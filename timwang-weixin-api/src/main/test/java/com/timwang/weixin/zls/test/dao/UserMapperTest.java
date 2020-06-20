package com.timwang.weixin.zls.test.dao;

import com.timwang.weixin.zls.dao.UserMapper;
import com.timwang.weixin.zls.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangjun
 * @date 2020-06-20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert_test() {
        User user = new User();
        user.setId(2);
        user.setName("测试2");
        int insert = userMapper.insert(user);
        assert insert > 0;
    }
}
