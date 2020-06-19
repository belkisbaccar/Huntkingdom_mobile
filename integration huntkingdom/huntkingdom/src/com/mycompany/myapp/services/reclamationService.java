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
import com.codename1.payment.Product;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.gui.front.reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author belkis
 */
public class reclamationService {
    
    public ArrayList<Reclamation> reclamations;
    public boolean resultOK;
    public static reclamationService instance;
    private ConnectionRequest req;
    public reclamationService(){
        req = new ConnectionRequest();
    }
    public static reclamationService getInstance(){
        if(instance==null)
            instance = new reclamationService();
        return instance;
    }
    public boolean addReclamation(Reclamation r){
        String url = Statics.BASE_URL+"reclamation/new?description="+r.getDescription()+"&image="+r.getImage()+"&idproduit="+r.getId_produit()+"&iduser="+r.getId_user();
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
    public boolean updateReclamation(Reclamation r){
        String url = Statics.BASE_URL+"reclamation/"+r.getId_reclamation()+"/update?description="+r.getDescription()+"&image="+r.getImage();
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
    
     public boolean rateReclamation(Reclamation r){
        String url = Statics.BASE_URL+"reclamation/"+r.getId_reclamation()+"/rate?note="+r.getNote();
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
    
    public ArrayList<Reclamation> parseReclamations(String jsonText){
       
        try {
             reclamations = new ArrayList<>();
        JSONParser j = new JSONParser();
        
            Map<String,Object>  RecListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)RecListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation r = new Reclamation();
                float id = Float.parseFloat(obj.get("idReclamation").toString());
                r.setId_reclamation((int)id);
                
                r.setDescription(obj.get("description").toString());
                r.setImage(obj.get("image").toString());
                
                //System.out.println("r "+r);
                reclamations.add(r);
                
            }
        } catch (IOException ex) {
            System.out.println("erreur ");
        }
        
            return reclamations;

    }
    
    public ArrayList<Reclamation> getAllReclamations(int user_id){
        String url = Statics.BASE_URL+"reclamations/"+user_id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
       // System.out.println("rec"+reclamations);
        return reclamations;
    }
    
    
    
}
