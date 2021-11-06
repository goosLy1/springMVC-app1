package ru.goosly.springapps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/third")
public class ThirdController {

    @GetMapping("/calculator")
    public String doCalculations(@RequestParam("a") int a,
                                 @RequestParam("b") int b,
                                 @RequestParam("action") String action,
                                 Model model) {
        double result;
        switch(action) {
            case "addiction":
                result=a + b;
                break;
            case "subtraction":
                result=a - b;
                break;
            case "multiplication":
                result=a * b;
                break;
            case "division":
                result=a / (double) b;
                break;
            default:
                result=-1;
        }
        model.addAttribute("calculator", "Parameters: a=" + a + " b=" + b +
                " The result of " + action + " is " + result);

        return "third/calculator";
    }
}
