/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.Annonces;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.entities.Annonces.Annonce;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.annonceService;

import java.io.IOException;

/**
 *
 * @author belkis
 */
public class modifier_annonce extends Form{
    Form current;
    public modifier_annonce(Form previous,int id){
        
         UserSession n = UserSession.getInstance();
        current = this;
        setTitle("Modifier une annonce");
        setLayout(BoxLayout.y());
        Annonce a = new Annonce();
        a.setId_annonce(id);
        Style annonce = getAllStyles();
    
        annonce.setBgImage(MyApplication.theme.getImage("2.jpg")); 
//reclamer.setBgImage(MyApplication.theme.getImage("b.jpg"));
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new consulter_annonce(current).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

        TextArea tfText= new TextArea("Text de l'annonce");

    ImageViewer v1 = new ImageViewer();
        MultipartRequest cr = new MultipartRequest();
        Button tfImage = new Button("select Image");
        tfImage.addActionListener((evt) -> {
    String  filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
     
        String url = "http://localhost/hunt/groupee/symfony2/web/uploadRec.php";
cr.setUrl(url);
cr.setPost(true);
String mime="image/jpeg";
        try {
              Image vv= Image.createImage(filePath);
    v1.setImage(vv);
            cr.addData("file", filePath, mime);
        } catch (IOException ex) {
            
        }
cr.setFilename("file", "MyImage.jpg");//any unique name you want

cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponse = new String(cr.getResponseData());
                
                System.out.println(reponse.substring(3, reponse.length()-1));
                a.setImage(reponse.substring(3, reponse.length()-1));
                
            }
        });

NetworkManager.getInstance().addToQueueAndWait(cr);
});  
        Style userStyle = tfText.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        userStyle.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        userStyle.setBgColor(0xffffff);
        userStyle.setBgTransparency(255);
        userStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);

        userStyle.setMargin(Component.TOP, 10);

        Style userStylei = tfImage.getAllStyles();
        Stroke borderStrokei = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        userStylei.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStrokei));
        userStylei.setBgColor(0xffffff);
        userStylei.setBgTransparency(255);
        userStylei.setMarginUnit(Style.UNIT_TYPE_DIPS);
        userStylei.setMargin(Component.BOTTOM, 1);
        userStylei.setMargin(Component.TOP, 1);
        
        Button btnValider = new Button("Modifier");

        Style butStyle = btnValider.getAllStyles();
        butStyle.setBorder(RoundRectBorder.create().
                strokeColor(0xCD853F).
                strokeOpacity(120)
        );
        butStyle.setBgColor(0xCD853F);
        butStyle.setFgColor(0x000000);
        butStyle.setBgTransparency(255);
        butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStyle.setMargin(Component.BOTTOM, 3);

        butStyle.setMargin(Component.TOP, 10);

        butStyle.setMargin(Component.LEFT, 10);
        butStyle.setMargin(Component.RIGHT, 10);
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfText.getText().length() == 0) || (tfImage.getText().length() == 0) ) {
                    Dialog.show("Alert", "SVP , Veulliez remplir les champs", new Command("OK"));
                } else {
                    try {

                        a.setText(tfText.getText());
                        
                        a.setUsername(n.getId());
                        if (new annonceService().updateAnnonce(a)) {
                            Dialog.show("Succés", "annonce modifiée", new Command("OK"));
                            new consulter_annonces(current).show();
                            
                           
                        } else {
                            Dialog.show("Erreur", "Erreur de serveur", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {

                        Dialog.show("Erreur", "Vous avez entré un champs érroné", new Command("OK"));
                    }
                    
                    
                }
            }
        });
        addAll(tfText, tfImage, v1, btnValider);
    }
}
