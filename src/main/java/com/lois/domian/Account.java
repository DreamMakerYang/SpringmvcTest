package com.lois.domian;

import java.io.Serializable;

public class Account implements Serializable {
    private String accountName;
    private Double money;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", money=" + money +
                '}';
    }
}
