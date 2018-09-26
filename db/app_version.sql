/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : ura

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-09-26 19:36:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_version`
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appname` varchar(50) DEFAULT '',
  `version_no` varchar(20) DEFAULT '',
  `version_name` varchar(25) DEFAULT '',
  `update_msg` varchar(100) DEFAULT '',
  `status` tinyint(1) DEFAULT NULL COMMENT '0 禁用|未发布   1 启用|发布',
  `publish_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES ('2', '优聚', '1.0.0', 'bata1', null, '1', '2018-09-26 19:34:47');
INSERT INTO `app_version` VALUES ('1', '优聚', '0.0.1', 'beta', null, '1', '2018-09-20 19:34:50');
