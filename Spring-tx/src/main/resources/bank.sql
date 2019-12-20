
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cardId` varchar(11) NOT NULL COMMENT '账号',
  `userName` varchar(20) NOT NULL COMMENT '用户名',
  `money` decimal(10,0) DEFAULT '0' COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `bank` VALUES ('1', '10000001', '李明', '3001');
INSERT INTO `bank` VALUES ('2', '10000002', '王月', '7000');
INSERT INTO `bank` VALUES ('3', '10000003', '张欣', '4999');

