/*
 Navicat MySQL Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.126.10:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/11/2019 15:57:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for A_GOAL
-- ----------------------------
DROP TABLE IF EXISTS `A_GOAL`;
CREATE TABLE `A_GOAL`  (
  `GOALID` int(11) NOT NULL AUTO_INCREMENT,
  `GOALNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GOALTOTAL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GOALDESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `GOALPERCENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ENDDATE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PROCESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`GOALID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1133 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of A_GOAL
-- ----------------------------
INSERT INTO `A_GOAL` VALUES (1132, '买房zi', '1234', '天津买房', NULL, '20191011', NULL, '333@qq.com');
INSERT INTO `A_GOAL` VALUES (1133, 'qq', 'qq', 'qq', '', '20191024', '', '1234@qq.com');

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat MySQL Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.126.10:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/11/2019 15:58:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for A_POSITION
-- ----------------------------
DROP TABLE IF EXISTS `A_POSITION`;
CREATE TABLE `A_POSITION`  (
  `POSITION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `POSITION_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`POSITION_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of A_POSITION
-- ----------------------------
INSERT INTO `A_POSITION` VALUES (1001, '说一不二的大大');
INSERT INTO `A_POSITION` VALUES (1002, '任劳任怨的伙计');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat MySQL Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.126.10:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/11/2019 15:58:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for A_USER
-- ----------------------------
DROP TABLE IF EXISTS `A_USER`;
CREATE TABLE `A_USER`  (
  `U_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `U_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `U_POSITION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `U_EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`U_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1428 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of A_USER
-- ----------------------------
INSERT INTO `A_USER` VALUES (1424, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '说一不二的大大', '333@qq.com');
INSERT INTO `A_USER` VALUES (1428, 'caopu', '96e79218965eb72c92a549dd5a330112', '任劳任怨的伙计', '17600201849@163.com');

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat MySQL Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.126.10:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/11/2019 15:58:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for A_KIND
-- ----------------------------
DROP TABLE IF EXISTS `A_KIND`;
CREATE TABLE `A_KIND`  (
  `K_ID` int(11) NOT NULL AUTO_INCREMENT,
  `K_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `K_FLAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`K_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1015 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of A_KIND
-- ----------------------------
INSERT INTO `A_KIND` VALUES (1001, '日常用品', '0');
INSERT INTO `A_KIND` VALUES (1002, '人情+礼物', '0');
INSERT INTO `A_KIND` VALUES (1003, '下馆子', '0');
INSERT INTO `A_KIND` VALUES (1004, '买菜', '0');
INSERT INTO `A_KIND` VALUES (1005, '公交打车', '0');
INSERT INTO `A_KIND` VALUES (1006, '工资', '1');
INSERT INTO `A_KIND` VALUES (1007, '外快', '1');
INSERT INTO `A_KIND` VALUES (1008, '私活', '1');
INSERT INTO `A_KIND` VALUES (1009, '预留房租', '3');
INSERT INTO `A_KIND` VALUES (1010, '预留保险', '3');
INSERT INTO `A_KIND` VALUES (1011, '预留办公', '3');
INSERT INTO `A_KIND` VALUES (1012, '其他', '3');
INSERT INTO `A_KIND` VALUES (1013, '其他', '1');
INSERT INTO `A_KIND` VALUES (1014, '其他', '0');
INSERT INTO `A_KIND` VALUES (1015, '预留买房', '3');

SET FOREIGN_KEY_CHECKS = 1;


/*
 Navicat MySQL Data Transfer

 Source Server         : mysql01
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 192.168.126.10:3306
 Source Schema         : account

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 04/11/2019 15:58:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for A_INOUT_ALL
-- ----------------------------
DROP TABLE IF EXISTS `A_INOUT_ALL`;
CREATE TABLE `A_INOUT_ALL`  (
  `A_ID` int(11) NOT NULL AUTO_INCREMENT,
  `A_U_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_K_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_FLAG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_DESC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `A_CHARGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `A_DATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`A_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1170 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of A_INOUT_ALL
-- ----------------------------
INSERT INTO `A_INOUT_ALL` VALUES (1149, '333@qq.com', '预留房租', '3', '房租', '3000', '20190926');
INSERT INTO `A_INOUT_ALL` VALUES (1151, '333@qq.com', '工资', '1', '工资', '5090', '20190925');
INSERT INTO `A_INOUT_ALL` VALUES (1152, '333@qq.com', '买菜', '0', '下班买新鲜蔬菜', '11.99', '20191011');
INSERT INTO `A_INOUT_ALL` VALUES (1162, '333@qq.com', '公交打车', '0', '公交', '30', '20191012');
INSERT INTO `A_INOUT_ALL` VALUES (1163, '333@qq.com', '预留买房', '3', '买房', '3000', '20191012');
INSERT INTO `A_INOUT_ALL` VALUES (1164, '333@qq.com', '私活', '1', '打零工', '200', '20191012');
INSERT INTO `A_INOUT_ALL` VALUES (1166, '333@qq.com', '外快', '1', '打零工', '3000', '20191012');
INSERT INTO `A_INOUT_ALL` VALUES (1167, '1234@qq.com', '买菜', '0', 'qq', '123', '20191024');
INSERT INTO `A_INOUT_ALL` VALUES (1168, '1234@qq.com', '日常用品', '0', 'ww', '222', '20191025');
INSERT INTO `A_INOUT_ALL` VALUES (1169, '1234@qq.com', '预留买房', '3', 'ww', '5000', '20191024');
INSERT INTO `A_INOUT_ALL` VALUES (1170, '1234@qq.com', '工资', '1', 'ww', '2000', '20191017');

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;

