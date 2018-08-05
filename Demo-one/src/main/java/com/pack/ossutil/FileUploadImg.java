package com.pack.ossutil;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

public class FileUploadImg extends AaliUploadImg {

    private static Logger logger = Logger.getLogger(AaliUploadImg.class);

    public static String uploadObjectOSSImg(OSSClient ossClient, File file){

        String path = "https://"+BACKET_NAME+"."+ENDPOINT+"/";
        // 以输入流的形式上传
        try {
            InputStream inputStream = new FileInputStream(file);
            String name = file.getName();
            String fileName = UUID.randomUUID() + name.substring(name.lastIndexOf("."));
            Long fileSize = file.length();

            ObjectMetadata metadata = new ObjectMetadata();
            //上传文件的长度
            metadata.setContentLength(inputStream.available());
            //缓存行为
            metadata.setCacheControl("no-cache");
            //设置该Object下设置Header
            metadata.setHeader("Pragma","no-cache");
            metadata.setContentEncoding("UTF-8");
            String type = getContentType(fileName);
            metadata.setContentType(type);
            metadata.setContentDisposition("filename/filesize="+fileName+"/"+fileSize+"Byte.");
            //上传文件
            String AliFileName = FOLDER +"/"+ fileName;
            ossClient.putObject(BACKET_NAME,AliFileName,inputStream,metadata);
            return  path+"/"+AliFileName;
        }catch (Exception E){
            System.out.println("文件传输失败！:"+E.getMessage());
            logger.error("上传文件失败："+E.getMessage(),E);
            return null;
        }

    }

    public static String getContentType(String fileName){
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));

        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }
}
