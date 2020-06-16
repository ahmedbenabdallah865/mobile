/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Question;
import com.mycompany.myapp.services.ServiceQuizz;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class start {
    
    Form Q= new Form("Quizz théatre", BoxLayout.yCenter());
    ServiceQuizz serviceTask = new ServiceQuizz();
    ArrayList<Question> lis = serviceTask.getMyQuizzList();
    Container C1=new Container(BoxLayout.y());
    CheckBox cb1 = new CheckBox();
    CheckBox cb2 = new CheckBox();
    CheckBox cb3 = new CheckBox();
    SpanLabel E =  new  SpanLabel ( );
    
    
    Button Suivant=new Button("Suivant");
    int score=0;
    int i=0;
    public start()
    {
       Quizz();
    }

    private void Quizz() {
        System.out.println(lis.size());
         
                    
        E.setText(lis.get(i).getEnonce());
        cb1.setText(lis.get(i).getRep1());
        cb2.setText(lis.get(i).getRep2());
        cb3.setText(lis.get(i).getRep3());
        C1.addAll(E,cb1,cb2,cb3,Suivant);
        Q.add(C1);
        Q.show();
        System.out.println("i:"+i);
        System.out.println("correct"+lis.get(i).getCorrect());
        cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
             if(cb1.getText().equals(lis.get(i).getCorrect()))
             {
                 score++;
             }
             cb1.setEnabled(false);
             cb2.setEnabled(false);
             cb3.setEnabled(false);
             System.out.println("score"+score);
            }
        });
        
        cb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
             if(cb2.getText().equals(lis.get(i).getCorrect()))
             {
                 score++;
             }
             cb2.setEnabled(false);
             cb1.setEnabled(false);
             cb3.setEnabled(false);
             System.out.println("score"+score);
            }
        }); 
        cb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
             if(cb3.getText().equals(lis.get(i).getCorrect()))
             {
                 score++;
             }
             cb3.setEnabled(false);
             cb1.setEnabled(false);
             cb2.setEnabled(false);
             System.out.println("score"+score);
             
            }
        });
        Suivant.addActionListener(new ActionListener() {
             

            @Override
            public void actionPerformed (ActionEvent evt) {
                String test="echec";
                    int size;
                    size=lis.size()/2;
                if((score>=size) && (i==lis.size()-1) )
                    {
                       
                        test="succe";
                        ConnectionRequest con = new ConnectionRequest();
                        con.setUrl("http://localhost/api/web/app_dev.php/comm/succes");
                        ToastBar.showMessage("vous avez completer le test:"+test,FontImage.MATERIAL_DONE);
                        System.out.println("sayey");
                        NetworkManager.getInstance().addToQueueAndWait(con);
                    }
                if((score<=size) && (i==lis.size()-1) )
                {
                  
                    
                        ConnectionRequest con = new ConnectionRequest();
                        
                        con.setUrl("http://localhost/api/web/app_dev.php/comm/fail"); 
                        ToastBar.showMessage("vous avez completer le test:"+test,FontImage.MATERIAL_DONE);
                        NetworkManager.getInstance().addToQueueAndWait(con);
                }
                try{
                Q.refreshTheme();
                rec();
                
                }catch(Exception E)
                {
                   
                  
                    
                }
            }
            
                
            });;
        
    }
    public void rec()
    {
        i++;
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        this.Quizz();
    }
   

  
}
