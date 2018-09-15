package ui;

public class MenuUi extends AbstractUiTemplate {

	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;
	private SelectPlayerUi selectPlayerUi;

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
		this.insertPlayerUi = insertPlayerUi;
	}

	public void setSelectPalyerUi(SelectPlayerUi selectPlayerUi) {
		this.selectPlayerUi = selectPlayerUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("『선수 명단』「메뉴 」");
		System.out.println("");
		System.out.println("1.종료 ");
		System.out.println("2.팀 목록 ");
		System.out.println("3.선수 추가 ");
		System.out.println("4.선수 목록 ");
		System.out.println("");
		System.out.println("번호를 입력한 후 Enter 키를 눌러주세요 .");
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
			System.out.println("종료되었습니다 .");
			System.exit(0);
		case 2:
			// 2.팀 목록
			this.selectTeamUi.show();
			break;
		case 3:
			// 3.선수 추가
			this.insertPlayerUi.show();
			break;
		case 4:
			// 4.선수 목록
			this.selectPlayerUi.show();
			break;
        }
	}

}
