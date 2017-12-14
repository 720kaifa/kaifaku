package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.User;
import simpleoa.model.WorkLog;
import simpleoa.service.WorkLogService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
@Controller
@RequestMapping("/workLog")
public class WorkLogController {

    @Autowired
    private WorkLogService workLogService;

    @RequestMapping("/workLogList")
    public void WorkLogList(int pageSize,int pageNum,HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        List<WorkLog> workLogList=workLogService.findAllByUserId(user.getId(),pageSize,pageNum);
        json.put("workLogList",workLogList);
        out.print(json);
    }

    @RequestMapping("/getCount")
    public void GetCount(HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        json.put("conut",workLogService.getCount(user.getId()));
        out.print(json);
    }

    @RequestMapping("/addWorklog")
    public void AddWorklog(WorkLog workLog,HttpSession session,HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        int result=workLogService.addWorklog(workLog,user);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/updateWorklog")
    public void UpdateWorklog(WorkLog workLog,HttpSession session,HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        int result=workLogService.updateWorklog(workLog,user);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/getWorklog")
    public void GetWorkLog(int id,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        WorkLog workLog=workLogService.findWorklogById(id);
        json.put("workLog",workLog);
        out.print(json);
    }


    @RequestMapping("/delWorklog")
    public void DelWorklog(int id,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        int result=workLogService.delWorklog(id);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }
}
