$(function(){
	app.init();
})
/**
 * 缓存管理
 */
var app = {
	cacheName:"",
	init:function(){
		app.bind();
		app.load();
	},
	bind : function() {
		$("#sysCache_1_xtable").on("click", "tr", function(){
			$("#cache_new").html("");
			$("#cache_name").val("");
			$("#cache_key_name").val("");
			var index = $(this).index();
			var row = app.table.getRow(index);
			app.table1.reload({key:row.cacheName});
			app.cacheName = row.cacheName;
		});
		$("#sysCache_2_xtable").on("click", "tr", function(){
			$("#cache_new").html("");
			var index = $(this).index();
			var row = app.table1.getRow(index);
			var cacheName = app.cacheName;
			$("#cache_name").val(cacheName);
			$("#cache_key_name").val(row.cache);
			$.xpost({
				url:adminPath + '/sysCache/getKetNeirong',
				data:{cacheName:cacheName, key:row.cache},
				success:function(e){
					$.log(e);
					if(e.code==1){
						$("#cache_new").html(e.data);
					}
				}
            });
		});
		$("#sysCache_1_xtable").on("click", ".delect_cache_removeAll", function(){
			var index = $(this).data("xv");
			var row = app.table.getRow(index);
			$.xalert({msg:"确定清空缓存吗？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/sysCache/removeAll',
						data:{cacheName:row.cache},
						success:function(e){
							if (e.code==1){
								app.table.reload();
								app.table1.reload();
								$.ok('删除成功');
							} else {
								$.xalert('删除失败！');
							}
						}
					});
				}
			});
		});
		$("#sysCache_2_xtable").on("click", ".delect_cache_remove", function(){
			var index = $(this).data("xv");
			var cacheName = app.cacheName;
			var row = app.table1.getRow(index);
			$.xalert({msg:"确定清空缓存键名吗？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/sysCache/remove',
						data:{cacheName:cacheName, key:row.cache},
						success:function(e){
							if (e.code==1){
								app.table.reload();
								app.table1.reload();
								$.ok('删除成功');
							} else {
								$.xalert('删除失败！');
							}
						}
					});
				}
			});
		});
	},
	load:function(){
		app.table = $('#sysCache_1_xtable').xtable({
			url:adminPath + '/sysCache/findList',
			deleteUrl:adminPath + '/sysCache/delete',
			format:function(row){
				row.btnDelete = "&nbsp;<a class='delect_cache_removeAll' data-xv='"+row.index+"'>删除</a>&nbsp;";
			}
		});
		app.table1 = $('#sysCache_2_xtable').xtable({
			url:adminPath + '/sysCache/findKeyList',
			deleteUrl:adminPath + '/sysCache/delete',
			data:{key:"comCache"},
			format:function(row){
				row.btnDelete = "&nbsp;<a class='delect_cache_remove' data-xv='"+row.index+"'>删除</a>&nbsp;";
			}
		});
	}
};