$(function(){
	app.init();
})
/**
 * 会员积分
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
		$("#member_xtable").on("click", ".js_btnDetailed", function(){
			var id = $(this).data("xv");
			linkMemberPoints.open(id);
		});
		$("#member_xtable").on("click", ".js_btnExchange", function(){
			var id = $(this).data("xv");
			memberReducePoints.callBack = function(data) {
				$.xalert({msg:"确定选择此商品吗？",confirm:true,
					okBack:function(){
						$.xpost({
							url:adminPath + '/memberPoints/updateReducePoints',
							data:{id:id,giftId:data.id},
							success:function(e){
			                	if (e.code==1){
			                		app.table.reload();
			                		memberReducePoints.win.close();
			                		$.ok("选择成功");
			                    } else {
			                    	$.xalert(e.msg);
			                    }
							},
							error:function(){$.xalert({msg:'请求失败！'});}
			            });
					}
				});
			}
			memberReducePoints.open();
		});
	},
	load:function(){
		app.table = $('#member_xtable').xtable({
			url:adminPath + '/member/listPage',
			paging:'.member_paging',
			format:function(row){
				row.btnDetailed = "&nbsp;<a class='js_btnDetailed' data-xv='"+row.id+"'>积分明细</a>&nbsp;";
				row.btnExchange = "&nbsp;<a class='js_btnExchange' data-xv='"+row.id+"'>积分兑换</a>&nbsp;";
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>赠送积分</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				app.win.open();
			}
		});
	}
};