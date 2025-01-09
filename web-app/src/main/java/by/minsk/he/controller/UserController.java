package by.minsk.he.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/web")
public class UserController {

    private static final String PAGE_HOME_NAME = "home";

    @GetMapping("/home")
    public String getHomePage() {
        return PAGE_HOME_NAME;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login_page";
    }

    @GetMapping("/personal")
    public String clientHome() {
        return "personal_page";
    }
}
