package com.business.util;


import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;

public class copyObjectToHisTools {
 /**
  * 把set集合中每一个对象拷贝到新对象上，并给新的对象赋上其他值
  * @date 2013-5-30
  * xuyunlong
  * @param fromObjectList 数据源
  * @param toObjectClass  目标对象的CLASS
  * @param otherPropertyMap 目标对象的属性的其他值
  * @return 返回新对象的List
  * @throws Exception
  */
  public static  List<?> CopySetObjectAndAddOtherProperty(Set<?> fromObjectList,Class<?> toObjectClass,Map<String,Object> otherPropertyMap) throws Exception{
	  int i=0;
	  if(fromObjectList==null){return null;}
	  if(fromObjectList.size()<=0){
		  return null;
	  }else{
		List toObjectlist=new ArrayList();
		Method writeMethod;
		for(Object fromobject:fromObjectList){
			Object toObject=toObjectClass.newInstance();
			BeanUtils.copyProperties(fromobject, toObject);
			if(otherPropertyMap!=null){
				PropertyDescriptor[] toObjectPD = BeanUtils.getPropertyDescriptors(toObjectClass);
				for(PropertyDescriptor propertyDescriptor_target : toObjectPD)
				{
				   String name_target = propertyDescriptor_target.getName();
				   if("id".equalsIgnoreCase(name_target)){
					   writeMethod = propertyDescriptor_target.getWriteMethod();
					   writeMethod.invoke(toObject, null);
				   }
				   if(otherPropertyMap.containsKey(name_target.toLowerCase())){
					   writeMethod = propertyDescriptor_target.getWriteMethod();
					   writeMethod.invoke(toObject,otherPropertyMap.get(name_target.toLowerCase()));
				   }
				}  
			}
			toObjectlist.add(toObject);
		}
	    return toObjectlist;
	  }
  }
}
