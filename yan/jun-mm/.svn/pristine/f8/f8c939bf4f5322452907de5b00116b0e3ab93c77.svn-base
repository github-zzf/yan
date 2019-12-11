$(function(){
	app.init();
})
/**
 * 通知设置
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform();
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
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/staffNoticeSetting/excelDownload?='+data;
			linkExcel.open("com_staff_notice_setting", url);
		})
	},
	load:function(){
		app.table = $('#staffNoticeSetting_xtable').xtable({
			url:adminPath + '/staffNoticeSetting/listPage',
			deleteUrl:adminPath + '/staffNoticeSetting/delete',
			paging:'.staffNoticeSetting_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				if(0 == row.enrollMsg){
					row.isEnrollMsg = "通知"
				}else{
					row.isEnrollMsg = "不通知"
				}
				if(0 == row.censusMsg){
					row.isCensusMsg = "通知";
				}else{
					row.isCensusMsg = "不通知";
				}
				if(0 == row.leaveMsg){
					row.leaveMsgTxt = "通知";
				}else{
					row.leaveMsgTxt = "不通知";
				}
			},
			update:function(row){
				$.log(row);
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