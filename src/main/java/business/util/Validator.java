package business.util;

import pojo.Info;

public class Validator {

    public static Info isValidUsername(String username) {

        if (username == null) {
            return new Info(false,"The username is null");
        }

        int length = username.length();
        if(length >= 5 && length <= 12) return new Info(true,"Legal username");
        else return new Info(false,"The username length does not meet the requirements");
    }

    public static Info isValidPassword(String password) {
        if(password == null){
            return new Info(false,"The password is null");
        }
        else if(password.length()<6||password.length()>15){
            return new Info(false,"The password length does not meet the requirements");
        }
        else {
            boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
            int countTypes = 0;

            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    hasLower = true;
                } else if (Character.isUpperCase(c)) {
                    hasUpper = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else {
                    hasSpecial = true;
                }
            }

            if (hasLower) countTypes++;
            if (hasUpper) countTypes++;
            if (hasDigit) countTypes++;
            if (hasSpecial) countTypes++;
            if(countTypes>=2) return new Info(true,"Legal Password");
            else return new Info(false,"The character class in the password does not meet the requirements");
        }
    }

    public static Info isValidCanteenName(String canteenName) {

        if (canteenName == null) {
            return new Info(false,"The username is null");
        }

        int length = canteenName.length();
        if(length >= 3 && length <= 12) return new Info(true,"Legal canteen name");
        else return new Info(false,"The canteen name length does not meet the requirements");
    }
}
