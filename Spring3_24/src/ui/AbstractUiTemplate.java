package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

abstract public class AbstractUiTemplate extends AbstractUi {

	@Override
	public void show() {
		// TODO Auto-generated method stub

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
