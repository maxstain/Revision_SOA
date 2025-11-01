package org.example.entities;

public class Client {
    private int id_client;
    private String nom;
    private String adresse;
    private int numTel;

    public Client(int id_client, String nom, String adresse, int numTel) {
        this.id_client = id_client;
        this.nom = nom;
        this.adresse = adresse;
        this.numTel = numTel;
    }

    public Client() {
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", nom=" + nom + ", adresse=" + adresse + ", numTel=" + numTel + '}';
    }
}
