/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.Annonces;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
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
import com.mycompany.myapp.entities.Annonces.Annonce;
import com.mycompany.myapp.gui.Reclamation_Reponse.modifier_reclamation;
import com.mycompany.myapp.gui.front.annonce;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.annonceService;
import java.util.ArrayList;

/**
 *
 * @author abdelhamid
 */
public class consulter_annonce extends Form{//sans user
     Form current;
public consulter_annonce(Form previous){
    UserSession n = UserSession.getInstance();
        setTitle("Mes annonces");
        Style annonce = getAllStyles();
    
        annonce.setBgImage(MyApplication.theme.getImage("2.jpg")); 
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new annonce(current).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

        SpanLabel sp = new SpanLabel();
        // sp.setText(reclamationService.getInstance().getAllReclamations().toString());

        ArrayList<Annonce> re = new ArrayList<>();
        re = annonceService.getInstance().getAllsAnnonces();
        Font largeBoldSystemFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);

        for (Annonce rel : re) {
            Container cnt2 = new Container(new FlowLayout(Container.CENTER));
            Container cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label rec = new Label("Annonce :");
            Style recstyle = rec.getAllStyles();
            recstyle.setFont(largeBoldSystemFont);
            recstyle.setFgColor(0x000000);
            recstyle.setMargin(Component.TOP, 1);

            
            Label desc = new Label();
            
            desc.setText(rel.getText());

            

            Style descstyle = desc.getAllStyles();
            descstyle.setFgColor(0x000000);
            descstyle.setMargin(Component.TOP, 1);
            //System.out.println(rel.getImage().substring(0,5));
            String path = "http://127.0.0.1/hunt/groupee/symfony2/web/images/" + rel.getImage() + "";
            EncodedImage encImg
                    = EncodedImage.createFromImage(theme.getImage("load.jpg"), false);

            URLImage imgUrl = URLImage.createToStorage(encImg, rel.getImage(), path);

            ImageViewer image = new ImageViewer();

            image.setImage(imgUrl);
           
            
        
            cnt1.addAll( desc, image);
            cnt2.addAll(rec, cnt1);
            add(cnt2);

        }

        //System.out.println("a :"+a );
        //add(sp);
    }

}
