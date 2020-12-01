package com.ssv.actions;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssv.mapper.UserMapper;
import com.ssv.model.User;
import com.ssv.util.SqlSessionFactoryUtil;

import lombok.var;

public class LoginAction extends ActionSupport implements SessionAware, ModelDriven<User> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3369875299120377549L;

	@Override
	public String execute() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		if (userMapper.getUser(user.getUsername(), user.getPassword()) != null) {
			user = userMapper.getUser(user.getUsername(), user.getPassword());
			sqlSession.close();
			addActionMessage("Welcome Admin, do some work.");
		} else {
			addActionError("User name is not valid");
		}
	}

	private User user = new User();

	private Map<String, Object> sessionAttributes = null;

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
