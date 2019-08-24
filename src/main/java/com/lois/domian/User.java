package com.lois.domian;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;

    private List<Account> list;
    private Map<String,Account> map;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    public Map<String, Account> getMap() {
        return map;
    }

    public void setMap(Map<String, Account> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
