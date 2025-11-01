package org.example.entities;

import org.example.utils.TypeProduit;

public class Produit {

    private int id_produit;
    private String nom;
    private double prix;
    private int quantite;
    private TypeProduit categorie;

    public Produit(int id_produit, String nom, double prix, int quantite, TypeProduit categorie) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public TypeProduit getCategorie() {
        return categorie;
    }

    public void setCategorie(TypeProduit categorie) {
        this.categorie = categorie;
    }

    public Produit() {

    }
}
