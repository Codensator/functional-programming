package com.amigoscode;

public class Hotmail implements EmailSender
{
    @Override
    public void send() {
        System.out.println("sending E-Mail using Hotmail...");

    }
}
