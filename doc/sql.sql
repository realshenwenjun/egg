/*
SQLyog Ultimate v8.32 
MySQL - 5.7.10 : Database - dskj_server
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dskj_server` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dskj_server`;

/*Table structure for table `announcement` */

DROP TABLE IF EXISTS `announcement`;

CREATE TABLE `announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告表',
  `institution_id` varchar(8) DEFAULT NULL COMMENT '机构id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '管理员id',
  `type_id` int(11) DEFAULT NULL COMMENT '公告类型id',
  `belong` int(4) DEFAULT NULL COMMENT '平台公告还是机构公告0:平台,1:机构',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` longtext COMMENT '内容',
  `anno_image` text COMMENT '公告图片',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `announcement_read` */

DROP TABLE IF EXISTS `announcement_read`;

CREATE TABLE `announcement_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告阅读表',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `announcement_id` int(11) DEFAULT NULL COMMENT '公告id',
  `institution_id` varchar(8) DEFAULT NULL COMMENT '机构id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=587 DEFAULT CHARSET=utf8;

/*Table structure for table `announcement_type` */

DROP TABLE IF EXISTS `announcement_type`;

CREATE TABLE `announcement_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告类型表',
  `name` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程表',
  `course_type_id` int(11) NOT NULL COMMENT '课程类型id',
  `institution_id` varchar(8) NOT NULL COMMENT '机构id',
  `name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `describition` text COMMENT '课程描述',
  `cover` varchar(50) DEFAULT NULL COMMENT '封面',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes` */

DROP TABLE IF EXISTS `course_classes`;

CREATE TABLE `course_classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级表',
  `institution_id` varchar(8) DEFAULT NULL COMMENT '机构id',
  `course_id` int(11) DEFAULT NULL COMMENT '课程id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '教师id',
  `name` varchar(50) DEFAULT NULL COMMENT '班级名称',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes_plan` */

DROP TABLE IF EXISTS `course_classes_plan`;

CREATE TABLE `course_classes_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课时表',
  `course_classes_id` int(11) NOT NULL COMMENT '班级id',
  `date` date DEFAULT NULL COMMENT '上课日期',
  `start_time` time DEFAULT NULL COMMENT '开始时间',
  `end_time` time DEFAULT NULL COMMENT '结束时间',
  `user_id` varchar(8) DEFAULT NULL COMMENT '教师id（保留）',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes_plan_lack` */

DROP TABLE IF EXISTS `course_classes_plan_lack`;

CREATE TABLE `course_classes_plan_lack` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '请假表',
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  `class_plan_id` int(11) DEFAULT NULL COMMENT '课时id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `reason` text COMMENT '原因',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes_plan_sign` */

DROP TABLE IF EXISTS `course_classes_plan_sign`;

CREATE TABLE `course_classes_plan_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '签到表',
  `institution_id` varchar(8) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL COMMENT '班级id',
  `class_plan_id` int(11) DEFAULT NULL COMMENT '课时id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `address` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=139 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes_plan_supple` */

DROP TABLE IF EXISTS `course_classes_plan_supple`;

CREATE TABLE `course_classes_plan_supple` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '补课表',
  `class_id` int(11) DEFAULT NULL COMMENT '班级id（原）',
  `class_plan_id` int(11) DEFAULT NULL COMMENT '课时id（原）',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `supple_class_id` int(11) DEFAULT NULL COMMENT '班级id（补）',
  `supple_class_plan_id` int(11) DEFAULT NULL COMMENT '课时id（补）',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Table structure for table `course_classes_sign` */

DROP TABLE IF EXISTS `course_classes_sign`;

CREATE TABLE `course_classes_sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级报名表',
  `classes_id` int(11) DEFAULT NULL COMMENT '班级id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `institution_id` varchar(8) DEFAULT NULL COMMENT '机构id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

/*Table structure for table `course_type` */

DROP TABLE IF EXISTS `course_type`;

CREATE TABLE `course_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '二级课程分类表',
  `name` varchar(50) DEFAULT NULL COMMENT '类别名称',
  `cover` varchar(50) DEFAULT NULL COMMENT '封面',
  `of_id` varchar(11) DEFAULT NULL COMMENT '一级类别id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Table structure for table `course_type_of` */

DROP TABLE IF EXISTS `course_type_of`;

CREATE TABLE `course_type_of` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '一级课程分类表',
  `name` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Table structure for table `institution` */

DROP TABLE IF EXISTS `institution`;

