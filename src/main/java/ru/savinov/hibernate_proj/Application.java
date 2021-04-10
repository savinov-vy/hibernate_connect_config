package ru.savinov.hibernate_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.savinov.hibernate_proj.dao.AccountDAO;
import ru.savinov.hibernate_proj.entity.Account;
import ru.savinov.hibernate_proj.entity.Bill;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot автоматически настраивает конфигурации, но т.к. в этом проекте HibernateConfiguration
 * настроен в ручную
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    AccountDAO accountDAO;

    @Override
    public void run(String... args) throws Exception {
        Account account = new Account("Lory", 20);
        List<Bill> bills = new ArrayList<>();
        bills.add(new Bill(10));
        bills.add(new Bill(11));
        bills.add(new Bill(12));
        bills.add(new Bill(13));
        bills.add(new Bill(14));
        account.setBills(bills);

        Account savedAccount = accountDAO.save(account);


        Long accountId = savedAccount.getAccountId();
        Account accountFromDB = accountDAO.findById(accountId);
        List<Bill> billsFromDB = accountFromDB.getBills();

        System.out.println(accountFromDB);
        System.out.println(billsFromDB);

    }
}
