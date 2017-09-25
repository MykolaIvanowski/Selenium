package com.epam.lab.model;

import java.util.ArrayList;
import java.util.List;

public class Credentials<Credential> {

    private List<Credential> credentials = new ArrayList<>();
    public List<Credential> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<Credential> credentials) {
        this.credentials = credentials;
    }
    public  void addLogin(String login){

    }

    public void addPassword(String password){


    }


}
