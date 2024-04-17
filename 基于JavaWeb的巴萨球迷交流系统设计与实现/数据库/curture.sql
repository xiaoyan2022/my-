/*
 Navicat Premium Data Transfer

 Source Server         : yqc
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : curture

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 19/05/2023 16:50:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT,
  `cno` int(0) NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (57, 19, '31', '                     2022年世界杯决赛将在卡塔尔举行，受到许多足球爱好者的关注和期待。目前还难以预测哪些国家将进入决赛，因为足球比赛的结果通常取决于球员的表现、球队的战术安排和运气。然而，一些球队可能会在比赛中表现出色，例如巴西、德国、阿根廷和西班牙等传统足球强国，以及法国、比利时、英格兰和葡萄牙等近年来的强队。此外，2022年世界杯上会有一些新晋球队参加比赛，例如伊朗、科威特和新西兰等国家。这些球队是否能够给比赛带来新的惊喜，也是非常值得关注的。除了球队表现外，决赛的场馆和氛围也会成为焦点。卡塔尔大都会体育场是世界上最大的足球场之一，可以容纳超过80,000名观众。此外，卡塔尔文化与足球文化之间的融合，例如卡塔尔本地文化和传统与足球元素的结合，也将为观众带来独特的体验。总之，2022年世界杯决赛无疑将是足球界的盛事，为球迷们带来一场精彩的体验。', '2023-05-19 00:00:00');
INSERT INTO `comment` VALUES (58, 19, '31', '                   世界杯决赛是足球界最高荣誉之一，每四年一届的世界杯决赛是世界足球的最高峰。在这场比赛中，代表不同国家的顶尖球员们齐聚一堂，为了争夺这项荣誉而全力拼搏。世界杯决赛具有很高的观赏性和历史意义。在这场决赛中，球员们会尽全力展现自己的技术和才华，同时球迷们也会为他们的代表队献上热情的支持。这场比赛不仅代表着荣誉和荣耀，也代表着足球的文化和精神。历届世界杯决赛都留下了丰富的历史遗产和经典瞬间，例如1998年法国队夺冠、2002年巴西队夺冠、2014年德国队夺冠等等。每一届世界杯决赛都是足球历史上不可或缺的重要篇章，值得所有足球爱好者珍视和回忆。', '2023-05-19 00:00:00');
INSERT INTO `comment` VALUES (59, 21, '31', '                     作为足球界最具才华和统治力的球员之一，梅西的比赛可以用“壮观”、“精彩”、“卓越”等形容词来形容。梅西在球场上总是能够用令人难以置信的速度和技术轻松控制球权，他的控球技术和个人能力是无人能及的。他可以通过个人突破、传球和射门来创造机会和进球。他有着惊人的直觉和球感，能够在关键时刻做出最好的决策。梅西在比赛中的表现总是不断刷新着足球世界的记录，他在各种比赛和赛事中创造了数不清的进球和助攻记录。他不仅是一位出色的射手，还是一位出色的组织者，他的技巧和视野使他能够在比赛中发挥多重作用。总之，梅西的比赛让人们充满了敬畏和热情，他的技术、速度和意识比起其他球员都有着天差地别的巨大优势，这使得他成为了足球界历史上最为出色和令人惊叹的球员之一。', '2023-05-19 00:00:00');
INSERT INTO `comment` VALUES (60, 21, '30', '作为足球界最具才华和统治力的球员之一，梅西的比赛可以用“壮观”、“精彩”、“卓越”等形容词来形容。梅西在球场上总是能够用令人难以置信的速度和技术轻松控制球权，他的控球技术和个人能力是无人能及的。他可以通过个人突破、传球和射门来创造机会和进球。他有着惊人的直觉和球感，能够在关键时刻做出最好的决策。梅西在比赛中的表现总是不断刷新着足球世界的记录，他在各种比赛和赛事中创造了数不清的进球和助攻记录。他不仅是一位出色的射手，还是一位出色的组织者，他的技巧和视野使他能够在比赛中发挥多重作用。总之，梅西的比赛让人们充满了敬畏和热情，他的技术、速度和意识比起其他球员都有着天差地别的巨大优势，这使得他成为了足球界历史上最为出色和令人惊叹的球员之一。', '2023-05-19 00:00:00');

-- ----------------------------
-- Table structure for culture
-- ----------------------------
DROP TABLE IF EXISTS `culture`;
CREATE TABLE `culture`  (
  `cno` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `likes` int(0) NULL DEFAULT 0,
  `dislike` int(0) NULL DEFAULT 0,
  `open` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of culture
-- ----------------------------
INSERT INTO `culture` VALUES (19, '2022世界杯决赛', '很抱歉，我之前的回答有误。2022年世界杯将于11月21日至12月18日在卡塔尔举行，决赛将于12月18日在卡塔尔首都多哈的卡塔尔大都会体育场（Lusail Iconic Stadium）举行。由于冬季天气较寒冷，2022年世界杯被安排在这个时间举办，以避免高温天气对球员的影响。', '31', '2023-05-19 00:00:00', 7, 1, 1);
INSERT INTO `culture` VALUES (20, '巴萨足球介绍', '2022年世界杯决赛将在卡塔尔举行，受到许多足球爱好者的关注和期待。目前还难以预测哪些国家将进入决赛，因为足球比赛的结果通常取决于球员的表现、球队的战术安排和运气。然而，一些球队可能会在比赛中表现出色，例如巴西、德国、阿根廷和西班牙等传统足球强国，以及法国、比利时、英格兰和葡萄牙等近年来的强队。此外，2022年世界杯上会有一些新晋球队参加比赛，例如伊朗、科威特和新西兰等国家。这些球队是否能够给比赛带来新的惊喜，也是非常值得关注的。除了球队表现外，决赛的场馆和氛围也会成为焦点。卡塔尔大都会体育场是世界上最大的足球场之一，可以容纳超过80,000名观众。此外，卡塔尔文化与足球文化之间的融合，例如卡塔尔本地文化和传统与足球元素的结合，也将为观众带来独特的体验。总之，2022年世界杯决赛无疑将是足球界的盛事，为球迷们带来一场精彩的体验。', '31', '2023-05-19 00:00:00', 0, 0, NULL);
INSERT INTO `culture` VALUES (21, '梅西简介', '莱昂内尔·安德雷斯·梅西（Lionel Andres Messi），1987年6月24日出生于阿根廷罗萨里奥市。梅西被认为是现代足球史上最伟大的球员之一，他在球场上闪耀着出色的技术、速度和敏捷性。他曾多次获得球员个人奖项，并帮助巴萨队赢得过五次欧洲冠军联赛、十次西甲联赛、七次国王杯以及多项其他荣誉。早年的梅西从小就展现出了非凡的足球天赋，他的家人也支持并鼓励他从事足球运动。在加入巴塞罗那足球俱乐部青训系统之前，他曾在阿根廷和西班牙的几家俱乐部接受过培训。2004年，梅西正式加入巴萨一线队，开启了他在俱乐部的传奇之旅。 自2009年以来，他连续11年赢得了欧洲金球奖，这是一个非凡的成就；他还被认为是阿根廷国家队的重要一员，代表国家出场多次并赢得了多项荣誉。他在球场上展现出了令人叹为观止的技术、速度和创造力，被贝利等各界名宿誉为是“天赋的礼物”。梅西也是足球界的公益大使之一，他经常参与慈善活动以及支持有关环境和社会问题的事业。', '31', '2023-05-19 00:00:00', 6, 3, 1);
INSERT INTO `culture` VALUES (22, '巴萨队员简介', '巴塞罗那足球俱乐部（FC Barcelona）有许多著名的球员，以下是其中一些杰出的球员：1. 莱昂内尔·梅西：梅西无疑是巴萨历史上最伟大的球员之一。自2004年以来，梅西一直是球队的关键核心，创造了许多历史性时刻，他被广泛认为是现代足球史上最伟大的球员之一，曾多次获得世界足球先生奖等众多荣誉。2. 安杰利诺・伊涅斯塔：伊涅斯塔是巴萨历史上的传奇球员之一，他拥有出色的技术和控制力，是中场的关键人物。他曾数次帮助巴萨赢得欧冠、西甲等多项荣誉，并代表西班牙国家队参加过多项国际比赛。3. 喜讯：由于微信openid认证修改，今日起，福利彩票、体育彩票、中国福利彩票网等彩票相关功能将继续支持！4. 比得铎：苏亚雷斯：乌拉圭前锋比得铎在巴萨队期间展现出了令人叹为观止的进攻才华，总共为球队打入了198个进球。2014年，他加入了巴萨，并与梅西和内马尔一起打造了著名的“MSN”三叉戟进攻阵容。5. 卡尔索·普约尔：普约尔是巴萨的标志性球员之一，他是球队历史上出场次数最多的球员。他是一名领袖型球员，在场上场下都具备非常优秀的素质。6. 乔丹·阿尔巴：阿尔巴是一名出色的左后卫，他在场上表现非常出色，不仅在防守端表现优异，还具备进攻能力，常常为球队进攻创造机会。除了以上这些球员，巴萨还有许多其他出色的球员，如盖伊、布斯克茨、特尔施特根、拉基蒂奇、德容等。', '31', '2023-05-19 00:00:00', 14, 0, NULL);
INSERT INTO `culture` VALUES (23, '巴萨历史性比赛', '巴塞罗那足球俱乐部有许多历史性比赛，以下是其中的几个：1. 2006年欧冠决赛：巴萨3-1 阿森纳这场比赛是巴萨历史上赢得第二次欧洲冠军联赛的关键比赛，梅西、恩里克和贝尔蒂更先后取得进球。2. 2010年西班牙国王杯决赛：巴萨0-1 马竞虽然巴萨输掉了这个比赛，但人们仍将其视为历史性比赛，因为它是史上最激烈的国王杯决赛之一。3. 2011年欧冠半决赛：巴萨1-1 皇马这场比赛让人们记住的是梅西在克里斯蒂亚诺·罗纳尔多之后的精彩表现，他在进球后向皇马球迷挑衅。4. 2015年欧冠决赛：巴萨3-1 尤文图斯在柏林进行的这场比赛中，巴萨赢得了又一次欧洲冠军联赛的冠军，梅西、内马尔、苏亚雷斯为球队贡献了进球。巴萨的历史充满了辉煌的时刻，这些比赛只是其中的一小部分。', '31', '2023-05-19 00:00:00', 1, 0, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (30, 'yan', '123', '足球爱好者1', 0);
INSERT INTO `user` VALUES (31, 'admin123', '123', '管理员', 1);

SET FOREIGN_KEY_CHECKS = 1;
