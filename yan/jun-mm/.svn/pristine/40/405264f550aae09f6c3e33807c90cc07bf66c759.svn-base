$(function(){
	app.init();
})
/**
 * 企业
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
		$("#sf_areaName").click(function(){
			linkSysArea.open(function(treeId, treeNode){
				$("#sf_areaName").val(treeNode.name);
				$("#sf_areaId").val(treeNode.id);
			})
		})
		$("#btn_reset").xbtn(function() {
			sf.clear();
			var data = sf.getData();
			app.table.reload(data);
		});
		$('#btn_add').click(function(){
			app.form.clear();
			app.form.setData({isNewT:true});
			$(".checkbox_role").prop("checked",false);
			$("#f_comId").removeClass("readonly").removeAttr("readonly");
			$("#f_comName").removeClass("readonly").removeAttr("readonly");
			app.win.open();
		});
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/sysCompany/excelDownload?='+data;
			linkExcel.open("sys_company", url);
		})
	},
	load:function(){
		app.table = $('#sysCompany_xtable').xtable({
			url:adminPath + '/sysCompany/listPage',
			deleteUrl:adminPath + '/sysCompany/delete',
			paging:'.sysCompany_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
			},
			update:function(row){
				$("#f_comId").addClass("readonly").attr("readonly","readonly");
				row.isNewT = false;
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