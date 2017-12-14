/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50126
Source Host           : localhost:3306
Source Database       : simpleoa

Target Server Type    : MYSQL
Target Server Version : 50126
File Encoding         : 65001

Date: 2017-12-08 16:42:10
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
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_loginlog
-- ----------------------------
INSERT INTO `s_loginlog` VALUES ('1', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:14:08', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('2', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:16:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('3', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:23:00', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('4', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:23:19', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('5', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:25:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('6', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:31:49', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('7', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:39:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('8', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:39:40', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('9', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 14:39:57', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('10', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 15:44:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('11', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 15:44:58', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('12', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 15:49:43', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('13', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 15:54:14', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('14', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:01:55', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('15', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:02:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('16', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:03:13', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('17', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:07:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('18', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-05 16:11:09', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('19', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 10:06:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('20', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 13:26:40', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('21', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 14:23:53', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('22', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 14:55:12', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('23', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 14:57:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('24', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:09:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('25', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:10:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('26', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:17:30', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('27', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:28:15', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('28', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:33:52', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('29', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:36:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('30', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:38:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('31', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 15:39:47', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('32', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 16:16:12', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('33', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 16:19:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('34', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-06 16:39:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('35', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 09:27:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('36', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 10:09:09', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('37', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 11:18:19', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('38', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 13:24:53', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('39', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 13:31:05', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('40', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 14:32:56', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('41', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 14:37:29', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('42', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 14:41:38', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('43', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:07:51', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('44', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:10:58', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('45', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:15:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('46', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 15:27:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('47', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 16:37:01', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('48', '王振', 'wz', '4', '0:0:0:0:0:0:0:1', null, null, '2017-12-07 16:53:37', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('49', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 08:42:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('50', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 08:42:36', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('51', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 09:05:56', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('52', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 09:08:04', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('53', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:20:41', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('54', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:35:14', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('55', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 10:51:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('56', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 11:00:59', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('57', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:15:18', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('58', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:18:03', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('59', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:21:45', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('60', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:24:44', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('61', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:30:17', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('62', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:32:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('63', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:50:50', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('64', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 12:57:34', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('65', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 13:01:07', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('66', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 14:01:28', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('67', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 15:15:31', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('68', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 15:23:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('69', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 15:32:41', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('70', '应锴', 'yk', '2', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:00:09', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('71', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:05:33', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('72', '管理员', 'admin', '1', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:10:48', 'SYSTEM', null, null);
INSERT INTO `s_loginlog` VALUES ('73', '裘斌斌', 'qbb', '3', '0:0:0:0:0:0:0:1', null, null, '2017-12-08 16:31:10', 'SYSTEM', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------
INSERT INTO `s_menu` VALUES ('1', 'dashbo', 'home', 'sy', '主页', '1', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('2', 'workLog', 'list-alt', 'gzrz', '工作日志', '2', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('3', 'project', 'align-justify', 'gzxm', '工作项目', '4', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('4', 'addUser', 'plus', 'tjyh', '添加用户', '5', '1', null, '2017-12-06 15:16:00', 'admin', null, null);
INSERT INTO `s_menu` VALUES ('5', 'mainSetting', 'cog', 'sysz', '首页设置', '6', '2', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('6', 'updateUser', 'user', 'personinf', '个人信息', '7', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('7', 'changePassword', 'lock', 'changepass', '修改密码', '8', '3', null, '2017-12-06 15:16:00', 'yk', null, null);
INSERT INTO `s_menu` VALUES ('8', 'countWorkTime', 'pushpin', 'cwt', '工时统计', '3', '3', null, '2017-12-08 15:13:00', 'yk', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_project
-- ----------------------------
INSERT INTO `s_project` VALUES ('1', 'SimpleOA系统开发', 'SimpleOA系统开发', '2017-11-25', '', '2017-12-09', '1', null, '2017-11-25 15:00:00', 'admin', null, null);
INSERT INTO `s_project` VALUES ('2', 'git使用', 'git如何使用', '2017-11-30', '', '2017-12-06', '1', null, '2017-11-30 15:00:00', 'admin', null, null);
INSERT INTO `s_project` VALUES ('3', 'html5学习', 'html5新特性的学习', '2017-11-15', '2017-12-02', '2017-12-01', '2', null, '2017-11-15 15:00:00', 'admin', null, null);
INSERT INTO `s_project` VALUES ('4', '微信公众号开发', '微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发微信公众号开发', '2017-12-08', null, '2017-12-29', '1', null, '2017-12-08 09:08:18', 'yk', null, null);

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
INSERT INTO `s_user` VALUES ('2', 'SA-002', '应锴', 'yk', 'yk123456', '24', '1', 'AdminUser', '你猜啊', '12345678983', 'M78星云', '364146@SA.com', '33646416', 'rt', '1993-07-13', null, '2017-12-05 14:17:07', 'admin', null, null);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_worklog
-- ----------------------------
INSERT INTO `s_worklog` VALUES ('1', '应锴', '2', '2', 'SimpleOA的开发', 'SimpleOA的开发工作', 'SimpleOA的开发工作', null, '2017-12-03 15:00', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-03');
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
INSERT INTO `s_worklog` VALUES ('13', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:14', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('14', '应锴', '2', '3', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:08:14', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('15', '应锴', '2', '1', 'SimpleOA开发', 'SimpleOA开发', 'SimpleOA开发', null, '2017-12-06 10:12:23', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('16', '应锴', '2', '3', '3', '4', '4', null, '2017-12-06 15:00:57', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('17', '应锴', '2', '2', 'we', 'wewe', '喂喂喂', null, '2017-12-06 15:18:15', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('18', '应锴', '2', '2', 'q', '去', '请问', null, '2017-12-06 15:48:09', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('19', '应锴', '2', '1', '1', '1', '1', null, '2017-12-07 11:29:17', 'yk', null, null, '	SimpleOA系统开发', '1', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('20', '应锴', '2', '1', '1', '1', '1', null, '2017-12-07 11:39:50', 'yk', null, null, 'SimpleOA系统开发', '1', '2017-12-06');
INSERT INTO `s_worklog` VALUES ('21', '应锴', '2', '1', '1', '1', '1', null, '2017-12-07 11:42:09', 'yk', null, null, 'git使用', '2', '2017-12-03');
INSERT INTO `s_worklog` VALUES ('22', '应锴', '2', '0', '1', '1', '1', null, '2017-12-08 08:57:41', 'yk', null, null, '微信公众号开发', '4', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('23', '应锴', '2', '0', '1', '1', '1', null, '2017-12-08 09:00:02', 'yk', null, null, '微信公众号开发', '4', '2017-12-08');
INSERT INTO `s_worklog` VALUES ('24', '应锴', '2', '1', '123', 'qwer', 'qwer', null, '2017-12-08 15:27:46', 'yk', null, null, '微信公众号开发', '4', '2017-12-07');
INSERT INTO `s_worklog` VALUES ('25', '应锴', '2', '2', 'er', 'sdefg', 'ggggg', null, '2017-12-08 15:30:58', 'yk', null, null, '微信公众号开发', '4', '2017-12-07');
