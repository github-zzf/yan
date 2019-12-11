/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : 192.168.0.200:3306
Source Database       : jun_mm

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-11-18 17:42:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cash_buy
-- ----------------------------
DROP TABLE IF EXISTS `cash_buy`;
CREATE TABLE `cash_buy` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `money` varchar(255) DEFAULT NULL COMMENT '应付金额',
  `ratio` decimal(10,1) DEFAULT NULL COMMENT '折扣比例',
  `type` char(1) DEFAULT NULL COMMENT '消费类型(1消费收银、2储值扣费、3会员储值)',
  `pay_type` char(2) DEFAULT NULL COMMENT '支付方式（1现金、2微信、3支付宝、4刷卡、11储值扣费）',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `points` decimal(10,2) DEFAULT '0.00' COMMENT '积分',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费记录';

-- ----------------------------
-- Records of cash_buy
-- ----------------------------
INSERT INTO `cash_buy` VALUES ('1195155973295620096', 'zhao', '1191218086037643264', '120', null, '1', '1', '22.00', '2.00', null, '0', 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04');

-- ----------------------------
-- Table structure for cash_buy_card
-- ----------------------------
DROP TABLE IF EXISTS `cash_buy_card`;
CREATE TABLE `cash_buy_card` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `buy_id` varchar(32) DEFAULT NULL COMMENT '消费记录主键',
  `card_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `money` decimal(10,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费明细';

-- ----------------------------
-- Records of cash_buy_card
-- ----------------------------
INSERT INTO `cash_buy_card` VALUES ('1194552449654165504', null, '1194552449620611072', '1189720213773475840', '12.00', '1', '12.00');
INSERT INTO `cash_buy_card` VALUES ('1194843753289064448', null, '1194843753045794816', '1189720213773475840', '12.00', '1', '12.00');
INSERT INTO `cash_buy_card` VALUES ('1194843906628624384', null, '1194843906486018048', '1189720213773475840', '12.00', '1', '12.00');
INSERT INTO `cash_buy_card` VALUES ('1194844084534222848', null, '1194844084416782336', '1189720213773475840', '12.00', '1', '12.00');
INSERT INTO `cash_buy_card` VALUES ('1194844495631847424', null, '1194844495371800576', '1189720213773475840', '12.00', '1', '12.00');
INSERT INTO `cash_buy_card` VALUES ('1195155973798936576', null, '1195155973295620096', '1184664162535550976', '100.00', '1', '100.00');

-- ----------------------------
-- Table structure for cash_buy_goods
-- ----------------------------
DROP TABLE IF EXISTS `cash_buy_goods`;
CREATE TABLE `cash_buy_goods` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `buy_id` varchar(32) DEFAULT NULL COMMENT '消费记录主键',
  `goods_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `money` decimal(10,2) DEFAULT NULL COMMENT '总价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费明细';

-- ----------------------------
-- Records of cash_buy_goods
-- ----------------------------
INSERT INTO `cash_buy_goods` VALUES ('1194552449649971200', null, '1194552449620611072', '1183232183269470208', '1.00', '1', '1.00');
INSERT INTO `cash_buy_goods` VALUES ('1194843753217761280', null, '1194843753045794816', '1183232183269470208', '1.00', '1', '1.00');
INSERT INTO `cash_buy_goods` VALUES ('1194843906599264256', null, '1194843906486018048', '1183232183269470208', '1.00', '1', '1.00');
INSERT INTO `cash_buy_goods` VALUES ('1194844084513251328', null, '1194844084416782336', '1183232183269470208', '1.00', '1', '1.00');
INSERT INTO `cash_buy_goods` VALUES ('1194844495573127168', null, '1194844495371800576', '1183232183269470208', '1.00', '1', '1.00');
INSERT INTO `cash_buy_goods` VALUES ('1195155973710856192', null, '1195155973295620096', '1191177074818289664', '20.00', '1', '20.00');

-- ----------------------------
-- Table structure for cash_buy_user
-- ----------------------------
DROP TABLE IF EXISTS `cash_buy_user`;
CREATE TABLE `cash_buy_user` (
  `id` varchar(32) NOT NULL COMMENT '自增id',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `buy_id` varchar(32) DEFAULT NULL COMMENT '消费记录主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '提成用户id',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '销售金额',
  `goods_money` decimal(10,2) DEFAULT NULL COMMENT '商品金额',
  `card_money` decimal(10,2) DEFAULT NULL COMMENT '会员卡金额',
  `ratio` int(11) DEFAULT NULL COMMENT '分成比例',
  `ratio_user` int(11) DEFAULT NULL COMMENT '员工消费项目提成比例',
  `card_ratio_user` int(11) DEFAULT NULL COMMENT '员工会员卡提成比例',
  `money` decimal(14,2) DEFAULT NULL COMMENT '提成金额',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费提成比例';

-- ----------------------------
-- Records of cash_buy_user
-- ----------------------------

-- ----------------------------
-- Table structure for cash_money
-- ----------------------------
DROP TABLE IF EXISTS `cash_money`;
CREATE TABLE `cash_money` (
  `id` varchar(32) NOT NULL,
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `biz_id` varchar(30) DEFAULT NULL COMMENT '业务主键',
  `biz_type` varchar(30) DEFAULT NULL COMMENT '业务类型',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `type` char(1) DEFAULT NULL COMMENT '消费类型(1消费收银、2储值扣费、3储次扣费、4线上支付)',
  `buy_type` char(2) DEFAULT NULL COMMENT ' 购买类型(11消费项目、12会员卡、13活动、41消费项目、42会员卡、43活动)',
  `pay_type` char(1) DEFAULT NULL COMMENT '支付方式（1现金、2微信、3支付宝、4刷卡）',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售金额';

-- ----------------------------
-- Records of cash_money
-- ----------------------------
INSERT INTO `cash_money` VALUES ('1195155973782159360', 'zhao', '1195155973295620096', 'cash_buy', '20.00', '1', '11', '1', '0', 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04', null);
INSERT INTO `cash_money` VALUES ('1195155973861851136', 'zhao', '1195155973295620096', 'cash_buy', '100.00', '1', '12', '1', '0', 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04', null);
INSERT INTO `cash_money` VALUES ('1195156052597325824', 'zhao', '1195156052576354304', 'member_card_change', '1.00', '2', null, null, '0', 'zhao_I95W', '2019-11-15 09:46:23', 'zhao_I95W', '2019-11-15 09:46:23', null);
INSERT INTO `cash_money` VALUES ('1196231502033453056', 'zhao', '1196231501978927104', 'member_card_change', '2.00', '2', null, null, '0', 'zhao_I95W', '2019-11-18 08:59:50', 'zhao_I95W', '2019-11-18 08:59:50', null);

-- ----------------------------
-- Table structure for cms_articles
-- ----------------------------
DROP TABLE IF EXISTS `cms_articles`;
CREATE TABLE `cms_articles` (
  `id` varchar(32) NOT NULL COMMENT '文章id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `type_id` varchar(32) NOT NULL DEFAULT '0' COMMENT '栏目ID',
  `sort` int(10) unsigned DEFAULT NULL COMMENT '文章排序',
  `title` char(60) NOT NULL DEFAULT '' COMMENT '文章标题',
  `body` mediumtext COMMENT '内容',
  `img` char(100) NOT NULL DEFAULT '' COMMENT '封面图片',
  `send_time` datetime DEFAULT NULL COMMENT '发布日期',
  `clicks` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '点击次数',
  `status` char(1) DEFAULT '6' COMMENT '状态（0正常、6草稿、9删除）',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `sortrank` (`sort`),
  KEY `mainindex` (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of cms_articles
-- ----------------------------
INSERT INTO `cms_articles` VALUES ('1191187357569441792', 'zhao', '1191187312824606720', '21', '21', '<div>12</div>', 'http://file.junkj.com/upload/201910/1186114440771538944.jpg', '2019-11-04 10:56:12', '0', '6', 'zhao_I95W', '2019-11-04 10:56:12', 'zhao_I95W', '2019-11-04 10:56:12');

-- ----------------------------
-- Table structure for cms_arttype
-- ----------------------------
DROP TABLE IF EXISTS `cms_arttype`;
CREATE TABLE `cms_arttype` (
  `id` varchar(32) NOT NULL COMMENT '栏目ID',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `type_type` char(1) DEFAULT NULL COMMENT '栏目类型',
  `type_name` varchar(32) DEFAULT NULL COMMENT '栏目名称',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='栏目表';

-- ----------------------------
-- Records of cms_arttype
-- ----------------------------
INSERT INTO `cms_arttype` VALUES ('1187929490989260800', '0', '3', '移动端', '0', '0,', '1', '00000001,', '0', '0', '移动端', null, 'junAdmin', '2019-10-26 11:10:36', 'junAdmin', '2019-10-26 11:10:36');
INSERT INTO `cms_arttype` VALUES ('1187978996477251584', '0', '4', '品牌介绍', '1187929490989260800', '0,1187929490989260800,', '3', '00000001,00000003', '1', '1', '移动端/品牌介绍', null, 'junAdmin', '2019-10-26 14:27:19', 'junAdmin', '2019-10-26 14:27:19');
INSERT INTO `cms_arttype` VALUES ('1189086553948631040', '0', '1', '宝马教学', '1187929490989260800', '0,1187929490989260800,', '4', '00000001,00000004', '0', '1', '移动端/宝马教学', '强无敌42452', 'junAdmin', '2019-10-29 15:48:21', 'junAdmin', '2019-10-29 16:14:25');
INSERT INTO `cms_arttype` VALUES ('1191187312824606720', 'zhao', '1', '12', '0', '0,', '1', '00000001,', '1', '0', '12', null, 'zhao_I95W', '2019-11-04 10:56:01', 'zhao_I95W', '2019-11-04 10:56:01');

-- ----------------------------
-- Table structure for com_activity
-- ----------------------------
DROP TABLE IF EXISTS `com_activity`;
CREATE TABLE `com_activity` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `status` char(1) DEFAULT NULL COMMENT '状态（0未开始、1报名中、2报名结束、3活动结束、4活动取消、6草稿）',
  `pay_status` char(1) DEFAULT '3' COMMENT '支付方式（1在线支付、2到店支付、3不限）',
  `name` varchar(30) DEFAULT NULL COMMENT '活动名称',
  `img` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `enroll_start` datetime DEFAULT NULL COMMENT '报名开始时间',
  `enroll_end` datetime DEFAULT NULL COMMENT '报名结束时间',
  `address` varchar(200) DEFAULT NULL COMMENT '活动地址',
  `coordinate` varchar(50) DEFAULT NULL COMMENT '经纬度',
  `content` longtext COMMENT '活动详情',
  `people_max` int(11) DEFAULT NULL COMMENT '报名上限',
  `money` decimal(10,2) DEFAULT '0.00' COMMENT '活动费',
  `give_points` int(11) DEFAULT '0' COMMENT '赠送积分',
  `cards_type_id` varchar(32) DEFAULT NULL COMMENT '会员卡分类',
  `card_num` decimal(10,2) DEFAULT '0.00' COMMENT '消耗数值',
  `clicks` int(11) DEFAULT '0' COMMENT '浏览数量',
  `goods` int(11) DEFAULT '0' COMMENT '点赞数量',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动';

-- ----------------------------
-- Records of com_activity
-- ----------------------------
INSERT INTO `com_activity` VALUES ('1191186609288830976', 'zhao', '1', '1', '3', 'http://file.junkj.com/upload/201911/1191177071274102784.jpg', '2019-11-09 08:42:06', '2019-11-30 08:42:07', '2019-11-08 08:42:09', '2019-11-30 08:42:11', '2', '2', '<div>2</div>', '2', '2.00', '2', '1177423738750693376', '0.00', '0', '0', 'zhao_I95W', '2019-11-04 10:53:13', 'zhao_I95W', '2019-11-04 10:53:13');
INSERT INTO `com_activity` VALUES ('1191186775098056704', 'zhao', '1', '1', '2', 'http://file.junkj.com/upload/201910/1186114440771538944.jpg', '2019-11-09 08:42:06', '2019-11-30 08:42:07', '2019-11-08 08:42:09', '2019-11-30 08:42:11', '2', '2', '<div>2</div>', '2', '2.00', '2', '1177423738750693376', '0.00', '0', '0', 'zhao_I95W', '2019-11-04 10:53:53', 'zhao_I95W', '2019-11-04 10:53:53');
INSERT INTO `com_activity` VALUES ('1192357026762240000', '0', '1', '3', '活动', 'http://file.junkj.com/upload/201910/1186148784568455168.jpg', '2019-11-09 08:42:06', '2019-11-30 08:42:07', '2019-11-08 08:42:09', '2019-11-30 08:42:11', '1', '1', '<div>1</div>', '1', '1.00', '1', '', '0.00', '0', '0', 'junAdmin', '2019-11-07 16:24:03', 'junAdmin', '2019-11-07 16:24:03');
INSERT INTO `com_activity` VALUES ('1193050546166767616', 'cheng', '3', '1', '1', 'http://file.junkj.com/upload/201910/1187290342987247616.jpg', '2019-11-09 14:19:41', '2019-11-09 14:19:43', '2019-11-09 14:19:44', '2019-11-09 14:19:46', '1', '1', '<div>1</div>', '4', '1.00', '1', '', '0.00', '0', '0', 'cheng_4KGX', '2019-11-09 14:19:51', 'cheng_4KGX', '2019-11-09 14:34:21');
INSERT INTO `com_activity` VALUES ('1193089570874490880', 'cheng', '9', '1', '1', null, '2019-11-09 16:54:44', '2019-11-09 16:54:45', '2019-11-09 16:54:47', '2019-11-09 16:54:48', '1', '1', '<div>1</div>', '1', '1.00', '1', null, '0.00', '0', '0', 'cheng_4KGX', '2019-11-09 16:54:55', 'cheng_4KGX', '2019-11-09 16:54:55');

-- ----------------------------
-- Table structure for com_activity_enroll
-- ----------------------------
DROP TABLE IF EXISTS `com_activity_enroll`;
CREATE TABLE `com_activity_enroll` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `activity_id` varchar(32) DEFAULT NULL COMMENT '活动id',
  `member_id` varchar(32) DEFAULT NULL COMMENT '报名用户',
  `enroll_status` char(1) DEFAULT '0' COMMENT '状态（0、正常 1、取消、4等位）',
  `enroll_time` datetime DEFAULT NULL COMMENT '报名日期',
  `wait_num` int(11) DEFAULT NULL COMMENT '等位编号',
  `is_sign` char(1) DEFAULT '0' COMMENT '是否签到（0没签到、1已签到）',
  `sign_time` datetime DEFAULT NULL COMMENT '签到时间',
  `pay_state` varchar(2) DEFAULT NULL COMMENT '支付状态（1、待支付 2、已支付）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动报名';

-- ----------------------------
-- Records of com_activity_enroll
-- ----------------------------
INSERT INTO `com_activity_enroll` VALUES ('1193053443741585408', 'cheng', '1193050546166767616', '1192985670917238784', '0', '2019-11-09 14:31:20', null, '0', null, null);
INSERT INTO `com_activity_enroll` VALUES ('1193053459226955776', 'cheng', '1193050546166767616', '1193049208589189120', '0', '2019-11-09 14:31:24', null, '0', null, null);
INSERT INTO `com_activity_enroll` VALUES ('1193053478181015552', 'cheng', '1193050546166767616', '1193049224326217728', '0', '2019-11-09 14:31:27', null, '0', null, null);
INSERT INTO `com_activity_enroll` VALUES ('1193053498951208960', 'cheng', '1193050546166767616', '1193049235327877120', '0', '2019-11-09 14:31:34', null, '0', null, null);
INSERT INTO `com_activity_enroll` VALUES ('1193053515141222400', 'cheng', '1193050546166767616', '1193049246358896640', '4', '2019-11-09 14:31:37', '1', '0', null, null);
INSERT INTO `com_activity_enroll` VALUES ('1193053535894638592', 'cheng', '1193050546166767616', '1195538778730991616', '4', '2019-11-09 14:31:43', '2', '0', null, null);

-- ----------------------------
-- Table structure for com_album
-- ----------------------------
DROP TABLE IF EXISTS `com_album`;
CREATE TABLE `com_album` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `name` varchar(15) DEFAULT NULL COMMENT '相册名称',
  `img` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `clicks` int(11) DEFAULT '0' COMMENT '浏览量',
  `remark` varchar(500) DEFAULT NULL COMMENT '相册描述',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0未删，9已删）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='相册';

-- ----------------------------
-- Records of com_album
-- ----------------------------
INSERT INTO `com_album` VALUES ('1185366032435970048', '0', '订单', '/upload/201910/1185476258174251008.png', '0', '123', 'junAdmin', '2019-10-19 09:24:20', 'junAdmin', '2019-10-22 11:34:37', '0');
INSERT INTO `com_album` VALUES ('1185366528578916352', '0', '搜索', '/upload/201910/1186485877780557824.png', '0', '321', 'junAdmin', '2019-10-19 09:26:18', 'junAdmin', '2019-10-22 11:34:24', '0');
INSERT INTO `com_album` VALUES ('1185441900109336576', '0', '舞蹈', '/upload/201910/1185476258174251008.png', '0', '', 'junAdmin', '2019-10-19 14:25:48', 'junAdmin', '2019-10-22 11:34:13', '0');
INSERT INTO `com_album` VALUES ('1185443642257940480', '0', '我的相册', '/upload/201910/1185476330484051968.png', '0', '', 'junAdmin', '2019-10-19 14:32:43', 'junAdmin', '2019-10-22 11:33:58', '0');
INSERT INTO `com_album` VALUES ('1191180369210843136', 'zhao', '举', 'http://file.junkj.com/upload/201910/1186148784568455168.jpg', '0', '', 'zhao_I95W', '2019-11-04 10:28:26', 'zhao_I95W', '2019-11-04 10:28:26', '0');

-- ----------------------------
-- Table structure for com_cards
-- ----------------------------
DROP TABLE IF EXISTS `com_cards`;
CREATE TABLE `com_cards` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `cards_type_id` varchar(32) DEFAULT NULL COMMENT '会员卡分类',
  `name` varchar(20) DEFAULT NULL COMMENT '卡名',
  `type` char(1) DEFAULT NULL COMMENT '卡类型（1储值卡、2储次卡）',
  `stored_num` decimal(10,2) DEFAULT NULL COMMENT '次数/金额',
  `money` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `days` int(11) DEFAULT NULL COMMENT '有效天数',
  `is_new` char(1) DEFAULT '2' COMMENT '只限新会员(1是、2否）',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='储次卡';

-- ----------------------------
-- Records of com_cards
-- ----------------------------
INSERT INTO `com_cards` VALUES ('1177384876855263232', '4', null, '储次卡3', '1', '10.00', '1000.00', '365', '1', '27272727', '1', '2019-09-27 08:50:04', 'junAdmin', '2019-10-08 08:59:55');
INSERT INTO `com_cards` VALUES ('1177760095291011072', '1', null, '储次卡4', '1', '111111.00', '11111.00', '1111111111', '1', '27272727', '1', '2019-09-28 09:41:03', 'junAdmin', '2019-10-08 08:59:53');
INSERT INTO `com_cards` VALUES ('1178207741987184640', '1', null, '储次卡5', '1', '666.00', '666.00', '666', '1', '27272727', '1', '2019-09-29 15:19:50', 'junAdmin', '2019-10-08 08:59:52');
INSERT INTO `com_cards` VALUES ('1183215160151171072', '0', null, '储值500', '1', '500.00', '500.00', '365', '1', '驱动器发出去出去玩出去玩去', 'junAdmin', '2019-10-13 10:57:32', 'junAdmin', '2019-10-13 11:03:06');
INSERT INTO `com_cards` VALUES ('1183306417827577856', '0', null, '储次卡30', '2', '30.00', '5000.00', '365', '0', 'adawdawdwdqwdqdq', 'junAdmin', '2019-10-13 17:00:09', 'junAdmin', '2019-10-13 17:00:38');
INSERT INTO `com_cards` VALUES ('1184659379668258816', 'wangxi', null, '青铜储值卡', '1', '200.00', '200.00', '200', '0', '27272727', 'wangxi_DOUW', '2019-10-17 10:36:21', 'wangxi_DOUW', '2019-10-17 10:36:21');
INSERT INTO `com_cards` VALUES ('1184659472131690496', 'wangxi', null, '青铜储次卡', '2', '200.00', '200.00', '200', '0', '27272727', 'wangxi_DOUW', '2019-10-17 10:36:43', 'wangxi_DOUW', '2019-10-17 10:36:43');
INSERT INTO `com_cards` VALUES ('1184660659429842944', 'ali', null, '会员卡一', '1', '111.00', '111.00', '11', '0', '27272727', 'aliali_PRJT', '2019-10-17 10:41:26', 'aliali_PRJT', '2019-10-17 16:49:21');
INSERT INTO `com_cards` VALUES ('1184660713276317696', 'ali', null, '会员卡二', '2', '222.00', '222.00', '222', '1', '27272727', 'aliali_PRJT', '2019-10-17 10:41:39', 'aliali_PRJT', '2019-10-17 16:49:29');
INSERT INTO `com_cards` VALUES ('1184664162535550976', 'zhao', null, '古河', '1', '200.00', '100.00', '100', '1', '27272727', 'zhao_I95W', '2019-10-17 10:37:03', 'zhao_I95W', '2019-10-17 10:37:03');
INSERT INTO `com_cards` VALUES ('1184714795166785536', 'ali', null, '会员卡三', '1', '333.00', '333.00', '333', '0', '27272727', 'aliali_PRJT', '2019-10-17 14:16:33', 'aliali_PRJT', '2019-10-17 16:49:36');
INSERT INTO `com_cards` VALUES ('1184722266789605376', 'zhao', null, '风塔', '1', '250.00', '200.00', '20', '1', '27272727', 'zhao_I95W', '2019-10-17 14:46:14', 'zhao_I95W', '2019-10-17 14:46:14');
INSERT INTO `com_cards` VALUES ('1184731933958983680', 'wangxi', null, '白银储次卡', '2', '1.00', '999999.00', '1', '0', '27272727', 'wangxi_DOUW', '2019-10-17 15:24:39', 'wangxi_DOUW', '2019-10-17 15:24:39');
INSERT INTO `com_cards` VALUES ('1184985708296052736', 'ali', null, '会员卡四', '1', '444.00', '444.00', '444', '0', '27272727', 'aliali_PRJT', '2019-10-18 08:13:03', 'aliali_PRJT', '2019-10-18 08:13:03');
INSERT INTO `com_cards` VALUES ('1185440017697312768', '0', null, '储值卡1000', '1', '1000.00', '988.00', '50', '1', '法发顺丰请我放弃我放弃我父亲', 'junAdmin', '2019-10-19 14:18:19', 'junAdmin', '2019-10-19 14:18:19');
INSERT INTO `com_cards` VALUES ('1185442833169321984', '0', null, '1', '1', '1.00', '1.00', '1', '0', '青春期为查询请我吃请我吃', 'junAdmin', '2019-10-19 14:29:31', 'junAdmin', '2019-10-19 14:29:31');
INSERT INTO `com_cards` VALUES ('1186468419585884160', '0', null, '水月教育卡', '1', '30000.00', '1000.00', '30', '0', '水电费圣诞节圣诞节时代收到技术可登录方式地方时代峻峰时刻到了发水电费决胜巅峰教师端水电费几十块代理费水电费圣诞节水电费几十块啦水电费几十块代理费施蒂利克副驾驶的几十块老地方你', 'junAdmin', '2019-10-22 10:24:49', 'junAdmin', '2019-10-22 10:24:49');
INSERT INTO `com_cards` VALUES ('1186468615875117056', '0', null, '黄金会员卡', '2', '1000.00', '2000.00', '10', '0', '胜多负少的水电费是的水电费收到收到胜多负少的大厦收到', 'junAdmin', '2019-10-22 10:25:36', 'junAdmin', '2019-10-22 10:25:36');
INSERT INTO `com_cards` VALUES ('1186472623293513728', '0', null, '白金卡', '1', '1111.00', '1111.00', '1111', '0', '双方都水电费水电费收到收到', 'junAdmin', '2019-10-22 10:41:32', 'junAdmin', '2019-10-22 10:41:32');
INSERT INTO `com_cards` VALUES ('1191173307305693184', 'zhao', null, '青竹', '1', '10.00', '200.00', '300', '2', null, 'zhao_I95W', '2019-11-04 10:00:22', 'zhao_I95W', '2019-11-04 10:00:22');
INSERT INTO `com_cards` VALUES ('1191585955874398208', '0', '1177423738750693376', 'asd', '1', '11.00', '11.00', '11', '2', '', 'junAdmin', '2019-11-05 13:20:05', 'junAdmin', '2019-11-07 09:42:27');

-- ----------------------------
-- Table structure for com_cards_type
-- ----------------------------
DROP TABLE IF EXISTS `com_cards_type`;
CREATE TABLE `com_cards_type` (
  `id` varchar(32) NOT NULL COMMENT '会员卡分类ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `type_name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员卡分类';

-- ----------------------------
-- Records of com_cards_type
-- ----------------------------
INSERT INTO `com_cards_type` VALUES ('1177423738750693376', '0', '周末');
INSERT INTO `com_cards_type` VALUES ('1177423782241431552', '0', '非周末');
INSERT INTO `com_cards_type` VALUES ('1177777327618486272', '0', '按摩卡');
INSERT INTO `com_cards_type` VALUES ('1191585859975831552', '0', '游泳卡');

-- ----------------------------
-- Table structure for com_config
-- ----------------------------
DROP TABLE IF EXISTS `com_config`;
CREATE TABLE `com_config` (
  `id` varchar(32) NOT NULL COMMENT '主键自增',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `c_name` varchar(64) DEFAULT NULL COMMENT '参数名称',
  `c_key` varchar(64) DEFAULT NULL COMMENT '参数key',
  `c_value` longtext COMMENT '参数值',
  `c_type` varchar(10) DEFAULT NULL COMMENT '参数类型（text/img/json/jsonObj/post/get）',
  `c_load` char(1) DEFAULT '0' COMMENT '自动加载（0否、1是）',
  `remark` text COMMENT '参数说明',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置';

-- ----------------------------
-- Records of com_config
-- ----------------------------
INSERT INTO `com_config` VALUES ('1191179326213267456', 'zhao', '奖金统计方式', 'bonus_mode', '1', null, '0', '上课奖金统计方式（1按课时，2按签到人数，3按评价）', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179348963172352', 'zhao', '准时签到送积分', 'sign_send_points', '20', null, '0', '会员准时签到，赠送会员＂?＂积分', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179364821835776', 'zhao', '消费积分比例', 'buy_send_points', '10', null, '0', '会员消费后，赠送消费金额乘以＂?＂%的积分', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179382043648000', 'zhao', '课程提前取消时间', 'course_cancel_time', '3', null, '0', '课程开始前＂?＂小时，允许取消课程', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179395691913216', 'zhao', '活动提前取消时间', 'activity_cancel_time', '2', null, '0', '活动开始前＂?＂小时，允许取消课程', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179409939963904', 'zhao', '导购一级提成比例', 'sale_ratio_1', '10', null, '0', '会员消费后，一级导购提成＂?＂%的奖金', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179423110078464', 'zhao', '导购二级提成比例', 'sale_ratio_2', '5', null, '0', '会员消费后，二级导购提成＂?＂%的奖金', null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179453283901440', 'zhao', '联系电话', 'com_phone', '20', null, '0', null, null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179466957332480', 'zhao', '地图坐标', 'com_coordinate', '20', null, '0', null, null, null, null, null);
INSERT INTO `com_config` VALUES ('1191179485714259968', 'zhao', '预约提示', 'com_tishi', '20', null, '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for com_course
-- ----------------------------
DROP TABLE IF EXISTS `com_course`;
CREATE TABLE `com_course` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `teacher_id` varchar(32) DEFAULT NULL COMMENT '教师',
  `assistant_id` varchar(32) DEFAULT NULL COMMENT '助教',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '复制课程id',
  `name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  `course_date` date DEFAULT NULL COMMENT '课程日期',
  `start_time` time DEFAULT NULL COMMENT '开始时间',
  `end_time` time DEFAULT NULL COMMENT '结束时间',
  `people_max` int(11) DEFAULT '0' COMMENT '报名上限',
  `cards_type_id` varchar(32) DEFAULT NULL COMMENT '会员卡分类',
  `card_num` decimal(10,2) DEFAULT '0.00' COMMENT '消耗数值',
  `is_week` char(1) DEFAULT '0' COMMENT '每周重复（1是、0否）',
  `is_check` char(1) DEFAULT '0' COMMENT '预约验证预约（1开、0关）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='排课表';

-- ----------------------------
-- Records of com_course
-- ----------------------------
INSERT INTO `com_course` VALUES ('1191186470167961600', 'zhao', '12312_J0CE', null, null, '312', '2019-11-04', '17:30:00', '12:00:00', '1', '1177423738750693376', '0.00', '1', '1', 'zhao_I95W', '2019-11-04 10:52:40', 'zhao_I95W', '2019-11-04 10:52:40');
INSERT INTO `com_course` VALUES ('1191592487168937984', '0', 'zzz1_J4JO', '', null, '阿斯达', '2019-11-06', '17:30:00', '11:11:00', '1', '1177423738750693376', '1.00', '1', '1', 'junAdmin', '2019-11-05 13:46:02', 'junAdmin', '2019-11-05 13:51:58');
INSERT INTO `com_course` VALUES ('1191601726945349632', '0', 'zzz1_J4JO', null, '1191592487168937984', '阿斯达', '2019-11-12', '17:30:00', '11:11:00', '1', '1177423738750693376', '1.00', '0', '1', 'junAdmin', '2019-11-05 13:46:02', 'junAdmin', '2019-11-05 13:51:58');
INSERT INTO `com_course` VALUES ('1192985590533402624', 'cheng', '1192954231329845248', '', null, '11', '2019-11-09', '00:00:00', '00:00:00', '10', '', '0.00', '1', '1', 'cheng_4KGX', '2019-11-09 10:01:44', 'cheng_4KGX', '2019-11-09 10:20:03');
INSERT INTO `com_course` VALUES ('1194879812844126208', 'zhao', '12312_J0CE', null, null, '312', '2019-11-14', '00:00:00', '00:00:00', '23', null, '0.00', '1', '1', 'zhao_I95W', '2019-11-14 15:28:42', 'zhao_I95W', '2019-11-14 15:28:42');

-- ----------------------------
-- Table structure for com_course_enroll
-- ----------------------------
DROP TABLE IF EXISTS `com_course_enroll`;
CREATE TABLE `com_course_enroll` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `course_id` varchar(32) DEFAULT NULL COMMENT '排课表ID',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `status` char(1) DEFAULT '1' COMMENT '1预约成功、2取消预约、3预约不通过、 4已签到、5已完成',
  `status_remark` varchar(500) DEFAULT NULL COMMENT '不通过原因',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `sign_time` datetime DEFAULT NULL COMMENT '签到时间',
  `comment_time` datetime DEFAULT NULL COMMENT '评价时间',
  `comment_level` varchar(100) DEFAULT NULL COMMENT '评价等级',
  `comment_content` varchar(500) DEFAULT NULL COMMENT '评价内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程预约';

-- ----------------------------
-- Records of com_course_enroll
-- ----------------------------
INSERT INTO `com_course_enroll` VALUES ('1192342118087589888', '0', '1191592487168937984', '1191593263232618496', '9', null, '2019-11-07 15:24:48', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1192342722349903872', '0', '1191592487168937984', '1191593263232618496', '9', null, '2019-11-07 15:27:12', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1192344794821898240', '0', '1191592487168937984', '1191593263232618496', '9', null, '2019-11-07 15:35:26', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1192345534305492992', '0', '1191592487168937984', '1191593263232618496', '2', 'fsefsf', '2019-11-07 15:38:23', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1192985706438799360', 'cheng', '1192985590533402624', '1192985670917238784', '1', null, '2019-11-09 10:02:12', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1192990125193445376', 'cheng', '1192985623941033984', '1192985670917238784', '9', null, '2019-11-09 10:19:45', null, null, null, null);
INSERT INTO `com_course_enroll` VALUES ('1195161538263822336', 'zhao', '1194879812844126208', '1191218086037643264', '9', null, '2019-11-15 10:08:10', null, null, null, null);

-- ----------------------------
-- Table structure for com_feedback
-- ----------------------------
DROP TABLE IF EXISTS `com_feedback`;
CREATE TABLE `com_feedback` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '关联id',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '关联业务（1客户端）',
  `content` varchar(500) DEFAULT NULL COMMENT '留言内容',
  `status` char(1) DEFAULT '0' COMMENT '状态（0未读，1已读）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `type` char(1) DEFAULT NULL COMMENT '类型（0投诉建议，1问题反馈）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见反馈';

-- ----------------------------
-- Records of com_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for com_leave
-- ----------------------------
DROP TABLE IF EXISTS `com_leave`;
CREATE TABLE `com_leave` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `staff_id` varchar(32) DEFAULT NULL COMMENT '员工',
  `content` text COMMENT '请假事由',
  `start_time` datetime DEFAULT NULL COMMENT '请假开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '请假结束时间',
  `checkState` varchar(1) DEFAULT '1' COMMENT '审批状态(1待审批,2未通过,3已通过,4已取消)',
  `checkRemark` text COMMENT '审批意见',
  `checkTime` datetime DEFAULT NULL COMMENT '审批时间',
  `checkStaffId` varchar(500) DEFAULT NULL COMMENT '审批人',
  `type` char(1) DEFAULT NULL COMMENT '请假类型',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工请假表';

-- ----------------------------
-- Records of com_leave
-- ----------------------------
INSERT INTO `com_leave` VALUES ('1192995616219668480', 'cheng', '1192995532400697344', '1', '2019-11-09 00:00:00', '2019-11-09 00:00:00', '3', '1', '2019-11-09 10:41:40', '1192995532400697344,1192954231329845248,', '1', 'cheng_4KGX', '2019-11-09 10:41:34', 'cheng_4KGX', '2019-11-09 10:41:44');
INSERT INTO `com_leave` VALUES ('1192995714425102336', 'cheng', '1192995532400697344', '1', '2019-11-09 00:00:00', '2019-11-09 00:00:00', '3', '1', '2019-11-09 10:42:01', '1192995532400697344,1192954231329845248,', '1', 'cheng_4KGX', '2019-11-09 10:41:58', 'cheng_4KGX', '2019-11-09 10:41:58');

-- ----------------------------
-- Table structure for com_member
-- ----------------------------
DROP TABLE IF EXISTS `com_member`;
CREATE TABLE `com_member` (
  `member_id` varchar(32) NOT NULL COMMENT '会员id',
  `com_id` varchar(20) NOT NULL COMMENT '企业id',
  `level_id` varchar(32) DEFAULT NULL COMMENT '会员级别',
  `points` int(11) DEFAULT '0' COMMENT '积分',
  `source` char(1) DEFAULT NULL COMMENT '来源（1店内、2微信）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `h1` varchar(255) DEFAULT NULL,
  `h2` varchar(255) DEFAULT NULL,
  `h3` varchar(255) DEFAULT NULL,
  `h4` varchar(255) DEFAULT NULL,
  `h5` varchar(255) DEFAULT NULL,
  `h6` varchar(255) DEFAULT NULL,
  `h7` varchar(255) DEFAULT NULL,
  `h8` varchar(255) DEFAULT NULL,
  `h9` varchar(255) DEFAULT NULL,
  `h10` varchar(255) DEFAULT NULL,
  `h11` varchar(255) DEFAULT NULL,
  `h12` varchar(255) DEFAULT NULL,
  `h13` varchar(255) DEFAULT NULL,
  `h14` varchar(255) DEFAULT NULL,
  `h15` varchar(255) DEFAULT NULL,
  `h16` varchar(255) DEFAULT NULL,
  `h17` varchar(255) DEFAULT NULL,
  `h18` varchar(255) DEFAULT NULL,
  `h19` varchar(255) DEFAULT NULL,
  `h20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`,`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业会员';

-- ----------------------------
-- Records of com_member
-- ----------------------------
INSERT INTO `com_member` VALUES ('1181743349920227328', '0', '1183201371552014336', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1191218086037643264', 'localhost', '0', '2', '2', null, null, '2019-11-14 15:37:49', null, '2019-11-14 15:37:49', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1191218086037643264', 'zhao', null, '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1191593263232618496', '0', '1183201371552014336', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1192669039138689024', 'baidu', '1192669018905366528', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1192985670917238784', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1193049208589189120', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1193049224326217728', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1193049235327877120', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1193049246358896640', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1194881841535229952', 'localhost', '0', '0', '2', null, null, '2019-11-14 15:36:46', null, '2019-11-14 15:36:46', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1195538778730991616', 'cheng', '1184659091286470656', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1195538778730991616', 'localhost', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1195543525196144640', 'cheng', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `com_member` VALUES ('1195579457663541248', 'zhao', null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for com_mobile_setting
-- ----------------------------
DROP TABLE IF EXISTS `com_mobile_setting`;
CREATE TABLE `com_mobile_setting` (
  `id` varchar(32) NOT NULL COMMENT '设置id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `type` char(1) DEFAULT NULL COMMENT '设置分类(1轮播）',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `url` varchar(255) DEFAULT NULL COMMENT '连接',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='官网设置';

-- ----------------------------
-- Records of com_mobile_setting
-- ----------------------------
INSERT INTO `com_mobile_setting` VALUES ('1184725126917492736', 'ali', '1', '222', '/upload/201909/1177470489730826240.png', '11', null, '11', null, null, null, null);
INSERT INTO `com_mobile_setting` VALUES ('1184725491419287552', 'ali', '1', '22', '/upload/201909/1177469357688176640.png', '22', null, '22', null, null, null, null);
INSERT INTO `com_mobile_setting` VALUES ('1191177681935405056', 'zhao', '1', '', 'http://file.junkj.com/upload/201910/1186144836116033537.jpg', '', null, '', null, null, null, null);

-- ----------------------------
-- Table structure for com_staff_money_setting
-- ----------------------------
DROP TABLE IF EXISTS `com_staff_money_setting`;
CREATE TABLE `com_staff_money_setting` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '员工',
  `ratio` int(11) DEFAULT '0' COMMENT '消费项目提成比例',
  `card_ratio` int(11) DEFAULT '0' COMMENT '会员卡提成比例',
  `bonus` int(11) DEFAULT '0' COMMENT '课时奖金',
  `star1` int(11) DEFAULT '0' COMMENT '一星奖金',
  `star2` int(11) DEFAULT '0' COMMENT '二星奖金',
  `star3` int(11) DEFAULT '0' COMMENT '三星奖金',
  `star4` int(11) DEFAULT '0' COMMENT '四星奖金',
  `star5` int(11) DEFAULT '0' COMMENT '五星奖金',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提成设置';

-- ----------------------------
-- Records of com_staff_money_setting
-- ----------------------------
INSERT INTO `com_staff_money_setting` VALUES ('1182943984068026368', 'tengxun', 'kuguan_PU9L', '1', '0', '1', '1', '1', '1', '1', '1', 'teng_W8UN', '2019-10-12 16:59:58', 'teng_W8UN', '2019-10-12 16:59:58');
INSERT INTO `com_staff_money_setting` VALUES ('1182944032654843904', 'baiducom', 'bdkuguan_KYZH', '1', '0', '1', '1', '1', '1', '1', '1', 'baidu_GN5E', '2019-10-12 17:00:10', 'baidu_GN5E', '2019-10-12 17:00:10');
INSERT INTO `com_staff_money_setting` VALUES ('1183254708644962305', '0', 'junAdmin', '10', '0', '10', '1', '2', '3', '4', '5', 'junAdmin', '2019-10-13 13:34:41', 'junAdmin', '2019-10-24 09:18:54');
INSERT INTO `com_staff_money_setting` VALUES ('1184663083628761088', 'wangxi', 'asda_5HRC', '11', '0', '11', '0', '0', '0', '0', '0', 'wangxi_DOUW', '2019-10-17 10:51:04', 'wangxi_DOUW', '2019-10-17 10:51:04');
INSERT INTO `com_staff_money_setting` VALUES ('1184664620360609792', 'zhao', 'zhao1_670P', '10', '0', '10', '10', '0', '0', '0', '0', 'zhao_I95W', '2019-10-17 10:57:10', 'zhao_I95W', '2019-10-17 13:11:31');
INSERT INTO `com_staff_money_setting` VALUES ('1184675673981198336', 'ali', '9999_F8RR', '40', '0', '11', '0', '0', '0', '0', '0', 'aliali_PRJT', '2019-10-17 11:41:06', 'aliali_PRJT', '2019-10-17 13:40:52');
INSERT INTO `com_staff_money_setting` VALUES ('1184710757855584256', 'ali', '8888_PRVQ', '20', '0', '20', '0', '0', '0', '0', '0', 'aliali_PRJT', '2019-10-17 14:00:30', 'aliali_PRJT', '2019-10-17 14:00:30');
INSERT INTO `com_staff_money_setting` VALUES ('1185441754252414976', '0', 'yonghu2_4N22', '10', '0', '10', '0', '0', '0', '0', '0', 'junAdmin', '2019-10-19 14:25:13', 'junAdmin', '2019-10-24 09:37:33');
INSERT INTO `com_staff_money_setting` VALUES ('1185443404113747968', '0', 'yonghu_KKXF', '1', '0', '1', '0', '0', '0', '0', '0', 'junAdmin', '2019-10-19 14:31:47', 'junAdmin', '2019-10-19 14:31:47');
INSERT INTO `com_staff_money_setting` VALUES ('1186900717766901760', '0', '123123123_AAYH', '10', '0', '10', '1', '2', '3', '4', '5', 'junAdmin', '2019-10-23 15:02:37', 'junAdmin', '2019-10-23 15:02:37');
INSERT INTO `com_staff_money_setting` VALUES ('1191179943283466240', 'zhao', '12312_J0CE', '30', '0', '10', '0', '0', '0', '0', '0', 'zhao_I95W', '2019-11-04 10:26:44', 'zhao_I95W', '2019-11-04 10:26:44');

-- ----------------------------
-- Table structure for com_staff_notice_setting
-- ----------------------------
DROP TABLE IF EXISTS `com_staff_notice_setting`;
CREATE TABLE `com_staff_notice_setting` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '员工',
  `enroll_msg` char(1) DEFAULT '0' COMMENT '预约通知(1不通知、0通知)',
  `census_msg` char(1) DEFAULT '0' COMMENT '统计通知(1不通知、0通知)',
  `leave_msg` char(1) DEFAULT '0' COMMENT '统计通知(1不通知、0通知)',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知设置';

-- ----------------------------
-- Records of com_staff_notice_setting
-- ----------------------------
INSERT INTO `com_staff_notice_setting` VALUES ('1191180300076130304', 'zhao', 'zhao1_670P', '0', '0', '1', 'zhao_I95W', '2019-11-04 10:28:09', 'zhao_I95W', '2019-11-04 10:28:09');
INSERT INTO `com_staff_notice_setting` VALUES ('1191180324952547328', 'zhao', '1195159802214412288', '1', '1', '1', 'zhao_I95W', '2019-11-04 10:28:15', 'zhao_I95W', '2019-11-04 10:28:15');
INSERT INTO `com_staff_notice_setting` VALUES ('1192995494551298048', 'cheng', '1192954231329845248', '0', '0', '0', 'cheng_4KGX', '2019-11-09 10:41:05', 'cheng_4KGX', '2019-11-09 10:41:05');
INSERT INTO `com_staff_notice_setting` VALUES ('1192995569897775104', 'cheng', '1192995532400697344', '0', '0', '0', 'cheng_4KGX', '2019-11-09 10:41:23', 'cheng_4KGX', '2019-11-09 10:41:23');

-- ----------------------------
-- Table structure for com_template
-- ----------------------------
DROP TABLE IF EXISTS `com_template`;
CREATE TABLE `com_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `tpl_code` varchar(32) DEFAULT NULL COMMENT '模板编码',
  `tpl_id` varchar(64) DEFAULT NULL COMMENT '模板ID',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业模板消息';

-- ----------------------------
-- Records of com_template
-- ----------------------------
INSERT INTO `com_template` VALUES ('1192321070424567808', '0', 'OPENTM414066453', 'HI1zfe9QNYpjBoH0uC_OE_FP4YiP9jDAxkiXKDJ4yVc', 'junAdmin', '2019-11-07 14:01:10', 'junAdmin', '2019-11-07 14:01:10');
INSERT INTO `com_template` VALUES ('1192321506789732352', '0', 'OPENTM205704113', 'nit0wb7RvUaJw8n_B5qni7i1hf5g0lLdS3uYw75dwAA', 'junAdmin', '2019-11-07 14:02:54', 'junAdmin', '2019-11-07 14:02:54');
INSERT INTO `com_template` VALUES ('1192321547520618496', '0', 'OPENTM202193611', 'aewoODzKOQYo_-MhE7kNbBTuVFzehC4uXmHTJB-K_vY', 'junAdmin', '2019-11-07 14:03:04', 'junAdmin', '2019-11-07 14:03:04');
INSERT INTO `com_template` VALUES ('1192321575639232512', '0', 'OPENTM417879714', 'FkDCBDztddD2GVgtr2GcavCQgOSn9W_DWDJ0ME3JlQg', 'junAdmin', '2019-11-07 14:03:11', 'junAdmin', '2019-11-07 14:03:11');
INSERT INTO `com_template` VALUES ('1192321599962001408', '0', 'OPENTM412181252', '9WjtCu9UOrro8uqF5AN-LAPEyp-CYcXUR1YDk1tpmP8', 'junAdmin', '2019-11-07 14:03:16', 'junAdmin', '2019-11-07 14:03:16');
INSERT INTO `com_template` VALUES ('1192321626436448256', '0', 'OPENTM207719530', 'xWsR53kiaohSgMdkw4iaysfTyfY6oCUbCMoKxf0g5W8', 'junAdmin', '2019-11-07 14:03:23', 'junAdmin', '2019-11-07 14:03:23');
INSERT INTO `com_template` VALUES ('1192321649937133568', '0', 'OPENTM417733499', '47m8aeWMtlp1K6-zJZzinWVALLdowC5pRc1GowKmups', 'junAdmin', '2019-11-07 14:03:28', 'junAdmin', '2019-11-07 14:03:28');
INSERT INTO `com_template` VALUES ('1192321683483176960', '0', 'OPENTM400417088', 'QUQHQzgdlmqeMPQbLZH8QFMlKL62FLBaD7FjG8oFPtQ', 'junAdmin', '2019-11-07 14:03:36', 'junAdmin', '2019-11-07 14:03:36');
INSERT INTO `com_template` VALUES ('1192321796863602688', '0', 'OPENTM401155654', '8I5iZVDddFIydWutFH1WX6J4lXP-LXQRzV4WDY1H18Y', 'junAdmin', '2019-11-07 14:04:03', 'junAdmin', '2019-11-07 14:04:03');
INSERT INTO `com_template` VALUES ('1192321828769673216', '0', 'OPENTM417813504', 'l5hwS8excEc6EEaII_9QmuWtcMrg9zN6YOqMePge0Eo', 'junAdmin', '2019-11-07 14:04:11', 'junAdmin', '2019-11-07 14:04:11');
INSERT INTO `com_template` VALUES ('1192322288574443520', '0', 'OPENTM412898512', 'ARpyqr9mOzIq4la1g7fVffL7XODI5JETF8nnk', 'junAdmin', '2019-11-07 14:06:01', 'junAdmin', '2019-11-07 14:06:01');
INSERT INTO `com_template` VALUES ('1192672360871170048', 'baidu', 'OPENTM414066453', 'HI1zfe9QNYpjBoH0uC_OE_FP4YiP9jDAxkiXKDJ4yVc', 'baidu_GN5E', '2019-11-08 13:17:04', 'baidu_GN5E', '2019-11-08 13:17:04');
INSERT INTO `com_template` VALUES ('1192672387303673856', 'baidu', 'OPENTM205704113', 'nit0wb7RvUaJw8n_B5qni7i1hf5g0lLdS3uYw75dwAA', 'baidu_GN5E', '2019-11-08 13:17:11', 'baidu_GN5E', '2019-11-08 13:17:11');
INSERT INTO `com_template` VALUES ('1192672414579232768', 'baidu', 'OPENTM202193611', 'aewoODzKOQYo_-MhE7kNbBTuVFzehC4uXmHTJB-K_vY', 'baidu_GN5E', '2019-11-08 13:17:17', 'baidu_GN5E', '2019-11-08 13:17:17');
INSERT INTO `com_template` VALUES ('1192672435349426176', 'baidu', 'OPENTM417879714', 'FkDCBDztddD2GVgtr2GcavCQgOSn9W_DWDJ0ME3JlQg', 'baidu_GN5E', '2019-11-08 13:17:22', 'baidu_GN5E', '2019-11-08 13:17:22');
INSERT INTO `com_template` VALUES ('1192990918151311360', 'cheng', 'OPENTM207719530', 'xWsR53kiaohSgMdkw4iaysfTyfY6oCUbCMoKxf0g5W8', 'cheng_4KGX', '2019-11-09 10:22:54', 'cheng_4KGX', '2019-11-09 10:22:54');

-- ----------------------------
-- Table structure for demo_base
-- ----------------------------
DROP TABLE IF EXISTS `demo_base`;
CREATE TABLE `demo_base` (
  `id` varchar(32) NOT NULL COMMENT '编码',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL COMMENT '年龄',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `status` char(1) DEFAULT NULL COMMENT '状态',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='示例增删改查';

-- ----------------------------
-- Records of demo_base
-- ----------------------------
INSERT INTO `demo_base` VALUES ('1169892281458737152', '1', '1', '1', '9', '1', '1', '2019-09-06 16:37:10', '1', '2019-09-27 09:57:57');
INSERT INTO `demo_base` VALUES ('1181438177262653440', '41', '41', '41', '1', '41', 'junAdmin', '2019-10-08 13:16:26', 'junAdmin', '2019-10-19 11:18:03');
INSERT INTO `demo_base` VALUES ('1181438384356413440', '12', '12', '12', '1', '12', 'junAdmin', '2019-10-08 13:17:16', 'junAdmin', '2019-10-08 13:17:16');
INSERT INTO `demo_base` VALUES ('1181438713407950848', '4', '4', '4', '1', '4', 'junAdmin', '2019-10-08 13:18:34', 'junAdmin', '2019-10-08 13:18:34');
INSERT INTO `demo_base` VALUES ('1181438772379865088', '4', '4', '4', '1', '4', 'junAdmin', '2019-10-08 13:18:48', 'junAdmin', '2019-10-08 13:18:48');
INSERT INTO `demo_base` VALUES ('1181443717155065856', '1', '1', '1', '1', '1', 'junAdmin', '2019-10-08 13:38:27', 'junAdmin', '2019-10-08 13:38:27');
INSERT INTO `demo_base` VALUES ('1183557882880520192', 'abc', '22', '男', '9', '123', 'junAdmin', '2019-10-14 09:39:23', 'junAdmin', '2019-10-14 13:17:21');

-- ----------------------------
-- Table structure for demo_item
-- ----------------------------
DROP TABLE IF EXISTS `demo_item`;
CREATE TABLE `demo_item` (
  `id` varchar(32) NOT NULL COMMENT '编码',
  `base_id` varchar(32) DEFAULT NULL COMMENT '父表主键',
  `course` varchar(255) DEFAULT NULL COMMENT '课程',
  `num` int(11) DEFAULT NULL COMMENT '分数',
  `rank` varchar(255) DEFAULT NULL COMMENT '排名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='示例子表';

-- ----------------------------
-- Records of demo_item
-- ----------------------------
INSERT INTO `demo_item` VALUES ('1170179120183402496', '1169892281458737152', '1', '11', '111');
INSERT INTO `demo_item` VALUES ('1170179139749830656', '1169892281458737152', '2', '22', '222');
INSERT INTO `demo_item` VALUES ('1178098826192801792', '1178098826150858752', '2', '2', '2');
INSERT INTO `demo_item` VALUES ('1181438247324307456', '1181438177262653440', '41', '41', '41');
INSERT INTO `demo_item` VALUES ('1181438454799749120', '1181438384356413440', '12', '12', '12');
INSERT INTO `demo_item` VALUES ('1181438508881104896', '1181438384356413440', '12', '12', '12');
INSERT INTO `demo_item` VALUES ('1181438509757714432', '1181438384356413440', '12', '12', '12');
INSERT INTO `demo_item` VALUES ('1181438713466671104', '1181438713407950848', '1', '1', '1');
INSERT INTO `demo_item` VALUES ('1181438772426002432', '1181438772379865088', '4', '4', '4');
INSERT INTO `demo_item` VALUES ('1181443717226369024', '1181443717155065856', '1', '1', '1');
INSERT INTO `demo_item` VALUES ('1183557883077652480', '1183557882880520192', '云纹', '87', '3');
INSERT INTO `demo_item` VALUES ('1183558517298360320', '1183557882880520192', '筛选', '77', '6');

-- ----------------------------
-- Table structure for demo_tree
-- ----------------------------
DROP TABLE IF EXISTS `demo_tree`;
CREATE TABLE `demo_tree` (
  `com_id` varchar(64) NOT NULL COMMENT '公司编码',
  `com_name` varchar(100) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL COMMENT '公司全称',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_id` varchar(64) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_id` varchar(64) NOT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`com_id`),
  KEY `idx_sys_office_pc` (`parent_id`),
  KEY `idx_sys_office_pcs` (`parent_ids`),
  KEY `idx_sys_office_status` (`status`),
  KEY `idx_sys_office_ts` (`tree_sort`),
  KEY `idx_sys_office_tss` (`tree_sorts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='示例树';

-- ----------------------------
-- Records of demo_tree
-- ----------------------------
INSERT INTO `demo_tree` VALUES ('1171026507027293210', '辽宁公司', '辽宁公司', '0', '0,', '1', '00000001,', '0', '0', '辽宁公司', '0', 'system', '2019-08-12 09:37:05', 'system', '2019-08-12 09:37:05', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293211', '大连公司', '大连公司', '1171026507027293210', '0,1171026507027293210,', '8', '00000001,00000008', '1', '1', '辽宁公司/大连公司', '0', 'system', '2019-08-12 09:37:05', '1', '2019-09-10 09:01:16', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293212', '沈阳公司', '沈阳公司', '1171026507027293210', '0,1171026507027293210,', '2', '00000001,00000002', '0', '1', '辽宁公司/沈阳公司', '0', 'system', '2019-08-12 09:37:05', '1', '2019-09-26 10:20:03', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293213', '营口公司', '营口公司', '1171026507027293210', '0,1171026507027293210,', '3', '00000001,00000003,', '1', '1', '辽宁公司/营口公司', '0', 'system', '2019-08-12 09:37:05', 'system', '2019-08-12 09:37:05', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293214', '丹东公司', '丹东公司', '1171026507027293210', '0,1171026507027293210,', '4', '00000001,00000004,', '1', '1', '辽宁公司/丹东公司', '0', 'system', '2019-08-12 09:37:05', 'system', '2019-08-12 09:37:05', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293220', '黑龙江公司', '黑龙江公司', '0', '0,', '2', '00000002,', '0', '0', '黑龙江公司', '0', 'system', '2019-08-12 09:37:05', 'system', '2019-08-12 09:37:05', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293222', '黑龙江佳木斯公司', '黑龙江佳木斯公司', '1171026507027293220', '0,1171026507027293220,', '2', '00000002,00000002', '1', '1', '黑龙江公司/佳木斯公司', '0', 'system', '2019-08-12 09:37:05', '1', '2019-09-10 08:58:55', null);
INSERT INTO `demo_tree` VALUES ('1171026507027293223', '黑龙江双鸭山公司', '黑龙江双鸭山公司', '1171026507027293220', '0,1171026507027293220,', '3', '00000002,00000003', '1', '1', '黑龙江公司/双鸭山公司', '0', 'system', '2019-08-12 09:37:05', '1', '2019-09-10 08:58:59', null);
INSERT INTO `demo_tree` VALUES ('1171218713516752896', 'bb', 'bb', '0', '0,', '3', '00000003,', '1', '0', 'aa', '0', '1', '2019-09-10 08:27:56', '1', '2019-09-10 08:27:56', null);
INSERT INTO `demo_tree` VALUES ('1171382421739679744', '黑龙江鹤岗公司', '黑龙江鹤岗公司', '1171026507027293220', '0,1171026507027293220,', '4', '00000002,00000004', '1', '1', '黑龙江公司/鹤岗公司', '0', '1', '2019-09-10 19:18:27', '1', '2019-09-10 19:18:27', null);
INSERT INTO `demo_tree` VALUES ('1171382496125661184', '黑龙江哈尔滨', '黑龙江哈尔滨', '1171026507027293220', '0,1171026507027293220,', '1', '00000002,00000001', '1', '1', '黑龙江公司/哈尔滨', '0', '1', '2019-09-10 19:18:45', '1', '2019-09-10 19:18:45', null);
INSERT INTO `demo_tree` VALUES ('1177777537333686272', '22', '22', '1171026507027293212', '0,1171026507027293210,1171026507027293212,', '22', '00000001,00000002,00000002', '1', '2', '辽宁公司/沈阳公司/222', '0', '1', '2019-09-28 10:50:22', '1', '2019-09-28 10:50:22', '22');
INSERT INTO `demo_tree` VALUES ('1182559282180734976', '1', '1', '1171026507027293210', '0,1171026507027293210,', '1', '00000001,00000001', '1', '1', '辽宁公司/1', '9', 'junAdmin', '2019-10-11 15:31:18', 'junAdmin', '2019-10-11 15:31:18', '1');
INSERT INTO `demo_tree` VALUES ('1182564277662834688', '1', '1', '1171026507027293210', '0,1171026507027293210,', '1', '00000001,00000001', '1', '1', '辽宁公司/1', '9', 'junAdmin', '2019-10-11 15:51:09', 'junAdmin', '2019-10-11 15:51:09', '1');
INSERT INTO `demo_tree` VALUES ('1182573133416546304', '22', '22', '1171026507027293210', '0,1171026507027293210,', '22', '00000001,00000022', '1', '1', '辽宁公司/22', '9', 'junAdmin', '2019-10-11 16:26:21', 'junAdmin', '2019-10-11 16:26:21', '22');
INSERT INTO `demo_tree` VALUES ('1186081643295817728', '1', '1', '1171026507027293210', '0,1171026507027293210,', '1', '00000001,00000001', '1', '1', '辽宁公司/1', '0', 'junAdmin', '2019-10-21 08:47:55', 'junAdmin', '2019-10-21 08:47:55', '1');

-- ----------------------------
-- Table structure for excel_col_rule
-- ----------------------------
DROP TABLE IF EXISTS `excel_col_rule`;
CREATE TABLE `excel_col_rule` (
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `colCode` varchar(36) NOT NULL COMMENT '列CODE',
  `ruleType` varchar(36) NOT NULL COMMENT '校验类型',
  `ruleValue` varchar(100) DEFAULT NULL COMMENT '校验值',
  `ruleMsg` varchar(100) NOT NULL COMMENT '提示信息',
  `sysDate` date NOT NULL COMMENT '系统时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校验规则';

-- ----------------------------
-- Records of excel_col_rule
-- ----------------------------
INSERT INTO `excel_col_rule` VALUES ('STAFF', 'name', 'NotNull', null, '姓名不能为空', '2019-06-19');
INSERT INTO `excel_col_rule` VALUES ('STAFF', 'password', 'NotNull', null, '密码不能为空', '2018-06-12');
INSERT INTO `excel_col_rule` VALUES ('STAFF', 'IdNumber', 'MinSize', '18', '身份证号长度不能小于18', '2018-06-12');
INSERT INTO `excel_col_rule` VALUES ('STAFF', 'IdNumber', 'MaxSize', '18', '身份证号长度不能大于18', '2018-06-12');
INSERT INTO `excel_col_rule` VALUES ('STAFF', 'IdNumber', 'NotNull', null, '身份证号不能为空', '2018-06-12');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'name', 'NotNull', null, '课程名称不能为空', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'teacherId', 'NotNull', null, '教师不能为空', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'courseDate', 'Date', null, '课程日期格式不正确', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'courseDate', 'NotNull', null, '课程日期不能为空', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'startTime', 'Date', null, '开始时间格式不正确', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'startTime', 'NotNull', null, '开始时间不能为空', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'endTime', 'NotNull', null, '结束时间不能为空', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'endTime', 'Date', null, '结束时间格式不正确', '2019-09-29');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'peopleMax', 'NotNull', null, '报名上限不能为空', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'peopleMax', 'Number', null, '报名上限格式不正确', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'isWeek', 'NotNull', null, '每周重复不能为空', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'isWeek', 'YES', null, '每周重复格式不正确', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'isCheck', 'NotNull', null, '预约验证不能为空', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('COURSE', 'isCheck', 'YES', null, '预约验证格式不正确', '2019-10-05');
INSERT INTO `excel_col_rule` VALUES ('MEMBER', 'name', 'NotNull', null, '姓名不能为空', '2019-11-13');
INSERT INTO `excel_col_rule` VALUES ('MEMBER', 'phone', 'NotNull', '', '电话不能为空', '2019-11-13');

-- ----------------------------
-- Table structure for excel_col_rule_type
-- ----------------------------
DROP TABLE IF EXISTS `excel_col_rule_type`;
CREATE TABLE `excel_col_rule_type` (
  `ruleType` varchar(20) NOT NULL COMMENT '类型标识：LENGTH长度在最大最小之间（逗号隔开）',
  `typeName` varchar(200) NOT NULL COMMENT '类型描述',
  `sysDate` date NOT NULL COMMENT '系统时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='校验类型';

-- ----------------------------
-- Records of excel_col_rule_type
-- ----------------------------
INSERT INTO `excel_col_rule_type` VALUES ('NotNull', '非空校验', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('MinSize', '最小长度', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('MaxSize', '最大长度', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Min', '最小数值', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Max', '最大数值', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Email', '电子邮件', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Regexp', '正则', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Sex', '性别', '2015-10-27');
INSERT INTO `excel_col_rule_type` VALUES ('Date', '日期', '2019-10-05');
INSERT INTO `excel_col_rule_type` VALUES ('YES', '是否', '2019-10-05');
INSERT INTO `excel_col_rule_type` VALUES ('Number', '数字', '2019-10-05');
INSERT INTO `excel_col_rule_type` VALUES ('Double', '小数', '2019-10-05');

-- ----------------------------
-- Table structure for excel_out
-- ----------------------------
DROP TABLE IF EXISTS `excel_out`;
CREATE TABLE `excel_out` (
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `colCode` varchar(36) NOT NULL COMMENT '列CODE',
  `colName` varchar(100) DEFAULT NULL COMMENT '列名称',
  `colWidth` int(11) DEFAULT NULL,
  `colSort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`tableCode`,`colCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导出列名';

-- ----------------------------
-- Records of excel_out
-- ----------------------------
INSERT INTO `excel_out` VALUES ('com_course', 'assistantName', '助教', '5000', '3');
INSERT INTO `excel_out` VALUES ('com_course', 'cardNum', '消耗数值', '5000', '9');
INSERT INTO `excel_out` VALUES ('com_course', 'cardsTypeName', '会员卡类型', '5000', '8');
INSERT INTO `excel_out` VALUES ('com_course', 'courseDate', '课程日期', '5000', '4');
INSERT INTO `excel_out` VALUES ('com_course', 'endTime', '结束时间', '5000', '6');
INSERT INTO `excel_out` VALUES ('com_course', 'isCheckTxt', '预约验证', '5000', '11');
INSERT INTO `excel_out` VALUES ('com_course', 'isWeekTxt', '每周重复', '5000', '10');
INSERT INTO `excel_out` VALUES ('com_course', 'name', '课程名称', '5000', '1');
INSERT INTO `excel_out` VALUES ('com_course', 'peopleMax', '报名上限', '5000', '7');
INSERT INTO `excel_out` VALUES ('com_course', 'startTime', '开始时间', '5000', '5');
INSERT INTO `excel_out` VALUES ('com_course', 'teacherName', '教师', '5000', '2');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'commentContent', '评价内容', '5000', '7');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'commentLevel', '评价等级', '5000', '6');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'commentTime', '评价时间', '5000', '5');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'memberName', '会员', '5000', '1');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'signTime', '签到时间', '5000', '4');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'statusRemark', '取消预约原因', '5000', '3');
INSERT INTO `excel_out` VALUES ('com_course_enroll', 'statusTxt', '状态', '5000', '2');
INSERT INTO `excel_out` VALUES ('member', 'address', '地址', '5000', '6');
INSERT INTO `excel_out` VALUES ('member', 'email', '电子邮箱', '5000', '5');
INSERT INTO `excel_out` VALUES ('member', 'levelTxt', '会员等级', '5000', '1');
INSERT INTO `excel_out` VALUES ('member', 'name', '姓名', '5000', '2');
INSERT INTO `excel_out` VALUES ('member', 'phone', '电话', '5000', '3');
INSERT INTO `excel_out` VALUES ('member', 'qq', 'QQ', '5000', '4');
INSERT INTO `excel_out` VALUES ('member', 'remark', '备注', '5000', '7');
INSERT INTO `excel_out` VALUES ('sale_performance', 'dgMoney', '导购业绩', '5000', '2');
INSERT INTO `excel_out` VALUES ('sale_performance', 'name', '导购', '5000', '1');
INSERT INTO `excel_out` VALUES ('sale_performance', 'saleMoney', '导购奖金', '5000', '3');
INSERT INTO `excel_out` VALUES ('sale_performance', 'teamMoney', '团队奖金', '5000', '5');
INSERT INTO `excel_out` VALUES ('sale_performance', 'tuanMoney', '团队业绩', '5000', '4');
INSERT INTO `excel_out` VALUES ('sale_performance', 'zMoney', '总奖金', '5000', '6');

-- ----------------------------
-- Table structure for excel_table
-- ----------------------------
DROP TABLE IF EXISTS `excel_table`;
CREATE TABLE `excel_table` (
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `tableName` varchar(100) NOT NULL COMMENT '业务表名称',
  `sysDate` date NOT NULL COMMENT '系统时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表';

-- ----------------------------
-- Records of excel_table
-- ----------------------------
INSERT INTO `excel_table` VALUES ('ENROLL', '预约', '2018-03-02');
INSERT INTO `excel_table` VALUES ('STAFF', '员工', '2019-06-19');

-- ----------------------------
-- Table structure for excel_title
-- ----------------------------
DROP TABLE IF EXISTS `excel_title`;
CREATE TABLE `excel_title` (
  `id` varchar(32) NOT NULL,
  `com_id` varchar(32) DEFAULT NULL,
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `colCode` varchar(36) DEFAULT NULL COMMENT '列CODE',
  `colTitle` varchar(36) DEFAULT NULL COMMENT '自定义名称',
  `width` int(11) DEFAULT '100' COMMENT '宽度',
  `display` int(1) DEFAULT '1' COMMENT '是否显示（1显示、2隐藏）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='excel自定义名称';

-- ----------------------------
-- Records of excel_title
-- ----------------------------
INSERT INTO `excel_title` VALUES ('1', '1', 'ENROLL', 'h1', '姓名', '100', '2');
INSERT INTO `excel_title` VALUES ('2', '1', 'ENROLL', 'h2', '年龄', '100', '2');
INSERT INTO `excel_title` VALUES ('29', '3', 'ENROLL', 'h5', '意外保险', '100', '1');
INSERT INTO `excel_title` VALUES ('3', '1', 'ENROLL', 'h3', '性别', '100', '2');
INSERT INTO `excel_title` VALUES ('30', '9', 'ENROLL', 'h1', '预约名称1', '100', '1');
INSERT INTO `excel_title` VALUES ('31', '9', 'ENROLL', 'h2', '预约名称2', '100', '1');
INSERT INTO `excel_title` VALUES ('32', '9', 'ENROLL', 'h3', '预约名称3', '100', '1');
INSERT INTO `excel_title` VALUES ('33', '9', 'ENROLL', 'h4', '预约名称4', '100', '2');
INSERT INTO `excel_title` VALUES ('34', '11', 'ENROLL', 'h1', '访客姓名', '100', '2');
INSERT INTO `excel_title` VALUES ('35', '11', 'ENROLL', 'h2', '访客性别', '100', '2');
INSERT INTO `excel_title` VALUES ('36', '11', 'ENROLL', 'h3', '访客公司', '100', '2');
INSERT INTO `excel_title` VALUES ('37', '11', 'ENROLL', 'h4', '访客电话', '50', '2');
INSERT INTO `excel_title` VALUES ('38', '11', 'ENROLL', 'h5', '来访事由', '200', '2');
INSERT INTO `excel_title` VALUES ('39', '13', 'ENROLL', 'h1', '访客姓名', '100', '1');
INSERT INTO `excel_title` VALUES ('4', '1', 'ENROLL', 'h4', '地址', '100', '2');
INSERT INTO `excel_title` VALUES ('40', '13', 'ENROLL', 'h2', '访客性别', '100', '1');
INSERT INTO `excel_title` VALUES ('41', '13', 'ENROLL', 'h3', '访客电话', '100', '1');
INSERT INTO `excel_title` VALUES ('42', '13', 'ENROLL', 'h4', '访客公司', '100', '1');
INSERT INTO `excel_title` VALUES ('43', '13', 'ENROLL', 'h5', '来访事由', '200', '1');
INSERT INTO `excel_title` VALUES ('44', '14', 'ENROLL', 'h1', '证件号码', '50', '1');
INSERT INTO `excel_title` VALUES ('5', '3', 'ENROLL', 'h1', '养老保险', '100', '1');
INSERT INTO `excel_title` VALUES ('6', '3', 'ENROLL', 'h2', '公积金', '100', '2');

-- ----------------------------
-- Table structure for excel_tpl
-- ----------------------------
DROP TABLE IF EXISTS `excel_tpl`;
CREATE TABLE `excel_tpl` (
  `tplId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '模版ID',
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `tplType` char(1) NOT NULL COMMENT '模版类型（1EXCEL；2XML；3其他）',
  `tplName` varchar(100) NOT NULL COMMENT '模版名称',
  `titleIndex` int(11) NOT NULL COMMENT '标题行',
  `usable` char(1) NOT NULL COMMENT '是否默认(0否，1是)',
  `sysDate` date NOT NULL COMMENT '系统时间',
  PRIMARY KEY (`tplId`),
  KEY `tplId` (`tplId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='模版';

-- ----------------------------
-- Records of excel_tpl
-- ----------------------------
INSERT INTO `excel_tpl` VALUES ('1', 'ENROLL', '1', '预约', '1', '1', '2018-03-02');
INSERT INTO `excel_tpl` VALUES ('2', 'STAFF', '1', '员工', '1', '1', '2019-06-19');
INSERT INTO `excel_tpl` VALUES ('3', 'COURSE', '1', '课程管理', '1', '1', '2019-09-29');
INSERT INTO `excel_tpl` VALUES ('4', 'MEMBER', '1', '会员管理', '1', '1', '2019-11-13');

-- ----------------------------
-- Table structure for excel_tpl_relation
-- ----------------------------
DROP TABLE IF EXISTS `excel_tpl_relation`;
CREATE TABLE `excel_tpl_relation` (
  `relationId` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '对应关系序号',
  `tplId` int(11) unsigned NOT NULL COMMENT '模版ID',
  `tableCode` varchar(36) NOT NULL COMMENT '业务表CODE',
  `colCode` varchar(36) NOT NULL COMMENT '列CODE',
  `colName` varchar(100) DEFAULT NULL COMMENT '列名称',
  `colType` varchar(20) DEFAULT NULL COMMENT '列类型',
  `colSort` int(11) NOT NULL COMMENT '排序',
  `colTitle` varchar(100) DEFAULT NULL COMMENT '自定义名称',
  `sysDate` date DEFAULT NULL COMMENT '系统时间',
  PRIMARY KEY (`relationId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='对应关系';

-- ----------------------------
-- Records of excel_tpl_relation
-- ----------------------------
INSERT INTO `excel_tpl_relation` VALUES ('1', '0', 'ENROLL', 'h1', null, 'String', '1', null, '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('2', '0', 'ENROLL', 'h2', null, 'String', '1', null, '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('3', '1', 'ENROLL', 'h3', null, 'String', '1', null, '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('4', '1', 'ENROLL', 'h4', null, 'String', '1', null, '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('5', '1', 'ENROLL', 'h5', null, 'String', '1', null, '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('6', '1', 'ENROLL', 'h6', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('7', '1', 'ENROLL', 'h7', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('8', '1', 'ENROLL', 'h8', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('9', '1', 'ENROLL', 'h9', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('10', '1', 'ENROLL', 'h10', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('11', '1', 'ENROLL', 'h11', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('12', '1', 'ENROLL', 'h12', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('13', '1', 'ENROLL', 'h13', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('14', '1', 'ENROLL', 'h14', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('15', '1', 'ENROLL', 'h15', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('16', '1', 'ENROLL', 'h16', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('17', '1', 'ENROLL', 'h17', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('18', '1', 'ENROLL', 'h18', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('19', '1', 'ENROLL', 'h19', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('20', '1', 'ENROLL', 'h20', '', 'String', '1', '', '2018-07-06');
INSERT INTO `excel_tpl_relation` VALUES ('21', '2', 'STAFF', 'name', '姓名', 'String', '1', '姓名', '2019-06-19');
INSERT INTO `excel_tpl_relation` VALUES ('22', '2', 'STAFF', 'password', '密码', 'String', '2', '密码', '2019-06-19');
INSERT INTO `excel_tpl_relation` VALUES ('23', '2', 'STAFF', 'idNumber', '身份证号', 'String', '3', '身份证号', '2019-06-19');
INSERT INTO `excel_tpl_relation` VALUES ('24', '3', 'COURSE', 'name', '课程名称', 'String', '1', '课程名称', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('25', '3', 'COURSE', 'teacherId', '教师', 'String', '2', '教师', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('26', '3', 'COURSE', 'assistantId', '助教', 'String', '3', '助教', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('27', '3', 'COURSE', 'courseDate', '课程日期(例:2019-01-30)', 'Date', '4', '课程日期(例:2019-01-30)', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('28', '3', 'COURSE', 'startTime', '开始时间(例:23:59)', 'Date', '5', '开始时间(例:23:59)', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('29', '3', 'COURSE', 'endTime', '结束时间(例:23:59)', 'Date', '6', '结束时间(例:23:59)', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('30', '3', 'COURSE', 'peopleMax', '报名上限', 'Long', '7', '报名上限', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('33', '3', 'COURSE', 'isWeek', '每周重复', 'String', '8', '每周重复', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('34', '3', 'COURSE', 'isCheck', '验证预约', 'String', '9', '验证预约', '2019-09-29');
INSERT INTO `excel_tpl_relation` VALUES ('35', '4', 'MEMBER', 'levelTxt', '会员级别', 'String', '1', '会员级别', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('36', '4', 'MEMBER', 'name', '姓名', 'String', '2', '姓名', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('37', '4', 'MEMBER', 'phone', '手机', 'String', '3', '手机', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('38', '4', 'MEMBER', 'qq', 'QQ', 'String', '4', 'QQ', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('39', '4', 'MEMBER', 'email', '电子邮箱', 'String', '5', '电子邮箱', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('40', '4', 'MEMBER', 'address', '地址', 'String', '6', '地址', '2019-11-13');
INSERT INTO `excel_tpl_relation` VALUES ('41', '4', 'MEMBER', 'remark', '备注', 'String', '7', '备注', '2019-11-13');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `open_id` varchar(32) DEFAULT NULL COMMENT '用户openId',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(30) DEFAULT NULL COMMENT '手机',
  `sex` char(1) DEFAULT NULL COMMENT '性别（1男、2女）',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `qq` varchar(30) DEFAULT NULL COMMENT 'QQ',
  `email` varchar(30) DEFAULT NULL COMMENT '电子邮件',
  `address` varchar(60) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`),
  KEY `pk_member_openId` (`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1181743349920227328', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'wew11', '', '1', '2019-11-02', '123', '123', '123');
INSERT INTO `member` VALUES ('1181810303455096832', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '赵怡博', '', null, null, '4', '4', '4');
INSERT INTO `member` VALUES ('1182449461081485312', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'vip1', '', null, null, '123', '123', '123');
INSERT INTO `member` VALUES ('1182449526177083392', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'vip2', '', null, null, '123', '123', '123');
INSERT INTO `member` VALUES ('1182451997498187776', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'baiduVip1', '', null, null, '123', '123', '123');
INSERT INTO `member` VALUES ('1182452072672698368', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'baiduVip2', '', null, null, '123', '123', '123');
INSERT INTO `member` VALUES ('1183288088536502272', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '李勋语', '', null, null, '3', '4', '5');
INSERT INTO `member` VALUES ('1183289109110308864', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '周唯朗', '', null, null, '1', '1', '1');
INSERT INTO `member` VALUES ('1184661287847669761', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员1', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1184661287847669762', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员2', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1184661287847669763', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员3', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1184661287847669764', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员4', '', null, null, '', '', '');
INSERT INTO `member` VALUES ('1184663302026170368', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员1', '', null, null, '11', '111', '111');
INSERT INTO `member` VALUES ('1184670928539410432', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'dasdasd', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1184724305806987264', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员卡用户一', '', null, null, '11', '11', '11');
INSERT INTO `member` VALUES ('1184724355257831424', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员卡用户二', '', null, null, '22', '22', '22');
INSERT INTO `member` VALUES ('1184724412401029120', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员卡用户三', '', null, null, '33', '33', '33');
INSERT INTO `member` VALUES ('1184741502526894080', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '1', '', null, null, '1', '1', '1');
INSERT INTO `member` VALUES ('1184749500673347584', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '奔驰会员', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1185441978328911872', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '王老五', '', null, null, '', '', '');
INSERT INTO `member` VALUES ('1185443676340854784', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '1', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1185448846734766080', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '1', '', null, null, '', '', '');
INSERT INTO `member` VALUES ('1186840763080249344', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '会员5', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1188731936377753600', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '123', '', null, null, '123', '123', '123');
INSERT INTO `member` VALUES ('1191182957004136448', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '6', '', null, null, '', '', '');
INSERT INTO `member` VALUES ('1191217964625125376', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'a', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1191218086037643264', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'c', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1191593263232618496', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '知乎', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1191594604220973056', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'csdn', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1192669039138689024', 'oCj6KsyWMz2LpPU4SP2EOq_sVNsw', '1', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1192985670917238784', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '1', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1193049208589189120', null, '2', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1193049224326217728', null, '3', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1193049235327877120', null, '4', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1193049246358896640', null, '5', '', null, null, null, null, null);
INSERT INTO `member` VALUES ('1194517092699344896', null, 'aaa', '18940863761', null, null, '11', '11', '');
INSERT INTO `member` VALUES ('1194518409677246464', null, 'aaa2', '13812341234', null, null, '11', '11', '11');
INSERT INTO `member` VALUES ('1194519167819337728', null, '11', '13812341235', null, null, null, null, null);
INSERT INTO `member` VALUES ('1194519995245932544', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', 'bbb1', '13812341111', null, null, '11', '11', '11');
INSERT INTO `member` VALUES ('1194600155918004224', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '程旭-骏骁网络', null, '1', null, null, null, null);
INSERT INTO `member` VALUES ('1194881841535229952', 'ou5CDwJnp9ki2LFqvQwFirxtueP0', '程旭-骏骁网络', null, '1', null, null, null, null);

-- ----------------------------
-- Table structure for member_card
-- ----------------------------
DROP TABLE IF EXISTS `member_card`;
CREATE TABLE `member_card` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `card_id` varchar(32) DEFAULT NULL COMMENT '会员卡id',
  `card_name` varchar(255) DEFAULT NULL COMMENT '会员卡名称',
  `stored_all` decimal(10,2) DEFAULT NULL COMMENT '总次数/总余额',
  `stored_num` decimal(10,2) DEFAULT NULL COMMENT '目前剩余次/余额',
  `invalid_time` date DEFAULT NULL COMMENT '失效日期',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员卡记录';

-- ----------------------------
-- Records of member_card
-- ----------------------------
INSERT INTO `member_card` VALUES ('1191944573175869440', '0', '1191593263232618496', '1186468419585884160', '水月教育卡', '30000.00', '30000.00', '2019-12-06', 'junAdmin', '2019-11-06 13:05:06', 'junAdmin', '2019-11-06 13:05:06');
INSERT INTO `member_card` VALUES ('1191952031218806784', '0', '1191593263232618496', '1185440017697312768', '储值卡1000', '1000.00', '1000.00', '2019-12-26', 'junAdmin', '2019-11-06 13:34:44', 'junAdmin', '2019-11-06 13:34:44');
INSERT INTO `member_card` VALUES ('1191956081345486848', '0', '1191593263232618496', '1186468419585884160', '水月教育卡', '30000.00', '30000.00', '2019-12-06', 'junAdmin', '2019-11-06 13:50:50', 'junAdmin', '2019-11-06 13:50:50');
INSERT INTO `member_card` VALUES ('1191956122613243904', '0', '1191594604220973056', '1186468419585884160', '水月教育卡', '30000.00', '30000.00', '2019-12-06', 'junAdmin', '2019-11-06 13:51:00', 'junAdmin', '2019-11-06 13:51:00');
INSERT INTO `member_card` VALUES ('1191956478239891456', '0', '1191593263232618496', '1186472623293513728', '白金卡', '1111.00', '1111.00', '2022-11-21', 'junAdmin', '2019-11-06 13:52:25', 'junAdmin', '2019-11-06 13:52:25');
INSERT INTO `member_card` VALUES ('1192342020473552896', '0', '1191593263232618496', '1186472623293513728', '白金卡', '1111.00', '1111.00', '2022-11-22', 'junAdmin', '2019-11-07 15:24:25', 'junAdmin', '2019-11-07 15:24:25');
INSERT INTO `member_card` VALUES ('1192342089599877120', '0', '1191593263232618496', '1191585955874398208', 'asd', '11.00', '11.00', '2019-11-18', 'junAdmin', '2019-11-07 15:24:41', 'junAdmin', '2019-11-07 15:24:41');
INSERT INTO `member_card` VALUES ('1192344803252682752', '0', '1191594604220973056', '1191585955874398208', 'asd', '11.00', '11.00', '2019-11-18', 'junAdmin', '2019-11-07 15:35:28', 'junAdmin', '2019-11-07 15:35:28');
INSERT INTO `member_card` VALUES ('1192344931044737024', '0', '1191594604220973056', '1191585955874398208', 'asd', '11.00', '11.00', '2019-11-18', 'junAdmin', '2019-11-07 15:35:59', 'junAdmin', '2019-11-07 15:35:59');
INSERT INTO `member_card` VALUES ('1192345644263231488', '0', '1191594604220973056', '1191585955874398208', 'asd', '11.00', '11.00', '2019-11-18', 'junAdmin', '2019-11-07 15:38:49', 'junAdmin', '2019-11-07 15:38:49');
INSERT INTO `member_card` VALUES ('1192345984492781568', '0', '1191594604220973056', '1191585955874398208', 'asd', '11.00', '10.00', '2019-11-18', 'junAdmin', '2019-11-07 15:40:10', 'junAdmin', '2019-11-07 15:40:10');
INSERT INTO `member_card` VALUES ('1195155973849268224', 'zhao', '1191218086037643264', '1184664162535550976', '古河', '200.00', '197.00', '2020-02-23', 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04');

-- ----------------------------
-- Table structure for member_card_change
-- ----------------------------
DROP TABLE IF EXISTS `member_card_change`;
CREATE TABLE `member_card_change` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `mc_id` varchar(32) NOT NULL COMMENT '会员卡记录',
  `member_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `type` char(1) DEFAULT NULL COMMENT '记录类型（1消耗，2储值，3赠送，4失效）',
  `stored_num` decimal(10,2) DEFAULT NULL COMMENT '次数/金额',
  `stored_new` decimal(10,2) DEFAULT NULL COMMENT '新次数',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员卡消费明细表';

-- ----------------------------
-- Records of member_card_change
-- ----------------------------
INSERT INTO `member_card_change` VALUES ('1184727182201950208', 'ali', '1184726867171971072', '1184724412401029120', '1', '1.00', '10.00', 'aliali_PRJT', '2019-10-17 15:05:46', 'aliali_PRJT', '2019-10-17 15:05:46');
INSERT INTO `member_card_change` VALUES ('1184727269644800000', 'ali', '1184726649646977024', '1184724412401029120', '2', '1.00', '999.00', 'aliali_PRJT', '2019-10-17 15:06:07', 'aliali_PRJT', '2019-10-18 08:24:10');
INSERT INTO `member_card_change` VALUES ('1184740020171780096', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '0.00', 'wangxi_DOUW', '2019-10-17 15:56:47', 'wangxi_DOUW', '2019-10-17 15:56:47');
INSERT INTO `member_card_change` VALUES ('1184740070411153408', 'wangxi', '1184732079463583744', '1184670928539410432', '3', '1000.00', '1000.00', 'wangxi_DOUW', '2019-10-17 15:56:59', 'wangxi_DOUW', '2019-10-17 15:56:59');
INSERT INTO `member_card_change` VALUES ('1184740142020505600', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '999.00', 'wangxi_DOUW', '2019-10-17 15:57:16', 'wangxi_DOUW', '2019-10-17 15:57:16');
INSERT INTO `member_card_change` VALUES ('1184740158957105152', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '998.00', 'wangxi_DOUW', '2019-10-17 15:57:20', 'wangxi_DOUW', '2019-10-17 15:57:20');
INSERT INTO `member_card_change` VALUES ('1184740173377122304', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '997.00', 'wangxi_DOUW', '2019-10-17 15:57:23', 'wangxi_DOUW', '2019-10-17 15:57:23');
INSERT INTO `member_card_change` VALUES ('1184740185716764672', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '996.00', 'wangxi_DOUW', '2019-10-17 15:57:26', 'wangxi_DOUW', '2019-10-17 15:57:26');
INSERT INTO `member_card_change` VALUES ('1184740224803483648', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '995.00', 'wangxi_DOUW', '2019-10-17 15:57:36', 'wangxi_DOUW', '2019-10-17 15:57:36');
INSERT INTO `member_card_change` VALUES ('1184740310686052352', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '994.00', 'wangxi_DOUW', '2019-10-17 15:57:56', 'wangxi_DOUW', '2019-10-17 15:57:56');
INSERT INTO `member_card_change` VALUES ('1184740363630751744', 'wangxi', '1184732079463583744', '1184670928539410432', '4', '994.00', '0.00', 'wangxi_DOUW', '2019-10-17 15:58:09', 'wangxi_DOUW', '2019-10-17 15:58:09');
INSERT INTO `member_card_change` VALUES ('1184751585574789120', 'ali', '1184745730949210112', '1184724412401029120', '2', '10.00', '1010.00', 'aliali_PRJT', '2019-10-17 16:42:44', 'aliali_PRJT', '2019-10-18 08:23:53');
INSERT INTO `member_card_change` VALUES ('1184751739146616832', 'zhao', '1184743233795489792', '1184669989896007680', '1', '10.00', '190.00', 'zhao_I95W', '2019-10-17 16:43:21', 'zhao_I95W', '2019-10-17 16:43:21');
INSERT INTO `member_card_change` VALUES ('1184751781684928512', 'wangxi', '1184732079463583744', '1184670928539410432', '3', '1.00', '1.00', 'wangxi_DOUW', '2019-10-17 16:43:31', 'wangxi_DOUW', '2019-10-17 16:43:31');
INSERT INTO `member_card_change` VALUES ('1184751878871465984', 'zhao', '1184743233795489792', '1184669989896007680', '1', '10.00', '180.00', 'zhao_I95W', '2019-10-17 16:43:54', 'zhao_I95W', '2019-10-17 16:43:54');
INSERT INTO `member_card_change` VALUES ('1184752301166256128', 'wangxi', '1184732079463583744', '1184670928539410432', '1', '1.00', '0.00', 'wangxi_DOUW', '2019-10-17 16:45:35', 'wangxi_DOUW', '2019-10-17 16:45:35');
INSERT INTO `member_card_change` VALUES ('1184754845515268096', 'zhao', '1184743233795489792', '1191182957004136448', '1', '10.00', '170.00', 'zhao_I95W', '2019-10-17 16:55:42', 'zhao_I95W', '2019-11-04 11:09:58');
INSERT INTO `member_card_change` VALUES ('1184986751683698688', 'ali', '1184745730949210112', '1184724305806987264', '4', '2.00', '999.00', 'aliali_PRJT', '2019-10-18 08:17:12', 'aliali_PRJT', '2019-10-18 08:33:29');
INSERT INTO `member_card_change` VALUES ('1184991030817497088', 'ali', '1184745730949210112', '1184724305806987264', '4', '101.00', '0.00', 'aliali_PRJT', '2019-10-18 08:34:12', 'aliali_PRJT', '2019-10-18 08:38:59');
INSERT INTO `member_card_change` VALUES ('1184997312865673216', 'ali', '1184726649646977024', '1184724412401029120', '1', '11.00', '988.00', 'aliali_PRJT', '2019-10-18 08:59:10', 'aliali_PRJT', '2019-10-18 08:59:10');
INSERT INTO `member_card_change` VALUES ('1185020757789466624', 'ali', '1184991181367844864', '1184724412401029120', '4', '444.00', '0.00', 'aliali_PRJT', '2019-10-18 10:32:20', 'aliali_PRJT', '2019-10-18 10:32:20');
INSERT INTO `member_card_change` VALUES ('1185114986598641664', '0', '1185114881464217600', '1183289109110308864', '1', '1.00', '29.00', 'junAdmin', '2019-10-18 16:46:46', 'junAdmin', '2019-10-18 16:46:46');
INSERT INTO `member_card_change` VALUES ('1191191236449198080', 'zhao', '1191191206933880832', '1191182957004136448', '1', '22.00', '178.00', 'zhao_I95W', '2019-11-04 11:11:37', 'zhao_I95W', '2019-11-04 11:11:37');
INSERT INTO `member_card_change` VALUES ('1191596574091157504', '0', '1191593841310302208', '1191593263232618496', '1', '1.00', '10.00', 'junAdmin', '2019-11-05 14:02:17', 'junAdmin', '2019-11-05 14:02:17');
INSERT INTO `member_card_change` VALUES ('1191596819034275840', '0', '1191593841310302208', '1191593263232618496', '1', '1.00', '9.00', 'junAdmin', '2019-11-05 14:03:15', 'junAdmin', '2019-11-05 14:03:15');
INSERT INTO `member_card_change` VALUES ('1191600121795080192', '0', '1191593841310302208', '1191593263232618496', '1', '1.00', '8.00', 'junAdmin', '2019-11-05 14:16:23', 'junAdmin', '2019-11-05 14:16:23');
INSERT INTO `member_card_change` VALUES ('1191625161586085888', '0', '1191593841310302208', '1191594604220973056', '1', '1.00', '7.00', 'junAdmin', '2019-11-05 15:55:53', 'junAdmin', '2019-11-05 15:55:53');
INSERT INTO `member_card_change` VALUES ('1191625788883841024', '0', '1191593841310302208', '1191594604220973056', '1', '1.00', '6.00', 'junAdmin', '2019-11-05 15:58:22', 'junAdmin', '2019-11-05 15:58:22');
INSERT INTO `member_card_change` VALUES ('1191625832366190592', '0', '1191593841310302208', '1191594604220973056', '1', '1.00', '5.00', 'junAdmin', '2019-11-05 15:58:32', 'junAdmin', '2019-11-05 15:58:32');
INSERT INTO `member_card_change` VALUES ('1191625988847681536', '0', '1191593841310302208', '1191594604220973056', '3', '1.00', '6.00', 'junAdmin', '2019-11-05 15:59:10', 'junAdmin', '2019-11-05 15:59:10');
INSERT INTO `member_card_change` VALUES ('1191626088743419904', '0', '1191593841310302208', '1191594604220973056', '3', '1.00', '7.00', 'junAdmin', '2019-11-05 15:59:34', 'junAdmin', '2019-11-05 15:59:34');
INSERT INTO `member_card_change` VALUES ('1192349000367828992', '0', '1192345984492781568', '1191594604220973056', '1', '1.00', '10.00', 'junAdmin', '2019-11-07 15:52:09', 'junAdmin', '2019-11-07 15:52:09');
INSERT INTO `member_card_change` VALUES ('1195156052576354304', 'zhao', '1195155973849268224', '1191218086037643264', '1', '1.00', '199.00', 'zhao_I95W', '2019-11-15 09:46:23', 'zhao_I95W', '2019-11-15 09:46:23');
INSERT INTO `member_card_change` VALUES ('1196231501978927104', 'zhao', '1195155973849268224', '1191218086037643264', '1', '2.00', '197.00', 'zhao_I95W', '2019-11-18 08:59:50', 'zhao_I95W', '2019-11-18 08:59:50');

-- ----------------------------
-- Table structure for member_card_user
-- ----------------------------
DROP TABLE IF EXISTS `member_card_user`;
CREATE TABLE `member_card_user` (
  `id` varchar(32) NOT NULL COMMENT '自增id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `change_id` varchar(32) DEFAULT NULL COMMENT '消费记录主键',
  `user_id` varchar(32) DEFAULT NULL COMMENT '提成用户id',
  `stored_num` decimal(10,2) DEFAULT NULL COMMENT '次数/金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消耗服务人员';

-- ----------------------------
-- Records of member_card_user
-- ----------------------------
INSERT INTO `member_card_user` VALUES ('1184727182210338816', 'ali', '1184727182201950208', '9999_F8RR', '1.00');
INSERT INTO `member_card_user` VALUES ('1184727269653188608', 'ali', '1184727269644800000', '9999_F8RR', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740224828649472', 'wangxi', '1184740224803483648', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740224862203904', 'wangxi', '1184740224803483648', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740224874786816', 'wangxi', '1184740224803483648', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740310702829568', 'wangxi', '1184740310686052352', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740310719606784', 'wangxi', '1184740310686052352', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184740310736384000', 'wangxi', '1184740310686052352', 'asda_5HRC', '1.00');
INSERT INTO `member_card_user` VALUES ('1184751739163394048', 'zhao', '1184751739146616832', 'zhao1_670P', '10.00');
INSERT INTO `member_card_user` VALUES ('1184986751696281600', 'ali', '1184986751683698688', '9999_F8RR', '1.00');

-- ----------------------------
-- Table structure for member_growup
-- ----------------------------
DROP TABLE IF EXISTS `member_growup`;
CREATE TABLE `member_growup` (
  `id` varchar(32) NOT NULL COMMENT '主键标识',
  `com_id` varchar(32) DEFAULT NULL COMMENT '公司ID',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员id',
  `content` varchar(500) DEFAULT NULL COMMENT '日记',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='成长记录';

-- ----------------------------
-- Records of member_growup
-- ----------------------------
INSERT INTO `member_growup` VALUES ('1187532357678637056', null, '1181743349920227328', '782782782', null, '2019-10-25 08:52:32', null, '2019-10-25 08:52:32');
INSERT INTO `member_growup` VALUES ('1187551121724571648', null, '1181743349920227328', '水电费楼上的了那是打飞机克鲁赛德经理发动机收到了粉丝的东方嘉盛圣诞节发送到发水电费圣诞节收到福建省代理费是的飞机上的了发坚实的纠纷时口袋里', null, '2019-10-25 10:07:06', null, '2019-10-25 10:07:06');
INSERT INTO `member_growup` VALUES ('1187551239089586176', null, '1181743349920227328', '时间飞逝副驾驶的方式司法局胜多负少的谁开的房间号四大发明收到收到发圣诞节发送到发时代峰峻时间飞逝副驾驶的方式司法局胜多负少的谁开的房间号四大发明收到收到发圣诞节发送到发时代峰峻时间飞逝副驾驶的方式司法局胜多负少的谁开的房间号四大发明收到收到发圣诞节发送到发时代峰峻时间飞逝副驾驶的方式司法局胜多负少的谁开的房间号四大发明收到收到发圣诞节发送到发时代峰峻时间飞逝副驾驶的方式司法局胜多负少的谁开的房间号', null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34');
INSERT INTO `member_growup` VALUES ('1187562279483375616', null, '1181743349920227328', '水电费是的是', null, '2019-10-25 10:51:26', null, '2019-10-25 10:51:26');
INSERT INTO `member_growup` VALUES ('1187563838254514176', null, '1181743349920227328', '是的是的发生', null, '2019-10-25 10:57:38', null, '2019-10-25 10:57:38');
INSERT INTO `member_growup` VALUES ('1187564079913533440', null, '1181743349920227328', '订单', null, '2019-10-25 10:58:35', null, '2019-10-25 10:58:35');
INSERT INTO `member_growup` VALUES ('1187564528477569024', null, '1181743349920227328', '哒哒哒哒哒哒', null, '2019-10-25 11:00:22', null, '2019-10-25 11:00:22');
INSERT INTO `member_growup` VALUES ('1187564598610526208', null, '1181743349920227328', '电饭锅梵蒂冈梵蒂冈梵蒂冈放到放到放到发过的放到放到放到放到', null, '2019-10-25 11:00:39', null, '2019-10-25 11:00:39');
INSERT INTO `member_growup` VALUES ('1190432653403394048', null, '1181743349920227328', '梵蒂冈梵蒂冈反对党', null, '2019-11-02 08:57:16', null, '2019-11-02 08:57:16');
INSERT INTO `member_growup` VALUES ('1190433134750109696', null, '1181743349920227328', '梵蒂冈放到大富大贵梵蒂冈梵蒂冈发的公司根深蒂固割发代首发的广泛地割发代首十多个梵蒂冈放到三四个反倒是官方的故事地方的梵蒂冈放到大富大贵梵蒂冈梵蒂冈发的公司根深蒂固割发代首发的广泛地割发代首十多个梵蒂冈放到三四个反倒是官方的故事地方的梵蒂冈放到大富大贵梵蒂冈梵蒂冈发的公司根深蒂固割发代首发的广泛地割发代首十多个梵蒂冈放到三四个反倒是官方的故事地方的梵蒂冈放到大富大贵梵蒂冈梵蒂冈发的公司根深蒂固割发代', null, '2019-11-02 08:59:11', null, '2019-11-02 08:59:11');
INSERT INTO `member_growup` VALUES ('1190464120662224896', null, '1181743349920227328', 'dfgfdgfdgfd', null, '2019-11-02 11:02:19', null, '2019-11-02 11:02:19');
INSERT INTO `member_growup` VALUES ('1190464151456804864', null, '1181743349920227328', 'ddddddfdfdfdf', null, '2019-11-02 11:02:26', null, '2019-11-02 11:02:26');
INSERT INTO `member_growup` VALUES ('1190469371555364864', null, '1181743349920227328', '梵蒂冈梵蒂冈发的', null, '2019-11-02 11:23:11', null, '2019-11-02 11:23:11');
INSERT INTO `member_growup` VALUES ('1190469449846243328', null, '1181743349920227328', '的水电费水电费水电费', null, '2019-11-02 11:23:29', null, '2019-11-02 11:23:29');
INSERT INTO `member_growup` VALUES ('1190469486781284352', null, '1181743349920227328', '说是的发送到收到s', null, '2019-11-02 11:23:38', null, '2019-11-02 11:23:38');

-- ----------------------------
-- Table structure for member_level
-- ----------------------------
DROP TABLE IF EXISTS `member_level`;
CREATE TABLE `member_level` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '公司ID',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `ratio` decimal(10,1) DEFAULT NULL COMMENT '折扣率',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员级别';

-- ----------------------------
-- Records of member_level
-- ----------------------------
INSERT INTO `member_level` VALUES ('1177374737450741760', '7777777', '钻石会员', '0.5', '1', '1', '2019-09-27 08:09:47', 'junAdmin', '2019-10-08 08:59:44');
INSERT INTO `member_level` VALUES ('1177378394241122304', '2', '铂金会员', '0.6', '2', '1', '2019-09-27 08:24:18', 'junAdmin', '2019-10-08 08:59:42');
INSERT INTO `member_level` VALUES ('1177424550302380032', '1', '白金会员', '0.7', '3', '1', '2019-09-27 11:27:43', 'junAdmin', '2019-10-08 08:59:40');
INSERT INTO `member_level` VALUES ('1177427424935735296', '1', '黑金会员', '0.4', '1', '1', '2019-09-27 11:39:08', 'junAdmin', '2019-10-08 08:59:38');
INSERT INTO `member_level` VALUES ('1183201371552014336', '0', '青铜', '9.8', '青铜折扣', 'junAdmin', '2019-10-13 10:02:44', 'junAdmin', '2019-10-13 10:29:26');
INSERT INTO `member_level` VALUES ('1183216943374172160', '0', '王者', '8.0', null, 'junAdmin', '2019-10-13 11:04:37', 'junAdmin', '2019-10-13 11:04:37');
INSERT INTO `member_level` VALUES ('1184659034076164096', 'zhao', '微者', '9.0', null, 'zhao_I95W', '2019-10-17 10:34:58', 'zhao_I95W', '2019-10-17 10:34:58');
INSERT INTO `member_level` VALUES ('1184659091286470656', 'zhao', '微师', '8.0', null, 'zhao_I95W', '2019-10-17 10:35:12', 'zhao_I95W', '2019-10-17 10:35:12');
INSERT INTO `member_level` VALUES ('1184659156608561152', 'zhao', '微灵', '7.0', null, 'zhao_I95W', '2019-10-17 10:35:27', 'zhao_I95W', '2019-10-17 10:35:27');
INSERT INTO `member_level` VALUES ('1184659226072846336', 'wangxi', '1', '9.7', '一级用户', 'wangxi_DOUW', '2019-10-17 10:35:44', 'wangxi_DOUW', '2019-10-17 10:37:06');
INSERT INTO `member_level` VALUES ('1184660461085401088', 'ali', '黑钻', '0.7', '111', 'aliali_PRJT', '2019-10-17 10:40:39', 'aliali_PRJT', '2019-10-17 10:40:39');
INSERT INTO `member_level` VALUES ('1184660514294341632', 'ali', '蓝钻', '0.2', '222', 'aliali_PRJT', '2019-10-17 10:40:51', 'aliali_PRJT', '2019-10-17 10:40:51');
INSERT INTO `member_level` VALUES ('1184749435716161536', '88888', '普通', '10.0', null, '88888_OUZ1', '2019-10-17 16:34:12', '88888_OUZ1', '2019-10-17 16:34:12');
INSERT INTO `member_level` VALUES ('1185439871601315840', '0', '钻石', '9.5', null, 'junAdmin', '2019-10-19 14:17:44', 'junAdmin', '2019-10-19 14:17:44');
INSERT INTO `member_level` VALUES ('1185442801078702080', '0', '阿斯达', '1.0', null, 'junAdmin', '2019-10-19 14:29:23', 'junAdmin', '2019-10-19 14:29:23');
INSERT INTO `member_level` VALUES ('1191173140506611712', 'zhao', '微皇', '5.0', null, 'zhao_I95W', '2019-11-04 09:59:42', 'zhao_I95W', '2019-11-04 09:59:42');
INSERT INTO `member_level` VALUES ('1192669018905366528', 'baidu', '1', '1.0', null, 'baidu_GN5E', '2019-11-08 13:03:47', 'baidu_GN5E', '2019-11-08 13:03:47');
INSERT INTO `member_level` VALUES ('1194792691571826688', 'zzf', '多少', '2.0', null, 'zzf123_ML76', '2019-11-14 09:42:31', 'zzf123_ML76', '2019-11-14 09:42:31');

-- ----------------------------
-- Table structure for member_points
-- ----------------------------
DROP TABLE IF EXISTS `member_points`;
CREATE TABLE `member_points` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '关联id',
  `biz_type` char(1) DEFAULT NULL COMMENT '关联类型（1消费、2课程签到、3活动签到、4赠送）',
  `type` char(1) DEFAULT NULL COMMENT '类型(1增加、2扣除）',
  `num` decimal(10,2) DEFAULT '0.00' COMMENT '积分',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分记录';

-- ----------------------------
-- Records of member_points
-- ----------------------------
INSERT INTO `member_points` VALUES ('1188732087850848256', '0', '1188731936377753600', null, '1', '1', '219.32', null, 'junAdmin', '2019-10-28 16:19:50', 'junAdmin', '2019-10-28 16:19:50');
INSERT INTO `member_points` VALUES ('1191190764732604416', 'zhao', '1191182957004136448', null, '1', '1', '1.00', null, 'zhao_I95W', '2019-11-04 11:09:44', 'zhao_I95W', '2019-11-04 11:09:44');
INSERT INTO `member_points` VALUES ('1191191206879354880', 'zhao', '1191182957004136448', null, '1', '1', '8.00', null, 'zhao_I95W', '2019-11-04 11:11:30', 'zhao_I95W', '2019-11-04 11:11:30');
INSERT INTO `member_points` VALUES ('1191219490139627520', 'zhao', '1191217964625125376', null, '1', '1', '1.00', null, 'zhao_I95W', '2019-11-04 13:03:53', 'zhao_I95W', '2019-11-04 13:03:53');
INSERT INTO `member_points` VALUES ('1195155973278842880', 'zhao', '1191218086037643264', null, '1', '1', '2.00', null, 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04');

-- ----------------------------
-- Table structure for sale_member
-- ----------------------------
DROP TABLE IF EXISTS `sale_member`;
CREATE TABLE `sale_member` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '导购',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导购客户';

-- ----------------------------
-- Records of sale_member
-- ----------------------------
INSERT INTO `sale_member` VALUES ('1186441252058890240', 'zhao', 'dao_1', '1184661287847669761');
INSERT INTO `sale_member` VALUES ('1186441284724129792', 'zhao', 'dao_2', '1184661287847669762');
INSERT INTO `sale_member` VALUES ('1186441307381760000', 'zhao', 'dao_3', '1184661287847669763');
INSERT INTO `sale_member` VALUES ('1186441332337868800', 'zhao', 'dao_4', '1184661287847669764');
INSERT INTO `sale_member` VALUES ('1186840804134096896', 'zhao', 'dao_3', '1186840763080249344');
INSERT INTO `sale_member` VALUES ('1187192347560796160', '0', 'qwer2_9ING', '1185441978328911872');
INSERT INTO `sale_member` VALUES ('1187193042963816448', '0', 'qwer4_UG7F', '1183289109110308864');
INSERT INTO `sale_member` VALUES ('1191187256583184384', 'zhao', 'dao_10_287U', '1191182957004136448');

-- ----------------------------
-- Table structure for sale_team
-- ----------------------------
DROP TABLE IF EXISTS `sale_team`;
CREATE TABLE `sale_team` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售团队';

-- ----------------------------
-- Records of sale_team
-- ----------------------------
INSERT INTO `sale_team` VALUES ('1182862125489799161', 'zhao', 'dao_1', '0', '0,', '1', '00000001,', '0', '0', 'dao_1', 'junAdmin', '2019-10-12 11:34:42', 'junAdmin', '2019-10-12 11:34:42');
INSERT INTO `sale_team` VALUES ('1185028087466356736', 'zhao', 'dao_3', '1182862125489799161', '0,1182862125489799161,', '2', '00000001,00000002', '0', '1', 'dao_1/导购3', 'zhao_I95W', '2019-10-18 11:01:27', 'zhao_I95W', '2019-10-18 11:01:27');
INSERT INTO `sale_team` VALUES ('1185028168185737216', 'zhao', 'dao_4', '1185028087466356736', '0,1182862125489799161,1185028087466356736,', '1', '00000001,0000000200000001', '1', '2', 'dao_1/导购3/导购4', 'zhao_I95W', '2019-10-18 11:01:47', 'zhao_I95W', '2019-10-18 11:01:47');
INSERT INTO `sale_team` VALUES ('1185035240054284288', 'ali', '6666_2KWT', '0', '0,', '1', '00000001,', '0', '0', '导购二', 'aliali_PRJT', '2019-10-18 11:29:53', 'aliali_PRJT', '2019-10-18 11:29:53');
INSERT INTO `sale_team` VALUES ('1185035285440847872', 'ali', '3333_KEOI', '1185035240054284288', '0,1185035240054284288,', '1', '00000001,00000001', '1', '1', '导购二/导购一', 'aliali_PRJT', '2019-10-18 11:30:04', 'aliali_PRJT', '2019-10-18 11:30:04');
INSERT INTO `sale_team` VALUES ('1186440688671588352', '0', 'qwer_4NPG', '0', '0,', '1', '00000001,', '0', '0', '导购1', 'junAdmin', '2019-10-22 08:34:38', 'junAdmin', '2019-10-22 08:34:38');
INSERT INTO `sale_team` VALUES ('1186440715611602944', '0', 'qwer3_VPXP', '1186440688671588352', '0,1186440688671588352,', '1', '00000001,00000001', '1', '1', '导购1/导购3', 'junAdmin', '2019-10-22 08:34:44', 'junAdmin', '2019-10-22 08:34:44');
INSERT INTO `sale_team` VALUES ('1186440737283571712', '0', 'qwer2_9ING', '1186440688671588352', '0,1186440688671588352,', '2', '00000001,00000002', '0', '1', '导购1/导购2', 'junAdmin', '2019-10-22 08:34:49', 'junAdmin', '2019-10-29 16:04:39');
INSERT INTO `sale_team` VALUES ('1186505547743092736', 'zhao', 'dao_2', '1185028087466356736', '0,1182862125489799161,1185028087466356736,', '2', '00000001,0000000200000002', '1', '2', 'dao_1/导购3/导购2', 'zhao_I95W', '2019-10-22 12:52:21', 'zhao_I95W', '2019-10-22 12:52:21');
INSERT INTO `sale_team` VALUES ('1189089744952696832', '0', 'qwer4_UG7F', '1186440737283571712', '0,1186440688671588352,1186440737283571712,', '1', '00000001,0000000200000001', '0', '2', '导购1/导购2/导购4', 'junAdmin', '2019-10-29 16:01:02', 'junAdmin', '2019-10-29 16:15:00');
INSERT INTO `sale_team` VALUES ('1191187208738758656', 'zhao', 'dao_10_287U', '1185028087466356736', '0,1182862125489799161,1185028087466356736,', '3', '00000001,0000000200000003', '1', '2', 'dao_1/导购3/12', 'zhao_I95W', '2019-11-04 10:55:36', 'zhao_I95W', '2019-11-04 10:55:36');

-- ----------------------------
-- Table structure for shop_gift
-- ----------------------------
DROP TABLE IF EXISTS `shop_gift`;
CREATE TABLE `shop_gift` (
  `id` varchar(32) NOT NULL COMMENT '礼物ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `gift_type_id` varchar(32) DEFAULT NULL COMMENT '礼物类别',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `points` int(11) DEFAULT NULL COMMENT '所需积分',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `img` varchar(255) DEFAULT NULL COMMENT '封面图片',
  `content` longtext COMMENT '描述',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分商品';

-- ----------------------------
-- Records of shop_gift
-- ----------------------------
INSERT INTO `shop_gift` VALUES ('1177392214035136512', '1', '家电', '热水器', '1000', '100', '1', '1', '1', '1', '2019-09-27 09:19:13', 'junAdmin', '2019-09-27 16:50:51');
INSERT INTO `shop_gift` VALUES ('1177489819251089408', null, '家电', '微波炉', '2000', '30', null, '11', '11', '1', '2019-09-27 15:47:04', 'junAdmin', '2019-09-27 16:50:39');
INSERT INTO `shop_gift` VALUES ('1177490185233891328', null, '洗浴用品', '悦诗风吟套装', '50', '100', null, '11', '11', '1', '2019-09-27 15:48:32', 'junAdmin', '2019-09-27 16:50:26');
INSERT INTO `shop_gift` VALUES ('1177500845295464448', '1', '洗浴用品', '沙宣护发素', '50', '100', null, '88', '88', '1', '2019-09-27 16:30:53', 'junAdmin', '2019-09-27 16:51:22');
INSERT INTO `shop_gift` VALUES ('1177782351078518784', '1', '戴森吹风机', '11', '11', '11', null, '11', '11', '1', '2019-09-28 11:09:29', 'junAdmin', '2019-09-28 11:09:29');
INSERT INTO `shop_gift` VALUES ('1183239383958786048', '0', '1182864988680400896', '玩具熊', '100', '6', null, null, null, 'junAdmin', '2019-10-13 12:33:47', 'junAdmin', '2019-10-13 13:22:20');
INSERT INTO `shop_gift` VALUES ('1184660711405916160', 'wangxi', '1184660602446286848', '礼物1', '11', '100000', null, null, null, 'wangxi_DOUW', '2019-10-17 10:41:38', 'wangxi_DOUW', '2019-10-17 10:41:38');
INSERT INTO `shop_gift` VALUES ('1184660881872596992', 'zhao', '1184660786896777216', '小蛮猪', '10', '9', null, null, null, 'zhao_I95W', '2019-10-17 10:42:19', 'zhao_I95W', '2019-10-17 13:09:39');
INSERT INTO `shop_gift` VALUES ('1184661252546371584', 'ali', '1184661177740959744', '11', '11', '11', null, null, '1', 'aliali_PRJT', '2019-10-17 10:43:47', 'aliali_PRJT', '2019-10-17 10:43:47');
INSERT INTO `shop_gift` VALUES ('1184696427372224512', 'ali', '1184661209680584704', '积分商品一', '100', '100', null, null, '22', 'aliali_PRJT', '2019-10-17 13:03:34', 'aliali_PRJT', '2019-10-17 13:20:09');
INSERT INTO `shop_gift` VALUES ('1185440667428556800', '0', '1183250434281992192', '棒棒糖', '5', '5', null, null, null, 'junAdmin', '2019-10-19 14:20:54', 'junAdmin', '2019-10-19 14:20:54');
INSERT INTO `shop_gift` VALUES ('1185442925079105536', '0', '1184019458532974592', '1', '1', '1', null, null, null, 'junAdmin', '2019-10-19 14:29:52', 'junAdmin', '2019-10-19 14:29:52');
INSERT INTO `shop_gift` VALUES ('1191177497335697408', 'zhao', '1191177383514869760', '独角兽', '20', '30', null, null, null, 'zhao_I95W', '2019-11-04 10:17:01', 'zhao_I95W', '2019-11-04 10:17:01');

-- ----------------------------
-- Table structure for shop_gift_exchange
-- ----------------------------
DROP TABLE IF EXISTS `shop_gift_exchange`;
CREATE TABLE `shop_gift_exchange` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员',
  `gift_id` varchar(32) DEFAULT NULL COMMENT '积分商品',
  `gift_name` varchar(50) DEFAULT NULL COMMENT '积分商品名称',
  `gift_num` int(11) DEFAULT NULL COMMENT '积分商品数量',
  `gift_points` int(11) DEFAULT NULL COMMENT '兑换积分数',
  `gift_img` varchar(300) DEFAULT NULL COMMENT '商品图片',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品兑换记录';

-- ----------------------------
-- Records of shop_gift_exchange
-- ----------------------------

-- ----------------------------
-- Table structure for shop_gift_type
-- ----------------------------
DROP TABLE IF EXISTS `shop_gift_type`;
CREATE TABLE `shop_gift_type` (
  `id` varchar(32) NOT NULL COMMENT '商品分类ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='积分商品分类';

-- ----------------------------
-- Records of shop_gift_type
-- ----------------------------
INSERT INTO `shop_gift_type` VALUES ('1177423738750693376', null, '0', '0,', '1', '00000001,', '0', '0', '1', '电器');
INSERT INTO `shop_gift_type` VALUES ('1177423782241431552', null, '1177423738750693376', '0,1177423738750693376,', '1', '00000001,00000001', '1', '1', '1/戴森吹风机', '戴森吹风机');
INSERT INTO `shop_gift_type` VALUES ('1177777327618486272', null, '1177423738750693376', '0,1177423738750693376,', '2', '00000001,00000002', '0', '1', '1/111', '111');
INSERT INTO `shop_gift_type` VALUES ('1177777346731929600', null, '1177777327618486272', '0,1177423738750693376,1177777327618486272,', '1', '00000001,0000000200000001', '1', '2', '1/111/222', '222');
INSERT INTO `shop_gift_type` VALUES ('1182864988680400896', '0', '0', '0,', '1', '00000001,', '0', '0', '玩具', '玩具');
INSERT INTO `shop_gift_type` VALUES ('1183250434281992192', '0', '0', '0,', '2', '00000002,', '0', '0', '食品', '食品');
INSERT INTO `shop_gift_type` VALUES ('1184019458532974592', '0', '1183250434281992192', '0,1183250434281992192,', '1', '00000002,00000001', '1', '1', '食品/11', '11');
INSERT INTO `shop_gift_type` VALUES ('1184019470679678976', '0', '1182864988680400896', '0,1182864988680400896,', '1', '00000001,00000001', '0', '1', '玩具/22', '22');
INSERT INTO `shop_gift_type` VALUES ('1184660378902466560', 'wangxi', '0', '0,', '1', '00000001,', '0', '0', '11', '11');
INSERT INTO `shop_gift_type` VALUES ('1184660602446286848', 'wangxi', '1184660378902466560', '0,1184660378902466560,', '1', '00000001,00000001', '1', '1', '11/111', '111');
INSERT INTO `shop_gift_type` VALUES ('1184660786896777216', 'zhao', '0', '0,', '1', '00000001,', '0', '0', '微宠', '微宠');
INSERT INTO `shop_gift_type` VALUES ('1184661177740959744', 'ali', '0', '0,', '1', '00000001,', '0', '0', '积分商品类型一', '积分商品类型一');
INSERT INTO `shop_gift_type` VALUES ('1184661209680584704', 'ali', '1184661177740959744', '0,1184661177740959744,', '1', '00000001,00000001', '1', '1', '11/1', '1');
INSERT INTO `shop_gift_type` VALUES ('1185440526697074688', '0', '1184019470679678976', '0,1182864988680400896,1184019470679678976,', '1', '00000001,0000000100000001', '1', '2', '玩具/22/33', '33');
INSERT INTO `shop_gift_type` VALUES ('1185440581168500736', '0', '1182864988680400896', '0,1182864988680400896,', '2', '00000001,00000002', '1', '1', '玩具/44', '44');
INSERT INTO `shop_gift_type` VALUES ('1185442900219465728', '0', '0', '0,', '3', '00000003,', '1', '0', '1', '1');
INSERT INTO `shop_gift_type` VALUES ('1191177383514869760', 'zhao', '1184660786896777216', '0,1184660786896777216,', '1', '00000001,00000001', '1', '1', '微宠/大型', '大型');

-- ----------------------------
-- Table structure for shop_goods
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods`;
CREATE TABLE `shop_goods` (
  `id` varchar(32) NOT NULL COMMENT '商品ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `type_id` varchar(32) DEFAULT NULL COMMENT '分类',
  `name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  `price_mkt` decimal(20,2) DEFAULT NULL COMMENT '市场价',
  `price` decimal(20,2) DEFAULT NULL COMMENT '零售价格',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `content` longtext COMMENT '详细',
  `expiry_date` date DEFAULT NULL COMMENT '商品有效期',
  `is_show` char(1) DEFAULT '0' COMMENT '是否上架(0下架，1上架)',
  `sort` int(11) DEFAULT '100' COMMENT '排序',
  `sales` int(11) DEFAULT '0' COMMENT '销量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消费项目';

-- ----------------------------
-- Records of shop_goods
-- ----------------------------
INSERT INTO `shop_goods` VALUES ('1177391566166163456', '2', '饮料', '尖叫', '3.00', '4.00', '1', '1', null, '0', '1', '100', null, '1', '2019-09-27 09:16:39', 'junAdmin', '2019-09-27 16:53:37');
INSERT INTO `shop_goods` VALUES ('1177487068894244864', null, '手机', 'k20 pro', '1999.00', '2099.00', null, '22', null, '0', '22', '22', null, '1', '2019-09-27 15:36:09', 'junAdmin', '2019-09-27 16:54:16');
INSERT INTO `shop_goods` VALUES ('1177499238326124544', null, '手机', 'iPhone11', '5999.00', '5999.00', null, '66', null, '1', '66', '66', null, '1', '2019-09-27 16:24:30', 'junAdmin', '2019-09-28 09:42:25');
INSERT INTO `shop_goods` VALUES ('1177781022205571072', '1', '饮料', '11111', '111111.00', '11.00', null, '11', null, '0', '1111', '11', null, '1', '2019-09-28 11:04:12', 'junAdmin', '2019-09-28 11:04:12');
INSERT INTO `shop_goods` VALUES ('1177781961280876544', '1', '111', '22', '22.00', '22.00', null, '22', null, '0', '22', '22', null, '1', '2019-09-28 11:07:56', 'junAdmin', '2019-09-28 11:07:56');
INSERT INTO `shop_goods` VALUES ('1178204292746108928', '1', '饮料', '00', '0.00', '0.00', null, '00', null, '0', '0', '0', null, '1', '2019-09-29 15:06:08', 'junAdmin', '2019-09-29 15:06:08');
INSERT INTO `shop_goods` VALUES ('1184665503209234432', 'ali', '1184660895720153088', '产品名称一', null, '100.00', null, null, null, '0', '1', '0', null, 'aliali_PRJT', '2019-10-17 11:00:41', 'aliali_PRJT', '2019-10-18 15:28:44');
INSERT INTO `shop_goods` VALUES ('1184749316266577920', '88888', '1184749058417545216', '8奔驰', null, '100.00', null, null, null, '1', '1', '0', null, '88888_OUZ1', '2019-10-17 16:33:43', '88888_OUZ1', '2019-10-17 16:33:43');
INSERT INTO `shop_goods` VALUES ('1184749889590185984', '88888', '1184749058417545216', '8宝马', null, '50.00', null, null, null, '1', '2', '0', null, '88888_OUZ1', '2019-10-17 16:36:00', '88888_OUZ1', '2019-10-17 16:36:05');
INSERT INTO `shop_goods` VALUES ('1185440448003543040', '0', '1185440298543714304', '牙膏', null, '4.00', null, null, null, '1', '3', '0', null, 'junAdmin', '2019-10-19 14:20:02', 'junAdmin', '2019-10-19 14:20:11');
INSERT INTO `shop_goods` VALUES ('1185442885426155520', '0', '1183221434610290688', '1', null, '1.00', null, null, null, '1', '1', '0', null, 'junAdmin', '2019-10-19 14:29:43', 'junAdmin', '2019-10-19 14:29:43');
INSERT INTO `shop_goods` VALUES ('1191177074818289664', 'zhao', '1184659896097910784', '灵丹', null, '20.00', null, null, null, '1', '1', '0', null, 'zhao_I95W', '2019-11-04 10:15:20', 'zhao_I95W', '2019-11-04 10:15:20');
INSERT INTO `shop_goods` VALUES ('1191177325104992256', 'zhao', '1191177181517189120', '阴阳两极棍', null, '300.00', null, null, null, '1', '2', '0', null, 'zhao_I95W', '2019-11-04 10:16:20', 'zhao_I95W', '2019-11-04 10:16:20');
INSERT INTO `shop_goods` VALUES ('1192669271402467328', 'baidu', '1192669244152074240', '1', null, '1.00', null, null, null, '1', '1', '0', null, 'baidu_GN5E', '2019-11-08 13:04:48', 'baidu_GN5E', '2019-11-08 13:04:48');

-- ----------------------------
-- Table structure for shop_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_type`;
CREATE TABLE `shop_goods_type` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `name` varchar(30) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消耗项目分类';

-- ----------------------------
-- Records of shop_goods_type
-- ----------------------------
INSERT INTO `shop_goods_type` VALUES ('1177407753958408192', null, '0', '0,', '2', '00000002,', '0', '0', '1', '饮料');
INSERT INTO `shop_goods_type` VALUES ('1177407919281094656', null, '1177407753958408192', '0,1177407753958408192,', '1', '00000002,00000001', '0', '1', '1/尖叫', '尖叫');
INSERT INTO `shop_goods_type` VALUES ('1177408582315618304', null, '1177407753958408192', '0,1177407753958408192,', '2', '00000002,00000002', '0', '1', '1/脉动', '脉动');
INSERT INTO `shop_goods_type` VALUES ('1177777418714574848', null, '1177407919281094656', '0,1177407753958408192,1177407919281094656,', '1', '00000002,0000000100000001', '1', '2', '1/尖叫/111', '111');
INSERT INTO `shop_goods_type` VALUES ('1177777448972283904', null, '1177408582315618304', '0,1177407753958408192,1177408582315618304,', '1', '00000002,0000000200000001', '1', '2', '1/脉动/222', '222');
INSERT INTO `shop_goods_type` VALUES ('1183221434610290688', '0', '0', '0,', '1', '00000001,', '0', '0', '消费项目', '消费项目');
INSERT INTO `shop_goods_type` VALUES ('1183221760272830464', '0', '0', '0,', '2', '00000002,', '0', '0', '储值卡', '储值卡');
INSERT INTO `shop_goods_type` VALUES ('1183639762177900544', '0', '1183221434610290688', '0,1183221434610290688,', '1', '00000001,00000001', '0', '1', '消费项目/11', '11');
INSERT INTO `shop_goods_type` VALUES ('1184659623973883904', 'wangxi', '0', '0,', '1', '00000001,', '0', '0', '11', '11');
INSERT INTO `shop_goods_type` VALUES ('1184659831726149632', 'wangxi', '1184659623973883904', '0,1184659623973883904,', '1', '00000001,00000001', '0', '1', '11/111', '111');
INSERT INTO `shop_goods_type` VALUES ('1184659896097910784', 'zhao', '0', '0,', '1', '00000001,', '1', '0', '微药', '微药');
INSERT INTO `shop_goods_type` VALUES ('1184659910641979392', 'wangxi', '1184659831726149632', '0,1184659623973883904,1184659831726149632,', '1', '00000001,0000000100000001', '1', '2', '11/111/11111', '11111');
INSERT INTO `shop_goods_type` VALUES ('1184660068739657728', 'zhao', '0', '0,', '2', '00000002,', '0', '0', '微兵', '微兵');
INSERT INTO `shop_goods_type` VALUES ('1184660895720153088', 'ali', '0', '0,', '1', '00000001,', '0', '0', '类型一', '类型一');
INSERT INTO `shop_goods_type` VALUES ('1184660935180165120', 'ali', '1184660895720153088', '0,1184660895720153088,', '1', '00000001,00000001', '1', '1', '111/222', '222');
INSERT INTO `shop_goods_type` VALUES ('1184709619362095104', 'ali', '0', '0,', '2', '00000002,', '0', '0', '类型二', '类型二');
INSERT INTO `shop_goods_type` VALUES ('1184709636906868736', 'ali', '1184709619362095104', '0,1184709619362095104,', '1', '00000002,00000001', '1', '1', '类型二/444', '444');
INSERT INTO `shop_goods_type` VALUES ('1184749058417545216', '88888', '0', '0,', '1', '00000001,', '1', '0', '商品', '商品');
INSERT INTO `shop_goods_type` VALUES ('1185440241119498240', '0', '1183639762177900544', '0,1183221434610290688,1183639762177900544,', '1', '00000001,0000000100000001', '1', '2', '消费项目/11/22', '22');
INSERT INTO `shop_goods_type` VALUES ('1185440298543714304', '0', '1183221760272830464', '0,1183221760272830464,', '1', '00000002,00000001', '1', '1', '储值卡/33', '33');
INSERT INTO `shop_goods_type` VALUES ('1185442849514524672', '0', '0', '0,', '3', '00000003,', '1', '0', '1', '1');
INSERT INTO `shop_goods_type` VALUES ('1191177162286305280', 'zhao', '1184660068739657728', '0,1184660068739657728,', '1', '00000002,00000001', '1', '1', '微兵/利刃', '利刃');
INSERT INTO `shop_goods_type` VALUES ('1191177181517189120', 'zhao', '1184660068739657728', '0,1184660068739657728,', '2', '00000002,00000002', '1', '1', '微兵/钝器', '钝器');
INSERT INTO `shop_goods_type` VALUES ('1192669244152074240', 'baidu', '0', '0,', '1', '00000001,', '1', '0', '1', '1');

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` varchar(32) NOT NULL COMMENT '库存id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `goods_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `num` decimal(10,2) DEFAULT NULL COMMENT '库存数量',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存';

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1184647234869047296', '0', '1183232183269470208', '101.00', 'junAdmin', '2019-10-17 09:48:05', 'junAdmin', '2019-10-24 10:01:27');
INSERT INTO `stock` VALUES ('1184647286706450432', '0', '1183231342462513152', '61.00', 'junAdmin', '2019-10-17 09:48:17', 'junAdmin', '2019-10-24 10:29:03');
INSERT INTO `stock` VALUES ('1184663407277776896', 'ali', '1184663166075936768', '1.00', 'aliali_PRJT', '2019-10-17 10:52:21', 'aliali_PRJT', '2019-10-18 11:46:22');
INSERT INTO `stock` VALUES ('1184663543207038976', 'wangxi', '1184660256432984064', '-174.00', 'wangxi_DOUW', '2019-10-17 10:52:53', 'wangxi_DOUW', '2019-10-17 16:41:27');
INSERT INTO `stock` VALUES ('1184692989787774976', 'ali', '1184665503209234432', '996.00', 'aliali_PRJT', '2019-10-17 12:49:54', 'aliali_PRJT', '2019-10-18 16:50:12');
INSERT INTO `stock` VALUES ('1184749616679407616', '88888', '1184749316266577920', '990.00', '88888_OUZ1', '2019-10-17 16:34:55', '88888_OUZ1', '2019-10-17 16:39:18');
INSERT INTO `stock` VALUES ('1184749973132333056', '88888', '1184749889590185984', '500.00', '88888_OUZ1', '2019-10-17 16:36:20', '88888_OUZ1', '2019-10-17 16:39:18');
INSERT INTO `stock` VALUES ('1185447691888431104', '0', '1185440448003543040', '260.00', 'junAdmin', '2019-10-19 14:48:49', 'junAdmin', '2019-11-07 15:40:10');
INSERT INTO `stock` VALUES ('1185448029315248128', '0', '1185442885426155520', '0.00', 'junAdmin', '2019-10-19 14:50:09', 'junAdmin', '2019-10-19 14:53:48');
INSERT INTO `stock` VALUES ('1191218996495212544', 'zhao', '1191177325104992256', '100.00', 'zhao_I95W', '2019-11-04 13:01:55', 'zhao_I95W', '2019-11-04 13:01:55');
INSERT INTO `stock` VALUES ('1191219105505173504', 'zhao', '1191177074818289664', '98.00', 'zhao_I95W', '2019-11-04 13:02:21', 'zhao_I95W', '2019-11-15 09:46:04');
INSERT INTO `stock` VALUES ('1192669367959539712', 'baidu', '1192669271402467328', '1096.00', 'baidu_GN5E', '2019-11-08 13:05:11', 'baidu_GN5E', '2019-11-08 13:37:39');

-- ----------------------------
-- Table structure for stock_record
-- ----------------------------
DROP TABLE IF EXISTS `stock_record`;
CREATE TABLE `stock_record` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `code` varchar(32) DEFAULT NULL COMMENT '单据编号',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '关联id',
  `biz_type` varchar(32) DEFAULT NULL COMMENT '关联业务（1消费收银）',
  `record_type` char(1) DEFAULT NULL COMMENT '类型（1入库、2出库、3报损、4盘点）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入库记录';

-- ----------------------------
-- Records of stock_record
-- ----------------------------
INSERT INTO `stock_record` VALUES ('1184647234822909952', '0', '0_20191017000001', null, null, '1', null, 'junAdmin', '2019-10-17 09:48:05', 'junAdmin', '2019-10-17 09:48:05');
INSERT INTO `stock_record` VALUES ('1184647286668701696', '0', '0_20191017000002', null, null, '1', null, 'junAdmin', '2019-10-17 09:48:17', 'junAdmin', '2019-10-17 09:48:18');
INSERT INTO `stock_record` VALUES ('1184647501157019648', '0', '0_20191017000003', null, null, '2', null, 'junAdmin', '2019-10-17 09:49:09', 'junAdmin', '2019-10-17 09:49:09');
INSERT INTO `stock_record` VALUES ('1184647696859049984', '0', '0_20191017000004', null, null, '3', null, 'junAdmin', '2019-10-17 09:49:55', 'junAdmin', '2019-10-17 09:49:55');
INSERT INTO `stock_record` VALUES ('1184647791000203264', '0', '0_20191017000005', null, null, '4', null, 'junAdmin', '2019-10-17 09:50:18', 'junAdmin', '2019-10-17 09:50:18');
INSERT INTO `stock_record` VALUES ('1184656191095762944', '0', '0_20191017000006', '1184656190990905344', 'cash_buy', '1', null, 'junAdmin', '2019-10-17 10:23:40', 'junAdmin', '2019-10-17 10:23:40');
INSERT INTO `stock_record` VALUES ('1184656496130715648', '0', '0_20191017000007', '1184656496071995392', 'cash_buy', '1', null, 'junAdmin', '2019-10-17 10:24:53', 'junAdmin', '2019-10-17 10:24:53');
INSERT INTO `stock_record` VALUES ('1184658009852620800', '0', '0_20191017000008', '1184658009718403072', 'cash_buy', '2', null, 'junAdmin', '2019-10-17 10:30:54', 'junAdmin', '2019-10-17 10:30:54');
INSERT INTO `stock_record` VALUES ('1184663407256805376', 'ali', 'ali_20191017000001', null, null, '1', '111', 'aliali_PRJT', '2019-10-17 10:52:21', 'aliali_PRJT', '2019-10-17 10:52:21');
INSERT INTO `stock_record` VALUES ('1184663522734383104', 'ali', 'ali_20191017000002', null, null, '1', '1', 'aliali_PRJT', '2019-10-17 10:52:48', 'aliali_PRJT', '2019-10-17 10:52:48');
INSERT INTO `stock_record` VALUES ('1184663543144124416', 'wangxi', 'wangxi_20191017000001', null, null, '1', '啊实打实大', 'wangxi_DOUW', '2019-10-17 10:52:53', 'wangxi_DOUW', '2019-10-17 10:52:53');
INSERT INTO `stock_record` VALUES ('1184663608675672064', 'ali', 'ali_20191017000003', null, null, '2', '1', 'aliali_PRJT', '2019-10-17 10:53:09', 'aliali_PRJT', '2019-10-17 10:53:09');
INSERT INTO `stock_record` VALUES ('1184663766838939648', 'wangxi', 'wangxi_20191017000002', '1184663766746664960', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 10:53:47', 'wangxi_DOUW', '2019-10-17 10:53:47');
INSERT INTO `stock_record` VALUES ('1184663916713746432', 'ali', 'ali_20191017000004', '1184663916680192000', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 10:54:22', 'aliali_PRJT', '2019-10-17 10:54:22');
INSERT INTO `stock_record` VALUES ('1184664852731404288', 'ali', 'ali_20191017000005', null, null, '4', '1', 'aliali_PRJT', '2019-10-17 10:58:06', 'aliali_PRJT', '2019-10-17 10:58:06');
INSERT INTO `stock_record` VALUES ('1184665059896467456', 'ali', 'ali_20191017000006', null, null, '2', '111', 'aliali_PRJT', '2019-10-17 10:58:55', 'aliali_PRJT', '2019-10-17 10:58:55');
INSERT INTO `stock_record` VALUES ('1184665774157078528', 'ali', 'ali_20191017000007', '1184663916680192000', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 11:01:45', 'aliali_PRJT', '2019-10-17 11:01:45');
INSERT INTO `stock_record` VALUES ('1184665950808580096', '0', '0_20191017000009', '1184656496071995392', 'cash_buy', '2', null, 'junAdmin', '2019-10-17 11:02:27', 'junAdmin', '2019-10-17 11:02:27');
INSERT INTO `stock_record` VALUES ('1184670982889201664', 'wangxi', 'wangxi_20191017000003', '1184670982809509888', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 11:22:27', 'wangxi_DOUW', '2019-10-17 11:22:27');
INSERT INTO `stock_record` VALUES ('1184676484299759616', 'ali', 'ali_20191017000008', '1184663916680192000', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 11:44:19', 'aliali_PRJT', '2019-10-17 11:44:19');
INSERT INTO `stock_record` VALUES ('1184692989770997760', 'ali', 'ali_20191017000009', null, null, '1', '2222', 'aliali_PRJT', '2019-10-17 12:49:54', 'aliali_PRJT', '2019-10-17 12:49:54');
INSERT INTO `stock_record` VALUES ('1184706942505263104', 'ali', 'ali_20191017000010', '1184663916680192000', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 13:45:21', 'aliali_PRJT', '2019-10-17 13:45:21');
INSERT INTO `stock_record` VALUES ('1184707099674222592', 'ali', 'ali_20191017000011', '1184707099632279552', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 13:45:58', 'aliali_PRJT', '2019-10-17 13:45:58');
INSERT INTO `stock_record` VALUES ('1184710206514323456', 'ali', 'ali_20191017000012', '1184710206451408896', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 13:58:19', 'aliali_PRJT', '2019-10-17 13:58:19');
INSERT INTO `stock_record` VALUES ('1184716223314714624', 'ali', 'ali_20191017000013', '1184663916680192000', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 14:22:13', 'aliali_PRJT', '2019-10-17 14:22:13');
INSERT INTO `stock_record` VALUES ('1184718419653656576', 'wangxi', 'wangxi_20191017000004', '1184718419381026816', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 14:30:57', 'wangxi_DOUW', '2019-10-17 14:30:57');
INSERT INTO `stock_record` VALUES ('1184726649584062464', 'ali', 'ali_20191017000014', '1184726649554702336', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:03:39', 'aliali_PRJT', '2019-10-17 15:03:39');
INSERT INTO `stock_record` VALUES ('1184726780458930176', 'ali', 'ali_20191017000015', '1184726780425375744', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:04:10', 'aliali_PRJT', '2019-10-17 15:04:10');
INSERT INTO `stock_record` VALUES ('1184726867100667904', 'ali', 'ali_20191017000016', '1184726867058724864', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:04:31', 'aliali_PRJT', '2019-10-17 15:04:31');
INSERT INTO `stock_record` VALUES ('1184726910759178240', 'ali', 'ali_20191017000017', '1184726649554702336', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:04:41', 'aliali_PRJT', '2019-10-17 15:04:41');
INSERT INTO `stock_record` VALUES ('1184727010612973568', 'ali', 'ali_20191017000018', '1184726649554702336', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:05:05', 'aliali_PRJT', '2019-10-17 15:05:05');
INSERT INTO `stock_record` VALUES ('1184727939655503872', 'ali', 'ali_20191017000019', '1184726780425375744', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:08:47', 'aliali_PRJT', '2019-10-17 15:08:47');
INSERT INTO `stock_record` VALUES ('1184728240051556352', 'ali', 'ali_20191017000020', '1184726780425375744', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:09:58', 'aliali_PRJT', '2019-10-17 15:09:58');
INSERT INTO `stock_record` VALUES ('1184728402106880000', 'ali', 'ali_20191017000021', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:10:37', 'aliali_PRJT', '2019-10-17 15:10:37');
INSERT INTO `stock_record` VALUES ('1184728574387916800', 'ali', 'ali_20191017000022', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:11:18', 'aliali_PRJT', '2019-10-17 15:11:18');
INSERT INTO `stock_record` VALUES ('1184729958591430656', 'wangxi', 'wangxi_20191017000005', '1184729958494961664', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:16:48', 'wangxi_DOUW', '2019-10-17 15:16:48');
INSERT INTO `stock_record` VALUES ('1184732079367114752', 'wangxi', 'wangxi_20191017000006', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:25:14', 'wangxi_DOUW', '2019-10-17 15:25:14');
INSERT INTO `stock_record` VALUES ('1184732285521350656', 'wangxi', 'wangxi_20191017000007', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:26:03', 'wangxi_DOUW', '2019-10-17 15:26:03');
INSERT INTO `stock_record` VALUES ('1184733195399520256', 'wangxi', 'wangxi_20191017000008', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:29:40', 'wangxi_DOUW', '2019-10-17 15:29:40');
INSERT INTO `stock_record` VALUES ('1184733221169324032', 'wangxi', 'wangxi_20191017000009', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:29:46', 'wangxi_DOUW', '2019-10-17 15:29:46');
INSERT INTO `stock_record` VALUES ('1184733826699038720', 'ali', 'ali_20191017000023', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:32:10', 'aliali_PRJT', '2019-10-17 15:32:10');
INSERT INTO `stock_record` VALUES ('1184733870575652864', 'ali', 'ali_20191017000024', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:32:21', 'aliali_PRJT', '2019-10-17 15:32:21');
INSERT INTO `stock_record` VALUES ('1184733967950614528', 'ali', 'ali_20191017000025', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:32:44', 'aliali_PRJT', '2019-10-17 15:32:44');
INSERT INTO `stock_record` VALUES ('1184734021501247488', 'wangxi', 'wangxi_20191017000010', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:32:57', 'wangxi_DOUW', '2019-10-17 15:32:57');
INSERT INTO `stock_record` VALUES ('1184734021906141184', 'ali', 'ali_20191017000026', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:32:57', 'aliali_PRJT', '2019-10-17 15:32:57');
INSERT INTO `stock_record` VALUES ('1184734045471694848', 'wangxi', 'wangxi_20191017000011', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:33:02', 'wangxi_DOUW', '2019-10-17 15:33:02');
INSERT INTO `stock_record` VALUES ('1184734126270767104', 'wangxi', 'wangxi_20191017000012', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:33:22', 'wangxi_DOUW', '2019-10-17 15:33:22');
INSERT INTO `stock_record` VALUES ('1184734153219170304', 'wangxi', 'wangxi_20191017000013', '1184732079283228672', 'cash_buy', '2', null, 'wangxi_DOUW', '2019-10-17 15:33:28', 'wangxi_DOUW', '2019-10-17 15:33:28');
INSERT INTO `stock_record` VALUES ('1184734455270019072', 'ali', 'ali_20191017000027', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:34:40', 'aliali_PRJT', '2019-10-17 15:34:40');
INSERT INTO `stock_record` VALUES ('1184737941136781312', 'ali', 'ali_20191017000028', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:48:31', 'aliali_PRJT', '2019-10-17 15:48:31');
INSERT INTO `stock_record` VALUES ('1184737978117959680', 'ali', 'ali_20191017000029', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:48:40', 'aliali_PRJT', '2019-10-17 15:48:40');
INSERT INTO `stock_record` VALUES ('1184738021839384576', 'ali', 'ali_20191017000030', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 15:48:50', 'aliali_PRJT', '2019-10-17 15:48:50');
INSERT INTO `stock_record` VALUES ('1184745218019385344', 'ali', 'ali_20191017000031', '1184728402073325568', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:17:26', 'aliali_PRJT', '2019-10-17 16:17:26');
INSERT INTO `stock_record` VALUES ('1184745730873712640', 'ali', 'ali_20191017000032', '1184745730848546816', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:19:28', 'aliali_PRJT', '2019-10-17 16:19:28');
INSERT INTO `stock_record` VALUES ('1184745795705069568', 'ali', 'ali_20191017000033', '1184745730848546816', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:19:44', 'aliali_PRJT', '2019-10-17 16:19:44');
INSERT INTO `stock_record` VALUES ('1184745858313445376', 'ali', 'ali_20191017000034', '1184745730848546816', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:19:59', 'aliali_PRJT', '2019-10-17 16:19:59');
INSERT INTO `stock_record` VALUES ('1184745940517609472', 'ali', 'ali_20191017000035', '1184745730848546816', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:20:18', 'aliali_PRJT', '2019-10-17 16:20:18');
INSERT INTO `stock_record` VALUES ('1184746386258878464', 'ali', 'ali_20191017000036', '1184745730848546816', 'cash_buy', '2', null, 'aliali_PRJT', '2019-10-17 16:22:05', 'aliali_PRJT', '2019-10-17 16:22:05');
INSERT INTO `stock_record` VALUES ('1184746590770585600', 'ali', 'ali_20191017000037', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:22:53', 'aliali_PRJT', '2019-10-17 16:22:53');
INSERT INTO `stock_record` VALUES ('1184746637444800512', 'ali', 'ali_20191017000038', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:23:05', 'aliali_PRJT', '2019-10-17 16:23:05');
INSERT INTO `stock_record` VALUES ('1184746878973796352', 'ali', 'ali_20191017000039', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:24:02', 'aliali_PRJT', '2019-10-17 16:24:02');
INSERT INTO `stock_record` VALUES ('1184747024977518592', 'ali', 'ali_20191017000040', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:24:37', 'aliali_PRJT', '2019-10-17 16:24:37');
INSERT INTO `stock_record` VALUES ('1184747170356289536', 'ali', 'ali_20191017000041', '1184728402073325568', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:25:12', 'aliali_PRJT', '2019-10-17 16:25:12');
INSERT INTO `stock_record` VALUES ('1184747760956235776', 'ali', 'ali_20191017000042', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:27:32', 'aliali_PRJT', '2019-10-17 16:27:32');
INSERT INTO `stock_record` VALUES ('1184747802760863744', 'ali', 'ali_20191017000043', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:27:42', 'aliali_PRJT', '2019-10-17 16:27:42');
INSERT INTO `stock_record` VALUES ('1184749240027717632', 'ali', 'ali_20191017000044', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:33:25', 'aliali_PRJT', '2019-10-17 16:33:25');
INSERT INTO `stock_record` VALUES ('1184749397330894848', 'ali', 'ali_20191017000045', '1184728402073325568', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:34:03', 'aliali_PRJT', '2019-10-17 16:34:03');
INSERT INTO `stock_record` VALUES ('1184749530076422144', 'ali', 'ali_20191017000046', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:34:34', 'aliali_PRJT', '2019-10-17 16:34:34');
INSERT INTO `stock_record` VALUES ('1184749812684431360', 'ali', 'ali_20191017000047', null, null, '1', '', 'aliali_PRJT', '2019-10-17 16:35:42', 'aliali_PRJT', '2019-10-17 16:35:42');
INSERT INTO `stock_record` VALUES ('1184749926404595712', 'ali', 'ali_20191017000048', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:36:09', 'aliali_PRJT', '2019-10-17 16:36:09');
INSERT INTO `stock_record` VALUES ('1184750101541953536', 'ali', 'ali_20191017000049', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:36:50', 'aliali_PRJT', '2019-10-17 16:36:50');
INSERT INTO `stock_record` VALUES ('1184750237433208832', 'ali', 'ali_20191017000050', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:37:23', 'aliali_PRJT', '2019-10-17 16:37:23');
INSERT INTO `stock_record` VALUES ('1184750663971950592', '88888', '88888_20191017000001', '1184750663963561984', 'cash_buy', '2', '消费收银变更库存', '88888_OUZ1', '2019-10-17 16:39:05', '88888_OUZ1', '2019-10-17 16:39:05');
INSERT INTO `stock_record` VALUES ('1184750678304890880', 'ali', 'ali_20191017000051', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:39:08', 'aliali_PRJT', '2019-10-17 16:39:08');
INSERT INTO `stock_record` VALUES ('1184750718497902592', '88888', '88888_20191017000002', '1184750663963561984', 'cash_buy', '2', '消费收银变更库存', '88888_OUZ1', '2019-10-17 16:39:18', '88888_OUZ1', '2019-10-17 16:39:18');
INSERT INTO `stock_record` VALUES ('1184750865467318272', 'ali', 'ali_20191017000052', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:39:53', 'aliali_PRJT', '2019-10-17 16:39:53');
INSERT INTO `stock_record` VALUES ('1184751066900029440', 'wangxi', 'wangxi_20191017000014', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:40:41', 'wangxi_DOUW', '2019-10-17 16:40:41');
INSERT INTO `stock_record` VALUES ('1184751092527226880', 'wangxi', 'wangxi_20191017000015', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:40:47', 'wangxi_DOUW', '2019-10-17 16:40:47');
INSERT INTO `stock_record` VALUES ('1184751110759866368', 'wangxi', 'wangxi_20191017000016', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:40:51', 'wangxi_DOUW', '2019-10-17 16:40:51');
INSERT INTO `stock_record` VALUES ('1184751192406188032', 'wangxi', 'wangxi_20191017000017', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:41:11', 'wangxi_DOUW', '2019-10-17 16:41:11');
INSERT INTO `stock_record` VALUES ('1184751230704377856', 'wangxi', 'wangxi_20191017000018', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:41:20', 'wangxi_DOUW', '2019-10-17 16:41:20');
INSERT INTO `stock_record` VALUES ('1184751261066944512', 'wangxi', 'wangxi_20191017000019', '1184732079283228672', 'cash_buy', '2', '消费收银变更库存', 'wangxi_DOUW', '2019-10-17 16:41:27', 'wangxi_DOUW', '2019-10-17 16:41:27');
INSERT INTO `stock_record` VALUES ('1184753438307917824', 'ali', 'ali_20191017000053', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-17 16:50:06', 'aliali_PRJT', '2019-10-17 16:50:06');
INSERT INTO `stock_record` VALUES ('1184984012224372736', 'ali', 'ali_20191018000054', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:06:19', 'aliali_PRJT', '2019-10-18 08:06:19');
INSERT INTO `stock_record` VALUES ('1184984473232908288', 'ali', 'ali_20191018000055', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:08:09', 'aliali_PRJT', '2019-10-18 08:08:09');
INSERT INTO `stock_record` VALUES ('1184985911405223936', 'ali', 'ali_20191018000056', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:13:52', 'aliali_PRJT', '2019-10-18 08:13:52');
INSERT INTO `stock_record` VALUES ('1184985928174051328', 'ali', 'ali_20191018000057', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:13:56', 'aliali_PRJT', '2019-10-18 08:13:56');
INSERT INTO `stock_record` VALUES ('1184986330432970752', 'ali', 'ali_20191018000058', '1184745730848546816', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:15:32', 'aliali_PRJT', '2019-10-18 08:15:32');
INSERT INTO `stock_record` VALUES ('1184986962766241792', 'ali', 'ali_20191018000059', '1184986962741075968', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:18:03', 'aliali_PRJT', '2019-10-18 08:18:03');
INSERT INTO `stock_record` VALUES ('1184987680294215680', 'ali', 'ali_20191018000060', '1184986962741075968', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:20:54', 'aliali_PRJT', '2019-10-18 08:20:54');
INSERT INTO `stock_record` VALUES ('1184991181300736000', 'ali', 'ali_20191018000061', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 08:34:48', 'aliali_PRJT', '2019-10-18 08:34:48');
INSERT INTO `stock_record` VALUES ('1185001861552365568', 'ali', 'ali_20191018000062', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 09:17:15', 'aliali_PRJT', '2019-10-18 09:17:15');
INSERT INTO `stock_record` VALUES ('1185008263389863936', 'ali', 'ali_20191018000063', null, null, '1', '', 'aliali_PRJT', '2019-10-18 09:42:41', 'aliali_PRJT', '2019-10-18 09:42:41');
INSERT INTO `stock_record` VALUES ('1185008428792242176', 'ali', 'ali_20191018000064', null, null, '1', '', 'aliali_PRJT', '2019-10-18 09:43:20', 'aliali_PRJT', '2019-10-18 09:43:21');
INSERT INTO `stock_record` VALUES ('1185008599047430144', 'ali', 'ali_20191018000065', null, null, '3', '', 'aliali_PRJT', '2019-10-18 09:44:01', 'aliali_PRJT', '2019-10-18 09:44:01');
INSERT INTO `stock_record` VALUES ('1185020735421243392', 'ali', 'ali_20191018000066', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 10:32:15', 'aliali_PRJT', '2019-10-18 10:32:15');
INSERT INTO `stock_record` VALUES ('1185033329909522432', 'ali', 'ali_20191018000067', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 11:22:17', 'aliali_PRJT', '2019-10-18 11:22:17');
INSERT INTO `stock_record` VALUES ('1185037601590288384', 'ali', 'ali_20191018000068', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 11:39:16', 'aliali_PRJT', '2019-10-18 11:39:16');
INSERT INTO `stock_record` VALUES ('1185037646968463360', 'ali', 'ali_20191018000069', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 11:39:27', 'aliali_PRJT', '2019-10-18 11:39:27');
INSERT INTO `stock_record` VALUES ('1185038711919026176', 'ali', 'ali_20191018000070', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 11:43:41', 'aliali_PRJT', '2019-10-18 11:43:41');
INSERT INTO `stock_record` VALUES ('1185039026777038848', 'ali', 'ali_20191018000071', null, null, '2', '', 'aliali_PRJT', '2019-10-18 11:44:56', 'aliali_PRJT', '2019-10-18 11:44:56');
INSERT INTO `stock_record` VALUES ('1185039177730039808', 'ali', 'ali_20191018000072', null, null, '1', '', 'aliali_PRJT', '2019-10-18 11:45:32', 'aliali_PRJT', '2019-10-18 11:45:32');
INSERT INTO `stock_record` VALUES ('1185039338002784256', 'ali', 'ali_20191018000073', null, null, '2', '', 'aliali_PRJT', '2019-10-18 11:46:10', 'aliali_PRJT', '2019-10-18 11:46:10');
INSERT INTO `stock_record` VALUES ('1185039389835993088', 'ali', 'ali_20191018000074', null, null, '1', '', 'aliali_PRJT', '2019-10-18 11:46:22', 'aliali_PRJT', '2019-10-18 11:46:22');
INSERT INTO `stock_record` VALUES ('1185115852386615296', 'ali', 'ali_20191018000075', '1184991181271375872', 'cash_buy', '2', '消费收银变更库存', 'aliali_PRJT', '2019-10-18 16:50:12', 'aliali_PRJT', '2019-10-18 16:50:12');
INSERT INTO `stock_record` VALUES ('1185440396062707712', '0', '0_20191019000010', null, null, '1', '啊实打实大', 'junAdmin', '2019-10-19 14:19:49', 'junAdmin', '2019-10-19 14:19:50');
INSERT INTO `stock_record` VALUES ('1185442202820644864', '0', '0_20191019000011', '1185442202715787264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-19 14:27:00', 'junAdmin', '2019-10-19 14:27:00');
INSERT INTO `stock_record` VALUES ('1185447691859070976', '0', '0_20191019000014', null, null, '1', '', 'junAdmin', '2019-10-19 14:48:49', 'junAdmin', '2019-10-19 14:48:49');
INSERT INTO `stock_record` VALUES ('1185447955721990144', '0', '0_20191019000012', null, null, '1', '', 'junAdmin', '2019-10-19 14:49:52', 'junAdmin', '2019-10-19 14:49:52');
INSERT INTO `stock_record` VALUES ('1185448029260722176', '0', '0_20191019000013', null, null, '1', '悄悄敲敲群群', 'junAdmin', '2019-10-19 14:50:09', 'junAdmin', '2019-10-19 14:50:09');
INSERT INTO `stock_record` VALUES ('1185448947901378560', '0', '0_20191019000015', '1185448947876212736', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-19 14:53:48', 'junAdmin', '2019-10-19 14:53:48');
INSERT INTO `stock_record` VALUES ('1187159935376789504', '0', '0_20191024000016', '1185442202715787264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 08:12:40', 'junAdmin', '2019-10-24 08:12:41');
INSERT INTO `stock_record` VALUES ('1187160127857594368', '0', '0_20191024000017', '1185442202715787264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 08:13:26', 'junAdmin', '2019-10-24 08:13:26');
INSERT INTO `stock_record` VALUES ('1187160853316997120', '0', '0_20191024000018', '1185442202715787264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 08:16:18', 'junAdmin', '2019-10-24 08:16:18');
INSERT INTO `stock_record` VALUES ('1187161303838412800', '0', '0_20191024000019', '1185442202715787264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 08:18:06', 'junAdmin', '2019-10-24 08:18:06');
INSERT INTO `stock_record` VALUES ('1187180407181795328', '0', '0_20191024000020', '1187180407106297856', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:34:00', 'junAdmin', '2019-10-24 09:34:00');
INSERT INTO `stock_record` VALUES ('1187180723092578304', '0', '0_20191024000021', '1187180407106297856', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:35:16', 'junAdmin', '2019-10-24 09:35:16');
INSERT INTO `stock_record` VALUES ('1187181531052216320', '0', '0_20191024000022', '1187180407106297856', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:38:28', 'junAdmin', '2019-10-24 09:38:28');
INSERT INTO `stock_record` VALUES ('1187181931847323648', '0', '0_20191024000023', '1187180407106297856', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:40:04', 'junAdmin', '2019-10-24 09:40:04');
INSERT INTO `stock_record` VALUES ('1187182268754792448', '0', '0_20191024000024', '1187182268725432320', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:41:24', 'junAdmin', '2019-10-24 09:41:24');
INSERT INTO `stock_record` VALUES ('1187185191474434048', '0', '0_20191024000025', null, null, '1', '', 'junAdmin', '2019-10-24 09:53:01', 'junAdmin', '2019-10-24 09:53:01');
INSERT INTO `stock_record` VALUES ('1187185291546333184', '0', '0_20191024000026', '1187185291516973056', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:53:25', 'junAdmin', '2019-10-24 09:53:25');
INSERT INTO `stock_record` VALUES ('1187185374375448576', '0', '0_20191024000027', '1187185291516973056', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:53:45', 'junAdmin', '2019-10-24 09:53:45');
INSERT INTO `stock_record` VALUES ('1187186090799812608', '0', '0_20191024000028', '1187185291516973056', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 09:56:36', 'junAdmin', '2019-10-24 09:56:36');
INSERT INTO `stock_record` VALUES ('1187187313337323520', '0', '0_20191024000029', '1187185291516973056', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:01:27', 'junAdmin', '2019-10-24 10:01:27');
INSERT INTO `stock_record` VALUES ('1187187433374109696', '0', '0_20191024000030', '1187187433340555264', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:01:56', 'junAdmin', '2019-10-24 10:01:56');
INSERT INTO `stock_record` VALUES ('1187188627857362944', '0', '0_20191024000032', '1187188627828002816', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:06:40', 'junAdmin', '2019-10-24 10:06:40');
INSERT INTO `stock_record` VALUES ('1187188796178976768', '0', '0_20191024000033', '1187188627828002816', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:07:21', 'junAdmin', '2019-10-24 10:07:21');
INSERT INTO `stock_record` VALUES ('1187188816728031232', '0', '0_20191024000031', '1187188816665116672', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:07:25', 'junAdmin', '2019-10-24 10:07:25');
INSERT INTO `stock_record` VALUES ('1187194087764942848', '0', '0_20191024000034', '1187194087555227648', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:28:22', 'junAdmin', '2019-10-24 10:28:22');
INSERT INTO `stock_record` VALUES ('1187194260041785344', '0', '0_20191024000035', '1187194259999842304', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-24 10:29:03', 'junAdmin', '2019-10-24 10:29:03');
INSERT INTO `stock_record` VALUES ('1188732088215752704', '0', '0_20191028000036', '1188732087892791296', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-10-28 16:19:50', 'junAdmin', '2019-10-28 16:19:50');
INSERT INTO `stock_record` VALUES ('1191218996465852416', 'zhao', 'zhao_20191104000001', null, null, '1', '', 'zhao_I95W', '2019-11-04 13:01:55', 'zhao_I95W', '2019-11-04 13:01:55');
INSERT INTO `stock_record` VALUES ('1191219105454841856', 'zhao', 'zhao_20191104000002', null, null, '1', '', 'zhao_I95W', '2019-11-04 13:02:21', 'zhao_I95W', '2019-11-04 13:02:21');
INSERT INTO `stock_record` VALUES ('1191219490206736384', 'zhao', 'zhao_20191104000003', '1191219490168987648', 'cash_buy', '2', '消费收银变更库存', 'zhao_I95W', '2019-11-04 13:03:53', 'zhao_I95W', '2019-11-04 13:03:53');
INSERT INTO `stock_record` VALUES ('1191944572999708672', '0', '0_20191106000037', '1191944572940988416', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:05:06', 'junAdmin', '2019-11-06 13:05:06');
INSERT INTO `stock_record` VALUES ('1191952031143309312', '0', '0_20191106000038', '1191952031118143488', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:34:44', 'junAdmin', '2019-11-06 13:34:44');
INSERT INTO `stock_record` VALUES ('1191952635840311296', '0', '0_20191106000039', '1191952635815145472', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:37:08', 'junAdmin', '2019-11-06 13:37:08');
INSERT INTO `stock_record` VALUES ('1191952729260044288', '0', '0_20191106000040', '1191952729209712640', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:37:31', 'junAdmin', '2019-11-06 13:37:31');
INSERT INTO `stock_record` VALUES ('1191954240245837824', '0', '0_20191106000041', '1191954239935459328', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:43:31', 'junAdmin', '2019-11-06 13:43:31');
INSERT INTO `stock_record` VALUES ('1191954594334928896', '0', '0_20191106000042', '1191954594003578880', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:44:55', 'junAdmin', '2019-11-06 13:44:55');
INSERT INTO `stock_record` VALUES ('1191954865934704640', '0', '0_20191106000043', '1191954865863401472', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:46:00', 'junAdmin', '2019-11-06 13:46:00');
INSERT INTO `stock_record` VALUES ('1191955842439979008', '0', '0_20191106000044', '1191955842389647360', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:49:53', 'junAdmin', '2019-11-06 13:49:53');
INSERT INTO `stock_record` VALUES ('1191956220512493568', '0', '0_20191106000045', '1191956220449579008', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:51:23', 'junAdmin', '2019-11-06 13:51:23');
INSERT INTO `stock_record` VALUES ('1191956317493190656', '0', '0_20191106000046', '1191956220449579008', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:51:46', 'junAdmin', '2019-11-06 13:51:46');
INSERT INTO `stock_record` VALUES ('1191956382710423552', '0', '0_20191106000047', '1191956220449579008', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-06 13:52:02', 'junAdmin', '2019-11-06 13:52:02');
INSERT INTO `stock_record` VALUES ('1192344803034578944', '0', '0_20191107000048', '1192344802795503616', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-07 15:35:28', 'junAdmin', '2019-11-07 15:35:28');
INSERT INTO `stock_record` VALUES ('1192344930931490816', '0', '0_20191107000049', '1192344930868576256', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-07 15:35:59', 'junAdmin', '2019-11-07 15:35:59');
INSERT INTO `stock_record` VALUES ('1192345644024156160', '0', '0_20191107000050', '1192345643810246656', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-07 15:38:49', 'junAdmin', '2019-11-07 15:38:49');
INSERT INTO `stock_record` VALUES ('1192345984211763200', '0', '0_20191107000051', '1192345983981076480', 'cash_buy', '2', '消费收银变更库存', 'junAdmin', '2019-11-07 15:40:10', 'junAdmin', '2019-11-07 15:40:10');
INSERT INTO `stock_record` VALUES ('1192669367946956800', 'baidu', 'baidu_20191108000001', null, null, '1', '', 'baidu_GN5E', '2019-11-08 13:05:11', 'baidu_GN5E', '2019-11-08 13:05:11');
INSERT INTO `stock_record` VALUES ('1192669427564793856', 'baidu', 'baidu_20191108000002', '1192669427552210944', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:05:25', 'baidu_GN5E', '2019-11-08 13:05:25');
INSERT INTO `stock_record` VALUES ('1192669716522979328', 'baidu', 'baidu_20191108000003', '1192669716510396416', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:06:34', 'baidu_GN5E', '2019-11-08 13:06:34');
INSERT INTO `stock_record` VALUES ('1192669822940860416', 'baidu', 'baidu_20191108000004', '1192669822928277504', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:06:59', 'baidu_GN5E', '2019-11-08 13:06:59');
INSERT INTO `stock_record` VALUES ('1192670266601947136', 'baidu', 'baidu_20191108000005', '1192670266455146496', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:08:45', 'baidu_GN5E', '2019-11-08 13:08:45');
INSERT INTO `stock_record` VALUES ('1192670792417841152', 'baidu', 'baidu_20191108000006', '1192670792279429120', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:10:50', 'baidu_GN5E', '2019-11-08 13:10:50');
INSERT INTO `stock_record` VALUES ('1192671554247790592', 'baidu', 'baidu_20191108000007', '1192671554092601344', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:13:52', 'baidu_GN5E', '2019-11-08 13:13:52');
INSERT INTO `stock_record` VALUES ('1192672679684411392', 'baidu', 'baidu_20191108000008', '1192672679671828480', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:18:20', 'baidu_GN5E', '2019-11-08 13:18:20');
INSERT INTO `stock_record` VALUES ('1192673835739013120', 'baidu', 'baidu_20191108000009', '1192673835571240960', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:22:56', 'baidu_GN5E', '2019-11-08 13:22:56');
INSERT INTO `stock_record` VALUES ('1192673995726544896', 'baidu', 'baidu_20191108000010', '1192673995709767680', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:23:34', 'baidu_GN5E', '2019-11-08 13:23:34');
INSERT INTO `stock_record` VALUES ('1192675197518434304', 'baidu', 'baidu_20191108000011', '1192675197480685568', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:28:21', 'baidu_GN5E', '2019-11-08 13:28:21');
INSERT INTO `stock_record` VALUES ('1192675561865039872', 'baidu', 'baidu_20191108000012', '1192675561844068352', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:29:47', 'baidu_GN5E', '2019-11-08 13:29:47');
INSERT INTO `stock_record` VALUES ('1192676843577532416', 'baidu', 'baidu_20191108000013', '1192676843539783680', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:34:53', 'baidu_GN5E', '2019-11-08 13:34:53');
INSERT INTO `stock_record` VALUES ('1192677072020299776', 'baidu', 'baidu_20191108000014', '1192677072007716864', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:35:47', 'baidu_GN5E', '2019-11-08 13:35:48');
INSERT INTO `stock_record` VALUES ('1192677424744488960', 'baidu', 'baidu_20191108000015', '1192677424731906048', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:37:12', 'baidu_GN5E', '2019-11-08 13:37:12');
INSERT INTO `stock_record` VALUES ('1192677539739721728', 'baidu', 'baidu_20191108000016', '1192677539722944512', 'cash_buy', '2', '消费收银变更库存', 'baidu_GN5E', '2019-11-08 13:37:39', 'baidu_GN5E', '2019-11-08 13:37:39');
INSERT INTO `stock_record` VALUES ('1195155973618581504', 'zhao', 'zhao_20191115000004', '1195155973295620096', 'cash_buy', '2', '消费收银变更库存', 'zhao_I95W', '2019-11-15 09:46:04', 'zhao_I95W', '2019-11-15 09:46:04');

-- ----------------------------
-- Table structure for stock_record_item
-- ----------------------------
DROP TABLE IF EXISTS `stock_record_item`;
CREATE TABLE `stock_record_item` (
  `id` varchar(32) NOT NULL COMMENT '明细id',
  `record_id` varchar(32) DEFAULT NULL COMMENT '出入库id',
  `goods_id` varchar(32) DEFAULT NULL COMMENT '商品id',
  `num_type` char(1) DEFAULT NULL COMMENT '类型（1增加、2减少）',
  `num` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `num_new` decimal(10,2) DEFAULT NULL COMMENT '新数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出入库明细';

-- ----------------------------
-- Records of stock_record_item
-- ----------------------------
INSERT INTO `stock_record_item` VALUES ('1184647234839687168', '1184647234822909952', '1183232183269470208', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184647286689673216', '1184647286668701696', '1183231342462513152', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184647286740004864', '1184647286668701696', '1183231342462513152', '1', '100.00', '200.00');
INSERT INTO `stock_record_item` VALUES ('1184647501177991168', '1184647501157019648', '1183232183269470208', '2', '10.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1184647501211545600', '1184647501157019648', '1183231342462513152', '2', '10.00', '190.00');
INSERT INTO `stock_record_item` VALUES ('1184647696880021504', '1184647696859049984', '1183231342462513152', '2', '20.00', '170.00');
INSERT INTO `stock_record_item` VALUES ('1184647696930353152', '1184647696859049984', '1183232183269470208', '2', '20.00', '70.00');
INSERT INTO `stock_record_item` VALUES ('1184647791021174784', '1184647791000203264', '1183232183269470208', '3', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184647791071506432', '1184647791000203264', '1183231342462513152', '3', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184656191108345856', '1184656191095762944', '1183232183269470208', '1', '1.00', '101.00');
INSERT INTO `stock_record_item` VALUES ('1184656496151687168', '1184656496130715648', '1183232183269470208', '1', '10.00', '111.00');
INSERT INTO `stock_record_item` VALUES ('1184658009869398016', '1184658009852620800', '1183231342462513152', '2', '100.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1184662018252156928', '1184662018235379712', '1184660420260081664', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184662059134038016', '1184662059113066496', '1184660603379200000', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184663407265193984', '1184663407256805376', '1184663166075936768', '1', '11.00', '11.00');
INSERT INTO `stock_record_item` VALUES ('1184663407311331328', '1184663407256805376', '1184663166075936768', '1', '11.00', '22.00');
INSERT INTO `stock_record_item` VALUES ('1184663522742771712', '1184663522734383104', '1184663166075936768', '1', '1.00', '23.00');
INSERT INTO `stock_record_item` VALUES ('1184663543181873152', '1184663543144124416', '1184660256432984064', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1184663608684060672', '1184663608675672064', '1184663166075936768', '2', '1.00', '22.00');
INSERT INTO `stock_record_item` VALUES ('1184663766859911168', '1184663766838939648', '1184660256432984064', '2', '1.00', '99.00');
INSERT INTO `stock_record_item` VALUES ('1184663916726329344', '1184663916713746432', '1184663166075936768', '2', '1.00', '21.00');
INSERT INTO `stock_record_item` VALUES ('1184664162485219328', '1184664162464247808', '1184660420260081664', '2', '1.00', '99.00');
INSERT INTO `stock_record_item` VALUES ('1184664852739792896', '1184664852731404288', '1184663166075936768', '3', '1.00', '1.00');
INSERT INTO `stock_record_item` VALUES ('1184665059904856064', '1184665059896467456', '1184663166075936768', '2', '1.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1184665193243815936', '1184665193222844416', '1184660420260081664', '2', '1.00', '98.00');
INSERT INTO `stock_record_item` VALUES ('1184665774169661440', '1184665774157078528', '1184663166075936768', '2', '1.00', '-1.00');
INSERT INTO `stock_record_item` VALUES ('1184665950816968704', '1184665950808580096', '1183232183269470208', '2', '10.00', '101.00');
INSERT INTO `stock_record_item` VALUES ('1184670066572079104', '1184670066555301888', '1184660420260081664', '2', '1.00', '97.00');
INSERT INTO `stock_record_item` VALUES ('1184670982897590272', '1184670982889201664', '1184660256432984064', '2', '1.00', '98.00');
INSERT INTO `stock_record_item` VALUES ('1184676484312342528', '1184676484299759616', '1184663166075936768', '2', '1.00', '-2.00');
INSERT INTO `stock_record_item` VALUES ('1184692989779386368', '1184692989770997760', '1184665503209234432', '1', '1111.00', '1111.00');
INSERT INTO `stock_record_item` VALUES ('1184706942517846016', '1184706942505263104', '1184663166075936768', '2', '1.00', '-3.00');
INSERT INTO `stock_record_item` VALUES ('1184707099682611200', '1184707099674222592', '1184665503209234432', '2', '1.00', '1110.00');
INSERT INTO `stock_record_item` VALUES ('1184710206522712064', '1184710206514323456', '1184665503209234432', '2', '1.00', '1109.00');
INSERT INTO `stock_record_item` VALUES ('1184710206560460800', '1184710206514323456', '1184665503209234432', '2', '1.00', '1108.00');
INSERT INTO `stock_record_item` VALUES ('1184710206589820928', '1184710206514323456', '1184665503209234432', '2', '1.00', '1107.00');
INSERT INTO `stock_record_item` VALUES ('1184710206614986752', '1184710206514323456', '1184665503209234432', '2', '1.00', '1106.00');
INSERT INTO `stock_record_item` VALUES ('1184715358860103680', '1184715358847520768', '1184660603379200000', '2', '2.00', '98.00');
INSERT INTO `stock_record_item` VALUES ('1184716223327297536', '1184716223314714624', '1184663166075936768', '2', '1.00', '-4.00');
INSERT INTO `stock_record_item` VALUES ('1184718419666239488', '1184718419653656576', '1184660256432984064', '2', '1.00', '97.00');
INSERT INTO `stock_record_item` VALUES ('1184726308027240448', '1184726308010463232', '1184660603379200000', '2', '1.00', '97.00');
INSERT INTO `stock_record_item` VALUES ('1184726649592451072', '1184726649584062464', '1184665503209234432', '2', '1.00', '1105.00');
INSERT INTO `stock_record_item` VALUES ('1184726780467318784', '1184726780458930176', '1184665503209234432', '2', '1.00', '1104.00');
INSERT INTO `stock_record_item` VALUES ('1184726867113250816', '1184726867100667904', '1184665503209234432', '2', '1.00', '1103.00');
INSERT INTO `stock_record_item` VALUES ('1184726910767566848', '1184726910759178240', '1184665503209234432', '2', '1.00', '1102.00');
INSERT INTO `stock_record_item` VALUES ('1184727010621362176', '1184727010612973568', '1184665503209234432', '2', '1.00', '1101.00');
INSERT INTO `stock_record_item` VALUES ('1184727939668086784', '1184727939655503872', '1184665503209234432', '2', '1.00', '1100.00');
INSERT INTO `stock_record_item` VALUES ('1184728240059944960', '1184728240051556352', '1184665503209234432', '2', '1.00', '1099.00');
INSERT INTO `stock_record_item` VALUES ('1184728240085110784', '1184728240051556352', '1184663166075936768', '2', '1.00', '-5.00');
INSERT INTO `stock_record_item` VALUES ('1184728402119462912', '1184728402106880000', '1184665503209234432', '2', '1.00', '1098.00');
INSERT INTO `stock_record_item` VALUES ('1184728574396305408', '1184728574387916800', '1184665503209234432', '2', '1.00', '1097.00');
INSERT INTO `stock_record_item` VALUES ('1184729958612402176', '1184729958591430656', '1184660256432984064', '2', '1.00', '96.00');
INSERT INTO `stock_record_item` VALUES ('1184732718696411136', '1184732718679633920', '1184660603379200000', '2', '2.00', '95.00');
INSERT INTO `stock_record_item` VALUES ('1184733110926749696', '1184733110905778176', '1184660603379200000', '2', '2.00', '93.00');
INSERT INTO `stock_record_item` VALUES ('1184733195416297472', '1184733195399520256', '1184660256432984064', '2', '1.00', '95.00');
INSERT INTO `stock_record_item` VALUES ('1184733221186101248', '1184733221169324032', '1184660256432984064', '2', '12.00', '83.00');
INSERT INTO `stock_record_item` VALUES ('1184733253675692032', '1184733253654720512', '1184660603379200000', '2', '2.00', '91.00');
INSERT INTO `stock_record_item` VALUES ('1184733826707427328', '1184733826699038720', '1184663166075936768', '2', '1.00', '-6.00');
INSERT INTO `stock_record_item` VALUES ('1184733870588235776', '1184733870575652864', '1184663166075936768', '2', '1.00', '-7.00');
INSERT INTO `stock_record_item` VALUES ('1184733967963197440', '1184733967950614528', '1184663166075936768', '2', '1.00', '-8.00');
INSERT INTO `stock_record_item` VALUES ('1184734021518024704', '1184734021501247488', '1184660256432984064', '2', '12.00', '71.00');
INSERT INTO `stock_record_item` VALUES ('1184734021914529792', '1184734021906141184', '1184665503209234432', '2', '1.00', '1096.00');
INSERT INTO `stock_record_item` VALUES ('1184734045484277760', '1184734045471694848', '1184660256432984064', '2', '12.00', '59.00');
INSERT INTO `stock_record_item` VALUES ('1184734108860723200', '1184734108843945984', '1184660603379200000', '2', '1.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1184734126291738624', '1184734126270767104', '1184660256432984064', '2', '112.00', '-53.00');
INSERT INTO `stock_record_item` VALUES ('1184734153240141824', '1184734153219170304', '1184660256432984064', '2', '122.00', '-175.00');
INSERT INTO `stock_record_item` VALUES ('1184734239743979520', '1184734239723008000', '1184660603379200000', '2', '1.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1184734278335770624', '1184734278310604800', '1184660603379200000', '2', '1.00', '88.00');
INSERT INTO `stock_record_item` VALUES ('1184734455282601984', '1184734455270019072', '1184663166075936768', '2', '1.00', '-9.00');
INSERT INTO `stock_record_item` VALUES ('1184737941149364224', '1184737941136781312', '1184663166075936768', '2', '1.00', '-10.00');
INSERT INTO `stock_record_item` VALUES ('1184737978126348288', '1184737978117959680', '1184663166075936768', '2', '1.00', '-11.00');
INSERT INTO `stock_record_item` VALUES ('1184738021851967488', '1184738021839384576', '1184663166075936768', '2', '1.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184745218027773952', '1184745218019385344', '1184663166075936768', '2', '0.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184745730882101248', '1184745730873712640', '1184665503209234432', '2', '1.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184745795717652480', '1184745795705069568', '1184663166075936768', '2', '0.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184745858326028288', '1184745858313445376', '1184665503209234432', '2', '0.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184745940525998080', '1184745940517609472', '1184663166075936768', '2', '0.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184746386267267072', '1184746386258878464', '1184663166075936768', '2', '1.00', '-13.00');
INSERT INTO `stock_record_item` VALUES ('1184746590783168512', '1184746590770585600', '1184663166075936768', '2', '1.00', '-14.00');
INSERT INTO `stock_record_item` VALUES ('1184746637457383424', '1184746637444800512', '1184663166075936768', '2', '-2.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184746878982184960', '1184746878973796352', '1184665503209234432', '2', '0.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184747024985907200', '1184747024977518592', '1184665503209234432', '2', '9.00', '1086.00');
INSERT INTO `stock_record_item` VALUES ('1184747170368872448', '1184747170356289536', '1184663166075936768', '2', '0.00', '-12.00');
INSERT INTO `stock_record_item` VALUES ('1184747760964624384', '1184747760956235776', '1184665503209234432', '2', '0.00', '1086.00');
INSERT INTO `stock_record_item` VALUES ('1184747802773446656', '1184747802760863744', '1184665503209234432', '2', '0.00', '1086.00');
INSERT INTO `stock_record_item` VALUES ('1184749240040300544', '1184749240027717632', '1184665503209234432', '2', '-10.00', '1096.00');
INSERT INTO `stock_record_item` VALUES ('1184749240078049280', '1184749240027717632', '1184663166075936768', '2', '10.00', '-22.00');
INSERT INTO `stock_record_item` VALUES ('1184749397339283456', '1184749397330894848', '1184663166075936768', '2', '-1.00', '-21.00');
INSERT INTO `stock_record_item` VALUES ('1184749397364449280', '1184749397330894848', '1184665503209234432', '2', '1.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184749530084810752', '1184749530076422144', '1184663166075936768', '2', '-10.00', '-11.00');
INSERT INTO `stock_record_item` VALUES ('1184749530109976576', '1184749530076422144', '1184665503209234432', '2', '10.00', '1085.00');
INSERT INTO `stock_record_item` VALUES ('1184749616666824704', '1184749616658436096', '1184749316266577920', '1', '1000.00', '1000.00');
INSERT INTO `stock_record_item` VALUES ('1184749812697014272', '1184749812684431360', '1184663166075936768', '1', '100.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1184749926412984320', '1184749926404595712', '1184665503209234432', '2', '-10.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184749926442344448', '1184749926404595712', '1184663166075936768', '2', '10.00', '79.00');
INSERT INTO `stock_record_item` VALUES ('1184749973128138752', '1184749973119750144', '1184749889590185984', '1', '500.00', '500.00');
INSERT INTO `stock_record_item` VALUES ('1184750101554536448', '1184750101541953536', '1184663166075936768', '2', '-10.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1184750101575507968', '1184750101541953536', '1184665503209234432', '2', '1.00', '1094.00');
INSERT INTO `stock_record_item` VALUES ('1184750101780025344', '1184750101775831040', '1184749889590185984', '2', '10.00', '490.00');
INSERT INTO `stock_record_item` VALUES ('1184750101792608256', '1184750101775831040', '1184749316266577920', '2', '-1.00', '1001.00');
INSERT INTO `stock_record_item` VALUES ('1184750155999793152', '1184750155991404544', '1184749889590185984', '2', '-10.00', '500.00');
INSERT INTO `stock_record_item` VALUES ('1184750156008181760', '1184750155991404544', '1184749316266577920', '2', '1.00', '1000.00');
INSERT INTO `stock_record_item` VALUES ('1184750237437403136', '1184750237433208832', '1184665503209234432', '2', '-1.00', '1095.00');
INSERT INTO `stock_record_item` VALUES ('1184750237462568960', '1184750237433208832', '1184663166075936768', '2', '1.00', '88.00');
INSERT INTO `stock_record_item` VALUES ('1184750663976144896', '1184750663971950592', '1184749889590185984', '2', '10.00', '490.00');
INSERT INTO `stock_record_item` VALUES ('1184750678317473792', '1184750678304890880', '1184663166075936768', '2', '-1.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1184750678338445312', '1184750678304890880', '1184665503209234432', '2', '100.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184750718502096896', '1184750718497902592', '1184749889590185984', '2', '-10.00', '500.00');
INSERT INTO `stock_record_item` VALUES ('1184750718514679808', '1184750718497902592', '1184749316266577920', '2', '10.00', '990.00');
INSERT INTO `stock_record_item` VALUES ('1184750865479901184', '1184750865467318272', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184751066925195264', '1184751066900029440', '1184660256432984064', '2', '4.00', '-179.00');
INSERT INTO `stock_record_item` VALUES ('1184751080838021120', '1184751080821243904', '1184660603379200000', '2', '-1.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1184751092556587008', '1184751092527226880', '1184660256432984064', '2', '-4.00', '-175.00');
INSERT INTO `stock_record_item` VALUES ('1184751110780837888', '1184751110759866368', '1184660256432984064', '2', '4.00', '-179.00');
INSERT INTO `stock_record_item` VALUES ('1184751192427159552', '1184751192406188032', '1184660256432984064', '2', '-1.00', '-178.00');
INSERT INTO `stock_record_item` VALUES ('1184751198215618560', '1184751198203035648', '1184660603379200000', '2', '-1.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1184751230729543680', '1184751230704377856', '1184660256432984064', '2', '2.00', '-180.00');
INSERT INTO `stock_record_item` VALUES ('1184751261083721728', '1184751261066944512', '1184660256432984064', '2', '-6.00', '-174.00');
INSERT INTO `stock_record_item` VALUES ('1184753438316306432', '1184753438307917824', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184984012232761344', '1184984012224372736', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184984473241296896', '1184984473232908288', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184985911413612544', '1184985911405223936', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184985928182439936', '1184985928174051328', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184986330441359360', '1184986330432970752', '1184665503209234432', '2', '0.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1184986962778824704', '1184986962766241792', '1184665503209234432', '2', '1.00', '994.00');
INSERT INTO `stock_record_item` VALUES ('1184987680306798592', '1184987680294215680', '1184665503209234432', '2', '0.00', '994.00');
INSERT INTO `stock_record_item` VALUES ('1184991181309124608', '1184991181300736000', '1184665503209234432', '2', '1.00', '993.00');
INSERT INTO `stock_record_item` VALUES ('1185001861560754176', '1185001861552365568', '1184665503209234432', '2', '0.00', '993.00');
INSERT INTO `stock_record_item` VALUES ('1185008263398252544', '1185008263389863936', '1184665503209234432', '1', '1.00', '994.00');
INSERT INTO `stock_record_item` VALUES ('1185008263419224064', '1185008263389863936', '1184665503209234432', '1', '1.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1185008263444389888', '1185008263389863936', '1184665503209234432', '1', '1.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185008428800630784', '1185008428792242176', '1184665503209234432', '1', '1.00', '997.00');
INSERT INTO `stock_record_item` VALUES ('1185008428829990912', '1185008428792242176', '1184665503209234432', '1', '1.00', '998.00');
INSERT INTO `stock_record_item` VALUES ('1185008428850962432', '1185008428792242176', '1184665503209234432', '1', '1.00', '999.00');
INSERT INTO `stock_record_item` VALUES ('1185008428876128256', '1185008428792242176', '1184663166075936768', '1', '1.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1185008428897099776', '1185008428792242176', '1184663166075936768', '1', '1.00', '91.00');
INSERT INTO `stock_record_item` VALUES ('1185008428955820032', '1185008428792242176', '1184663166075936768', '1', '1.00', '92.00');
INSERT INTO `stock_record_item` VALUES ('1185008599055818752', '1185008599047430144', '1184665503209234432', '2', '1.00', '998.00');
INSERT INTO `stock_record_item` VALUES ('1185008599076790272', '1185008599047430144', '1184665503209234432', '2', '1.00', '997.00');
INSERT INTO `stock_record_item` VALUES ('1185008599101956096', '1185008599047430144', '1184665503209234432', '2', '1.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185008599118733312', '1185008599047430144', '1184663166075936768', '2', '1.00', '91.00');
INSERT INTO `stock_record_item` VALUES ('1185008599148093440', '1185008599047430144', '1184663166075936768', '2', '1.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1185008599173259264', '1185008599047430144', '1184663166075936768', '2', '1.00', '89.00');
INSERT INTO `stock_record_item` VALUES ('1185020735438020608', '1185020735421243392', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185033329917911040', '1185033329909522432', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185037601598676992', '1185037601590288384', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185037646976851968', '1185037646968463360', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185038711927414784', '1185038711919026176', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185039026785427456', '1185039026777038848', '1184663166075936768', '2', '89.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1185039177738428416', '1185039177730039808', '1184663166075936768', '1', '1.00', '1.00');
INSERT INTO `stock_record_item` VALUES ('1185039338011172864', '1185039338002784256', '1184663166075936768', '2', '1.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1185039338036338688', '1185039338002784256', '1184665503209234432', '2', '1.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1185039389848576000', '1185039389835993088', '1184665503209234432', '1', '1.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185039389873741824', '1185039389835993088', '1184663166075936768', '1', '1.00', '1.00');
INSERT INTO `stock_record_item` VALUES ('1185115852395003904', '1185115852386615296', '1184665503209234432', '2', '0.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1185349655996268544', '1185349655979491328', '1184660420260081664', '2', '1.00', '96.00');
INSERT INTO `stock_record_item` VALUES ('1185440396075290624', '1185440396062707712', '1183232183269470208', '1', '1.00', '102.00');
INSERT INTO `stock_record_item` VALUES ('1185442202837422080', '1185442202820644864', '1183232183269470208', '2', '1.00', '101.00');
INSERT INTO `stock_record_item` VALUES ('1185447691875848192', '1185447691859070976', '1185440448003543040', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1185448029281693696', '1185448029260722176', '1185442885426155520', '1', '1.00', '1.00');
INSERT INTO `stock_record_item` VALUES ('1185448947913961472', '1185448947901378560', '1185442885426155520', '2', '1.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1186835611538599936', '1186835611517628416', '1184660420260081664', '2', '20.00', '76.00');
INSERT INTO `stock_record_item` VALUES ('1186836531941871616', '1186836531925094400', '1184660603379200000', '2', '11.00', '79.00');
INSERT INTO `stock_record_item` VALUES ('1186836609666519040', '1186836609649741824', '1184660603379200000', '2', '33.00', '46.00');
INSERT INTO `stock_record_item` VALUES ('1187159935758471168', '1187159935376789504', '1183232183269470208', '2', '9999.00', '-9898.00');
INSERT INTO `stock_record_item` VALUES ('1187160127874371584', '1187160127857594368', '1183232183269470208', '2', '9990000.00', '-9999898.00');
INSERT INTO `stock_record_item` VALUES ('1187160853333774336', '1187160853316997120', '1183232183269470208', '2', '-9999999.00', '101.00');
INSERT INTO `stock_record_item` VALUES ('1187161303855190016', '1187161303838412800', '1183232183269470208', '2', '99.00', '2.00');
INSERT INTO `stock_record_item` VALUES ('1187180407198572544', '1187180407181795328', '1185440448003543040', '2', '20.00', '80.00');
INSERT INTO `stock_record_item` VALUES ('1187180723105161216', '1187180723092578304', '1185440448003543040', '2', '-2.00', '82.00');
INSERT INTO `stock_record_item` VALUES ('1187181531068993536', '1187181531052216320', '1185440448003543040', '2', '-8.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1187181931859906560', '1187181931847323648', '1185440448003543040', '2', '0.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1187181931906043904', '1187181931847323648', '1183232183269470208', '2', '1.00', '1.00');
INSERT INTO `stock_record_item` VALUES ('1187182268767375360', '1187182268754792448', '1185440448003543040', '2', '20.00', '70.00');
INSERT INTO `stock_record_item` VALUES ('1187185191487016960', '1187185191474434048', '1183231342462513152', '1', '200.00', '200.00');
INSERT INTO `stock_record_item` VALUES ('1187185191596068864', '1187185191474434048', '1183232183269470208', '1', '200.00', '201.00');
INSERT INTO `stock_record_item` VALUES ('1187185191629623296', '1187185191474434048', '1185440448003543040', '1', '200.00', '270.00');
INSERT INTO `stock_record_item` VALUES ('1187185291558916096', '1187185291546333184', '1183232183269470208', '2', '10.00', '191.00');
INSERT INTO `stock_record_item` VALUES ('1187185291592470528', '1187185291546333184', '1185440448003543040', '2', '5.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1187185374388031488', '1187185374375448576', '1185440448003543040', '2', '0.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1187185374417391616', '1187185374375448576', '1183232183269470208', '2', '-5.00', '196.00');
INSERT INTO `stock_record_item` VALUES ('1187186090816589824', '1187186090799812608', '1185440448003543040', '2', '0.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1187186090892087296', '1187186090799812608', '1183232183269470208', '2', '5.00', '191.00');
INSERT INTO `stock_record_item` VALUES ('1187187313354100736', '1187187313337323520', '1185440448003543040', '2', '0.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1187187313425403904', '1187187313337323520', '1183232183269470208', '2', '90.00', '101.00');
INSERT INTO `stock_record_item` VALUES ('1187187433390886912', '1187187433374109696', '1183231342462513152', '2', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1187188627911888896', '1187188627857362944', '1183231342462513152', '2', '10.00', '80.00');
INSERT INTO `stock_record_item` VALUES ('1187188796195753984', '1187188796178976768', '1183231342462513152', '2', '-1.00', '81.00');
INSERT INTO `stock_record_item` VALUES ('1187188816744808448', '1187188816728031232', '1183231342462513152', '2', '10.00', '90.00');
INSERT INTO `stock_record_item` VALUES ('1187194087777525760', '1187194087764942848', '1183231342462513152', '2', '10.00', '71.00');
INSERT INTO `stock_record_item` VALUES ('1187194260054368256', '1187194260041785344', '1183231342462513152', '2', '10.00', '61.00');
INSERT INTO `stock_record_item` VALUES ('1188732088228335616', '1188732088215752704', '1185440448003543040', '2', '1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1188732088299638784', '1188732088215752704', '1185440448003543040', '2', '1.00', '263.00');
INSERT INTO `stock_record_item` VALUES ('1189792412881723392', '1189792412860751872', '1184660420260081664', '1', '1000.00', '1000.00');
INSERT INTO `stock_record_item` VALUES ('1189792471954300928', '1189792471941718016', '1184660420260081664', '2', '1000.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1189792930555305984', '1189792930534334464', '1184660420260081664', '1', '1000.00', '1000.00');
INSERT INTO `stock_record_item` VALUES ('1189792988658999296', '1189792988646416384', '1184660420260081664', '2', '1000.00', '0.00');
INSERT INTO `stock_record_item` VALUES ('1189793093164277760', '1189793093139111936', '1183232183269470208', '1', '1000.00', '1000.00');
INSERT INTO `stock_record_item` VALUES ('1189793152350101504', '1189793152337518592', '1183232183269470208', '2', '1.00', '999.00');
INSERT INTO `stock_record_item` VALUES ('1189793152941498368', '1189793152928915456', '1183232183269470208', '2', '1.00', '998.00');
INSERT INTO `stock_record_item` VALUES ('1189793153633558528', '1189793153620975616', '1183232183269470208', '2', '1.00', '997.00');
INSERT INTO `stock_record_item` VALUES ('1189793154375950336', '1189793154363367424', '1183232183269470208', '2', '1.00', '996.00');
INSERT INTO `stock_record_item` VALUES ('1189793155776847872', '1189793155751682048', '1183232183269470208', '2', '1.00', '995.00');
INSERT INTO `stock_record_item` VALUES ('1189793157110636544', '1189793157089665024', '1183232183269470208', '2', '1.00', '994.00');
INSERT INTO `stock_record_item` VALUES ('1189793158427648000', '1189793158419259392', '1183232183269470208', '2', '1.00', '993.00');
INSERT INTO `stock_record_item` VALUES ('1189793159132291072', '1189793159123902464', '1183232183269470208', '2', '1.00', '992.00');
INSERT INTO `stock_record_item` VALUES ('1189793159811768320', '1189793159799185408', '1183232183269470208', '2', '1.00', '991.00');
INSERT INTO `stock_record_item` VALUES ('1189793160562548736', '1189793160545771520', '1183232183269470208', '2', '1.00', '990.00');
INSERT INTO `stock_record_item` VALUES ('1189793262261837824', '1189793262240866304', '1183232183269470208', '2', '1.00', '989.00');
INSERT INTO `stock_record_item` VALUES ('1189793263562072064', '1189793263549489152', '1183232183269470208', '2', '1.00', '988.00');
INSERT INTO `stock_record_item` VALUES ('1189793264275103744', '1189793264258326528', '1183232183269470208', '2', '1.00', '987.00');
INSERT INTO `stock_record_item` VALUES ('1189793265579532288', '1189793265566949376', '1183232183269470208', '2', '1.00', '986.00');
INSERT INTO `stock_record_item` VALUES ('1189793266850406400', '1189793266842017792', '1183232183269470208', '2', '1.00', '985.00');
INSERT INTO `stock_record_item` VALUES ('1189793268138057728', '1189793268121280512', '1183232183269470208', '2', '1.00', '984.00');
INSERT INTO `stock_record_item` VALUES ('1189793268725260288', '1189793268712677376', '1183232183269470208', '2', '1.00', '983.00');
INSERT INTO `stock_record_item` VALUES ('1189793269526372352', '1189793269509595136', '1183232183269470208', '2', '1.00', '982.00');
INSERT INTO `stock_record_item` VALUES ('1189793270935658496', '1189793270885326848', '1183232183269470208', '2', '1.00', '981.00');
INSERT INTO `stock_record_item` VALUES ('1189793781994823680', '1189793781944492032', '1183232183269470208', '2', '1.00', '980.00');
INSERT INTO `stock_record_item` VALUES ('1189793823434547200', '1189793823413575680', '1183232183269470208', '2', '1.00', '979.00');
INSERT INTO `stock_record_item` VALUES ('1189793832188059648', '1189793832171282432', '1183232183269470208', '2', '1.00', '978.00');
INSERT INTO `stock_record_item` VALUES ('1189793929995034624', '1189793929965674496', '1183232183269470208', '2', '1.00', '977.00');
INSERT INTO `stock_record_item` VALUES ('1189793931303657472', '1189793931278491648', '1183232183269470208', '2', '1.00', '976.00');
INSERT INTO `stock_record_item` VALUES ('1189793935808339968', '1189793935787368448', '1183232183269470208', '2', '1.00', '975.00');
INSERT INTO `stock_record_item` VALUES ('1189793936521371648', '1189793936512983040', '1183232183269470208', '2', '1.00', '974.00');
INSERT INTO `stock_record_item` VALUES ('1189793976958656512', '1189793976941879296', '1183232183269470208', '2', '1.00', '973.00');
INSERT INTO `stock_record_item` VALUES ('1189793978296639488', '1189793978279862272', '1183232183269470208', '2', '1.00', '972.00');
INSERT INTO `stock_record_item` VALUES ('1189793979504599040', '1189793979492016128', '1183232183269470208', '2', '1.00', '971.00');
INSERT INTO `stock_record_item` VALUES ('1189793980129550336', '1189793980121161728', '1183232183269470208', '2', '1.00', '970.00');
INSERT INTO `stock_record_item` VALUES ('1189793980813221888', '1189793980800638976', '1183232183269470208', '2', '1.00', '969.00');
INSERT INTO `stock_record_item` VALUES ('1189793981475921920', '1189793981463339008', '1183232183269470208', '2', '1.00', '968.00');
INSERT INTO `stock_record_item` VALUES ('1189793982117650432', '1189793982109261824', '1183232183269470208', '2', '1.00', '967.00');
INSERT INTO `stock_record_item` VALUES ('1189793982906179584', '1189793982885208064', '1183232183269470208', '2', '1.00', '966.00');
INSERT INTO `stock_record_item` VALUES ('1189794199030276096', '1189794199013498880', '1183232183269470208', '2', '1.00', '965.00');
INSERT INTO `stock_record_item` VALUES ('1189794199663616000', '1189794199651033088', '1183232183269470208', '2', '1.00', '964.00');
INSERT INTO `stock_record_item` VALUES ('1189794200389230592', '1189794200372453376', '1183232183269470208', '2', '1.00', '963.00');
INSERT INTO `stock_record_item` VALUES ('1189794201693659136', '1189794201676881920', '1183232183269470208', '2', '1.00', '962.00');
INSERT INTO `stock_record_item` VALUES ('1189794202914201600', '1189794202901618688', '1183232183269470208', '2', '1.00', '961.00');
INSERT INTO `stock_record_item` VALUES ('1189794204369625088', '1189794204348653568', '1183232183269470208', '2', '1.00', '960.00');
INSERT INTO `stock_record_item` VALUES ('1189794205728579584', '1189794205703413760', '1183232183269470208', '2', '1.00', '959.00');
INSERT INTO `stock_record_item` VALUES ('1189794207079145472', '1189794207058173952', '1183232183269470208', '2', '1.00', '958.00');
INSERT INTO `stock_record_item` VALUES ('1191188505714024448', '1191188505697247232', '1191177074818289664', '1', '10.00', '10.00');
INSERT INTO `stock_record_item` VALUES ('1191190764791324672', '1191190764778741760', '1191177074818289664', '2', '1.00', '9.00');
INSERT INTO `stock_record_item` VALUES ('1191218996482629632', '1191218996465852416', '1191177325104992256', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1191219105492590592', '1191219105454841856', '1191177074818289664', '1', '100.00', '100.00');
INSERT INTO `stock_record_item` VALUES ('1191219490219319296', '1191219490206736384', '1191177074818289664', '2', '1.00', '99.00');
INSERT INTO `stock_record_item` VALUES ('1191944573012291584', '1191944572999708672', '1185440448003543040', '2', '-1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1191952031155892224', '1191952031143309312', '1185440448003543040', '2', '-1.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1191952635857088512', '1191952635840311296', '1185440448003543040', '2', '1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1191952729276821504', '1191952729260044288', '1185440448003543040', '2', '1.00', '263.00');
INSERT INTO `stock_record_item` VALUES ('1191954240258420736', '1191954240245837824', '1185440448003543040', '2', '-1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1191954594372677632', '1191954594334928896', '1185440448003543040', '2', '-1.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1191954865947287552', '1191954865934704640', '1185440448003543040', '2', '-1.00', '266.00');
INSERT INTO `stock_record_item` VALUES ('1191955842456756224', '1191955842439979008', '1185440448003543040', '2', '1.00', '265.00');
INSERT INTO `stock_record_item` VALUES ('1191956220533465088', '1191956220512493568', '1185440448003543040', '2', '1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1191956317514162176', '1191956317493190656', '1185440448003543040', '2', '1.00', '263.00');
INSERT INTO `stock_record_item` VALUES ('1191956382723006464', '1191956382710423552', '1185440448003543040', '2', '-1.00', '264.00');
INSERT INTO `stock_record_item` VALUES ('1192344803047161856', '1192344803034578944', '1185440448003543040', '2', '1.00', '263.00');
INSERT INTO `stock_record_item` VALUES ('1192344930952462336', '1192344930931490816', '1185440448003543040', '2', '1.00', '262.00');
INSERT INTO `stock_record_item` VALUES ('1192345644036739072', '1192345644024156160', '1185440448003543040', '2', '1.00', '261.00');
INSERT INTO `stock_record_item` VALUES ('1192345984228540416', '1192345984211763200', '1185440448003543040', '2', '1.00', '260.00');
INSERT INTO `stock_record_item` VALUES ('1192669367955345408', '1192669367946956800', '1192669271402467328', '1', '1111.00', '1111.00');
INSERT INTO `stock_record_item` VALUES ('1192669427568988160', '1192669427564793856', '1192669271402467328', '2', '1.00', '1110.00');
INSERT INTO `stock_record_item` VALUES ('1192669716527173632', '1192669716522979328', '1192669271402467328', '2', '1.00', '1109.00');
INSERT INTO `stock_record_item` VALUES ('1192669822945054720', '1192669822940860416', '1192669271402467328', '2', '1.00', '1108.00');
INSERT INTO `stock_record_item` VALUES ('1192670266610335744', '1192670266601947136', '1192669271402467328', '2', '1.00', '1107.00');
INSERT INTO `stock_record_item` VALUES ('1192670792422035456', '1192670792417841152', '1192669271402467328', '2', '1.00', '1106.00');
INSERT INTO `stock_record_item` VALUES ('1192671554251984896', '1192671554247790592', '1192669271402467328', '2', '1.00', '1105.00');
INSERT INTO `stock_record_item` VALUES ('1192672679688605696', '1192672679684411392', '1192669271402467328', '2', '1.00', '1104.00');
INSERT INTO `stock_record_item` VALUES ('1192673835747401728', '1192673835739013120', '1192669271402467328', '2', '1.00', '1103.00');
INSERT INTO `stock_record_item` VALUES ('1192673995730739200', '1192673995726544896', '1192669271402467328', '2', '1.00', '1102.00');
INSERT INTO `stock_record_item` VALUES ('1192675197522628608', '1192675197518434304', '1192669271402467328', '2', '1.00', '1101.00');
INSERT INTO `stock_record_item` VALUES ('1192675561869234176', '1192675561865039872', '1192669271402467328', '2', '1.00', '1100.00');
INSERT INTO `stock_record_item` VALUES ('1192676843581726720', '1192676843577532416', '1192669271402467328', '2', '1.00', '1099.00');
INSERT INTO `stock_record_item` VALUES ('1192677072028688384', '1192677072020299776', '1192669271402467328', '2', '1.00', '1098.00');
INSERT INTO `stock_record_item` VALUES ('1192677424748683264', '1192677424744488960', '1192669271402467328', '2', '1.00', '1097.00');
INSERT INTO `stock_record_item` VALUES ('1192677539743916032', '1192677539739721728', '1192669271402467328', '2', '1.00', '1096.00');
INSERT INTO `stock_record_item` VALUES ('1194461604694089728', '1194461604677312512', '1183232183269470208', '2', '1.00', '957.00');
INSERT INTO `stock_record_item` VALUES ('1194500648036261888', '1194500648027873280', '1183232183269470208', '2', '1.00', '956.00');
INSERT INTO `stock_record_item` VALUES ('1194500813879042048', '1194500813870653440', '1183232183269470208', '2', '1.00', '955.00');
INSERT INTO `stock_record_item` VALUES ('1194502197071872000', '1194502197063483392', '1183232183269470208', '2', '1.00', '954.00');
INSERT INTO `stock_record_item` VALUES ('1194550373989584896', '1194550373981196288', '1183232183269470208', '2', '1.00', '953.00');
INSERT INTO `stock_record_item` VALUES ('1194550608073691136', '1194550608069496832', '1183232183269470208', '2', '1.00', '952.00');
INSERT INTO `stock_record_item` VALUES ('1194552449637388288', '1194552449633193984', '1183232183269470208', '2', '1.00', '951.00');
INSERT INTO `stock_record_item` VALUES ('1194553038033268736', '1194553038024880128', '1183232183269470208', '2', '0.00', '951.00');
INSERT INTO `stock_record_item` VALUES ('1194553120270987264', '1194553120266792960', '1183232183269470208', '2', '0.00', '951.00');
INSERT INTO `stock_record_item` VALUES ('1194843753142263808', '1194843753129680896', '1183232183269470208', '2', '1.00', '950.00');
INSERT INTO `stock_record_item` VALUES ('1194843906544738304', '1194843906527961088', '1183232183269470208', '2', '1.00', '949.00');
INSERT INTO `stock_record_item` VALUES ('1194844084467113984', '1194844084450336768', '1183232183269470208', '2', '1.00', '948.00');
INSERT INTO `stock_record_item` VALUES ('1194844495485046784', '1194844495468269568', '1183232183269470208', '2', '1.00', '947.00');
INSERT INTO `stock_record_item` VALUES ('1195155973631164416', '1195155973618581504', '1191177074818289664', '2', '1.00', '98.00');

-- ----------------------------
-- Table structure for sys_area
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` varchar(32) NOT NULL COMMENT '地址id',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `name` varchar(50) DEFAULT NULL COMMENT '地址名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常 1删除 2停用）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `address_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行政区';

-- ----------------------------
-- Records of sys_area
-- ----------------------------
INSERT INTO `sys_area` VALUES ('110000', '0', '0,', '11', '00000011,', '0', '0', null, '北京市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110100', '110000', '0,110000,', '0', '00000011,00000000,', '0', '1', null, '市辖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110101', '110100', '0,110000,110100,', '1', '00000011,00000000,00000001,', '1', '2', null, '东城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110102', '110100', '0,110000,110100,', '2', '00000011,00000000,00000002,', '1', '2', null, '西城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110103', '110100', '0,110000,110100,', '3', '00000011,00000000,00000003,', '1', '2', null, '崇文区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110104', '110100', '0,110000,110100,', '4', '00000011,00000000,00000004,', '1', '2', null, '宣武区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110105', '110100', '0,110000,110100,', '5', '00000011,00000000,00000005,', '1', '2', null, '朝阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110106', '110100', '0,110000,110100,', '6', '00000011,00000000,00000006,', '1', '2', null, '丰台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110107', '110100', '0,110000,110100,', '7', '00000011,00000000,00000007,', '1', '2', null, '石景山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110108', '110100', '0,110000,110100,', '8', '00000011,00000000,00000008,', '1', '2', null, '海淀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110109', '110100', '0,110000,110100,', '9', '00000011,00000000,00000009,', '1', '2', null, '门头沟区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110111', '110100', '0,110000,110100,', '11', '00000011,00000000,00000011,', '1', '2', null, '房山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110112', '110100', '0,110000,110100,', '12', '00000011,00000000,00000012,', '1', '2', null, '通州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110113', '110100', '0,110000,110100,', '13', '00000011,00000000,00000013,', '1', '2', null, '顺义区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110114', '110100', '0,110000,110100,', '14', '00000011,00000000,00000014,', '1', '2', null, '昌平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110115', '110100', '0,110000,110100,', '15', '00000011,00000000,00000015,', '1', '2', null, '大兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110116', '110100', '0,110000,110100,', '16', '00000011,00000000,00000016,', '1', '2', null, '怀柔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110117', '110100', '0,110000,110100,', '17', '00000011,00000000,00000017,', '1', '2', null, '平谷区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110200', '110000', '0,110000,', '0', '00000011,00000000,', '0', '1', null, '县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110228', '110200', '0,110000,110200,', '28', '00000011,00000000,00000028,', '1', '2', null, '密云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('110229', '110200', '0,110000,110200,', '29', '00000011,00000000,00000029,', '1', '2', null, '延庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120000', '0', '0,', '12', '00000012,', '0', '0', null, '天津市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120100', '120000', '0,120000,', '0', '00000012,00000000,', '0', '1', null, '市辖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120101', '120100', '0,120000,120100,', '1', '00000012,00000000,00000001,', '1', '2', null, '和平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120102', '120100', '0,120000,120100,', '2', '00000012,00000000,00000002,', '1', '2', null, '河东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120103', '120100', '0,120000,120100,', '3', '00000012,00000000,00000003,', '1', '2', null, '河西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120104', '120100', '0,120000,120100,', '4', '00000012,00000000,00000004,', '1', '2', null, '南开区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120105', '120100', '0,120000,120100,', '5', '00000012,00000000,00000005,', '1', '2', null, '河北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120106', '120100', '0,120000,120100,', '6', '00000012,00000000,00000006,', '1', '2', null, '红桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120107', '120100', '0,120000,120100,', '7', '00000012,00000000,00000007,', '1', '2', null, '塘沽区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120108', '120100', '0,120000,120100,', '8', '00000012,00000000,00000008,', '1', '2', null, '汉沽区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120109', '120100', '0,120000,120100,', '9', '00000012,00000000,00000009,', '1', '2', null, '大港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120110', '120100', '0,120000,120100,', '10', '00000012,00000000,00000010,', '1', '2', null, '东丽区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120111', '120100', '0,120000,120100,', '11', '00000012,00000000,00000011,', '1', '2', null, '西青区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120112', '120100', '0,120000,120100,', '12', '00000012,00000000,00000012,', '1', '2', null, '津南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120113', '120100', '0,120000,120100,', '13', '00000012,00000000,00000013,', '1', '2', null, '北辰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120114', '120100', '0,120000,120100,', '14', '00000012,00000000,00000014,', '1', '2', null, '武清区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120115', '120100', '0,120000,120100,', '15', '00000012,00000000,00000015,', '1', '2', null, '宝坻区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120200', '120000', '0,120000,', '0', '00000012,00000000,', '0', '1', null, '县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120221', '120200', '0,120000,120200,', '21', '00000012,00000000,00000021,', '1', '2', null, '宁河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120223', '120200', '0,120000,120200,', '23', '00000012,00000000,00000023,', '1', '2', null, '静海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('120225', '120200', '0,120000,120200,', '25', '00000012,00000000,00000025,', '1', '2', null, '蓟　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130000', '0', '0,', '13', '00000013,', '0', '0', null, '河北省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130100', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '石家庄市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130102', '130100', '0,130000,130100,', '2', '00000013,00000000,00000002,', '1', '2', null, '长安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130103', '130100', '0,130000,130100,', '3', '00000013,00000000,00000003,', '1', '2', null, '桥东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130104', '130100', '0,130000,130100,', '4', '00000013,00000000,00000004,', '1', '2', null, '桥西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130105', '130100', '0,130000,130100,', '5', '00000013,00000000,00000005,', '1', '2', null, '新华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130107', '130100', '0,130000,130100,', '7', '00000013,00000000,00000007,', '1', '2', null, '井陉矿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130108', '130100', '0,130000,130100,', '8', '00000013,00000000,00000008,', '1', '2', null, '裕华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130121', '130100', '0,130000,130100,', '21', '00000013,00000000,00000021,', '1', '2', null, '井陉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130123', '130100', '0,130000,130100,', '23', '00000013,00000000,00000023,', '1', '2', null, '正定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130124', '130100', '0,130000,130100,', '24', '00000013,00000000,00000024,', '1', '2', null, '栾城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130125', '130100', '0,130000,130100,', '25', '00000013,00000000,00000025,', '1', '2', null, '行唐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130126', '130100', '0,130000,130100,', '26', '00000013,00000000,00000026,', '1', '2', null, '灵寿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130127', '130100', '0,130000,130100,', '27', '00000013,00000000,00000027,', '1', '2', null, '高邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130128', '130100', '0,130000,130100,', '28', '00000013,00000000,00000028,', '1', '2', null, '深泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130129', '130100', '0,130000,130100,', '29', '00000013,00000000,00000029,', '1', '2', null, '赞皇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130130', '130100', '0,130000,130100,', '30', '00000013,00000000,00000030,', '1', '2', null, '无极县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130131', '130100', '0,130000,130100,', '31', '00000013,00000000,00000031,', '1', '2', null, '平山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130132', '130100', '0,130000,130100,', '32', '00000013,00000000,00000032,', '1', '2', null, '元氏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130133', '130100', '0,130000,130100,', '33', '00000013,00000000,00000033,', '1', '2', null, '赵　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130181', '130100', '0,130000,130100,', '81', '00000013,00000000,00000081,', '1', '2', null, '辛集市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130182', '130100', '0,130000,130100,', '82', '00000013,00000000,00000082,', '1', '2', null, '藁城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130183', '130100', '0,130000,130100,', '83', '00000013,00000000,00000083,', '1', '2', null, '晋州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130184', '130100', '0,130000,130100,', '84', '00000013,00000000,00000084,', '1', '2', null, '新乐市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130185', '130100', '0,130000,130100,', '85', '00000013,00000000,00000085,', '1', '2', null, '鹿泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130200', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '唐山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130202', '130200', '0,130000,130200,', '2', '00000013,00000000,00000002,', '1', '2', null, '路南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130203', '130200', '0,130000,130200,', '3', '00000013,00000000,00000003,', '1', '2', null, '路北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130204', '130200', '0,130000,130200,', '4', '00000013,00000000,00000004,', '1', '2', null, '古冶区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130205', '130200', '0,130000,130200,', '5', '00000013,00000000,00000005,', '1', '2', null, '开平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130207', '130200', '0,130000,130200,', '7', '00000013,00000000,00000007,', '1', '2', null, '丰南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130208', '130200', '0,130000,130200,', '8', '00000013,00000000,00000008,', '1', '2', null, '丰润区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130223', '130200', '0,130000,130200,', '23', '00000013,00000000,00000023,', '1', '2', null, '滦　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130224', '130200', '0,130000,130200,', '24', '00000013,00000000,00000024,', '1', '2', null, '滦南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130225', '130200', '0,130000,130200,', '25', '00000013,00000000,00000025,', '1', '2', null, '乐亭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130227', '130200', '0,130000,130200,', '27', '00000013,00000000,00000027,', '1', '2', null, '迁西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130229', '130200', '0,130000,130200,', '29', '00000013,00000000,00000029,', '1', '2', null, '玉田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130230', '130200', '0,130000,130200,', '30', '00000013,00000000,00000030,', '1', '2', null, '唐海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130281', '130200', '0,130000,130200,', '81', '00000013,00000000,00000081,', '1', '2', null, '遵化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130283', '130200', '0,130000,130200,', '83', '00000013,00000000,00000083,', '1', '2', null, '迁安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130300', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '秦皇岛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130302', '130300', '0,130000,130300,', '2', '00000013,00000000,00000002,', '1', '2', null, '海港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130303', '130300', '0,130000,130300,', '3', '00000013,00000000,00000003,', '1', '2', null, '山海关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130304', '130300', '0,130000,130300,', '4', '00000013,00000000,00000004,', '1', '2', null, '北戴河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130321', '130300', '0,130000,130300,', '21', '00000013,00000000,00000021,', '1', '2', null, '青龙满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130322', '130300', '0,130000,130300,', '22', '00000013,00000000,00000022,', '1', '2', null, '昌黎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130323', '130300', '0,130000,130300,', '23', '00000013,00000000,00000023,', '1', '2', null, '抚宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130324', '130300', '0,130000,130300,', '24', '00000013,00000000,00000024,', '1', '2', null, '卢龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130400', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '邯郸市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130402', '130400', '0,130000,130400,', '2', '00000013,00000000,00000002,', '1', '2', null, '邯山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130403', '130400', '0,130000,130400,', '3', '00000013,00000000,00000003,', '1', '2', null, '丛台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130404', '130400', '0,130000,130400,', '4', '00000013,00000000,00000004,', '1', '2', null, '复兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130406', '130400', '0,130000,130400,', '6', '00000013,00000000,00000006,', '1', '2', null, '峰峰矿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130421', '130400', '0,130000,130400,', '21', '00000013,00000000,00000021,', '1', '2', null, '邯郸县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130423', '130400', '0,130000,130400,', '23', '00000013,00000000,00000023,', '1', '2', null, '临漳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130424', '130400', '0,130000,130400,', '24', '00000013,00000000,00000024,', '1', '2', null, '成安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130425', '130400', '0,130000,130400,', '25', '00000013,00000000,00000025,', '1', '2', null, '大名县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130426', '130400', '0,130000,130400,', '26', '00000013,00000000,00000026,', '1', '2', null, '涉　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130427', '130400', '0,130000,130400,', '27', '00000013,00000000,00000027,', '1', '2', null, '磁　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130428', '130400', '0,130000,130400,', '28', '00000013,00000000,00000028,', '1', '2', null, '肥乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130429', '130400', '0,130000,130400,', '29', '00000013,00000000,00000029,', '1', '2', null, '永年县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130430', '130400', '0,130000,130400,', '30', '00000013,00000000,00000030,', '1', '2', null, '邱　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130431', '130400', '0,130000,130400,', '31', '00000013,00000000,00000031,', '1', '2', null, '鸡泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130432', '130400', '0,130000,130400,', '32', '00000013,00000000,00000032,', '1', '2', null, '广平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130433', '130400', '0,130000,130400,', '33', '00000013,00000000,00000033,', '1', '2', null, '馆陶县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130434', '130400', '0,130000,130400,', '34', '00000013,00000000,00000034,', '1', '2', null, '魏　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130435', '130400', '0,130000,130400,', '35', '00000013,00000000,00000035,', '1', '2', null, '曲周县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130481', '130400', '0,130000,130400,', '81', '00000013,00000000,00000081,', '1', '2', null, '武安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130500', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '邢台市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130502', '130500', '0,130000,130500,', '2', '00000013,00000000,00000002,', '1', '2', null, '桥东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130503', '130500', '0,130000,130500,', '3', '00000013,00000000,00000003,', '1', '2', null, '桥西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130521', '130500', '0,130000,130500,', '21', '00000013,00000000,00000021,', '1', '2', null, '邢台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130522', '130500', '0,130000,130500,', '22', '00000013,00000000,00000022,', '1', '2', null, '临城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130523', '130500', '0,130000,130500,', '23', '00000013,00000000,00000023,', '1', '2', null, '内丘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130524', '130500', '0,130000,130500,', '24', '00000013,00000000,00000024,', '1', '2', null, '柏乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130525', '130500', '0,130000,130500,', '25', '00000013,00000000,00000025,', '1', '2', null, '隆尧县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130526', '130500', '0,130000,130500,', '26', '00000013,00000000,00000026,', '1', '2', null, '任　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130527', '130500', '0,130000,130500,', '27', '00000013,00000000,00000027,', '1', '2', null, '南和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130528', '130500', '0,130000,130500,', '28', '00000013,00000000,00000028,', '1', '2', null, '宁晋县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130529', '130500', '0,130000,130500,', '29', '00000013,00000000,00000029,', '1', '2', null, '巨鹿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130530', '130500', '0,130000,130500,', '30', '00000013,00000000,00000030,', '1', '2', null, '新河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130531', '130500', '0,130000,130500,', '31', '00000013,00000000,00000031,', '1', '2', null, '广宗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130532', '130500', '0,130000,130500,', '32', '00000013,00000000,00000032,', '1', '2', null, '平乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130533', '130500', '0,130000,130500,', '33', '00000013,00000000,00000033,', '1', '2', null, '威　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130534', '130500', '0,130000,130500,', '34', '00000013,00000000,00000034,', '1', '2', null, '清河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130535', '130500', '0,130000,130500,', '35', '00000013,00000000,00000035,', '1', '2', null, '临西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130581', '130500', '0,130000,130500,', '81', '00000013,00000000,00000081,', '1', '2', null, '南宫市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130582', '130500', '0,130000,130500,', '82', '00000013,00000000,00000082,', '1', '2', null, '沙河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130600', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '保定市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130602', '130600', '0,130000,130600,', '2', '00000013,00000000,00000002,', '1', '2', null, '新市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130603', '130600', '0,130000,130600,', '3', '00000013,00000000,00000003,', '1', '2', null, '北市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130604', '130600', '0,130000,130600,', '4', '00000013,00000000,00000004,', '1', '2', null, '南市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130621', '130600', '0,130000,130600,', '21', '00000013,00000000,00000021,', '1', '2', null, '满城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130622', '130600', '0,130000,130600,', '22', '00000013,00000000,00000022,', '1', '2', null, '清苑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130623', '130600', '0,130000,130600,', '23', '00000013,00000000,00000023,', '1', '2', null, '涞水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130624', '130600', '0,130000,130600,', '24', '00000013,00000000,00000024,', '1', '2', null, '阜平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130625', '130600', '0,130000,130600,', '25', '00000013,00000000,00000025,', '1', '2', null, '徐水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130626', '130600', '0,130000,130600,', '26', '00000013,00000000,00000026,', '1', '2', null, '定兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130627', '130600', '0,130000,130600,', '27', '00000013,00000000,00000027,', '1', '2', null, '唐　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130628', '130600', '0,130000,130600,', '28', '00000013,00000000,00000028,', '1', '2', null, '高阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130629', '130600', '0,130000,130600,', '29', '00000013,00000000,00000029,', '1', '2', null, '容城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130630', '130600', '0,130000,130600,', '30', '00000013,00000000,00000030,', '1', '2', null, '涞源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130631', '130600', '0,130000,130600,', '31', '00000013,00000000,00000031,', '1', '2', null, '望都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130632', '130600', '0,130000,130600,', '32', '00000013,00000000,00000032,', '1', '2', null, '安新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130633', '130600', '0,130000,130600,', '33', '00000013,00000000,00000033,', '1', '2', null, '易　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130634', '130600', '0,130000,130600,', '34', '00000013,00000000,00000034,', '1', '2', null, '曲阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130635', '130600', '0,130000,130600,', '35', '00000013,00000000,00000035,', '1', '2', null, '蠡　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130636', '130600', '0,130000,130600,', '36', '00000013,00000000,00000036,', '1', '2', null, '顺平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130637', '130600', '0,130000,130600,', '37', '00000013,00000000,00000037,', '1', '2', null, '博野县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130638', '130600', '0,130000,130600,', '38', '00000013,00000000,00000038,', '1', '2', null, '雄　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130681', '130600', '0,130000,130600,', '81', '00000013,00000000,00000081,', '1', '2', null, '涿州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130682', '130600', '0,130000,130600,', '82', '00000013,00000000,00000082,', '1', '2', null, '定州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130683', '130600', '0,130000,130600,', '83', '00000013,00000000,00000083,', '1', '2', null, '安国市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130684', '130600', '0,130000,130600,', '84', '00000013,00000000,00000084,', '1', '2', null, '高碑店市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130700', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '张家口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130702', '130700', '0,130000,130700,', '2', '00000013,00000000,00000002,', '1', '2', null, '桥东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130703', '130700', '0,130000,130700,', '3', '00000013,00000000,00000003,', '1', '2', null, '桥西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130705', '130700', '0,130000,130700,', '5', '00000013,00000000,00000005,', '1', '2', null, '宣化区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130706', '130700', '0,130000,130700,', '6', '00000013,00000000,00000006,', '1', '2', null, '下花园区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130721', '130700', '0,130000,130700,', '21', '00000013,00000000,00000021,', '1', '2', null, '宣化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130722', '130700', '0,130000,130700,', '22', '00000013,00000000,00000022,', '1', '2', null, '张北县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130723', '130700', '0,130000,130700,', '23', '00000013,00000000,00000023,', '1', '2', null, '康保县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130724', '130700', '0,130000,130700,', '24', '00000013,00000000,00000024,', '1', '2', null, '沽源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130725', '130700', '0,130000,130700,', '25', '00000013,00000000,00000025,', '1', '2', null, '尚义县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130726', '130700', '0,130000,130700,', '26', '00000013,00000000,00000026,', '1', '2', null, '蔚　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130727', '130700', '0,130000,130700,', '27', '00000013,00000000,00000027,', '1', '2', null, '阳原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130728', '130700', '0,130000,130700,', '28', '00000013,00000000,00000028,', '1', '2', null, '怀安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130729', '130700', '0,130000,130700,', '29', '00000013,00000000,00000029,', '1', '2', null, '万全县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130730', '130700', '0,130000,130700,', '30', '00000013,00000000,00000030,', '1', '2', null, '怀来县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130731', '130700', '0,130000,130700,', '31', '00000013,00000000,00000031,', '1', '2', null, '涿鹿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130732', '130700', '0,130000,130700,', '32', '00000013,00000000,00000032,', '1', '2', null, '赤城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130733', '130700', '0,130000,130700,', '33', '00000013,00000000,00000033,', '1', '2', null, '崇礼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130800', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '承德市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130802', '130800', '0,130000,130800,', '2', '00000013,00000000,00000002,', '1', '2', null, '双桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130803', '130800', '0,130000,130800,', '3', '00000013,00000000,00000003,', '1', '2', null, '双滦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130804', '130800', '0,130000,130800,', '4', '00000013,00000000,00000004,', '1', '2', null, '鹰手营子矿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130821', '130800', '0,130000,130800,', '21', '00000013,00000000,00000021,', '1', '2', null, '承德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130822', '130800', '0,130000,130800,', '22', '00000013,00000000,00000022,', '1', '2', null, '兴隆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130823', '130800', '0,130000,130800,', '23', '00000013,00000000,00000023,', '1', '2', null, '平泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130824', '130800', '0,130000,130800,', '24', '00000013,00000000,00000024,', '1', '2', null, '滦平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130825', '130800', '0,130000,130800,', '25', '00000013,00000000,00000025,', '1', '2', null, '隆化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130826', '130800', '0,130000,130800,', '26', '00000013,00000000,00000026,', '1', '2', null, '丰宁满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130827', '130800', '0,130000,130800,', '27', '00000013,00000000,00000027,', '1', '2', null, '宽城满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130828', '130800', '0,130000,130800,', '28', '00000013,00000000,00000028,', '1', '2', null, '围场满族蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130900', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '沧州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130902', '130900', '0,130000,130900,', '2', '00000013,00000000,00000002,', '1', '2', null, '新华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130903', '130900', '0,130000,130900,', '3', '00000013,00000000,00000003,', '1', '2', null, '运河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130921', '130900', '0,130000,130900,', '21', '00000013,00000000,00000021,', '1', '2', null, '沧　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130922', '130900', '0,130000,130900,', '22', '00000013,00000000,00000022,', '1', '2', null, '青　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130923', '130900', '0,130000,130900,', '23', '00000013,00000000,00000023,', '1', '2', null, '东光县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130924', '130900', '0,130000,130900,', '24', '00000013,00000000,00000024,', '1', '2', null, '海兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130925', '130900', '0,130000,130900,', '25', '00000013,00000000,00000025,', '1', '2', null, '盐山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130926', '130900', '0,130000,130900,', '26', '00000013,00000000,00000026,', '1', '2', null, '肃宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130927', '130900', '0,130000,130900,', '27', '00000013,00000000,00000027,', '1', '2', null, '南皮县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130928', '130900', '0,130000,130900,', '28', '00000013,00000000,00000028,', '1', '2', null, '吴桥县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130929', '130900', '0,130000,130900,', '29', '00000013,00000000,00000029,', '1', '2', null, '献　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130930', '130900', '0,130000,130900,', '30', '00000013,00000000,00000030,', '1', '2', null, '孟村回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130981', '130900', '0,130000,130900,', '81', '00000013,00000000,00000081,', '1', '2', null, '泊头市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130982', '130900', '0,130000,130900,', '82', '00000013,00000000,00000082,', '1', '2', null, '任丘市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130983', '130900', '0,130000,130900,', '83', '00000013,00000000,00000083,', '1', '2', null, '黄骅市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('130984', '130900', '0,130000,130900,', '84', '00000013,00000000,00000084,', '1', '2', null, '河间市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131000', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '廊坊市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131002', '131000', '0,130000,131000,', '2', '00000013,00000000,00000002,', '1', '2', null, '安次区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131003', '131000', '0,130000,131000,', '3', '00000013,00000000,00000003,', '1', '2', null, '广阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131022', '131000', '0,130000,131000,', '22', '00000013,00000000,00000022,', '1', '2', null, '固安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131023', '131000', '0,130000,131000,', '23', '00000013,00000000,00000023,', '1', '2', null, '永清县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131024', '131000', '0,130000,131000,', '24', '00000013,00000000,00000024,', '1', '2', null, '香河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131025', '131000', '0,130000,131000,', '25', '00000013,00000000,00000025,', '1', '2', null, '大城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131026', '131000', '0,130000,131000,', '26', '00000013,00000000,00000026,', '1', '2', null, '文安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131028', '131000', '0,130000,131000,', '28', '00000013,00000000,00000028,', '1', '2', null, '大厂回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131081', '131000', '0,130000,131000,', '81', '00000013,00000000,00000081,', '1', '2', null, '霸州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131082', '131000', '0,130000,131000,', '82', '00000013,00000000,00000082,', '1', '2', null, '三河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131100', '130000', '0,130000,', '0', '00000013,00000000,', '0', '1', null, '衡水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131102', '131100', '0,130000,131100,', '2', '00000013,00000000,00000002,', '1', '2', null, '桃城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131121', '131100', '0,130000,131100,', '21', '00000013,00000000,00000021,', '1', '2', null, '枣强县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131122', '131100', '0,130000,131100,', '22', '00000013,00000000,00000022,', '1', '2', null, '武邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131123', '131100', '0,130000,131100,', '23', '00000013,00000000,00000023,', '1', '2', null, '武强县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131124', '131100', '0,130000,131100,', '24', '00000013,00000000,00000024,', '1', '2', null, '饶阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131125', '131100', '0,130000,131100,', '25', '00000013,00000000,00000025,', '1', '2', null, '安平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131126', '131100', '0,130000,131100,', '26', '00000013,00000000,00000026,', '1', '2', null, '故城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131127', '131100', '0,130000,131100,', '27', '00000013,00000000,00000027,', '1', '2', null, '景　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131128', '131100', '0,130000,131100,', '28', '00000013,00000000,00000028,', '1', '2', null, '阜城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131181', '131100', '0,130000,131100,', '81', '00000013,00000000,00000081,', '1', '2', null, '冀州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('131182', '131100', '0,130000,131100,', '82', '00000013,00000000,00000082,', '1', '2', null, '深州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140000', '0', '0,', '14', '00000014,', '0', '0', null, '山西省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140100', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '太原市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140105', '140100', '0,140000,140100,', '5', '00000014,00000000,00000005,', '1', '2', null, '小店区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140106', '140100', '0,140000,140100,', '6', '00000014,00000000,00000006,', '1', '2', null, '迎泽区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140107', '140100', '0,140000,140100,', '7', '00000014,00000000,00000007,', '1', '2', null, '杏花岭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140108', '140100', '0,140000,140100,', '8', '00000014,00000000,00000008,', '1', '2', null, '尖草坪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140109', '140100', '0,140000,140100,', '9', '00000014,00000000,00000009,', '1', '2', null, '万柏林区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140110', '140100', '0,140000,140100,', '10', '00000014,00000000,00000010,', '1', '2', null, '晋源区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140121', '140100', '0,140000,140100,', '21', '00000014,00000000,00000021,', '1', '2', null, '清徐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140122', '140100', '0,140000,140100,', '22', '00000014,00000000,00000022,', '1', '2', null, '阳曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140123', '140100', '0,140000,140100,', '23', '00000014,00000000,00000023,', '1', '2', null, '娄烦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140181', '140100', '0,140000,140100,', '81', '00000014,00000000,00000081,', '1', '2', null, '古交市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140200', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '大同市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140202', '140200', '0,140000,140200,', '2', '00000014,00000000,00000002,', '1', '2', null, '城　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140203', '140200', '0,140000,140200,', '3', '00000014,00000000,00000003,', '1', '2', null, '矿　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140211', '140200', '0,140000,140200,', '11', '00000014,00000000,00000011,', '1', '2', null, '南郊区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140212', '140200', '0,140000,140200,', '12', '00000014,00000000,00000012,', '1', '2', null, '新荣区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140221', '140200', '0,140000,140200,', '21', '00000014,00000000,00000021,', '1', '2', null, '阳高县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140222', '140200', '0,140000,140200,', '22', '00000014,00000000,00000022,', '1', '2', null, '天镇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140223', '140200', '0,140000,140200,', '23', '00000014,00000000,00000023,', '1', '2', null, '广灵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140224', '140200', '0,140000,140200,', '24', '00000014,00000000,00000024,', '1', '2', null, '灵丘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140225', '140200', '0,140000,140200,', '25', '00000014,00000000,00000025,', '1', '2', null, '浑源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140226', '140200', '0,140000,140200,', '26', '00000014,00000000,00000026,', '1', '2', null, '左云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140227', '140200', '0,140000,140200,', '27', '00000014,00000000,00000027,', '1', '2', null, '大同县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140300', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '阳泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140302', '140300', '0,140000,140300,', '2', '00000014,00000000,00000002,', '1', '2', null, '城　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140303', '140300', '0,140000,140300,', '3', '00000014,00000000,00000003,', '1', '2', null, '矿　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140311', '140300', '0,140000,140300,', '11', '00000014,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140321', '140300', '0,140000,140300,', '21', '00000014,00000000,00000021,', '1', '2', null, '平定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140322', '140300', '0,140000,140300,', '22', '00000014,00000000,00000022,', '1', '2', null, '盂　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140400', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '长治市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140402', '140400', '0,140000,140400,', '2', '00000014,00000000,00000002,', '1', '2', null, '城　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140411', '140400', '0,140000,140400,', '11', '00000014,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140421', '140400', '0,140000,140400,', '21', '00000014,00000000,00000021,', '1', '2', null, '长治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140423', '140400', '0,140000,140400,', '23', '00000014,00000000,00000023,', '1', '2', null, '襄垣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140424', '140400', '0,140000,140400,', '24', '00000014,00000000,00000024,', '1', '2', null, '屯留县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140425', '140400', '0,140000,140400,', '25', '00000014,00000000,00000025,', '1', '2', null, '平顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140426', '140400', '0,140000,140400,', '26', '00000014,00000000,00000026,', '1', '2', null, '黎城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140427', '140400', '0,140000,140400,', '27', '00000014,00000000,00000027,', '1', '2', null, '壶关县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140428', '140400', '0,140000,140400,', '28', '00000014,00000000,00000028,', '1', '2', null, '长子县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140429', '140400', '0,140000,140400,', '29', '00000014,00000000,00000029,', '1', '2', null, '武乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140430', '140400', '0,140000,140400,', '30', '00000014,00000000,00000030,', '1', '2', null, '沁　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140431', '140400', '0,140000,140400,', '31', '00000014,00000000,00000031,', '1', '2', null, '沁源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140481', '140400', '0,140000,140400,', '81', '00000014,00000000,00000081,', '1', '2', null, '潞城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140500', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '晋城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140502', '140500', '0,140000,140500,', '2', '00000014,00000000,00000002,', '1', '2', null, '城　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140521', '140500', '0,140000,140500,', '21', '00000014,00000000,00000021,', '1', '2', null, '沁水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140522', '140500', '0,140000,140500,', '22', '00000014,00000000,00000022,', '1', '2', null, '阳城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140524', '140500', '0,140000,140500,', '24', '00000014,00000000,00000024,', '1', '2', null, '陵川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140525', '140500', '0,140000,140500,', '25', '00000014,00000000,00000025,', '1', '2', null, '泽州县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140581', '140500', '0,140000,140500,', '81', '00000014,00000000,00000081,', '1', '2', null, '高平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140600', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '朔州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140602', '140600', '0,140000,140600,', '2', '00000014,00000000,00000002,', '1', '2', null, '朔城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140603', '140600', '0,140000,140600,', '3', '00000014,00000000,00000003,', '1', '2', null, '平鲁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140621', '140600', '0,140000,140600,', '21', '00000014,00000000,00000021,', '1', '2', null, '山阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140622', '140600', '0,140000,140600,', '22', '00000014,00000000,00000022,', '1', '2', null, '应　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140623', '140600', '0,140000,140600,', '23', '00000014,00000000,00000023,', '1', '2', null, '右玉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140624', '140600', '0,140000,140600,', '24', '00000014,00000000,00000024,', '1', '2', null, '怀仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140700', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '晋中市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140702', '140700', '0,140000,140700,', '2', '00000014,00000000,00000002,', '1', '2', null, '榆次区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140721', '140700', '0,140000,140700,', '21', '00000014,00000000,00000021,', '1', '2', null, '榆社县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140722', '140700', '0,140000,140700,', '22', '00000014,00000000,00000022,', '1', '2', null, '左权县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140723', '140700', '0,140000,140700,', '23', '00000014,00000000,00000023,', '1', '2', null, '和顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140724', '140700', '0,140000,140700,', '24', '00000014,00000000,00000024,', '1', '2', null, '昔阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140725', '140700', '0,140000,140700,', '25', '00000014,00000000,00000025,', '1', '2', null, '寿阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140726', '140700', '0,140000,140700,', '26', '00000014,00000000,00000026,', '1', '2', null, '太谷县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140727', '140700', '0,140000,140700,', '27', '00000014,00000000,00000027,', '1', '2', null, '祁　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140728', '140700', '0,140000,140700,', '28', '00000014,00000000,00000028,', '1', '2', null, '平遥县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140729', '140700', '0,140000,140700,', '29', '00000014,00000000,00000029,', '1', '2', null, '灵石县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140781', '140700', '0,140000,140700,', '81', '00000014,00000000,00000081,', '1', '2', null, '介休市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140800', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '运城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140802', '140800', '0,140000,140800,', '2', '00000014,00000000,00000002,', '1', '2', null, '盐湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140821', '140800', '0,140000,140800,', '21', '00000014,00000000,00000021,', '1', '2', null, '临猗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140822', '140800', '0,140000,140800,', '22', '00000014,00000000,00000022,', '1', '2', null, '万荣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140823', '140800', '0,140000,140800,', '23', '00000014,00000000,00000023,', '1', '2', null, '闻喜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140824', '140800', '0,140000,140800,', '24', '00000014,00000000,00000024,', '1', '2', null, '稷山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140825', '140800', '0,140000,140800,', '25', '00000014,00000000,00000025,', '1', '2', null, '新绛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140826', '140800', '0,140000,140800,', '26', '00000014,00000000,00000026,', '1', '2', null, '绛　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140827', '140800', '0,140000,140800,', '27', '00000014,00000000,00000027,', '1', '2', null, '垣曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140828', '140800', '0,140000,140800,', '28', '00000014,00000000,00000028,', '1', '2', null, '夏　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140829', '140800', '0,140000,140800,', '29', '00000014,00000000,00000029,', '1', '2', null, '平陆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140830', '140800', '0,140000,140800,', '30', '00000014,00000000,00000030,', '1', '2', null, '芮城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140881', '140800', '0,140000,140800,', '81', '00000014,00000000,00000081,', '1', '2', null, '永济市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140882', '140800', '0,140000,140800,', '82', '00000014,00000000,00000082,', '1', '2', null, '河津市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140900', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '忻州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140902', '140900', '0,140000,140900,', '2', '00000014,00000000,00000002,', '1', '2', null, '忻府区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140921', '140900', '0,140000,140900,', '21', '00000014,00000000,00000021,', '1', '2', null, '定襄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140922', '140900', '0,140000,140900,', '22', '00000014,00000000,00000022,', '1', '2', null, '五台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140923', '140900', '0,140000,140900,', '23', '00000014,00000000,00000023,', '1', '2', null, '代　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140924', '140900', '0,140000,140900,', '24', '00000014,00000000,00000024,', '1', '2', null, '繁峙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140925', '140900', '0,140000,140900,', '25', '00000014,00000000,00000025,', '1', '2', null, '宁武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140926', '140900', '0,140000,140900,', '26', '00000014,00000000,00000026,', '1', '2', null, '静乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140927', '140900', '0,140000,140900,', '27', '00000014,00000000,00000027,', '1', '2', null, '神池县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140928', '140900', '0,140000,140900,', '28', '00000014,00000000,00000028,', '1', '2', null, '五寨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140929', '140900', '0,140000,140900,', '29', '00000014,00000000,00000029,', '1', '2', null, '岢岚县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140930', '140900', '0,140000,140900,', '30', '00000014,00000000,00000030,', '1', '2', null, '河曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140931', '140900', '0,140000,140900,', '31', '00000014,00000000,00000031,', '1', '2', null, '保德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140932', '140900', '0,140000,140900,', '32', '00000014,00000000,00000032,', '1', '2', null, '偏关县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('140981', '140900', '0,140000,140900,', '81', '00000014,00000000,00000081,', '1', '2', null, '原平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141000', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '临汾市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141002', '141000', '0,140000,141000,', '2', '00000014,00000000,00000002,', '1', '2', null, '尧都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141021', '141000', '0,140000,141000,', '21', '00000014,00000000,00000021,', '1', '2', null, '曲沃县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141022', '141000', '0,140000,141000,', '22', '00000014,00000000,00000022,', '1', '2', null, '翼城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141023', '141000', '0,140000,141000,', '23', '00000014,00000000,00000023,', '1', '2', null, '襄汾县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141024', '141000', '0,140000,141000,', '24', '00000014,00000000,00000024,', '1', '2', null, '洪洞县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141025', '141000', '0,140000,141000,', '25', '00000014,00000000,00000025,', '1', '2', null, '古　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141026', '141000', '0,140000,141000,', '26', '00000014,00000000,00000026,', '1', '2', null, '安泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141027', '141000', '0,140000,141000,', '27', '00000014,00000000,00000027,', '1', '2', null, '浮山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141028', '141000', '0,140000,141000,', '28', '00000014,00000000,00000028,', '1', '2', null, '吉　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141029', '141000', '0,140000,141000,', '29', '00000014,00000000,00000029,', '1', '2', null, '乡宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141030', '141000', '0,140000,141000,', '30', '00000014,00000000,00000030,', '1', '2', null, '大宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141031', '141000', '0,140000,141000,', '31', '00000014,00000000,00000031,', '1', '2', null, '隰　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141032', '141000', '0,140000,141000,', '32', '00000014,00000000,00000032,', '1', '2', null, '永和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141033', '141000', '0,140000,141000,', '33', '00000014,00000000,00000033,', '1', '2', null, '蒲　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141034', '141000', '0,140000,141000,', '34', '00000014,00000000,00000034,', '1', '2', null, '汾西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141081', '141000', '0,140000,141000,', '81', '00000014,00000000,00000081,', '1', '2', null, '侯马市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141082', '141000', '0,140000,141000,', '82', '00000014,00000000,00000082,', '1', '2', null, '霍州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141100', '140000', '0,140000,', '0', '00000014,00000000,', '0', '1', null, '吕梁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141102', '141100', '0,140000,141100,', '2', '00000014,00000000,00000002,', '1', '2', null, '离石区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141121', '141100', '0,140000,141100,', '21', '00000014,00000000,00000021,', '1', '2', null, '文水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141122', '141100', '0,140000,141100,', '22', '00000014,00000000,00000022,', '1', '2', null, '交城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141123', '141100', '0,140000,141100,', '23', '00000014,00000000,00000023,', '1', '2', null, '兴　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141124', '141100', '0,140000,141100,', '24', '00000014,00000000,00000024,', '1', '2', null, '临　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141125', '141100', '0,140000,141100,', '25', '00000014,00000000,00000025,', '1', '2', null, '柳林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141126', '141100', '0,140000,141100,', '26', '00000014,00000000,00000026,', '1', '2', null, '石楼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141127', '141100', '0,140000,141100,', '27', '00000014,00000000,00000027,', '1', '2', null, '岚　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141128', '141100', '0,140000,141100,', '28', '00000014,00000000,00000028,', '1', '2', null, '方山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141129', '141100', '0,140000,141100,', '29', '00000014,00000000,00000029,', '1', '2', null, '中阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141130', '141100', '0,140000,141100,', '30', '00000014,00000000,00000030,', '1', '2', null, '交口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141181', '141100', '0,140000,141100,', '81', '00000014,00000000,00000081,', '1', '2', null, '孝义市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('141182', '141100', '0,140000,141100,', '82', '00000014,00000000,00000082,', '1', '2', null, '汾阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150000', '0', '0,', '15', '00000015,', '0', '0', null, '内蒙古自治区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150100', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '呼和浩特市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150102', '150100', '0,150000,150100,', '2', '00000015,00000000,00000002,', '1', '2', null, '新城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150103', '150100', '0,150000,150100,', '3', '00000015,00000000,00000003,', '1', '2', null, '回民区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150104', '150100', '0,150000,150100,', '4', '00000015,00000000,00000004,', '1', '2', null, '玉泉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150105', '150100', '0,150000,150100,', '5', '00000015,00000000,00000005,', '1', '2', null, '赛罕区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150121', '150100', '0,150000,150100,', '21', '00000015,00000000,00000021,', '1', '2', null, '土默特左旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150122', '150100', '0,150000,150100,', '22', '00000015,00000000,00000022,', '1', '2', null, '托克托县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150123', '150100', '0,150000,150100,', '23', '00000015,00000000,00000023,', '1', '2', null, '和林格尔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150124', '150100', '0,150000,150100,', '24', '00000015,00000000,00000024,', '1', '2', null, '清水河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150125', '150100', '0,150000,150100,', '25', '00000015,00000000,00000025,', '1', '2', null, '武川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150200', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '包头市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150202', '150200', '0,150000,150200,', '2', '00000015,00000000,00000002,', '1', '2', null, '东河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150203', '150200', '0,150000,150200,', '3', '00000015,00000000,00000003,', '1', '2', null, '昆都仑区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150204', '150200', '0,150000,150200,', '4', '00000015,00000000,00000004,', '1', '2', null, '青山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150205', '150200', '0,150000,150200,', '5', '00000015,00000000,00000005,', '1', '2', null, '石拐区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150206', '150200', '0,150000,150200,', '6', '00000015,00000000,00000006,', '1', '2', null, '白云矿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150207', '150200', '0,150000,150200,', '7', '00000015,00000000,00000007,', '1', '2', null, '九原区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150221', '150200', '0,150000,150200,', '21', '00000015,00000000,00000021,', '1', '2', null, '土默特右旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150222', '150200', '0,150000,150200,', '22', '00000015,00000000,00000022,', '1', '2', null, '固阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150223', '150200', '0,150000,150200,', '23', '00000015,00000000,00000023,', '1', '2', null, '达尔罕茂明安联合旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150300', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '乌海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150302', '150300', '0,150000,150300,', '2', '00000015,00000000,00000002,', '1', '2', null, '海勃湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150303', '150300', '0,150000,150300,', '3', '00000015,00000000,00000003,', '1', '2', null, '海南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150304', '150300', '0,150000,150300,', '4', '00000015,00000000,00000004,', '1', '2', null, '乌达区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150400', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '赤峰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150402', '150400', '0,150000,150400,', '2', '00000015,00000000,00000002,', '1', '2', null, '红山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150403', '150400', '0,150000,150400,', '3', '00000015,00000000,00000003,', '1', '2', null, '元宝山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150404', '150400', '0,150000,150400,', '4', '00000015,00000000,00000004,', '1', '2', null, '松山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150421', '150400', '0,150000,150400,', '21', '00000015,00000000,00000021,', '1', '2', null, '阿鲁科尔沁旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150422', '150400', '0,150000,150400,', '22', '00000015,00000000,00000022,', '1', '2', null, '巴林左旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150423', '150400', '0,150000,150400,', '23', '00000015,00000000,00000023,', '1', '2', null, '巴林右旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150424', '150400', '0,150000,150400,', '24', '00000015,00000000,00000024,', '1', '2', null, '林西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150425', '150400', '0,150000,150400,', '25', '00000015,00000000,00000025,', '1', '2', null, '克什克腾旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150426', '150400', '0,150000,150400,', '26', '00000015,00000000,00000026,', '1', '2', null, '翁牛特旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150428', '150400', '0,150000,150400,', '28', '00000015,00000000,00000028,', '1', '2', null, '喀喇沁旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150429', '150400', '0,150000,150400,', '29', '00000015,00000000,00000029,', '1', '2', null, '宁城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150430', '150400', '0,150000,150400,', '30', '00000015,00000000,00000030,', '1', '2', null, '敖汉旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150500', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '通辽市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150502', '150500', '0,150000,150500,', '2', '00000015,00000000,00000002,', '1', '2', null, '科尔沁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150521', '150500', '0,150000,150500,', '21', '00000015,00000000,00000021,', '1', '2', null, '科尔沁左翼中旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150522', '150500', '0,150000,150500,', '22', '00000015,00000000,00000022,', '1', '2', null, '科尔沁左翼后旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150523', '150500', '0,150000,150500,', '23', '00000015,00000000,00000023,', '1', '2', null, '开鲁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150524', '150500', '0,150000,150500,', '24', '00000015,00000000,00000024,', '1', '2', null, '库伦旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150525', '150500', '0,150000,150500,', '25', '00000015,00000000,00000025,', '1', '2', null, '奈曼旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150526', '150500', '0,150000,150500,', '26', '00000015,00000000,00000026,', '1', '2', null, '扎鲁特旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150581', '150500', '0,150000,150500,', '81', '00000015,00000000,00000081,', '1', '2', null, '霍林郭勒市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150600', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '鄂尔多斯市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150602', '150600', '0,150000,150600,', '2', '00000015,00000000,00000002,', '1', '2', null, '东胜区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150621', '150600', '0,150000,150600,', '21', '00000015,00000000,00000021,', '1', '2', null, '达拉特旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150622', '150600', '0,150000,150600,', '22', '00000015,00000000,00000022,', '1', '2', null, '准格尔旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150623', '150600', '0,150000,150600,', '23', '00000015,00000000,00000023,', '1', '2', null, '鄂托克前旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150624', '150600', '0,150000,150600,', '24', '00000015,00000000,00000024,', '1', '2', null, '鄂托克旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150625', '150600', '0,150000,150600,', '25', '00000015,00000000,00000025,', '1', '2', null, '杭锦旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150626', '150600', '0,150000,150600,', '26', '00000015,00000000,00000026,', '1', '2', null, '乌审旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150627', '150600', '0,150000,150600,', '27', '00000015,00000000,00000027,', '1', '2', null, '伊金霍洛旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150700', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '呼伦贝尔市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150702', '150700', '0,150000,150700,', '2', '00000015,00000000,00000002,', '1', '2', null, '海拉尔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150721', '150700', '0,150000,150700,', '21', '00000015,00000000,00000021,', '1', '2', null, '阿荣旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150722', '150700', '0,150000,150700,', '22', '00000015,00000000,00000022,', '1', '2', null, '莫力达瓦达斡尔族自治旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150723', '150700', '0,150000,150700,', '23', '00000015,00000000,00000023,', '1', '2', null, '鄂伦春自治旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150724', '150700', '0,150000,150700,', '24', '00000015,00000000,00000024,', '1', '2', null, '鄂温克族自治旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150725', '150700', '0,150000,150700,', '25', '00000015,00000000,00000025,', '1', '2', null, '陈巴尔虎旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150726', '150700', '0,150000,150700,', '26', '00000015,00000000,00000026,', '1', '2', null, '新巴尔虎左旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150727', '150700', '0,150000,150700,', '27', '00000015,00000000,00000027,', '1', '2', null, '新巴尔虎右旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150781', '150700', '0,150000,150700,', '81', '00000015,00000000,00000081,', '1', '2', null, '满洲里市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150782', '150700', '0,150000,150700,', '82', '00000015,00000000,00000082,', '1', '2', null, '牙克石市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150783', '150700', '0,150000,150700,', '83', '00000015,00000000,00000083,', '1', '2', null, '扎兰屯市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150784', '150700', '0,150000,150700,', '84', '00000015,00000000,00000084,', '1', '2', null, '额尔古纳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150785', '150700', '0,150000,150700,', '85', '00000015,00000000,00000085,', '1', '2', null, '根河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150800', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '巴彦淖尔市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150802', '150800', '0,150000,150800,', '2', '00000015,00000000,00000002,', '1', '2', null, '临河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150821', '150800', '0,150000,150800,', '21', '00000015,00000000,00000021,', '1', '2', null, '五原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150822', '150800', '0,150000,150800,', '22', '00000015,00000000,00000022,', '1', '2', null, '磴口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150823', '150800', '0,150000,150800,', '23', '00000015,00000000,00000023,', '1', '2', null, '乌拉特前旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150824', '150800', '0,150000,150800,', '24', '00000015,00000000,00000024,', '1', '2', null, '乌拉特中旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150825', '150800', '0,150000,150800,', '25', '00000015,00000000,00000025,', '1', '2', null, '乌拉特后旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150826', '150800', '0,150000,150800,', '26', '00000015,00000000,00000026,', '1', '2', null, '杭锦后旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150900', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '乌兰察布市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150902', '150900', '0,150000,150900,', '2', '00000015,00000000,00000002,', '1', '2', null, '集宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150921', '150900', '0,150000,150900,', '21', '00000015,00000000,00000021,', '1', '2', null, '卓资县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150922', '150900', '0,150000,150900,', '22', '00000015,00000000,00000022,', '1', '2', null, '化德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150923', '150900', '0,150000,150900,', '23', '00000015,00000000,00000023,', '1', '2', null, '商都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150924', '150900', '0,150000,150900,', '24', '00000015,00000000,00000024,', '1', '2', null, '兴和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150925', '150900', '0,150000,150900,', '25', '00000015,00000000,00000025,', '1', '2', null, '凉城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150926', '150900', '0,150000,150900,', '26', '00000015,00000000,00000026,', '1', '2', null, '察哈尔右翼前旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150927', '150900', '0,150000,150900,', '27', '00000015,00000000,00000027,', '1', '2', null, '察哈尔右翼中旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150928', '150900', '0,150000,150900,', '28', '00000015,00000000,00000028,', '1', '2', null, '察哈尔右翼后旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150929', '150900', '0,150000,150900,', '29', '00000015,00000000,00000029,', '1', '2', null, '四子王旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('150981', '150900', '0,150000,150900,', '81', '00000015,00000000,00000081,', '1', '2', null, '丰镇市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152200', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '兴安盟', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152201', '152200', '0,150000,152200,', '1', '00000015,00000000,00000001,', '1', '2', null, '乌兰浩特市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152202', '152200', '0,150000,152200,', '2', '00000015,00000000,00000002,', '1', '2', null, '阿尔山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152221', '152200', '0,150000,152200,', '21', '00000015,00000000,00000021,', '1', '2', null, '科尔沁右翼前旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152222', '152200', '0,150000,152200,', '22', '00000015,00000000,00000022,', '1', '2', null, '科尔沁右翼中旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152223', '152200', '0,150000,152200,', '23', '00000015,00000000,00000023,', '1', '2', null, '扎赉特旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152224', '152200', '0,150000,152200,', '24', '00000015,00000000,00000024,', '1', '2', null, '突泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152500', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '锡林郭勒盟', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152501', '152500', '0,150000,152500,', '1', '00000015,00000000,00000001,', '1', '2', null, '二连浩特市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152502', '152500', '0,150000,152500,', '2', '00000015,00000000,00000002,', '1', '2', null, '锡林浩特市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152522', '152500', '0,150000,152500,', '22', '00000015,00000000,00000022,', '1', '2', null, '阿巴嘎旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152523', '152500', '0,150000,152500,', '23', '00000015,00000000,00000023,', '1', '2', null, '苏尼特左旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152524', '152500', '0,150000,152500,', '24', '00000015,00000000,00000024,', '1', '2', null, '苏尼特右旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152525', '152500', '0,150000,152500,', '25', '00000015,00000000,00000025,', '1', '2', null, '东乌珠穆沁旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152526', '152500', '0,150000,152500,', '26', '00000015,00000000,00000026,', '1', '2', null, '西乌珠穆沁旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152527', '152500', '0,150000,152500,', '27', '00000015,00000000,00000027,', '1', '2', null, '太仆寺旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152528', '152500', '0,150000,152500,', '28', '00000015,00000000,00000028,', '1', '2', null, '镶黄旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152529', '152500', '0,150000,152500,', '29', '00000015,00000000,00000029,', '1', '2', null, '正镶白旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152530', '152500', '0,150000,152500,', '30', '00000015,00000000,00000030,', '1', '2', null, '正蓝旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152531', '152500', '0,150000,152500,', '31', '00000015,00000000,00000031,', '1', '2', null, '多伦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152900', '150000', '0,150000,', '0', '00000015,00000000,', '0', '1', null, '阿拉善盟', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152921', '152900', '0,150000,152900,', '21', '00000015,00000000,00000021,', '1', '2', null, '阿拉善左旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152922', '152900', '0,150000,152900,', '22', '00000015,00000000,00000022,', '1', '2', null, '阿拉善右旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('152923', '152900', '0,150000,152900,', '23', '00000015,00000000,00000023,', '1', '2', null, '额济纳旗', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210000', '0', '0,', '21', '00000021,', '0', '0', null, '辽宁省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210100', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '沈阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210102', '210100', '0,210000,210100,', '2', '00000021,00000000,00000002,', '1', '2', null, '和平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210103', '210100', '0,210000,210100,', '3', '00000021,00000000,00000003,', '1', '2', null, '沈河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210104', '210100', '0,210000,210100,', '4', '00000021,00000000,00000004,', '1', '2', null, '大东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210105', '210100', '0,210000,210100,', '5', '00000021,00000000,00000005,', '1', '2', null, '皇姑区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210106', '210100', '0,210000,210100,', '6', '00000021,00000000,00000006,', '1', '2', null, '铁西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210111', '210100', '0,210000,210100,', '11', '00000021,00000000,00000011,', '1', '2', null, '苏家屯区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210112', '210100', '0,210000,210100,', '12', '00000021,00000000,00000012,', '1', '2', null, '东陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210113', '210100', '0,210000,210100,', '13', '00000021,00000000,00000013,', '1', '2', null, '新城子区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210114', '210100', '0,210000,210100,', '14', '00000021,00000000,00000014,', '1', '2', null, '于洪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210122', '210100', '0,210000,210100,', '22', '00000021,00000000,00000022,', '1', '2', null, '辽中县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210123', '210100', '0,210000,210100,', '23', '00000021,00000000,00000023,', '1', '2', null, '康平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210124', '210100', '0,210000,210100,', '24', '00000021,00000000,00000024,', '1', '2', null, '法库县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210181', '210100', '0,210000,210100,', '81', '00000021,00000000,00000081,', '1', '2', null, '新民市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210200', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '大连市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210202', '210200', '0,210000,210200,', '2', '00000021,00000000,00000002,', '1', '2', null, '中山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210203', '210200', '0,210000,210200,', '3', '00000021,00000000,00000003,', '1', '2', null, '西岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210204', '210200', '0,210000,210200,', '4', '00000021,00000000,00000004,', '1', '2', null, '沙河口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210211', '210200', '0,210000,210200,', '11', '00000021,00000000,00000011,', '1', '2', null, '甘井子区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210212', '210200', '0,210000,210200,', '12', '00000021,00000000,00000012,', '1', '2', null, '旅顺口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210213', '210200', '0,210000,210200,', '13', '00000021,00000000,00000013,', '1', '2', null, '金州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210224', '210200', '0,210000,210200,', '24', '00000021,00000000,00000024,', '1', '2', null, '长海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210281', '210200', '0,210000,210200,', '81', '00000021,00000000,00000081,', '1', '2', null, '瓦房店市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210282', '210200', '0,210000,210200,', '82', '00000021,00000000,00000082,', '1', '2', null, '普兰店市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210283', '210200', '0,210000,210200,', '83', '00000021,00000000,00000083,', '1', '2', null, '庄河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210300', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '鞍山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210302', '210300', '0,210000,210300,', '2', '00000021,00000000,00000002,', '1', '2', null, '铁东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210303', '210300', '0,210000,210300,', '3', '00000021,00000000,00000003,', '1', '2', null, '铁西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210304', '210300', '0,210000,210300,', '4', '00000021,00000000,00000004,', '1', '2', null, '立山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210311', '210300', '0,210000,210300,', '11', '00000021,00000000,00000011,', '1', '2', null, '千山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210321', '210300', '0,210000,210300,', '21', '00000021,00000000,00000021,', '1', '2', null, '台安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210323', '210300', '0,210000,210300,', '23', '00000021,00000000,00000023,', '1', '2', null, '岫岩满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210381', '210300', '0,210000,210300,', '81', '00000021,00000000,00000081,', '1', '2', null, '海城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210400', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '抚顺市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210402', '210400', '0,210000,210400,', '2', '00000021,00000000,00000002,', '1', '2', null, '新抚区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210403', '210400', '0,210000,210400,', '3', '00000021,00000000,00000003,', '1', '2', null, '东洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210404', '210400', '0,210000,210400,', '4', '00000021,00000000,00000004,', '1', '2', null, '望花区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210411', '210400', '0,210000,210400,', '11', '00000021,00000000,00000011,', '1', '2', null, '顺城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210421', '210400', '0,210000,210400,', '21', '00000021,00000000,00000021,', '1', '2', null, '抚顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210422', '210400', '0,210000,210400,', '22', '00000021,00000000,00000022,', '1', '2', null, '新宾满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210423', '210400', '0,210000,210400,', '23', '00000021,00000000,00000023,', '1', '2', null, '清原满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210500', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '本溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210502', '210500', '0,210000,210500,', '2', '00000021,00000000,00000002,', '1', '2', null, '平山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210503', '210500', '0,210000,210500,', '3', '00000021,00000000,00000003,', '1', '2', null, '溪湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210504', '210500', '0,210000,210500,', '4', '00000021,00000000,00000004,', '1', '2', null, '明山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210505', '210500', '0,210000,210500,', '5', '00000021,00000000,00000005,', '1', '2', null, '南芬区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210521', '210500', '0,210000,210500,', '21', '00000021,00000000,00000021,', '1', '2', null, '本溪满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210522', '210500', '0,210000,210500,', '22', '00000021,00000000,00000022,', '1', '2', null, '桓仁满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210600', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '丹东市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210602', '210600', '0,210000,210600,', '2', '00000021,00000000,00000002,', '1', '2', null, '元宝区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210603', '210600', '0,210000,210600,', '3', '00000021,00000000,00000003,', '1', '2', null, '振兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210604', '210600', '0,210000,210600,', '4', '00000021,00000000,00000004,', '1', '2', null, '振安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210624', '210600', '0,210000,210600,', '24', '00000021,00000000,00000024,', '1', '2', null, '宽甸满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210681', '210600', '0,210000,210600,', '81', '00000021,00000000,00000081,', '1', '2', null, '东港市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210682', '210600', '0,210000,210600,', '82', '00000021,00000000,00000082,', '1', '2', null, '凤城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210700', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '锦州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210702', '210700', '0,210000,210700,', '2', '00000021,00000000,00000002,', '1', '2', null, '古塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210703', '210700', '0,210000,210700,', '3', '00000021,00000000,00000003,', '1', '2', null, '凌河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210711', '210700', '0,210000,210700,', '11', '00000021,00000000,00000011,', '1', '2', null, '太和区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210726', '210700', '0,210000,210700,', '26', '00000021,00000000,00000026,', '1', '2', null, '黑山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210727', '210700', '0,210000,210700,', '27', '00000021,00000000,00000027,', '1', '2', null, '义　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210781', '210700', '0,210000,210700,', '81', '00000021,00000000,00000081,', '1', '2', null, '凌海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210782', '210700', '0,210000,210700,', '82', '00000021,00000000,00000082,', '1', '2', null, '北宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210800', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '营口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210802', '210800', '0,210000,210800,', '2', '00000021,00000000,00000002,', '1', '2', null, '站前区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210803', '210800', '0,210000,210800,', '3', '00000021,00000000,00000003,', '1', '2', null, '西市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210804', '210800', '0,210000,210800,', '4', '00000021,00000000,00000004,', '1', '2', null, '鲅鱼圈区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210811', '210800', '0,210000,210800,', '11', '00000021,00000000,00000011,', '1', '2', null, '老边区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210881', '210800', '0,210000,210800,', '81', '00000021,00000000,00000081,', '1', '2', null, '盖州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210882', '210800', '0,210000,210800,', '82', '00000021,00000000,00000082,', '1', '2', null, '大石桥市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210900', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '阜新市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210902', '210900', '0,210000,210900,', '2', '00000021,00000000,00000002,', '1', '2', null, '海州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210903', '210900', '0,210000,210900,', '3', '00000021,00000000,00000003,', '1', '2', null, '新邱区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210904', '210900', '0,210000,210900,', '4', '00000021,00000000,00000004,', '1', '2', null, '太平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210905', '210900', '0,210000,210900,', '5', '00000021,00000000,00000005,', '1', '2', null, '清河门区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210911', '210900', '0,210000,210900,', '11', '00000021,00000000,00000011,', '1', '2', null, '细河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210921', '210900', '0,210000,210900,', '21', '00000021,00000000,00000021,', '1', '2', null, '阜新蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('210922', '210900', '0,210000,210900,', '22', '00000021,00000000,00000022,', '1', '2', null, '彰武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211000', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '辽阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211002', '211000', '0,210000,211000,', '2', '00000021,00000000,00000002,', '1', '2', null, '白塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211003', '211000', '0,210000,211000,', '3', '00000021,00000000,00000003,', '1', '2', null, '文圣区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211004', '211000', '0,210000,211000,', '4', '00000021,00000000,00000004,', '1', '2', null, '宏伟区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211005', '211000', '0,210000,211000,', '5', '00000021,00000000,00000005,', '1', '2', null, '弓长岭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211011', '211000', '0,210000,211000,', '11', '00000021,00000000,00000011,', '1', '2', null, '太子河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211021', '211000', '0,210000,211000,', '21', '00000021,00000000,00000021,', '1', '2', null, '辽阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211081', '211000', '0,210000,211000,', '81', '00000021,00000000,00000081,', '1', '2', null, '灯塔市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211100', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '盘锦市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211102', '211100', '0,210000,211100,', '2', '00000021,00000000,00000002,', '1', '2', null, '双台子区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211103', '211100', '0,210000,211100,', '3', '00000021,00000000,00000003,', '1', '2', null, '兴隆台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211121', '211100', '0,210000,211100,', '21', '00000021,00000000,00000021,', '1', '2', null, '大洼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211122', '211100', '0,210000,211100,', '22', '00000021,00000000,00000022,', '1', '2', null, '盘山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211200', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '铁岭市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211202', '211200', '0,210000,211200,', '2', '00000021,00000000,00000002,', '1', '2', null, '银州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211204', '211200', '0,210000,211200,', '4', '00000021,00000000,00000004,', '1', '2', null, '清河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211221', '211200', '0,210000,211200,', '21', '00000021,00000000,00000021,', '1', '2', null, '铁岭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211223', '211200', '0,210000,211200,', '23', '00000021,00000000,00000023,', '1', '2', null, '西丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211224', '211200', '0,210000,211200,', '24', '00000021,00000000,00000024,', '1', '2', null, '昌图县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211281', '211200', '0,210000,211200,', '81', '00000021,00000000,00000081,', '1', '2', null, '调兵山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211282', '211200', '0,210000,211200,', '82', '00000021,00000000,00000082,', '1', '2', null, '开原市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211300', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '朝阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211302', '211300', '0,210000,211300,', '2', '00000021,00000000,00000002,', '1', '2', null, '双塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211303', '211300', '0,210000,211300,', '3', '00000021,00000000,00000003,', '1', '2', null, '龙城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211321', '211300', '0,210000,211300,', '21', '00000021,00000000,00000021,', '1', '2', null, '朝阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211322', '211300', '0,210000,211300,', '22', '00000021,00000000,00000022,', '1', '2', null, '建平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211324', '211300', '0,210000,211300,', '24', '00000021,00000000,00000024,', '1', '2', null, '喀喇沁左翼蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211381', '211300', '0,210000,211300,', '81', '00000021,00000000,00000081,', '1', '2', null, '北票市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211382', '211300', '0,210000,211300,', '82', '00000021,00000000,00000082,', '1', '2', null, '凌源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211400', '210000', '0,210000,', '0', '00000021,00000000,', '0', '1', null, '葫芦岛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211402', '211400', '0,210000,211400,', '2', '00000021,00000000,00000002,', '1', '2', null, '连山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211403', '211400', '0,210000,211400,', '3', '00000021,00000000,00000003,', '1', '2', null, '龙港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211404', '211400', '0,210000,211400,', '4', '00000021,00000000,00000004,', '1', '2', null, '南票区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211421', '211400', '0,210000,211400,', '21', '00000021,00000000,00000021,', '1', '2', null, '绥中县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211422', '211400', '0,210000,211400,', '22', '00000021,00000000,00000022,', '1', '2', null, '建昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('211481', '211400', '0,210000,211400,', '81', '00000021,00000000,00000081,', '1', '2', null, '兴城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220000', '0', '0,', '22', '00000022,', '0', '0', null, '吉林省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220100', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '长春市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220102', '220100', '0,220000,220100,', '2', '00000022,00000000,00000002,', '1', '2', null, '南关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220103', '220100', '0,220000,220100,', '3', '00000022,00000000,00000003,', '1', '2', null, '宽城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220104', '220100', '0,220000,220100,', '4', '00000022,00000000,00000004,', '1', '2', null, '朝阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220105', '220100', '0,220000,220100,', '5', '00000022,00000000,00000005,', '1', '2', null, '二道区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220106', '220100', '0,220000,220100,', '6', '00000022,00000000,00000006,', '1', '2', null, '绿园区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220112', '220100', '0,220000,220100,', '12', '00000022,00000000,00000012,', '1', '2', null, '双阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220122', '220100', '0,220000,220100,', '22', '00000022,00000000,00000022,', '1', '2', null, '农安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220181', '220100', '0,220000,220100,', '81', '00000022,00000000,00000081,', '1', '2', null, '九台市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220182', '220100', '0,220000,220100,', '82', '00000022,00000000,00000082,', '1', '2', null, '榆树市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220183', '220100', '0,220000,220100,', '83', '00000022,00000000,00000083,', '1', '2', null, '德惠市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220200', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '吉林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220202', '220200', '0,220000,220200,', '2', '00000022,00000000,00000002,', '1', '2', null, '昌邑区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220203', '220200', '0,220000,220200,', '3', '00000022,00000000,00000003,', '1', '2', null, '龙潭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220204', '220200', '0,220000,220200,', '4', '00000022,00000000,00000004,', '1', '2', null, '船营区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220211', '220200', '0,220000,220200,', '11', '00000022,00000000,00000011,', '1', '2', null, '丰满区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220221', '220200', '0,220000,220200,', '21', '00000022,00000000,00000021,', '1', '2', null, '永吉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220281', '220200', '0,220000,220200,', '81', '00000022,00000000,00000081,', '1', '2', null, '蛟河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220282', '220200', '0,220000,220200,', '82', '00000022,00000000,00000082,', '1', '2', null, '桦甸市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220283', '220200', '0,220000,220200,', '83', '00000022,00000000,00000083,', '1', '2', null, '舒兰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220284', '220200', '0,220000,220200,', '84', '00000022,00000000,00000084,', '1', '2', null, '磐石市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220300', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '四平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220302', '220300', '0,220000,220300,', '2', '00000022,00000000,00000002,', '1', '2', null, '铁西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220303', '220300', '0,220000,220300,', '3', '00000022,00000000,00000003,', '1', '2', null, '铁东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220322', '220300', '0,220000,220300,', '22', '00000022,00000000,00000022,', '1', '2', null, '梨树县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220323', '220300', '0,220000,220300,', '23', '00000022,00000000,00000023,', '1', '2', null, '伊通满族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220381', '220300', '0,220000,220300,', '81', '00000022,00000000,00000081,', '1', '2', null, '公主岭市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220382', '220300', '0,220000,220300,', '82', '00000022,00000000,00000082,', '1', '2', null, '双辽市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220400', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '辽源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220402', '220400', '0,220000,220400,', '2', '00000022,00000000,00000002,', '1', '2', null, '龙山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220403', '220400', '0,220000,220400,', '3', '00000022,00000000,00000003,', '1', '2', null, '西安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220421', '220400', '0,220000,220400,', '21', '00000022,00000000,00000021,', '1', '2', null, '东丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220422', '220400', '0,220000,220400,', '22', '00000022,00000000,00000022,', '1', '2', null, '东辽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220500', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '通化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220502', '220500', '0,220000,220500,', '2', '00000022,00000000,00000002,', '1', '2', null, '东昌区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220503', '220500', '0,220000,220500,', '3', '00000022,00000000,00000003,', '1', '2', null, '二道江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220521', '220500', '0,220000,220500,', '21', '00000022,00000000,00000021,', '1', '2', null, '通化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220523', '220500', '0,220000,220500,', '23', '00000022,00000000,00000023,', '1', '2', null, '辉南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220524', '220500', '0,220000,220500,', '24', '00000022,00000000,00000024,', '1', '2', null, '柳河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220581', '220500', '0,220000,220500,', '81', '00000022,00000000,00000081,', '1', '2', null, '梅河口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220582', '220500', '0,220000,220500,', '82', '00000022,00000000,00000082,', '1', '2', null, '集安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220600', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '白山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220602', '220600', '0,220000,220600,', '2', '00000022,00000000,00000002,', '1', '2', null, '八道江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220621', '220600', '0,220000,220600,', '21', '00000022,00000000,00000021,', '1', '2', null, '抚松县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220622', '220600', '0,220000,220600,', '22', '00000022,00000000,00000022,', '1', '2', null, '靖宇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220623', '220600', '0,220000,220600,', '23', '00000022,00000000,00000023,', '1', '2', null, '长白朝鲜族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220625', '220600', '0,220000,220600,', '25', '00000022,00000000,00000025,', '1', '2', null, '江源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220681', '220600', '0,220000,220600,', '81', '00000022,00000000,00000081,', '1', '2', null, '临江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220700', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '松原市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220702', '220700', '0,220000,220700,', '2', '00000022,00000000,00000002,', '1', '2', null, '宁江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220721', '220700', '0,220000,220700,', '21', '00000022,00000000,00000021,', '1', '2', null, '前郭尔罗斯蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220722', '220700', '0,220000,220700,', '22', '00000022,00000000,00000022,', '1', '2', null, '长岭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220723', '220700', '0,220000,220700,', '23', '00000022,00000000,00000023,', '1', '2', null, '乾安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220724', '220700', '0,220000,220700,', '24', '00000022,00000000,00000024,', '1', '2', null, '扶余县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220800', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '白城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220802', '220800', '0,220000,220800,', '2', '00000022,00000000,00000002,', '1', '2', null, '洮北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220821', '220800', '0,220000,220800,', '21', '00000022,00000000,00000021,', '1', '2', null, '镇赉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220822', '220800', '0,220000,220800,', '22', '00000022,00000000,00000022,', '1', '2', null, '通榆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220881', '220800', '0,220000,220800,', '81', '00000022,00000000,00000081,', '1', '2', null, '洮南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('220882', '220800', '0,220000,220800,', '82', '00000022,00000000,00000082,', '1', '2', null, '大安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222400', '220000', '0,220000,', '0', '00000022,00000000,', '0', '1', null, '延边朝鲜族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222401', '222400', '0,220000,222400,', '1', '00000022,00000000,00000001,', '1', '2', null, '延吉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222402', '222400', '0,220000,222400,', '2', '00000022,00000000,00000002,', '1', '2', null, '图们市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222403', '222400', '0,220000,222400,', '3', '00000022,00000000,00000003,', '1', '2', null, '敦化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222404', '222400', '0,220000,222400,', '4', '00000022,00000000,00000004,', '1', '2', null, '珲春市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222405', '222400', '0,220000,222400,', '5', '00000022,00000000,00000005,', '1', '2', null, '龙井市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222406', '222400', '0,220000,222400,', '6', '00000022,00000000,00000006,', '1', '2', null, '和龙市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222424', '222400', '0,220000,222400,', '24', '00000022,00000000,00000024,', '1', '2', null, '汪清县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('222426', '222400', '0,220000,222400,', '26', '00000022,00000000,00000026,', '1', '2', null, '安图县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230000', '0', '0,', '23', '00000023,', '0', '0', null, '黑龙江省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230100', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '哈尔滨市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230102', '230100', '0,230000,230100,', '2', '00000023,00000000,00000002,', '1', '2', null, '道里区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230103', '230100', '0,230000,230100,', '3', '00000023,00000000,00000003,', '1', '2', null, '南岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230104', '230100', '0,230000,230100,', '4', '00000023,00000000,00000004,', '1', '2', null, '道外区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230106', '230100', '0,230000,230100,', '6', '00000023,00000000,00000006,', '1', '2', null, '香坊区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230107', '230100', '0,230000,230100,', '7', '00000023,00000000,00000007,', '1', '2', null, '动力区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230108', '230100', '0,230000,230100,', '8', '00000023,00000000,00000008,', '1', '2', null, '平房区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230109', '230100', '0,230000,230100,', '9', '00000023,00000000,00000009,', '1', '2', null, '松北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230111', '230100', '0,230000,230100,', '11', '00000023,00000000,00000011,', '1', '2', null, '呼兰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230123', '230100', '0,230000,230100,', '23', '00000023,00000000,00000023,', '1', '2', null, '依兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230124', '230100', '0,230000,230100,', '24', '00000023,00000000,00000024,', '1', '2', null, '方正县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230125', '230100', '0,230000,230100,', '25', '00000023,00000000,00000025,', '1', '2', null, '宾　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230126', '230100', '0,230000,230100,', '26', '00000023,00000000,00000026,', '1', '2', null, '巴彦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230127', '230100', '0,230000,230100,', '27', '00000023,00000000,00000027,', '1', '2', null, '木兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230128', '230100', '0,230000,230100,', '28', '00000023,00000000,00000028,', '1', '2', null, '通河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230129', '230100', '0,230000,230100,', '29', '00000023,00000000,00000029,', '1', '2', null, '延寿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230181', '230100', '0,230000,230100,', '81', '00000023,00000000,00000081,', '1', '2', null, '阿城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230182', '230100', '0,230000,230100,', '82', '00000023,00000000,00000082,', '1', '2', null, '双城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230183', '230100', '0,230000,230100,', '83', '00000023,00000000,00000083,', '1', '2', null, '尚志市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230184', '230100', '0,230000,230100,', '84', '00000023,00000000,00000084,', '1', '2', null, '五常市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230200', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '齐齐哈尔市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230202', '230200', '0,230000,230200,', '2', '00000023,00000000,00000002,', '1', '2', null, '龙沙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230203', '230200', '0,230000,230200,', '3', '00000023,00000000,00000003,', '1', '2', null, '建华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230204', '230200', '0,230000,230200,', '4', '00000023,00000000,00000004,', '1', '2', null, '铁锋区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230205', '230200', '0,230000,230200,', '5', '00000023,00000000,00000005,', '1', '2', null, '昂昂溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230206', '230200', '0,230000,230200,', '6', '00000023,00000000,00000006,', '1', '2', null, '富拉尔基区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230207', '230200', '0,230000,230200,', '7', '00000023,00000000,00000007,', '1', '2', null, '碾子山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230208', '230200', '0,230000,230200,', '8', '00000023,00000000,00000008,', '1', '2', null, '梅里斯达斡尔族区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230221', '230200', '0,230000,230200,', '21', '00000023,00000000,00000021,', '1', '2', null, '龙江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230223', '230200', '0,230000,230200,', '23', '00000023,00000000,00000023,', '1', '2', null, '依安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230224', '230200', '0,230000,230200,', '24', '00000023,00000000,00000024,', '1', '2', null, '泰来县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230225', '230200', '0,230000,230200,', '25', '00000023,00000000,00000025,', '1', '2', null, '甘南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230227', '230200', '0,230000,230200,', '27', '00000023,00000000,00000027,', '1', '2', null, '富裕县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230229', '230200', '0,230000,230200,', '29', '00000023,00000000,00000029,', '1', '2', null, '克山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230230', '230200', '0,230000,230200,', '30', '00000023,00000000,00000030,', '1', '2', null, '克东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230231', '230200', '0,230000,230200,', '31', '00000023,00000000,00000031,', '1', '2', null, '拜泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230281', '230200', '0,230000,230200,', '81', '00000023,00000000,00000081,', '1', '2', null, '讷河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230300', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '鸡西市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230302', '230300', '0,230000,230300,', '2', '00000023,00000000,00000002,', '1', '2', null, '鸡冠区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230303', '230300', '0,230000,230300,', '3', '00000023,00000000,00000003,', '1', '2', null, '恒山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230304', '230300', '0,230000,230300,', '4', '00000023,00000000,00000004,', '1', '2', null, '滴道区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230305', '230300', '0,230000,230300,', '5', '00000023,00000000,00000005,', '1', '2', null, '梨树区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230306', '230300', '0,230000,230300,', '6', '00000023,00000000,00000006,', '1', '2', null, '城子河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230307', '230300', '0,230000,230300,', '7', '00000023,00000000,00000007,', '1', '2', null, '麻山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230321', '230300', '0,230000,230300,', '21', '00000023,00000000,00000021,', '1', '2', null, '鸡东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230381', '230300', '0,230000,230300,', '81', '00000023,00000000,00000081,', '1', '2', null, '虎林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230382', '230300', '0,230000,230300,', '82', '00000023,00000000,00000082,', '1', '2', null, '密山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230400', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '鹤岗市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230402', '230400', '0,230000,230400,', '2', '00000023,00000000,00000002,', '1', '2', null, '向阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230403', '230400', '0,230000,230400,', '3', '00000023,00000000,00000003,', '1', '2', null, '工农区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230404', '230400', '0,230000,230400,', '4', '00000023,00000000,00000004,', '1', '2', null, '南山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230405', '230400', '0,230000,230400,', '5', '00000023,00000000,00000005,', '1', '2', null, '兴安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230406', '230400', '0,230000,230400,', '6', '00000023,00000000,00000006,', '1', '2', null, '东山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230407', '230400', '0,230000,230400,', '7', '00000023,00000000,00000007,', '1', '2', null, '兴山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230421', '230400', '0,230000,230400,', '21', '00000023,00000000,00000021,', '1', '2', null, '萝北县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230422', '230400', '0,230000,230400,', '22', '00000023,00000000,00000022,', '1', '2', null, '绥滨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230500', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '双鸭山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230502', '230500', '0,230000,230500,', '2', '00000023,00000000,00000002,', '1', '2', null, '尖山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230503', '230500', '0,230000,230500,', '3', '00000023,00000000,00000003,', '1', '2', null, '岭东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230505', '230500', '0,230000,230500,', '5', '00000023,00000000,00000005,', '1', '2', null, '四方台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230506', '230500', '0,230000,230500,', '6', '00000023,00000000,00000006,', '1', '2', null, '宝山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230521', '230500', '0,230000,230500,', '21', '00000023,00000000,00000021,', '1', '2', null, '集贤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230522', '230500', '0,230000,230500,', '22', '00000023,00000000,00000022,', '1', '2', null, '友谊县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230523', '230500', '0,230000,230500,', '23', '00000023,00000000,00000023,', '1', '2', null, '宝清县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230524', '230500', '0,230000,230500,', '24', '00000023,00000000,00000024,', '1', '2', null, '饶河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230600', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '大庆市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230602', '230600', '0,230000,230600,', '2', '00000023,00000000,00000002,', '1', '2', null, '萨尔图区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230603', '230600', '0,230000,230600,', '3', '00000023,00000000,00000003,', '1', '2', null, '龙凤区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230604', '230600', '0,230000,230600,', '4', '00000023,00000000,00000004,', '1', '2', null, '让胡路区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230605', '230600', '0,230000,230600,', '5', '00000023,00000000,00000005,', '1', '2', null, '红岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230606', '230600', '0,230000,230600,', '6', '00000023,00000000,00000006,', '1', '2', null, '大同区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230621', '230600', '0,230000,230600,', '21', '00000023,00000000,00000021,', '1', '2', null, '肇州县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230622', '230600', '0,230000,230600,', '22', '00000023,00000000,00000022,', '1', '2', null, '肇源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230623', '230600', '0,230000,230600,', '23', '00000023,00000000,00000023,', '1', '2', null, '林甸县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230624', '230600', '0,230000,230600,', '24', '00000023,00000000,00000024,', '1', '2', null, '杜尔伯特蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230700', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '伊春市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230702', '230700', '0,230000,230700,', '2', '00000023,00000000,00000002,', '1', '2', null, '伊春区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230703', '230700', '0,230000,230700,', '3', '00000023,00000000,00000003,', '1', '2', null, '南岔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230704', '230700', '0,230000,230700,', '4', '00000023,00000000,00000004,', '1', '2', null, '友好区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230705', '230700', '0,230000,230700,', '5', '00000023,00000000,00000005,', '1', '2', null, '西林区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230706', '230700', '0,230000,230700,', '6', '00000023,00000000,00000006,', '1', '2', null, '翠峦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230707', '230700', '0,230000,230700,', '7', '00000023,00000000,00000007,', '1', '2', null, '新青区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230708', '230700', '0,230000,230700,', '8', '00000023,00000000,00000008,', '1', '2', null, '美溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230709', '230700', '0,230000,230700,', '9', '00000023,00000000,00000009,', '1', '2', null, '金山屯区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230710', '230700', '0,230000,230700,', '10', '00000023,00000000,00000010,', '1', '2', null, '五营区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230711', '230700', '0,230000,230700,', '11', '00000023,00000000,00000011,', '1', '2', null, '乌马河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230712', '230700', '0,230000,230700,', '12', '00000023,00000000,00000012,', '1', '2', null, '汤旺河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230713', '230700', '0,230000,230700,', '13', '00000023,00000000,00000013,', '1', '2', null, '带岭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230714', '230700', '0,230000,230700,', '14', '00000023,00000000,00000014,', '1', '2', null, '乌伊岭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230715', '230700', '0,230000,230700,', '15', '00000023,00000000,00000015,', '1', '2', null, '红星区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230716', '230700', '0,230000,230700,', '16', '00000023,00000000,00000016,', '1', '2', null, '上甘岭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230722', '230700', '0,230000,230700,', '22', '00000023,00000000,00000022,', '1', '2', null, '嘉荫县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230781', '230700', '0,230000,230700,', '81', '00000023,00000000,00000081,', '1', '2', null, '铁力市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230800', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '佳木斯市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230802', '230800', '0,230000,230800,', '2', '00000023,00000000,00000002,', '1', '2', null, '永红区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230803', '230800', '0,230000,230800,', '3', '00000023,00000000,00000003,', '1', '2', null, '向阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230804', '230800', '0,230000,230800,', '4', '00000023,00000000,00000004,', '1', '2', null, '前进区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230805', '230800', '0,230000,230800,', '5', '00000023,00000000,00000005,', '1', '2', null, '东风区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230811', '230800', '0,230000,230800,', '11', '00000023,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230822', '230800', '0,230000,230800,', '22', '00000023,00000000,00000022,', '1', '2', null, '桦南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230826', '230800', '0,230000,230800,', '26', '00000023,00000000,00000026,', '1', '2', null, '桦川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230828', '230800', '0,230000,230800,', '28', '00000023,00000000,00000028,', '1', '2', null, '汤原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230833', '230800', '0,230000,230800,', '33', '00000023,00000000,00000033,', '1', '2', null, '抚远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230881', '230800', '0,230000,230800,', '81', '00000023,00000000,00000081,', '1', '2', null, '同江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230882', '230800', '0,230000,230800,', '82', '00000023,00000000,00000082,', '1', '2', null, '富锦市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230900', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '七台河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230902', '230900', '0,230000,230900,', '2', '00000023,00000000,00000002,', '1', '2', null, '新兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230903', '230900', '0,230000,230900,', '3', '00000023,00000000,00000003,', '1', '2', null, '桃山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230904', '230900', '0,230000,230900,', '4', '00000023,00000000,00000004,', '1', '2', null, '茄子河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('230921', '230900', '0,230000,230900,', '21', '00000023,00000000,00000021,', '1', '2', null, '勃利县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231000', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '牡丹江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231002', '231000', '0,230000,231000,', '2', '00000023,00000000,00000002,', '1', '2', null, '东安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231003', '231000', '0,230000,231000,', '3', '00000023,00000000,00000003,', '1', '2', null, '阳明区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231004', '231000', '0,230000,231000,', '4', '00000023,00000000,00000004,', '1', '2', null, '爱民区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231005', '231000', '0,230000,231000,', '5', '00000023,00000000,00000005,', '1', '2', null, '西安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231024', '231000', '0,230000,231000,', '24', '00000023,00000000,00000024,', '1', '2', null, '东宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231025', '231000', '0,230000,231000,', '25', '00000023,00000000,00000025,', '1', '2', null, '林口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231081', '231000', '0,230000,231000,', '81', '00000023,00000000,00000081,', '1', '2', null, '绥芬河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231083', '231000', '0,230000,231000,', '83', '00000023,00000000,00000083,', '1', '2', null, '海林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231084', '231000', '0,230000,231000,', '84', '00000023,00000000,00000084,', '1', '2', null, '宁安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231085', '231000', '0,230000,231000,', '85', '00000023,00000000,00000085,', '1', '2', null, '穆棱市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231100', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '黑河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231102', '231100', '0,230000,231100,', '2', '00000023,00000000,00000002,', '1', '2', null, '爱辉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231121', '231100', '0,230000,231100,', '21', '00000023,00000000,00000021,', '1', '2', null, '嫩江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231123', '231100', '0,230000,231100,', '23', '00000023,00000000,00000023,', '1', '2', null, '逊克县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231124', '231100', '0,230000,231100,', '24', '00000023,00000000,00000024,', '1', '2', null, '孙吴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231181', '231100', '0,230000,231100,', '81', '00000023,00000000,00000081,', '1', '2', null, '北安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231182', '231100', '0,230000,231100,', '82', '00000023,00000000,00000082,', '1', '2', null, '五大连池市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231200', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '绥化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231202', '231200', '0,230000,231200,', '2', '00000023,00000000,00000002,', '1', '2', null, '北林区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231221', '231200', '0,230000,231200,', '21', '00000023,00000000,00000021,', '1', '2', null, '望奎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231222', '231200', '0,230000,231200,', '22', '00000023,00000000,00000022,', '1', '2', null, '兰西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231223', '231200', '0,230000,231200,', '23', '00000023,00000000,00000023,', '1', '2', null, '青冈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231224', '231200', '0,230000,231200,', '24', '00000023,00000000,00000024,', '1', '2', null, '庆安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231225', '231200', '0,230000,231200,', '25', '00000023,00000000,00000025,', '1', '2', null, '明水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231226', '231200', '0,230000,231200,', '26', '00000023,00000000,00000026,', '1', '2', null, '绥棱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231281', '231200', '0,230000,231200,', '81', '00000023,00000000,00000081,', '1', '2', null, '安达市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231282', '231200', '0,230000,231200,', '82', '00000023,00000000,00000082,', '1', '2', null, '肇东市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('231283', '231200', '0,230000,231200,', '83', '00000023,00000000,00000083,', '1', '2', null, '海伦市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('232700', '230000', '0,230000,', '0', '00000023,00000000,', '0', '1', null, '大兴安岭地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('232721', '232700', '0,230000,232700,', '21', '00000023,00000000,00000021,', '1', '2', null, '呼玛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('232722', '232700', '0,230000,232700,', '22', '00000023,00000000,00000022,', '1', '2', null, '塔河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('232723', '232700', '0,230000,232700,', '23', '00000023,00000000,00000023,', '1', '2', null, '漠河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310000', '0', '0,', '31', '00000031,', '0', '0', null, '上海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310100', '310000', '0,310000,', '0', '00000031,00000000,', '0', '1', null, '市辖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310101', '310100', '0,310000,310100,', '1', '00000031,00000000,00000001,', '1', '2', null, '黄浦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310103', '310100', '0,310000,310100,', '3', '00000031,00000000,00000003,', '1', '2', null, '卢湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310104', '310100', '0,310000,310100,', '4', '00000031,00000000,00000004,', '1', '2', null, '徐汇区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310105', '310100', '0,310000,310100,', '5', '00000031,00000000,00000005,', '1', '2', null, '长宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310106', '310100', '0,310000,310100,', '6', '00000031,00000000,00000006,', '1', '2', null, '静安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310107', '310100', '0,310000,310100,', '7', '00000031,00000000,00000007,', '1', '2', null, '普陀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310108', '310100', '0,310000,310100,', '8', '00000031,00000000,00000008,', '1', '2', null, '闸北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310109', '310100', '0,310000,310100,', '9', '00000031,00000000,00000009,', '1', '2', null, '虹口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310110', '310100', '0,310000,310100,', '10', '00000031,00000000,00000010,', '1', '2', null, '杨浦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310112', '310100', '0,310000,310100,', '12', '00000031,00000000,00000012,', '1', '2', null, '闵行区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310113', '310100', '0,310000,310100,', '13', '00000031,00000000,00000013,', '1', '2', null, '宝山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310114', '310100', '0,310000,310100,', '14', '00000031,00000000,00000014,', '1', '2', null, '嘉定区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310115', '310100', '0,310000,310100,', '15', '00000031,00000000,00000015,', '1', '2', null, '浦东新区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310116', '310100', '0,310000,310100,', '16', '00000031,00000000,00000016,', '1', '2', null, '金山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310117', '310100', '0,310000,310100,', '17', '00000031,00000000,00000017,', '1', '2', null, '松江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310118', '310100', '0,310000,310100,', '18', '00000031,00000000,00000018,', '1', '2', null, '青浦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310119', '310100', '0,310000,310100,', '19', '00000031,00000000,00000019,', '1', '2', null, '南汇区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310120', '310100', '0,310000,310100,', '20', '00000031,00000000,00000020,', '1', '2', null, '奉贤区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310200', '310000', '0,310000,', '0', '00000031,00000000,', '0', '1', null, '县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('310230', '310200', '0,310000,310200,', '30', '00000031,00000000,00000030,', '1', '2', null, '崇明县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320000', '0', '0,', '32', '00000032,', '0', '0', null, '江苏省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320100', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '南京市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320102', '320100', '0,320000,320100,', '2', '00000032,00000000,00000002,', '1', '2', null, '玄武区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320103', '320100', '0,320000,320100,', '3', '00000032,00000000,00000003,', '1', '2', null, '白下区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320104', '320100', '0,320000,320100,', '4', '00000032,00000000,00000004,', '1', '2', null, '秦淮区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320105', '320100', '0,320000,320100,', '5', '00000032,00000000,00000005,', '1', '2', null, '建邺区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320106', '320100', '0,320000,320100,', '6', '00000032,00000000,00000006,', '1', '2', null, '鼓楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320107', '320100', '0,320000,320100,', '7', '00000032,00000000,00000007,', '1', '2', null, '下关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320111', '320100', '0,320000,320100,', '11', '00000032,00000000,00000011,', '1', '2', null, '浦口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320113', '320100', '0,320000,320100,', '13', '00000032,00000000,00000013,', '1', '2', null, '栖霞区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320114', '320100', '0,320000,320100,', '14', '00000032,00000000,00000014,', '1', '2', null, '雨花台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320115', '320100', '0,320000,320100,', '15', '00000032,00000000,00000015,', '1', '2', null, '江宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320116', '320100', '0,320000,320100,', '16', '00000032,00000000,00000016,', '1', '2', null, '六合区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320124', '320100', '0,320000,320100,', '24', '00000032,00000000,00000024,', '1', '2', null, '溧水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320125', '320100', '0,320000,320100,', '25', '00000032,00000000,00000025,', '1', '2', null, '高淳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320200', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '无锡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320202', '320200', '0,320000,320200,', '2', '00000032,00000000,00000002,', '1', '2', null, '崇安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320203', '320200', '0,320000,320200,', '3', '00000032,00000000,00000003,', '1', '2', null, '南长区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320204', '320200', '0,320000,320200,', '4', '00000032,00000000,00000004,', '1', '2', null, '北塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320205', '320200', '0,320000,320200,', '5', '00000032,00000000,00000005,', '1', '2', null, '锡山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320206', '320200', '0,320000,320200,', '6', '00000032,00000000,00000006,', '1', '2', null, '惠山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320211', '320200', '0,320000,320200,', '11', '00000032,00000000,00000011,', '1', '2', null, '滨湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320281', '320200', '0,320000,320200,', '81', '00000032,00000000,00000081,', '1', '2', null, '江阴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320282', '320200', '0,320000,320200,', '82', '00000032,00000000,00000082,', '1', '2', null, '宜兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320300', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '徐州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320302', '320300', '0,320000,320300,', '2', '00000032,00000000,00000002,', '1', '2', null, '鼓楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320303', '320300', '0,320000,320300,', '3', '00000032,00000000,00000003,', '1', '2', null, '云龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320304', '320300', '0,320000,320300,', '4', '00000032,00000000,00000004,', '1', '2', null, '九里区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320305', '320300', '0,320000,320300,', '5', '00000032,00000000,00000005,', '1', '2', null, '贾汪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320311', '320300', '0,320000,320300,', '11', '00000032,00000000,00000011,', '1', '2', null, '泉山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320321', '320300', '0,320000,320300,', '21', '00000032,00000000,00000021,', '1', '2', null, '丰　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320322', '320300', '0,320000,320300,', '22', '00000032,00000000,00000022,', '1', '2', null, '沛　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320323', '320300', '0,320000,320300,', '23', '00000032,00000000,00000023,', '1', '2', null, '铜山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320324', '320300', '0,320000,320300,', '24', '00000032,00000000,00000024,', '1', '2', null, '睢宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320381', '320300', '0,320000,320300,', '81', '00000032,00000000,00000081,', '1', '2', null, '新沂市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320382', '320300', '0,320000,320300,', '82', '00000032,00000000,00000082,', '1', '2', null, '邳州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320400', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '常州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320402', '320400', '0,320000,320400,', '2', '00000032,00000000,00000002,', '1', '2', null, '天宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320404', '320400', '0,320000,320400,', '4', '00000032,00000000,00000004,', '1', '2', null, '钟楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320405', '320400', '0,320000,320400,', '5', '00000032,00000000,00000005,', '1', '2', null, '戚墅堰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320411', '320400', '0,320000,320400,', '11', '00000032,00000000,00000011,', '1', '2', null, '新北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320412', '320400', '0,320000,320400,', '12', '00000032,00000000,00000012,', '1', '2', null, '武进区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320481', '320400', '0,320000,320400,', '81', '00000032,00000000,00000081,', '1', '2', null, '溧阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320482', '320400', '0,320000,320400,', '82', '00000032,00000000,00000082,', '1', '2', null, '金坛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320500', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '苏州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320502', '320500', '0,320000,320500,', '2', '00000032,00000000,00000002,', '1', '2', null, '沧浪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320503', '320500', '0,320000,320500,', '3', '00000032,00000000,00000003,', '1', '2', null, '平江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320504', '320500', '0,320000,320500,', '4', '00000032,00000000,00000004,', '1', '2', null, '金阊区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320505', '320500', '0,320000,320500,', '5', '00000032,00000000,00000005,', '1', '2', null, '虎丘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320506', '320500', '0,320000,320500,', '6', '00000032,00000000,00000006,', '1', '2', null, '吴中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320507', '320500', '0,320000,320500,', '7', '00000032,00000000,00000007,', '1', '2', null, '相城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320581', '320500', '0,320000,320500,', '81', '00000032,00000000,00000081,', '1', '2', null, '常熟市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320582', '320500', '0,320000,320500,', '82', '00000032,00000000,00000082,', '1', '2', null, '张家港市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320583', '320500', '0,320000,320500,', '83', '00000032,00000000,00000083,', '1', '2', null, '昆山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320584', '320500', '0,320000,320500,', '84', '00000032,00000000,00000084,', '1', '2', null, '吴江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320585', '320500', '0,320000,320500,', '85', '00000032,00000000,00000085,', '1', '2', null, '太仓市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320600', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '南通市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320602', '320600', '0,320000,320600,', '2', '00000032,00000000,00000002,', '1', '2', null, '崇川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320611', '320600', '0,320000,320600,', '11', '00000032,00000000,00000011,', '1', '2', null, '港闸区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320621', '320600', '0,320000,320600,', '21', '00000032,00000000,00000021,', '1', '2', null, '海安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320623', '320600', '0,320000,320600,', '23', '00000032,00000000,00000023,', '1', '2', null, '如东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320681', '320600', '0,320000,320600,', '81', '00000032,00000000,00000081,', '1', '2', null, '启东市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320682', '320600', '0,320000,320600,', '82', '00000032,00000000,00000082,', '1', '2', null, '如皋市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320683', '320600', '0,320000,320600,', '83', '00000032,00000000,00000083,', '1', '2', null, '通州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320684', '320600', '0,320000,320600,', '84', '00000032,00000000,00000084,', '1', '2', null, '海门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320700', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '连云港市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320703', '320700', '0,320000,320700,', '3', '00000032,00000000,00000003,', '1', '2', null, '连云区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320705', '320700', '0,320000,320700,', '5', '00000032,00000000,00000005,', '1', '2', null, '新浦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320706', '320700', '0,320000,320700,', '6', '00000032,00000000,00000006,', '1', '2', null, '海州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320721', '320700', '0,320000,320700,', '21', '00000032,00000000,00000021,', '1', '2', null, '赣榆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320722', '320700', '0,320000,320700,', '22', '00000032,00000000,00000022,', '1', '2', null, '东海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320723', '320700', '0,320000,320700,', '23', '00000032,00000000,00000023,', '1', '2', null, '灌云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320724', '320700', '0,320000,320700,', '24', '00000032,00000000,00000024,', '1', '2', null, '灌南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320800', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '淮安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320802', '320800', '0,320000,320800,', '2', '00000032,00000000,00000002,', '1', '2', null, '清河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320803', '320800', '0,320000,320800,', '3', '00000032,00000000,00000003,', '1', '2', null, '楚州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320804', '320800', '0,320000,320800,', '4', '00000032,00000000,00000004,', '1', '2', null, '淮阴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320811', '320800', '0,320000,320800,', '11', '00000032,00000000,00000011,', '1', '2', null, '清浦区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320826', '320800', '0,320000,320800,', '26', '00000032,00000000,00000026,', '1', '2', null, '涟水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320829', '320800', '0,320000,320800,', '29', '00000032,00000000,00000029,', '1', '2', null, '洪泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320830', '320800', '0,320000,320800,', '30', '00000032,00000000,00000030,', '1', '2', null, '盱眙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320831', '320800', '0,320000,320800,', '31', '00000032,00000000,00000031,', '1', '2', null, '金湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320900', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '盐城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320902', '320900', '0,320000,320900,', '2', '00000032,00000000,00000002,', '1', '2', null, '亭湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320903', '320900', '0,320000,320900,', '3', '00000032,00000000,00000003,', '1', '2', null, '盐都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320921', '320900', '0,320000,320900,', '21', '00000032,00000000,00000021,', '1', '2', null, '响水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320922', '320900', '0,320000,320900,', '22', '00000032,00000000,00000022,', '1', '2', null, '滨海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320923', '320900', '0,320000,320900,', '23', '00000032,00000000,00000023,', '1', '2', null, '阜宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320924', '320900', '0,320000,320900,', '24', '00000032,00000000,00000024,', '1', '2', null, '射阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320925', '320900', '0,320000,320900,', '25', '00000032,00000000,00000025,', '1', '2', null, '建湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320981', '320900', '0,320000,320900,', '81', '00000032,00000000,00000081,', '1', '2', null, '东台市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('320982', '320900', '0,320000,320900,', '82', '00000032,00000000,00000082,', '1', '2', null, '大丰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321000', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '扬州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321002', '321000', '0,320000,321000,', '2', '00000032,00000000,00000002,', '1', '2', null, '广陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321003', '321000', '0,320000,321000,', '3', '00000032,00000000,00000003,', '1', '2', null, '邗江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321011', '321000', '0,320000,321000,', '11', '00000032,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321023', '321000', '0,320000,321000,', '23', '00000032,00000000,00000023,', '1', '2', null, '宝应县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321081', '321000', '0,320000,321000,', '81', '00000032,00000000,00000081,', '1', '2', null, '仪征市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321084', '321000', '0,320000,321000,', '84', '00000032,00000000,00000084,', '1', '2', null, '高邮市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321088', '321000', '0,320000,321000,', '88', '00000032,00000000,00000088,', '1', '2', null, '江都市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321100', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '镇江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321102', '321100', '0,320000,321100,', '2', '00000032,00000000,00000002,', '1', '2', null, '京口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321111', '321100', '0,320000,321100,', '11', '00000032,00000000,00000011,', '1', '2', null, '润州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321112', '321100', '0,320000,321100,', '12', '00000032,00000000,00000012,', '1', '2', null, '丹徒区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321181', '321100', '0,320000,321100,', '81', '00000032,00000000,00000081,', '1', '2', null, '丹阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321182', '321100', '0,320000,321100,', '82', '00000032,00000000,00000082,', '1', '2', null, '扬中市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321183', '321100', '0,320000,321100,', '83', '00000032,00000000,00000083,', '1', '2', null, '句容市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321200', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '泰州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321202', '321200', '0,320000,321200,', '2', '00000032,00000000,00000002,', '1', '2', null, '海陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321203', '321200', '0,320000,321200,', '3', '00000032,00000000,00000003,', '1', '2', null, '高港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321281', '321200', '0,320000,321200,', '81', '00000032,00000000,00000081,', '1', '2', null, '兴化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321282', '321200', '0,320000,321200,', '82', '00000032,00000000,00000082,', '1', '2', null, '靖江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321283', '321200', '0,320000,321200,', '83', '00000032,00000000,00000083,', '1', '2', null, '泰兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321284', '321200', '0,320000,321200,', '84', '00000032,00000000,00000084,', '1', '2', null, '姜堰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321300', '320000', '0,320000,', '0', '00000032,00000000,', '0', '1', null, '宿迁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321302', '321300', '0,320000,321300,', '2', '00000032,00000000,00000002,', '1', '2', null, '宿城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321311', '321300', '0,320000,321300,', '11', '00000032,00000000,00000011,', '1', '2', null, '宿豫区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321322', '321300', '0,320000,321300,', '22', '00000032,00000000,00000022,', '1', '2', null, '沭阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321323', '321300', '0,320000,321300,', '23', '00000032,00000000,00000023,', '1', '2', null, '泗阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('321324', '321300', '0,320000,321300,', '24', '00000032,00000000,00000024,', '1', '2', null, '泗洪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330000', '0', '0,', '33', '00000033,', '0', '0', null, '浙江省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330100', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '杭州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330102', '330100', '0,330000,330100,', '2', '00000033,00000000,00000002,', '1', '2', null, '上城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330103', '330100', '0,330000,330100,', '3', '00000033,00000000,00000003,', '1', '2', null, '下城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330104', '330100', '0,330000,330100,', '4', '00000033,00000000,00000004,', '1', '2', null, '江干区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330105', '330100', '0,330000,330100,', '5', '00000033,00000000,00000005,', '1', '2', null, '拱墅区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330106', '330100', '0,330000,330100,', '6', '00000033,00000000,00000006,', '1', '2', null, '西湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330108', '330100', '0,330000,330100,', '8', '00000033,00000000,00000008,', '1', '2', null, '滨江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330109', '330100', '0,330000,330100,', '9', '00000033,00000000,00000009,', '1', '2', null, '萧山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330110', '330100', '0,330000,330100,', '10', '00000033,00000000,00000010,', '1', '2', null, '余杭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330122', '330100', '0,330000,330100,', '22', '00000033,00000000,00000022,', '1', '2', null, '桐庐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330127', '330100', '0,330000,330100,', '27', '00000033,00000000,00000027,', '1', '2', null, '淳安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330182', '330100', '0,330000,330100,', '82', '00000033,00000000,00000082,', '1', '2', null, '建德市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330183', '330100', '0,330000,330100,', '83', '00000033,00000000,00000083,', '1', '2', null, '富阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330185', '330100', '0,330000,330100,', '85', '00000033,00000000,00000085,', '1', '2', null, '临安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330200', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '宁波市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330203', '330200', '0,330000,330200,', '3', '00000033,00000000,00000003,', '1', '2', null, '海曙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330204', '330200', '0,330000,330200,', '4', '00000033,00000000,00000004,', '1', '2', null, '江东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330205', '330200', '0,330000,330200,', '5', '00000033,00000000,00000005,', '1', '2', null, '江北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330206', '330200', '0,330000,330200,', '6', '00000033,00000000,00000006,', '1', '2', null, '北仑区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330211', '330200', '0,330000,330200,', '11', '00000033,00000000,00000011,', '1', '2', null, '镇海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330212', '330200', '0,330000,330200,', '12', '00000033,00000000,00000012,', '1', '2', null, '鄞州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330225', '330200', '0,330000,330200,', '25', '00000033,00000000,00000025,', '1', '2', null, '象山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330226', '330200', '0,330000,330200,', '26', '00000033,00000000,00000026,', '1', '2', null, '宁海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330281', '330200', '0,330000,330200,', '81', '00000033,00000000,00000081,', '1', '2', null, '余姚市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330282', '330200', '0,330000,330200,', '82', '00000033,00000000,00000082,', '1', '2', null, '慈溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330283', '330200', '0,330000,330200,', '83', '00000033,00000000,00000083,', '1', '2', null, '奉化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330300', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '温州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330302', '330300', '0,330000,330300,', '2', '00000033,00000000,00000002,', '1', '2', null, '鹿城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330303', '330300', '0,330000,330300,', '3', '00000033,00000000,00000003,', '1', '2', null, '龙湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330304', '330300', '0,330000,330300,', '4', '00000033,00000000,00000004,', '1', '2', null, '瓯海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330322', '330300', '0,330000,330300,', '22', '00000033,00000000,00000022,', '1', '2', null, '洞头县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330324', '330300', '0,330000,330300,', '24', '00000033,00000000,00000024,', '1', '2', null, '永嘉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330326', '330300', '0,330000,330300,', '26', '00000033,00000000,00000026,', '1', '2', null, '平阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330327', '330300', '0,330000,330300,', '27', '00000033,00000000,00000027,', '1', '2', null, '苍南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330328', '330300', '0,330000,330300,', '28', '00000033,00000000,00000028,', '1', '2', null, '文成县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330329', '330300', '0,330000,330300,', '29', '00000033,00000000,00000029,', '1', '2', null, '泰顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330381', '330300', '0,330000,330300,', '81', '00000033,00000000,00000081,', '1', '2', null, '瑞安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330382', '330300', '0,330000,330300,', '82', '00000033,00000000,00000082,', '1', '2', null, '乐清市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330400', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '嘉兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330402', '330400', '0,330000,330400,', '2', '00000033,00000000,00000002,', '1', '2', null, '秀城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330411', '330400', '0,330000,330400,', '11', '00000033,00000000,00000011,', '1', '2', null, '秀洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330421', '330400', '0,330000,330400,', '21', '00000033,00000000,00000021,', '1', '2', null, '嘉善县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330424', '330400', '0,330000,330400,', '24', '00000033,00000000,00000024,', '1', '2', null, '海盐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330481', '330400', '0,330000,330400,', '81', '00000033,00000000,00000081,', '1', '2', null, '海宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330482', '330400', '0,330000,330400,', '82', '00000033,00000000,00000082,', '1', '2', null, '平湖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330483', '330400', '0,330000,330400,', '83', '00000033,00000000,00000083,', '1', '2', null, '桐乡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330500', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '湖州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330502', '330500', '0,330000,330500,', '2', '00000033,00000000,00000002,', '1', '2', null, '吴兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330503', '330500', '0,330000,330500,', '3', '00000033,00000000,00000003,', '1', '2', null, '南浔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330521', '330500', '0,330000,330500,', '21', '00000033,00000000,00000021,', '1', '2', null, '德清县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330522', '330500', '0,330000,330500,', '22', '00000033,00000000,00000022,', '1', '2', null, '长兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330523', '330500', '0,330000,330500,', '23', '00000033,00000000,00000023,', '1', '2', null, '安吉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330600', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '绍兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330602', '330600', '0,330000,330600,', '2', '00000033,00000000,00000002,', '1', '2', null, '越城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330621', '330600', '0,330000,330600,', '21', '00000033,00000000,00000021,', '1', '2', null, '绍兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330624', '330600', '0,330000,330600,', '24', '00000033,00000000,00000024,', '1', '2', null, '新昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330681', '330600', '0,330000,330600,', '81', '00000033,00000000,00000081,', '1', '2', null, '诸暨市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330682', '330600', '0,330000,330600,', '82', '00000033,00000000,00000082,', '1', '2', null, '上虞市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330683', '330600', '0,330000,330600,', '83', '00000033,00000000,00000083,', '1', '2', null, '嵊州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330700', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '金华市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330702', '330700', '0,330000,330700,', '2', '00000033,00000000,00000002,', '1', '2', null, '婺城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330703', '330700', '0,330000,330700,', '3', '00000033,00000000,00000003,', '1', '2', null, '金东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330723', '330700', '0,330000,330700,', '23', '00000033,00000000,00000023,', '1', '2', null, '武义县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330726', '330700', '0,330000,330700,', '26', '00000033,00000000,00000026,', '1', '2', null, '浦江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330727', '330700', '0,330000,330700,', '27', '00000033,00000000,00000027,', '1', '2', null, '磐安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330781', '330700', '0,330000,330700,', '81', '00000033,00000000,00000081,', '1', '2', null, '兰溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330782', '330700', '0,330000,330700,', '82', '00000033,00000000,00000082,', '1', '2', null, '义乌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330783', '330700', '0,330000,330700,', '83', '00000033,00000000,00000083,', '1', '2', null, '东阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330784', '330700', '0,330000,330700,', '84', '00000033,00000000,00000084,', '1', '2', null, '永康市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330800', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '衢州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330802', '330800', '0,330000,330800,', '2', '00000033,00000000,00000002,', '1', '2', null, '柯城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330803', '330800', '0,330000,330800,', '3', '00000033,00000000,00000003,', '1', '2', null, '衢江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330822', '330800', '0,330000,330800,', '22', '00000033,00000000,00000022,', '1', '2', null, '常山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330824', '330800', '0,330000,330800,', '24', '00000033,00000000,00000024,', '1', '2', null, '开化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330825', '330800', '0,330000,330800,', '25', '00000033,00000000,00000025,', '1', '2', null, '龙游县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330881', '330800', '0,330000,330800,', '81', '00000033,00000000,00000081,', '1', '2', null, '江山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330900', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '舟山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330902', '330900', '0,330000,330900,', '2', '00000033,00000000,00000002,', '1', '2', null, '定海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330903', '330900', '0,330000,330900,', '3', '00000033,00000000,00000003,', '1', '2', null, '普陀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330921', '330900', '0,330000,330900,', '21', '00000033,00000000,00000021,', '1', '2', null, '岱山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('330922', '330900', '0,330000,330900,', '22', '00000033,00000000,00000022,', '1', '2', null, '嵊泗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331000', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '台州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331002', '331000', '0,330000,331000,', '2', '00000033,00000000,00000002,', '1', '2', null, '椒江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331003', '331000', '0,330000,331000,', '3', '00000033,00000000,00000003,', '1', '2', null, '黄岩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331004', '331000', '0,330000,331000,', '4', '00000033,00000000,00000004,', '1', '2', null, '路桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331021', '331000', '0,330000,331000,', '21', '00000033,00000000,00000021,', '1', '2', null, '玉环县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331022', '331000', '0,330000,331000,', '22', '00000033,00000000,00000022,', '1', '2', null, '三门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331023', '331000', '0,330000,331000,', '23', '00000033,00000000,00000023,', '1', '2', null, '天台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331024', '331000', '0,330000,331000,', '24', '00000033,00000000,00000024,', '1', '2', null, '仙居县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331081', '331000', '0,330000,331000,', '81', '00000033,00000000,00000081,', '1', '2', null, '温岭市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331082', '331000', '0,330000,331000,', '82', '00000033,00000000,00000082,', '1', '2', null, '临海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331100', '330000', '0,330000,', '0', '00000033,00000000,', '0', '1', null, '丽水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331102', '331100', '0,330000,331100,', '2', '00000033,00000000,00000002,', '1', '2', null, '莲都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331121', '331100', '0,330000,331100,', '21', '00000033,00000000,00000021,', '1', '2', null, '青田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331122', '331100', '0,330000,331100,', '22', '00000033,00000000,00000022,', '1', '2', null, '缙云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331123', '331100', '0,330000,331100,', '23', '00000033,00000000,00000023,', '1', '2', null, '遂昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331124', '331100', '0,330000,331100,', '24', '00000033,00000000,00000024,', '1', '2', null, '松阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331125', '331100', '0,330000,331100,', '25', '00000033,00000000,00000025,', '1', '2', null, '云和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331126', '331100', '0,330000,331100,', '26', '00000033,00000000,00000026,', '1', '2', null, '庆元县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331127', '331100', '0,330000,331100,', '27', '00000033,00000000,00000027,', '1', '2', null, '景宁畲族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('331181', '331100', '0,330000,331100,', '81', '00000033,00000000,00000081,', '1', '2', null, '龙泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340000', '0', '0,', '34', '00000034,', '0', '0', null, '安徽省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340100', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '合肥市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340102', '340100', '0,340000,340100,', '2', '00000034,00000000,00000002,', '1', '2', null, '瑶海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340103', '340100', '0,340000,340100,', '3', '00000034,00000000,00000003,', '1', '2', null, '庐阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340104', '340100', '0,340000,340100,', '4', '00000034,00000000,00000004,', '1', '2', null, '蜀山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340111', '340100', '0,340000,340100,', '11', '00000034,00000000,00000011,', '1', '2', null, '包河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340121', '340100', '0,340000,340100,', '21', '00000034,00000000,00000021,', '1', '2', null, '长丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340122', '340100', '0,340000,340100,', '22', '00000034,00000000,00000022,', '1', '2', null, '肥东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340123', '340100', '0,340000,340100,', '23', '00000034,00000000,00000023,', '1', '2', null, '肥西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340200', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '芜湖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340202', '340200', '0,340000,340200,', '2', '00000034,00000000,00000002,', '1', '2', null, '镜湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340203', '340200', '0,340000,340200,', '3', '00000034,00000000,00000003,', '1', '2', null, '马塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340204', '340200', '0,340000,340200,', '4', '00000034,00000000,00000004,', '1', '2', null, '新芜区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340207', '340200', '0,340000,340200,', '7', '00000034,00000000,00000007,', '1', '2', null, '鸠江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340221', '340200', '0,340000,340200,', '21', '00000034,00000000,00000021,', '1', '2', null, '芜湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340222', '340200', '0,340000,340200,', '22', '00000034,00000000,00000022,', '1', '2', null, '繁昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340223', '340200', '0,340000,340200,', '23', '00000034,00000000,00000023,', '1', '2', null, '南陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340300', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '蚌埠市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340302', '340300', '0,340000,340300,', '2', '00000034,00000000,00000002,', '1', '2', null, '龙子湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340303', '340300', '0,340000,340300,', '3', '00000034,00000000,00000003,', '1', '2', null, '蚌山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340304', '340300', '0,340000,340300,', '4', '00000034,00000000,00000004,', '1', '2', null, '禹会区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340311', '340300', '0,340000,340300,', '11', '00000034,00000000,00000011,', '1', '2', null, '淮上区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340321', '340300', '0,340000,340300,', '21', '00000034,00000000,00000021,', '1', '2', null, '怀远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340322', '340300', '0,340000,340300,', '22', '00000034,00000000,00000022,', '1', '2', null, '五河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340323', '340300', '0,340000,340300,', '23', '00000034,00000000,00000023,', '1', '2', null, '固镇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340400', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '淮南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340402', '340400', '0,340000,340400,', '2', '00000034,00000000,00000002,', '1', '2', null, '大通区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340403', '340400', '0,340000,340400,', '3', '00000034,00000000,00000003,', '1', '2', null, '田家庵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340404', '340400', '0,340000,340400,', '4', '00000034,00000000,00000004,', '1', '2', null, '谢家集区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340405', '340400', '0,340000,340400,', '5', '00000034,00000000,00000005,', '1', '2', null, '八公山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340406', '340400', '0,340000,340400,', '6', '00000034,00000000,00000006,', '1', '2', null, '潘集区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340421', '340400', '0,340000,340400,', '21', '00000034,00000000,00000021,', '1', '2', null, '凤台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340500', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '马鞍山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340502', '340500', '0,340000,340500,', '2', '00000034,00000000,00000002,', '1', '2', null, '金家庄区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340503', '340500', '0,340000,340500,', '3', '00000034,00000000,00000003,', '1', '2', null, '花山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340504', '340500', '0,340000,340500,', '4', '00000034,00000000,00000004,', '1', '2', null, '雨山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340521', '340500', '0,340000,340500,', '21', '00000034,00000000,00000021,', '1', '2', null, '当涂县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340600', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '淮北市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340602', '340600', '0,340000,340600,', '2', '00000034,00000000,00000002,', '1', '2', null, '杜集区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340603', '340600', '0,340000,340600,', '3', '00000034,00000000,00000003,', '1', '2', null, '相山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340604', '340600', '0,340000,340600,', '4', '00000034,00000000,00000004,', '1', '2', null, '烈山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340621', '340600', '0,340000,340600,', '21', '00000034,00000000,00000021,', '1', '2', null, '濉溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340700', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '铜陵市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340702', '340700', '0,340000,340700,', '2', '00000034,00000000,00000002,', '1', '2', null, '铜官山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340703', '340700', '0,340000,340700,', '3', '00000034,00000000,00000003,', '1', '2', null, '狮子山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340711', '340700', '0,340000,340700,', '11', '00000034,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340721', '340700', '0,340000,340700,', '21', '00000034,00000000,00000021,', '1', '2', null, '铜陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340800', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '安庆市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340802', '340800', '0,340000,340800,', '2', '00000034,00000000,00000002,', '1', '2', null, '迎江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340803', '340800', '0,340000,340800,', '3', '00000034,00000000,00000003,', '1', '2', null, '大观区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340811', '340800', '0,340000,340800,', '11', '00000034,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340822', '340800', '0,340000,340800,', '22', '00000034,00000000,00000022,', '1', '2', null, '怀宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340823', '340800', '0,340000,340800,', '23', '00000034,00000000,00000023,', '1', '2', null, '枞阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340824', '340800', '0,340000,340800,', '24', '00000034,00000000,00000024,', '1', '2', null, '潜山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340825', '340800', '0,340000,340800,', '25', '00000034,00000000,00000025,', '1', '2', null, '太湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340826', '340800', '0,340000,340800,', '26', '00000034,00000000,00000026,', '1', '2', null, '宿松县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340827', '340800', '0,340000,340800,', '27', '00000034,00000000,00000027,', '1', '2', null, '望江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340828', '340800', '0,340000,340800,', '28', '00000034,00000000,00000028,', '1', '2', null, '岳西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('340881', '340800', '0,340000,340800,', '81', '00000034,00000000,00000081,', '1', '2', null, '桐城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341000', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '黄山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341002', '341000', '0,340000,341000,', '2', '00000034,00000000,00000002,', '1', '2', null, '屯溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341003', '341000', '0,340000,341000,', '3', '00000034,00000000,00000003,', '1', '2', null, '黄山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341004', '341000', '0,340000,341000,', '4', '00000034,00000000,00000004,', '1', '2', null, '徽州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341021', '341000', '0,340000,341000,', '21', '00000034,00000000,00000021,', '1', '2', null, '歙　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341022', '341000', '0,340000,341000,', '22', '00000034,00000000,00000022,', '1', '2', null, '休宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341023', '341000', '0,340000,341000,', '23', '00000034,00000000,00000023,', '1', '2', null, '黟　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341024', '341000', '0,340000,341000,', '24', '00000034,00000000,00000024,', '1', '2', null, '祁门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341100', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '滁州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341102', '341100', '0,340000,341100,', '2', '00000034,00000000,00000002,', '1', '2', null, '琅琊区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341103', '341100', '0,340000,341100,', '3', '00000034,00000000,00000003,', '1', '2', null, '南谯区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341122', '341100', '0,340000,341100,', '22', '00000034,00000000,00000022,', '1', '2', null, '来安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341124', '341100', '0,340000,341100,', '24', '00000034,00000000,00000024,', '1', '2', null, '全椒县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341125', '341100', '0,340000,341100,', '25', '00000034,00000000,00000025,', '1', '2', null, '定远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341126', '341100', '0,340000,341100,', '26', '00000034,00000000,00000026,', '1', '2', null, '凤阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341181', '341100', '0,340000,341100,', '81', '00000034,00000000,00000081,', '1', '2', null, '天长市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341182', '341100', '0,340000,341100,', '82', '00000034,00000000,00000082,', '1', '2', null, '明光市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341200', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '阜阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341202', '341200', '0,340000,341200,', '2', '00000034,00000000,00000002,', '1', '2', null, '颍州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341203', '341200', '0,340000,341200,', '3', '00000034,00000000,00000003,', '1', '2', null, '颍东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341204', '341200', '0,340000,341200,', '4', '00000034,00000000,00000004,', '1', '2', null, '颍泉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341221', '341200', '0,340000,341200,', '21', '00000034,00000000,00000021,', '1', '2', null, '临泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341222', '341200', '0,340000,341200,', '22', '00000034,00000000,00000022,', '1', '2', null, '太和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341225', '341200', '0,340000,341200,', '25', '00000034,00000000,00000025,', '1', '2', null, '阜南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341226', '341200', '0,340000,341200,', '26', '00000034,00000000,00000026,', '1', '2', null, '颍上县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341282', '341200', '0,340000,341200,', '82', '00000034,00000000,00000082,', '1', '2', null, '界首市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341300', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '宿州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341302', '341300', '0,340000,341300,', '2', '00000034,00000000,00000002,', '1', '2', null, '墉桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341321', '341300', '0,340000,341300,', '21', '00000034,00000000,00000021,', '1', '2', null, '砀山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341322', '341300', '0,340000,341300,', '22', '00000034,00000000,00000022,', '1', '2', null, '萧　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341323', '341300', '0,340000,341300,', '23', '00000034,00000000,00000023,', '1', '2', null, '灵璧县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341324', '341300', '0,340000,341300,', '24', '00000034,00000000,00000024,', '1', '2', null, '泗　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341400', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '巢湖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341402', '341400', '0,340000,341400,', '2', '00000034,00000000,00000002,', '1', '2', null, '居巢区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341421', '341400', '0,340000,341400,', '21', '00000034,00000000,00000021,', '1', '2', null, '庐江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341422', '341400', '0,340000,341400,', '22', '00000034,00000000,00000022,', '1', '2', null, '无为县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341423', '341400', '0,340000,341400,', '23', '00000034,00000000,00000023,', '1', '2', null, '含山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341424', '341400', '0,340000,341400,', '24', '00000034,00000000,00000024,', '1', '2', null, '和　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341500', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '六安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341502', '341500', '0,340000,341500,', '2', '00000034,00000000,00000002,', '1', '2', null, '金安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341503', '341500', '0,340000,341500,', '3', '00000034,00000000,00000003,', '1', '2', null, '裕安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341521', '341500', '0,340000,341500,', '21', '00000034,00000000,00000021,', '1', '2', null, '寿　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341522', '341500', '0,340000,341500,', '22', '00000034,00000000,00000022,', '1', '2', null, '霍邱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341523', '341500', '0,340000,341500,', '23', '00000034,00000000,00000023,', '1', '2', null, '舒城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341524', '341500', '0,340000,341500,', '24', '00000034,00000000,00000024,', '1', '2', null, '金寨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341525', '341500', '0,340000,341500,', '25', '00000034,00000000,00000025,', '1', '2', null, '霍山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341600', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '亳州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341602', '341600', '0,340000,341600,', '2', '00000034,00000000,00000002,', '1', '2', null, '谯城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341621', '341600', '0,340000,341600,', '21', '00000034,00000000,00000021,', '1', '2', null, '涡阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341622', '341600', '0,340000,341600,', '22', '00000034,00000000,00000022,', '1', '2', null, '蒙城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341623', '341600', '0,340000,341600,', '23', '00000034,00000000,00000023,', '1', '2', null, '利辛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341700', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '池州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341702', '341700', '0,340000,341700,', '2', '00000034,00000000,00000002,', '1', '2', null, '贵池区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341721', '341700', '0,340000,341700,', '21', '00000034,00000000,00000021,', '1', '2', null, '东至县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341722', '341700', '0,340000,341700,', '22', '00000034,00000000,00000022,', '1', '2', null, '石台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341723', '341700', '0,340000,341700,', '23', '00000034,00000000,00000023,', '1', '2', null, '青阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341800', '340000', '0,340000,', '0', '00000034,00000000,', '0', '1', null, '宣城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341802', '341800', '0,340000,341800,', '2', '00000034,00000000,00000002,', '1', '2', null, '宣州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341821', '341800', '0,340000,341800,', '21', '00000034,00000000,00000021,', '1', '2', null, '郎溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341822', '341800', '0,340000,341800,', '22', '00000034,00000000,00000022,', '1', '2', null, '广德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341823', '341800', '0,340000,341800,', '23', '00000034,00000000,00000023,', '1', '2', null, '泾　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341824', '341800', '0,340000,341800,', '24', '00000034,00000000,00000024,', '1', '2', null, '绩溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341825', '341800', '0,340000,341800,', '25', '00000034,00000000,00000025,', '1', '2', null, '旌德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('341881', '341800', '0,340000,341800,', '81', '00000034,00000000,00000081,', '1', '2', null, '宁国市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350000', '0', '0,', '35', '00000035,', '0', '0', null, '福建省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350100', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '福州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350102', '350100', '0,350000,350100,', '2', '00000035,00000000,00000002,', '1', '2', null, '鼓楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350103', '350100', '0,350000,350100,', '3', '00000035,00000000,00000003,', '1', '2', null, '台江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350104', '350100', '0,350000,350100,', '4', '00000035,00000000,00000004,', '1', '2', null, '仓山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350105', '350100', '0,350000,350100,', '5', '00000035,00000000,00000005,', '1', '2', null, '马尾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350111', '350100', '0,350000,350100,', '11', '00000035,00000000,00000011,', '1', '2', null, '晋安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350121', '350100', '0,350000,350100,', '21', '00000035,00000000,00000021,', '1', '2', null, '闽侯县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350122', '350100', '0,350000,350100,', '22', '00000035,00000000,00000022,', '1', '2', null, '连江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350123', '350100', '0,350000,350100,', '23', '00000035,00000000,00000023,', '1', '2', null, '罗源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350124', '350100', '0,350000,350100,', '24', '00000035,00000000,00000024,', '1', '2', null, '闽清县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350125', '350100', '0,350000,350100,', '25', '00000035,00000000,00000025,', '1', '2', null, '永泰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350128', '350100', '0,350000,350100,', '28', '00000035,00000000,00000028,', '1', '2', null, '平潭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350181', '350100', '0,350000,350100,', '81', '00000035,00000000,00000081,', '1', '2', null, '福清市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350182', '350100', '0,350000,350100,', '82', '00000035,00000000,00000082,', '1', '2', null, '长乐市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350200', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '厦门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350203', '350200', '0,350000,350200,', '3', '00000035,00000000,00000003,', '1', '2', null, '思明区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350205', '350200', '0,350000,350200,', '5', '00000035,00000000,00000005,', '1', '2', null, '海沧区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350206', '350200', '0,350000,350200,', '6', '00000035,00000000,00000006,', '1', '2', null, '湖里区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350211', '350200', '0,350000,350200,', '11', '00000035,00000000,00000011,', '1', '2', null, '集美区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350212', '350200', '0,350000,350200,', '12', '00000035,00000000,00000012,', '1', '2', null, '同安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350213', '350200', '0,350000,350200,', '13', '00000035,00000000,00000013,', '1', '2', null, '翔安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350300', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '莆田市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350302', '350300', '0,350000,350300,', '2', '00000035,00000000,00000002,', '1', '2', null, '城厢区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350303', '350300', '0,350000,350300,', '3', '00000035,00000000,00000003,', '1', '2', null, '涵江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350304', '350300', '0,350000,350300,', '4', '00000035,00000000,00000004,', '1', '2', null, '荔城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350305', '350300', '0,350000,350300,', '5', '00000035,00000000,00000005,', '1', '2', null, '秀屿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350322', '350300', '0,350000,350300,', '22', '00000035,00000000,00000022,', '1', '2', null, '仙游县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350400', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '三明市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350402', '350400', '0,350000,350400,', '2', '00000035,00000000,00000002,', '1', '2', null, '梅列区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350403', '350400', '0,350000,350400,', '3', '00000035,00000000,00000003,', '1', '2', null, '三元区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350421', '350400', '0,350000,350400,', '21', '00000035,00000000,00000021,', '1', '2', null, '明溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350423', '350400', '0,350000,350400,', '23', '00000035,00000000,00000023,', '1', '2', null, '清流县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350424', '350400', '0,350000,350400,', '24', '00000035,00000000,00000024,', '1', '2', null, '宁化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350425', '350400', '0,350000,350400,', '25', '00000035,00000000,00000025,', '1', '2', null, '大田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350426', '350400', '0,350000,350400,', '26', '00000035,00000000,00000026,', '1', '2', null, '尤溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350427', '350400', '0,350000,350400,', '27', '00000035,00000000,00000027,', '1', '2', null, '沙　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350428', '350400', '0,350000,350400,', '28', '00000035,00000000,00000028,', '1', '2', null, '将乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350429', '350400', '0,350000,350400,', '29', '00000035,00000000,00000029,', '1', '2', null, '泰宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350430', '350400', '0,350000,350400,', '30', '00000035,00000000,00000030,', '1', '2', null, '建宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350481', '350400', '0,350000,350400,', '81', '00000035,00000000,00000081,', '1', '2', null, '永安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350500', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '泉州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350502', '350500', '0,350000,350500,', '2', '00000035,00000000,00000002,', '1', '2', null, '鲤城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350503', '350500', '0,350000,350500,', '3', '00000035,00000000,00000003,', '1', '2', null, '丰泽区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350504', '350500', '0,350000,350500,', '4', '00000035,00000000,00000004,', '1', '2', null, '洛江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350505', '350500', '0,350000,350500,', '5', '00000035,00000000,00000005,', '1', '2', null, '泉港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350521', '350500', '0,350000,350500,', '21', '00000035,00000000,00000021,', '1', '2', null, '惠安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350524', '350500', '0,350000,350500,', '24', '00000035,00000000,00000024,', '1', '2', null, '安溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350525', '350500', '0,350000,350500,', '25', '00000035,00000000,00000025,', '1', '2', null, '永春县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350526', '350500', '0,350000,350500,', '26', '00000035,00000000,00000026,', '1', '2', null, '德化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350527', '350500', '0,350000,350500,', '27', '00000035,00000000,00000027,', '1', '2', null, '金门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350581', '350500', '0,350000,350500,', '81', '00000035,00000000,00000081,', '1', '2', null, '石狮市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350582', '350500', '0,350000,350500,', '82', '00000035,00000000,00000082,', '1', '2', null, '晋江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350583', '350500', '0,350000,350500,', '83', '00000035,00000000,00000083,', '1', '2', null, '南安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350600', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '漳州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350602', '350600', '0,350000,350600,', '2', '00000035,00000000,00000002,', '1', '2', null, '芗城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350603', '350600', '0,350000,350600,', '3', '00000035,00000000,00000003,', '1', '2', null, '龙文区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350622', '350600', '0,350000,350600,', '22', '00000035,00000000,00000022,', '1', '2', null, '云霄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350623', '350600', '0,350000,350600,', '23', '00000035,00000000,00000023,', '1', '2', null, '漳浦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350624', '350600', '0,350000,350600,', '24', '00000035,00000000,00000024,', '1', '2', null, '诏安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350625', '350600', '0,350000,350600,', '25', '00000035,00000000,00000025,', '1', '2', null, '长泰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350626', '350600', '0,350000,350600,', '26', '00000035,00000000,00000026,', '1', '2', null, '东山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350627', '350600', '0,350000,350600,', '27', '00000035,00000000,00000027,', '1', '2', null, '南靖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350628', '350600', '0,350000,350600,', '28', '00000035,00000000,00000028,', '1', '2', null, '平和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350629', '350600', '0,350000,350600,', '29', '00000035,00000000,00000029,', '1', '2', null, '华安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350681', '350600', '0,350000,350600,', '81', '00000035,00000000,00000081,', '1', '2', null, '龙海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350700', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '南平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350702', '350700', '0,350000,350700,', '2', '00000035,00000000,00000002,', '1', '2', null, '延平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350721', '350700', '0,350000,350700,', '21', '00000035,00000000,00000021,', '1', '2', null, '顺昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350722', '350700', '0,350000,350700,', '22', '00000035,00000000,00000022,', '1', '2', null, '浦城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350723', '350700', '0,350000,350700,', '23', '00000035,00000000,00000023,', '1', '2', null, '光泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350724', '350700', '0,350000,350700,', '24', '00000035,00000000,00000024,', '1', '2', null, '松溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350725', '350700', '0,350000,350700,', '25', '00000035,00000000,00000025,', '1', '2', null, '政和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350781', '350700', '0,350000,350700,', '81', '00000035,00000000,00000081,', '1', '2', null, '邵武市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350782', '350700', '0,350000,350700,', '82', '00000035,00000000,00000082,', '1', '2', null, '武夷山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350783', '350700', '0,350000,350700,', '83', '00000035,00000000,00000083,', '1', '2', null, '建瓯市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350784', '350700', '0,350000,350700,', '84', '00000035,00000000,00000084,', '1', '2', null, '建阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350800', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '龙岩市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350802', '350800', '0,350000,350800,', '2', '00000035,00000000,00000002,', '1', '2', null, '新罗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350821', '350800', '0,350000,350800,', '21', '00000035,00000000,00000021,', '1', '2', null, '长汀县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350822', '350800', '0,350000,350800,', '22', '00000035,00000000,00000022,', '1', '2', null, '永定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350823', '350800', '0,350000,350800,', '23', '00000035,00000000,00000023,', '1', '2', null, '上杭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350824', '350800', '0,350000,350800,', '24', '00000035,00000000,00000024,', '1', '2', null, '武平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350825', '350800', '0,350000,350800,', '25', '00000035,00000000,00000025,', '1', '2', null, '连城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350881', '350800', '0,350000,350800,', '81', '00000035,00000000,00000081,', '1', '2', null, '漳平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350900', '350000', '0,350000,', '0', '00000035,00000000,', '0', '1', null, '宁德市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350902', '350900', '0,350000,350900,', '2', '00000035,00000000,00000002,', '1', '2', null, '蕉城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350921', '350900', '0,350000,350900,', '21', '00000035,00000000,00000021,', '1', '2', null, '霞浦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350922', '350900', '0,350000,350900,', '22', '00000035,00000000,00000022,', '1', '2', null, '古田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350923', '350900', '0,350000,350900,', '23', '00000035,00000000,00000023,', '1', '2', null, '屏南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350924', '350900', '0,350000,350900,', '24', '00000035,00000000,00000024,', '1', '2', null, '寿宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350925', '350900', '0,350000,350900,', '25', '00000035,00000000,00000025,', '1', '2', null, '周宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350926', '350900', '0,350000,350900,', '26', '00000035,00000000,00000026,', '1', '2', null, '柘荣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350981', '350900', '0,350000,350900,', '81', '00000035,00000000,00000081,', '1', '2', null, '福安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('350982', '350900', '0,350000,350900,', '82', '00000035,00000000,00000082,', '1', '2', null, '福鼎市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360000', '0', '0,', '36', '00000036,', '0', '0', null, '江西省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360100', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '南昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360102', '360100', '0,360000,360100,', '2', '00000036,00000000,00000002,', '1', '2', null, '东湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360103', '360100', '0,360000,360100,', '3', '00000036,00000000,00000003,', '1', '2', null, '西湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360104', '360100', '0,360000,360100,', '4', '00000036,00000000,00000004,', '1', '2', null, '青云谱区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360105', '360100', '0,360000,360100,', '5', '00000036,00000000,00000005,', '1', '2', null, '湾里区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360111', '360100', '0,360000,360100,', '11', '00000036,00000000,00000011,', '1', '2', null, '青山湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360121', '360100', '0,360000,360100,', '21', '00000036,00000000,00000021,', '1', '2', null, '南昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360122', '360100', '0,360000,360100,', '22', '00000036,00000000,00000022,', '1', '2', null, '新建县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360123', '360100', '0,360000,360100,', '23', '00000036,00000000,00000023,', '1', '2', null, '安义县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360124', '360100', '0,360000,360100,', '24', '00000036,00000000,00000024,', '1', '2', null, '进贤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360200', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '景德镇市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360202', '360200', '0,360000,360200,', '2', '00000036,00000000,00000002,', '1', '2', null, '昌江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360203', '360200', '0,360000,360200,', '3', '00000036,00000000,00000003,', '1', '2', null, '珠山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360222', '360200', '0,360000,360200,', '22', '00000036,00000000,00000022,', '1', '2', null, '浮梁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360281', '360200', '0,360000,360200,', '81', '00000036,00000000,00000081,', '1', '2', null, '乐平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360300', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '萍乡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360302', '360300', '0,360000,360300,', '2', '00000036,00000000,00000002,', '1', '2', null, '安源区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360313', '360300', '0,360000,360300,', '13', '00000036,00000000,00000013,', '1', '2', null, '湘东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360321', '360300', '0,360000,360300,', '21', '00000036,00000000,00000021,', '1', '2', null, '莲花县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360322', '360300', '0,360000,360300,', '22', '00000036,00000000,00000022,', '1', '2', null, '上栗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360323', '360300', '0,360000,360300,', '23', '00000036,00000000,00000023,', '1', '2', null, '芦溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360400', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '九江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360402', '360400', '0,360000,360400,', '2', '00000036,00000000,00000002,', '1', '2', null, '庐山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360403', '360400', '0,360000,360400,', '3', '00000036,00000000,00000003,', '1', '2', null, '浔阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360421', '360400', '0,360000,360400,', '21', '00000036,00000000,00000021,', '1', '2', null, '九江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360423', '360400', '0,360000,360400,', '23', '00000036,00000000,00000023,', '1', '2', null, '武宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360424', '360400', '0,360000,360400,', '24', '00000036,00000000,00000024,', '1', '2', null, '修水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360425', '360400', '0,360000,360400,', '25', '00000036,00000000,00000025,', '1', '2', null, '永修县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360426', '360400', '0,360000,360400,', '26', '00000036,00000000,00000026,', '1', '2', null, '德安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360427', '360400', '0,360000,360400,', '27', '00000036,00000000,00000027,', '1', '2', null, '星子县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360428', '360400', '0,360000,360400,', '28', '00000036,00000000,00000028,', '1', '2', null, '都昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360429', '360400', '0,360000,360400,', '29', '00000036,00000000,00000029,', '1', '2', null, '湖口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360430', '360400', '0,360000,360400,', '30', '00000036,00000000,00000030,', '1', '2', null, '彭泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360481', '360400', '0,360000,360400,', '81', '00000036,00000000,00000081,', '1', '2', null, '瑞昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360500', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '新余市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360502', '360500', '0,360000,360500,', '2', '00000036,00000000,00000002,', '1', '2', null, '渝水区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360521', '360500', '0,360000,360500,', '21', '00000036,00000000,00000021,', '1', '2', null, '分宜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360600', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '鹰潭市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360602', '360600', '0,360000,360600,', '2', '00000036,00000000,00000002,', '1', '2', null, '月湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360622', '360600', '0,360000,360600,', '22', '00000036,00000000,00000022,', '1', '2', null, '余江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360681', '360600', '0,360000,360600,', '81', '00000036,00000000,00000081,', '1', '2', null, '贵溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360700', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '赣州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360702', '360700', '0,360000,360700,', '2', '00000036,00000000,00000002,', '1', '2', null, '章贡区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360721', '360700', '0,360000,360700,', '21', '00000036,00000000,00000021,', '1', '2', null, '赣　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360722', '360700', '0,360000,360700,', '22', '00000036,00000000,00000022,', '1', '2', null, '信丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360723', '360700', '0,360000,360700,', '23', '00000036,00000000,00000023,', '1', '2', null, '大余县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360724', '360700', '0,360000,360700,', '24', '00000036,00000000,00000024,', '1', '2', null, '上犹县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360725', '360700', '0,360000,360700,', '25', '00000036,00000000,00000025,', '1', '2', null, '崇义县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360726', '360700', '0,360000,360700,', '26', '00000036,00000000,00000026,', '1', '2', null, '安远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360727', '360700', '0,360000,360700,', '27', '00000036,00000000,00000027,', '1', '2', null, '龙南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360728', '360700', '0,360000,360700,', '28', '00000036,00000000,00000028,', '1', '2', null, '定南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360729', '360700', '0,360000,360700,', '29', '00000036,00000000,00000029,', '1', '2', null, '全南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360730', '360700', '0,360000,360700,', '30', '00000036,00000000,00000030,', '1', '2', null, '宁都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360731', '360700', '0,360000,360700,', '31', '00000036,00000000,00000031,', '1', '2', null, '于都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360732', '360700', '0,360000,360700,', '32', '00000036,00000000,00000032,', '1', '2', null, '兴国县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360733', '360700', '0,360000,360700,', '33', '00000036,00000000,00000033,', '1', '2', null, '会昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360734', '360700', '0,360000,360700,', '34', '00000036,00000000,00000034,', '1', '2', null, '寻乌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360735', '360700', '0,360000,360700,', '35', '00000036,00000000,00000035,', '1', '2', null, '石城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360781', '360700', '0,360000,360700,', '81', '00000036,00000000,00000081,', '1', '2', null, '瑞金市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360782', '360700', '0,360000,360700,', '82', '00000036,00000000,00000082,', '1', '2', null, '南康市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360800', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '吉安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360802', '360800', '0,360000,360800,', '2', '00000036,00000000,00000002,', '1', '2', null, '吉州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360803', '360800', '0,360000,360800,', '3', '00000036,00000000,00000003,', '1', '2', null, '青原区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360821', '360800', '0,360000,360800,', '21', '00000036,00000000,00000021,', '1', '2', null, '吉安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360822', '360800', '0,360000,360800,', '22', '00000036,00000000,00000022,', '1', '2', null, '吉水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360823', '360800', '0,360000,360800,', '23', '00000036,00000000,00000023,', '1', '2', null, '峡江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360824', '360800', '0,360000,360800,', '24', '00000036,00000000,00000024,', '1', '2', null, '新干县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360825', '360800', '0,360000,360800,', '25', '00000036,00000000,00000025,', '1', '2', null, '永丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360826', '360800', '0,360000,360800,', '26', '00000036,00000000,00000026,', '1', '2', null, '泰和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360827', '360800', '0,360000,360800,', '27', '00000036,00000000,00000027,', '1', '2', null, '遂川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360828', '360800', '0,360000,360800,', '28', '00000036,00000000,00000028,', '1', '2', null, '万安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360829', '360800', '0,360000,360800,', '29', '00000036,00000000,00000029,', '1', '2', null, '安福县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360830', '360800', '0,360000,360800,', '30', '00000036,00000000,00000030,', '1', '2', null, '永新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360881', '360800', '0,360000,360800,', '81', '00000036,00000000,00000081,', '1', '2', null, '井冈山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360900', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '宜春市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360902', '360900', '0,360000,360900,', '2', '00000036,00000000,00000002,', '1', '2', null, '袁州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360921', '360900', '0,360000,360900,', '21', '00000036,00000000,00000021,', '1', '2', null, '奉新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360922', '360900', '0,360000,360900,', '22', '00000036,00000000,00000022,', '1', '2', null, '万载县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360923', '360900', '0,360000,360900,', '23', '00000036,00000000,00000023,', '1', '2', null, '上高县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360924', '360900', '0,360000,360900,', '24', '00000036,00000000,00000024,', '1', '2', null, '宜丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360925', '360900', '0,360000,360900,', '25', '00000036,00000000,00000025,', '1', '2', null, '靖安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360926', '360900', '0,360000,360900,', '26', '00000036,00000000,00000026,', '1', '2', null, '铜鼓县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360981', '360900', '0,360000,360900,', '81', '00000036,00000000,00000081,', '1', '2', null, '丰城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360982', '360900', '0,360000,360900,', '82', '00000036,00000000,00000082,', '1', '2', null, '樟树市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('360983', '360900', '0,360000,360900,', '83', '00000036,00000000,00000083,', '1', '2', null, '高安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361000', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '抚州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361002', '361000', '0,360000,361000,', '2', '00000036,00000000,00000002,', '1', '2', null, '临川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361021', '361000', '0,360000,361000,', '21', '00000036,00000000,00000021,', '1', '2', null, '南城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361022', '361000', '0,360000,361000,', '22', '00000036,00000000,00000022,', '1', '2', null, '黎川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361023', '361000', '0,360000,361000,', '23', '00000036,00000000,00000023,', '1', '2', null, '南丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361024', '361000', '0,360000,361000,', '24', '00000036,00000000,00000024,', '1', '2', null, '崇仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361025', '361000', '0,360000,361000,', '25', '00000036,00000000,00000025,', '1', '2', null, '乐安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361026', '361000', '0,360000,361000,', '26', '00000036,00000000,00000026,', '1', '2', null, '宜黄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361027', '361000', '0,360000,361000,', '27', '00000036,00000000,00000027,', '1', '2', null, '金溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361028', '361000', '0,360000,361000,', '28', '00000036,00000000,00000028,', '1', '2', null, '资溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361029', '361000', '0,360000,361000,', '29', '00000036,00000000,00000029,', '1', '2', null, '东乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361030', '361000', '0,360000,361000,', '30', '00000036,00000000,00000030,', '1', '2', null, '广昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361100', '360000', '0,360000,', '0', '00000036,00000000,', '0', '1', null, '上饶市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361102', '361100', '0,360000,361100,', '2', '00000036,00000000,00000002,', '1', '2', null, '信州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361121', '361100', '0,360000,361100,', '21', '00000036,00000000,00000021,', '1', '2', null, '上饶县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361122', '361100', '0,360000,361100,', '22', '00000036,00000000,00000022,', '1', '2', null, '广丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361123', '361100', '0,360000,361100,', '23', '00000036,00000000,00000023,', '1', '2', null, '玉山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361124', '361100', '0,360000,361100,', '24', '00000036,00000000,00000024,', '1', '2', null, '铅山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361125', '361100', '0,360000,361100,', '25', '00000036,00000000,00000025,', '1', '2', null, '横峰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361126', '361100', '0,360000,361100,', '26', '00000036,00000000,00000026,', '1', '2', null, '弋阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361127', '361100', '0,360000,361100,', '27', '00000036,00000000,00000027,', '1', '2', null, '余干县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361128', '361100', '0,360000,361100,', '28', '00000036,00000000,00000028,', '1', '2', null, '鄱阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361129', '361100', '0,360000,361100,', '29', '00000036,00000000,00000029,', '1', '2', null, '万年县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361130', '361100', '0,360000,361100,', '30', '00000036,00000000,00000030,', '1', '2', null, '婺源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('361181', '361100', '0,360000,361100,', '81', '00000036,00000000,00000081,', '1', '2', null, '德兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370000', '0', '0,', '37', '00000037,', '0', '0', null, '山东省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370100', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '济南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370102', '370100', '0,370000,370100,', '2', '00000037,00000000,00000002,', '1', '2', null, '历下区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370103', '370100', '0,370000,370100,', '3', '00000037,00000000,00000003,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370104', '370100', '0,370000,370100,', '4', '00000037,00000000,00000004,', '1', '2', null, '槐荫区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370105', '370100', '0,370000,370100,', '5', '00000037,00000000,00000005,', '1', '2', null, '天桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370112', '370100', '0,370000,370100,', '12', '00000037,00000000,00000012,', '1', '2', null, '历城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370113', '370100', '0,370000,370100,', '13', '00000037,00000000,00000013,', '1', '2', null, '长清区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370124', '370100', '0,370000,370100,', '24', '00000037,00000000,00000024,', '1', '2', null, '平阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370125', '370100', '0,370000,370100,', '25', '00000037,00000000,00000025,', '1', '2', null, '济阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370126', '370100', '0,370000,370100,', '26', '00000037,00000000,00000026,', '1', '2', null, '商河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370181', '370100', '0,370000,370100,', '81', '00000037,00000000,00000081,', '1', '2', null, '章丘市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370200', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '青岛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370202', '370200', '0,370000,370200,', '2', '00000037,00000000,00000002,', '1', '2', null, '市南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370203', '370200', '0,370000,370200,', '3', '00000037,00000000,00000003,', '1', '2', null, '市北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370205', '370200', '0,370000,370200,', '5', '00000037,00000000,00000005,', '1', '2', null, '四方区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370211', '370200', '0,370000,370200,', '11', '00000037,00000000,00000011,', '1', '2', null, '黄岛区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370212', '370200', '0,370000,370200,', '12', '00000037,00000000,00000012,', '1', '2', null, '崂山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370213', '370200', '0,370000,370200,', '13', '00000037,00000000,00000013,', '1', '2', null, '李沧区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370214', '370200', '0,370000,370200,', '14', '00000037,00000000,00000014,', '1', '2', null, '城阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370281', '370200', '0,370000,370200,', '81', '00000037,00000000,00000081,', '1', '2', null, '胶州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370282', '370200', '0,370000,370200,', '82', '00000037,00000000,00000082,', '1', '2', null, '即墨市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370283', '370200', '0,370000,370200,', '83', '00000037,00000000,00000083,', '1', '2', null, '平度市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370284', '370200', '0,370000,370200,', '84', '00000037,00000000,00000084,', '1', '2', null, '胶南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370285', '370200', '0,370000,370200,', '85', '00000037,00000000,00000085,', '1', '2', null, '莱西市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370300', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '淄博市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370302', '370300', '0,370000,370300,', '2', '00000037,00000000,00000002,', '1', '2', null, '淄川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370303', '370300', '0,370000,370300,', '3', '00000037,00000000,00000003,', '1', '2', null, '张店区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370304', '370300', '0,370000,370300,', '4', '00000037,00000000,00000004,', '1', '2', null, '博山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370305', '370300', '0,370000,370300,', '5', '00000037,00000000,00000005,', '1', '2', null, '临淄区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370306', '370300', '0,370000,370300,', '6', '00000037,00000000,00000006,', '1', '2', null, '周村区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370321', '370300', '0,370000,370300,', '21', '00000037,00000000,00000021,', '1', '2', null, '桓台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370322', '370300', '0,370000,370300,', '22', '00000037,00000000,00000022,', '1', '2', null, '高青县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370323', '370300', '0,370000,370300,', '23', '00000037,00000000,00000023,', '1', '2', null, '沂源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370400', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '枣庄市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370402', '370400', '0,370000,370400,', '2', '00000037,00000000,00000002,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370403', '370400', '0,370000,370400,', '3', '00000037,00000000,00000003,', '1', '2', null, '薛城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370404', '370400', '0,370000,370400,', '4', '00000037,00000000,00000004,', '1', '2', null, '峄城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370405', '370400', '0,370000,370400,', '5', '00000037,00000000,00000005,', '1', '2', null, '台儿庄区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370406', '370400', '0,370000,370400,', '6', '00000037,00000000,00000006,', '1', '2', null, '山亭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370481', '370400', '0,370000,370400,', '81', '00000037,00000000,00000081,', '1', '2', null, '滕州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370500', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '东营市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370502', '370500', '0,370000,370500,', '2', '00000037,00000000,00000002,', '1', '2', null, '东营区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370503', '370500', '0,370000,370500,', '3', '00000037,00000000,00000003,', '1', '2', null, '河口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370521', '370500', '0,370000,370500,', '21', '00000037,00000000,00000021,', '1', '2', null, '垦利县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370522', '370500', '0,370000,370500,', '22', '00000037,00000000,00000022,', '1', '2', null, '利津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370523', '370500', '0,370000,370500,', '23', '00000037,00000000,00000023,', '1', '2', null, '广饶县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370600', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '烟台市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370602', '370600', '0,370000,370600,', '2', '00000037,00000000,00000002,', '1', '2', null, '芝罘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370611', '370600', '0,370000,370600,', '11', '00000037,00000000,00000011,', '1', '2', null, '福山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370612', '370600', '0,370000,370600,', '12', '00000037,00000000,00000012,', '1', '2', null, '牟平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370613', '370600', '0,370000,370600,', '13', '00000037,00000000,00000013,', '1', '2', null, '莱山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370634', '370600', '0,370000,370600,', '34', '00000037,00000000,00000034,', '1', '2', null, '长岛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370681', '370600', '0,370000,370600,', '81', '00000037,00000000,00000081,', '1', '2', null, '龙口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370682', '370600', '0,370000,370600,', '82', '00000037,00000000,00000082,', '1', '2', null, '莱阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370683', '370600', '0,370000,370600,', '83', '00000037,00000000,00000083,', '1', '2', null, '莱州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370684', '370600', '0,370000,370600,', '84', '00000037,00000000,00000084,', '1', '2', null, '蓬莱市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370685', '370600', '0,370000,370600,', '85', '00000037,00000000,00000085,', '1', '2', null, '招远市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370686', '370600', '0,370000,370600,', '86', '00000037,00000000,00000086,', '1', '2', null, '栖霞市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370687', '370600', '0,370000,370600,', '87', '00000037,00000000,00000087,', '1', '2', null, '海阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370700', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '潍坊市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370702', '370700', '0,370000,370700,', '2', '00000037,00000000,00000002,', '1', '2', null, '潍城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370703', '370700', '0,370000,370700,', '3', '00000037,00000000,00000003,', '1', '2', null, '寒亭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370704', '370700', '0,370000,370700,', '4', '00000037,00000000,00000004,', '1', '2', null, '坊子区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370705', '370700', '0,370000,370700,', '5', '00000037,00000000,00000005,', '1', '2', null, '奎文区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370724', '370700', '0,370000,370700,', '24', '00000037,00000000,00000024,', '1', '2', null, '临朐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370725', '370700', '0,370000,370700,', '25', '00000037,00000000,00000025,', '1', '2', null, '昌乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370781', '370700', '0,370000,370700,', '81', '00000037,00000000,00000081,', '1', '2', null, '青州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370782', '370700', '0,370000,370700,', '82', '00000037,00000000,00000082,', '1', '2', null, '诸城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370783', '370700', '0,370000,370700,', '83', '00000037,00000000,00000083,', '1', '2', null, '寿光市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370784', '370700', '0,370000,370700,', '84', '00000037,00000000,00000084,', '1', '2', null, '安丘市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370785', '370700', '0,370000,370700,', '85', '00000037,00000000,00000085,', '1', '2', null, '高密市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370786', '370700', '0,370000,370700,', '86', '00000037,00000000,00000086,', '1', '2', null, '昌邑市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370800', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '济宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370802', '370800', '0,370000,370800,', '2', '00000037,00000000,00000002,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370811', '370800', '0,370000,370800,', '11', '00000037,00000000,00000011,', '1', '2', null, '任城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370826', '370800', '0,370000,370800,', '26', '00000037,00000000,00000026,', '1', '2', null, '微山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370827', '370800', '0,370000,370800,', '27', '00000037,00000000,00000027,', '1', '2', null, '鱼台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370828', '370800', '0,370000,370800,', '28', '00000037,00000000,00000028,', '1', '2', null, '金乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370829', '370800', '0,370000,370800,', '29', '00000037,00000000,00000029,', '1', '2', null, '嘉祥县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370830', '370800', '0,370000,370800,', '30', '00000037,00000000,00000030,', '1', '2', null, '汶上县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370831', '370800', '0,370000,370800,', '31', '00000037,00000000,00000031,', '1', '2', null, '泗水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370832', '370800', '0,370000,370800,', '32', '00000037,00000000,00000032,', '1', '2', null, '梁山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370881', '370800', '0,370000,370800,', '81', '00000037,00000000,00000081,', '1', '2', null, '曲阜市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370882', '370800', '0,370000,370800,', '82', '00000037,00000000,00000082,', '1', '2', null, '兖州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370883', '370800', '0,370000,370800,', '83', '00000037,00000000,00000083,', '1', '2', null, '邹城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370900', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '泰安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370902', '370900', '0,370000,370900,', '2', '00000037,00000000,00000002,', '1', '2', null, '泰山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370903', '370900', '0,370000,370900,', '3', '00000037,00000000,00000003,', '1', '2', null, '岱岳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370921', '370900', '0,370000,370900,', '21', '00000037,00000000,00000021,', '1', '2', null, '宁阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370923', '370900', '0,370000,370900,', '23', '00000037,00000000,00000023,', '1', '2', null, '东平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370982', '370900', '0,370000,370900,', '82', '00000037,00000000,00000082,', '1', '2', null, '新泰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('370983', '370900', '0,370000,370900,', '83', '00000037,00000000,00000083,', '1', '2', null, '肥城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371000', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '威海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371002', '371000', '0,370000,371000,', '2', '00000037,00000000,00000002,', '1', '2', null, '环翠区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371081', '371000', '0,370000,371000,', '81', '00000037,00000000,00000081,', '1', '2', null, '文登市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371082', '371000', '0,370000,371000,', '82', '00000037,00000000,00000082,', '1', '2', null, '荣成市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371083', '371000', '0,370000,371000,', '83', '00000037,00000000,00000083,', '1', '2', null, '乳山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371100', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '日照市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371102', '371100', '0,370000,371100,', '2', '00000037,00000000,00000002,', '1', '2', null, '东港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371103', '371100', '0,370000,371100,', '3', '00000037,00000000,00000003,', '1', '2', null, '岚山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371121', '371100', '0,370000,371100,', '21', '00000037,00000000,00000021,', '1', '2', null, '五莲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371122', '371100', '0,370000,371100,', '22', '00000037,00000000,00000022,', '1', '2', null, '莒　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371200', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '莱芜市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371202', '371200', '0,370000,371200,', '2', '00000037,00000000,00000002,', '1', '2', null, '莱城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371203', '371200', '0,370000,371200,', '3', '00000037,00000000,00000003,', '1', '2', null, '钢城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371300', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '临沂市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371302', '371300', '0,370000,371300,', '2', '00000037,00000000,00000002,', '1', '2', null, '兰山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371311', '371300', '0,370000,371300,', '11', '00000037,00000000,00000011,', '1', '2', null, '罗庄区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371312', '371300', '0,370000,371300,', '12', '00000037,00000000,00000012,', '1', '2', null, '河东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371321', '371300', '0,370000,371300,', '21', '00000037,00000000,00000021,', '1', '2', null, '沂南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371322', '371300', '0,370000,371300,', '22', '00000037,00000000,00000022,', '1', '2', null, '郯城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371323', '371300', '0,370000,371300,', '23', '00000037,00000000,00000023,', '1', '2', null, '沂水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371324', '371300', '0,370000,371300,', '24', '00000037,00000000,00000024,', '1', '2', null, '苍山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371325', '371300', '0,370000,371300,', '25', '00000037,00000000,00000025,', '1', '2', null, '费　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371326', '371300', '0,370000,371300,', '26', '00000037,00000000,00000026,', '1', '2', null, '平邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371327', '371300', '0,370000,371300,', '27', '00000037,00000000,00000027,', '1', '2', null, '莒南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371328', '371300', '0,370000,371300,', '28', '00000037,00000000,00000028,', '1', '2', null, '蒙阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371329', '371300', '0,370000,371300,', '29', '00000037,00000000,00000029,', '1', '2', null, '临沭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371400', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '德州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371402', '371400', '0,370000,371400,', '2', '00000037,00000000,00000002,', '1', '2', null, '德城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371421', '371400', '0,370000,371400,', '21', '00000037,00000000,00000021,', '1', '2', null, '陵　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371422', '371400', '0,370000,371400,', '22', '00000037,00000000,00000022,', '1', '2', null, '宁津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371423', '371400', '0,370000,371400,', '23', '00000037,00000000,00000023,', '1', '2', null, '庆云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371424', '371400', '0,370000,371400,', '24', '00000037,00000000,00000024,', '1', '2', null, '临邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371425', '371400', '0,370000,371400,', '25', '00000037,00000000,00000025,', '1', '2', null, '齐河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371426', '371400', '0,370000,371400,', '26', '00000037,00000000,00000026,', '1', '2', null, '平原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371427', '371400', '0,370000,371400,', '27', '00000037,00000000,00000027,', '1', '2', null, '夏津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371428', '371400', '0,370000,371400,', '28', '00000037,00000000,00000028,', '1', '2', null, '武城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371481', '371400', '0,370000,371400,', '81', '00000037,00000000,00000081,', '1', '2', null, '乐陵市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371482', '371400', '0,370000,371400,', '82', '00000037,00000000,00000082,', '1', '2', null, '禹城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371500', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '聊城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371502', '371500', '0,370000,371500,', '2', '00000037,00000000,00000002,', '1', '2', null, '东昌府区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371521', '371500', '0,370000,371500,', '21', '00000037,00000000,00000021,', '1', '2', null, '阳谷县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371522', '371500', '0,370000,371500,', '22', '00000037,00000000,00000022,', '1', '2', null, '莘　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371523', '371500', '0,370000,371500,', '23', '00000037,00000000,00000023,', '1', '2', null, '茌平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371524', '371500', '0,370000,371500,', '24', '00000037,00000000,00000024,', '1', '2', null, '东阿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371525', '371500', '0,370000,371500,', '25', '00000037,00000000,00000025,', '1', '2', null, '冠　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371526', '371500', '0,370000,371500,', '26', '00000037,00000000,00000026,', '1', '2', null, '高唐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371581', '371500', '0,370000,371500,', '81', '00000037,00000000,00000081,', '1', '2', null, '临清市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371600', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '滨州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371602', '371600', '0,370000,371600,', '2', '00000037,00000000,00000002,', '1', '2', null, '滨城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371621', '371600', '0,370000,371600,', '21', '00000037,00000000,00000021,', '1', '2', null, '惠民县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371622', '371600', '0,370000,371600,', '22', '00000037,00000000,00000022,', '1', '2', null, '阳信县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371623', '371600', '0,370000,371600,', '23', '00000037,00000000,00000023,', '1', '2', null, '无棣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371624', '371600', '0,370000,371600,', '24', '00000037,00000000,00000024,', '1', '2', null, '沾化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371625', '371600', '0,370000,371600,', '25', '00000037,00000000,00000025,', '1', '2', null, '博兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371626', '371600', '0,370000,371600,', '26', '00000037,00000000,00000026,', '1', '2', null, '邹平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371700', '370000', '0,370000,', '0', '00000037,00000000,', '0', '1', null, '荷泽市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371702', '371700', '0,370000,371700,', '2', '00000037,00000000,00000002,', '1', '2', null, '牡丹区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371721', '371700', '0,370000,371700,', '21', '00000037,00000000,00000021,', '1', '2', null, '曹　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371722', '371700', '0,370000,371700,', '22', '00000037,00000000,00000022,', '1', '2', null, '单　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371723', '371700', '0,370000,371700,', '23', '00000037,00000000,00000023,', '1', '2', null, '成武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371724', '371700', '0,370000,371700,', '24', '00000037,00000000,00000024,', '1', '2', null, '巨野县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371725', '371700', '0,370000,371700,', '25', '00000037,00000000,00000025,', '1', '2', null, '郓城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371726', '371700', '0,370000,371700,', '26', '00000037,00000000,00000026,', '1', '2', null, '鄄城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371727', '371700', '0,370000,371700,', '27', '00000037,00000000,00000027,', '1', '2', null, '定陶县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('371728', '371700', '0,370000,371700,', '28', '00000037,00000000,00000028,', '1', '2', null, '东明县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410000', '0', '0,', '41', '00000041,', '0', '0', null, '河南省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410100', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '郑州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410102', '410100', '0,410000,410100,', '2', '00000041,00000000,00000002,', '1', '2', null, '中原区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410103', '410100', '0,410000,410100,', '3', '00000041,00000000,00000003,', '1', '2', null, '二七区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410104', '410100', '0,410000,410100,', '4', '00000041,00000000,00000004,', '1', '2', null, '管城回族区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410105', '410100', '0,410000,410100,', '5', '00000041,00000000,00000005,', '1', '2', null, '金水区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410106', '410100', '0,410000,410100,', '6', '00000041,00000000,00000006,', '1', '2', null, '上街区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410108', '410100', '0,410000,410100,', '8', '00000041,00000000,00000008,', '1', '2', null, '邙山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410122', '410100', '0,410000,410100,', '22', '00000041,00000000,00000022,', '1', '2', null, '中牟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410181', '410100', '0,410000,410100,', '81', '00000041,00000000,00000081,', '1', '2', null, '巩义市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410182', '410100', '0,410000,410100,', '82', '00000041,00000000,00000082,', '1', '2', null, '荥阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410183', '410100', '0,410000,410100,', '83', '00000041,00000000,00000083,', '1', '2', null, '新密市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410184', '410100', '0,410000,410100,', '84', '00000041,00000000,00000084,', '1', '2', null, '新郑市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410185', '410100', '0,410000,410100,', '85', '00000041,00000000,00000085,', '1', '2', null, '登封市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410200', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '开封市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410202', '410200', '0,410000,410200,', '2', '00000041,00000000,00000002,', '1', '2', null, '龙亭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410203', '410200', '0,410000,410200,', '3', '00000041,00000000,00000003,', '1', '2', null, '顺河回族区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410204', '410200', '0,410000,410200,', '4', '00000041,00000000,00000004,', '1', '2', null, '鼓楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410205', '410200', '0,410000,410200,', '5', '00000041,00000000,00000005,', '1', '2', null, '南关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410211', '410200', '0,410000,410200,', '11', '00000041,00000000,00000011,', '1', '2', null, '郊　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410221', '410200', '0,410000,410200,', '21', '00000041,00000000,00000021,', '1', '2', null, '杞　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410222', '410200', '0,410000,410200,', '22', '00000041,00000000,00000022,', '1', '2', null, '通许县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410223', '410200', '0,410000,410200,', '23', '00000041,00000000,00000023,', '1', '2', null, '尉氏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410224', '410200', '0,410000,410200,', '24', '00000041,00000000,00000024,', '1', '2', null, '开封县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410225', '410200', '0,410000,410200,', '25', '00000041,00000000,00000025,', '1', '2', null, '兰考县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410300', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '洛阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410302', '410300', '0,410000,410300,', '2', '00000041,00000000,00000002,', '1', '2', null, '老城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410303', '410300', '0,410000,410300,', '3', '00000041,00000000,00000003,', '1', '2', null, '西工区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410304', '410300', '0,410000,410300,', '4', '00000041,00000000,00000004,', '1', '2', null, '廛河回族区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410305', '410300', '0,410000,410300,', '5', '00000041,00000000,00000005,', '1', '2', null, '涧西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410306', '410300', '0,410000,410300,', '6', '00000041,00000000,00000006,', '1', '2', null, '吉利区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410307', '410300', '0,410000,410300,', '7', '00000041,00000000,00000007,', '1', '2', null, '洛龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410322', '410300', '0,410000,410300,', '22', '00000041,00000000,00000022,', '1', '2', null, '孟津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410323', '410300', '0,410000,410300,', '23', '00000041,00000000,00000023,', '1', '2', null, '新安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410324', '410300', '0,410000,410300,', '24', '00000041,00000000,00000024,', '1', '2', null, '栾川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410325', '410300', '0,410000,410300,', '25', '00000041,00000000,00000025,', '1', '2', null, '嵩　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410326', '410300', '0,410000,410300,', '26', '00000041,00000000,00000026,', '1', '2', null, '汝阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410327', '410300', '0,410000,410300,', '27', '00000041,00000000,00000027,', '1', '2', null, '宜阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410328', '410300', '0,410000,410300,', '28', '00000041,00000000,00000028,', '1', '2', null, '洛宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410329', '410300', '0,410000,410300,', '29', '00000041,00000000,00000029,', '1', '2', null, '伊川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410381', '410300', '0,410000,410300,', '81', '00000041,00000000,00000081,', '1', '2', null, '偃师市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410400', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '平顶山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410402', '410400', '0,410000,410400,', '2', '00000041,00000000,00000002,', '1', '2', null, '新华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410403', '410400', '0,410000,410400,', '3', '00000041,00000000,00000003,', '1', '2', null, '卫东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410404', '410400', '0,410000,410400,', '4', '00000041,00000000,00000004,', '1', '2', null, '石龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410411', '410400', '0,410000,410400,', '11', '00000041,00000000,00000011,', '1', '2', null, '湛河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410421', '410400', '0,410000,410400,', '21', '00000041,00000000,00000021,', '1', '2', null, '宝丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410422', '410400', '0,410000,410400,', '22', '00000041,00000000,00000022,', '1', '2', null, '叶　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410423', '410400', '0,410000,410400,', '23', '00000041,00000000,00000023,', '1', '2', null, '鲁山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410425', '410400', '0,410000,410400,', '25', '00000041,00000000,00000025,', '1', '2', null, '郏　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410481', '410400', '0,410000,410400,', '81', '00000041,00000000,00000081,', '1', '2', null, '舞钢市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410482', '410400', '0,410000,410400,', '82', '00000041,00000000,00000082,', '1', '2', null, '汝州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410500', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '安阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410502', '410500', '0,410000,410500,', '2', '00000041,00000000,00000002,', '1', '2', null, '文峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410503', '410500', '0,410000,410500,', '3', '00000041,00000000,00000003,', '1', '2', null, '北关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410505', '410500', '0,410000,410500,', '5', '00000041,00000000,00000005,', '1', '2', null, '殷都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410506', '410500', '0,410000,410500,', '6', '00000041,00000000,00000006,', '1', '2', null, '龙安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410522', '410500', '0,410000,410500,', '22', '00000041,00000000,00000022,', '1', '2', null, '安阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410523', '410500', '0,410000,410500,', '23', '00000041,00000000,00000023,', '1', '2', null, '汤阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410526', '410500', '0,410000,410500,', '26', '00000041,00000000,00000026,', '1', '2', null, '滑　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410527', '410500', '0,410000,410500,', '27', '00000041,00000000,00000027,', '1', '2', null, '内黄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410581', '410500', '0,410000,410500,', '81', '00000041,00000000,00000081,', '1', '2', null, '林州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410600', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '鹤壁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410602', '410600', '0,410000,410600,', '2', '00000041,00000000,00000002,', '1', '2', null, '鹤山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410603', '410600', '0,410000,410600,', '3', '00000041,00000000,00000003,', '1', '2', null, '山城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410611', '410600', '0,410000,410600,', '11', '00000041,00000000,00000011,', '1', '2', null, '淇滨区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410621', '410600', '0,410000,410600,', '21', '00000041,00000000,00000021,', '1', '2', null, '浚　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410622', '410600', '0,410000,410600,', '22', '00000041,00000000,00000022,', '1', '2', null, '淇　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410700', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '新乡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410702', '410700', '0,410000,410700,', '2', '00000041,00000000,00000002,', '1', '2', null, '红旗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410703', '410700', '0,410000,410700,', '3', '00000041,00000000,00000003,', '1', '2', null, '卫滨区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410704', '410700', '0,410000,410700,', '4', '00000041,00000000,00000004,', '1', '2', null, '凤泉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410711', '410700', '0,410000,410700,', '11', '00000041,00000000,00000011,', '1', '2', null, '牧野区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410721', '410700', '0,410000,410700,', '21', '00000041,00000000,00000021,', '1', '2', null, '新乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410724', '410700', '0,410000,410700,', '24', '00000041,00000000,00000024,', '1', '2', null, '获嘉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410725', '410700', '0,410000,410700,', '25', '00000041,00000000,00000025,', '1', '2', null, '原阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410726', '410700', '0,410000,410700,', '26', '00000041,00000000,00000026,', '1', '2', null, '延津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410727', '410700', '0,410000,410700,', '27', '00000041,00000000,00000027,', '1', '2', null, '封丘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410728', '410700', '0,410000,410700,', '28', '00000041,00000000,00000028,', '1', '2', null, '长垣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410781', '410700', '0,410000,410700,', '81', '00000041,00000000,00000081,', '1', '2', null, '卫辉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410782', '410700', '0,410000,410700,', '82', '00000041,00000000,00000082,', '1', '2', null, '辉县市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410800', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '焦作市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410802', '410800', '0,410000,410800,', '2', '00000041,00000000,00000002,', '1', '2', null, '解放区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410803', '410800', '0,410000,410800,', '3', '00000041,00000000,00000003,', '1', '2', null, '中站区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410804', '410800', '0,410000,410800,', '4', '00000041,00000000,00000004,', '1', '2', null, '马村区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410811', '410800', '0,410000,410800,', '11', '00000041,00000000,00000011,', '1', '2', null, '山阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410821', '410800', '0,410000,410800,', '21', '00000041,00000000,00000021,', '1', '2', null, '修武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410822', '410800', '0,410000,410800,', '22', '00000041,00000000,00000022,', '1', '2', null, '博爱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410823', '410800', '0,410000,410800,', '23', '00000041,00000000,00000023,', '1', '2', null, '武陟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410825', '410800', '0,410000,410800,', '25', '00000041,00000000,00000025,', '1', '2', null, '温　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410881', '410800', '0,410000,410800,', '81', '00000041,00000000,00000081,', '1', '2', null, '济源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410882', '410800', '0,410000,410800,', '82', '00000041,00000000,00000082,', '1', '2', null, '沁阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410883', '410800', '0,410000,410800,', '83', '00000041,00000000,00000083,', '1', '2', null, '孟州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410900', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '濮阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410902', '410900', '0,410000,410900,', '2', '00000041,00000000,00000002,', '1', '2', null, '华龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410922', '410900', '0,410000,410900,', '22', '00000041,00000000,00000022,', '1', '2', null, '清丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410923', '410900', '0,410000,410900,', '23', '00000041,00000000,00000023,', '1', '2', null, '南乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410926', '410900', '0,410000,410900,', '26', '00000041,00000000,00000026,', '1', '2', null, '范　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410927', '410900', '0,410000,410900,', '27', '00000041,00000000,00000027,', '1', '2', null, '台前县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('410928', '410900', '0,410000,410900,', '28', '00000041,00000000,00000028,', '1', '2', null, '濮阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411000', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '许昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411002', '411000', '0,410000,411000,', '2', '00000041,00000000,00000002,', '1', '2', null, '魏都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411023', '411000', '0,410000,411000,', '23', '00000041,00000000,00000023,', '1', '2', null, '许昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411024', '411000', '0,410000,411000,', '24', '00000041,00000000,00000024,', '1', '2', null, '鄢陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411025', '411000', '0,410000,411000,', '25', '00000041,00000000,00000025,', '1', '2', null, '襄城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411081', '411000', '0,410000,411000,', '81', '00000041,00000000,00000081,', '1', '2', null, '禹州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411082', '411000', '0,410000,411000,', '82', '00000041,00000000,00000082,', '1', '2', null, '长葛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411100', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '漯河市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411102', '411100', '0,410000,411100,', '2', '00000041,00000000,00000002,', '1', '2', null, '源汇区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411103', '411100', '0,410000,411100,', '3', '00000041,00000000,00000003,', '1', '2', null, '郾城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411104', '411100', '0,410000,411100,', '4', '00000041,00000000,00000004,', '1', '2', null, '召陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411121', '411100', '0,410000,411100,', '21', '00000041,00000000,00000021,', '1', '2', null, '舞阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411122', '411100', '0,410000,411100,', '22', '00000041,00000000,00000022,', '1', '2', null, '临颍县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411200', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '三门峡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411202', '411200', '0,410000,411200,', '2', '00000041,00000000,00000002,', '1', '2', null, '湖滨区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411221', '411200', '0,410000,411200,', '21', '00000041,00000000,00000021,', '1', '2', null, '渑池县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411222', '411200', '0,410000,411200,', '22', '00000041,00000000,00000022,', '1', '2', null, '陕　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411224', '411200', '0,410000,411200,', '24', '00000041,00000000,00000024,', '1', '2', null, '卢氏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411281', '411200', '0,410000,411200,', '81', '00000041,00000000,00000081,', '1', '2', null, '义马市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411282', '411200', '0,410000,411200,', '82', '00000041,00000000,00000082,', '1', '2', null, '灵宝市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411300', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '南阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411302', '411300', '0,410000,411300,', '2', '00000041,00000000,00000002,', '1', '2', null, '宛城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411303', '411300', '0,410000,411300,', '3', '00000041,00000000,00000003,', '1', '2', null, '卧龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411321', '411300', '0,410000,411300,', '21', '00000041,00000000,00000021,', '1', '2', null, '南召县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411322', '411300', '0,410000,411300,', '22', '00000041,00000000,00000022,', '1', '2', null, '方城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411323', '411300', '0,410000,411300,', '23', '00000041,00000000,00000023,', '1', '2', null, '西峡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411324', '411300', '0,410000,411300,', '24', '00000041,00000000,00000024,', '1', '2', null, '镇平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411325', '411300', '0,410000,411300,', '25', '00000041,00000000,00000025,', '1', '2', null, '内乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411326', '411300', '0,410000,411300,', '26', '00000041,00000000,00000026,', '1', '2', null, '淅川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411327', '411300', '0,410000,411300,', '27', '00000041,00000000,00000027,', '1', '2', null, '社旗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411328', '411300', '0,410000,411300,', '28', '00000041,00000000,00000028,', '1', '2', null, '唐河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411329', '411300', '0,410000,411300,', '29', '00000041,00000000,00000029,', '1', '2', null, '新野县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411330', '411300', '0,410000,411300,', '30', '00000041,00000000,00000030,', '1', '2', null, '桐柏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411381', '411300', '0,410000,411300,', '81', '00000041,00000000,00000081,', '1', '2', null, '邓州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411400', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '商丘市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411402', '411400', '0,410000,411400,', '2', '00000041,00000000,00000002,', '1', '2', null, '梁园区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411403', '411400', '0,410000,411400,', '3', '00000041,00000000,00000003,', '1', '2', null, '睢阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411421', '411400', '0,410000,411400,', '21', '00000041,00000000,00000021,', '1', '2', null, '民权县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411422', '411400', '0,410000,411400,', '22', '00000041,00000000,00000022,', '1', '2', null, '睢　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411423', '411400', '0,410000,411400,', '23', '00000041,00000000,00000023,', '1', '2', null, '宁陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411424', '411400', '0,410000,411400,', '24', '00000041,00000000,00000024,', '1', '2', null, '柘城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411425', '411400', '0,410000,411400,', '25', '00000041,00000000,00000025,', '1', '2', null, '虞城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411426', '411400', '0,410000,411400,', '26', '00000041,00000000,00000026,', '1', '2', null, '夏邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411481', '411400', '0,410000,411400,', '81', '00000041,00000000,00000081,', '1', '2', null, '永城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411500', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '信阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411502', '411500', '0,410000,411500,', '2', '00000041,00000000,00000002,', '1', '2', null, '师河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411503', '411500', '0,410000,411500,', '3', '00000041,00000000,00000003,', '1', '2', null, '平桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411521', '411500', '0,410000,411500,', '21', '00000041,00000000,00000021,', '1', '2', null, '罗山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411522', '411500', '0,410000,411500,', '22', '00000041,00000000,00000022,', '1', '2', null, '光山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411523', '411500', '0,410000,411500,', '23', '00000041,00000000,00000023,', '1', '2', null, '新　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411524', '411500', '0,410000,411500,', '24', '00000041,00000000,00000024,', '1', '2', null, '商城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411525', '411500', '0,410000,411500,', '25', '00000041,00000000,00000025,', '1', '2', null, '固始县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411526', '411500', '0,410000,411500,', '26', '00000041,00000000,00000026,', '1', '2', null, '潢川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411527', '411500', '0,410000,411500,', '27', '00000041,00000000,00000027,', '1', '2', null, '淮滨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411528', '411500', '0,410000,411500,', '28', '00000041,00000000,00000028,', '1', '2', null, '息　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411600', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '周口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411602', '411600', '0,410000,411600,', '2', '00000041,00000000,00000002,', '1', '2', null, '川汇区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411621', '411600', '0,410000,411600,', '21', '00000041,00000000,00000021,', '1', '2', null, '扶沟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411622', '411600', '0,410000,411600,', '22', '00000041,00000000,00000022,', '1', '2', null, '西华县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411623', '411600', '0,410000,411600,', '23', '00000041,00000000,00000023,', '1', '2', null, '商水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411624', '411600', '0,410000,411600,', '24', '00000041,00000000,00000024,', '1', '2', null, '沈丘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411625', '411600', '0,410000,411600,', '25', '00000041,00000000,00000025,', '1', '2', null, '郸城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411626', '411600', '0,410000,411600,', '26', '00000041,00000000,00000026,', '1', '2', null, '淮阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411627', '411600', '0,410000,411600,', '27', '00000041,00000000,00000027,', '1', '2', null, '太康县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411628', '411600', '0,410000,411600,', '28', '00000041,00000000,00000028,', '1', '2', null, '鹿邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411681', '411600', '0,410000,411600,', '81', '00000041,00000000,00000081,', '1', '2', null, '项城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411700', '410000', '0,410000,', '0', '00000041,00000000,', '0', '1', null, '驻马店市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411702', '411700', '0,410000,411700,', '2', '00000041,00000000,00000002,', '1', '2', null, '驿城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411721', '411700', '0,410000,411700,', '21', '00000041,00000000,00000021,', '1', '2', null, '西平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411722', '411700', '0,410000,411700,', '22', '00000041,00000000,00000022,', '1', '2', null, '上蔡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411723', '411700', '0,410000,411700,', '23', '00000041,00000000,00000023,', '1', '2', null, '平舆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411724', '411700', '0,410000,411700,', '24', '00000041,00000000,00000024,', '1', '2', null, '正阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411725', '411700', '0,410000,411700,', '25', '00000041,00000000,00000025,', '1', '2', null, '确山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411726', '411700', '0,410000,411700,', '26', '00000041,00000000,00000026,', '1', '2', null, '泌阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411727', '411700', '0,410000,411700,', '27', '00000041,00000000,00000027,', '1', '2', null, '汝南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411728', '411700', '0,410000,411700,', '28', '00000041,00000000,00000028,', '1', '2', null, '遂平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('411729', '411700', '0,410000,411700,', '29', '00000041,00000000,00000029,', '1', '2', null, '新蔡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420000', '0', '0,', '42', '00000042,', '0', '0', null, '湖北省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420100', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '武汉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420102', '420100', '0,420000,420100,', '2', '00000042,00000000,00000002,', '1', '2', null, '江岸区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420103', '420100', '0,420000,420100,', '3', '00000042,00000000,00000003,', '1', '2', null, '江汉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420104', '420100', '0,420000,420100,', '4', '00000042,00000000,00000004,', '1', '2', null, '乔口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420105', '420100', '0,420000,420100,', '5', '00000042,00000000,00000005,', '1', '2', null, '汉阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420106', '420100', '0,420000,420100,', '6', '00000042,00000000,00000006,', '1', '2', null, '武昌区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420107', '420100', '0,420000,420100,', '7', '00000042,00000000,00000007,', '1', '2', null, '青山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420111', '420100', '0,420000,420100,', '11', '00000042,00000000,00000011,', '1', '2', null, '洪山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420112', '420100', '0,420000,420100,', '12', '00000042,00000000,00000012,', '1', '2', null, '东西湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420113', '420100', '0,420000,420100,', '13', '00000042,00000000,00000013,', '1', '2', null, '汉南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420114', '420100', '0,420000,420100,', '14', '00000042,00000000,00000014,', '1', '2', null, '蔡甸区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420115', '420100', '0,420000,420100,', '15', '00000042,00000000,00000015,', '1', '2', null, '江夏区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420116', '420100', '0,420000,420100,', '16', '00000042,00000000,00000016,', '1', '2', null, '黄陂区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420117', '420100', '0,420000,420100,', '17', '00000042,00000000,00000017,', '1', '2', null, '新洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420200', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '黄石市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420202', '420200', '0,420000,420200,', '2', '00000042,00000000,00000002,', '1', '2', null, '黄石港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420203', '420200', '0,420000,420200,', '3', '00000042,00000000,00000003,', '1', '2', null, '西塞山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420204', '420200', '0,420000,420200,', '4', '00000042,00000000,00000004,', '1', '2', null, '下陆区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420205', '420200', '0,420000,420200,', '5', '00000042,00000000,00000005,', '1', '2', null, '铁山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420222', '420200', '0,420000,420200,', '22', '00000042,00000000,00000022,', '1', '2', null, '阳新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420281', '420200', '0,420000,420200,', '81', '00000042,00000000,00000081,', '1', '2', null, '大冶市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420300', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '十堰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420302', '420300', '0,420000,420300,', '2', '00000042,00000000,00000002,', '1', '2', null, '茅箭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420303', '420300', '0,420000,420300,', '3', '00000042,00000000,00000003,', '1', '2', null, '张湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420321', '420300', '0,420000,420300,', '21', '00000042,00000000,00000021,', '1', '2', null, '郧　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420322', '420300', '0,420000,420300,', '22', '00000042,00000000,00000022,', '1', '2', null, '郧西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420323', '420300', '0,420000,420300,', '23', '00000042,00000000,00000023,', '1', '2', null, '竹山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420324', '420300', '0,420000,420300,', '24', '00000042,00000000,00000024,', '1', '2', null, '竹溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420325', '420300', '0,420000,420300,', '25', '00000042,00000000,00000025,', '1', '2', null, '房　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420381', '420300', '0,420000,420300,', '81', '00000042,00000000,00000081,', '1', '2', null, '丹江口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420500', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '宜昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420502', '420500', '0,420000,420500,', '2', '00000042,00000000,00000002,', '1', '2', null, '西陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420503', '420500', '0,420000,420500,', '3', '00000042,00000000,00000003,', '1', '2', null, '伍家岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420504', '420500', '0,420000,420500,', '4', '00000042,00000000,00000004,', '1', '2', null, '点军区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420505', '420500', '0,420000,420500,', '5', '00000042,00000000,00000005,', '1', '2', null, '猇亭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420506', '420500', '0,420000,420500,', '6', '00000042,00000000,00000006,', '1', '2', null, '夷陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420525', '420500', '0,420000,420500,', '25', '00000042,00000000,00000025,', '1', '2', null, '远安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420526', '420500', '0,420000,420500,', '26', '00000042,00000000,00000026,', '1', '2', null, '兴山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420527', '420500', '0,420000,420500,', '27', '00000042,00000000,00000027,', '1', '2', null, '秭归县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420528', '420500', '0,420000,420500,', '28', '00000042,00000000,00000028,', '1', '2', null, '长阳土家族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420529', '420500', '0,420000,420500,', '29', '00000042,00000000,00000029,', '1', '2', null, '五峰土家族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420581', '420500', '0,420000,420500,', '81', '00000042,00000000,00000081,', '1', '2', null, '宜都市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420582', '420500', '0,420000,420500,', '82', '00000042,00000000,00000082,', '1', '2', null, '当阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420583', '420500', '0,420000,420500,', '83', '00000042,00000000,00000083,', '1', '2', null, '枝江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420600', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '襄樊市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420602', '420600', '0,420000,420600,', '2', '00000042,00000000,00000002,', '1', '2', null, '襄城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420606', '420600', '0,420000,420600,', '6', '00000042,00000000,00000006,', '1', '2', null, '樊城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420607', '420600', '0,420000,420600,', '7', '00000042,00000000,00000007,', '1', '2', null, '襄阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420624', '420600', '0,420000,420600,', '24', '00000042,00000000,00000024,', '1', '2', null, '南漳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420625', '420600', '0,420000,420600,', '25', '00000042,00000000,00000025,', '1', '2', null, '谷城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420626', '420600', '0,420000,420600,', '26', '00000042,00000000,00000026,', '1', '2', null, '保康县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420682', '420600', '0,420000,420600,', '82', '00000042,00000000,00000082,', '1', '2', null, '老河口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420683', '420600', '0,420000,420600,', '83', '00000042,00000000,00000083,', '1', '2', null, '枣阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420684', '420600', '0,420000,420600,', '84', '00000042,00000000,00000084,', '1', '2', null, '宜城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420700', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '鄂州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420702', '420700', '0,420000,420700,', '2', '00000042,00000000,00000002,', '1', '2', null, '梁子湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420703', '420700', '0,420000,420700,', '3', '00000042,00000000,00000003,', '1', '2', null, '华容区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420704', '420700', '0,420000,420700,', '4', '00000042,00000000,00000004,', '1', '2', null, '鄂城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420800', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '荆门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420802', '420800', '0,420000,420800,', '2', '00000042,00000000,00000002,', '1', '2', null, '东宝区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420804', '420800', '0,420000,420800,', '4', '00000042,00000000,00000004,', '1', '2', null, '掇刀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420821', '420800', '0,420000,420800,', '21', '00000042,00000000,00000021,', '1', '2', null, '京山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420822', '420800', '0,420000,420800,', '22', '00000042,00000000,00000022,', '1', '2', null, '沙洋县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420881', '420800', '0,420000,420800,', '81', '00000042,00000000,00000081,', '1', '2', null, '钟祥市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420900', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '孝感市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420902', '420900', '0,420000,420900,', '2', '00000042,00000000,00000002,', '1', '2', null, '孝南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420921', '420900', '0,420000,420900,', '21', '00000042,00000000,00000021,', '1', '2', null, '孝昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420922', '420900', '0,420000,420900,', '22', '00000042,00000000,00000022,', '1', '2', null, '大悟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420923', '420900', '0,420000,420900,', '23', '00000042,00000000,00000023,', '1', '2', null, '云梦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420981', '420900', '0,420000,420900,', '81', '00000042,00000000,00000081,', '1', '2', null, '应城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420982', '420900', '0,420000,420900,', '82', '00000042,00000000,00000082,', '1', '2', null, '安陆市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('420984', '420900', '0,420000,420900,', '84', '00000042,00000000,00000084,', '1', '2', null, '汉川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421000', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '荆州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421002', '421000', '0,420000,421000,', '2', '00000042,00000000,00000002,', '1', '2', null, '沙市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421003', '421000', '0,420000,421000,', '3', '00000042,00000000,00000003,', '1', '2', null, '荆州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421022', '421000', '0,420000,421000,', '22', '00000042,00000000,00000022,', '1', '2', null, '公安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421023', '421000', '0,420000,421000,', '23', '00000042,00000000,00000023,', '1', '2', null, '监利县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421024', '421000', '0,420000,421000,', '24', '00000042,00000000,00000024,', '1', '2', null, '江陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421081', '421000', '0,420000,421000,', '81', '00000042,00000000,00000081,', '1', '2', null, '石首市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421083', '421000', '0,420000,421000,', '83', '00000042,00000000,00000083,', '1', '2', null, '洪湖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421087', '421000', '0,420000,421000,', '87', '00000042,00000000,00000087,', '1', '2', null, '松滋市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421100', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '黄冈市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421102', '421100', '0,420000,421100,', '2', '00000042,00000000,00000002,', '1', '2', null, '黄州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421121', '421100', '0,420000,421100,', '21', '00000042,00000000,00000021,', '1', '2', null, '团风县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421122', '421100', '0,420000,421100,', '22', '00000042,00000000,00000022,', '1', '2', null, '红安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421123', '421100', '0,420000,421100,', '23', '00000042,00000000,00000023,', '1', '2', null, '罗田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421124', '421100', '0,420000,421100,', '24', '00000042,00000000,00000024,', '1', '2', null, '英山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421125', '421100', '0,420000,421100,', '25', '00000042,00000000,00000025,', '1', '2', null, '浠水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421126', '421100', '0,420000,421100,', '26', '00000042,00000000,00000026,', '1', '2', null, '蕲春县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421127', '421100', '0,420000,421100,', '27', '00000042,00000000,00000027,', '1', '2', null, '黄梅县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421181', '421100', '0,420000,421100,', '81', '00000042,00000000,00000081,', '1', '2', null, '麻城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421182', '421100', '0,420000,421100,', '82', '00000042,00000000,00000082,', '1', '2', null, '武穴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421200', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '咸宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421202', '421200', '0,420000,421200,', '2', '00000042,00000000,00000002,', '1', '2', null, '咸安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421221', '421200', '0,420000,421200,', '21', '00000042,00000000,00000021,', '1', '2', null, '嘉鱼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421222', '421200', '0,420000,421200,', '22', '00000042,00000000,00000022,', '1', '2', null, '通城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421223', '421200', '0,420000,421200,', '23', '00000042,00000000,00000023,', '1', '2', null, '崇阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421224', '421200', '0,420000,421200,', '24', '00000042,00000000,00000024,', '1', '2', null, '通山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421281', '421200', '0,420000,421200,', '81', '00000042,00000000,00000081,', '1', '2', null, '赤壁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421300', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '随州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421302', '421300', '0,420000,421300,', '2', '00000042,00000000,00000002,', '1', '2', null, '曾都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('421381', '421300', '0,420000,421300,', '81', '00000042,00000000,00000081,', '1', '2', null, '广水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422800', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '恩施土家族苗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422801', '422800', '0,420000,422800,', '1', '00000042,00000000,00000001,', '1', '2', null, '恩施市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422802', '422800', '0,420000,422800,', '2', '00000042,00000000,00000002,', '1', '2', null, '利川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422822', '422800', '0,420000,422800,', '22', '00000042,00000000,00000022,', '1', '2', null, '建始县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422823', '422800', '0,420000,422800,', '23', '00000042,00000000,00000023,', '1', '2', null, '巴东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422825', '422800', '0,420000,422800,', '25', '00000042,00000000,00000025,', '1', '2', null, '宣恩县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422826', '422800', '0,420000,422800,', '26', '00000042,00000000,00000026,', '1', '2', null, '咸丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422827', '422800', '0,420000,422800,', '27', '00000042,00000000,00000027,', '1', '2', null, '来凤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('422828', '422800', '0,420000,422800,', '28', '00000042,00000000,00000028,', '1', '2', null, '鹤峰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('429000', '420000', '0,420000,', '0', '00000042,00000000,', '0', '1', null, '省直辖行政单位', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('429004', '429000', '0,420000,429000,', '4', '00000042,00000000,00000004,', '1', '2', null, '仙桃市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('429005', '429000', '0,420000,429000,', '5', '00000042,00000000,00000005,', '1', '2', null, '潜江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('429006', '429000', '0,420000,429000,', '6', '00000042,00000000,00000006,', '1', '2', null, '天门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('429021', '429000', '0,420000,429000,', '21', '00000042,00000000,00000021,', '1', '2', null, '神农架林区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430000', '0', '0,', '43', '00000043,', '0', '0', null, '湖南省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430100', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '长沙市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430102', '430100', '0,430000,430100,', '2', '00000043,00000000,00000002,', '1', '2', null, '芙蓉区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430103', '430100', '0,430000,430100,', '3', '00000043,00000000,00000003,', '1', '2', null, '天心区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430104', '430100', '0,430000,430100,', '4', '00000043,00000000,00000004,', '1', '2', null, '岳麓区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430105', '430100', '0,430000,430100,', '5', '00000043,00000000,00000005,', '1', '2', null, '开福区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430111', '430100', '0,430000,430100,', '11', '00000043,00000000,00000011,', '1', '2', null, '雨花区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430121', '430100', '0,430000,430100,', '21', '00000043,00000000,00000021,', '1', '2', null, '长沙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430122', '430100', '0,430000,430100,', '22', '00000043,00000000,00000022,', '1', '2', null, '望城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430124', '430100', '0,430000,430100,', '24', '00000043,00000000,00000024,', '1', '2', null, '宁乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430181', '430100', '0,430000,430100,', '81', '00000043,00000000,00000081,', '1', '2', null, '浏阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430200', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '株洲市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430202', '430200', '0,430000,430200,', '2', '00000043,00000000,00000002,', '1', '2', null, '荷塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430203', '430200', '0,430000,430200,', '3', '00000043,00000000,00000003,', '1', '2', null, '芦淞区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430204', '430200', '0,430000,430200,', '4', '00000043,00000000,00000004,', '1', '2', null, '石峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430211', '430200', '0,430000,430200,', '11', '00000043,00000000,00000011,', '1', '2', null, '天元区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430221', '430200', '0,430000,430200,', '21', '00000043,00000000,00000021,', '1', '2', null, '株洲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430223', '430200', '0,430000,430200,', '23', '00000043,00000000,00000023,', '1', '2', null, '攸　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430224', '430200', '0,430000,430200,', '24', '00000043,00000000,00000024,', '1', '2', null, '茶陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430225', '430200', '0,430000,430200,', '25', '00000043,00000000,00000025,', '1', '2', null, '炎陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430281', '430200', '0,430000,430200,', '81', '00000043,00000000,00000081,', '1', '2', null, '醴陵市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430300', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '湘潭市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430302', '430300', '0,430000,430300,', '2', '00000043,00000000,00000002,', '1', '2', null, '雨湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430304', '430300', '0,430000,430300,', '4', '00000043,00000000,00000004,', '1', '2', null, '岳塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430321', '430300', '0,430000,430300,', '21', '00000043,00000000,00000021,', '1', '2', null, '湘潭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430381', '430300', '0,430000,430300,', '81', '00000043,00000000,00000081,', '1', '2', null, '湘乡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430382', '430300', '0,430000,430300,', '82', '00000043,00000000,00000082,', '1', '2', null, '韶山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430400', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '衡阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430405', '430400', '0,430000,430400,', '5', '00000043,00000000,00000005,', '1', '2', null, '珠晖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430406', '430400', '0,430000,430400,', '6', '00000043,00000000,00000006,', '1', '2', null, '雁峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430407', '430400', '0,430000,430400,', '7', '00000043,00000000,00000007,', '1', '2', null, '石鼓区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430408', '430400', '0,430000,430400,', '8', '00000043,00000000,00000008,', '1', '2', null, '蒸湘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430412', '430400', '0,430000,430400,', '12', '00000043,00000000,00000012,', '1', '2', null, '南岳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430421', '430400', '0,430000,430400,', '21', '00000043,00000000,00000021,', '1', '2', null, '衡阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430422', '430400', '0,430000,430400,', '22', '00000043,00000000,00000022,', '1', '2', null, '衡南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430423', '430400', '0,430000,430400,', '23', '00000043,00000000,00000023,', '1', '2', null, '衡山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430424', '430400', '0,430000,430400,', '24', '00000043,00000000,00000024,', '1', '2', null, '衡东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430426', '430400', '0,430000,430400,', '26', '00000043,00000000,00000026,', '1', '2', null, '祁东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430481', '430400', '0,430000,430400,', '81', '00000043,00000000,00000081,', '1', '2', null, '耒阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430482', '430400', '0,430000,430400,', '82', '00000043,00000000,00000082,', '1', '2', null, '常宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430500', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '邵阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430502', '430500', '0,430000,430500,', '2', '00000043,00000000,00000002,', '1', '2', null, '双清区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430503', '430500', '0,430000,430500,', '3', '00000043,00000000,00000003,', '1', '2', null, '大祥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430511', '430500', '0,430000,430500,', '11', '00000043,00000000,00000011,', '1', '2', null, '北塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430521', '430500', '0,430000,430500,', '21', '00000043,00000000,00000021,', '1', '2', null, '邵东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430522', '430500', '0,430000,430500,', '22', '00000043,00000000,00000022,', '1', '2', null, '新邵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430523', '430500', '0,430000,430500,', '23', '00000043,00000000,00000023,', '1', '2', null, '邵阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430524', '430500', '0,430000,430500,', '24', '00000043,00000000,00000024,', '1', '2', null, '隆回县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430525', '430500', '0,430000,430500,', '25', '00000043,00000000,00000025,', '1', '2', null, '洞口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430527', '430500', '0,430000,430500,', '27', '00000043,00000000,00000027,', '1', '2', null, '绥宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430528', '430500', '0,430000,430500,', '28', '00000043,00000000,00000028,', '1', '2', null, '新宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430529', '430500', '0,430000,430500,', '29', '00000043,00000000,00000029,', '1', '2', null, '城步苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430581', '430500', '0,430000,430500,', '81', '00000043,00000000,00000081,', '1', '2', null, '武冈市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430600', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '岳阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430602', '430600', '0,430000,430600,', '2', '00000043,00000000,00000002,', '1', '2', null, '岳阳楼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430603', '430600', '0,430000,430600,', '3', '00000043,00000000,00000003,', '1', '2', null, '云溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430611', '430600', '0,430000,430600,', '11', '00000043,00000000,00000011,', '1', '2', null, '君山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430621', '430600', '0,430000,430600,', '21', '00000043,00000000,00000021,', '1', '2', null, '岳阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430623', '430600', '0,430000,430600,', '23', '00000043,00000000,00000023,', '1', '2', null, '华容县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430624', '430600', '0,430000,430600,', '24', '00000043,00000000,00000024,', '1', '2', null, '湘阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430626', '430600', '0,430000,430600,', '26', '00000043,00000000,00000026,', '1', '2', null, '平江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430681', '430600', '0,430000,430600,', '81', '00000043,00000000,00000081,', '1', '2', null, '汨罗市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430682', '430600', '0,430000,430600,', '82', '00000043,00000000,00000082,', '1', '2', null, '临湘市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430700', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '常德市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430702', '430700', '0,430000,430700,', '2', '00000043,00000000,00000002,', '1', '2', null, '武陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430703', '430700', '0,430000,430700,', '3', '00000043,00000000,00000003,', '1', '2', null, '鼎城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430721', '430700', '0,430000,430700,', '21', '00000043,00000000,00000021,', '1', '2', null, '安乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430722', '430700', '0,430000,430700,', '22', '00000043,00000000,00000022,', '1', '2', null, '汉寿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430723', '430700', '0,430000,430700,', '23', '00000043,00000000,00000023,', '1', '2', null, '澧　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430724', '430700', '0,430000,430700,', '24', '00000043,00000000,00000024,', '1', '2', null, '临澧县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430725', '430700', '0,430000,430700,', '25', '00000043,00000000,00000025,', '1', '2', null, '桃源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430726', '430700', '0,430000,430700,', '26', '00000043,00000000,00000026,', '1', '2', null, '石门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430781', '430700', '0,430000,430700,', '81', '00000043,00000000,00000081,', '1', '2', null, '津市市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430800', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '张家界市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430802', '430800', '0,430000,430800,', '2', '00000043,00000000,00000002,', '1', '2', null, '永定区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430811', '430800', '0,430000,430800,', '11', '00000043,00000000,00000011,', '1', '2', null, '武陵源区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430821', '430800', '0,430000,430800,', '21', '00000043,00000000,00000021,', '1', '2', null, '慈利县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430822', '430800', '0,430000,430800,', '22', '00000043,00000000,00000022,', '1', '2', null, '桑植县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430900', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '益阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430902', '430900', '0,430000,430900,', '2', '00000043,00000000,00000002,', '1', '2', null, '资阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430903', '430900', '0,430000,430900,', '3', '00000043,00000000,00000003,', '1', '2', null, '赫山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430921', '430900', '0,430000,430900,', '21', '00000043,00000000,00000021,', '1', '2', null, '南　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430922', '430900', '0,430000,430900,', '22', '00000043,00000000,00000022,', '1', '2', null, '桃江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430923', '430900', '0,430000,430900,', '23', '00000043,00000000,00000023,', '1', '2', null, '安化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('430981', '430900', '0,430000,430900,', '81', '00000043,00000000,00000081,', '1', '2', null, '沅江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431000', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '郴州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431002', '431000', '0,430000,431000,', '2', '00000043,00000000,00000002,', '1', '2', null, '北湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431003', '431000', '0,430000,431000,', '3', '00000043,00000000,00000003,', '1', '2', null, '苏仙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431021', '431000', '0,430000,431000,', '21', '00000043,00000000,00000021,', '1', '2', null, '桂阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431022', '431000', '0,430000,431000,', '22', '00000043,00000000,00000022,', '1', '2', null, '宜章县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431023', '431000', '0,430000,431000,', '23', '00000043,00000000,00000023,', '1', '2', null, '永兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431024', '431000', '0,430000,431000,', '24', '00000043,00000000,00000024,', '1', '2', null, '嘉禾县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431025', '431000', '0,430000,431000,', '25', '00000043,00000000,00000025,', '1', '2', null, '临武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431026', '431000', '0,430000,431000,', '26', '00000043,00000000,00000026,', '1', '2', null, '汝城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431027', '431000', '0,430000,431000,', '27', '00000043,00000000,00000027,', '1', '2', null, '桂东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431028', '431000', '0,430000,431000,', '28', '00000043,00000000,00000028,', '1', '2', null, '安仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431081', '431000', '0,430000,431000,', '81', '00000043,00000000,00000081,', '1', '2', null, '资兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431100', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '永州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431102', '431100', '0,430000,431100,', '2', '00000043,00000000,00000002,', '1', '2', null, '芝山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431103', '431100', '0,430000,431100,', '3', '00000043,00000000,00000003,', '1', '2', null, '冷水滩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431121', '431100', '0,430000,431100,', '21', '00000043,00000000,00000021,', '1', '2', null, '祁阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431122', '431100', '0,430000,431100,', '22', '00000043,00000000,00000022,', '1', '2', null, '东安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431123', '431100', '0,430000,431100,', '23', '00000043,00000000,00000023,', '1', '2', null, '双牌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431124', '431100', '0,430000,431100,', '24', '00000043,00000000,00000024,', '1', '2', null, '道　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431125', '431100', '0,430000,431100,', '25', '00000043,00000000,00000025,', '1', '2', null, '江永县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431126', '431100', '0,430000,431100,', '26', '00000043,00000000,00000026,', '1', '2', null, '宁远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431127', '431100', '0,430000,431100,', '27', '00000043,00000000,00000027,', '1', '2', null, '蓝山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431128', '431100', '0,430000,431100,', '28', '00000043,00000000,00000028,', '1', '2', null, '新田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431129', '431100', '0,430000,431100,', '29', '00000043,00000000,00000029,', '1', '2', null, '江华瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431200', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '怀化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431202', '431200', '0,430000,431200,', '2', '00000043,00000000,00000002,', '1', '2', null, '鹤城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431221', '431200', '0,430000,431200,', '21', '00000043,00000000,00000021,', '1', '2', null, '中方县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431222', '431200', '0,430000,431200,', '22', '00000043,00000000,00000022,', '1', '2', null, '沅陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431223', '431200', '0,430000,431200,', '23', '00000043,00000000,00000023,', '1', '2', null, '辰溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431224', '431200', '0,430000,431200,', '24', '00000043,00000000,00000024,', '1', '2', null, '溆浦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431225', '431200', '0,430000,431200,', '25', '00000043,00000000,00000025,', '1', '2', null, '会同县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431226', '431200', '0,430000,431200,', '26', '00000043,00000000,00000026,', '1', '2', null, '麻阳苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431227', '431200', '0,430000,431200,', '27', '00000043,00000000,00000027,', '1', '2', null, '新晃侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431228', '431200', '0,430000,431200,', '28', '00000043,00000000,00000028,', '1', '2', null, '芷江侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431229', '431200', '0,430000,431200,', '29', '00000043,00000000,00000029,', '1', '2', null, '靖州苗族侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431230', '431200', '0,430000,431200,', '30', '00000043,00000000,00000030,', '1', '2', null, '通道侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431281', '431200', '0,430000,431200,', '81', '00000043,00000000,00000081,', '1', '2', null, '洪江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431300', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '娄底市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431302', '431300', '0,430000,431300,', '2', '00000043,00000000,00000002,', '1', '2', null, '娄星区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431321', '431300', '0,430000,431300,', '21', '00000043,00000000,00000021,', '1', '2', null, '双峰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431322', '431300', '0,430000,431300,', '22', '00000043,00000000,00000022,', '1', '2', null, '新化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431381', '431300', '0,430000,431300,', '81', '00000043,00000000,00000081,', '1', '2', null, '冷水江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('431382', '431300', '0,430000,431300,', '82', '00000043,00000000,00000082,', '1', '2', null, '涟源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433100', '430000', '0,430000,', '0', '00000043,00000000,', '0', '1', null, '湘西土家族苗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433101', '433100', '0,430000,433100,', '1', '00000043,00000000,00000001,', '1', '2', null, '吉首市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433122', '433100', '0,430000,433100,', '22', '00000043,00000000,00000022,', '1', '2', null, '泸溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433123', '433100', '0,430000,433100,', '23', '00000043,00000000,00000023,', '1', '2', null, '凤凰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433124', '433100', '0,430000,433100,', '24', '00000043,00000000,00000024,', '1', '2', null, '花垣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433125', '433100', '0,430000,433100,', '25', '00000043,00000000,00000025,', '1', '2', null, '保靖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433126', '433100', '0,430000,433100,', '26', '00000043,00000000,00000026,', '1', '2', null, '古丈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433127', '433100', '0,430000,433100,', '27', '00000043,00000000,00000027,', '1', '2', null, '永顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('433130', '433100', '0,430000,433100,', '30', '00000043,00000000,00000030,', '1', '2', null, '龙山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440000', '0', '0,', '44', '00000044,', '0', '0', null, '广东省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440100', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '广州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440102', '440100', '0,440000,440100,', '2', '00000044,00000000,00000002,', '1', '2', null, '东山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440103', '440100', '0,440000,440100,', '3', '00000044,00000000,00000003,', '1', '2', null, '荔湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440104', '440100', '0,440000,440100,', '4', '00000044,00000000,00000004,', '1', '2', null, '越秀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440105', '440100', '0,440000,440100,', '5', '00000044,00000000,00000005,', '1', '2', null, '海珠区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440106', '440100', '0,440000,440100,', '6', '00000044,00000000,00000006,', '1', '2', null, '天河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440107', '440100', '0,440000,440100,', '7', '00000044,00000000,00000007,', '1', '2', null, '芳村区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440111', '440100', '0,440000,440100,', '11', '00000044,00000000,00000011,', '1', '2', null, '白云区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440112', '440100', '0,440000,440100,', '12', '00000044,00000000,00000012,', '1', '2', null, '黄埔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440113', '440100', '0,440000,440100,', '13', '00000044,00000000,00000013,', '1', '2', null, '番禺区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440114', '440100', '0,440000,440100,', '14', '00000044,00000000,00000014,', '1', '2', null, '花都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440183', '440100', '0,440000,440100,', '83', '00000044,00000000,00000083,', '1', '2', null, '增城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440184', '440100', '0,440000,440100,', '84', '00000044,00000000,00000084,', '1', '2', null, '从化市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440200', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '韶关市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440203', '440200', '0,440000,440200,', '3', '00000044,00000000,00000003,', '1', '2', null, '武江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440204', '440200', '0,440000,440200,', '4', '00000044,00000000,00000004,', '1', '2', null, '浈江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440205', '440200', '0,440000,440200,', '5', '00000044,00000000,00000005,', '1', '2', null, '曲江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440222', '440200', '0,440000,440200,', '22', '00000044,00000000,00000022,', '1', '2', null, '始兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440224', '440200', '0,440000,440200,', '24', '00000044,00000000,00000024,', '1', '2', null, '仁化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440229', '440200', '0,440000,440200,', '29', '00000044,00000000,00000029,', '1', '2', null, '翁源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440232', '440200', '0,440000,440200,', '32', '00000044,00000000,00000032,', '1', '2', null, '乳源瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440233', '440200', '0,440000,440200,', '33', '00000044,00000000,00000033,', '1', '2', null, '新丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440281', '440200', '0,440000,440200,', '81', '00000044,00000000,00000081,', '1', '2', null, '乐昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440282', '440200', '0,440000,440200,', '82', '00000044,00000000,00000082,', '1', '2', null, '南雄市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440300', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '深圳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440303', '440300', '0,440000,440300,', '3', '00000044,00000000,00000003,', '1', '2', null, '罗湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440304', '440300', '0,440000,440300,', '4', '00000044,00000000,00000004,', '1', '2', null, '福田区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440305', '440300', '0,440000,440300,', '5', '00000044,00000000,00000005,', '1', '2', null, '南山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440306', '440300', '0,440000,440300,', '6', '00000044,00000000,00000006,', '1', '2', null, '宝安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440307', '440300', '0,440000,440300,', '7', '00000044,00000000,00000007,', '1', '2', null, '龙岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440308', '440300', '0,440000,440300,', '8', '00000044,00000000,00000008,', '1', '2', null, '盐田区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440400', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '珠海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440402', '440400', '0,440000,440400,', '2', '00000044,00000000,00000002,', '1', '2', null, '香洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440403', '440400', '0,440000,440400,', '3', '00000044,00000000,00000003,', '1', '2', null, '斗门区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440404', '440400', '0,440000,440400,', '4', '00000044,00000000,00000004,', '1', '2', null, '金湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440500', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '汕头市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440507', '440500', '0,440000,440500,', '7', '00000044,00000000,00000007,', '1', '2', null, '龙湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440511', '440500', '0,440000,440500,', '11', '00000044,00000000,00000011,', '1', '2', null, '金平区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440512', '440500', '0,440000,440500,', '12', '00000044,00000000,00000012,', '1', '2', null, '濠江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440513', '440500', '0,440000,440500,', '13', '00000044,00000000,00000013,', '1', '2', null, '潮阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440514', '440500', '0,440000,440500,', '14', '00000044,00000000,00000014,', '1', '2', null, '潮南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440515', '440500', '0,440000,440500,', '15', '00000044,00000000,00000015,', '1', '2', null, '澄海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440523', '440500', '0,440000,440500,', '23', '00000044,00000000,00000023,', '1', '2', null, '南澳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440600', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '佛山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440604', '440600', '0,440000,440600,', '4', '00000044,00000000,00000004,', '1', '2', null, '禅城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440605', '440600', '0,440000,440600,', '5', '00000044,00000000,00000005,', '1', '2', null, '南海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440606', '440600', '0,440000,440600,', '6', '00000044,00000000,00000006,', '1', '2', null, '顺德区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440607', '440600', '0,440000,440600,', '7', '00000044,00000000,00000007,', '1', '2', null, '三水区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440608', '440600', '0,440000,440600,', '8', '00000044,00000000,00000008,', '1', '2', null, '高明区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440700', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '江门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440703', '440700', '0,440000,440700,', '3', '00000044,00000000,00000003,', '1', '2', null, '蓬江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440704', '440700', '0,440000,440700,', '4', '00000044,00000000,00000004,', '1', '2', null, '江海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440705', '440700', '0,440000,440700,', '5', '00000044,00000000,00000005,', '1', '2', null, '新会区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440781', '440700', '0,440000,440700,', '81', '00000044,00000000,00000081,', '1', '2', null, '台山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440783', '440700', '0,440000,440700,', '83', '00000044,00000000,00000083,', '1', '2', null, '开平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440784', '440700', '0,440000,440700,', '84', '00000044,00000000,00000084,', '1', '2', null, '鹤山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440785', '440700', '0,440000,440700,', '85', '00000044,00000000,00000085,', '1', '2', null, '恩平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440800', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '湛江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440802', '440800', '0,440000,440800,', '2', '00000044,00000000,00000002,', '1', '2', null, '赤坎区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440803', '440800', '0,440000,440800,', '3', '00000044,00000000,00000003,', '1', '2', null, '霞山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440804', '440800', '0,440000,440800,', '4', '00000044,00000000,00000004,', '1', '2', null, '坡头区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440811', '440800', '0,440000,440800,', '11', '00000044,00000000,00000011,', '1', '2', null, '麻章区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440823', '440800', '0,440000,440800,', '23', '00000044,00000000,00000023,', '1', '2', null, '遂溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440825', '440800', '0,440000,440800,', '25', '00000044,00000000,00000025,', '1', '2', null, '徐闻县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440881', '440800', '0,440000,440800,', '81', '00000044,00000000,00000081,', '1', '2', null, '廉江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440882', '440800', '0,440000,440800,', '82', '00000044,00000000,00000082,', '1', '2', null, '雷州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440883', '440800', '0,440000,440800,', '83', '00000044,00000000,00000083,', '1', '2', null, '吴川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440900', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '茂名市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440902', '440900', '0,440000,440900,', '2', '00000044,00000000,00000002,', '1', '2', null, '茂南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440903', '440900', '0,440000,440900,', '3', '00000044,00000000,00000003,', '1', '2', null, '茂港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440923', '440900', '0,440000,440900,', '23', '00000044,00000000,00000023,', '1', '2', null, '电白县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440981', '440900', '0,440000,440900,', '81', '00000044,00000000,00000081,', '1', '2', null, '高州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440982', '440900', '0,440000,440900,', '82', '00000044,00000000,00000082,', '1', '2', null, '化州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('440983', '440900', '0,440000,440900,', '83', '00000044,00000000,00000083,', '1', '2', null, '信宜市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441200', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '肇庆市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441202', '441200', '0,440000,441200,', '2', '00000044,00000000,00000002,', '1', '2', null, '端州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441203', '441200', '0,440000,441200,', '3', '00000044,00000000,00000003,', '1', '2', null, '鼎湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441223', '441200', '0,440000,441200,', '23', '00000044,00000000,00000023,', '1', '2', null, '广宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441224', '441200', '0,440000,441200,', '24', '00000044,00000000,00000024,', '1', '2', null, '怀集县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441225', '441200', '0,440000,441200,', '25', '00000044,00000000,00000025,', '1', '2', null, '封开县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441226', '441200', '0,440000,441200,', '26', '00000044,00000000,00000026,', '1', '2', null, '德庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441283', '441200', '0,440000,441200,', '83', '00000044,00000000,00000083,', '1', '2', null, '高要市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441284', '441200', '0,440000,441200,', '84', '00000044,00000000,00000084,', '1', '2', null, '四会市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441300', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '惠州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441302', '441300', '0,440000,441300,', '2', '00000044,00000000,00000002,', '1', '2', null, '惠城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441303', '441300', '0,440000,441300,', '3', '00000044,00000000,00000003,', '1', '2', null, '惠阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441322', '441300', '0,440000,441300,', '22', '00000044,00000000,00000022,', '1', '2', null, '博罗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441323', '441300', '0,440000,441300,', '23', '00000044,00000000,00000023,', '1', '2', null, '惠东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441324', '441300', '0,440000,441300,', '24', '00000044,00000000,00000024,', '1', '2', null, '龙门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441400', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '梅州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441402', '441400', '0,440000,441400,', '2', '00000044,00000000,00000002,', '1', '2', null, '梅江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441421', '441400', '0,440000,441400,', '21', '00000044,00000000,00000021,', '1', '2', null, '梅　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441422', '441400', '0,440000,441400,', '22', '00000044,00000000,00000022,', '1', '2', null, '大埔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441423', '441400', '0,440000,441400,', '23', '00000044,00000000,00000023,', '1', '2', null, '丰顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441424', '441400', '0,440000,441400,', '24', '00000044,00000000,00000024,', '1', '2', null, '五华县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441426', '441400', '0,440000,441400,', '26', '00000044,00000000,00000026,', '1', '2', null, '平远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441427', '441400', '0,440000,441400,', '27', '00000044,00000000,00000027,', '1', '2', null, '蕉岭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441481', '441400', '0,440000,441400,', '81', '00000044,00000000,00000081,', '1', '2', null, '兴宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441500', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '汕尾市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441502', '441500', '0,440000,441500,', '2', '00000044,00000000,00000002,', '1', '2', null, '城　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441521', '441500', '0,440000,441500,', '21', '00000044,00000000,00000021,', '1', '2', null, '海丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441523', '441500', '0,440000,441500,', '23', '00000044,00000000,00000023,', '1', '2', null, '陆河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441581', '441500', '0,440000,441500,', '81', '00000044,00000000,00000081,', '1', '2', null, '陆丰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441600', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '河源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441602', '441600', '0,440000,441600,', '2', '00000044,00000000,00000002,', '1', '2', null, '源城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441621', '441600', '0,440000,441600,', '21', '00000044,00000000,00000021,', '1', '2', null, '紫金县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441622', '441600', '0,440000,441600,', '22', '00000044,00000000,00000022,', '1', '2', null, '龙川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441623', '441600', '0,440000,441600,', '23', '00000044,00000000,00000023,', '1', '2', null, '连平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441624', '441600', '0,440000,441600,', '24', '00000044,00000000,00000024,', '1', '2', null, '和平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441625', '441600', '0,440000,441600,', '25', '00000044,00000000,00000025,', '1', '2', null, '东源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441700', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '阳江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441702', '441700', '0,440000,441700,', '2', '00000044,00000000,00000002,', '1', '2', null, '江城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441721', '441700', '0,440000,441700,', '21', '00000044,00000000,00000021,', '1', '2', null, '阳西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441723', '441700', '0,440000,441700,', '23', '00000044,00000000,00000023,', '1', '2', null, '阳东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441781', '441700', '0,440000,441700,', '81', '00000044,00000000,00000081,', '1', '2', null, '阳春市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441800', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '清远市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441802', '441800', '0,440000,441800,', '2', '00000044,00000000,00000002,', '1', '2', null, '清城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441821', '441800', '0,440000,441800,', '21', '00000044,00000000,00000021,', '1', '2', null, '佛冈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441823', '441800', '0,440000,441800,', '23', '00000044,00000000,00000023,', '1', '2', null, '阳山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441825', '441800', '0,440000,441800,', '25', '00000044,00000000,00000025,', '1', '2', null, '连山壮族瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441826', '441800', '0,440000,441800,', '26', '00000044,00000000,00000026,', '1', '2', null, '连南瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441827', '441800', '0,440000,441800,', '27', '00000044,00000000,00000027,', '1', '2', null, '清新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441881', '441800', '0,440000,441800,', '81', '00000044,00000000,00000081,', '1', '2', null, '英德市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441882', '441800', '0,440000,441800,', '82', '00000044,00000000,00000082,', '1', '2', null, '连州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('441900', '440000', '0,440000,', '0', '00000044,00000000,', '1', '1', null, '东莞市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('442000', '440000', '0,440000,', '0', '00000044,00000000,', '1', '1', null, '中山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445100', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '潮州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445102', '445100', '0,440000,445100,', '2', '00000044,00000000,00000002,', '1', '2', null, '湘桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445121', '445100', '0,440000,445100,', '21', '00000044,00000000,00000021,', '1', '2', null, '潮安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445122', '445100', '0,440000,445100,', '22', '00000044,00000000,00000022,', '1', '2', null, '饶平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445200', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '揭阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445202', '445200', '0,440000,445200,', '2', '00000044,00000000,00000002,', '1', '2', null, '榕城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445221', '445200', '0,440000,445200,', '21', '00000044,00000000,00000021,', '1', '2', null, '揭东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445222', '445200', '0,440000,445200,', '22', '00000044,00000000,00000022,', '1', '2', null, '揭西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445224', '445200', '0,440000,445200,', '24', '00000044,00000000,00000024,', '1', '2', null, '惠来县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445281', '445200', '0,440000,445200,', '81', '00000044,00000000,00000081,', '1', '2', null, '普宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445300', '440000', '0,440000,', '0', '00000044,00000000,', '0', '1', null, '云浮市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445302', '445300', '0,440000,445300,', '2', '00000044,00000000,00000002,', '1', '2', null, '云城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445321', '445300', '0,440000,445300,', '21', '00000044,00000000,00000021,', '1', '2', null, '新兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445322', '445300', '0,440000,445300,', '22', '00000044,00000000,00000022,', '1', '2', null, '郁南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445323', '445300', '0,440000,445300,', '23', '00000044,00000000,00000023,', '1', '2', null, '云安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('445381', '445300', '0,440000,445300,', '81', '00000044,00000000,00000081,', '1', '2', null, '罗定市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450000', '0', '0,', '45', '00000045,', '0', '0', null, '广西壮族自治区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450100', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '南宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450102', '450100', '0,450000,450100,', '2', '00000045,00000000,00000002,', '1', '2', null, '兴宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450103', '450100', '0,450000,450100,', '3', '00000045,00000000,00000003,', '1', '2', null, '青秀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450105', '450100', '0,450000,450100,', '5', '00000045,00000000,00000005,', '1', '2', null, '江南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450107', '450100', '0,450000,450100,', '7', '00000045,00000000,00000007,', '1', '2', null, '西乡塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450108', '450100', '0,450000,450100,', '8', '00000045,00000000,00000008,', '1', '2', null, '良庆区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450109', '450100', '0,450000,450100,', '9', '00000045,00000000,00000009,', '1', '2', null, '邕宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450122', '450100', '0,450000,450100,', '22', '00000045,00000000,00000022,', '1', '2', null, '武鸣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450123', '450100', '0,450000,450100,', '23', '00000045,00000000,00000023,', '1', '2', null, '隆安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450124', '450100', '0,450000,450100,', '24', '00000045,00000000,00000024,', '1', '2', null, '马山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450125', '450100', '0,450000,450100,', '25', '00000045,00000000,00000025,', '1', '2', null, '上林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450126', '450100', '0,450000,450100,', '26', '00000045,00000000,00000026,', '1', '2', null, '宾阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450127', '450100', '0,450000,450100,', '27', '00000045,00000000,00000027,', '1', '2', null, '横　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450200', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '柳州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450202', '450200', '0,450000,450200,', '2', '00000045,00000000,00000002,', '1', '2', null, '城中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450203', '450200', '0,450000,450200,', '3', '00000045,00000000,00000003,', '1', '2', null, '鱼峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450204', '450200', '0,450000,450200,', '4', '00000045,00000000,00000004,', '1', '2', null, '柳南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450205', '450200', '0,450000,450200,', '5', '00000045,00000000,00000005,', '1', '2', null, '柳北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450221', '450200', '0,450000,450200,', '21', '00000045,00000000,00000021,', '1', '2', null, '柳江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450222', '450200', '0,450000,450200,', '22', '00000045,00000000,00000022,', '1', '2', null, '柳城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450223', '450200', '0,450000,450200,', '23', '00000045,00000000,00000023,', '1', '2', null, '鹿寨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450224', '450200', '0,450000,450200,', '24', '00000045,00000000,00000024,', '1', '2', null, '融安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450225', '450200', '0,450000,450200,', '25', '00000045,00000000,00000025,', '1', '2', null, '融水苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450226', '450200', '0,450000,450200,', '26', '00000045,00000000,00000026,', '1', '2', null, '三江侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450300', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '桂林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450302', '450300', '0,450000,450300,', '2', '00000045,00000000,00000002,', '1', '2', null, '秀峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450303', '450300', '0,450000,450300,', '3', '00000045,00000000,00000003,', '1', '2', null, '叠彩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450304', '450300', '0,450000,450300,', '4', '00000045,00000000,00000004,', '1', '2', null, '象山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450305', '450300', '0,450000,450300,', '5', '00000045,00000000,00000005,', '1', '2', null, '七星区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450311', '450300', '0,450000,450300,', '11', '00000045,00000000,00000011,', '1', '2', null, '雁山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450321', '450300', '0,450000,450300,', '21', '00000045,00000000,00000021,', '1', '2', null, '阳朔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450322', '450300', '0,450000,450300,', '22', '00000045,00000000,00000022,', '1', '2', null, '临桂县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450323', '450300', '0,450000,450300,', '23', '00000045,00000000,00000023,', '1', '2', null, '灵川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450324', '450300', '0,450000,450300,', '24', '00000045,00000000,00000024,', '1', '2', null, '全州县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450325', '450300', '0,450000,450300,', '25', '00000045,00000000,00000025,', '1', '2', null, '兴安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450326', '450300', '0,450000,450300,', '26', '00000045,00000000,00000026,', '1', '2', null, '永福县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450327', '450300', '0,450000,450300,', '27', '00000045,00000000,00000027,', '1', '2', null, '灌阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450328', '450300', '0,450000,450300,', '28', '00000045,00000000,00000028,', '1', '2', null, '龙胜各族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450329', '450300', '0,450000,450300,', '29', '00000045,00000000,00000029,', '1', '2', null, '资源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450330', '450300', '0,450000,450300,', '30', '00000045,00000000,00000030,', '1', '2', null, '平乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450331', '450300', '0,450000,450300,', '31', '00000045,00000000,00000031,', '1', '2', null, '荔蒲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450332', '450300', '0,450000,450300,', '32', '00000045,00000000,00000032,', '1', '2', null, '恭城瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450400', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '梧州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450403', '450400', '0,450000,450400,', '3', '00000045,00000000,00000003,', '1', '2', null, '万秀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450404', '450400', '0,450000,450400,', '4', '00000045,00000000,00000004,', '1', '2', null, '蝶山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450405', '450400', '0,450000,450400,', '5', '00000045,00000000,00000005,', '1', '2', null, '长洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450421', '450400', '0,450000,450400,', '21', '00000045,00000000,00000021,', '1', '2', null, '苍梧县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450422', '450400', '0,450000,450400,', '22', '00000045,00000000,00000022,', '1', '2', null, '藤　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450423', '450400', '0,450000,450400,', '23', '00000045,00000000,00000023,', '1', '2', null, '蒙山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450481', '450400', '0,450000,450400,', '81', '00000045,00000000,00000081,', '1', '2', null, '岑溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450500', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '北海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450502', '450500', '0,450000,450500,', '2', '00000045,00000000,00000002,', '1', '2', null, '海城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450503', '450500', '0,450000,450500,', '3', '00000045,00000000,00000003,', '1', '2', null, '银海区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450512', '450500', '0,450000,450500,', '12', '00000045,00000000,00000012,', '1', '2', null, '铁山港区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450521', '450500', '0,450000,450500,', '21', '00000045,00000000,00000021,', '1', '2', null, '合浦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450600', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '防城港市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450602', '450600', '0,450000,450600,', '2', '00000045,00000000,00000002,', '1', '2', null, '港口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450603', '450600', '0,450000,450600,', '3', '00000045,00000000,00000003,', '1', '2', null, '防城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450621', '450600', '0,450000,450600,', '21', '00000045,00000000,00000021,', '1', '2', null, '上思县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450681', '450600', '0,450000,450600,', '81', '00000045,00000000,00000081,', '1', '2', null, '东兴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450700', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '钦州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450702', '450700', '0,450000,450700,', '2', '00000045,00000000,00000002,', '1', '2', null, '钦南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450703', '450700', '0,450000,450700,', '3', '00000045,00000000,00000003,', '1', '2', null, '钦北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450721', '450700', '0,450000,450700,', '21', '00000045,00000000,00000021,', '1', '2', null, '灵山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450722', '450700', '0,450000,450700,', '22', '00000045,00000000,00000022,', '1', '2', null, '浦北县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450800', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '贵港市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450802', '450800', '0,450000,450800,', '2', '00000045,00000000,00000002,', '1', '2', null, '港北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450803', '450800', '0,450000,450800,', '3', '00000045,00000000,00000003,', '1', '2', null, '港南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450804', '450800', '0,450000,450800,', '4', '00000045,00000000,00000004,', '1', '2', null, '覃塘区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450821', '450800', '0,450000,450800,', '21', '00000045,00000000,00000021,', '1', '2', null, '平南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450881', '450800', '0,450000,450800,', '81', '00000045,00000000,00000081,', '1', '2', null, '桂平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450900', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '玉林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450902', '450900', '0,450000,450900,', '2', '00000045,00000000,00000002,', '1', '2', null, '玉州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450921', '450900', '0,450000,450900,', '21', '00000045,00000000,00000021,', '1', '2', null, '容　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450922', '450900', '0,450000,450900,', '22', '00000045,00000000,00000022,', '1', '2', null, '陆川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450923', '450900', '0,450000,450900,', '23', '00000045,00000000,00000023,', '1', '2', null, '博白县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450924', '450900', '0,450000,450900,', '24', '00000045,00000000,00000024,', '1', '2', null, '兴业县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('450981', '450900', '0,450000,450900,', '81', '00000045,00000000,00000081,', '1', '2', null, '北流市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451000', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '百色市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451002', '451000', '0,450000,451000,', '2', '00000045,00000000,00000002,', '1', '2', null, '右江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451021', '451000', '0,450000,451000,', '21', '00000045,00000000,00000021,', '1', '2', null, '田阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451022', '451000', '0,450000,451000,', '22', '00000045,00000000,00000022,', '1', '2', null, '田东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451023', '451000', '0,450000,451000,', '23', '00000045,00000000,00000023,', '1', '2', null, '平果县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451024', '451000', '0,450000,451000,', '24', '00000045,00000000,00000024,', '1', '2', null, '德保县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451025', '451000', '0,450000,451000,', '25', '00000045,00000000,00000025,', '1', '2', null, '靖西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451026', '451000', '0,450000,451000,', '26', '00000045,00000000,00000026,', '1', '2', null, '那坡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451027', '451000', '0,450000,451000,', '27', '00000045,00000000,00000027,', '1', '2', null, '凌云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451028', '451000', '0,450000,451000,', '28', '00000045,00000000,00000028,', '1', '2', null, '乐业县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451029', '451000', '0,450000,451000,', '29', '00000045,00000000,00000029,', '1', '2', null, '田林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451030', '451000', '0,450000,451000,', '30', '00000045,00000000,00000030,', '1', '2', null, '西林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451031', '451000', '0,450000,451000,', '31', '00000045,00000000,00000031,', '1', '2', null, '隆林各族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451100', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '贺州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451102', '451100', '0,450000,451100,', '2', '00000045,00000000,00000002,', '1', '2', null, '八步区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451121', '451100', '0,450000,451100,', '21', '00000045,00000000,00000021,', '1', '2', null, '昭平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451122', '451100', '0,450000,451100,', '22', '00000045,00000000,00000022,', '1', '2', null, '钟山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451123', '451100', '0,450000,451100,', '23', '00000045,00000000,00000023,', '1', '2', null, '富川瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451200', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '河池市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451202', '451200', '0,450000,451200,', '2', '00000045,00000000,00000002,', '1', '2', null, '金城江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451221', '451200', '0,450000,451200,', '21', '00000045,00000000,00000021,', '1', '2', null, '南丹县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451222', '451200', '0,450000,451200,', '22', '00000045,00000000,00000022,', '1', '2', null, '天峨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451223', '451200', '0,450000,451200,', '23', '00000045,00000000,00000023,', '1', '2', null, '凤山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451224', '451200', '0,450000,451200,', '24', '00000045,00000000,00000024,', '1', '2', null, '东兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451225', '451200', '0,450000,451200,', '25', '00000045,00000000,00000025,', '1', '2', null, '罗城仫佬族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451226', '451200', '0,450000,451200,', '26', '00000045,00000000,00000026,', '1', '2', null, '环江毛南族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451227', '451200', '0,450000,451200,', '27', '00000045,00000000,00000027,', '1', '2', null, '巴马瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451228', '451200', '0,450000,451200,', '28', '00000045,00000000,00000028,', '1', '2', null, '都安瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451229', '451200', '0,450000,451200,', '29', '00000045,00000000,00000029,', '1', '2', null, '大化瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451281', '451200', '0,450000,451200,', '81', '00000045,00000000,00000081,', '1', '2', null, '宜州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451300', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '来宾市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451302', '451300', '0,450000,451300,', '2', '00000045,00000000,00000002,', '1', '2', null, '兴宾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451321', '451300', '0,450000,451300,', '21', '00000045,00000000,00000021,', '1', '2', null, '忻城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451322', '451300', '0,450000,451300,', '22', '00000045,00000000,00000022,', '1', '2', null, '象州县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451323', '451300', '0,450000,451300,', '23', '00000045,00000000,00000023,', '1', '2', null, '武宣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451324', '451300', '0,450000,451300,', '24', '00000045,00000000,00000024,', '1', '2', null, '金秀瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451381', '451300', '0,450000,451300,', '81', '00000045,00000000,00000081,', '1', '2', null, '合山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451400', '450000', '0,450000,', '0', '00000045,00000000,', '0', '1', null, '崇左市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451402', '451400', '0,450000,451400,', '2', '00000045,00000000,00000002,', '1', '2', null, '江洲区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451421', '451400', '0,450000,451400,', '21', '00000045,00000000,00000021,', '1', '2', null, '扶绥县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451422', '451400', '0,450000,451400,', '22', '00000045,00000000,00000022,', '1', '2', null, '宁明县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451423', '451400', '0,450000,451400,', '23', '00000045,00000000,00000023,', '1', '2', null, '龙州县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451424', '451400', '0,450000,451400,', '24', '00000045,00000000,00000024,', '1', '2', null, '大新县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451425', '451400', '0,450000,451400,', '25', '00000045,00000000,00000025,', '1', '2', null, '天等县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('451481', '451400', '0,450000,451400,', '81', '00000045,00000000,00000081,', '1', '2', null, '凭祥市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460000', '0', '0,', '46', '00000046,', '0', '0', null, '海南省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460100', '460000', '0,460000,', '0', '00000046,00000000,', '0', '1', null, '海口市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460105', '460100', '0,460000,460100,', '5', '00000046,00000000,00000005,', '1', '2', null, '秀英区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460106', '460100', '0,460000,460100,', '6', '00000046,00000000,00000006,', '1', '2', null, '龙华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460107', '460100', '0,460000,460100,', '7', '00000046,00000000,00000007,', '1', '2', null, '琼山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460108', '460100', '0,460000,460100,', '8', '00000046,00000000,00000008,', '1', '2', null, '美兰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('460200', '460000', '0,460000,', '0', '00000046,00000000,', '1', '1', null, '三亚市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469000', '460000', '0,460000,', '0', '00000046,00000000,', '0', '1', null, '省直辖县级行政单位', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469001', '469000', '0,460000,469000,', '1', '00000046,00000000,00000001,', '1', '2', null, '五指山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469002', '469000', '0,460000,469000,', '2', '00000046,00000000,00000002,', '1', '2', null, '琼海市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469003', '469000', '0,460000,469000,', '3', '00000046,00000000,00000003,', '1', '2', null, '儋州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469005', '469000', '0,460000,469000,', '5', '00000046,00000000,00000005,', '1', '2', null, '文昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469006', '469000', '0,460000,469000,', '6', '00000046,00000000,00000006,', '1', '2', null, '万宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469007', '469000', '0,460000,469000,', '7', '00000046,00000000,00000007,', '1', '2', null, '东方市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469025', '469000', '0,460000,469000,', '25', '00000046,00000000,00000025,', '1', '2', null, '定安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469026', '469000', '0,460000,469000,', '26', '00000046,00000000,00000026,', '1', '2', null, '屯昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469027', '469000', '0,460000,469000,', '27', '00000046,00000000,00000027,', '1', '2', null, '澄迈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469028', '469000', '0,460000,469000,', '28', '00000046,00000000,00000028,', '1', '2', null, '临高县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469030', '469000', '0,460000,469000,', '30', '00000046,00000000,00000030,', '1', '2', null, '白沙黎族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469031', '469000', '0,460000,469000,', '31', '00000046,00000000,00000031,', '1', '2', null, '昌江黎族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469033', '469000', '0,460000,469000,', '33', '00000046,00000000,00000033,', '1', '2', null, '乐东黎族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469034', '469000', '0,460000,469000,', '34', '00000046,00000000,00000034,', '1', '2', null, '陵水黎族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469035', '469000', '0,460000,469000,', '35', '00000046,00000000,00000035,', '1', '2', null, '保亭黎族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469036', '469000', '0,460000,469000,', '36', '00000046,00000000,00000036,', '1', '2', null, '琼中黎族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469037', '469000', '0,460000,469000,', '37', '00000046,00000000,00000037,', '1', '2', null, '西沙群岛', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469038', '469000', '0,460000,469000,', '38', '00000046,00000000,00000038,', '1', '2', null, '南沙群岛', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('469039', '469000', '0,460000,469000,', '39', '00000046,00000000,00000039,', '1', '2', null, '中沙群岛的岛礁及其海域', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500000', '0', '0,', '50', '00000050,', '0', '0', null, '重庆市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500100', '500000', '0,500000,', '0', '00000050,00000000,', '0', '1', null, '市辖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500101', '500100', '0,500000,500100,', '1', '00000050,00000000,00000001,', '1', '2', null, '万州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500102', '500100', '0,500000,500100,', '2', '00000050,00000000,00000002,', '1', '2', null, '涪陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500103', '500100', '0,500000,500100,', '3', '00000050,00000000,00000003,', '1', '2', null, '渝中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500104', '500100', '0,500000,500100,', '4', '00000050,00000000,00000004,', '1', '2', null, '大渡口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500105', '500100', '0,500000,500100,', '5', '00000050,00000000,00000005,', '1', '2', null, '江北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500106', '500100', '0,500000,500100,', '6', '00000050,00000000,00000006,', '1', '2', null, '沙坪坝区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500107', '500100', '0,500000,500100,', '7', '00000050,00000000,00000007,', '1', '2', null, '九龙坡区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500108', '500100', '0,500000,500100,', '8', '00000050,00000000,00000008,', '1', '2', null, '南岸区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500109', '500100', '0,500000,500100,', '9', '00000050,00000000,00000009,', '1', '2', null, '北碚区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500110', '500100', '0,500000,500100,', '10', '00000050,00000000,00000010,', '1', '2', null, '万盛区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500111', '500100', '0,500000,500100,', '11', '00000050,00000000,00000011,', '1', '2', null, '双桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500112', '500100', '0,500000,500100,', '12', '00000050,00000000,00000012,', '1', '2', null, '渝北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500113', '500100', '0,500000,500100,', '13', '00000050,00000000,00000013,', '1', '2', null, '巴南区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500114', '500100', '0,500000,500100,', '14', '00000050,00000000,00000014,', '1', '2', null, '黔江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500115', '500100', '0,500000,500100,', '15', '00000050,00000000,00000015,', '1', '2', null, '长寿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500200', '500000', '0,500000,', '0', '00000050,00000000,', '0', '1', null, '县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500222', '500200', '0,500000,500200,', '22', '00000050,00000000,00000022,', '1', '2', null, '綦江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500223', '500200', '0,500000,500200,', '23', '00000050,00000000,00000023,', '1', '2', null, '潼南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500224', '500200', '0,500000,500200,', '24', '00000050,00000000,00000024,', '1', '2', null, '铜梁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500225', '500200', '0,500000,500200,', '25', '00000050,00000000,00000025,', '1', '2', null, '大足县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500226', '500200', '0,500000,500200,', '26', '00000050,00000000,00000026,', '1', '2', null, '荣昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500227', '500200', '0,500000,500200,', '27', '00000050,00000000,00000027,', '1', '2', null, '璧山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500228', '500200', '0,500000,500200,', '28', '00000050,00000000,00000028,', '1', '2', null, '梁平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500229', '500200', '0,500000,500200,', '29', '00000050,00000000,00000029,', '1', '2', null, '城口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500230', '500200', '0,500000,500200,', '30', '00000050,00000000,00000030,', '1', '2', null, '丰都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500231', '500200', '0,500000,500200,', '31', '00000050,00000000,00000031,', '1', '2', null, '垫江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500232', '500200', '0,500000,500200,', '32', '00000050,00000000,00000032,', '1', '2', null, '武隆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500233', '500200', '0,500000,500200,', '33', '00000050,00000000,00000033,', '1', '2', null, '忠　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500234', '500200', '0,500000,500200,', '34', '00000050,00000000,00000034,', '1', '2', null, '开　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500235', '500200', '0,500000,500200,', '35', '00000050,00000000,00000035,', '1', '2', null, '云阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500236', '500200', '0,500000,500200,', '36', '00000050,00000000,00000036,', '1', '2', null, '奉节县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500237', '500200', '0,500000,500200,', '37', '00000050,00000000,00000037,', '1', '2', null, '巫山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500238', '500200', '0,500000,500200,', '38', '00000050,00000000,00000038,', '1', '2', null, '巫溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500240', '500200', '0,500000,500200,', '40', '00000050,00000000,00000040,', '1', '2', null, '石柱土家族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500241', '500200', '0,500000,500200,', '41', '00000050,00000000,00000041,', '1', '2', null, '秀山土家族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500242', '500200', '0,500000,500200,', '42', '00000050,00000000,00000042,', '1', '2', null, '酉阳土家族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500243', '500200', '0,500000,500200,', '43', '00000050,00000000,00000043,', '1', '2', null, '彭水苗族土家族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500300', '500000', '0,500000,', '0', '00000050,00000000,', '0', '1', null, '市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500381', '500300', '0,500000,500300,', '81', '00000050,00000000,00000081,', '1', '2', null, '江津市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500382', '500300', '0,500000,500300,', '82', '00000050,00000000,00000082,', '1', '2', null, '合川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500383', '500300', '0,500000,500300,', '83', '00000050,00000000,00000083,', '1', '2', null, '永川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('500384', '500300', '0,500000,500300,', '84', '00000050,00000000,00000084,', '1', '2', null, '南川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510000', '0', '0,', '51', '00000051,', '0', '0', null, '四川省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510100', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '成都市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510104', '510100', '0,510000,510100,', '4', '00000051,00000000,00000004,', '1', '2', null, '锦江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510105', '510100', '0,510000,510100,', '5', '00000051,00000000,00000005,', '1', '2', null, '青羊区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510106', '510100', '0,510000,510100,', '6', '00000051,00000000,00000006,', '1', '2', null, '金牛区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510107', '510100', '0,510000,510100,', '7', '00000051,00000000,00000007,', '1', '2', null, '武侯区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510108', '510100', '0,510000,510100,', '8', '00000051,00000000,00000008,', '1', '2', null, '成华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510112', '510100', '0,510000,510100,', '12', '00000051,00000000,00000012,', '1', '2', null, '龙泉驿区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510113', '510100', '0,510000,510100,', '13', '00000051,00000000,00000013,', '1', '2', null, '青白江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510114', '510100', '0,510000,510100,', '14', '00000051,00000000,00000014,', '1', '2', null, '新都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510115', '510100', '0,510000,510100,', '15', '00000051,00000000,00000015,', '1', '2', null, '温江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510121', '510100', '0,510000,510100,', '21', '00000051,00000000,00000021,', '1', '2', null, '金堂县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510122', '510100', '0,510000,510100,', '22', '00000051,00000000,00000022,', '1', '2', null, '双流县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510124', '510100', '0,510000,510100,', '24', '00000051,00000000,00000024,', '1', '2', null, '郫　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510129', '510100', '0,510000,510100,', '29', '00000051,00000000,00000029,', '1', '2', null, '大邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510131', '510100', '0,510000,510100,', '31', '00000051,00000000,00000031,', '1', '2', null, '蒲江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510132', '510100', '0,510000,510100,', '32', '00000051,00000000,00000032,', '1', '2', null, '新津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510181', '510100', '0,510000,510100,', '81', '00000051,00000000,00000081,', '1', '2', null, '都江堰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510182', '510100', '0,510000,510100,', '82', '00000051,00000000,00000082,', '1', '2', null, '彭州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510183', '510100', '0,510000,510100,', '83', '00000051,00000000,00000083,', '1', '2', null, '邛崃市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510184', '510100', '0,510000,510100,', '84', '00000051,00000000,00000084,', '1', '2', null, '崇州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510300', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '自贡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510302', '510300', '0,510000,510300,', '2', '00000051,00000000,00000002,', '1', '2', null, '自流井区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510303', '510300', '0,510000,510300,', '3', '00000051,00000000,00000003,', '1', '2', null, '贡井区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510304', '510300', '0,510000,510300,', '4', '00000051,00000000,00000004,', '1', '2', null, '大安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510311', '510300', '0,510000,510300,', '11', '00000051,00000000,00000011,', '1', '2', null, '沿滩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510321', '510300', '0,510000,510300,', '21', '00000051,00000000,00000021,', '1', '2', null, '荣　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510322', '510300', '0,510000,510300,', '22', '00000051,00000000,00000022,', '1', '2', null, '富顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510400', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '攀枝花市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510402', '510400', '0,510000,510400,', '2', '00000051,00000000,00000002,', '1', '2', null, '东　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510403', '510400', '0,510000,510400,', '3', '00000051,00000000,00000003,', '1', '2', null, '西　区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510411', '510400', '0,510000,510400,', '11', '00000051,00000000,00000011,', '1', '2', null, '仁和区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510421', '510400', '0,510000,510400,', '21', '00000051,00000000,00000021,', '1', '2', null, '米易县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510422', '510400', '0,510000,510400,', '22', '00000051,00000000,00000022,', '1', '2', null, '盐边县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510500', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '泸州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510502', '510500', '0,510000,510500,', '2', '00000051,00000000,00000002,', '1', '2', null, '江阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510503', '510500', '0,510000,510500,', '3', '00000051,00000000,00000003,', '1', '2', null, '纳溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510504', '510500', '0,510000,510500,', '4', '00000051,00000000,00000004,', '1', '2', null, '龙马潭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510521', '510500', '0,510000,510500,', '21', '00000051,00000000,00000021,', '1', '2', null, '泸　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510522', '510500', '0,510000,510500,', '22', '00000051,00000000,00000022,', '1', '2', null, '合江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510524', '510500', '0,510000,510500,', '24', '00000051,00000000,00000024,', '1', '2', null, '叙永县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510525', '510500', '0,510000,510500,', '25', '00000051,00000000,00000025,', '1', '2', null, '古蔺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510600', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '德阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510603', '510600', '0,510000,510600,', '3', '00000051,00000000,00000003,', '1', '2', null, '旌阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510623', '510600', '0,510000,510600,', '23', '00000051,00000000,00000023,', '1', '2', null, '中江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510626', '510600', '0,510000,510600,', '26', '00000051,00000000,00000026,', '1', '2', null, '罗江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510681', '510600', '0,510000,510600,', '81', '00000051,00000000,00000081,', '1', '2', null, '广汉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510682', '510600', '0,510000,510600,', '82', '00000051,00000000,00000082,', '1', '2', null, '什邡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510683', '510600', '0,510000,510600,', '83', '00000051,00000000,00000083,', '1', '2', null, '绵竹市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510700', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '绵阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510703', '510700', '0,510000,510700,', '3', '00000051,00000000,00000003,', '1', '2', null, '涪城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510704', '510700', '0,510000,510700,', '4', '00000051,00000000,00000004,', '1', '2', null, '游仙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510722', '510700', '0,510000,510700,', '22', '00000051,00000000,00000022,', '1', '2', null, '三台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510723', '510700', '0,510000,510700,', '23', '00000051,00000000,00000023,', '1', '2', null, '盐亭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510724', '510700', '0,510000,510700,', '24', '00000051,00000000,00000024,', '1', '2', null, '安　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510725', '510700', '0,510000,510700,', '25', '00000051,00000000,00000025,', '1', '2', null, '梓潼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510726', '510700', '0,510000,510700,', '26', '00000051,00000000,00000026,', '1', '2', null, '北川羌族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510727', '510700', '0,510000,510700,', '27', '00000051,00000000,00000027,', '1', '2', null, '平武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510781', '510700', '0,510000,510700,', '81', '00000051,00000000,00000081,', '1', '2', null, '江油市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510800', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '广元市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510802', '510800', '0,510000,510800,', '2', '00000051,00000000,00000002,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510811', '510800', '0,510000,510800,', '11', '00000051,00000000,00000011,', '1', '2', null, '元坝区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510812', '510800', '0,510000,510800,', '12', '00000051,00000000,00000012,', '1', '2', null, '朝天区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510821', '510800', '0,510000,510800,', '21', '00000051,00000000,00000021,', '1', '2', null, '旺苍县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510822', '510800', '0,510000,510800,', '22', '00000051,00000000,00000022,', '1', '2', null, '青川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510823', '510800', '0,510000,510800,', '23', '00000051,00000000,00000023,', '1', '2', null, '剑阁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510824', '510800', '0,510000,510800,', '24', '00000051,00000000,00000024,', '1', '2', null, '苍溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510900', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '遂宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510903', '510900', '0,510000,510900,', '3', '00000051,00000000,00000003,', '1', '2', null, '船山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510904', '510900', '0,510000,510900,', '4', '00000051,00000000,00000004,', '1', '2', null, '安居区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510921', '510900', '0,510000,510900,', '21', '00000051,00000000,00000021,', '1', '2', null, '蓬溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510922', '510900', '0,510000,510900,', '22', '00000051,00000000,00000022,', '1', '2', null, '射洪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('510923', '510900', '0,510000,510900,', '23', '00000051,00000000,00000023,', '1', '2', null, '大英县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511000', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '内江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511002', '511000', '0,510000,511000,', '2', '00000051,00000000,00000002,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511011', '511000', '0,510000,511000,', '11', '00000051,00000000,00000011,', '1', '2', null, '东兴区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511024', '511000', '0,510000,511000,', '24', '00000051,00000000,00000024,', '1', '2', null, '威远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511025', '511000', '0,510000,511000,', '25', '00000051,00000000,00000025,', '1', '2', null, '资中县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511028', '511000', '0,510000,511000,', '28', '00000051,00000000,00000028,', '1', '2', null, '隆昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511100', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '乐山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511102', '511100', '0,510000,511100,', '2', '00000051,00000000,00000002,', '1', '2', null, '市中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511111', '511100', '0,510000,511100,', '11', '00000051,00000000,00000011,', '1', '2', null, '沙湾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511112', '511100', '0,510000,511100,', '12', '00000051,00000000,00000012,', '1', '2', null, '五通桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511113', '511100', '0,510000,511100,', '13', '00000051,00000000,00000013,', '1', '2', null, '金口河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511123', '511100', '0,510000,511100,', '23', '00000051,00000000,00000023,', '1', '2', null, '犍为县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511124', '511100', '0,510000,511100,', '24', '00000051,00000000,00000024,', '1', '2', null, '井研县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511126', '511100', '0,510000,511100,', '26', '00000051,00000000,00000026,', '1', '2', null, '夹江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511129', '511100', '0,510000,511100,', '29', '00000051,00000000,00000029,', '1', '2', null, '沐川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511132', '511100', '0,510000,511100,', '32', '00000051,00000000,00000032,', '1', '2', null, '峨边彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511133', '511100', '0,510000,511100,', '33', '00000051,00000000,00000033,', '1', '2', null, '马边彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511181', '511100', '0,510000,511100,', '81', '00000051,00000000,00000081,', '1', '2', null, '峨眉山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511300', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '南充市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511302', '511300', '0,510000,511300,', '2', '00000051,00000000,00000002,', '1', '2', null, '顺庆区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511303', '511300', '0,510000,511300,', '3', '00000051,00000000,00000003,', '1', '2', null, '高坪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511304', '511300', '0,510000,511300,', '4', '00000051,00000000,00000004,', '1', '2', null, '嘉陵区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511321', '511300', '0,510000,511300,', '21', '00000051,00000000,00000021,', '1', '2', null, '南部县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511322', '511300', '0,510000,511300,', '22', '00000051,00000000,00000022,', '1', '2', null, '营山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511323', '511300', '0,510000,511300,', '23', '00000051,00000000,00000023,', '1', '2', null, '蓬安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511324', '511300', '0,510000,511300,', '24', '00000051,00000000,00000024,', '1', '2', null, '仪陇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511325', '511300', '0,510000,511300,', '25', '00000051,00000000,00000025,', '1', '2', null, '西充县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511381', '511300', '0,510000,511300,', '81', '00000051,00000000,00000081,', '1', '2', null, '阆中市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511400', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '眉山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511402', '511400', '0,510000,511400,', '2', '00000051,00000000,00000002,', '1', '2', null, '东坡区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511421', '511400', '0,510000,511400,', '21', '00000051,00000000,00000021,', '1', '2', null, '仁寿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511422', '511400', '0,510000,511400,', '22', '00000051,00000000,00000022,', '1', '2', null, '彭山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511423', '511400', '0,510000,511400,', '23', '00000051,00000000,00000023,', '1', '2', null, '洪雅县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511424', '511400', '0,510000,511400,', '24', '00000051,00000000,00000024,', '1', '2', null, '丹棱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511425', '511400', '0,510000,511400,', '25', '00000051,00000000,00000025,', '1', '2', null, '青神县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511500', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '宜宾市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511502', '511500', '0,510000,511500,', '2', '00000051,00000000,00000002,', '1', '2', null, '翠屏区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511521', '511500', '0,510000,511500,', '21', '00000051,00000000,00000021,', '1', '2', null, '宜宾县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511522', '511500', '0,510000,511500,', '22', '00000051,00000000,00000022,', '1', '2', null, '南溪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511523', '511500', '0,510000,511500,', '23', '00000051,00000000,00000023,', '1', '2', null, '江安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511524', '511500', '0,510000,511500,', '24', '00000051,00000000,00000024,', '1', '2', null, '长宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511525', '511500', '0,510000,511500,', '25', '00000051,00000000,00000025,', '1', '2', null, '高　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511526', '511500', '0,510000,511500,', '26', '00000051,00000000,00000026,', '1', '2', null, '珙　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511527', '511500', '0,510000,511500,', '27', '00000051,00000000,00000027,', '1', '2', null, '筠连县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511528', '511500', '0,510000,511500,', '28', '00000051,00000000,00000028,', '1', '2', null, '兴文县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511529', '511500', '0,510000,511500,', '29', '00000051,00000000,00000029,', '1', '2', null, '屏山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511600', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '广安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511602', '511600', '0,510000,511600,', '2', '00000051,00000000,00000002,', '1', '2', null, '广安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511621', '511600', '0,510000,511600,', '21', '00000051,00000000,00000021,', '1', '2', null, '岳池县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511622', '511600', '0,510000,511600,', '22', '00000051,00000000,00000022,', '1', '2', null, '武胜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511623', '511600', '0,510000,511600,', '23', '00000051,00000000,00000023,', '1', '2', null, '邻水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511681', '511600', '0,510000,511600,', '81', '00000051,00000000,00000081,', '1', '2', null, '华莹市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511700', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '达州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511702', '511700', '0,510000,511700,', '2', '00000051,00000000,00000002,', '1', '2', null, '通川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511721', '511700', '0,510000,511700,', '21', '00000051,00000000,00000021,', '1', '2', null, '达　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511722', '511700', '0,510000,511700,', '22', '00000051,00000000,00000022,', '1', '2', null, '宣汉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511723', '511700', '0,510000,511700,', '23', '00000051,00000000,00000023,', '1', '2', null, '开江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511724', '511700', '0,510000,511700,', '24', '00000051,00000000,00000024,', '1', '2', null, '大竹县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511725', '511700', '0,510000,511700,', '25', '00000051,00000000,00000025,', '1', '2', null, '渠　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511781', '511700', '0,510000,511700,', '81', '00000051,00000000,00000081,', '1', '2', null, '万源市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511800', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '雅安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511802', '511800', '0,510000,511800,', '2', '00000051,00000000,00000002,', '1', '2', null, '雨城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511821', '511800', '0,510000,511800,', '21', '00000051,00000000,00000021,', '1', '2', null, '名山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511822', '511800', '0,510000,511800,', '22', '00000051,00000000,00000022,', '1', '2', null, '荥经县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511823', '511800', '0,510000,511800,', '23', '00000051,00000000,00000023,', '1', '2', null, '汉源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511824', '511800', '0,510000,511800,', '24', '00000051,00000000,00000024,', '1', '2', null, '石棉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511825', '511800', '0,510000,511800,', '25', '00000051,00000000,00000025,', '1', '2', null, '天全县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511826', '511800', '0,510000,511800,', '26', '00000051,00000000,00000026,', '1', '2', null, '芦山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511827', '511800', '0,510000,511800,', '27', '00000051,00000000,00000027,', '1', '2', null, '宝兴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511900', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '巴中市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511902', '511900', '0,510000,511900,', '2', '00000051,00000000,00000002,', '1', '2', null, '巴州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511921', '511900', '0,510000,511900,', '21', '00000051,00000000,00000021,', '1', '2', null, '通江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511922', '511900', '0,510000,511900,', '22', '00000051,00000000,00000022,', '1', '2', null, '南江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('511923', '511900', '0,510000,511900,', '23', '00000051,00000000,00000023,', '1', '2', null, '平昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('512000', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '资阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('512002', '512000', '0,510000,512000,', '2', '00000051,00000000,00000002,', '1', '2', null, '雁江区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('512021', '512000', '0,510000,512000,', '21', '00000051,00000000,00000021,', '1', '2', null, '安岳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('512022', '512000', '0,510000,512000,', '22', '00000051,00000000,00000022,', '1', '2', null, '乐至县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('512081', '512000', '0,510000,512000,', '81', '00000051,00000000,00000081,', '1', '2', null, '简阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513200', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '阿坝藏族羌族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513221', '513200', '0,510000,513200,', '21', '00000051,00000000,00000021,', '1', '2', null, '汶川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513222', '513200', '0,510000,513200,', '22', '00000051,00000000,00000022,', '1', '2', null, '理　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513223', '513200', '0,510000,513200,', '23', '00000051,00000000,00000023,', '1', '2', null, '茂　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513224', '513200', '0,510000,513200,', '24', '00000051,00000000,00000024,', '1', '2', null, '松潘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513225', '513200', '0,510000,513200,', '25', '00000051,00000000,00000025,', '1', '2', null, '九寨沟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513226', '513200', '0,510000,513200,', '26', '00000051,00000000,00000026,', '1', '2', null, '金川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513227', '513200', '0,510000,513200,', '27', '00000051,00000000,00000027,', '1', '2', null, '小金县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513228', '513200', '0,510000,513200,', '28', '00000051,00000000,00000028,', '1', '2', null, '黑水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513229', '513200', '0,510000,513200,', '29', '00000051,00000000,00000029,', '1', '2', null, '马尔康县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513230', '513200', '0,510000,513200,', '30', '00000051,00000000,00000030,', '1', '2', null, '壤塘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513231', '513200', '0,510000,513200,', '31', '00000051,00000000,00000031,', '1', '2', null, '阿坝县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513232', '513200', '0,510000,513200,', '32', '00000051,00000000,00000032,', '1', '2', null, '若尔盖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513233', '513200', '0,510000,513200,', '33', '00000051,00000000,00000033,', '1', '2', null, '红原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513300', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '甘孜藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513321', '513300', '0,510000,513300,', '21', '00000051,00000000,00000021,', '1', '2', null, '康定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513322', '513300', '0,510000,513300,', '22', '00000051,00000000,00000022,', '1', '2', null, '泸定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513323', '513300', '0,510000,513300,', '23', '00000051,00000000,00000023,', '1', '2', null, '丹巴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513324', '513300', '0,510000,513300,', '24', '00000051,00000000,00000024,', '1', '2', null, '九龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513325', '513300', '0,510000,513300,', '25', '00000051,00000000,00000025,', '1', '2', null, '雅江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513326', '513300', '0,510000,513300,', '26', '00000051,00000000,00000026,', '1', '2', null, '道孚县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513327', '513300', '0,510000,513300,', '27', '00000051,00000000,00000027,', '1', '2', null, '炉霍县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513328', '513300', '0,510000,513300,', '28', '00000051,00000000,00000028,', '1', '2', null, '甘孜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513329', '513300', '0,510000,513300,', '29', '00000051,00000000,00000029,', '1', '2', null, '新龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513330', '513300', '0,510000,513300,', '30', '00000051,00000000,00000030,', '1', '2', null, '德格县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513331', '513300', '0,510000,513300,', '31', '00000051,00000000,00000031,', '1', '2', null, '白玉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513332', '513300', '0,510000,513300,', '32', '00000051,00000000,00000032,', '1', '2', null, '石渠县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513333', '513300', '0,510000,513300,', '33', '00000051,00000000,00000033,', '1', '2', null, '色达县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513334', '513300', '0,510000,513300,', '34', '00000051,00000000,00000034,', '1', '2', null, '理塘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513335', '513300', '0,510000,513300,', '35', '00000051,00000000,00000035,', '1', '2', null, '巴塘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513336', '513300', '0,510000,513300,', '36', '00000051,00000000,00000036,', '1', '2', null, '乡城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513337', '513300', '0,510000,513300,', '37', '00000051,00000000,00000037,', '1', '2', null, '稻城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513338', '513300', '0,510000,513300,', '38', '00000051,00000000,00000038,', '1', '2', null, '得荣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513400', '510000', '0,510000,', '0', '00000051,00000000,', '0', '1', null, '凉山彝族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513401', '513400', '0,510000,513400,', '1', '00000051,00000000,00000001,', '1', '2', null, '西昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513422', '513400', '0,510000,513400,', '22', '00000051,00000000,00000022,', '1', '2', null, '木里藏族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513423', '513400', '0,510000,513400,', '23', '00000051,00000000,00000023,', '1', '2', null, '盐源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513424', '513400', '0,510000,513400,', '24', '00000051,00000000,00000024,', '1', '2', null, '德昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513425', '513400', '0,510000,513400,', '25', '00000051,00000000,00000025,', '1', '2', null, '会理县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513426', '513400', '0,510000,513400,', '26', '00000051,00000000,00000026,', '1', '2', null, '会东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513427', '513400', '0,510000,513400,', '27', '00000051,00000000,00000027,', '1', '2', null, '宁南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513428', '513400', '0,510000,513400,', '28', '00000051,00000000,00000028,', '1', '2', null, '普格县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513429', '513400', '0,510000,513400,', '29', '00000051,00000000,00000029,', '1', '2', null, '布拖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513430', '513400', '0,510000,513400,', '30', '00000051,00000000,00000030,', '1', '2', null, '金阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513431', '513400', '0,510000,513400,', '31', '00000051,00000000,00000031,', '1', '2', null, '昭觉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513432', '513400', '0,510000,513400,', '32', '00000051,00000000,00000032,', '1', '2', null, '喜德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513433', '513400', '0,510000,513400,', '33', '00000051,00000000,00000033,', '1', '2', null, '冕宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513434', '513400', '0,510000,513400,', '34', '00000051,00000000,00000034,', '1', '2', null, '越西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513435', '513400', '0,510000,513400,', '35', '00000051,00000000,00000035,', '1', '2', null, '甘洛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513436', '513400', '0,510000,513400,', '36', '00000051,00000000,00000036,', '1', '2', null, '美姑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('513437', '513400', '0,510000,513400,', '37', '00000051,00000000,00000037,', '1', '2', null, '雷波县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520000', '0', '0,', '52', '00000052,', '0', '0', null, '贵州省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520100', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '贵阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520102', '520100', '0,520000,520100,', '2', '00000052,00000000,00000002,', '1', '2', null, '南明区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520103', '520100', '0,520000,520100,', '3', '00000052,00000000,00000003,', '1', '2', null, '云岩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520111', '520100', '0,520000,520100,', '11', '00000052,00000000,00000011,', '1', '2', null, '花溪区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520112', '520100', '0,520000,520100,', '12', '00000052,00000000,00000012,', '1', '2', null, '乌当区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520113', '520100', '0,520000,520100,', '13', '00000052,00000000,00000013,', '1', '2', null, '白云区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520114', '520100', '0,520000,520100,', '14', '00000052,00000000,00000014,', '1', '2', null, '小河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520121', '520100', '0,520000,520100,', '21', '00000052,00000000,00000021,', '1', '2', null, '开阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520122', '520100', '0,520000,520100,', '22', '00000052,00000000,00000022,', '1', '2', null, '息烽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520123', '520100', '0,520000,520100,', '23', '00000052,00000000,00000023,', '1', '2', null, '修文县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520181', '520100', '0,520000,520100,', '81', '00000052,00000000,00000081,', '1', '2', null, '清镇市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520200', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '六盘水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520201', '520200', '0,520000,520200,', '1', '00000052,00000000,00000001,', '1', '2', null, '钟山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520203', '520200', '0,520000,520200,', '3', '00000052,00000000,00000003,', '1', '2', null, '六枝特区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520221', '520200', '0,520000,520200,', '21', '00000052,00000000,00000021,', '1', '2', null, '水城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520222', '520200', '0,520000,520200,', '22', '00000052,00000000,00000022,', '1', '2', null, '盘　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520300', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '遵义市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520302', '520300', '0,520000,520300,', '2', '00000052,00000000,00000002,', '1', '2', null, '红花岗区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520303', '520300', '0,520000,520300,', '3', '00000052,00000000,00000003,', '1', '2', null, '汇川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520321', '520300', '0,520000,520300,', '21', '00000052,00000000,00000021,', '1', '2', null, '遵义县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520322', '520300', '0,520000,520300,', '22', '00000052,00000000,00000022,', '1', '2', null, '桐梓县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520323', '520300', '0,520000,520300,', '23', '00000052,00000000,00000023,', '1', '2', null, '绥阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520324', '520300', '0,520000,520300,', '24', '00000052,00000000,00000024,', '1', '2', null, '正安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520325', '520300', '0,520000,520300,', '25', '00000052,00000000,00000025,', '1', '2', null, '道真仡佬族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520326', '520300', '0,520000,520300,', '26', '00000052,00000000,00000026,', '1', '2', null, '务川仡佬族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520327', '520300', '0,520000,520300,', '27', '00000052,00000000,00000027,', '1', '2', null, '凤冈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520328', '520300', '0,520000,520300,', '28', '00000052,00000000,00000028,', '1', '2', null, '湄潭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520329', '520300', '0,520000,520300,', '29', '00000052,00000000,00000029,', '1', '2', null, '余庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520330', '520300', '0,520000,520300,', '30', '00000052,00000000,00000030,', '1', '2', null, '习水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520381', '520300', '0,520000,520300,', '81', '00000052,00000000,00000081,', '1', '2', null, '赤水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520382', '520300', '0,520000,520300,', '82', '00000052,00000000,00000082,', '1', '2', null, '仁怀市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520400', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '安顺市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520402', '520400', '0,520000,520400,', '2', '00000052,00000000,00000002,', '1', '2', null, '西秀区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520421', '520400', '0,520000,520400,', '21', '00000052,00000000,00000021,', '1', '2', null, '平坝县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520422', '520400', '0,520000,520400,', '22', '00000052,00000000,00000022,', '1', '2', null, '普定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520423', '520400', '0,520000,520400,', '23', '00000052,00000000,00000023,', '1', '2', null, '镇宁布依族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520424', '520400', '0,520000,520400,', '24', '00000052,00000000,00000024,', '1', '2', null, '关岭布依族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('520425', '520400', '0,520000,520400,', '25', '00000052,00000000,00000025,', '1', '2', null, '紫云苗族布依族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522200', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '铜仁地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522201', '522200', '0,520000,522200,', '1', '00000052,00000000,00000001,', '1', '2', null, '铜仁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522222', '522200', '0,520000,522200,', '22', '00000052,00000000,00000022,', '1', '2', null, '江口县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522223', '522200', '0,520000,522200,', '23', '00000052,00000000,00000023,', '1', '2', null, '玉屏侗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522224', '522200', '0,520000,522200,', '24', '00000052,00000000,00000024,', '1', '2', null, '石阡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522225', '522200', '0,520000,522200,', '25', '00000052,00000000,00000025,', '1', '2', null, '思南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522226', '522200', '0,520000,522200,', '26', '00000052,00000000,00000026,', '1', '2', null, '印江土家族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522227', '522200', '0,520000,522200,', '27', '00000052,00000000,00000027,', '1', '2', null, '德江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522228', '522200', '0,520000,522200,', '28', '00000052,00000000,00000028,', '1', '2', null, '沿河土家族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522229', '522200', '0,520000,522200,', '29', '00000052,00000000,00000029,', '1', '2', null, '松桃苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522230', '522200', '0,520000,522200,', '30', '00000052,00000000,00000030,', '1', '2', null, '万山特区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522300', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '黔西南布依族苗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522301', '522300', '0,520000,522300,', '1', '00000052,00000000,00000001,', '1', '2', null, '兴义市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522322', '522300', '0,520000,522300,', '22', '00000052,00000000,00000022,', '1', '2', null, '兴仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522323', '522300', '0,520000,522300,', '23', '00000052,00000000,00000023,', '1', '2', null, '普安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522324', '522300', '0,520000,522300,', '24', '00000052,00000000,00000024,', '1', '2', null, '晴隆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522325', '522300', '0,520000,522300,', '25', '00000052,00000000,00000025,', '1', '2', null, '贞丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522326', '522300', '0,520000,522300,', '26', '00000052,00000000,00000026,', '1', '2', null, '望谟县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522327', '522300', '0,520000,522300,', '27', '00000052,00000000,00000027,', '1', '2', null, '册亨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522328', '522300', '0,520000,522300,', '28', '00000052,00000000,00000028,', '1', '2', null, '安龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522400', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '毕节地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522401', '522400', '0,520000,522400,', '1', '00000052,00000000,00000001,', '1', '2', null, '毕节市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522422', '522400', '0,520000,522400,', '22', '00000052,00000000,00000022,', '1', '2', null, '大方县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522423', '522400', '0,520000,522400,', '23', '00000052,00000000,00000023,', '1', '2', null, '黔西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522424', '522400', '0,520000,522400,', '24', '00000052,00000000,00000024,', '1', '2', null, '金沙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522425', '522400', '0,520000,522400,', '25', '00000052,00000000,00000025,', '1', '2', null, '织金县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522426', '522400', '0,520000,522400,', '26', '00000052,00000000,00000026,', '1', '2', null, '纳雍县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522427', '522400', '0,520000,522400,', '27', '00000052,00000000,00000027,', '1', '2', null, '威宁彝族回族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522428', '522400', '0,520000,522400,', '28', '00000052,00000000,00000028,', '1', '2', null, '赫章县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522600', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '黔东南苗族侗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522601', '522600', '0,520000,522600,', '1', '00000052,00000000,00000001,', '1', '2', null, '凯里市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522622', '522600', '0,520000,522600,', '22', '00000052,00000000,00000022,', '1', '2', null, '黄平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522623', '522600', '0,520000,522600,', '23', '00000052,00000000,00000023,', '1', '2', null, '施秉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522624', '522600', '0,520000,522600,', '24', '00000052,00000000,00000024,', '1', '2', null, '三穗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522625', '522600', '0,520000,522600,', '25', '00000052,00000000,00000025,', '1', '2', null, '镇远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522626', '522600', '0,520000,522600,', '26', '00000052,00000000,00000026,', '1', '2', null, '岑巩县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522627', '522600', '0,520000,522600,', '27', '00000052,00000000,00000027,', '1', '2', null, '天柱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522628', '522600', '0,520000,522600,', '28', '00000052,00000000,00000028,', '1', '2', null, '锦屏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522629', '522600', '0,520000,522600,', '29', '00000052,00000000,00000029,', '1', '2', null, '剑河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522630', '522600', '0,520000,522600,', '30', '00000052,00000000,00000030,', '1', '2', null, '台江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522631', '522600', '0,520000,522600,', '31', '00000052,00000000,00000031,', '1', '2', null, '黎平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522632', '522600', '0,520000,522600,', '32', '00000052,00000000,00000032,', '1', '2', null, '榕江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522633', '522600', '0,520000,522600,', '33', '00000052,00000000,00000033,', '1', '2', null, '从江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522634', '522600', '0,520000,522600,', '34', '00000052,00000000,00000034,', '1', '2', null, '雷山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522635', '522600', '0,520000,522600,', '35', '00000052,00000000,00000035,', '1', '2', null, '麻江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522636', '522600', '0,520000,522600,', '36', '00000052,00000000,00000036,', '1', '2', null, '丹寨县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522700', '520000', '0,520000,', '0', '00000052,00000000,', '0', '1', null, '黔南布依族苗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522701', '522700', '0,520000,522700,', '1', '00000052,00000000,00000001,', '1', '2', null, '都匀市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522702', '522700', '0,520000,522700,', '2', '00000052,00000000,00000002,', '1', '2', null, '福泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522722', '522700', '0,520000,522700,', '22', '00000052,00000000,00000022,', '1', '2', null, '荔波县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522723', '522700', '0,520000,522700,', '23', '00000052,00000000,00000023,', '1', '2', null, '贵定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522725', '522700', '0,520000,522700,', '25', '00000052,00000000,00000025,', '1', '2', null, '瓮安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522726', '522700', '0,520000,522700,', '26', '00000052,00000000,00000026,', '1', '2', null, '独山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522727', '522700', '0,520000,522700,', '27', '00000052,00000000,00000027,', '1', '2', null, '平塘县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522728', '522700', '0,520000,522700,', '28', '00000052,00000000,00000028,', '1', '2', null, '罗甸县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522729', '522700', '0,520000,522700,', '29', '00000052,00000000,00000029,', '1', '2', null, '长顺县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522730', '522700', '0,520000,522700,', '30', '00000052,00000000,00000030,', '1', '2', null, '龙里县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522731', '522700', '0,520000,522700,', '31', '00000052,00000000,00000031,', '1', '2', null, '惠水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('522732', '522700', '0,520000,522700,', '32', '00000052,00000000,00000032,', '1', '2', null, '三都水族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530000', '0', '0,', '53', '00000053,', '0', '0', null, '云南省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530100', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '昆明市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530102', '530100', '0,530000,530100,', '2', '00000053,00000000,00000002,', '1', '2', null, '五华区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530103', '530100', '0,530000,530100,', '3', '00000053,00000000,00000003,', '1', '2', null, '盘龙区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530111', '530100', '0,530000,530100,', '11', '00000053,00000000,00000011,', '1', '2', null, '官渡区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530112', '530100', '0,530000,530100,', '12', '00000053,00000000,00000012,', '1', '2', null, '西山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530113', '530100', '0,530000,530100,', '13', '00000053,00000000,00000013,', '1', '2', null, '东川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530121', '530100', '0,530000,530100,', '21', '00000053,00000000,00000021,', '1', '2', null, '呈贡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530122', '530100', '0,530000,530100,', '22', '00000053,00000000,00000022,', '1', '2', null, '晋宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530124', '530100', '0,530000,530100,', '24', '00000053,00000000,00000024,', '1', '2', null, '富民县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530125', '530100', '0,530000,530100,', '25', '00000053,00000000,00000025,', '1', '2', null, '宜良县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530126', '530100', '0,530000,530100,', '26', '00000053,00000000,00000026,', '1', '2', null, '石林彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530127', '530100', '0,530000,530100,', '27', '00000053,00000000,00000027,', '1', '2', null, '嵩明县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530128', '530100', '0,530000,530100,', '28', '00000053,00000000,00000028,', '1', '2', null, '禄劝彝族苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530129', '530100', '0,530000,530100,', '29', '00000053,00000000,00000029,', '1', '2', null, '寻甸回族彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530181', '530100', '0,530000,530100,', '81', '00000053,00000000,00000081,', '1', '2', null, '安宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530300', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '曲靖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530302', '530300', '0,530000,530300,', '2', '00000053,00000000,00000002,', '1', '2', null, '麒麟区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530321', '530300', '0,530000,530300,', '21', '00000053,00000000,00000021,', '1', '2', null, '马龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530322', '530300', '0,530000,530300,', '22', '00000053,00000000,00000022,', '1', '2', null, '陆良县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530323', '530300', '0,530000,530300,', '23', '00000053,00000000,00000023,', '1', '2', null, '师宗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530324', '530300', '0,530000,530300,', '24', '00000053,00000000,00000024,', '1', '2', null, '罗平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530325', '530300', '0,530000,530300,', '25', '00000053,00000000,00000025,', '1', '2', null, '富源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530326', '530300', '0,530000,530300,', '26', '00000053,00000000,00000026,', '1', '2', null, '会泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530328', '530300', '0,530000,530300,', '28', '00000053,00000000,00000028,', '1', '2', null, '沾益县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530381', '530300', '0,530000,530300,', '81', '00000053,00000000,00000081,', '1', '2', null, '宣威市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530400', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '玉溪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530402', '530400', '0,530000,530400,', '2', '00000053,00000000,00000002,', '1', '2', null, '红塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530421', '530400', '0,530000,530400,', '21', '00000053,00000000,00000021,', '1', '2', null, '江川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530422', '530400', '0,530000,530400,', '22', '00000053,00000000,00000022,', '1', '2', null, '澄江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530423', '530400', '0,530000,530400,', '23', '00000053,00000000,00000023,', '1', '2', null, '通海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530424', '530400', '0,530000,530400,', '24', '00000053,00000000,00000024,', '1', '2', null, '华宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530425', '530400', '0,530000,530400,', '25', '00000053,00000000,00000025,', '1', '2', null, '易门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530426', '530400', '0,530000,530400,', '26', '00000053,00000000,00000026,', '1', '2', null, '峨山彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530427', '530400', '0,530000,530400,', '27', '00000053,00000000,00000027,', '1', '2', null, '新平彝族傣族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530428', '530400', '0,530000,530400,', '28', '00000053,00000000,00000028,', '1', '2', null, '元江哈尼族彝族傣族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530500', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '保山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530502', '530500', '0,530000,530500,', '2', '00000053,00000000,00000002,', '1', '2', null, '隆阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530521', '530500', '0,530000,530500,', '21', '00000053,00000000,00000021,', '1', '2', null, '施甸县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530522', '530500', '0,530000,530500,', '22', '00000053,00000000,00000022,', '1', '2', null, '腾冲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530523', '530500', '0,530000,530500,', '23', '00000053,00000000,00000023,', '1', '2', null, '龙陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530524', '530500', '0,530000,530500,', '24', '00000053,00000000,00000024,', '1', '2', null, '昌宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530600', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '昭通市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530602', '530600', '0,530000,530600,', '2', '00000053,00000000,00000002,', '1', '2', null, '昭阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530621', '530600', '0,530000,530600,', '21', '00000053,00000000,00000021,', '1', '2', null, '鲁甸县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530622', '530600', '0,530000,530600,', '22', '00000053,00000000,00000022,', '1', '2', null, '巧家县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530623', '530600', '0,530000,530600,', '23', '00000053,00000000,00000023,', '1', '2', null, '盐津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530624', '530600', '0,530000,530600,', '24', '00000053,00000000,00000024,', '1', '2', null, '大关县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530625', '530600', '0,530000,530600,', '25', '00000053,00000000,00000025,', '1', '2', null, '永善县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530626', '530600', '0,530000,530600,', '26', '00000053,00000000,00000026,', '1', '2', null, '绥江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530627', '530600', '0,530000,530600,', '27', '00000053,00000000,00000027,', '1', '2', null, '镇雄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530628', '530600', '0,530000,530600,', '28', '00000053,00000000,00000028,', '1', '2', null, '彝良县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530629', '530600', '0,530000,530600,', '29', '00000053,00000000,00000029,', '1', '2', null, '威信县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530630', '530600', '0,530000,530600,', '30', '00000053,00000000,00000030,', '1', '2', null, '水富县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530700', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '丽江市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530702', '530700', '0,530000,530700,', '2', '00000053,00000000,00000002,', '1', '2', null, '古城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530721', '530700', '0,530000,530700,', '21', '00000053,00000000,00000021,', '1', '2', null, '玉龙纳西族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530722', '530700', '0,530000,530700,', '22', '00000053,00000000,00000022,', '1', '2', null, '永胜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530723', '530700', '0,530000,530700,', '23', '00000053,00000000,00000023,', '1', '2', null, '华坪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530724', '530700', '0,530000,530700,', '24', '00000053,00000000,00000024,', '1', '2', null, '宁蒗彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530800', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '思茅市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530802', '530800', '0,530000,530800,', '2', '00000053,00000000,00000002,', '1', '2', null, '翠云区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530821', '530800', '0,530000,530800,', '21', '00000053,00000000,00000021,', '1', '2', null, '普洱哈尼族彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530822', '530800', '0,530000,530800,', '22', '00000053,00000000,00000022,', '1', '2', null, '墨江哈尼族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530823', '530800', '0,530000,530800,', '23', '00000053,00000000,00000023,', '1', '2', null, '景东彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530824', '530800', '0,530000,530800,', '24', '00000053,00000000,00000024,', '1', '2', null, '景谷傣族彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530825', '530800', '0,530000,530800,', '25', '00000053,00000000,00000025,', '1', '2', null, '镇沅彝族哈尼族拉祜族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530826', '530800', '0,530000,530800,', '26', '00000053,00000000,00000026,', '1', '2', null, '江城哈尼族彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530827', '530800', '0,530000,530800,', '27', '00000053,00000000,00000027,', '1', '2', null, '孟连傣族拉祜族佤族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530828', '530800', '0,530000,530800,', '28', '00000053,00000000,00000028,', '1', '2', null, '澜沧拉祜族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530829', '530800', '0,530000,530800,', '29', '00000053,00000000,00000029,', '1', '2', null, '西盟佤族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530900', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '临沧市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530902', '530900', '0,530000,530900,', '2', '00000053,00000000,00000002,', '1', '2', null, '临翔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530921', '530900', '0,530000,530900,', '21', '00000053,00000000,00000021,', '1', '2', null, '凤庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530922', '530900', '0,530000,530900,', '22', '00000053,00000000,00000022,', '1', '2', null, '云　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530923', '530900', '0,530000,530900,', '23', '00000053,00000000,00000023,', '1', '2', null, '永德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530924', '530900', '0,530000,530900,', '24', '00000053,00000000,00000024,', '1', '2', null, '镇康县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530925', '530900', '0,530000,530900,', '25', '00000053,00000000,00000025,', '1', '2', null, '双江拉祜族佤族布朗族傣族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530926', '530900', '0,530000,530900,', '26', '00000053,00000000,00000026,', '1', '2', null, '耿马傣族佤族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('530927', '530900', '0,530000,530900,', '27', '00000053,00000000,00000027,', '1', '2', null, '沧源佤族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532300', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '楚雄彝族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532301', '532300', '0,530000,532300,', '1', '00000053,00000000,00000001,', '1', '2', null, '楚雄市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532322', '532300', '0,530000,532300,', '22', '00000053,00000000,00000022,', '1', '2', null, '双柏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532323', '532300', '0,530000,532300,', '23', '00000053,00000000,00000023,', '1', '2', null, '牟定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532324', '532300', '0,530000,532300,', '24', '00000053,00000000,00000024,', '1', '2', null, '南华县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532325', '532300', '0,530000,532300,', '25', '00000053,00000000,00000025,', '1', '2', null, '姚安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532326', '532300', '0,530000,532300,', '26', '00000053,00000000,00000026,', '1', '2', null, '大姚县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532327', '532300', '0,530000,532300,', '27', '00000053,00000000,00000027,', '1', '2', null, '永仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532328', '532300', '0,530000,532300,', '28', '00000053,00000000,00000028,', '1', '2', null, '元谋县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532329', '532300', '0,530000,532300,', '29', '00000053,00000000,00000029,', '1', '2', null, '武定县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532331', '532300', '0,530000,532300,', '31', '00000053,00000000,00000031,', '1', '2', null, '禄丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532500', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '红河哈尼族彝族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532501', '532500', '0,530000,532500,', '1', '00000053,00000000,00000001,', '1', '2', null, '个旧市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532502', '532500', '0,530000,532500,', '2', '00000053,00000000,00000002,', '1', '2', null, '开远市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532522', '532500', '0,530000,532500,', '22', '00000053,00000000,00000022,', '1', '2', null, '蒙自县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532523', '532500', '0,530000,532500,', '23', '00000053,00000000,00000023,', '1', '2', null, '屏边苗族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532524', '532500', '0,530000,532500,', '24', '00000053,00000000,00000024,', '1', '2', null, '建水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532525', '532500', '0,530000,532500,', '25', '00000053,00000000,00000025,', '1', '2', null, '石屏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532526', '532500', '0,530000,532500,', '26', '00000053,00000000,00000026,', '1', '2', null, '弥勒县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532527', '532500', '0,530000,532500,', '27', '00000053,00000000,00000027,', '1', '2', null, '泸西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532528', '532500', '0,530000,532500,', '28', '00000053,00000000,00000028,', '1', '2', null, '元阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532529', '532500', '0,530000,532500,', '29', '00000053,00000000,00000029,', '1', '2', null, '红河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532530', '532500', '0,530000,532500,', '30', '00000053,00000000,00000030,', '1', '2', null, '金平苗族瑶族傣族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532531', '532500', '0,530000,532500,', '31', '00000053,00000000,00000031,', '1', '2', null, '绿春县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532532', '532500', '0,530000,532500,', '32', '00000053,00000000,00000032,', '1', '2', null, '河口瑶族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532600', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '文山壮族苗族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532621', '532600', '0,530000,532600,', '21', '00000053,00000000,00000021,', '1', '2', null, '文山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532622', '532600', '0,530000,532600,', '22', '00000053,00000000,00000022,', '1', '2', null, '砚山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532623', '532600', '0,530000,532600,', '23', '00000053,00000000,00000023,', '1', '2', null, '西畴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532624', '532600', '0,530000,532600,', '24', '00000053,00000000,00000024,', '1', '2', null, '麻栗坡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532625', '532600', '0,530000,532600,', '25', '00000053,00000000,00000025,', '1', '2', null, '马关县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532626', '532600', '0,530000,532600,', '26', '00000053,00000000,00000026,', '1', '2', null, '丘北县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532627', '532600', '0,530000,532600,', '27', '00000053,00000000,00000027,', '1', '2', null, '广南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532628', '532600', '0,530000,532600,', '28', '00000053,00000000,00000028,', '1', '2', null, '富宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532800', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '西双版纳傣族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532801', '532800', '0,530000,532800,', '1', '00000053,00000000,00000001,', '1', '2', null, '景洪市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532822', '532800', '0,530000,532800,', '22', '00000053,00000000,00000022,', '1', '2', null, '勐海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532823', '532800', '0,530000,532800,', '23', '00000053,00000000,00000023,', '1', '2', null, '勐腊县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532900', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '大理白族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532901', '532900', '0,530000,532900,', '1', '00000053,00000000,00000001,', '1', '2', null, '大理市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532922', '532900', '0,530000,532900,', '22', '00000053,00000000,00000022,', '1', '2', null, '漾濞彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532923', '532900', '0,530000,532900,', '23', '00000053,00000000,00000023,', '1', '2', null, '祥云县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532924', '532900', '0,530000,532900,', '24', '00000053,00000000,00000024,', '1', '2', null, '宾川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532925', '532900', '0,530000,532900,', '25', '00000053,00000000,00000025,', '1', '2', null, '弥渡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532926', '532900', '0,530000,532900,', '26', '00000053,00000000,00000026,', '1', '2', null, '南涧彝族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532927', '532900', '0,530000,532900,', '27', '00000053,00000000,00000027,', '1', '2', null, '巍山彝族回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532928', '532900', '0,530000,532900,', '28', '00000053,00000000,00000028,', '1', '2', null, '永平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532929', '532900', '0,530000,532900,', '29', '00000053,00000000,00000029,', '1', '2', null, '云龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532930', '532900', '0,530000,532900,', '30', '00000053,00000000,00000030,', '1', '2', null, '洱源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532931', '532900', '0,530000,532900,', '31', '00000053,00000000,00000031,', '1', '2', null, '剑川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('532932', '532900', '0,530000,532900,', '32', '00000053,00000000,00000032,', '1', '2', null, '鹤庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533100', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '德宏傣族景颇族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533102', '533100', '0,530000,533100,', '2', '00000053,00000000,00000002,', '1', '2', null, '瑞丽市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533103', '533100', '0,530000,533100,', '3', '00000053,00000000,00000003,', '1', '2', null, '潞西市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533122', '533100', '0,530000,533100,', '22', '00000053,00000000,00000022,', '1', '2', null, '梁河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533123', '533100', '0,530000,533100,', '23', '00000053,00000000,00000023,', '1', '2', null, '盈江县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533124', '533100', '0,530000,533100,', '24', '00000053,00000000,00000024,', '1', '2', null, '陇川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533300', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '怒江傈僳族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533321', '533300', '0,530000,533300,', '21', '00000053,00000000,00000021,', '1', '2', null, '泸水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533323', '533300', '0,530000,533300,', '23', '00000053,00000000,00000023,', '1', '2', null, '福贡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533324', '533300', '0,530000,533300,', '24', '00000053,00000000,00000024,', '1', '2', null, '贡山独龙族怒族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533325', '533300', '0,530000,533300,', '25', '00000053,00000000,00000025,', '1', '2', null, '兰坪白族普米族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533400', '530000', '0,530000,', '0', '00000053,00000000,', '0', '1', null, '迪庆藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533421', '533400', '0,530000,533400,', '21', '00000053,00000000,00000021,', '1', '2', null, '香格里拉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533422', '533400', '0,530000,533400,', '22', '00000053,00000000,00000022,', '1', '2', null, '德钦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('533423', '533400', '0,530000,533400,', '23', '00000053,00000000,00000023,', '1', '2', null, '维西傈僳族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540000', '0', '0,', '54', '00000054,', '0', '0', null, '西藏自治区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540100', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '拉萨市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540102', '540100', '0,540000,540100,', '2', '00000054,00000000,00000002,', '1', '2', null, '城关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540121', '540100', '0,540000,540100,', '21', '00000054,00000000,00000021,', '1', '2', null, '林周县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540122', '540100', '0,540000,540100,', '22', '00000054,00000000,00000022,', '1', '2', null, '当雄县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540123', '540100', '0,540000,540100,', '23', '00000054,00000000,00000023,', '1', '2', null, '尼木县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540124', '540100', '0,540000,540100,', '24', '00000054,00000000,00000024,', '1', '2', null, '曲水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540125', '540100', '0,540000,540100,', '25', '00000054,00000000,00000025,', '1', '2', null, '堆龙德庆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540126', '540100', '0,540000,540100,', '26', '00000054,00000000,00000026,', '1', '2', null, '达孜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('540127', '540100', '0,540000,540100,', '27', '00000054,00000000,00000027,', '1', '2', null, '墨竹工卡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542100', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '昌都地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542121', '542100', '0,540000,542100,', '21', '00000054,00000000,00000021,', '1', '2', null, '昌都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542122', '542100', '0,540000,542100,', '22', '00000054,00000000,00000022,', '1', '2', null, '江达县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542123', '542100', '0,540000,542100,', '23', '00000054,00000000,00000023,', '1', '2', null, '贡觉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542124', '542100', '0,540000,542100,', '24', '00000054,00000000,00000024,', '1', '2', null, '类乌齐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542125', '542100', '0,540000,542100,', '25', '00000054,00000000,00000025,', '1', '2', null, '丁青县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542126', '542100', '0,540000,542100,', '26', '00000054,00000000,00000026,', '1', '2', null, '察雅县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542127', '542100', '0,540000,542100,', '27', '00000054,00000000,00000027,', '1', '2', null, '八宿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542128', '542100', '0,540000,542100,', '28', '00000054,00000000,00000028,', '1', '2', null, '左贡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542129', '542100', '0,540000,542100,', '29', '00000054,00000000,00000029,', '1', '2', null, '芒康县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542132', '542100', '0,540000,542100,', '32', '00000054,00000000,00000032,', '1', '2', null, '洛隆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542133', '542100', '0,540000,542100,', '33', '00000054,00000000,00000033,', '1', '2', null, '边坝县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542200', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '山南地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542221', '542200', '0,540000,542200,', '21', '00000054,00000000,00000021,', '1', '2', null, '乃东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542222', '542200', '0,540000,542200,', '22', '00000054,00000000,00000022,', '1', '2', null, '扎囊县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542223', '542200', '0,540000,542200,', '23', '00000054,00000000,00000023,', '1', '2', null, '贡嘎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542224', '542200', '0,540000,542200,', '24', '00000054,00000000,00000024,', '1', '2', null, '桑日县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542225', '542200', '0,540000,542200,', '25', '00000054,00000000,00000025,', '1', '2', null, '琼结县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542226', '542200', '0,540000,542200,', '26', '00000054,00000000,00000026,', '1', '2', null, '曲松县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542227', '542200', '0,540000,542200,', '27', '00000054,00000000,00000027,', '1', '2', null, '措美县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542228', '542200', '0,540000,542200,', '28', '00000054,00000000,00000028,', '1', '2', null, '洛扎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542229', '542200', '0,540000,542200,', '29', '00000054,00000000,00000029,', '1', '2', null, '加查县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542231', '542200', '0,540000,542200,', '31', '00000054,00000000,00000031,', '1', '2', null, '隆子县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542232', '542200', '0,540000,542200,', '32', '00000054,00000000,00000032,', '1', '2', null, '错那县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542233', '542200', '0,540000,542200,', '33', '00000054,00000000,00000033,', '1', '2', null, '浪卡子县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542300', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '日喀则地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542301', '542300', '0,540000,542300,', '1', '00000054,00000000,00000001,', '1', '2', null, '日喀则市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542322', '542300', '0,540000,542300,', '22', '00000054,00000000,00000022,', '1', '2', null, '南木林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542323', '542300', '0,540000,542300,', '23', '00000054,00000000,00000023,', '1', '2', null, '江孜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542324', '542300', '0,540000,542300,', '24', '00000054,00000000,00000024,', '1', '2', null, '定日县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542325', '542300', '0,540000,542300,', '25', '00000054,00000000,00000025,', '1', '2', null, '萨迦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542326', '542300', '0,540000,542300,', '26', '00000054,00000000,00000026,', '1', '2', null, '拉孜县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542327', '542300', '0,540000,542300,', '27', '00000054,00000000,00000027,', '1', '2', null, '昂仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542328', '542300', '0,540000,542300,', '28', '00000054,00000000,00000028,', '1', '2', null, '谢通门县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542329', '542300', '0,540000,542300,', '29', '00000054,00000000,00000029,', '1', '2', null, '白朗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542330', '542300', '0,540000,542300,', '30', '00000054,00000000,00000030,', '1', '2', null, '仁布县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542331', '542300', '0,540000,542300,', '31', '00000054,00000000,00000031,', '1', '2', null, '康马县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542332', '542300', '0,540000,542300,', '32', '00000054,00000000,00000032,', '1', '2', null, '定结县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542333', '542300', '0,540000,542300,', '33', '00000054,00000000,00000033,', '1', '2', null, '仲巴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542334', '542300', '0,540000,542300,', '34', '00000054,00000000,00000034,', '1', '2', null, '亚东县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542335', '542300', '0,540000,542300,', '35', '00000054,00000000,00000035,', '1', '2', null, '吉隆县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542336', '542300', '0,540000,542300,', '36', '00000054,00000000,00000036,', '1', '2', null, '聂拉木县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542337', '542300', '0,540000,542300,', '37', '00000054,00000000,00000037,', '1', '2', null, '萨嘎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542338', '542300', '0,540000,542300,', '38', '00000054,00000000,00000038,', '1', '2', null, '岗巴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542400', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '那曲地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542421', '542400', '0,540000,542400,', '21', '00000054,00000000,00000021,', '1', '2', null, '那曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542422', '542400', '0,540000,542400,', '22', '00000054,00000000,00000022,', '1', '2', null, '嘉黎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542423', '542400', '0,540000,542400,', '23', '00000054,00000000,00000023,', '1', '2', null, '比如县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542424', '542400', '0,540000,542400,', '24', '00000054,00000000,00000024,', '1', '2', null, '聂荣县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542425', '542400', '0,540000,542400,', '25', '00000054,00000000,00000025,', '1', '2', null, '安多县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542426', '542400', '0,540000,542400,', '26', '00000054,00000000,00000026,', '1', '2', null, '申扎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542427', '542400', '0,540000,542400,', '27', '00000054,00000000,00000027,', '1', '2', null, '索　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542428', '542400', '0,540000,542400,', '28', '00000054,00000000,00000028,', '1', '2', null, '班戈县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542429', '542400', '0,540000,542400,', '29', '00000054,00000000,00000029,', '1', '2', null, '巴青县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542430', '542400', '0,540000,542400,', '30', '00000054,00000000,00000030,', '1', '2', null, '尼玛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542500', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '阿里地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542521', '542500', '0,540000,542500,', '21', '00000054,00000000,00000021,', '1', '2', null, '普兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542522', '542500', '0,540000,542500,', '22', '00000054,00000000,00000022,', '1', '2', null, '札达县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542523', '542500', '0,540000,542500,', '23', '00000054,00000000,00000023,', '1', '2', null, '噶尔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542524', '542500', '0,540000,542500,', '24', '00000054,00000000,00000024,', '1', '2', null, '日土县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542525', '542500', '0,540000,542500,', '25', '00000054,00000000,00000025,', '1', '2', null, '革吉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542526', '542500', '0,540000,542500,', '26', '00000054,00000000,00000026,', '1', '2', null, '改则县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542527', '542500', '0,540000,542500,', '27', '00000054,00000000,00000027,', '1', '2', null, '措勤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542600', '540000', '0,540000,', '0', '00000054,00000000,', '0', '1', null, '林芝地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542621', '542600', '0,540000,542600,', '21', '00000054,00000000,00000021,', '1', '2', null, '林芝县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542622', '542600', '0,540000,542600,', '22', '00000054,00000000,00000022,', '1', '2', null, '工布江达县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542623', '542600', '0,540000,542600,', '23', '00000054,00000000,00000023,', '1', '2', null, '米林县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542624', '542600', '0,540000,542600,', '24', '00000054,00000000,00000024,', '1', '2', null, '墨脱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542625', '542600', '0,540000,542600,', '25', '00000054,00000000,00000025,', '1', '2', null, '波密县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542626', '542600', '0,540000,542600,', '26', '00000054,00000000,00000026,', '1', '2', null, '察隅县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('542627', '542600', '0,540000,542600,', '27', '00000054,00000000,00000027,', '1', '2', null, '朗　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610000', '0', '0,', '61', '00000061,', '0', '0', null, '陕西省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610100', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '西安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610102', '610100', '0,610000,610100,', '2', '00000061,00000000,00000002,', '1', '2', null, '新城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610103', '610100', '0,610000,610100,', '3', '00000061,00000000,00000003,', '1', '2', null, '碑林区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610104', '610100', '0,610000,610100,', '4', '00000061,00000000,00000004,', '1', '2', null, '莲湖区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610111', '610100', '0,610000,610100,', '11', '00000061,00000000,00000011,', '1', '2', null, '灞桥区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610112', '610100', '0,610000,610100,', '12', '00000061,00000000,00000012,', '1', '2', null, '未央区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610113', '610100', '0,610000,610100,', '13', '00000061,00000000,00000013,', '1', '2', null, '雁塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610114', '610100', '0,610000,610100,', '14', '00000061,00000000,00000014,', '1', '2', null, '阎良区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610115', '610100', '0,610000,610100,', '15', '00000061,00000000,00000015,', '1', '2', null, '临潼区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610116', '610100', '0,610000,610100,', '16', '00000061,00000000,00000016,', '1', '2', null, '长安区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610122', '610100', '0,610000,610100,', '22', '00000061,00000000,00000022,', '1', '2', null, '蓝田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610124', '610100', '0,610000,610100,', '24', '00000061,00000000,00000024,', '1', '2', null, '周至县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610125', '610100', '0,610000,610100,', '25', '00000061,00000000,00000025,', '1', '2', null, '户　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610126', '610100', '0,610000,610100,', '26', '00000061,00000000,00000026,', '1', '2', null, '高陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610200', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '铜川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610202', '610200', '0,610000,610200,', '2', '00000061,00000000,00000002,', '1', '2', null, '王益区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610203', '610200', '0,610000,610200,', '3', '00000061,00000000,00000003,', '1', '2', null, '印台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610204', '610200', '0,610000,610200,', '4', '00000061,00000000,00000004,', '1', '2', null, '耀州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610222', '610200', '0,610000,610200,', '22', '00000061,00000000,00000022,', '1', '2', null, '宜君县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610300', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '宝鸡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610302', '610300', '0,610000,610300,', '2', '00000061,00000000,00000002,', '1', '2', null, '渭滨区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610303', '610300', '0,610000,610300,', '3', '00000061,00000000,00000003,', '1', '2', null, '金台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610304', '610300', '0,610000,610300,', '4', '00000061,00000000,00000004,', '1', '2', null, '陈仓区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610322', '610300', '0,610000,610300,', '22', '00000061,00000000,00000022,', '1', '2', null, '凤翔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610323', '610300', '0,610000,610300,', '23', '00000061,00000000,00000023,', '1', '2', null, '岐山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610324', '610300', '0,610000,610300,', '24', '00000061,00000000,00000024,', '1', '2', null, '扶风县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610326', '610300', '0,610000,610300,', '26', '00000061,00000000,00000026,', '1', '2', null, '眉　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610327', '610300', '0,610000,610300,', '27', '00000061,00000000,00000027,', '1', '2', null, '陇　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610328', '610300', '0,610000,610300,', '28', '00000061,00000000,00000028,', '1', '2', null, '千阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610329', '610300', '0,610000,610300,', '29', '00000061,00000000,00000029,', '1', '2', null, '麟游县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610330', '610300', '0,610000,610300,', '30', '00000061,00000000,00000030,', '1', '2', null, '凤　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610331', '610300', '0,610000,610300,', '31', '00000061,00000000,00000031,', '1', '2', null, '太白县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610400', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '咸阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610402', '610400', '0,610000,610400,', '2', '00000061,00000000,00000002,', '1', '2', null, '秦都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610403', '610400', '0,610000,610400,', '3', '00000061,00000000,00000003,', '1', '2', null, '杨凌区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610404', '610400', '0,610000,610400,', '4', '00000061,00000000,00000004,', '1', '2', null, '渭城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610422', '610400', '0,610000,610400,', '22', '00000061,00000000,00000022,', '1', '2', null, '三原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610423', '610400', '0,610000,610400,', '23', '00000061,00000000,00000023,', '1', '2', null, '泾阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610424', '610400', '0,610000,610400,', '24', '00000061,00000000,00000024,', '1', '2', null, '乾　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610425', '610400', '0,610000,610400,', '25', '00000061,00000000,00000025,', '1', '2', null, '礼泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610426', '610400', '0,610000,610400,', '26', '00000061,00000000,00000026,', '1', '2', null, '永寿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610427', '610400', '0,610000,610400,', '27', '00000061,00000000,00000027,', '1', '2', null, '彬　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610428', '610400', '0,610000,610400,', '28', '00000061,00000000,00000028,', '1', '2', null, '长武县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610429', '610400', '0,610000,610400,', '29', '00000061,00000000,00000029,', '1', '2', null, '旬邑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610430', '610400', '0,610000,610400,', '30', '00000061,00000000,00000030,', '1', '2', null, '淳化县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610431', '610400', '0,610000,610400,', '31', '00000061,00000000,00000031,', '1', '2', null, '武功县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610481', '610400', '0,610000,610400,', '81', '00000061,00000000,00000081,', '1', '2', null, '兴平市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610500', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '渭南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610502', '610500', '0,610000,610500,', '2', '00000061,00000000,00000002,', '1', '2', null, '临渭区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610521', '610500', '0,610000,610500,', '21', '00000061,00000000,00000021,', '1', '2', null, '华　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610522', '610500', '0,610000,610500,', '22', '00000061,00000000,00000022,', '1', '2', null, '潼关县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610523', '610500', '0,610000,610500,', '23', '00000061,00000000,00000023,', '1', '2', null, '大荔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610524', '610500', '0,610000,610500,', '24', '00000061,00000000,00000024,', '1', '2', null, '合阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610525', '610500', '0,610000,610500,', '25', '00000061,00000000,00000025,', '1', '2', null, '澄城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610526', '610500', '0,610000,610500,', '26', '00000061,00000000,00000026,', '1', '2', null, '蒲城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610527', '610500', '0,610000,610500,', '27', '00000061,00000000,00000027,', '1', '2', null, '白水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610528', '610500', '0,610000,610500,', '28', '00000061,00000000,00000028,', '1', '2', null, '富平县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610581', '610500', '0,610000,610500,', '81', '00000061,00000000,00000081,', '1', '2', null, '韩城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610582', '610500', '0,610000,610500,', '82', '00000061,00000000,00000082,', '1', '2', null, '华阴市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610600', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '延安市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610602', '610600', '0,610000,610600,', '2', '00000061,00000000,00000002,', '1', '2', null, '宝塔区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610621', '610600', '0,610000,610600,', '21', '00000061,00000000,00000021,', '1', '2', null, '延长县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610622', '610600', '0,610000,610600,', '22', '00000061,00000000,00000022,', '1', '2', null, '延川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610623', '610600', '0,610000,610600,', '23', '00000061,00000000,00000023,', '1', '2', null, '子长县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610624', '610600', '0,610000,610600,', '24', '00000061,00000000,00000024,', '1', '2', null, '安塞县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610625', '610600', '0,610000,610600,', '25', '00000061,00000000,00000025,', '1', '2', null, '志丹县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610626', '610600', '0,610000,610600,', '26', '00000061,00000000,00000026,', '1', '2', null, '吴旗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610627', '610600', '0,610000,610600,', '27', '00000061,00000000,00000027,', '1', '2', null, '甘泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610628', '610600', '0,610000,610600,', '28', '00000061,00000000,00000028,', '1', '2', null, '富　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610629', '610600', '0,610000,610600,', '29', '00000061,00000000,00000029,', '1', '2', null, '洛川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610630', '610600', '0,610000,610600,', '30', '00000061,00000000,00000030,', '1', '2', null, '宜川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610631', '610600', '0,610000,610600,', '31', '00000061,00000000,00000031,', '1', '2', null, '黄龙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610632', '610600', '0,610000,610600,', '32', '00000061,00000000,00000032,', '1', '2', null, '黄陵县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610700', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '汉中市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610702', '610700', '0,610000,610700,', '2', '00000061,00000000,00000002,', '1', '2', null, '汉台区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610721', '610700', '0,610000,610700,', '21', '00000061,00000000,00000021,', '1', '2', null, '南郑县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610722', '610700', '0,610000,610700,', '22', '00000061,00000000,00000022,', '1', '2', null, '城固县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610723', '610700', '0,610000,610700,', '23', '00000061,00000000,00000023,', '1', '2', null, '洋　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610724', '610700', '0,610000,610700,', '24', '00000061,00000000,00000024,', '1', '2', null, '西乡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610725', '610700', '0,610000,610700,', '25', '00000061,00000000,00000025,', '1', '2', null, '勉　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610726', '610700', '0,610000,610700,', '26', '00000061,00000000,00000026,', '1', '2', null, '宁强县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610727', '610700', '0,610000,610700,', '27', '00000061,00000000,00000027,', '1', '2', null, '略阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610728', '610700', '0,610000,610700,', '28', '00000061,00000000,00000028,', '1', '2', null, '镇巴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610729', '610700', '0,610000,610700,', '29', '00000061,00000000,00000029,', '1', '2', null, '留坝县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610730', '610700', '0,610000,610700,', '30', '00000061,00000000,00000030,', '1', '2', null, '佛坪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610800', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '榆林市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610802', '610800', '0,610000,610800,', '2', '00000061,00000000,00000002,', '1', '2', null, '榆阳区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610821', '610800', '0,610000,610800,', '21', '00000061,00000000,00000021,', '1', '2', null, '神木县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610822', '610800', '0,610000,610800,', '22', '00000061,00000000,00000022,', '1', '2', null, '府谷县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610823', '610800', '0,610000,610800,', '23', '00000061,00000000,00000023,', '1', '2', null, '横山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610824', '610800', '0,610000,610800,', '24', '00000061,00000000,00000024,', '1', '2', null, '靖边县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610825', '610800', '0,610000,610800,', '25', '00000061,00000000,00000025,', '1', '2', null, '定边县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610826', '610800', '0,610000,610800,', '26', '00000061,00000000,00000026,', '1', '2', null, '绥德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610827', '610800', '0,610000,610800,', '27', '00000061,00000000,00000027,', '1', '2', null, '米脂县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610828', '610800', '0,610000,610800,', '28', '00000061,00000000,00000028,', '1', '2', null, '佳　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610829', '610800', '0,610000,610800,', '29', '00000061,00000000,00000029,', '1', '2', null, '吴堡县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610830', '610800', '0,610000,610800,', '30', '00000061,00000000,00000030,', '1', '2', null, '清涧县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610831', '610800', '0,610000,610800,', '31', '00000061,00000000,00000031,', '1', '2', null, '子洲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610900', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '安康市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610902', '610900', '0,610000,610900,', '2', '00000061,00000000,00000002,', '1', '2', null, '汉滨区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610921', '610900', '0,610000,610900,', '21', '00000061,00000000,00000021,', '1', '2', null, '汉阴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610922', '610900', '0,610000,610900,', '22', '00000061,00000000,00000022,', '1', '2', null, '石泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610923', '610900', '0,610000,610900,', '23', '00000061,00000000,00000023,', '1', '2', null, '宁陕县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610924', '610900', '0,610000,610900,', '24', '00000061,00000000,00000024,', '1', '2', null, '紫阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610925', '610900', '0,610000,610900,', '25', '00000061,00000000,00000025,', '1', '2', null, '岚皋县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610926', '610900', '0,610000,610900,', '26', '00000061,00000000,00000026,', '1', '2', null, '平利县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610927', '610900', '0,610000,610900,', '27', '00000061,00000000,00000027,', '1', '2', null, '镇坪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610928', '610900', '0,610000,610900,', '28', '00000061,00000000,00000028,', '1', '2', null, '旬阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('610929', '610900', '0,610000,610900,', '29', '00000061,00000000,00000029,', '1', '2', null, '白河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611000', '610000', '0,610000,', '0', '00000061,00000000,', '0', '1', null, '商洛市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611002', '611000', '0,610000,611000,', '2', '00000061,00000000,00000002,', '1', '2', null, '商州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611021', '611000', '0,610000,611000,', '21', '00000061,00000000,00000021,', '1', '2', null, '洛南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611022', '611000', '0,610000,611000,', '22', '00000061,00000000,00000022,', '1', '2', null, '丹凤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611023', '611000', '0,610000,611000,', '23', '00000061,00000000,00000023,', '1', '2', null, '商南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611024', '611000', '0,610000,611000,', '24', '00000061,00000000,00000024,', '1', '2', null, '山阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611025', '611000', '0,610000,611000,', '25', '00000061,00000000,00000025,', '1', '2', null, '镇安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('611026', '611000', '0,610000,611000,', '26', '00000061,00000000,00000026,', '1', '2', null, '柞水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620000', '0', '0,', '62', '00000062,', '0', '0', null, '甘肃省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620100', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '兰州市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620102', '620100', '0,620000,620100,', '2', '00000062,00000000,00000002,', '1', '2', null, '城关区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620103', '620100', '0,620000,620100,', '3', '00000062,00000000,00000003,', '1', '2', null, '七里河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620104', '620100', '0,620000,620100,', '4', '00000062,00000000,00000004,', '1', '2', null, '西固区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620105', '620100', '0,620000,620100,', '5', '00000062,00000000,00000005,', '1', '2', null, '安宁区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620111', '620100', '0,620000,620100,', '11', '00000062,00000000,00000011,', '1', '2', null, '红古区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620121', '620100', '0,620000,620100,', '21', '00000062,00000000,00000021,', '1', '2', null, '永登县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620122', '620100', '0,620000,620100,', '22', '00000062,00000000,00000022,', '1', '2', null, '皋兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620123', '620100', '0,620000,620100,', '23', '00000062,00000000,00000023,', '1', '2', null, '榆中县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620200', '620000', '0,620000,', '0', '00000062,00000000,', '1', '1', null, '嘉峪关市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620300', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '金昌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620302', '620300', '0,620000,620300,', '2', '00000062,00000000,00000002,', '1', '2', null, '金川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620321', '620300', '0,620000,620300,', '21', '00000062,00000000,00000021,', '1', '2', null, '永昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620400', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '白银市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620402', '620400', '0,620000,620400,', '2', '00000062,00000000,00000002,', '1', '2', null, '白银区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620403', '620400', '0,620000,620400,', '3', '00000062,00000000,00000003,', '1', '2', null, '平川区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620421', '620400', '0,620000,620400,', '21', '00000062,00000000,00000021,', '1', '2', null, '靖远县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620422', '620400', '0,620000,620400,', '22', '00000062,00000000,00000022,', '1', '2', null, '会宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620423', '620400', '0,620000,620400,', '23', '00000062,00000000,00000023,', '1', '2', null, '景泰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620500', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '天水市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620502', '620500', '0,620000,620500,', '2', '00000062,00000000,00000002,', '1', '2', null, '秦城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620503', '620500', '0,620000,620500,', '3', '00000062,00000000,00000003,', '1', '2', null, '北道区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620521', '620500', '0,620000,620500,', '21', '00000062,00000000,00000021,', '1', '2', null, '清水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620522', '620500', '0,620000,620500,', '22', '00000062,00000000,00000022,', '1', '2', null, '秦安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620523', '620500', '0,620000,620500,', '23', '00000062,00000000,00000023,', '1', '2', null, '甘谷县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620524', '620500', '0,620000,620500,', '24', '00000062,00000000,00000024,', '1', '2', null, '武山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620525', '620500', '0,620000,620500,', '25', '00000062,00000000,00000025,', '1', '2', null, '张家川回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620600', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '武威市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620602', '620600', '0,620000,620600,', '2', '00000062,00000000,00000002,', '1', '2', null, '凉州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620621', '620600', '0,620000,620600,', '21', '00000062,00000000,00000021,', '1', '2', null, '民勤县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620622', '620600', '0,620000,620600,', '22', '00000062,00000000,00000022,', '1', '2', null, '古浪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620623', '620600', '0,620000,620600,', '23', '00000062,00000000,00000023,', '1', '2', null, '天祝藏族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620700', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '张掖市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620702', '620700', '0,620000,620700,', '2', '00000062,00000000,00000002,', '1', '2', null, '甘州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620721', '620700', '0,620000,620700,', '21', '00000062,00000000,00000021,', '1', '2', null, '肃南裕固族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620722', '620700', '0,620000,620700,', '22', '00000062,00000000,00000022,', '1', '2', null, '民乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620723', '620700', '0,620000,620700,', '23', '00000062,00000000,00000023,', '1', '2', null, '临泽县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620724', '620700', '0,620000,620700,', '24', '00000062,00000000,00000024,', '1', '2', null, '高台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620725', '620700', '0,620000,620700,', '25', '00000062,00000000,00000025,', '1', '2', null, '山丹县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620800', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '平凉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620802', '620800', '0,620000,620800,', '2', '00000062,00000000,00000002,', '1', '2', null, '崆峒区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620821', '620800', '0,620000,620800,', '21', '00000062,00000000,00000021,', '1', '2', null, '泾川县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620822', '620800', '0,620000,620800,', '22', '00000062,00000000,00000022,', '1', '2', null, '灵台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620823', '620800', '0,620000,620800,', '23', '00000062,00000000,00000023,', '1', '2', null, '崇信县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620824', '620800', '0,620000,620800,', '24', '00000062,00000000,00000024,', '1', '2', null, '华亭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620825', '620800', '0,620000,620800,', '25', '00000062,00000000,00000025,', '1', '2', null, '庄浪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620826', '620800', '0,620000,620800,', '26', '00000062,00000000,00000026,', '1', '2', null, '静宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620900', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '酒泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620902', '620900', '0,620000,620900,', '2', '00000062,00000000,00000002,', '1', '2', null, '肃州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620921', '620900', '0,620000,620900,', '21', '00000062,00000000,00000021,', '1', '2', null, '金塔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620922', '620900', '0,620000,620900,', '22', '00000062,00000000,00000022,', '1', '2', null, '安西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620923', '620900', '0,620000,620900,', '23', '00000062,00000000,00000023,', '1', '2', null, '肃北蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620924', '620900', '0,620000,620900,', '24', '00000062,00000000,00000024,', '1', '2', null, '阿克塞哈萨克族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620981', '620900', '0,620000,620900,', '81', '00000062,00000000,00000081,', '1', '2', null, '玉门市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('620982', '620900', '0,620000,620900,', '82', '00000062,00000000,00000082,', '1', '2', null, '敦煌市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621000', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '庆阳市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621002', '621000', '0,620000,621000,', '2', '00000062,00000000,00000002,', '1', '2', null, '西峰区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621021', '621000', '0,620000,621000,', '21', '00000062,00000000,00000021,', '1', '2', null, '庆城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621022', '621000', '0,620000,621000,', '22', '00000062,00000000,00000022,', '1', '2', null, '环　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621023', '621000', '0,620000,621000,', '23', '00000062,00000000,00000023,', '1', '2', null, '华池县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621024', '621000', '0,620000,621000,', '24', '00000062,00000000,00000024,', '1', '2', null, '合水县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621025', '621000', '0,620000,621000,', '25', '00000062,00000000,00000025,', '1', '2', null, '正宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621026', '621000', '0,620000,621000,', '26', '00000062,00000000,00000026,', '1', '2', null, '宁　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621027', '621000', '0,620000,621000,', '27', '00000062,00000000,00000027,', '1', '2', null, '镇原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621100', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '定西市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621102', '621100', '0,620000,621100,', '2', '00000062,00000000,00000002,', '1', '2', null, '安定区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621121', '621100', '0,620000,621100,', '21', '00000062,00000000,00000021,', '1', '2', null, '通渭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621122', '621100', '0,620000,621100,', '22', '00000062,00000000,00000022,', '1', '2', null, '陇西县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621123', '621100', '0,620000,621100,', '23', '00000062,00000000,00000023,', '1', '2', null, '渭源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621124', '621100', '0,620000,621100,', '24', '00000062,00000000,00000024,', '1', '2', null, '临洮县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621125', '621100', '0,620000,621100,', '25', '00000062,00000000,00000025,', '1', '2', null, '漳　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621126', '621100', '0,620000,621100,', '26', '00000062,00000000,00000026,', '1', '2', null, '岷　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621200', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '陇南市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621202', '621200', '0,620000,621200,', '2', '00000062,00000000,00000002,', '1', '2', null, '武都区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621221', '621200', '0,620000,621200,', '21', '00000062,00000000,00000021,', '1', '2', null, '成　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621222', '621200', '0,620000,621200,', '22', '00000062,00000000,00000022,', '1', '2', null, '文　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621223', '621200', '0,620000,621200,', '23', '00000062,00000000,00000023,', '1', '2', null, '宕昌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621224', '621200', '0,620000,621200,', '24', '00000062,00000000,00000024,', '1', '2', null, '康　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621225', '621200', '0,620000,621200,', '25', '00000062,00000000,00000025,', '1', '2', null, '西和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621226', '621200', '0,620000,621200,', '26', '00000062,00000000,00000026,', '1', '2', null, '礼　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621227', '621200', '0,620000,621200,', '27', '00000062,00000000,00000027,', '1', '2', null, '徽　县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('621228', '621200', '0,620000,621200,', '28', '00000062,00000000,00000028,', '1', '2', null, '两当县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622900', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '临夏回族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622901', '622900', '0,620000,622900,', '1', '00000062,00000000,00000001,', '1', '2', null, '临夏市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622921', '622900', '0,620000,622900,', '21', '00000062,00000000,00000021,', '1', '2', null, '临夏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622922', '622900', '0,620000,622900,', '22', '00000062,00000000,00000022,', '1', '2', null, '康乐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622923', '622900', '0,620000,622900,', '23', '00000062,00000000,00000023,', '1', '2', null, '永靖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622924', '622900', '0,620000,622900,', '24', '00000062,00000000,00000024,', '1', '2', null, '广河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622925', '622900', '0,620000,622900,', '25', '00000062,00000000,00000025,', '1', '2', null, '和政县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622926', '622900', '0,620000,622900,', '26', '00000062,00000000,00000026,', '1', '2', null, '东乡族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('622927', '622900', '0,620000,622900,', '27', '00000062,00000000,00000027,', '1', '2', null, '积石山保安族东乡族撒拉族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623000', '620000', '0,620000,', '0', '00000062,00000000,', '0', '1', null, '甘南藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623001', '623000', '0,620000,623000,', '1', '00000062,00000000,00000001,', '1', '2', null, '合作市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623021', '623000', '0,620000,623000,', '21', '00000062,00000000,00000021,', '1', '2', null, '临潭县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623022', '623000', '0,620000,623000,', '22', '00000062,00000000,00000022,', '1', '2', null, '卓尼县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623023', '623000', '0,620000,623000,', '23', '00000062,00000000,00000023,', '1', '2', null, '舟曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623024', '623000', '0,620000,623000,', '24', '00000062,00000000,00000024,', '1', '2', null, '迭部县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623025', '623000', '0,620000,623000,', '25', '00000062,00000000,00000025,', '1', '2', null, '玛曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623026', '623000', '0,620000,623000,', '26', '00000062,00000000,00000026,', '1', '2', null, '碌曲县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('623027', '623000', '0,620000,623000,', '27', '00000062,00000000,00000027,', '1', '2', null, '夏河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630000', '0', '0,', '63', '00000063,', '0', '0', null, '青海省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630100', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '西宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630102', '630100', '0,630000,630100,', '2', '00000063,00000000,00000002,', '1', '2', null, '城东区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630103', '630100', '0,630000,630100,', '3', '00000063,00000000,00000003,', '1', '2', null, '城中区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630104', '630100', '0,630000,630100,', '4', '00000063,00000000,00000004,', '1', '2', null, '城西区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630105', '630100', '0,630000,630100,', '5', '00000063,00000000,00000005,', '1', '2', null, '城北区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630121', '630100', '0,630000,630100,', '21', '00000063,00000000,00000021,', '1', '2', null, '大通回族土族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630122', '630100', '0,630000,630100,', '22', '00000063,00000000,00000022,', '1', '2', null, '湟中县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('630123', '630100', '0,630000,630100,', '23', '00000063,00000000,00000023,', '1', '2', null, '湟源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632100', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '海东地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632121', '632100', '0,630000,632100,', '21', '00000063,00000000,00000021,', '1', '2', null, '平安县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632122', '632100', '0,630000,632100,', '22', '00000063,00000000,00000022,', '1', '2', null, '民和回族土族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632123', '632100', '0,630000,632100,', '23', '00000063,00000000,00000023,', '1', '2', null, '乐都县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632126', '632100', '0,630000,632100,', '26', '00000063,00000000,00000026,', '1', '2', null, '互助土族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632127', '632100', '0,630000,632100,', '27', '00000063,00000000,00000027,', '1', '2', null, '化隆回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632128', '632100', '0,630000,632100,', '28', '00000063,00000000,00000028,', '1', '2', null, '循化撒拉族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632200', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '海北藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632221', '632200', '0,630000,632200,', '21', '00000063,00000000,00000021,', '1', '2', null, '门源回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632222', '632200', '0,630000,632200,', '22', '00000063,00000000,00000022,', '1', '2', null, '祁连县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632223', '632200', '0,630000,632200,', '23', '00000063,00000000,00000023,', '1', '2', null, '海晏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632224', '632200', '0,630000,632200,', '24', '00000063,00000000,00000024,', '1', '2', null, '刚察县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632300', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '黄南藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632321', '632300', '0,630000,632300,', '21', '00000063,00000000,00000021,', '1', '2', null, '同仁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632322', '632300', '0,630000,632300,', '22', '00000063,00000000,00000022,', '1', '2', null, '尖扎县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632323', '632300', '0,630000,632300,', '23', '00000063,00000000,00000023,', '1', '2', null, '泽库县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632324', '632300', '0,630000,632300,', '24', '00000063,00000000,00000024,', '1', '2', null, '河南蒙古族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632500', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '海南藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632521', '632500', '0,630000,632500,', '21', '00000063,00000000,00000021,', '1', '2', null, '共和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632522', '632500', '0,630000,632500,', '22', '00000063,00000000,00000022,', '1', '2', null, '同德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632523', '632500', '0,630000,632500,', '23', '00000063,00000000,00000023,', '1', '2', null, '贵德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632524', '632500', '0,630000,632500,', '24', '00000063,00000000,00000024,', '1', '2', null, '兴海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632525', '632500', '0,630000,632500,', '25', '00000063,00000000,00000025,', '1', '2', null, '贵南县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632600', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '果洛藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632621', '632600', '0,630000,632600,', '21', '00000063,00000000,00000021,', '1', '2', null, '玛沁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632622', '632600', '0,630000,632600,', '22', '00000063,00000000,00000022,', '1', '2', null, '班玛县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632623', '632600', '0,630000,632600,', '23', '00000063,00000000,00000023,', '1', '2', null, '甘德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632624', '632600', '0,630000,632600,', '24', '00000063,00000000,00000024,', '1', '2', null, '达日县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632625', '632600', '0,630000,632600,', '25', '00000063,00000000,00000025,', '1', '2', null, '久治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632626', '632600', '0,630000,632600,', '26', '00000063,00000000,00000026,', '1', '2', null, '玛多县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632700', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '玉树藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632721', '632700', '0,630000,632700,', '21', '00000063,00000000,00000021,', '1', '2', null, '玉树县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632722', '632700', '0,630000,632700,', '22', '00000063,00000000,00000022,', '1', '2', null, '杂多县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632723', '632700', '0,630000,632700,', '23', '00000063,00000000,00000023,', '1', '2', null, '称多县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632724', '632700', '0,630000,632700,', '24', '00000063,00000000,00000024,', '1', '2', null, '治多县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632725', '632700', '0,630000,632700,', '25', '00000063,00000000,00000025,', '1', '2', null, '囊谦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632726', '632700', '0,630000,632700,', '26', '00000063,00000000,00000026,', '1', '2', null, '曲麻莱县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632800', '630000', '0,630000,', '0', '00000063,00000000,', '0', '1', null, '海西蒙古族藏族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632801', '632800', '0,630000,632800,', '1', '00000063,00000000,00000001,', '1', '2', null, '格尔木市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632802', '632800', '0,630000,632800,', '2', '00000063,00000000,00000002,', '1', '2', null, '德令哈市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632821', '632800', '0,630000,632800,', '21', '00000063,00000000,00000021,', '1', '2', null, '乌兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632822', '632800', '0,630000,632800,', '22', '00000063,00000000,00000022,', '1', '2', null, '都兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('632823', '632800', '0,630000,632800,', '23', '00000063,00000000,00000023,', '1', '2', null, '天峻县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640000', '0', '0,', '64', '00000064,', '0', '0', null, '宁夏回族自治区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640100', '640000', '0,640000,', '0', '00000064,00000000,', '0', '1', null, '银川市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640104', '640100', '0,640000,640100,', '4', '00000064,00000000,00000004,', '1', '2', null, '兴庆区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640105', '640100', '0,640000,640100,', '5', '00000064,00000000,00000005,', '1', '2', null, '西夏区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640106', '640100', '0,640000,640100,', '6', '00000064,00000000,00000006,', '1', '2', null, '金凤区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640121', '640100', '0,640000,640100,', '21', '00000064,00000000,00000021,', '1', '2', null, '永宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640122', '640100', '0,640000,640100,', '22', '00000064,00000000,00000022,', '1', '2', null, '贺兰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640181', '640100', '0,640000,640100,', '81', '00000064,00000000,00000081,', '1', '2', null, '灵武市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640200', '640000', '0,640000,', '0', '00000064,00000000,', '0', '1', null, '石嘴山市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640202', '640200', '0,640000,640200,', '2', '00000064,00000000,00000002,', '1', '2', null, '大武口区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640205', '640200', '0,640000,640200,', '5', '00000064,00000000,00000005,', '1', '2', null, '惠农区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640221', '640200', '0,640000,640200,', '21', '00000064,00000000,00000021,', '1', '2', null, '平罗县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640300', '640000', '0,640000,', '0', '00000064,00000000,', '0', '1', null, '吴忠市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640302', '640300', '0,640000,640300,', '2', '00000064,00000000,00000002,', '1', '2', null, '利通区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640323', '640300', '0,640000,640300,', '23', '00000064,00000000,00000023,', '1', '2', null, '盐池县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640324', '640300', '0,640000,640300,', '24', '00000064,00000000,00000024,', '1', '2', null, '同心县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640381', '640300', '0,640000,640300,', '81', '00000064,00000000,00000081,', '1', '2', null, '青铜峡市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640400', '640000', '0,640000,', '0', '00000064,00000000,', '0', '1', null, '固原市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640402', '640400', '0,640000,640400,', '2', '00000064,00000000,00000002,', '1', '2', null, '原州区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640422', '640400', '0,640000,640400,', '22', '00000064,00000000,00000022,', '1', '2', null, '西吉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640423', '640400', '0,640000,640400,', '23', '00000064,00000000,00000023,', '1', '2', null, '隆德县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640424', '640400', '0,640000,640400,', '24', '00000064,00000000,00000024,', '1', '2', null, '泾源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640425', '640400', '0,640000,640400,', '25', '00000064,00000000,00000025,', '1', '2', null, '彭阳县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640500', '640000', '0,640000,', '0', '00000064,00000000,', '0', '1', null, '中卫市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640502', '640500', '0,640000,640500,', '2', '00000064,00000000,00000002,', '1', '2', null, '沙坡头区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640521', '640500', '0,640000,640500,', '21', '00000064,00000000,00000021,', '1', '2', null, '中宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('640522', '640400', '0,640000,640400,', '22', '00000064,00000000,00000022,', '1', '2', null, '海原县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650000', '0', '0,', '65', '00000065,', '0', '0', null, '新疆维吾尔自治区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650100', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '乌鲁木齐市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650102', '650100', '0,650000,650100,', '2', '00000065,00000000,00000002,', '1', '2', null, '天山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650103', '650100', '0,650000,650100,', '3', '00000065,00000000,00000003,', '1', '2', null, '沙依巴克区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650104', '650100', '0,650000,650100,', '4', '00000065,00000000,00000004,', '1', '2', null, '新市区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650105', '650100', '0,650000,650100,', '5', '00000065,00000000,00000005,', '1', '2', null, '水磨沟区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650106', '650100', '0,650000,650100,', '6', '00000065,00000000,00000006,', '1', '2', null, '头屯河区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650107', '650100', '0,650000,650100,', '7', '00000065,00000000,00000007,', '1', '2', null, '达坂城区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650108', '650100', '0,650000,650100,', '8', '00000065,00000000,00000008,', '1', '2', null, '东山区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650121', '650100', '0,650000,650100,', '21', '00000065,00000000,00000021,', '1', '2', null, '乌鲁木齐县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650200', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '克拉玛依市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650202', '650200', '0,650000,650200,', '2', '00000065,00000000,00000002,', '1', '2', null, '独山子区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650203', '650200', '0,650000,650200,', '3', '00000065,00000000,00000003,', '1', '2', null, '克拉玛依区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650204', '650200', '0,650000,650200,', '4', '00000065,00000000,00000004,', '1', '2', null, '白碱滩区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('650205', '650200', '0,650000,650200,', '5', '00000065,00000000,00000005,', '1', '2', null, '乌尔禾区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652100', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '吐鲁番地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652101', '652100', '0,650000,652100,', '1', '00000065,00000000,00000001,', '1', '2', null, '吐鲁番市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652122', '652100', '0,650000,652100,', '22', '00000065,00000000,00000022,', '1', '2', null, '鄯善县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652123', '652100', '0,650000,652100,', '23', '00000065,00000000,00000023,', '1', '2', null, '托克逊县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652200', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '哈密地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652201', '652200', '0,650000,652200,', '1', '00000065,00000000,00000001,', '1', '2', null, '哈密市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652222', '652200', '0,650000,652200,', '22', '00000065,00000000,00000022,', '1', '2', null, '巴里坤哈萨克自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652223', '652200', '0,650000,652200,', '23', '00000065,00000000,00000023,', '1', '2', null, '伊吾县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652300', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '昌吉回族自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652301', '652300', '0,650000,652300,', '1', '00000065,00000000,00000001,', '1', '2', null, '昌吉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652302', '652300', '0,650000,652300,', '2', '00000065,00000000,00000002,', '1', '2', null, '阜康市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652303', '652300', '0,650000,652300,', '3', '00000065,00000000,00000003,', '1', '2', null, '米泉市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652323', '652300', '0,650000,652300,', '23', '00000065,00000000,00000023,', '1', '2', null, '呼图壁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652324', '652300', '0,650000,652300,', '24', '00000065,00000000,00000024,', '1', '2', null, '玛纳斯县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652325', '652300', '0,650000,652300,', '25', '00000065,00000000,00000025,', '1', '2', null, '奇台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652327', '652300', '0,650000,652300,', '27', '00000065,00000000,00000027,', '1', '2', null, '吉木萨尔县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652328', '652300', '0,650000,652300,', '28', '00000065,00000000,00000028,', '1', '2', null, '木垒哈萨克自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652700', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '博尔塔拉蒙古自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652701', '652700', '0,650000,652700,', '1', '00000065,00000000,00000001,', '1', '2', null, '博乐市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652722', '652700', '0,650000,652700,', '22', '00000065,00000000,00000022,', '1', '2', null, '精河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652723', '652700', '0,650000,652700,', '23', '00000065,00000000,00000023,', '1', '2', null, '温泉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652800', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '巴音郭楞蒙古自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652801', '652800', '0,650000,652800,', '1', '00000065,00000000,00000001,', '1', '2', null, '库尔勒市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652822', '652800', '0,650000,652800,', '22', '00000065,00000000,00000022,', '1', '2', null, '轮台县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652823', '652800', '0,650000,652800,', '23', '00000065,00000000,00000023,', '1', '2', null, '尉犁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652824', '652800', '0,650000,652800,', '24', '00000065,00000000,00000024,', '1', '2', null, '若羌县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652825', '652800', '0,650000,652800,', '25', '00000065,00000000,00000025,', '1', '2', null, '且末县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652826', '652800', '0,650000,652800,', '26', '00000065,00000000,00000026,', '1', '2', null, '焉耆回族自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652827', '652800', '0,650000,652800,', '27', '00000065,00000000,00000027,', '1', '2', null, '和静县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652828', '652800', '0,650000,652800,', '28', '00000065,00000000,00000028,', '1', '2', null, '和硕县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652829', '652800', '0,650000,652800,', '29', '00000065,00000000,00000029,', '1', '2', null, '博湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652900', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '阿克苏地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652901', '652900', '0,650000,652900,', '1', '00000065,00000000,00000001,', '1', '2', null, '阿克苏市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652922', '652900', '0,650000,652900,', '22', '00000065,00000000,00000022,', '1', '2', null, '温宿县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652923', '652900', '0,650000,652900,', '23', '00000065,00000000,00000023,', '1', '2', null, '库车县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652924', '652900', '0,650000,652900,', '24', '00000065,00000000,00000024,', '1', '2', null, '沙雅县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652925', '652900', '0,650000,652900,', '25', '00000065,00000000,00000025,', '1', '2', null, '新和县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652926', '652900', '0,650000,652900,', '26', '00000065,00000000,00000026,', '1', '2', null, '拜城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652927', '652900', '0,650000,652900,', '27', '00000065,00000000,00000027,', '1', '2', null, '乌什县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652928', '652900', '0,650000,652900,', '28', '00000065,00000000,00000028,', '1', '2', null, '阿瓦提县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('652929', '652900', '0,650000,652900,', '29', '00000065,00000000,00000029,', '1', '2', null, '柯坪县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653000', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '克孜勒苏柯尔克孜自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653001', '653000', '0,650000,653000,', '1', '00000065,00000000,00000001,', '1', '2', null, '阿图什市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653022', '653000', '0,650000,653000,', '22', '00000065,00000000,00000022,', '1', '2', null, '阿克陶县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653023', '653000', '0,650000,653000,', '23', '00000065,00000000,00000023,', '1', '2', null, '阿合奇县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653024', '653000', '0,650000,653000,', '24', '00000065,00000000,00000024,', '1', '2', null, '乌恰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653100', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '喀什地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653101', '653100', '0,650000,653100,', '1', '00000065,00000000,00000001,', '1', '2', null, '喀什市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653121', '653100', '0,650000,653100,', '21', '00000065,00000000,00000021,', '1', '2', null, '疏附县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653122', '653100', '0,650000,653100,', '22', '00000065,00000000,00000022,', '1', '2', null, '疏勒县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653123', '653100', '0,650000,653100,', '23', '00000065,00000000,00000023,', '1', '2', null, '英吉沙县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653124', '653100', '0,650000,653100,', '24', '00000065,00000000,00000024,', '1', '2', null, '泽普县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653125', '653100', '0,650000,653100,', '25', '00000065,00000000,00000025,', '1', '2', null, '莎车县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653126', '653100', '0,650000,653100,', '26', '00000065,00000000,00000026,', '1', '2', null, '叶城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653127', '653100', '0,650000,653100,', '27', '00000065,00000000,00000027,', '1', '2', null, '麦盖提县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653128', '653100', '0,650000,653100,', '28', '00000065,00000000,00000028,', '1', '2', null, '岳普湖县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653129', '653100', '0,650000,653100,', '29', '00000065,00000000,00000029,', '1', '2', null, '伽师县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653130', '653100', '0,650000,653100,', '30', '00000065,00000000,00000030,', '1', '2', null, '巴楚县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653131', '653100', '0,650000,653100,', '31', '00000065,00000000,00000031,', '1', '2', null, '塔什库尔干塔吉克自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653200', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '和田地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653201', '653200', '0,650000,653200,', '1', '00000065,00000000,00000001,', '1', '2', null, '和田市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653221', '653200', '0,650000,653200,', '21', '00000065,00000000,00000021,', '1', '2', null, '和田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653222', '653200', '0,650000,653200,', '22', '00000065,00000000,00000022,', '1', '2', null, '墨玉县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653223', '653200', '0,650000,653200,', '23', '00000065,00000000,00000023,', '1', '2', null, '皮山县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653224', '653200', '0,650000,653200,', '24', '00000065,00000000,00000024,', '1', '2', null, '洛浦县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653225', '653200', '0,650000,653200,', '25', '00000065,00000000,00000025,', '1', '2', null, '策勒县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653226', '653200', '0,650000,653200,', '26', '00000065,00000000,00000026,', '1', '2', null, '于田县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('653227', '653200', '0,650000,653200,', '27', '00000065,00000000,00000027,', '1', '2', null, '民丰县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654000', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '伊犁哈萨克自治州', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654002', '654000', '0,650000,654000,', '2', '00000065,00000000,00000002,', '1', '2', null, '伊宁市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654003', '654000', '0,650000,654000,', '3', '00000065,00000000,00000003,', '1', '2', null, '奎屯市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654021', '654000', '0,650000,654000,', '21', '00000065,00000000,00000021,', '1', '2', null, '伊宁县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654022', '654000', '0,650000,654000,', '22', '00000065,00000000,00000022,', '1', '2', null, '察布查尔锡伯自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654023', '654000', '0,650000,654000,', '23', '00000065,00000000,00000023,', '1', '2', null, '霍城县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654024', '654000', '0,650000,654000,', '24', '00000065,00000000,00000024,', '1', '2', null, '巩留县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654025', '654000', '0,650000,654000,', '25', '00000065,00000000,00000025,', '1', '2', null, '新源县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654026', '654000', '0,650000,654000,', '26', '00000065,00000000,00000026,', '1', '2', null, '昭苏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654027', '654000', '0,650000,654000,', '27', '00000065,00000000,00000027,', '1', '2', null, '特克斯县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654028', '654000', '0,650000,654000,', '28', '00000065,00000000,00000028,', '1', '2', null, '尼勒克县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654200', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '塔城地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654201', '654200', '0,650000,654200,', '1', '00000065,00000000,00000001,', '1', '2', null, '塔城市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654202', '654200', '0,650000,654200,', '2', '00000065,00000000,00000002,', '1', '2', null, '乌苏市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654221', '654200', '0,650000,654200,', '21', '00000065,00000000,00000021,', '1', '2', null, '额敏县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654223', '654200', '0,650000,654200,', '23', '00000065,00000000,00000023,', '1', '2', null, '沙湾县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654224', '654200', '0,650000,654200,', '24', '00000065,00000000,00000024,', '1', '2', null, '托里县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654225', '654200', '0,650000,654200,', '25', '00000065,00000000,00000025,', '1', '2', null, '裕民县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654226', '654200', '0,650000,654200,', '26', '00000065,00000000,00000026,', '1', '2', null, '和布克赛尔蒙古自治县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654300', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '阿勒泰地区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654301', '654300', '0,650000,654300,', '1', '00000065,00000000,00000001,', '1', '2', null, '阿勒泰市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654321', '654300', '0,650000,654300,', '21', '00000065,00000000,00000021,', '1', '2', null, '布尔津县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654322', '654300', '0,650000,654300,', '22', '00000065,00000000,00000022,', '1', '2', null, '富蕴县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654323', '654300', '0,650000,654300,', '23', '00000065,00000000,00000023,', '1', '2', null, '福海县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654324', '654300', '0,650000,654300,', '24', '00000065,00000000,00000024,', '1', '2', null, '哈巴河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654325', '654300', '0,650000,654300,', '25', '00000065,00000000,00000025,', '1', '2', null, '青河县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('654326', '654300', '0,650000,654300,', '26', '00000065,00000000,00000026,', '1', '2', null, '吉木乃县', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('659000', '650000', '0,650000,', '0', '00000065,00000000,', '0', '1', null, '省直辖行政单位', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('659001', '659000', '0,650000,659000,', '1', '00000065,00000000,00000001,', '1', '2', null, '石河子市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('659002', '659000', '0,650000,659000,', '2', '00000065,00000000,00000002,', '1', '2', null, '阿拉尔市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('659003', '659000', '0,650000,659000,', '3', '00000065,00000000,00000003,', '1', '2', null, '图木舒克市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('659004', '659000', '0,650000,659000,', '4', '00000065,00000000,00000004,', '1', '2', null, '五家渠市', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('710000', '0', '0,', '71', '00000071,', '1', '0', null, '台湾省', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('810000', '0', '0,', '81', '00000081,', '1', '0', null, '香港特别行政区', null, '0', null, null, null, null);
INSERT INTO `sys_area` VALUES ('820000', '0', '0,', '82', '00000082,', '1', '0', null, '澳门特别行政区', null, '0', null, null, null, null);

-- ----------------------------
-- Table structure for sys_bean_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_bean_data`;
CREATE TABLE `sys_bean_data` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `bean_key` varchar(20) DEFAULT NULL COMMENT '类型',
  `bean_val` varchar(20) DEFAULT NULL COMMENT '值',
  `bean_txt` varchar(20) DEFAULT NULL COMMENT '标签',
  `bean_sort` int(11) DEFAULT NULL COMMENT '排序',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、8停用、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `beantype_tKey` (`bean_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典数据';

-- ----------------------------
-- Records of sys_bean_data
-- ----------------------------
INSERT INTO `sys_bean_data` VALUES ('1174212046086033408', 'com_cards_type', '1', '储值卡', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046140559360', 'com_cards_type', '2', '储次卡', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046253805568', 'com_cards_is_week', '0', '不限', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046253805569', 'com_cards_is_week', '1', '周末卡', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046262194176', 'com_cards_is_week', '2', '非周末卡', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046270582784', 'member_source', '1', '微信', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046278971392', 'member_source', '2', '网页', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046291554304', 'member_source', '3', '店内', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212046304137216', 'course_isCheck', '1', '开', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212059474251776', 'course_isCheck', '0', '关', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212059616858112', 'activity_payStatus', '1', '在线支付', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212059688161280', 'activity_payStatus', '2', '到店支付', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212059763658752', 'activity_payStatus', '3', '不限', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212060975812608', 'activity_status', '0', '未开始', '0', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212061068087296', 'activity_status', '1', '报名中', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212163484602368', 'activity_status', '2', '报名结束', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212163543322624', 'activity_status', '3', '活动结束', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212163614625792', 'activity_status', '4', '活动取消', '4', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212169369210880', 'activity_status', '6', '草稿', '5', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212169499234304', 'com_goods_is_show', '0', '下架', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212169570537472', 'com_goods_is_show', '1', '上架', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212169646034944', 'course_enroll_status', '1', '预约成功', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212171365699584', 'course_enroll_status', '2', '取消预约', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212171449585664', 'course_enroll_status', '3', '预约不通过', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212222892724224', 'course_enroll_status', '4', '已签到', '4', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212223165353984', 'course_enroll_status', '5', '已完成', '5', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212223253434368', 'cash_buy_type', '1', '消费收银', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212223328931840', 'cash_buy_type', '2', '储值扣费', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228248850432', 'cash_buy_type', '3', '会员储值', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228416622592', 'pay_type', '1', '现金', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228471148544', 'pay_type', '2', '微信', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228521480192', 'pay_type', '3', '支付宝', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228576006144', 'pay_type', '4', '刷卡', '4', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228580200448', 'cash_buy_type', '11', '储值扣费', '5', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228588589056', 'activity_en_status', '0', '正常', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228601171968', 'activity_en_status', '1', '已取消', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212228622143488', 'activity_en_status', '4', '等位', '5', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212231537184768', 'activity_en_is_sign', '0', '没签到', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212231696568320', 'activity_en_is_sign', '1', '已签到', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212231814008832', 'card_change_type', '1', '消费', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212231902089216', 'card_change_type', '2', '储值', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212237539233792', 'card_change_type', '4', '失效', '4', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212237648285696', 'sys_user_status', '0', '正常', '1', '0', null, null, 'junAdmin', '2019-10-15 07:37:17', null);
INSERT INTO `sys_bean_data` VALUES ('1174212240320057344', 'sys_user_status', '8', '停用', '2', '0', null, null, 'junAdmin', '2019-10-15 07:37:17', null);
INSERT INTO `sys_bean_data` VALUES ('1174212240450080768', 'is_yes', '0', '否', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212240512995328', 'is_yes', '1', '是', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212240584298496', 'sys_user_type', 'none', '&nbsp;', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212241800646656', 'sys_user_type', 'staff', '员工', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212241800646657', 'sys_user_type', 'sale', '导购', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212241926475776', 'card_change_type', '3', '赠送', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1174212241976807424', 'company_config', 'bonus_mode', '奖金统计方式', '1', '0', null, null, 'junAdmin', '2019-11-04 13:40:53', '上课奖金统计方式（1按课时，2按签到人数，3按评价）');
INSERT INTO `sys_bean_data` VALUES ('1174212242027139072', 'company_config', 'sign_send_points', '准时签到送积分', '2', '0', null, null, 'junAdmin', '2019-11-04 13:40:53', '会员准时签到，赠送会员＂?＂积分');
INSERT INTO `sys_bean_data` VALUES ('1183648239905316865', 'stock_num_type', '1', '增加', '1', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1183648239905316866', 'stock_num_type', '2', '减少', '2', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1183648239905316867', 'stock_num_type', '3', '盘点', '3', '0', null, null, null, null, null);
INSERT INTO `sys_bean_data` VALUES ('1184662712336703488', 'company_config', 'buy_send_points', '消费积分比例', '3', '0', 'junAdmin', '2019-10-17 10:49:35', 'junAdmin', '2019-11-04 13:40:53', '会员消费后，赠送消费金额乘以＂?＂%的积分');
INSERT INTO `sys_bean_data` VALUES ('1184662712340897792', 'company_config', 'course_cancel_time', '课程提前取消时间', '4', '0', 'junAdmin', '2019-10-17 10:49:35', 'junAdmin', '2019-11-04 13:40:53', '课程开始前＂?＂小时，允许取消课程');
INSERT INTO `sys_bean_data` VALUES ('1184662712345092096', 'company_config', 'activity_cancel_time', '活动提前取消时间', '5', '0', 'junAdmin', '2019-10-17 10:49:35', 'junAdmin', '2019-11-04 13:40:53', '活动开始前＂?＂小时，允许取消课程');
INSERT INTO `sys_bean_data` VALUES ('1184698710722555904', 'mobile_setting_type', '1', '轮播', '1', '0', 'junAdmin', '2019-10-17 13:12:38', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_data` VALUES ('1184986744041586688', 'company_config', 'sale_ratio_1', '导购一级提成比例', '6', '0', 'junAdmin', '2019-10-18 08:17:10', 'junAdmin', '2019-11-04 13:40:53', '会员消费后，一级导购提成＂?＂%的奖金');
INSERT INTO `sys_bean_data` VALUES ('1184986744045780992', 'company_config', 'sale_ratio_2', '导购二级提成比例', '7', '0', 'junAdmin', '2019-10-18 08:17:10', 'junAdmin', '2019-11-04 13:40:53', '会员消费后，二级导购提成＂?＂%的奖金');
INSERT INTO `sys_bean_data` VALUES ('1184986744045780993', 'company_config', 'com_phone', '联系电话', '8', '0', 'junAdmin', '2019-10-30 14:24:05', 'junAdmin', '2019-11-04 13:40:53', null);
INSERT INTO `sys_bean_data` VALUES ('1184986744045780994', 'company_config', 'com_coordinate', '地图坐标', '9', '0', 'junAdmin', '2019-10-30 14:24:05', 'junAdmin', '2019-11-04 13:40:53', null);
INSERT INTO `sys_bean_data` VALUES ('1186522125724209152', 'leave_type', '1', '事假', '1', '0', 'junAdmin', '2019-10-22 13:58:14', 'junAdmin', '2019-10-22 13:58:14', null);
INSERT INTO `sys_bean_data` VALUES ('1186522125740986368', 'leave_type', '2', '病假', '2', '0', 'junAdmin', '2019-10-22 13:58:14', 'junAdmin', '2019-10-22 13:58:14', null);
INSERT INTO `sys_bean_data` VALUES ('1186522125753569280', 'leave_type', '3', '婚假', '3', '0', 'junAdmin', '2019-10-22 13:58:14', 'junAdmin', '2019-10-22 13:58:14', null);
INSERT INTO `sys_bean_data` VALUES ('1186522125766152192', 'leave_type', '4', '年假', '4', '0', 'junAdmin', '2019-10-22 13:58:14', 'junAdmin', '2019-10-22 13:58:14', null);
INSERT INTO `sys_bean_data` VALUES ('1186522345669316608', 'leave_isCancel', '0', '否', '1', '0', 'junAdmin', '2019-10-22 13:59:06', 'junAdmin', '2019-10-22 13:59:06', null);
INSERT INTO `sys_bean_data` VALUES ('1186522345681899520', 'leave_isCancel', '1', '是', '2', '0', 'junAdmin', '2019-10-22 13:59:06', 'junAdmin', '2019-10-22 13:59:06', null);
INSERT INTO `sys_bean_data` VALUES ('1186522578839064576', 'leave_checkState', '1', '待审批', '1', '0', 'junAdmin', '2019-10-22 14:00:02', 'junAdmin', '2019-10-22 14:00:02', null);
INSERT INTO `sys_bean_data` VALUES ('1186522578851647488', 'leave_checkState', '2', '未通过', '2', '0', 'junAdmin', '2019-10-22 14:00:02', 'junAdmin', '2019-10-22 14:00:02', null);
INSERT INTO `sys_bean_data` VALUES ('1186522578864230400', 'leave_checkState', '3', '已通过', '3', '0', 'junAdmin', '2019-10-22 14:00:02', 'junAdmin', '2019-10-22 14:00:02', null);
INSERT INTO `sys_bean_data` VALUES ('1186522578864230401', 'leave_checkState', '4', '已取消', '4', '0', 'junAdmin', '2019-10-22 14:00:02', 'junAdmin', '2019-10-22 14:00:02', null);
INSERT INTO `sys_bean_data` VALUES ('1186783685706420224', 'arttype_type', '1', '关于我们', '1', '0', 'junAdmin', '2019-10-23 07:17:35', 'junAdmin', '2019-11-01 16:16:26', null);
INSERT INTO `sys_bean_data` VALUES ('1186783685710614528', 'arttype_type', '2', '宝妈教学', '2', '0', 'junAdmin', '2019-10-23 07:17:35', 'junAdmin', '2019-11-01 16:16:26', null);
INSERT INTO `sys_bean_data` VALUES ('1186783685714808832', 'arttype_type', '3', '员工端通知', '3', '0', 'junAdmin', '2019-10-23 07:17:35', 'junAdmin', '2019-11-01 16:16:26', null);
INSERT INTO `sys_bean_data` VALUES ('1186787843036987392', 'arttype_type', '4', '品牌介绍', '4', '0', 'junAdmin', '2019-10-23 07:34:06', 'junAdmin', '2019-11-01 16:16:26', null);
INSERT INTO `sys_bean_data` VALUES ('1186919061804064768', 'points_bizType', '1', '消费', '1', '0', 'junAdmin', '2019-10-23 16:15:31', 'junAdmin', '2019-10-23 16:15:31', null);
INSERT INTO `sys_bean_data` VALUES ('1186919061820841984', 'points_bizType', '2', '课程签到', '2', '0', 'junAdmin', '2019-10-23 16:15:31', 'junAdmin', '2019-10-23 16:15:31', null);
INSERT INTO `sys_bean_data` VALUES ('1186919061837619200', 'points_bizType', '3', '活动签到', '3', '0', 'junAdmin', '2019-10-23 16:15:31', 'junAdmin', '2019-10-23 16:15:31', null);
INSERT INTO `sys_bean_data` VALUES ('1186919061850202112', 'points_bizType', '4', '赠送', '4', '0', 'junAdmin', '2019-10-23 16:15:31', 'junAdmin', '2019-10-23 16:15:31', null);
INSERT INTO `sys_bean_data` VALUES ('1186919061850202113', 'points_bizType', '5', '积分兑换', '5', '0', 'junAdmin', '2019-10-23 16:16:16', 'junAdmin', '2019-10-23 16:16:16', '');
INSERT INTO `sys_bean_data` VALUES ('1186919249520140288', 'points_type', '1', '增加', '1', '0', 'junAdmin', '2019-10-23 16:16:16', 'junAdmin', '2019-10-23 16:16:16', null);
INSERT INTO `sys_bean_data` VALUES ('1186919249532723200', 'points_type', '2', '扣除', '2', '0', 'junAdmin', '2019-10-23 16:16:16', 'junAdmin', '2019-10-23 16:16:16', null);
INSERT INTO `sys_bean_data` VALUES ('1190180785608327168', 'arttype_type', '9', '其他', '9', '0', 'junAdmin', '2019-11-01 16:16:26', 'junAdmin', '2019-11-01 16:16:26', null);
INSERT INTO `sys_bean_data` VALUES ('1191150202893283328', 'company_config', 'com_tishi', '预约提示', '10', '0', 'junAdmin', '2019-11-04 08:28:34', 'junAdmin', '2019-11-04 13:40:53', null);
INSERT INTO `sys_bean_data` VALUES ('1191228801332666368', 'company_config', 'com_chuzhi', '卡余额不足', '11', '0', 'junAdmin', '2019-11-04 13:40:53', 'junAdmin', '2019-11-04 13:40:53', '储值余额不足＂?＂元，提示');
INSERT INTO `sys_bean_data` VALUES ('1191228801341054976', 'company_config', 'com_chuci', '储次不足', '11', '0', 'junAdmin', '2019-11-04 13:40:53', 'junAdmin', '2019-11-04 13:40:53', '储次余额不足＂?＂次，提示');
INSERT INTO `sys_bean_data` VALUES ('1191228801353637888', 'company_config', 'com_cardTime', '卡过期', '12', '0', 'junAdmin', '2019-11-04 13:40:53', 'junAdmin', '2019-11-04 13:40:53', '会员卡还有＂?＂小时过期，提示');
INSERT INTO `sys_bean_data` VALUES ('1193812217818546176', 'sysComMsg_type', '1', '产品消息', '1', '0', 'junAdmin', '2019-11-11 16:46:27', 'junAdmin', '2019-11-11 16:46:27', null);
INSERT INTO `sys_bean_data` VALUES ('1193812217831129088', 'sysComMsg_type', '2', '服务消息', '2', '0', 'junAdmin', '2019-11-11 16:46:27', 'junAdmin', '2019-11-11 16:46:27', null);
INSERT INTO `sys_bean_data` VALUES ('1193812217839517696', 'sysComMsg_type', '3', '活动消息', '3', '0', 'junAdmin', '2019-11-11 16:46:27', 'junAdmin', '2019-11-11 16:46:27', null);
INSERT INTO `sys_bean_data` VALUES ('1193812425084272640', 'receive_type', '0', '全部', '1', '0', 'junAdmin', '2019-11-11 16:47:17', 'junAdmin', '2019-11-11 16:47:17', null);
INSERT INTO `sys_bean_data` VALUES ('1193812425105244160', 'receive_type', '1', '用户', '2', '0', 'junAdmin', '2019-11-11 16:47:17', 'junAdmin', '2019-11-11 16:47:17', null);
INSERT INTO `sys_bean_data` VALUES ('1194051227359604736', 'msg_read_state', '1', '待发送', '1', '0', 'junAdmin', '2019-11-12 08:36:12', 'junAdmin', '2019-11-12 08:36:12', null);
INSERT INTO `sys_bean_data` VALUES ('1194051227372187648', 'msg_read_state', '2', '未读', '2', '0', 'junAdmin', '2019-11-12 08:36:12', 'junAdmin', '2019-11-12 08:36:12', null);
INSERT INTO `sys_bean_data` VALUES ('1194051227384770560', 'msg_read_state', '3', '已读', '3', '0', 'junAdmin', '2019-11-12 08:36:12', 'junAdmin', '2019-11-12 08:36:12', null);
INSERT INTO `sys_bean_data` VALUES ('1194169101678280704', 'cash_buy_payType', '1', '现金', '1', '0', 'junAdmin', '2019-11-12 16:24:35', 'junAdmin', '2019-11-12 16:24:35', null);
INSERT INTO `sys_bean_data` VALUES ('1194169101690863616', 'cash_buy_payType', '2', '微信', '2', '0', 'junAdmin', '2019-11-12 16:24:35', 'junAdmin', '2019-11-12 16:24:35', null);
INSERT INTO `sys_bean_data` VALUES ('1194169101703446528', 'cash_buy_payType', '3', '支付宝', '3', '0', 'junAdmin', '2019-11-12 16:24:35', 'junAdmin', '2019-11-12 16:24:35', null);
INSERT INTO `sys_bean_data` VALUES ('1194169101716029440', 'cash_buy_payType', '4', '刷卡', '4', '0', 'junAdmin', '2019-11-12 16:24:35', 'junAdmin', '2019-11-12 16:24:35', null);
INSERT INTO `sys_bean_data` VALUES ('1194169101724418048', 'cash_buy_payType', '11', '储值扣费', '11', '0', 'junAdmin', '2019-11-12 16:24:35', 'junAdmin', '2019-11-12 16:24:35', null);
INSERT INTO `sys_bean_data` VALUES ('1194169524095025152', 'activity_py_state', '1', '待支付', '1', '0', 'junAdmin', '2019-11-12 16:26:16', 'junAdmin', '2019-11-12 16:26:16', null);
INSERT INTO `sys_bean_data` VALUES ('1194169524111802368', 'activity_py_state', '2', '已支付', '2', '0', 'junAdmin', '2019-11-12 16:26:16', 'junAdmin', '2019-11-12 16:26:16', null);

-- ----------------------------
-- Table structure for sys_bean_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_bean_type`;
CREATE TABLE `sys_bean_type` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `bean_name` varchar(20) DEFAULT NULL COMMENT '名称',
  `bean_key` varchar(20) DEFAULT NULL COMMENT '类型',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、8停用、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `beantype_tKey` (`bean_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典类型';

-- ----------------------------
-- Records of sys_bean_type
-- ----------------------------
INSERT INTO `sys_bean_type` VALUES ('1160726857232519168', '会员卡类型', 'com_cards_type', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857282850816', '是否周末卡', 'com_cards_is_week', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857295433728', '会员来源', 'member_source', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857308016640', '预约验证', 'course_isCheck', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857320599552', '支付方式', 'activity_payStatus', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857333182464', '活动状态', 'activity_status', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857349959680', '商品状态', 'com_goods_is_show', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857362542592', '课程预约状态', 'course_enroll_status', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857375125504', '消费类型', 'cash_buy_type', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857391902720', '支付方式', 'cash_buy_payType', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-11-12 16:24:35', '');
INSERT INTO `sys_bean_type` VALUES ('1160726857421262848', '活动预约状态', 'activity_en_status', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857433845760', '活动签到状态', 'activity_en_is_sign', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857446428672', '消费类型', 'card_change_type', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857463205888', '用户状态', 'sys_user_status', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857479983104', '是否', 'is_yes', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857505148928', '用户类型', 'sys_user_type', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1160726857530314752', '企业设置', 'company_config', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', '');
INSERT INTO `sys_bean_type` VALUES ('1183633396149596160', '官网设置类型', 'mobile_setting_type', '0', 'junAdmin', '2019-10-14 14:39:27', 'junAdmin', '2019-10-17 13:12:38', null);
INSERT INTO `sys_bean_type` VALUES ('1186522125711626240', '请假状态', 'leave_type', '0', 'junAdmin', '2019-10-22 13:58:14', 'junAdmin', '2019-10-22 13:58:14', null);
INSERT INTO `sys_bean_type` VALUES ('1186522345635762176', '请假是否取消', 'leave_isCancel', '0', 'junAdmin', '2019-10-22 13:59:06', 'junAdmin', '2019-10-22 13:59:06', null);
INSERT INTO `sys_bean_type` VALUES ('1186522578822287360', '请假审批状态', 'leave_checkState', '0', 'junAdmin', '2019-10-22 14:00:02', 'junAdmin', '2019-10-22 14:00:02', null);
INSERT INTO `sys_bean_type` VALUES ('1186783685702225920', '栏目类型', 'arttype_type', '0', 'junAdmin', '2019-10-23 07:17:35', 'junAdmin', '2019-11-01 16:16:26', '');
INSERT INTO `sys_bean_type` VALUES ('1186919061787287552', '积分关联类型', 'points_bizType', '0', 'junAdmin', '2019-10-23 16:15:31', 'junAdmin', '2019-10-23 16:15:31', null);
INSERT INTO `sys_bean_type` VALUES ('1186919249478197248', '积分类型', 'points_type', '0', 'junAdmin', '2019-10-23 16:16:16', 'junAdmin', '2019-10-23 16:16:16', null);
INSERT INTO `sys_bean_type` VALUES ('1186919249478197249', '模板消息', 'com_tpls', '0', 'junAdmin', '2019-10-23 16:16:16', 'junAdmin', '2019-10-23 16:16:16', null);
INSERT INTO `sys_bean_type` VALUES ('1193812217810157568', '消息管理_消息类型', 'sysComMsg_type', '0', 'junAdmin', '2019-11-11 16:46:27', 'junAdmin', '2019-11-11 16:46:27', null);
INSERT INTO `sys_bean_type` VALUES ('1193812425071689728', '消息管理_接受者类型', 'receive_type', '0', 'junAdmin', '2019-11-11 16:47:17', 'junAdmin', '2019-11-11 16:47:17', null);
INSERT INTO `sys_bean_type` VALUES ('1194051227347021824', '阅读状态', 'msg_read_state', '0', 'junAdmin', '2019-11-12 08:36:12', 'junAdmin', '2019-11-12 08:36:12', null);
INSERT INTO `sys_bean_type` VALUES ('1194169524074053632', '活动支付状态', 'activity_py_state', '0', 'junAdmin', '2019-11-12 16:26:16', 'junAdmin', '2019-11-12 16:26:16', null);

-- ----------------------------
-- Table structure for sys_company
-- ----------------------------
DROP TABLE IF EXISTS `sys_company`;
CREATE TABLE `sys_company` (
  `com_id` varchar(32) NOT NULL COMMENT '企业编码',
  `com_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `contacts` varchar(10) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `wx` varchar(50) DEFAULT NULL COMMENT '微信',
  `x` double(15,6) DEFAULT NULL COMMENT '经度',
  `y` double(15,6) DEFAULT NULL COMMENT '纬度',
  `area_id` varchar(6) DEFAULT NULL COMMENT '行政区',
  `address` varchar(150) DEFAULT NULL COMMENT '详细地址',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT NULL COMMENT '用户状态（0正常、8停用、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业';

-- ----------------------------
-- Records of sys_company
-- ----------------------------
INSERT INTO `sys_company` VALUES ('0', '11', '11', '111', null, null, null, null, null, null, null, null, null, 'junAdmin', '2019-11-12 13:13:05', 'junAdmin', '2019-11-12 13:13:05');
INSERT INTO `sys_company` VALUES ('baidu', '11', '11', '11', '11', '11', '11', null, null, null, null, null, null, 'junAdmin', '2019-11-04 13:21:42', 'junAdmin', '2019-11-04 13:21:42');
INSERT INTO `sys_company` VALUES ('cheng', '88', '88', '88', '88', '88', '88', null, null, '110000', '88', '88', '', null, null, 'junAdmin', '2019-10-15 14:33:53');
INSERT INTO `sys_company` VALUES ('cxmail8', '88', '88', '88', '88', '88', '88', null, null, '110000', '88', '88', null, null, null, 'junAdmin', '2019-10-15 14:33:53');
INSERT INTO `sys_company` VALUES ('localhost', '测试企业', 'test', 'teset', '1', '1', '1', '1.000000', '1.000000', '1', '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for sys_com_msg
-- ----------------------------
DROP TABLE IF EXISTS `sys_com_msg`;
CREATE TABLE `sys_com_msg` (
  `id` varchar(32) NOT NULL COMMENT '消息id',
  `type` char(1) DEFAULT NULL COMMENT '消息类型（1产品消息、2服务消息、3活动消息）',
  `title` varchar(60) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `receive_type` char(1) NOT NULL COMMENT '接受者类型（0全部 1用户）',
  `receive_ids` text COMMENT '接受者字符串',
  `receive_names` text COMMENT '接受者名称字符串',
  `send_id` varchar(64) DEFAULT NULL COMMENT '发送者',
  `send_name` varchar(100) DEFAULT NULL COMMENT '发送者',
  `send_date` datetime DEFAULT NULL COMMENT '发送时间',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息';

-- ----------------------------
-- Records of sys_com_msg
-- ----------------------------
INSERT INTO `sys_com_msg` VALUES ('1194124371796242432', '1', '11', '<div>11</div>', '0', null, null, 'junAdmin', '超级管理员', '2019-11-12 13:26:51', 'junAdmin', '2019-11-12 13:26:51', 'junAdmin', '2019-11-12 13:26:51');
INSERT INTO `sys_com_msg` VALUES ('1194585700780392448', '1', '产品过期通知', '产品:小米  将在:2019-11-06  过期请及时续费!', '1', 'x111', 'x111', '0', '定时通知', '2019-11-13 20:00:00', '0', '2019-11-13 20:00:00', '0', '2019-11-13 20:00:00');
INSERT INTO `sys_com_msg` VALUES ('1195221985153462272', '1', '11', '<div>111</div>', '0', null, null, '1195159802214412288', '1', '2019-11-15 14:08:22', '1195159802214412288', '2019-11-15 14:08:22', '1195159802214412288', '2019-11-15 14:08:22');

-- ----------------------------
-- Table structure for sys_com_msg_record
-- ----------------------------
DROP TABLE IF EXISTS `sys_com_msg_record`;
CREATE TABLE `sys_com_msg_record` (
  `id` varchar(32) NOT NULL COMMENT '消息id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `com_name` varchar(32) DEFAULT NULL COMMENT '企业名称',
  `msg_id` varchar(32) DEFAULT NULL COMMENT '标题',
  `read_state` char(1) DEFAULT '2' COMMENT '阅读状态（1待发送、2未读、3已读）',
  `read_time` datetime DEFAULT NULL COMMENT '阅读时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息发送记录';

-- ----------------------------
-- Records of sys_com_msg_record
-- ----------------------------
INSERT INTO `sys_com_msg_record` VALUES ('1194124371833991168', '0', '11', '1194124371796242432', '3', '2019-11-14 16:30:29');
INSERT INTO `sys_com_msg_record` VALUES ('1194124371846574080', 'x111', 'x111', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371859156992', 'baidu', '11', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371875934208', 'cheng', '88', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371888517120', 'cxmail8', '88', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371905294336', 'localhost:8080', '爱佳摄影工作室', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371917877248', 'localhost:8081', '许宁', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371930460160', 'localhost:8082', '贝之语', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371947237376', 'localhost:8088', '123', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371959820288', 'localhost:8080/', 'test', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194124371972403200', '192.168.0.104:8088', '123', '1194124371796242432', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1194585700826529792', 'x111', 'x111', '1194585700780392448', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1195221985249931264', '0', '11', '1195221985153462272', '3', '2019-11-15 15:19:06');
INSERT INTO `sys_com_msg_record` VALUES ('1195221985258319872', 'baidu', '11', '1195221985153462272', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1195221985270902784', 'cheng', '88', '1195221985153462272', '3', '2019-11-15 14:08:28');
INSERT INTO `sys_com_msg_record` VALUES ('1195221985279291392', 'cxmail8', '88', '1195221985153462272', '2', null);
INSERT INTO `sys_com_msg_record` VALUES ('1195221985291874304', 'localhost', '测试企业', '1195221985153462272', '2', null);

-- ----------------------------
-- Table structure for sys_com_orders
-- ----------------------------
DROP TABLE IF EXISTS `sys_com_orders`;
CREATE TABLE `sys_com_orders` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `code` varchar(32) DEFAULT NULL COMMENT '订单编号',
  `money` varchar(255) DEFAULT NULL COMMENT '应付金额',
  `type` char(1) DEFAULT NULL COMMENT '消费类型(1消费收银、2储值扣费、3会员储值)',
  `pay_type` char(2) DEFAULT NULL COMMENT '支付方式（1现金、2微信、3支付宝、4刷卡）',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常、1即将到期、2已到期）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业订单';

-- ----------------------------
-- Records of sys_com_orders
-- ----------------------------
INSERT INTO `sys_com_orders` VALUES ('1184286894928662528', 'SA4CwYXN', '420920191016000101', '11998', null, '1', '1.00', null, '0', 'junAdmin', '2019-10-16 09:56:13', 'junAdmin', '2019-10-16 09:56:13');
INSERT INTO `sys_com_orders` VALUES ('1184287072255447040', 'SA4CwYXN', '420920191016000102', '5999', null, '1', '1.00', null, '9', 'junAdmin', '2019-10-16 09:56:56', 'junAdmin', '2019-10-16 09:56:56');
INSERT INTO `sys_com_orders` VALUES ('1184289109016395776', 'SA4CwYXN', '420920191016000103', '1', null, '1', '1.00', null, '0', 'junAdmin', '2019-10-16 10:05:01', 'junAdmin', '2019-10-16 10:05:01');
INSERT INTO `sys_com_orders` VALUES ('1185445314451447808', 'SA4CwYXN', '420920191019000104', '12', null, '1', '1.00', null, '0', 'junAdmin', '2019-10-19 14:39:22', 'junAdmin', '2019-10-19 14:39:22');
INSERT INTO `sys_com_orders` VALUES ('1185446506380988416', '1185446272615649280', '000020191019000105', '11', null, '1', '10.00', null, '0', 'junAdmin', '2019-10-19 14:44:06', 'junAdmin', '2019-10-19 14:44:06');
INSERT INTO `sys_com_orders` VALUES ('1191548532128468992', 'x111', 'x11120191105000105', '10', null, '1', '11.00', null, '0', 'junAdmin', '2019-11-05 10:51:23', 'junAdmin', '2019-11-05 10:51:23');

-- ----------------------------
-- Table structure for sys_com_orders_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_com_orders_product`;
CREATE TABLE `sys_com_orders_product` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `orders_id` varchar(32) DEFAULT NULL COMMENT '订单',
  `product_id` varchar(32) DEFAULT NULL COMMENT '产品',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `money` varchar(255) DEFAULT NULL COMMENT '总价',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业订单明细';

-- ----------------------------
-- Records of sys_com_orders_product
-- ----------------------------
INSERT INTO `sys_com_orders_product` VALUES ('1184286895025131520', '0', '1184286894928662528', '1177499238326124544', '5999.00', '1', '5999', null, '0', 'junAdmin', '2019-10-16 09:56:13', 'junAdmin', '2019-10-16 09:56:13');
INSERT INTO `sys_com_orders_product` VALUES ('1184286895083851776', '0', '1184286894928662528', '1177499238326124544', '5999.00', '1', '5999', null, '0', 'junAdmin', '2019-10-16 09:56:13', 'junAdmin', '2019-10-16 09:56:13');
INSERT INTO `sys_com_orders_product` VALUES ('1184287072314167296', '0', '1184287072255447040', '1177499238326124544', '5999.00', '1', '5999', null, '0', 'junAdmin', '2019-10-16 09:56:56', 'junAdmin', '2019-10-16 09:56:56');
INSERT INTO `sys_com_orders_product` VALUES ('1184289109062533120', '0', '1184289109016395776', '1183232183269470208', '1.00', '1', '1', null, '0', 'junAdmin', '2019-10-16 10:05:01', 'junAdmin', '2019-10-16 10:05:01');
INSERT INTO `sys_com_orders_product` VALUES ('1185445314543722496', '0', '1185445314451447808', '1184769149461422080', '12.00', '1', '12', null, '0', 'junAdmin', '2019-10-19 14:39:22', 'junAdmin', '2019-10-19 14:39:22');
INSERT INTO `sys_com_orders_product` VALUES ('1185446506481651712', '0', '1185446506380988416', '1183232183269470208', '1.00', '11', '11', null, '0', 'junAdmin', '2019-10-19 14:44:06', 'junAdmin', '2019-10-19 14:44:06');
INSERT INTO `sys_com_orders_product` VALUES ('1191548532191383552', '0', '1191548532128468992', '1185446689793708032', '10.00', '1', '10', null, '0', 'junAdmin', '2019-11-05 10:51:23', 'junAdmin', '2019-11-05 10:51:23');

-- ----------------------------
-- Table structure for sys_com_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_com_product`;
CREATE TABLE `sys_com_product` (
  `id` varchar(32) NOT NULL COMMENT '主键ID',
  `com_id` varchar(32) DEFAULT NULL COMMENT '企业',
  `product_id` varchar(32) DEFAULT NULL COMMENT '产品',
  `start_time` date DEFAULT NULL COMMENT '开始时间',
  `end_time` date DEFAULT NULL COMMENT '结束时间',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常、1即将到期、2已到期）',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品状态';

-- ----------------------------
-- Records of sys_com_product
-- ----------------------------
INSERT INTO `sys_com_product` VALUES ('1184286894983188480', '0', '1177499238326124544', '2019-10-16', '2019-11-03', '0', null, 'junAdmin', '2019-10-16 09:56:13', 'junAdmin', '2019-10-16 09:56:56');
INSERT INTO `sys_com_product` VALUES ('1184289109049950208', '0', '1183232183269470208', '2019-10-16', '2019-10-17', '0', null, 'junAdmin', '2019-10-16 10:05:01', 'junAdmin', '2019-10-16 10:05:01');
INSERT INTO `sys_com_product` VALUES ('1185445314514362368', '0', '1184769149461422080', '2019-10-19', '2028-05-07', '0', null, 'junAdmin', '2019-10-19 14:39:22', 'junAdmin', '2019-10-19 14:39:22');
INSERT INTO `sys_com_product` VALUES ('1185446506443902976', '0', '1183232183269470208', '2019-10-19', '2019-10-30', '0', null, 'junAdmin', '2019-10-19 14:44:06', 'junAdmin', '2019-10-19 14:44:06');
INSERT INTO `sys_com_product` VALUES ('1191548532157829120', '0', '1185446689793708032', '2019-11-05', '2019-11-06', '0', null, 'junAdmin', '2019-11-05 10:51:23', 'junAdmin', '2019-11-05 10:51:23');

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` varchar(32) NOT NULL COMMENT '主键自增',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `c_name` varchar(64) DEFAULT NULL COMMENT '参数名称',
  `c_key` varchar(64) DEFAULT NULL COMMENT '参数key',
  `c_value` longtext COMMENT '参数值',
  `c_type` varchar(10) DEFAULT NULL COMMENT '参数类型（text/img/json/jsonObj/post/get）',
  `c_load` char(1) DEFAULT '0' COMMENT '自动加载（0否、1是）',
  `is_sys` char(1) DEFAULT NULL COMMENT '系统配置（0否、1是）',
  `remark` text COMMENT '参数说明',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置';

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1', 'localhost:8080', '文件版本', 'sys_V', '5', 'text', '1', '1', '系统文件版本号，防止浏览器缓存', null, null, null, null);

-- ----------------------------
-- Table structure for sys_file_entity
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_entity`;
CREATE TABLE `sys_file_entity` (
  `file_id` varchar(64) NOT NULL COMMENT '文件编号',
  `file_md5` varchar(64) NOT NULL COMMENT '文件MD5',
  `file_path` varchar(1000) NOT NULL COMMENT '文件相对路径',
  `file_type` varchar(200) NOT NULL COMMENT '文件内容类型',
  `file_extension` varchar(100) NOT NULL COMMENT '文件后缀扩展名',
  `file_size` decimal(31,0) NOT NULL COMMENT '文件大小(单位B)',
  `file_meta` varchar(255) DEFAULT NULL COMMENT '文件信息(JSON格式)',
  PRIMARY KEY (`file_id`),
  KEY `idx_sys_file_entity_md5` (`file_md5`),
  KEY `idx_sys_file_entity_size` (`file_size`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件实体表';

-- ----------------------------
-- Records of sys_file_entity
-- ----------------------------
INSERT INTO `sys_file_entity` VALUES ('1174498201148030976', 'abb8c2201a5e037d033c6fec8066c5aa', '201909/', 'image/jpeg', 'jpg', '129936', '{\"width\":229,\"height\":1599}');
INSERT INTO `sys_file_entity` VALUES ('1175927308728188928', '910d56b8646d78875d491965f834d7cb', '201909/', 'image/jpeg', 'jpg', '38387', '{\"width\":533,\"height\":299}');
INSERT INTO `sys_file_entity` VALUES ('1175928933834842112', 'f60703796a0b091759296b7b323936a1', '201909/', 'image/jpeg', 'jpg', '42856', '{\"width\":478,\"height\":407}');
INSERT INTO `sys_file_entity` VALUES ('1177049928951730176', '4524c4b845b0c039f77a995dda1fb0e3', '201909/', 'image/jpeg', 'jpg', '49308', '{\"width\":508,\"height\":300}');
INSERT INTO `sys_file_entity` VALUES ('1177050210629267456', 'ca4dbb346fc887555964b8e2696f7a1e', '201909/', 'image/jpeg', 'jpg', '31509', '{\"width\":500,\"height\":351}');
INSERT INTO `sys_file_entity` VALUES ('1177399864154361856', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201909/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1177402023379734528', 'a7642faec0eb4520ce65481913d52231', '201909/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1177402446866026496', '9b5735c60af1ec3c6f54400daa2e93df', '201909/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1177464645391826944', '7d60c16657a95a730c63e469aaf52983', '201909/', 'image/png', 'png', '11141', '{\"width\":578,\"height\":78}');
INSERT INTO `sys_file_entity` VALUES ('1177464645391826945', '0472abc3428f78d9afa6002438f480d9', '201909/', 'image/png', 'png', '165679', '{\"width\":715,\"height\":362}');
INSERT INTO `sys_file_entity` VALUES ('1177464645391826946', '3ea4aeb899ae8921be14dd066277b2de', '201909/', 'image/png', 'png', '96530', '{\"width\":750,\"height\":461}');
INSERT INTO `sys_file_entity` VALUES ('1177469357566541824', '00d2f7f9db0aa728497fa459571f83e4', '201909/', 'image/png', 'png', '2436', '{\"width\":64,\"height\":64}');
INSERT INTO `sys_file_entity` VALUES ('1177469357642039296', '229fe701f3c13705fcc4ad7912ec17c7', '201909/', 'image/png', 'png', '31366', '{\"width\":750,\"height\":340}');
INSERT INTO `sys_file_entity` VALUES ('1177469357688176640', '9e4f7c15cb61ddae1edf8655ae0319a7', '201909/', 'image/png', 'png', '2488', '{\"width\":64,\"height\":64}');
INSERT INTO `sys_file_entity` VALUES ('1177469380136091648', 'e6ee3128ec029f322dd47f09018e5670', '201909/', 'image/png', 'png', '25477', '{\"width\":750,\"height\":313}');
INSERT INTO `sys_file_entity` VALUES ('1177470489730826240', '0a6a03c162cd494593c99669c9ed6d9a', '201909/', 'image/png', 'png', '105803', '{\"width\":750,\"height\":461}');
INSERT INTO `sys_file_entity` VALUES ('1177489809792933888', 'c9f4be5c461bc480ee0896eb7eefa5f1', '201909/', 'image/png', 'png', '10602', '{\"width\":578,\"height\":78}');
INSERT INTO `sys_file_entity` VALUES ('1178203698971627520', 'c600e33753345bfc92c98e39a98687d5', '201909/', 'image/jpeg', 'jpg', '249342', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1181742037417648128', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1183230237298470912', '67a24a69d47ade9f2931b9ac414377ef', '201910/', 'image/jpeg', 'jpg', '31111', '{\"width\":450,\"height\":300}');
INSERT INTO `sys_file_entity` VALUES ('1183230272119582720', 'f34740185fa05401665b5d3879d81e92', '201910/', 'image/jpeg', 'jpg', '16633', '{\"width\":446,\"height\":300}');
INSERT INTO `sys_file_entity` VALUES ('1183230284631191552', '60ceac8ea1caedb44f1c21170fc15cb4', '201910/', 'image/jpeg', 'jpg', '31277', '{\"width\":452,\"height\":300}');
INSERT INTO `sys_file_entity` VALUES ('1183557709542518784', 'e6f44b5974c0b3b577ad61812c68bea1', '201910/', 'image/png', 'png', '7476', '{\"width\":200,\"height\":200}');
INSERT INTO `sys_file_entity` VALUES ('1184655380678389760', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1184660596848668672', 'b631199f91747b0d26eaebf254b83d36', '201910/', 'image/png', 'png', '9490', '{\"width\":200,\"height\":200}');
INSERT INTO `sys_file_entity` VALUES ('1184710287326007296', 'fda558a9420682db598b2fe75516cbe9', '201910/', 'image/png', 'png', '285072', '{\"width\":483,\"height\":322}');
INSERT INTO `sys_file_entity` VALUES ('1184741812045557760', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1184741813387735040', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1184742555194851328', '53e14ac31608e5c404ab76e57374649a', '201910/', 'image/png', 'png', '5053', '{\"width\":200,\"height\":200}');
INSERT INTO `sys_file_entity` VALUES ('1185358210079182848', '9fd3c5cb976bf5b2397e30b255137c5f', '201910/', 'image/jpeg', 'jpg', '213002', '{\"width\":1600,\"height\":738}');
INSERT INTO `sys_file_entity` VALUES ('1185358301863137280', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185359059278942208', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185364021144653824', 'c600e33753345bfc92c98e39a98687d5', '201910/', 'image/jpeg', 'jpg', '249342', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185364077457379328', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185366023850229760', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201910/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185366519007514624', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185366579577458688', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185367320954630144', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185367629424332800', 'a7642faec0eb4520ce65481913d52231', '201910/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185369467976630272', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185375815470592000', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185389793016598528', 'cb5663cbc235e24929f90fe69cf2e6a8', '201910/', 'image/png', 'png', '75934', '{\"width\":237,\"height\":162}');
INSERT INTO `sys_file_entity` VALUES ('1185393867125628928', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201910/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185394235540709376', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185399422867152896', 'ec19892ab3b33e4fb00a6daa1772f038', '201910/', 'image/png', 'png', '48343', '{\"width\":338,\"height\":330}');
INSERT INTO `sys_file_entity` VALUES ('1185423716439498752', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185425786026532864', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185440400838594560', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185440663502688256', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185441328492134400', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185463240711639040', '1e005bb6ba5b845a053874489700d979', '201910/', 'image/png', 'png', '767842', '{\"width\":702,\"height\":936}');
INSERT INTO `sys_file_entity` VALUES ('1185463249200910336', '18212662740a7bd62276a220a69020cd', '201910/', 'image/png', 'png', '329888', '{\"width\":579,\"height\":344}');
INSERT INTO `sys_file_entity` VALUES ('1185463260101906432', '9fea0e2525310faef9b4252d7061acff', '201910/', 'image/png', 'png', '179583', '{\"width\":480,\"height\":320}');
INSERT INTO `sys_file_entity` VALUES ('1185463329865764864', 'f6df29cee7adc06c8480cd24b8bc48bd', '201910/', 'image/png', 'png', '277174', '{\"width\":502,\"height\":377}');
INSERT INTO `sys_file_entity` VALUES ('1185469380571656192', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185472200309960704', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185473447629279232', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185474367956533248', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1185476069048889344', '38b86dc509af0d00b4d1d9b78465c86f', '201910/', 'image/jpeg', 'jpg', '102136', '{\"width\":780,\"height\":521}');
INSERT INTO `sys_file_entity` VALUES ('1185476217690828800', '23e762a6833b1bb38bee9c7768b3db3e', '201910/', 'image/png', 'png', '725394', '{\"width\":721,\"height\":479}');
INSERT INTO `sys_file_entity` VALUES ('1185476258174251008', '18530a708221055436abbcf33eddd293', '201910/', 'image/png', 'png', '559897', '{\"width\":723,\"height\":410}');
INSERT INTO `sys_file_entity` VALUES ('1185476330484051968', '225fd7792c9469028195572bad6a0ac3', '201910/', 'image/png', 'png', '345509', '{\"width\":737,\"height\":407}');
INSERT INTO `sys_file_entity` VALUES ('1185476355318525952', 'dd40137d5317231ecc32ddc2904748e1', '201910/', 'image/png', 'png', '514194', '{\"width\":732,\"height\":424}');
INSERT INTO `sys_file_entity` VALUES ('1185714201875484672', '35d7d5bff9e8427024d20a015666e18a', '201910/', 'image/png', 'png', '303397', '{\"width\":481,\"height\":320}');
INSERT INTO `sys_file_entity` VALUES ('1185714247115247616', '81b10de691fbaaf26a828f5f586eb7f4', '201910/', 'image/png', 'png', '795953', '{\"width\":771,\"height\":580}');
INSERT INTO `sys_file_entity` VALUES ('1185726526066036736', 'be24d33f03c1cebbb21501c1434a26f5', '201910/', 'image/png', 'png', '228507', '{\"width\":414,\"height\":311}');
INSERT INTO `sys_file_entity` VALUES ('1185727320152641536', 'cf5971f4f39930abda69a2b6c5726f78', '201910/', 'image/png', 'png', '339935', '{\"width\":460,\"height\":345}');
INSERT INTO `sys_file_entity` VALUES ('1185727329975701504', 'a9476f8876e997b4eb19d9d465e4abfd', '201910/', 'image/png', 'png', '316214', '{\"width\":459,\"height\":345}');
INSERT INTO `sys_file_entity` VALUES ('1185727351379234816', 'ed2daa5073556c472bd283e649d0e554', '201910/', 'image/png', 'png', '446249', '{\"width\":699,\"height\":493}');
INSERT INTO `sys_file_entity` VALUES ('1185730503398690816', '821a5c0f1ec4e585c8d3fdf09d7c7dc9', '201910/', 'image/png', 'png', '415676', '{\"width\":617,\"height\":349}');
INSERT INTO `sys_file_entity` VALUES ('1186074891203670016', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186077892887592960', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186078102405185536', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186090104901775360', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186090104994050048', 'a7642faec0eb4520ce65481913d52231', '201910/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186090105103101952', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186090209713238016', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186094772464316416', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201910/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186094836825911296', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186095521965469696', 'a7642faec0eb4520ce65481913d52231', '201910/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186095522263265280', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186095522569449472', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186095523089543168', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186105332387418112', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107228493926400', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107228644921344', 'a7642faec0eb4520ce65481913d52231', '201910/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107228745584640', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107230721101824', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107231002120192', 'c600e33753345bfc92c98e39a98687d5', '201910/', 'image/jpeg', 'jpg', '249342', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107231320887296', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107231643848704', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201910/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186107231866146816', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186114307761770496', '4f4b5c31bbb0946b92bb1f8157772dc7', '201910/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186114332273283072', 'ec7ab1ca6ec9d6d8956fda399d4e4eec', '201910/', 'image/jpeg', 'jpg', '200243', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186114358189887488', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186114440771538944', '9b5735c60af1ec3c6f54400daa2e93df', '201910/', 'image/jpeg', 'jpg', '131509', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186143502937522176', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186144836116033536', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186144836116033537', '8e97db6be025c11965812abf30ed5491', '201910/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186144836116033538', 'a7642faec0eb4520ce65481913d52231', '201910/', 'image/jpeg', 'jpg', '230385', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186148784568455168', 'c600e33753345bfc92c98e39a98687d5', '201910/', 'image/jpeg', 'jpg', '249342', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186148784568455169', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186478295661854720', '9e2205607d80f0d3bcfcd6ee785f2451', '201910/', 'image/png', 'png', '535392', '{\"width\":726,\"height\":485}');
INSERT INTO `sys_file_entity` VALUES ('1186478352897327104', '924862cc1f69f43223ced840505ffb3b', '201910/', 'image/png', 'png', '713056', '{\"width\":750,\"height\":494}');
INSERT INTO `sys_file_entity` VALUES ('1186485806028599296', '8d09b12976d0d09c2bc6b2184a1da303', '201910/', 'image/png', 'png', '415043', '{\"width\":713,\"height\":403}');
INSERT INTO `sys_file_entity` VALUES ('1186485877780557824', '515f40766159860a299b67f5bed555cd', '201910/', 'image/png', 'png', '70981', '{\"width\":263,\"height\":165}');
INSERT INTO `sys_file_entity` VALUES ('1186485877956718592', 'e6eec484de69a15fb408cca7d64d70cf', '201910/', 'image/png', 'png', '55616', '{\"width\":226,\"height\":206}');
INSERT INTO `sys_file_entity` VALUES ('1186485878103519232', 'dd833133f3ff0acf934f7f63ba51a594', '201910/', 'image/png', 'png', '85667', '{\"width\":228,\"height\":206}');
INSERT INTO `sys_file_entity` VALUES ('1186485878392926208', 'e8042cacf9d729763249a31779f643f7', '201910/', 'image/png', 'png', '92488', '{\"width\":208,\"height\":208}');
INSERT INTO `sys_file_entity` VALUES ('1186485878644584448', '74f4cda35a362e54ef4c0be13941c200', '201910/', 'image/png', 'png', '277944', '{\"width\":436,\"height\":416}');
INSERT INTO `sys_file_entity` VALUES ('1186486432716337152', 'e6962c452c13b6c90177c2caf0874103', '201910/', 'image/png', 'png', '72279', '{\"width\":254,\"height\":172}');
INSERT INTO `sys_file_entity` VALUES ('1186486472239263744', '9e0b3abacaa183d5ff3aad5f5eafc35b', '201910/', 'image/png', 'png', '67100', '{\"width\":295,\"height\":183}');
INSERT INTO `sys_file_entity` VALUES ('1186486502371143680', 'fbd2b129f13797e465e1f9cabac72744', '201910/', 'image/png', 'png', '74058', '{\"width\":269,\"height\":172}');
INSERT INTO `sys_file_entity` VALUES ('1186486537116758016', 'dba1658e049e595a406f388f672b64c5', '201910/', 'image/png', 'png', '93552', '{\"width\":276,\"height\":189}');
INSERT INTO `sys_file_entity` VALUES ('1186523206071136256', '80f3a6f4912286cbbb38ab684b28fdd0', '201910/', 'image/png', 'png', '170165', '{\"width\":750,\"height\":400}');
INSERT INTO `sys_file_entity` VALUES ('1186523241181655040', 'be4d99281f025e4577989073212d173b', '201910/', 'image/png', 'png', '112167', '{\"width\":750,\"height\":418}');
INSERT INTO `sys_file_entity` VALUES ('1186603005396955136', '81b10de691fbaaf26a828f5f586eb7f4', '201910/', 'image/png', 'png', '795953', '{\"width\":771,\"height\":580}');
INSERT INTO `sys_file_entity` VALUES ('1186803299205332992', '6c0d5f5a4f7880525fad5bb2c482d4a5', '201910/', 'image/png', 'png', '416847', '{\"width\":714,\"height\":465}');
INSERT INTO `sys_file_entity` VALUES ('1186810491741245440', '805cfd81f5e0588755b9a6738503d0f0', '201910/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1186837673102409728', 'b13e44bcea9c02e4aaa7e6f97faf6539', '201910/', 'image/png', 'png', '59802', '{\"width\":224,\"height\":173}');
INSERT INTO `sys_file_entity` VALUES ('1187212765659983872', '0603e90855f7db1d1825a422cabd86ab', '201910/', 'image/png', 'png', '1615', '{\"width\":34,\"height\":34}');
INSERT INTO `sys_file_entity` VALUES ('1187235222984744960', 'f91df82ba346c0861e8192734c50eb64', '201910/', 'image/png', 'png', '6372', '{\"width\":81,\"height\":80}');
INSERT INTO `sys_file_entity` VALUES ('1187237713569411072', 'ccd2af0dfa29349ca0cf4aed2694ca90', '201910/', 'image/png', 'png', '9830', '{\"width\":407,\"height\":211}');
INSERT INTO `sys_file_entity` VALUES ('1187240797245100032', '01d83be9a9d74de2ad30ce3ad6874efc', '201910/', 'image/png', 'png', '2247', '{\"width\":62,\"height\":62}');
INSERT INTO `sys_file_entity` VALUES ('1187290342987247616', '83e065366e1acaba8bcbbe77bbee6838', '201910/', 'image/jpeg', 'jpg', '215618', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1187539035262029824', '935a540f25cbfa5889d38d9727cb1684', '201910/', 'text/html', 'file-1571966343943', '1413', '{}');
INSERT INTO `sys_file_entity` VALUES ('1187543637491453952', 'b55d6e638a945e6605453317ababe066', '201910/', 'image/png', 'png', '6108', '{\"width\":81,\"height\":81}');
INSERT INTO `sys_file_entity` VALUES ('1187544153990631424', 'c41541fa55028316df835ad7f0a1031f', '201910/', 'image/png', 'png', '5311', '{\"width\":81,\"height\":81}');
INSERT INTO `sys_file_entity` VALUES ('1187544427253731328', '2b20207eb452eeadffac55f067ab1690', '201910/', 'image/png', 'png', '5860', '{\"width\":80,\"height\":80}');
INSERT INTO `sys_file_entity` VALUES ('1187649879238307842', '18904712e91cac517337596c0ec1bd8f', '201910/', 'image/png', 'png', '6494', '{\"width\":85,\"height\":85}');
INSERT INTO `sys_file_entity` VALUES ('1188990202329202688', 'fda558a9420682db598b2fe75516cbe9', '201910/', 'image/png', 'png', '285072', '{\"width\":483,\"height\":322}');
INSERT INTO `sys_file_entity` VALUES ('1189379660797870080', '79796f490d39dbed7149e23dafd222e3', '201910/', 'image/png', 'png', '3811', '{\"width\":128,\"height\":128}');
INSERT INTO `sys_file_entity` VALUES ('1189379933775757312', 'f9ebfabc9645e9a5b78a03f3b21abfbb', '201910/', 'image/png', 'png', '9552', '{\"width\":319,\"height\":191}');
INSERT INTO `sys_file_entity` VALUES ('1189379933947723776', '20ebb9441f7bf44cdeac87ecd8342dfa', '201910/', 'image/png', 'png', '6878', '{\"width\":319,\"height\":186}');
INSERT INTO `sys_file_entity` VALUES ('1189379934019026944', 'cf9beaeb608b77184e30d1d809e86c66', '201910/', 'image/png', 'png', '6113', '{\"width\":319,\"height\":192}');
INSERT INTO `sys_file_entity` VALUES ('1189379934060969984', 'e6f684cc73b0ed18f1143cabb186984f', '201910/', 'image/png', 'png', '7793', '{\"width\":321,\"height\":195}');
INSERT INTO `sys_file_entity` VALUES ('1189498006339833856', 'e621798962adc1a4fe9413ad160d44ac', '201910/', 'image/jpeg', 'jpg', '303140', '{\"width\":1600,\"height\":773}');
INSERT INTO `sys_file_entity` VALUES ('1190192489215774720', 'db6fe2b6199374ae8f4c2e827c5d3384', '201911/', 'image/png', 'png', '3680', '{\"width\":128,\"height\":128}');
INSERT INTO `sys_file_entity` VALUES ('1190432653759909888', '63f741cd1b39a3c0ecfbdc4b8092716f', '201911/', 'image/png', 'png', '1415', '{\"width\":114,\"height\":114}');
INSERT INTO `sys_file_entity` VALUES ('1191177071274102784', '805cfd81f5e0588755b9a6738503d0f0', '201911/', 'image/jpeg', 'jpg', '168948', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1191177320671612928', '1160b022cf53cdea021abf6d342c729b', '201911/', 'image/jpeg', 'jpg', '80682', '{\"width\":580,\"height\":826}');
INSERT INTO `sys_file_entity` VALUES ('1191177493183336448', '9cdb081f14c7c67624f4f59ff7b21825', '201911/', 'image/jpeg', 'jpg', '32129', '{\"width\":350,\"height\":350}');
INSERT INTO `sys_file_entity` VALUES ('1191598954592907264', '4f4b5c31bbb0946b92bb1f8157772dc7', '201911/', 'image/jpeg', 'jpg', '158693', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1191599166031966208', '8e97db6be025c11965812abf30ed5491', '201911/', 'image/jpeg', 'jpg', '161278', '{\"width\":1024,\"height\":768}');
INSERT INTO `sys_file_entity` VALUES ('1191911449658273792', 'b10448f5ac153adc0f5f3a30ed7fab62', '201911/', 'image/jpeg', 'jpg', '33878', '{\"width\":499,\"height\":327}');
INSERT INTO `sys_file_entity` VALUES ('1192965542676123648', '9fea0e2525310faef9b4252d7061acff', '201911/', 'image/png', 'png', '179583', '{\"width\":480,\"height\":320}');

-- ----------------------------
-- Table structure for sys_file_upload
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_upload`;
CREATE TABLE `sys_file_upload` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `file_id` varchar(64) NOT NULL COMMENT '文件编号',
  `file_name` varchar(500) NOT NULL COMMENT '文件名称',
  `file_type` varchar(20) NOT NULL COMMENT '文件分类（image、media、file）',
  `biz_id` varchar(64) DEFAULT NULL COMMENT '业务主键',
  `biz_type` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '状态（0正常、9删除）',
  `sort` varchar(255) DEFAULT NULL,
  `create_id` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_id` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `idx_sys_file_biz_ft` (`file_type`),
  KEY `idx_sys_file_biz_fi` (`file_id`),
  KEY `idx_sys_file_biz_status` (`status`),
  KEY `idx_sys_file_biz_cb` (`create_id`),
  KEY `idx_sys_file_biz_ud` (`update_time`),
  KEY `idx_sys_file_biz_bt` (`biz_type`),
  KEY `idx_sys_file_biz_bk` (`biz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件上传表';

-- ----------------------------
-- Records of sys_file_upload
-- ----------------------------
INSERT INTO `sys_file_upload` VALUES ('1174498201206751232', '1174498201148030976', '首页 - 副本 (2).jpg', 'image', null, null, '0', null, '1', '2019-09-19 09:39:27', '1', '2019-09-19 09:39:27', null);
INSERT INTO `sys_file_upload` VALUES ('1175927308916932608', '1185730503398690816', 's3.jpg', 'image', '1', 'growup_img', '0', null, '1', '2019-09-23 08:18:13', '1', '2019-09-23 08:18:13', null);
INSERT INTO `sys_file_upload` VALUES ('1175928933998419968', '1185463249200910336', '3.jpg', 'image', '2', 'growup_img', '0', null, '1', '2019-09-23 08:24:40', '1', '2019-09-23 08:24:40', null);
INSERT INTO `sys_file_upload` VALUES ('1177049929102725120', '1184710287326007296', 's2.jpg', 'image', '3', 'growup_img', '0', null, '1', '2019-09-26 10:39:06', '1', '2019-09-26 10:39:06', null);
INSERT INTO `sys_file_upload` VALUES ('1177050210675404800', '1185463249200910336', '4.jpg', 'image', '4', 'growup_img', '0', null, '1', '2019-09-26 10:40:13', '1', '2019-09-26 10:40:13', null);
INSERT INTO `sys_file_upload` VALUES ('1177399864708009984', '1177399864154361856', 'Penguins.jpg', 'image', '1', 'growup_img', '0', null, '1', '2019-09-27 09:49:37', '1', '2019-09-27 09:49:37', null);
INSERT INTO `sys_file_upload` VALUES ('1177400281416306689', '1177399864154361856', 'Penguins.jpg', 'image', '1177400341608763392', 'demoBase_image', '0', null, '1', '2019-09-27 09:51:17', '1', '2019-09-27 09:51:17', null);
INSERT INTO `sys_file_upload` VALUES ('1177401956300230657', '1177399864154361856', 'Penguins.jpg', 'image', '1169892281458737152', 'demoBase_image', '0', null, '1', '2019-09-27 09:57:56', '1', '2019-09-27 09:57:56', null);
INSERT INTO `sys_file_upload` VALUES ('1177402023463620608', '1177402023379734528', 'Desert.jpg', 'image', '1177400341608763392', 'demoBase_image', '0', null, '1', '2019-09-27 09:58:12', '1', '2019-09-27 09:58:12', null);
INSERT INTO `sys_file_upload` VALUES ('1177402446937329664', '1177402446866026496', 'Jellyfish.jpg', 'image', '1177400341608763392', 'demoBase_image', '0', null, '1', '2019-09-27 09:59:53', '1', '2019-09-27 09:59:53', null);
INSERT INTO `sys_file_upload` VALUES ('1177458473532366849', '1177402023379734528', 'Desert.jpg', 'image', '1177458401134485504', 'demoBase_image', '0', null, '1', '2019-09-27 13:42:31', '1', '2019-09-27 13:42:31', null);
INSERT INTO `sys_file_upload` VALUES ('1177464645840617472', '1177464645391826944', '登录.png', 'image', null, null, '0', null, '1', '2019-09-27 14:07:02', '1', '2019-09-27 14:07:02', null);
INSERT INTO `sys_file_upload` VALUES ('1177464645890949120', '1177464645391826946', 'login_top.png', 'image', null, null, '0', null, '1', '2019-09-27 14:07:02', '1', '2019-09-27 14:07:02', null);
INSERT INTO `sys_file_upload` VALUES ('1177464645907726336', '1177464645391826945', 'banner.png', 'image', null, null, '0', null, '1', '2019-09-27 14:07:02', '1', '2019-09-27 14:07:02', null);
INSERT INTO `sys_file_upload` VALUES ('1177469357591707648', '1177469357566541824', '未读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:46', '1', '2019-09-27 14:25:46', null);
INSERT INTO `sys_file_upload` VALUES ('1177469357700759552', '1177469357642039296', '我的_top_bg.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:46', '1', '2019-09-27 14:25:46', null);
INSERT INTO `sys_file_upload` VALUES ('1177469357713342464', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:46', '1', '2019-09-27 14:25:46', null);
INSERT INTO `sys_file_upload` VALUES ('1177469380173840386', '1177464645391826946', 'login_top.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:51', '1', '2019-09-27 14:25:51', null);
INSERT INTO `sys_file_upload` VALUES ('1177469380173840387', '1177464645391826944', '登录.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:51', '1', '2019-09-27 14:25:51', null);
INSERT INTO `sys_file_upload` VALUES ('1177469380178034688', '1177469380136091648', '积分top.png', 'image', null, null, '0', null, '1', '2019-09-27 14:25:51', '1', '2019-09-27 14:25:51', null);
INSERT INTO `sys_file_upload` VALUES ('1177469560059150336', '1177469357566541824', '未读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:26:34', '1', '2019-09-27 14:26:34', null);
INSERT INTO `sys_file_upload` VALUES ('1177469560134647809', '1177469357642039296', '我的_top_bg.png', 'image', null, null, '0', null, '1', '2019-09-27 14:26:34', '1', '2019-09-27 14:26:34', null);
INSERT INTO `sys_file_upload` VALUES ('1177469891363028993', '1177469357566541824', '未读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:27:53', '1', '2019-09-27 14:27:53', null);
INSERT INTO `sys_file_upload` VALUES ('1177469891459497985', '1177469357642039296', '我的_top_bg.png', 'image', null, null, '0', null, '1', '2019-09-27 14:27:53', '1', '2019-09-27 14:27:53', null);
INSERT INTO `sys_file_upload` VALUES ('1177469891497246721', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:27:53', '1', '2019-09-27 14:27:53', null);
INSERT INTO `sys_file_upload` VALUES ('1177470489814712320', '1177470489730826240', '注册.png', 'image', '1177470495145672704', 'demoBase_image', '0', null, '1', '2019-09-27 14:30:16', '1', '2019-09-27 14:30:16', null);
INSERT INTO `sys_file_upload` VALUES ('1177471936727957505', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 14:36:01', '1', '2019-09-27 14:36:01', null);
INSERT INTO `sys_file_upload` VALUES ('1177482237917609984', '1177469357642039296', '我的_top_bg.png', 'image', null, null, '0', null, '1', '2019-09-27 15:16:57', '1', '2019-09-27 15:16:57', null);
INSERT INTO `sys_file_upload` VALUES ('1177482237951164417', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 15:16:57', '1', '2019-09-27 15:16:57', null);
INSERT INTO `sys_file_upload` VALUES ('1177482238030856193', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 15:16:57', '1', '2019-09-27 15:16:57', null);
INSERT INTO `sys_file_upload` VALUES ('1177482887934066689', '1177469357642039296', '我的_top_bg.png', 'image', null, null, '0', null, '1', '2019-09-27 15:19:32', '1', '2019-09-27 15:19:32', null);
INSERT INTO `sys_file_upload` VALUES ('1177482887984398337', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 15:19:32', '1', '2019-09-27 15:19:32', null);
INSERT INTO `sys_file_upload` VALUES ('1177482888076673025', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 15:19:32', '1', '2019-09-27 15:19:32', null);
INSERT INTO `sys_file_upload` VALUES ('1177483490135457793', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 15:21:55', '1', '2019-09-27 15:21:55', null);
INSERT INTO `sys_file_upload` VALUES ('1177486737200107521', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 15:34:49', '1', '2019-09-27 15:34:49', null);
INSERT INTO `sys_file_upload` VALUES ('1177487054134489088', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-27 15:36:05', '1', '2019-09-27 15:36:05', null);
INSERT INTO `sys_file_upload` VALUES ('1177489810002649088', '1177489809792933888', '确定.png', 'image', null, null, '0', null, '1', '2019-09-27 15:47:02', '1', '2019-09-27 15:47:02', null);
INSERT INTO `sys_file_upload` VALUES ('1177490175670878208', '1177489809792933888', '确定.png', 'image', null, null, '0', null, '1', '2019-09-27 15:48:29', '1', '2019-09-27 15:48:29', null);
INSERT INTO `sys_file_upload` VALUES ('1177490304905773057', '1177489809792933888', '确定.png', 'image', null, null, '0', null, '1', '2019-09-27 15:49:00', '1', '2019-09-27 15:49:00', null);
INSERT INTO `sys_file_upload` VALUES ('1177490507444518913', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 15:49:48', '1', '2019-09-27 15:49:48', null);
INSERT INTO `sys_file_upload` VALUES ('1177495718837956609', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 16:10:31', '1', '2019-09-27 16:10:31', null);
INSERT INTO `sys_file_upload` VALUES ('1177496016999313409', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 16:11:42', '1', '2019-09-27 16:11:42', null);
INSERT INTO `sys_file_upload` VALUES ('1177497108749352961', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-27 16:16:02', '1', '2019-09-27 16:16:02', null);
INSERT INTO `sys_file_upload` VALUES ('1177499224866603008', '1177470489730826240', '注册.png', 'image', '1177499238326124544', 'demoBase_image', '0', null, '1', '2019-09-27 16:24:27', '1', '2019-09-27 16:24:27', null);
INSERT INTO `sys_file_upload` VALUES ('1177500835598233601', '1177489809792933888', '确定.png', 'image', '1177500845295464448', 'demoBase_image', '0', null, '1', '2019-09-27 16:30:51', '1', '2019-09-27 16:30:51', null);
INSERT INTO `sys_file_upload` VALUES ('1177505759968808961', '1177470489730826240', '注册.png', 'image', '1177490185233891328', 'demoBase_image', '0', null, '1', '2019-09-27 16:50:25', '1', '2019-09-27 16:50:25', null);
INSERT INTO `sys_file_upload` VALUES ('1177505815287484417', '1177489809792933888', '确定.png', 'image', '1177489819251089408', 'demoBase_image', '0', null, '1', '2019-09-27 16:50:38', '1', '2019-09-27 16:50:38', null);
INSERT INTO `sys_file_upload` VALUES ('1177505858539147265', '1177469380136091648', '积分top.png', 'image', '1177392214035136512', 'demoBase_image', '0', null, '1', '2019-09-27 16:50:48', '1', '2019-09-27 16:50:48', null);
INSERT INTO `sys_file_upload` VALUES ('1177506510845693953', '1177469380136091648', '积分top.png', 'image', '1177487068894244864', 'demoBase_image', '0', null, '1', '2019-09-27 16:53:24', '1', '2019-09-27 16:53:24', null);
INSERT INTO `sys_file_upload` VALUES ('1177506561491914753', '1177469357688176640', '已读.png', 'image', '1177391566166163456', 'demoBase_image', '0', null, '1', '2019-09-27 16:53:36', '1', '2019-09-27 16:53:36', null);
INSERT INTO `sys_file_upload` VALUES ('1177757234586169344', '1177402023379734528', 'Desert.jpg', 'image', '1177757292845051904', 'demoBase_image', '0', null, '1', '2019-09-28 09:29:41', '1', '2019-09-28 09:29:41', null);
INSERT INTO `sys_file_upload` VALUES ('1177780996486098945', '1177470489730826240', '注册.png', 'image', '1177781022205571072', 'demoBase_image', '0', null, '1', '2019-09-28 11:04:06', '1', '2019-09-28 11:04:06', null);
INSERT INTO `sys_file_upload` VALUES ('1177781745240666113', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-28 11:07:05', '1', '2019-09-28 11:07:05', null);
INSERT INTO `sys_file_upload` VALUES ('1177781958898511873', '1177470489730826240', '注册.png', 'image', '1177781961280876544', 'demoBase_image', '0', null, '1', '2019-09-28 11:07:56', '1', '2019-09-28 11:07:56', null);
INSERT INTO `sys_file_upload` VALUES ('1177782079040155649', '1177470489730826240', '注册.png', 'image', null, null, '0', null, '1', '2019-09-28 11:08:24', '1', '2019-09-28 11:08:24', null);
INSERT INTO `sys_file_upload` VALUES ('1177782343537160193', '1177470489730826240', '注册.png', 'image', '1177782351078518784', 'demoBase_image', '0', null, '1', '2019-09-28 11:09:27', '1', '2019-09-28 11:09:27', null);
INSERT INTO `sys_file_upload` VALUES ('1178199355611717633', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, '1', '2019-09-29 14:46:31', '1', '2019-09-29 14:46:31', null);
INSERT INTO `sys_file_upload` VALUES ('1178201783990398977', '1177469357688176640', '已读.png', 'image', null, null, '0', null, '1', '2019-09-29 14:56:10', '1', '2019-09-29 14:56:10', null);
INSERT INTO `sys_file_upload` VALUES ('1178201882019303425', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, '1', '2019-09-29 14:56:33', '1', '2019-09-29 14:56:33', null);
INSERT INTO `sys_file_upload` VALUES ('1178203699705630720', '1178203698971627520', 'Koala.jpg', 'image', '1178203771746996224', 'demoBase_image', '0', null, '1', '2019-09-29 15:03:47', '1', '2019-09-29 15:03:47', null);
INSERT INTO `sys_file_upload` VALUES ('1181742038764019712', '1181742037417648128', 'Lighthouse.jpg', 'image', '1181742107097620480', 'demoBase_image', '0', null, 'teng_W8UN', '2019-10-09 09:23:52', 'teng_W8UN', '2019-10-09 09:23:52', null);
INSERT INTO `sys_file_upload` VALUES ('1182550013369442305', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'baidu_GN5E', '2019-10-11 14:54:29', 'baidu_GN5E', '2019-10-11 14:54:29', null);
INSERT INTO `sys_file_upload` VALUES ('1182552065070944257', '1177402446866026496', 'Jellyfish.jpg', 'image', '1182552126093873152', 'demoBase_image', '0', null, 'junAdmin', '2019-10-11 15:02:38', 'junAdmin', '2019-10-11 15:02:38', null);
INSERT INTO `sys_file_upload` VALUES ('1182553086321053697', '1178203698971627520', 'Koala.jpg', 'image', '1182553144479272960', 'demoBase_image', '0', null, 'baidu_GN5E', '2019-10-11 15:06:41', 'baidu_GN5E', '2019-10-11 15:06:41', null);
INSERT INTO `sys_file_upload` VALUES ('1183230238229606400', '1183230237298470912', '0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-13 11:57:27', 'junAdmin', '2019-10-13 11:57:27', null);
INSERT INTO `sys_file_upload` VALUES ('1183230272354463744', '1183230272119582720', '838ba61ea8d3fd1fc9c7b6853a4e251f94ca5f46.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-13 11:57:35', 'junAdmin', '2019-10-13 11:57:35', null);
INSERT INTO `sys_file_upload` VALUES ('1183230284748632064', '1183230284631191552', '908fa0ec08fa513db777cf78376d55fbb3fbd9b3.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-13 11:57:38', 'junAdmin', '2019-10-13 11:57:38', null);
INSERT INTO `sys_file_upload` VALUES ('1183230422569267201', '1183230237298470912', '0e2442a7d933c8956c0e8eeadb1373f08202002a.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-13 11:58:11', 'junAdmin', '2019-10-13 11:58:11', null);
INSERT INTO `sys_file_upload` VALUES ('1183230434082631681', '1183230272119582720', '838ba61ea8d3fd1fc9c7b6853a4e251f94ca5f46.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-13 11:58:14', 'junAdmin', '2019-10-13 11:58:14', null);
INSERT INTO `sys_file_upload` VALUES ('1183231329590194177', '1183230272119582720', '838ba61ea8d3fd1fc9c7b6853a4e251f94ca5f46.jpg', 'image', '1183231342462513152', 'shopGoods_image', '0', null, 'junAdmin', '2019-10-13 12:01:47', 'junAdmin', '2019-10-13 12:01:47', null);
INSERT INTO `sys_file_upload` VALUES ('1183231337462902784', '1183230284631191552', '908fa0ec08fa513db777cf78376d55fbb3fbd9b3.jpg', 'image', '1183231342462513152', 'shopGoods_image', '0', null, 'junAdmin', '2019-10-13 12:01:49', 'junAdmin', '2019-10-13 12:01:49', null);
INSERT INTO `sys_file_upload` VALUES ('1183557709857091584', '1183557709542518784', 'goutong.png', 'image', '1183557882880520192', 'demoBase_image', '0', null, 'junAdmin', '2019-10-14 09:38:42', 'junAdmin', '2019-10-14 09:38:42', null);
INSERT INTO `sys_file_upload` VALUES ('1184655381248815104', '1184655380678389760', 'Hydrangeas.jpg', 'image', '1184655477818470400', 'demoBase_image', '9', null, 'junAdmin', '2019-10-17 10:20:27', 'junAdmin', '2019-10-17 10:20:27', null);
INSERT INTO `sys_file_upload` VALUES ('1184660252570030080', '1178203698971627520', 'Koala.jpg', 'image', '1184660256432984064', 'shopGoods_image', '0', null, 'wangxi_DOUW', '2019-10-17 10:39:49', 'wangxi_DOUW', '2019-10-17 10:39:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184660400299388929', '1183557709542518784', 'goutong.png', 'image', '1184660420260081664', 'shopGoods_image', '0', null, 'zhao_I95W', '2019-10-17 10:40:24', 'zhao_I95W', '2019-10-17 10:40:24', null);
INSERT INTO `sys_file_upload` VALUES ('1184660559846518785', '1183557709542518784', 'goutong.png', 'image', '1184660603379200000', 'shopGoods_image', '0', null, 'zhao_I95W', '2019-10-17 10:41:02', 'zhao_I95W', '2019-10-17 10:41:02', null);
INSERT INTO `sys_file_upload` VALUES ('1184660597398122496', '1184660596848668672', '电话01.png', 'image', '1184660603379200000', 'shopGoods_image', '9', null, 'zhao_I95W', '2019-10-17 10:41:11', 'zhao_I95W', '2019-10-17 10:41:11', null);
INSERT INTO `sys_file_upload` VALUES ('1184660708188884993', '1178203698971627520', 'Koala.jpg', 'image', '1184660711405916160', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 10:41:37', 'wangxi_DOUW', '2019-10-17 10:41:37', null);
INSERT INTO `sys_file_upload` VALUES ('1184660877858648065', '1183557709542518784', 'goutong.png', 'image', '1184660881872596992', 'demoBase_image', '0', null, 'zhao_I95W', '2019-10-17 10:42:18', 'zhao_I95W', '2019-10-17 10:42:18', null);
INSERT INTO `sys_file_upload` VALUES ('1184661070941396993', '1177470489730826240', '注册.png', 'image', null, null, '0', null, 'aliali_PRJT', '2019-10-17 10:43:04', 'aliali_PRJT', '2019-10-17 10:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1184661137798602753', '1177470489730826240', '注册.png', 'image', '1184661148452134912', 'shopGoods_image', '0', null, 'aliali_PRJT', '2019-10-17 10:43:20', 'aliali_PRJT', '2019-10-17 10:43:20', null);
INSERT INTO `sys_file_upload` VALUES ('1184661247383183361', '1177470489730826240', '注册.png', 'image', '1184661252546371584', 'demoBase_image', '0', null, 'aliali_PRJT', '2019-10-17 10:43:46', 'aliali_PRJT', '2019-10-17 10:43:46', null);
INSERT INTO `sys_file_upload` VALUES ('1184663112279793665', '1177470489730826240', '注册.png', 'image', null, null, '0', null, 'aliali_PRJT', '2019-10-17 10:51:11', 'aliali_PRJT', '2019-10-17 10:51:11', null);
INSERT INTO `sys_file_upload` VALUES ('1184663158496829441', '1177470489730826240', '注册.png', 'image', '1184663166075936768', 'shopGoods_image', '0', null, 'aliali_PRJT', '2019-10-17 10:51:22', 'aliali_PRJT', '2019-10-17 10:51:22', null);
INSERT INTO `sys_file_upload` VALUES ('1184665496368324609', '1177470489730826240', '注册.png', 'image', '1184665503209234432', 'shopGoods_image', '0', null, 'aliali_PRJT', '2019-10-17 11:00:39', 'aliali_PRJT', '2019-10-17 11:00:39', null);
INSERT INTO `sys_file_upload` VALUES ('1184667167087472641', '1183557709542518784', 'goutong.png', 'image', '1184668014345269248', 'demoBase_image', '0', null, 'zhao_I95W', '2019-10-17 11:07:17', 'zhao_I95W', '2019-10-17 11:07:17', null);
INSERT INTO `sys_file_upload` VALUES ('1184673736151982081', '1178203698971627520', 'Koala.jpg', 'image', '1184673813998264320', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:33:24', 'wangxi_DOUW', '2019-10-17 11:33:24', null);
INSERT INTO `sys_file_upload` VALUES ('1184673952305438721', '1181742037417648128', 'Lighthouse.jpg', 'image', '1184674012736970752', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:34:15', 'wangxi_DOUW', '2019-10-17 11:34:15', null);
INSERT INTO `sys_file_upload` VALUES ('1184674373287731201', '1178203698971627520', 'Koala.jpg', 'image', '1184674438312026112', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:35:55', 'wangxi_DOUW', '2019-10-17 11:35:55', null);
INSERT INTO `sys_file_upload` VALUES ('1184674775706034177', '1178203698971627520', 'Koala.jpg', 'image', '1184674845167902720', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:37:31', 'wangxi_DOUW', '2019-10-17 11:37:31', null);
INSERT INTO `sys_file_upload` VALUES ('1184676859739820033', '1178203698971627520', 'Koala.jpg', 'image', '1184676922671157248', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:45:48', 'wangxi_DOUW', '2019-10-17 11:45:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184677257640857601', '1181742037417648128', 'Lighthouse.jpg', 'image', '1184677324175101952', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 11:47:23', 'wangxi_DOUW', '2019-10-17 11:47:23', null);
INSERT INTO `sys_file_upload` VALUES ('1184693046930493441', '1181742037417648128', 'Lighthouse.jpg', 'image', '1184693112344858624', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-17 12:50:08', 'wangxi_DOUW', '2019-10-17 12:50:08', null);
INSERT INTO `sys_file_upload` VALUES ('1184696387958349825', '1177470489730826240', '注册.png', 'image', null, null, '0', null, 'aliali_PRJT', '2019-10-17 13:03:24', 'aliali_PRJT', '2019-10-17 13:03:24', null);
INSERT INTO `sys_file_upload` VALUES ('1184696420590034945', '1177470489730826240', '注册.png', 'image', '1184696427372224512', 'demoBase_image', '0', null, 'aliali_PRJT', '2019-10-17 13:03:32', 'aliali_PRJT', '2019-10-17 13:03:32', null);
INSERT INTO `sys_file_upload` VALUES ('1184697017012002817', '1177470489730826240', '注册.png', 'image', '1184697104303857664', 'demoBase_image', '0', null, 'aliali_PRJT', '2019-10-17 13:05:54', 'aliali_PRJT', '2019-10-17 13:05:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184710287657357312', '1184710287326007296', '1173511072173961216.png', 'image', '1184697639362830336', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-17 13:58:38', 'junAdmin', '2019-10-17 13:58:38', null);
INSERT INTO `sys_file_upload` VALUES ('1184725115513180161', '1177470489730826240', '注册.png', 'image', '1184725126917492736', 'mobile_setting_image', '0', null, 'aliali_PRJT', '2019-10-17 14:57:33', 'aliali_PRJT', '2019-10-17 14:57:33', null);
INSERT INTO `sys_file_upload` VALUES ('1184725471366320129', '1177469357688176640', '已读.png', 'image', '1184725491419287552', 'mobile_setting_image', '9', null, 'aliali_PRJT', '2019-10-17 14:58:58', 'aliali_PRJT', '2019-10-17 14:58:58', null);
INSERT INTO `sys_file_upload` VALUES ('1184741780626026497', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:47', 'wangxi_DOUW', '2019-10-17 16:03:47', null);
INSERT INTO `sys_file_upload` VALUES ('1184741812360130561', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741812368519168', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741812548874241', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741812754395137', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741812993470465', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741813219962881', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184741813467426816', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:03:54', 'wangxi_DOUW', '2019-10-17 16:03:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184742040601571329', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742040878395393', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742041146830849', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742041411072001', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742041650147328', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742041838891009', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742042069577729', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742042254127105', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:04:49', 'wangxi_DOUW', '2019-10-17 16:04:49', null);
INSERT INTO `sys_file_upload` VALUES ('1184742476232884225', '1183557709542518784', 'goutong.png', 'image', '1184742507585306624', 'mobile_setting_image', '0', null, 'zhao_I95W', '2019-10-17 16:06:32', 'zhao_I95W', '2019-10-17 16:06:32', null);
INSERT INTO `sys_file_upload` VALUES ('1184742555446509568', '1184742555194851328', 'perm_phone_msg.png', 'image', '1184742507585306624', 'mobile_setting_image', '0', null, 'zhao_I95W', '2019-10-17 16:06:51', 'zhao_I95W', '2019-10-17 16:06:51', null);
INSERT INTO `sys_file_upload` VALUES ('1184742564736892929', '1184660596848668672', '电话01.png', 'image', '1184742507585306624', 'mobile_setting_image', '0', null, 'zhao_I95W', '2019-10-17 16:06:54', 'zhao_I95W', '2019-10-17 16:06:54', null);
INSERT INTO `sys_file_upload` VALUES ('1184742697656070145', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:25', 'wangxi_DOUW', '2019-10-17 16:07:25', null);
INSERT INTO `sys_file_upload` VALUES ('1184742697941282817', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:25', 'wangxi_DOUW', '2019-10-17 16:07:25', null);
INSERT INTO `sys_file_upload` VALUES ('1184742698188746753', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:25', 'wangxi_DOUW', '2019-10-17 16:07:25', null);
INSERT INTO `sys_file_upload` VALUES ('1184742698427822081', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:25', 'wangxi_DOUW', '2019-10-17 16:07:25', null);
INSERT INTO `sys_file_upload` VALUES ('1184742698687868929', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:25', 'wangxi_DOUW', '2019-10-17 16:07:25', null);
INSERT INTO `sys_file_upload` VALUES ('1184742698885001217', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:26', 'wangxi_DOUW', '2019-10-17 16:07:26', null);
INSERT INTO `sys_file_upload` VALUES ('1184742699124076545', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:26', 'wangxi_DOUW', '2019-10-17 16:07:26', null);
INSERT INTO `sys_file_upload` VALUES ('1184742699300237313', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:07:26', 'wangxi_DOUW', '2019-10-17 16:07:26', null);
INSERT INTO `sys_file_upload` VALUES ('1184743063778013185', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743064088391681', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743064348438529', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743064574930945', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743064801423361', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743065132773377', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743065380237313', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743065585758209', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:08:53', 'wangxi_DOUW', '2019-10-17 16:08:53', null);
INSERT INTO `sys_file_upload` VALUES ('1184743171181363201', '1177469357688176640', '已读.png', 'image', '1184725491419287552', 'mobile_setting_image', '9', null, 'aliali_PRJT', '2019-10-17 16:09:18', 'aliali_PRJT', '2019-10-17 16:09:18', null);
INSERT INTO `sys_file_upload` VALUES ('1184743188239597568', '1177469357566541824', '未读.png', 'image', '1184725491419287552', 'mobile_setting_image', '9', null, 'aliali_PRJT', '2019-10-17 16:09:22', 'aliali_PRJT', '2019-10-17 16:09:22', null);
INSERT INTO `sys_file_upload` VALUES ('1184743206103138305', '1177489809792933888', '确定.png', 'image', '1184725491419287552', 'mobile_setting_image', '9', null, 'aliali_PRJT', '2019-10-17 16:09:26', 'aliali_PRJT', '2019-10-17 16:09:26', null);
INSERT INTO `sys_file_upload` VALUES ('1184743294984826881', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743295391674369', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743295651721217', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743295920156673', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743296192786433', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743296410890241', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743296742240257', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743296964538369', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:48', 'wangxi_DOUW', '2019-10-17 16:09:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184743341797453825', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743342086860801', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743342422405120', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743342648897537', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743342908944385', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743343110270976', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743343353540609', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743343554867201', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:09:59', 'wangxi_DOUW', '2019-10-17 16:09:59', null);
INSERT INTO `sys_file_upload` VALUES ('1184743498823806977', '1184741812045557760', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:36', 'wangxi_DOUW', '2019-10-17 16:10:36', null);
INSERT INTO `sys_file_upload` VALUES ('1184743499109019649', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:36', 'wangxi_DOUW', '2019-10-17 16:10:36', null);
INSERT INTO `sys_file_upload` VALUES ('1184743499356483585', '1184655380678389760', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:36', 'wangxi_DOUW', '2019-10-17 16:10:36', null);
INSERT INTO `sys_file_upload` VALUES ('1184743499704610817', '1177402446866026496', 'Jellyfish.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:36', 'wangxi_DOUW', '2019-10-17 16:10:36', null);
INSERT INTO `sys_file_upload` VALUES ('1184743499968851968', '1178203698971627520', 'Koala.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:37', 'wangxi_DOUW', '2019-10-17 16:10:37', null);
INSERT INTO `sys_file_upload` VALUES ('1184743500186955777', '1181742037417648128', 'Lighthouse.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:37', 'wangxi_DOUW', '2019-10-17 16:10:37', null);
INSERT INTO `sys_file_upload` VALUES ('1184743500476362753', '1177399864154361856', 'Penguins.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:37', 'wangxi_DOUW', '2019-10-17 16:10:37', null);
INSERT INTO `sys_file_upload` VALUES ('1184743500677689345', '1184741813387735040', 'Tulips.jpg', 'image', null, null, '0', null, 'wangxi_DOUW', '2019-10-17 16:10:37', 'wangxi_DOUW', '2019-10-17 16:10:37', null);
INSERT INTO `sys_file_upload` VALUES ('1184748492359294977', '1183557709542518784', 'goutong.png', 'image', '1184748565365350400', 'demoBase_image', '0', null, 'zhao_I95W', '2019-10-17 16:30:27', 'zhao_I95W', '2019-10-17 16:30:27', null);
INSERT INTO `sys_file_upload` VALUES ('1184749588247044097', '1183557709542518784', 'goutong.png', 'image', '1184749655515291648', 'demoBase_image', '0', null, 'zhao_I95W', '2019-10-17 16:34:48', 'zhao_I95W', '2019-10-17 16:34:48', null);
INSERT INTO `sys_file_upload` VALUES ('1184981763170045953', '1177470489730826240', '注册.png', 'image', '1184697639362830336', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-18 07:57:23', 'junAdmin', '2019-10-18 07:57:23', null);
INSERT INTO `sys_file_upload` VALUES ('1185358210687356928', '1185358210079182848', '微信图片_20190927165253.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 08:53:15', 'junAdmin', '2019-10-19 08:53:15', null);
INSERT INTO `sys_file_upload` VALUES ('1185358301947023360', '1185358301863137280', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 08:53:37', 'junAdmin', '2019-10-19 08:53:37', null);
INSERT INTO `sys_file_upload` VALUES ('1185358766491357185', '1185358301863137280', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 08:55:27', 'junAdmin', '2019-10-19 08:55:27', null);
INSERT INTO `sys_file_upload` VALUES ('1185359059371216896', '1185359059278942208', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 08:56:37', 'junAdmin', '2019-10-19 08:56:37', null);
INSERT INTO `sys_file_upload` VALUES ('1185359511601074177', '1185358301863137280', 'Tulips.jpg', 'image', '1184655477818470400', 'demoBase_image', '0', null, 'junAdmin', '2019-10-19 08:58:25', 'junAdmin', '2019-10-19 08:58:25', null);
INSERT INTO `sys_file_upload` VALUES ('1185364021253705728', '1185364021144653824', 'Koala.jpg', 'image', '1185364031957569536', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-19 09:16:20', 'junAdmin', '2019-10-19 09:16:20', null);
INSERT INTO `sys_file_upload` VALUES ('1185364077579014144', '1185364077457379328', 'Jellyfish.jpg', 'image', '1184697639362830336', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-19 09:16:34', 'junAdmin', '2019-10-19 09:16:34', null);
INSERT INTO `sys_file_upload` VALUES ('1185364837914054657', '1185358301863137280', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 09:19:35', 'junAdmin', '2019-10-19 09:19:35', null);
INSERT INTO `sys_file_upload` VALUES ('1185366023950893056', '1185366023850229760', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 09:24:18', 'junAdmin', '2019-10-19 09:24:18', null);
INSERT INTO `sys_file_upload` VALUES ('1185366519099789312', '1185366519007514624', 'Hydrangeas.jpg', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-19 09:26:16', 'junAdmin', '2019-10-19 09:26:16', null);
INSERT INTO `sys_file_upload` VALUES ('1185366569410465793', '1185364021144653824', 'Koala.jpg', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-19 09:26:28', 'junAdmin', '2019-10-19 09:26:28', null);
INSERT INTO `sys_file_upload` VALUES ('1185366579669733376', '1185366579577458688', 'Lighthouse.jpg', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-19 09:26:30', 'junAdmin', '2019-10-19 09:26:30', null);
INSERT INTO `sys_file_upload` VALUES ('1185367226679259137', '1177402023379734528', 'Desert.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 09:29:05', 'junAdmin', '2019-10-19 09:29:05', null);
INSERT INTO `sys_file_upload` VALUES ('1185367321520861184', '1185367320954630144', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 09:29:27', 'junAdmin', '2019-10-19 09:29:27', null);
INSERT INTO `sys_file_upload` VALUES ('1185367629516607488', '1185367629424332800', 'Desert.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-19 09:30:41', 'junAdmin', '2019-10-19 09:30:41', null);
INSERT INTO `sys_file_upload` VALUES ('1185369042661896193', '1185367320954630144', 'Hydrangeas.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 09:36:18', 'junAdmin', '2019-10-19 09:36:18', null);
INSERT INTO `sys_file_upload` VALUES ('1185369468219899904', '1185369467976630272', 'Jellyfish.jpg', 'image', '1185369471243993088', 'demoBase_image', '0', null, 'junAdmin', '2019-10-19 09:37:59', 'junAdmin', '2019-10-19 09:37:59', null);
INSERT INTO `sys_file_upload` VALUES ('1185375815713861632', '1185375815470592000', 'Lighthouse.jpg', 'image', '1185375819950108672', 'demoBase_image', '0', null, 'junAdmin', '2019-10-19 10:03:12', 'junAdmin', '2019-10-19 10:03:12', null);
INSERT INTO `sys_file_upload` VALUES ('1185375970156523521', '1185375815470592000', 'Lighthouse.jpg', 'image', '1185375972878626816', 'demoBase_image', '0', null, 'wangxi_DOUW', '2019-10-19 10:03:49', 'wangxi_DOUW', '2019-10-19 10:03:49', null);
INSERT INTO `sys_file_upload` VALUES ('1185376172577828865', '1185375815470592000', 'Lighthouse.jpg', 'image', '1185376176432394240', 'demoBase_image', '0', null, 'zhao_I95W', '2019-10-19 10:04:37', 'zhao_I95W', '2019-10-19 10:04:37', null);
INSERT INTO `sys_file_upload` VALUES ('1185376561586941953', '1185375815470592000', 'Lighthouse.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 10:06:10', 'junAdmin', '2019-10-19 10:06:10', null);
INSERT INTO `sys_file_upload` VALUES ('1185389793662521344', '1185389793016598528', '12312312.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 10:58:45', 'junAdmin', '2019-10-19 10:58:45', null);
INSERT INTO `sys_file_upload` VALUES ('1185390218168029185', '1185389793016598528', '12312312.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 11:00:26', 'junAdmin', '2019-10-19 11:00:26', null);
INSERT INTO `sys_file_upload` VALUES ('1185391164927299585', '1185389793016598528', '12312312.png', 'image', '1185391195998703616', 'productCfj_img', '0', null, 'junAdmin', '2019-10-19 11:04:12', 'junAdmin', '2019-10-19 11:04:12', null);
INSERT INTO `sys_file_upload` VALUES ('1185392849718013953', '1185389793016598528', '12312312.png', 'image', '1185392862946848768', 'productCfj_img', '0', null, 'junAdmin', '2019-10-19 11:10:54', 'junAdmin', '2019-10-19 11:10:54', null);
INSERT INTO `sys_file_upload` VALUES ('1185393867440201728', '1185393867125628928', 'Penguins.jpg', 'image', '1185393877074518016', 'productCfj_img', '0', null, 'junAdmin', '2019-10-19 11:14:56', 'junAdmin', '2019-10-19 11:14:56', null);
INSERT INTO `sys_file_upload` VALUES ('1185394235666538496', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 11:16:24', 'junAdmin', '2019-10-19 11:16:24', null);
INSERT INTO `sys_file_upload` VALUES ('1185399422942650368', '1185399422867152896', 'xiaopiao.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 11:37:01', 'junAdmin', '2019-10-19 11:37:01', null);
INSERT INTO `sys_file_upload` VALUES ('1185399456996204545', '1185399422867152896', 'xiaopiao.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 11:37:09', 'junAdmin', '2019-10-19 11:37:09', null);
INSERT INTO `sys_file_upload` VALUES ('1185418705835859969', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 12:53:38', 'junAdmin', '2019-10-19 12:53:38', null);
INSERT INTO `sys_file_upload` VALUES ('1185419416162213889', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 12:56:27', 'junAdmin', '2019-10-19 12:56:27', null);
INSERT INTO `sys_file_upload` VALUES ('1185419790604509184', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 12:57:57', 'junAdmin', '2019-10-19 12:57:57', null);
INSERT INTO `sys_file_upload` VALUES ('1185420077746561025', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 12:59:05', 'junAdmin', '2019-10-19 12:59:05', null);
INSERT INTO `sys_file_upload` VALUES ('1185420196105625601', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 12:59:33', 'junAdmin', '2019-10-19 12:59:33', null);
INSERT INTO `sys_file_upload` VALUES ('1185420694212780033', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:01:32', 'junAdmin', '2019-10-19 13:01:32', null);
INSERT INTO `sys_file_upload` VALUES ('1185423716552744960', '1185423716439498752', 'Chrysanthemum.jpg', 'image', '1185423686257287168', 'productCfj_img', '0', null, 'junAdmin', '2019-10-19 13:13:33', 'junAdmin', '2019-10-19 13:13:33', null);
INSERT INTO `sys_file_upload` VALUES ('1185425449425248257', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:20:26', 'junAdmin', '2019-10-19 13:20:26', null);
INSERT INTO `sys_file_upload` VALUES ('1185425672381865985', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:21:19', 'junAdmin', '2019-10-19 13:21:19', null);
INSERT INTO `sys_file_upload` VALUES ('1185425786114613248', '1185425786026532864', 'Lighthouse.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:21:46', 'junAdmin', '2019-10-19 13:21:46', null);
INSERT INTO `sys_file_upload` VALUES ('1185425946982948865', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:22:25', 'junAdmin', '2019-10-19 13:22:25', null);
INSERT INTO `sys_file_upload` VALUES ('1185428181947195393', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:31:17', 'junAdmin', '2019-10-19 13:31:17', null);
INSERT INTO `sys_file_upload` VALUES ('1185428238306058241', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:31:31', 'junAdmin', '2019-10-19 13:31:31', null);
INSERT INTO `sys_file_upload` VALUES ('1185428263245389825', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:31:37', 'junAdmin', '2019-10-19 13:31:37', null);
INSERT INTO `sys_file_upload` VALUES ('1185433589784977409', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 13:52:47', 'junAdmin', '2019-10-19 13:52:47', null);
INSERT INTO `sys_file_upload` VALUES ('1185435714065735681', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:01:13', 'junAdmin', '2019-10-19 14:01:13', null);
INSERT INTO `sys_file_upload` VALUES ('1185439516502474753', '1185394235540709376', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:16:20', 'junAdmin', '2019-10-19 14:16:20', null);
INSERT INTO `sys_file_upload` VALUES ('1185439560433614849', '1185393867125628928', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:16:30', 'junAdmin', '2019-10-19 14:16:30', null);
INSERT INTO `sys_file_upload` VALUES ('1185440402210131968', '1185440400838594560', 'Tulips.jpg', 'image', '1185440448003543040', 'shopGoods_image', '0', null, 'junAdmin', '2019-10-19 14:19:51', 'junAdmin', '2019-10-19 14:19:51', null);
INSERT INTO `sys_file_upload` VALUES ('1185440663590768640', '1185440663502688256', 'Hydrangeas.jpg', 'image', '1185440667428556800', 'demoBase_image', '0', null, 'junAdmin', '2019-10-19 14:20:53', 'junAdmin', '2019-10-19 14:20:53', null);
INSERT INTO `sys_file_upload` VALUES ('1185441328915759104', '1185441328492134400', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:23:32', 'junAdmin', '2019-10-19 14:23:32', null);
INSERT INTO `sys_file_upload` VALUES ('1185441588190855169', '1185441328492134400', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:24:34', 'junAdmin', '2019-10-19 14:24:34', null);
INSERT INTO `sys_file_upload` VALUES ('1185442819463024641', '1185364021144653824', 'Koala.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:29:27', 'junAdmin', '2019-10-19 14:29:27', null);
INSERT INTO `sys_file_upload` VALUES ('1185443396703436801', '1185425786026532864', 'Lighthouse.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 14:31:45', 'junAdmin', '2019-10-19 14:31:45', null);
INSERT INTO `sys_file_upload` VALUES ('1185443655874351105', '1185367629424332800', 'Desert.jpg', 'image', '1185443658843918336', 'demoBase_image', '0', null, 'junAdmin', '2019-10-19 14:32:47', 'junAdmin', '2019-10-19 14:32:47', null);
INSERT INTO `sys_file_upload` VALUES ('1185463241147846656', '1185463240711639040', '1173822679515889664.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:50:36', 'junAdmin', '2019-10-19 15:50:36', null);
INSERT INTO `sys_file_upload` VALUES ('1185463249288990720', '1185463249200910336', '1173835618448801792.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:50:38', 'junAdmin', '2019-10-19 15:50:38', null);
INSERT INTO `sys_file_upload` VALUES ('1185463260160626688', '1185463260101906432', '1173511379939405824.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:50:41', 'junAdmin', '2019-10-19 15:50:41', null);
INSERT INTO `sys_file_upload` VALUES ('1185463313591865345', '1185463240711639040', '1173822679515889664.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:50:53', 'junAdmin', '2019-10-19 15:50:53', null);
INSERT INTO `sys_file_upload` VALUES ('1185463329949650944', '1185463329865764864', '1173822845723574272.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:50:57', 'junAdmin', '2019-10-19 15:50:57', null);
INSERT INTO `sys_file_upload` VALUES ('1185463403932979201', '1185463240711639040', '1173822679515889664.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 15:51:15', 'junAdmin', '2019-10-19 15:51:15', null);
INSERT INTO `sys_file_upload` VALUES ('1185469380894617600', '1185469380571656192', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:15:00', 'junAdmin', '2019-10-19 16:15:00', null);
INSERT INTO `sys_file_upload` VALUES ('1185472200423206912', '1185472200309960704', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:26:12', 'junAdmin', '2019-10-19 16:26:12', null);
INSERT INTO `sys_file_upload` VALUES ('1185473401923948545', '1185472200309960704', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:30:59', 'junAdmin', '2019-10-19 16:30:59', null);
INSERT INTO `sys_file_upload` VALUES ('1185473447729942528', '1185473447629279232', 'Jellyfish.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:31:10', 'junAdmin', '2019-10-19 16:31:10', null);
INSERT INTO `sys_file_upload` VALUES ('1185474369747501056', '1185474367956533248', 'Jellyfish.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:34:49', 'junAdmin', '2019-10-19 16:34:49', null);
INSERT INTO `sys_file_upload` VALUES ('1185474482598957057', '1185472200309960704', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:35:16', 'junAdmin', '2019-10-19 16:35:16', null);
INSERT INTO `sys_file_upload` VALUES ('1185474784354451457', '1185474367956533248', 'Jellyfish.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:36:28', 'junAdmin', '2019-10-19 16:36:28', null);
INSERT INTO `sys_file_upload` VALUES ('1185474816541540353', '1185474367956533248', 'Jellyfish.jpg', 'image', '1185474406690930688', 'activity_img', '0', null, 'junAdmin', '2019-10-19 16:36:36', 'junAdmin', '2019-10-19 16:36:36', null);
INSERT INTO `sys_file_upload` VALUES ('1185474861415911425', '1185367629424332800', 'Desert.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-19 16:36:47', 'junAdmin', '2019-10-19 16:36:47', null);
INSERT INTO `sys_file_upload` VALUES ('1185476069376045056', '1185476069048889344', '1183581772530040832.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-19 16:41:35', 'junAdmin', '2019-10-19 16:41:35', null);
INSERT INTO `sys_file_upload` VALUES ('1185476217883766784', '1185476217690828800', 'hd_img1.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-19 16:42:10', 'junAdmin', '2019-10-19 16:42:10', null);
INSERT INTO `sys_file_upload` VALUES ('1185476258316857344', '1185476258174251008', 'photo1.png', 'image', '1185441900109336576', 'album_img', '9', null, 'junAdmin', '2019-10-19 16:42:20', 'junAdmin', '2019-10-19 16:42:20', null);
INSERT INTO `sys_file_upload` VALUES ('1185476319893434369', '1185476258174251008', 'photo1.png', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-19 16:42:34', 'junAdmin', '2019-10-19 16:42:34', null);
INSERT INTO `sys_file_upload` VALUES ('1185476330601492480', '1185476330484051968', 'photo2.png', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-19 16:42:37', 'junAdmin', '2019-10-19 16:42:37', null);
INSERT INTO `sys_file_upload` VALUES ('1185476355444355072', '1185476355318525952', 'photo4.png', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-19 16:42:43', 'junAdmin', '2019-10-19 16:42:43', null);
INSERT INTO `sys_file_upload` VALUES ('1185714171710050305', '1184710287326007296', '1173511072173961216.png', 'image', '1185444094798176256', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-20 08:27:43', 'junAdmin', '2019-10-20 08:27:43', null);
INSERT INTO `sys_file_upload` VALUES ('1185714202169085952', '1185714201875484672', '1173511225723236352.png', 'image', '1185443296244637696', 'mobile_setting_image', '9', null, 'junAdmin', '2019-10-20 08:27:50', 'junAdmin', '2019-10-20 08:27:50', null);
INSERT INTO `sys_file_upload` VALUES ('1185714217105002497', '1185463260101906432', '1173511379939405824.png', 'image', '1185364031957569536', 'mobile_setting_image', '0', null, 'junAdmin', '2019-10-20 08:27:54', 'junAdmin', '2019-10-20 08:27:54', null);
INSERT INTO `sys_file_upload` VALUES ('1185714247278825472', '1185714247115247616', '1173421500270764032.png', 'image', '1184697639362830336', 'mobile_setting_image', '0', null, 'junAdmin', '2019-10-20 08:28:01', 'junAdmin', '2019-10-20 08:28:01', null);
INSERT INTO `sys_file_upload` VALUES ('1185726526124756992', '1185726526066036736', '1173822263159914496.png', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-20 09:16:48', 'junAdmin', '2019-10-20 09:16:48', null);
INSERT INTO `sys_file_upload` VALUES ('1185726748305428481', '1185463249200910336', '1173835618448801792.png', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-20 09:17:41', 'junAdmin', '2019-10-20 09:17:41', null);
INSERT INTO `sys_file_upload` VALUES ('1185727241723351041', '1184710287326007296', '1173511072173961216.png', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:19:39', 'junAdmin', '2019-10-20 09:19:39', null);
INSERT INTO `sys_file_upload` VALUES ('1185727250594304001', '1185714201875484672', '1173511225723236352.png', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:19:41', 'junAdmin', '2019-10-20 09:19:41', null);
INSERT INTO `sys_file_upload` VALUES ('1185727278142492673', '1185463240711639040', '1173822679515889664.png', 'image', '1185441900109336576', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:19:48', 'junAdmin', '2019-10-20 09:19:48', null);
INSERT INTO `sys_file_upload` VALUES ('1185727285755154433', '1185463329865764864', '1173822845723574272.png', 'image', '1185441900109336576', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:19:49', 'junAdmin', '2019-10-20 09:19:49', null);
INSERT INTO `sys_file_upload` VALUES ('1185727320228139008', '1185727320152641536', '1173841653994942464.png', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:19:58', 'junAdmin', '2019-10-20 09:19:58', null);
INSERT INTO `sys_file_upload` VALUES ('1185727330047004672', '1185727329975701504', '1173841904692686848.png', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:20:00', 'junAdmin', '2019-10-20 09:20:00', null);
INSERT INTO `sys_file_upload` VALUES ('1185727351492481024', '1185727351379234816', '1173860514433658880.png', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-20 09:20:05', 'junAdmin', '2019-10-20 09:20:05', null);
INSERT INTO `sys_file_upload` VALUES ('1185730258702995457', '1184710287326007296', '1173511072173961216.png', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-20 09:31:38', 'junAdmin', '2019-10-20 09:31:38', null);
INSERT INTO `sys_file_upload` VALUES ('1185730477339480065', '1185463249200910336', '1173835618448801792.png', 'image', '1185443658843918336', 'articles_image', '9', null, 'junAdmin', '2019-10-20 09:32:30', 'junAdmin', '2019-10-20 09:32:30', null);
INSERT INTO `sys_file_upload` VALUES ('1185730503490965504', '1185730503398690816', '1173836922411778048.png', 'image', '1185445142992494592', 'articles_image', '9', null, 'junAdmin', '2019-10-20 09:32:36', 'junAdmin', '2019-10-20 09:32:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186073553904365569', '1185389793016598528', '12312312.png', 'image', '1186073562003566592', 'productCfj_img', '0', null, 'junAdmin', '2019-10-21 08:15:46', 'junAdmin', '2019-10-21 08:15:46', null);
INSERT INTO `sys_file_upload` VALUES ('1186074472578285569', '1177469357688176640', '已读.png', 'image', '1186074488927682560', 'articles_image', '0', null, 'aliali_PRJT', '2019-10-21 08:19:25', 'aliali_PRJT', '2019-10-21 08:19:25', null);
INSERT INTO `sys_file_upload` VALUES ('1186074613024555009', '1177470489730826240', '注册.png', 'image', '1186074618514898944', 'articles_image', '0', null, 'aliali_PRJT', '2019-10-21 08:19:59', 'aliali_PRJT', '2019-10-21 08:19:59', null);
INSERT INTO `sys_file_upload` VALUES ('1186074891946061824', '1186074891203670016', 'Tulips.jpg', 'image', '1186074999823560704', 'productCfj_img', '0', null, 'junAdmin', '2019-10-21 08:21:05', 'junAdmin', '2019-10-21 08:21:05', null);
INSERT INTO `sys_file_upload` VALUES ('1186075433648812033', '1185389793016598528', '12312312.png', 'image', '1186075454318342144', 'demoBase_image', '0', null, 'junAdmin', '2019-10-21 08:23:14', 'junAdmin', '2019-10-21 08:23:14', null);
INSERT INTO `sys_file_upload` VALUES ('1186076193438593025', '1185393867125628928', 'Penguins.jpg', 'image', '1186076200841539584', 'demoBase_image', '0', null, 'junAdmin', '2019-10-21 08:26:15', 'junAdmin', '2019-10-21 08:26:15', null);
INSERT INTO `sys_file_upload` VALUES ('1186077460362575873', '1185389793016598528', '12312312.png', 'image', '1186077577438183424', 'productCfj_img', '0', null, 'junAdmin', '2019-10-21 08:31:17', 'junAdmin', '2019-10-21 08:31:17', null);
INSERT INTO `sys_file_upload` VALUES ('1186077689874890753', '1186074891203670016', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 08:32:12', 'junAdmin', '2019-10-21 08:32:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186077893130862592', '1186077892887592960', 'Chrysanthemum.jpg', 'image', '1186077917508157440', 'productCfj_img', '0', null, 'junAdmin', '2019-10-21 08:33:01', 'junAdmin', '2019-10-21 08:33:01', null);
INSERT INTO `sys_file_upload` VALUES ('1186078103537647616', '1186078102405185536', 'Chrysanthemum.jpg', 'image', '1185441900109336576', 'album_img', '9', null, 'junAdmin', '2019-10-21 08:33:51', 'junAdmin', '2019-10-21 08:33:51', null);
INSERT INTO `sys_file_upload` VALUES ('1186088692548038657', '1185440663502688256', 'Hydrangeas.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:15:55', 'junAdmin', '2019-10-21 09:15:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186090105518338048', '1186090104901775360', 'Chrysanthemum.jpg', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-21 09:21:32', 'junAdmin', '2019-10-21 09:21:32', null);
INSERT INTO `sys_file_upload` VALUES ('1186090105522532352', '1186090105103101952', 'Hydrangeas.jpg', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-21 09:21:32', 'junAdmin', '2019-10-21 09:21:32', null);
INSERT INTO `sys_file_upload` VALUES ('1186090105677721600', '1186090104994050048', 'Desert.jpg', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-21 09:21:32', 'junAdmin', '2019-10-21 09:21:32', null);
INSERT INTO `sys_file_upload` VALUES ('1186090209788735488', '1186090209713238016', 'Lighthouse.jpg', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-21 09:21:57', 'junAdmin', '2019-10-21 09:21:57', null);
INSERT INTO `sys_file_upload` VALUES ('1186092004401393665', '1186090209713238016', 'Lighthouse.jpg', 'image', '1185726875279593472', 'activity_img', '9', null, 'junAdmin', '2019-10-21 09:29:05', 'junAdmin', '2019-10-21 09:29:05', null);
INSERT INTO `sys_file_upload` VALUES ('1186094772715974656', '1186094772464316416', 'Penguins.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:40:05', 'junAdmin', '2019-10-21 09:40:05', null);
INSERT INTO `sys_file_upload` VALUES ('1186094811513286657', '1185364021144653824', 'Koala.jpg', 'image', '1185366528578916352', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:40:14', 'junAdmin', '2019-10-21 09:40:14', null);
INSERT INTO `sys_file_upload` VALUES ('1186094836926574592', '1186094836825911296', 'Chrysanthemum.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:40:20', 'junAdmin', '2019-10-21 09:40:20', null);
INSERT INTO `sys_file_upload` VALUES ('1186095522087104512', '1186095521965469696', 'Desert.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186095522389094400', '1186095522263265280', 'Hydrangeas.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186095522653335552', '1186095522569449472', 'Jellyfish.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186095522837884929', '1185364021144653824', 'Koala.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186095523181817856', '1186095523089543168', 'Lighthouse.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186095523517362177', '1186094772464316416', 'Penguins.jpg', 'image', '1185443642257940480', 'album_img', '9', null, 'junAdmin', '2019-10-21 09:43:04', 'junAdmin', '2019-10-21 09:43:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186105331703746560', '1186094836825911296', 'Chrysanthemum.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-21 10:22:03', 'junAdmin', '2019-10-21 10:22:03', null);
INSERT INTO `sys_file_upload` VALUES ('1186105331712135169', '1186095521965469696', 'Desert.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-21 10:22:03', 'junAdmin', '2019-10-21 10:22:03', null);
INSERT INTO `sys_file_upload` VALUES ('1186105332072845313', '1186095522263265280', 'Hydrangeas.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-21 10:22:03', 'junAdmin', '2019-10-21 10:22:03', null);
INSERT INTO `sys_file_upload` VALUES ('1186105332634882048', '1186105332387418112', 'Tulips.jpg', 'image', '1185366032435970048', 'album_img', '9', null, 'junAdmin', '2019-10-21 10:22:03', 'junAdmin', '2019-10-21 10:22:03', null);
INSERT INTO `sys_file_upload` VALUES ('1186107230205202432', '1186107228493926400', 'Chrysanthemum.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107230205202433', '1186107228745584640', 'Hydrangeas.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107230209396736', '1186107228644921344', 'Desert.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107230788210688', '1186107230721101824', 'Jellyfish.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107231081811968', '1186107231002120192', 'Koala.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107231396384768', '1186107231320887296', 'Lighthouse.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:35', 'junAdmin', '2019-10-21 10:29:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186107231723540480', '1186107231643848704', 'Penguins.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:36', 'junAdmin', '2019-10-21 10:29:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186107231937449984', '1186107231866146816', 'Tulips.jpg', 'image', '1185474918936596480', 'activity_img', '9', null, 'junAdmin', '2019-10-21 10:29:36', 'junAdmin', '2019-10-21 10:29:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186109734267604993', '1186107231002120192', 'Koala.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:39:32', 'junAdmin', '2019-10-21 10:39:32', null);
INSERT INTO `sys_file_upload` VALUES ('1186109744602370049', '1186107231320887296', 'Lighthouse.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:39:35', 'junAdmin', '2019-10-21 10:39:35', null);
INSERT INTO `sys_file_upload` VALUES ('1186109783387099137', '1186107231002120192', 'Koala.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:39:44', 'junAdmin', '2019-10-21 10:39:44', null);
INSERT INTO `sys_file_upload` VALUES ('1186109794959183873', '1186107231643848704', 'Penguins.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:39:47', 'junAdmin', '2019-10-21 10:39:47', null);
INSERT INTO `sys_file_upload` VALUES ('1186110043891126273', '1186107228493926400', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:40:46', 'junAdmin', '2019-10-21 10:40:46', null);
INSERT INTO `sys_file_upload` VALUES ('1186110075532955649', '1186107230721101824', 'Jellyfish.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-21 10:40:54', 'junAdmin', '2019-10-21 10:40:54', null);
INSERT INTO `sys_file_upload` VALUES ('1186114307866628096', '1186114307761770496', 'Tulips.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 10:57:43', 'junAdmin', '2019-10-21 10:57:43', null);
INSERT INTO `sys_file_upload` VALUES ('1186114332373946368', '1186114332273283072', 'Penguins.jpg', 'image', '1185443658843918336', 'articles_image', '9', null, 'junAdmin', '2019-10-21 10:57:48', 'junAdmin', '2019-10-21 10:57:48', null);
INSERT INTO `sys_file_upload` VALUES ('1186114358294745088', '1186114358189887488', 'Hydrangeas.jpg', 'image', '1185445142992494592', 'articles_image', '9', null, 'junAdmin', '2019-10-21 10:57:55', 'junAdmin', '2019-10-21 10:57:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186114440859619328', '1186114440771538944', 'Jellyfish.jpg', 'image', '1185445142992494592', 'articles_image', '9', null, 'junAdmin', '2019-10-21 10:58:14', 'junAdmin', '2019-10-21 10:58:14', null);
INSERT INTO `sys_file_upload` VALUES ('1186114965993906177', '1186107230721101824', 'Jellyfish.jpg', 'image', '1183289109110308864', 'member_head_img', '9', null, 'junAdmin', '2019-10-21 11:00:20', 'junAdmin', '2019-10-21 11:00:20', null);
INSERT INTO `sys_file_upload` VALUES ('1186115357284720641', '1186107231002120192', 'Koala.jpg', 'image', '1183289109110308864', 'member_head_img', '9', null, 'junAdmin', '2019-10-21 11:01:53', 'junAdmin', '2019-10-21 11:01:53', null);
INSERT INTO `sys_file_upload` VALUES ('1186117891278589953', '1186107231002120192', 'Koala.jpg', 'image', '1183289109110308864', 'member_head_img', '0', null, 'junAdmin', '2019-10-21 11:11:57', 'junAdmin', '2019-10-21 11:11:57', null);
INSERT INTO `sys_file_upload` VALUES ('1186143504413917184', '1186143502937522176', 'Hydrangeas.jpg', 'image', '1185441978328911872', 'member_head_img', '0', null, 'junAdmin', '2019-10-21 12:53:44', 'junAdmin', '2019-10-21 12:53:44', null);
INSERT INTO `sys_file_upload` VALUES ('1186144837403684864', '1186144836116033537', 'Hydrangeas.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 12:59:01', 'junAdmin', '2019-10-21 12:59:01', null);
INSERT INTO `sys_file_upload` VALUES ('1186144837403684865', '1186144836116033538', 'Desert.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 12:59:01', 'junAdmin', '2019-10-21 12:59:01', null);
INSERT INTO `sys_file_upload` VALUES ('1186144837403684866', '1186144836116033536', 'Chrysanthemum.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 12:59:01', 'junAdmin', '2019-10-21 12:59:01', null);
INSERT INTO `sys_file_upload` VALUES ('1186144837957332993', '1186114440771538944', 'Jellyfish.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 12:59:02', 'junAdmin', '2019-10-21 12:59:02', null);
INSERT INTO `sys_file_upload` VALUES ('1186144838242545665', '1186114307761770496', 'Tulips.jpg', 'image', '1185375819950108672', 'articles_image', '9', null, 'junAdmin', '2019-10-21 12:59:02', 'junAdmin', '2019-10-21 12:59:02', null);
INSERT INTO `sys_file_upload` VALUES ('1186148784677507072', '1186148784568455168', 'Koala.jpg', 'image', '1185443658843918336', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:14:43', 'junAdmin', '2019-10-21 13:14:43', null);
INSERT INTO `sys_file_upload` VALUES ('1186148784681701376', '1186148784568455169', 'Lighthouse.jpg', 'image', '1185443658843918336', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:14:43', 'junAdmin', '2019-10-21 13:14:43', null);
INSERT INTO `sys_file_upload` VALUES ('1186148816382251009', '1186148784568455169', 'Lighthouse.jpg', 'image', '1185445142992494592', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:14:50', 'junAdmin', '2019-10-21 13:14:50', null);
INSERT INTO `sys_file_upload` VALUES ('1186148816638103553', '1186114332273283072', 'Penguins.jpg', 'image', '1185445142992494592', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:14:50', 'junAdmin', '2019-10-21 13:14:50', null);
INSERT INTO `sys_file_upload` VALUES ('1186149397561790464', '1186144836116033536', 'Chrysanthemum.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:17:09', 'junAdmin', '2019-10-21 13:17:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186149397796671489', '1186144836116033538', 'Desert.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:17:09', 'junAdmin', '2019-10-21 13:17:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186149398044135425', '1186144836116033537', 'Hydrangeas.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:17:09', 'junAdmin', '2019-10-21 13:17:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186149398283210753', '1186114440771538944', 'Jellyfish.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:17:09', 'junAdmin', '2019-10-21 13:17:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186149398484537345', '1186114307761770496', 'Tulips.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 13:17:09', 'junAdmin', '2019-10-21 13:17:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186196006265425921', '1186114440771538944', 'Jellyfish.jpg', 'image', '1186149457309650944', 'articles_image', '9', null, 'junAdmin', '2019-10-21 16:22:21', 'junAdmin', '2019-10-21 16:22:21', null);
INSERT INTO `sys_file_upload` VALUES ('1186196124725153793', '1186148784568455169', 'Lighthouse.jpg', 'image', '1185441900109336576', 'album_img', '9', null, 'junAdmin', '2019-10-21 16:22:49', 'junAdmin', '2019-10-21 16:22:49', null);
INSERT INTO `sys_file_upload` VALUES ('1186478249696477185', '1185476217690828800', 'hd_img1.png', 'image', '1185726875279593473', 'activity_img', '0', null, 'junAdmin', '2019-10-22 11:03:53', 'junAdmin', '2019-10-22 11:03:53', null);
INSERT INTO `sys_file_upload` VALUES ('1186478296127422464', '1186478295661854720', 'hd_img2.png', 'image', '1185726875279593472', 'activity_img', '0', null, 'junAdmin', '2019-10-22 11:04:04', 'junAdmin', '2019-10-22 11:04:04', null);
INSERT INTO `sys_file_upload` VALUES ('1186478353035739136', '1186478352897327104', 'hd_img3.png', 'image', '1185474918936596480', 'activity_img', '0', null, 'junAdmin', '2019-10-22 11:04:18', 'junAdmin', '2019-10-22 11:04:18', null);
INSERT INTO `sys_file_upload` VALUES ('1186485806028599299', '1185476330484051968', 'photo2.png', 'image', '1185443642257940480', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:33:55', 'junAdmin', '2019-10-22 11:33:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186485806028599300', '1185476258174251008', 'photo1.png', 'image', '1185443642257940480', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:33:55', 'junAdmin', '2019-10-22 11:33:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186485806565470208', '1186485806028599296', 'photo3.png', 'image', '1185443642257940480', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:33:55', 'junAdmin', '2019-10-22 11:33:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186485806611607554', '1185476355318525952', 'photo4.png', 'image', '1185443642257940480', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:33:55', 'junAdmin', '2019-10-22 11:33:55', null);
INSERT INTO `sys_file_upload` VALUES ('1186485877126246401', '1185476258174251008', 'photo1.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485877268852737', '1185476330484051968', 'photo2.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485877411459073', '1186485806028599296', 'photo3.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485877629562881', '1185476355318525952', 'photo4.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485877851860992', '1186485877780557824', 'pt.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485878007050240', '1186485877956718592', 'rec1.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485878174822400', '1186485878103519232', 'rec2.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485878451646464', '1186485878392926208', 'rec3.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485878749442048', '1186485878644584448', 'rec5.png', 'image', '1185441900109336576', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:12', 'junAdmin', '2019-10-22 11:34:12', null);
INSERT INTO `sys_file_upload` VALUES ('1186485922798022657', '1186485877780557824', 'pt.png', 'image', '1185366528578916352', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:22', 'junAdmin', '2019-10-22 11:34:22', null);
INSERT INTO `sys_file_upload` VALUES ('1186485922827382785', '1186485877956718592', 'rec1.png', 'image', '1185366528578916352', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:23', 'junAdmin', '2019-10-22 11:34:23', null);
INSERT INTO `sys_file_upload` VALUES ('1186485922974183425', '1186485878103519232', 'rec2.png', 'image', '1185366528578916352', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:23', 'junAdmin', '2019-10-22 11:34:23', null);
INSERT INTO `sys_file_upload` VALUES ('1186485923192287233', '1186485878392926208', 'rec3.png', 'image', '1185366528578916352', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:23', 'junAdmin', '2019-10-22 11:34:23', null);
INSERT INTO `sys_file_upload` VALUES ('1186485923225841665', '1186485878644584448', 'rec5.png', 'image', '1185366528578916352', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:23', 'junAdmin', '2019-10-22 11:34:23', null);
INSERT INTO `sys_file_upload` VALUES ('1186485977584021505', '1185476258174251008', 'photo1.png', 'image', '1185366032435970048', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:36', 'junAdmin', '2019-10-22 11:34:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186485977600798720', '1185476330484051968', 'photo2.png', 'image', '1185366032435970048', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:36', 'junAdmin', '2019-10-22 11:34:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186485977634353153', '1186485806028599296', 'photo3.png', 'image', '1185366032435970048', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:36', 'junAdmin', '2019-10-22 11:34:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186485977915371521', '1185476355318525952', 'photo4.png', 'image', '1185366032435970048', 'album_img', '0', null, 'junAdmin', '2019-10-22 11:34:36', 'junAdmin', '2019-10-22 11:34:36', null);
INSERT INTO `sys_file_upload` VALUES ('1186486432770863104', '1186486432716337152', 'about1.png', 'image', '1186149457309650944', 'articles_image', '0', null, 'junAdmin', '2019-10-22 11:36:24', 'junAdmin', '2019-10-22 11:36:24', null);
INSERT INTO `sys_file_upload` VALUES ('1186486472285401088', '1186486472239263744', 'about2.png', 'image', '1185445142992494592', 'articles_image', '0', null, 'junAdmin', '2019-10-22 11:36:34', 'junAdmin', '2019-10-22 11:36:34', null);
INSERT INTO `sys_file_upload` VALUES ('1186486502429863936', '1186486502371143680', 'about3.png', 'image', '1185443658843918336', 'articles_image', '0', null, 'junAdmin', '2019-10-22 11:36:41', 'junAdmin', '2019-10-22 11:36:41', null);
INSERT INTO `sys_file_upload` VALUES ('1186486537175478272', '1186486537116758016', 'about4.png', 'image', '1185375819950108672', 'articles_image', '0', null, 'junAdmin', '2019-10-22 11:36:49', 'junAdmin', '2019-10-22 11:36:49', null);
INSERT INTO `sys_file_upload` VALUES ('1186523206146633728', '1186523206071136256', 'banner.png', 'image', '1185444094798176256', 'mobile_setting_image', '0', null, 'junAdmin', '2019-10-22 14:02:32', 'junAdmin', '2019-10-22 14:02:32', null);
INSERT INTO `sys_file_upload` VALUES ('1186523241261346816', '1186523241181655040', 'brand.png', 'image', '1185443296244637696', 'mobile_setting_image', '0', null, 'junAdmin', '2019-10-22 14:02:40', 'junAdmin', '2019-10-22 14:02:40', null);
INSERT INTO `sys_file_upload` VALUES ('1186523314267402241', '1186478295661854720', 'hd_img2.png', 'image', '1186523318100996096', 'mobile_setting_image', '0', null, 'junAdmin', '2019-10-22 14:02:57', 'junAdmin', '2019-10-22 14:02:57', null);
INSERT INTO `sys_file_upload` VALUES ('1186603005770248192', '1186603005396955136', '1173421500270764032.png', 'image', '1186523318100996096', 'mobile_setting_img', '9', null, 'junAdmin', '2019-10-22 19:19:37', 'junAdmin', '2019-10-22 19:19:37', null);
INSERT INTO `sys_file_upload` VALUES ('1186803299712843776', '1186803299205332992', 'hd_img4.png', 'image', '1186803457213153280', 'activity_img', '0', null, 'junAdmin', '2019-10-23 08:35:31', 'junAdmin', '2019-10-23 08:35:31', null);
INSERT INTO `sys_file_upload` VALUES ('1186810492466860032', '1186810491741245440', 'Lighthouse.jpg', 'image', '1186810498783481856', 'articles_img', '0', null, 'junAdmin', '2019-10-23 09:04:06', 'junAdmin', '2019-10-23 09:04:06', null);
INSERT INTO `sys_file_upload` VALUES ('1186837673354067968', '1186837673102409728', 'act_img.png', 'image', '1186837703095877632', 'articles_img', '0', null, 'junAdmin', '2019-10-23 10:52:06', 'junAdmin', '2019-10-23 10:52:06', null);
INSERT INTO `sys_file_upload` VALUES ('1186869141634879489', '1186523206071136256', 'banner.png', 'image', '1186523318100996096', 'mobile_setting_img', '9', null, 'junAdmin', '2019-10-23 12:57:09', 'junAdmin', '2019-10-23 12:57:09', null);
INSERT INTO `sys_file_upload` VALUES ('1186869173071187969', '1186523241181655040', 'brand.png', 'image', '1186523318100996096', 'mobile_setting_img', '0', null, 'junAdmin', '2019-10-23 12:57:16', 'junAdmin', '2019-10-23 12:57:16', null);
INSERT INTO `sys_file_upload` VALUES ('1187182308915720193', '1186837673102409728', 'act_img.png', 'image', '1181743349920227328', 'member_head_img', '9', null, 'junAdmin', '2019-10-24 09:41:34', 'junAdmin', '2019-10-24 09:41:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187211885686616065', '1186486537116758016', 'about4.png', 'image', '1181743349920227328', 'member_head_img', '9', null, 'junAdmin', '2019-10-24 11:39:06', 'junAdmin', '2019-10-24 11:39:06', null);
INSERT INTO `sys_file_upload` VALUES ('1187212765949390848', '1187212765659983872', 'clear.png', 'image', '1181743349920227328', 'member_head_img', '9', null, 'junAdmin', '2019-10-24 11:42:35', 'junAdmin', '2019-10-24 11:42:35', null);
INSERT INTO `sys_file_upload` VALUES ('1187235263543664640', '1187235222984744960', 'ic5.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-24 13:11:59', 'junAdmin', '2019-10-24 13:11:59', null);
INSERT INTO `sys_file_upload` VALUES ('1187237648993906688', '1186837673102409728', 'act_img.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-24 13:21:28', 'junAdmin', '2019-10-24 13:21:28', null);
INSERT INTO `sys_file_upload` VALUES ('1187237790820102144', '1187237713569411072', 'card1.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-24 13:22:02', 'junAdmin', '2019-10-24 13:22:02', null);
INSERT INTO `sys_file_upload` VALUES ('1187240797291237376', '1187240797245100032', 'buy.png', 'image', null, null, '0', null, 'junAdmin', '2019-10-24 13:33:59', 'junAdmin', '2019-10-24 13:33:59', null);
INSERT INTO `sys_file_upload` VALUES ('1187250632042881025', '1186837673102409728', 'act_img.png', 'image', null, null, '0', null, null, '2019-10-24 14:13:03', null, '2019-10-24 14:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1187250672945733633', '1186486502371143680', 'about3.png', 'image', null, null, '0', null, null, '2019-10-24 14:13:13', null, '2019-10-24 14:13:13', null);
INSERT INTO `sys_file_upload` VALUES ('1187283874220740609', '1186486502371143680', 'about3.png', 'image', null, null, '0', null, null, '2019-10-24 16:25:09', null, '2019-10-24 16:25:09', null);
INSERT INTO `sys_file_upload` VALUES ('1187284430330925057', '1186486537116758016', 'about4.png', 'image', null, null, '0', null, null, '2019-10-24 16:27:22', null, '2019-10-24 16:27:22', null);
INSERT INTO `sys_file_upload` VALUES ('1187284453328293889', '1185476217690828800', 'hd_img1.png', 'image', null, null, '0', null, null, '2019-10-24 16:27:27', null, '2019-10-24 16:27:27', null);
INSERT INTO `sys_file_upload` VALUES ('1187284935044108289', '1186486537116758016', 'about4.png', 'image', null, null, '0', null, null, '2019-10-24 16:29:22', null, '2019-10-24 16:29:22', null);
INSERT INTO `sys_file_upload` VALUES ('1187285441804111873', '1186837673102409728', 'act_img.png', 'image', null, null, '0', null, null, '2019-10-24 16:31:23', null, '2019-10-24 16:31:23', null);
INSERT INTO `sys_file_upload` VALUES ('1187285580333584385', '1186478295661854720', 'hd_img2.png', 'image', null, null, '0', null, null, '2019-10-24 16:31:56', null, '2019-10-24 16:31:56', null);
INSERT INTO `sys_file_upload` VALUES ('1187285631818665985', '1186837673102409728', 'act_img.png', 'image', null, null, '0', null, null, '2019-10-24 16:32:08', null, '2019-10-24 16:32:08', null);
INSERT INTO `sys_file_upload` VALUES ('1187286720735481857', '1186478295661854720', 'hd_img2.png', 'image', null, null, '0', null, null, '2019-10-24 16:36:28', null, '2019-10-24 16:36:28', null);
INSERT INTO `sys_file_upload` VALUES ('1187286778969198593', '1186837673102409728', 'act_img.png', 'image', null, null, '0', null, null, '2019-10-24 16:36:41', null, '2019-10-24 16:36:41', null);
INSERT INTO `sys_file_upload` VALUES ('1187288567957295105', '1186486502371143680', 'about3.png', 'image', null, null, '0', null, null, '2019-10-24 16:43:48', null, '2019-10-24 16:43:48', null);
INSERT INTO `sys_file_upload` VALUES ('1187288580745728001', '1186523241181655040', 'brand.png', 'image', null, null, '0', null, null, '2019-10-24 16:43:51', null, '2019-10-24 16:43:51', null);
INSERT INTO `sys_file_upload` VALUES ('1187290344631414784', '1187290342987247616', 'Chrysanthemum.jpg', 'image', '1187290405822115840', 'activity_img', '0', null, 'junAdmin', '2019-10-24 16:50:52', 'junAdmin', '2019-10-24 16:50:52', null);
INSERT INTO `sys_file_upload` VALUES ('1187545345937276930', '1186523241181655040', 'brand.png', 'image', '1187545344339247104', 'growup_img', '0', null, null, '2019-10-25 09:44:09', null, '2019-10-25 09:44:09', null);
INSERT INTO `sys_file_upload` VALUES ('1187545345937276931', '1186523206071136256', 'banner.png', 'image', '1187545344339247104', 'growup_img', '0', null, null, '2019-10-25 09:44:09', null, '2019-10-25 09:44:09', null);
INSERT INTO `sys_file_upload` VALUES ('1187546355539804161', '1186803299205332992', 'hd_img4.png', 'image', '1187546355250397184', 'growup_img', '0', null, null, '2019-10-25 09:48:09', null, '2019-10-25 09:48:09', null);
INSERT INTO `sys_file_upload` VALUES ('1187546355552387073', '1186478352897327104', 'hd_img3.png', 'image', '1187546355250397184', 'growup_img', '0', null, null, '2019-10-25 09:48:09', null, '2019-10-25 09:48:09', null);
INSERT INTO `sys_file_upload` VALUES ('1187551121913315329', '1186485878644584448', 'rec5.png', 'image', '1187551121724571648', 'growup_img', '0', null, null, '2019-10-25 10:07:06', null, '2019-10-25 10:07:06', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239420936193', '1186486502371143680', 'about3.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239441907714', '1186523206071136256', 'banner.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239441907715', '1186486472239263744', 'about2.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239450296321', '1186523241181655040', 'brand.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239450296323', '1186837673102409728', 'act_img.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239450296325', '1186486432716337152', 'about1.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187551239571931137', '1186486537116758016', 'about4.png', 'image', '1187551239089586176', 'growup_img', '0', null, null, '2019-10-25 10:07:34', null, '2019-10-25 10:07:34', null);
INSERT INTO `sys_file_upload` VALUES ('1187562132879867905', '1187544153990631424', 'ic2.png', 'image', '1187562132716290048', 'growup_img', '0', null, null, '2019-10-25 10:50:51', null, '2019-10-25 10:50:51', null);
INSERT INTO `sys_file_upload` VALUES ('1187562279797948417', '1186523206071136256', 'banner.png', 'image', '1187562279483375616', 'growup_img', '0', null, null, '2019-10-25 10:51:26', null, '2019-10-25 10:51:26', null);
INSERT INTO `sys_file_upload` VALUES ('1187563838418092033', '1187544153990631424', 'ic2.png', 'image', '1187563838254514176', 'growup_img', '0', null, null, '2019-10-25 10:57:38', null, '2019-10-25 10:57:38', null);
INSERT INTO `sys_file_upload` VALUES ('1187563838476812289', '1187543637491453952', 'ic3.png', 'image', '1187563838254514176', 'growup_img', '0', null, null, '2019-10-25 10:57:38', null, '2019-10-25 10:57:38', null);
INSERT INTO `sys_file_upload` VALUES ('1187563962561101825', '1187544427253731328', 'ic1.png', 'image', '1187563962372358144', 'growup_img', '0', null, null, '2019-10-25 10:58:07', null, '2019-10-25 10:58:07', null);
INSERT INTO `sys_file_upload` VALUES ('1187564080068722689', '1186486432716337152', 'about1.png', 'image', '1187564079913533440', 'growup_img', '0', null, null, '2019-10-25 10:58:35', null, '2019-10-25 10:58:35', null);
INSERT INTO `sys_file_upload` VALUES ('1187564528750198785', '1186485878644584448', 'rec5.png', 'image', '1187564528477569024', 'growup_img', '0', null, null, '2019-10-25 11:00:22', null, '2019-10-25 11:00:22', null);
INSERT INTO `sys_file_upload` VALUES ('1187564598908321793', '1186485806028599296', 'photo3.png', 'image', '1187564598610526208', 'growup_img', '0', null, null, '2019-10-25 11:00:39', null, '2019-10-25 11:00:39', null);
INSERT INTO `sys_file_upload` VALUES ('1187564714650140673', '1186486432716337152', 'about1.png', 'image', '1187564714335567872', 'growup_img', '0', null, null, '2019-10-25 11:01:07', null, '2019-10-25 11:01:07', null);
INSERT INTO `sys_file_upload` VALUES ('1187564865498284033', '1186523241181655040', 'brand.png', 'image', '1187564865229848576', 'growup_img', '0', null, null, '2019-10-25 11:01:42', null, '2019-10-25 11:01:42', null);
INSERT INTO `sys_file_upload` VALUES ('1187649879238307843', '1186486432716337152', 'about1.png', 'image', '1187649878621745152', 'feedback_img', '0', null, null, '2019-10-25 16:39:31', null, '2019-10-25 16:39:31', null);
INSERT INTO `sys_file_upload` VALUES ('1187649879242502144', '1186486472239263744', 'about2.png', 'image', '1187649878621745152', 'feedback_img', '0', null, null, '2019-10-25 16:39:31', null, '2019-10-25 16:39:31', null);
INSERT INTO `sys_file_upload` VALUES ('1187649879460605952', '1187649879238307842', 'ic4.png', 'image', '1187649878621745152', 'feedback_img', '0', null, null, '2019-10-25 16:39:31', null, '2019-10-25 16:39:31', null);
INSERT INTO `sys_file_upload` VALUES ('1187659191541100545', '1186486537116758016', 'about4.png', 'image', '1187659191213944832', 'growup_img', '0', null, null, '2019-10-25 17:16:32', null, '2019-10-25 17:16:32', null);
INSERT INTO `sys_file_upload` VALUES ('1187659191549489153', '1186486432716337152', 'about1.png', 'image', '1187659191213944832', 'growup_img', '0', null, null, '2019-10-25 17:16:32', null, '2019-10-25 17:16:32', null);
INSERT INTO `sys_file_upload` VALUES ('1187659191549489155', '1186486472239263744', 'about2.png', 'image', '1187659191213944832', 'growup_img', '0', null, null, '2019-10-25 17:16:32', null, '2019-10-25 17:16:32', null);
INSERT INTO `sys_file_upload` VALUES ('1187659191574654977', '1186486502371143680', 'about3.png', 'image', '1187659191213944832', 'growup_img', '0', null, null, '2019-10-25 17:16:32', null, '2019-10-25 17:16:32', null);
INSERT INTO `sys_file_upload` VALUES ('1187659248592023553', '1187237713569411072', 'card1.png', 'image', null, null, '0', null, null, '2019-10-25 17:16:45', null, '2019-10-25 17:16:45', null);
INSERT INTO `sys_file_upload` VALUES ('1187894193828106241', '1185476217690828800', 'hd_img1.png', 'image', '1187894525744353280', 'activity_img', '0', null, 'junAdmin', '2019-10-26 08:50:20', 'junAdmin', '2019-10-26 08:50:20', null);
INSERT INTO `sys_file_upload` VALUES ('1187930549799362561', '1186486472239263744', 'about2.png', 'image', '1187930574151491584', 'articles_img', '0', null, 'junAdmin', '2019-10-26 11:14:48', 'junAdmin', '2019-10-26 11:14:48', null);
INSERT INTO `sys_file_upload` VALUES ('1187930707136094209', '1186486502371143680', 'about3.png', 'image', '1187930718456520704', 'articles_img', '0', null, 'junAdmin', '2019-10-26 11:15:26', 'junAdmin', '2019-10-26 11:15:26', null);
INSERT INTO `sys_file_upload` VALUES ('1187930865408155649', '1186486537116758016', 'about4.png', 'image', '1187930871154352128', 'articles_img', '0', null, 'junAdmin', '2019-10-26 11:16:04', 'junAdmin', '2019-10-26 11:16:04', null);
INSERT INTO `sys_file_upload` VALUES ('1187931531014840321', '1186485878103519232', 'rec2.png', 'image', '1187931557367652352', 'articles_img', '0', null, 'junAdmin', '2019-10-26 11:18:42', 'junAdmin', '2019-10-26 11:18:42', null);
INSERT INTO `sys_file_upload` VALUES ('1187979171308425217', '1186523206071136256', 'banner.png', 'image', '1187979202266583040', 'articles_img', '0', null, 'junAdmin', '2019-10-26 14:28:01', 'junAdmin', '2019-10-26 14:28:01', null);
INSERT INTO `sys_file_upload` VALUES ('1188985924107378689', '1186144836116033538', 'Desert.jpg', 'image', '1188985931082506240', 'articles_img', '0', null, 'junAdmin', '2019-10-29 09:08:29', 'junAdmin', '2019-10-29 09:08:29', null);
INSERT INTO `sys_file_upload` VALUES ('1188990202635386880', '1188990202329202688', '1173511072173961216.png', 'image', '1188990279688945664', 'activity_img', '0', null, 'junAdmin', '2019-10-29 09:25:29', 'junAdmin', '2019-10-29 09:25:29', null);
INSERT INTO `sys_file_upload` VALUES ('1188991124408508417', '1188990202329202688', '1173511072173961216.png', 'image', '1188991180033368064', 'activity_img', '0', null, 'junAdmin', '2019-10-29 09:29:09', 'junAdmin', '2019-10-29 09:29:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189351684885454849', '1186486537116758016', 'about4.png', 'image', null, null, '0', null, null, '2019-10-30 09:21:53', null, '2019-10-30 09:21:53', null);
INSERT INTO `sys_file_upload` VALUES ('1189372800580411393', '1186478295661854720', 'hd_img2.png', 'image', '1189373060455292928', 'activity_img', '0', null, 'junAdmin', '2019-10-30 10:45:48', 'junAdmin', '2019-10-30 10:45:48', null);
INSERT INTO `sys_file_upload` VALUES ('1189377408628588545', '1186478352897327104', 'hd_img3.png', 'image', '1189377540929519616', 'activity_img', '0', null, 'junAdmin', '2019-10-30 11:04:06', 'junAdmin', '2019-10-30 11:04:06', null);
INSERT INTO `sys_file_upload` VALUES ('1189379267611230209', '1185476258174251008', 'photo1.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379267636396033', '1185476330484051968', 'photo2.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379267728670720', '1186485806028599296', 'photo3.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379267984523265', '1186485877780557824', 'pt.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379268009689089', '1185476355318525952', 'photo4.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379268148101121', '1186485877956718592', 'rec1.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379268403953665', '1186485878392926208', 'rec3.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379268429119489', '1186485878103519232', 'rec2.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379268575920129', '1186485878644584448', 'rec5.png', 'image', '1189379298116403200', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:30', 'junAdmin', '2019-10-30 11:11:30', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371420254209', '1185476258174251008', 'photo1.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:54', 'junAdmin', '2019-10-30 11:11:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371453808642', '1185476330484051968', 'photo2.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:54', 'junAdmin', '2019-10-30 11:11:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371629969409', '1186485806028599296', 'photo3.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:54', 'junAdmin', '2019-10-30 11:11:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371776770049', '1186485877780557824', 'pt.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:54', 'junAdmin', '2019-10-30 11:11:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371801935873', '1185476355318525952', 'photo4.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:54', 'junAdmin', '2019-10-30 11:11:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189379371864850433', '1186485877956718592', 'rec1.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:55', 'junAdmin', '2019-10-30 11:11:55', null);
INSERT INTO `sys_file_upload` VALUES ('1189379372015845378', '1186485878392926208', 'rec3.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:55', 'junAdmin', '2019-10-30 11:11:55', null);
INSERT INTO `sys_file_upload` VALUES ('1189379372015845379', '1186485878103519232', 'rec2.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:55', 'junAdmin', '2019-10-30 11:11:55', null);
INSERT INTO `sys_file_upload` VALUES ('1189379372112314369', '1186485878644584448', 'rec5.png', 'image', '1189379387954200576', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:11:55', 'junAdmin', '2019-10-30 11:11:55', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443138658305', '1186486432716337152', 'about1.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443327401985', '1186486472239263744', 'about2.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443381927937', '1186486537116758016', 'about4.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443394510849', '1186486502371143680', 'about3.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443541311489', '1186837673102409728', 'act_img.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443696500738', '1186478295661854720', 'hd_img2.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443696500739', '1185476217690828800', 'hd_img1.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443813941249', '1186478352897327104', 'hd_img3.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379443931381761', '1186803299205332992', 'hd_img4.png', 'image', '1189379452827500544', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:12', 'junAdmin', '2019-10-30 11:12:12', null);
INSERT INTO `sys_file_upload` VALUES ('1189379559585120257', '1185476217690828800', 'hd_img1.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379559937441793', '1186478295661854720', 'hd_img2.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560054882305', '1186478352897327104', 'hd_img3.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560088436738', '1186803299205332992', 'hd_img4.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560243625985', '1185476258174251008', 'photo1.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560298151937', '1185476330484051968', 'photo2.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560403009537', '1186485806028599296', 'photo3.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:39', 'junAdmin', '2019-10-30 11:12:39', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560658862082', '1186485877780557824', 'pt.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560658862083', '1185476355318525952', 'photo4.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560675639297', '1186485877956718592', 'rec1.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560918908929', '1186485878103519232', 'rec2.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379560977629185', '1186485878392926208', 'rec3.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379561103458305', '1186485878644584448', 'rec5.png', 'image', '1189379575871602688', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:12:40', 'junAdmin', '2019-10-30 11:12:40', null);
INSERT INTO `sys_file_upload` VALUES ('1189379659594104833', '1187544427253731328', 'ic1.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379659736711169', '1187544153990631424', 'ic2.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379659791237121', '1187543637491453952', 'ic3.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379659833180161', '1187649879238307842', 'ic4.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379659967397889', '1187235222984744960', 'ic5.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660089032705', '1185476258174251008', 'photo1.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660101615617', '1185476330484051968', 'photo2.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660294553601', '1186485806028599296', 'photo3.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660411994113', '1186485877780557824', 'pt.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660416188417', '1185476355318525952', 'photo4.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660512657409', '1186485877956718592', 'rec1.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660625903617', '1186485878103519232', 'rec2.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379660751732737', '1186485878392926208', 'rec3.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379661015973888', '1189379660797870080', 'tx.png', 'image', '1189379677952573440', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:13:03', 'junAdmin', '2019-10-30 11:13:03', null);
INSERT INTO `sys_file_upload` VALUES ('1189379933838671872', '1189379933775757312', 'm1.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:08', 'junAdmin', '2019-10-30 11:14:08', null);
INSERT INTO `sys_file_upload` VALUES ('1189379933993861120', '1189379933947723776', 'm2.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934065164288', '1189379934019026944', 'm3.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934090330112', '1189379934060969984', 'm4.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934216159233', '1185476258174251008', 'photo1.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934337794048', '1185476330484051968', 'photo2.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934379737090', '1186485806028599296', 'photo3.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934476206081', '1185476355318525952', 'photo4.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189379934543314945', '1186485877780557824', 'pt.png', 'image', '1189379943716257792', 'album_img', '0', null, 'junAdmin', '2019-10-30 11:14:09', 'junAdmin', '2019-10-30 11:14:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189498006654406656', '1189498006339833856', 'cxa.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-10-30 19:03:19', 'junAdmin', '2019-10-30 19:03:19', null);
INSERT INTO `sys_file_upload` VALUES ('1189498076632174593', '1189498006339833856', 'cxa.jpg', 'image', '1184663166075936768', 'shopGoods_img', '0', null, 'junAdmin', '2019-10-30 19:03:36', 'junAdmin', '2019-10-30 19:03:36', null);
INSERT INTO `sys_file_upload` VALUES ('1189712962435047425', '1187544153990631424', 'ic2.png', 'image', '1189712961914953728', 'feedback_img', '0', null, null, '2019-10-31 09:17:29', null, '2019-10-31 09:17:29', null);
INSERT INTO `sys_file_upload` VALUES ('1189713321907871745', '1187235222984744960', 'ic5.png', 'image', '1189713321698156544', 'feedback_img', '0', null, null, '2019-10-31 09:18:54', null, '2019-10-31 09:18:54', null);
INSERT INTO `sys_file_upload` VALUES ('1189713382251323393', '1187543637491453952', 'ic3.png', 'image', '1189713381634760704', 'feedback_img', '0', null, null, '2019-10-31 09:19:09', null, '2019-10-31 09:19:09', null);
INSERT INTO `sys_file_upload` VALUES ('1189728014503030784', '1187543637491453952', 'ic3.png', 'image', null, null, '0', null, null, '2019-10-31 10:17:17', null, '2019-10-31 10:17:17', null);
INSERT INTO `sys_file_upload` VALUES ('1189769258344153089', '1187544427253731328', 'ic1.png', 'image', '1189769257866002432', 'growup_img', '0', null, null, '2019-10-31 13:01:11', null, '2019-10-31 13:01:11', null);
INSERT INTO `sys_file_upload` VALUES ('1189773065396453377', '1187544427253731328', 'ic1.png', 'image', '1189773065165766656', 'growup_img', '0', null, null, '2019-10-31 13:16:18', null, '2019-10-31 13:16:18', null);
INSERT INTO `sys_file_upload` VALUES ('1190177882952826881', '1187649879238307842', 'ic4.png', 'image', null, null, '0', null, null, '2019-11-01 16:04:54', null, '2019-11-01 16:04:54', null);
INSERT INTO `sys_file_upload` VALUES ('1190185931102584833', '1187649879238307842', 'ic4.png', 'image', '1190185936244801536', 'articles_img', '0', null, 'junAdmin', '2019-11-01 16:36:53', 'junAdmin', '2019-11-01 16:36:53', null);
INSERT INTO `sys_file_upload` VALUES ('1190192489417101312', '1190192489215774720', 'add_img2.png', 'image', null, null, '0', null, 'junAdmin', '2019-11-01 17:02:57', 'junAdmin', '2019-11-01 17:02:57', null);
INSERT INTO `sys_file_upload` VALUES ('1190192543267770369', '1190192489215774720', 'add_img2.png', 'image', '1190192547684372480', 'album_img', '0', null, 'junAdmin', '2019-11-01 17:03:10', 'junAdmin', '2019-11-01 17:03:10', null);
INSERT INTO `sys_file_upload` VALUES ('1190193455973486593', '1187649879238307842', 'ic4.png', 'image', '1190193461241532416', 'album_img', '0', null, 'junAdmin', '2019-11-01 17:06:47', 'junAdmin', '2019-11-01 17:06:47', null);
INSERT INTO `sys_file_upload` VALUES ('1190194913607372801', '1187237713569411072', 'card1.png', 'image', null, null, '0', null, null, '2019-11-01 17:12:35', null, '2019-11-01 17:12:35', null);
INSERT INTO `sys_file_upload` VALUES ('1190430100208914433', '1187544427253731328', 'ic1.png', 'image', '1190430078645997568', 'growup_img', '0', null, null, '2019-11-02 08:47:08', null, '2019-11-02 08:47:08', null);
INSERT INTO `sys_file_upload` VALUES ('1190430186301198337', '1187544153990631424', 'ic2.png', 'image', '1190430186087288832', 'growup_img', '0', null, null, '2019-11-02 08:47:28', null, '2019-11-02 08:47:28', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653793464321', '1187237713569411072', 'card1.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:16', null, '2019-11-02 08:57:16', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653843795969', '1186486472239263744', 'about2.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653910904833', '1186837673102409728', 'act_img.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653957042177', '1186486537116758016', 'about4.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653986402304', '1186486502371143680', 'about3.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432653990596609', '1186837673102409728', 'act_img.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432654133202945', '1186486502371143680', 'about3.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432654158368768', '1190432653759909888', 'add_img.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190432654162563073', '1186486537116758016', 'about4.png', 'image', '1190432653403394048', 'growup_img', '0', null, null, '2019-11-02 08:57:17', null, '2019-11-02 08:57:17', null);
INSERT INTO `sys_file_upload` VALUES ('1190433135052099585', '1186485806028599296', 'photo3.png', 'image', '1190433134750109696', 'growup_img', '0', null, null, '2019-11-02 08:59:11', null, '2019-11-02 08:59:11', null);
INSERT INTO `sys_file_upload` VALUES ('1190433135068876801', '1185476330484051968', 'photo2.png', 'image', '1190433134750109696', 'growup_img', '0', null, null, '2019-11-02 08:59:11', null, '2019-11-02 08:59:11', null);
INSERT INTO `sys_file_upload` VALUES ('1190433135123402754', '1185476355318525952', 'photo4.png', 'image', '1190433134750109696', 'growup_img', '0', null, null, '2019-11-02 08:59:11', null, '2019-11-02 08:59:11', null);
INSERT INTO `sys_file_upload` VALUES ('1190433135123402755', '1185476258174251008', 'photo1.png', 'image', '1190433134750109696', 'growup_img', '0', null, null, '2019-11-02 08:59:11', null, '2019-11-02 08:59:11', null);
INSERT INTO `sys_file_upload` VALUES ('1190468442846359553', '1186486537116758016', 'about4.png', 'image', '1190468442389180416', 'feedback_img', '0', null, null, '2019-11-02 11:19:29', null, '2019-11-02 11:19:29', null);
INSERT INTO `sys_file_upload` VALUES ('1190469371857354752', '1186486537116758016', 'about4.png', 'image', '1190469371555364864', 'growup_img', '0', null, null, '2019-11-02 11:23:11', null, '2019-11-02 11:23:11', null);
INSERT INTO `sys_file_upload` VALUES ('1190469449951100929', '1187237713569411072', 'card1.png', 'image', '1190469449846243328', 'growup_img', '0', null, null, '2019-11-02 11:23:29', null, '2019-11-02 11:23:29', null);
INSERT INTO `sys_file_upload` VALUES ('1190469486902919169', '1186837673102409728', 'act_img.png', 'image', '1190469486781284352', 'growup_img', '0', null, null, '2019-11-02 11:23:38', null, '2019-11-02 11:23:38', null);
INSERT INTO `sys_file_upload` VALUES ('1191177072146518016', '1191177071274102784', 'Lighthouse.jpg', 'image', '1191177074818289664', 'shopGoods_img', '0', null, 'zhao_I95W', '2019-11-04 10:15:20', 'zhao_I95W', '2019-11-04 10:15:20', null);
INSERT INTO `sys_file_upload` VALUES ('1191177320763887616', '1191177320671612928', 'e9404966d01609246d3e0711db0735fae7cd34da.jpg', 'image', '1191177325104992256', 'shopGoods_img', '0', null, 'zhao_I95W', '2019-11-04 10:16:19', 'zhao_I95W', '2019-11-04 10:16:19', null);
INSERT INTO `sys_file_upload` VALUES ('1191177493254639616', '1191177493183336448', 'et2.jpg', 'image', '1191177497335697408', 'gift_img', '0', null, 'zhao_I95W', '2019-11-04 10:17:00', 'zhao_I95W', '2019-11-04 10:17:00', null);
INSERT INTO `sys_file_upload` VALUES ('1191177604739239937', '1191177071274102784', 'Lighthouse.jpg', 'image', '1191177608874823680', 'mobile_setting_img', '0', null, 'zhao_I95W', '2019-11-04 10:17:27', 'zhao_I95W', '2019-11-04 10:17:27', null);
INSERT INTO `sys_file_upload` VALUES ('1191177673488076801', '1186144836116033537', 'Hydrangeas.jpg', 'image', '1191177681935405056', 'mobile_setting_img', '0', null, 'zhao_I95W', '2019-11-04 10:17:43', 'zhao_I95W', '2019-11-04 10:17:43', null);
INSERT INTO `sys_file_upload` VALUES ('1191180347266244609', '1186148784568455168', 'Koala.jpg', 'image', '1191180369210843136', 'album_img', '0', null, 'zhao_I95W', '2019-11-04 10:28:21', 'zhao_I95W', '2019-11-04 10:28:21', null);
INSERT INTO `sys_file_upload` VALUES ('1191181869567909889', '1186114440771538944', 'Jellyfish.jpg', 'image', null, null, '0', null, 'zhao_I95W', '2019-11-04 10:34:23', 'zhao_I95W', '2019-11-04 10:34:23', null);
INSERT INTO `sys_file_upload` VALUES ('1191182954273644545', '1186144836116033537', 'Hydrangeas.jpg', 'image', '1191182957004136448', 'member_head_img', '0', null, 'zhao_I95W', '2019-11-04 10:38:42', 'zhao_I95W', '2019-11-04 10:38:42', null);
INSERT INTO `sys_file_upload` VALUES ('1191186560727179265', '1191177071274102784', 'Lighthouse.jpg', 'image', '1191186609288830976', 'activity_img', '0', null, 'zhao_I95W', '2019-11-04 10:53:02', 'zhao_I95W', '2019-11-04 10:53:02', null);
INSERT INTO `sys_file_upload` VALUES ('1191186699978072065', '1186114440771538944', 'Jellyfish.jpg', 'image', '1191186775098056704', 'activity_img', '0', null, 'zhao_I95W', '2019-11-04 10:53:35', 'zhao_I95W', '2019-11-04 10:53:35', null);
INSERT INTO `sys_file_upload` VALUES ('1191187354180444161', '1186114440771538944', 'Jellyfish.jpg', 'image', '1191187357569441792', 'articles_img', '0', null, 'zhao_I95W', '2019-11-04 10:56:11', 'zhao_I95W', '2019-11-04 10:56:11', null);
INSERT INTO `sys_file_upload` VALUES ('1191598955222052864', '1191598954592907264', 'Tulips.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-11-05 14:11:44', 'junAdmin', '2019-11-05 14:11:44', null);
INSERT INTO `sys_file_upload` VALUES ('1191599166132629504', '1191599166031966208', 'Hydrangeas - 副本.jpg', 'image', '1191599250740129792', 'activity_img', '0', null, 'junAdmin', '2019-11-05 14:12:35', 'junAdmin', '2019-11-05 14:12:35', null);
INSERT INTO `sys_file_upload` VALUES ('1191907828829904897', '1191177320671612928', 'e9404966d01609246d3e0711db0735fae7cd34da.jpg', 'image', '1191907930386587648', 'activity_img', '0', null, 'junAdmin', '2019-11-06 10:39:06', 'junAdmin', '2019-11-06 10:39:06', null);
INSERT INTO `sys_file_upload` VALUES ('1191911451134668800', '1191911449658273792', 'et0.jpg', 'image', '1191911504658182144', 'activity_img', '0', null, 'junAdmin', '2019-11-06 10:53:29', 'junAdmin', '2019-11-06 10:53:29', null);
INSERT INTO `sys_file_upload` VALUES ('1191976086325878785', '1186144836116033538', 'Desert.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-11-06 15:10:19', 'junAdmin', '2019-11-06 15:10:19', null);
INSERT INTO `sys_file_upload` VALUES ('1192341832556150785', '1191177071274102784', 'Lighthouse.jpg', 'image', null, null, '0', null, 'junAdmin', '2019-11-07 15:23:40', 'junAdmin', '2019-11-07 15:23:40', null);
INSERT INTO `sys_file_upload` VALUES ('1192356959590461441', '1186148784568455168', 'Koala.jpg', 'image', '1192357026762240000', 'activity_img', '0', null, 'junAdmin', '2019-11-07 16:23:47', 'junAdmin', '2019-11-07 16:23:47', null);
INSERT INTO `sys_file_upload` VALUES ('1192965542969724928', '1192965542676123648', '1173511379939405824.png', 'image', '1192965666336788480', 'activity_img', '0', null, 'cheng_4KGX', '2019-11-09 08:42:04', 'cheng_4KGX', '2019-11-09 08:42:04', null);
INSERT INTO `sys_file_upload` VALUES ('1193049651844702208', '1187290342987247616', 'Chrysanthemum.jpg', 'image', null, null, '0', null, 'cheng_4KGX', '2019-11-09 14:16:17', 'cheng_4KGX', '2019-11-09 14:16:17', null);
INSERT INTO `sys_file_upload` VALUES ('1193050482455289857', '1187290342987247616', 'Chrysanthemum.jpg', 'image', '1193050546166767616', 'activity_img', '0', null, 'cheng_4KGX', '2019-11-09 14:19:35', 'cheng_4KGX', '2019-11-09 14:19:35', null);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `log_type` varchar(50) NOT NULL COMMENT '日志类型',
  `log_title` varchar(500) NOT NULL COMMENT '日志标题',
  `create_id` varchar(64) NOT NULL DEFAULT '' COMMENT '创建者',
  `create_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `request_uri` varchar(500) DEFAULT NULL COMMENT '请求URI',
  `request_method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `request_params` longtext COMMENT '操作提交的数据',
  `biz_id` varchar(64) DEFAULT NULL COMMENT '业务主键',
  `biz_type` varchar(64) DEFAULT NULL COMMENT '业务类型',
  `server_addr` varchar(255) NOT NULL COMMENT '请求服务器地址',
  `is_exception` char(1) DEFAULT NULL COMMENT '是否异常',
  `exception` text COMMENT '异常信息',
  `user_id` varchar(255) NOT NULL COMMENT '操作IP地址',
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户代理',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称/操作系统',
  `browser_name` varchar(100) DEFAULT NULL COMMENT '浏览器名称',
  `run_time` decimal(19,0) DEFAULT NULL COMMENT '执行时间',
  PRIMARY KEY (`id`),
  KEY `idx_sys_log_cb` (`create_id`),
  KEY `idx_sys_log_lt` (`log_type`),
  KEY `idx_sys_log_bk` (`biz_id`),
  KEY `idx_sys_log_bt` (`biz_type`),
  KEY `idx_sys_log_ie` (`is_exception`),
  KEY `idx_sys_log_cd` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL COMMENT '菜单id',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '所有父级编号',
  `tree_sort` decimal(10,0) DEFAULT NULL COMMENT '本级排序号（升序）',
  `tree_sorts` varchar(1000) DEFAULT NULL COMMENT '所有级别排序号',
  `tree_leaf` char(1) DEFAULT NULL COMMENT '是否最末级',
  `tree_level` decimal(4,0) DEFAULT NULL COMMENT '层次级别',
  `tree_names` varchar(1000) DEFAULT NULL COMMENT '全节点名',
  `is_sys` char(1) DEFAULT NULL COMMENT '系统菜单（1是、0否）',
  `name` varchar(20) DEFAULT NULL COMMENT '菜单名称',
  `type` enum('menu','button') DEFAULT NULL COMMENT '菜单类型 [menu|button]',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `img` varchar(255) DEFAULT NULL COMMENT '图片',
  `imgs` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_menu_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('01', '0', '0,', '1', '00000001,', '0', '0', null, '0', '设置', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('0101', '01', '0,01,', '1', '00000001,00000001,', '0', '1', null, '0', '会员等级', 'menu', '/level', null, null, null);
INSERT INTO `sys_menu` VALUES ('010101', '0101', '0,01,0101,', '1', '00000001,00000001,00000001,', '1', '2', null, '0', '查看', 'button', '', 'member:level:view', '', '');
INSERT INTO `sys_menu` VALUES ('010102', '0101', '0,01,0101,', '2', '00000001,00000001,00000002,', '1', '2', '', '0', '编辑', 'button', '', 'member:level:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0102', '01', '0,01,', '2', '00000001,00000002,', '0', '1', '', '0', '会员卡类型', 'menu', '/cardsType', '', '', '');
INSERT INTO `sys_menu` VALUES ('010201', '0102', '0,01,0102,', '1', '00000001,00000002,00000001,', '1', '2', '', '0', '查看', 'button', '', 'company:cardsType:view', '', '');
INSERT INTO `sys_menu` VALUES ('010202', '0102', '0,01,0102,', '2', '00000001,00000002,00000002,', '1', '2', '', '0', '编辑', 'button', '', 'company:cardsType:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0103', '01', '0,01,', '2', '00000001,00000003,', '0', '1', null, '0', '会员卡设置', 'menu', '/cards', null, null, null);
INSERT INTO `sys_menu` VALUES ('010301', '0103', '0,01,0103,', '1', '00000001,00000003,00000001,', '1', '2', null, '0', '查看', 'button', '', 'company:cards:view', '', '');
INSERT INTO `sys_menu` VALUES ('010302', '0103', '0,01,0103,', '2', '00000001,00000003,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'company:cards:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0104', '01', '0,01,', '3', '00000001,00000004,', '0', '1', null, '0', '消费项目分类', 'menu', '/goodsType', null, null, null);
INSERT INTO `sys_menu` VALUES ('010401', '0104', '0,01,0104,', '1', '00000001,00000004,00000001,', '1', '2', null, '0', '查看', 'button', '', 'shop:goodsType:view', '', '');
INSERT INTO `sys_menu` VALUES ('010402', '0104', '0,01,0104,', '2', '00000001,00000004,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'shop:goodsType:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0105', '01', '0,01,', '4', '00000001,00000005,', '0', '1', null, '0', '消费项目', 'menu', '/goods', null, null, null);
INSERT INTO `sys_menu` VALUES ('010501', '0105', '0,01,0105,', '1', '00000001,00000005,00000001,', '1', '2', null, '0', '查看', 'button', '', 'shop:goods:view', '', '');
INSERT INTO `sys_menu` VALUES ('010502', '0105', '0,01,0105,', '2', '00000001,00000005,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'shop:goods:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0106', '01', '0,01,', '5', '00000001,00000006,', '0', '1', null, '0', '积分商品分类', 'menu', '/giftType', null, null, null);
INSERT INTO `sys_menu` VALUES ('010601', '0106', '0,01,0106,', '1', '00000001,00000006,00000001,', '1', '2', null, '0', '查看', 'button', '', 'shop:giftType:view', '', '');
INSERT INTO `sys_menu` VALUES ('010602', '0106', '0,01,0106,', '2', '00000001,00000006,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'shop:giftType:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0107', '01', '0,01,', '6', '00000001,00000007,', '0', '1', null, '0', '积分商品', 'menu', '/gift', null, null, null);
INSERT INTO `sys_menu` VALUES ('010701', '0107', '0,01,0107,', '1', '00000001,00000007,00000001,', '1', '2', null, '0', '查看', 'button', '', 'shop:gift:view', '', '');
INSERT INTO `sys_menu` VALUES ('010702', '0107', '0,01,0107,', '2', '00000001,00000007,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'shop:gift:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0108', '01', '0,01,', '7', '00000001,00000008,', '0', '1', 'null/官网设置', '0', '官网设置', 'menu', '/mobileSetting', null, null, null);
INSERT INTO `sys_menu` VALUES ('010801', '0108', '0,01,0108,', '1', '00000001,00000008,00000001,', '1', '2', null, '0', '查看', 'button', '', 'company:mobileSetting:view', '', '');
INSERT INTO `sys_menu` VALUES ('010802', '0108', '0,01,0108,', '2', '00000001,00000008,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'company:mobileSetting:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0109', '01', '0,01,', '8', '00000001,00000009,', '0', '1', 'null/基础设置', '0', '基础设置', 'menu', '/comConfig', null, null, null);
INSERT INTO `sys_menu` VALUES ('010901', '0109', '0,01,0109,', '1', '00000001,00000009,00000001,', '1', '2', null, '0', '查看', 'button', null, 'company:comConfig:view', null, null);
INSERT INTO `sys_menu` VALUES ('010902', '0109', '0,01,0109,', '2', '00000001,00000009,00000002,', '1', '2', null, '0', '编辑', 'button', null, 'company:comConfig:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0110', '01', '0,01,', '9', '00000001,00000010,', '0', '1', null, '0', '提成设置', 'menu', '/staffMoneySetting', null, null, null);
INSERT INTO `sys_menu` VALUES ('011001', '0110', '0,01,0110,', '1', '00000001,00000010,00000001,', '1', '2', null, '0', '查看', 'button', null, 'company:staffMoneySetting:view', null, null);
INSERT INTO `sys_menu` VALUES ('011002', '0110', '0,01,0110,', '2', '00000001,00000010,00000002,', '1', '2', null, '0', '编辑', 'button', null, 'company:staffMoneySetting:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0111', '01', '0,01,', '10', '00000001,00000011,', '0', '1', null, '0', '通知设置', 'menu', '/staffNoticeSetting', null, null, null);
INSERT INTO `sys_menu` VALUES ('011101', '0111', '0,01,0111,', '1', '00000001,00000011,00000001,', '1', '2', null, '0', '查看', 'button', null, 'company:staffNoticeSetting:view', null, null);
INSERT INTO `sys_menu` VALUES ('011102', '0111', '0,01,0111,', '2', '00000001,00000011,00000002,', '1', '2', null, '0', '编辑', 'button', null, 'company:staffNoticeSetting:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0112', '01', '0,01,', '11', '00000001,00000012,', '0', '1', null, '0', '相册管理', 'menu', '/album', null, null, null);
INSERT INTO `sys_menu` VALUES ('011201', '0112', '0,01,0112,', '1', '00000001,00000012,', '1', '2', null, '0', '查看', 'button', null, 'company:album:view', null, null);
INSERT INTO `sys_menu` VALUES ('011202', '0112', '0,01,0112,', '2', '00000001,00000012,', '1', '2', null, '0', '编辑', 'button', null, 'company:album:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0113', '01', '0,01,', '13', '00000001,00000013,', '0', '1', '', '0', '模板消息', 'menu', '/comTemplate', '', '', '');
INSERT INTO `sys_menu` VALUES ('011301', '0113', '0,01,0113,', '1', '00000001,00000013,', '1', '2', '', '0', '查看', 'button', '', 'company:comTemplate:view', '', '');
INSERT INTO `sys_menu` VALUES ('011302', '0113', '0,01,0113,', '2', '00000001,00000013,', '1', '2', '', '0', '编辑', 'button', '', 'company:comTemplate:edit', '', '');
INSERT INTO `sys_menu` VALUES ('02', '0', '0,', '2', '00000002,', '0', '0', null, '0', '运营', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('0201', '02', '0,02,', '1', '00000002,00000001,', '0', '1', null, '0', '会员管理', 'menu', '/member', null, null, null);
INSERT INTO `sys_menu` VALUES ('020101', '0201', '0,02,0201,', '1', '00000002,00000001,00000001,', '1', '2', null, '0', '查看', 'button', '', 'member:member:view', '', '');
INSERT INTO `sys_menu` VALUES ('020102', '0201', '0,02,0201,', '2', '00000002,00000001,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'member:member:edit', '', '');
INSERT INTO `sys_menu` VALUES ('020103', '0201', '0,02,0201,', '2', '00000002,00000001,00000003,', '1', '2', '', '0', '导出', 'button', '', 'member:member:export', '', '');
INSERT INTO `sys_menu` VALUES ('020104', '0201', '0,02,0201,', '2', '00000002,00000001,00000004,', '1', '2', '', '0', '导入', 'button', '', 'member:member:gets', '', '');
INSERT INTO `sys_menu` VALUES ('0202', '02', '0,02,', '2', '00000002,00000002,', '0', '1', '', '0', '会员积分', 'menu', '/memberPoints', '', '', '');
INSERT INTO `sys_menu` VALUES ('020201', '0202', '0,02,0202,', '1', '00000002,00000002,00000001,', '1', '2', '', '0', '查看', 'button', '', 'member:memberPoints:view', '', '');
INSERT INTO `sys_menu` VALUES ('020202', '0202', '0,02,0202,', '2', '00000002,00000002,00000002,', '1', '2', '', '0', '编辑', 'button', '', 'member:memberPoints:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0203', '02', '0,02,', '3', '00000002,00000003,', '0', '1', null, '0', '收银入账', 'menu', '/cashBuy', null, null, null);
INSERT INTO `sys_menu` VALUES ('020301', '0203', '0,02,0203,', '1', '00000002,00000003,00000001,', '1', '2', null, '0', '查看', 'button', '', 'cash:cashBuy:view', '', '');
INSERT INTO `sys_menu` VALUES ('020302', '0203', '0,02,0203,', '2', '00000002,00000003,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'cash:cashBuy:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0204', '02', '0,02,', '4', '00000002,00000004,', '0', '1', null, '0', '划卡消费', 'menu', '/card', null, null, null);
INSERT INTO `sys_menu` VALUES ('020401', '0204', '0,02,0204,', '1', '00000002,00000004,00000001,', '1', '2', null, '0', '查看', 'button', '', 'member:card:view', '', '');
INSERT INTO `sys_menu` VALUES ('020402', '0204', '0,02,0204,', '2', '00000002,00000004,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'member:card:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0205', '02', '0,02,', '5', '00000002,00000005,', '0', '1', null, '0', '账目明细', 'menu', '/cardChange', null, null, null);
INSERT INTO `sys_menu` VALUES ('020501', '0205', '0,02,0205,', '1', '00000002,00000005,00000001,', '1', '2', null, '0', '查看', 'button', '', 'member:cardChange:view', '', '');
INSERT INTO `sys_menu` VALUES ('020502', '0205', '0,02,0205,', '2', '00000002,00000005,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'member:cardChange:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0206', '02', '0,02,', '6', '00000002,00000006,', '0', '1', null, '0', '课程管理', 'menu', '/course', null, null, null);
INSERT INTO `sys_menu` VALUES ('020601', '0206', '0,02,0206,', '1', '00000002,00000006,00000001,', '1', '2', null, '0', '查看', 'button', '', 'company:course:view', '', '');
INSERT INTO `sys_menu` VALUES ('020602', '0206', '0,02,0206,', '2', '00000002,00000006,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'company:course:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0207', '02', '0,02,', '7', '00000002,00000007,', '0', '1', null, '0', '活动管理', 'menu', '/activity', null, null, null);
INSERT INTO `sys_menu` VALUES ('020701', '0207', '0,02,0207,', '1', '00000002,00000007,00000001,', '1', '2', null, '0', '查看', 'button', '', 'company:activity:view', '', '');
INSERT INTO `sys_menu` VALUES ('020702', '0207', '0,02,0207,', '2', '00000002,00000007,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'company:activity:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0208', '02', '0,02,', '8', '00000002,00000008,', '0', '1', null, '0', '请假管理', 'menu', '/leave', null, null, null);
INSERT INTO `sys_menu` VALUES ('020801', '0208', '0,02,0208,', '1', '00000002,00000008,00000001,', '1', '2', null, '0', '查看', 'button', '', 'company:leave:view', '', '');
INSERT INTO `sys_menu` VALUES ('020802', '0208', '0,02,0208,', '2', '00000002,00000008,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'company:leave:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0209', '02', '0,02,', '8', '00000002,00000009,', '0', '1', null, '0', '反馈留言', 'menu', '/feedback', null, null, null);
INSERT INTO `sys_menu` VALUES ('020901', '0209', '0,02,0209,', '1', '00000002,00000009,', '1', '2', null, '0', '查看', 'button', null, 'company:feedback:view', null, null);
INSERT INTO `sys_menu` VALUES ('020902', '0209', '0,02,0209,', '2', '00000002,00000009,', '1', '2', null, '0', '编辑', 'button', null, 'company:feedback:edit', null, null);
INSERT INTO `sys_menu` VALUES ('03', '0', '0,', '3', '00000003,', '0', '0', null, '0', '导购管理', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('0301', '03', '0,03,', '1', '00000003,00000001,', '1', '1', null, '0', '导购管理', 'menu', '/saleUser', null, null, null);
INSERT INTO `sys_menu` VALUES ('030101', '0301', '0,03,0301,', '1', '00000003,00000001,00000001,', '1', '2', '', '0', '查看', 'button', '', 'sale:saleUser:view', '', '');
INSERT INTO `sys_menu` VALUES ('030102', '0301', '0,03,0301,', '2', '00000003,00000001,00000002,', '1', '2', '', '0', '编辑', 'button', '', 'sale:saleUser:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0302', '03', '0,03,', '2', '00000003,00000002,', '0', '1', null, '0', '导购团队', 'menu', '/saleTeam', null, null, null);
INSERT INTO `sys_menu` VALUES ('030201', '0302', '0,03,0302,', '1', '00000003,00000002,00000001,', '1', '2', '', '0', '查看', 'button', '', 'sale:saleTeam:view', '', '');
INSERT INTO `sys_menu` VALUES ('030202', '0302', '0,03,0302,', '2', '00000003,00000002,00000002,', '1', '2', null, '0', '编辑', 'button', '', 'sale:saleTeam:edit', '', '');
INSERT INTO `sys_menu` VALUES ('0303', '03', '0,03,', '3', '00000003,00000003,', '0', '1', null, '0', '导购客户', 'menu', '/saleMember', null, null, null);
INSERT INTO `sys_menu` VALUES ('030301', '0303', '0,03,0303,', '1', '00000003,00000003,00000001,', '1', '2', null, '0', '查看', 'button', null, 'sale:saleMember:view', null, null);
INSERT INTO `sys_menu` VALUES ('030302', '0303', '0,03,0303,', '2', '00000003,00000003,00000002,', '1', '2', null, '0', '编辑', 'button', null, 'sale:saleMember:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0304', '03', '0,03,', '4', '00000003,00000004,', '1', '1', '', '0', '导购业绩', 'menu', '/salePerformance', '', '', '');
INSERT INTO `sys_menu` VALUES ('030401', '0304', '0,03,0304,', '1', '00000003,00000004,00000001,', '1', '2', '', '0', '查看', 'button', '', 'sale:salePerformance:view', '', '');
INSERT INTO `sys_menu` VALUES ('030402', '0304', '0,03,0304,', '2', '00000003,00000004,00000002,', '1', '2', '', '0', '编辑', 'button', '', 'sale:saleMember:edit', '', '');
INSERT INTO `sys_menu` VALUES ('04', '0', '0,', '100', '00000100,', '0', '0', '库存管理', '0', '库存管理', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('0401', '04', '0,04,', '1', '00000100,00000001', '0', '1', '库存管理/库存查询', '0', '库存查询', 'menu', '/stock', null, null, null);
INSERT INTO `sys_menu` VALUES ('040101', '0401', '0,04,0401,', '1', '00000100,0000000100000001', '1', '2', '库存管理/库存查询/查看', '0', '查看', 'menu', null, 'stock:stock:view', null, null);
INSERT INTO `sys_menu` VALUES ('040102', '0401', '0,04,0401,', '2', '00000100,0000000100000002', '1', '2', '库存管理/库存查询/编辑', '0', '编辑', 'menu', null, 'stock:stock:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0402', '04', '0,04,', '2', '00000100,00000002', '0', '1', '库存管理/出入库记录', '0', '出入库记录', 'menu', '/stockRecord', null, null, null);
INSERT INTO `sys_menu` VALUES ('040201', '0402', '0,04,0402,', '1', '00000100,0000000200000001', '1', '2', '库存管理/出入库记录/查看', '0', '查看', 'menu', null, 'stock:stockRecord:view', null, null);
INSERT INTO `sys_menu` VALUES ('040202', '0402', '0,04,0402,', '2', '00000100,0000000200000002', '1', '2', '库存管理/出入库记录/编辑', '0', '编辑', 'menu', null, 'stock:stockRecord:edit', null, null);
INSERT INTO `sys_menu` VALUES ('05', '0', '0,', '5', '00000005,', null, '0', null, '0', '文章管理', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('0501', '05', '0,05,', '1', '00000005,', null, '1', null, '0', '栏目管理', 'menu', '/arttype', null, null, null);
INSERT INTO `sys_menu` VALUES ('050101', '0501', '0,05,0501,', '1', '00000005,', null, '2', null, '0', '查看', 'button', null, 'cms:arttype:view', null, null);
INSERT INTO `sys_menu` VALUES ('050102', '0501', '0,05,0501,', '2', '00000005,', null, '2', null, '0', '编辑', 'button', null, 'cms:arttype:edit', null, null);
INSERT INTO `sys_menu` VALUES ('0502', '05', '0,05,', '2', '00000005,', null, '1', null, '0', '文章管理', 'menu', '/articles', null, null, null);
INSERT INTO `sys_menu` VALUES ('050201', '0502', '0,05,0502,', '1', '00000005,', null, '2', null, '0', '查看', 'button', null, 'cms:articles:view', null, null);
INSERT INTO `sys_menu` VALUES ('050202', '0502', '0,05,0502,', '2', '00000005,', null, '2', null, '0', '编辑', 'button', null, 'cms:articles:edit', null, null);
INSERT INTO `sys_menu` VALUES ('80', '0', '0,', '80', '00000080,', '0', '0', null, '0', '统计', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('8007', '80', '0,80,', '7', '00000080,00000007,', '1', '1', '', '0', '我的统计', 'menu', '/statistics/myStatistics', null, '', '');
INSERT INTO `sys_menu` VALUES ('8008', '80', '0,80,', '8', '00000080,00000008,', '1', '1', '', '0', '管理员统计', 'menu', '/statistics/adminStatistics', null, '', '');
INSERT INTO `sys_menu` VALUES ('8009', '80', '0,80,', '9', '00000080,00000009,', '1', '1', '', '0', '每日统计', 'menu', '/statistics/dayStatistics', null, '', '');
INSERT INTO `sys_menu` VALUES ('90', '0', '0,', '90', '00000090,', '0', '0', null, '1', '用户管理', 'menu', '', null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('9001', '90', '0,90,', '1', '00000090,00000001,', '1', '1', null, '1', '角色管理', 'menu', '/sysRole', null, null, null);
INSERT INTO `sys_menu` VALUES ('900101', '9001', '0,90,9001,', '1', '00000090,00000001,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysRole:view', '', '');
INSERT INTO `sys_menu` VALUES ('900102', '9001', '0,90,9001,', '2', '00000090,00000001,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:sysRole:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9002', '90', '0,90,', '2', '00000090,00000002,', '1', '1', null, '1', '用户管理', 'menu', '/staffUser', null, null, null);
INSERT INTO `sys_menu` VALUES ('900201', '9002', '0,90,9002,', '1', '00000090,00000002,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:staffUser:view', '', '');
INSERT INTO `sys_menu` VALUES ('900202', '9002', '0,90,9002,', '2', '00000090,00000002,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:staffUser:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9004', '90', '0,90,', '4', '00000090,00000004,', '1', '1', null, '1', '企业管理员', 'menu', '/sysUser', null, null, null);
INSERT INTO `sys_menu` VALUES ('900401', '9004', '0,90,9004,', '1', '00000090,00000004,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysUser:view', '', '');
INSERT INTO `sys_menu` VALUES ('900402', '9004', '0,90,9004,', '2', '00000090,00000004,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:sysUser:edit', '', '');
INSERT INTO `sys_menu` VALUES ('91', '0', '0,', '91', '00000091,', '0', '0', null, '1', '企业管理', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('9101', '91', '0,91,', '1', '00000091,00000001,', '1', '1', null, '1', '企业管理', 'menu', '/sysCompany', null, null, null);
INSERT INTO `sys_menu` VALUES ('910101', '9101', '0,91,9101,', '1', '00000091,00000001,00000001,', '1', '2', '', '1', '查看', 'button', null, 'sys:sysCompany:view', '', '');
INSERT INTO `sys_menu` VALUES ('910102', '9101', '0,91,9101,', '2', '00000091,00000001,00000002,', '1', '2', '', '1', '编辑', 'button', null, 'sys:sysCompany:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9102', '91', '0,91,', '2', '00000091,00000002,', '1', '1', null, '1', '订单管理', 'menu', '/sysComOrders', null, null, null);
INSERT INTO `sys_menu` VALUES ('910201', '9102', '0,91,9102,', '1', '00000091,00000002,00000001,', '1', '2', '', '1', '查看', 'button', null, 'sys:sysComOrders:view', '', '');
INSERT INTO `sys_menu` VALUES ('910202', '9102', '0,91,9102,', '2', '00000091,00000002,00000002,', '1', '2', '', '1', '编辑', 'button', null, 'sys:sysComOrders:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9103', '91', '0,91,', '3', '00000091,00000003,', '1', '1', null, '1', '产品状态', 'menu', '/sysComProduct', null, null, null);
INSERT INTO `sys_menu` VALUES ('910301', '9103', '0,91,9103,', '1', '00000091,00000003,00000001,', '1', '2', '', '1', '查看', 'button', null, 'sys:sysComProduct:view', '', '');
INSERT INTO `sys_menu` VALUES ('910302', '9103', '0,91,9103,', '2', '00000091,00000003,00000002,', '1', '2', '', '1', '编辑', 'button', null, 'sys:sysComProduct:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9104', '91', '0,91,', '4', '00000091,00000004,', '1', '1', null, '1', '产品管理', 'menu', '/sysProduct', null, null, null);
INSERT INTO `sys_menu` VALUES ('910401', '9104', '0,91,9104,', '1', '00000091,00000004,00000001,', '1', '2', '', '1', '查看', 'button', null, 'sys:sysProduct:view', '', '');
INSERT INTO `sys_menu` VALUES ('910402', '9104', '0,91,9104,', '2', '00000091,00000004,00000002,', '1', '2', '', '1', '编辑', 'button', null, 'sys:sysProduct:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9105', '91', '0,91,', '4', '00000091,00000005,', '1', '1', '', '1', '公众号管理', 'menu', '/wxConfig', '', '', '');
INSERT INTO `sys_menu` VALUES ('910501', '9105', '0,91,9105,', '1', '00000091,00000005,00000001,', '1', '2', '', '1', '查看', 'button', '', 'weixin:wxConfig:view', '', '');
INSERT INTO `sys_menu` VALUES ('910502', '9105', '0,91,9105,', '2', '00000091,00000005,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'weixin:wxConfig:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9106', '91', '0,91,', '1', '00000091,00000006,', '1', '1', '', '1', '消息管理', 'menu', '/sysComMsg', '', '', '');
INSERT INTO `sys_menu` VALUES ('910601', '9106', '0,91,9106,', '1', '00000091,00000006,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysComMsg:view', '', '');
INSERT INTO `sys_menu` VALUES ('910602', '9106', '0,91,9106,', '2', '00000091,00000006,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:sysComMsg:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9107', '91', '0,91,', '1', '00000091,00000007,', '1', '1', '', '1', '我的消息', 'menu', '/sysComMsgRecord', '', '', '');
INSERT INTO `sys_menu` VALUES ('910701', '9107', '0,91,9107,', '1', '00000091,00000007,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysComMsgRecord:view', '', '');
INSERT INTO `sys_menu` VALUES ('910702', '9107', '0,91,9107,', '2', '00000091,00000007,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:sysComMsgRecord:edit', '', '');
INSERT INTO `sys_menu` VALUES ('92', '0', '0,', '92', '00000092,', '0', '0', null, '1', '系统设置', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('9201', '92', '0,92,', '1', '00000092,00000001,', '0', '1', null, '1', '菜单管理', 'menu', '/sysMenu', null, null, null);
INSERT INTO `sys_menu` VALUES ('920101', '9201', '0,92,9201,', '1', '00000092,00000001,00000001,', '1', '2', null, '1', '查看', 'button', null, 'sys:sysMenu:view', null, null);
INSERT INTO `sys_menu` VALUES ('920102', '9201', '0,92,9201,', '2', '00000092,00000001,00000002,', '1', '2', null, '1', '编辑', 'button', null, 'sys:sysMenu:edit', null, null);
INSERT INTO `sys_menu` VALUES ('9202', '92', '0,92,', '2', '00000092,00000002,', '0', '1', null, '1', '参数设置', 'menu', '/sysConfig', null, null, null);
INSERT INTO `sys_menu` VALUES ('920201', '9202', '0,92,9202,', '1', '00000092,00000002,00000001,', '1', '2', null, '1', '查看', 'button', null, 'sys:sysConfig:view', null, null);
INSERT INTO `sys_menu` VALUES ('920202', '9202', '0,92,9202,', '2', '00000092,00000002,00000002,', '1', '2', null, '1', '编辑', 'button', null, 'sys:sysConfig:edit', null, null);
INSERT INTO `sys_menu` VALUES ('9203', '92', '0,92,', '3', '00000092,00000003,', '0', '1', null, '1', '字典管理', 'menu', '/sysBeanType', null, null, null);
INSERT INTO `sys_menu` VALUES ('920301', '9203', '0,92,9203,', '1', '00000092,00000003,00000001,', '1', '2', '', '1', '查看', 'button', null, 'sys:sysBeanType:view', '', '');
INSERT INTO `sys_menu` VALUES ('920302', '9203', '0,92,9203,', '2', '00000092,00000003,00000002,', '1', '2', '', '1', '编辑', 'button', null, 'sys:sysBeanType:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9204', '92', '0,92,', '4', '00000092,00000004,', '0', '1', null, '1', '行政区管理', 'menu', '/sysArea', null, null, null);
INSERT INTO `sys_menu` VALUES ('920401', '9204', '0,92,9204,', '1', '00000092,00000004,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysArea:view', '', '');
INSERT INTO `sys_menu` VALUES ('920402', '9204', '0,92,9204,', '2', '00000092,00000004,00000002,', '1', '2', '', '1', '编辑', 'button', '', 'sys:sysArea:edit', '', '');
INSERT INTO `sys_menu` VALUES ('9205', '92', '0,92,', '5', '00000092,00000005,', '0', '1', '', '1', '模板消息', 'menu', '/sysTemplate', '', '', '');
INSERT INTO `sys_menu` VALUES ('920501', '9205', '0,92,9205,', '1', '00000092,00000005,00000001,', '1', '2', '', '1', '查看', 'button', '', 'sys:sysTemplate:view', '', '');
INSERT INTO `sys_menu` VALUES ('920502', '9205', '0,92,9205,', '2', '00000092,00000005,00000002,', '1', '2', null, '1', '编辑', 'button', null, 'sys:sysTemplate:edit', null, null);
INSERT INTO `sys_menu` VALUES ('93', '0', '0,', '93', '00000093,', '0', '0', null, '1', '系统监控', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('9301', '93', '0,93,', '1', '00000093,00000001,', '0', '1', null, '1', '系统日志', 'menu', '/sysLog', null, null, null);
INSERT INTO `sys_menu` VALUES ('930101', '9301', '0,93,9301,', '1', '00000093,00000001,00000001,', '1', '2', null, '1', '查看', 'button', '', 'sys:sysLog:view', '', '');
INSERT INTO `sys_menu` VALUES ('9302', '93', '0,93,', '2', '00000093,00000002,', '1', '1', null, '1', '缓存管理', 'menu', '/sysCache', null, null, null);
INSERT INTO `sys_menu` VALUES ('99', '0', '0,', '99', '00000099,', '0', '0', null, '1', '参考示例', 'menu', null, null, 'static/module/base/icon/xitong1.png', 'static/module/base/icon/xitong.png');
INSERT INTO `sys_menu` VALUES ('9901', '99', '0,99,', '1', '00000099,00000001,', '0', '1', null, '1', '增删改查', 'menu', '/demoBase', null, null, null);
INSERT INTO `sys_menu` VALUES ('990101', '9901', '0,99,9901,', '1', '00000099,00000001,00000001,', '1', '2', null, '1', '查看', 'button', null, 'demo:demoBase:view', null, null);
INSERT INTO `sys_menu` VALUES ('990102', '9901', '0,99,9901,', '2', '00000099,00000001,00000002,', '1', '2', null, '1', '编辑', 'button', null, 'demo:demoBase:edit', null, null);
INSERT INTO `sys_menu` VALUES ('9902', '99', '0,99,', '2', '00000099,00000002,', '0', '1', null, '1', '树结构', 'menu', '/demoTree', null, '', '');
INSERT INTO `sys_menu` VALUES ('990201', '9902', '0,99,9902,', '1', '00000099,00000002,00000001,', '1', '2', null, '1', '查看', 'button', '', 'demo:demoTree:view', '', '');
INSERT INTO `sys_menu` VALUES ('990202', '9902', '0,99,9902,', '2', '00000099,00000002,00000002,', '1', '2', null, '1', '编辑', 'button', '', 'demo:demoTree:edit', '', '');

-- ----------------------------
-- Table structure for sys_pay
-- ----------------------------
DROP TABLE IF EXISTS `sys_pay`;
CREATE TABLE `sys_pay` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `pay_id` varchar(64) DEFAULT NULL,
  `wx_id` varchar(64) DEFAULT NULL,
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员ID',
  `pay_code` varchar(64) DEFAULT NULL COMMENT '支付单号',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '关联id',
  `biz_type` varchar(2) DEFAULT NULL COMMENT '关联类型(1储值储次、2活动)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `pay_status` int(1) DEFAULT NULL COMMENT '支付状态(1待支付、2已支付、3已退款)',
  `pay_type` varchar(2) DEFAULT NULL COMMENT '支付方式(1微信、2支付宝、3银联支付、4下线支付）',
  `pay_money` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`),
  KEY `opay_id` (`id`),
  KEY `opay_pid` (`biz_id`) USING BTREE,
  KEY `opay_payCode` (`pay_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付表';

-- ----------------------------
-- Records of sys_pay
-- ----------------------------
INSERT INTO `sys_pay` VALUES ('1189050011247370240', 'wx291325015692818e85b32d461046377000', null, '1181743349920227328', '02521d44cb30483f8565749e667541c6', '1182530217618563072', '1', '2019-10-29 13:23:09', '2019-10-29 13:23:09', '2', '1', '100.00', '2019-10-29 13:23:11');

-- ----------------------------
-- Table structure for sys_product
-- ----------------------------
DROP TABLE IF EXISTS `sys_product`;
CREATE TABLE `sys_product` (
  `id` varchar(32) NOT NULL COMMENT '产品ID',
  `name` varchar(30) DEFAULT NULL COMMENT '产品名称',
  `price` decimal(20,2) DEFAULT NULL COMMENT '销售价格',
  `days` int(11) DEFAULT NULL COMMENT '产品天数',
  `sort` int(11) DEFAULT '100' COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `content` varchar(500) DEFAULT NULL COMMENT '产品过期提醒',
  `status` char(1) DEFAULT '0' COMMENT '状态',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='平台产品';

-- ----------------------------
-- Records of sys_product
-- ----------------------------
INSERT INTO `sys_product` VALUES ('1177391566166163456', '尖叫', '4.00', '8', '1', null, null, '0', '1', '2019-09-27 09:16:39', 'junAdmin', '2019-09-27 16:53:37');
INSERT INTO `sys_product` VALUES ('1177487068894244864', 'k20 pro', '2099.00', '7', '22', null, null, '0', '1', '2019-09-27 15:36:09', 'junAdmin', '2019-09-27 16:54:16');
INSERT INTO `sys_product` VALUES ('1177499238326124544', 'iPhone11', '5999.00', '6', '66', null, null, '0', '1', '2019-09-27 16:24:30', 'junAdmin', '2019-09-28 09:42:25');
INSERT INTO `sys_product` VALUES ('1177781022205571072', '11111', '11.00', '5', '1111', null, null, '0', '1', '2019-09-28 11:04:12', 'junAdmin', '2019-09-28 11:04:12');
INSERT INTO `sys_product` VALUES ('1177781961280876544', '22', '22.00', '4', '22', null, null, '0', '1', '2019-09-28 11:07:56', 'junAdmin', '2019-09-28 11:07:56');
INSERT INTO `sys_product` VALUES ('1178204292746108928', '00', '0.00', '3', '0', null, null, '0', '1', '2019-09-29 15:06:08', 'junAdmin', '2019-09-29 15:06:08');
INSERT INTO `sys_product` VALUES ('1183231342462513152', '毛巾', '1.00', '2', '1', null, null, '0', 'junAdmin', '2019-10-13 12:01:50', 'junAdmin', '2019-10-13 12:01:50');
INSERT INTO `sys_product` VALUES ('1183232183269470208', '香皂', '1.00', '1', '1', '1', null, '0', 'junAdmin', '2019-10-13 12:05:11', 'junAdmin', '2019-10-15 11:03:41');
INSERT INTO `sys_product` VALUES ('1184769149461422080', '123', '12.00', '3123', '123', '123', null, '0', null, null, 'junAdmin', '2019-10-17 17:52:32');
INSERT INTO `sys_product` VALUES ('1185445344650436608', '123', '123.00', '123', '1', '', null, '0', null, null, 'junAdmin', '2019-11-11 15:57:21');
INSERT INTO `sys_product` VALUES ('1185446689793708032', '小米', '10.00', '1', '11', '产品:小米  将在:2019-11-06  过期请及时续费!', '产品:(name)  将在:(date)  过期请及时续费!', '0', null, null, 'junAdmin', '2019-11-14 16:45:11');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(32) NOT NULL COMMENT '角色ID',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `menus` longtext COMMENT '系统菜单',
  `is_sys` char(1) DEFAULT NULL COMMENT '系统角色（1是、0否）',
  `user_type` varchar(20) DEFAULT NULL COMMENT '用户类型',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、8停用、9删除）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_role_id` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('11', 'wangxi', '11', null, '0', 'staff', '0', null, 'wangxi_DOUW', '2019-10-17 15:23:58', 'wangxi_DOUW', '2019-10-17 15:23:58');
INSERT INTO `sys_role` VALUES ('111', '0', '老师', '91,9107,910701,910702', '0', 'staff', '0', '', 'junAdmin', '2019-10-17 15:55:50', 'junAdmin', '2019-10-21 06:48:27');
INSERT INTO `sys_role` VALUES ('1184738476647448576', 'ali', '导购角色', null, '0', 'sale', '8', null, 'aliali_PRJT', '2019-10-17 15:50:39', 'aliali_PRJT', '2019-10-17 15:50:39');
INSERT INTO `sys_role` VALUES ('1184995947733590016', 'zhao', '导购13', null, '0', 'sale', '0', '', 'zhao_I95W', '2019-10-18 08:53:45', 'zhao_I95W', '2019-11-04 11:27:20');
INSERT INTO `sys_role` VALUES ('1191195109086494720', 'zhao', '撒旦', null, '0', 'staff', '0', null, 'zhao_I95W', '2019-11-04 11:27:00', 'zhao_I95W', '2019-11-04 11:27:00');
INSERT INTO `sys_role` VALUES ('1191195148647170048', 'zhao', '123', null, '0', 'sale', '0', null, 'zhao_I95W', '2019-11-04 11:27:09', 'zhao_I95W', '2019-11-04 11:27:09');
INSERT INTO `sys_role` VALUES ('1192954207078379520', 'cheng', 'aaaa', null, '0', 'staff', '0', null, 'cheng_4KGX', '2019-11-09 07:57:02', 'cheng_4KGX', '2019-11-09 07:57:02');
INSERT INTO `sys_role` VALUES ('1231', 'wangxi', '123123', null, '0', 'staff', '0', '12321', 'junAdmin', '2019-10-08 17:13:43', 'junAdmin', '2019-10-08 17:13:43');
INSERT INTO `sys_role` VALUES ('452452', '0', '导购', '91,9107,910701,910702', '1', 'sale', '0', '452452', 'junAdmin', '2019-10-19 10:14:13', 'junAdmin', '2019-10-21 06:48:48');
INSERT INTO `sys_role` VALUES ('adminRole', '0', '管理员', '01,0101,010101,010102,0102,010201,010202,0103,010301,010302,0104,010401,010402,0105,010501,010502,0106,010601,010602,0107,010701,010702,0108,010801,010802,0109,010901,010902,0110,011001,011002,0111,011101,011102,0112,011201,011202,0113,011301,011302,02,0201,020101,020102,020103,020104,0202,020201,020202,0203,020301,020302,0204,020401,020402,0205,020501,020502,0206,020601,020602,0207,020701,020702,0208,020801,020802,0209,020901,020902,03,0301,030101,030102,0302,030201,030202,0303,030301,030302,0304,030401,030402,05,0501,050101,050102,0502,050201,050202,80,8007,8008,8009,90,9001,900101,900102,9002,900201,900202,9004,900401,900402,91,9101,910101,910102,9102,910201,910202,9103,910301,910302,9104,910401,910402,9105,910501,910502,9106,910601,910602,9107,910701,910702,92,9201,920101,920102,9202,920201,920202,9203,920301,920302,9204,920401,920402,9205,920501,920502,93,9301,930101,9302,99,9901,990101,990102,9902,990201,990202,04,0401,040101,040102,0402,040201,040202', '0', 'none', '0', '企业端使用的管理员，企业管理员', null, null, 'junAdmin', '2019-10-07 21:01:24');
INSERT INTO `sys_role` VALUES ('bdcaiwu', 'baiducom', '百度财务', null, '0', 'staff', '0', null, 'baidu_GN5E', '2019-10-08 16:25:15', 'baidu_GN5E', '2019-10-08 16:48:05');
INSERT INTO `sys_role` VALUES ('bdkuguan', 'baiducom', '百度库管', null, '0', 'staff', '0', null, 'baidu_GN5E', '2019-10-08 16:25:25', 'baidu_GN5E', '2019-10-08 16:48:04');
INSERT INTO `sys_role` VALUES ('caiwu', 'tengxun', '腾讯财务', null, '0', 'staff', '0', null, 'teng_W8UN', '2019-10-08 15:05:05', 'teng_W8UN', '2019-10-08 15:24:14');
INSERT INTO `sys_role` VALUES ('sqs', 'ali', '阿里管理员', '01,0101,010101,010102,0102,010201,010202,0103,010301,010302,0104,010401,010402,0105,010501,010502,0106,010601,010602,0107,010701,010702,0108,010801,010802,0109,010901,010902,0110,011001,011002,02,0201,020101,020102,0202,020201,020202,0203,020301,020302,0204,020401,020402,0205,020501,020502,0206,020601,020602,0207,020701,020702,03,0301,0302,030201,030202,0303,030301,030302,80,8007,8008,8009,90,9001,9002,04,0401,040101,040102,0402,040201,040202', '0', 'staff', '0', '12321', 'junAdmin', '2019-10-08 17:13:43', 'aliali_PRJT', '2019-10-08 17:13:43');
INSERT INTO `sys_role` VALUES ('staffRole', '0', '员工', '01,0101,010101,010102,0102,010201,010202,0103,010301,010302,0104,010401,010402,0105,010501,010502,0106,010601,010602,0107,010701,010702,0108,010801,010802,02,0201,020101,020102,0202,020201,020202,0203,020301,020302,0204,020401,020402,0205,020501,020502,0206,020601,020602,0207,020701,020702,03,0301,0302,030201,030202,0303,030301,030302,80,91,9107,910701,910702,9201,920101,920102,9204,920401,920402,99,9901,9902', '1', 'none', '0', '非管理员用户，共有的默认角色', 'junAdmin', '2019-10-07 21:30:53', 'junAdmin', '2019-10-17 15:06:58');
INSERT INTO `sys_role` VALUES ('z1', 'zhao', '服务', '', '0', 'staff', '0', '12321', 'junAdmin', '2019-10-08 17:13:43', 'zhao_I95W', '2019-10-17 10:53:50');
INSERT INTO `sys_role` VALUES ('z2', 'zhao', '检测', null, '0', 'staff', '0', '1', 'zhao_I95W', '2019-10-17 15:24:49', 'zhao_I95W', '2019-10-17 15:24:49');

-- ----------------------------
-- Table structure for sys_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_template`;
CREATE TABLE `sys_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `testId` varchar(64) DEFAULT NULL,
  `tpl_code` varchar(64) DEFAULT NULL COMMENT '模板编码',
  `tpl_name` varchar(64) DEFAULT NULL COMMENT '模板名称',
  `tpl_params` varchar(500) DEFAULT NULL COMMENT '参数值',
  `remark` text COMMENT '参数说明',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模板消息';

-- ----------------------------
-- Records of sys_template
-- ----------------------------
INSERT INTO `sys_template` VALUES ('01', 'HI1zfe9QNYpjBoH0uC_OE_FP4YiP9jDAxkiXKDJ4yVc', 'OPENTM414066453', '消费通知', 'first,keyword1,keyword2,keyword3,keyword4,keyword5,remark', '编号  OPENTM414066453\n标题  购买成功通知\n行业  IT科技 - IT软件与服务\n详细内容\n{{first.DATA}}\n支付时间：{{keyword1.DATA}}\n订单商品：{{keyword2.DATA}}\n订单金额：{{keyword3.DATA}}\n订单编号：{{keyword4.DATA}}\n商家信息：{{keyword5.DATA}}\n{{remark.DATA}}', null, null, 'junAdmin', '2019-11-07 14:14:09');
INSERT INTO `sys_template` VALUES ('02', 'nit0wb7RvUaJw8n_B5qni7i1hf5g0lLdS3uYw75dwAA', 'OPENTM205704113', '消耗通知', 'first,keyword1,keyword2,keyword3,keyword4,remark', '编号  OPENTM205704113\r\n标题  消费通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n本次消费项目：{{keyword1.DATA}}\r\n剩余项目：{{keyword2.DATA}}\r\n消费时间：{{keyword3.DATA}}\r\n消费门店：{{keyword4.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('03', 'aewoODzKOQYo_-MhE7kNbBTuVFzehC4uXmHTJB-K_vY', 'OPENTM202193611', '预约通知', 'first,keyword1,keyword2,remark', '编号  OPENTM202193611\r\n标题  预约成功通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n预约内容：{{keyword1.DATA}}\r\n预约时间：{{keyword2.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('04', 'FkDCBDztddD2GVgtr2GcavCQgOSn9W_DWDJ0ME3JlQg', 'OPENTM417879714', '取消预约通知', 'first,keyword1,keyword2,keyword3,remark', '编号  OPENTM417879714\r\n标题  取消预约成功通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n预约日期：{{keyword1.DATA}}\r\n预约时间：{{keyword2.DATA}}\r\n预约单号：{{keyword3.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('05', '9WjtCu9UOrro8uqF5AN-LAPEyp-CYcXUR1YDk1tpmP8', 'OPENTM412181252', '签到通知', 'first,keyword1,keyword2,keyword3,remark', '编号  OPENTM412181252\r\n标题  签到成功通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n签到人：{{keyword1.DATA}}\r\n签到时间：{{keyword2.DATA}}\r\n签到状态：{{keyword3.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('06', 'xWsR53kiaohSgMdkw4iaysfTyfY6oCUbCMoKxf0g5W8', 'OPENTM207719530', '调课通知', 'first,keyword1,keyword2,keyword3,remark', '编号  OPENTM207719530\r\n标题  调课通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n事由：{{keyword1.DATA}}\r\n上课时间：{{keyword2.DATA}}\r\n调课时间：{{keyword3.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('07', '47m8aeWMtlp1K6-zJZzinWVALLdowC5pRc1GowKmups', 'OPENTM417733499', '评价通知', 'first,keyword1,keyword2,remark', '编号  OPENTM417733499\r\n标题  服务评价通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n服务项目：{{keyword1.DATA}}\r\n完成时间：{{keyword2.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('08', null, null, '时光日历通知', null, null, null, null, null, null);
INSERT INTO `sys_template` VALUES ('09', 'QUQHQzgdlmqeMPQbLZH8QFMlKL62FLBaD7FjG8oFPtQ', 'OPENTM400417088', '客户报名提醒', 'first,keyword1,keyword2,keyword3,keyword4,remark', '编号  OPENTM400417088\r\n标题  报名提醒\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n姓名：{{keyword1.DATA}}\r\n电话：{{keyword2.DATA}}\r\n项目：{{keyword3.DATA}}\r\n时间：{{keyword4.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('10', '8I5iZVDddFIydWutFH1WX6J4lXP-LXQRzV4WDY1H18Y', 'OPENTM401155654', '每日统计', 'first,keyword1,keyword2,remark', '编号  OPENTM401155654\r\n标题  营业情况明细通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n统计时间：{{keyword1.DATA}}\r\n营业简报：{{keyword2.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('11', 'l5hwS8excEc6EEaII_9QmuWtcMrg9zN6YOqMePge0Eo', 'OPENTM417813504', '请假申请通知', 'first,keyword1,keyword2,keyword3,keyword4,keyword5,remark', '编号  OPENTM417813504\r\n标题  请假申请通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n申请时间：{{keyword1.DATA}}\r\n申请人：{{keyword2.DATA}}\r\n请假类型：{{keyword3.DATA}}\r\n请假开始时间：{{keyword4.DATA}}\r\n请假结束时间：{{keyword5.DATA}}\r\n{{remark.DATA}}', null, null, null, null);
INSERT INTO `sys_template` VALUES ('12', 'rE8v5-ARpyqr9mOzIq4la1g7fVffL7XODI5JETF8nnk', 'OPENTM412898512', '请假审批通知', 'first,keyword1,keyword2,remark', '编号  OPENTM412898512\r\n标题  审批结果通知\r\n行业  IT科技 - IT软件与服务\r\n详细内容\r\n{{first.DATA}}\r\n请假时间：{{keyword1.DATA}}\r\n审批结果：{{keyword2.DATA}}\r\n{{remark.DATA}}', null, null, null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '用户id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `role_ids` text COMMENT '角色列表',
  `username` varchar(50) DEFAULT NULL COMMENT '邀请码',
  `password` varchar(50) DEFAULT NULL COMMENT '登录密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `qq` varchar(50) DEFAULT NULL COMMENT 'qq',
  `wx` varchar(50) DEFAULT NULL COMMENT '微信',
  `status` char(1) DEFAULT '0' COMMENT '用户状态（0正常、8停用、9删除）',
  `user_type` varchar(16) DEFAULT NULL COMMENT '用户类型',
  `sys_type` char(1) DEFAULT NULL COMMENT '管理员类型（0非管理员 1系统管理员  2二级管理员）',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('0000_W92Q', 'ali', '1184738476647448576', '0000', 'd2b3c36fbb49c87d29974aa81b57530a', '导购三', '11', '11', '11', '11', '0', 'sale', '0', '11', null, null, null, null);
INSERT INTO `sys_user` VALUES ('11111111_L904', '11', 'adminRole', '11111111', '0bfe5eda0e0d117a4a465f80c1217327', '1111111', null, null, null, null, '9', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('11111_HEKL', '0', '452452', '11111', '08cfe972f7bc80999709b0b3efcc01ac', '1111', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('1111_M8SV', 'baiducom', 'bdkuguan', '1111', 'fabb93847235525823238890b184ae9a', '1111', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('1191634218989297664', '0', '111', 'zx19', 'b2c8369f90cf87a4fa1b83901e94d4cf', 'zx19', '', '', '41141', '11', '9', 'staff', '0', '', null, null, 'junAdmin', '2019-11-05 16:37:25');
INSERT INTO `sys_user` VALUES ('1191635703535583232', '0', '111', 'zc11', '1a894ebc83e1ba9e19a0fbd7a4b08c73', '11010', '', '123', '', '', '9', 'staff', '0', '', 'junAdmin', '2019-11-05 16:37:46', 'junAdmin', '2019-11-05 16:38:04');
INSERT INTO `sys_user` VALUES ('1191636842976985088', '0', '452452', 'qq123', '0375cdee2574e92e553071e7be21cfe3', 'qq123', '', '1', '', '', '0', 'sale', '0', '', 'junAdmin', '2019-11-05 16:42:18', 'junAdmin', '2019-11-05 16:42:37');
INSERT INTO `sys_user` VALUES ('1191637198054178816', 'z111', 'adminRole', 'admin11111', '39a88cda93d083f9c947cef5fed4eb20', 'admin11111', null, null, null, null, '9', 'none', '1', null, 'junAdmin', '2019-11-05 16:43:42', 'junAdmin', '2019-11-05 16:43:42');
INSERT INTO `sys_user` VALUES ('1195159802214412288', 'cheng', 'adminRole', 'cheng', 'e092bb37776c1fb4a02b52073b8eafcf', '1', null, null, null, null, '0', 'none', '1', null, 'junAdmin', '2019-11-15 10:01:17', 'junAdmin', '2019-11-15 10:01:17');
INSERT INTO `sys_user` VALUES ('123123123_AAYH', '0', '111', '123123123', '0dec441f2d33f6d9d57d0fd755cc7794', '周老师', '', '', '', '', '0', 'staff', '0', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('12312312_XIX2', '1233', 'staffRole,adminRole', '12312312', '007d1cb8740253b15762cd053dbfda8a', '123', '', '', '', '', '0', 'none', '1', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('123123_8QJO', '123123', 'adminRole', '123123', '1ae6ec381b922a82127598984d411c79', '123123', '123123', '123123', '123123', '123123', '0', 'none', '1', '123123', null, null, null, null);
INSERT INTO `sys_user` VALUES ('12312_J0CE', 'zhao', 'z2', '12312', 'ca8bf1e47009afeac53dad3e18e814c2', '3123123', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('1231_K6PZ', '123', 'adminRole', '1231', '33d271c1aa8d5a0d1c4b9470582ae20e', '123', '123', '123', '123', '123', '0', 'none', '1', '123', null, null, null, null);
INSERT INTO `sys_user` VALUES ('123aaa_UFZS', '11', 'adminRole', '123aaa', '63b219df59f852afacea5f6707d035f2', '123', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2222_MJ9U', 'tengxun', 'caiwu', '2222', 'd2a1d077792bb1a9084d0773ed54fbbe', '腾讯导购', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('3333_KEOI', 'ali', 'sqs', '3333', '95317dca09354e29b76a3ad10ce5b152', '导购一', '11', '11', '11', '11', '0', 'sale', '0', '11', null, null, null, null);
INSERT INTO `sys_user` VALUES ('6666_2KWT', 'ali', 'sqs', '6666', 'e38159c00a6b5271ab437c3fa2cd876c', '导购二', '11', '11', '11', '11', '0', 'sale', '0', '11', null, null, null, null);
INSERT INTO `sys_user` VALUES ('88888_OUZ1', '88888', 'adminRole', '88888', '8367e951e99c80cdc7b6635710080de4', '88888', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('8888_PRVQ', 'ali', 'sqs', '8888', 'adc884e85e0e6b7f131d0c57246962e2', '王五', '1234566@163.com', '123456', '11', '11', '0', 'staff', '0', '11', null, null, null, null);
INSERT INTO `sys_user` VALUES ('9999_F8RR', 'ali', 'sqs', '9999', '529f4ab58039688fb0a4a950fe876f76', '张三', '9999', '9999', '9999', '9999', '0', 'staff', '0', '9999', null, null, null, null);
INSERT INTO `sys_user` VALUES ('aliali_PRJT', 'ali', 'adminRole', 'aliali', 'da155b4c5d6f1099ef872e0bd8b76250', '阿里', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('asdasdasdasd_WOVT', '0', '452452', 'asdasdasdasd', 'd5ccd87b9bbb27dbcfbded8722a999d9', 'asdasd', 'asdasd', 'asdasd', 'asdasd', 'asdasd', '0', 'sale', '0', 'asdasd', null, null, null, null);
INSERT INTO `sys_user` VALUES ('asdasd_0RMB', 'wangxi', '1231', 'asdasd', '01e48e728cb109c796e1c163d19a99f6', 'asdasd', 'asdasd', 'asdasd', null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('asda_5HRC', 'wangxi', '1231', 'asda', '15368e72089ae7595c8e7850beff3b6e', 'asd', 'asd', 'asd', 'asd', 'asd', '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('baidu_GN5E', 'baidu', 'adminRole', 'baidu', 'a51bd53ecb87debb4093ccca787d7ae9', '百度', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('bdcaiwu_JVV7', 'baiducom', 'bdkuguan', 'bdcaiwu', 'd8ea85efa4ca2bb11c57cd3a2bd34257', '百度财务账号', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('bdkuguan_KYZH', 'baiducom', 'bdkuguan', 'bdkuguan', '3181eac94a5b8d4c1f98e3fc71c2c571', '百度库管账号', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('caiwu_N3BV', 'tengxun', 'caiwu', 'caiwu', 'f3d5072759919db4c6e1d3e5b4b44525', '腾讯财务', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('dao_1', 'zhao', '11', 'dao_1', '934aa602fde99b7bce41e42881308559', '导购1', '10000000', '15800000000', '10000002', '10000', '0', 'sale', '0', '000000000002', null, null, null, null);
INSERT INTO `sys_user` VALUES ('dao_10_287U', 'zhao', '1184995947733590016', 'dao_10', '835abe6ce01e6def0b8f5e3d5b1cc0f6', '12', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('dao_2', 'zhao', '11', 'dao_2', '025a2d54f265599e1066c19b924f484f', '导购2', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('dao_3', 'zhao', '11', 'dao_3', '6d392bdd4c18288720e19d2c203e997c', '导购3', '111', '111', '111', '111', '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('dao_4', 'zhao', '1184995947733590016', 'dao_4', 'b73d3a0999f52a9b4aa3a1926f3536b5', '导购4', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('junAdmin', '0', 'adminRole', 'admin', 'c69a29698e81ebe56cf6d355a6f4fa87', '超级管理员', null, null, null, null, '0', 'none', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('kuguan_PU9L', 'tengxun', 'caiwu', 'kuguan', '65708def53ab3ab3cf25f7752762be4e', '腾讯库管', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('qwer2_9ING', '0', '452452', 'qwer2', '6aa4471fb5bd101a8480a63f152caa97', '导购2', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('qwer3_VPXP', '0', '452452', 'qwer3', '06a39df65c85d4d66324912c2c30d1de', '导购3', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('qwer4_UG7F', '0', '452452', 'qwer4', '2f6ef5117ea0798242ee8c44c883a1e4', '导购4', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('qwer_4NPG', '0', '452452', 'qwer', '6f9465a7743b259896d793c9fa6bc107', '导购1', '', '', '', '', '0', 'sale', '0', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('teng_W8UN', 'tengxun', 'adminRole', 'teng', '96a0fcf6e1cd802dfc93a9f7e1ad24b5', '腾讯', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('yonghu2_4N22', '0', '111', 'yonghu2', '367382582f07771a761b8cb1df4761cb', '李老师', '', '', '', '', '0', 'staff', '0', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('yonghu_KKXF', '0', '111', 'yonghu', 'bc86a1633d3f47b721503e17d40cbd28', '张老师', '', '', '', '', '0', 'staff', '0', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('z123_CTUI', 'z111', 'adminRole', 'z123', '54e562e457c948e1db9e170a729f8f69', 'z123', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zhao1_670P', 'zhao', 'z1', 'zhao1', 'bad0feea2493bb4190eb1c9aad0300ca', 'zhao1', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zhao2_J9J1', 'zhao', 'z1', 'zhao2', '62b667d5f0febb6e7e785a7dcd62c425', '123', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zhao3_T9CD', 'zhao', '1184995947733590016', 'zhao3', 'efe3aacdb8fcf9aec75e0c4726831fa6', '3', null, null, null, null, '0', 'sale', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zhao_I95W', 'zhao', 'adminRole', 'zhao', '9d2dce003cadddea206b1e3b17677b65', 'zhao', null, null, null, null, '0', 'none', '1', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx11_AS6H', '0', '111', 'zx11', '57a0f873ff2a036338fc8ff6c14d2a4f', 'zx11', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx12_6S93', '0', '111', 'zx12', '0f80272cb936aae4f1ce28d732805360', 'zx12', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx13_6A9I', '0', '111', 'zx13', 'e5a53cfa39633f2b08ec368802fd8ff7', 'zx13', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx14_SR2N', '0', '111', 'zx14', '4cafeda545f43944add4ef583f75a931', 'zx14', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx15_HS18', '0', '111', 'zx15', '9acca2429c69008de16de902336ef9e4', 'zx15', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx16_FY40', '0', '111', 'zx16', 'f7c7fefc66bc2ccdec09872d50db2094', 'zx16', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx17_7SUY', '0', '111', 'zx17', '2f4b6c73c52ad0db5fcefa20c8d292f7', 'zx17', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zx18_C9PU', '0', '111', 'zx18', 'c07ee28e25e41055fd8327c412fab176', 'zx18', null, null, null, null, '0', 'staff', '0', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('zzf123_ML76', 'zzf', 'adminRole', 'zzf123', '3ef1ed4bd1308f7db9c3587f0643ebe2', 'zzf', '11', '11', '11', '11', '0', 'none', '1', '', null, null, null, null);
INSERT INTO `sys_user` VALUES ('zzz1_J4JO', '0', '111', 'wang', '78346f9ac8739bb5557fbb89bb8947bd', '王老师', '1', '13688889999', '', '', '0', 'staff', '0', '', null, null, 'junAdmin', '2019-11-15 11:09:33');

-- ----------------------------
-- Table structure for work_msg
-- ----------------------------
DROP TABLE IF EXISTS `work_msg`;
CREATE TABLE `work_msg` (
  `id` varchar(32) NOT NULL COMMENT '通知id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `user_id` varchar(32) DEFAULT NULL COMMENT '员工id',
  `style` char(1) DEFAULT NULL COMMENT '类型（1通知、2审批）',
  `biz_id` varchar(32) DEFAULT NULL COMMENT '关联业务id',
  `biz_type` char(2) DEFAULT NULL COMMENT '分类（1预约通知、21请假审批）',
  `url` varchar(255) DEFAULT NULL COMMENT '连接地址',
  `title` varchar(60) DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `read_state` char(1) DEFAULT '0' COMMENT '阅读状态（0未读取、1已读取）',
  `check_user` varchar(500) DEFAULT NULL COMMENT '审批人',
  `check_state` char(1) DEFAULT '1' COMMENT '审批状态（1待审批、2审批拒绝、3审批通过）',
  `check_remark` varchar(500) DEFAULT NULL COMMENT '审批意见',
  `check_time` datetime DEFAULT NULL COMMENT '审批时间',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息通知';

-- ----------------------------
-- Records of work_msg
-- ----------------------------

-- ----------------------------
-- Table structure for wx_config
-- ----------------------------
DROP TABLE IF EXISTS `wx_config`;
CREATE TABLE `wx_config` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `com_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `appid` varchar(32) DEFAULT NULL COMMENT '公众号appid',
  `appname` varchar(32) DEFAULT NULL COMMENT '公众号名称',
  `appsecret` varchar(32) DEFAULT NULL COMMENT '公众号AppSecret',
  `mch_id` varchar(32) DEFAULT NULL COMMENT '商户号',
  `mch_key` varchar(50) DEFAULT NULL COMMENT '商户api密钥',
  `mch_cert` varchar(100) DEFAULT NULL COMMENT '证书地址',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常、8禁用、9删除）',
  `create_id` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_id` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信公众号配置';

-- ----------------------------
-- Records of wx_config
-- ----------------------------
INSERT INTO `wx_config` VALUES ('1', 'cxmail8', 'wx6b170483c8a78748', '333334', '5ee440c6e2a89d1338ca5763d52e8287', '1469130202', 'ff0fb618e0e243599ac601f4920dbd8b', '1', '0', null, null, 'junAdmin', '2019-11-04 13:21:17', '');
INSERT INTO `wx_config` VALUES ('2', 'localhost', 'wx6b170483c8a78748', '测试', '5ee440c6e2a89d1338ca5763d52e8287', '1469130202', 'ff0fb618e0e243599ac601f4920dbd8b', '1', '0', null, null, 'junAdmin', '2019-11-04 09:02:20', '');
INSERT INTO `wx_config` VALUES ('3', 'cheng', 'wx675336d315136725', '优贝心选服务号', '18a61c8650f156872a501356348b785d', '1228112702', 'UNCfCqBBnfg4X6M2bZHWdV5Nh0h9Pclz', '11', '9', 'junAdmin', '2019-11-04 13:21:56', 'junAdmin', '2019-11-04 13:21:56', '');
INSERT INTO `wx_config` VALUES ('4', 'baidu', 'wx675336d315136725', '优贝心选服务号', '18a61c8650f156872a501356348b785d', '1228112702', 'UNCfCqBBnfg4X6M2bZHWdV5Nh0h9Pclz', '11', '9', 'junAdmin', '2019-11-04 13:21:56', 'junAdmin', '2019-11-04 13:21:56', null);

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `openid` varchar(64) NOT NULL COMMENT '用户的标识，对当前公众号唯一',
  `company_id` varchar(20) DEFAULT NULL COMMENT '企业id',
  `appid` varchar(64) DEFAULT NULL,
  `member_id` varchar(32) DEFAULT NULL COMMENT '会员id',
  `del_member_id` varchar(32) DEFAULT NULL,
  `staff_id` varchar(32) DEFAULT NULL COMMENT '员工id',
  `sale_id` varchar(32) DEFAULT NULL COMMENT '导购id',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `head_img` varchar(300) DEFAULT NULL COMMENT '本地头像',
  `session_id` varchar(64) DEFAULT NULL COMMENT 'session_id',
  `session_key` varchar(64) DEFAULT NULL COMMENT 'session_key',
  `nickname` varchar(50) DEFAULT NULL COMMENT '用户的昵称',
  `sex` int(1) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(20) DEFAULT NULL COMMENT '用户所在省份',
  `city` varchar(20) DEFAULT NULL COMMENT '用户所在城市',
  `country` varchar(20) DEFAULT NULL COMMENT '用户所在国家',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空',
  `privilege` varchar(255) DEFAULT NULL COMMENT '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  `unionid` varchar(64) DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`openid`),
  KEY `openid` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户';

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES ('ou5CDwJnp9ki2LFqvQwFirxtueP0', 'localhost', 'wx6b170483c8a78748', '1191218086037643264', '', '1195159802214412288', null, null, 'http://file.junkj.com/upload/201911/1194882108695617536.jpg', null, null, '程旭-骏骁网络', '1', '辽宁', '大连', '中国', 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTI5l8zFmibgFdicdNbo8rbdZHJqgl60xia0b3D71WcnLyWAPVic9lzP3T5VZR2xp2YUyGB2hzclkOIFaQ/132', '[]', null, '2019-11-14 15:37:49', '2019-11-14 15:37:49');
