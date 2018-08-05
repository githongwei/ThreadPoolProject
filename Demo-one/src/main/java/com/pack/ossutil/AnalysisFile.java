package com.pack.ossutil;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class AnalysisFile {

    public static File multipartToFile(MultipartFile multipartFiles)throws IOException{

        DiskFileItem fileItem = (DiskFileItem)((CommonsMultipartFile) multipartFiles).getFileItem();

       // File file = fileItem.getStoreLocation();
        // 不用生成临时文件，以免出错
        /*if(file.length() < 2048){
            File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                    file.getName());
            multipartFiles.transferTo(tmpFile);
            return tmpFile;
        }
            String filimgName = multipartFiles.getOriginalFilename();
            String path = UUID.randomUUID().toString()+filimgName.substring(filimgName.lastIndexOf("."));
        */

        File file1 = new File(fileItem.getName());
        multipartFiles.transferTo(file1);
        return file1;
    }
}
