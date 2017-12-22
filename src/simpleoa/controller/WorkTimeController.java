package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.User;
import simpleoa.model.WorkTime;
import simpleoa.service.WorkTimeService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Luwer on 2017/12/12.
 */
@Controller
@RequestMapping("/workTime")
public class WorkTimeController {


    @Autowired
    private WorkTimeService workTimeService;

    @RequestMapping("/workTimeList")
    public void WorkTimeList(int pageSize,int pageNum,HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        List<WorkTime> workTimeList=workTimeService.findAllByUserId(user.getId(),user.getRole(),pageSize,pageNum);
        json.put("workTimeList",workTimeList);
        out.print(json);
    }

    @RequestMapping("/getCount")
    public void GetCount(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        json.put("conut",workTimeService.getCount(user.getId(),user.getRole()));
        out.print(json);
    }
}
