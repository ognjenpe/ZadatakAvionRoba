package model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import zadaci.Zadatak2DodavanjeVrednosti;

import java.sql.SQLException;
import java.util.List;

public class AvionNit extends Thread implements Runnable {

    public Avion avion;
    public String id_avion;
    static Dao<Avion, Integer> avionDao;

    static synchronized boolean dozvoljenoSletanje() {
        return true;
    }

    public AvionNit(Avion avion){
        this.avion = avion;

    }


    private void proveraOpreme() {
        System.out.println("Pocinju provere za avion <" + avion.getId() + ">");

        int period = (int) (Math.random() * 2000);
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avion <" + avion.getId() + "> je spreman za poletanje i čeka dozvolu za poletanje");

    }


    private void poletanje() {
        System.out.println("Avion <" + avion.getId() + "> izlazi na pistu i poleće");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avion <" + avion.getId() + "> je poleteo");
    }

    @Override
    public void run() {
        proveraOpreme();
        dozvoljenoSletanje();
        poletanje();

    }

    public static void main(String[] args) {

        JdbcConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            avionDao = DaoManager.createDao(connectionSource, Avion.class);
            List<Avion> avioni = avionDao.queryForAll();
            for (Avion av : avioni) {
                AvionNit avio = new AvionNit(av);
                avio.start();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            }



    }


}
