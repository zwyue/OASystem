package com.zhongrui.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Joanne
 * @date 2018/11/1 17:18
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @RequestMapping("/go")
    public String goTest(){
        return "reach";
    }

    @RequestMapping("/detail/data={uname}")
    public String goDetail(@PathVariable("uname")String data, Model model){
        model.addAttribute("data",data);
        return "detail" ;
    }

    @GetMapping("/report1")
    public String reportGet(@RequestParam("begin")String begin ,@RequestParam("end")String end , Model model){
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("formType","GET");
        return "report" ;
    }

    @PostMapping("/report2")
    public String reportPost(@RequestParam("begin")String begin ,@RequestParam("end")String end , Model model){
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("formType","POST");
        return "report" ;
    }
}
