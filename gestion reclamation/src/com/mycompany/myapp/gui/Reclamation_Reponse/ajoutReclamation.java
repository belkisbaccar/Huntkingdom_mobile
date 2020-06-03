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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.gui.login.acceuil;
import com.mycompany.myapp.services.reclamationService;
import com.mycompany.myapp.entities.Reclamation_Reponse.Reclamation;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.gui.front.ecommerce;
import com.mycompany.myapp.services.UserSession;
import com.mycompany.myapp.gui.front.reclamation;
import java.io.IOException;

/**
 *
 * @author hazem
 */
public class ajoutReclamation extends Form {

    Form current;

    public ajoutReclamation(Form previous,Float prod_id) {
        current = this;
         UserSession n = UserSession.getInstance();
        setTitle("Ajouter une réclamtion");
        setLayout(BoxLayout.y());
        Reclamation r = new Reclamation();
        Style reclamation = getAllStyles();
    
        reclamation.setBgImage(MyApplication.theme.getImage("2.jpg")); 
//reclamer.setBgImage(MyApplication.theme.getImage("b.jpg"));
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new ecommerce(current).show();
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
       // TextField tfProd = new TextField("", "l'id du produit a reclamer");
        //TextField tfUser = new TextField("", "votre id (user)");

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

//        Style userStylep = tfProd.getAllStyles();
//        Stroke borderStrokep = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
//        userStylep.setBorder(RoundRectBorder.create().
//                strokeColor(0).
//                strokeOpacity(120).
//                stroke(borderStrokep));
//        userStylep.setBgColor(0xffffff);
//        userStylep.setBgTransparency(255);
//        userStylep.setMarginUnit(Style.UNIT_TYPE_DIPS);
//        userStylep.setMargin(Component.BOTTOM, 1);
//        userStylep.setMargin(Component.TOP, 1);

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
        System.out.println("prod id "+prod_id);
        btnValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfDescription.getText().length() == 0) || (tfImage.getText().length() == 0) ) {
                    Dialog.show("Alert", "SVP , Veulliez remplir les champs", new Command("OK"));
                } else {
                    try {
int id = Math.round(prod_id) ;
                        r.setDescription(tfDescription.getText());
                        r.setId_produit(id);
                        r.setId_user(n.getId());
                        if (new reclamationService().addReclamation(r)) {
                            //Dialog.show("Succés", "Reclamation ajoutée", new Command("OK"));
 
                          /*  Message m = new Message("<html><body>Check out <a href=\"https://www.codenameone.com/\">Codename One</a></body></html>");
m.setMimeType(Message.MIME_HTML);
                            Display.getInstance().sendMessage(new String[]{user.getEmail()}, "Subject of message", m);*/
                            // System.out.println(success);
                        } else {
                            Dialog.show("Erreur", "Erreur de serveur", new Command("OK"));
                        }
                    } catch (NumberFormatException e) {

                        Dialog.show("Erreur", "Vous avez entré un champs érroné", new Command("OK"));
                    }
                }
                 ToastBar.Status status = ToastBar.getInstance().createStatus();
                 status.setMessage("Nouvelle réclamation");
                 status.setMessageUIID("Title");
                 //Image i = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentCustomStyle(null, null));
                // status.setIcon(i);
                 status.setExpires(2000);
                 status.show();
                 //return;
            }
        });

        addAll(tfDescription, tfImage, v1, btnValider);
    }

}
