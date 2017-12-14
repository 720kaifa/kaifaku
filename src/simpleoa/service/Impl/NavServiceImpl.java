package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.INavDao;
import simpleoa.model.NavMenu;
import simpleoa.model.User;
import simpleoa.service.NavService;

import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
@Service
public class NavServiceImpl implements NavService {

    @Autowired
    private INavDao iNavDao;

    @Override
    public List<NavMenu> findAllByAut(User user) {
        int authority;
        switch (user.getRole())
        {
            case "SuperUser":authority=1;;break;
            case "AdminUser":authority=2;break;
            case "OrdinaryUser":authority=3;break;
            default:authority=3;break;
        }
        return iNavDao.findAllByAut(authority);
    }
}
