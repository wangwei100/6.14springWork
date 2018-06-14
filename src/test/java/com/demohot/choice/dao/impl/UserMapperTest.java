package com.demohot.choice.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.demohot.choice.mapper.UserMapper;
import com.demohot.choice.model.User;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:app-context.xml")
public class UserMapperTest {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testRegister() {
		User user = new User();
		user.setUsername("1234567");
		user.setPassword("123");
		userMapper.insert(user);
	}

	@Test
	public void testLogin() {
		String username = "1234567";
		String password = "123";
		User user = userMapper.getByUsernameAndPassword(username, password);
		System.out.println(user);
	}

}
