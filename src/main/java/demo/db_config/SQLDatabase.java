package demo.db_config;

import java.sql.Connection;

public class SQLDatabase implements Database{
    private String host;
    private int port;
    private String username;
    private String password;


    @Override
    public Connection connect() {
        return null;
    }

    @Override
    public void disconnection() {

    }
}

