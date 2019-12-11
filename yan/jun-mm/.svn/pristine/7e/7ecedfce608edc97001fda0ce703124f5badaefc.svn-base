$(function(){
	app.init();
})
/**
 * 消费记录
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
		$('#btn_add').click(function(){
			$("#btn_submit").show();
			app.form.clear();
			app.editTable.setData([]);
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysComOrders/excelDownload?='+data;
			linkExcel.open("sys_com_orders", url);
		})
	},
	load:function(){
		app.table = $('#sysComOrders_xtable').xtable({
			url:adminPath + '/sysComOrders/listPage',
			deleteUrl:adminPath + '/sysComOrders/delete',
			paging:'.sysComOrders_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>查看</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				$("#btn_submit").hide();
				app.form.setData(row);
				// 加载子表数据
				app.editTable.reload({ordersId:row.id});
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