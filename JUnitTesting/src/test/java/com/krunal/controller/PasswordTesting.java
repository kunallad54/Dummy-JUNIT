package com.krunal.controller;

import com.krunal.service.UserRegistrationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class PasswordTesting {
    private String emailId;
    private boolean result;
    private UserRegistrationService userRegistrationService;

    public PasswordTesting(String emailId, boolean result) {
        this.emailId = emailId;
        this.result = result;
    }

    @Before
    public void initialize() {
        userRegistrationService = new UserRegistrationService();
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{{"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc-gmail.com", false},
                {"abc@.com.my", false},
                {"abc123@gmail.a", false},
                {"abc123@.com", false},
                {"abc123@.com.com", false},
                {".abc@abc.com", false},
                {"abc()*@gmail.com", false},
                {"abc@%*.com", false},
                {"abc..2002@gmail.com", false},
                {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false},
                {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", false}});
    }

    @Test
    public void testEmailValidation() {
        Assert.assertEquals(userRegistrationService.emailPattern, result, userRegistrationService.userDataValidation(emailId, userRegistrationService.emailPattern));
    }
}
/*
@RunWith(Parameterized.class)
public class PasswordTesting {
    UserRegistrationService userRegistrationService;

    String password;

    public PasswordTesting(String password) {
        super();
        this.password = password;
    }

    @Before
    void initialize() {
        userRegistrationService = new UserRegistrationService();
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[]{"Say12kun"} );
    }

    @Test
    public void givenPassword_WithMinimum8Characters_ShouldReturnTrue() {
        System.out.println(password);
        boolean result = userRegistrationService.checkPassword(password);
        Assertions.assertTrue(result);
    }


}*/
