$(function() {
	login.init();
});
var login = {
	form: null,
	init: function() {
		login.loadFrom();
        login.getCookie();
		//Enter事件
        $('#password').keyup(function(e){
        	if(e.keyCode===13){
        		login.form.submit();
        	}
        });
	},
	loadFrom: function() {
		login.form = $('#login_from').xform({
			url: adminPath + '/login',
			xbtn: '#submit',
			xcheck: [
			    {label: '账号',name: 'username',xcheck: 'null,length:1:20',msgBox:'.errors'}, 
			    {label: '密码',name: 'password',xcheck: 'null,length:1:20',msgBox:'.errors'}
			],
			submitBefore: function() {
				$('#login_from').find('.error').remove();
			},
			success: function(data) {
				$.cookie("jun_mm_ths_menu", null, {expires:7, path:'/'});
				if (data.code == 1) {
		        	var username=$('#username').val();
					var password=$('#password').val();
    		        login.setCookie(username);
    		        window.location.href = adminPath +'/index';
					
				} else if(data.code == 2) {
					$(".errors").html("账户或登录密码不正确").show();
				} else {
					$(".errors").html("登录异常").show();
				}
			}
		});
	},
	
	
	
	getCookie:function(){
    	var username = $.cookie('jun_mm_user');
    	if(username!=null&&username!="null"){
    		$("#username").val(username);
    		$("#logincheckbox").attr("checked","checked");
    	}
    },
    setCookie:function(username){
    	if($("#logincheckbox").is(':checked')){
    		$.cookie('jun_mm_user', username, {expires:7, path:'/'});
    	}else{
    		$.cookie('jun_mm_user', null, {path:'/'});
    	}
    }
}