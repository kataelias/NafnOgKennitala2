package myfirstapp.example.com.nafnogkennitala.models;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Quima on 14/10/2014.
 */
public class User extends RealmObject {

    private String name;

    private int ssn;



    private RealmList<Meds> medsList;

    private RealmList<Faults> faultList;

    private RealmList<Allergy> allergyList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public RealmList<Meds> getMedsListedsList() {
        return medsList;
    }

    public void setMedsList(RealmList<Meds> medsList) {
        this.medsList = medsList;
    }

    public faultList<Faults> getFaultList() {
        return faultList;
    }

    public void setFaultList(RealmList<Faults> faultList){
        this.faultList = faultList;
    }

    public allergyList<Allergy> getAllergyList(){
        return allergyList;
    }

    public void setAllergyList(RealmList<Allergy> allergyList){
        this.allergyList = allergyList;
    }
}
