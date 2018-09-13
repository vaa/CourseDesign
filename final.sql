/*
Navicat MySQL Data Transfer

Source Server         : MySQL_123456
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : final

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-04 08:22:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_grade_info
-- ----------------------------
DROP TABLE IF EXISTS `t_grade_info`;
CREATE TABLE `t_grade_info` (
  `stu_no` varchar(50) CHARACTER SET utf8 NOT NULL,
  `stu_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `topic_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `grade` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`stu_no`,`topic_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_man_info
-- ----------------------------
DROP TABLE IF EXISTS `t_man_info`;
CREATE TABLE `t_man_info` (
  `man_no` varchar(30) NOT NULL,
  `man_name` varchar(30) DEFAULT NULL,
  `man_pwd` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`man_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_select_course_info
-- ----------------------------
DROP TABLE IF EXISTS `t_select_course_info`;
CREATE TABLE `t_select_course_info` (
  `sc_id` int(11) NOT NULL AUTO_INCREMENT,
  `sc_group` varchar(30) NOT NULL,
  `sc_tea_name` varchar(30) DEFAULT NULL,
  `sc_tea_no` varchar(30) DEFAULT NULL,
  `sc_topic_name` varchar(30) DEFAULT NULL,
  `topic_date` varchar(50) DEFAULT NULL,
  `filename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sc_id`,`sc_group`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_info
-- ----------------------------
DROP TABLE IF EXISTS `t_student_info`;
CREATE TABLE `t_student_info` (
  `stu_no` varchar(30) NOT NULL,
  `stu_name` varchar(30) DEFAULT NULL,
  `stu_pwd` varchar(30) DEFAULT NULL,
  `stu_group` varchar(30) DEFAULT NULL,
  `stu_role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`stu_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_tea_info
-- ----------------------------
DROP TABLE IF EXISTS `t_tea_info`;
CREATE TABLE `t_tea_info` (
  `tea_no` varchar(30) NOT NULL,
  `tea_name` varchar(30) DEFAULT NULL,
  `tea_pwd` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_topic_name_info
-- ----------------------------
DROP TABLE IF EXISTS `t_topic_name_info`;
CREATE TABLE `t_topic_name_info` (
  `en_id` int(11) NOT NULL AUTO_INCREMENT,
  `en_tea_name` varchar(30) DEFAULT NULL,
  `en_topic_name` varchar(30) DEFAULT NULL,
  `en_topic_content` varchar(90) DEFAULT NULL,
  `en_filename` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`en_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for v_grade_info
-- ----------------------------
DROP VIEW IF EXISTS `v_grade_info`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_grade_info` AS select `t_grade_info`.`grade` AS `grade`,`t_grade_info`.`stu_no` AS `stu_no`,`t_grade_info`.`stu_name` AS `stu_name`,`t_grade_info`.`topic_name` AS `topic_name` from ((`t_grade_info` join `t_student_info`) join `t_select_course_info`) where ((`t_student_info`.`stu_group` = `t_select_course_info`.`sc_group`) and (`t_grade_info`.`stu_no` = `t_student_info`.`stu_no`) and (`t_grade_info`.`topic_name` = `t_select_course_info`.`sc_topic_name`)) ;
