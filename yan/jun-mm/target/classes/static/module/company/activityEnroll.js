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
		$("#activityEnroll_name").html(activityName+"_报名明细");
		$("#btn_fanHui").xbtn(function() {
			window.location.href = adminPath + '/activity';
		});
		$('#btn_add').click(function(){
			app.form.clear();
			app.form.setData({activityId:id});
			app.win.open();
		});
		// 签到
		$('#activityEnroll_xtable').on("click", '.js_qiandao', function(){
			var xv = $(this).data("xv");
			$.xpost({
				url:adminPath + '/activityEnroll/qiandao',
				data:{id:xv,isSign:'1'},
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
		$('#activityEnroll_xtable').on("click", '.js_btnQuXiao', function(){
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
		$('#activityEnroll_xtable').on("click", '.js_btnPy', function(){
			var index = $(this).data("xv");
			var row = app.table.getRow(index);
			$.log(row.payState);
			app.form1.clear();
			app.form1.setData(row);
			app.win1.open();
		});
	},
	load:function(){
		app.table = $('#activityEnroll_xtable').xtable({
			url:adminPath + '/activityEnroll/findList',
			deleteUrl:adminPath + '/activityEnroll/delete',
			data:{activityId:id},
			format:function(row){
					/*row.btnShenPi = "&nbsp;<a class='js_btnShenPi' data-xv='"+row.id+"'>审批</a>&nbsp;";*/
					if(row.isSign == "0" && row.enrollStatus == "0"){
						row.btnQianDao = "&nbsp;<a class='js_qiandao' data-xv='"+row.id+"'>签到</a>&nbsp;";
						row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
						row.btnQuXiao = "&nbsp;<a class='js_btnQuXiao' data-xv='"+row.id+"'>取消预约</a>&nbsp;";
					}
					if(row.payState == '1'){
						row.btnPy = "&nbsp;<a class='js_btnPy' data-xv='"+row.index+"'>到店支付</a>&nbsp;";
					}
					row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.index+"'>删除</a>&nbsp;";
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