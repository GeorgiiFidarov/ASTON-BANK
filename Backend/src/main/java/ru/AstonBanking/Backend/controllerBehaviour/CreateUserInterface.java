package ru.AstonBanking.Backend.controllerBehaviour;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.AstonBanking.Backend.DTO.UserDTO;
import ru.AstonBanking.Backend.responce.UserResponse;

public interface CreateUserInterface {

    @PostMapping("/create")
    ResponseEntity<UserResponse> createUser(@RequestBody UserDTO userDTO);
}
