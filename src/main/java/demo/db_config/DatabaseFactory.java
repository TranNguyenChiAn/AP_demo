package demo.db_config;

public class DatabaseFactory {
    private DatabaseFactory() {}

    public static Database getInstance(DatabaseType type) {
        switch (type) {
            case SQL:
                return new SQLDatabase();
            case MySQL:
                return new MySQLDatabase();
            case PostgreSQL:
                return new PostgreSQLDatabase();
            default:
                return null;
        }
    }
}

