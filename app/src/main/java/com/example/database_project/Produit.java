package com.example.database_project;

public class Produit {
    int id;
    String nom,prix;

    public Produit(int id, String nom, String prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, String prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Produit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
