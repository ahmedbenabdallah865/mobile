/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Publication;
import static com.mycompany.myapp.gui.AfficheCommentaire.rec;
import com.mycompany.myapp.services.ServiceCommentaire;
import java.io.IOException;
//import java.lang.reflect.Parameter;
import com.restfb.Parameter;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.FacebookType;

/**
 *
 * @author admin
 */
public class detailCommentaire extends Form{
    private Resources theme;
     EncodedImage enc;
      SpanLabel desc;
      SpanLabel nomE;
    public detailCommentaire(Publication p) {
        
    

        try {
            
            

             theme = UIManager.initFirstTheme("/theme");
             Image back= Image.createImage("/back-command.png");
             back.scaled(150, 150);
             this.getToolbar().addCommandToLeftBar("Retour ", back, (ev) -> {

                AfficheCommentaire affComent = new AfficheCommentaire(p);
                affComent.show();
            });
             
           
            
            Container C1 = new Container(new FlowLayout(Component.CENTER));
            Container C2 = new Container(new FlowLayout(0, Component.CENTER));
            Container C3 = new Container(new FlowLayout(0, Component.CENTER));
            Button supprimer = new Button("supprimer");
            Button modifier = new Button("modifier");
            ServiceCommentaire sr = new ServiceCommentaire();

            // ArrayList<Event> event = sr.getListEvent();
            //String url = "http://localhost/salma/web/uploads/event/" + AffichageEvent.rec.getImage();
            enc = EncodedImage.create("/giphy.gif");
            nomE = new SpanLabel("Titre de la publication " + AfficheCommentaire.rec.getTitre());
            desc = new SpanLabel("Contenu : " + AfficheCommentaire.rec.getContenu()+"\nCreer par: "+AfficheCommentaire.rec.getUsername()
            +"\nAdress mail :"+AfficheCommentaire.rec.getEmail());
            

            supprimer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                sr.supprimercommentaire(rec);
                }
                
            });
             modifier.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new ModifierCommentaire(rec,p).show();
               
                }
                
            });

           

            
            C1.add(supprimer);
            C1.add(modifier);
            
            C2.add(nomE);
           

            C3.add(desc);

           
            

            this.add(C1);
            this.add(C2);
            this.add(C3);
            
           
        } catch (IOException ex) {
            
        }


        

   }
}
