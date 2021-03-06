/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import javax.xml.parsers.*;
import java.io.File;
import javax.swing.event.ListSelectionEvent;
import org.w3c.dom.*;
import java.util.HashMap;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import javax.swing.filechooser.FileNameExtensionFilter;



/**
 *
 * @author 7110007
 */
public class MainWindow extends javax.swing.JFrame {

    // GLOBALS

    public String FilePath;             // filepath where bone.xml was located
    public String VectorMapPath;        // File path to update drawing vector map
    public int MapZoom;                 // Variable for scale of map zoom (use w/ slider)
    public int MapWindow;               // Default zoom distance
    public DefaultListModel listModel;  // Contains bone ID's
    public DefaultListModel<String> tempList;
    public DefaultListModel<Integer> YearModel;     // Int model for list for sorting bones
    public String IDT;                  //Holds the ID for the bones
    public int ObjectNumT;              //ext..
    public int YearT;
    public String TaxonT;
    public int ElementT;
    public String SubElementT;
    public String CompletenessT;
    public String GenderT;
    public String RemarksT;
    public String DateFoundT;
    public double ElevationT;
    public int ObjectIdT;
    public double ShapeT;
    public String ExpSideT;
    public boolean Flagin;
    public XMLplot2 parser; 
    public HashMap<String, BoneInfo> BoneID;
    public int detail;
    public JPanel vectorMap;

    
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        labelZoomTxt.setText("Zoom %: " + sliderZoom.getValue()*20);
        BoneID = new HashMap();
        listModel = new DefaultListModel();
        BoneID.put("walkway", new BoneInfo());
        listModel.addElement("walkway");
        detail = 15;
        MapWindow = 1000;
        MapZoom = MapWindow;
        vectorMap = new JPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ColorBG = new javax.swing.ButtonGroup();
        containerBoneList = new javax.swing.JScrollPane();
        ID = new javax.swing.JList<>();
        containerMapPan = new javax.swing.JScrollPane();
        sliderZoom = new javax.swing.JSlider();
        containerImagePane = new javax.swing.JScrollPane();
        labelZoomTxt = new javax.swing.JLabel();
        labelBoneList = new javax.swing.JLabel();
        labelBoneInfo = new javax.swing.JLabel();
        DetailSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaBoneInfo = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemImportData = new javax.swing.JMenuItem();
        ColorSchemeMenu = new javax.swing.JMenu();
        CompletenessRButton = new javax.swing.JRadioButtonMenuItem();
        GenderRButton = new javax.swing.JRadioButtonMenuItem();
        ElevationRbutton = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mammoth Site Dig Site");
        setLocationByPlatform(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        containerBoneList.setViewportView(ID);

        containerMapPan.setBackground(new java.awt.Color(255, 255, 255));
        containerMapPan.setDoubleBuffered(true);
        containerMapPan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                containerMapPanMouseClicked(evt);
            }
        });

        sliderZoom.setMinimum(1);
        sliderZoom.setValue(5);
        sliderZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderZoomStateChanged(evt);
            }
        });
       
        containerImagePane.setBackground(new java.awt.Color(0, 0, 0));
        containerImagePane.setBorder(null);

        labelZoomTxt.setText("Zoom: 0");

        labelBoneList.setText("Bone ID's");

        labelBoneInfo.setText("Bone Image");

        DetailSlider.setMaximum(15);
        DetailSlider.setMinimum(1);
        DetailSlider.setMinorTickSpacing(1);
        DetailSlider.setPaintLabels(true);
        DetailSlider.setPaintTicks(true);
        DetailSlider.setSnapToTicks(true);
        DetailSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DetailSliderStateChanged(evt);
            }
        });

        jLabel1.setText("Detail");

        textAreaBoneInfo.setColumns(20);
        textAreaBoneInfo.setLineWrap(true);
        textAreaBoneInfo.setRows(5);
        jScrollPane1.setViewportView(textAreaBoneInfo);

        menuFile.setText("File");
        menuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuFileMouseClicked(evt);
            }
        });

        menuItemImportData.setText("Import Data");
        menuItemImportData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemImportDataActionPerformed(evt);
            }
        });
        menuFile.add(menuItemImportData);

        menuBar.add(menuFile);

        ColorSchemeMenu.setText("Colors");

        ColorBG.add(CompletenessRButton);
        CompletenessRButton.setText("Completeness");
        CompletenessRButton.setToolTipText("{Red incomplete, Yellow Partially, Green Complete}");
        CompletenessRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                CompletenessRButtonStateChanged(evt);
            }
        });
        ColorSchemeMenu.add(CompletenessRButton);

        ColorBG.add(GenderRButton);
        GenderRButton.setText("Gender");
        GenderRButton.setToolTipText("{Red = Female, Cyan = Unknown, Purple = Guy}");
        GenderRButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GenderRButtonStateChanged(evt);
            }
        });
        ColorSchemeMenu.add(GenderRButton);

        ColorBG.add(ElevationRbutton);
        ElevationRbutton.setText("Elevation");
        ElevationRbutton.setToolTipText("{Light Cream low -> Red}");
        ElevationRbutton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ElevationRbuttonStateChanged(evt);
            }
        });
        ColorSchemeMenu.add(ElevationRbutton);

        menuBar.add(ColorSchemeMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelBoneList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(containerImagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(labelBoneInfo))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(containerBoneList, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containerMapPan)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelZoomTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DetailSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sliderZoom, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelBoneList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerBoneList, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelBoneInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerImagePane, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelZoomTxt)
                            .addComponent(DetailSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderZoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(containerMapPan, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void menuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuFileMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menuFileMouseClicked

    
/**
 * Gets Directory and finds the data to read into this project
 * @param evt
 */
    private void menuItemImportDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemImportDataActionPerformed
        JFileChooser fc = new JFileChooser();

        fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("XML Documents", "xml"));
        fc.setAcceptAllFileFilterUsed(true);
        if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION )
        {
            initBoneID(fc.getSelectedFile().getPath());
            FilePath= fc.getSelectedFile().getPath();
            int FilI = FilePath.lastIndexOf('/');
            FilePath = FilePath.substring(0, FilI + 1);
            VectorMapPath = FilePath;
            parseBones();
        }
    }//GEN-LAST:event_menuItemImportDataActionPerformed

