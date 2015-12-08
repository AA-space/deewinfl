var fieldTypeData = [{
	value : 'text',
	text : '文本框'
}, {
	value : 'textarea',
	text : '多行文本框'
}, {
	value : 'date',
	text : '日期控件'
}, {
	value : 'select',
	text : '下拉框'
}, {
	value : 'digits',
	text : '整数输入框'
}, {
	value : 'number',
	text : '浮点数输入框'
}, {
	value : 'hidden',
	text : '隐藏控件'
},{
	value : 'checkbox',
	text : '复选框'
},{
	value : 'radio',
	text : '单选'
}];

	var dataScouceData = [{value : 'empty', text : '空'}, {value : 'dictdata', text : '数据字典'}, {value : 'opentree', text : '弹出树'}, {value : 'customjs', text : '自定义JavaScript'}, {value : 'fixSelect', text : '固定值下拉'}, {value : 'cascadeSelect', text : '级联下拉'}, {value : 'custSelect', text : '自定义下拉'}];
	
	var dataSourceForm = {
		dictdata : [{name : 'dictdatapid', display : '字典父ID', type : 'text'},{name : 'hasblank', display : '是否留空', type : 'checkbox'},{name : 'ismultiselect', display : '是否多选', type : 'checkbox'}],
		opentree : [{name : 'opentreeid', display : '字典ID',  type : 'text'}],
		customjs : [{name : 'customjsid', display : '自定义js',  type : 'text'}, {name : 'customjsarea', display : 'js',  type : 'textarea'}],
		custSelect : [{name : 'custSelectUrl', display : 'url地址',  type : 'text'},{name : 'textField', display : '显示字段',  type : 'text'},{name : 'valueField', display : '值字段',  type : 'text'},{name : 'autocomplete', display : 'ajax联想',  type : 'checkbox'}],
		fixSelect : [{name : 'fixSelectColumn', display : '字段',  type : 'textarea', tip : {content:"不能为空"}}],
		//cascadeSelect : [{name : 'cascadeSelectType', display : '下拉类别',  type : 'text'},{name : 'cascadeSelectid', display : '下拉序号',  type : 'text'},{name : 'cascadeSelectDataSource', display : '数据源',  type : 'text'},{name : 'cascadeSelectStartValue', display : '起始值',  type : 'text'},{name : 'cascadeSelectPid', display : '父字段名',  type : 'text'}]
		cascadeSelect : [{name : 'cascadeUrl', display : 'url地址',  type : 'text'},{name : 'keyName', display : '上一级字段名称',  type : 'text', tip : {content:"上一级的字段名称，必须是这个表单里的字段,必填项目"}},{name : 'columnName', display : '本次查询字段名称',  type : 'text', tip:{content:"如果使用通用的tree的话，填写本次查询的字段的名称，如果自定义action，留空就行"}},{name : 'textField', display : '显示字段',  type : 'text'},{name : 'valueField', display : '值字段',  type : 'text'}]
	};
	//validate验证数据
	var dataSourceValidate = {rows : [{value : 'Require'    , text : '必填项'},                  
	                                  {value : 'Chinese'    , text : '中文'},
	                                  {value : 'English'    , text : '英文'},
	                                  {value : 'Number'     , text : '数字'},
	                                  {value : 'Integer'    , text : '整数'},
	                                  {value : 'Double'     , text : '实数'},
	                                  {value : 'Email'      , text : 'Email地址格式'},
	                                  {value : 'Url'        , text : '基于HTTP协议的网址格式'},
	                                  {value : 'Phone'      , text : '电话号码格式'},
	                                  {value : 'Mobile'     , text : '手机号码格式'},
	                                  {value : 'Currency'   , text : '货币格式'},
	                                  {value : 'Zip'        , text : '邮政编码'},
	                                  {value : 'IdCard'     , text : '身份证号码'}, 
	                                  {value : 'QQ'         , text : 'QQ号码'},
	                                  {value : 'Date'       , text : '日期'},
	                                  {value : 'SafeString' , text : '安全密码'},
	                                  {value : 'Group'      , text : '验证单/多选按钮组'},
	                                  {value : 'Repeat'     , text : '重复输入'},
	                                  {value : 'Compare'    , text : '关系比较'},
	                                  {value : 'Range'      , text : '输入范围'},
	                                  {value : 'Limit'      , text : '限制输入长度'},
	                                  {value : 'LimitB'     , text : '限制输入的字节长度'},
	                                  {value : 'Custom'     , text : '自定义正则表达式验证'}]};
/*	
var dataSourceValidate = {rows : [{value : '*'    , text : '任何值'},                  
									{value : 'n'   , text : '数字'},
									{value : 's'   , text : '字符串'},
									{value : 'p'   , text : '电话号码格式'},
									{value : 'e'   , text : 'Email地址格式'},
									{value : 'url' , text : '网址格式'}
							]};
*/
