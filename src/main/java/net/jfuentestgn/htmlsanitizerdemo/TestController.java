package net.jfuentestgn.htmlsanitizerdemo;

import lombok.extern.slf4j.Slf4j;
import net.jfuentestgn.htmlsanitizer.Sanitizer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller()
@Slf4j
public class TestController {

    private final Sanitizer sanitizer;

    public TestController(Sanitizer sanitizer) {
        this.sanitizer = sanitizer;
    }

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/test")
    public String submitForm(TestForm data, Model model) {
        model.addAttribute("data", data);
        model.addAttribute("customized", this.sanitizer.sanitize("CUSTOM", data.getHtmlContent()));
        return "result";
    }
}
