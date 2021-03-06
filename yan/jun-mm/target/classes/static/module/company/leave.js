$(function(){
	app.init();
})
/**
 * 员工请假表
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sf_startTime").xdate();
		$("#sf_endTime").xdate();
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
			var url = adminPath + '/leave/excelDownload?='+data;
			linkExcel.open("com_leave", url);
		})
		// 审批
		$("#leave_xtable").on("click", ".js_btnCheck", function(){
			var id = $(this).data("xv");
			checkWin.setUrl(adminPath + '/leave/updateCheckState');
			checkWin.open({id:id});
		});
		// 取消
		$("#leave_xtable").on("click", ".js_btnIsCancel", function(){
			var id = $(this).data("xv");
			$.xalert({msg:"确定取消请假吗？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/leave/updateIsCancel',
						data:{id:id},
						success:function(e){
		                	if (e.code==1){
		                		app.table.reload();
		                		$.ok("取消成功");
		                    } else {
		                    	$.xalert({msg:'取消失败！'});
		                    }
						},
						error:function(){$.xalert({msg:'请求失败！'});}
		            });
				}
			});
		});
	},
	load:function(){
		app.table = $('#leave_xtable').xtable({
			url:adminPath + '/leave/listPage',
			deleteUrl:adminPath + '/leave/delete',
			paging:'.leave_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				if(row.checkState == '1'){
					row.btnCheck = "&nbsp;<a class='js_btnCheck' data-xv='"+row.id+"'>审批</a>&nbsp;";
					row.btnIsCancel = "&nbsp;<a class='js_btnIsCancel' data-xv='"+row.id+"'>取消</a>&nbsp;";
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