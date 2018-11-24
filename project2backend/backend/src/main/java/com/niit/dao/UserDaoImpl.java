package com.niit.dao;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.models.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDaoImpl()
	{
		System.out.println("USER DAOIMPL BEAN CREATED");
		
		
		
	}
	
	@Override
	public void registerUser(User user) {
		Session session=sessionFactory.getCurrentSession();
	     session.save(user);
	}

	@Override
	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		
		
		Session session=sessionFactory.getCurrentSession();
		
		User user=(User)session.get(User.class, email);
				if(user==null)
					return true;
				else
		return false;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=? and password=?");
		query.setString(0, user.getEmail());
		query.setString(1, user.getPassword());
		return (User)query.uniqueResult();
	}
	
	
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		
		
		
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
     	return user;
	}
	
	
	
}
