package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User rsl = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                rsl = key;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account key : users.get(user)) {
                if (key.getRequisite().equals(requisite)) {
                    rsl = key;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String scrPassport, String scrRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account scrAcc = findByRequisite(scrPassport, scrRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (scrAcc != null && destAcc != null && scrAcc.getBalance() >= amount) {
            scrAcc.setBalance(scrAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}

