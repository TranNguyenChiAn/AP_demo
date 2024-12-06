package demo.db_config;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
    public Connection connect() throws SQLException;
    public void disconnection() throws SQLException;
}
