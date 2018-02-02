package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * redis缓存配置(先安装redis)：
	 * 1.pom.xml 添加spring-boot-starter-redis
	 * 2.添加配置类：RedisConfig.java;
	 * 3.application.properties中设置redis参数；
	 * 4.业务层使用注解把数据保存到redis和从redis删除；
	 * 
	 * redis常用命令：
	 * 1.查询:get key;
	 * 2.删除:del key;
	 * 3.删除所有:flushall;
	 * 4.查询所有key:keys *;
	 * 5.保存键值对:set key value;
	 */
	
	/**
	 * 查询
	 */
	@RequestMapping("getUser")
	public Object get(String username) {
		User us = userService.getUser(username);

		return us;
	}

	/**
	 * 增加
	 */
	@RequestMapping("saveUser")
	public Object saveUser(User user) {

		User result =userService.saveUser(user);

		return result;

	}

	/**
	 * 删除
	 */
	@RequestMapping("removeUser")
	public Object removeUser(String username) {
		boolean removeUserByName = this.userService.removeUserByName(username);
		return removeUserByName;
	}
	
	
}
