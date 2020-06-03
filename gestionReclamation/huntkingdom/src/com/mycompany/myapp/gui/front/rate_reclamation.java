/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.entities.fosUser.Reclamation;
import com.mycompany.myapp.entities.fosUser.Utilisateur;
import com.mycompany.myapp.services.reclamationService;

/**
 *
 * @author belkis
 */
public class rate_reclamation extends Form{
     Form current;
     public rate_reclamation(Form previous, Utilisateur user,int id){
         current = this;
        setTitle("Noter une réclamtion");
        setLayout(new FlowLayout(CENTER, CENTER));
        Reclamation r = new Reclamation();
        r.setId_reclamation(id);
        Style reclamer = getAllStyles();
        reclamer.setBgColor(0xccff99);
//reclamer.setBgImage(MyApplication.theme.getImage("b.jpg"));
        getToolbar().addMaterialCommandToLeftBar("back",
                FontImage.MATERIAL_BACKUP, ev -> {
                    new afficher_reclamations(current, user).show();
                });
        getToolbar().addCommandToOverflowMenu("Exit",
                null, ev -> {
                    Display.getInstance().exitApplication();
                });

      
                    Slider ra = createStarRankSlider();

                    Button done = new Button("done");
                    done.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                           
                            r.setNote(ra.getProgress());
                            System.out.println(ra.getProgress()+" "+r);
                           if (new reclamationService().rateReclamation(r)) {
                            Dialog.show("Succés", "Reclamation notée", new Command("OK"));
                           new afficher_reclamations(current, user).show();
                           
                        }

                        }
                    });
                   addAll(FlowLayout.encloseCenter(ra,done));
     }
     
      public void initStarRankStyle(Style s, Image star) {
        s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
        s.setBorder(Border.createEmpty());
        s.setBgImage(star);
        s.setBgTransparency(0);
    }

    public Slider createStarRankSlider() {
        Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(5);
        Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
                derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
        Style s = new Style(0xffff33, 0, fnt, (byte) 0);
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        s.setOpacity(100);
        s.setFgColor(0);
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
        initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
        initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
        initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
        starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
        System.out.println("star" + starRank);
        return starRank;
    }

    public void showStarPickingForm() {
        Form hi = new Form("Star Slider", new FlowLayout(CENTER, CENTER));
        Slider r = createStarRankSlider();

        Button done = new Button("done");
        done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("stars" + r.getProgress());

            }
        });
        // Dialog.show("Reclamation notée", "Vous avez noté votre réclamation", new Command("OK"));
        hi.addAll(FlowLayout.encloseCenter(r, done));
        hi.show();

        //System.out.println(createStarRankSlider());
    }
}
