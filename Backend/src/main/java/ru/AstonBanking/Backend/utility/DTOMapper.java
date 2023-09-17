package ru.AstonBanking.Backend.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.AstonBanking.Backend.DTO.UserDTO;
import ru.AstonBanking.Backend.model.User;
import ru.AstonBanking.Backend.repository.AccountRepository;

@Component
public class DTOMapper {

    public static AccountRepository accountRepository;

    @Autowired
    public DTOMapper(AccountRepository accountRepository) {
        DTOMapper.accountRepository = accountRepository;
    }

    public static UserDTO getUserDTO(User user){

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setPin(user.getPIN());
        userDTO.setEmail(userDTO.getEmail());
        userDTO.setAccountNumber(user.getAccount().getAccountId());

        return userDTO;
    }

    //Делает из ДТО ---> USER
    public static User getUser(UserDTO userDTO){

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPIN(userDTO.getPin());
        user.setName(userDTO.getName());
        user.setAccount(accountRepository.findAccountByAccountId(userDTO.getAccountNumber()));

        return user;
    }
}
