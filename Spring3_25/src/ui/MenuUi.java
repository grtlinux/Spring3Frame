package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

	private SelectEventUi selectEventUi;
	private SelectUserUi selectUserUi;
	private UpdateUserUi updateUserUi;

	public void setSelectEventUi(SelectEventUi selectEventUi) {
		this.selectEventUi = selectEventUi;
	}

	public void setSelectUserUi(SelectUserUi selectUserUi) {
		this.selectUserUi = selectUserUi;
	}

	public void setUpdateUserUi(UpdateUserUi updateUserUi) {
		this.updateUserUi = updateUserUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("『티켓 예약』「메뉴」");
		System.out.println("");
		System.out.println("1.종료");
		System.out.println("2.이벤트 검색");
		System.out.println("3.예약 완료 티켓 목록");
		System.out.println("4.유저명 변경");
		System.out.println("");
		System.out.println("번호를 입력한 후 Enter를 눌러주세요.");
	}

	@Override
	protected int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	protected int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch (number) {
		case 1:
			// 1.종료
			System.out.println("종료되었습니다.");
			System.exit(0);
		case 2:
			// 2.이벤트 검색
			this.selectEventUi.show();
			break;
		case 3:
			// 3.예약 완료 티켓 목록
			this.selectUserUi.show();
			break;
		case 4:
			// 4.유저명 변경
			this.updateUserUi.show();
			break;
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MenuUi menuUi = context.getBean(MenuUi.class);
		while (true) {
			menuUi.show();
		}
	}
}
