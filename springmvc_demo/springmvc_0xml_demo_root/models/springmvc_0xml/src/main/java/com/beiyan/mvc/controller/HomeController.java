package com.beiyan.mvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.beiyan.mvc.exception.NotFoundException;
import com.beiyan.mvc.exception.BadRequestException;

@Controller
public class HomeController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(Model model) {
        model.addAttribute("name", "Proooogram");
        return "demo";
    }

    /**
     * upload the file
     *
     * @param file
     * @param picname
     * @param req
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("profilePicture") MultipartFile file,
        @RequestParam("picname") String picname, HttpServletRequest req) {
        System.out.println("上传文件时的name是:" + picname);
        System.out.println("上传的图片内容是：" + file);

        String path = req.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        // String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            try {
                targetFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
            return "fair";
        }
        return "success";
    }

    /**
     * 抛出异常，直接显示给浏览器
     *
     * @return
     */
    @RequestMapping(value = "/demo/exception", method = RequestMethod.GET)
    public @ResponseBody String demoException() {
        throw new NotFoundException();
    }

    /**
     * 抛出异常，被全局异常捕捉，在浏览器上显示异常处理后的返回信息
     *
     * @return
     */
    @RequestMapping(value = "/test/exception", method = RequestMethod.GET)
    public @ResponseBody String testException() {
        throw new BadRequestException();
    }

    /**
     * 测试重定向redirect，传递参数
     *
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String redirect(@RequestParam("username") String username, RedirectAttributes model) {
        model.addAttribute("username", username);
        return "redirect:handMessage";
    }

    @RequestMapping(value = "/handMessage", method = RequestMethod.GET)
    public @ResponseBody String handMessage(String username) {
        return username;
    }

}
