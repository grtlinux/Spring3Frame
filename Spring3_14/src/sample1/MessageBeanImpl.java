package sample1;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String message;

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}

		System.out.println("Hello, " + this.name + "!");
		System.out.printf("Message = [%s]%n", this.message);
	}

}
