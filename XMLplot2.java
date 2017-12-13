
/*

    **** XMLplot2.java ****

Read an XML file containing vector coordinates for a shape,
and plot the shape (see also PlotShape.java).

Usage:
javac XMLplot2.java
java  XMLplot2 shapefile.xml

Author: John M. Weiss, Ph.D.
Edited: Krey Warshaw
Class:  CSC468 GUI Programming
Date:   Spring 2017

Modifications:
170127 - Replaced Vector with ArrayList (similar but preferred).
       - Specified element type using generics, which allows compile-time type checking.
       - Use polyline of points rather than doubles.
       - Use polyline struct instead of arraylist of points
       - take boneinfo hash and add bounding points
       - make x/y Min/Max track the overall for all files
       - turn it inside out, most variables are public
*/

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.*;
//import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Point2D;

public class XMLplot2 extends JFrame
{
    public static double xMax = -1000, yMax = -1000;    // Maximum x-,y-coordinates
    public static double xMin = 50000, yMin = 50000;    // Minimum x-,y-coordinates
    
    // Array list of vectors from parsed from .xml files
    public static ArrayList<Polyline> polylines = new ArrayList<Polyline>();
    
    // Default list of ID's
    public static DefaultListModel files = new DefaultListModel();
    
    // Used with files list to open "<bone_id>".xml file
    public static String FilePath;
    private static HashMap<String, BoneInfo> BoneHash;

/**
 * Plots the onto the images on the bones onto the Jpanel for visual display
 * using the Hash that holds all bone data.
 * @param var - list of files for getting MORE information on bones for drawing
 * @param Args - the file directory path
 * @param Bones  - The HashMap holding the Object with all the Date on Bones
 */
    public XMLplot2(DefaultListModel var, String Args, HashMap<String, BoneInfo> Bones)//DefaultListModel var)
    {
        FilePath = Args;
        files = var;
        BoneHash = Bones;
        processFiles();
        pack();
    }
/**
 * Recursively reads the .xml files for plotting on the display
 * 
 * @param root - node holding the current directory with all the xml files
 * @param ID   - holds the ID or the post of the .xml for finding information
 */
    // read polyline data from XML file
    private void readPolylines( Node root, String ID )
    {
        Polyline line = new Polyline();
        line.ID = ID;
        double tempxMin, tempyMin, tempxMax, tempyMax = 0;
        // bounding box extents are given by xymin and xymax
        if ( root.getNodeName().equals( "xymin" ) )
        {
            Scanner sc = new Scanner( root.getTextContent().trim() );
            tempxMin = Double.parseDouble(sc.next());
            tempyMin = Double.parseDouble(sc.next());
            if(tempxMin < xMin)
                xMin = tempxMin;
            if(tempyMin < yMin)
                yMin = tempyMin;
            //Saves
            BoneHash.get(ID).setXmin(tempxMin);
            BoneHash.get(ID).setYmin(tempyMin);
        }
        else if ( root.getNodeName().equals( "xymax" ) )
        {
            Scanner sc = new Scanner( root.getTextContent().trim() );
            tempxMax = Double.parseDouble(sc.next());
            tempyMax = Double.parseDouble(sc.next());
            if(tempxMax > xMax)
                xMax = tempxMax;
            if(tempyMax > yMax)
                yMax = tempyMax;
            BoneHash.get(ID).setXmax(tempxMax);
            BoneHash.get(ID).setYmax(tempyMax);
        }

        // polylines consist of a sequence of (x,y) coordinates
        // store these in a vector for display
        else if ( root.getNodeName().equals( "polyline" ) )
        {
            //ArrayList<Point2D.Double> v = new ArrayList<Point2D.Double>();
            NodeList list = root.getChildNodes();
            //Polyline line = new Polyline();
            
            for ( int i = 0; i < list.getLength(); i++ )
            {
                Node elem = list.item( i );
                if ( elem.getNodeName().equals( "xy" ) )
                {
                    Scanner sc = new Scanner( elem.getTextContent().trim() );
                    double x = (Double.parseDouble(sc.next()));// - xMin ) / scale;
                    double y = (Double.parseDouble(sc.next()));// - yMin ) / scale;
                    Point2D.Double p = new Point2D.Double( x, y );
                    line.point.add( p );
                }
            }
            polylines.add( line );
        }

        // recursively visit children
        NodeList list = root.getChildNodes();
        for ( int i = 0; i < list.getLength(); i++ )
        {
            readPolylines( list.item( i ), ID );
        }
    }
    
/**
 * Process Files for later usage and information on the bones.
 *
 */
    public void processFiles() {
        for(int i = 0; i < files.size(); i++){
            try
            {
                // get root node of XML document
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(FilePath + files.getElementAt(i) + ".xml");
                Element root = document.getDocumentElement();

                // read and store XML data
                readPolylines(root, (String)files.getElementAt(i) );
            }
            catch ( Exception e ) { System.out.println( e.toString() ); }
        }
    }
    
/**
 * @returns BoneHash for use other places 
 */
    public HashMap<String, BoneInfo> getHash()
    {
        return BoneHash;
    }
}

