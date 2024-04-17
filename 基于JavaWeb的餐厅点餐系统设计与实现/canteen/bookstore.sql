/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.75.128
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.75.128:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 17/05/2023 02:32:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `imgUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `publish` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (26, '凉拌千张', '凉菜', 'liangbanqianzhang.jpg', '咸', 12.00);
INSERT INTO `book` VALUES (28, '肉末茄子', '素菜', 'roumoqiezhi.jpg', '咸香', 15.00);

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (9, 2, 1, 2, '2023-02-09 00:00:00');
INSERT INTO `cart` VALUES (10, 2, 1, 1, '2023-02-09 00:00:00');
INSERT INTO `cart` VALUES (11, 2, 1, 1, '2023-02-09 00:00:00');
INSERT INTO `cart` VALUES (25, 1, 2, 3, '2023-02-09 00:00:00');
INSERT INTO `cart` VALUES (27, 26, 6, 1, '2023-05-17 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `telphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'tom', '123', '鹰酱111', '1111', '10009');
INSERT INTO `user` VALUES (2, 'jack', '123', '用户da9734', NULL, NULL);
INSERT INTO `user` VALUES (3, 'haha', '123', '用户6b4fed', NULL, NULL);
INSERT INTO `user` VALUES (4, 'haha', '123', '用户aef991', NULL, NULL);
INSERT INTO `user` VALUES (5, 'haha', '123', '用户740936', NULL, NULL);
INSERT INTO `user` VALUES (6, '1', '1', '吃货666', '', '');

SET FOREIGN_KEY_CHECKS = 1;
