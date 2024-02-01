/** 03.02 - Combinator Pattern
 * Diese Klasse funktioniert im Wesentlichen wie die Klasse EmailValidator aus 03.01
 * ALlerdings hat diese Klasse nicht nur eine abrufbare function, sondern mehrere miteinander verknüpfte functions
 */

package com.amigoscode;

import static com.amigoscode.PersonRegistrationValidator.ValidationResult.*;
import java.util.function.Function;

public interface PersonRegistrationValidator
        extends Function<Person, PersonRegistrationValidator.ValidationResult>{

    //Diese statische Methode returnt unterschiedliche enums, je nachdem was die Überprüfung der email ergeben hat
    static PersonRegistrationValidator isEmailValid(){
        return person -> person.email().contains("@") ?
                SUCCES : EMAIL_NOT_VALID_ERROR;
    }

    //In dieser Methode wird die Verknüpfung verschiedener functionen durchgeführt
    default PersonRegistrationValidator other(
            PersonRegistrationValidator validator){
        return person -> {                                          //das Argument ist person
            ValidationResult result = this.apply(person);           //result ist ein neues ValidationResult das person als Wert übergeben bekommt
            return result.equals(SUCCES) ?                          //for diesem return wird überprüft, ob result mit SUCCES übereinstimmt
                   validator.apply(person) :                        //wenn result und SUCCES übereinstimmen, dann wird validator auf person angewendet
                   result;                                          //ansonsten wird result als Wert zum return übergeben
        };
        
    }

    static PersonRegistrationValidator isEmailTaken(){
        return person -> SUCCES;                                  
    }

    //Diese statische Methode returnt unterschiedliche enums, je nachdem was die Überprüfung der phoneNumber ergeben hat
    static PersonRegistrationValidator isPhoneNumberValid(){
        return person -> person.email().contains("+") ?
                SUCCES : PHONE_NOT_VALID_ERROR;
    }







    enum ValidationResult{
        SUCCES,
        EMAIL_NOT_VALID_ERROR,
        EMAIL_TAKEN_ERROR,
        PHONE_NOT_VALID_ERROR,
        NOT_ADULT_ERROR

    }



}
