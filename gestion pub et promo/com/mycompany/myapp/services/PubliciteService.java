/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import Produit.produit_entities;
import Publicite.Publicite_entite;
import Publicite.chasseEntite;
import Publicite.newsletter_entite;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;

/**
 *
 * @author walid
 */
public class PubliciteService {
        private ConnectionRequest req;
         private ConnectionRequest req1;
         public static PubliciteService instance=null;
  public ArrayList<Publicite_entite> tasks;
   public ArrayList<newsletter_entite> tasks1;
   public ArrayList<chasseEntite> tasks2;
   public ArrayList<produit_entities> tasks3;
  public String s;
   
  
  public PubliciteService() {
         req = new ConnectionRequest();
    }
       public static PubliciteService getInstance() {
        if (instance == null) {
            instance = new PubliciteService();
        }
        return instance;
    }
               
                       public ArrayList<produit_entities> parseProduits(String jsonText){
        try {
            tasks3=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                Map<String, Object> Products=(Map<String, Object>) obj.get("Product");
                
                float prixPromo = Float.parseFloat(Products.get("prixPromo").toString());
                System.out.println(prixPromo);
                produit_entities p= new produit_entities(Products.get("nom").toString(),0,Products.get("image").toString(),(int)Float.parseFloat(Products.get("prix").toString()),prixPromo);
               p.setPrix_promo(prixPromo);
                tasks3.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks3;
    
              }
       public ArrayList<Publicite_entite> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                
                Publicite_entite t = new Publicite_entite();
                float position = Float.parseFloat(obj.get("position").toString());
                 float id = Float.parseFloat(obj.get("idPublicite").toString());
                t.setPosition((int)position);
                t.setId((int)id);
                float etat = Float.parseFloat(obj.get("etat").toString());
                t.setEtat((int)etat);
               
                t.setNom(obj.get("nom").toString());
                t.setImage(obj.get("image").toString());
            
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    
              }
                
                
                                public ArrayList<chasseEntite> parseChasse(String jsonText){
        try {
            tasks2=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                chasseEntite t = new chasseEntite();
                Map<String, Object> nom_animal=(Map<String, Object>) obj.get("animal");
                
                
                t.setAnimal(nom_animal.get("nom").toString());
                t.setRegion(obj.get("region").toString());
                t.setType(obj.get("type").toString());
                
                
                Map<String, Object> mapDateDebut=(Map<String, Object>) obj.get("dateDebut");
                            float datedebutt = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String date =new com.codename1.l10n.SimpleDateFormat("dd/MM/yy").format(new Date((long) (datedebutt * 1000L)));
                t.setDate_debut(date);
                  Map<String, Object> mapDatefin=(Map<String, Object>) obj.get("dateFin");
                            float datefin = Float.parseFloat(mapDatefin.get("timestamp").toString());
                            String datef =new com.codename1.l10n.SimpleDateFormat("dd/MM/yy").format(new Date((long) (datefin * 1000L)));
                t.setDate_fin(datef);
               
                
               
                 float id = Float.parseFloat(obj.get("id").toString());
              
                t.setId((int)id);
                float etat = Float.parseFloat(obj.get("etat").toString());
                t.setEtat((int)etat);
               
                System.out.println(t);
            
                tasks2.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks2;
    
              }
                
                               public ArrayList<newsletter_entite> parseNews(String jsonText){
        try {
            tasks1=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
           
            for(Map<String,Object> obj : list){
                
                newsletter_entite n = new newsletter_entite();
                
                float id_user = Float.parseFloat(obj.get("idUser").toString());
                 float id = Float.parseFloat(obj.get("id").toString());
                n.setId_user((int)id_user);
                n.setId((int)id);
                float etat = Float.parseFloat(obj.get("etat").toString());
                n.setEtat((int)etat);
                
                n.setMail(obj.get("mail").toString());
                
            
                tasks1.add(n);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks1;
    
              } 
                

                                
                                               public ArrayList<newsletter_entite> getnewsletter(int id_user){
        String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/getnewsletter/"+id_user;
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                tasks1= parseNews(new String(req.getResponseData()));
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks1;
    } 
                
               public ArrayList<Publicite_entite> getPub(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/PubliciteMobile";
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                tasks = parseTasks(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }     
                              public ArrayList<chasseEntite> getChasse(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/getChasseM";
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                tasks2 = parseChasse(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks2;
    }
                                                            public ArrayList<chasseEntite> getChasseToday(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/getChasseT";
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                tasks2 = parseChasse(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks2;
    }
                                                             public ArrayList<produit_entities> getPromoToday(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/getPromoT";
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                tasks3 = parseProduits(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks3;
    }
                   public boolean getPubAimer(int id ,int iduser){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/chercherPubmobile/"+id+"/"+iduser;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s.equals("1");
             
    } 
                                      public boolean getNews(int iduser){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/cherchernews/"+iduser;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s.equals("1");
             
    }
                                                                                  public String countAllNews(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/countAll";
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                  s=s.substring(1,s.length());
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s;
             
    } 
                                             public String countENews(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/countE";
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                  s=s.substring(1,s.length());
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s;
             
    }  
                                 public String countPNews(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/countP";
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                 
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s;
             
    }
                                        public String countCNews(){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/countC";
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                 
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s;
             
    }                          
            public void ajoutPubAimer(int id ,int iduser){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/PubliciteAimerMobile/"+id+"/"+iduser;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
                System.out.println(s);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
             
    }
                        public void supprimerPubAimer(int id ,int iduser){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/removeM/"+id+"/"+iduser;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
                System.out.println(s);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
             
    }
            
                        public void ajoutnews(int iduser,int etat,String mail){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/ajoutnews/"+iduser+"/"+mail+"/"+etat;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
                System.out.println(s);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
             
    } 
                              public void updatenews(int id,int etat,String mail){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/updatenewsletter/"+id+"/"+etat+"/"+mail;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
                System.out.println(s);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
             
    }                  
                               public void sendMailnews(String mail,String username){
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/sendmailNews/"+username+"/"+mail;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               String s =new String(req.getResponseData());
                s=s.substring(1,s.length()-1);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
      
             
    }            
}