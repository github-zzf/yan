$(function(){
	app.init();
})
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
		$('#user_xtable').on("click", ".btn_status", function(){
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
						url:adminPath + '/saleUser/updateStatus',
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
		$('#user_xtable').on("click", ".btn_resetPass", function(){
			var ths =$(this);
			var id = ths.data("xv");
			$.xalert({
				msg:'确认要重置密码到初始状态吗？',
				confirm: true,
				okBack:function(){
					$.xpost({
						url : adminPath + '/saleUser/resetPass',
						data:{id:id},
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
			})
		})
	},
	load:function(){
		app.table = $('#user_xtable').xtable({
			url:adminPath + '/saleUser/findPage',
			deleteUrl:adminPath+'/saleUser/delete',
			paging:'.user_paging',
			format:function(row){
				row.birthday = base.subDate(row.birthday);
				row.entryDate = base.subDate(row.entryDate);
				row.leaveDate = base.subDate(row.leaveDate);

				if(row.status==0){
					row.btnStatus = '&nbsp;<a class="btn_status" data-xv="'+row.index+'">停用</a>&nbsp;';
				}else{
					row.btnStatus = '&nbsp;<a class="btn_status" data-xv="'+row.index+'">启用</a>&nbsp;';
				}
				row.btnUpdate = '&nbsp;<a class="xupdate" data-xv="'+row.index+'">修改</a>&nbsp;';
				row.btnDelete = '&nbsp;<a class="xdelete" data-xv="'+row.id+'">删除</a>&nbsp;';
				row.btnResetPass = '&nbsp;<a class="btn_resetPass" data-xv="'+row.id+'">重置密码</a>&nbsp;';
			},
			update:function(row){
				$(".checkbox_role").prop("checked",false);
				var roleIds = row.roleIds;
				if (roleIds!="" && roleIds!=null) {
					$(".checkbox_role").each(function(index,item){
						var id = ","+$(item).data("id")+",";
						if((","+roleIds+",").indexOf(id)!=-1){
							item.checked=true;
						}
					});
				}
				app.form.setData(row);
				app.win.open();
			},
			deleteSuccess:function(e){
				if (e.code==1){
					app.table.reload();
            		$.ok('删除成功');
                } else {
                	$.xalert({msg:e.msg});
                }
			}
		});
	}
};