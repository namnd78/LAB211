/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.util.ArrayList;

/**
 *
 * @author 10 pro 64bit
 */
public class AccountList {

    public ArrayList<Account> data() {
        ArrayList<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account("0123456789", "abcd1234"));
        accountList.add(new Account("9876543210", "1234abcd"));
        accountList.add(new Account("1122334455", "1a2b3c4d5e"));
        return accountList;
    }

}
