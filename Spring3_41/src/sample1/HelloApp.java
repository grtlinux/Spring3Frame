package sample1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		new ClassPathXmlApplicationContext("beans.xml");
	}
}
