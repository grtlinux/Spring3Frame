package logic;

public class ShopImpl implements Shop {

	private UserCatalog userCatalog;

	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	@Override
	public void entryUser(User user) {
		// TODO Auto-generated method stub
		this.userCatalog.entryUser(user);
	}

}
