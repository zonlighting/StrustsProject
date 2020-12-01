package com.ssv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssv.dto.SearchDto;
import com.ssv.model.User;
@Mapper
public interface UserMapper {
	public User getUser(@Param("user") String username, @Param("pass") String password);

	void save(@Param("user") String user, @Param("pass") String pass);

	public List<User> getAll();

	public List<User> search(@Param("dto") SearchDto dto);

	public int totalPage(@Param("dto") SearchDto dto);
	

}
