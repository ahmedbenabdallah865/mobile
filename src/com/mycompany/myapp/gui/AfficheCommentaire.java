/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.entities.Publication;
import com.mycompany.myapp.services.ServiceCommentaire;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author admin
 */
public class AfficheCommentaire extends Form{
    
    public static Commentaire rec = new Commentaire();
    
    public AfficheCommentaire(Publication p){
        ServiceCommentaire serviceTask = new ServiceCommentaire();
        ArrayList<Commentaire> lis = serviceTask.getMyCommentaireList(p);
        System.out.println(lis);
       Resources theme = UIManager.initFirstTheme("/theme");
       this.show();
       Toolbar tb = this.getToolbar();
       this.setTitle("Liste des Commentaire");
       tb.addCommandToOverflowMenu("Ajouter Commentaire",null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             new AjouterCommentaire(p).show();
            }
        });
        tb.addCommandToOverflowMenu("Mes commentaire",null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             new AfficheCommentaire(p).show();
               
            }
        });
        
        for (Commentaire t : lis) {
            
            
            Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            C3.setWidth(100);
            Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            
            Button detail = new Button("Detail");
            SpanLabel contenu = new SpanLabel("Commentaire:"+t.getContenu());
            SpanLabel titre = new SpanLabel("Titre de Publication :"+t.getTitre());
            
           
            SimpleDateFormat Date = new SimpleDateFormat("dd-MM-yyyy");
           
            String dd= Date.format(t.getCreated_at());
           
            
            Label date = new Label("Date de Création : " + dd  );
           
            
           
            this.add(new Slider());
            C2.setLeadComponent(detail);
            detail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    rec = t;
                    Form f2 = new detailCommentaire(p);
                    Toolbar tb_detail = f2.getToolbar();
                    
                    f2.show();
                }
                
            });
          
            detail.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   
                   
                }
                
            });
           C1.add(titre);
            C2.add(contenu);
            
            C2.add(date);
            
            C4.add(detail);
            
          
         
            this.add(C1);
            this.add(C2);
            this.add(C3);
            this.add(C4);
                
              }
          tb.addMaterialCommandToSideMenu("Accueil", FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
             
           } });
          tb.addMaterialCommandToSideMenu("Publicité", FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
           } });
          tb.addMaterialCommandToSideMenu("Réclamation", FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });
          tb.addMaterialCommandToSideMenu("Evenemenets", FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
            }
        });
          tb.addMaterialCommandToSideMenu("Formations ", FontImage.MATERIAL_KEYBOARD_ARROW_RIGHT,
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              

            }
        });
    }
}
