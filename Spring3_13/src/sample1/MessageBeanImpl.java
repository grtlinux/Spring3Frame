package sample1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

	private String greeting;
	private String beanName;
	private BeanFactory beanFactory;

	public MessageBeanImpl() {
		System.out.println("1. execute the constructor of Bean");
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. execute the setter method");
	}

	@Override
	public void setBeanName(String beanName) {
		System.out.println("3. setting the Bean name");
		this.beanName = beanName;
		System.out.println(" -> " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) {
		System.out.println("4. setting the BeanFactory name");
		this.beanFactory = beanFactory;
		System.out.println(" -> " + this.beanFactory.getClass());
	}

	public void init() {
		System.out.println("7. execute the method of initialization");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Finish");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("6. complete to set of properties");
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(this.greeting + this.beanName + "!");
	}

}
