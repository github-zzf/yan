$(function(){
	app.init();
})
/**
 * 菜单管理
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
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysMenu/excelDownload?='+data;
			linkExcel.open("sys_menu", url);
		});
		// 添加子集
		$('#sysMenu_xtable').on("click",".btn_addSon",function(){
			var index = $(this).data('xv');
			app.clickIndex = index;
			var row = app.table.getRow(index);
			app.form.clear();
			$("#f_parentId").val(row.id);
			$("#f_parentName").val(row.name);
			app.win.open();
		})
	},
	load:function(){
		app.table = $('#sysMenu_xtable').xtable({
			url:adminPath + '/sysMenu/findList',
			deleteUrl:adminPath + '/sysMenu/delete',
			tree: true,
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				row.btnAddSon = "&nbsp;<a class='btn_addSon' data-xv='"+row.index+"'>添加</a>&nbsp;";
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
			},
			success:function(){
				$('#sysMenu_xtable').find(".tree_click").trigger("click");
			}
		});
	}
};