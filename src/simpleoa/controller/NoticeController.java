package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.Notice;
import simpleoa.model.User;
import simpleoa.service.NoticeService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/addNotice")
    public void addNews(Notice notice, HttpSession session, HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        int result=noticeService.addNotice(notice,user);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/noticeList")
    public void findAllNotice(int pageSize,int pageNum,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        List<Notice> noticeList=noticeService.findAllNotice(pageSize,pageNum);
        json.put("noticeList",noticeList);
        out.print(json);
    }

    @RequestMapping("/getCount")
    public void getCount(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        int conut=noticeService.getCount();
        json.put("conut",conut);
        out.print(json);
    }
}
