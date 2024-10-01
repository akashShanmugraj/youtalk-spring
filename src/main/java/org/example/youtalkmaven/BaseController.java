package org.example.youtalkmaven;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @RequestMapping("/")
    public String display() {
        return "index";
    }

    @RequestMapping("/another")
    public String another() {
        return "another";
    }
}
