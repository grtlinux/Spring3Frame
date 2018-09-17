package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.UserDao;
import model.User;

public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		String query = " FROM User AS user WHERE user.name = :name ";
		List<User> userList = em.createQuery(query, User.class).setParameter("name", name).getResultList();

		if (userList.isEmpty()) {
			return null;
		}

		return userList.get(0);
	}

	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		em.merge(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		em.persist(user);
	}

}
