package hello.springmvc12.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @GetMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mv = new ModelAndView("response/hello").addObject("data", "hello!");

        return mv;
    }

    @GetMapping("/response-view-v2")
    public String responseView1(Model model) {
        model.addAttribute("data", "hello!");

        return "response/hello";
    }

}
