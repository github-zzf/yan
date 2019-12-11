$(function(){
	app.init();
})
/**
 * 活动报名
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#f_is_activityStartTime").xdate();
		$("#f_is_activityEndTime").xdate();
		$("#f_is_activityStartTime").val(base.getData());
		$("#f_is_activityEndTime").val(base.getData());
		var sf = $("#form_activityEnrollIsSigen_search").xform({
			xcombo:[
					{id:'#f_status', url:adminPath+"/combo/findBeanType?tKey=activity_en_status"},
					{id:'#f_isSigen', url:adminPath+"/combo/findBeanType?tKey=activity_en_is_sign"}
				]
			}
		);
		$("#btn_search").xbtn(function() {
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_reset").xbtn(function() {
			sf.clear();
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_activityEnrollIsSigen_fanHui").xbtn(function() {
			window.location.href = adminPath + '/activity';
		});
		// 签到
		$('#activityEnroll_activityEnrollIsSigen_xtable').on("click", '.js_is_qiandao', function(){
			var xv = $(this).data("xv");
			$.xpost({
				url:adminPath + '/activityEnroll/qiandao',
				data:{id:xv},
				success : function(e) {
					if(e.code==1){
						app.table.reload();
						$.ok('操作成功');
					}else {
						$.xalert(e.msg);
					}
				}
			})
		});
		// 取消预约
		$('#activityEnroll_activityEnrollIsSigen_xtable').on("click", '.js_is_btnQuXiao', function(){
			var xv = $(this).data("xv");
			$.xpost({
				url:adminPath + '/activityEnroll/updateEnrollStatus',
				data:{id:xv},
				success : function(e) {
					if(e.code==1){
						app.table.reload();
						$.ok('操作成功');
					}else {
						$.xalert(e.msg);
					}
				}
			})
		});
		// 到店支付
		$('#activityEnroll_activityEnrollIsSigen_xtable').on("click", '.js_is_btnPy', function(){
			var index = $(this).data("xv");
			var row = app.table.getRow(index);
			app.form1.clear();
			app.form1.setData(row);
			app.win1.open();
		});
	},
	load:function(){
		app.table = $('#activityEnroll_activityEnrollIsSigen_xtable').xtable({
			url:adminPath + '/activityEnroll/listIsPage',
			deleteUrl:adminPath + '/activityEnroll/delete',
			data:{activityStartTime:base.getData(),activityEndTime:base.getData()},
			paging:'.activity_is_paging',
			format:function(row){
					if(row.isSign == "0" && row.enrollStatus == "0"){
						row.btnQianDao = "&nbsp;<a class='js_is_qiandao' data-xv='"+row.id+"'>签到</a>&nbsp;";
						row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
						row.btnQuXiao = "&nbsp;<a class='js_is_btnQuXiao' data-xv='"+row.id+"'>取消预约</a>&nbsp;";
					}
					if(row.payState == '1'){
						row.btnPy = "&nbsp;<a class='js_is_btnPy' data-xv='"+row.index+"'>到店支付</a>&nbsp;";
					}
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