package com.nedacort.challengespringbackend.email;

public interface EmailSender {
    void send(String to, String email);
}
