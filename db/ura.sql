/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : ura

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-12-02 22:11:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ai_bd_face`
-- ----------------------------
DROP TABLE IF EXISTS `ai_bd_face`;
CREATE TABLE `ai_bd_face` (
  `face_id` int(11) NOT NULL AUTO_INCREMENT,
  `error_code` varchar(255) DEFAULT NULL,
  `error_msg` varchar(255) DEFAULT NULL,
  `log_id` varchar(255) DEFAULT NULL,
  `timestamp` varchar(255) DEFAULT NULL,
  `cached` int(255) DEFAULT NULL,
  `face_num` int(11) DEFAULT NULL,
  `face_token` varchar(255) DEFAULT NULL,
  `face_probability` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `beauty` varchar(255) DEFAULT NULL COMMENT '美丑打分，范围0-100，越大表示越美。',
  `expression_type` varchar(255) DEFAULT NULL COMMENT 'none:不笑；smile:微笑；laugh:大笑',
  `face_shape_type` varchar(255) DEFAULT NULL COMMENT '脸型 square: 正方形 triangle:三角形 oval: 椭圆 heart: 心形 round: 圆形',
  `gender` varchar(255) DEFAULT NULL COMMENT 'male:男性 female:女性',
  `glasses_type` varchar(255) DEFAULT NULL COMMENT 'none:无眼镜，common:普通眼镜，sun:墨镜',
  `race_type` varchar(255) DEFAULT NULL COMMENT 'yellow: 黄种人 white: 白种人 black:黑种人 arabs: 阿拉伯人',
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信openid',
  `nickname` varchar(255) DEFAULT NULL COMMENT '微信昵称',
  `image_path` varchar(1000) DEFAULT NULL COMMENT '可以是本地路径 远程路径 具体根据实际业务来',
  PRIMARY KEY (`face_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ai_bd_face
-- ----------------------------
INSERT INTO `ai_bd_face` VALUES ('28', '0', 'SUCCESS', '2267528118', '1528816284', '0', '1', 'c739e29fc9b2bf58a18b63ae3868b237', '0', '18', '65.46601868', 'none', 'heart', 'female', 'none', 'yellow', 'op5Hs0EYFmR7XvvWNrbsMFVn22Kk', '小帅丶', '/face/faceV3BD1528816282.jpeg');
INSERT INTO `ai_bd_face` VALUES ('29', '0', 'SUCCESS', '4137833425', '1529414807', '0', '1', '2a5781540fb973bc2af81fd2f4e8915f', '1', '14', '27.21316338', 'none', 'square', 'male', 'none', 'yellow', 'op5Hs0EYFmR7XvvWNrbsMFVn22Kk', '小帅丶', '/face/faceV3BD1529414807.jpeg');
INSERT INTO `ai_bd_face` VALUES ('30', '0', 'SUCCESS', '565353545997', '1530023626', '0', '1', '4db3bf7b672fddb0dc647040d60ab567', '1', '35', '48.57863998', 'none', 'square', 'female', 'none', 'white', 'op5Hs0EYFmR7XvvWNrbsMFVn22Kk', '小帅丶', '/face/faceV3BD1530023626.jpg');
INSERT INTO `ai_bd_face` VALUES ('31', '0', 'SUCCESS', '744193237574287881', '1543757428', '0', '1', '457b3d769fcd8d052aede31bf66fec6c', '0', '12', '35.73', 'none', 'round', 'male', 'common', 'yellow', null, null, '');
INSERT INTO `ai_bd_face` VALUES ('32', '0', 'SUCCESS', '747956937578138951', '1543757813', '0', '1', '824603e34276df3845a775fc40c31f5e', '1', '1', '41.34', 'none', 'round', 'male', 'none', 'yellow', null, null, '');
INSERT INTO `ai_bd_face` VALUES ('33', '0', 'SUCCESS', '744193237584741411', '1543758474', '0', '1', '16261753dbbf72d83c63d96ee9bdbf4b', '1', '6', '43.55', 'smile', 'round', 'female', 'none', 'yellow', null, null, '');
INSERT INTO `ai_bd_face` VALUES ('34', '0', 'SUCCESS', '747956937591433171', '1543759143', '0', '1', 'c39d3b8786d799cd0d641fada5dc4052', '1', '24', '74.96', 'smile', 'heart', 'female', 'none', 'white', null, null, '');

