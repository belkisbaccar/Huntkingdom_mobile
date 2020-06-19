/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.gui.login.acceuil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
/**
 *
 * @author azizm
 */
public class historique  extends Form {
    Form current;
    public historique (Form previous,List f) {
      current=this;
        setTitle("historique");
        System.out.println(f);
        setLayout(BoxLayout.y());
         getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new acceuil(current).show();});
          getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
          
    TextField tf = new TextField("", "File Name", 20, TextField.ANY);
        TextArea body = new TextArea(5, 20);
         for(int i=0; i<f.size(); i++){
        body.setHint(f.get(i).toString());}
        Command ok = new Command("OK");
        Command cancel = new Command("Cancel");
        Command result = Dialog.show("File Name", BorderLayout.north(tf).add(BorderLayout.CENTER, body), ok, cancel);
        if(ok == result) {
            try(OutputStream os = Storage.getInstance().createOutputStream(tf.getText())) {
                  for(int i=0; i<f.size(); i++){
                os.write(f.get(i).toString().getBytes("UTF-8"));}
                createFileEntry(current, tf.getText());
                current.getContentPane().animateLayout(250);
            } catch(IOException err) {
                Log.e(err);
            }
        }
   
    
    for(String file : Storage.getInstance().listEntries()) {
       Storage.getInstance().deleteStorageFile("logo-decathlon.jpg");
        createFileEntry(current, file);
    }
    current.show();
}

private void createFileEntry(Form hi, String file) {
   Label fileField = new Label(file);
   Button delete = new Button();
   Button view = new Button();
   FontImage.setMaterialIcon(delete, FontImage.MATERIAL_DELETE);
   FontImage.setMaterialIcon(view, FontImage.MATERIAL_OPEN_IN_NEW);
   Container content = BorderLayout.center(fileField);
   int size = Storage.getInstance().entrySize(file);
   content.add(BorderLayout.EAST, BoxLayout.encloseX(new Label(size + "bytes"), delete, view));            
   delete.addActionListener((e) -> {
       Storage.getInstance().deleteStorageFile(file);
       content.setY(hi.getWidth());
       hi.getContentPane().animateUnlayoutAndWait(150, 255);
       hi.removeComponent(content);
       hi.getContentPane().animateLayout(150);
   });         
   view.addActionListener((e) -> {
       try(InputStream is = Storage.getInstance().createInputStream(file)) {
           String s = Util.readToString(is, "UTF-8");
           Dialog.show(file, s, "OK", null);
       } catch(IOException err) {
           Log.e(err);
       }
   });
   hi.add(content);
}}
