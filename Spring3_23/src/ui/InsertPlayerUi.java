package ui;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {

	private TeamDao teamDao;
	private PlayerDao playerDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public void show() {
        final String playerName = "선수명";
        // 메뉴 표시
        showMenu(playerName);
        // 콘솔에 입력된 값을 취득
        String name = getInputedString();
        // 문자열이 입력되었는지?
        if (StringUtils.isEmpty(name)) {
            // 메뉴로 돌아가기
            return;
        // 128문자 이하인지?
        } else if (UiUtils.isSmallLength(name, playerName, 128)) {
            // 새로운 선수를 생성
            Player player = new Player();
            player.setName(name);
            // 팀을 결정
            showTeamField(player);
        } else {
            show();
        }
    }

    protected void showTeamField(Player player) {
        final String teamId = "팀ID";
        // 메뉴를 표시
        showMenu(teamId);
        // 콘솔에 입력된 값을 취득
        String id = getInputedString();
        // 문자열이 입력되어 있는지
        if (StringUtils.isEmpty(id)) {
            return;
        // 숫자인지?
        } else if (UiUtils.isNumeric(id, teamId)) {
            // ID로 팀을 검색
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                // 해당하는 팀이 존재하지 않는다
                System.out.printf("입력한 팀명「%s」인 팀은 존재하지 않습니다.%n", id);
                showTeamField(player);
            } else {
                // 팀을 선수에 지정
                player.setTeam(team);
                // 데이터베이스에 선수를 등록
                playerDao.insertPlayer(player);
                System.out.printf("팀「%s」에 「%s」선수를 추가했습니다.%n", team.getName(), player.getName());
            }
        }
    }

    protected void showMenu(String wanted) {
        System.out.println("--------------------");
        System.out.println("『선수 명단』「선수 추가」");
        System.out.println("");
        System.out.printf("%s를 입력한 후, Enter를 눌러 주세요.%n", wanted);
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
    }
}
