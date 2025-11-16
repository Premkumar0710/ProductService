package com.example.ProductService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello buddy !";
    }

    @GetMapping("/hi/{name}")
    public String sayHi(@PathVariable("name") String name){
        return "Hi " + name + " !";
    }

    @GetMapping("/vanakkam/{name}/{times}")
    public String sayVanakkam(@PathVariable("name")String name ,@PathVariable("times") int times){
        String s = "";
        for(int i=1;i<=times;i++){
            s+="Vanakkam " + name + " ! <br>";
        }
        return s;
    }


}
