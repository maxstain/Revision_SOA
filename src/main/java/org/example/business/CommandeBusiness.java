package org.example.business;

import org.example.entities.Commande;

import java.util.ArrayList;
import java.util.List;

public class CommandeBusiness {

    private static CommandeBusiness instance = null;
    private static final List<Commande> listeCmds = new ArrayList<>();

    private CommandeBusiness() {
        listeCmds.add(new Commande(1, 1, 1, "2021-01-01"));
        listeCmds.add(new Commande(2, 2, 2, "2021-01-02"));
        listeCmds.add(new Commande(3, 3, 3, "2021-01-03"));
    }

    public static CommandeBusiness getInstance() {
        if (instance == null) {
            instance = new CommandeBusiness();
        }
        return instance;
    }

    public Commande getCommandeById(int id) {
        for (Commande cmd : listeCmds) {
            if (cmd.getId_commande() == id) {
                return cmd;
            }
        }
        return null;
    }

    public List<Commande> getAllCommandes() {
        return listeCmds;
    }

    public void addCommande(Commande commande) {
        listeCmds.add(commande);
    }

    public void deleteCommande(int id) {
        listeCmds.removeIf(cmd -> cmd.getId_commande() == id);
    }

    public void updateCommande(Commande commande) {
        listeCmds.removeIf(cmd -> cmd.getId_commande() == commande.getId_commande());
        listeCmds.add(commande);
    }

}
