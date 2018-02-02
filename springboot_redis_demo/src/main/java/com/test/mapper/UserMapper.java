package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where username=#{username}")
	public User getUser(String username);

	@Insert("insert into user values(null,#{username},#{password})")
	public void insertUser(User user);

	@Delete("delete from user where username=#{username}")
	public int removeUserByName(String username);

	@Update("update user set username=#{username} ,password =#{password} where uid=#{uid}")
	public int updateUser( User user);
}
