package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.IORuntimeException;

abstract public class AbstractUi {

	protected String getInputedString() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			return input.readLine();
		} catch (IOException e) {
			throw new IORuntimeException("콘솔에 입력된 값을 받을 수 없습니다.", e);
		}
	}

	abstract public void show();
}
