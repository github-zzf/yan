$(function(){
	app.init();
})
/**
 * 消费记录
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_type',url:adminPath+'/combo/findBeanType?tKey=cash_buy_type'},
				{id:'#sf_payType',url:adminPath+'/combo/findBeanType?tKey=pay_type'}
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
		$('#btn_add').click(function(){
			app.form.clear();
			app.childGoods.setData([]);
			app.childCard.setData([]);
			app.childUser.setData([]);
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/cashBuy/excelDownload?='+data;
			linkExcel.open("cash_buy", url);
		})
	},
	load:function(){
		app.table = $('#cashBuy_xtable').xtable({
			url:adminPath + '/cashBuy/listPage',
			deleteUrl:adminPath + '/cashBuy/delete',
			paging:'.cashBuy_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				// 加载子表数据
				app.childGoods.reload({buyId:row.id})
				app.childCard.reload({buyId:row.id})
				app.childUser.reload({buyId:row.id})
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