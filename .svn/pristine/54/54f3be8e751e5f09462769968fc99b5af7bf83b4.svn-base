
Grid.innerFn.PageSystem = function(config) {
	this.totalCount = config.totalCount; // 总记录数
	//this.initMaxPage = grountCount ? grountCount : 5; // 显示页数，如 1 2 3 4 5
	this.pageList = config.pageList || [10, 20, 30]; // 每页记录数
	this.pageSize = this.pageList[0]; //每页记录
	//this.currentMax = 0; // 当前显示的最大页码, 如 1 2 3 4 5; 5为最大页码
	//this.currentMin = 0; // 当前显示的最小页码, 如 11 12 13 14 15; 11为最小页码
	this.minPage = 1; // 首页
	this.maxPage = 1; // 总页数，计算得到
	this.currentPage = 1; // 当前页
	this.currentActiveSpan; // 当前活动a容器
	this.pageDivObj = document.getElementById(config.renderID); // 分页系统容器
	this.pageDivObj.className = "page";
	// this._url = _url; //提交URL
	this.callBack = config.callBack || null; // 回调
	var that = this; // 指针的引用

	this.init = function() {
		this.maxPage = parseInt(this.totalCount / this.pageSize); // 获得总共有几页
		this.maxPage = this.totalCount % this.pageSize == 0 ? this.maxPage : this.maxPage + 1;
		this.currentPage = 1;
		this.createPage();
		this.setCurrentPage(this.currentPage);
		Grid.innerFn.addEvent(this.pageDivObj, 'click', that.pageClick);
		Grid.innerFn.addEvent(this.pageDivObj, 'change', that.selectChange);
		return this;
	};
	this.query = function() {//
		var curPage = that.currentPage; // 当前页
		var pageSize = that.pageSize;
		console.info("查询页码" + curPage + ', 当前页码范围' + pageSize);
		if (that.callBack)
			that.callBack(curPage, pageSize);
		that.setCurrentPage(curPage);
	};
	
	this.getPageAndSize = function(){
		return [that.currentPage, this.pageSize];
	};
	
	this.toFirstPage = function() {//首页
		if(that.currentPage == that.minPage)
			return;
		that.currentPage = that.minPage;
		that.query();
	};
	this.toEndPage = function() {//尾页
		if(that.currentPage == that.maxPage)
			return;
		
		that.currentPage = that.maxPage;
		that.query();
	};

	this.nextPage = function(that) {// 下一页
		if(that.currentPage == that.maxPage){
			return;
		}
		that.currentPage = that.currentPage > that.maxPage ? that.maxPage : that.currentPage + 1;
		that.query();
	};
	this.prePage = function(that) {// 上一页
		if(that.currentPage == that.minPage){
			return;
		}
		that.currentPage = that.currentPage < that.minPage ? that.minPage : that.currentPage - 1;
		that.query();
	};
	
	this.createPage = function(){
		var strHtml = '<span class="spanClass"><select name="pageSize">';
		for ( var int = 0; int < this.pageList.length; int++) {
			strHtml += '<option>' + this.pageList[int] + '</option>';
		}
		strHtml += '</select></span>';
		
		strHtml += '<span title="首页">|< </span>';
		strHtml += '<span title="上一页"> << </span>';
		strHtml += '<label>第</label><input style="width:20px; height: 20px; padding-top=2px;" type = text name = "pageInput" title="按回车键进入" value="' + this.currentPage + '"/><label>共' + this.maxPage + '页</label>';
		
		strHtml += '<span title="下一页"> >> </span>';
		strHtml += '<span title="尾页"> >| </span>';
		this.pageDivObj.innerHTML = strHtml;
	};
	
	this.getCurrentPage = function(){
		return this.pageDivObj.getElementsByTagName("INPUT")[0].value = page;
	};
	this.setCurrentPage = function(v){
		var page = parseInt(v);
		if(isNaN(page)){
			alert("请输入正确的数字");
			return;
		}
		page > this.maxPage ? this.maxPage : page;
		console.info(this.pageDivObj.getElementsByTagName("INPUT")[0].value);
		this.pageDivObj.getElementsByTagName("INPUT")[0].value = page;
	};
	this.reloadPageSystem = function(){
		this.maxPage = parseInt(this.totalCount / this.pageSize); // 获得总共有几页
		this.maxPage = this.totalCount % this.pageSize == 0 ? this.maxPage : this.maxPage + 1;
		this.createPage();
		this.setCurrentPage(this.currentPage);
	}
	this.setMaxPage = function(maxPage){
		this.maxPage = maxPage;
		this.createPage();
		
	}
	
	
	this.pageClick = function(e){//点击监听
		var src = Grid.innerFn.getEventElement(e);
		if(src.tagName == 'SPAN'){
			var title = src.title;
			console.info(title);
			switch (title) {
			case '上一页':
				that.prePage(that);
				break;

			case '下一页':
				that.nextPage(that);
				break;

			case '首页':
				that.toFirstPage(that);
				break;

			case '尾页':
				that.toEndPage(that);
				break;

			default:
				break;
			}
		}
		Grid.innerFn.stopBubble(e);
	};
	this.selectChange = function(e){//选择监听
		var src = Grid.innerFn.getEventElement(e);
		if(src.nodeName == 'SELECT'){
			that.pageSize = parseInt(src.value);
			console.info(that.pageSize);
		}
		if(src.nodeName == 'INPUT'){
			that.currentPage = parseInt(src.value);
			
			if(isNaN(that.currentPage)){
				alert("请输入正确的数字");
				return;
			}
			
			that.currentPage = that.currentPage < that.minPage ? that.minPage : that.currentPage;
			that.currentPage = that.currentPage > that.maxPage ? that.maxPage : that.currentPage;
			that.query();
		}
		Grid.innerFn.stopBubble(e);
	};
};

