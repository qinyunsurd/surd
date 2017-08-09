package com.gulang.surd.service;

import com.gulang.surd.base.BaseService;
import com.gulang.surd.entity.UserDO;

/**
 * @author : gulang
 * Create Date : 2017/8/9
 * Company     : Garden Plus
 * Description : 用户服务接口
 */
public interface UserService extends BaseService<String,UserDO>{
     //添加自己需要的其他服务接口
    UserDO getObject(String userId);
}
