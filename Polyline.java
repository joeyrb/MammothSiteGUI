import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Author: Krey Warshaw
 * Basically I miss structs and this is my solution to hold a polyline and 
 * an associated ID
 */
public class Polyline {
    public ArrayList<Point2D.Double> point;
    public String ID;
    
    Polyline(){
        point = new ArrayList<Point2D.Double>(); //Array for points of min/max
        ID = new String();                       //String of ID
    }
}
