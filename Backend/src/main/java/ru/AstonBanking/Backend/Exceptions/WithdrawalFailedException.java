package ru.AstonBanking.Backend.Exceptions;

import java.io.IOException;

public class WithdrawalFailedException extends IOException {
    public WithdrawalFailedException(String message, Exception e){
        super(message);
    }
}
