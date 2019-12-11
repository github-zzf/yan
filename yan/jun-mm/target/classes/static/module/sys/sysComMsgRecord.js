$(function(){
	app.init();
})
/**
 * 系统消息发送记录
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
					{id:'#sf_readState', url:adminPath+"/combo/findBeanType?tKey=msg_read_state"}
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
		$('#btn_add').click(function(){
			app.form.clear();
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysComMsgRecord/excelDownload?='+data;
			linkExcel.open("sys_com_msg_record", url);
		})
		$("#sysComMsgRecord_xtable").on("click", ".js_btnUpdateStates", function(){
			var id = $(this).data("xv");
			$.xalert({msg:"是否标记为已读？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/sysComMsgRecord/updateSysComMsgRecordStates',
						data:{id:id},
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
				}
			});
		});
		$('#sysComMsgRecord_xtable').on('click', '.remark_btn', function(){
			var xv = $(this).data('xv');
			var row = app.table.getRow(xv);
			openRemark.open(row.content);
		});
	},
	load:function(){
		app.table = $('#sysComMsgRecord_xtable').xtable({
			url:adminPath + '/sysComMsgRecord/listMyPage',
			deleteUrl:adminPath + '/sysComMsgRecord/delete',
			paging:'.sysComMsgRecord_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				if(row.readState == '2'){
					row.btnUpdateStates = "&nbsp;<a class='js_btnUpdateStates' data-xv='"+row.id+"'>标记为已读</a>&nbsp;";
				}

				row.remarkBtn = openRemark.getRemark(row,'remark_btn');
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