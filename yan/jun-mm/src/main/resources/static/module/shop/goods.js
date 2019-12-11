$(function(){
	app.init();
})
/**
 * 消费项目
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_isShow',xdata:[{val:'0',txt:'下架'},{val:'1',txt:'上架'}]}
			]
		});
		$("#sf_typeName").click(function(){
			linkGoodsType.open(function(treeId, treeNode){
				$("#sf_typeName").val(treeNode.name);
				$("#sf_typeId").val(treeNode.id);
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
			app.form.setData({isShow:1});
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/goods/excelDownload?='+data;
			linkExcel.open("shop_goods", url);
		})
	},
	load:function(){
		app.table = $('#goods_xtable').xtable({
			url:adminPath + '/goods/listPage',
			deleteUrl:adminPath + '/goods/delete',
			paging:'.goods_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				app.win.open();
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