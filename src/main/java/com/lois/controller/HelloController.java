package com.lois.controller;

import com.lois.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@RequestMapping("/springmvc")
@SessionAttributes(value = "user",types = User.class)
public class HelloController {

    //----------SessionAttributes start------------
    @RequestMapping("/testSessionAttributesPut")
    public String testSessionAttributesPut(Model model){
        User user = new User();
        user.setId(1);
        user.setUsername("lois");
        user.setPassword("123456");
        model.addAttribute("user",user);
        System.out.println("数据存储成功");
        return "success";
    }
    @RequestMapping("/testSessionAttributesGet")
    public String testSessionAttributesGet(ModelMap model){
        System.out.println(model.get("user"));
        return "success";
    }
    @RequestMapping("/testSessionAttributesDel")
    public String testSessionAttributesDel(SessionStatus status){
        System.out.println("清除存储的数据");
        status.setComplete();
        return "success";
    }
    //----------SessionAttributes end------------


    @RequestMapping("/hello") //访问该方法的路径
    public String Hello(int money){
        System.out.println("Hello SpringMVC! money=" + money);
        return "success"; //跳转页面的名字,给视图解析器解析
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST) //使用Post方法提交
    public String Hello(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String name){
        System.out.println(name);
        return "success";
    }

    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    @RequestMapping(value = "/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable String uid){
        System.out.println(uid);
        return "success";
    }

    @RequestMapping(value = "/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header){
        System.out.println(header);
        return "success";
    }

    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println(cookie);
        return "success";
    }

    //-------------ModelAttribute-------------
//    @ModelAttribute
//    public User setUserId(User user){
//        user.setId(1);
//        System.out.println("执行了setUserId");
//        return user;
//    }
//    @RequestMapping(value = "/testModelAttribute",method = RequestMethod.POST) //使用Post方法提交
//    public String testModelAttribute(User user){
//        System.out.println("修改后的User为"+user);
//        return "success";
//    }

    @ModelAttribute
    public void setUserId(User user, Map<String,User> map){
        user.setId(1);
        System.out.println("执行了setUserId");
        map.put("abc",user);
    }
    @RequestMapping(value = "/testModelAttribute",method = RequestMethod.POST) //使用Post方法提交
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("修改后的User为"+user);
        return "success";
    }
}
