$(function(){
	app.init();
})
/**
 * 数据字典类型
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
			app.editTable.setData([]);
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysBeanType/excelDownload?='+data;
			linkExcel.open("sys_bean_type", url);
		})
	},
	load:function(){
		app.table = $('#sysBeanType_xtable').xtable({
			url:adminPath + '/sysBeanType/listPage',
			deleteUrl:adminPath + '/sysBeanType/delete',
			paging:'.sysBeanType_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				//加载子表数据
				app.editTable.reload({beanKey:row.beanKey});
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