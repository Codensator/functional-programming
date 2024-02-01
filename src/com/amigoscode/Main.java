package com.amigoscode;

import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
/**     01.03 - OOP
 *      um send() auszuführen, muss extra eine Klasse mit der entsprechenden Methode und ein Objekt der Klasse erstellt werden.
 */
/*
        EmailSender emailSender = new Gmail();
        emailSender.send();
*/

/**     01.04 - @FunctionalInterface
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
/**     01.04 - @FunctionalInterface
 *      Das ist die Variante von amigosCodeSender, die noch effizienter ist, weil Sie Lambda nutzt und damit nochmal weniger Code braucht.
 *      Wenn nur ein Statement bzw. nur eine Zeile Code nach dem = kommt, dann können die {}-Klammern weggelassen werden.
 *      Das -> ist nur dann ein Lambda, wenn sich nur eine Methode im Interface befindet (hier EmailSender).
 *      Die Funktion würde nicht mehr funktionieren, wenn das Interface eine zweite Methode hätte.
 */

/**     01.05 - Working with Lambdas
 *      Da die send()-Methode im Interface EmailSender um den String email ergänzt wurde, müssen die functions ebenfalls um einen String email ergänzt werden.
 *      Wenn nur ein Argument an die Funktion übergeben wird, dann muss es nicht in ()-Klammern gesetzt werden.
 *      Hier gibt es zwei Argumente (from, to) und daher ist die Klammer notwendig.
 */
/*
        EmailSender amigosCodeSender = (from, to) -> {
            System.out.println("sending E-Mail using " + "Amigoscode Server");
            return false; // weil die send()-Methode im Interface von void in boolean geändert wurde, muss beim call ein Wert returned werden.
        };
        amigosCodeSender.send("hello@amigosCode.com", "alex@gmail.com");

        EmailSender gmail = (from, to) -> {
            System.out.println("Sending E-Mail using Gmail");
            return false;
        };

        EmailSender hotmail = (from, to) -> {
            boolean isValid = to.contains("@"); // var isValid: boolean isValid = email.contains("@"); // der original Code aus 05 - Working with Lambdas, der bei mir aber mehrere Fehler verursacht hat.
            System.out.println("Sending E-Mail using Hotmail");
            return true;
        };

        boolean wasEmailSent = gmail.send("hello@amigosCode.com", "alex@gmail.com");
        hotmail.send("hello@amigosCode.com", "jamila@gmail.com");

*/
/**     01.06 - forEach
 *      forEach mit Consumer
 */

 /*     //Ausgabe aller Namen im Array mit for-each-Schleife
        String [] names = {"Jamila", "Alex", "Mariam"};
        for (String name : names){
            System.out.println(name);
        }
 */

 /*     //Ausgabe aller Namen im Array in der basic Variante
        String [] names = {"Jamila", "Alex", "Mariam"};
        for (int i = 0; i < names.length; i++ ){
            System.out.println(names[i]);
        }
*/

/**     01.07 - Method References
 *      Wenn nur die Methode aufgerufen wrid, dann kann Method Referenz mit "::" verwendet werden ohne, dass ein Argument explizit genannt werden muss
 *      Das geht nur, wenn ausschließlich die Methode aufgerufen wird. Wenn mit dem Argument noch was anderes passieren soll, dann funktioniert der implizite Aufruf nicht mehr.
 */
