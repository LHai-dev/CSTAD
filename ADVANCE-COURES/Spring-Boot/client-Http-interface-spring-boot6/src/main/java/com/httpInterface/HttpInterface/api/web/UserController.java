package com.httpInterface.HttpInterface.api.web;

import com.httpInterface.HttpInterface.api.User;
import com.httpInterface.HttpInterface.api.UserClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

@Controller
public class UserController {
    private final UserRestController userRestController;
    private final UserClientService userClientService;
    public UserController(UserRestController userRestController,UserClientService userClientService){
        this.userRestController = userRestController;
        this.userClientService = userClientService;
    }

    @GetMapping("/them")
    public String home(Model model) {
        Flux<User> findUserAll = userRestController.findAll();

        // Add the Flux as an attribute to the model
        model.addAttribute("data", findUserAll);

        return "home"; // This will render the 'home.html' template
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("book", userClientService.getAllById("6505e4b8331fb4046f01589c"));
        return "test";
    }

}
