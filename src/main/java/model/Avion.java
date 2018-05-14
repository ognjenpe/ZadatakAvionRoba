package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

public class Avion {



    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_RASPONKRILA = "raspon_krila";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA, canBeNull = false, unique = false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_RASPONKRILA)
    private int rasponKrila;
    @ForeignCollectionField(foreignFieldName = "avion")
    private ForeignCollection<Roba> roba;

    public Avion(){

    }
    public Avion(String oznaka, int raspon_krila){
        this.oznaka = oznaka;
        this.rasponKrila = raspon_krila;
    }

    public String getOznaka() {
        return oznaka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;

    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", rasponKrila=" + rasponKrila +
                '}';
    }
}
