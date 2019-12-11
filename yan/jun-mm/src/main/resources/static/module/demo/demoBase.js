$(function(){
	app.init();
})
/**
 * 增删改查示例
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
		$('#btn_add').click(function(){
			app.form.clear();
			app.editTable.setData([]);
			app.win.open();
		});
	},
	load:function(){
		app.table = $('#demoBase_xtable').xtable({
			url:adminPath + '/demoBase/listPage',
			deleteUrl:adminPath + '/demoBase/delete',
			paging:'.demoBase_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
			
				// 加载表单数据
				app.form.setData(row);
				// 加载图片数据
				$("#uploader").attr('bizid',row.id);
				// 加载子表数据
				app.editTable.reload({baseId:row.id})
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