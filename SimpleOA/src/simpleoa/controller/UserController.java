package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import simpleoa.model.User;
import simpleoa.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Luwer on 2017/11/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public void login(String account,String password ,HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user = userService.login(account, password);
        if (user!=null) {
            if(user.getPassword().equals(password)){
                session.setAttribute("simpleoa_user", user);
                session.setMaxInactiveInterval(60 * 60);
                json.put("result","success");
            }else{
                json.put("result","passworderror");
            }
        } else {
            json.put("result","accounterror");
        }
        out.print(json);
    }
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
        ModelAndView mav = new ModelAndView();
        session.removeAttribute("simpleoa_user");
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("/register")
    @ResponseBody
    public void register(User user, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        boolean result=userService.register(user);
        if(result){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/checkAccount")
    public void checkAccount(String account,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user = userService.login(account,"");
        if (user!=null) {
            json.put("result","accounterror");
        }
        out.print(json);
    }

    @RequestMapping("/changePassword")
    public void changePassword(String password,HttpServletResponse response,HttpSession session) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user= (User) session.getAttribute("simpleoa_user");
        user.setPassword(password);
        int num=userService.updateUser(user);
        if(num>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }
}
