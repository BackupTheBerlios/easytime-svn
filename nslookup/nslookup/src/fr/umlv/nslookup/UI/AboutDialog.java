/* 
 * Project nslookup
 * AboutDialog.java - package fr.umlv.nslookup.UI;
 * Creator: Mathias Loyen
 * Created on 22 févr. 2005 22:01:14
 *
 * Person in charge: Mathias Loyen
 */
package fr.umlv.nslookup.UI;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Mathias Loyen
 *
 * Class responsible for displaying the "about" dialog box.
 *
 */
public class AboutDialog extends JDialog implements ActionListener {
    private static final long serialVersionUID = 3906090052923767096L;
    JPanel panel1 = new JPanel(){
        
        private static final long serialVersionUID = 3978425802029217333L;
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;
            Paint p = g2d.getPaint();
            //g2d.setPaint(new GradientPaint(0,0,Color.WHITE,0,getHeight(),Color.BLUE,false));
            g2d.setPaint(Color.white);
            g2d.fillRect(0,0,getWidth(),getHeight());
            
        }
        
    };
    JPanel panel2 = new JPanel();
    JPanel insetsPanel1 = new JPanel();
    JPanel insetsPanel2 = new DefilPanel();
    
    JButton button1 = new JButton();
    ImageIcon imgIg2000;
    ImageIcon imgLogo;
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
        imgLogo = new ImageIcon(MainFrame.class.getResource("icons/logo.jpg"));
        imgIg2000 = new ImageIcon(MainFrame.class.getResource("icons/ig2000.jpg"));
        this.setSize(437,200);
        this.setTitle("A propos de NSLookup");
        setResizable(false);
        panel1.setLayout(borderLayout1);
        panel2.setLayout(borderLayout2);
        insetsPanel1.setLayout(flowLayout1);
        insetsPanel2.setLayout(flowLayout1);
        insetsPanel2.setPreferredSize(new Dimension(400, 200));
        insetsPanel2.setOpaque(false);
        insetsPanel2.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        button1.setText("Ok");
        button1.addActionListener(this);
        panel2.setPreferredSize(new Dimension(400, 200));
        insetsPanel1.setPreferredSize(new Dimension(320, 37));
        this.getContentPane().add(panel1, BorderLayout.WEST);
        panel1.add(panel2, BorderLayout.CENTER);
        panel1.add(new JLabel(imgIg2000), BorderLayout.WEST);
        panel1.add(new JLabel(imgLogo), BorderLayout.EAST);
        panel1.setBackground(new Color(255,255,255,255));
        
        
        panel2.add(insetsPanel2, BorderLayout.WEST);
        panel1.add(insetsPanel1, BorderLayout.SOUTH);
        insetsPanel1.add(button1, null);
        insetsPanel1.setBackground(Color.WHITE);
        setUndecorated(true);
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

/**
 * @author Mat
 *
 * Class responsible for showing a scrolling text in a panel.
 *
 */
class DefilPanel extends JPanel implements Runnable{
    
    
    private static final long serialVersionUID = 3257568425210755122L;
    
    private final ImageIcon sergio = new ImageIcon(MainFrame.class.getResource("icons/mid1.gif"));
    
    /** The messages **/
    private final String[] messages = {
            "NS Lookup, l'explorateur de Naming Service",
            "",
            "Projet de Corba",
            "Ingénieurs 2000 - IR3 - Février 2005 ",
            "",
            "Romain JOURDAN, Mathias LOYEN, Jonathan VALDES",
            "",
            "Encadré par Serge MIDONNET",
    "Serge.Midonnet@univ-mlv.fr"};
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
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run(){
        currentY=this.getHeight();
        while(!Thread.interrupted())
            try{repaint();
            Thread.sleep(30);
            currentY--;
            }catch (InterruptedException e){};
    }
    
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        Paint p = g2d.getPaint();
        g2d.setPaint(new GradientPaint(0,0,Color.WHITE,0,getHeight(),new Color(86,141,231),false));
        //g2d.setPaint(new Color(255,255,255,0));
        
        g2d.fillRoundRect(0,0,getWidth(),getHeight(),30,15);
        g2d.setPaint(p);
        g2d.setPaint(new GradientPaint(0,0,Color.WHITE,0,getHeight(),Color.BLACK,false));
        g.setFont(new Font("Arial", Font.BOLD, 14));
        FontMetrics fontMetrics = g2d.getFontMetrics();
        int fontHeight = fontMetrics.getHeight();
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
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
        int theX = (this.getWidth()-sergio.getIconWidth())/2;
        g.drawImage(sergio.getImage(),theX,theY,null);
        theY += sergio.getIconHeight();
        
        if(theY < 0)
            currentY=this.getHeight() + fontHeight; 
        //g.setFont(new Font("Monospaced", Font.BOLD, 14));
    }
    
}

