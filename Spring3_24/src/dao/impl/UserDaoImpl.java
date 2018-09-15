package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import dao.UserDao;
import model.User;

public class UserDaoImpl implements UserDao {

	private EntityManagerFactory emf;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		String query = " FROM User AS user WHERE user.name = :name ";
		List<User> userList = em.createQuery(query, User.class)
				.setParameter("name", name)
				.getResultList();

		if (userList.isEmpty())
			return null;

		return userList.get(0);
	}

}
