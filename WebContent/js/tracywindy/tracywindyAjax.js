/***
* url:'ajax.jsp'
* timeout:30*1000 请求超时时间(默认30s)ms为单位
* method : post/get  //发送方式
* contentType: 'application/x-www-form-urlencoded;charset=UTF-8'
* async:true/false 是否异步
* success(response): ajax成功返回的回调函数reponse.responseText
* failure(response):ajax请求失败
* params :参数{method:'remode'}
*
***/

var ajaxRequest = function(config) {
    var GetXmlHttpObject = function() {
        var xmlHttp = null;
        try {
            // Firefox, Opera 8.0+, Safari
            xmlHttp = new XMLHttpRequest();
        } catch(e) {
            // Internet Explorer
            try {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch(e) {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        return xmlHttp;
    };
    var xmlHttpRequest = GetXmlHttpObject();
    if (xmlHttpRequest == null) {
        alert("您的浏览器不支持AJAX！");
        return;
    }
    var method = config.method || 'POST';
    method = method.toUpperCase();
    var url = config.url;
    var sendParams = null;
    var contentType = config.contentType || 'application/x-www-form-urlencoded;charset=UTF-8';
    var params = config.params || {};
    //清除缓存
    url = getTracywindyRandomUrl(url);
    url += ("&decorate=none");
    if (method == 'GET') {
        if (url.indexOf('?') > -1) {
            for (var param in params) {
                url += ("&" + param + "=" + escape(encodeURIComponent(params[param])));
            }
        } else {
            var index = 0;
            for (var param in params) {
                var addFlag = "&";
                if (1 == (++index)) {
                    addFlag = "?";
                }
                url += (addFlag + param + "=" + escape(encodeURIComponent(params[param])));
            }
        }
    } else if (method == 'POST') {
        var str = "";
        var postIndex = 0;
        for (var param in params) {
            var postFlag = "";
            if (1 != (++postIndex)) {
                postFlag = "&";
            }
            str += (postFlag + param + "=" + escape(encodeURIComponent(params[param])));
        }
        sendParams = str;

    }
    //url = encodeURI(url);
    var timeout = config.timeout || 60*2*1000;
    this.async = (config.async == false) ? false: true;
    xmlHttpRequest.open(method, url, this.async);
    xmlHttpRequest.setRequestHeader("Content-Type", contentType);
    xmlHttpRequest.setRequestHeader("X-Requested-With", "XMLHttpRequest");
    xmlHttpRequest.onreadystatechange = function() {
        if (xmlHttpRequest.readyState == 4) {
            if (xmlHttpRequest.status == 200) {
                clearTimeout(clearTO); //如果准备状态成功，并且HTTP状态码正确则清除
                var judgeText = xmlHttpRequest.responseText;
                if (/^\s*<\s*html/gim.test(judgeText)) {
                    //项目根路径
                    var rootPath = "";
                    if (window.getRootPath) {
                        rootPath = getRootPath();
                    } else {
                        var strFullPath = window.document.location.href;
                        var strPath = window.document.location.pathname;
                        var pos = strFullPath.indexOf(strPath);
                        var prePath = strFullPath.substring(0, pos);
                        var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
                        rootPath = (prePath + postPath);
                    }
                    //alert("登录超时!");
                    window.top.location.href = rootPath + "/login.jsp";
                    return;
                } else if (0 == judgeText.indexOf("X-Requested-With-Error")) {
                    alert(judgeText.substring("X-Requested-With-Error".length, judgeText.length));
                    if (window.tracywindyObject) {
                        for (var p in window.tracywindyObject) {
                            var currentObj = tracywindyObject[p];
                            if ("loadmask" == currentObj['objectType']) {
                                currentObj.hide();
                            }
                        }
                    }
                    //alert("请求异常，异常信息 》 "+judgeText.substring("X-Requested-With-Error".length,judgeText.length));
                } else {
                    config.success(xmlHttpRequest);
                }

            } else if (xmlHttpRequest.status == 404) {
                config.failure(xmlHttpRequest);
            }
        }
    };
    var clearTO = setTimeout(function() {
        xmlHttpRequest.abort(); //终止XMLHttpRequest对象
        config.failure(xmlHttpRequest);
    }, timeout);
    xmlHttpRequest.send(sendParams);
};