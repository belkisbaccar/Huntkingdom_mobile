/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.Tabs;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.entitie.evenement;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.gui.front.login;
import com.mycompany.myapp.services.eventService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hazem
 */
public class afficheevent extends Form{
    Form current;
        
        static evenement b=new evenement();
       
Utilisateur l=new Utilisateur();
             
             ArrayList<evenement> list2=new ArrayList<>();

   public afficheevent(Form previous) {
      current=this;
      Style eventStyle= getAllStyles();
        eventStyle.setBgColor(0xCD853F);
        setTitle("evenement");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new crudevent(current).show();});
         getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
         /**************/
         /*******************************************************************************************/
            Label a = new Label("Vos Evenement");
         a.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        a.getAllStyles().setFgColor(0xA0522D);
        Container c=new Container(new FlowLayout(Container.CENTER));
        c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        add(c);
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
/***********************************************************************************/
         
        
         ArrayList<evenement> liste=eventService.getInstance().getAllevents(login.t.getId());

  
         Style s3=getAllStyles();
  
      
            /*************************************/
                           Container listss = new Container(BoxLayout.y());
   
                           
        Container lists = new Container(BoxLayout.y());
           for(evenement c1 : liste) {
            listss.add(createCoursContainer(c1));
        }
      /*************************/

        //listss.setScrollableY(true);
          
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,900);

        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
                      t.setUIID("Tab");
                     
        t.addTab("evenement", listss);
t.setScrollableY(true);

         add(t);
       

        
        
                 
     // lists.setScrollableY(true);
       
  
        }
        private Container createCoursContainer(evenement plat) {
                
            Button bt=new Button("modifier");
            Style butStylebn=bt.getAllStyles();

butStylebn.setFgColor(0x000000);
                Button bt1=new Button("X");
                Style butStylebbn=bt1.getAllStyles();

butStylebbn.setFgColor(0x000000);

           // Label name = new Label(imgserv);
Label image1 = new Label("image");
               Label titre1 = new Label("titre");
            Label description1 = new Label("description");
            Label datedebut1 = new Label("date debut");
            Label datefin1 = new Label("date fin"); 
            Label nb1 = new Label("nombre de place");
            Label titre = new Label("");
            Label description = new Label("");
            Label datedebut = new Label("");
            Label datefin = new Label("");
            Label nb = new Label("");
          String url="http://localhost/hunt/groupee/symfony2/web/imagesEvent/"+plat.getImage();
                System.out.println(url);

                 ImageViewer imgv;
             Image imge;
             EncodedImage enc;

             enc=EncodedImage.createFromImage(theme.getImage("ba.jpg"), false);
                imge=URLImage.createToStorage(enc, url, url);




                imgv=new ImageViewer(imge);
           
           

            Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xA0522D);
        cnt.getStyle().setBgTransparency(255);
           // name.getAllStyles().setBgTransparency(0);
        //name.getAllStyles().setFgColor(0xB1D7E8);
          // name.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
            //email.getAllStyles().setBgTransparency(0);
        titre.getAllStyles().setFgColor(0x000000);
        description.getAllStyles().setFgColor(0x000000);
        datedebut.getAllStyles().setFgColor(0x000000);
        datefin.getAllStyles().setFgColor(0x000000);
        nb.getAllStyles().setFgColor(0x000000);
       
       // b=plat;
        cnt.add(image1);
        cnt.add(imgv);
            cnt.add(titre1);
            cnt.add(titre);
            cnt.add(description1);
            cnt.add(description);
            cnt.add(datedebut1);
            cnt.add(datedebut);
            cnt.add(datefin1);
            cnt.add(datefin);
            cnt.add(nb1);
            cnt.add(nb);
           
           
        //cnt.setScrollVisible(true);
        Style st=cnt.getAllStyles();
        st.setMargin(Component.BOTTOM,2);
        Stroke borderStroke = new Stroke(2, Stroke.CAP_BUTT, Stroke.JOIN_MITER, 1);

         // name.setText(person.getNom()+" "+person.getPrenom() );
            titre.setText(plat.getTitre_event());
            description.setText(plat.getDescription_event());
            datedebut.setText(plat.getDate_debut_event());
            datefin.setText(plat.getDate_fin_event());
           
            int h=plat.getNb_place_event();
            String hh=String.valueOf(h);
            nb.setText(hh);
            //plat.setIdUser(login.t.getId());
            System.err.println(plat.getIdUser());
           Container c4=BoxLayout.encloseX(bt,bt1);
  bt1.addActionListener(e->{ 
                list2=eventService.getInstance().supprimerevent(plat.getId_event());
           list2=eventService.getInstance().getAllevents(login.t.getId());
                    Dialog.show("Success", "Voulez-vous supprimer cette evenement?", new Command("OK"));

        cnt.remove();
        c4.remove();
    });
    
bt.addActionListener(e->{
                b=plat;
                new modifierevent(current).show();});
        
            /***************************/
            return BorderLayout.center(cnt).
                add(BorderLayout.EAST,c4);
        }

    
}
