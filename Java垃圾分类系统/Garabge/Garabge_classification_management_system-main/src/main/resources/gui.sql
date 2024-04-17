/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : gui

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 09/07/2022 23:20:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for complaint_management
-- ----------------------------
DROP TABLE IF EXISTS `complaint_management`;
CREATE TABLE `complaint_management`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '投诉管理id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投诉标题',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投诉详情',
  `complainant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投诉人',
  `propertyCompletionStatus` int NULL DEFAULT NULL COMMENT '物业完成状态（0代表未完成，1代表已完成）',
  `userConfirmationStatus` int NULL DEFAULT NULL COMMENT '用户确认状态（0代表未确认，0代表已确认）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of complaint_management
-- ----------------------------
INSERT INTO `complaint_management` VALUES (1, '垃圾问题', '垃圾乱扔', '王五', 1, 1);
INSERT INTO `complaint_management` VALUES (2, '垃圾箱投放问题', '垃圾投放不合理', '张三', 1, 1);
INSERT INTO `complaint_management` VALUES (3, '垃圾箱损坏长时间未处理', '3号小区垃圾箱损坏长时间未处理', '小儿', 1, 1);
INSERT INTO `complaint_management` VALUES (4, '个人居民垃圾分类不合理', '个人居民垃圾分类不合理', '赵六', 0, 0);

-- ----------------------------
-- Table structure for equipment_list
-- ----------------------------
DROP TABLE IF EXISTS `equipment_list`;
CREATE TABLE `equipment_list`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '设备列表id',
  `equipmentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `deliveryPort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投放口',
  `cleaner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清洁员',
  `deliveryPortCapacity` int NULL DEFAULT NULL COMMENT '投放口容量',
  `deliveryPortTemperature` int NULL DEFAULT NULL COMMENT '投放口温度',
  `deliveryPortWeight` int NULL DEFAULT NULL COMMENT '投放口重量',
  `deliveryPortHumidity` int NULL DEFAULT NULL COMMENT '投放口湿度',
  `deliveryPortHarmfulGas` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '投放口有害气体',
  `deliveryPortStatus` int NULL DEFAULT NULL COMMENT '投放口状态（0处理完成，1未完成）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment_list
-- ----------------------------
INSERT INTO `equipment_list` VALUES (1, '拖拉机1号', '山顶1号', '外星人1号', 1000, 36, 100000, 20, '氮气', 0);
INSERT INTO `equipment_list` VALUES (2, '拖拉机2号', '山顶2号', '外星人2号', 1000, 36, 100000, 20, '氮气', 0);
INSERT INTO `equipment_list` VALUES (3, '牛魔王1.0', '山腰1号', '铁扇公主', 9000, 42, 1000, 23, '氯气', 0);
INSERT INTO `equipment_list` VALUES (4, '拖拉机3号', '山顶3号', '外星人3号', 10000, 36, 60000, 20, '氮气', 1);
INSERT INTO `equipment_list` VALUES (5, '拖拉机5号', '山顶5号', '外星人5号', 6500, 36, 85600, 20, '氮气', 0);
INSERT INTO `equipment_list` VALUES (6, '拖拉机6号', '山顶6号', '外星人6号', 8000, 36, 56390, 20, '氮气', 0);

-- ----------------------------
-- Table structure for repair_management
-- ----------------------------
DROP TABLE IF EXISTS `repair_management`;
CREATE TABLE `repair_management`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '报修管理id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修标题',
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修详情',
  `applicant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报修人',
  `propertyCompletionStatus` int NULL DEFAULT NULL COMMENT '物业完成状态（0代表未完成，1代表已完成）',
  `userConfirmationStatus` int NULL DEFAULT NULL COMMENT '用户确认状态（0代表未确认，1代表已确认）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of repair_management
-- ----------------------------
INSERT INTO `repair_management` VALUES (1, '垃圾箱损坏问题', '垃圾箱损坏', '小二', 1, 1);
INSERT INTO `repair_management` VALUES (5, '垃圾车设备问题', '垃圾车年久失修', '阿牛', 0, 0);

-- ----------------------------
-- Table structure for rubbish_classification
-- ----------------------------
DROP TABLE IF EXISTS `rubbish_classification`;
CREATE TABLE `rubbish_classification`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '垃圾分类编号',
  `classificationName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾分类名称(1塑料垃圾、2纸质垃圾、3干垃圾)',
  `rubbishType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾分类类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rubbish_classification
-- ----------------------------
INSERT INTO `rubbish_classification` VALUES (2, '干垃圾', '可回收');
INSERT INTO `rubbish_classification` VALUES (3, '厨余垃圾', '不可回收');
INSERT INTO `rubbish_classification` VALUES (4, '塑料垃圾', '可回收');
INSERT INTO `rubbish_classification` VALUES (5, '纸质垃圾', '可回收');

-- ----------------------------
-- Table structure for rubbish_station
-- ----------------------------
DROP TABLE IF EXISTS `rubbish_station`;
CREATE TABLE `rubbish_station`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '垃圾站信息主键id',
  `classificationName` int NULL DEFAULT NULL COMMENT '垃圾分类名称(1塑料垃圾、2纸质垃圾、3干垃圾)',
  `nameStation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '垃圾站点',
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rubbish_station
-- ----------------------------
INSERT INTO `rubbish_station` VALUES (1, 1, '1号垃圾厂', '张三');
INSERT INTO `rubbish_station` VALUES (2, 2, '2号垃圾厂', '李四');
INSERT INTO `rubbish_station` VALUES (3, 3, '3号垃圾厂', '王五');

