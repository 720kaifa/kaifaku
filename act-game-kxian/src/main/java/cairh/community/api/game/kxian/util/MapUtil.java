package cairh.community.api.game.kxian.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by duanxq on 2016/11/14.
 */
public class MapUtil {

    /**
     * 将javabean实体类转为map类型，然后返回一个map类型的值
     * @param obj
     * @return
     */
    public static Map<String, Object> beanToMap(Object obj) {
        Map params = new HashMap();
        try {
            params = BeanUtils.describe(obj);
            params.remove("class");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 将map转为javaBean
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T> T mapToBean(Map map, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

}
