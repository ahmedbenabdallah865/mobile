/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.MultiButton;
import static com.codename1.io.Log.p;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.entities.Question;
import com.mycompany.myapp.services.ServiceQuizz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Quizz {
   
    
    
    String[] characters = { "théatre", "sport", "autre"};
    public Quizz(){
        
    MultiButton b = new MultiButton("Sujet ...");
    b.addActionListener(e -> {
    Dialog d = new Dialog();
    d.setLayout(BoxLayout.y());
    d.getContentPane().setScrollableY(true);
    for(int iter = 0 ; iter < characters.length ; iter++) {
        MultiButton mb = new MultiButton(characters[iter]);
       
        d.add(mb);
        mb.addActionListener(ee -> {
            
            b.setTextLine1(mb.getTextLine1());
            String S=mb.getTextLine1();
           
           // System.out.println(mb.getTextLine1());
            d.dispose();
            b.revalidate();
            if(S.equals("théatre"))
            { 
              new start();
                
            }
            if(S.equals("sport"))
            {
                System.out.println("sport");
            }
            if(S.equals("autre"))
            {
                System.out.println("autre");
            }
        });
       
    }
    d.showPopupDialog(b);
    });
      Form hi = new Form("Quizz", new BorderLayout());
      ((BorderLayout)hi.getLayout()).setCenterBehavior(BorderLayout.CENTER_BEHAVIOR_CENTER);
      hi.add(BorderLayout.CENTER, b);
      hi.show();
    }
     
}
               
    
    
   
    

