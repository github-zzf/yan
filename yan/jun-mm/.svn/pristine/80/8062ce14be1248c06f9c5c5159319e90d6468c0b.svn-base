$(function(){
	app.init();
})
/**
 * 个人统计
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
	},
	select:function(data){
		if(typeof(data) == "undefined"){
			var date = base.getData().substring(0,7);
			data = {date:date};
		}
		$.xpost({
			url:adminPath+'/statistics/findMyStatistics',
			data:data,
			success:function(e){
				$(".xiaoshou").html(e.xiaoshou);
				$(".ticheng").html(e.ticheng);
				$(".shankeNum").html(e.shangkeNum);
				$(".shangkeMoney").html(e.shangkeMoney);
				$(".zhujiaoNum").html(e.zhujiaoNum);
				$(".zhujiaoMoney").html(e.zhujiaoMoney);
			}
		});
	}
};