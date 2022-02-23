package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает модель баноквской системы. Система позволяет.
 * 1. Регистрировать пользователя.
 * 2. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 3. Переводить деньги с одного банковского счета на другой счет.
 * @autor Anton Meleshnikov
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение информации о пользователях и их счетах осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход информацию о пользователе
     * и добавляет пользователя в систему (регистрирует пользователя)
     * @param user пользователь которого регистрируют
     */

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Первоначально пользователя находят по паспорату. Для этого используется метод findByPassport.
     * После этого в список всех счетов пользователя добавляется новый счет.
     * @param passport номер паспарта по которому определяется список счетов пользователя
     * @param account новый добавляемый счет
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод  принимает на вход номер паспорта  {@param passport} и ищет пользователя по номеру.
     * @return возвращает пользователя или null, если такого пользователя нет
     */

    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам. На вход метод принимает номер паспорта и реквизиты.
     * Сначала осуществляется поиск пользователя по паспорту с помощью метода findByPassport.
     * Потом получаем список счетов этого пользователя и в нем находим нужный счет.
     * @param passport номер паспорта
     * @param requisite реквизиты по которым осуществляется поис
     * @return возвращается счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят), то метод должен вернуть false.
     * @param scrPassport номер паспорта
     * @param scrRequisite реквизиты счета с которго переводятся деньги
     * @param destPassport номер паспорта
     * @param destRequisite реквизиты счета на который переводятся деньги
     * @param amount сумма перевода
     * @return возвращает true если перевод выполнен
     */
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

