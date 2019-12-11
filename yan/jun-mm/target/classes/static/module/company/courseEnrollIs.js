$(function(){
	app.init();
})
/**
 * 课程预约
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sf_courseDate").xdate();
		$("#sf_courseDate").val(base.getData());
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_status', url:adminPath+"/combo/findBeanType?tKey=course_enroll_status"},
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
		$("#btn_fanHui").xbtn(function() {
			window.location.href = adminPath + '/course';
		});
		// 取消预约
		$('#courseEnroll_xtable').on("click", '.js_quxiao', function(){
			var xv = $(this).data("xv");
			app.form1.setData({id:xv});
			app.win1.open();
		});
		// 签到
		$('#courseEnroll_xtable').on("click", '.js_qiandao', function(){
			var xv = $(this).data("xv");
			$.xpost({
				url:adminPath + '/courseEnroll/qiandao',
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
		// 调课
		$('#courseEnroll_xtable').on("click", '.js_tiaoke', function(){
			var xv = $(this).data("xv");
			app.form2.setData({id:xv});
			app.win2.open();
		});
	},
	load:function(){
		app.table = $('#courseEnroll_xtable').xtable({
			url:adminPath + '/courseEnroll/listPage',
			deleteUrl:adminPath + '/courseEnroll/delete',
			data:{courseDate:base.getData()},
			paging:'.courseEnroll_is_paging',
			format:function(row){
				if(row.status == "1"){
					row.btnQuXiao = "&nbsp;<a class='js_quxiao' data-xv='"+row.id+"'>取消预约</a>&nbsp;";
					row.btnTiaoKe = "&nbsp;<a class='js_tiaoke' data-xv='"+row.id+"'>调课</a>&nbsp;";
					row.btnQianDao = "&nbsp;<a class='js_qiandao' data-xv='"+row.id+"'>签到</a>&nbsp;";
					row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
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