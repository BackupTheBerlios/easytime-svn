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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

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
    private GridBagConstraints c;
    //final JLabel cours;
    final JTextPane cours;
    
    private void makeDay(int i, boolean last){
        JLabel l = new JLabel("jour" +(i+1));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        c.gridx=i+1;
        if (last)
            c.gridwidth = GridBagConstraints.REMAINDER;
        grid.setConstraints(l,c);
        back.add(l);
    }
    
    private void makeDivs(int i, boolean last){
        JLabel l = new JLabel("division" +(i+1));
        l.setBorder(BorderFactory.createLineBorder(Color.RED));
                
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
        
        c = new GridBagConstraints();
        c.fill= GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 0;
        
        for(int i=0;i<nbJours-1;i++)
            makeDay(i,false);
        makeDay(nbJours-1,true);

        c.gridx = 0;
        c.gridwidth = 1;
        c.weightx = 0;
        c.weighty = 1;
        
        for(int i=0;i<nbDivisions-1;i++)
            makeDivs(i,false);
        makeDivs(nbDivisions-1,true);
        
        
        cours=new JTextPane();
        cours.setEditable(false);
        
        
		cours.setText("test pour voir si ça déchire");
		//cours = new JLabel("<html>test qui tue grave</html>");
		cours.setPreferredSize(new Dimension(0,0));
		
		
        //cours.setHorizontalAlignment(JLabel.CENTER);
        //JButton cours=new JButton("cours de test");
        //cours.setHorizontalAlignment(JLabel.CENTER);
        
        cours.setBorder(BorderFactory.createLineBorder(Color.RED));
        //GridBagConstraints c = new GridBagConstraints();
        //c.fill = GridBagConstraints.BOTH;
        
        
        c.gridx=3;
        c.gridy=7;
        c.gridheight=4;
        c.gridwidth=1;
        grid.setConstraints(cours,c);
        
        back.add(cours);
        dndMouseMotionListener d = new dndMouseMotionListener(cours,grid);
        cours.addMouseListener(d);
        cours.addMouseMotionListener(d);
        
        JButton b = new JButton("Switch");
        b.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cours.setVisible(! cours.isVisible());
				System.out.println(cours.getWidth());
				
				
			}
		
		
		
        });
        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.gridwidth=1;
        c.weightx = 0;
        c.weighty = 0;
        grid.setConstraints(b,c);
        back.add(b);
        
        
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
