/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.Reclamation_Reponse;

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
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reponse;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.reclamationService;
import com.mycompany.myapp.services.reponseService;
import com.mycompany.myapp.gui.Reclamation_Reponse.rate_reclamation;
import com.mycompany.myapp.gui.front.reclamation;
import java.util.ArrayList;

/**
 *
 * @author belkis
 */
public class afiicher_reponses extends Form {
    
    Form current;
    public afiicher_reponses(Form previous) {
        current = this;
        
         UserSession n = UserSession.getInstance();
        setTitle("Liste des reponses");
        Style reclamation = getAllStyles();
    
        reclamation.setBgImage(MyApplication.theme.getImage("2.jpg")); 
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new reclamation(current).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

        
        
        ArrayList<Reponse> r=new ArrayList<>();
        r = reponseService.getInstance().getAllReponses(n.getId());
        System.out.println("r"+r);
        System.out.println("user "+n);
        Font largeBoldSystemFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);

       
       
        for (Reponse rep : r) {
             Container cnt3r=new Container(new FlowLayout(BoxLayout.Y_AXIS));
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
            String path ="http://127.0.0.1/hunt/groupee/symfony2/web/images/"+rep.getImage()+""; 
               EncodedImage encImg
                = EncodedImage.createFromImage(theme.getImage("load.jpg"), false);
         
              URLImage  imgUrl = URLImage.createToStorage(encImg,rep.getImage(),path);
            
           ImageViewer image = new ImageViewer();
     
            image.setImage(imgUrl);
         
           
        
             Container cnt2 = new Container(new FlowLayout(Container.CENTER));
            Container cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label recl = new Label("Réclamation :");
            Style recstylel = recl.getAllStyles();
            recstylel.setFont(largeBoldSystemFont);
            recstylel.setFgColor(0x000000);
            recstylel.setMargin(Component.TOP, 1);

            
            Label descl = new Label();
            
            descl.setText(rep.getDesc_reclamation());

            

            Style descstylel = descl.getAllStyles();
            descstylel.setFgColor(0x000000);
            descstylel.setMargin(Component.TOP, 1);
            //System.out.println(rel.getImage().substring(0,5));
            String pathl = "http://127.0.0.1/groupee/symfony2/web/images/" + rep.getImg_reclamation() + "";
            EncodedImage encImgl
                    = EncodedImage.createFromImage(theme.getImage("load.jpg"), false);

            URLImage imgUrll = URLImage.createToStorage(encImgl, rep.getImg_reclamation(), pathl);

            ImageViewer imagel = new ImageViewer();

            imagel.setImage(imgUrll);
           
        Button rate = new Button("noter la réclamation");
        Style rateStyle = rate.getAllStyles();
        rateStyle.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        rateStyle.setBgColor(0xCD853F);
        rateStyle.setFgColor(0x000000);
        rateStyle.setBgTransparency(255);
        rateStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        rateStyle.setMargin(Component.BOTTOM, 1);

        rateStyle.setMargin(Component.TOP, 1);

        rateStyle.setMargin(Component.LEFT, 10);
        rateStyle.setMargin(Component.RIGHT, 10);
        
        rate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int id= rep.getId_reclamation();
                new rate_reclamation(current,id).show();
            }
        });
            cnt1.addAll( descl, imagel,rate);
            //cnt2.addAll(recl, cnt1);
            cnt1r.addAll(Contenu,image);
            cnt2r.addAll(rec,cnt1r,recl, cnt1);
            addAll(cnt2r);
           
        }
        

        //System.out.println("a :"+a );
        //add(sp);
        
    }
}