/**
 * Does scrolling percentage wise for the display of the entire field
 * 
 * @param evt 
 */    
    private void sliderZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderZoomStateChanged
        // TODO: change the value of MapZoom and update map
        double xPercent = (double)containerMapPan.getHorizontalScrollBar()
                .getValue()/containerMapPan.getHorizontalScrollBar().getMaximum();
        
        double yPercent = (double)containerMapPan.getVerticalScrollBar()
                .getValue()/containerMapPan.getVerticalScrollBar().getMaximum();
        MapZoom = MapWindow * sliderZoom.getValue()/5;
        labelZoomTxt.setText("Zoom %: " + sliderZoom.getValue()*20);
        drawMap();
        // Move view port with the horizontal and vertical sliders
        //      
        containerMapPan.getHorizontalScrollBar().setValue((int)
                (xPercent*containerMapPan.getHorizontalScrollBar().getMaximum()));
        containerMapPan.getVerticalScrollBar().setValue((int)
                (yPercent*containerMapPan.getVerticalScrollBar().getMaximum()));
    }//GEN-LAST:event_sliderZoomStateChanged

/**
 * 
 * @param evt 
 */
    private void containerMapPanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_containerMapPanMouseClicked
        System.out.println(evt.getX() + ", " + evt.getComponent().getY());
    }//GEN-LAST:event_containerMapPanMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    
/**
 * If the Completeness is selected it changes the color of the bones dictated by
 * the CO, PC, or anything else.
 * @param evt 
 */
    private void CompletenessRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_CompletenessRButtonStateChanged
        double xPercent = (double)containerMapPan.getHorizontalScrollBar()
                .getValue()/containerMapPan.getHorizontalScrollBar()
                        .getMaximum();
        
        double yPercent = (double)containerMapPan.getVerticalScrollBar()
                .getValue()/containerMapPan.getVerticalScrollBar().getMaximum();
        
        if (CompletenessRButton.isSelected()){
            for (String key : BoneID.keySet()) {
                if ("walkway".equals(key))
                    continue;
                BoneInfo C = BoneID.get(key);
                if(C.GetCompl().equals("CO") ){
                    C.SetColor(new Color(0, 255, 0));
                }
                else if(C.GetCompl().equals("PC")){
                    C.SetColor(new Color(255, 255, 0));
                }
                else{
                    C.SetColor(new Color(255, 0, 0));}
            }
        }
        
        drawMap();// TODO add your handling code here:
        containerMapPan.getHorizontalScrollBar().setValue((int)
                (xPercent*containerMapPan.getHorizontalScrollBar().getMaximum()));
        containerMapPan.getVerticalScrollBar().setValue((int)
                (yPercent*containerMapPan.getVerticalScrollBar().getMaximum()));
    }//GEN-LAST:event_CompletenessRButtonStateChanged

