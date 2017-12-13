
/*
    **** XMLdump.java ****

Read and dump contents of XML file, without a priori knowledge of structure.

Usage:
javac XMLdump.java
java  XMLdump file.xml

Author: John M. Weiss, Ph.D.
Class:  CSC468 GUI Programming
Date:   Spring 2017

*/

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLdump
{
/** Starting from the beginning
 * 
 * @param args main For building the entire project  
 */
    public static void main( String [] args )
    {
        // check usage
        if ( args.length == 0 )
        {
            System.out.println( "Usage: java XMLdump file.xml" );
            return;
        }

        // read and parse XML document
        try
        {
            // get root node of XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse( args[0] );
            Element root = document.getDocumentElement();

            // DOM tree traversal
            visitChildNodes( root, "" );
            System.out.println();
        }
        catch ( Exception e ) { System.out.println( e.toString() ); }
    }

    

    
/**
 *  recursive (preorder) traversal of DOM tree
 *  indent prints spaces to show hierarchical structure
 * @param root  - hold position for traversal
 * @param indent - directory
 */    
    private static void visitChildNodes( Node root, String indent )
    {
        // print element name
        if ( root.getNodeType() == Node.ELEMENT_NODE )
        {
            System.out.println();
            System.out.print( indent + root.getNodeName() + ": " );
        }
        // print element contents (text)
        else if ( root.getNodeType() == Node.TEXT_NODE )
        {
            String s = root.getTextContent().trim();
            if ( s.length() > 0 ) System.out.print( root.getTextContent() );
        }

        // print element attributes, if any
        if ( root.hasAttributes() )
        {
            NamedNodeMap attrs = root.getAttributes();
            for ( int i = 0 ; i < attrs.getLength(); i++ )
            {
                Attr attribute = ( Attr )attrs.item( i );     
                System.out.print( "(" + attribute.getName() + "=" + attribute.getValue() + ") " );
            }
        }

        // recursively visit children
        NodeList list = root.getChildNodes();
        for ( int i = 0; i < list.getLength(); i++ )
        {
            visitChildNodes( list.item( i ), indent + "   "  );
        }
    }
}

