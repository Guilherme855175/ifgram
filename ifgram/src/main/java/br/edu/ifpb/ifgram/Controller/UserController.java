package br.edu.ifpb.ifgram.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping
    public String getUser() {
        return "get user was called";
    }
    @PostMapping
    public String postUser(){
       return "chamei o endpoint com um POST" ;
   }
  @DeleteMapping
    public String deleteruser(){
        return "chamei o endpoint com o DELETE";
  }

}
