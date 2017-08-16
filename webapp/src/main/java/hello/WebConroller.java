package hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebConroller {

    @RequestMapping(value="/greeting", method= RequestMethod.GET)
    @ResponseBody
    public String greeting() {
        // model.addAttribute("name", name);
        return "{\"id\":1,\"content\":\"Hello, World!\"}";
    }
}
