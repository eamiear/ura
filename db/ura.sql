/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : ura

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-08-06 11:35:35
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
INSERT INTO `gen_config` VALUES ('1', 'package', 'com.ura', '0', '包名');
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
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单';

-- ----------------------------
-- Records of sys_menu
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
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
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
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `udate_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
