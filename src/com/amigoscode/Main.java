package com.amigoscode;

import java.util.List;
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
 *      Wenn nur ein Statement bzw. nur eine Zeile Code nach dem = kommt, dann können die {}-Klammern weggelassen werden.
 *      Das -> ist nur dann ein Lambda, wenn sich nur eine Methode im Interface befindet (hier EmailSender).
 *      Die Funktion würde nicht mehr funktionieren, wenn das Interface eine zweite Methode hätte.
 */

/**     05 - Working with Lambdas
 *      Da die send()-Methode im Interface EmailSender um den String email ergänzt wurde, müssen die functions ebenfalls um einen String email ergänzt werden.
 *      Wenn nur ein Argument an die Funktion übergeben wird, dann muss es nicht in ()-Klammern gesetzt werden.
 *      Hier gibt es zwei Argumente (from, to) und daher ist die Klammer notwendig.
 */
        EmailSender amigosCodeSender = (from, to) -> {
            System.out.println("sending E-Mail using " + "Amigoscode Server");
            return false; // weil die send()-Methode im Interface von void in boolean geändert wurde, muss beim call ein Wert returned werden.
        };
        amigosCodeSender.send("hello@amigosCode.com","alex@gmail.com");

        EmailSender gmail = (from, to) -> {
            System.out.println("Sending E-Mail using Gmail");
            return false;
        };

        EmailSender hotmail = (from, to) -> {
            boolean isValid = to.contains("@"); // var isValid: boolean isValid = email.contains("@"); // der original Code aus 05 - Working with Lambdas, der bei mir aber mehrere Fehler verursacht hat.
            System.out.println("Sending E-Mail using Hotmail");
            return true;
        };

        boolean wasEmailSent = gmail.send("hello@amigosCode.com","alex@gmail.com");
        hotmail.send("hello@amigosCode.com", "jamila@gmail.com");

/**     06 - forEach
 *      forEach mit Consumer
 */
        //Ausgabe aller Namen im Array mit for-each-Schleife
 /*     String [] names = {"Jamila", "Alex", "Mariam"};
        for (String name : names){
            System.out.println(name);
        }
 */
        //Ausgabe aller Namen im Array in der basic Variante
 /*     String [] names = {"Jamila", "Alex", "Mariam"};
        for (int i = 0; i < names.lenght; i++ ){
            System.out.println(names[i]);
        }
*/
        // Ausgabe aller Namen in der Liste mit forEach und Consumer d.h. mit Lambda
        List<String> names = List.of("Jamila", "Alex", "Mariam");
        Consumer<String> stringConsumer =
                name -> System.out.println(name); // Consumer akzeptiert ein Argument, aber gibt keinen Wert aus (quais void)
        //names.forEach(name -> System.out.println(name)); //quasi eine andere Schreibweise für den Stringconsumer so wie im Beispiel unten
        names.forEach(stringConsumer);



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