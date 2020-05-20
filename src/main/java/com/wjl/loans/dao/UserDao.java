package com.wjl.loans.dao;

import com.wjl.loans.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 念迟 & https://www.mrchi.cn
 * @creed: 夕颜几度香散尽, 自古多情空念迟
 * @date: 2020/5/16 12:54
 * @project: ${ProjectNAME}
 * @description 不写点什么？
 */
@Repository
@Mapper
public interface UserDao {

    /**
     * 查询用户是否存在，若是存在则提示已存在
     *
     * @param name
     * @return
     */
    @Select(value = "select u.id from t_user u where u.name=#{name} ")
    User findUserNameByName(String name);

    /**
     * 新增用户
     * <p>
     * 加入该注解可以保存对象后，查看对象插入id
     *
     * @param user
     * @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
     */
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_user (name,age,pwd,idcard,ctime) values(#{name},#{age},#{pwd},#{idcard},#{ctime})")
    void regist(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Select("select * from t_user u where u.name = #{name} and u.pwd = #{pwd}")
    User login(User user);

    /**
     * 用户更新
     *
     * @param user
     * @return
     */
    @Update("UPDATE t_user SET  idcard = #{idcard}, phone = #{phone}, page = #{page} WHERE name = #{name}")
    Long update(User user);

    @Select("select u.id from t_user u where u.name = #{name}")
    User findUserNameByID(User user);

    @Select("SELECT * FROM t_user")
    List<User> findAllUser();
}
