package com.ssv.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.opensymphony.xwork2.ActionSupport;
import com.ssv.dto.SearchDto;
import com.ssv.mapper.UserMapper;
import com.ssv.model.User;
import com.ssv.util.SqlSessionFactoryUtil;

import lombok.Data;

@Data
public class UserAction extends ActionSupport {
	private List<User> users = new ArrayList<User>();

	@Override
	public String execute() throws Exception {
		initData();
		return super.execute();
	}

	private int page = 0;
	private int pageSize = 5;
	private String searchName;
	private int totalPage;

	private void initData() {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		SearchDto dto = new SearchDto(page * pageSize, pageSize, searchName);
		totalPage = userMapper.totalPage(dto);
		if (totalPage % pageSize == 0) {
			totalPage = (totalPage / pageSize) - 1;
		} else {
			totalPage = (totalPage / pageSize);
		}
		users = userMapper.search(dto);
		sqlSession.close();
	}

	public String next() throws Exception {
		page++;
		initData();
		return super.execute();
	}

	public String previous() throws Exception {
		page--;
		initData();
		return super.execute();
	}

}
