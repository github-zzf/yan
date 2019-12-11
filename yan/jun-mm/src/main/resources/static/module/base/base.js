var base = {
	//测试数据
	xdata : {"total":32,"list":[
    	{id:'1',name:"小米4",checkState:1},
    	{id:'2',name:"红米Note",checkState:2},
    	{id:'3',name:"九号平衡车",checkState:3},
    	{id:'4',name:"小米Note",checkState:1},
    	{id:'5',name:"小米4",checkState:2},
    	{id:'6',name:"红米Note",checkState:3},
    	{id:'7',name:"九号平衡车",checkState:2},
    	{id:'8',name:"小米Note",checkState:3}
    ]},
    xinfo:{
    	id:'1',
    	name:'名字'
    },
	download:function(url){
		top.window.frames['downloadIframe'].location.href = url;
	},
	getData:function(){
		return baseDate.getYmd(new Date());
	},
	getOnoff:function(id, state, cls){
		var html = "<div class='checkbox_random'>";
		if (state=="1") {
			// 允许
			html += "<input type='checkbox' id='"+cls+id+"' class='"+cls+" btn_check' data-type='"+cls+"'   data-xv='"+id+"' checked />"
		}else{
			// 不允许
			html += "<input type='checkbox' id='"+cls+id+"' class='"+cls+" btn_check' data-type='"+cls+"'   data-xv='"+id+"'/>"
		}
		html+="<label for='"+cls+id+"'></label>"
		html+="</div>"
		return html;
	},
	toFixed:function(num){
		if(String(num).indexOf(".")==-1){
			return num;
		}
		return num.toFixed(2);
	},
	bindDays:function(){
		var now = new Date();
		$("#sf_day").click(function(){
			$(".sf_date").prop('checked',false);
			$(this).prop('checked',true);
			var date = baseDate.getYmd(now);
			$("#startTime").val(date);
			$("#endTime").val(date);
		});
		$("#sf_day").trigger("click");
		$("#sf_week").click(function(){
			$(".sf_date").prop('checked',false);
			$(this).prop('checked',true);
			var date1 = baseDate.getWeek1(now);
			var date2 = baseDate.getWeek7(now);
			$("#startTime").val(date1);
			$("#endTime").val(date2);
		});
		$("#sf_month").click(function(){
			$(".sf_date").prop('checked',false);
			$(this).prop('checked',true);
			var date1 = baseDate.getMonthDay1(now);
			var date2 = baseDate.getMonthDays(now);
			$("#startTime").val(date1);
			$("#endTime").val(date2);
		});
		$("#sf_year").click(function(){
			$(".sf_date").prop('checked',false);
			$(this).prop('checked',true);
			var date1 = baseDate.getYearDay1(now);
			var date2 = baseDate.getYearDays(now);
			$("#startTime").val(date1);
			$("#endTime").val(date2);
		});
	},
	ratio:function(a, b){ 
		if(a==0 || b==0){
			return "0";
		}
		var ratio = (Number(a) / Number(b) * 100).toFixed(2); 
		return ratio == 0 ? 0 : ratio;
	},
	subDate:function(str){
		if(str){
			return str.substring(0,10);
		}
		return str;
	}
}

var baseDate = {
	week:["星期一","星期二","星期三","星期四","星期五","星期六","星期日"],
	addDate:function(date, days) {
        if (days == undefined || days == '') {
            days = 1;
        }
        var date = new Date(date);
        date.setDate(date.getDate() + days);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
		return  y  + '-' + dateUtil.fill(m) + '-' + dateUtil.fill(d);
    },
    getYmd:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return  y  + '-' + baseDate.fill(m) + '-' + baseDate.fill(d);
    }
	,getWeek:function(date){
    	var date = new Date(date);
    	var week = date.getDay();
    	return baseDate.week[week===0?6:week-1];
    }
    //获取周一
    ,getWeek1:function(date){
    	var nowTime = date.getTime() ; 
    	var day = date.getDay()==0?7:date.getDay();
    	var oneDayLong = 24*60*60*1000 ; 
    	var time = nowTime - (day-1)*oneDayLong; 
    	var week1 = new Date(time);
    	return baseDate.getYmd(week1);
    }
    //获取周日
    ,getWeek7:function(date){
    	var nowTime = date.getTime() ; 
    	var day = date.getDay()==0?7:date.getDay();
    	var oneDayLong = 24*60*60*1000 ; 
    	var time = nowTime + (7-day)*oneDayLong; 
    	var week1 = new Date(time);
    	return baseDate.getYmd(week1);
    }
    //获取本月1号
    ,getMonthDay1:function(date){
		var y = date.getFullYear();
		var m = date.getMonth();
    	return baseDate.getYmd(new Date(y, m, 1));
    }
    //获取本月max号
    ,getMonthDays:function(date){
		var y = date.getFullYear();
		var m = date.getMonth();
		var d = new Date(y, m+1, 0).getDate();
    	return baseDate.getYmd(new Date(y, m, d));
    }
    //获取本年1号
    ,getYearDay1:function(date){
		var y = date.getFullYear();
    	return baseDate.getYmd(new Date(y, 0, 1));
    }
    //获取本月max号
    ,getYearDays:function(date){
		var y = date.getFullYear();
    	return baseDate.getYmd(new Date(y, 11, 31));
    },
    fill: function(a) {
    	return 10 > a ? '0' + (0 | a) : a;
    },
	addDate: function(d,i){
		if(!(d instanceof Date)){
			d = this.getDate(d);
		}
		d.setDate(d.getDate()+parseInt(i));
    	return d;
	},
	//获取两个时间的差值
	spaceDate:function(startDate, endDate){
		startDate = baseDate.toDate(startDate);
		endDate = baseDate.toDate(endDate);
		var date = null;
		if(endDate >= startDate){
			date = endDate.getTime()-startDate.getTime();
		}else{
			date = startDate.getTime()-endDate.getTime();
		}
		return Math.floor(date/(1000 * 60 * 60 * 24))+1;
	},
	toDate:function(d){
		if(!(d instanceof Date)){
			d = this.getDate(d);
		}
		return d;
	},
	getDate : function(str) {
		var d = str.split("-");
		return new Date(d[0], d[1] - 1, d[2]);
	},
	getYear : function(date) {
		var y = date.getFullYear();
		return  y;
	},
	getMonth : function(date) {
		var m = date.getMonth() + 1;
		return  baseDate.fill(m);
	},
    getYm:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		return  y  + '-' + baseDate.fill(m);
    }
}
