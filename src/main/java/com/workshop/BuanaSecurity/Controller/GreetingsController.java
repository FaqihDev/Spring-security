package com.workshop.BuanaSecurity.Controller;


import com.workshop.BuanaSecurity.Statval.IApplicationConstant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IApplicationConstant.ApplicationContext.API.API_V2)
public class GreetingsController {

    @GetMapping(IApplicationConstant.ENDPOINT.HELLO_WORLD)
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from our API_V2");
    }

    @GetMapping(IApplicationConstant.ENDPOINT.GOOD_BYE)
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Good by and see you later");
    }

}
