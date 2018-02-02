package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 查询 value 是缓存的名字； key 是缓存对应的key 可在redis中用命令 get value:key查询出来； unless 除非；
	 * 缓存的是返回值；
	 * 
	 * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中 unless
	 *            表示条件表达式成立的话不放入缓存
	 */
	@Cacheable(value = "user", key = "#root.targetClass + #username", unless = "#result eq null")
	public User getUser(String username) {
		return userMapper.getUser(username);
	}

	/**
	 * 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存 缓存的是返回值
	 *
	 */
	@CachePut(value = "user",key = "#root.targetClass + #user.username", unless = "#user eq null")
	public User saveUser(User user) {
		if(user.getUid()==null){
			userMapper.insertUser(user);
			
		}else {
			this.userMapper.updateUser(user);
		}
		//user =getUser(user.getUsername());
		return user;
	}

	/**
	 * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
	 * @param username
	 * @return
	 */
	@CacheEvict(value = "user", key = "#root.targetClass + #username", condition = "#result eq true")
	public boolean removeUserByName(String username) {
		return userMapper.removeUserByName(username) > 0;
	}

}
