
/*

    **** PlotShape2.java ****

Given a vector containing shape coordinates, plot the shape.

Author: John M. Weiss, Ph.D.
Edited: Krey Warshaw
Class:  CSC468 GUI Programming
Date:   Spring 2017

Modifications:
170127 - Replaced Vector with ArrayList (similar but preferred).
       - Specified element type using generics, which allows compile-time type checking.
       - Use polyline of points rather than doubles.
       - implemented drawing colors
       - implemented usage of the Polyline class with the BoneInfo Hash
       - implemented selective drawing according to detail
*/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.Point2D;

public class PlotShape2 extends JPanel
{
    private static int MaxSize;
    private ArrayList<Polyline> polylines;
    private double xDim, yDim, xM, yM;
    private int xSize, ySize;
    private double scale;
    private HashMap<String, BoneInfo> lookup;
    private int MaxDetail;

    // constructor sets basic plotting parameters
    public PlotShape2( ArrayList<Polyline> v, double xMin, double xMax, 
            double yMin, double yMax, int zoom, 
            HashMap<String, BoneInfo> BoneID, int detail )
    {
        MaxDetail = detail;
        MaxSize = zoom;
        polylines = v;
        xM = xMin;
        yM = yMin;
        xDim = xMax - xMin;
        yDim = yMax - yMin;
        scale =  (xDim > yDim) ? xDim : yDim; 
        xSize = xDim > yDim ? MaxSize : ( int )( MaxSize * xDim / yDim );
        ySize = yDim > xDim ? MaxSize : ( int )( MaxSize * yDim / xDim );
        lookup = BoneID;
    }

    // paintComponent() is the display callback function
    // this is called automatically when the window needs to be redrawn
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        // for each polyline
        for ( Polyline line : polylines )
        {
            //colors the walkway black
            if(line.ID == "walkway"){
                g.setColor(Color.BLACK);
            }
            //ignores any bones that are greater than the detail limit
            if(line.ID != "walkway" && lookup.get(line.ID).GetEle() > MaxDetail)
                continue;
            //sets color according to stored color
            else{
                g.setColor(lookup.get(line.ID).GetColor());
            }
            // connect the dots
            boolean firstpoint = true;
            double x1 = 0.0, y1 = 0.0;
            for ( Point2D.Double p : line.point )
            {
                double x2 = (p.x - xM)/scale;
                double y2 = (p.y - yM)/scale;
                if ( firstpoint )
                    firstpoint = false;
                else
                    g.drawLine( ( int ) ( x1 * MaxSize ), ySize - ( int ) ( y1 * MaxSize ),
                                ( int ) ( x2 * MaxSize ), ySize - ( int ) ( y2 * MaxSize ) );
                x1 = x2;
                y1 = y2;
            }
        }
    }

    // set initial panel size
    public Dimension getPreferredSize()
    {
        return new Dimension( xSize, ySize );
    }
}


