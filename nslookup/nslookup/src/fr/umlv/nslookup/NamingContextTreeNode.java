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

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingType;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

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
    //private 
    private int type;
    private String host;
    private String port;
    public static final DataFlavor TREENODE_FLAVOR = new DataFlavor(NamingContextTreeNode.class, "NCTreeNode"); 
    
    public NamingContextTreeNode(Binding b){
        super(b.binding_name[0].id);
        System.out.println(b.binding_name[0].kind);
        this.binding = b;
        
        if(binding.binding_type.equals(BindingType.ncontext))
            this.type=TYPE_CONTEXT;
        else
            this.type=TYPE_OBJECT;

    }
    
    public NamingContextTreeNode(String host, String port){
        super(host+" "+port);
        this.host = host;
        this.port = port;
        this.binding = null;
        this.type=TYPE_NS;
        
    }
    
    public NamingContextTreeNode(String s, int type){
        super(s);
        
        this.binding = null;
        this.type=TYPE_ROOT;
        
    }

    public String getHost(){
        
        switch(type){
        	case(TYPE_ROOT): return null; 
        	case(TYPE_NS):   return host; 
        	default:		 return ((NamingContextTreeNode)getParent()).getHost();        
        }
    }
    
    public String getPort(){
        
        switch(type){
        	case(TYPE_ROOT): return null; 
        	case(TYPE_NS):   return port; 
        	default:		 return ((NamingContextTreeNode)getParent()).getPort();        
        }
    }
    
    
    public NamingContext getParentContext(){
    	
    	
    	
    	NamingContext namingContext = null;
    	switch(type)
		{    	
    		case (TYPE_CONTEXT):
    		{
    			namingContext =  (NamingContext)((NamingContextTreeNode)getParent()).getNodeObject();
    			break;
    		}
    		case (TYPE_OBJECT):
    		{
    			namingContext =  (NamingContext)((NamingContextTreeNode)getParent()).getNodeObject();
    			break;
    		}
    		case (TYPE_NS):
    			return null;
    		case (TYPE_ROOT):
				return null;    	
		}
		return namingContext;
    }
    
    public Object getNodeObject(){
    	
    	NamingContext nc = null;
    	
    	if(type==TYPE_ROOT) return null;
    	if(type==TYPE_NS) 
    	{
			String[] args = {"-ORBInitialPort",getPort(),"-ORBInitialHost",getHost()}; 
			ORB orb = ORB.init(args, null);
			try {
				nc = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
			} catch (InvalidName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nc;
		}    	
    	else
    	{
    	nc = getParentContext();
    	Object o = null;
    	if(nc !=null)
			try {
				o = nc.resolve(binding.binding_name);
			} catch (NotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CannotProceed e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return o;
    	}
    }
    
    public void unbind(){
    	
    }
    
    public void bind(NamingContext nc){
    	
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
