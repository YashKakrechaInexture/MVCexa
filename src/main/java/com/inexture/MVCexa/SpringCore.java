package com.inexture.MVCexa;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

@Controller
public class SpringCore {
	
	@RequestMapping("/core")
	public String redirect() {
		return "viewpage3";
	}
	
	@RequestMapping("/validate")  
    public String display(HttpServletRequest req,Model m)  
    {  
        //read the provided form data  
        String name=req.getParameter("name");  
        String pass=req.getParameter("pass");  
        if(pass.equals("admin"))  
        {  
            String msg="Hello "+ name;  
            //add a message to the model  
            m.addAttribute("message", msg);  
            return "viewpage4";  
        }  
        else  
        {  
            String msg="Sorry "+ name+". You entered an incorrect password";  
            m.addAttribute("message", msg);  
            return "errorpage";  
        }     
    }  
	@RequestMapping("/validate2")  
    public String display2(@RequestParam("name2") String name,@RequestParam("pass2") String pass,Model m)  
    {  
        if(pass.equals("admin"))  
        {  
            String msg="Hello "+ name;  
            //add a message to the model  
            m.addAttribute("message", msg);  
            return "viewpage4";  
        }  
        else  
        {  
            String msg="Sorry "+ name+". You entered an incorrect password";  
            m.addAttribute("message", msg);  
            return "errorpage";  
        }     
    }  
	
	@RequestMapping("/message/{name}")
	@ResponseBody
	public String message(@PathVariable String name) {
		return "Hello "+name;
	}
	
	@RequestMapping("/users")
	public ModelAndView temp() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1,"yash"));
		list.add(new Student(2,"abc"));
		list.add(new Student(3,"pqr"));
		list.add(new Student(4,"xyz"));
		//m.addAttribute("users",list);
		
		ModelAndView model = new ModelAndView("usersView");
        model.addObject("users", list);
        
		return model;
	}
}
