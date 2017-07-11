package com.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void updateName(Integer id, String name) {
		userDao.updateName(id, name);
	}
	
	//ʹ���Լ��������������������ţ�Ĭ����REQUIRES,timeout����ʱʱ��
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED,
					readOnly=false,timeout=1)
	@Override
	public String getName(Integer id) {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userDao.getName(id);
	}
}
