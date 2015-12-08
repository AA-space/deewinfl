Jason.ComboBox =  function(config){
	this.url = config.url;
	this.param = config.param;
	this.valueField = config.valueField || 'id';
	this.textField = config.textField || 'name';
	this.name = config.name || this.id;
	this.renderID = config.renderID;
	this.data = config.data || '';
	
	this.selectClass = config.selectClass;
	this.optionClass = config.optionClass;
	this.hasEmpty = config.hasEmpty || false;
	
	//事件
	this.onSelect = config.onSelect || null;
	
	//中间变量
	this.renderDiv = document.getElementById(this.renderID);
	
	//初始化
	(function(config){
		Jason.ComboBox.innerFn.init(config);
	})(this);
	//
};
Jason.ComboBox.prototype.fn = function() {
};

Jason.ComboBox.innerFn = Jason.ComboBox.prototype.fn.prototype;
Jason.ComboBox.innerFn.init = function(config){
	var selectText = [];
	
	var sclass = config.selectClass ? 'class=' + config.selectClass : "";
	selectText.push('<select ' + sclass + '>');

	selectText.push('<select>');
	config.renderDiv.appendChild(document.createElement("DIV")).innerHTML = selectText.join("");
	config.url ? Jason.ComboBox.setAjaxData(config) : Jason.ComboBox.setOptionData(config);
};

Jason.ComboBox.setOptionData = function(config){
	var optionDiv = config.renderDiv.getElementsByTagName("SELECT")[0];
	var oclass = config.optionClass ? 'class=' + config.optionClass : "";
	var options = config.hasEmpty ? ['<option ' + oclass + '></option>'] : [];
	
	for ( var key in config.data) {
		options.push('<option  value=' + config.data[key][config.valueField] + '><div ' + oclass + '>' +  config.data[key][config.textField] + '</div></option>');
	}
	optionDiv.innerHTML = options.join("");
	Jason.ComboBox.innerFn.listen(config);
};

Jason.ComboBox.setAjaxData = function(config){
	jQuery.post(config.url, config.param, function(data){
		config.data = data;
		Jason.ComboBox.setOptionData(config);
	});
};

Jason.ComboBox.innerFn.listen = function(config){
	
	Grid.innerFn.addEvent(config.renderDiv, 'change', function(e){
		var src = Grid.innerFn.getEventElement(e);
		if(src.tagName == 'SELECT'){
			config.onSelect(src.value);
		}
		Grid.innerFn.stopBubble(e);
	});
};


