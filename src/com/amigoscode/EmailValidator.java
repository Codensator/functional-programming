/** 03.01 - Extending Functional Interfaces
 * In dieser Klasse ging es lediglich nachzuvollziehen, wie functions auf wiederverwendbare ARt implementiert werden können
 */


package com.amigoscode;

import java.util.function.Function;


public class EmailValidator
        implements Function<String, Boolean>
{
    @Override
    public Boolean apply(String email) {
        return email.contains("@");
    }
}

/*
public class EmailValidatorConsumer implements Consumer<String> {
    @Override
    public void accept(String email) {
        System.out.println(email);
    }
}
*/