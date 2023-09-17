package ru.AstonBanking.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.AstonBanking.Backend.DTO.UserDTO;
import ru.AstonBanking.Backend.controllerBehaviour.CreateUserInterface;
import ru.AstonBanking.Backend.model.User;
import ru.AstonBanking.Backend.model.UserLogIn;
import ru.AstonBanking.Backend.responce.UserLogInResponse;
import ru.AstonBanking.Backend.responce.UserResponse;
import ru.AstonBanking.Backend.service.UserService;

@RestController
@RequestMapping("/api/user")
public class CreateUserInterfaceController implements CreateUserInterface {

    private final UserService userService;

    @Autowired
    public CreateUserInterfaceController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<UserLogInResponse> login(@RequestBody UserLogIn userLogIn){
        try {
            if (userService.getUserByEmail(userLogIn.getEmail()) != null) {

                User user = userService.getUserByEmail(userLogIn.getEmail());
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new UserLogInResponse(
                                user.getName(),
                                user.getAccount().getBalance(),
                                "Авторизация прошла успешно"
                        ));
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new UserLogInResponse(
                               "Нет такого аккаунта попбробуйте зарегистрироваться" ));
            }


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            new UserLogInResponse(
                                    "Произошла ошибка при создании аккаунта"));
        }
    }




    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserDTO userDTO){
        try {
            if (userService.getUserByEmail(userDTO.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(new UserResponse(false, "Такой пользователь существует"));
            }
            userDTO.setAccountNumber(UserDTO.generate(userDTO));
            User user = userService.createUserAccount(userDTO);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new UserResponse(
                            true,
                            user.getName(),
                            user.getEmail(),
                            user.getAccount().getAccountId(),
                            "Аккаунт успешно создан",
                            user.getAccount().getBalance()
                    ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            new UserResponse(
                                    false,
                                    "Произошла ошибка при создании аккаунта"));
        }
    }



}
