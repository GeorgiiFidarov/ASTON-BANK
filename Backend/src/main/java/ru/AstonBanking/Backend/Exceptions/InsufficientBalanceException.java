package ru.AstonBanking.Backend.Exceptions;

import java.io.IOException;

public class InsufficientBalanceException extends IOException {
    public InsufficientBalanceException(String message){
        super(message);
    }
}
