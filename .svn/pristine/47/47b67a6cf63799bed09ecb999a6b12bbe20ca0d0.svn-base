    /** 
	* @author tracywindy 
	* 
	*/ 
    (function($){  
	   $.fn.extend({  
	       serializeObject:function(allownNull){  
	           var arr=this.serializeArray();  
	           var obj=new Object();  
	           $.each(arr,function(k,v){  
		           var name = v.name;
		           var value = v.value;
		           if(!name)return;
		           if(!allownNull && ((null==value)||('undefined'==typeof(value))||(''==value)))return;
		           var currentObj = {};
	               if(name.indexOf(".")>-1)  
	               {
		               var names = name.split(".");
		               var len = names.length;
		               for(var i=0;i<len;i++)
		               {
			               var attrName = names[i];
			               if(0==i)
			               {
				               if(!obj[attrName])
				               {
				              	obj[attrName] = {};
					           }
				               currentObj = obj[attrName];
				           }
			               else if((len-1)==i)
			               {
			              	 currentObj[attrName] = value;
				           }
			               else
			               {
				               if(!currentObj[attrName])
				               {
				              	 currentObj[attrName]={};
					           }
			              	 currentObj = currentObj[attrName];
				           }
			           }
		           }
	               else
	               {
	              	 obj[v.name]=v.value;
		           }
	           });  
	           return obj;  
	       }  
	   });  
})(jQuery);