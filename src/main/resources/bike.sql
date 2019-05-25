/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : bike

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-05-24 10:46:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_user`;
CREATE TABLE `t_admin_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT '' COMMENT '昵称',
  `mobilephone` varchar(255) DEFAULT '' COMMENT '手机号',
  `password` varchar(255) DEFAULT '' COMMENT '密码',
  `userType` tinyint(3) DEFAULT '0' COMMENT '用户类型',
  `auths` varchar(255) DEFAULT '' COMMENT '操作权限',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '创建账号时间',
  `status` tinyint(3) DEFAULT '0' COMMENT '管理员状态 0正常 1停用 -100删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_bike
-- ----------------------------
DROP TABLE IF EXISTS `t_bike`;
CREATE TABLE `t_bike` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `siteId` int(11) DEFAULT NULL COMMENT '站点ID',
  `bikeCode` varchar(20) DEFAULT '' COMMENT '车辆编号',
  `bikeAmount` double DEFAULT NULL COMMENT '使用车辆所需金额',
  `color` varchar(11) DEFAULT '' COMMENT '车辆颜色',
  `status` int(11) DEFAULT '-1' COMMENT '使用状态：1=使用中；2=未使用；3=车辆故障；',
  `position` varchar(50) DEFAULT '' COMMENT '车辆所属位置',
  `appearance` varchar(20) DEFAULT '' COMMENT '自行车外观新旧程度',
  `useTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '车辆开始使用时间',
  `endTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '车辆最后使用时间',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '车辆发布时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`) USING BTREE,
  KEY `siteId` (`siteId`) USING BTREE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `t_user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_site
-- ----------------------------
DROP TABLE IF EXISTS `t_site`;
CREATE TABLE `t_site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT '' COMMENT '站点名称',
  `userId` int(11) DEFAULT NULL COMMENT '用户ID',
  `siteSize` varchar(20) DEFAULT '' COMMENT '站点大小',
  `sitePosition` varchar(20) DEFAULT '' COMMENT '站点位置',
  `bikeQuantity` int(11) DEFAULT NULL COMMENT '站点可容纳的车辆数量',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '站点发布时间',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userType` tinyint(3) DEFAULT NULL COMMENT '用户类型',
  `sex` tinyint(3) DEFAULT '0' COMMENT '用户性别：0=保密；1=男；2=女',
  `userName` varchar(20) DEFAULT '' COMMENT '用户名',
  `phoneNum` varchar(11) DEFAULT '' COMMENT '用户手机号',
  `password` varchar(50) DEFAULT '' COMMENT '登录密码',
  `identityCard` varchar(20) DEFAULT '' COMMENT '用户身份证号',
  `address` varchar(255) DEFAULT '' COMMENT '所在地',
  `amount` double DEFAULT '0' COMMENT '用户账号余额',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '用户注册时间',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_order
-- ----------------------------
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `useId` int(11) DEFAULT '0' COMMENT '使用者用户ID',
  `issueId` int(11) DEFAULT NULL COMMENT '发布者用户ID',
  `bikeId` int(11) DEFAULT NULL COMMENT '车辆ID',
  `orderCode` varchar(30) DEFAULT '' COMMENT '订单号',
  `betAmount` decimal(11,2) DEFAULT '0.00' COMMENT '订单金额',
  `orderStatus` int(3) DEFAULT '0' COMMENT '订单状态：5=下单失败；10=下单成功；',
  `createTime` datetime DEFAULT '0001-01-01 00:00:00' COMMENT '下单时间',
  PRIMARY KEY (`id`),
  KEY `idx_userId` (`useId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
