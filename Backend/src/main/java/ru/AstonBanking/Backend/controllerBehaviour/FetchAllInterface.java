package ru.AstonBanking.Backend.controllerBehaviour;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ru.AstonBanking.Backend.responce.AccountDataResponse;

import java.util.List;

public interface FetchAllInterface {

    @GetMapping
    ResponseEntity<List<AccountDataResponse>> fetchAll();
}
