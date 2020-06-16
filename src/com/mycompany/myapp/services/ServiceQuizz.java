/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ServiceQuizz {
    public ArrayList<Question> getMyQuizzList() {
        ArrayList<Question> listTasks = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/api/web/app_dev.php/comm/theatre");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();     
                try {
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                 
                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                    System.out.println(list);
                    for (Map<String, Object> obj : list) {
                        Question task = new Question();
                        float id = Float.parseFloat(obj.get("id").toString()); 
                        task.setId((int) id);
                        task.setRep1(obj.get("rep1").toString());
                        task.setRep2(obj.get("rep2").toString());
                        task.setRep3(obj.get("rep3").toString());
                        task.setCorrect(obj.get("correct").toString());
                        task.setSujet(obj.get("sujet").toString());
                        task.setEnonce(obj.get("enonce").toString());
                        listTasks.add(task);
                    }
                    
                    
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listTasks;
    }
     
}
