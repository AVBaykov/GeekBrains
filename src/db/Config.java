package db;

public class Config {

    private static final Config INSTANCE = new Config();
    private final DataBase dataBase;

    private Config() {
        try {
            dataBase = new DataBase("jdbc:sqlite:main.db");
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    public static Config getInstance() {
        return INSTANCE;
    }

    public DataBase getDataBase() {
        return dataBase;
    }
}
