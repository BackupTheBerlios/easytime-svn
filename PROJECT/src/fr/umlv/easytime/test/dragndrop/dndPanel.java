/* 
 * Project easytime
 * dndPanel.java - package fr.umlv.easytime.test.dragndrop;
 * Creator: Mat
 * Created on 30 déc. 2004 13:51:22
 *
 * Person in charge: Mat
 */
package fr.umlv.easytime.test.dragndrop;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class dndPanel {
    
    private JPanel back;
    private JButton but1 = new JButton("ok 1");
    private GridBagLayout grid; 
    private int nbJours;
    private int nbDivisions;
    
    private void makeDay(int i, boolean last){
        JLabel l = new JLabel("jour" +(i+1));
        l.setBorder(BorderFactory.createLineBorder(Color.RED));
        GridBagConstraints c = new GridBagConstraints();
        c.fill= GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridx=i+1;
        if (last)
            c.gridwidth = GridBagConstraints.REMAINDER;
        grid.setConstraints(l,c);
        back.add(l);
    }
    
    private void makeDivs(int i, boolean last){
        JLabel l = new JLabel("division" +(i+1));
        l.setBorder(BorderFactory.createLineBorder(Color.RED));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
                
        c.gridy=i+1;
        if (last)
            c.gridheight = GridBagConstraints.REMAINDER;
        grid.setConstraints(l,c);
        back.add(l);
    }
    
    public dndPanel(){
        nbJours = 5;
        nbDivisions = 20;
        grid = new GridBagLayout();
        back = new JPanel(grid);
        
        for(int i=0;i<nbJours-1;i++)
            makeDay(i,false);
        makeDay(nbJours-1,true);

        for(int i=0;i<nbDivisions-1;i++)
            makeDivs(i,false);
        makeDivs(nbDivisions-1,true);
        
        JLabel cours=new JLabel("cours de test");
        cours.setHorizontalAlignment(JLabel.CENTER);
        cours.setBorder(BorderFactory.createLineBorder(Color.RED));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx=2;
        c.gridy=7;
        c.gridheight=4;
        //c.weighty = 1.0;
        //c.weightx = 1.0;
        grid.setConstraints(cours,c);
        back.add(cours);
        dndMouseMotionListener d = new dndMouseMotionListener(cours,grid);
        cours.addMouseListener(d);
        cours.addMouseMotionListener(d);
        
        
        
        //back.setLayout(new G)
        //back.setBackground(Color.BLUE);
    }
    /**
     * @return Returns the back.
     */
    public JPanel getBack() {
        return back;
    }
}
