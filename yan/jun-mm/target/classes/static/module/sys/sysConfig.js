$(function(){
	app.init();
})
/**
 * 参数配置
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform();
		$("#btn_search").xbtn(function() {
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_reset").xbtn(function() {
			sf.clear();
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#sysConfig_xtable").on("click", ".xupdate_open", function(){
			var index = $(this).data("xv");
			var row = app.table.getRow(index);
			app.form1.setData(row);
			app.win1.open();
		});
	},
	load:function(){
		app.table = $('#sysConfig_xtable').xtable({
			url:adminPath + '/sysConfig/findList',
			deleteUrl:adminPath + '/sysConfig/delete',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				if(row.configKey == "bonus_mode"){
					row.btnUpdate = "&nbsp;<a class='xupdate_open' data-xv='"+row.index+"'>修改</a>&nbsp;";
				}
			},
			update:function(row){
				app.form.setData(row);
				app.win.open();
			}
		});
	}
};