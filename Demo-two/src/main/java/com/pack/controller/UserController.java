package com.pack.controller;

import com.pack.config.ResultCode;
import com.pack.config.ResultTools;
import com.pack.entity.User;
import com.pack.service.UserService;
import com.pack.util.dbcp.datasource.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/select1")
    public String selectObject(HttpServletRequest request)throws Exception{
        //默认使用master_data_sources
        DataSourceContextHolder.setDataSources(DataSourceContextHolder.MASTER_DATA_SOURCES);
        User user = userService.selectObject(111111);

        System.out.println("库1拿到的ID："+user.getId()+",拿到的Password:"+user.getPassword());

        return null;
    }
    @RequestMapping("/select2")
    public String selectObject2()throws Exception{
        DataSourceContextHolder.setDataSources(DataSourceContextHolder.SLAVE_DATA_SOURCES);
        User user = userService.selectObject(111111);

        System.out.println("库2拿到的ID："+user.getId()+",拿到的Password:"+user.getPassword());

        return null;
    }

    @RequestMapping(value = "/upload/img",method = RequestMethod.POST)
    @ResponseBody
    public ResultTools uploadImg(HttpServletRequest request){

        //获取所有的上传文件
        Map<String,MultipartFile> multipartFileMap = ((MultipartHttpServletRequest)request).getFileMap();

        try {
            return userService.uploadImg(multipartFileMap);
        }catch (Exception e){
            return ResultTools.DIY_ERROR(ResultCode.SysErrorCode,"系统繁忙，请稍后再试");
        }
    }
}
