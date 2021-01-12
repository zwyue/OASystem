 
 DROP TABLE IF EXISTS `message`;  
 CREATE TABLE `message`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `command` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
 PRIMARY KEY (`id`) USING BTREE, 
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ; 
 
 DROP TABLE IF EXISTS `role`;  
 CREATE TABLE `role`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
 PRIMARY KEY (`id`) USING BTREE, 
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ; 
 
 DROP TABLE IF EXISTS `user_info`;  
 CREATE TABLE `user_info`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
 PRIMARY KEY (`id`) USING BTREE, 
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ; 
 
 DROP TABLE IF EXISTS `user_permission`;  
 CREATE TABLE `user_permission`  ( 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
  
 `operation_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL, 
 `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 
 `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
 PRIMARY KEY (`id`) USING BTREE, 
 INDEX `id`(`id`) USING BTREE 
 ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ; 
