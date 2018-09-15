package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

abstract public class AbstractUiTemplate extends AbstractUi {

	@Override
	public void show() {
		// 메뉴 표시
		showMenu();
		// 콘솔에 입력된 값을 취득
		String inputedString = getInputedString();
		// 입력된 문자열을 검증
		if (isValidNumber(inputedString)) {
			// 처리를 기동
			execute(NumberUtils.toInt(inputedString));
		}
	}

	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);

	protected boolean isValidNumber(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		} else if (!StringUtils.isNumeric(str)) {
			return false;
		}

		int number = NumberUtils.toInt(str);
		if (getMinMenuNumber() <= number && number <= getMaxMenuNumber()) {
			return true;
		}
		return false;
	}
}
