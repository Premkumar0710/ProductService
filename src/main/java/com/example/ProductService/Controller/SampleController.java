package com.example.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello/{name}/{timesTobeCalled}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("timesTobeCalled") int timesTobeCalled){
        String response = "";
        for(int i=1;i<=timesTobeCalled;i++){
            response+="Hello " + name + "\n";
        }
        return response;
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye";
    }
}