/*
        // Ausgabe aller Namen in der Liste mit forEach und Consumer d.h. mit Lambda
        List<String> names = List.of("Jamila", "Alex", "Mariam");
        // Consumer<String> stringConsumer = name -> System.out.println(name); // Consumer akzeptiert ein Argument, aber gibt keinen Wert aus (quasi void) // andere Schreibweise für Function unten
        Consumer<String> stringConsumer = System.out::println;
        //Das heißt Method-Reference: name muss nicht mehr explizit verwendet werden, weil die Argument automatisch übergeben wird
        // Consumer<String> stringConsumer = name -> System.out.println(name.toUpperCase()); // hier kann keine Method-Reference verwendet werden, weil nicht nur die Methode aufgerufen wird, sondern auch noch das Argument geparset wird
        //names.forEach(name -> System.out.println(name)); //quasi eine andere Schreibweise für den Stringconsumer so wie im Beispiel unten
        names.forEach(stringConsumer);
*/
/**     02.02 - Function
 *
 */
 /*
        System.out.println(incrementByOneMeth(1));
        System.out.println(incrementByOneFunc.apply(1));

        List<Integer> integers = List.of(1, 2, 3)
            .stream()
            .map(Main::incrementByOneMeth) // möglich, da nur das Argument übergeben wird und nicht explizit genannt werden muss, wie hier: (n -> incrementByOneMeth(n))
            // bis hier hin fast nur andere Schreibweise für List.of(1, 2, 3).forEach(Main::incrementByOneMeth);
            // bzw. andere Schreibweise für List.of(1, 2, 3).forEach(n -> incrementByOneMeth(n));
            .collect(Collectors.toList()); //

        System.out.println(integers);

        List.of(1, 2, 3)
            .stream()
            .map(n -> incrementByOneMeth(n))
            // bis hier hin fast nur andere Schreibweise für List.of(1, 2, 3).forEach(Main::incrementByOneMeth);
            // bzw. andere Schreibweise für List.of(1, 2, 3).forEach(n -> incrementByOneMeth(n));
            .collect(Collectors.toList()); //
 */
/**     02.03 - Chaining Functions
 *      Functions können aneinander gekettet werden, indem die Methode andThen() verwendet wird.
 */
/*
        Function<Integer, Integer> combinedFunction =
                incrementByOneFunc  //ruft erst incrementByOneFunc auf
                        .andThen(doubleFunc);   //mit "andThen" wird die nächste Function angekettet

        System.out.println(combinedFunction.apply(1));  //"apply" gibt an auf welchen Wert diese Kette von Functions angewendet werden soll
        System.out.println(combinedFunction.apply(3));
*/

/**     02.04 - BiConsumer
 *
 */
/*
        Person jamila = personMapperFunc.apply("Jamila", 18);

        System.out.println(jamila);
*/
/**     02.05 - Consumer
 *      In diesem Beispiel akzeptiert der Consumer den String und führt eine function aus, ohne eine object auszugeben.
 */
/*
        sendEmailConsumer.accept("jamila@amigoscode.com");
        //OOP-Variante von function darüber
        //sendEmail("hello@amigoscode.com");

        List<String> emails = List.of(
                "hello@amigoscode.com",
                "foo@amigoscode.com",
                "bar@amigoscode.com"
        );

        emails.forEach(email -> sendEmail(email));

        //emails.forEach(Main::sendEmail); //alternative Schreibweise zu oben, aber da Main verwendet wird, für mich erstmal nicht intuitiv
*/
/**     02.06 - Exercise
 *      In dieser Aufgabe soll der Code von 02.05 - Consumer so angepasst werden, dass eine Absender- und eine Empfänger-E-Mail als String akzeptiert wird
 */
 /*       sendEmailBiConsumer.accept("hello@amigoscode.com", "alexu@gmail.com");
*/

/**
 * 02.08 - Predicate and BiPredicates
 * Predicate ist quasi ein boolean nur als function
 * es können BiPredicates gebildet werden, indem predicate-functions mit .and ect. verknüpft werden
 */
/*

        String email = "hello@amigoscode.com";
        //OOP-Variante
        //System.out.println(isValidEmail(email));
        //function
        //System.out.println(isValidEmailPredicate.test(email));
        //kombinierte beide functions durch .and und bildet ein BiPredicate
        boolean test =
                isValidEmailPredicate
                        .and(containsDotPredicate) //mehrere predicates können mit .and, .or .negate etc. wie mit boolschen Operatoren verknüpft werden
                        .test(email);

        System.out.println(test);
*/

/** 02.09 - Supplier
 * Supplier akzeptiert kein Argument, aber gibt eines aus
 * Supplier hat anders als andere functions, nur eine einzige (abstrakte) Methode: .get()
 */

