package com.example.CricBuzz.exception;

import com.example.CricBuzz.model.Player;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
