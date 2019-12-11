$(function(){
	app.init();
})
/**
 * 提成设置
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
			app.form.clear();
			app.form.setData({star1:0,star2:0,star3:0,star4:0,star5:0});
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/staffMoneySetting/excelDownload?='+data;
			linkExcel.open("com_staff_money_setting", url);
		})
	},
	load:function(){
		app.table = $('#staffMoneySetting_xtable').xtable({
			url:adminPath + '/staffMoneySetting/listPage',
			deleteUrl:adminPath + '/staffMoneySetting/delete',
			paging:'.staffMoneySetting_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
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