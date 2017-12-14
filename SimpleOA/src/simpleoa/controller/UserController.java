package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import simpleoa.model.User;
import simpleoa.service.LoginLogService;
import simpleoa.service.UserService;
import simpleoa.util.CusAccessObjectUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Luwer on 2017/11/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping("/login")
    public void login(String account, String password , HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user = userService.login(account, password);
        if (user!=null) {
            if(user.getPassword().equals(password)){
                session.setAttribute("simpleoa_user", user);
                session.setMaxInactiveInterval(60 * 60);
                loginLogService.addLodinLog(user, CusAccessObjectUtil.getIpAddress(request));
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

    @RequestMapping("/addUser")
    public void addUser(String account, String relname,String role,HttpServletResponse response,HttpSession session) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User) session.getAttribute("simpleoa_user");
        int id=userService.addUser(account,relname,role,user.getAccount());
        if(id>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/getUser")
    public void GetUser(HttpServletResponse response,HttpSession session) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User suser=(User) session.getAttribute("simpleoa_user");
        User user=userService.findUserById(suser.getId());
        json.put("user",user);
        out.print(json);
    }

    @RequestMapping("/userList")
    public void UserList(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        List<User> userList=userService.findAll();
        json.put("userList",userList);
        out.print(json);
    }

    @RequestMapping("/updateUser")
    public void UpdateUser(User user,HttpSession session,HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User suser=(User) session.getAttribute("simpleoa_user");
        int result=userService.updateUser(user,suser);
        if(result>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }

    @RequestMapping("/register")
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
        response.setContentType("application/json;charset=UTF-8");
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
        int num=userService.updateUser(user,user);
        if(num>0){
            json.put("result","success");
        }else{
            json.put("result","error");
        }
        out.print(json);
    }
}
