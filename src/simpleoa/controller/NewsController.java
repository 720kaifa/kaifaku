package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.News;
import simpleoa.model.User;
import simpleoa.service.NewsService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

/**
 * Created by Luwer on 2017/12/19.
 */

@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/addNews")
    public void addNews(News news, HttpSession session, HttpServletResponse response) throws IOException, ParseException{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        int result=newsService.addNews(news,user);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }
}
