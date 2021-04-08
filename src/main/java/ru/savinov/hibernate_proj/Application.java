package ru.savinov.hibernate_proj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.savinov.hibernate_proj.dao.AccountDAO;
import ru.savinov.hibernate_proj.entity.Account;

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
        Account savedAccount = accountDAO.save(account);

        Long accountId = savedAccount.getAccountId();

        System.out.println(accountDAO.findById(accountId));

    }
}
