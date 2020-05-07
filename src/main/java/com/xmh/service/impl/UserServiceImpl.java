package com.xmh.service.impl;

import java.util.List;

import com.xmh.entity.Admin;
import com.xmh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmh.mapper.UserMapper;
import com.xmh.service.UserService;
import com.xmh.utils.PageHelper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PageHelper<User> pageHelper;
	
	@Override
	public boolean addUser(User user) {
		return userMapper.addUser(user);
	}

	@Override
	public User selectUserByUNAndPWD(String username, String password) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUNAndPWD(username, password);
	}

	@Override
	public Admin selectAdminByUNAndPWD(String username, String password) {
		return userMapper.selectAdminByUNAndPWD(username,password);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}

	@Override
	public boolean updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserInfo(user);
	}

	@Override
	public boolean adminAddUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.adminAddUser(user);
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

	@Override
	public boolean adminAddAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return userMapper.adminAddAdmin(admin);
	}

	@Override
	public boolean admindeleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.admindeleteAdmin(id);
	}

	@Override
	public List<Admin> selectAddAdmin() {
		// TODO Auto-generated method stub
		return userMapper.selectAddAdmin();
	}

	@Override
	public User userInfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.userInfoByUserId(userId);
	}

	@Override
	public boolean editUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.editUserInfo(user);
	}


	@Override
	public Admin selectAdminByUserId(Integer userId, String oldPassword) {
		// TODO Auto-generated method stub
		return userMapper.selectAdminByUserIdAndOldPwd(userId, oldPassword);
	}

	@Override
	public boolean changeAdminPwd(Integer userId, String newPassword) {
		// TODO Auto-generated method stub
		return userMapper.changeAdminPwd(userId,newPassword);
	}

	@Override
	public User selectUserByUserIdAndOldPwd(Integer userId, String oldPassword) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUserIdAndOldPwd(userId, oldPassword);
	}

	@Override
	public boolean changeUserPwd(Integer userId, String newPassword) {
		// TODO Auto-generated method stub
		return userMapper.changeUserPwd(userId,newPassword);
	}

	@Override
	public PageHelper<User> selectAllUserByPage(Integer page) {
		// TODO Auto-generated method stub
		//page����С��1
		if (page<=1) {
			page = 1;
		}
		//���浱ǰҳ
		pageHelper.setNow_page(page);
		List<User> totalUsers = userMapper.selectAllUser();
		Integer size = pageHelper.getSize();
		List<User> users = userMapper.selectAllUserByPage((page-1)*size,size);
		//�ܼ�¼��
		pageHelper.setCounts(totalUsers.size());
		
		//��ҳ����
		pageHelper.setList(users);
		//��ҳ��
		int total = pageHelper.getPage_total();
		if (page>1) {
			pageHelper.setPrev(true);
			
		}else {
			pageHelper.setPrev(false);
		}
		if (page<total) {
			pageHelper.setNext(true);
			
		}else {
			pageHelper.setNext(false);
		}
		return pageHelper;
	}



}