CREATE TABLE `institution` (
  `id` varchar(8) NOT NULL COMMENT '机构表',
  `name` varchar(100) DEFAULT NULL COMMENT '机构名称',
  `summary` text COMMENT '简介',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `logo` varchar(50) DEFAULT NULL COMMENT 'logo图',
  `face` varchar(50) DEFAULT NULL COMMENT '机构主页图',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `parent_id` varchar(8) DEFAULT NULL COMMENT '父机构id',
  `region_id` int(11) DEFAULT NULL COMMENT '地区id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `institution_propa` */

DROP TABLE IF EXISTS `institution_propa`;

CREATE TABLE `institution_propa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institution_id` varchar(8) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `propagate` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

/*Table structure for table `institution_user` */

DROP TABLE IF EXISTS `institution_user`;

CREATE TABLE `institution_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户选择机构表',
  `institution_id` varchar(8) DEFAULT NULL COMMENT '机构id',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `current` tinyint(4) DEFAULT NULL COMMENT '是否是当前机构',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=381 DEFAULT CHARSET=utf8;

/*Table structure for table `institution_work_time` */

DROP TABLE IF EXISTS `institution_work_time`;

CREATE TABLE `institution_work_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `institution_id` varchar(8) DEFAULT NULL,
  `work_date` date DEFAULT NULL,
  `work_start` time DEFAULT NULL,
  `work_end` time DEFAULT NULL,
  `free` tinyint(1) DEFAULT NULL COMMENT '1上班时间,0休息时间',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4079 DEFAULT CHARSET=utf8;

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '地区名称',
  `location` varchar(30) DEFAULT NULL COMMENT '坐标',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级地区id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=524 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `system_carousel` */

DROP TABLE IF EXISTS `system_carousel`;

CREATE TABLE `system_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(50) DEFAULT NULL,
  `val` tinyint(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Table structure for table `system_config` */

DROP TABLE IF EXISTS `system_config`;

CREATE TABLE `system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统配置表',
  `key` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

insert  into `system_config`(`id`,`key`,`value`,`create_time`) values (1,'sms_restUrl','sandboxapp.cloopen.com','2015-10-22 11:23:00'),(2,'sms_port','8883','2015-10-22 11:23:00'),(3,'sms_accountSid','8a48b551506fd26f01508d57f9675268','2015-10-22 11:23:00'),(4,'sms_authToken','3ba177c92f884fe7a06a58dd0028c962','2015-10-22 11:23:00'),(5,'sms_appId','8a48b551506fd26f01508d58ecfd526b','2015-10-22 11:23:00'),(6,'sms_regist_templateId','1','2015-10-22 11:23:00'),(7,'sms_min','5','2015-10-22 11:23:00'),(8,'ins_file_maxsize','1M','2015-10-22 11:23:00'),(9,'ins_file_suffix','jpg/png','2015-10-22 11:23:00'),(10,'chat_org_name','ceshiceshi','2015-10-22 11:23:00'),(11,'chat_app_name','chat','2015-10-22 11:23:00'),(12,'chat_org_admin','shenwenjun','2015-10-22 11:23:00'),(13,'chat_appkey','ceshiceshi#chat','2015-10-22 11:23:00'),(14,'chat_domain','https://a1.easemob.com','2015-10-22 11:23:00'),(15,'chat_client_id','YXA69mNcwIFNEeWzd0N3FcOBWA','2015-10-22 11:23:00'),(16,'chat_client_secret','YXA68RT7Amo4GzpQVcDZX2nuRBNMmrU','2015-10-22 11:23:00'),(17,'chat_expires_in','1451818557054','2015-10-22 11:23:00'),(18,'chat_access_token','YWMtnFiBuoLiEeWGqwk7D2CXrQAAAVIHIQOxrClAUOftS_L-LluzizDq4tJ_eE8','2015-10-22 11:23:00'),(19,'chat_open','true','2015-10-22 11:23:00'),(20,'sys_token_value','ZDE4MmRiNzEtZjcwNy00NTNjLWE3NGMtODYwODU4YTc0NWEy','2015-10-22 11:23:00'),(21,'sys_token_expires_in','1458212688053','2015-10-22 11:23:00'),(22,'sys_token_open','true','2015-10-22 11:23:00'),(25,'region_version','3','2015-10-22 11:23:00'),(26,'ins_file_cache','/usr/local/tomcat/temp/','2015-10-22 11:23:00');
/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(8) NOT NULL COMMENT '用户表',
  `level_id` int(4) DEFAULT '1' COMMENT '用户等级',
  `type` int(4) DEFAULT '3' COMMENT '0:平台管理员,1:机构管理员,2:教师,3:学生',
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `photo` varchar(100) DEFAULT NULL COMMENT '头像路径',
  `qq_open_id` varchar(50) DEFAULT NULL,
  `sina_open_id` varchar(50) DEFAULT NULL,
  `weixin_open_id` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日 ',
  `region_id` int(11) DEFAULT NULL COMMENT '地区id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `user_collect` */

DROP TABLE IF EXISTS `user_collect`;

CREATE TABLE `user_collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(8) DEFAULT NULL,
  `institution_id` varchar(8) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Table structure for table `user_info_back` */

DROP TABLE IF EXISTS `user_info_back`;

CREATE TABLE `user_info_back` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` text COMMENT '文字描述',
  `picture` varchar(50) DEFAULT NULL COMMENT '图片',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `stat` tinyint(4) DEFAULT NULL COMMENT '状态默认0',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Table structure for table `user_login_log` */

DROP TABLE IF EXISTS `user_login_log`;

CREATE TABLE `user_login_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '登陆记录表',
  `user_id` varchar(8) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8694 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色表',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
