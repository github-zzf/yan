$(function(){
	app.init();
})
/**
 * 用户角色管理
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform();
		$("#btn_search").click(function() {
			var data = sf.getData();
			app.table.reload(data);
		});
		$("#btn_reset").click(function() {
			sf.clear();
			var data = sf.getData();
			app.table.reload(data);
		});
		//电脑端权限
		$('#role_xtable').on("click", '.js_power', function(){
			var xv = $(this).data("xv");
			var row = app.table.getRow(xv);
			linkMenu.open(function(treeId, treeNode){
				$("#f_parentName").val(treeNode.name);
				$("#f_parentId").val(treeNode.id);
			},row)
//			var xv = $(this).data("xv");
//			var row = app.table.getRow(xv);
//			app.roleId = row.id;
//			app.menus = ','+row.menus+',';
//			app.loadMenus();
//			app.menuWin.open();
		});
		//启用禁用
		$('#role_xtable').on("click", ".btn_status", function(){
			var ths =$(this);
			var index = ths.data("xv");
			var row = app.table.getRow(index);
			var msg = "确认要启用该用户吗？";
			var status = 0;
			if(row.status==0){
				msg = "确认要停用该用户吗？";
				status = 8;
			}
			$.xalert({
				msg:msg,
				confirm: true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/sysRole/updateStatus',
						data:{id:row.id,status:status},
						success:function(e){
							if (e.code==1) {
								$.ok("设置成功")
								app.table.reload();
							}else{
								$.xalert(e.msg);
							}
						}
					});
				}
			});
		})
	},
	load:function(){
		app.table = $('#role_xtable').xtable({
			url:adminPath + '/sysRole/listPage',
			deleteUrl:adminPath+'/sysRole/delete',
			paging:'.role_paging',
			format:function(row){
//				if(row.status==0){
//					row.btnStatus = '&nbsp;<a class="btn_status" data-xv="'+row.index+'">停用</a>&nbsp;';
//				}else{
//					row.btnStatus = '&nbsp;<a class="btn_status" data-xv="'+row.index+'">启用</a>&nbsp;';
//				}
				row.btnUpdate = '&nbsp;<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;';
				row.btnDelete =	'&nbsp;<a class="xdelete" data-xv="'+row.id+'">删除</a>&nbsp;';
				row.btnPower =	'&nbsp;<a class="js_power" data-xv="'+row.index+'">权限设置</a>&nbsp;';
			},
			bind:function(){
				app.bind();
			},
			update:function(row){
				row.isNewT = false;
				app.form.setData(row);
				$("#f_id").addClass("readonly").attr("readonly","readonly");
				app.win.open();
			},
			deleteSuccess:function(e){
				if (e.code == 1) {
					app.table.reload();
					$.ok('删除成功');
				} else {
					$.xalert(e.msg);
				}
			}
		});
	}
};
