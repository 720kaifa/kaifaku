package simpleoa.controller;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import simpleoa.model.NavMenu;
import simpleoa.model.Project;
import simpleoa.model.User;
import simpleoa.service.NavService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */

@Controller
@RequestMapping("/menu")
public class NavMenuController {
    @Autowired
    private NavService navService;

    @RequestMapping("/getMenu")
    public void GetMenu(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        JSONObject json=new JSONObject();
        User user=(User)session.getAttribute("simpleoa_user");
        List<NavMenu> menuList=navService.findAllByAut(user);
        json.put("menuList",menuList);
        out.print(json);
    }
}
