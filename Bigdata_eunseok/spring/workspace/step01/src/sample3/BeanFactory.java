package sample3;

public class BeanFactory {
	public MessageBean getBean(String beanName) {
		MessageBean bean = null;
		if(beanName.equals("kr")) {
			bean = new MessageBeanKr();
		}else if(beanName.equals("en")){
			bean = new MessageBeanEn();
		}
		return bean;
	}
}
