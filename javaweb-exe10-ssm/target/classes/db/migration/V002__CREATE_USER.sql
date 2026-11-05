-- 先切换到 V001 创建的库，否则执行本脚本会报 No database selected
use mobile_shop;

CREATE TABLE `ms_user` (
    `user_id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY comment '用户ID',
    `username` VARCHAR(50) NOT NULL comment '用户名',
    `password` VARCHAR(50) NOT NULL comment '密码'
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

insert into `ms_user` (`username`,`password`) values('zhangsan','123456');
