package com.pack.service;


import com.pack.config.ResultTools;
import com.pack.entity.User;
import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

public interface UserService {

    User selectObject(Integer id)throws Exception;

    ResultTools uploadImg(Map<String,MultipartFile> map)throws Exception;
}
