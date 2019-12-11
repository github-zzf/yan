$.fn.xsearch = function(options){
	var ths = this;
	if(ths.length===0){$.logError('search Unable to read element '+ths.selector);return;}
	var xfn = $(ths.selector).data(ths.selector);
	if(xfn){ return xfn; }
	var defaults = {
		url:null,
		xdata:[],
		text:null,
		width:null,
		height:null,
		relation:null,
		clear:true,
		valBox:null,
		valText:'id',
		back:function(){}
	}
	var ops = $.extend(defaults,options,{
		body:null,
		input:null,
		tpl:null,
		timeoutid:null
	});
	var inside = {
		init:function(){
			inside.template();
			inside.bind();
		},
		template:function(){
			ops.tpl = $('<ul class="search_ul"></ul>').insertAfter(ths);
		},
		bind:function(){
			ths.click(function(){
				if(ops.clear){
					ths.val('');
					$(ops.valBox).val('');
				}
				inside.load();
			})
			ths.keyup(function(event) {
				if(event.keyCode > 40 || event.keyCode == 8 || event.keyCode == 32) {
					ops.tpl.empty().hide();
					clearTimeout(ops.timeoutid);
					ops.timeoutid = setTimeout(inside.load, 100);
				} else if(event.keyCode == 38) {
					if(ops.selectedItem == -1) {
						inside.setSelectedItem(ops.tpl.find('li').length - 1);
					} else {
						inside.setSelectedItem(ops.selectedItem - 1);
					}
					event.preventDefault();
				} else if(event.keyCode == 40) {
					if(ops.selectedItem == -1) {
						inside.setSelectedItem(0);
					} else {
						inside.setSelectedItem(ops.selectedItem + 1);
					}
					event.preventDefault();
				}
			})
			.keypress(function(event) {
				if(event.keyCode == 13) {
					if(ops.tpl.find('li').length == 0 || ops.selectedItem == -1) {
						return;
					}
					ths.val(ops.tpl.find('li').eq(ops.selectedItem).text());
					ops.tpl.empty().hide();
					event.preventDefault();
				}
			})
			.keydown(function(event) {
				if(event.keyCode == 27) {
					ops.tpl.empty().hide();
					event.preventDefault();
				}
			});
			$(window).resize(function() {
				var ypos = ths.position().top + ths.outerHeight();
				var xpos = ths.position().left;
				ops.tpl.css({'width': ths.outerWidth(), 'left': xpos + "px", 'top': ypos + "px" });
			});
			$(document).click(function(){
				ops.tpl.empty().hide();
			});
		},
		load:function(){
			if(ops.url){
				var data = {search:ths.val()};
				if(ops.relation!=null){
					var name = $(ops.relation).prop("name");
					var relation = {};
					relation[name] = $(ops.relation).val();
					data = $.extend(data, relation); 
				}
				$.ajax({
					url:ops.url,
					data:data,
					type:'POST',
					dataType:'json',
					success:inside.success,
					error:inside.error
				});
			}else if(ops.xdata){
				inside.draw(ops.xdata);
			}else{
			}
		},
		success:function(data){
			ops.xdata = data;
			inside.draw(data);
		},
		draw:function(){
        	ops.tpl.empty();
			$.each(ops.xdata, function(index, item) {
				var html = $.xtemplate(ops.text, item);
				var li = $('<li class="item"></li>').text(html).appendTo(ops.tpl);
				li.hover(function() {
					$(this).siblings().removeClass('selected');
					$(this).addClass('selected');
					ops.selectedItem = index;
				}, function() {
					$(this).removeClass('selected');
					ops.selectedItem = -1;
				}).click(function() {
					$(ops.valBox).val(item[ops.valText]);
					ths.val(html);
					ops.tpl.empty().hide();
					ops.back(item.id,item);
				});
			}); 
			var ypos = ths.position().top + ths.outerHeight();
			var xpos = ths.position().left;
			ops.tpl.css({'width': ths.outerWidth(), 'left': xpos + "px", 'top': ypos + "px" });
			inside.setSelectedItem(0);
			ops.tpl.show();
		},
		setSelectedItem:function(item){
			ops.selectedItem = item;
			if(ops.selectedItem < 0) {
				ops.selectedItem = ops.tpl.find('li').length - 1;
			} else if(ops.selectedItem > ops.tpl.find('li').length - 1) {
				ops.selectedItem = 0;
			}
			ops.tpl.find('li').removeClass('selected').eq(ops.selectedItem).addClass('selected');
		},
		error:function(e){
			$.error('数据加载失败！')
		},
		call:function(){
			if(ops.success){
        		ops.success();
        	}
		},
		itemClick:function(item){
			var xv = $(item).data('xv');
			var index = $(item).data('index');
			var text = $(item).html();
			ths.find('input[type = hidden]').val(xv);
			ths.find('.xtext').html(text);
			ths.find('li').removeClass('selected');
			$(item).addClass('selected');
			if(ops.change){ops.change(xv,text,ops.xdata[index]);}
		},
		clear : function() {
			ths.val("");
			ops.tpl.empty();
			ops.tpl.hide();
		}
	}
	var xcombo = function(){
		inside.init();
	}
	var combo = new xcombo();		
	var outside = {
		clear : function() {
			inside.clear();
		}
	}
	$.extend(combo,outside);
	$(ths.selector).data(ths.selector,combo);
	return combo;
}