/*        System.out.println(getUrlSupplier.get()); //.get ist notwendig, getUrlSupplier Supplier
 */


/** 03.01 - Extending Functional Interfaces
 * functional interfaces können in Klassen definiert und in Main wiederverwendet werden.
 */

        EmailValidator EmailValidator = new EmailValidator();
        List<String> emails = List.of(
                "hello@gmail.com",
                "hellogmail.com"
        );

        //Um EmailValidator aufzurufen und auf die Liste anzuwenden, ist die untere function notwendig
        //mails ist eine List. Auf Lists kann man forEach() anwenden. forEach() ist ein Consumer

        emails.forEach(email -> {
            boolean isValid = EmailValidator.apply(email);
            System.out.println(email + " is valid: " + isValid);
        });

    } // # # # # # # # # # # # END OF public static void main(String[] args) # # # # # # # # # #

/**     02.02 - Function
 *
 */
/*
    static Function<Integer,Integer> incrementByOneFunc =
        n -> n + 1; // Aufbau ist ähnlich wie beim Methods aber in <>-Klammern wird sowohl der Eingabe- als auch der Ausgabe-Wert eingegeben
    // Die untere Methode ist noch die OOP-Version von der Function darüber
    static int incrementByOneMeth (int n){
       return n = n + 1;
    }
/*

 */
/**     02.04 - BiConsumer
 *
 */
/*
    record Person(String name, int Age){}
    static BiFunction<String, Integer, Person> personMapperFunc = Person::new;   //BiConsumer akzeptiert die ersten zwei Argumente und gibt den dritten aus
    //Oben ist effizientere Alternative zu unten
    //static BiFunction<String, Integer, Person> personMapperFunc = (name, age) ->  new Person(name, age);   //weil es zwei ein Argumente gibt, müssen diese in ()-Klammern gesetzt werden

    //Methode unten macht dasselbe wie personMapperFunc nur ohne Function
    static Person PersonMapperMeth(String name, int age){
        return new Person(name, age);
    }
*/
/**     02.03 - Chaining Functions
 *
 */
/*
    static Function<Integer,Integer> doubleFunc =
            n -> n * 2;
*/

/**     02.05 - Consumer
 *
 */
/*
    static Consumer<String> sendEmailConsumer =
            email -> System.out.println("Sending E-Mail to " + email);

    //OOP-Variante von function darüber
    static void sendEmail(String email){
        System.out.println("Sending E-Mail to " + email);
    }
*/
/**     02.06 - Exercise
 *      In dieser Aufgabe soll die untenstehende Methode in analogie zu 02.05 - Consumer in eine function umgeformt werden
 */
/*
    static void sendEmail(String from, String to) {
        System.out.println("Sending from " + from + " email to " + to);
    }

    static BiConsumer<String, String> sendEmailBiConsumer =
            (from, to) ->
                    System.out.println("Sending from " + from + " email to " + to);
*/

/**
 * 02.08 - Predicate and BiPredicates
 */
/*
    //überprüft, ob ein "@" im Eingabe-String ist
    static Predicate<String> isValidEmailPredicate =
        email -> email.contains("@");

    //überprüft, ob ein "." im Eingabe-String ist
    static Predicate<String> containsDotPredicate =
            email -> email.contains(".");

    //OOP-Variante der function isValidEmailPredicate
    static boolean isValidEmail(String email){
        return email.contains("@");
    }
*/

/** 02.09 - Supplier
 *
 */
/*
    static Supplier<String> getUrlSupplier =
        () -> "https://app.amigoscode.com/";

    static Supplier<List<String>> getUrlListSupplier =
            () -> List.of("https://app.amigoscode.com/",
                          "https://www.google.com/");
    // Es ist auch möglich innerhalb des Suppliers basic logic anzuwenden, z.B. um die URL abzurufen oder zu erzeugen.
    // dass könnte z.B. so aussehen: () -> { logic... return List.of(...)}

    //OOP-Variante der function
    static String getURL(){
        return "https://app.amigoscode.com/";
    }
*/
} //# # # # # # # # # # # END OF public class Main # # # # # # # # # # #