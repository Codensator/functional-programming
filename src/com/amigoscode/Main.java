package com.amigoscode;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
// um send() auszuführen, muss extra eine Klasse mit der entsprechenden Methode und ein Objekt der Klasse erstellt werden.
/*
        EmailSender emailSender = new Gmail();
        emailSender.send();
 */

// Das ist eine effizientere Variante um send() auszuführen, weil dafür nur der unten stehende Code gebraucht wird.
// IntellJ gibt sogar den Hinweis: Anonymous new EmailSender() can be replaced with lambda
/*        
        EmailSender amigosCodeSender = new EmailSender(){
            @Override
            public void send() {
                System.out.println("sending E-Mail using Amigoscode Server");
            }
        }; 
 */
// Das ist die Variante von amigoScodeSender, die noch effizienter ist, weil Sie Lambda nutzt und damit nochmal weniger Code braucht.
// Wenn nur eine function nach dem = kommt, dann können die {}-Klammern weggelassen werden.
        EmailSender amigoCodeSender =
                () -> System.out.println("sending E-Mail using Amigoscode Server");

        amigoCodeSender.send();



        hello("Alex", "Jones", input -> {
            System.out.println(input + " you must have last name");
        });
    }

    /*
     const cb = (firstName) => {
        console.log(firstName + " you must have last name")
    }*/

    static Consumer<String> cb = input ->
            System.out.println(input + " you must have last name");

    static void hello(String firstName,
                      String lastName,
                      Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    /*
    const hello = (firstName, lastName, callback) => {
        console.log(firstName);
        if (lastName) {
            console.log(lastName);
        } else {
            callback(firstName);
        }
    }

    const cb = (firstName) => {
        console.log(firstName + " you must have last name")
    }*/
}