/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.75.128
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.75.128:3306
 Source Schema         : stu_help

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 17/05/2023 15:55:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good`  (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `owner` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `status` int(10) NULL DEFAULT 1,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES (1, 20221001, '团建活动', '1', '2022-12-08 00:00:00.000000', 1, 1);
INSERT INTO `good` VALUES (2, 123, '活动66', '123', '2023-04-04 00:00:00.000000', 54, 1);
INSERT INTO `good` VALUES (3, 1, '交流平台', 'test', '2023-05-17 00:00:00.000000', 0, 1);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `pub` int(255) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `end` datetime(0) NULL DEFAULT NULL,
  `reward` int(255) NULL DEFAULT NULL,
  `status` int(255) NULL DEFAULT 1,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES (1, 20221002, '打饭', '好兄弟，帮忙去汇吃打个2荤一素', '2022-12-07 15:51:20.000000', '2023-05-17 14:23:03', 5, 0);
INSERT INTO `task` VALUES (2, 1, '打饭', '10个菜', '2022-12-07 00:00:00.000000', '2023-05-26 14:23:06', 100, 0);
INSERT INTO `task` VALUES (5, 123, '帮忙拿快递', '123', '2022-12-07 00:00:00.000000', '2023-04-24 14:23:11', 111, 1);
INSERT INTO `task` VALUES (7, 123, '帮忙拿快递', '11', '2022-12-07 00:00:00.000000', '2023-05-31 14:23:14', 111, 1);
INSERT INTO `task` VALUES (8, 20221001, '代写作业', '666', '2022-12-07 00:00:00.000000', '2023-05-31 14:23:20', 1000, 1);
INSERT INTO `task` VALUES (9, 20221002, '代写作业', '1', '2022-12-07 00:00:00.000000', '2023-05-27 14:23:26', 1, 1);
INSERT INTO `task` VALUES (11, 1, '来', 'have fun', '2023-05-17 00:00:00.000000', '2023-05-22 14:23:30', 99, 1);
INSERT INTO `task` VALUES (12, 1, '55555', '555', '2023-05-13 00:00:00.000000', '2023-05-24 00:00:00', 5555, 1);
INSERT INTO `task` VALUES (13, 1, '3333', '333', '2023-05-01 00:00:00.000000', '2023-05-30 00:00:00', 2323, 1);
INSERT INTO `task` VALUES (14, 1, '1', '1', '2023-05-11 00:00:00.000000', '2023-05-26 00:00:00', 1, 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `sno` int(255) NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `time` datetime(6) NULL DEFAULT NULL,
  `account` int(255) NULL DEFAULT 0,
  `status` int(255) NULL DEFAULT 1,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '1', '女', '1', '2023-05-17 00:00:00.000000', 0, 1);
INSERT INTO `user` VALUES (11, '11', '1', '男', '11', '2022-12-07 00:00:00.000000', 0, 1);
INSERT INTO `user` VALUES (123, 'q1', '小明', '男', '家里蹲大学', '2022-12-07 00:00:00.000000', 0, 1);
INSERT INTO `user` VALUES (20221001, 'q1', 'tom', '男', '清华大学', '2022-12-06 15:53:10.000000', 0, 1);
INSERT INTO `user` VALUES (20221002, 'q1', '10000', '男', '100', '2022-12-07 00:00:00.000000', 0, 1);

SET FOREIGN_KEY_CHECKS = 1;
