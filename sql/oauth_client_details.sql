/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50173
Source Host           : 127.0.0.1:3306
Source Database       : oauth_user

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-08-10 15:40:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(50) NOT NULL COMMENT '客户端ID',
  `client_secret` varchar(150) NOT NULL COMMENT '客户端密钥',
  `resource_ids` varchar(150) DEFAULT NULL COMMENT '资源id',
  `scope` varchar(150) DEFAULT 'all' COMMENT '权限域',
  `authorized_grant_types` varchar(150) DEFAULT NULL COMMENT '认证类型',
  `web_server_redirect_uri` varchar(200) DEFAULT NULL COMMENT '重定向uri',
  `authorities` varchar(150) DEFAULT NULL COMMENT 'authorities',
  `access_token_validity` int(11) DEFAULT '1800' COMMENT 'token有效时间',
  `refresh_token_validity` int(11) DEFAULT '3600' COMMENT 'refresh_token有效时间',
  `additional_information` varchar(200) DEFAULT NULL COMMENT 'additional_information',
  `autoapprove` varchar(150) DEFAULT NULL COMMENT 'autoapprove',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`client_id`,`client_secret`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='oauth客户端';
