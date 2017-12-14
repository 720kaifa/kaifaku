package simpleoa.service;

import org.springframework.stereotype.Service;
import simpleoa.model.WorkTime;

import java.util.List;

/**
 * Created by Luwer on 2017/12/11.
 */

@Service
public interface WorkTimeService {
    public List<WorkTime> findAllByUserId(int userid, String role, int pageSize, int pageNum) ;
    public int getCount(int userid,String role);
}
