package com.mymvpproject;

import com.mymvpproject.util.Validation;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginUnitTest {

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue()throws Exception{
        Assert.assertEquals("", Validation.isEmailValid("sdf@dfg.com"));
    }



    @Test
    public void passwordValidator_CorrectEmailSimple_ReturnsTrue()throws Exception{
        Assert.assertEquals("", Validation.isPasswordValid("qwerty"));
    }

    @Test
    public void otpValidator_CorrectEmailSimple_ReturnsTrue()throws Exception{
        Assert.assertEquals("", Validation.isOtpValid("32"));
    }
}