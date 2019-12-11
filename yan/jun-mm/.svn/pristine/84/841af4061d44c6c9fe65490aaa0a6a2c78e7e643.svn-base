$(function(){
	app.init();
})
/**
 * 会员卡记录
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sf_invalidTime").xdate();
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_cardId',url:adminPath+'/combo/findComCards'}
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
			var url = adminPath + '/card/excelDownload?='+data;
			linkExcel.open("member_card", url);
		})
		// 消耗
		$('#card_xtable').on('click', '.js_btnXiaoFei', function(){
			app.editTable.setData([]);
			var xv = $(this).data("xv");
			var row = app.table.getRow(xv);
			app.form_xiaoFei.clear();
			app.form_xiaoFei.setData({mcId:row.id,memberName:row.memberName,oldNum:row.storedNum});
			app.win_xiaoFei.open();
			if(row.cardsType == "1"){
				$("#xf_oldstoredNum").html("剩余金额");
				$("#xf_storedNum").html("消耗金额");
			}else if (row.cardsType == "2"){
				$("#xf_oldstoredNum").html("剩余次数");
				$("#xf_storedNum").html("消耗次数");
			}
		});
		// 赠送
		$('#card_xtable').on('click', '.js_btnZengSong', function(){
			var xv = $(this).data("xv");
			var row = app.table.getRow(xv);
			app.form_zengSong.clear();
			app.form_zengSong.setData({mcId:row.id,memberName:row.memberName,oldNum:row.storedNum});
			app.win_zengSong.open();
			if(row.cardsType == "1"){
				$("#zs_oldstoredNum").html("剩余金额");
				$("#zs_storedNum").html("赠送金额");
			}else if (row.cardsType == "2"){
				$("#zs_oldstoredNum").html("剩余次数");
				$("#zs_storedNum").html("赠送次数");
			}
		});
		// 失效
		$('#card_xtable').on("click", '.js_btnShiXiao', function(){
			var xv = $(this).data("xv");
			$.xalert({
				confirm:true,
				msg:"确认失效这条记录吗?",
				okBack:function(){
					$.xpost({
						url:adminPath + '/card/shiXiao',
						data:{mcId:xv},
						success : function(e) {
							if(e.code==1){
								app.table.reload();
								$.ok('操作成功');
							}else {
								$.xalert(e.msg);
							}
						}
					})
				}
			});
		});
		// 消费明细
		$('#card_xtable').on("click", '.js_btnMingXi', function(){
			var xv = $(this).data("xv");
			linkCardChange.open(xv);
		});
	},
	load:function(){
		app.table = $('#card_xtable').xtable({
			url:adminPath + '/card/listPage',
			deleteUrl:adminPath + '/card/delete',
			paging:'.card_paging',
			format:function(row){

				if(row.cardsType == "1"){
					row.typeLabel = ' 元';
				}else{
					row.typeLabel = ' 次';
				}
				row.btnShiXiao = "&nbsp;<a class='js_btnShiXiao' data-xv='"+row.id+"'>失效</a>&nbsp;";
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改失效日期</a>&nbsp;";
				row.btnXiaoFei = "&nbsp;<a class='js_btnXiaoFei' data-xv='"+row.index+"'>消费</a>&nbsp;";
				row.btnZengSong = "&nbsp;<a class='js_btnZengSong' data-xv='"+row.index+"'>赠送</a>&nbsp;";
				row.btnMingXi = "&nbsp;<a class='js_btnMingXi' data-xv='"+row.id+"'>消费明细</a>&nbsp;";
//				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
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