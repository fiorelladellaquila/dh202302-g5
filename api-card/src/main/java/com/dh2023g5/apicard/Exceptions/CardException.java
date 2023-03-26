package com.dh2023g5.apicard.Exceptions;

public class CardException extends Exception {
    public CardException(MessageError message) {
        super(message.message);
    }
}
