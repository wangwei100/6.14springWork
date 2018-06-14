package com.demohot.choice.mapper;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.annotations.Param;

import com.demohot.choice.model.User;

public interface UserMapper {
	void insert(User user);

	User getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	User getByUsername(String username);

	User get(int id);

	List<User> list();
}
