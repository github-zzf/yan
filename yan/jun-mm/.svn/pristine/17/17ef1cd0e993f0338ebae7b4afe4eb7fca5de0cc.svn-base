$(function(){
	app.init();
	ExcelWin.init();
	ExcelWinError.init();
})
/**
 * 排课表
 */
var app = {
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sf_courseDate").xdate();
		var sf = $("#form_search").xform({
			xcombo:[
				{id:'#sf_isWeek', url:adminPath+"/combo/findBeanType?tKey=is_yes"},
				{id:'#sf_isCheck', url:adminPath+"/combo/findBeanType?tKey=course_isCheck"}
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
			app.form.setData({isWeek:1,isCheck:1});
			app.win.open();
		});
		// 课程导出
		$('#btn_export').xbtn(function() {
			exportWin.bindFind("com_course");
			var url = adminPath + '/course/excelDownload';
			exportWin.bindExport(url);
		});
		// 课程明细导出
		$('#btn_courseEnroll_export').xbtn(function() {
			var ids = app.table.getSelectedId().split(",");
			if(ids.length > 1 || (ids.length > 0 && ids[0] == "")){
				$.xalert("请选择一条记录!");
				return;
			}
			$("#sf_courseId").val(ids[0]);
			exportWin.bindFind("com_course_enroll");
			var url = adminPath + '/courseEnroll/excelDownload';
			exportWin.bindExport(url);
		});
		// 课程批量导入
		$('#btn_gets').click(function() {
			ExcelWin.winExcel.open();
		});
		// 教师
		$("#sf_teacher").xsearch({
			url:adminPath+"/combo/findStaff",
			text:'{name}',
			valText:'id',
			valBox:'#sf_teacherId'
		});
		// 助教
		$("#sf_assistant").xsearch({
			url:adminPath+"/combo/findStaff",
			text:'{name}',
			valText:'id',
			valBox:'#sf_assistantId'
		});
		// 会员卡
		$("#sf_cardName").xsearch({
			url:adminPath+"/combo/findComCards",
			text:'{name}',
			valText:'id',
			valBox:'#sf_cardId'
		});
		// 报名明细
		$('#course_xtable').on("click", '.js_detailed', function(){
			var xv = $(this).data("xv");
			var row = app.table.getRow(xv);
			window.location.href = adminPath + '/courseEnroll?id='+row.id+"&name="+row.name;
		});
		// 清空会员卡
		$("#link_deleteCardId").show();
		$('#link_deleteCardId').click(function(){
			var id = $("#course_id").val();
			$.xalert({msg:"确定清空会员卡吗？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/course/updateCourseCardIdNull',
						data:{id:id},
						success:function(e){
		                	if (e.code==1){
		                		app.table.reload();
		                		linkCards.win.close();
		                		app.win.close();
		                		$.ok("清空成功");
		                    } else {
		                    	$.xalert({msg:'清空失败！'});
		                    }
						},
						error:function(){$.xalert({msg:'请求失败！'});}
		            });
				}
			});
		});
	},
	load:function(){
		app.table = $('#course_xtable').xtable({
			url:adminPath + '/course/listPage',
			deleteUrl:adminPath + '/course/delete',
			paging:'.course_paging',
			format:function(row){
				row.btnDetailed = "&nbsp;<a class='js_detailed' data-xv='"+row.index+"'>报名明细</a>&nbsp;";
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
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
                	$.xalert(e.msg);
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
			save : adminPath + '/course/importExcelDownload',
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
			var demoUrl = adminPath + '/course/excelDownloadDemo';
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