/**
 * If the Gender is selected it changes the color of the bones dictated by the 
 * Gender. Male = Magenta, Female = Red, All others = Cyan
 * @param evt 
 */    
    private void GenderRButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GenderRButtonStateChanged
        double xPercent = (double)containerMapPan.getHorizontalScrollBar().
                getValue()/containerMapPan.getHorizontalScrollBar().getMaximum();
        double yPercent = (double)containerMapPan.getVerticalScrollBar().
                getValue()/containerMapPan.getVerticalScrollBar().getMaximum();
        
        if (GenderRButton.isSelected()){
            for(String key : BoneID.keySet()){
                if ("walkway".equals(key))
                    continue;
                BoneInfo G = BoneID.get(key);
                if(G.GetSex().equals( "MALE"))
                    G.SetColor(new Color(255,0, 0));
                else if(G.GetSex().equals("FEMALE"))
                    G.SetColor(new Color(255, 0, 255));
                else 
                    G.SetColor(new Color(0, 255, 255));        
            }
        }
        
        drawMap();// TODO add your handling code here:
        containerMapPan.getHorizontalScrollBar().setValue((int)
                (xPercent*containerMapPan.getHorizontalScrollBar().getMaximum()));
        containerMapPan.getVerticalScrollBar().setValue((int)
                (yPercent*containerMapPan.getVerticalScrollBar().getMaximum()));
    }//GEN-LAST:event_GenderRButtonStateChanged

/**
 * If the Elevation button is selected it changes the color of the bones dictated
 * by the height or elevation. From red to palish.
 * @param evt 
 */
    private void ElevationRbuttonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ElevationRbuttonStateChanged
        double xPercent = (double)containerMapPan.getHorizontalScrollBar()
                .getValue()/containerMapPan.getHorizontalScrollBar().getMaximum();
        
        double yPercent = (double)containerMapPan.getVerticalScrollBar()
                .getValue()/containerMapPan.getVerticalScrollBar().getMaximum();
        
        if (ElevationRbutton.isSelected()){
            for(String key : BoneID.keySet()){
                if (key == "walkway")
                    continue;
                BoneInfo E = BoneID.get(key);
                int Jah = E.GetEle() *10;
                E.SetColor(new Color(255,Jah, 48));
       
            }
        }
        
        drawMap();// TODO add your handling code here:// TODO add your handling code here:
        containerMapPan.getHorizontalScrollBar().setValue((int)
                (xPercent*containerMapPan.getHorizontalScrollBar().getMaximum()));
        containerMapPan.getVerticalScrollBar().setValue((int)
                (yPercent*containerMapPan.getVerticalScrollBar().getMaximum()));
    }//GEN-LAST:event_ElevationRbuttonStateChanged

/**
 * Changes the level of details dictated by the number of elements and 
 * sub-elements of each bone. 
 * @param evt 
 */    
    private void DetailSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DetailSliderStateChanged
        double xPercent = (double)containerMapPan.getHorizontalScrollBar()
                .getValue()/containerMapPan.getHorizontalScrollBar().getMaximum();
        
        double yPercent = (double)containerMapPan.getVerticalScrollBar()
                .getValue()/containerMapPan.getVerticalScrollBar().getMaximum();
        
        detail = DetailSlider.getValue();
        drawMap();
        containerMapPan.getHorizontalScrollBar().setValue((int)
                (xPercent*containerMapPan.getHorizontalScrollBar().getMaximum()));
        containerMapPan.getVerticalScrollBar().setValue((int)
                (yPercent*containerMapPan.getVerticalScrollBar().getMaximum()));
    }//GEN-LAST:event_DetailSliderStateChanged

/**
 * Parse the files for future use in the program.
 */    
    private void parseBones(){
        parser = new XMLplot2(listModel, VectorMapPath, BoneID);
        BoneID = parser.getHash();
        drawMap();
    }
    
/**
 * Draws the map using the defined bones from previously.
 */    
    private void drawMap() {
        JPanel test = new PlotShape2(parser.polylines, parser.xMin, parser.xMax, 
                                     parser.yMin, parser.yMax, MapZoom, BoneID,
                                     detail);
        vectorMap = test;
        //containerMapPan.setViewportView(test);
        containerMapPan.setViewportView(vectorMap);
    }
    
/**
 * display unique bone id image given filepath and string of ID
 */
    private void displayImage( String filepath ){
        
        // check if image file exists
        JLabel label;
        File f = new File(filepath);
        
        // if image doesn't exist set label to default.jpg
        if(f.exists() && !f.isDirectory()) {
            label = new JLabel( new ImageIcon(filepath) );
        }
        // else, set label =  "<boneid>".jpg
        else {
            // Strip filename from path and replace with default.jpg
            String defBones = filepath.substring(0, filepath.lastIndexOf('/'))
                    + "/default.jpg";
            
            System.out.println(defBones);
            label = new JLabel( new ImageIcon(defBones) );
        }
        
        // display label
        containerImagePane.setViewportView(label);
    }
