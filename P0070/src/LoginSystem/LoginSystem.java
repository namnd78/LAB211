package LoginSystem;

import Account.Account;
import java.util.Scanner;
import Account.AccountList;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 10 pro 64bit
 */
class LoginSystem {

    Scanner sc = new Scanner(System.in);

    void displayMenu() {
        System.out.println("\n-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit\n");
    }

    void login(Ebank ebank) {
        AccountList users = new AccountList();
        ArrayList<Account> accountList = users.data();
        String accountNumber;
        do {
            System.out.print(ebank.getBundle().getString("enterAccount"));
            accountNumber = sc.nextLine();
            // check account number
            if (ebank.checkAccountNumber(accountNumber).equals("")) {
                break;
            } else {
                System.out.println(ebank.checkAccountNumber(accountNumber));
            }
        } while (true);

        String password;
        do {
            System.out.print(ebank.getBundle().getString("enterPassword"));
            password = sc.nextLine();
            // check password
            if (ebank.checkPassword(password).equals("")) {
                break;
            } else {
                System.out.println(ebank.checkPassword(password));
            }
        } while (true);

        String captcha = ebank.generateCaptcha();
        System.out.println("Captcha: " + captcha);
        do {
            System.out.print(ebank.getBundle().getString("enterCaptcha"));
            String captchaInput = sc.nextLine();
            // check captcha input
            if (ebank.checkCaptcha(captchaInput, captcha).equals("")) {
                break;
            } else {
                System.out.println(ebank.checkCaptcha(captchaInput, captcha));
            }
        } while (true);

        // Check account number and password exist in list
        if (checkAccountExist(accountNumber, password, accountList)) {
            System.out.println(ebank.getBundle().getString("loginSuccess"));
        } else {
            System.out.println(ebank.getBundle().getString("loginFail"));
        }
    }

    private boolean checkAccountExist(String accountNumber, String password, ArrayList<Account> accountList) {
        // Loop to access from the first to the last element in list
        for (Account account : accountList) {
            // Compare entered accountNumber & password with accounts int the list
            if (account.getAccountNumber().equals(accountNumber)
                    && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
