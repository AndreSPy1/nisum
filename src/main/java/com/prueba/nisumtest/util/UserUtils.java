package com.prueba.nisumtest.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserUtils {

    @Value("${regex.pass}")
    private String regexPass;
    public boolean validEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher = pattern.matcher(email);

        if(matcher.find() != true){
            return false;
        }
        return true;
    }

    public boolean validPass(String pass){
        Pattern pattern = Pattern
                .compile(regexPass);

        Matcher matcher = pattern.matcher(pass);

        if(matcher.find() != true){
            return false;
        }
        return true;
    }
}
