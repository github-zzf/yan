$(function(){
	app.init();
})
/**
 * 相册
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
			$("#uploader").attr('bizid',0);
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/album/excelDownload?='+data;
			linkExcel.open("com_album", url);
		})
		$('#album_xtable').on('click','.btn_img',function() {
			var xv = $(this).data('xv');
			openImg.open(xv);
		})
	},
	load:function(){
		app.table = $('#album_xtable').xtable({
			url:adminPath + '/album/listPage',
			deleteUrl:adminPath + '/album/delete',
			paging:'.album_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				if(row.img){
					var arrImg = row.img.split(',');
					row.imgTxt = "<img class='picture btn_img' data-xv='"+arrImg[0]+"' src='"+arrImg[0]+"'/>";
				}
			},
			update:function(row){
				app.form.setData(row);
				// 加载图片数据
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