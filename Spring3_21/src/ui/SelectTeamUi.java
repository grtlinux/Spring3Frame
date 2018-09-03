package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi {

	private TeamDao teamDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void show() {
		showTeamList(this.teamDao.getTeamList());
		System.out.println("press Enter key");
		getInputedString();
	}

	protected void showTeamList(List<Team> teamList) {
		System.out.println("----------------------");
		System.out.println(" [TEAM NAME]  [TEAM LIST]");
		System.out.println("ID   NAME");
		for (Team team : teamList) {
			System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
	}
}
