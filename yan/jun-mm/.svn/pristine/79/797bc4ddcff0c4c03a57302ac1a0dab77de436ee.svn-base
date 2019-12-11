$(function(){
	app.init();
})
/**
 * 示例树
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
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
		$('#btn_export').click(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/demoTree/excelDownload?='+data;
			linkExcel.open("demo_tree", url);
		})
		// 添加
		$('#btn_add').click(function(){
			app.form.clear();
			app.win.open();
		});
		// 添加子集
		$('#demoTree_xtable').on("click",".btn_addSon",function(){
			var index = $(this).data('xv');
			app.clickIndex = index;
			var row = app.table.getRow(index);
			app.form.clear();
			$("#f_parentId").val(row.comId);
			$("#f_parentName").val(row.comName);
			app.win.open();
		})
	},
	load:function(){
		$.ztree({
			id:"tree",
			url:adminPath + '/demoTree/treeData',
			click:function(treeId, treeNode){
				app.table.reload({comId:treeNode.id});
			}
		})
		app.table = $('#demoTree_xtable').xtable({
			url:adminPath + '/demoTree/listData',
			deleteUrl:adminPath + '/demoTree/delete',
			tree: true,
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.comId+"'>删除</a>&nbsp;";
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
				$('#demoTree_xtable').find(".tree_click").trigger("click");
			}
		});
	}
};