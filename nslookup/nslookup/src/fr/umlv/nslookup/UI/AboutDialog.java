/* 
 * Project nslookup
 * AboutDialog.java - package fr.umlv.nslookup.UI;
 * Creator: Mat
 * Created on 22 févr. 2005 22:01:14
 *
 * Person in charge: Mat
 */
package fr.umlv.nslookup.UI;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class AboutDialog extends JDialog implements ActionListener {
    
    
	
    

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel insetsPanel1 = new JPanel();
        JPanel insetsPanel2 = new DefilPanel();
        JButton button1 = new JButton();
        ImageIcon imageIcon;
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        BorderLayout borderLayout1 = new BorderLayout();
        BorderLayout borderLayout2 = new BorderLayout();
        FlowLayout flowLayout1 = new FlowLayout();
        FlowLayout flowLayout2 = new FlowLayout();
        String product = "NS Lookup";
        String version = "1.0";
        String copyright = "Copyright (c) 2005 R. Jourdan, M. Loyen, J. Valdes";
        String comments = "Programme permettant d'explorer et manipuler les naming services Corba";
        int j=0;
        public AboutDialog(Frame parent) {
          super(parent);
          enableEvents(AWTEvent.WINDOW_EVENT_MASK);
          try {
            jbInit();
          }
          catch(Exception e) {
            e.printStackTrace();
          }
          //imageControl1.setIcon(imageIcon);
          pack();
        }

        private void jbInit() throws Exception  {
          //imageIcon = new ImageIcon(getClass().getResource("[Your Image]"));
          this.setSize(320,180);
          this.setTitle("A propos de NSLookup");
          setResizable(false);
          panel1.setLayout(borderLayout1);
          panel2.setLayout(borderLayout2);
          insetsPanel1.setLayout(flowLayout1);
          insetsPanel2.setLayout(flowLayout1);
          insetsPanel2.setBorder(new EmptyBorder(10, 10, 10, 10));
          insetsPanel2.setPreferredSize(new Dimension(320, 200));
          label1.setText(product);
          label2.setText(version);
          label3.setText(copyright);
          label4.setText(comments);
          button1.setText("Ok");
          button1.addActionListener(this);
          panel2.setPreferredSize(new Dimension(200, 100));
          insetsPanel1.setPreferredSize(new Dimension(320, 37));
          this.getContentPane().add(panel1, BorderLayout.WEST);
          panel1.add(panel2, BorderLayout.NORTH);
          panel2.add(insetsPanel2, BorderLayout.WEST);
          //insetsPanel3.add(label1, null);
          //insetsPanel3.add(label2, null);
          //insetsPanel3.add(label3, null);
          //insetsPanel3.add(label4, null);
          panel1.add(insetsPanel1, BorderLayout.SOUTH);
          insetsPanel1.add(button1, null);

        }
        protected void processWindowEvent(WindowEvent e) {
          if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            cancel();
          }
          super.processWindowEvent(e);
        }

        void cancel() {
          dispose();
        }

        public void actionPerformed(ActionEvent e) {
          if (e.getSource() == button1) {
            cancel();
          }
        }
      }

class DefilPanel extends JPanel implements Runnable{
    
	
	/** The messages **/
	private final String[] messages = {
	        "NS Lookup, l'explorateur de Naming Service",
	        "",
	        "Projet de Corba",
	        "Ingénieurs 2000 - IR3 - Février 2005 ",
	        "",
	        "Romain JOURDAN , Mathias LOYEN, Jonathan VALDES",
	        "",
	        "Encadré par Serge MIDONNET"};
    int currentY;
    boolean start = true;
    private Thread runner;
    public DefilPanel()
    {super();
      start();
    }
    public void start(){
        if(runner == null)
          {runner = new Thread(this);
          runner.start();
        }
      }
    public void stop(){
      runner.interrupt();
      runner = null;
    }

    public void run(){
    currentY=this.getHeight();
    while(!Thread.interrupted())
        try{repaint();
        Thread.sleep(50);
        currentY--;
        }catch (InterruptedException e){};
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g; 	            
        FontMetrics fontMetrics = g2d.getFontMetrics();
        int fontHeight = fontMetrics.getHeight();
        
        if(start)
        {
            start = false;
            currentY=this.getHeight() + fontHeight;
        }
        
        
        int theY = currentY;
        
        for(int i=0;i<messages.length;i++)
        {
            String text = messages[i];
            text=text.trim();
            int len = fontMetrics.stringWidth(text);
            
            int theX = (this.getWidth()-len)/2;
            g.drawString(text,theX,theY);
            theY += fontHeight;
        }
        if(theY < 0)
            currentY=this.getHeight() + fontHeight; 
        //g.setFont(new Font("Monospaced", Font.BOLD, 14));
        
      }

}

