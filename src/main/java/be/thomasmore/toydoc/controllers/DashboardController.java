package be.thomasmore.toydoc.controllers;

import be.thomasmore.toydoc.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private AppUserRepository appUserRepository;

    GetMapping("/dashboard/{}")
}
