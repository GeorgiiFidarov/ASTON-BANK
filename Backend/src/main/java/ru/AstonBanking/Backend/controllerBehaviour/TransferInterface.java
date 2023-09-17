package ru.AstonBanking.Backend.controllerBehaviour;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.AstonBanking.Backend.model.Transfer;
import ru.AstonBanking.Backend.responce.TransferResponse;

public interface TransferInterface {

    @PostMapping("/transfer")
    ResponseEntity<TransferResponse> transferMoney(@RequestBody Transfer transfer);
}
