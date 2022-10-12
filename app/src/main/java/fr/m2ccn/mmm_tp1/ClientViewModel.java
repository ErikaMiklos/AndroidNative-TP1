package fr.m2ccn.mmm_tp1;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class ClientViewModel extends BaseObservable {
    private Client model;


    public ClientViewModel(Client model) {
        this.model = model;
    }

    public Client getModel() {
        return model;
    }

    @Bindable
    public String getName(){
        return model.nom;
    }

    @Bindable
    public void setName(String nom){
        this.model.nom = nom;
        // BR. name is automatically generated
        notifyPropertyChanged (BR.name);
    }

    @Bindable
    public String getPrenom(){
        return model.prenom;
    }

    @Bindable
    public void setPrenom(String prenom){
        this.model.prenom = prenom;
        notifyPropertyChanged (BR.prenom);
    }

    @Bindable
    public String getVille(){
        return model.villeDeNaissence;
    }

    @Bindable
    public void setVille(String villeDeNaissence){
        this.model.villeDeNaissence = villeDeNaissence;
        notifyPropertyChanged (BR.ville);
    }

    @Bindable
    public String getNumTel(){
        return model.numTel;
    }

    @Bindable
    public void setNumTel(String numTel){
        this.model.numTel=numTel;
        notifyPropertyChanged (BR.numTel);
    }
}
