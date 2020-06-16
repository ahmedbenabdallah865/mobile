/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.entities.Publication;
import com.mycompany.myapp.services.ServiceCommentaire;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class ModifierCommentaire extends Form {
     Label testVide;
    TextField Contenu;
    Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
    ServiceCommentaire es = new ServiceCommentaire();
    Resources theme = UIManager.initFirstTheme("/theme");
   public ModifierCommentaire(Commentaire e,Publication p) {
    
    Image back; 
    try {
     back = Image.createImage("/back-command.png");
               back.scaled(150, 150);
        this.getToolbar().addCommandToLeftBar(" ", back, (ev) -> {
            AfficheCommentaire myp = new AfficheCommentaire(p);
            myp.showBack();
        });
      } catch (IOException ex) {
           
      }
     this.setTitle("Modifier Commentaire");
     Contenu = new TextField("", e.getContenu());
     testVide = new Label();
      Container ajoutCont = new Container(new GridLayout(1, 2));
      Button ajout = new Button("Ajouter");
     ajoutCont.add(ajout);
     C1.add(Contenu);
     C1.add(testVide);
     this.addAll(C1,ajoutCont);
     
     
     ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                
                e.setContenu(Contenu.getText());
                
                es.modifiercommentaire(e);
                
                    
                 }
            
        });
    
   }
     
}
