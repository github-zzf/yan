$(function(){
	main.init();
	bind.init();
});
var app = {menu:null,sonMenu:null,load:true}
var sys_menus = null;
var main = {
    openImg:function(msg){
        var width = $(document).width();
        var height = $(document).height();
        var bodyHeight = height - 120;
        msg ='<div class="scroll_img" style="height:'+bodyHeight+'px">'+msg+
            '<span class="xbtn zoomImg">放大</span>'+
            '<span class="xbtn left_scroll">左旋转</span>'+
            '<span class="xbtn right_scroll">右旋转</span>'+
            '<span class="xbtn closeImg">关闭</span></div>';
        var alt = $.xalert({
            title:btn.name,
            msg:msg,
            width:'100%',
            height:height,
            ok:'关闭'
        });
        $(".zoomImg").unbind("click").bind("click",function(){
            var txt = $(this).text();
            if(txt=="放大"){
                $(this).text("还原");
                $(".scroll_img .box_img").addClass("max_img");
            }else{
                $(this).text("放大");
                $(".scroll_img .box_img").removeClass("max_img");
            }
        });
        $(".closeImg").click(function(){
            alt.close();
        });
        var num = 0;
        $(".right_scroll").click(function(){
            num = (num+90)%360;
            $(".scroll_img .box_img")[0].style.transform = 'rotate('+num+'deg)';
        })
        $(".left_scroll").click(function(){
            num = (num+(-90))%-360;
            $(".scroll_img .box_img")[0].style.transform = 'rotate('+num+'deg)';
        })
    },
	init:function(){
		main.loadMenu();
        $(".nav_right").mouseenter(function () {
            $(".nav_box").show();
        });
        $(".btn_right").mouseleave(function () {
            $(".nav_box").hide();
        });
        $("#btn_home").click(function () {
        });
        $("#jx_menu").on('click','.item',function () {
        	var has = $(".jx_center").hasClass("jx_center2")
        	if(!has){
        		$(".jx_center").addClass("jx_center2");
        	}
        });
        $(".jm_left").on('click','.item',function () {
        	$('.item_sel').removeClass('item_sel');
        	$(this).addClass("item_sel");
        	var has = $(".jx_center").hasClass("jx_center2")
        	if(!has){
        		$(".jx_center").addClass("jx_center2");
        	}
        	var index = $(this).data('xv');
			main.createRight(index);
        });
        $(".jm_right").on('click','.item',function () {
    		$(this).toggleClass("open");
        });
        $(".jm_right").on('click','.nav_son',function (e) {
        	e.stopPropagation ? e.stopPropagation() : e.cancelBubble = !0;
        });
        $(".jm_right").on('click','.son_item',function (e) {
        	$(".son_sel").removeClass("son_sel");
    		$(this).toggleClass("son_sel");
        	var url = $(this).data('url');
        	main.openUrl(url);
        });
	},
	loadMenu:function(){
		$.xpost({
			url:adminPath+'/getMenus',
			success:function(e){
				if(e && e.length>0){
					sys_menus = e;
					main.createLeft();
					main.loadUrl();
				}
			}
		})
	},
	createRight:function(index){
		var jm_right = "";
		$.each(sys_menus[index].son,function(i, item){
			jm_right += '<div class="item open" data-url="'+item.url+'">';
			jm_right += '<span class="item_name">'+item.name+'</span>';
			jm_right += '<i class="i_right"></i>';
			if(item.son){
				jm_right += '<div class="nav_son">';
				$.each(item.son,function(si, sitem){
					jm_right += '<div class="son_item" data-url="'+sitem.url+'">';
					jm_right += '<span>'+sitem.name+'</span>';
					jm_right += '</div>';
				})
				jm_right += '</div>';
			}
			jm_right += '</div>';
		})
		$("#jm_right").html(jm_right);
	},
	createLeft:function(){
		var jm_left = "";
		$.each(sys_menus,function(i, item){
			var cls = '';
			if(i==0){
				cls = ' item_sel'
			}
			jm_left += '<div class="item'+cls+'" data-xv='+i+'><div class="item_box">';
			jm_left += '<i><img src="'+item.img+'"></i>';
			jm_left += '<div class="name">'+item.name+'</div>';
			jm_left += '</div></div>';
		})
		$("#jm_left").html(jm_left);
	},
	loadUrl:function(){
		var ths_menu = tools.getCookie('jun_mm_ths_menu');
		if (ths_menu != null && ths_menu != 'null') {
			main.createRight(0);
			main.openUrl(ths_menu);
		} else if (sys_menus != null && sys_menus.length > 0) {
			main.createRight(0);
			if(sys_menus[0].son[0].son){
				var ths_menu = sys_menus[0].son[0].son[0].url;
				main.openUrl(ths_menu);
			}else{
				var ths_menu = sys_menus[0].son[0].url;
				main.openUrl(ths_menu);
			}
		}
	},
	openUrl:function(url){
		tools.setCookie('jun_mm_ths_menu', url);
		document.main_iframe.location.href = adminPath + url;
	}
}
var bind = {
	init:function(){
		bind.logout();
		bind.bindMenuClose();
		bind.bindUpdate();
		bind.message();
	},
	logout:function(){
		$(".xsoft_logout").click(function(){
			$.xget({
				url:adminPath+'/logout',
				success:function(data){
					if(data.code==1){
						window.location.href = adminPath + '/login';
					}else{
						$.xalert({msg:'操作失败！'});
					}
				}
			})
		});
	},
	bindMenuClose:function(){
		$("#btn_menu_close").click(function(){
			var ths = $(this);
			var body = $(".jx_body");
			if(body.hasClass("close")){
				ths.removeClass("move1");
				ths.addClass("move2");
				body.removeClass("close");
			}else{
				ths.removeClass("move2");
				ths.addClass("move1");
				body.addClass("close");
			}
		});
	},
	bindUpdate:function(){
		$('.xsoft_update').click(function(){
			upWin.form.clear();
			upWin.win.open();
		});
	},
	message:function(){
		if(comId != '0'){
			$("#mess_img").show();
			getMassage();
			setInterval(getMassage, 1000);
			$("#mess_img").click(function(){
				main.openUrl('/sysComMsgRecord');
			});
		}else if(comId == '0'){
			$("#mess_img").hide();
		}
	}
}
var tools = {
	setCookie:function(key,value){
		$.cookie(key, value, {expires:7, path:'/'});
	},
	getCookie:function(key){
		return $.cookie(key);
	}
}
function getMassage() {
	$.ajax({
		type:'post',
		async:false,
		url:adminPath + '/sysComMsgRecord/selectMessageNum',
		success : function(e) {
			if(e.code==1){
				if(e.data=="0"){
					$("#message_num").hide();
				}else{
					$("#message_num").html(e.data);
				}
			}else{
				$("#message_num").hide();
			}
		}
	})
}