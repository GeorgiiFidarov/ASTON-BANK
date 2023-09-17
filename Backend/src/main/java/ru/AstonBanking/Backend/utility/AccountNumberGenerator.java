package ru.AstonBanking.Backend.utility;

import ru.AstonBanking.Backend.DTO.UserDTO;

public class AccountNumberGenerator {

    public static Long generate(UserDTO userDTO){
        return (long) userDTO.hashCode();
    }
}
