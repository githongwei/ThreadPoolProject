package com.pack.service.impi;

import com.aliyun.oss.OSSClient;
import com.pack.config.ResultCode;
import com.pack.config.ResultTools;
import com.pack.entity.User;
import com.pack.mappers.UserMapper;
import com.pack.ossutil.AaliUploadImg;
import com.pack.ossutil.AnalysisFile;
import com.pack.ossutil.FileUploadImg;
import com.pack.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 娃哈哈
 * service层
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public User selectObject(Integer id) throws Exception {

        return userMapper.selectObject(id);
    }

    @Override
    public ResultTools uploadImg(Map<String, MultipartFile> multipartFileMap) throws Exception {

        //final String AliImgPath = "https://personimg.oss-cn-beijing.aliyuncs.com/test/";
        //推荐
        for (Map.Entry<String,MultipartFile> Entry : multipartFileMap.entrySet()){
            MultipartFile multipartFile = Entry.getValue();
            OSSClient client = AaliUploadImg.getOssClient();
            String pathImg = FileUploadImg.uploadObjectOSSImg(client, AnalysisFile.multipartToFile(multipartFile));
            //String pathImg = AliImgPath+multipartFile.getOriginalFilename();
            System.out.println(pathImg);
        }

        return null;
    }
}
