package myfirstapp.example.com.nafnogkennitala.models;

/*
Höfundur: Helga Sigríður Ívarsdóttir
Dagsetning: 12.10.2014

Þessi klasi tekur við upplýsingunum um notanda (nafn og kennitala), vistar þær í töflu og tengir
við þá töflu, þrjár aðrar sem búnar eru til fyrir notandann: ofnæmi, lyf og sjúkdóma en inniheldur
klasinn einnig gettera og settera fyrir alla hlutina sem hann inniheldur.
 */

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

    private RealmList<Meds> medsList;
    private RealmList<Faults> faultList;
    private RealmList<Allergy> allergyList;

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
}
