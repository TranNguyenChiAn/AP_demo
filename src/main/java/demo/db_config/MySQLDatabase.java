package demo.db_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements Database {
    private String host;
    private int port;
    private String username;
    private String password;
    private String dbName;
    private Connection connection;

    public MySQLDatabase() {
        this.host = "localhost";
        this.port = 3306;
        this.username = "root";
        this.password = "";
        this.dbName = "table_employees";
    }

    public MySQLDatabase(String host, int port, String username, String password, String dbName) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    @Override
    public Connection connect() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s",this.host,this.port,this.dbName);
        this.connection = DriverManager.getConnection(url,this.username,this.password);
        return connection;
    }

    @Override
    public void disconnection() throws SQLException {
        if (!connection.isClosed())   {
            connection.close();
        }
    }
}
