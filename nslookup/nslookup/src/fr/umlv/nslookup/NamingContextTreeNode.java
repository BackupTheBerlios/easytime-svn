/* 
 * Project nslookup
 * ContextTreeNode.java - package fr.umlv.nslookup;
 * Creator: Mat
 * Created on 9 févr. 2005 11:35:58
 *
 * Person in charge: Mat
 */
package fr.umlv.nslookup;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.tree.DefaultMutableTreeNode;

import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingType;

/**
 * @author Mat
 *
 * "This [abstract|immmutable|private|...] class does ..." or "Class responsible for doing..."
 *
 */
public class NamingContextTreeNode extends DefaultMutableTreeNode implements Transferable {

    public static final int TYPE_NS = 1;
    public static final int TYPE_CONTEXT = 2;
	public static final int TYPE_OBJECT = 3;
	public static final int TYPE_ROOT = 0;
	
	
    private Binding binding;
    private int type;
    public static final DataFlavor TREENODE_FLAVOR = new DataFlavor(NamingContextTreeNode.class, "NCTreeNode"); 
    
    public NamingContextTreeNode(Binding b){
        super(b.binding_name[0].id);
        
        this.binding = b;
        if(binding.binding_type.equals(BindingType.ncontext))
            this.type=TYPE_CONTEXT;
        else
            this.type=TYPE_OBJECT;

    }
    
    public NamingContextTreeNode(String s, int type){
        super(s);
        
        this.binding = null;
        this.type=type;
        
    }

    public int getType() {
        
        return this.type;
    }

    /* (non-Javadoc)
     * @see java.awt.datatransfer.Transferable#getTransferDataFlavors()
     */
    public DataFlavor[] getTransferDataFlavors() {
        final DataFlavor[] tmp = {TREENODE_FLAVOR};
        return tmp;
    }

    /* (non-Javadoc)
     * @see java.awt.datatransfer.Transferable#isDataFlavorSupported(java.awt.datatransfer.DataFlavor)
     */
    public boolean isDataFlavorSupported(DataFlavor df) {
        return (df.equals(TREENODE_FLAVOR));
    }

    /* (non-Javadoc)
     * @see java.awt.datatransfer.Transferable#getTransferData(java.awt.datatransfer.DataFlavor)
     */
    public Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException {
        if(df.equals(TREENODE_FLAVOR)) return this;
        else throw new UnsupportedFlavorException(df);
    }

}
