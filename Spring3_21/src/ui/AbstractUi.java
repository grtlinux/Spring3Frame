package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exception.IORuntimeException;

public abstract class AbstractUi {

	protected String getInputedString() {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		try {
			return input.readLine();
		} catch (IOException e) {
			// TODO: handle exception
			throw new IORuntimeException("can't get the data from console..", e);
		}
	}

	public abstract void show();
}
