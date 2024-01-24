package st.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model
    ) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(
            @RequestParam(value = "operation", required = false) String operation,
            @RequestParam(value = "numA", required = false) int numA,
            @RequestParam(value = "numB", required = false) int numB,
            Model model
    ) {
        double result;
        switch (operation) {
            case "sum":
                result = numA + numB;
                break;
            case "min":
                result = numA - numB;
                break;
            case "dev":
                result = numA / (double) numB;
                break;
            case "mul":
                result = numA * numB;
                break;
            default:
                result = Double.POSITIVE_INFINITY;
                break;
        }
        model.addAttribute("result", "res = " + result);

        return "first/calc";
    }
}