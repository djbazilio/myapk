package com.example.akhonin.bazilio;

public class Auth extends HttpService{
    public boolean atuthirizated;

    public void Login(String login,String password) {

        this.sendGetRequest();

        System.out.println("login===============" + login);
        System.out.println("password===============" + password);
    }

}