/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.userService;
import static com.mycompany.myapp.services.userService.instance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azizm
 */
public class service {
   utils u= new utils();
  private ConnectionRequest req;
  public static service  instance=null;
  public ArrayList<String> nom;
  public ArrayList<String> prix;
  public ArrayList<String> priPromo;
   public ArrayList<String> image;
   public ArrayList<Float> id;
  
   
   

    public service() {
         req = new ConnectionRequest();
    }
        public static service getInstance() {
        if (instance == null) {
            instance = new service();
        }
        return instance;
    }
    
       /* public ArrayList<produit_entities> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                produit_entities t = new produit_entities();
                  float prix = Float.parseFloat(obj.get("prix").toString());
                   t.setPrix((int)prix);
                   float prix_promo = Float.parseFloat(obj.get("prixPromo").toString());
                   t.setPrix_promo((float)prix_promo);
                   float quantite = Float.parseFloat(obj.get("quantite").toString());
                   t.setQuantite((int)quantite);
       
                
                t.setNom(obj.get("nom").toString());
                t.setImage(obj.get("image").toString());
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return tasks;
    }*/
        
        
        public ArrayList<String> parsenom(String jsonText){
        try {
            nom=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("nom").toString());
               
                
                nom.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return nom;
    }
         public ArrayList<Float> parseid(String jsonText){
        try {
            id=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                float name = Float.parseFloat(obj.get("id").toString());
                id.add(name);
            }
        } catch (IOException ex) {
        }
        return id;
    }
      
        
            public ArrayList<String> parseimage(String jsonText){
        try {
            image=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                produit_entities t = new produit_entities();
                   String name=(obj.get("image").toString());
               
                
                image.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return image;
    }
        
            public ArrayList<String> parseprix(String jsonText){
        try {
            prix=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("prix").toString());
               
                
                prix.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return prix;
    }
                        public ArrayList<String> parseprixPromo(String jsonText){
        try {
            prix=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("prixPromo").toString());
               
                
                prix.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return prix;
    }
      
                
          
        
        
               public ArrayList<String> getProd(){
                   
        String url =u.PROD_URL;
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                nom = parsenom(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return nom;
    }
               
               public ArrayList<Float> getID(){
                   
        String url =u.PROD_URL;
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                id = parseid(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return id;
    }
                   public ArrayList<String> getImage(){
                   
        String url =u.PROD_URL;
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                image = parseimage(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return image;
    }
                   
                   public ArrayList<String> getPrix(){
                   
        String url =u.PROD_URL;
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                prix = parseprix(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return prix;
    }
                                      public ArrayList<String> getPrixPromo(){
                   
        String url =u.PROD_URL;
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                priPromo = parseprixPromo(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return priPromo;
    }
                   
}
