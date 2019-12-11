$(function(){
	app.init();
})
/**
 * 会员卡消费明细表
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_cardId',url:adminPath+'/combo/findComCards'},
				{id:'#sf_type',url:adminPath+'/combo/findBeanType?tKey=card_change_type'}
			]
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
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/cardChange/excelDownload?='+data;
			linkExcel.open("member_card_change", url);
		})
	},
	load:function(){
		app.table = $('#cardChange_xtable').xtable({
			url:adminPath + '/cardChange/listPage',
			deleteUrl:adminPath + '/cardChange/delete',
			paging:'.cardChange_paging',
			format:function(row){

				if(row.cardsType == "1"){
					row.typeLabel = ' 元';
				}else{
					row.typeLabel = ' 次';
				}
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