package myfirstapp.example.com.nafnogkennitala.models;

import io.realm.RealmObject;

/**
 * Created by Quima on 14/10/2014.
 */
public class Meds extends RealmObject{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
