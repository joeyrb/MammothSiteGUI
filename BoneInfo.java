
import java.awt.Color;
import java.awt.Point;

/*
 * A class that holds all the Bone infor directly read in from the .xml
 * chosen by the user. Holds Year, Taxon, Element, SubElement, Completeness,
 * Gender, Remarks, DateFound, Elevation, ObjectId, Shape, xMin, xMax, yMin,
 * yMax, and clr for drawing.
 */


public class BoneInfo {
    private int Year;
    private String Taxon;
    private int Element;
    private String SubElement;
    private String Completeness;
    private String Gender;
    private String Remarks;
    private String DateFound;
    private double Elevation;
    private int ObjectId;
    private double Shape;
    private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;
    private Color clr;
    
/**
 * Default constructor for BoneInfo (used for adding walkway to 
 */
    public BoneInfo(){
        
    }
    
    public BoneInfo(int yr, String tx, int ele, 
                    String sub, String cmplts, String sex,
                    String rmks, String dtef, double elvat,
                    int objid, double shpe){
        Year = yr;
        Taxon = tx;
        Element = ele;
        SubElement = sub;
        Completeness = cmplts;
        Gender = sex;
        Remarks = rmks;
        DateFound = dtef;
        Elevation = elvat;
        ObjectId = objid;
        Shape = shpe;
        SetColor(new Color(45, 65, 23)); 
    }
    String AllInfo(){
        String Temp;
        Temp = ("Year: " + Year 
                + " \nTaxon: " + Taxon 
                + " \nElement: " + Element 
                + " \nSubElement: " + SubElement 
                + " \nCompleteness: " + Completeness 
                + " \nGender: " + Gender 
                + " \nRemarks: " + Remarks
                + " \nDateFound: "+ DateFound 
                + " \nElevation: " + Elevation 
                + " \nObjectId: " + ObjectId 
                + " \nShape: " + Shape);
        return Temp;
    }
    int GetYear(){
     return Year;   
    }
    String GetTaxon(){
        return Taxon;
    }
    int GetEle(){
        return Element;
    }
    String GetSub(){
        return SubElement;
    }
    String GetCompl(){
            return Completeness;
    }
    String GetSex(){
        return Gender;
    }
    String GetRmks(){
        return Remarks;
    }
    String GetDateFound(){
        return DateFound;
    }
    double GetElevation(){
        return Elevation;
    }
    int GetObjId(){
        return ObjectId;
    }
    double GetShape(){
        return Shape;
    }
    Color GetColor(){
        return clr;
    }
    void SetColor(Color colr){
        clr = colr;
    }
    void setXmin(double temp){
        xMin = temp;
    }
    void setXmax(double temp){
        xMax = temp;
    }
    void setYmax(double temp){
        yMax = temp;
    }
    void setYmin(double temp){
        yMin = temp;
    }
    public Point getCentroid(){
       int x, y;
       x = (int) ((xMin + xMax)/2);
       y = (int) ((yMin + yMax)/2);
       return new Point(x, y);
    }
    
    
    //checks if a point is within the area of the bone
    public boolean checkBounds(double x, double y){
        if(x > xMax || x < xMin)
            return false;
        if(y > yMax || y < yMin)
            return false;
        return true;
    }
}