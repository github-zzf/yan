$(function(){
	app.init();
})
/**
 * 积分商品
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform();
		$("#sf_giftTypeName").click(function(){
			linkGiftType.open(function(treeId, treeNode){
				$("#sf_giftTypeName").val(treeNode.name);
				$("#sf_parentId").val(treeNode.id);
			})
		});
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
			$("#uploader").attr('bizid',0);
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/gift/excelDownload?='+data;
			linkExcel.open("shop_gift", url);
		})
	},
	load:function(){
		app.table = $('#gift_xtable').xtable({
			url:adminPath + '/gift/listPage',
			deleteUrl:adminPath + '/gift/delete',
			paging:'.gift_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				$("#uploader").attr('bizid',row.id);
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