package be.thomasmore.toydoc.controllers;


import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {


    @GetMapping("/dashboard")
    public String admin(){
        return "admin/dashboard";
    }


}
