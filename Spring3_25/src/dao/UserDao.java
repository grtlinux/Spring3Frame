package dao;

import model.User;

public interface UserDao {

	public User getUser(String name);
	public User getUser(Integer id);
	public void updateUser(User user);
}
