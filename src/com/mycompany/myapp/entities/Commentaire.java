/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author admin
 */
public class Commentaire {
     private int id;
     private Publication  publication;
     private User user;
     private String contenu;
     private int actif;
     private Date created_at;
     private String titre;
     private String Username;
     private String email;
     private String Date;
   

    public Commentaire(int id, String contenu, Date created_at,String Date) {
        this.id = id;
        this.contenu = contenu;
        this.created_at = created_at;
        this.Date=Date;
    }

    public Commentaire() {
       
    }


   

    
    
    
 

    public Commentaire(Publication publication, User user, String contenu, int actif, Date created_at,String titre,String Username,String email) {
        this.publication = publication;
        this.user = user;
        this.contenu = contenu;
        this.actif = actif;
        this.created_at = created_at;
        this.titre=titre;
        this.Username=Username;
        this.email=email;
    }

    public Commentaire(int id, Publication publication, User user, String contenu, int actif, Date created_at) {
        this.id = id;
        this.publication= publication;
        this.user= user;
        this.contenu = contenu;
        this.actif = actif;
        this.created_at = created_at;
    }
    
    

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ",  contenu=" + contenu + ", actif=" + actif + ", created_at=" + created_at  + '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getActif() {
        return actif;
    }

    public void setActif(int actif) {
        this.actif = actif;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    

}
