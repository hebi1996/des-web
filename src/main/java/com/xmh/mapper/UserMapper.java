package com.xmh.mapper;

import java.util.List;

import com.xmh.entity.Admin;
import com.xmh.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean addUser(User user);
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User selectUserByUNAndPWD(@Param("username") String username, @Param("password") String password);
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	Admin selectAdminByUNAndPWD(@Param("username") String username, @Param("password") String password);
	/**
	 * 
	 * @return
	 */
	List<User> selectAllUser();
	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean updateUserInfo(User user);
	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean adminAddUser(User user);
	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteUser(@Param("id") Integer id);
	/**
	 * 
	 * @param admin
	 * @return
	 */
	boolean adminAddAdmin(Admin admin);
	/**
	 * 
	 * @param id
	 * @return
	 */
	boolean admindeleteAdmin(@Param("id") Integer id);
	/**
	 * 
	 * @return
	 */
	List<Admin> selectAddAdmin();
	/**
	 * 
	 * @param userId
	 * @return
	 */
	User userInfoByUserId(@Param("userId") Integer userId);
	/**
	 * 
	 * @param user
	 * @return
	 */
	boolean editUserInfo(User user);
	/**
	 * 
	 * @param userId
	 * @param oldPassword
	 * @return
	 */
	Admin selectAdminByUserIdAndOldPwd(@Param("id") Integer userId, @Param("oldPwd") String oldPassword);
	/**
	 * 
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	boolean changeAdminPwd(@Param("id") Integer userId, @Param("newPwd") String newPassword);
	/**
	 * 
	 * @param userId
	 * @param oldPassword
	 * @return
	 */
	User selectUserByUserIdAndOldPwd(@Param("id") Integer userId, @Param("oldPwd") String oldPassword);
	/**
	 * 
	 * @param userId
	 * @param newPassword
	 * @return
	 */
	boolean changeUserPwd(@Param("id") Integer userId, @Param("newPwd") String newPassword);
	/**
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	List<User> selectAllUserByPage(@Param("page") Integer page, @Param("size") Integer size);
	/**
	 * 
	 * @param id
	 * @return
	 */
	Admin selectAdminById(@Param("id") Integer id);

}
