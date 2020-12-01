package com.ssv.actions;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssv.mapper.UserMapper;
import com.ssv.model.User;
import com.ssv.util.SqlSessionFactoryUtil;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	public String cancel() {
		return LOGIN;
	};

	@Override
	public String execute() {
		return SUCCESS;
	}

	@Override
	public void validate() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactoryUtil.openSqlSession();
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			if (user.getUsername() == null || user.getPassword() == null) {
				sqlSession.close();
				addActionError("Must not be left blank\r\n" + "");
			} else {
				userMapper.save(user.getUsername(), user.getPassword());
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
