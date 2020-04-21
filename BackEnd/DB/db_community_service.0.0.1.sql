/*
 Navicat Premium Data Transfer

 Source Server         : MySQL 8.0.13
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_community_service

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 22/04/2020 03:03:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cs_activity_activity
-- ----------------------------
DROP TABLE IF EXISTS `cs_activity_activity`;
CREATE TABLE `cs_activity_activity`  (
  `activity_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_num` int(11) NULL DEFAULT NULL,
  `community_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`activity_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_activity_activity
-- ----------------------------
INSERT INTO `cs_activity_activity` VALUES ('aa1', 'Hello World!', 0, 'cc1', 0, 'system', '2020-04-20 00:29:05', 'system', '2020-04-20 00:29:09');

-- ----------------------------
-- Table structure for cs_activity_comment
-- ----------------------------
DROP TABLE IF EXISTS `cs_activity_comment`;
CREATE TABLE `cs_activity_comment`  (
  `comment_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_community_community
-- ----------------------------
DROP TABLE IF EXISTS `cs_community_community`;
CREATE TABLE `cs_community_community`  (
  `community_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `community_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `community_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`community_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_community_community
-- ----------------------------
INSERT INTO `cs_community_community` VALUES ('cc1', '常乐社区', '双流常乐社区', 0, 'system', '2020-04-20 00:27:05', 'system', '2020-04-20 00:27:10');

-- ----------------------------
-- Table structure for cs_member_account
-- ----------------------------
DROP TABLE IF EXISTS `cs_member_account`;
CREATE TABLE `cs_member_account`  (
  `account_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `community_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_member_account
-- ----------------------------
INSERT INTO `cs_member_account` VALUES ('aa1', 'cc1', 'u1', '123456', 1, 'n1', '17742879989', '1@abc.cn', 0, 'system', '2020-04-19 00:51:10', '1', '2020-04-19 00:51:16');

-- ----------------------------
-- Table structure for cs_member_account_detail
-- ----------------------------
DROP TABLE IF EXISTS `cs_member_account_detail`;
CREATE TABLE `cs_member_account_detail`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL,
  `birthday` datetime(0) NULL DEFAULT NULL,
  `constellation` int(2) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_member_account_detail
-- ----------------------------
INSERT INTO `cs_member_account_detail` VALUES ('ad1', 'aa1', 1, '1998-10-17 00:24:40', NULL, NULL, 0, 'system', '2020-04-20 00:25:26', 'system', '2020-04-20 00:25:43');

-- ----------------------------
-- Table structure for cs_member_read_history
-- ----------------------------
DROP TABLE IF EXISTS `cs_member_read_history`;
CREATE TABLE `cs_member_read_history`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(1) NULL DEFAULT NULL,
  `account_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_message_message
-- ----------------------------
DROP TABLE IF EXISTS `cs_message_message`;
CREATE TABLE `cs_message_message`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sender_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_news_answer
-- ----------------------------
DROP TABLE IF EXISTS `cs_news_answer`;
CREATE TABLE `cs_news_answer`  (
  `answer_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cs_news_news
-- ----------------------------
DROP TABLE IF EXISTS `cs_news_news`;
CREATE TABLE `cs_news_news`  (
  `news_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `cover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reply_num` int(10) NULL DEFAULT NULL,
  `community_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_news_news
-- ----------------------------
INSERT INTO `cs_news_news` VALUES ('nn1', '新闻1', '新闻1内容', NULL, 0, 'cc1', 0, 'system', '2020-04-20 00:27:47', 'system', '2020-04-20 00:27:52');

-- ----------------------------
-- Table structure for cs_news_notice
-- ----------------------------
DROP TABLE IF EXISTS `cs_news_notice`;
CREATE TABLE `cs_news_notice`  (
  `notice_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `community_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `del_flg` tinyint(1) NULL DEFAULT NULL,
  `create_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cs_news_notice
-- ----------------------------
INSERT INTO `cs_news_notice` VALUES ('nc1', '公告1', '公告1内容', '2020-04-20 00:29:52', '2020-04-30 00:29:44', 'cc1', 0, 'system', '2020-04-20 09:29:28', 'system', '2020-04-20 00:29:36');

SET FOREIGN_KEY_CHECKS = 1;
