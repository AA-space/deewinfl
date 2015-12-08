
jQuery.extend({
	serializeObject : function(form) {/* 讲表单序列化成一个对象 */
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				if(this['value']&&""!=this['value']){
					o[this['name']] = o[this['name']] + "," + this['value'];
				}
			} else {
				if(this['value']&&""!=this['value']){
					o[this['name']] = this['value'];
				}
			}
		});
		return o;
	}
});


function createFrame(url){/* 创建iframe */
	var s = '<iframe scrolling="auto"  id="o"  onload="Javascript:SetCwinHeight(this)"  frameborder="0" src="'+url+'" style="width:100%;height:98%;"></iframe>'; 
	return s; 
}

//将数字添加千分号
function AddQF(obj){
    if(AllTrim(obj) != ""){
        if(isDouble(AllTrim(obj))){
            var str2= "";
            if(AllTrim(obj).indexOf(".")!=-1){       
                var str = AllTrim(obj).split(".")[0];
                if(str.indexOf("-")!=-1){
                    str = str.substring(1,str.length);
                 }  
               
                //添加千分号       
                var i = str.length/3;
                var k = str.length%3;
                if( k== 0){
                    for(var j=0;j<i;j++){           
                        str2+=str.substring(j*3,3*j+3)+",";       
                    }
                }else{
                    var l = int(i);
                    str2+=str.substring(0,k)+",";
                    for(var j=0;j<l;j++){           
                        str2+=str.substring(j*3+k,3*j+3+k)+",";       
                    }
                         
                }
                //去除最后一个千分号       
                str2=str2.substring(0,str2.length-1);
                str2+="."+AllTrim(obj).split(".")[1];
             }else{
               var str = AllTrim(obj);      
                 if(str.indexOf("-")!=-1){
                    str = str.substring(1,str.length);
                 }
                //添加千分号       
                var i = str.length/3;
                var k = str.length%3;
                if( k== 0){
                    for(var j=0;j<i;j++){           
                        str2+=str.substring(j*3,3*j+3)+",";       
                    }
                }else{
                    var l = int(i);
                    str2+=str.substring(0,k)+",";
                    for(var j=0;j<l;j++){           
                        str2+=str.substring(j*3+k,3*j+3+k)+",";       
                    }
                         
                }
                //去除最后一个千分号       
                str2=str2.substring(0,str2.length-1);
             }
             if(AllTrim(obj).indexOf("-")!=-1){
                obj.value = "-"+str2;
             }else{
                obj.value = str2;
             }
             //还原边框
             if(obj.parentNode.style.borderRight == "red 1px solid"){
                obj.parentNode.style.borderRight = "silver 1px solid";
                obj.parentNode.style.borderLeft = "";
                obj.parentNode.style.borderTop= "";
                obj.parentNode.style.borderBottom = "silver 1px solid";
                obj.value = AllTrim(obj);
            }
         }else{
            if(obj.parentNode.style.borderRight != "red 1px solid"){
                alert("错误:只能输入数字(可包含“-”和“.”)!");
                //获得焦点
                obj.focus();
            }
                     }        
     }else{
           }
}

function SetCwinHeight(o) {
	if (document.getElementById) {
		if (o && !window.opera) {
			if (o.contentDocument && o.contentDocument.body.offsetWidth) {
				o.width = o.contentDocument.body.offsetWidth;
				
			} else if (o.Document && o.Document.body.scrollWidth) {
				o.width = o.Document.body.scrollWidth;
			}
			console.info(o.width);
		}
	}
}


/**
*   @param  iframeID 		iframe的id或者iframeElement[Doc Object]
*   @param  iframeWrapper	用于包装iframe的元素
*/
function scrollIframeForIOS(iframe, iframeWrapper){	
    //if(!navigator.userAgent.match(/iPad|iPhone/i)) return false; 

	var touchY = 0,
	    touchX = 0;
	iframe =  (typeof(iframe) =="string" ? document.getElementById(iframe) : iframe);
	console.info(iframe);
	iframe.onload = function(){

		var ifrWin = iframe.contentWindow,
		    ifrDoc = ifrWin.document;

		// iframe的上一级节点
		iframeWrapper = iframeWrapper||ifrWin.frameElement.parentNode;

		// 记录手指按下的位置
		ifrDoc.body.addEventListener("touchstart", function( event ){
			touchX = event.targetTouches[0].pageX;
			touchY = event.targetTouches[0].pageY;
		});

		ifrDoc.body.addEventListener("touchmove", function( event ){
			e.preventDefault(); // 阻止整个页面拖动

			var moveX = (touchX - event.targetTouches[0].pageX),
			    moveY = (touchY - event.targetTouches[0].pageY);

			iframeWrapper.scrollLeft += moveX;
			iframeWrapper.scrollTop  += moveY;
		});
	};

    return true;
};



//获得对象的宽度
function getDivWidth(id)
{
    var o = document.getElementById(id);
    var w = o.clientWidth||o.offsetWidth;
    return w;
}
//获得对象的高度
function getDivHeight(id)
{
    var o = document.getElementById(id);
    var w = o.clientHeight||o.offsetHeight;
    return w;
}

//判断对象是否为空
isEmptyObject = function(obj){ 
	for(var name in obj){
		return false;
	}
	return true;
};