/**
 * display unique bone id info given the string of ID.
 * @param id 
 */    
    private void displayInfo( String id ){
        textAreaBoneInfo.setText( BoneID.get(id).AllInfo());
    }

/**
 * Does Parsing and list creating for future use
 * @param Args -Dir path
 */    
    private void initBoneID(String Args){
         try {
            // get xml root node
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse( Args );
            Element root = document.getDocumentElement();

            // tree traversal
            visitChildNodes( root, "" , Args);
            JList list = new JList(listModel);

            // Listen and display image in scroll pane of the selected bone id
            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent arg0) {
                    if (!arg0.getValueIsAdjusting()) {
                        // Display bone .jpg file in image pane
                        String fp = FilePath + list.getSelectedValue().toString()
                                + ".jpg";
                        displayImage(fp);
                        
                        // Display bone info in text area pane
                        String id = list.getSelectedValue().toString();
                        displayInfo(id);
                    }
                }
            });
            // Set zoom slider back to zero before map is drawn to avoid 
            // unsynched panel zoom
            sliderZoom.setValue(5);
            
            // Fill ID JList with list mode and set selection mode to single
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            containerBoneList.setViewportView(list);
        }
        catch ( Exception e ) 
        { 
            System.out.println( e.toString() ); }
    }

/**
 * Creates the Hash for use throughout the code in drawing the Panels for display
 * of the Mammoth site and the walkways.
 * 
 * @param root - the Node of the information from the XML
 * @param indent - works For the code
 * @param FilePath - Dir FilePath
 */    
    private void visitChildNodes( Node root, String indent, String FilePath ){
        

        if ( root.getNodeName().equals( "uniqueid" ) )
        {
            IDT = root.getTextContent().trim();
            listModel.addElement(IDT);
            Flagin = true;
        }

        if ( root.getNodeName().equals("objectnum")){
            ObjectNumT = Integer.parseInt(root.getTextContent().trim());}
        
        if( root.getNodeName().equals("year")){
            YearT = Integer.parseInt(root.getTextContent().trim());}          
  
        if (root.getNodeName().equals("taxon")){
            TaxonT = root.getTextContent().trim();}
        
        if (root.getNodeName().equals("element")){
            ElementT = Integer.parseInt(root.getTextContent().trim());}

        if (root.getNodeName().equals("subelement")){
            SubElementT = root.getTextContent().trim();}
        
        if (root.getNodeName().equals("completeness")){
            CompletenessT = root.getTextContent().trim();}
                                
        if (root.getNodeName().equals("expside") || root.getNodeName()
                .equals("articulate")){
            
            ExpSideT = root.getTextContent().trim();}
        
        if(root.getNodeName().equals("gender")){
            GenderT = root.getTextContent().trim();}

        if(root.getNodeName().equals("remarks")){
            RemarksT = root.getTextContent().trim();}
                        
        if(root.getNodeName().equals("datefound")){
            DateFoundT = root.getTextContent().trim();}

        if(root.getNodeName().equals("elevation")){
            ElevationT = Double.parseDouble(root.getTextContent().trim());}
        
        if(root.getNodeName().equals("objectid")){
            ObjectIdT = Integer.parseInt(root.getTextContent().trim());}
        
        if(root.getNodeName().equals("shapelength")){
            ShapeT = Double.parseDouble(root.getTextContent().trim());
            if (Flagin)
            {
                BoneID.put(IDT, new BoneInfo(YearT,  TaxonT, ElementT, 
                     SubElementT,  CompletenessT, GenderT,
                     RemarksT,  DateFoundT,  ElevationT,
                     ObjectIdT, ShapeT));
                Flagin = false;
        
            }
        }
        // visit children (recursive)
        NodeList list = root.getChildNodes();
        for ( int i = 0; i < list.getLength(); i++ )
        {
            visitChildNodes( list.item( i ), indent + "   " , FilePath);
        }
    }
    
/**
 * @param args the command line arguments
 */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ColorBG;
    private javax.swing.JMenu ColorSchemeMenu;
    private javax.swing.JRadioButtonMenuItem CompletenessRButton;
    private javax.swing.JSlider DetailSlider;
    private javax.swing.JRadioButtonMenuItem ElevationRbutton;
    private javax.swing.JRadioButtonMenuItem GenderRButton;
    private javax.swing.JList<String> ID;
    private javax.swing.JScrollPane containerBoneList;
    private javax.swing.JScrollPane containerImagePane;
    private javax.swing.JScrollPane containerMapPan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelBoneInfo;
    private javax.swing.JLabel labelBoneList;
    private javax.swing.JLabel labelZoomTxt;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemImportData;
    private javax.swing.JSlider sliderZoom;
    private javax.swing.JTextArea textAreaBoneInfo;
    // End of variables declaration//GEN-END:variables
}
