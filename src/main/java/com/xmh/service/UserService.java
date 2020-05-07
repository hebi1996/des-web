package com.xmh.service;

import java.util.List;

import com.xmh.entity.Admin;
import com.xmh.entity.User;
import com.xmh.utils.PageHelper;

public interface UserService {
	boolean addUser(User user);
	User selectUserByUNAndPWD(String username, String password);
	Admin selectAdminByUNAndPWD(String username, String password);
	List<User> selectAllUser();
	boolean updateUserInfo(User user);
	boolean adminAddUser(User user);
	boolean deleteUser(Integer id);
	boolean adminAddAdmin(Admin admin);
	boolean admindeleteAdmin(Integer id);
	List<Admin> selectAddAdmin();
	User userInfoByUserId(Integer userId);
	boolean editUserInfo(User user);
	Admin selectAdminByUserId(Integer userId, String oldPassword);
	boolean changeAdminPwd(Integer userId, String newPassword);
	User selectUserByUserIdAndOldPwd(Integer userId, String oldPassword);
	boolean changeUserPwd(Integer userId, String newPassword);
	PageHelper<User> selectAllUserByPage(Integer page);

}
