package demo.db_config;

import java.sql.Connection;

public class PostgreSQLDatabase implements Database{
    @Override
    public Connection connect() {
        return null;
    }

    @Override
    public void disconnection() {

    }
}