-- ----------------------------
-- Table structure for rubbish_transportation
-- ----------------------------
DROP TABLE IF EXISTS `rubbish_transportation`;
CREATE TABLE `rubbish_transportation`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '垃圾运输信息管理id编号',
  `chargeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收费名称',
  `transportationQuantity` int NULL DEFAULT NULL COMMENT '运输数量',
  `communityName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小区名称',
  `rubbishType` int NULL DEFAULT NULL COMMENT '可回收垃圾（0） 不可回收垃圾（1）',
  `transportationStatus` int NULL DEFAULT NULL COMMENT '运输状态(0代表运输中，1代表已送达)',
  `createTime` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  `transportationTime` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '运输时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rubbish_transportation
-- ----------------------------
INSERT INTO `rubbish_transportation` VALUES (3, '干垃圾', 100, '光明小区', 1, 0, '2022-07-02 20:30:14.857444', '2022-07-02 20:30:12.000000');
INSERT INTO `rubbish_transportation` VALUES (4, '塑料垃圾', 100, '光明小区', 1, 0, '2022-07-02 20:39:26.000000', '2022-07-02 20:39:29.000000');
INSERT INTO `rubbish_transportation` VALUES (6, '纸质垃圾', 100, '光明小区', 0, 1, '2022-07-02 20:40:02.377000', '2022-07-02 20:40:02.377000');
INSERT INTO `rubbish_transportation` VALUES (7, '纸质垃圾', 10000, '光明小区', 0, 1, '2022-07-02 20:40:55.010000', '2022-07-02 20:40:55.010000');
INSERT INTO `rubbish_transportation` VALUES (8, '纸质垃圾', 1000000, '光明小区', 0, 1, '2022-07-02 20:43:47.386000', '2022-07-02 20:43:47.386000');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `communityName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责小区名称',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮箱',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` int NULL DEFAULT NULL COMMENT '用户账号状态',
  `createTime` datetime NULL DEFAULT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '12', '13', '21', '231', '3', 213, '2022-07-09 15:53:47');
INSERT INTO `user` VALUES ('chenmk', '123456', 'ck', '东15栋405', '3066686488@qq.com', '13652989137', 0, '2022-07-07 14:52:46');
INSERT INTO `user` VALUES ('chenmuke', '123456', 'cmk', '东15栋405', '3066686488@qq.com', '13652989137', 0, '2022-07-05 18:26:34');
INSERT INTO `user` VALUES ('lisi', '123456', '李四', '2号小区', '3066686488@qq.com', '13652989137', 1, '2022-07-09 12:24:45');
INSERT INTO `user` VALUES ('root', '123', '菜坤', 'jyu', '3066686488@qq.com', '13652989137', 0, '2022-07-05 16:56:28');
INSERT INTO `user` VALUES ('wangwu', '123456', '王五', '4号小区', '3066686488@qq.com', '13652989137', -1, '2022-07-09 12:24:46');
INSERT INTO `user` VALUES ('xiaoer', '123456', '小二', '3号小区', '3066686488@qq.com', '13652989137', 1, '2022-07-09 12:24:47');
INSERT INTO `user` VALUES ('zhangsan', '123456', '张三', '1号小区', '3066686488@qq.com', '13652989137', 1, '2022-07-09 12:24:48');
INSERT INTO `user` VALUES ('zhaoliu', '123456', '赵六', '5号小区', '3066686488@qq.com', '13652989137', 1, '2022-07-09 12:24:49');
INSERT INTO `user` VALUES ('zhuzilong', '123456', 'zzl', '东15栋406', '3066686488@qq.com', '13652989137', 0, '2022-07-09 12:26:32');

SET FOREIGN_KEY_CHECKS = 1;
