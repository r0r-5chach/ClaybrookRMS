package com.mawkish.claybrookrms.login;

import com.mawkish.claybrookrms.tools.DBHandler;
import org.bson.Document;

public class LoginHandler {
    private DBHandler database;

    public LoginHandler() {
        init();
    }

    private void init() {
        database = new DBHandler();
    }

    public Boolean checkLogin(String username, String password) {
        var users = database.getUser(username);
        if (users == null) {
            return false;
        }
        for (Document user: users) {
            if (user.getString("_password").equals(password)) {
                return true;
            }
        }
        return false;
    }

}
