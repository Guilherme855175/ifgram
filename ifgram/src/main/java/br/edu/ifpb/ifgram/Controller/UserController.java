package br.edu.ifpb.ifgram.Controller;

import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import br.edu.ifpb.ifgram.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api?users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
}


    @GetMapping
    public List<UserResponse> getUsers(){
        List<UserResponse> listaUsuarios = service.buscarTodosUsuarios();
        return listaUsuarios;
    }

    @PostMapping
    public UserResponse postUser(UserRequest request) throws Exception {
        UserResponse userResponse = service.criar(request);
        return userResponse;
    }

    @DeleteMapping
    public String deleteUser(){
        return "chamei o endpoint como um DELETE!";
    }






     }



