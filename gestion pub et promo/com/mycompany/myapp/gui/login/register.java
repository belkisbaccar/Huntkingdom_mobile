/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.login;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
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
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.services.userService;
import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author walid
 */
public class register extends Form {
    Form current;
    String imageName="";
     public register(){
     
     current=this;
        setTitle("Register");
        setLayout(BoxLayout.y());
        Style loginStyle= getAllStyles();
        loginStyle.setBgColor(0xCD853F);
        getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_ARROW_BACK, ev->{new login().show();});
         Container cnt1=new Container(new FlowLayout(Container.CENTER));
                  Container cnt4=new Container(new FlowLayout(Container.CENTER));
        Container cnt5=new Container(new FlowLayout(Container.CENTER));

        Container cnt2=new Container(new FlowLayout(Container.CENTER));
        Container cnt3=new Container(new FlowLayout(Container.CENTER));
               
                
     /**************************************************************************************************/            
  Label Seconnecter = new Label("S'inscrire");
  Style connecterStyle=Seconnecter.getAllStyles();
  
 
  
      Font largeBoldSystemFont = Font.createSystemFont(Font.FACE_MONOSPACE, Font.STYLE_BOLD, Font.SIZE_LARGE);

  connecterStyle.setFont(largeBoldSystemFont);
connecterStyle.setFgColor(0x000000);
connecterStyle.setMargin(Component.TOP,130); 
connecterStyle.setMargin(Component.LEFT,280); 
connecterStyle.setMargin(Component.BOTTOM,3);
  
/**************************************************************************************************/ 

                        TextField Username = new TextField("", "saisir votre username");
                        Style userStyle = Username.getAllStyles();
Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
userStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
userStyle.setBgColor(0xffffff);
userStyle.setBgTransparency(255);
userStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
userStyle.setMargin(Component.BOTTOM, 3);       
          userStyle.setMargin(Component.TOP,10);                
      /**************************************************************************************************/  
                              TextField mail = new TextField("", "saisir votre mail");
                        Style userStylemail = mail.getAllStyles();
Stroke borderStroke1 = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
userStylemail.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(120).
        stroke(borderStroke));
userStylemail.setBgColor(0xffffff);
userStylemail.setBgTransparency(255);
userStylemail.setMarginUnit(Style.UNIT_TYPE_DIPS);
userStylemail.setMargin(Component.BOTTOM, 3);       
          userStylemail.setMargin(Component.TOP,1);                
      /**************************************************************************************************/  
                              Button bt = new Button("import image");
Style butStyle1=bt.getAllStyles();
butStyle1.setBorder(RoundRectBorder.create().
        strokeColor(0xA0522D).
        strokeOpacity(120).
        stroke(borderStroke));
butStyle1.setBgColor(0xA0522D);
butStyle1.setFgColor(0x000000);
butStyle1.setBgTransparency(255);
butStyle1.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle1.setMargin(Component.BOTTOM, 3);       

          butStyle1.setMargin(Component.TOP,1);  
              
          butStyle1.setMargin(Component.LEFT,2);  
           butStyle1.setMargin(Component.RIGHT,2); 
                //cnt5.add(btnval);
      
     /**************************************************************************************************/       
      
                        TextField tpassword = new TextField();
           Style passwordStyle = tpassword.getAllStyles();
passwordStyle.setBorder(RoundRectBorder.create().
        strokeColor(0).
        strokeOpacity(50).
        stroke(borderStroke));
passwordStyle.setBgColor(0xffffff);
passwordStyle.setBgTransparency(255);                
                        
                        tpassword.setHint("saisir votre mot de passe");
        tpassword.setConstraint(TextField.PASSWORD);
cnt2.addAll(Username,mail);
cnt3.add(tpassword);
              
    /**************************************************************************************************/             
                        Button btnval = new Button("valider");
Style butStyle=btnval.getAllStyles();
butStyle.setBorder(RoundRectBorder.create().
        strokeColor(0xA0522D).
        strokeOpacity(120).
        stroke(borderStroke));
butStyle.setBgColor(0xA0522D);
butStyle.setFgColor(0x000000);
butStyle.setBgTransparency(255);
butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle.setMargin(Component.BOTTOM, 3);       

          butStyle.setMargin(Component.TOP,10);  
              
          butStyle.setMargin(Component.LEFT,10);  
           butStyle.setMargin(Component.RIGHT,10); 
                //cnt5.add(btnval);
          
                
                
                
                userService us = userService.getInstance();
               
            
               
               ImageViewer pdp = new ImageViewer();
         
        Container CC =new Container(BoxLayout.xCenter());
addAll(Seconnecter,cnt2,cnt3,CC,bt,btnval,cnt5);   
btnval.addActionListener((evt) -> {
    String strong_salt = BCrypt.gensalt(13);
   String S= BCrypt.hashpw(tpassword.getText(),strong_salt);
   if(Username.getText().length()==0 || mail.getText().length()==0 ||tpassword.getText().length()==0 ||imageName.length()==0)
   Dialog.show("Error", "Remplir touts les champs ",new Command("ok"));
   else if(us.getUsercherche(Username.getText()))
         Dialog.show("Error", "username deja exisite ", new Command("ok"));
   else if(us.getUserchercheMail(mail.getText()))
       Dialog.show("Error", "mail deja exisite ", new Command("ok"));
   else if(tpassword.getText().length()< 8)
       Dialog.show("Error", "mot de passe < 8 ", new Command("ok"));
   else
   us.ajouterUser(Username.getText(),mail.getText(),S,imageName);
    Dialog.show("Valide", "user ajoute", new Command("ok"));
    new login().show();
});



     MultipartRequest cr = new MultipartRequest();
     bt.addActionListener((evt) -> {
         String filePath="";
      filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
    
        String url = "http://localhost/hunt/groupee/symfony2/web/upload.php";
cr.setUrl(url);
cr.setPost(true);
String mime="image/jpeg";

        try { 
         
    Image v = Image.createImage(filePath);
    v.scale(250,400);
            pdp.setImage(v);
            CC.removeAll();
            CC.add(pdp);
            revalidate();
          
            cr.addData("file", filePath, mime);
        } catch (IOException ex) {
            
        }
cr.setFilename("file", "MyImage.jpg");//any unique name you want

cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponse = new String(cr.getResponseData());
                imageName=reponse.substring(3,reponse.length()-1);
           
            }
        });

NetworkManager.getInstance().addToQueueAndWait(cr);
});
     
     }
    
}
