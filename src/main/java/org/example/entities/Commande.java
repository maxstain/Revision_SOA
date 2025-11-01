package org.example.entities;

public class Commande {

    private int id_commande;
    private int id_client;
    private int id_produit;
    private String date;

    public Commande(int id_commande, int id_client, int id_produit, String date) {
        this.id_commande = id_commande;
        this.id_client = id_client;
        this.id_produit = id_produit;
        this.date = date;
    }

    public Commande() {
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_client() {
        return id_client;
    }
}
