/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.payment.Receipt;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.entities.fosUser.Reclamation;
import com.mycompany.myapp.entities.fosUser.Reponse;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.reclamationService;
import com.mycompany.myapp.services.reponseService;
import java.util.ArrayList;

/**
 *
 * @author belkis
 */
public class afiicher_reponses extends Form {
    
    Form current;
    public afiicher_reponses(Form previous,Utilisateur user) {
        current = this;
        
        
        setTitle("Liste des reponses");
        Style reponse = getAllStyles();
        reponse.setBgColor(0xccff99);
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new reclamation(current,user).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

        
        
        ArrayList<Reponse> r=new ArrayList<>();
        r = reponseService.getInstance().getAllReponses(user);
        System.out.println("r"+r);
        System.out.println("user "+user);
        Font largeBoldSystemFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);

       
       
        for (Reponse rep : r) {
            Container cnt2r=new Container(new FlowLayout(Container.CENTER));
            Container cnt1r=new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label rec = new Label("Réponse :");
            Style recstyle = rec.getAllStyles();
            recstyle.setFont(largeBoldSystemFont);
            recstyle.setFgColor(0x000000);
            recstyle.setMargin(Component.TOP, 1);
            
            Label Contenu = new Label();
            Contenu.setText(rep.getContenu());
            
            Style descstyle = Contenu.getAllStyles();
            descstyle.setFgColor(0x000000);
            descstyle.setMargin(Component.TOP, 1);
            //System.out.println(rel.getImage().substring(0,5));
            String path ="http://127.0.0.1/groupee/symfony2/web/images/"+rep.getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("load.jpg"), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,rep.getImage(),path);
            
           ImageViewer image = new ImageViewer();
     
            image.setImage(imgUrl);
            System.out.println(rep.getImage());
           int idreponse= rep.getId_reponse();
            System.out.println("id rep "+idreponse);
             
        ArrayList<Reclamation> re = reponseService.getInstance().getidRec(idreponse);
            System.out.println("rel "+re);
           for(Reclamation rel:re){
               
                   Container cnt2 = new Container(new FlowLayout(Container.CENTER));
            Container cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label rec1 = new Label("Réclamation :");
            Style recstyle1 = rec.getAllStyles();
            recstyle1.setFont(largeBoldSystemFont);
            recstyle1.setFgColor(0x000000);
            recstyle1.setMargin(Component.TOP, 1);

            
            Label desc = new Label();
            
            desc.setText(rel.getDescription());

            

            Style descstyle1 = desc.getAllStyles();
            descstyle1.setFgColor(0x000000);
            descstyle1.setMargin(Component.TOP, 1);
            //System.out.println(rel.getImage().substring(0,5));
            String path1 = "http://127.0.0.1/groupee/symfony2/web/images/" + rel.getImage() + "";
            EncodedImage encImg1
                    = EncodedImage.createFromImage(theme.getImage("load.jpg"), false);

            URLImage imgUrl1 = URLImage.createToStorage(encImg1, rel.getImage(), path1);

            ImageViewer image1 = new ImageViewer();

            image1.setImage(imgUrl1);
           
            
        
            cnt1.addAll( desc, image1);
            cnt2.addAll(rec, cnt1);
            add(cnt2);

           }
               
            
            
            cnt1r.addAll(Contenu,image);
            cnt2r.addAll(rec,cnt1r);
            add(cnt2r);
        }
        

        //System.out.println("a :"+a );
        //add(sp);
        
    }
}
