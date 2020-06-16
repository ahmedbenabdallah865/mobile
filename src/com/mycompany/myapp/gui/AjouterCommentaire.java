/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
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
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.SMS;


import com.mycompany.myapp.services.ServiceCommentaire;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class AjouterCommentaire  extends Form{
    Label testVide;
    TextField Contenu;
    Container C1=new Container(new BoxLayout(BoxLayout.Y_AXIS));
    ServiceCommentaire es = new ServiceCommentaire();
    Resources theme = UIManager.initFirstTheme("/theme");
   public AjouterCommentaire(Publication p) {
    
       
       
       
       
    
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
     this.setTitle("Ajouter Commentaire");
     Contenu = new TextField("", "Creé un Contenu");
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
                
                 
                 if (controle() == true)
                {
                    testVide.setText("Veuillez Remplir Tout Les Champs");
                }
            else {
                     
                 
                Commentaire e = new Commentaire();
                //e.setActif(1);
                //lblusernametest.setText("");
                //e.setUser(User.user);
                e.setContenu(Contenu.getText());
                
               
                
               
               
               /* //e.setImage(fileName);
                LocalNotification ln = new LocalNotification();
                ln.setId("LnMessage");
                ln.setAlertTitle("Welcome");
                ln.setAlertBody("Thanks for arriving!");
               Display.getInstance().scheduleLocalNotification(
                                    ln,
                                    System.currentTimeMillis() + 10 * 1000, // fire date/time
                                    LocalNotification.REPEAT_MINUTE // Whether to repeat and what frequency
                            );*/
              /*     Local_Notification lo=new Local_Notification("Ajout","Ajout Réussi !");
                                     lo.getLocal_Notif();
                                     
                                     System.out.println("insertion");
                    try {
               Display.getInstance().sendSMS("+21650700477", "votre message");
                } catch (IOException ex) {
                    System.out.println("error sms : aa");
           }*/
              
            SMS a= new SMS();
           Twilio.init("AC3c73039043e78f6167ef78415d30d2b3", "18a9b129c59f6be28f607ac39567b7bf");
        com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21623477656"),//to
                new PhoneNumber("(205) 846-9113"),//from 
                "a participer a").create();
              
                es.addCommentaire(e,p);
                
                    
                 }
            

            }

        });
    
    
     }
   
   
   
    private Boolean controle() {

        if (Contenu.getText() == " ") {
            System.out.println("temchi");

            return true;
        }

        return false;
    }
}
