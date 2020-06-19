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
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entitie.evenement;
import com.mycompany.myapp.entitie.participation;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.userService;
import static com.mycompany.myapp.services.userService.instance;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hazem
 */
public class eventService {
   // utils u= new utils();
  private ConnectionRequest req;
  public static eventService  instance=null;
   public ArrayList<String> idParticipation;
  public ArrayList<String> id;
  public ArrayList<String> etat;
   public ArrayList<String> idUserr;
  public ArrayList<String> titre;
  public ArrayList<String> description;
  public ArrayList<String> datedebut;
   public ArrayList<String> datefin;
    public ArrayList<String> nombreplace;
   public ArrayList<String> image;
   public ArrayList<evenement> listEvent;
   public ArrayList<participation> listParticipation;
   
  
    
    public boolean resultOK;
    public String s;
   

    public eventService() {
         req = new ConnectionRequest();
    }
        public static eventService getInstance() {
        if (instance == null) {
            instance = new eventService();
        }
        return instance;
    }
     public ArrayList<String> parseidParticipation(String jsonText){
        try {
            idParticipation=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("idParticipation").toString());
               
                

                
               
                idParticipation.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return idParticipation;
    }
      public ArrayList<String> parseid(String jsonText){
        try {
            id=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("idEvent").toString());
               evenement t = new evenement();
                

                float idd = Float.parseFloat(obj.get("idEvent").toString());
                t.setId_event((int)idd);
               
                id.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return id;
    }
       public ArrayList<String> parseetat(String jsonText){
        try {
            etat=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("etat").toString());
               
                

               
                etat.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return etat;
    }
      
      public ArrayList<String> parseidUserr(String jsonText){
        try {
            idUserr=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("idUserr").toString());
               evenement t = new evenement();
                

               
                idUserr.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return idUserr;
    }
        public ArrayList<String> parsetitre(String jsonText){
        try {
            titre=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("titreEvent").toString());
               
                
                titre.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return titre;
    }
        
      
        
            public ArrayList<String> parseimage(String jsonText){
        try {
            image=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                evenement t = new evenement();
                   String name=(obj.get("image").toString());
               
                
                image.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return image;
    }
        
            public ArrayList<String> parsedescription(String jsonText){
        try {
            description=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("descriptionEvent").toString());
               
                
                description.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return description;
    }
            public ArrayList<String> parsedatedebut(String jsonText){
        try {
            datedebut=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                  //String name=(obj.get("dateDebutEvent").toString());
               Map<String, Object> mapDateDebut=(Map<String, Object>) obj.get("dateDebutEvent");
                            float datedebutt = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String date =new com.codename1.l10n.SimpleDateFormat("yyy/MM/dd").format(new Date((long) (datedebutt * 1000L)));
               // Map<String, Object> dated = (Map<String, Object>) obj.get("dateDebutEvent");

               /* float dateTimeStamp = Float.parseFloat(obj.get("dateDebutEvent").toString());
                Date date = new Date((long)dateTimeStamp);    
                       DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
                       
                String strDate = dateFormat.format(date); */ 

                datedebut.add(date);
            }
            
            
        } catch (IOException ex) {
            
        }
        return datedebut;
    }
             public ArrayList<String> parsedatefin(String jsonText){
        try {
            datefin=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                  // String name=(obj.get("dateFinEvent").toString());
               
               Map<String, Object> mapDateDebut=(Map<String, Object>) obj.get("dateFinEvent");
                            float datedebutt = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String date =new com.codename1.l10n.SimpleDateFormat("yyy/MM/dd").format(new Date((long) (datedebutt * 1000L)));
                
                datefin.add(date);
            }
            
            
        } catch (IOException ex) {
            
        }
        return datefin;
    }
             public ArrayList<String> parsenombreplace(String jsonText){
        try {
            nombreplace=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                
                   String name=(obj.get("nbPlaceEvent").toString());
               
                
                nombreplace.add(name);
            }
            
            
        } catch (IOException ex) {
            
        }
        return nombreplace;
    }
                
         public ArrayList<String> getid(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
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
           public ArrayList<String> getetat(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                etat = parseetat(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return etat;
    } 
        
          public ArrayList<String> getidParticipation(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/allparticipation";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                idParticipation = parseidParticipation(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return idParticipation;
    }
           public ArrayList<String> getidUserr(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                idUserr = parseidUserr(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return idUserr;
    }
               public ArrayList<String> gettitre(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                titre = parsetitre(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return titre;
    }
                   public ArrayList<String> getImage(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
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
                   
                   public ArrayList<String> getdescription(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                description = parsedescription(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return description;
    }
                   public ArrayList<String> getdatedebut(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                datedebut = parsedatedebut(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return datedebut;
    }
                   public ArrayList<String> getdatefin(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                datefin = parsedatefin(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return datefin;
    }
                   public ArrayList<String> getnombreplace(){
                   
        String url ="http://127.0.0.1/hunt/groupee/symfony2/web/app_dev.php/all";
       
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                nombreplace = parsenombreplace(new String(req.getResponseData()));
                 //System.out.println("chnia mochkol "+tasks);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return nombreplace;
    }
                   
   /*******************************************************************************************/               
             public boolean addevent(evenement e) {//baseurl : adresse ip de serveur 
        String url = "http://localhost/hunt/groupee/symfony2/web/app_dev.php/ajouterevent" + "?titreEvent=" + e.getTitre_event()+"&descriptionEvent="+e.getDescription_event()+"&image="+e.getImage()+"&dateDebutEvent="+e.getDate_debut_event()+"&dateFinEvent="+e.getDate_fin_event()+"&nbPlaceEvent="+e.getNb_place_event()+"&idUserr="+e.getIdUser();//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  /************************************************************************************************/                   
             public boolean addparticipation(participation p,int id) {//baseurl : adresse ip de serveur 
        String url = "http://localhost/hunt/groupee/symfony2/web/app_dev.php/ajouterparticipation/" +id+ "?username=" + p.getUsername()+"&idEvent="+p.getId_event()+"&dateReservation="+p.getDateReservation();//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
  /************************************************************************************************/   
       public ArrayList<evenement> parseevents(String jsonText) throws ParseException{
        try {
            listEvent=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                

                evenement t = new evenement();
               

                float id = Float.parseFloat(obj.get("idEvent").toString());
                t.setId_event((int)id);
               
                t.setTitre_event(obj.get("titreEvent").toString());
                t.setDescription_event(obj.get("descriptionEvent").toString());
                t.setImage(obj.get("image").toString());
                t.setNb_place_event((int)Float.parseFloat(obj.get("nbPlaceEvent").toString()));
                t.setNb((int)Float.parseFloat(obj.get("nb").toString()));
                
                 
                 t.setIdUser((int)Float.parseFloat(obj.get("idUserr").toString()));
                 
                 Map<String, Object> mapDateDebut=(Map<String, Object>) obj.get("dateDebutEvent");
                            float datedebutt = Float.parseFloat(mapDateDebut.get("timestamp").toString());
                            String date =new com.codename1.l10n.SimpleDateFormat("yyy/MM/dd").format(new Date((long) (datedebutt * 1000L)));
                t.setDate_debut_event(date);
                 Map<String, Object> mapDateDebutt=(Map<String, Object>) obj.get("dateFinEvent");
                            float datedebuttt = Float.parseFloat(mapDateDebutt.get("timestamp").toString());
                            String datee =new com.codename1.l10n.SimpleDateFormat("yyy/MM/dd").format(new Date((long) (datedebuttt * 1000L)));
                t.setDate_fin_event(datee);
                
               
               /* t.setDated(new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss").parse(obj.get("dated").toString()));
                t.setDatef(new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").parse(obj.get("datef").toString()));*/
              // t.setDated(new SimpleDateFormat("dd-MM-yyyy  HH:mm:ss").parse(dateF.get("timestamp").toString()));
              
                listEvent.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return listEvent;
    } 
           public ArrayList<evenement> getAllevents(int id){
       
                String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/Event/alll/"+id;
       System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                
                try {
                    listEvent = parseevents(new String(req.getResponseData()));
                } catch (ParseException ex) {
                }
                    //System.out.println("chnia mochkol "+tasks);
                    req.removeResponseListener(this);
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listEvent;
    }
  /************************************************************************************************/    
                               public ArrayList<evenement> supprimerevent(int id){
        String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/supprimerevent" + "?idEvent=" + id;
       System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                 
                
                    //System.out.println("chnia mochkol "+tasks);
                    req.removeResponseListener(this);
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listEvent;
    }
                                 /************************************************************************************************/    
                               public ArrayList<participation> supprimerparticipation(int idEvent,int id){
        String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/supprimerParticipation/" +idEvent+ "?idParticipation=" + id;
       System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               
                 
                
                    //System.out.println("chnia mochkol "+tasks);
                    req.removeResponseListener(this);
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listParticipation;
    }
         public boolean modifierevents(evenement e) {////ne9sa matiere
        String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/modifierevent" + "?idEvent=" + e.getId_event() + "&titreEvent=" + e.getTitre_event()+"&descriptionEvent="+e.getDescription_event()+"&image="+e.getImage()+"&dateDebutEvent="+e.getDate_debut_event()+"&dateFinEvent="+e.getDate_fin_event()+"&nbPlaceEvent="+e.getNb_place_event();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
         public boolean getPubAimer(String username ,int idevent ){
        String url ="http://localhost/hunt/groupee/symfony2/web/app_dev.php/Event/chercherEventmobile/"+username+"/"+idevent;
     
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                s =new String(req.getResponseData());
                s=s.substring(2,s.length()-1);
               
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return s.equals("1");
             
    } 
    
}
