package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.sql.SQLException;

public class Zadatak2DodavanjeVrednosti {



        public static void main(String[] args) {
            JdbcConnectionSource connectionSource = null;
            try {
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }