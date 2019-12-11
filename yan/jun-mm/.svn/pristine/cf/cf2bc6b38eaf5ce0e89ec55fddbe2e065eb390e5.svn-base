$(function(){
	app.init();
})
/**
 * 每日统计
 */
var app = {
	init:function(){
		app.bind();
		app.select();
	},
	bind : function() {
		$("#sf_date").xdate();
		$("#sf_date").val(base.getData());
		var sf = $("#form_search").xform();
		$("#btn_search").xbtn(function() {
			var data = sf.getData();
			app.select(data);
		});
		$("#btn_reset").xbtn(function() {
			sf.clear();
			$("#sf_date").val(base.getData());
			var data = sf.getData();
			app.select(data);
		});
	},
	select:function(data){
		if(typeof(data) == "undefined"){
			var date = base.getData();
			data = {date:date};
		}
		$.xpost({
			url:adminPath+'/statistics/findDayStatistics',
			data:data,
			success:function(e){
				$(".xiaoshou").html(e.xiaoshou);
				$(".jine").html(e.jine);
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