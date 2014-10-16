package myfirstapp.example.com.nafnogkennitala.models;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by Quima on 14/10/2014.
 */
@RealmClass
public class User extends RealmObject {

    private String name;

    private String ssn;


/*
    private RealmList<Meds> medsList;

    private RealmList<Faults> faultList;

    private RealmList<Allergy> allergyList;
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
/*
    public RealmList<Meds> getMedsList() {
        return medsList;
    }

    public void setMedsList(RealmList<Meds> medsList) {
        this.medsList = medsList;
    }

    public RealmList<Faults> getFaultList() {
        return faultList;
    }

    public void setFaultList(RealmList<Faults> faultList){
        this.faultList = faultList;
    }

    public RealmList<Allergy> getAllergyList(){
        return allergyList;
    }

    public void setAllergyList(RealmList<Allergy> allergyList){
        this.allergyList = allergyList;
    }
*/
}
