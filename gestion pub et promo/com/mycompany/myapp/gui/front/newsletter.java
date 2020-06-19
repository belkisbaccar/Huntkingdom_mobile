/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.mycompany.myapp.services.PubliciteService;
import Publicite.Publicite_entite;
import Publicite.newsletter_entite;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.regex.RE;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.services.UserSession;
import java.util.List;

/**
 *
 * @author walid
 */
public class newsletter extends Form{
      Form current;
    
    public newsletter(Form previous) {
      current=this;
        setTitle("Newsletter");
        setLayout(BoxLayout.y());
        Style loginStyle= getAllStyles();

        
        loginStyle.setBgImage(MyApplication.theme.getImage("2.jpg")); 
        getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_ARROW_BACK, ev->{new acceuil(current).show();});
         getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
         TextField email = new TextField("", "E-Mail", 20, TextArea.EMAILADDR);
         CheckBox cb1 = new CheckBox("toutes les infos");
         CheckBox cb2 = new CheckBox("infos sur les promos");
         cb2.addActionListener((evt) -> {
             if(cb1.isSelected())
             {
               cb1.setSelected(false);
             }
             
                 
         });
         
          CheckBox cb3 = new CheckBox("infos sur les events");
            cb3.addActionListener((evt) -> {
             if(cb1.isSelected())
             {
               cb1.setSelected(false);
             }
             
                 
         });
                cb1.addActionListener((evt) -> {
             if(cb2.isSelected() && cb3.isSelected())
             {
               cb2.setSelected(false);
               cb3.setSelected(false);
             }
             
                 
         });
         Container c = new Container(BoxLayout.y());
         Style butStyle21=c.getAllStyles();
butStyle21.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle21.setBgColor(0xFFFFFF);
butStyle21.setFgColor(0x000000);
butStyle21.setBgTransparency(255);
butStyle21.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle21.setMargin(Component.BOTTOM, 3);       

          butStyle21.setMargin(Component.TOP,30);  
              
          
          butStyle21.setMargin(Component.LEFT,10);  
           butStyle21.setMargin(Component.RIGHT,10);
                       Button btnval2 = new Button("S'inscrire");
Style butStyle2=btnval2.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xCD853F);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle2.setMargin(Component.BOTTOM, 3);       

          butStyle2.setMargin(Component.TOP,10);  
              
          
          butStyle2.setMargin(Component.LEFT,10);  
           butStyle2.setMargin(Component.RIGHT,10);
           
              Button btnval3 = new Button("Consulter");
Style butStyle3=btnval3.getAllStyles();
butStyle3.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle3.setBgColor(0xCD853F);
butStyle3.setFgColor(0x000000);
butStyle3.setBgTransparency(255);
butStyle3.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle3.setMargin(Component.BOTTOM, 3);       

          butStyle3.setMargin(Component.TOP,40);  
              
          
          butStyle3.setMargin(Component.LEFT,10);  
           butStyle3.setMargin(Component.RIGHT,10); 
    /**************************************************************************************************/ 
               Button btnval4 = new Button("modifier");
Style butStyle4=btnval4.getAllStyles();
butStyle4.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle4.setBgColor(0xCD853F);
butStyle4.setFgColor(0x000000);
butStyle4.setBgTransparency(255);
butStyle4.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle4.setMargin(Component.BOTTOM, 3);       

          butStyle4.setMargin(Component.TOP,1);  
              
          
          butStyle4.setMargin(Component.LEFT,10);  
           butStyle4.setMargin(Component.RIGHT,10);
           
           
           
         PubliciteService ps= new PubliciteService();
       String count=ps.countPNews();
        System.out.println("wiouuuu "+count.substring(1,count.length()));
          UserSession n = UserSession.getInstance();
          List<newsletter_entite> tasks;
         newsletter_entite ns = new newsletter_entite();
          btnval2.addActionListener((evt) -> {
             int etat = 0;
             String mail=email.getText();
             if(cb1.isSelected())
                 etat=1;
              if (cb2.isSelected())
                 etat=2;
              if (cb3.isSelected())
              etat=3;
              if (cb3.isSelected()&& cb2.isSelected())
                 etat=4;
              Validator validator = new Validator();
RegexConstraint emailConstraint = new RegexConstraint("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$", "Invalid Email Address");
validator.addConstraint(email, emailConstraint);
      
              if(etat ==0 || mail.length()==0){
               
                ToastBar.showErrorMessage("verifier les champs");
              }
              else  if (!validator.isValid()) {
         ToastBar.showErrorMessage("verifier votre addresse mail");
       }
              else {
            ps.ajoutnews(n.getId(), etat, mail);
            ps.sendMailnews(mail,n.getUserName());
           new acceuil(current).show();}
          });
         if(ps.getNews(n.getId())){
             addAll(btnval3,btnval4);
            btnval3.addActionListener((evt) -> {
               new newsConsulter(current, ns).show();
            });
              tasks=ps.getnewsletter(n.getId());
              for(int i=0; i<tasks.size(); i++){
                ns.setId(tasks.get(i).getId());
                ns.setId_user(tasks.get(i).getId_user());
                ns.setEtat(tasks.get(i).getEtat());
                ns.setMail(tasks.get(i).getMail());
                 btnval4.addActionListener((evt) -> {
              Dialog d = new Dialog(BoxLayout.yCenter());
              email.setText(ns.getMail());
              CheckBox cb11 = new CheckBox("toutes les infos");
         CheckBox cb22 = new CheckBox("infos sur les promos");
         cb22.addActionListener((evt5) -> {
             if(cb11.isSelected())
             {
               cb11.setSelected(false);
             }
             
                 
         });
         
          CheckBox cb33 = new CheckBox("infos sur les events");
            cb33.addActionListener((evt5) -> {
             if(cb11.isSelected())
             {
               cb11.setSelected(false);
             }
             
                 
         });
                cb11.addActionListener((evt5) -> {
             if(cb22.isSelected() && cb33.isSelected())
             {
               cb22.setSelected(false);
               cb33.setSelected(false);
             }
             
                 
         });
              if(ns.getEtat()==1)
                  cb11.setSelected(true);
              if(ns.getEtat()==2)
                  cb22.setSelected(true);
              if(ns.getEtat()==3)
                   cb33.setSelected(true);
               if(ns.getEtat()==4)
               { cb33.setSelected(true);
               cb22.setSelected(true);}
              d.addAll(cb11,cb22,cb33,email);
             Button close =new Button("close");
             Button valider =new Button("valider");
             Container cb = new Container(BoxLayout.xCenter());
             cb.addAll(valider,close);
             
              
             close.addActionListener((evt1) -> {
                 
                 d.dispose();
                 d.removeAll();
             });
             valider.addActionListener((evt1) -> {
                  int etat = 0;
                  
             
             if(cb11.isSelected())
                 etat=1;
              if (cb22.isSelected())
                 etat=2;
              if (cb33.isSelected())
              etat=3;
              if (cb33.isSelected()&& cb22.isSelected())
                 etat=4;
                 ps.updatenews(ns.getId(),etat,email.getText());
                 ns.setEtat(etat);
                 ns.setMail(email.getText());
             });
             d.add(cb);
             d.show();
              
              
           });
              }
        
         }
         else {
             cb1.setSelected(true);
             
             c.addAll(cb1,cb2,cb3,email,btnval2);
             add(c);
             
             
             
         }
         
         
    }
}
