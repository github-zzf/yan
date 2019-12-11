$(function(){
	app.init();
})
/**
 * 文章表
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
			$("#uploader").attr('bizid',0);
			app.ue_content.setContent("");
			app.win.open();
		});
		$("#sf_typeName").click(function(){
			linkArttype.open(function(treeId, treeNode){
				$("#sf_typeName").val(treeNode.name);
				$("#sf_typeId").val(treeNode.id);
			})
		})
		$('#btn_export').xbtn(function() {
			var data = $("#form_search").serialize();
			var url = adminPath + '/articles/excelDownload?='+data;
			linkExcel.open("cms_articles", url);
		})
		$('#articles_xtable').on('click', '.remark_btn', function(){
			var xv = $(this).data('xv');
			var row = app.table.getRow(xv);
			openRemark.open(row.body);
		});
		//向上移动
		$('#articles_xtable').on('click', '.btn_up', function(){
			var index = $(this).data('xv');
			app.moveRow(index, "up");
		});
		//向下移动
		$('#articles_xtable').on('click', '.btn_down', function(){
			var index = $(this).data('xv');
			app.moveRow(index, "down");
		});
	},
	load:function(){
		app.table = $('#articles_xtable').xtable({
			url:adminPath + '/articles/listPage',
			deleteUrl:adminPath + '/articles/delete',
			paging:'.articles_paging',
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>修改</a>&nbsp;";
				row.btnDelete = "&nbsp;<a class='xdelete' data-xv='"+row.id+"'>删除</a>&nbsp;";
				row.body = app.strReplace(row.body);
				row.remarkBtn = openRemark.getRemark(row,'remark_btn');
			},
			update:function(row){
				app.form.setData(row);
				// 加载图片数据
				$("#uploader").attr('bizid',row.id);
				app.ue_content.ready(function(){
                    if(row.body!=null&&row.body!=""){
                        app.ue_content.setContent(row.body);
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
	},
	strReplace:function(str){
    	var arrEntities={'lt':'<','gt':'>','nbsp':' ','amp':'&','quot':'"'}; 
    	return str.replace(/&(lt|gt|nbsp|amp|quot);/ig,function(all,t){return arrEntities[t];});
	},
	moveRow:function(id, upDown){
		$.open();
		$.xpost({
			url:adminPath + '/articles/moveSetup',
			data : {
				id : id,
				upDown:upDown
			},
			success : function(e) {
				if(e.code==1){
					$.close();
					app.table.reload();
				}else {
					$.xalert(e.msg);
					$.close();
				}
			}
		})
	}
};