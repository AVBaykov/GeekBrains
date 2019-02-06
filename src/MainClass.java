import db.Config;
import db.DataBase;

import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        DataBase db = Config.getInstance().getDataBase();
        try {
            db.initDB();
            db.populateDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
