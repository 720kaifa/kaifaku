/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50126
Source Host           : localhost:3306
Source Database       : simpleoa

Target Server Type    : MYSQL
Target Server Version : 50126
File Encoding         : 65001

Date: 2017-12-21 16:37:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `s_loginlog`;
CREATE TABLE `s_loginlog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relname` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `loginip` varchar(20) DEFAULT NULL,
  `logintime` varchar(50) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_loginlog
-- ----------------------------
INSERT INTO `s_loginlog` VALUES ('1', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:14:08', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('2', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:16:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('4', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:23:19', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('8', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:39:40', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('9', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:39:57', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('10', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 15:44:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('14', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:01:55', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('15', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:02:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('16', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:03:13', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('17', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:07:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('44', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:10:58', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('46', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:27:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('47', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 16:37:01', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('48', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 16:53:37', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('49', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 08:42:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('53', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:20:41', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('54', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:35:14', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('55', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:51:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('56', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 11:00:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('57', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:15:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('64', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:57:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('67', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 15:15:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('69', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 15:32:41', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('71', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:05:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('72', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:10:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('73', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:31:10', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('74', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 09:00:25', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('75', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 10:59:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('76', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:49', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('77', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:49', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('78', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('79', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('80', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('81', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('82', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:58', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('83', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:02:58', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('84', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:07:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('85', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 11:50:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('86', '管理员', 'admin', '1', '127.0.0.1', null, null, '2017-12-11 13:17:19', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('87', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:02:30', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('88', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:04:24', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('89', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:18:37', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('90', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:21:56', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('91', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:30:17', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('92', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:32:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('93', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:34:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('94', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-11 16:39:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('95', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-11 16:47:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('96', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 09:24:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('97', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 09:44:37', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('98', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 09:51:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('99', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 10:12:08', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('100', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:37:47', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('101', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:40:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('102', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:42:53', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('103', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:46:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('104', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:48:16', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('105', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:49:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('106', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:52:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('107', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:57:36', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('108', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 11:59:38', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('109', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 12:05:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('110', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 12:17:26', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('111', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 12:18:22', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('112', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:06:57', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('113', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:08:16', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('114', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:19:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('115', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:21:54', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('116', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:23:53', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('117', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:25:20', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('118', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:31:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('119', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:34:06', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('120', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:34:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('121', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:35:55', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('122', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:37:02', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('123', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:56:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('124', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 13:57:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('125', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:01:47', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('126', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:03:09', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('127', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:04:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('128', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:05:07', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('129', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:13:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('130', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:31:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('131', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 14:54:22', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('132', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 15:11:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('133', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 15:37:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('134', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 15:38:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('135', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-12 15:41:30', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('136', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 15:49:00', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('137', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:31:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('138', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:32:47', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('139', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:33:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('140', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:46:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('141', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:48:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('142', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:49:46', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('143', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-12 16:55:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('144', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 10:31:54', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('145', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 10:39:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('146', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 10:40:54', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('147', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 10:41:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('148', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 11:00:26', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('149', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 11:01:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('150', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 12:53:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('151', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 12:55:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('152', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 15:18:04', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('153', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 15:23:21', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('154', '裘斌斌', 'qbb', '3', '127.0.0.1', null, null, '2017-12-13 15:26:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('155', '应锴', 'yk', '2', '127.0.0.1', null, null, '2017-12-13 15:33:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('156', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 15:50:25', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('157', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-13 15:53:49', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('158', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 10:34:39', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('159', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 13:28:08', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('160', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 14:09:57', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('161', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 14:34:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('162', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 14:43:25', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('163', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 15:21:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('164', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 16:00:25', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('165', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 16:05:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('166', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 16:42:07', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('167', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 16:50:26', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('168', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-14 16:55:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('169', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 10:03:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('170', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 10:06:05', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('171', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 10:10:55', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('172', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 12:55:12', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('173', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 15:19:24', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('174', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 15:32:00', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('175', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 15:39:21', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('176', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-15 16:35:43', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('177', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-18 16:44:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('178', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-18 17:00:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('179', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 09:31:07', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('180', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 10:11:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('181', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 10:16:22', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('182', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 10:25:25', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('183', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 14:56:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('184', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 14:58:00', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('185', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 14:58:40', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('186', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 15:46:20', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('187', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-19 16:51:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('188', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 10:40:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('189', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 11:53:05', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('190', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 11:56:06', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('191', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 11:59:39', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('192', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 12:16:54', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('193', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 13:11:36', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('194', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 13:15:02', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('195', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 13:24:54', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('196', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 14:30:40', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('197', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 14:45:20', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('198', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 14:47:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('199', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 16:22:39', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('200', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-21 16:29:13', 'SYSTEM', null, null);

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `lid` varchar(50) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `sort` decimal(2,0) DEFAULT NULL,
  `authority` decimal(2,0) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', 'dashbo', 'home', 'sy', '主页', '1', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('2', 'workLog', 'list-alt', 'gzrz', '工作日志', '2', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('3', 'project', 'align-justify', 'gzxm', '工程项目', '4', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('4', 'addUser', 'plus', 'tjyh', '添加用户', '5', '1', null, '2017-12-06 15:16:00', 'admin', null, null);
INSERT INTO `s_menu` VALUES ('5', 'mainSetting', 'cog', 'sysz', '首页设置', '6', '2', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('6', 'updateUser', 'user', 'personinf', '个人信息', '7', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('7', 'changePassword', 'lock', 'changepass', '修改密码', '8', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('8', 'countWorkTime', 'pushpin', 'cwt', '工时统计', '3', '3', null, '2017-12-08 15:13:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('9', 'notice', 'gift', 'notice', '公告管理', '9', '2', null, '2017-12-19 15:13:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('10', 'news', 'camera', 'news', '新闻管理', '10', '2', null, '2017-12-19 15:13:00', 'yk', null, null);

-- ----------------------------
-- Table structure for s_news
-- ----------------------------
DROP TABLE IF EXISTS `s_news`;
CREATE TABLE `s_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `relname` varchar(50) DEFAULT NULL,
  `istop` decimal(2,0) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_news
-- ----------------------------
INSERT INTO `s_news` VALUES ('1', '123', '123123123123123123', '应锴', '2', null, '2017-12-21 13:15:31', 'yk', '2017-12-21 14:48:00', 'yk');
INSERT INTO `s_news` VALUES ('2', '投票系统', '投票系统上线啦', '应锴', '1', null, '2017-12-21 14:51:39', 'yk', null, null);

-- ----------------------------
-- Table structure for s_notice
-- ----------------------------
DROP TABLE IF EXISTS `s_notice`;
CREATE TABLE `s_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `relname` varchar(50) DEFAULT NULL,
  `istop` decimal(2,0) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_notice
-- ----------------------------
INSERT INTO `s_notice` VALUES ('3', '123456', '123456789', '应锴', '2', null, '2017-12-21 13:15:45', 'yk', '2017-12-21 14:51:11', 'yk');
INSERT INTO `s_notice` VALUES ('4', '投票', '投票开始了，欢迎大家踊跃参加33333', '应锴', '1', null, '2017-12-21 13:28:32', 'yk', '2017-12-21 16:29:45', 'yk');

-- ----------------------------
-- Table structure for s_project
-- ----------------------------
DROP TABLE IF EXISTS `s_project`;
CREATE TABLE `s_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `projectname` varchar(255) NOT NULL,
  `projectdec` varchar(1000) DEFAULT NULL,
  `starttime` varchar(50) DEFAULT NULL,
  `endtime` varchar(50) DEFAULT NULL,
  `estimated` varchar(50) DEFAULT NULL,
  `projectstatus` decimal(2,0) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_project
-- ----------------------------
INSERT INTO `s_project` VALUES ('1', 'SimpleOA系统开发', 'SimpleOA系统开发', '2017-11-25', '', '2017-12-09', '1', null, '2017-11-25 15:00:00', 'admin', '2017-12-19 13:25:03', 'yk');
INSERT INTO `s_project` VALUES ('2', 'git使用', 'git如何使用', '2017-11-30', '', '2017-12-06', '1', null, '2017-11-30 15:00:00', 'admin', '2017-12-19 13:20:46', 'yk');
INSERT INTO `s_project` VALUES ('4', '微信公众号开发', '微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发', '2017-12-08', '', '2017-12-29', '1', null, '2017-12-08 09:08:18', 'yk', '2017-12-19 11:59:57', 'yk');
INSERT INTO `s_project` VALUES ('5', 'SimpleOA测试', 'SimpleOA测试336', '2017-12-08', '2017-12-19', '2017-12-16', '2', null, '2017-12-13 16:04:24', 'yk', '2017-12-19 12:36:14', 'yk');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numid` varchar(20) NOT NULL,
  `relname` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `age` decimal(3,0) DEFAULT NULL,
  `gender` decimal(1,0) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `interest` varchar(50) DEFAULT NULL,
  `mphone` decimal(15,0) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `qq` varchar(50) DEFAULT NULL,
  `wx` varchar(50) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'SA-001', '管理员', 'admin', '123456', '24', '1', 'SuperUser', '编程', '12345666666', '银河系太阳', '123654789@SA.com', '895856854', 'forlove', '1993-10-01', null, '1949-10-1', 'SYSTEM', null, null);
INSERT INTO `s_user` VALUES ('2', 'SA-002', '应锴', 'yk', '123', '24', '1', 'AdminUser', '你猜啊', '12345678983', 'M78星云', '364146@SA.com', '33646416', 'rt', '1993-07-13', null, '2017-12-05 14:17:07', 'admin', null, null);
INSERT INTO `s_user` VALUES ('3', 'SA-003', '裘斌斌', 'qbb', '123456', '20', '1', 'OrdinaryUser', null, null, null, null, null, null, null, null, '2017-12-05 14:22:07', 'admin', null, null);
INSERT INTO `s_user` VALUES ('4', 'SA-004', '王振', 'wz', '123456', '20', '1', 'OrdinaryUser', null, null, null, null, null, null, null, null, '2017-12-05 16:02:16', 'admin', null, null);
INSERT INTO `s_user` VALUES ('5', 'SA-005', '杨尚杭', 'ysh', '123456', '0', '0', 'OrdinaryUser', null, null, null, null, null, null, null, null, '2017-12-08 15:20:52', 'admin', null, null);
INSERT INTO `s_user` VALUES ('6', 'SA-006', '老王', 'lw', '123456', '0', '0', 'OrdinaryUser', null, null, null, null, null, null, null, null, '2017-12-08 15:22:01', 'admin', null, null);
INSERT INTO `s_user` VALUES ('7', 'SA-007', '张三', 'zs', '123456', '0', '0', 'OrdinaryUser', null, null, null, null, null, null, null, null, '2017-12-08 15:23:08', 'admin', null, null);

-- ----------------------------
-- Table structure for s_worklog
-- ----------------------------
DROP TABLE IF EXISTS `s_worklog`;
CREATE TABLE `s_worklog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `relname` varchar(50) NOT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `worktime` decimal(2,0) DEFAULT NULL,
  `jcontent` varchar(500) DEFAULT NULL,
  `cdescribe` varchar(1000) DEFAULT NULL,
  `summary` varchar(500) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  `projectname` varchar(255) DEFAULT NULL,
  `projectid` bigint(20) DEFAULT NULL,
  `workdate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_worklog
-- ----------------------------
INSERT INTO `s_worklog` VALUES ('2', '应锴', '2', '3', 'SimpleOA开发', '主要是做工作日志添加的功能', '哎呦哦，不错哦', null, '2017-12-05 15:50:38', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-05');
INSERT INTO `s_worklog` VALUES ('3', '应锴', '2', '2', 'SimpleOA开发', '工作日志功能开发', '哎呦，不错哦', null, '2017-12-05 15:55:13', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-05');
INSERT INTO `s_worklog` VALUES ('4', '王振', '4', '24', '玩', '玩玩玩', '好玩', null, '2017-12-05 16:08:11', 'wz', null, null, 'SimpleOA系统开发', '1', '2017-12-05');
INSERT INTO `s_worklog` VALUES ('5', '应锴', '2', '3', '1', '3', '3', null, '2017-12-06 10:07:05', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('6', '应锴', '2', '4', '1', '2', '5', null, '2017-12-06 10:07:26', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('7', '应锴', '2', '4', '1', '2', '5', null, '2017-12-06 10:07:26', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('8', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:06', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('9', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:10', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('10', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:10', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('11', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:14', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('12', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:14', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('14', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:14', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('15', '应锴', '2', '1', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:12:23', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('16', '应锴', '2', '3', '3', '4', '4', null, '2017-12-06 15:00:57', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('17', '应锴', '2', '2', 'we', 'wewe', '喂喂喂', null, '2017-12-06 15:18:15', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('18', '应锴', '2', '2', 'q', '去', '请问', null, '2017-12-06 15:48:09', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('19', '应锴', '2', '1', '1', '1', '1', null, '2017-12-07 11:29:17', 'yk', null, null, '	SimpleOA系统开发', '1', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('21', '应锴', '2', '1', '1', '1', '1', null, '2017-12-07 11:42:09', 'yk', null, null, 'git使用', '2', '2017-12-03');
INSERT INTO `s_worklog` VALUES ('22', '应锴', '2', '0', '1', '1', '1', null, '2017-12-08 08:57:41', 'yk', null, null, '微信公众号开发', '4', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('24', '应锴', '2', '1', '123', 'qwer', 'qwer', null, '2017-12-08 15:27:46', 'yk', null, null, '微信公众号开发', '4', '2017-12-07');
INSERT INTO `s_worklog` VALUES ('25', '应锴', '2', '2', 'er', 'sdefg', 'ggggg', null, '2017-12-08 15:30:58', 'yk', null, null, '微信公众号开发', '4', '2017-12-07');
INSERT INTO `s_worklog` VALUES ('26', '管理员', '1', '1', 'git学习', 'git学习', '挺好', null, '2017-12-11 13:59:56', 'admin', '2017-12-18 16:57:29', null, 'git使用', '2', '2017-12-10');
INSERT INTO `s_worklog` VALUES ('27', '应锴', '2', '2', '微信公众号开发', '微信公众号开发', '微信公众号开发', null, '2017-12-11 16:03:03', 'yk', null, null, '微信公众号开发', '4', '2017-12-10');
INSERT INTO `s_worklog` VALUES ('28', '应锴', '2', '1', 'w', 'w', 'wwww', null, '2017-12-11 16:04:46', 'yk', '2017-12-15 10:06:34', null, '微信公众号开发', '4', '2017-12-09');
INSERT INTO `s_worklog` VALUES ('29', '应锴', '2', '1', 'wwe', 'wwe', 'www', null, '2017-12-11 16:11:59', 'yk', null, null, '微信公众号开发', '4', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('30', '应锴', '2', '1', 'wer', 'wer', 'wwr', null, '2017-12-11 16:18:56', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-09');
INSERT INTO `s_worklog` VALUES ('31', '应锴', '2', '2', 'tth', 'tth', 'tth', null, '2017-12-11 16:22:34', 'yk', null, null, 'git使用', '2', '2017-12-05');
INSERT INTO `s_worklog` VALUES ('33', '应锴', '2', '1', 'hht', 'hht', 'hht', null, '2017-12-11 16:26:09', 'yk', null, null, 'git使用', '2', '2017-12-12');
INSERT INTO `s_worklog` VALUES ('34', '应锴', '2', '1', 'ssh', 'ssh', 'ssh', null, '2017-12-11 16:30:49', 'yk', null, null, 'git使用', '2', '2017-12-11');
INSERT INTO `s_worklog` VALUES ('35', '应锴', '2', '1', 'ssm', 'ssm', 'ssm', null, '2017-12-11 16:32:53', 'yk', '2017-12-19 14:17:41', null, 'git使用', '2', '2017-12-11');
INSERT INTO `s_worklog` VALUES ('36', '应锴', '2', '1', 'ssd', 'ssd', 'ssd', null, '2017-12-11 16:34:59', 'yk', null, null, 'git使用', '2', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('38', '应锴', '2', '1', 'ssk', 'ssk', 'ssk23665', null, '2017-12-11 16:40:41', 'yk', '2017-12-14 16:55:59', null, 'git使用', '2', '2017-12-09');
INSERT INTO `s_worklog` VALUES ('39', '裘斌斌', '3', '2', 'wer', '未亡人', '123', null, '2017-12-12 16:32:11', 'qbb', null, null, 'git使用', '2', '2017-12-12');

-- ----------------------------
-- Table structure for s_worktime
-- ----------------------------
DROP TABLE IF EXISTS `s_worktime`;
CREATE TABLE `s_worktime` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) NOT NULL,
  `relname` varchar(50) DEFAULT NULL,
  `projectid` bigint(20) NOT NULL,
  `projectname` varchar(100) DEFAULT NULL,
  `projectstatus` decimal(2,0) DEFAULT NULL,
  `tmworktime` decimal(5,0) DEFAULT NULL,
  `twworktime` decimal(5,0) DEFAULT NULL,
  `coworktime` decimal(5,0) DEFAULT NULL,
  `IS_DELETE` decimal(5,0) DEFAULT NULL,
  `CREATE_TIME` varchar(50) NOT NULL,
  `CREATE_USER` varchar(50) NOT NULL,
  `UPDATE_TIME` varchar(50) DEFAULT NULL,
  `UPDATE_USER` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_worktime
-- ----------------------------
INSERT INTO `s_worktime` VALUES ('1', '2', '应锴', '2', 'git使用', '1', '3', '1', '3', null, '2017-12-11 16:22:34', 'SYSTEM', '2017-12-11 16:22:34', 'SYSTEM');
INSERT INTO `s_worktime` VALUES ('2', '3', '裘斌斌', '2', 'git使用', '1', '2', '2', '2', null, '2017-12-12 16:32:11', 'SYSTEM', '2017-12-12 16:32:11', null);
