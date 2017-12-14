package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.User;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

/**
 * Created by Luwer on 2017/11/29.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/toMain")
    public String toMain(HttpSession session){
        User user= (User) session.getAttribute("simpleoa_user");
        if(user==null){
            return "login";
        }else{
            return "main";
        }
    }

    @RequestMapping("/getWorkTime")
    public void getWorkTime(HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        int workTime[]={20,7,2,2};
        json.put("workTime",workTime);
        out.print(json);
    }

    @RequestMapping("/getBar")
    public void getBar(HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        int[][] barDate={};
       for(int i=0;i<3;i++){
           int[] timeDate={i+10,i+13,i+26,i+33,i+36};
       }
       String[] ticData={ "弯针","管理员","李四","王五","赵谦"};
        json.put("barDate",barDate);
        json.put("ticData",ticData);
        out.print(json);
    }
}
