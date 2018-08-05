package com.pack.ossutil;

import com.aliyun.oss.OSSClient;
import com.sun.istack.internal.NotNull;

public class AaliUploadImg {
    /**
     * 阿里云API的内或外网域名
     */
    final static String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    /**
     * 阿里云API的密匙Access Key ID
     */
    final static String ACCESS_KEY_ID = "LTAIeOgnxNAUpYuk";
    /**
     * 阿里云API的密匙 Access Key Secret
     */
    final static String ACCESS_KEY_SECRET = "d19TbNT8WrxdMZhhIUuGEbePjuniSz";
    /**
     * 阿里云API的bucket名称
     */
    final static String BACKET_NAME = "personimg";
    /**
     * 阿里云API的文件夹名称
     */
    final static String FOLDER = "test";


    /**
     * @return 阿里云OSS客户端对象
     */
    @NotNull
    public static OSSClient getOssClient(){
        return new OSSClient(ENDPOINT,ACCESS_KEY_ID,ACCESS_KEY_SECRET);
    }

}
