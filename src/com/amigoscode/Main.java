package com.amigoscode;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
/**     03 - OOP
 *      um send() auszuführen, muss extra eine Klasse mit der entsprechenden Methode und ein Objekt der Klasse erstellt werden.
 */
/*
        EmailSender emailSender = new Gmail();
        emailSender.send();
*/

/**     04 - @FunctionalInterface
 *      Das ist eine effizientere Variante um send() auszuführen, weil dafür nur der unten stehende Code gebraucht wird.
 *      IntellJ gibt sogar den Hinweis: Anonymous new EmailSender() can be replaced with lambda
 */
/*
        EmailSender amigosCodeSender = new EmailSender(){
            @Override
            public void send() {
                System.out.println("sending E-Mail using Amigoscode Server");
            }
        };
 */
/**     04 - @FunctionalInterface
 *      Das ist die Variante von amigosCodeSender, die noch effizienter ist, weil Sie Lambda nutzt und damit nochmal weniger Code braucht.
 *      Wenn nur eine function nach dem = kommt, dann können die {}-Klammern weggelassen werden.
 *      Das -> ist nur dann ein Lambda, wenn sich nur eine Methode im Interface befindet (hier EmailSender).
 *      Die Funktion würde nicht mehr funktionieren, wenn das Interface eine zweite Methode hätte.
 */

        EmailSender amigosCodeSender = () -> System.out.println("sending E-Mail using " + "Amigoscode Server");
        amigosCodeSender.send();

        EmailSender gmail = () -> System.out.println("Sending E-Mail using Gmail");
        gmail.send();

        EmailSender hotmail = () -> System.out.println("Sending E-Mail using Hotmail");
        hotmail.send();



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