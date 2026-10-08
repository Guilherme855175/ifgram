package br.edu.ifpb.ifgram.Controller;

import br.edu.ifpb.ifgram.dto.UserRequest;
import br.edu.ifpb.ifgram.dto.UserResponse;
import br.edu.ifpb.ifgram.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api?users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
}
     @PostMapping
    public UserResponse criar(@Valid @RequestBody UserRequest request) throws Exception {
        return service.criar(request);

     }


}
