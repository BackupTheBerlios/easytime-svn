/* 
 * Project nslookup
 * ContextTreeNode.java - package fr.umlv.nslookup;
 * Creator: Mat
 * Created on 9 févr. 2005 11:35:58
 *
 * Person in charge: Mat
 */
package fr.umlv.nslookup;

import javax.swing.tree.DefaultMutableTreeNode;

import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingType;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NamingContextTreeNode extends DefaultMutableTreeNode {

    public static final int TYPE_CONTEXT = 1;
	public static final int TYPE_OBJECT = 2;
	public static final int TYPE_ROOT = 0;
	
	
    private Binding binding;
    private int type;
    
    public NamingContextTreeNode(Binding b){
        super(b.binding_name[0].id);
        
        this.binding = b;
        if(binding.binding_type.equals(BindingType.ncontext))
            this.type=TYPE_CONTEXT;
        else
            this.type=TYPE_OBJECT;

    }
    
    public NamingContextTreeNode(String s){
        super(s);
        
        this.binding = null;
        this.type=TYPE_ROOT;
        
    }

    public int getType() {
        
        return this.type;
    }

}
