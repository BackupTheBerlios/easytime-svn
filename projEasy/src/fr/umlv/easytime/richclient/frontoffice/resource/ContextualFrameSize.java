/* 
 * Project easytime
 * ContextualFrameSize.java - package fr.umlv.easytime.richclient.frontoffice.resource;
 * Creator: Administrateur
 * Created on 6 janv. 2005 13:16:40
 *
 * Person in charge: fgarac
 */
package fr.umlv.easytime.richclient.frontoffice.resource;

import java.awt.Dimension;


/**
 * @author fgarac
 *
 * Class responsible for defining the size of the contextual frame 
 *
 */
public class ContextualFrameSize {
    public static int width = 600;
    public static int height = 400;
    public static Dimension dimension = null;
    static{dimension = new Dimension(width, height);}
}
