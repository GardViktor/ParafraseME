package com.me.Parafrase.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuControllerUI {

    @GetMapping("/")
    public String menu() {
        return "menu";
    }
}