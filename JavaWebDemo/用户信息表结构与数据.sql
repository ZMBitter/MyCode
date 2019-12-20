
SET FOREIGN_KEY_CHECKS=0;


-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` varchar(5) DEFAULT NULL COMMENT '性别',
  `age` int(5) DEFAULT NULL COMMENT '年龄',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `qq` varchar(15) DEFAULT NULL COMMENT 'qq',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('21', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('24', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('25', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('26', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('27', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('28', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('29', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('30', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('31', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('32', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('33', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('34', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('35', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('36', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('37', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('38', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('39', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('40', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('41', 'xiaohong', '女', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('42', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');
INSERT INTO `customer` VALUES ('43', 'xiaohong', '男', '22', '陕西', '123456789', '123456789@qq.com');



-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', '小明', '12345');
