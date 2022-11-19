/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginSystem;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;

/**
 *
 * @author 10 pro 64bit
 */
class Ebank {

    private ResourceBundle bundle;

    public Ebank() {
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    void setLocate(Locale locale) {
        bundle = ResourceBundle.getBundle("LoginSystem/language", locale);
    }

    String checkAccountNumber(String accountNumber) {
        String message = "";
        // ^: match the beginning of the string
        // \d: match one digit from 0 to 9
        // {10}: match the previous part occur 10 times
        // $: match the end of the string
        if (!accountNumber.matches("^\\d{10}$")) {
            message = bundle.getString("accountError");
        }
        return message;
    }

    String checkPassword(String password) {
        String message = "";
        // Check length of entered password:
        // ^: match the beginning of the string
        // [a-zA-Z0-9]: match 1 letter (lower or upper case) or digit (0-9)
        // {8,31}: match previous part occur 8 to 31 times
        // $: match the end of the string
        if (!password.matches("^[a-zA-Z0-9]{8,31}$")) {
            message = bundle.getString("passwordError");
        }
        // Check password must have both letter and number:
        // ^: match the beginning of the string
        // [a-zA-Z0-9]*: match letter (lower or upper case) or digit (0-9), zero or more times
        // [0-9]+: match one or more digit (0-9)
        // [a-zA-Z]+: match one or more letter (lower or upper case)
        // |: or
        // $: match the end of the string
        if (!password.matches("^[a-zA-Z0-9]*(([0-9]+[a-zA-Z]+)|([a-zA-Z]+[0-9]+))[a-zA-Z0-9]*$")) {
            message = bundle.getString("passwordError");
        }
        return message;
    }

    String generateCaptcha() {
        Random random = new Random();
        String captcha;
        String characters = "";
        for (int i = 0; i < 10; i++) {
            characters += i;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            characters += i;
        }
        for (char i = 'A'; i < 'Z'; i++) {
            characters += i;
        }
        do {
            captcha = "";
            boolean hasDigit = false;
            boolean hasLowerLetter = false;
            boolean hasUpperLetter = false;
            // Loop to creat string with 5 random character
            for (int i = 0; i < 5; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                // check character is digit
                if (randomChar >= '0' && randomChar <= '9') {
                    hasDigit = true;
                } // check character is lower letter
                else if (randomChar >= 'a' && randomChar <= 'z') {
                    hasLowerLetter = true;
                } // check character is upper letter
                else if (randomChar >= 'A' && randomChar <= 'Z') {
                    hasUpperLetter = true;
                }
                captcha += randomChar;
            }
            if (hasDigit && hasLowerLetter && hasUpperLetter) {
                return captcha;
            }
        } while (true);
    }

    String checkCaptcha(String captchaInput, String captcha) {
        String message = "";
        // check characters input exist in captcha code
        if (!captcha.contains(captchaInput)) {
            message = bundle.getString("captchaError");
        }
        return message;
    }
}
