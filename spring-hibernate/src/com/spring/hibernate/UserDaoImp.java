package com.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public String getName(Integer id) {
		String sql = "SELECT name FROM User WHERE ID = ?";
		Query query = getSession().createQuery(sql).setInteger(0, id);
		return (String)query.uniqueResult();
	}

	@Override
	public void updateName(Integer id, String name) {
		int count = 0;
		String sql = "UPDATE User SET NAME = ? WHERE ID = ?";
		getSession().createQuery(sql).setInteger(0, id).executeUpdate();
	}
}
