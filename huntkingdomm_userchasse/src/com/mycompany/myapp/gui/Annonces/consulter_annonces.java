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
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import com.mycompany.myapp.gui.Reclamation_Reponse.modifier_reclamation;
import com.mycompany.myapp.gui.front.annonce;
import com.mycompany.myapp.gui.front.reclamation;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.annonceService;
import com.mycompany.myapp.services.reclamationService;
import java.util.ArrayList;

/**
 *
 * @author abdelhalid
 */
public class consulter_annonces extends Form{
    
    Form current;
public consulter_annonces(Form previous){
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
        re = annonceService.getInstance().getAllAnnonces(n.getId());
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
           
            Button update = new Button("Modifier l'annonce");
        Style updStyle5 = update.getAllStyles();
        updStyle5.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        updStyle5.setBgColor(0xCD853F);
        updStyle5.setFgColor(0x000000);
        updStyle5.setBgTransparency(255);
        updStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
        updStyle5.setMargin(Component.BOTTOM, 3);

        updStyle5.setMargin(Component.TOP, 1);

        updStyle5.setMargin(Component.LEFT, 10);
        updStyle5.setMargin(Component.RIGHT, 10);
        
        Button delete = new Button("Supprimer l'annonce");
        Style delStyle5 = delete.getAllStyles();
        delStyle5.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        delStyle5.setBgColor(0xCD853F);
        delStyle5.setFgColor(0x000000);
        delStyle5.setBgTransparency(255);
        delStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
        delStyle5.setMargin(Component.BOTTOM, 3);

        delStyle5.setMargin(Component.TOP, 1);

        delStyle5.setMargin(Component.LEFT, 10);
        delStyle5.setMargin(Component.RIGHT, 10);
        
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int id= rel.getId_annonce();
                System.out.println("id "+id);
                new modifier_annonce(current,id).show();
            }
        });
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int id= rel.getId_annonce();
                System.out.println("id "+id);
                Annonce a = new Annonce();
                a.setId_annonce(id);
                new annonceService().deleteAnnonce(a);
                new consulter_annonces(current).show();
            }
        });
        
            cnt1.addAll( desc, image,update,delete);
            cnt2.addAll(rec, cnt1);
            add(cnt2);

        }

        //System.out.println("a :"+a );
        //add(sp);
    }

}
