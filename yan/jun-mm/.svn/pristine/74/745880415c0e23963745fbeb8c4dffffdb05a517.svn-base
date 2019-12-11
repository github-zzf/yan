$(function(){
	app.init();
})
/**
 * 奖金统计方式
 */
var app = {
	init:function(){
		app.bind();
		app.load();
		app.input();
	},
	bind : function() {
	},
	load:function(){
		app.table = $('#bonusMode_xtable').xtable({
			url:adminPath + '/comConfig/findConfig',
			data:{configKey1:"bonus_mode"},
			format:function(row){
				row.btnUpdate = "&nbsp;<a class='xupdate' data-xv='"+row.index+"'>设置</a>&nbsp;";
			},
			update:function(row){
				app.form.setData(row);
				if(row.configKey=="com_coordinate"){
					$("#ditu").show()
				}else{
					$("#ditu").hide()
				}
				if(row.configKey=="com_tishi"){
					$("#textarea").val("")
					$("#textarea").show().val(row.configValue);
					$("#input").hide()
				}else{
					$("#textarea").hide()
					$("#input").show()
				}
				$.log(row);
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
	input:function(){
		$("#textarea").bind("input propertychange",function(event){
			$("#input").val($(this).val())
		})
	}
};