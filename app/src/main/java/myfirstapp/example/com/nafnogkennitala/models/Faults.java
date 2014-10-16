package myfirstapp.example.com.nafnogkennitala.models;

/*
Höfundur: Helga Sigríður Ívarsdóttir
Dagsetning: 12.10.2014

Þessi klasi tekur við upplýsingunum sem notandi gefur um þá sjúkdóma sem hrjá hann og vistar þær í töflu en
inniheldur einnig gettera og settera fyrir hvern entry í töfluna.
 */

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by Quima on 14/10/2014.
 */
public class Faults extends RealmObject{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
