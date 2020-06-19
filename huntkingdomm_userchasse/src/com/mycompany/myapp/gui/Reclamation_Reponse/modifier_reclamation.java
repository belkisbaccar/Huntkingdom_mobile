/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.Reclamation_Reponse;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
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
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.services.reclamationService;
import com.twilio.Twilio;
import java.io.IOException;

/**
 *
 * @author belkis
 */
public class modifier_reclamation extends Form{
    Form current;
     public static final String ACCOUNT_SID = "ACd133f6219bb4c58abee84fa46d92b4dc";
  public static final String AUTH_TOKEN = "03092fa7f788be25d7505d3ac0cf7a97";
    public modifier_reclamation(Form previous,int id){
         UserSession n = UserSession.getInstance();
        current = this;
        setTitle("Modifier une réclamtion");
        setLayout(BoxLayout.y());
        Reclamation r = new Reclamation();
        r.setId_reclamation(id);
        Style reclamation = getAllStyles();
    
        reclamation.setBgImage(MyApplication.theme.getImage("2.jpg")); 
//reclamer.setBgImage(MyApplication.theme.getImage("b.jpg"));
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new afficher_reclamations(current).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

        TextArea tfDescription = new TextArea("Description de la réclamation");

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
                r.setImage(reponse.substring(3, reponse.length()-1));
                
            }
        });

NetworkManager.getInstance().addToQueueAndWait(cr);
});  
        Style userStyle = tfDescription.getAllStyles();
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
        
        Button btnValider = new Button("Réclamer");

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
                if ((tfDescription.getText().length() == 0) || (tfImage.getText().length() == 0) ) {
                    Dialog.show("Alert", "SVP , Veulliez remplir les champs", new Command("OK"));
                } else {
                    try {

                        r.setDescription(tfDescription.getText());
                        
                        r.setId_user(n.getId());
                        if (new reclamationService().updateReclamation(r)) {
                            //Dialog.show("Succés", "Reclamation modifiée", new Command("OK"));
                            //new afficher_reclamations(current, user).show();
//                            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
//                new com.twilio.type.PhoneNumber("+21623831858"),
//                new com.twilio.type.PhoneNumber("+12015946415"),
//                "Vous avez modifié une de vos réclamation")
//            .create();

                         //    System.out.println(message.getSid());  
                        } else {
                            Dialog.show("Erreur", "Erreur de serveur", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {

                        Dialog.show("Erreur", "Vous avez entré un champs érroné", new Command("OK"));
                    }
                    
                     ToastBar.Status status = ToastBar.getInstance().createStatus();
                 status.setMessage("Réclamation modifiée");
                 status.setMessageUIID("Title");
                 //Image i = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentCustomStyle(null, null));
                // status.setIcon(i);
                 status.setExpires(2000);
                 status.show();
                }
            }
        });
        addAll(tfDescription, tfImage, v1, btnValider);
    }
}
