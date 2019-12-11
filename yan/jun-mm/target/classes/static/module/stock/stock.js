$(function(){
	app.init();
})
/**
 * 库存
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
			var data = $("#form_search").serialize();
			var url = adminPath + '/stock/excelDownload?='+data;
			linkExcel.open("stock", url);
		});
		// 查看明细
		$('#stock_xtable').on("click", '.js_btnMingXi', function(){
			var xv = $(this).data("xv");
			linkStockRecordItem.open(xv);
		});
	},
	load:function(){
		app.table = $('#stock_xtable').xtable({
			url:adminPath + '/stock/listPage',
			deleteUrl:adminPath + '/stock/delete',
			paging:'.stock_paging',
			format:function(row){
				row.btnMingXi = "&nbsp;<a class='js_btnMingXi' data-xv='"+row.goodsId+"'>查看明细</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				app.win.open();
			},
			deleteSuccess:function(e){
				if (e.code==1){
					app.table.reload();
            		$.ok('删除成功');
                } else {
                	$.xalert('删除失败！');
                }
			}
		});
	}
};