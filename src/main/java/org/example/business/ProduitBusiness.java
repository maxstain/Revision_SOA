package org.example.business;

import org.example.entities.Produit;
import org.example.utils.TypeProduit;

import java.util.ArrayList;
import java.util.List;

public class ProduitBusiness {

    // Singleton instance
    private static ProduitBusiness instance = null;

    // List of products (mock database)
    private final List<Produit> listeProduits = new ArrayList<>();

    // Private constructor
    private ProduitBusiness() {
        listeProduits.add(new Produit(1, "Lenovo LOQ", 3500.0, 3, TypeProduit.ordinateur));
        listeProduits.add(new Produit(2, "Clavier Logitech", 120.5, 10, TypeProduit.perephirique));
        listeProduits.add(new Produit(3, "Routeur TP-Link", 250.0, 5, TypeProduit.equipement_reseau));
    }

    // Singleton accessor
    public static ProduitBusiness getInstance() {
        if (instance == null) {
            instance = new ProduitBusiness();
        }
        return instance;
    }

    // ✅ Return all products
    public List<Produit> getListeProduits() {
        return listeProduits;
    }

    // ✅ Add a new product
    public boolean addProduit(Produit p) {
        if (p != null) {
            listeProduits.add(p);
            return true;
        }
        return false;
    }

    public boolean deleteProduit(Produit p) {
        return listeProduits.remove(p);
    }

    public boolean updateProduit(Produit p) {
        return deleteProduit(p) && addProduit(p);
    }

    // ✅ Optional: find a product by ID
    public Produit getProduitById(int id) {
        for (Produit p : listeProduits) {
            if (p.getId_produit() == id) {
                return p;
            }
        }
        return null;
    }
}
