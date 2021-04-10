package ru.savinov.hibernate_proj.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String name;

    private Integer age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Bill> bills;

    public Account(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
