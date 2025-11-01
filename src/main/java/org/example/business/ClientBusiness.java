package org.example.business;

import org.example.entities.Client;
import org.example.entities.Commande;

import java.util.ArrayList;
import java.util.List;

public class ClientBusiness {

    private static ClientBusiness instance = null;
    private final List<Client> lstClient = new ArrayList<>();
    private final CommandeBusiness commandeBusiness = CommandeBusiness.getInstance();

    private ClientBusiness() {
        lstClient.add(new Client(1, "Mohamed", "Adresse 1", 123456789));
        lstClient.add(new Client(2, "Firas", "Adresse 2", 987654321));
        lstClient.add(new Client(3, "Client 3", "Adresse 3", 111111111));
        lstClient.add(new Client(4, "Client 4", "Adresse 4", 222222222));
    }

    public static ClientBusiness getInstance() {
        if (instance == null) {
            instance = new ClientBusiness();
        }
        return instance;
    }

    public List<Commande> getCommandesClient(int id) {
        List<Commande> commandes = new ArrayList<>();
        for (Commande cmd : commandeBusiness.getAllCommandes()) {
            if (cmd.getId_client() == id) {
                commandes.add(cmd);
            }
        }
        return commandes;
    }

    public void addClient(Client client) {
        lstClient.add(client);
    }

    public void deleteClient(Client client) {
        lstClient.remove(client);
    }

    public void updateClient(Client client) {
        lstClient.remove(client);
        lstClient.add(client);
    }

    public Client getClientById(int id) {
        for (Client client : lstClient) {
            if (client.getId_client() == id) {
                return client;
            }
        }
        return null;
    }

    public Client getClientByNom(String nom) {
        for (Client client : lstClient) {
            if (client.getNom().equalsIgnoreCase(nom)) {
                return client;
            }
        }
        return null;
    }

    public List<Client> getAllClients() {
        return lstClient;
    }
}
