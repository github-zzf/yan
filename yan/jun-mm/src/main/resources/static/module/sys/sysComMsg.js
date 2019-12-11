$(function(){
	app.init();
})
/**
 * 系统消息
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_type', url:adminPath+"/combo/findBeanType?tKey=sysComMsg_type"}
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
			app.ue_content.setContent("");
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysComMsg/excelDownload?='+data;
			linkExcel.open("sys_com_msg", url);
		})
	},
	load:function(){
		app.table = $('#sysComMsg_xtable').xtable({
			url:adminPath + '/sysComMsg/listPage',
			deleteUrl:adminPath + '/sysComMsg/delete',
			paging:'.sysComMsg_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				if(row.receiveType == '0'){
					$(".receiveType_hide").hide();
				}else{
					$(".receiveType_hide").show();
				}
				app.ue_content.ready(function(){
                    if(row.content!=null&&row.content!=""){
                        app.ue_content.setContent(row.content);
                    }else{

                        app.ue_content.setContent("");
                    }
                });
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