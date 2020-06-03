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
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.fosUser.Reclamation;
import com.mycompany.myapp.entities.fosUser.Reponse;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author belkis
 */
public class reponseService {
    public ArrayList<Reponse> reponses;
    public ArrayList<Reclamation> reclamation;
    public boolean resultOK;
    private ConnectionRequest req;
    public static reponseService instance;
    public reponseService(){
        req = new ConnectionRequest();
    }
    public static reponseService getInstance(){
        if(instance==null)
            instance = new reponseService();
        return instance;
    }
    public void notifRep(){
        
        LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
    }
    
    
     public ArrayList<Reponse> parseReponses(String jsonText){
       
        try {
             reponses = new ArrayList<>();
        JSONParser j = new JSONParser();
        
            Map<String,Object>  RepListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)RepListJson.get("root");
            for(Map<String,Object> obj : list){
                Reponse r = new Reponse();
                float id = Float.parseFloat(obj.get("idReponse").toString());
                r.setId_reponse((int)id);
                
                
                r.setContenu(obj.get("contenu").toString());
                r.setImage(obj.get("image").toString());
                
                //System.out.println("r "+r.getId_reclamation());
               reponses.add(r);
                
            }
        } catch (IOException ex) {
            System.out.println("erreur ");
        }
        
            return reponses;

    }
     
      public ArrayList<Reponse> getAllReponses(Utilisateur us){
        String url = Statics.BASE_URL+"reps/"+us.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                reponses = parseReponses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
        return reponses;
    }
      
      public ArrayList<Reponse> parseNew(String jsonText){
       
        try {
             reponses = new ArrayList<>();
        JSONParser j = new JSONParser();
        
            Map<String,Object>  RepListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)RepListJson.get("root");
            for(Map<String,Object> obj : list){
                Reponse r = new Reponse();
                
                
                r.setContenu(obj.get("contenu").toString());
                
                
                //System.out.println("r "+r);
               reponses.add(r);
                
            }
        } catch (IOException ex) {
            System.out.println("erreur ");
        }
        
            return reponses;

    }
       public ArrayList<Reponse> getNewReponses(Utilisateur us){
        String url = Statics.BASE_URL+"new_rep/"+us.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                reponses = parseNew(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
         //  System.out.println("rep "+reponses);
        return reponses;
    }
     public ArrayList<Reclamation> parseidRec(String jsonText){
        try {
             reclamation = new ArrayList<>();
        JSONParser j = new JSONParser();
        
            Map<String,Object>  RecListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)RecListJson.get("root");
            for(Map<String,Object> obj : list){
              Reclamation r= new Reclamation();
                r.setDescription(obj.get("description").toString());
                r.setImage(obj.get("image").toString());
      reclamation.add(r);
            }
        } catch (IOException ex) {
            System.out.println("erreur ");
        }
         //System.out.println("       "+reclamation);
            return reclamation;

       
    }
     public ArrayList<Reclamation> getidRec(int idreponse){
        String url = Statics.BASE_URL+"reprecs/"+idreponse;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamation = parseidRec(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
         //  System.out.println("rep "+reponses);
        return reclamation;
    }
      
}
