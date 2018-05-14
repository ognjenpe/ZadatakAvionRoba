package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

import static zadaci.Zadatak2DodavanjeVrednosti.robaDao;

public class Zadatak3IzmenaVrednosti {



        public static void main(String[] args) {
            JdbcConnectionSource connectionSource = null;
            try {
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            List<Roba> robe= null;
            try {
                robe = robaDao.queryForAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for(Roba r:robe) {
                System.out.println(r);
            }
        }
    }