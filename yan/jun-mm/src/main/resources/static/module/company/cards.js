$(function(){
	app.init();
})
/**
 * 储次卡
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_type',xdata:[{val:'1',txt:'储值卡'},{val:'2',txt:'储次卡'}]},
			/*	{id:'#sf_isNew',xdata:[{val:'1',txt:'是'},{val:'0',txt:'否'}]}*/
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
			app.form.setData({type:1,isNew:0,isWeek:0})
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/cards/excelDownload?='+data;
			linkExcel.open("com_cards", url);
		})
	},
	load:function(){
		app.table = $('#cards_xtable').xtable({
			url:adminPath + '/cards/listPage',
			deleteUrl:adminPath + '/cards/delete',
			paging:'.cards_paging',
			format:function(row){
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