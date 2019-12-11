$(function(){
	app.init();
	ExcelWin.init();
	ExcelWinError.init();
})
/**
 * 会员
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_levelId', url:adminPath+"/combo/findMemberLevel"}
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
		// 会员导出
		$('#btn_export').xbtn(function() {
			exportWin.bindFind("member");
			var url = adminPath + '/member/excelDownload';
			exportWin.bindExport(url);
		})
		// 会员导入
		$('#btn_gets').click(function() {
			ExcelWin.winExcel.open();
		});
		// 绑定微信
		$("#member_xtable").on('click','.btnBindUser', function() {
			var index = $(this).data('xv');
			var row = app.table.getRow(index);
			app.memberBindOpen(row);
		});
		// 解除绑定
		$("#member_xtable").on('click','.btnUnBindUser', function() {
			var index = $(this).data('xv');
			var row = app.table.getRow(index);
			app.memberUnBindOpen(row);
		});
	},
	load:function(){
		app.table = $('#member_xtable').xtable({
			url:adminPath + '/member/listPage',
			deleteUrl:adminPath + '/member/delete',
			paging:'.member_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				if(row.openId){
					row.btnUnBindUser = "&nbsp;<a class='btnUnBindUser' data-xv='"+row.index+"'>解除绑定</a>&nbsp;";
				}else{
					row.btnBindUser = "&nbsp;<a class='btnBindUser' data-xv='"+row.index+"'>绑定微信</a>&nbsp;";
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

/**
 * 导入excel
 */
var ExcelWin = {
	init : function() {
		ExcelWin.loadWin();
		ExcelWin.loadForm();
		ExcelWin.bindOpen();
		ExcelWin.bindExcelUpload();
	},
	loadWin : function() {
		ExcelWin.winExcel = $('#excel_win').xwindow({
			width : 500,
			height :200,
			open : false
		});
	},
	loadForm : function() {
		ExcelWin.formExcel = $('#excel_form').xform({
			save : adminPath + '/member/importExcelDownload',
			fileupload : true,
			xbtn : '.btn_submitExcel',
			xcheck : [ {
				label : 'Excel文件',
				name : 'excelFile',
				xcheck : 'null'
			}],
			success : function(e) {
				var e =eval("("+e+")");
				if (e.code == 1) {
					ExcelWin.winExcel.close();
					$.ok('操作成功');
					ExcelWinError.bindOpen(e);
					app.table.reload();
				} else if (e.code==2) {
					$.xalert(e.data);
				} else{
					$.xalert({
						msg : '操作失败！'
					});
				}
			},
			error : function() {
				$.xalert({
					msg : '请求失败！'
				});
			}
		});
	},
	bindExcelUpload : function() {
		var btn = $('#ExcelGO');
		if (btn.length > 0) {
			btn.xbtn(function(btn) {
				var ie = !-[ 1 ];
				if (ie) {
					jQuery('input:file').trigger('click').trigger('change');
				} else {
					jQuery('input:file').trigger('click');
				}
			});
		}
	},
	bindOpen : function() {
		//导入
		$('#btn_gets').click(function() {
			ExcelWin.winExcel.open();
		});
		
		//导入模板
		$('#btn_export_demo').xbtn(function() {
			var demoUrl = adminPath + '/member/excelDownloadDemo';
			base.download(demoUrl);
		})
	}
};
/**
 * 导入excel结果
 */
var ExcelWinError = {
		init : function() {
			ExcelWinError.loadWin();
			ExcelWinError.bindclose();
		},
		loadWin : function() {
			ExcelWinError.winExcelError = $('#export_error_win').xwindow({
				width : 500,
				height :500,
				open : false
			});
		},
		bindOpen : function(e) {
			$('#table1').empty();
			$('#totalCount').html("总数量：" + e.totalCount);  
			$('#successCount').html("成功数：" + e.successCount);  
			$('#errorCount').html("错误数：" + e.errorCount);  
			var shu=new Array();
			shu = e.errors;
			var count =$('#errorCount');
			for (var i = 0; i < shu.length; i++) {
				var vTr = "<tr><td>错误"+(i+1)+"</td><td class='tl'>"+shu[i]+"</td></tr>";
				$('#table1').append(vTr);
			}
			ExcelWinError.winExcelError.open();
		},
		bindclose:function(){
			$(".btn_yes").click(function(){
				ExcelWinError.winExcelError.close();		
			});
		}
};