package com.lois.controller;

import com.lois.domian.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/return")
public class returnController {

    //返回值是字符串
    @RequestMapping("/testReturnString")
    public String testReturnString(){
        System.out.println("testReturnString方法执行了。。。");
        return "success";
    }

    //返回值是void
    @RequestMapping("/testReturnVoid")
    public void testReturnVoid(HttpServletRequest request, HttpServletResponse response){
        System.out.println("testReturnVoid方法执行了。。。");
    }

    //返回值是ModelAndView
    @RequestMapping("/testReturnModelAndView")
    public ModelAndView testReturnModelAndView(ModelAndView mv){
        System.out.println("testReturnModelAndView方法执行了。。。");
        User user = new User();
        user.setId(1);
        user.setUsername("lois");
        user.setPassword("123456");
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    //转发
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("testForward方法执行了。。。");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    //重定向
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect方法执行了。。。");
        return "redirect:/index.jsp";
    }

    //ajax
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了。。。");
        System.out.println(user);
        user.setUsername("lois");
        return user;
    }

    //上传文件
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("fileUpload方法执行了。。。");
        //获取需要上传文件的位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        //获取上传文件名称
        String fileName = upload.getOriginalFilename();
        //把文件名唯一化
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        fileName = uuid + "-" + fileName;
        //上传文件
        upload.transferTo(new File(file,fileName));
        return "success";
    }

    //异常处理
    @RequestMapping("/testException")
    public String testException(){
        System.out.println("testException方法执行了。。。");
        int i = 1/0;
        return "success";
    }

    //拦截器
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor方法执行了。。。");
        return "success";
    }
}
