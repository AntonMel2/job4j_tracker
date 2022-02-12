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
        if (findByPassport(passport) != null) {
            boolean ans = users.get(findByPassport(passport)).contains(account);
            if (!ans) {
                users.get(findByPassport(passport)).add(account);
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
        if (findByPassport(passport) != null) {
            for (Account key : users.get(findByPassport(passport))) {
                if (key.getRequisite().equals(requisite)) {
                    rsl = key;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String scrPassport, String scrRequisite, String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        if (findByRequisite(scrPassport, scrRequisite).getBalance() >= amount) {
            double destAmount = findByRequisite(destPassport, destRequisite).getBalance();
            double scrAmount = findByRequisite(scrPassport, scrRequisite).getBalance();
            findByRequisite(destPassport, destRequisite).setBalance(destAmount + amount);
            findByRequisite(scrPassport, scrRequisite).setBalance(scrAmount - amount);
            rsl = true;
        }
        return rsl;
    }
}

