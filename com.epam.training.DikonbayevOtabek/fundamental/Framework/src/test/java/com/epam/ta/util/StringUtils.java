package com.epam.ta.util;

import java.util.Random;

public class StringUtils
{
    private static final String ALFANUMERICAL_ALL_CAPS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public static String getRandomString(int stringLength)
    {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++)
        {
            stringBuilder.append(ALFANUMERICAL_ALL_CAPS.charAt(random.nextInt(ALFANUMERICAL_ALL_CAPS.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomUsernameWithPostfixLength(int postfixLength){
        return "testUsername_".concat(getRandomString(postfixLength));
    }
    public static String generateRandomPasswordWithPostfixLength(int postfixLength){
        return "testPassword_".concat(getRandomString(postfixLength));
    }
    public static String generateRandomMessageValueWithPostfixLength(int postfixLength){
        return "testMessage_".concat(getRandomString(postfixLength));
    }

}
