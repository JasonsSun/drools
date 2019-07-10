/*
 Navicat Premium Data Transfer

 Source Server         : MySQLOWN
 Source Server Type    : MySQL
 Source Server Version : 50537
 Source Host           : localhost:3306
 Source Schema         : drools

 Target Server Type    : MySQL
 Target Server Version : 50537
 File Encoding         : 65001

 Date: 03/07/2019 17:05:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for iot_rule_engine
-- ----------------------------
DROP TABLE IF EXISTS `iot_rule_engine`;
CREATE TABLE `iot_rule_engine`  (
  `iotengine_rule` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规则引擎ID',
  `iotengine_package` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规则引擎导入包',
  `iotengine_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则引擎的属性',
  `iotengine_typecontent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则引擎的属性内容',
  `iotengine_ruleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则名称',
  `iotengine_ruleType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则属性',
  `iotengine_ruleCondition` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则执行条件',
  `iotengine_ruleResult` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则执行后结果',
  `iotengine_isValid` int(11) NULL DEFAULT NULL COMMENT '规则是否生效',
  `iotengine_description` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则最后结果',
  PRIMARY KEY (`iotengine_rule`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of iot_rule_engine
-- ----------------------------
INSERT INTO `iot_rule_engine` VALUES (38, 'package com.example.drools;', NULL, 'import java.text.SimpleDateFormat;\n	import java.util.Date;\n	import com.example.drools.vo.TimeResult;', 'iwant', 'timer(cron: */1 * * * * ?)', '$t:TimeResult( status == false  &&  count < 6 )', 'if($t.getCount()<=6){ $t.setCount($t.getCount()+1);update($t);System.out.println($t.getCount()) ;}else{  this.timer.cancel();}', 1, '\r\npackage com.example.drools; \r\n\r\n	import java.text.SimpleDateFormat; \r\n	import java.util.Date; \r\n	import com.example.drools.vo.TimeResult; \r\nglobal org.kie.api.runtime.KieSession session;\r\n\r\nrule \"iwant\" \r\n        salience 3 \r\n		timer(cron: */1 * * * * ?) \r\n		when \r\n		 $t:TimeResult(status == true ,count>=0&& <30) \r\n       		then \r\n      	  $t.setCount($t.getCount()+1); \r\nupdate($t); \r\nSystem.out.println($t.getCount()) ;\r\n	\r\nend \r\n \r\n');
INSERT INTO `iot_rule_engine` VALUES (39, 'package com.example.drools;', NULL, 'import java.text.SimpleDateFormat;\n	import java.util.Date;\n	import com.example.drools.vo.TimeResult;', 'iwant1', 'no-loop true', '$t:TimeResult( status == false)', '$t.setStatus(true);update($t);System.out.println($t.getStatus()) ;', 1, ' \r\nrule \"iwant1\" \r\n        salience 2 \r\n		no-loop true \r\n		when \r\n		 $t:TimeResult( status == true&&count==0) \r\n 		then \r\n    System.out.println($t.getCount ()); \r\nend\r\n \r\n');
INSERT INTO `iot_rule_engine` VALUES (41, 'package com.example.drools;', NULL, 'import java.text.SimpleDateFormat;\n	import java.util.Date;\n	import com.example.drools.vo.TimeResult;', 'iwant1', 'no-loop true', '$t:TimeResult( status == false)', '$t.setStatus(true);update($t);System.out.println($t.getStatus()) ;', 1, 'rule \"iwant2\" \r\n        salience 100\r\n		no-loop true \r\n		when \r\n		 $t:TimeResult( status == false) \r\n 		then \r\n      	  $t.setStatus(false);  \r\n$t. setCount(0);  \r\nSystem.out.println($t.getStatus());  \r\nupdate ($t); \r\n \r\nend \r\n');
INSERT INTO `iot_rule_engine` VALUES (42, 'package com.example.drools;', NULL, 'import java.text.SimpleDateFormat;\n	import java.util.Date;\n	import com.example.drools.vo.TimeResult;', 'iwant1', 'no-loop true', '$t:TimeResult( status == false)', '$t.setStatus(true);update($t);System.out.println($t.getStatus()) ;', 1, '\r\nrule \"iwant3\" \r\n        salience 101\r\n		no-loop true \r\n		when \r\n		 $t:TimeResult( count == 30) \r\n 		then \r\n     System.out.println(\"开始预警\"); \r\nend \r\n');

SET FOREIGN_KEY_CHECKS = 1;
