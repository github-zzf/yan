$(function(){
	app.init();
})
/**
 * 导购业绩
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
		$('#btn_export').xbtn(function() {
			exportWin.bindFind("sale_performance");
			var url = adminPath + '/salePerformance/excelDownload';
			exportWin.bindExport(url);
		})
	},
	load:function(){
		app.table = $('#salePerformance_xtable').xtable({
			url:adminPath + '/salePerformance/findList',
			format:function(row){
			}
		});
	}
};