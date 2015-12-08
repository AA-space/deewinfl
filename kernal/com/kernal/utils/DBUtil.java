package com.kernal.utils;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.junit.Test;

import com.kernal.annotation.FieldName;




 /**
 * 项目名称：    系统名称
 * 包名：              
 * 文件名：         DBUtil.java
 * 版本信息：    1.0.0
 * 创建日期：     2013-7-1-下午03:05:29
 * Copyright：2013XX公司-版权所有
 **/

/**
 * 类名称：     DBUtil
 * 类描述：     
 * 创建人：     Administrator
 * 修改人：     Administrator
 * 修改时间：2013-7-1 下午03:05:29
 * 修改备注：
 * @version 1.0.0
 **/

public class DBUtil {
   public static List<String> getCommentSqls(String[] scanPackages) throws Exception{
	 List<String> comments = new ArrayList<String>();
	 for(String scanPackage : scanPackages){
		 comments.addAll(getComments(FileUtil.getClasses(scanPackage)));
	 }
	 FileOutputStream out = new FileOutputStream("D:\\comments.sql");
	 for(String comment : comments){
		 out.write((comment+";").getBytes());
		 out.write("\n".getBytes());
	 }
	 out.flush();
	 out.close();
	 return comments;
   }
   private static List<String> getComments(Set<Class<?>> classes){
	   List<String> comments = new ArrayList<String>();
	   for(Class<?> clazz : classes){
		   if(clazz.isAnnotationPresent(Entity.class)){
			  String tableComment   = "";
			  String tableName = clazz.getSimpleName();
			  if(clazz.isAnnotationPresent(Table.class)){
				  Table table = clazz.getAnnotation(Table.class);
				  tableName = table.name();
				  if(clazz.isAnnotationPresent(FieldName.class)){
					  tableComment = clazz.getAnnotation(FieldName.class).name();
				  }
				  comments.add("comment on table "+tableName+" is '"+tableComment+"'");
			  }
			  Field[] fields =  clazz.getDeclaredFields();
			  for(Field field : fields){
				  String columnName = field.getName();
				  String columnComment = "";
				  if(field.isAnnotationPresent(Column.class)){
					  columnName = field.getAnnotation(Column.class).name();
				  }
				  else if(field.isAnnotationPresent(JoinColumn.class)){
					  columnName = field.getAnnotation(JoinColumn.class).name();
				  }
				  else{
					  continue;
				  }
				  if(field.isAnnotationPresent(FieldName.class)){
					  columnComment = field.getAnnotation(FieldName.class).name();
				  }
				  comments.add("comment on column "+tableName+"."+columnName+"  is '"+columnComment+"'");
   			}
   		 }
	   }
	   return comments;
   	}
   public static void main(String []args) throws Exception{
	   System.out.println("11111111");
	   DBUtil.getCommentSqls(new String[]{"com.business","com.tenwa"});
   }
   @Test
   public  void test() throws Exception{
	   System.out.println("11111111");
	   DBUtil.getCommentSqls(new String[]{"com.business","com.tenwa"});
   }
}
