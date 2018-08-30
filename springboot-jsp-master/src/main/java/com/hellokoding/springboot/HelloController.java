package com.hellokoding.springboot;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hellokoding.dao.ExternalLiveScore;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView adminPage() throws IOException, JSONException {
    	ExternalLiveScore dao=new ExternalLiveScore();
        ModelAndView model = new ModelAndView();
        model.addObject("users", dao.getAllScore());
        model.setViewName("show");
        return model;

    }
}
