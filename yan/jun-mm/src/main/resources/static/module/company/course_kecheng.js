$(function(){
	app.init();
})
/**
 * 排课表
 */
var app = {
	init:function(){
		app.bind();
		app.date = new Date();
		app.loadWeek();
	},
	bind : function() {
		$("#sf_courseDate").xdate();
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
			app.form.setData({isWeek:1,isCheck:1});
			app.win.open();
		});
		// 上一周
		$("#btn_week_prve").xbtn(function(){
			app.date.setDate(app.date.getDate()-7);
			app.loadWeek();
		})
		// 下一周
		$("#btn_week_next").xbtn(function(){
			app.date.setDate(app.date.getDate()+7);
			app.loadWeek();
		})
		//课程报名明细
		$("#app_kecheng_xtable").on("click", ".btn_info", function(){
			 var kechengId = $(this).data("xv");
			 var index = $(this).data("xval");
			 var now = $("#app_kecheng_xtable th:eq("+index+")").attr("data-xv");
			 url = adminPath + '/courseEnroll/kc?kechengId='+kechengId+"&now="+now;
			 window.location.href = url;
		})
		//单个修改
		$("#app_kecheng_xtable").on("click", ".btn_edit", function(){
			 var week = $(this).data("week");
			 var index = $(this).data("xval");
			 var row = app.table.getRow(0);
			 var data = row[week][index];
			 app.form.setData(data);
			 app.win.open();
		});
		//单个删除
		$("#app_kecheng_xtable").on("click", ".btn_delete", function(){
			var id = $(this).data("xval");
			$.xalert({msg:"确定要删除这个课程吗？",confirm:true,
				okBack:function(){
					$.xpost({
						url:adminPath + '/course/delete',
						data:{id:id},
						success:function(e){
		                	if (e.code==1){
		                		app.table.reload();
		                		$.ok("删除成功");
		                    } else {
		                    	$.xalert(e.msg);
		                    }
						},
						error:function(){$.xalert({msg:'请求失败！'});}
	                });
				}
			});
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
		$("#btn_isSigen").click(function(){
			window.location.href = adminPath + '/courseEnroll/isSigen';
		});
	},
	loadWeek:function(){
		$("#week_body").empty();
		var week1 = dateUtil.getWeek1(app.date);
		var week7 = dateUtil.getWeek7(app.date);
		var date,week;
		for (var i = 0; i < 7; i++) {
			if(i>0){
				date = dateUtil.addDate(week1,i);
			}else{
				date = week1;
			}
			var arr = date.split("-");
			week = dateUtil.getWeek(date);
			var html = "<th data-xv="+date+">"+week+"<br/>"+arr[1]+"月"+arr[2]+"日</th>";
			$("#week_body").append(html);
		}
		app.loadData(week1,week7);
	},
	loadData:function(startTime,endTime){
		var data = {startTime:startTime,endTime:endTime};
		if(app.table==null){
			app.table = $("#app_kecheng_xtable").xtable({
				url:adminPath + '/course/findWeekKecheng',
				data:data,
				rows:999,
				format:function(row){
					row.weekText1 = app.format(row.week1,"week1",0);
					row.weekText2 = app.format(row.week2,"week2",1);
					row.weekText3 = app.format(row.week3,"week3",2);
					row.weekText4 = app.format(row.week4,"week4",3);
					row.weekText5 = app.format(row.week5,"week5",4);
					row.weekText6 = app.format(row.week6,"week6",5);
					row.weekText7 = app.format(row.week7,"week7",6);
				}
			});
		}else{
			app.table.reload(data);
		}
	},
	format:function(data,week, col){
		var html = "";
		$.each(data, function(index, row) {
			row.cdate = dateUtil.getYmd(row.courseDate);
			row.startTime = row.startTime.substring(0,5);
			row.endTime = row.endTime.substring(0,5);
			html += "<div class='kc_item'>";
			html += "<div>" + row.startTime + "-" + row.endTime + "(" + row.enrollNum + "/" + row.peopleMax + ")</div>";
			html += "<div>" + row.name + "(" + row.teacherName + ")</div>";
			if(hasEdit){
				html += "<div><a class='btn_info' data-xv='"+row.id+"' data-xval='"+col+"'>报名管理</a>&nbsp;";
				html += "&nbsp;<a class='btn_edit' data-week='"+week+"' data-xval='"+index+"'>修改</a>&nbsp;";
				html += "&nbsp;<a class='btn_delete' data-xval='"+row.id+"'>删除</a>&nbsp;</div>";
			}
			html += "</div>";
		})
		return html;
	}
};
var dateUtil = {
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
    getWeek:function(date){
    	var date = new Date(date);
    	var week = date.getDay();
    	return dateUtil.week[week===0?6:week-1];
    },
    //获取周一
    getWeek1:function(date){
    	var nowTime = date.getTime() ; 
    	var day = date.getDay()==0?7:date.getDay();
    	var oneDayLong = 24*60*60*1000 ; 
    	var time = nowTime - (day-1)*oneDayLong; 
    	var week1 = new Date(time);
    	return dateUtil.format(week1);
    },
    //获取周日
    getWeek7:function(date){
    	var nowTime = date.getTime() ; 
    	var day = date.getDay()==0?7:date.getDay();
    	var oneDayLong = 24*60*60*1000 ; 
    	var time = nowTime + (7-day)*oneDayLong; 
    	var week1 = new Date(time);
    	return dateUtil.format(week1);
    },
    format:function(date){
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return  y  + '-' + dateUtil.fill(m) + '-' + dateUtil.fill(d);
    },
    getHm:function(str){
    	return str.substring(10,16);
    },
    getYmd:function(str){
    	return str.substring(0,10);
    },
    fill: function(a) {
    	return 10 > a ? '0' + (0 | a) : a;
    }
}
