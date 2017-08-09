package com.gulang.surd.service.impl;

import com.gulang.surd.base.AbstractBaseService;
import com.gulang.surd.base.BaseDao;
import com.gulang.surd.dao.UserDao;
import com.gulang.surd.entity.UserDO;
import com.gulang.surd.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : gulang
 *         Create Date : 2017/8/9
 *         Company     : Garden Plus
 *         Description : 服务实现类
 */
@Service
public class UserServiceImpl extends AbstractBaseService<String, UserDO> implements UserService {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserDao userDao;

    @Override
    protected BaseDao<String, UserDO> getDao() {
        return userDao;
    }

    /**
     * 防止物理删除,在此拦截,改成逻辑删除
     *
     * @param s 主键
     * @return 影响行数
     */
    @Override
    public int removeObject(String s) {
        UserDO userDO = this.setUserDo(s,null,null,null);
        userDO.setIsDel(0);
        UserDO u = this.getObjectByEntity(userDO);
        if (null == u) {
            logger.info("传入的主键在数据库中没有对应的记录");
            return 0;
        }
        u.setIsDel(1);
        return this.updateObject(u);
    }

    /**
     * 获取一个对象
     * @param userId 用户ID
     * @return  用户对象
     */
    @Override
    public UserDO getObject(String userId) {
        UserDO userDO = this.setUserDo(userId,null,null,null);
        return this.getObjectByEntity(userDO);
    }

    /**
     * 根据自己的需求自己定义此类包装对象的方法, 也可以不需要. 灵活运用
     * @param userId 用户id
     * @param email 邮箱
     * @param userName 用户名
     * @param mobile 手机
     * @return 用户临时对象
     */
    private UserDO setUserDo(String userId, String email, String userName, String mobile) {
        UserDO userDO = new UserDO();
        userDO.setUserId(userId);
        userDO.setEmail(email);
        userDO.setUserName(userName);
        userDO.setMobile(mobile);
        return userDO;
    }
}
