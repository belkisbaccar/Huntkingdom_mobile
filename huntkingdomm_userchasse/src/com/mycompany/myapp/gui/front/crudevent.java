        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.entitie.evenement;
import com.mycompany.myapp.services.eventService;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hazem
 */
public class crudevent extends Form{
     Form current;
  String l="";
  private String imgPath = "";
    private String imgName = "";
    boolean imageselected = false;
    public crudevent(Form previous) {
       current=this;
      Style eventStyle= getAllStyles();
        eventStyle.setBgColor(0xCD853F);
      eventService s = new eventService();
     
        
        setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new menuevent(current).show();});
         setTitle("Evenement");
         getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("affichage", 
                FontImage.MATERIAL_BACKUP, ev->{new afficheevent(current).show();});
          
/***********************************************************************************/
              Label a = new Label("Ajouter evenement");
         a.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        a.getAllStyles().setFgColor(0xA0522D);
        Container c=new Container(new FlowLayout(Container.CENTER));
        c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        add(c);
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
/***********************************************************************************/

        Label titre  =new Label("titre :");
         TextField titre1  =new TextField();
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

        Label image  =new Label("image :");
         
        image.getAllStyles().setMargin(Component.BOTTOM,120);

        image.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   image.getAllStyles().setFgColor(0x000000);
Button bt = new Button("import");
MultipartRequest cr = new MultipartRequest();
bt.addActionListener((evt) -> {
    String  filePath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
  
        String url = "http://127.0.0.1/hunt/groupee/symfony2/web/uploadd.php";
cr.setUrl(url);
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
                
            }
        });

NetworkManager.getInstance().addToQueueAndWait(cr);
});

 
  
/***********************************************************************************/

        Label desc  =new Label("description :");
         TextArea desc1  =new TextArea();
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
     // date1.setType(Display.PICKER_TYPE_DATE);
         date1.setDate(new Date());
        dated.getAllStyles().setMargin(Component.BOTTOM,120);

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
         
      //datef1.setType(Display.PICKER_TYPE_DATE);
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
/***********************************************************************************/

        Label nb  =new Label("nombre place  :");
         TextArea nb1  =new TextArea();
        nb.getAllStyles().setMargin(Component.BOTTOM,80);

        nb1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStylenb=desc1.getAllStyles();
        butStylenb.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        nb.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   nb1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   nb.getAllStyles().setFgColor(0x000000);
nb1.getAllStyles().setFgColor(0x000000);
    /**************************************************************************************************/             
                        Button valider = new Button("valider");
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
Container c1=BoxLayout.encloseY(titre,image,desc,dated,datef,nb);

Container c3=BoxLayout.encloseY(titre1,bt,desc1,date1,datef1,nb1);


setScrollableY(false);

cnt3.add(valider);
Container c4=BoxLayout.encloseX(c1,c3);

c.getAllStyles().setMargin(Component.BOTTOM,150);
c4.getAllStyles().setMargin(Component.TOP,10);
c4.getAllStyles().setMargin(Component.LEFT,50);
c4.getAllStyles().setMargin(Component.RIGHT,50);
c4.getStyle().setBgColor(0xA0522D);
c4.getStyle().setBgTransparency(255);

                
                        
addAll(c4,cnt3);
/***********************************************************************************/
valider.addActionListener(e->{
evenement ee=new evenement();
ee.setTitre_event(titre1.getText());

ee.setImage(imgName);
ee.setDescription_event(desc1.getText());
String result = StringUtil.replaceAll(date1.getText(), "/", "-");

ee.setDate_debut_event(result);
ee.setDate_fin_event(result);
ee.setNb_place_event(Integer.parseInt(nb1.getText()));
ee.setNb(ee.getNb_place_event());
ee.setEtat(0);
ee.setIdUser(login.t.getId());
Picker datee = new Picker();
     // datee.setType(Display.PICKER_TYPE_DATE);
      String dateenow = StringUtil.replaceAll(datee.getText(), "/", "-");

if(titre1.getText().length()==0 ||desc1.getText().length()==0 || date1.getText().length()==0 || datef1.getText().length()==0 || nb1.getText().length()==0 ){
 Dialog.show("failed","veuillez remplir le champ",new Command("OK"));

}
/*else if( date1.getText().compareTo(dateenow)> 0 )
{
     Dialog.show("failed","la date d'ajout est inferieur au date aujourd'huit ",new Command("OK"));
}
else if( date1.getText().compareTo(datef.getText())> 0 )
{
     Dialog.show("failed","la date d'ajout est superieur date fin ",new Command("OK"));
}*/
else {
eventService ev1= new eventService();
ev1.addevent(ee);
    System.out.println(ee);
                           Dialog.show("Success","ajout avec succes",new Command("OK"));

LocalNotification ln = new LocalNotification();
            ln.setId("LnMessage");
            ln.setAlertTitle("salut");
            ln.setAlertBody("merci d'aariver à huntkingdom!");
           
          Display.getInstance().scheduleLocalNotification( ln,
                System.currentTimeMillis() + 10 * 10, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency);
          );
                Dialog.show("Succès", "Une notification sera envoyée ", "Ok", null);}


});


    }
    
    
}