-- ----------------------------
-- Table structure for `gen_config`
-- ----------------------------
DROP TABLE IF EXISTS `gen_config`;
CREATE TABLE `gen_config` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT '' COMMENT '键名',
  `value` varchar(200) DEFAULT '' COMMENT '键值',
  `status` int(4) DEFAULT '0' COMMENT '状态： 0 显示， 1删除',
  `remark` varchar(200) DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='生成器属性表';

-- ----------------------------
-- Records of gen_config
-- ----------------------------
INSERT INTO `gen_config` VALUES ('1', 'package', 'com.ura.admin', '0', '包名');
INSERT INTO `gen_config` VALUES ('3', 'mainPath', 'com.ura', '0', '');

-- ----------------------------
-- Table structure for `sys_config`
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(200) DEFAULT '' COMMENT '键名',
  `value` varchar(500) DEFAULT '' COMMENT '键值',
  `status` int(4) DEFAULT '0' COMMENT '状态',
  `remark` varchar(200) DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置';

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID，一级部门为0',
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `orders` int(11) DEFAULT NULL COMMENT '排序',
  `del_flag` tinyint(4) DEFAULT NULL COMMENT '是否删除  -1：已删除  0：正常',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '字典名称',
  `type` varchar(100) NOT NULL DEFAULT '' COMMENT '字典类型',
  `code` varchar(100) NOT NULL DEFAULT '' COMMENT '字典码',
  `value` varchar(1000) NOT NULL DEFAULT '' COMMENT '字典值',
  `order` int(11) DEFAULT '0' COMMENT '排序',
  `remark` varchar(255) DEFAULT '' COMMENT '备注',
  `del` tinyint(4) DEFAULT '0' COMMENT '删除标记  -1：已删除  0：正常',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`,`code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='数据字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '性别', 'sex', '0', '女', '0', null, '0');
INSERT INTO `sys_dict` VALUES ('2', '性别', 'sex', '1', '男', '1', null, '0');
INSERT INTO `sys_dict` VALUES ('3', '性别', 'sex', '2', '未知', '3', null, '0');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户名',
  `username` varchar(50) DEFAULT NULL,
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `time` varchar(100) DEFAULT NULL COMMENT '执行时间',
  `ip` varchar(70) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '查询用户列表', 'com.ura.admin.controller.SysUserController.list()', '{}', '211', '0:0:0:0:0:0:0:1', '2018-08-20 23:20:07');
