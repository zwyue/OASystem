package com.zhongrui.dao;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zwy
 * @date 1/12/2021
 */
public class SqlGenerator {

    private static final Logger logger = LoggerFactory.getLogger(SqlGenerator.class);

    public static void main(String[] args) {
        //实体类所在的package在磁盘上的绝对路径
        String packageName = "E:\\project\\own\\OASystem\\src\\main\\java\\com\\zhongrui\\entity";
        //生成sql的文件夹
        String filePath = "E:\\project\\own\\OASystem\\src\\main\\resources\\sql\\";
        //项目中实体类的路径
        String prefix = "com.zhongrui.entity.";
        String className ;

        StringBuilder sqlList = new StringBuilder();
        //获取包下的所有类名称
        List<String> list = getAllClasses(packageName);

        if(CollectionUtils.isEmpty(list)) {
            return;
        }
        for (String str : list) {
            className = prefix + str.substring(0, str.lastIndexOf("."));
            String sql = generateSql(className);
            sqlList.append(sql);
        }

        System.out.println(sqlList.toString());
        StringToSql(sqlList.toString(), filePath + "report.sql");
    }

    /**
     * 根据实体类生成建表语句
     * @date   2018年4月11日
     * @param className 全类名
     */
    public static String generateSql(String className){
        try {
            Class<?> clz = Class.forName(className);
            className = clz.getSimpleName();
            Field[] fields = clz.getDeclaredFields();
            StringBuilder columns = new StringBuilder();
            String varchar = " varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,";
            for (Field f : fields) {

                String fieldName = f.getName() ;

                if("id".equals(fieldName) || "createTime".equals(fieldName) || "updateTime".equals(fieldName)) {
                    continue;
                }

                String column = transToLowerCaseAndUnderline(fieldName) ;

                columns.append(" \n `").append(column).append("`").append(varchar);
            }

            String tableName = transToLowerCaseAndUnderline(className) ;
            return
                    " \n DROP TABLE IF EXISTS `" + tableName + "`; " +
                    " \n CREATE TABLE `" + tableName + "`  (" +
                    " \n `id` int(11) NOT NULL AUTO_INCREMENT," +
                    " \n " + columns +
                    " \n `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
                    " \n `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP," +
                    " \n PRIMARY KEY (`id`) USING BTREE," +
                    " \n INDEX `id`(`id`) USING BTREE" +
                    " \n ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ;" +
                    " \n" ;

        } catch (ClassNotFoundException e) {
            logger.debug("该类未找到！");
            return null;
        }

    }

    private static String transToLowerCaseAndUnderline(String fieldName) {

        char[] chars = fieldName.toCharArray() ;

        StringBuilder newStr = new StringBuilder();

        int j = 0 ;
        for (int i = 0; i < chars.length; i++) {
            if(i==0) {
                continue ;
            }

            if(Character.isUpperCase(chars[i])) {
                newStr.append(fieldName.substring(j,i).toLowerCase()).append("_") ;
                j = i ;
            }
        }

        newStr.append(fieldName.substring(j).toLowerCase()) ;
        return newStr.toString() ;
    }

    /**
     * 获取包下的所有类名称,获取的结果类似于 XXX.java
     * @date   2018年4月11日
     * @param packageName 包名
     */
    public static List<String> getAllClasses(String packageName){
        List<String> classList = new ArrayList<>();
        String className ;
        File f = new File(packageName);
        if(f.exists() && f.isDirectory()){
            File[] files = f.listFiles();
            if(files!=null && files.length>0) {
                for (File file : files) {
                    className = file.getName();
                    classList.add(className);
                }
            }
            return classList;
        }else{
            logger.debug("包路径未找到！");
            return null;
        }
    }
    /**
     * 将string 写入sql文件
     * @date   2018年4月11日
     */
    public static void StringToSql(String str,String path){
        byte[] sourceByte = str.getBytes();
        try {
            File file = new File(path);     //文件路径（路径+文件名）
            if (!file.exists()) {   //文件不存在则创建文件，先创建目录
                File dir = new File(file.getParent());
                System.out.println(dir.mkdirs());
                System.out.println(file.createNewFile());
            }
            FileOutputStream outStream = new FileOutputStream(file);    //文件输出流用于将数据写入文件
            outStream.write(sourceByte);
            outStream.flush();
            outStream.close();  //关闭文件输出流
            System.out.println("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
