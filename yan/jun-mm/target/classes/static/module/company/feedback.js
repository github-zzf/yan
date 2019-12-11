$(function(){
	app.init();
})
/**
 * 意见反馈
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_type',xdata:[{val:'0',txt:'投诉建议'},{val:'1',txt:'问题反馈'}]}
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
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/feedback/excelDownload?='+data;
			linkExcel.open("com_feedback", url);
		})
		$("#feedback_xtable").on("click", ".js_btnUpdate", function(){
			var id = $(this).data("xv");
			$.xpost({
				url:adminPath + '/feedback/updateFeedbackStatus',
				data:{ids:id},
				success:function(e){
                	if (e.code==1){
                		app.table.reload();
                		$.ok("标记成功");
                    } else {
                    	$.xalert({msg:'标记失败！'});
                    }
				},
				error:function(){$.xalert({msg:'请求失败！'});}
            });
		});
		$("#btn_updateFrrdbackStatus").click(function(){
			var row = app.table.getSelectedData();
			var isStatus = false;
			var ids = [];
			$.each(row, function(index, item){
				if(item.status == 1){
					isStatus = true;
					return false;
				}
				ids.push(item.id);
			});
			if(isStatus){
				$.xalert("请选择未读!");
				return;
			}
			$.xpost({
				url:adminPath + '/feedback/updateFeedbackStatus',
				data:{ids:ids.join(",")},
				success:function(e){
					if (e.code==1){
						app.table.reload();
						$.ok("标记成功");
					} else {
						$.xalert({msg:'标记失败！'});
					}
				},
				error:function(){$.xalert({msg:'请求失败！'});}
			});
		});
	},
	load:function(){
		app.table = $('#feedback_xtable').xtable({
			url:adminPath + '/feedback/listPage',
			deleteUrl:adminPath + '/feedback/delete',
			paging:'.feedback_paging',
			format:function(row){
				if(row.status == 0){
					row.btnUpdate = "&nbsp;<a class='js_btnUpdate' data-xv='"+row.id+"'>标记为已读</a>&nbsp;";
				}
				if(row.type=="0"){
					row.typeTxt="投诉建议";
				}else{
					row.typeTxt="问题反馈";
				}
				if(row.status==0){
					row.statusTxt="未读";
				}else if(row.status==1){
					row.statusTxt="已读";
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