package ru.AstonBanking.Backend.responce;

public class TransferResponse {
    private String message;

    public TransferResponse(String message) {
        this.message = message;
    }

    public TransferResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
