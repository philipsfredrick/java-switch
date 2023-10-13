package com.danielkpobari.formvalidationapp.controller;

import com.danielkpobari.formvalidationapp.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RestController
//@RequiredArgsConstructor
public class WebController implements WebMvcConfigurer {

//    private final ValidationService validationService;
//
//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(User user) {
        return "form";
    }

    @PostMapping("/")
    public String validateUserInfo(@Valid User user, Model model, BindingResult bindingResult) {
//        List<String> errors = validationService.validateUser(user);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", errors);
            return "form";
        }
        return "redirect:/results";
    }
}
