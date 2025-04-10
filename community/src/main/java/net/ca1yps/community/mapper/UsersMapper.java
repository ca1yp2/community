package net.ca1yps.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.ca1yps.community.dto.Users;

@Mapper
public interface UsersMapper {
	
	List<Users> allUsers();
	Users getUserForUserid(String userid);
	
	void setInsertUser(Users user);
	void setUpdateUser(Users user);
	void setDeleteUser(int id);

}
