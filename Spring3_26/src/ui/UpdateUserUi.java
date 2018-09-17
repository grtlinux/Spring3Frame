package ui;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.User;

public class UpdateUserUi extends AbstractUi {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public void show() {
		// TODO Auto-generated method stub
		showHeader();
		Integer id = getUserId();
		if (id == null)
			return;

		User user = this.userDao.getUser(id);
		if (user == null) {
			System.out.printf("입력된 유저ID '%s'는 존재하지 않습니다.%n", id);
			show();
			return;
		}

		showUser(user);
		String name = getName();
		if (StringUtils.isBlank(name)) {
			return;
		}

		user.setName(name);
	}

	protected Integer getUserId() {
		final String userId = "유저ID";
		// 메뉴 표시
		showMenu(userId);
		// 콘솔에 입력된 값을 취득
		String id = getInputedString();
		// 문자열이 입력되어 있는지?
		if (StringUtils.isBlank(id)) {
			return null;
		}
		// 숫자인지?
		if (UiUtils.isNumeric(id, userId)) {
			return new Integer(id);
		}

		return getUserId();
	}

	protected String getName() {
		showMenu("새로운 유저명");
		// 콘솔에 입력된 값을 취득
		String newName = getInputedString();
		// 128문자 이하인지?
		if (!UiUtils.isSmallLength(newName, "유저명", 128)) {
			return getName();
		}

		return newName;
	}

	protected void showUser(User user) {
		System.out.println("--------------------");
		System.out.println("『티켓 예약』「유저 정보 변경」");
		System.out.println("ID    이름");
		System.out.printf("%s  %s%n", user.getUserId(), user.getName());
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("『티켓 예약』「유저 정보 변경」");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s를 입력한 후 Enter를 눌러주세요.%n", wanted);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
	}
}
