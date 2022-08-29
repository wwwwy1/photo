DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) DEFAULT '' COMMENT '图片名称',
                         `tag` varchar(255) DEFAULT '' COMMENT '标签',
                         `source_url` varchar(255) DEFAULT '' COMMENT '源文件地址',
                         `preview_url` varchar(255) DEFAULT '' COMMENT '预览地址',
                         `download_url` varchar(255) DEFAULT '' COMMENT '下载地址',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片表';



