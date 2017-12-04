package cairh.community.api.game.kxian.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
public class SpringContext implements BeanFactoryAware, ApplicationContextAware {

    private static BeanFactory beanFactory = null;
    private static ApplicationContext springContext = null;
                                                              
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        beanFactory = factory;
    }

    public static Object getBean(String beanName) {
        if (beanFactory != null) {
            return beanFactory.getBean(beanName);
        }
        return null;
    }

    public static Object getDao(String daoName) {
        return getBean(daoName);
    }

    public static Object getService(String serviceName) {
        return getBean(serviceName);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
   	public static Object getBean(String beanName, Class clazz) {
       	if (beanFactory != null) {
               return beanFactory.getBean(beanName, clazz);
           }
           return null;
       }
    
    public static String[] getBeanNamesByType(Class<?> type) {
    	if (springContext != null) {
    		return springContext.getBeanNamesForType(type);
    	}
    	return new String[0];
    }

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		springContext = applicationContext;
	}
}