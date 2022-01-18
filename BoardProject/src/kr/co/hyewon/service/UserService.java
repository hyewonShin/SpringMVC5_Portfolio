package kr.co.hyewon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.hyewon.bean.UserBean;
import kr.co.hyewon.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	// 아이디 중복검사 
	public boolean checkUserIdExist(String user_id) {
		
		String user_name = userDao.checkUserIdExist(user_id);
	
		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
}