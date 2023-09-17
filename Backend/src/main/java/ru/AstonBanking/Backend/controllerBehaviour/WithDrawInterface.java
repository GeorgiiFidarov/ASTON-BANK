package ru.AstonBanking.Backend.controllerBehaviour;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.AstonBanking.Backend.model.Transaction;
import ru.AstonBanking.Backend.responce.TransactionResponse;

public interface WithDrawInterface {

    @PostMapping("/deposit")
    ResponseEntity<TransactionResponse> withDrawMoney(@RequestBody Transaction transaction);
}
