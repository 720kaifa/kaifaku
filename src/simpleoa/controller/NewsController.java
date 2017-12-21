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
import java.util.List;

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

    @RequestMapping("/newsList")
    public void findAllNews(int pageSize,int pageNum,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        List<News> newsList=newsService.findAllNews(pageSize,pageNum);
        json.put("newsList",newsList);
        out.print(json);
    }

    @RequestMapping("/getCount")
    public void getCount(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        JSONObject json=new JSONObject();
        PrintWriter out=response.getWriter();
        int conut=newsService.getCount();
        json.put("conut",conut);
        out.print(json);
    }

    @RequestMapping("/getNews")
    public void getNews(int id,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        News news =newsService.findNewsById(id);
        json.put("news",news);
        out.print(json);
    }

    @RequestMapping("/updateNews")
    public void updateNews(News news, HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        int result=newsService.updateNews(news,user);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/delNews")
    public void delNews(int id,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        int result=newsService.delNews(id);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/getNews")
    public void getNews(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        News news =newsService.getNews();
        if(news!=null){
            json.put("news",news);
        }else{
            json.put("news","errorNull");
        }
        out.print(json);
    }
}
