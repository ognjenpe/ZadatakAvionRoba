package model;

import java.util.List;

public class AvionNit implements Runnable{

    public Avion avion;
    public String id_avion;

    static synchronized boolean  dozvoljenoSletanje(){
        return true;
    }


    public AvionNit(String id_avion){
        this.id_avion = id_avion;
    }

    private void proveraOpreme(){
        System.out.println("Pocinju provere za avion <"+id_avion+">");

        int period = (int)(Math.random() * 2000);
        try {
            Thread.sleep(period);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avion <" +id_avion+ "> je spreman za poletanje i čeka dozvolu za poletanje");

    }



    private void poletanje(){
        System.out.println("Avion <"+id_avion+ "> izlazi na pistu i poleće");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Avion <"+id_avion+ "> je poleteo");
    }

    @Override
    public void run() {
        proveraOpreme();
        dozvoljenoSletanje();
        poletanje();

    }

    public static void main(String[] args) {

        AvionNit avion1 = new AvionNit("avion1");
        AvionNit avion2 = new AvionNit("avion2");
        Thread t1 = new Thread(avion1);
        Thread t2 = new Thread(avion2);
        t1.start();
        t2.start();


    }
}
