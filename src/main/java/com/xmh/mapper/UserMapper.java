package com.xmh.mapper;

import java.util.List;

import com.xmh.entity.Admin;
import com.xmh.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	boolean addUser(User user);
	User selectUserByUNAndPWD(@Param("username") String username, @Param("password") String password);
	Admin selectAdminByUNAndPWD(@Param("username") String username, @Param("password") String password);
	List<User> selectAllUser();
	boolean updateUserInfo(User user);
	boolean adminAddUser(User user);
	boolean deleteUser(@Param("id") Integer id);
	boolean adminAddAdmin(Admin admin);
	boolean admindeleteAdmin(@Param("id") Integer id);
	List<Admin> selectAddAdmin();
	User userInfoByUserId(@Param("userId") Integer userId);
	boolean editUserInfo(User user);
	Admin selectAdminByUserIdAndOldPwd(@Param("id") Integer userId, @Param("oldPwd") String oldPassword);
	boolean changeAdminPwd(@Param("id") Integer userId, @Param("newPwd") String newPassword);
	User selectUserByUserIdAndOldPwd(@Param("id") Integer userId, @Param("oldPwd") String oldPassword);
	boolean changeUserPwd(@Param("id") Integer userId, @Param("newPwd") String newPassword);
	List<User> selectAllUserByPage(@Param("page") Integer page, @Param("size") Integer size);

}
