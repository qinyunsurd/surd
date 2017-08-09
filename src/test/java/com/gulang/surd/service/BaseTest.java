package com.gulang.surd.service;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: gulang
 * Create Date : 2017/8/9
 * Company     : Garden Plus
 * Description :
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-mvc-test.xml","/spring-mybatis-test.xml"})
public class BaseTest {
    @Before
    public void before(){}

    @After
    public void after(){}
}
