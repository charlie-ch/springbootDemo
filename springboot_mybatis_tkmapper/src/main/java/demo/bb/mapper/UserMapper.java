package demo.bb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import demo.bb.conf.BaseMapper;
import demo.bb.entity.User;

// 继承写的BaseMapper
public interface UserMapper extends BaseMapper<User>{
	@Select("select * from user")
public List<User> getAllUsers();
	
}
