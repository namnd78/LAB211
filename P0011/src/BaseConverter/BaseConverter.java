package BaseConverter;


import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
class BaseConverter {

    String convertBase(String inputValue, int inputBase, int outputBase) {
        String result = "";
        // Compare input base with 10
        if (inputBase == 10) {
            result = convertFromDecimal(inputValue, outputBase);
        } // Compare output base with 10
        else if (outputBase == 10) {
            result = convertToDecimal(inputValue, inputBase);
        } else {
            result = convertToDecimal(inputValue, inputBase);
            result = convertFromDecimal(result, outputBase);
        }
        return result;
    }

    private String convertFromDecimal(String inputValue, int outputBase) {
        String digits = "0123456789ABCDEF";
        BigInteger decNumber = new BigInteger(inputValue);
        BigInteger divisor = new BigInteger(Integer.toString(outputBase));
        BigInteger remainder;
        String result = "";
        // Compare input value with 0
        if (inputValue.equals("0")) {
            result = "0";
        } else {
            // Loop until decimal number equals 0 after dividing by output base
            while (!decNumber.equals(new BigInteger("0"))) {
                remainder = decNumber.mod(divisor);
                result = digits.charAt(remainder.intValue()) + result;
                decNumber = decNumber.divide(divisor);
            }
        }
        return result;
    }

    private String convertToDecimal(String inputValue, int inputBase) {
        String digits = "0123456789ABCDEF";
        BigInteger base = new BigInteger(Integer.toString(inputBase));
        BigInteger result = new BigInteger("0");
        BigInteger coefficient;
        BigInteger value;
        // Loop to access from the first to the last character of input value string
        for (int i = 0; i < inputValue.length(); i++) {
            coefficient = new BigInteger(Integer.toString(digits.indexOf(inputValue.charAt(i))));
            value = new BigInteger(coefficient.multiply(base.pow(inputValue.length() - i - 1)).toString());
            result = result.add(value);
        }
        return result.toString();
    }

}
