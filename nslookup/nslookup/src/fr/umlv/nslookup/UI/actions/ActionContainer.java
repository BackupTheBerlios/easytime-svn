/* 
 * Project NSLookUPUI
 * ActionContainer.java - package UI.actions;
 * Creator: Jo
 * Created on 9 févr. 2005 16:22:26
 *
 * Person in charge: Jo
 */
package fr.umlv.nslookup.UI.actions;

import javax.swing.Action;

import fr.umlv.nslookup.UI.MainFrame;
import fr.umlv.nslookup.UI.NSLUMenuBar;


/**
 * @author Jo
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class ActionContainer {
	
	private MainFrame frame;
	
	public ActionContainer(MainFrame frame){
		this.frame = frame;
	}
	
	static{
		initDefault();
	}

    public static Action addNC;
    public static Action remNC;
    public static Action addOBJ;
    public static Action remOBJ;
    public static Action addORB;
    public static Action remORB;
    public static Action prop;
    public static Action option;
    public static Action help;
    public static Action about;
    public static Action quit;
    
    public static void initDefault(){
    	addNC = DefaultActionFactory.addNC;
        remNC= DefaultActionFactory.remNC;
        addOBJ= DefaultActionFactory.addOBJ;
        remOBJ= DefaultActionFactory.remOBJ;
        addORB= DefaultActionFactory.addORB;
        remORB= DefaultActionFactory.remORB;
        prop= DefaultActionFactory.prop;
        option= DefaultActionFactory.option;
        option.setEnabled(true);
        help= DefaultActionFactory.help;
        help.setEnabled(true);
        about= DefaultActionFactory.about;
        about.setEnabled(true);
        quit= DefaultActionFactory.quit;
        quit.setEnabled(true);
        
    }
    
    /**
     * 
     * Pickup all the source action values (NAME, LONG_DESCRIPTION, SHORT_DESCRIPTION, SMALL_ICON, ACCELERATOR_KEY)
     * and copy them to the target action.
     *
     * @param source
     * @param target
     */
    private void copyActionSkeleton(Action source, Action target){
        target.putValue(Action.NAME, source.getValue(Action.NAME));
        target.putValue(Action.LONG_DESCRIPTION, source.getValue(Action.LONG_DESCRIPTION));
        target.putValue(Action.SHORT_DESCRIPTION, source.getValue(Action.SHORT_DESCRIPTION));
        if(source.getValue(Action.SMALL_ICON)!=null) target.putValue(Action.SMALL_ICON, source.getValue(Action.SMALL_ICON));
        if(source.getValue(Action.ACCELERATOR_KEY)!=null) target.putValue(Action.ACCELERATOR_KEY, source.getValue(Action.ACCELERATOR_KEY));
        target.setEnabled(true);
    }
    
    public void setActions(Action addNC, Action remNC, Action addOBJ, Action remOBJ, Action addORB, Action remORB, Action prop){
    	
    	copyActionSkeleton(DefaultActionFactory.addNC, ActionContainer.addNC);
    	ActionContainer.addNC = addNC;
    	
    	copyActionSkeleton(DefaultActionFactory.remNC, ActionContainer.remNC);
    	ActionContainer.remNC = remNC;
    	
    	copyActionSkeleton(DefaultActionFactory.addOBJ, ActionContainer.addOBJ);
    	ActionContainer.addOBJ = addOBJ;
    	
    	copyActionSkeleton(DefaultActionFactory.remOBJ, ActionContainer.remOBJ);
    	ActionContainer.remOBJ = remOBJ;
    	
    	copyActionSkeleton(DefaultActionFactory.addORB, ActionContainer.addORB);
    	ActionContainer.addORB = addORB;
    	
    	copyActionSkeleton(DefaultActionFactory.remORB, ActionContainer.remORB);
    	ActionContainer.remORB = remORB;
    	
    	copyActionSkeleton(DefaultActionFactory.prop, ActionContainer.prop);
    	ActionContainer.prop = prop;
    	
    	frame.getToolBar().loadActions();
    	((NSLUMenuBar)frame.getJMenuBar()).loadActions();
    }
}
