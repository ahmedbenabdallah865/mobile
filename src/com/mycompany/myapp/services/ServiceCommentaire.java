/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.FontImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.entities.Publication;
import com.mycompany.myapp.entities.User;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author admin
 */
public class ServiceCommentaire {
    
    
    
    
     public ArrayList<Commentaire> getMyCommentaireList(Publication p) {
        ArrayList<Commentaire> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/api/web/app_dev.php/comm/affichecommentaire/"+p.getId());
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();     
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                 
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list);
                    for (Map<String, Object> obj : list) {
                        Commentaire task = new Commentaire();
                        task.setContenu(obj.get("contenu").toString());
                        task.setActif((int) Float.parseFloat(obj.get("actif").toString()));    
                        float id = Float.parseFloat(obj.get("id").toString()); 
                        Map<String, Object> listpub = null;
                        listpub = (Map<String, Object>) obj.get("publication");
                        Map<String, Object> listuser = null;
                        listuser = (Map<String, Object>) obj.get("User");
                        System.out.println("user"+listuser);
                        String S;
                        S=listuser.get("nom").toString()+" "+listuser.get("prenom").toString();
                        task.setUsername((String) listuser.get("prenom"));
                        task.setEmail(listuser.get("email").toString());
                        task.setTitre(listpub.get("nom").toString());
                        task.setId((int) id);
                        System.out.println();
                        
                       Map<String, Object> date = (Map<String, Object>) obj.get("createdAt");
                         float time=Float.parseFloat(date.get("timestamp").toString());
                         task.setCreated_at(new Date((long)time*1000));
                          
                        
                        listTasks.add(task);
                    }
                    
                    System.out.println("test");
                    System.out.println("list"+listTasks);
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     public void addCommentaire(Commentaire e,Publication p) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String S="samir";
        String Url = "http://localhost/api/web/app_dev.php/comm/commentaire/new/"+e.getContenu()+"/"+1+"/"+p.getId()+"/"+1;
           
        System.out.println(Url);// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((evt) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            ToastBar.showMessage("commentaire ajoutée avec succées.",FontImage.MATERIAL_DONE);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }   
    public void supprimercommentaire(Commentaire e) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/api/web/app_dev.php/comm/commentaire/supprimer/"+e.getId()
              ;
            System.out.println(Url);// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((evt) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            ToastBar.showMessage("commentaire supprimé avec succées.",FontImage.MATERIAL_DONE);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    public void modifiercommentaire(Commentaire e) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/api/web/app_dev.php/comm/update/"+e.getId()+"/"+e.getContenu()
              ;
            System.out.println(Url);// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((evt) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console
            ToastBar.showMessage("commentaire modifié avec succées.",FontImage.MATERIAL_DONE);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }
    
    
}
