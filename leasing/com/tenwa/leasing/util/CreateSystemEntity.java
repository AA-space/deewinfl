package com.tenwa.leasing.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.kernal.annotation.FieldName;

public class CreateSystemEntity {

	/** 
	 * @author 作者 E-mail: 生成系统中的实体类的说明的
	 * @version 创建时间：2013-12-13 下午01:44:36 
	 * 类说明 
	 */
	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			File directory = new File("");// 参数为空
			String courseFile = directory.getCanonicalPath();
			String dirpath=courseFile+"\\leasing";
			File dir = new File(dirpath);
			File file = new File("d:\\系统实体类.html");   
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file),"utf-8");
			File[] files = dir.listFiles();
			fw.write("<style   type='text/css'>");
			fw.write("table{border-collapse:collapse;margin-bottom:50}");
			fw.write(" table,th, td{border: 1px solid blue;}");
			fw.write("</style>");
			fw.write("<table>");
			fw.write("<tr><td>表中文名</td>");
	        fw.write("<td>表名</td>");
	        fw.write("<td>实体类</td></tr>");
			for (File f : files) {
				if (f.isDirectory() && (!f.getName().equals(".svn"))) {
					readFileName(f,fw,0,dirpath);
				}
			}
			 fw.write("</table>");
			for (File f : files) {
				if (f.isDirectory() && (!f.getName().equals(".svn"))) {
					readFileName(f,fw,1,dirpath);
				}
			}
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
    public static void readFileName(File f,OutputStreamWriter fw,int i,String dirpath ){
    	
    	String fileName="";
    	if(f.isFile()&&(!f.isDirectory())){
    		fileName=f.getAbsolutePath();
    		if(fileName.indexOf(".svn")<0){
    		fileName=fileName.replace(dirpath+"\\", "");
    		fileName=fileName.replaceAll("\\\\", ".");
    		if(fileName.indexOf("com.business.entity")>=0){
    			fileName=fileName.replace(".java", "");
    			readEntityPropotype(fileName,fw,i);}
    		}
    	}else{
    		 File[] files=f.listFiles();
    		 for(File fd : files){
    			 readFileName(fd ,fw ,i,dirpath);
    		 }
    	}
    }
    public static void readEntityPropotype(String fileName,OutputStreamWriter fw ,int j){
       String className=fileName;
   	   Class<?> demo1=null;
   	   try{
             demo1=Class.forName(className);
             Table ctable=(Table) demo1.getAnnotation(Table.class);
             FieldName tableName=(FieldName)demo1.getAnnotation(FieldName.class);
             if(j==0){
            	   fw.write("<tr><td >"+tableName.name()+"</td>");
            	   fw.write("<td>"+(null==ctable?"":ctable.name())+"</td>");
                   fw.write("<td><a href='#"+demo1.getName()+"'>"+demo1.getName()+"</a</td></tr>");
                
             }else{
             fw.write("<table>");
             fw.write("<tr><td colspan='4'>表名:"+(null==ctable?"":ctable.name())+"</td></tr>");
             fw.write("<tr><td colspan='4'>实体类:<a name='"+demo1.getName()+"' id='"+demo1.getName()+"'>"+demo1.getName()+"</a></td></tr>");
             fw.write("<tr><td colspan='4'>表中文名："+tableName.name()+"</td></tr>");
             Field[] field = demo1.getDeclaredFields();
             fw.write("<tr>");
             fw.write("<td>类属性</td>");
             fw.write("<td>类属性类型</td>");
             fw.write("<td>表字段</td>");
             fw.write("<td>说明</td></tr>");
             for (int i = 0; i < field.length; i++) {
            	fw.write("<tr>");
           	    Field fd=field[i];
             	fw.write("<td>"+fd.getName().toLowerCase()+"</td>");
           	    fw.write("<td>"+fd.getType().getName()+"</td>");
           	    
           	    Column anC= (Column)fd.getAnnotation(Column.class);
           	    if(null!=anC){fw.write("<td>"+anC.name()+"</td>");}
           	    JoinColumn anD= (JoinColumn)fd.getAnnotation(JoinColumn.class);
           	    if(null!=anD){fw.write("<td>"+anD.name()+"</td>");}
           	    if(null==anC&&null==anD){fw.write("<td></td>");}
           	    FieldName anF= (FieldName)fd.getAnnotation(FieldName.class);
        	    if(null!=anF){fw.write("<td>"+anF.name()+"</td>");}
        	    else{fw.write("<td>id</td>");}
        	    fw.write("</tr>");
             }
             fw.write("</table>");}
         }catch(Exception e){
           System.out.println(fileName);
          // e.printStackTrace();
         }
    }
    
}
