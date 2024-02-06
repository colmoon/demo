package com.moon.mybatis;


import com.moon.mybatis.mapper.UserDao;
import com.moon.mybatis.model.UserPO;
import com.moon.study.common.base.utils.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
class MybatisUtilsTest {

    @Test
    public void getUserByID(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<UserPO> user = mapper.getUserList();
        UserPO userPO = mapper.selectUserById(1);
        log.info(GsonUtil.gsonToString(user));
        sqlSession.close();
    }

}