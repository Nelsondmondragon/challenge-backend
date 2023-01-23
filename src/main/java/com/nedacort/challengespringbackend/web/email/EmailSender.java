package com.nedacort.challengespringbackend.web.email;

public interface EmailSender {
    void send(String to, String email);
}
