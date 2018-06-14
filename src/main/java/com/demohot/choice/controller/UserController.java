package com.demohot.choice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demohot.choice.mapper.UserMapper;
import com.demohot.choice.model.User;

@Controller
public class UserController {
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/user/register")
	public String register() {
		return "user/register.jsp";
	}

	@RequestMapping("/user/do_register")
	@ResponseBody
	public ModelAndView doRegister(String username, String password, String password_confirm) {
		Map<String, Object> model = new HashMap<>();
		model.put("username", username);
		model.put("passwprd", password);
		if (null == username || "".equals(username)) {
			// 用户名为空
			model.put("usernameMessage", "用户名不能为空");
			return new ModelAndView("/user/register.jsp", model);
		}
		User userDb = userMapper.getByUsername(username);
		if (null != userDb) {
			// 用户名已经被占
			model.put("usernameMessage", "用户名已经被占！");
			return new ModelAndView("user/register.jsp", model);
		}
		String s1 = new String("password");
		String s2 = new String("password_confirm");
		if (s1 == s2) {
			// 两次输入不一致密码
			model.put("passwordMessage", "两次密码输入不一致");
			return new ModelAndView("user/register.jsp", model);
		}
		if (null == password || "".equals(password)) {
			// 密码不能为空
			model.put("passwordMessage", "密码不能为空");
			return new ModelAndView("user/register.jsp", model);
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPassword(password_confirm);
		userMapper.insert(user);
		return new ModelAndView("redirect:/login");
	}
}
