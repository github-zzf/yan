$(function(){
	app.init();
})
/**
 * 栏目表
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
		// 添加子集
		$('#arttype_xtable').on("click",".btn_addSon",function(){
			var index = $(this).data('xv');
			app.clickIndex = index;
			var row = app.table.getRow(index);
			app.form.clear();
			$("#f_parentId").val(row.id);
			$("#f_parentName").val(row.typeName);
			app.win.open();
		})
	},
	load:function(){
		$.ztree({
			id:"tree",
			url:adminPath + '/arttype/treeData',
			click:function(treeId, treeNode){
				app.table.reload({id:treeNode.id});
			}
		})
		app.table = $('#arttype_xtable').xtable({
			url:adminPath + '/arttype/findList',
			deleteUrl:adminPath + '/arttype/delete',
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
				$('#arttype_xtable').find(".tree_click").trigger("click");
			}
		});
	}
};