INSERT INTO `sys_log` VALUES ('2', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '21', '127.0.0.1', '2018-09-01 16:16:46');
INSERT INTO `sys_log` VALUES ('3', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '37', '127.0.0.1', '2018-09-02 21:58:24');
INSERT INTO `sys_log` VALUES ('4', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-02 21:58:24');
INSERT INTO `sys_log` VALUES ('5', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '2', '127.0.0.1', '2018-09-02 21:58:36');
INSERT INTO `sys_log` VALUES ('6', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '2', '127.0.0.1', '2018-09-02 22:01:47');
INSERT INTO `sys_log` VALUES ('7', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '44', '127.0.0.1', '2018-09-02 22:01:57');
INSERT INTO `sys_log` VALUES ('8', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '45', '127.0.0.1', '2018-09-02 22:01:57');
INSERT INTO `sys_log` VALUES ('9', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '3', '127.0.0.1', '2018-09-02 22:02:49');
INSERT INTO `sys_log` VALUES ('10', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '3', '127.0.0.1', '2018-09-02 22:04:27');
INSERT INTO `sys_log` VALUES ('11', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '5', '127.0.0.1', '2018-09-02 22:04:27');
INSERT INTO `sys_log` VALUES ('12', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '3', '127.0.0.1', '2018-09-02 22:04:27');
INSERT INTO `sys_log` VALUES ('13', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '2', '127.0.0.1', '2018-09-02 22:05:26');
INSERT INTO `sys_log` VALUES ('14', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '5', '127.0.0.1', '2018-09-02 22:05:33');
INSERT INTO `sys_log` VALUES ('15', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '19', '127.0.0.1', '2018-09-02 22:05:33');
INSERT INTO `sys_log` VALUES ('16', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '58', '127.0.0.1', '2018-09-02 22:08:59');
INSERT INTO `sys_log` VALUES ('17', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '3', '127.0.0.1', '2018-09-02 22:09:19');
INSERT INTO `sys_log` VALUES ('18', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '4', '127.0.0.1', '2018-09-02 22:09:26');
INSERT INTO `sys_log` VALUES ('19', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '16', '127.0.0.1', '2018-09-02 22:09:26');
INSERT INTO `sys_log` VALUES ('20', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '68', '127.0.0.1', '2018-09-02 22:37:45');
INSERT INTO `sys_log` VALUES ('21', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '3', '127.0.0.1', '2018-09-02 22:37:51');
INSERT INTO `sys_log` VALUES ('22', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-02 22:37:51');
INSERT INTO `sys_log` VALUES ('23', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-02 22:38:37');
INSERT INTO `sys_log` VALUES ('24', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '335', '127.0.0.1', '2018-09-02 22:40:34');
INSERT INTO `sys_log` VALUES ('25', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '395', '127.0.0.1', '2018-09-02 22:40:34');
INSERT INTO `sys_log` VALUES ('26', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '81', '127.0.0.1', '2018-09-02 22:43:55');
INSERT INTO `sys_log` VALUES ('27', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '42', '127.0.0.1', '2018-09-02 22:44:01');
INSERT INTO `sys_log` VALUES ('28', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '67', '127.0.0.1', '2018-09-02 22:44:01');
INSERT INTO `sys_log` VALUES ('29', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '7', '127.0.0.1', '2018-09-02 22:44:46');
INSERT INTO `sys_log` VALUES ('30', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '11', '127.0.0.1', '2018-09-02 22:45:13');
INSERT INTO `sys_log` VALUES ('31', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '6', '127.0.0.1', '2018-09-02 22:45:21');
INSERT INTO `sys_log` VALUES ('32', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '5', '127.0.0.1', '2018-09-02 22:45:47');
INSERT INTO `sys_log` VALUES ('33', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '6', '127.0.0.1', '2018-09-02 22:47:34');
INSERT INTO `sys_log` VALUES ('34', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '96', '127.0.0.1', '2018-09-02 22:48:49');
INSERT INTO `sys_log` VALUES ('35', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-02 22:48:49');
INSERT INTO `sys_log` VALUES ('36', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-02 22:48:57');
INSERT INTO `sys_log` VALUES ('37', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '24', '127.0.0.1', '2018-09-02 22:51:27');
INSERT INTO `sys_log` VALUES ('38', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '24', '127.0.0.1', '2018-09-02 22:51:27');
INSERT INTO `sys_log` VALUES ('39', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '5', '127.0.0.1', '2018-09-02 22:51:48');
INSERT INTO `sys_log` VALUES ('40', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-02 22:52:00');
INSERT INTO `sys_log` VALUES ('41', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '2', '127.0.0.1', '2018-09-02 22:53:12');
INSERT INTO `sys_log` VALUES ('42', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '26', '127.0.0.1', '2018-09-02 22:53:12');
INSERT INTO `sys_log` VALUES ('43', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '5', '127.0.0.1', '2018-09-02 22:53:21');
INSERT INTO `sys_log` VALUES ('44', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '3', '127.0.0.1', '2018-09-02 22:53:29');
INSERT INTO `sys_log` VALUES ('45', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '5', '127.0.0.1', '2018-09-02 23:16:31');
INSERT INTO `sys_log` VALUES ('46', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-02 23:16:31');
INSERT INTO `sys_log` VALUES ('47', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '18', '127.0.0.1', '2018-09-10 23:44:17');
INSERT INTO `sys_log` VALUES ('48', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '54', '127.0.0.1', '2018-09-10 23:44:17');
INSERT INTO `sys_log` VALUES ('49', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-11 21:10:20');
INSERT INTO `sys_log` VALUES ('50', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '27', '127.0.0.1', '2018-09-11 21:10:26');
INSERT INTO `sys_log` VALUES ('51', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '118', '127.0.0.1', '2018-09-11 21:23:11');
INSERT INTO `sys_log` VALUES ('52', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '12', '127.0.0.1', '2018-09-11 21:23:12');
INSERT INTO `sys_log` VALUES ('53', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-11 21:31:36');
INSERT INTO `sys_log` VALUES ('54', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '6', '127.0.0.1', '2018-09-11 21:32:11');
INSERT INTO `sys_log` VALUES ('55', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '107', '127.0.0.1', '2018-09-11 21:32:11');
INSERT INTO `sys_log` VALUES ('56', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '5', '127.0.0.1', '2018-09-11 21:32:11');
INSERT INTO `sys_log` VALUES ('57', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '6', '127.0.0.1', '2018-09-11 21:32:15');
INSERT INTO `sys_log` VALUES ('58', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '4', '127.0.0.1', '2018-09-11 21:32:15');
INSERT INTO `sys_log` VALUES ('59', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '34', '127.0.0.1', '2018-09-11 21:32:56');
INSERT INTO `sys_log` VALUES ('60', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-11 21:32:56');
INSERT INTO `sys_log` VALUES ('61', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '8', '127.0.0.1', '2018-09-11 21:32:57');
INSERT INTO `sys_log` VALUES ('62', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '6', '127.0.0.1', '2018-09-11 21:35:40');
INSERT INTO `sys_log` VALUES ('63', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '29', '127.0.0.1', '2018-09-11 21:35:40');
INSERT INTO `sys_log` VALUES ('64', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '7', '127.0.0.1', '2018-09-11 21:35:40');
INSERT INTO `sys_log` VALUES ('65', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '98', '127.0.0.1', '2018-09-11 21:52:38');
INSERT INTO `sys_log` VALUES ('66', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-11 21:52:38');
INSERT INTO `sys_log` VALUES ('67', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '6', '127.0.0.1', '2018-09-11 21:52:39');
INSERT INTO `sys_log` VALUES ('68', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 21:55:14');
INSERT INTO `sys_log` VALUES ('69', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '6', '127.0.0.1', '2018-09-11 21:55:14');
INSERT INTO `sys_log` VALUES ('70', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-11 21:55:14');
INSERT INTO `sys_log` VALUES ('71', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '26', '127.0.0.1', '2018-09-11 21:56:39');
INSERT INTO `sys_log` VALUES ('72', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-11 21:56:39');
INSERT INTO `sys_log` VALUES ('73', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-11 21:56:39');
INSERT INTO `sys_log` VALUES ('74', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '5', '127.0.0.1', '2018-09-11 21:56:41');
INSERT INTO `sys_log` VALUES ('75', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '5', '127.0.0.1', '2018-09-11 21:56:41');
INSERT INTO `sys_log` VALUES ('76', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '153', '127.0.0.1', '2018-09-11 22:07:07');
INSERT INTO `sys_log` VALUES ('77', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 22:07:07');
INSERT INTO `sys_log` VALUES ('78', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-11 22:07:07');
INSERT INTO `sys_log` VALUES ('79', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '5', '127.0.0.1', '2018-09-11 22:07:08');
INSERT INTO `sys_log` VALUES ('80', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '7', '127.0.0.1', '2018-09-11 22:07:08');
INSERT INTO `sys_log` VALUES ('81', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 22:08:30');
INSERT INTO `sys_log` VALUES ('82', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '6', '127.0.0.1', '2018-09-11 22:08:30');
INSERT INTO `sys_log` VALUES ('83', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '6', '127.0.0.1', '2018-09-11 22:08:30');
INSERT INTO `sys_log` VALUES ('84', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-11 22:08:31');
INSERT INTO `sys_log` VALUES ('85', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '5', '127.0.0.1', '2018-09-11 22:08:31');
INSERT INTO `sys_log` VALUES ('86', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '144', '127.0.0.1', '2018-09-11 22:08:47');
INSERT INTO `sys_log` VALUES ('87', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '148', '127.0.0.1', '2018-09-11 22:08:47');
INSERT INTO `sys_log` VALUES ('88', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '8', '127.0.0.1', '2018-09-11 22:08:48');
INSERT INTO `sys_log` VALUES ('89', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '93', '127.0.0.1', '2018-09-11 22:10:47');
INSERT INTO `sys_log` VALUES ('90', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '96', '127.0.0.1', '2018-09-11 22:10:47');
INSERT INTO `sys_log` VALUES ('91', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '4', '127.0.0.1', '2018-09-11 22:10:47');
INSERT INTO `sys_log` VALUES ('92', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 22:10:52');
INSERT INTO `sys_log` VALUES ('93', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '4', '127.0.0.1', '2018-09-11 22:10:52');
INSERT INTO `sys_log` VALUES ('94', 'admin', '登出系统', 'com.ura.admin.controller.SysLoginController.logout()', null, '129', '127.0.0.1', '2018-09-11 22:10:53');
INSERT INTO `sys_log` VALUES ('95', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '7', '127.0.0.1', '2018-09-11 22:23:55');
INSERT INTO `sys_log` VALUES ('96', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '5', '127.0.0.1', '2018-09-11 22:23:55');
INSERT INTO `sys_log` VALUES ('97', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '19', '127.0.0.1', '2018-09-11 22:24:57');
INSERT INTO `sys_log` VALUES ('98', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '4', '127.0.0.1', '2018-09-11 22:37:35');
INSERT INTO `sys_log` VALUES ('99', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 22:37:35');
INSERT INTO `sys_log` VALUES ('100', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '5', '127.0.0.1', '2018-09-11 22:37:36');
INSERT INTO `sys_log` VALUES ('101', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 22:37:36');
INSERT INTO `sys_log` VALUES ('102', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '5', '127.0.0.1', '2018-09-11 22:37:36');
INSERT INTO `sys_log` VALUES ('103', 'admin', '登出系统', 'com.ura.admin.controller.SysLoginController.logout()', null, '7', '127.0.0.1', '2018-09-11 22:37:38');
INSERT INTO `sys_log` VALUES ('104', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '25', '127.0.0.1', '2018-09-11 23:02:29');
INSERT INTO `sys_log` VALUES ('105', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '4', '127.0.0.1', '2018-09-11 23:02:29');
INSERT INTO `sys_log` VALUES ('106', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '6', '127.0.0.1', '2018-09-11 23:02:34');
INSERT INTO `sys_log` VALUES ('107', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":1,\"name\":\"rrrr\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":1,\"url\":\"/system/menu.html\"}', '203', '127.0.0.1', '2018-09-11 23:03:16');
INSERT INTO `sys_log` VALUES ('108', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '9', '127.0.0.1', '2018-09-11 23:03:19');
INSERT INTO `sys_log` VALUES ('109', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '12', '127.0.0.1', '2018-09-11 23:04:34');
INSERT INTO `sys_log` VALUES ('110', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '3', '127.0.0.1', '2018-09-11 23:04:34');
INSERT INTO `sys_log` VALUES ('111', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '10', '127.0.0.1', '2018-09-11 23:04:34');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  `name` varchar(100) DEFAULT '' COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单路径',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(10) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `orders` int(10) DEFAULT NULL COMMENT '排序',
  `status` int(2) DEFAULT NULL COMMENT '菜单状态： 0 显示， 1隐藏',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', 'rrrr', '/system/menu.html', null, '1', '', '0', '1', null, null);

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `system_id` bigint(10) NOT NULL COMMENT '所属系统',
  `parent_id` bigint(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `url` varchar(100) DEFAULT NULL COMMENT '菜单路径',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `status` tinyint(4) DEFAULT NULL COMMENT '菜单状态： 0 显示， 1隐藏',
  `orders` bigint(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `title` varchar(50) DEFAULT NULL COMMENT '角色标题',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述/备注',
  `orders` int(10) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(200) NOT NULL DEFAULT '0',
  `dept_id` bigint(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色部门表';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(200) NOT NULL DEFAULT '0',
  `menu_id` bigint(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_permission_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(10) NOT NULL COMMENT '角色编号',
  `permission_id` bigint(10) NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`role_permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT '' COMMENT '用户名',
  `realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `create_user_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', null, '48ab4178302e623bf6cd366e68be466f14364b5209aeaf3508cfe6ca9aa2d263', null, null, null, null, null, 'xX8dQjxhGKgmhnwk7ETd', null, null, '1', null, '2018-08-10 19:09:13', '2018-08-10 19:26:37');

-- ----------------------------
-- Table structure for `sys_user_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_dept`;
CREATE TABLE `sys_user_dept` (
  `user_id` bigint(200) NOT NULL DEFAULT '0',
  `dept_id` bigint(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`dept_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户部门关联表';

-- ----------------------------
-- Records of sys_user_dept
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_permission`;
CREATE TABLE `sys_user_permission` (
  `user_permission_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(10) NOT NULL COMMENT '用户编号',
  `permission_id` bigint(10) NOT NULL COMMENT '权限编号',
  `type` tinyint(4) DEFAULT NULL COMMENT '权限类型(-1:减权限,1:增权限)f',
  PRIMARY KEY (`user_permission_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户权限关联表';

-- ----------------------------
-- Records of sys_user_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(200) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(200) NOT NULL DEFAULT '0',
  `role_id` bigint(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_token`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_token`;
CREATE TABLE `sys_user_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL,
  `expire_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_token
-- ----------------------------
INSERT INTO `sys_user_token` VALUES ('1', '668c634290834d0202a9d6edf868b481', '2018-09-12 11:02:29', '2018-09-11 23:02:29');

-- ----------------------------
-- Table structure for `tb_token`
-- ----------------------------
DROP TABLE IF EXISTS `tb_token`;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of tb_token
-- ----------------------------
INSERT INTO `tb_token` VALUES ('1', 'd0e9a8bf436ddbd736fdb74183522f78', '2018-09-17 04:21:46', '2018-09-16 16:21:46');
INSERT INTO `tb_token` VALUES ('3', 'c99c01443e4d96f028008fbfbdce7a18', '2018-09-24 08:53:50', '2018-09-23 20:53:50');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `register_ip` varchar(100) DEFAULT NULL,
  `last_lgoin_ip` varchar(100) DEFAULT NULL,
  `nickname` varchar(60) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `weixin_openid` varchar(50) DEFAULT NULL,
  `group_id` int(10) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT NULL,
  `login_times` int(20) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '12345678901', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', null, null, '2018-09-16 15:25:42', null, null, null, null, '12345678901', null, null, null, null, null, null, null, null);
INSERT INTO `tb_user` VALUES ('3', 'skz', null, '1', null, '2018-09-23 14:09:14', '2018-09-23 20:53:50', '2408:84f3:8e01:e497:a8fe:102f:e6:b1fb', '112.96.176.12', 'skz', null, null, 'o67jR0ggMG6mKHGfrecnLBmjtR1c', null, null, '3', 'CN', 'Guangdong', 'Guangzhou');
