package com.example.luv2code.ultime.Email;


import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;


@Component
public class Emailvalidator implements Predicate<String> {

  public static final Predicate<String> IS_EMAIL_VALID=
            compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).asPredicate();

    @Override
    public boolean test(String email) {
        return IS_EMAIL_VALID.test(email);
    }
}
