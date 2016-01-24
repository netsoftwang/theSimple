function dateFormatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	var h = date.getHours();
	var mi= date.getMinutes();
	var s = date.getSeconds();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d)+' '+(h<10?('0'+h):h)+':'+(mi<10?('0'+mi):mi)+':'+(s<10?('0'+s):s);
}

String.prototype.trim=function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
 }
function trim(str){
	 return str.replace(/(^\s*)|(\s*$)/g, "");
}

function msgTip(msg){
	$.messager.show({
		title:'操作提示！',
		msg:msg,
		timeout:800
	});
}

function msgTipSucc(){
	$.messager.show({
		title:'操作提示！',
		msg:"操作成功！",
		timeout:800
	});
}
function msgTipErr(){
	$.messager.show({
		title:'操作提示！',
		msg:"操作失败！！",
		timeout:800
	});
}
//给主panel添加页签
function addTabsToMainPanel(title,url){
	var tabsEle = parent.document.getElementById("tabs");
	var mainPanelEle = parent.document.getElementById("mainPanel");
	if($(tabsEle).tabs("exists",node.text)){
		$(tabsEle).tabs('select', node.text);
	}else{
		$(tabsEle).tabs("add",{
			title:title,
			closable:true,
			content:function(){
				return "<iframe scrolling='auto' frameborder=0 src="+url+" style='width:100%;height:100%'></iframe>";
			},
			width:$(mainPanelEle).width()-10,
			heigt:$(mainPanelEle).height()-10,
			tools:[{
					//iconCls:'icon-remove',
					handler:function(){
						alert('refresh');
					}
			}]
		});
	}
}