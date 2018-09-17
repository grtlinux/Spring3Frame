package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import dao.EventDao;
import model.Event;

public class SelectEventUi extends AbstractUi {

	private EventDao eventDao;
	private SelectRankUi SelectRankUi;

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void setSelectRankUi(SelectRankUi selectRankUi) {
		SelectRankUi = selectRankUi;
	}

	private static final String DATE_FORMAT_MESSAGE = "날짜는 YYYYMMDD형식으로 입력해주세요.(예:20100101)";

	@Override
	public void show() {
		// TODO Auto-generated method stub
		showHeader();
		showMenu("검색개시링");
		Date start = getDate();
		if (start == null)
			return;

		showMenu("검색종료일");
		Date end = getDate();
		if (end == null)
			return;

		if (start.compareTo(end) > 0) {
			System.out.println("검색종료일에는 검색개시일 이후의 날짜를 입력해 주세요.");
			show();
			return;
		}

		List<Event> eventList = this.eventDao.getEventList(start, end);
		showEventList(eventList);

		this.SelectRankUi.show();
	}

	protected void showEventList(List<Event> eventList) {
		System.out.println("--------------------");
		System.out.println("『티켓 예약』「이벤트 목록」");
		System.out.println("ID    이름    날짜");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

		for (Event event : eventList) {
			// 이벤트ID와 이벤트명, 날짜를 표시
			System.out.printf("%s  %s  %s%n", event.getEventId(), event.getName(), dateFormat.format(event.getDate()));
		}
	}

	protected Date getDate() {
		// 콘솔에 입력된 값을 취득
		String dateString = getInputedString();
		// 문자열이 입력되었는지?
		if (StringUtils.isEmpty(dateString)) {
			return null;
		}

		// 8문자(yyyyMMdd인지?
		if (dateString.length() != 8) {
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date;
		try {
			// Date로 변환
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// 날짜로 변환시킬 수 없는 형식의 문자열
			System.out.println(DATE_FORMAT_MESSAGE);
			return getDate();
		}

		// 현재 날짜보다 미래인지?
		if (new Date().after(date)) {
			System.out.println("지금보다 과거인 날짜는 입력할 수 없습니다. 다시 날짜를 입력해 주세요.");
			return getDate();
		}

		return date;
	}

	protected void showHeader() {
		System.out.println("--------------------");
		System.out.println("『티켓 예약』「이벤트 검색」");
		System.out.println("");
	}

	protected void showMenu(String wanted) {
		System.out.printf("%s를 입력한 후, Enter를 눌러주세요.%n", wanted);
		System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
		System.out.println(DATE_FORMAT_MESSAGE);
	}
}
