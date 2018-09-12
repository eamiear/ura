/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : ura

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-09-12 16:26:04
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=MyISAM AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1', 'admin', '查询字典列表', 'com.ura.admin.controller.SysDictController.list()', '{}', '200', '0:0:0:0:0:0:0:1', '2018-08-23 10:57:30');
INSERT INTO `sys_log` VALUES ('2', 'admin', '查询字典列表', 'com.ura.admin.controller.SysDictController.list()', '{}', '25', '0:0:0:0:0:0:0:1', '2018-08-23 11:41:29');
INSERT INTO `sys_log` VALUES ('3', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '1539', '127.0.0.1', '2018-09-11 18:36:21');
INSERT INTO `sys_log` VALUES ('4', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '168', '127.0.0.1', '2018-09-11 18:36:20');
INSERT INTO `sys_log` VALUES ('5', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '66', '127.0.0.1', '2018-09-11 18:36:23');
INSERT INTO `sys_log` VALUES ('6', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '26', '127.0.0.1', '2018-09-11 18:37:43');
INSERT INTO `sys_log` VALUES ('7', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '90', '127.0.0.1', '2018-09-11 18:37:43');
INSERT INTO `sys_log` VALUES ('8', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '53', '127.0.0.1', '2018-09-11 18:37:43');
INSERT INTO `sys_log` VALUES ('9', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '35', '127.0.0.1', '2018-09-11 18:40:41');
INSERT INTO `sys_log` VALUES ('10', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '63', '127.0.0.1', '2018-09-11 18:40:42');
INSERT INTO `sys_log` VALUES ('11', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '10', '127.0.0.1', '2018-09-11 18:40:42');
INSERT INTO `sys_log` VALUES ('12', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '101', '127.0.0.1', '2018-09-11 18:56:02');
INSERT INTO `sys_log` VALUES ('13', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '113', '127.0.0.1', '2018-09-11 18:56:02');
INSERT INTO `sys_log` VALUES ('14', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '34', '127.0.0.1', '2018-09-11 18:56:02');
INSERT INTO `sys_log` VALUES ('15', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '444', '127.0.0.1', '2018-09-11 18:58:12');
INSERT INTO `sys_log` VALUES ('16', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '75', '127.0.0.1', '2018-09-11 18:58:12');
INSERT INTO `sys_log` VALUES ('17', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '21', '127.0.0.1', '2018-09-11 18:58:12');
INSERT INTO `sys_log` VALUES ('18', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '13', '127.0.0.1', '2018-09-11 18:58:32');
INSERT INTO `sys_log` VALUES ('19', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '35', '127.0.0.1', '2018-09-12 10:40:49');
INSERT INTO `sys_log` VALUES ('20', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '193', '127.0.0.1', '2018-09-12 10:40:49');
INSERT INTO `sys_log` VALUES ('21', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '35', '127.0.0.1', '2018-09-12 10:40:58');
INSERT INTO `sys_log` VALUES ('22', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '21', '127.0.0.1', '2018-09-12 10:42:53');
INSERT INTO `sys_log` VALUES ('23', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":1,\"name\":\"会员\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '281', '127.0.0.1', '2018-09-12 10:44:41');
INSERT INTO `sys_log` VALUES ('24', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '51', '127.0.0.1', '2018-09-12 10:44:45');
INSERT INTO `sys_log` VALUES ('25', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '29', '127.0.0.1', '2018-09-12 10:46:59');
INSERT INTO `sys_log` VALUES ('26', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '29', '127.0.0.1', '2018-09-12 10:49:22');
INSERT INTO `sys_log` VALUES ('27', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '94', '127.0.0.1', '2018-09-12 10:49:22');
INSERT INTO `sys_log` VALUES ('28', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '30', '127.0.0.1', '2018-09-12 10:49:23');
INSERT INTO `sys_log` VALUES ('29', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":2,\"name\":\"江宇航\",\"orders\":0,\"parentId\":1,\"parentName\":\"会员\",\"perms\":\"member:user:list\",\"status\":1,\"type\":1,\"url\":\"/member/user.html\"}', '109', '127.0.0.1', '2018-09-12 10:53:34');
INSERT INTO `sys_log` VALUES ('30', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '57', '127.0.0.1', '2018-09-12 10:53:37');
INSERT INTO `sys_log` VALUES ('31', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '41', '127.0.0.1', '2018-09-12 10:57:26');
INSERT INTO `sys_log` VALUES ('32', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '34', '127.0.0.1', '2018-09-12 11:10:04');
INSERT INTO `sys_log` VALUES ('33', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '26', '127.0.0.1', '2018-09-12 11:10:12');
INSERT INTO `sys_log` VALUES ('34', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '93', '127.0.0.1', '2018-09-12 11:10:12');
INSERT INTO `sys_log` VALUES ('35', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '47', '127.0.0.1', '2018-09-12 11:10:12');
INSERT INTO `sys_log` VALUES ('36', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '58', '127.0.0.1', '2018-09-12 11:10:29');
INSERT INTO `sys_log` VALUES ('37', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '44', '127.0.0.1', '2018-09-12 11:22:56');
INSERT INTO `sys_log` VALUES ('38', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '60', '127.0.0.1', '2018-09-12 11:28:15');
INSERT INTO `sys_log` VALUES ('39', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '25', '127.0.0.1', '2018-09-12 11:30:58');
INSERT INTO `sys_log` VALUES ('40', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '96', '127.0.0.1', '2018-09-12 11:30:58');
INSERT INTO `sys_log` VALUES ('41', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '51', '127.0.0.1', '2018-09-12 11:31:00');
INSERT INTO `sys_log` VALUES ('42', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '48', '127.0.0.1', '2018-09-12 11:35:15');
INSERT INTO `sys_log` VALUES ('43', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '33', '127.0.0.1', '2018-09-12 11:48:08');
INSERT INTO `sys_log` VALUES ('44', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '84', '127.0.0.1', '2018-09-12 11:48:09');
INSERT INTO `sys_log` VALUES ('45', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '48', '127.0.0.1', '2018-09-12 11:48:09');
INSERT INTO `sys_log` VALUES ('46', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '38', '127.0.0.1', '2018-09-12 13:22:31');
INSERT INTO `sys_log` VALUES ('47', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '7', '127.0.0.1', '2018-09-12 13:22:31');
INSERT INTO `sys_log` VALUES ('48', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '34', '127.0.0.1', '2018-09-12 13:22:31');
INSERT INTO `sys_log` VALUES ('49', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '46', '127.0.0.1', '2018-09-12 13:24:31');
INSERT INTO `sys_log` VALUES ('50', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '17', '127.0.0.1', '2018-09-12 13:24:51');
INSERT INTO `sys_log` VALUES ('51', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '103', '127.0.0.1', '2018-09-12 13:24:51');
INSERT INTO `sys_log` VALUES ('52', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '41', '127.0.0.1', '2018-09-12 13:28:33');
INSERT INTO `sys_log` VALUES ('53', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '43', '127.0.0.1', '2018-09-12 13:28:54');
INSERT INTO `sys_log` VALUES ('54', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '94', '127.0.0.1', '2018-09-12 13:28:54');
INSERT INTO `sys_log` VALUES ('55', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '36', '127.0.0.1', '2018-09-12 13:31:35');
INSERT INTO `sys_log` VALUES ('56', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '37', '127.0.0.1', '2018-09-12 13:35:24');
INSERT INTO `sys_log` VALUES ('57', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '69', '127.0.0.1', '2018-09-12 13:35:43');
INSERT INTO `sys_log` VALUES ('58', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '42', '127.0.0.1', '2018-09-12 13:35:53');
INSERT INTO `sys_log` VALUES ('59', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '66', '127.0.0.1', '2018-09-12 13:35:53');
INSERT INTO `sys_log` VALUES ('60', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '49', '127.0.0.1', '2018-09-12 13:35:53');
INSERT INTO `sys_log` VALUES ('61', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '337', '127.0.0.1', '2018-09-12 13:39:06');
INSERT INTO `sys_log` VALUES ('62', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '376', '127.0.0.1', '2018-09-12 13:39:07');
INSERT INTO `sys_log` VALUES ('63', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '64', '127.0.0.1', '2018-09-12 13:39:07');
INSERT INTO `sys_log` VALUES ('64', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '100', '127.0.0.1', '2018-09-12 13:43:04');
INSERT INTO `sys_log` VALUES ('65', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '430', '127.0.0.1', '2018-09-12 13:43:05');
INSERT INTO `sys_log` VALUES ('66', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '58', '127.0.0.1', '2018-09-12 13:43:05');
INSERT INTO `sys_log` VALUES ('67', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '255', '127.0.0.1', '2018-09-12 13:45:30');
INSERT INTO `sys_log` VALUES ('68', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '501', '127.0.0.1', '2018-09-12 13:45:30');
INSERT INTO `sys_log` VALUES ('69', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '57', '127.0.0.1', '2018-09-12 13:45:31');
INSERT INTO `sys_log` VALUES ('70', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '36', '127.0.0.1', '2018-09-12 13:45:58');
INSERT INTO `sys_log` VALUES ('71', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '40', '127.0.0.1', '2018-09-12 13:53:43');
INSERT INTO `sys_log` VALUES ('72', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-12 13:53:43');
INSERT INTO `sys_log` VALUES ('73', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '89', '127.0.0.1', '2018-09-12 13:53:44');
INSERT INTO `sys_log` VALUES ('74', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '8', '127.0.0.1', '2018-09-12 13:55:54');
INSERT INTO `sys_log` VALUES ('75', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '39', '127.0.0.1', '2018-09-12 13:55:55');
INSERT INTO `sys_log` VALUES ('76', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '38', '127.0.0.1', '2018-09-12 13:55:55');
INSERT INTO `sys_log` VALUES ('77', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '57', '127.0.0.1', '2018-09-12 14:09:31');
INSERT INTO `sys_log` VALUES ('78', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '101', '127.0.0.1', '2018-09-12 14:09:31');
INSERT INTO `sys_log` VALUES ('79', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '53', '127.0.0.1', '2018-09-12 14:09:32');
INSERT INTO `sys_log` VALUES ('80', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-12 14:24:08');
INSERT INTO `sys_log` VALUES ('81', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '92', '127.0.0.1', '2018-09-12 14:24:08');
INSERT INTO `sys_log` VALUES ('82', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '42', '127.0.0.1', '2018-09-12 14:24:08');
INSERT INTO `sys_log` VALUES ('83', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '49', '127.0.0.1', '2018-09-12 14:25:00');
INSERT INTO `sys_log` VALUES ('84', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '23', '127.0.0.1', '2018-09-12 14:25:00');
INSERT INTO `sys_log` VALUES ('85', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '46', '127.0.0.1', '2018-09-12 14:25:00');
INSERT INTO `sys_log` VALUES ('86', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '1', '10', '127.0.0.1', '2018-09-12 14:25:03');
INSERT INTO `sys_log` VALUES ('87', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '20', '127.0.0.1', '2018-09-12 14:26:10');
INSERT INTO `sys_log` VALUES ('88', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '123', '127.0.0.1', '2018-09-12 14:26:10');
INSERT INTO `sys_log` VALUES ('89', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '36', '127.0.0.1', '2018-09-12 14:26:55');
INSERT INTO `sys_log` VALUES ('90', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '74', '127.0.0.1', '2018-09-12 14:26:57');
INSERT INTO `sys_log` VALUES ('91', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '37', '127.0.0.1', '2018-09-12 14:27:05');
INSERT INTO `sys_log` VALUES ('92', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '18', '127.0.0.1', '2018-09-12 14:27:41');
INSERT INTO `sys_log` VALUES ('93', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '40', '127.0.0.1', '2018-09-12 14:27:41');
INSERT INTO `sys_log` VALUES ('94', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '26', '127.0.0.1', '2018-09-12 14:28:04');
INSERT INTO `sys_log` VALUES ('95', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '13', '127.0.0.1', '2018-09-12 14:28:04');
INSERT INTO `sys_log` VALUES ('96', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '44', '127.0.0.1', '2018-09-12 14:29:52');
INSERT INTO `sys_log` VALUES ('97', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '60', '127.0.0.1', '2018-09-12 14:29:52');
INSERT INTO `sys_log` VALUES ('98', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '9', '127.0.0.1', '2018-09-12 14:30:20');
INSERT INTO `sys_log` VALUES ('99', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '36', '127.0.0.1', '2018-09-12 14:30:20');
INSERT INTO `sys_log` VALUES ('100', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '42', '127.0.0.1', '2018-09-12 14:31:43');
INSERT INTO `sys_log` VALUES ('101', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '62', '127.0.0.1', '2018-09-12 14:31:45');
INSERT INTO `sys_log` VALUES ('102', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '1', '16', '127.0.0.1', '2018-09-12 14:31:54');
INSERT INTO `sys_log` VALUES ('103', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '2', '19', '127.0.0.1', '2018-09-12 14:32:08');
INSERT INTO `sys_log` VALUES ('104', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '18', '127.0.0.1', '2018-09-12 14:33:02');
INSERT INTO `sys_log` VALUES ('105', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '90', '127.0.0.1', '2018-09-12 14:33:02');
INSERT INTO `sys_log` VALUES ('106', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '43', '127.0.0.1', '2018-09-12 14:33:06');
INSERT INTO `sys_log` VALUES ('107', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '2', '10', '127.0.0.1', '2018-09-12 14:33:23');
INSERT INTO `sys_log` VALUES ('108', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '94', '127.0.0.1', '2018-09-12 14:34:51');
INSERT INTO `sys_log` VALUES ('109', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '18', '127.0.0.1', '2018-09-12 14:34:51');
INSERT INTO `sys_log` VALUES ('110', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '47', '127.0.0.1', '2018-09-12 14:34:52');
INSERT INTO `sys_log` VALUES ('111', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '2', '10', '127.0.0.1', '2018-09-12 14:34:58');
INSERT INTO `sys_log` VALUES ('112', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":2,\"name\":\"菜单\",\"orders\":0,\"parentId\":1,\"parentName\":\"会员\",\"perms\":\"sys:menu:list\",\"status\":1,\"type\":1,\"url\":\"/system/menu.html\"}', '277', '127.0.0.1', '2018-09-12 14:35:17');
INSERT INTO `sys_log` VALUES ('113', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '49', '127.0.0.1', '2018-09-12 14:35:21');
INSERT INTO `sys_log` VALUES ('114', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '2', '13', '127.0.0.1', '2018-09-12 14:36:04');
INSERT INTO `sys_log` VALUES ('115', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":2,\"name\":\"菜单\",\"orders\":0,\"parentId\":1,\"parentName\":\"会员\",\"perms\":\"sys:menu:list\",\"status\":1,\"type\":1,\"url\":\"/system/menu.html\"}', '102', '127.0.0.1', '2018-09-12 14:36:12');
INSERT INTO `sys_log` VALUES ('116', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '110', '127.0.0.1', '2018-09-12 14:36:13');
INSERT INTO `sys_log` VALUES ('117', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '107', '127.0.0.1', '2018-09-12 14:36:14');
INSERT INTO `sys_log` VALUES ('118', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '1', '21', '127.0.0.1', '2018-09-12 14:36:20');
INSERT INTO `sys_log` VALUES ('119', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":1,\"name\":\"系统菜单\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '79', '127.0.0.1', '2018-09-12 14:36:29');
INSERT INTO `sys_log` VALUES ('120', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '119', '127.0.0.1', '2018-09-12 14:36:30');
INSERT INTO `sys_log` VALUES ('121', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '122', '127.0.0.1', '2018-09-12 14:36:30');
INSERT INTO `sys_log` VALUES ('122', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '1', '17', '127.0.0.1', '2018-09-12 14:36:36');
INSERT INTO `sys_log` VALUES ('123', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":1,\"name\":\"系统管理\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '79', '127.0.0.1', '2018-09-12 14:36:41');
INSERT INTO `sys_log` VALUES ('124', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '92', '127.0.0.1', '2018-09-12 14:36:42');
INSERT INTO `sys_log` VALUES ('125', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '94', '127.0.0.1', '2018-09-12 14:36:42');
INSERT INTO `sys_log` VALUES ('126', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '69', '127.0.0.1', '2018-09-12 14:39:50');
INSERT INTO `sys_log` VALUES ('127', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '10', '127.0.0.1', '2018-09-12 14:40:05');
INSERT INTO `sys_log` VALUES ('128', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '21', '127.0.0.1', '2018-09-12 14:40:05');
INSERT INTO `sys_log` VALUES ('129', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '57', '127.0.0.1', '2018-09-12 14:42:12');
INSERT INTO `sys_log` VALUES ('130', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '1', '14', '127.0.0.1', '2018-09-12 14:42:21');
INSERT INTO `sys_log` VALUES ('131', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":1,\"name\":\"系统平台\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '109', '127.0.0.1', '2018-09-12 14:42:26');
INSERT INTO `sys_log` VALUES ('132', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '110', '127.0.0.1', '2018-09-12 14:42:27');
INSERT INTO `sys_log` VALUES ('133', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '91', '127.0.0.1', '2018-09-12 14:42:27');
INSERT INTO `sys_log` VALUES ('134', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '2', '11', '127.0.0.1', '2018-09-12 14:42:33');
INSERT INTO `sys_log` VALUES ('135', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":2,\"name\":\"菜单管理\",\"orders\":0,\"parentId\":1,\"parentName\":\"系统平台\",\"perms\":\"sys:menu:list\",\"status\":1,\"type\":1,\"url\":\"/system/menu.html\"}', '85', '127.0.0.1', '2018-09-12 14:42:41');
INSERT INTO `sys_log` VALUES ('136', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '96', '127.0.0.1', '2018-09-12 14:42:42');
INSERT INTO `sys_log` VALUES ('137', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '90', '127.0.0.1', '2018-09-12 14:42:42');
INSERT INTO `sys_log` VALUES ('138', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '13', '127.0.0.1', '2018-09-12 14:43:03');
INSERT INTO `sys_log` VALUES ('139', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '95', '127.0.0.1', '2018-09-12 14:43:03');
INSERT INTO `sys_log` VALUES ('140', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '63', '127.0.0.1', '2018-09-12 14:43:03');
INSERT INTO `sys_log` VALUES ('141', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":3,\"name\":\"会员平台\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '83', '127.0.0.1', '2018-09-12 14:43:15');
INSERT INTO `sys_log` VALUES ('142', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '143', '127.0.0.1', '2018-09-12 14:43:17');
INSERT INTO `sys_log` VALUES ('143', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '129', '127.0.0.1', '2018-09-12 14:43:17');
INSERT INTO `sys_log` VALUES ('144', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '3', '17', '127.0.0.1', '2018-09-12 14:43:20');
INSERT INTO `sys_log` VALUES ('145', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '3', '12', '127.0.0.1', '2018-09-12 14:43:24');
INSERT INTO `sys_log` VALUES ('146', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '22', '127.0.0.1', '2018-09-12 14:43:57');
INSERT INTO `sys_log` VALUES ('147', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '174', '127.0.0.1', '2018-09-12 14:43:57');
INSERT INTO `sys_log` VALUES ('148', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '69', '127.0.0.1', '2018-09-12 14:43:58');
INSERT INTO `sys_log` VALUES ('149', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":4,\"name\":\"会员列表\",\"orders\":0,\"parentId\":3,\"parentName\":\"会员平台\",\"perms\":\"sys:member:list\",\"status\":1,\"type\":1,\"url\":\"/member/list.html\"}', '71', '127.0.0.1', '2018-09-12 14:44:46');
INSERT INTO `sys_log` VALUES ('150', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '158', '127.0.0.1', '2018-09-12 14:44:48');
INSERT INTO `sys_log` VALUES ('151', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '135', '127.0.0.1', '2018-09-12 14:44:48');
INSERT INTO `sys_log` VALUES ('152', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":5,\"name\":\"会员组\",\"orders\":0,\"parentId\":3,\"parentName\":\"会员平台\",\"status\":1,\"type\":0,\"url\":\"\"}', '83', '127.0.0.1', '2018-09-12 16:10:06');
INSERT INTO `sys_log` VALUES ('153', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '165', '127.0.0.1', '2018-09-12 16:10:08');
INSERT INTO `sys_log` VALUES ('154', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '154', '127.0.0.1', '2018-09-12 16:10:08');
INSERT INTO `sys_log` VALUES ('155', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '5', '12', '127.0.0.1', '2018-09-12 16:10:16');
INSERT INTO `sys_log` VALUES ('156', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":5,\"name\":\"会员组\",\"orders\":0,\"parentId\":3,\"parentName\":\"会员平台\",\"perms\":\"sys:member:group\",\"status\":1,\"type\":1,\"url\":\"/system/member/group.html\"}', '72', '127.0.0.1', '2018-09-12 16:10:52');
INSERT INTO `sys_log` VALUES ('157', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '168', '127.0.0.1', '2018-09-12 16:10:53');
INSERT INTO `sys_log` VALUES ('158', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '178', '127.0.0.1', '2018-09-12 16:10:53');
INSERT INTO `sys_log` VALUES ('159', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '5', '15', '127.0.0.1', '2018-09-12 16:11:00');
INSERT INTO `sys_log` VALUES ('160', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":5,\"name\":\"会员组\",\"orders\":0,\"parentId\":3,\"parentName\":\"会员平台\",\"perms\":\"sys:member:group\",\"status\":1,\"type\":1,\"url\":\"/member/group.html\"}', '93', '127.0.0.1', '2018-09-12 16:11:06');
INSERT INTO `sys_log` VALUES ('161', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '192', '127.0.0.1', '2018-09-12 16:11:08');
INSERT INTO `sys_log` VALUES ('162', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '157', '127.0.0.1', '2018-09-12 16:11:08');
INSERT INTO `sys_log` VALUES ('163', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '97', '127.0.0.1', '2018-09-12 16:11:28');
INSERT INTO `sys_log` VALUES ('164', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":6,\"name\":\"签名平台\",\"orders\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"status\":1,\"type\":0,\"url\":\"\"}', '108', '127.0.0.1', '2018-09-12 16:13:56');
INSERT INTO `sys_log` VALUES ('165', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '186', '127.0.0.1', '2018-09-12 16:13:57');
INSERT INTO `sys_log` VALUES ('166', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '178', '127.0.0.1', '2018-09-12 16:13:57');
INSERT INTO `sys_log` VALUES ('167', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '6', '11', '127.0.0.1', '2018-09-12 16:14:05');
INSERT INTO `sys_log` VALUES ('168', 'admin', '新增菜单', 'com.ura.admin.controller.SysMenuController.save()', '{\"icon\":\"\",\"menuId\":7,\"name\":\"字体库\",\"orders\":0,\"parentId\":6,\"parentName\":\"签名平台\",\"perms\":\"sys:sign:font\",\"status\":1,\"type\":1,\"url\":\"/signature/fonts.html\"}', '127', '127.0.0.1', '2018-09-12 16:15:36');
INSERT INTO `sys_log` VALUES ('169', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '251', '127.0.0.1', '2018-09-12 16:15:37');
INSERT INTO `sys_log` VALUES ('170', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '219', '127.0.0.1', '2018-09-12 16:15:37');
INSERT INTO `sys_log` VALUES ('171', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '115', '127.0.0.1', '2018-09-12 16:19:37');
INSERT INTO `sys_log` VALUES ('172', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '95', '127.0.0.1', '2018-09-12 16:19:57');
INSERT INTO `sys_log` VALUES ('173', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '27', '127.0.0.1', '2018-09-12 16:19:57');
INSERT INTO `sys_log` VALUES ('174', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '116', '127.0.0.1', '2018-09-12 16:19:57');
INSERT INTO `sys_log` VALUES ('175', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '107', '127.0.0.1', '2018-09-12 16:20:29');
INSERT INTO `sys_log` VALUES ('176', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '6', '127.0.0.1', '2018-09-12 16:20:33');
INSERT INTO `sys_log` VALUES ('177', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '119', '127.0.0.1', '2018-09-12 16:20:34');
INSERT INTO `sys_log` VALUES ('178', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '111', '127.0.0.1', '2018-09-12 16:21:06');
INSERT INTO `sys_log` VALUES ('179', 'admin', '查询用户信息', 'com.ura.admin.controller.SysUserController.info()', '1', '31', '127.0.0.1', '2018-09-12 16:22:15');
INSERT INTO `sys_log` VALUES ('180', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '254', '127.0.0.1', '2018-09-12 16:22:15');
INSERT INTO `sys_log` VALUES ('181', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '124', '127.0.0.1', '2018-09-12 16:22:32');
INSERT INTO `sys_log` VALUES ('182', 'admin', '查询菜单记录', 'com.ura.admin.controller.SysMenuController.info()', '4', '17', '127.0.0.1', '2018-09-12 16:25:28');
INSERT INTO `sys_log` VALUES ('183', 'admin', '修改菜单', 'com.ura.admin.controller.SysMenuController.update()', '{\"icon\":\"\",\"menuId\":4,\"name\":\"会员管理\",\"orders\":0,\"parentId\":3,\"parentName\":\"会员平台\",\"perms\":\"sys:member:list\",\"status\":1,\"type\":1,\"url\":\"/member/list.html\"}', '85', '127.0.0.1', '2018-09-12 16:25:39');
INSERT INTO `sys_log` VALUES ('184', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{}', '283', '127.0.0.1', '2018-09-12 16:25:41');
INSERT INTO `sys_log` VALUES ('185', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '216', '127.0.0.1', '2018-09-12 16:25:41');
INSERT INTO `sys_log` VALUES ('186', 'admin', '查询菜单列表', 'com.ura.admin.controller.SysMenuController.list()', '{\"0\":\"1\"}', '91', '127.0.0.1', '2018-09-12 16:25:48');

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统平台', '', null, '0', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('2', '1', '菜单管理', '/system/menu.html', 'sys:menu:list', '1', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('3', '0', '会员平台', '', null, '0', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('4', '3', '会员管理', '/member/list.html', 'sys:member:list', '1', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('5', '3', '会员组', '/member/group.html', 'sys:member:group', '1', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('6', '0', '签名平台', '', null, '0', '', '0', '1', null, null);
INSERT INTO `sys_menu` VALUES ('7', '6', '字体库', '/signature/fonts.html', 'sys:sign:font', '1', '', '0', '1', null, null);

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
  `user_id` bigint(200) NOT NULL DEFAULT '0',
  `role_id` bigint(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`role_id`)
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
INSERT INTO `sys_user_token` VALUES ('1', '4b447030b088e6de1f7b892253aeeb8a', '2018-09-12 22:40:48', '2018-09-12 10:40:48');
