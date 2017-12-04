package cairh.community.api.game.kxian.util;

import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
public class CommunityPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	@Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        
        Enumeration<?> keys = props.propertyNames();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = props.getProperty(key);
            if (key.contains("password") && null != value) {
                props.remove(key);
                value = TriDES.decode(value.trim());
                props.setProperty(key, value);
            }
            System.setProperty(key, value);
        }
        
        super.processProperties(beanFactoryToProcess, props);
    }
}
