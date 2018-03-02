package demo.bb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import demo.bb.entity.User;
import demo.bb.mapper.UserMapper;

@RestController
@RequestMapping("user")
public class UserController<E> {

	@Resource
	private UserMapper userMapper;

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	@RequestMapping("getAll")
	public Object getAllUsers() {
		List<User> us = this.userMapper.selectAll();
		return us;
	}

	/**
	 * 分页查询所有-使用pagehelper工具分页
	 * 
	 * 
	 * @return
	 */
	@RequestMapping("getAllByPage")
	public Object getAllByPage(Integer start ,Integer limit){
		
		PageHelper.startPage((start+limit)/limit, limit);
		List<User> us = this.userMapper.selectAll();
		  PageInfo<User> appsPageInfo = new PageInfo<User>(us);
		 
		return appsPageInfo;
	}

	/**
	 * 根据参数查询
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("getByUsername")
	public Object getByUsername(@WebParam Map<String, String> params) {

		// 封装参数
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("username", "tom");
		List<User> us = this.userMapper.selectByExample(example);

		return us;
	}

	/**
	 * 批量插入
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("insertList")
	public Object insertList(String username) {

		List<User> us = new ArrayList();
		User u1 = new User();
		u1.setUsername(username);

		us.add(u1);
		int i = this.userMapper.insert(u1);
		
		System.out.print(u1.getUid());
		return i;
	}

}
