package sample1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MessageBeanImpl implements MessageBean {

	private Log log = LogFactory.getLog(getClass());

	private String name;
	private String greeting;

	public MessageBeanImpl(String name) {
		this.name = name;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		String message = greeting + name + "!";
		log.info("ThreadID=" + Thread.currentThread().getId() + ":" + message);
	}

}
