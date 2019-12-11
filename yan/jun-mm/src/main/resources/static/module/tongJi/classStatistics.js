$(function(){
	app.init();
})
/**
 * 管理员统计
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sf_date").xdate({date:false});
		$("#sf_date").val(base.getData().substring(0,7));
		var sf = $("#form_search").xform();
		$("#btn_search").xbtn(function() {
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_reset").xbtn(function() {
			sf.clear();
			$("#sf_date").val(base.getData().substring(0,7));
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#admin_xtable").on("click", ".pingjia_open", function(){
			var id = $(this).data("xv");
			linkCommentContent.open(id);
		});
	},
	load:function(){
		app.table = $('#admin_xtable').xtable({
			data:{date:base.getData().substring(0,7)},
			url:adminPath + '/statistics/findAdminStatisticsTable',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='pingjia_open' data-xv='"+row.id+"'>查看服务评价</a>&nbsp;";
			}
		});
	}
};