$(function(){
	app.init();
})
/**
 * 管理员统计
 */
var app = {
	init:function(){
		app.bind();
		app.select();
	},
	bind : function() {
		$("#sf_date").xdate({date:false});
		$("#sf_date").val(base.getData().substring(0,7));
		var sf = $("#form_search").xform();
		$("#btn_search").xbtn(function() {
			var data = sf.getData();
			app.select(data);
		});
		$("#btn_reset").xbtn(function() {
			sf.clear();
			$("#sf_date").val(base.getData().substring(0,7));
			var data = sf.getData();
			app.select(data);
		});
		$("#admin_xtable").on("click", ".pingjia_open", function(){
			var id = $(this).data("xv");
			linkCommentContent.open(id);
		});
	},
	select:function(data){
		if(typeof(data) == "undefined"){
			var date = base.getData().substring(0,7);
			data = {date:date};
		}
		$.xpost({
			url:adminPath+'/statistics/findAdminStatistics',
			data:data,
			success:function(e){
				$(".xiaoshou").html(e.zongMoney);
				$(".jine").html(e.chuzhi);
				$(".chuci").html(e.chuci);
				$(".xianjin").html(e.xianjin);
				$(".shuaka").html(e.shuaka);
				$(".zhifubao").html(e.zhifubao);
				$(".weixin").html(e.weixin);
				$(".type1buy11").html(e.type1buy11);
				$(".type1buy12").html(e.type1buy12);
				$(".type1buy13").html(e.type1buy13);
				$(".xianshang").html(e.xianshang);
				$(".type4buy42").html(e.type4buy42);
				$(".type4buy43").html(e.type4buy43);
			}
		});
	}
};