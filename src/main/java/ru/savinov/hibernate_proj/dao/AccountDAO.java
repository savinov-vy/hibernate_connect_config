package ru.savinov.hibernate_proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.savinov.hibernate_proj.entity.Account;

@Component
public class AccountDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AccountDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Account save(Account account) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.flush();
        session.getTransaction().commit();
        session.close();
        return account;
    }

    /**
     * Передаем класс Объект которого хотим найти и id
     * @param id
     * @return Account
     */
    public Account findById(Long id) {
        Session session = sessionFactory.openSession();
        Account account = session.find(Account.class, id);
        System.out.println(account);
        System.out.println("\n\n");
        System.out.println(account.getBills());
        session.close();
        return account;
    }
}
