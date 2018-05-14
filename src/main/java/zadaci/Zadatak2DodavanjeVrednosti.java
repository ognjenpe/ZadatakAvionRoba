package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import model.Avion;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

public class Zadatak2DodavanjeVrednosti {

    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

        public static void main(String[] args) {
            JdbcConnectionSource connectionSource = null;

            try {
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
                avionDao = DaoManager.createDao(connectionSource, Avion.class);
                robaDao = DaoManager.createDao(connectionSource, Roba.class);
            } catch (SQLException e) {
                e.printStackTrace();

            }
            Avion a1 = new Avion("Avion1", 34);
            try {
                avionDao.create(a1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Avion a2 = new Avion("Avion2", 21);
            try {
                avionDao.create(a2);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Roba r1 = new Roba("Patike", "Duboke patike", 1, a1);
            Roba r2 = new Roba("Kosulje", "Na duge rukave", 0.4, a1);
            Roba r3 = new Roba("Voda", "Voda za pice", 1.4, a1);
            Roba r4 = new Roba("Ploce", "Drvene ploce", 3.4, a2);
            Roba r5 = new Roba("Stolica", "Plasticna stolica", 2.4, a2);
            try {
                robaDao.create(r1);
                robaDao.create(r2);
                robaDao.create(r3);
                robaDao.create(r4);
                robaDao.create(r5);

                List<Avion> avioni = avionDao.queryForAll();

                for(Avion a : avioni){
                    System.out.println(a);
                }

                List<Roba>  robe = robaDao.queryForAll();

                for(Roba r : robe){
                    System.out.println(r);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }



        }
    }