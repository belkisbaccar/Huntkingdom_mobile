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
import com.mycompany.myapp.entities.Annonces.Annonce;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import static com.mycompany.myapp.services.reclamationService.instance;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author belkis
 */
public class annonceService {
   public ArrayList<Annonce> annonces;
   public boolean resultOK;
   private ConnectionRequest req;
   public static annonceService instance;
   
   public annonceService(){
       req=new ConnectionRequest();
   }
   
  public static annonceService getInstance(){
    if(instance==null)
     instance = new annonceService();
    return instance ;
  }
  public ArrayList<Annonce> parseAnnonces(String jsonText){
       
        try {
             annonces = new ArrayList<>();
        JSONParser j = new JSONParser();
        
            Map<String,Object>  AnListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)AnListJson.get("root");
            for(Map<String,Object> obj : list){
                Annonce r = new Annonce();
                float id = Float.parseFloat(obj.get("idAnnonce").toString());
              r.setId_annonce((int)id);
                
              
                
                r.setText(obj.get("text").toString());
                r.setImage(obj.get("image").toString());
                Map<String, Object> user=(Map<String, Object>) obj.get("user");
                r.setId_user(user.get("username").toString());
                
                annonces.add(r);
                
            }
        } catch (IOException ex) {
            System.out.println("erreur ");
        }
        
            return annonces;

    }
      public ArrayList<Annonce> getAllAnnonces(int user_id){
        String url = Statics.BASE_URL+"annonces/"+user_id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                annonces = parseAnnonces(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
        return annonces;
    }
      
      
       
       public ArrayList<Annonce> getAllsAnnonces(){
        String url = Statics.BASE_URL+"annonce";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                annonces = parseAnnonces(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
        return annonces;
    }
       
       public boolean addAnnonce(Annonce r){
        String url = Statics.BASE_URL+"annonce/new?text="+r.getText()+"&image="+r.getImage()+"&user="+r.getUsername();
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
       public boolean updateAnnonce(Annonce a){
        String url = Statics.BASE_URL+"annonce/"+a.getId_annonce()+"/update?text="+a.getText()+"&image="+a.getImage();
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
       public boolean deleteAnnonce(Annonce a){
        String url = Statics.BASE_URL+"annonce/"+a.getId_annonce()+"/delete";
         req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
