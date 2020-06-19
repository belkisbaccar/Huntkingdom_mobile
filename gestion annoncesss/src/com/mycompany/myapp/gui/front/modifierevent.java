/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.TOP;
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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.MyApplication;
import static com.mycompany.myapp.MyApplication.theme;
import com.mycompany.myapp.services.eventService;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author hazem
 */
public class modifierevent extends Form{
       Form current;
  String l="";
  private String imgName = "";
  
    public modifierevent(Form previous) {
   
        current=this;
        Style eventStyle= getAllStyles();
        eventStyle.setBgColor(0xCD853F);
        setTitle(" evenement");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new afficheevent(current).show();});
         getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
  /*******************************************************************************************/
            Label a = new Label("modifier evenement");
         a.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        a.getAllStyles().setFgColor(0xA0522D);
        Container c=new Container(new FlowLayout(Container.CENTER));
        c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        c.getAllStyles().setMargin(Component.BOTTOM,4);
        add(c);
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
/***********************************************************************************/
        Button image = new Button("import");
        image.getAllStyles().setMargin(Component.TOP,200);
        image.getAllStyles().setMargin(Component.BOTTOM,300);
String url="http://localhost/hunt/groupee/symfony2/web/imagesEvent/"+afficheevent.b.getImage();
                System.out.println(url);
                 ImageViewer imgv;
                 Image imge;
                 EncodedImage enc;
                 enc=EncodedImage.createFromImage(theme.getImage("ba.jpg"), false);
                 imge=URLImage.createToStorage(enc, url, url);
                 imgv=new ImageViewer(imge);
                 MultipartRequest cr = new MultipartRequest();
      image.addActionListener((evt) -> {
    String  filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
  
        String urll = "http://127.0.0.1/hunt/groupee/symfony2/web/uploadd.php";
cr.setUrl(urll);
cr.setPost(true);
String mime="image/jpeg";
        try {
            cr.addData("file", filePath, mime);
        } catch (IOException ex) {
            
        }
cr.setFilename("file", "MyImage.jpg");//any unique name you want

cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String reponse = new String(cr.getResponseData());
                System.out.println(reponse.substring(3, reponse.length()-1));
              imgName=reponse.substring(3, reponse.length()-1);
              afficheevent.b.setImage(imgName);
                
            }
        });

NetworkManager.getInstance().addToQueueAndWait(cr);
});     
        
/***********************************************************************************/

        Label titre  =new Label("titre :");
         TextField titre1  =new TextField(afficheevent.b.getTitre_event());
        titre.getAllStyles().setMargin(Component.BOTTOM,120);

        titre1.getAllStyles().setMargin(Component.BOTTOM,2);

        Style butStylee=titre1.getAllStyles();
        butStylee.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        titre.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   titre1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   titre.getAllStyles().setFgColor(0x000000);
titre1.getAllStyles().setFgColor(0x000000);

/***********************************************************************************/

        Label desc  =new Label("description :");
         TextArea desc1  =new TextArea(afficheevent.b.getDescription_event());
        desc.getAllStyles().setMargin(Component.BOTTOM,120);

        desc1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyle=desc1.getAllStyles();
        butStyle.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        desc.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   desc1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   desc1.getAllStyles().setFont(Font.createSystemFont(TOP, TOP, 500));
   desc.getAllStyles().setFgColor(0x000000);
desc1.getAllStyles().setFgColor(0x000000);
/***********************************************************************************/

        Label dated  =new Label("date debut :");
         
         Picker date1 = new Picker();
      date1.setType(Display.PICKER_TYPE_DATE);
        dated.getAllStyles().setMargin(Component.BOTTOM,120);
date1.setText(afficheevent.b.getDate_debut_event());
        date1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyled=desc1.getAllStyles();
        butStyled.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        dated.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   date1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   dated.getAllStyles().setFgColor(0x000000);
date1.getAllStyles().setFgColor(0x000000);
/***********************************************************************************/

       Label datef  =new Label("date fin :");
         Picker datef1 = new Picker();
      datef1.setType(Display.PICKER_TYPE_DATE);
      datef1.setText(afficheevent.b.getDate_debut_event());
        datef.getAllStyles().setMargin(Component.BOTTOM,120);

        datef1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStylef=desc1.getAllStyles();
        butStyled.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        datef.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   datef1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   datef.getAllStyles().setFgColor(0x000000);
datef1.getAllStyles().setFgColor(0x000000);

    /**************************************************************************************************/             
                        Button valider = new Button("modifier");
Style butStyleb=valider.getAllStyles();
butStyleb.setBorder(RoundRectBorder.create().
        strokeColor(0xA0522D).
        strokeOpacity(120).
        stroke(borderStroke));
butStyleb.setBgColor(0xA0522D);
butStyleb.setFgColor(0x000000);
butStyleb.setBgTransparency(255);
butStyleb.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyleb.setMargin(Component.BOTTOM, 3);       

          butStyleb.setMargin(Component.TOP,2);  
              
          butStyleb.setMargin(Component.LEFT,10);  
           butStyleb.setMargin(Component.RIGHT,10); 
                //cnt5.add(btnval);
          

     
  /**************************************************************************************************/   

                Container cnt3=new Container(new FlowLayout(Container.CENTER));
/***********************************************************************************/
Container c1=BoxLayout.encloseY(image,titre,desc,dated,datef);

Container c3=BoxLayout.encloseY(imgv,titre1,desc1,date1,datef1);


setScrollableY(false);

cnt3.add(valider);
Container c4=BoxLayout.encloseX(c1,c3);

c.getAllStyles().setMargin(Component.BOTTOM,10);
c4.getAllStyles().setMargin(Component.TOP,0);
c4.getAllStyles().setMargin(Component.LEFT,50);
c4.getAllStyles().setMargin(Component.RIGHT,50);
c4.getStyle().setBgColor(0xA0522D);
c4.getStyle().setBgTransparency(255);

                
      valider.addActionListener(e->{
 afficheevent.b.setTitre_event(titre1.getText());         
afficheevent.b.setDescription_event(desc1.getText());
String result = StringUtil.replaceAll(date1.getText(), "/", "-");
  afficheevent.b.setDate_debut_event(result);
String resultt = StringUtil.replaceAll(datef1.getText(), "/", "-");
  afficheevent.b.setDate_fin_event(resultt);
  afficheevent.b.setImage(afficheevent.b.getImage());
  
if(eventService.getInstance().modifierevents(afficheevent.b))
{                            Dialog.show("Success","evenement modifié ",new Command("OK"));


} else                             Dialog.show("ERROR", "Server error", new Command("OK"));

});                      
addAll(c4,cnt3);
/***********************************************************************************/
  /*******************************************************************************************/       
         /*********************************/
          

    

    }
}
