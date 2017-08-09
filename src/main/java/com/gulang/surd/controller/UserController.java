package com.gulang.surd.controller;

import com.gulang.surd.entity.UserDO;
import com.gulang.surd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : gulang
 * Create Date : 2017/8/9
 * Company     : Garden Plus
 * Description : 用户controller
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userInfo")
    @ResponseBody
    public String getUser(String userId) {
        UserDO userDO = userService.getObject(userId);
        return userDO.toString();
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser() {
        UserDO userDO = new UserDO();
        userDO.setMobile("15500000000");
        String userId = UUID.randomUUID().toString().replace("-","");
        userDO.setUserId(userId);
        userDO.setUserName("json");
        userDO.setAppDomain("egafgeahfejajefnk21213");
        userDO.setEmail("123123@qq.com");
        int result =  userService.saveObject(userDO);
        return 0 < result ? "添加成功" : "添加失败";
    }
    @RequestMapping("/batchUser")
    @ResponseBody
    public String batchUser() {
        UserDO userDO = new UserDO();
        userDO.setMobile("15512300000");
        String userId = UUID.randomUUID().toString().replace("-","");
        userDO.setUserId(userId);
        userDO.setUserName("jack");
        userDO.setAppDomain("egafgeahfejajefnk21213");
        userDO.setEmail("123000@qq.com");
        UserDO userDO1 = new UserDO();
        userDO1.setMobile("15500001234");
        String userId1 = UUID.randomUUID().toString().replace("-","");
        userDO1.setUserId(userId1);
        userDO1.setUserName("ZhangSan");
        userDO1.setAppDomain("egafgeahfejajefnk21213");
        userDO1.setEmail("123333333@qq.com");
        List<UserDO> userDOs = new ArrayList<>();
        userDOs.add(userDO);
        userDOs.add(userDO1);
        int result =  userService.insertBatch(userDOs);
        return 0 < result ? "添加成功" : "添加失败";
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(String userId) {
        UserDO userDO = new UserDO();
        userDO.setMobile("15500000001");
        userDO.setUserId(userId);
        userDO.setUserName("jsonupdate");
        userDO.setAppDomain("egafgeahfejajefnk21213");
        userDO.setEmail("12312344@qq.com");
//        UserDO u = userService.getObject(userId);
//        u.setUserName("update");
//        u.setEmail("12@qq.com");
        int result =  userService.updateObject(userDO);
        String message ;
        if (0 < result) {
               message = "修改成功";
        } else {
            message = "修改失败";
        }
        return message;
    }

    @RequestMapping("/removeUser")
    @ResponseBody
    public String removeUser(String userId) {
        int result =  userService.removeObject(userId);
        String message ;
        if (0 < result) {
               message = "删除成功";
        } else {
            message = "删除失败";
        }
        return message;
    }

}
