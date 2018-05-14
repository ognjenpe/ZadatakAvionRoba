package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Zadatak1KreiranjeTabela {



        public static void main(String[] args) {
            JdbcConnectionSource connectionSource = null;
            Statement stmt = null;
            try {
                connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");

                TableUtils.dropTable(connectionSource, Roba.class,true);
                TableUtils.dropTable(connectionSource, Avion.class,true);

                TableUtils.createTable(connectionSource,Avion.class);
                TableUtils.createTable(connectionSource,Roba.class);



            } catch (SQLException e) {
                e.printStackTrace();
            }


         }

    }