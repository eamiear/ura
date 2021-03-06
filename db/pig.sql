/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50168
Source Host           : localhost:3306
Source Database       : pig

Target Server Type    : MYSQL
Target Server Version : 50168
File Encoding         : 65001

Date: 2018-08-03 00:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `job_execution_log`
-- ----------------------------
DROP TABLE IF EXISTS `job_execution_log`;
CREATE TABLE `job_execution_log` (
  `id` varchar(40) NOT NULL,
  `job_name` varchar(100) NOT NULL,
  `task_id` varchar(255) NOT NULL,
  `hostname` varchar(255) NOT NULL,
  `ip` varchar(50) NOT NULL,
  `sharding_item` int(11) NOT NULL,
  `execution_source` varchar(20) NOT NULL,
  `failure_cause` varchar(4000) DEFAULT NULL,
  `is_success` int(11) NOT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `complete_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_execution_log
-- ----------------------------
INSERT INTO `job_execution_log` VALUES ('02e7226f-0474-439d-abf8-b36e990092c2', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('03787adb-8838-4ee4-8aec-f800155e92b5', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('04856b6b-b04f-43af-b397-4afa0d5ec824', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('0499b7b4-1028-4eed-a595-0a8400fa3f8d', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('05a148ab-354c-4b47-93e2-8a33e1f72025', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('06ef245c-fff0-46cd-b8f3-3bb0b7735294', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('08d8b07e-613c-4e0a-b676-f300b6f7420a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('0be783c6-ee26-4bb1-a073-464fb7b345b1', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('0e9a9e51-5f00-4ada-b6bf-90c2f394a714', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('1090dc79-22e0-4357-a488-3a400de187b2', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('12f20da7-bd0b-479e-9609-c05678b1085c', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('1313d63b-e1dc-462f-92fe-b3e46c35bc23', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('1834d00f-3ce0-4aa7-a59b-ee796869781f', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('206d8a46-24af-43d6-b220-04ffa35120e6', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('23cccdbb-3cff-46b8-b86d-9d1ba145ee8e', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('24ba419e-e535-4bb3-9a03-7ccd60377b09', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('24bf826e-a6f5-4e2c-81e2-ffb6b5b7100f', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('29299b03-e8a3-414a-8c78-1652cf938aeb', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('2a2e0d20-f554-4d72-a6c2-86331db784bb', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('2d9ec975-009d-46ca-90e2-4a3dd71cce1a', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('30d3c5f4-8ff5-4010-a156-95086443c27c', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('34d91607-8ed9-4ee8-9e36-9d685ea2d6b6', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('361e481a-686a-45db-b71f-ca2968d27171', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('38229735-411c-47f0-9cb8-d5c58eb34992', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('3928c634-fbe5-4442-a2de-7e0d869e57ed', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('3a190ab7-beb8-419c-8064-42ed84757f30', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('3be72a34-8bcb-4239-a689-647d9592aaa7', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');
INSERT INTO `job_execution_log` VALUES ('3dc012d6-1fac-4129-9895-7c6e73a26b37', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('3fcfc11c-c20c-4d47-91c4-5419ac125dd0', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('400bd9ee-cd0e-457c-b435-f87d8cb42976', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('41d24c86-8a8d-49e7-af22-b3b04baa13aa', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('41d3af13-cba7-4533-b060-39fb4cd224db', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('428f6a33-a1ac-41a3-be15-376f7378b070', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('43e817d2-a581-4e2f-838b-adc87c70194f', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('48813f42-3c38-4cd9-b43e-71a1b5b1e783', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('489800c2-1a9f-48e9-8267-6a8a0f5033ae', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('49871eed-6b6a-467d-a62e-ece64b5835ce', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('4feb3271-7f68-4cd2-9d4f-cd00fde0ad22', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('51d72b2b-9e6b-4115-b520-8403411abeaf', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('5274e5b0-08d9-4ecc-bef9-7b22eae4b41b', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('55e92309-58f7-4c2f-9269-2d0ec15452ed', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('55ecde11-a7e1-403d-a812-bbee6a7a5f5f', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('5642f36f-8b93-4d83-a004-86f4cc2e2b42', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('57293d60-5bd5-41db-bb39-741829c73622', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('582b456e-f89e-4808-914d-54a1031421e2', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('58fd3269-9585-48fb-a815-3c5ed4bc82e0', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('5db348ea-a4a5-4cbd-9068-489929e9864a', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('5e24c455-53da-4f9d-9f04-a151ce831385', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('5f421b86-8566-45f1-b18d-9e51ef9127ba', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('615df759-b18d-4acf-971c-a07dc9f051b7', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('6618c90d-72c6-4889-ad50-de5df1a3c4ce', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('66903087-cd34-4793-9e80-3704b06cb28a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('67c5cf94-f967-462b-abd1-1d18a1ad6482', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('691b72bb-ceb3-4868-9a9f-f51a08ff6234', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('6ee7c4d1-ed9f-4d5e-92fc-912465321e0e', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('75a3a5c9-da55-43ab-a6c2-0ad1732c86f9', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('761b207e-953f-453e-a2e1-cec97081a0af', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('777d38a2-9e37-4e59-950f-fa2f47669ae8', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('77b4ae92-f095-40eb-a675-886bbca6b852', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('78956573-ac95-4c5a-b590-a31af1df14fb', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('7cba6c5e-a80d-47b6-8db9-2a9ab793e685', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('8117e8c4-29c4-4020-9af0-096691acd64a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('81ed4af7-286b-490b-a72a-b73f7ff46604', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('830b848b-4ae1-425c-a857-e35b53c15482', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('897e5d1a-f750-43ea-bd6b-1be842cab049', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('8ec1470a-afdb-4df4-b66e-1e1cd36d53b7', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('8f6ae126-9204-4a2b-8f49-189e53760c34', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('91f85b85-5140-4e69-b8a2-68e3dc6c6e20', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('94532b3e-1fe5-48a0-84c4-35d734a37ae1', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:30', '2018-03-27 08:45:30');
INSERT INTO `job_execution_log` VALUES ('948c14f0-6a3a-4667-b25c-f2bb7778b95e', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('96fd9903-3811-4ef3-8a13-9abbd3e00158', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');
INSERT INTO `job_execution_log` VALUES ('97e2a45c-66b6-41eb-bcf4-0acc5fb26329', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('9c240470-e14a-4812-9059-1b1d5d1bb07f', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('9d02fd1e-b441-4d69-9cda-75d13d3af79b', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('a0d0b02c-5511-4202-a878-f661e9a77337', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('a1636d12-0fa1-4444-bcb5-0b10ed0d1e08', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('a16ac219-8226-4b19-8ee5-316ef4d42231', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('a272e5b3-f37b-4a8d-b6ac-f4be282d58d1', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('a2c2f09e-1acd-4249-b3d1-4f045ab1afff', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('a537d5a4-6f91-44aa-b255-6f438358db7d', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('a5ec4399-de63-4d5b-ac52-ef5546f48dff', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('a60cf9a6-48bb-42a0-adfd-b8e61fe94020', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('a8b60b87-08db-4631-aa1a-394f23057fdb', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('a92a8e78-e00a-461a-8816-c5e229334ae5', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('b3c83215-7c19-4571-8961-6b7cfd1bce2a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('b41feca4-4fe2-4156-bebd-744295ae1b16', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('b4445bb5-76d2-41ee-a563-3088cb4a0f26', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('b4a96749-6dc4-42e4-8382-d69d4699ba0f', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:29', '2018-03-27 08:45:29');
INSERT INTO `job_execution_log` VALUES ('b53be9ff-ce75-4429-928f-87dc15f4e255', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('b60e50bc-3c99-42d0-922a-faf9383a200f', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('b9272e2e-8dd2-49d1-9331-21658e4863fe', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('baa28893-9695-41f1-b5cd-958553e3a489', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:17', '2018-03-27 08:45:17');
INSERT INTO `job_execution_log` VALUES ('bdadcfd7-2635-458c-a1e7-aca2ca24287a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');
INSERT INTO `job_execution_log` VALUES ('c088e104-b07f-484b-91a4-2789fa52910c', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:09', '2018-03-27 08:45:09');
INSERT INTO `job_execution_log` VALUES ('c0d77639-c95c-4cb8-97a6-72cfd34c957a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:34', '2018-03-27 08:45:34');
INSERT INTO `job_execution_log` VALUES ('c2531928-632a-4c84-a450-ba9d4763c7ed', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('c3bb79a9-7821-429f-87e2-07e93ec7ffc1', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('c3fca60a-9ff0-4e8c-b05a-2441f13a53c4', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:25', '2018-03-27 08:45:25');
INSERT INTO `job_execution_log` VALUES ('c42631b8-8d7a-4e34-ba45-fb85ec561183', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:21', '2018-03-27 08:45:21');
INSERT INTO `job_execution_log` VALUES ('ca2c8b99-e3f5-47f1-8055-93e0c080be3c', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('cb263a14-38be-481b-a24d-41cbcd42f53f', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:10', '2018-03-27 08:45:10');
INSERT INTO `job_execution_log` VALUES ('cb85508a-7823-4ff8-ac51-fd9d1ccb3374', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:33', '2018-03-27 08:45:33');
INSERT INTO `job_execution_log` VALUES ('d1669a5a-3991-4df7-9329-2fc5706bb937', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:38', '2018-03-27 08:45:38');
INSERT INTO `job_execution_log` VALUES ('d1a55bc2-c577-4ad9-8be8-36dc6e9778ff', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'MISFIRE', null, '1', '2018-03-27 08:45:18', '2018-03-27 08:45:18');
INSERT INTO `job_execution_log` VALUES ('d2ba04c7-b0fc-487f-8769-9f758c8f819e', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('d6211116-60c2-4f12-948a-c7e12d7747b0', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:37', '2018-03-27 08:45:37');
INSERT INTO `job_execution_log` VALUES ('d6677608-a840-41c1-bcdc-864baef26e2b', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:14', '2018-03-27 08:45:14');
INSERT INTO `job_execution_log` VALUES ('dbadd263-1a08-49f4-8437-b4a83af68e60', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('ddcbed31-33e6-4358-914d-27ae133f3116', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('dfca49c1-c671-4600-ad04-2bd01e2e9ec1', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('e4f069ed-a4c8-4ed0-ab77-021d83589cf4', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');
INSERT INTO `job_execution_log` VALUES ('e68b42ed-9c9a-4d68-aca8-77faec7d91b0', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'MISFIRE', null, '1', '2018-03-27 08:45:22', '2018-03-27 08:45:22');
INSERT INTO `job_execution_log` VALUES ('e76186e6-779f-40d9-9adf-9cc22d9b73d6', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');
INSERT INTO `job_execution_log` VALUES ('e89f172c-c9b7-47fa-9e65-08bc85dba517', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:04', '2018-03-27 08:45:04');
INSERT INTO `job_execution_log` VALUES ('ea66a077-ab6a-410b-bff7-9716ef942cf6', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:44:59', '2018-03-27 08:44:59');
INSERT INTO `job_execution_log` VALUES ('ef4e84f0-56a7-4761-8a1f-8bc7f3e958d1', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '0', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('f12667e9-c6ca-46ee-9005-8bd41131ca91', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:03', '2018-03-27 08:45:03');
INSERT INTO `job_execution_log` VALUES ('f1439855-c3e1-4e66-a30e-77b038e96a1a', 'com.github.pig.daemon.job.PigSimpleJob', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:00', '2018-03-27 08:45:00');
INSERT INTO `job_execution_log` VALUES ('f53b96cc-6862-4a98-8b6f-a0f61fd6941d', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '1', 'MISFIRE', null, '1', '2018-03-27 08:45:26', '2018-03-27 08:45:26');
INSERT INTO `job_execution_log` VALUES ('ff55bb8c-b4f6-4730-9d5d-e6279e6f993a', 'com.github.pig.daemon.job.DemoSimpleJob', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', 'LXH', '172.31.76.193', '2', 'NORMAL_TRIGGER', null, '1', '2018-03-27 08:45:13', '2018-03-27 08:45:13');

-- ----------------------------
-- Table structure for `job_status_trace_log`
-- ----------------------------
DROP TABLE IF EXISTS `job_status_trace_log`;
CREATE TABLE `job_status_trace_log` (
  `id` varchar(40) NOT NULL,
  `job_name` varchar(100) NOT NULL,
  `original_task_id` varchar(255) NOT NULL,
  `task_id` varchar(255) NOT NULL,
  `slave_id` varchar(50) NOT NULL,
  `source` varchar(50) NOT NULL,
  `execution_type` varchar(20) NOT NULL,
  `sharding_item` varchar(100) NOT NULL,
  `state` varchar(20) NOT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `creation_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TASK_ID_STATE_INDEX` (`task_id`,`state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job_status_trace_log
-- ----------------------------
INSERT INTO `job_status_trace_log` VALUES ('021ffb6d-5b86-46be-ace3-75834873d0d6', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('077c40fb-bed7-4919-ad77-a9d98ea9bf3c', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('078aef81-a7ea-4c98-9dd9-6f7cd472910e', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('0b49d0e7-85a5-43dd-9175-2d0524e16466', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:05');
INSERT INTO `job_status_trace_log` VALUES ('0e2a66b1-6c8d-4079-8ca9-bbd96ee92acb', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('0fcfd222-df65-4235-a012-a57bccda5a90', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:04');
INSERT INTO `job_status_trace_log` VALUES ('19ac2f9a-808d-42f7-a003-ee82f1cf82d5', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:04');
INSERT INTO `job_status_trace_log` VALUES ('1d52a7d3-7ad5-4e31-bc63-cf919f0853e4', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('1ddbd289-9fd2-47fa-9712-2970919e7b1f', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('1fcc1db1-b421-4791-8290-aaa1c4067e05', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('21306318-369d-45c1-a884-d080162051d3', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('21eefa81-368d-488f-80d5-c1f82441a730', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('22ac5086-7ca6-4c52-9f52-c48f43324722', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('27014e96-56ae-465d-a144-75cb1fffa3b1', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('278631a9-f3fb-4146-aaf7-4802f7cc927e', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:01');
INSERT INTO `job_status_trace_log` VALUES ('28fae6b2-4c60-4a81-9cf5-9fde9196df81', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('2da6c9ac-2209-496a-b8e0-37dd07c1462c', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('36ef37e0-bf77-4cb0-ba53-4ce3c5ee077f', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:10');
INSERT INTO `job_status_trace_log` VALUES ('39510537-1815-46e8-8fd4-dd2a535605b9', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('3a3122f1-3966-4250-a75a-9e51d31fe82b', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('3c2f08b9-f817-463a-b55f-f9c37e7ad79d', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:15');
INSERT INTO `job_status_trace_log` VALUES ('3d176b75-fbd5-4984-bac7-0d4375e58458', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:14');
INSERT INTO `job_status_trace_log` VALUES ('3ef18229-67e7-4666-9fdf-c08d8c65a10e', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:38');
INSERT INTO `job_status_trace_log` VALUES ('42540c64-4ec0-4a2e-8118-bcdd166247fc', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('43475406-f03f-4455-958d-11b025f89b19', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('46029e2b-2567-41ab-85b0-8808c80c7690', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('4c76c3fb-2cc4-494c-8b6c-b10bb5ebc15a', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('4e1bb92d-5240-464e-8531-d1adcced9b02', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:38');
INSERT INTO `job_status_trace_log` VALUES ('50bbe34b-cc1f-459e-b48c-86b841560fdf', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:22');
INSERT INTO `job_status_trace_log` VALUES ('524b6680-79e1-428b-8f71-c8087c75c088', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:19');
INSERT INTO `job_status_trace_log` VALUES ('53546611-35cc-4407-a254-debe4630d580', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('53ca764c-990f-46be-9750-d9bb68ccaf3b', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:22');
INSERT INTO `job_status_trace_log` VALUES ('56ab78ce-5b13-43c3-b5e7-a2ac772ecb40', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('56e20b58-4389-42ae-b5aa-e32b8fb9c1a8', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('5c988f0f-af07-49a2-934d-391fb2178b83', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:31');
INSERT INTO `job_status_trace_log` VALUES ('5efb5a09-7776-46d8-963c-11a67b13ffdd', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:35');
INSERT INTO `job_status_trace_log` VALUES ('63628360-30a3-4d05-85f0-bff87cbf8cee', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:19');
INSERT INTO `job_status_trace_log` VALUES ('64ed181f-e28b-4bc9-b859-3b461fd286e3', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:11');
INSERT INTO `job_status_trace_log` VALUES ('64fdde4f-1c82-41b5-99e1-cfcdf6503d4e', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('65073635-fc69-4066-98b8-caad965e43d4', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:39');
INSERT INTO `job_status_trace_log` VALUES ('684e1d7e-56de-41e9-b94d-72ef9957303c', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('69e104b4-45aa-4365-8504-ecf9b6704935', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('6bcf0463-839b-4d55-b92d-8febfaca296b', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:26');
INSERT INTO `job_status_trace_log` VALUES ('6f0af1cf-54e2-4427-8591-e348b47cc7a6', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('6fa769ec-8b7f-493c-97a0-effdb0abd8c2', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:27');
INSERT INTO `job_status_trace_log` VALUES ('74e01c63-c9f3-450d-95da-1408dcc4409e', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:01');
INSERT INTO `job_status_trace_log` VALUES ('75b62b78-a2c4-4895-950f-75332d9591c5', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:22');
INSERT INTO `job_status_trace_log` VALUES ('7a1a7833-80a0-4fd2-9e4f-ac8872373852', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:00');
INSERT INTO `job_status_trace_log` VALUES ('7dae13c2-4703-4ea6-ac6f-d2185841a648', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('7fda85f6-8b3f-4852-9177-1f57c035f45e', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('84d1e5c3-54b4-4ae3-9604-13dd6df7be44', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('86834e31-b352-401e-ae77-4907e69304b3', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('873fcdb2-a762-4a80-8786-fd244bd34c29', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:18');
INSERT INTO `job_status_trace_log` VALUES ('8c54db5d-1653-44a6-bdb9-641376fa2861', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('8f67abce-60d9-4f45-8f6d-3c90953d53f1', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('9121d1be-a191-463e-a260-ed5e2fba9cfd', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:14');
INSERT INTO `job_status_trace_log` VALUES ('92ba1a3c-570f-4556-af91-5a84c8d3845f', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:18');
INSERT INTO `job_status_trace_log` VALUES ('932eba90-8ba8-4ea2-8214-d7772ce6da62', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:05');
INSERT INTO `job_status_trace_log` VALUES ('99e7edd7-aede-4526-8892-bedede6e70d0', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('a7a9e20d-6c96-44ff-a7bb-650150be18bc', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('a7f10baf-380e-4179-a13a-a0ac1d32426b', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:34');
INSERT INTO `job_status_trace_log` VALUES ('a8268af2-67d6-4242-9405-6d3678f41fa3', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('a920df1e-9e10-4c43-ba11-25a62f7dcf6e', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('ab67e057-722c-45b5-8598-fc139e864f55', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('ab8a1983-1488-4fa3-84c1-1e3bfa141ebb', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:21');
INSERT INTO `job_status_trace_log` VALUES ('abd7b787-f333-4588-8ddd-05a99237c593', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:26');
INSERT INTO `job_status_trace_log` VALUES ('aedad4f4-a3ae-420a-a409-cb57c3293cab', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('b1e0a37e-1c74-4d50-825b-62d97ebca37c', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:09');
INSERT INTO `job_status_trace_log` VALUES ('b63ef7fd-f930-4af1-964d-f8af318156db', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('b7582811-ce9b-4581-a370-e9617ccca9a9', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:35');
INSERT INTO `job_status_trace_log` VALUES ('b9cca6b1-11e0-46ae-943e-aa98b232633e', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:10');
INSERT INTO `job_status_trace_log` VALUES ('ba72a17e-a701-48b7-a531-e7b2003ee5ac', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:23');
INSERT INTO `job_status_trace_log` VALUES ('bd9842a7-7a79-42f4-8c82-6d31cccda8ee', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:31');
INSERT INTO `job_status_trace_log` VALUES ('c097baf8-62c1-403b-8e0d-70888c52d304', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('c252e742-1364-4745-8084-2a6d3074f556', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:14');
INSERT INTO `job_status_trace_log` VALUES ('c378ea69-cd34-4d7e-9ed1-655feb56f66c', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:30');
INSERT INTO `job_status_trace_log` VALUES ('c65804d3-6034-4a6a-8164-5d3682d43547', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:30');
INSERT INTO `job_status_trace_log` VALUES ('cf588ccc-b1d0-49db-9fc2-696455985724', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('cf5f7fed-63cf-4089-88a9-e162e27e3caa', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('d04b37d4-9acc-4da9-b676-8853c3141835', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('d2d0d398-cf98-4bdd-968f-305f7900a44b', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:10');
INSERT INTO `job_status_trace_log` VALUES ('d520ba33-5802-400e-b561-05e77891b3ae', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('d65959e0-b683-44ee-83c7-0755dd043b3b', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:03');
INSERT INTO `job_status_trace_log` VALUES ('de1d52e5-172b-449e-96aa-74b32692f775', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('dff9b954-0840-4f23-897d-d54d35b04c7d', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('e3d4c770-4990-41cb-b4fa-46304e79c03c', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:13');
INSERT INTO `job_status_trace_log` VALUES ('e83169ab-a792-49f9-9a01-9c72d4a361d0', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:37');
INSERT INTO `job_status_trace_log` VALUES ('e9bee497-4893-4b87-9b35-e0b711cce6d6', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:33');
INSERT INTO `job_status_trace_log` VALUES ('eea71f4f-1f4b-4e3d-9a4b-fed651e089fa', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('ef6101cc-02d7-4261-ab7a-21946a498087', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('f0c0fc9a-8fd7-4d2d-86c1-e2d0529eec6f', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:44:59');
INSERT INTO `job_status_trace_log` VALUES ('f12b6cb6-3012-4719-af8c-fb48d7d1e208', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('f40cd470-0252-4142-bc84-364d2ddcce75', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:39');
INSERT INTO `job_status_trace_log` VALUES ('f45f0445-910d-4729-bb73-b186142e5089', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:17');
INSERT INTO `job_status_trace_log` VALUES ('f8e95e99-36c7-4c02-a3a2-605ed543d33d', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.PigSimpleJob\' execute begin.', '2018-03-27 08:45:29');
INSERT INTO `job_status_trace_log` VALUES ('faeb3638-de34-42eb-a540-2455f7720744', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:00');
INSERT INTO `job_status_trace_log` VALUES ('fcc77e4b-a056-4296-91f8-ab1b5a645f84', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_STAGING', 'Job \'com.github.pig.daemon.job.DemoSimpleJob\' execute begin.', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('fd21e94a-81c6-456e-984d-5e2e2f297c7b', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_RUNNING', '', '2018-03-27 08:45:34');
INSERT INTO `job_status_trace_log` VALUES ('feaeb18f-5031-4089-b7b7-c8cd8dfb5a56', 'com.github.pig.daemon.job.PigSimpleJob', '', 'com.github.pig.daemon.job.PigSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:25');
INSERT INTO `job_status_trace_log` VALUES ('ff956f8d-cfd0-4350-bd01-fb5e96409846', 'com.github.pig.daemon.job.DemoSimpleJob', '', 'com.github.pig.daemon.job.DemoSimpleJob@-@0,1,2@-@READY@-@172.31.76.193@-@19272', '172.31.76.193', 'LITE_EXECUTOR', 'READY', '[0, 1, 2]', 'TASK_FINISHED', '', '2018-03-27 08:45:26');

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `dept_id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门管理';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '山东农信', null, '2018-01-22 19:00:23', '2018-01-23 12:40:46', '0', '0');
INSERT INTO `sys_dept` VALUES ('2', '沙县国际', null, '2018-01-22 19:00:38', '2018-01-23 12:42:04', '0', '0');
INSERT INTO `sys_dept` VALUES ('3', '潍坊农信', null, '2018-01-22 19:00:44', '2018-01-23 12:40:56', '0', '1');
INSERT INTO `sys_dept` VALUES ('4', '高新农信', null, '2018-01-22 19:00:52', '2018-01-23 12:41:11', '0', '3');
INSERT INTO `sys_dept` VALUES ('5', '院校农信', null, '2018-01-22 19:00:57', '2018-01-23 12:41:22', '0', '4');
INSERT INTO `sys_dept` VALUES ('6', '潍坊学院农信', '115', '2018-01-22 19:01:06', '2018-03-07 16:22:04', '0', '5');
INSERT INTO `sys_dept` VALUES ('7', '山东沙县', null, '2018-01-22 19:01:57', '2018-01-23 12:42:15', '0', '2');
INSERT INTO `sys_dept` VALUES ('8', '潍坊沙县', null, '2018-01-22 19:02:03', '2018-01-23 12:42:23', '0', '7');
INSERT INTO `sys_dept` VALUES ('9', '高新沙县', null, '2018-01-22 19:02:14', '2018-03-07 16:28:14', '0', '8');

-- ----------------------------
-- Table structure for `sys_dept_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_relation`;
CREATE TABLE `sys_dept_relation` (
  `ancestor` int(11) NOT NULL COMMENT '祖先节点',
  `descendant` int(11) NOT NULL COMMENT '后代节点',
  PRIMARY KEY (`ancestor`,`descendant`),
  KEY `idx1` (`ancestor`),
  KEY `idx2` (`descendant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_dept_relation
-- ----------------------------
INSERT INTO `sys_dept_relation` VALUES ('1', '1');
INSERT INTO `sys_dept_relation` VALUES ('1', '3');
INSERT INTO `sys_dept_relation` VALUES ('1', '4');
INSERT INTO `sys_dept_relation` VALUES ('1', '5');
INSERT INTO `sys_dept_relation` VALUES ('1', '6');
INSERT INTO `sys_dept_relation` VALUES ('2', '2');
INSERT INTO `sys_dept_relation` VALUES ('2', '7');
INSERT INTO `sys_dept_relation` VALUES ('2', '8');
INSERT INTO `sys_dept_relation` VALUES ('2', '9');
INSERT INTO `sys_dept_relation` VALUES ('3', '3');
INSERT INTO `sys_dept_relation` VALUES ('3', '4');
INSERT INTO `sys_dept_relation` VALUES ('3', '5');
INSERT INTO `sys_dept_relation` VALUES ('3', '6');
INSERT INTO `sys_dept_relation` VALUES ('4', '4');
INSERT INTO `sys_dept_relation` VALUES ('4', '5');
INSERT INTO `sys_dept_relation` VALUES ('4', '6');
INSERT INTO `sys_dept_relation` VALUES ('5', '5');
INSERT INTO `sys_dept_relation` VALUES ('5', '6');
INSERT INTO `sys_dept_relation` VALUES ('6', '6');
INSERT INTO `sys_dept_relation` VALUES ('7', '7');
INSERT INTO `sys_dept_relation` VALUES ('7', '8');
INSERT INTO `sys_dept_relation` VALUES ('7', '9');
INSERT INTO `sys_dept_relation` VALUES ('8', '8');
INSERT INTO `sys_dept_relation` VALUES ('8', '9');
INSERT INTO `sys_dept_relation` VALUES ('9', '9');

-- ----------------------------
-- Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '0', '正常', 'log_type', '日志正常', '0', '2017-12-28 17:00:23', '2017-12-28 17:00:23', null, '0');
INSERT INTO `sys_dict` VALUES ('2', '9', '异常', 'log_type', '日志异常', '1', '2017-12-28 13:06:39', '2018-01-06 10:54:41', null, '0');

-- ----------------------------
-- Table structure for `sys_log_0`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_0`;
CREATE TABLE `sys_log_0` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `time` mediumtext COMMENT '执行时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='日志表';

-- ----------------------------
-- Records of sys_log_0
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log_1`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log_1`;
CREATE TABLE `sys_log_1` (
  `id` bigint(64) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `service_id` varchar(32) DEFAULT NULL COMMENT '服务ID',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(10) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `time` mediumtext COMMENT '执行时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='日志表';

-- ----------------------------
-- Records of sys_log_1
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(128) DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT NULL COMMENT '排序值',
  `type` char(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', null, '/admin', null, null, '-1', 'icon-xitongguanli', 'Layout', null, '0', '2017-11-07 20:56:00', '2018-03-21 15:47:03', '0');
INSERT INTO `sys_menu` VALUES ('2', '用户管理', null, '/admin/user', null, null, '1', 'icon-yonghuguanli', '_import(\'admin/user\')', null, '0', '2017-11-02 22:24:37', '2018-03-21 15:47:05', '0');
INSERT INTO `sys_menu` VALUES ('3', '菜单管理', null, '/admin/menu', null, null, '1', 'icon-caidanguanli', '_import(\'admin/menu\')', null, '0', '2017-11-08 09:57:27', '2018-03-21 15:46:29', '0');
INSERT INTO `sys_menu` VALUES ('4', '角色管理', null, '/admin/role', null, null, '1', 'icon-jiaoseguanli', '_import(\'admin/role\')', null, '0', '2017-11-08 10:13:37', '2018-03-21 15:46:25', '0');
INSERT INTO `sys_menu` VALUES ('5', '日志管理', null, '/admin/log', null, null, '1', 'icon-rizhiguanli', '_import(\'admin/log\')', null, '0', '2017-11-20 14:06:22', '2018-03-21 15:46:07', '0');
INSERT INTO `sys_menu` VALUES ('6', '字典管理', null, '/admin/dict', null, null, '1', 'icon-zygl', '_import(\'admin/dict\')', null, '0', '2017-11-29 11:30:52', '2018-03-21 15:46:35', '0');
INSERT INTO `sys_menu` VALUES ('7', '部门管理', null, '/admin/dept', null, null, '1', 'icon-iconbmgl', '_import(\'admin/dept\')', null, '0', '2018-01-20 13:17:19', '2018-03-21 15:46:44', '0');
INSERT INTO `sys_menu` VALUES ('8', '系统监控', null, '#/monitor:5001', null, null, '-1', 'icon-iconbmgl', null, null, '0', '2018-01-22 12:30:41', '2018-03-21 16:15:47', '0');
INSERT INTO `sys_menu` VALUES ('9', '服务监控', null, 'http://106.14.69.75:15005', null, null, '8', 'icon-jiankong', null, null, '0', '2018-01-23 10:53:33', '2018-03-21 20:28:59', '0');
INSERT INTO `sys_menu` VALUES ('10', 'zipkin监控', null, 'http://127.0.0.1:5003', null, null, '8', 'icon-jiankong', null, null, '0', '2018-01-23 10:55:18', '2018-03-21 20:44:58', '0');
INSERT INTO `sys_menu` VALUES ('11', 'pinpoint监控', null, 'http://106.14.69.75:28080', null, null, '8', 'icon-xiazaihuancun', null, null, '0', '2018-01-25 11:08:52', '2018-03-21 20:31:34', '0');
INSERT INTO `sys_menu` VALUES ('12', '缓存状态', null, 'http://106.14.69.75:15005', null, null, '8', 'icon-ecs-status', null, null, '0', '2018-01-23 10:56:11', '2018-03-21 20:31:23', '0');
INSERT INTO `sys_menu` VALUES ('13', 'ELK状态', null, 'http://106.14.69.75:5601', null, null, '8', 'icon-ecs-status', null, null, '0', '2018-01-23 10:55:47', '2018-03-21 20:32:26', '0');
INSERT INTO `sys_menu` VALUES ('14', '接口文档', null, 'http://127.0.0.1:9999/swagger-ui.html', null, null, '8', 'icon-wendangdocument72', null, null, '0', '2018-01-23 10:56:43', '2018-03-21 20:26:58', '0');
INSERT INTO `sys_menu` VALUES ('15', '任务监控', null, 'http://106.14.69.75:8899', null, null, '8', 'icon-jiankong', null, null, '0', '2018-01-23 10:55:18', '2018-03-21 20:43:23', '0');
INSERT INTO `sys_menu` VALUES ('21', '用户查看', '', null, '/admin/user/**', 'GET', '2', null, null, null, '1', '2017-11-07 20:58:05', '2018-02-04 14:28:49', '0');
INSERT INTO `sys_menu` VALUES ('22', '用户新增', 'sys_user_add', null, '/admin/user/*', 'POST', '2', null, null, null, '1', '2017-11-08 09:52:09', '2017-12-04 16:31:10', '0');
INSERT INTO `sys_menu` VALUES ('23', '用户修改', 'sys_user_upd', null, '/admin/user/**', 'PUT', '2', null, null, null, '1', '2017-11-08 09:52:48', '2018-01-17 17:40:01', '0');
INSERT INTO `sys_menu` VALUES ('24', '用户删除', 'sys_user_del', null, '/admin/user/*', 'DELETE', '2', null, null, null, '1', '2017-11-08 09:54:01', '2017-12-04 16:31:18', '0');
INSERT INTO `sys_menu` VALUES ('31', '菜单查看', null, null, '/admin/menu/**', 'GET', '3', null, null, null, '1', '2017-11-08 09:57:56', '2017-11-14 17:29:17', '0');
INSERT INTO `sys_menu` VALUES ('32', '菜单新增', 'sys_menu_add', null, '/admin/menu/*', 'POST', '3', null, null, null, '1', '2017-11-08 10:15:53', '2018-01-20 14:37:50', '0');
INSERT INTO `sys_menu` VALUES ('33', '菜单修改', 'sys_menu_edit', null, '/admin/menu/*', 'PUT', '3', null, null, null, '1', '2017-11-08 10:16:23', '2018-01-20 14:37:56', '0');
INSERT INTO `sys_menu` VALUES ('34', '菜单删除', 'sys_menu_del', null, '/admin/menu/*', 'DELETE', '3', null, null, null, '1', '2017-11-08 10:16:43', '2018-01-20 14:38:03', '0');
INSERT INTO `sys_menu` VALUES ('41', '角色查看', null, null, '/admin/role/**', 'GET', '4', null, null, null, '1', '2017-11-08 10:14:01', '2018-02-04 13:55:06', '0');
INSERT INTO `sys_menu` VALUES ('42', '角色新增', null, null, '/admin/role/*', 'POST', '4', null, null, null, '1', '2017-11-08 10:14:18', '2017-11-14 14:10:03', '0');
INSERT INTO `sys_menu` VALUES ('43', '角色修改', null, null, '/admin/role/*', 'PUT', '4', null, null, null, '1', '2017-11-08 10:14:41', '2017-11-08 20:35:33', '0');
INSERT INTO `sys_menu` VALUES ('44', '角色删除', null, null, '/admin/role/*', 'DELETE', '4', null, null, null, '1', '2017-11-08 10:14:59', '2017-11-08 20:35:35', '0');
INSERT INTO `sys_menu` VALUES ('51', '日志查看', null, null, '/admin/log/**', 'GET', '5', null, null, null, '1', '2017-11-20 14:07:25', '2018-02-04 14:28:53', '0');
INSERT INTO `sys_menu` VALUES ('52', '日志删除', 'sys_log_del', null, '/admin/log/*', 'DELETE', '5', null, null, null, '1', '2017-11-20 20:37:37', '2017-11-28 17:36:52', '0');
INSERT INTO `sys_menu` VALUES ('61', '字典查看', null, null, '/admin/dict/**', 'GET', '6', null, null, null, '1', '2017-11-19 22:04:24', '2017-11-29 11:31:24', '0');
INSERT INTO `sys_menu` VALUES ('62', '字典删除', 'sys_dict_del', null, '/admin/dict/**', 'DELETE', '6', null, null, null, '1', '2017-11-29 11:30:11', '2018-01-07 15:40:51', '0');
INSERT INTO `sys_menu` VALUES ('71', '部门查看', '', null, '/admin/dept/**', 'GET', '7', null, '', null, '1', '2018-01-20 13:17:19', '2018-01-20 14:55:24', '0');
INSERT INTO `sys_menu` VALUES ('72', '部门新增', 'sys_dept_add', null, '/admin/dept/**', 'POST', '7', null, null, null, '1', '2018-01-20 14:56:16', '2018-01-20 21:17:57', '0');
INSERT INTO `sys_menu` VALUES ('73', '部门修改', 'sys_dept_edit', null, '/admin/dept/**', 'PUT', '7', null, null, null, '1', '2018-01-20 14:56:59', '2018-01-20 21:17:59', '0');
INSERT INTO `sys_menu` VALUES ('74', '部门删除', 'sys_dept_del', null, '/admin/dept/**', 'DELETE', '7', null, null, null, '1', '2018-01-20 14:57:28', '2018-01-20 21:18:05', '0');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `role_code` varchar(64) COLLATE utf8_bin NOT NULL,
  `role_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL,
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'ROLE_ADMIN', '超级管理员', '2017-10-29 15:45:51', '2018-01-28 12:46:43', '0');
INSERT INTO `sys_role` VALUES ('13', 'test', 'test', '测965230', '2018-03-07 17:37:45', '2018-03-08 13:24:40', '0');

-- ----------------------------
-- Table structure for `sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` int(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色与部门对应关系';

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('11', '1', '1');
INSERT INTO `sys_role_dept` VALUES ('12', '13', '6');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1');
INSERT INTO `sys_role_menu` VALUES ('1', '2');
INSERT INTO `sys_role_menu` VALUES ('1', '3');
INSERT INTO `sys_role_menu` VALUES ('1', '4');
INSERT INTO `sys_role_menu` VALUES ('1', '5');
INSERT INTO `sys_role_menu` VALUES ('1', '6');
INSERT INTO `sys_role_menu` VALUES ('1', '7');
INSERT INTO `sys_role_menu` VALUES ('1', '8');
INSERT INTO `sys_role_menu` VALUES ('1', '9');
INSERT INTO `sys_role_menu` VALUES ('1', '10');
INSERT INTO `sys_role_menu` VALUES ('1', '11');
INSERT INTO `sys_role_menu` VALUES ('1', '12');
INSERT INTO `sys_role_menu` VALUES ('1', '13');
INSERT INTO `sys_role_menu` VALUES ('1', '14');
INSERT INTO `sys_role_menu` VALUES ('1', '15');
INSERT INTO `sys_role_menu` VALUES ('1', '21');
INSERT INTO `sys_role_menu` VALUES ('1', '22');
INSERT INTO `sys_role_menu` VALUES ('1', '23');
INSERT INTO `sys_role_menu` VALUES ('1', '24');
INSERT INTO `sys_role_menu` VALUES ('1', '31');
INSERT INTO `sys_role_menu` VALUES ('1', '32');
INSERT INTO `sys_role_menu` VALUES ('1', '33');
INSERT INTO `sys_role_menu` VALUES ('1', '34');
INSERT INTO `sys_role_menu` VALUES ('1', '41');
INSERT INTO `sys_role_menu` VALUES ('1', '42');
INSERT INTO `sys_role_menu` VALUES ('1', '43');
INSERT INTO `sys_role_menu` VALUES ('1', '44');
INSERT INTO `sys_role_menu` VALUES ('1', '51');
INSERT INTO `sys_role_menu` VALUES ('1', '52');
INSERT INTO `sys_role_menu` VALUES ('1', '61');
INSERT INTO `sys_role_menu` VALUES ('1', '62');
INSERT INTO `sys_role_menu` VALUES ('1', '71');
INSERT INTO `sys_role_menu` VALUES ('1', '72');
INSERT INTO `sys_role_menu` VALUES ('1', '73');
INSERT INTO `sys_role_menu` VALUES ('1', '74');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `salt` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '随机盐',
  `introduction` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '简介',
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '头像',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_idx1_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$gBejTEife2WvJzysrRDXL.MVNCcBsso3adMZWQDsVewCDUaIsIvSK', null, '17034642119', 'http://p0hpm86wj.bkt.clouddn.com/10bd0c7c-03c7-4ad1-8366-b24b4201b969.png', '1', '2017-10-29 15:45:13', '2018-02-03 13:29:28', '0');

-- ----------------------------
-- Table structure for `sys_userconnection`
-- ----------------------------
DROP TABLE IF EXISTS `sys_userconnection`;
CREATE TABLE `sys_userconnection` (
  `userId` varchar(128) CHARACTER SET utf8 NOT NULL,
  `providerId` varchar(128) CHARACTER SET utf8 NOT NULL,
  `providerUserId` varchar(128) CHARACTER SET utf8 NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `profileUrl` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `imageUrl` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `accessToken` varchar(512) CHARACTER SET utf8 NOT NULL,
  `secret` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `refreshToken` varchar(512) CHARACTER SET utf8 DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_userconnection
-- ----------------------------
INSERT INTO `sys_userconnection` VALUES ('B86F3FDF72CD481F4AA094A2345BF446', 'qq', 'B86F3FDF72CD481F4AA094A2345BF446', '1', '冷冷', null, 'http://q.qlogo.cn/qqapp/101322838/B86F3FDF72CD481F4AA094A2345BF446/40', 'E09B51404CDC276F463D05DF1C573514', null, 'B30A1C7C8601259F220807DD2EAA412E', '1524300218147');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
