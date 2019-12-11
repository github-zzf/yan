$(function() {
	app.init();
})

/**
 * 操作日志
 */
var app = {
	init : function() {
		app.bind();
		app.load();
	},
	bind : function() {
		$("#xdate_begin").xdate({time:true});
		$("#xdate_end").xdate({time:true});
		var sf = $("#form_search").xform();
		$("#btn_search").click(function() {
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_reset").click(function() {
			sf.clear();
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#sys_log_xtable").on('click', ".params_btn", function(){
			var xv = $(this).data('xv');
			var row = app.table.getRow(xv);
			openRemark.open(row.requestParams);
		});
	},
	load : function() {
		app.table = $("#sys_log_xtable").xtable({
			url : adminPath + '/sysLog/findLog',
			paging : '.sys_log_paging',
			format:function(row){
				if(row.requestParams){
					row.paramsBtn = openRemark.getRemark(row, "params_btn");
				}
			}
		});
	}
};
