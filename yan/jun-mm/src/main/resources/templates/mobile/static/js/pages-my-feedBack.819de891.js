(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-my-feedBack"],{"07ed":function(t,e,i){"use strict";i.r(e);var a=i("d9d7"),n=i("e3e7");for(var o in n)"default"!==o&&function(t){i.d(e,t,function(){return n[t]})}(o);i("1b8a");var s=i("2877"),d=Object(s["a"])(n["default"],a["a"],a["b"],!1,null,"7edd50de",null);e["default"]=d.exports},"1b8a":function(t,e,i){"use strict";var a=i("98d7"),n=i.n(a);n.a},"67ad":function(t,e,i){e=t.exports=i("2350")(!1),e.push([t.i,'uni-page-body[data-v-7edd50de]{background:#f8f8f8}.btn_submit[data-v-7edd50de]{width:90%;margin:%?40?% auto;background:#ffc122;height:%?90?%;border-radius:%?90?%;text-align:center;line-height:%?90?%;color:#fff;font-size:%?36?%}.feed_conten[data-v-7edd50de]{background:#fff;padding-bottom:%?30?%}.feed_box[data-v-7edd50de]{padding:0 %?30?%}.feed_box .flex_start[data-v-7edd50de]{-webkit-box-align:center;-webkit-align-items:center;-ms-flex-align:center;align-items:center}.item_name[data-v-7edd50de]{font-size:%?36?%;color:#333;font-weight:600;width:%?250?%}.item_name2[data-v-7edd50de]{font-size:%?36?%;color:#333;font-weight:600}.radio_box[data-v-7edd50de]{width:%?200?%;display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-align:center;-webkit-align-items:center;-ms-flex-align:center;align-items:center}.radio_box uni-label[data-v-7edd50de]{font-size:%?30?%;color:#333;font-weight:600;margin-top:%?5?%}.radio_right[data-v-7edd50de]{margin-top:%?-3?%;margin-left:%?60?%}.item_box[data-v-7edd50de]{padding:%?30?% 0}.word_num[data-v-7edd50de]{font-size:%?32?%;color:#ccc}.textarea_box[data-v-7edd50de]{height:%?280?%;background:#f2f2f2;border-radius:%?10?%;padding:%?20?%}.texcontent[data-v-7edd50de]{background:none;color:#ababab;font-size:%?32?%}.item_img_box[data-v-7edd50de]{display:-webkit-box;display:-webkit-flex;display:-ms-flexbox;display:flex;-webkit-box-pack:start;-webkit-justify-content:flex-start;-ms-flex-pack:start;justify-content:flex-start;-webkit-flex-wrap:wrap;-ms-flex-wrap:wrap;flex-wrap:wrap}.img_item[data-v-7edd50de]{width:%?130?%;height:%?130?%;border-radius:%?5?%;overflow:hidden;margin-right:%?30?%;margin-bottom:%?20?%}.img[data-v-7edd50de]{width:100%;height:100%}[data-v-7edd50de] uni-radio .uni-radio-input.uni-radio-input-checked:before{font:none;content:"";color:#fff;font-size:18px;position:absolute;top:50%;left:50%;-ms-transform:translate(-50%,-48%) scale(.73);transform:translate(-50%,-48%) scale(.73);-webkit-transform:translate(-50%,-48%) scale(.73)}[data-v-7edd50de] uni-radio .uni-radio-input{-webkit-appearance:none;-moz-appearance:none;appearance:none;margin-right:5px;outline:0;border:none;background-color:#fff;border-radius:50%;width:12px;height:12px;position:relative;margin:3px}[data-v-7edd50de] uni-radio .uni-radio-wrapper{border:1px solid #bfbfbf;border-radius:50%;margin-right:%?10?%}body.?%PAGE?%[data-v-7edd50de]{background:#f8f8f8}',""])},"7fc5":function(t,e,i){"use strict";var a=i("288e");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("ac6a");var n=a(i("cebc")),o=i("2f62"),s={data:function(){return{items:[{value:"1",name:"问题反馈",checked:"true"},{value:"0",name:"投诉"}],current:1,imgList:[],count:[1,2,3,4],content:"",temp:!1}},computed:(0,o.mapState)(["forcedLogin","hasLogin","userName"]),methods:(0,n.default)({},(0,o.mapMutations)(["login"]),{radioChange:function(t){this.current=t.detail.value},submit:function(){var t=this;if(""==this.content)return uni.showToast({title:"请描述您的问题",icon:"none"}),!1;this.temp||(this.temp=!0,this.$http.request({url:"/m/saveFeedback",data:{type:this.current,content:this.content}}).then(function(e){if(1==e.data.code){var i=e.data.data;t.imgList.length>0&&t.imgList.forEach(function(e){t.$http.upload("/m/saveFeedbackImg",{name:"files",filePath:e,formData:{id:i}}).then(function(e){1==e.data.code&&(t.imgList=[],t.content=""),t.temp=!1}).catch(function(e){uni.showToast({title:"提交失败",icon:"none"}),t.temp=!1})}),t.$msgbox({title:"信息提示",html:'<p style="text-align: center;">您已提交成功</p>'}),t.temp=!1,t.content=""}}).catch(function(e){t.temp=!1}))},touchstart:function(t){var e=this;clearInterval(this.Loop),this.Loop=setTimeout(function(){uni.showModal({title:"删除",content:"请问要删除这个图片吗？",success:function(i){i.confirm?e.imgList=e.imgList.splice(0,t):i.cancel&&console.log("用户点击取消")}})}.bind(this),1e3)},touchend:function(){clearInterval(this.Loop)},chooseImage:function(){var t=this;uni.chooseImage({count:4,sizeType:["original","compressed"],sourceType:["album"],success:function(e){t.imgList=t.imgList.concat(e.tempFilePaths)}})},previewImage:function(t){var e=t.target.dataset.src;uni.previewImage({current:e,urls:this.imgList})}}),onLoad:function(){if(!this.hasLogin){var t=this;this.$weixin.loginBack(function(){t.login()})}this.$loadingHiden()}};e.default=s},"98d7":function(t,e,i){var a=i("67ad");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var n=i("4f06").default;n("1ee3452c",a,!0,{sourceMap:!1,shadowMode:!1})},d9d7:function(t,e,i){"use strict";var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",{},[i("v-uni-view",{staticClass:"feed_conten"},[i("v-uni-view",{staticClass:"feed_box"},[i("v-uni-view",{staticClass:"flex_start item_box"},[i("v-uni-view",{staticClass:"item_name"},[t._v("类型：")]),i("v-uni-radio-group",{staticClass:"radio_right  flex_start",on:{change:function(e){e=t.$handleEvent(e),t.radioChange(e)}}},t._l(t.items,function(e,a){return i("v-uni-view",{key:e.value,staticClass:"radio_box"},[i("v-uni-radio",{attrs:{value:e.value,checked:e.value==t.current,color:"#bfbfbf"}}),i("v-uni-label",[t._v(t._s(e.name))])],1)}),1)],1),i("v-uni-view",{staticClass:"flex_space item_box"},[i("v-uni-view",{staticClass:"item_name"},[t._v("内容：")]),i("v-uni-view",{staticClass:"word_num"},[t._v("200字以内")])],1),i("v-uni-view",{staticClass:"textarea_box"},[i("v-uni-textarea",{staticClass:"texcontent",staticStyle:{width:"98%"},attrs:{value:"","placeholder-style":"color:#cccccc;font-size:32upx",maxlength:"200",placeholder:"请描述您的问题~"},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}})],1),i("v-uni-view",{staticClass:"item_box"},[i("v-uni-view",{staticClass:"item_name2"},[t._v("上传图片（"+t._s(t.imgList.length)+"/4）")])],1),i("v-uni-view",{staticClass:"item_img_box"},[t._l(t.imgList,function(e,a){return i("v-uni-view",{key:a,staticClass:"img_item",on:{touchstart:function(e){e.stopPropagation(),e=t.$handleEvent(e),t.touchstart(a)},touchend:function(e){e.stopPropagation(),e=t.$handleEvent(e),t.touchend(e)}}},[i("v-uni-image",{staticClass:"img",attrs:{src:e,mode:"aspectFill","data-src":e},on:{click:function(e){e.stopPropagation(),e=t.$handleEvent(e),t.previewImage(e)}}})],1)}),t.imgList.length<4?i("v-uni-view",{staticClass:"img_item",on:{click:function(e){e=t.$handleEvent(e),t.chooseImage(e)}}},[i("v-uni-image",{staticClass:"img",attrs:{src:"../../static/img/add_img2.png",mode:"aspectFill"}})],1):t._e()],2)],1)],1),i("v-uni-view",{staticClass:"btn_submit",on:{click:function(e){e=t.$handleEvent(e),t.submit(e)}}},[t._v("提  交")])],1)},n=[];i.d(e,"a",function(){return a}),i.d(e,"b",function(){return n})},e3e7:function(t,e,i){"use strict";i.r(e);var a=i("7fc5"),n=i.n(a);for(var o in a)"default"!==o&&function(t){i.d(e,t,function(){return a[t]})}(o);e["default"]=n.a}}]);