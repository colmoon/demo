CREATE TABLE IF NOT EXISTS `t_oplog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '操作用户名',
  `module` varchar(64) NOT NULL COMMENT '操作模块',
  `op_type` varchar(64) NOT NULL COMMENT '操作类型',
  `optime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  `op_result` tinyint(1) DEFAULT NULL COMMENT '操作成功与否,true/false或者是code错误码之类',
  `op_desc` text COMMENT '描述',
  `message` text COMMENT '消息(用于存放异常，警告，提醒等消息)',
  `ip` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
