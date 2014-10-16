package myfirstapp.example.com.nafnogkennitala.models;

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
