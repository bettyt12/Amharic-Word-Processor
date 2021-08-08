


package Bethelhem_Tarekegn_1010616;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import java.util.List;


public class TextEditor  {
    String filename="";
     String password;
     FileProperty prop1;
    ObjectOutputStream output1, output2;
    ObjectInputStream input;
   public TextEditor(){
  
     JFrame mainFrame= new JFrame();
     mainFrame.setLayout(new BorderLayout());
    
     //a panel that contains the menu bar and the toolbar
     JPanel subPanel=new JPanel();
     subPanel.setLayout(new GridLayout(2,0));
    
     
    JMenuBar menubar=new JMenuBar();
    JToolBar toolbar=new JToolBar();
     
        //the area where we will be writing 
      JEditorPane editorpane=new JEditorPane();
      JScrollPane scroll=new JScrollPane(editorpane);
      mainFrame.add(scroll,BorderLayout.EAST);
      
        JMenu menu1=new JMenu("ማህደር ");//file menu
        JMenu menu2=new JMenu("መረጃ");//help menu
        
        menu1.setFont(new Font("Ebrima",Font.PLAIN,12));
        menu2.setFont(new Font("Ebrima",Font.PLAIN,12));
       
        //the menu items in filename menu
        JMenuItem newFile=new JMenuItem("አዲስ");
        JMenuItem openFile=new JMenuItem("ክፈት");//open menu 
        JMenuItem saveFile=new JMenuItem("አስቀምጥ");//save menu
        JMenuItem saveasFile=new JMenuItem("እንደ ... አስቅምጥ ");//saveas menu
        JMenuItem closeFile=new JMenuItem("ዝጋ");//closes the window
        
        newFile.setFont(new Font("Ebrima",Font.PLAIN,12));
        newFile.setToolTipText("new file");
        openFile.setFont(new Font("Ebrima",Font.PLAIN,11));
        openFile.setToolTipText("opens the file we want");
        saveFile.setFont(new Font("Ebrima",Font.PLAIN,11));
        saveFile.setToolTipText("saves the file we want");
        saveasFile.setFont(new Font("Ebrima",Font.PLAIN,11));
        saveasFile.setToolTipText("saves the file in the place we want ");
        closeFile.setFont(new Font("Ebrima",Font.PLAIN,11));
        closeFile.setToolTipText("closes the text editor");
        JMenuItem fileHistory=new JMenuItem("ስለ ማህደር ");
        fileHistory.setFont(new Font("Ebrima",Font.PLAIN,12));
        
        //setting the shortcut key for the filename menu items
       saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
       newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
       openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
       saveasFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
       closeFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
       fileHistory.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK)); 
        //adding the menu items into the filename menu
            menu1.add(newFile);
            menu1.add(openFile);
            menu1.add(saveFile);
            menu1.add(saveasFile);
            menu1.add(fileHistory);
            menu1.add(closeFile);
            menubar.add(menu1);
            
            //menu items for the help menu
        JMenuItem developerDetail=new JMenuItem("ስለ እኛ ");
        developerDetail.setFont(new Font("Ebrima",Font.PLAIN,12)); 
        JMenuItem howToUse=new JMenuItem("አጠቃቀም");
        howToUse.setFont(new Font("Ebrima",Font.PLAIN,12));
        
                 
        
         //adding the menu items into the help menu
            menu2.add(developerDetail);
            menu2.add(howToUse);
            menubar.add(menu2);
                  
        
        //adding a button that make the text bold
        Icon boldIcon = new ImageIcon("src/pic/bold.png");
        JToggleButton bold=new JToggleButton(boldIcon);
        bold.setPreferredSize(new Dimension(13,13));
        bold.setToolTipText("make your text bold");
        //adding a button that make the text italic
        Icon italicIcon = new ImageIcon("src/pic/italic.png");
        JToggleButton italic=new JToggleButton(italicIcon);
        italic.setToolTipText("Italize your text");
        //adding a button that make the text Undelined
        Icon underlineIcon = new ImageIcon("src/pic/underline.png");
        JToggleButton underline=new JToggleButton(underlineIcon);
        underline.setToolTipText("Underline your text");
        //adding a comboBox that can change the size of the text
        Integer[] sizeList={8,9,10,11,12,14,16,18,20,22,24,28,36,48,72};
        JComboBox fontSize=new JComboBox(sizeList);
        fontSize.setPreferredSize(new Dimension(49,28));
        fontSize.setMaximumSize(new Dimension(49,28));
        fontSize.setToolTipText("chande the size of your text");
        //adding a comboBox that can change the font style of the text
        String fontList[]=GraphicsEnvironment.getLocalGraphicsEnvironment()
                          .getAvailableFontFamilyNames();
        JComboBox fontStyle=new JComboBox(fontList);
        fontStyle.setPreferredSize(new Dimension(280,28));
        fontStyle.setMaximumSize(new Dimension(280,28));
        fontStyle.setToolTipText("set a new font for your text");
        //adding a button that could change the text's foreground color
        Icon foregroundIcon = new ImageIcon("src/pic/fontColor.png");
        JButton foreground=new JButton(foregroundIcon);
        foreground.setToolTipText("highlight your text");  
        //adding a button that could change the text's foreground color
        Icon backgroundIcon = new ImageIcon("src/pic/background.png");
        JButton background=new JButton(backgroundIcon);
        background.setToolTipText("change the color of your text");
        
        StyledEditorKit editorkit= new StyledEditorKit();
        StyledDocument doc = new DefaultStyledDocument() ;
        editorpane.setEditorKit(editorkit);
        editorpane.setDocument(doc);
        
                  toolbar.add(bold);
                  toolbar.add(italic);
                  toolbar.add(underline);
                  toolbar.add(fontSize);
                  toolbar.add(fontStyle);
                  toolbar.add(foreground);
                  toolbar.add(background);
                  subPanel.add(menubar);
                  subPanel.add(toolbar);
    
           //new filename action       
        newFile.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             editorpane.setText("");
             filename="";
            }});
        
        //open filename action
        openFile.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
              ObjectInputStream input=null;
              try {
                  
                  JFileChooser fileChooser = new JFileChooser();
                  fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                  fileChooser.showOpenDialog(openFile);
                  filename=fileChooser.getSelectedFile()  + "";
                  input = new ObjectInputStream(new FileInputStream(filename));
                  String pass = JOptionPane.showInputDialog(openFile, "enter password");
                  DataContent cont = (DataContent) input.readObject();
                  FileProperty Fileobj1 = (FileProperty) input.readObject();
                  FileProperty Fileobj2 = (FileProperty) input.readObject();
                  if (Fileobj1.getPassWord().equals(pass)) {
                      editorpane.setText(cont.getData());
                      
                  } else {
                      JOptionPane.showMessageDialog(openFile, "ያስገቡት ይለፍቃል የተሳሳተ ነወ");
                  }     
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
              }} });
                  
        
        //adding action litener to the save menu item
        saveFile.addActionListener(new ActionListener(){
   @Override
   public void actionPerformed(ActionEvent e){
       try {
           input = new ObjectInputStream(new FileInputStream(filename));
           DataContent data1=(DataContent)input.readObject();
           FileProperty property=(FileProperty)input.readObject();
           DataContent data2 = new DataContent();
           data2.setData(editorpane.getText());
           File file1=new File(filename);
           FileProperty fileproperty1 = new FileProperty(System.getProperty("user.name"), property.getCreatedDate(), property.getPassWord(),file1.canWrite());
           prop1.addToList(System.getProperty("user.name"));
           prop1.addToListDate(new Date());
           output2 = new ObjectOutputStream(new FileOutputStream(filename));
           output2.writeObject(data2);
           output2.writeObject(property);
           output2.writeObject(prop1);
           output2.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
       }
   
              
   }
   });
                
                // adding action listener to the save as menu item
        saveasFile.addActionListener(new ActionListener() {
            @Override
              public void actionPerformed(ActionEvent e) {
                ObjectOutputStream output = null;
                  try {
                              JFileChooser fileChooser = new JFileChooser();
                              fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                              fileChooser.showSaveDialog(saveFile);
                              filename=fileChooser.getSelectedFile() + ".betty";
                              output = new ObjectOutputStream(new FileOutputStream(filename));
                              password = JOptionPane.showInputDialog("enter password");
                              DataContent data = new DataContent();
                              data.setData(editorpane.getText());
                              File file1=new File(filename);
                              FileProperty FPobj1= new FileProperty(System.getProperty("user.name"), new Date(),
                                      password,file1.canWrite());
                              FileProperty FPobj2 = new FileProperty(System.getProperty("user.name"), new Date());
                              output.writeObject(data);
                              output.writeObject(FPobj1);
                              output.writeObject(FPobj2);
                              output.close();
                          } catch (FileNotFoundException ex) {
                              Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                          } catch (IOException ex) {
                              Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                          } finally {
                              try {
                                  output.close();
                              } catch (IOException ex) {
                                  Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                          }
                      }
                  });          
                  
                  
              //adding action listener to the close menu item    
         closeFile.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });   
         
          //file History menu item's action
         fileHistory.addActionListener(e->{
         try {
             JDialog dialog3=new JDialog();
             dialog3.setTitle("ስለ ማህደር");
             dialog3.setFont(new Font("Ebrima",Font.PLAIN,12));
             dialog3.setSize(250, 250);
             dialog3.setLocation(80, 80);
             
             JTextPane textpane3=new JTextPane();
             input = new ObjectInputStream(new FileInputStream(filename));
             DataContent cont= (DataContent) input.readObject();
             FileProperty property2 = (FileProperty) input.readObject();
             FileProperty prop1 = (FileProperty) input.readObject();
             List <String> modBy=prop1.getModifiedBy();
             List <Date> modOn=prop1.getModifiedOn();
             String strmodBy="";
             String strmodOn="";
             for(int i=0;i<modBy.size();i++)
             {
                 strmodBy=strmodBy+modBy.get(i);
             }
             for(int i=0;i<modOn.size();i++)
             {
                 strmodOn=strmodOn+modOn.get(i);
             }
             String History="ስለ ተጠቃሚው መረጃ\n\n"+"የተሰራው በ:"+property2.getCreatedBy()+
                     ".\n"+"የተሰራበት ቀን:"+property2.getCreatedDate()+".\n"+"የተሻሻለው በ:"+strmodBy+" "+"\nየተሻሻለበት ቀን:"+strmodOn+" ";
             textpane3.setText(History);
             textpane3.setFont(new Font("Ebrima",Font.PLAIN,12));
             textpane3.setBackground(Color.LIGHT_GRAY);
             textpane3.setEditable(false);
             dialog3.setVisible(true);
             dialog3.add(textpane3);
             
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        });
         
           //developers detail menu item's action
        developerDetail.addActionListener(e->{
        JDialog dialog1=new JDialog();
        dialog1.setTitle("ስለ እኛ");
        dialog1.setFont(new Font("Ebrima",Font.PLAIN,12));
        dialog1.setSize(250, 250);
        dialog1.setVisible(true);
        JTextPane textpane=new JTextPane();
        dialog1.setFont(new Font("Ebrima",Font.PLAIN,12));
        String devBy="ብራና የአማርኛ ፊደል ገበታ"+"\n\nየተሰራው : "+" በ ቤተልሔም ታረቀኝ "+
                "\nአድራሻ: betitarekegn12@gmail.com"+
                "\n\nበባህርዳር ዩኒቨርስቲ የሁለተኛ አመት የሶፍትዌር ኢንጅነሪንግ ተማሪ"+
                "\n\nBranna Systems. Copyright©2019\nAll rights reserved";
        textpane.setText(devBy);
         textpane.setFont(new Font("Ebrima",Font.PLAIN,12));
        textpane.setBackground(Color.lightGray);
        textpane.setEditable(false);
        dialog1.add(textpane);
        });
        
        // how to use menu item's action
         howToUse.addActionListener(e->{
        JDialog dialog2=new JDialog();
        dialog2.setTitle("አጠቃቀም");
        dialog2.setFont(new Font("Ebrima",Font.PLAIN,12));
        dialog2.setSize(250, 250);
        dialog2.setVisible(true);
        JTextPane textpane2=new JTextPane();
        dialog2.setFont(new Font("Ebrima",Font.PLAIN,12));
        String how="ብራና የአማርኛ ፊደል ገበታ"+
                "\n\n ለበለጠ መረጃ ከታች በተጠቀሱት አድራሻዎች ያግኙን \n\nኢሜል: betitarekegn12@gmail.com or \nስልክ ቁጥር: +251984625198 ";
        textpane2.setText(how);
        textpane2.setFont(new Font("Ebrima",Font.PLAIN,12));
        textpane2.setBackground(Color.LIGHT_GRAY);
        textpane2.setEditable(false);
        dialog2.add(textpane2);
        });
         
           
                  //actions performed on the text
                  //bold Action
                  bold.addActionListener(e -> {
                      Action fontAction = new StyledEditorKit.BoldAction();
                      fontAction.actionPerformed(e);
                  });
                  
                  //Italic action
                    italic.addActionListener(e -> {
                      Action fontAction = new StyledEditorKit.ItalicAction();
                      fontAction.actionPerformed(e);
                  }); 
                  
                    //underline action
                    underline.addActionListener(e -> {
                      Action fontAction = new StyledEditorKit.UnderlineAction();
                      fontAction.actionPerformed(e);
                  });        
                  
                    //font size action
                  fontSize.addActionListener(e -> {
                      int fs= (Integer)fontSize.getSelectedItem();
                      Action fontAction = new StyledEditorKit.FontSizeAction("font", fs);
                      fontAction.actionPerformed(e);
                  });          
                  
                  //font style action
                  fontStyle.addActionListener(e -> {
                      String fonts= (String)fontStyle.getSelectedItem();
                      Action fontAction = new StyledEditorKit.FontFamilyAction(fonts, fonts);
                      fontAction.actionPerformed(e);
                  });     
                  
                  //foreground action
                  foreground.addActionListener(e -> {
               Color colorChoose = JColorChooser.showDialog(editorpane, "ቀለም ይምረጡ", Color.BLACK);
                StyledDocument sdocfc = (StyledDocument) editorpane.getDocument();
                int start = editorpane.getSelectionStart();
                int end = editorpane.getSelectionEnd();
                int dif = end - start;
                if (start == end) {
                    return;
                } else {
                    Element element = sdocfc.getCharacterElement(start);
                    AttributeSet fgcolor = element.getAttributes();
                    MutableAttributeSet mfgcolor = new SimpleAttributeSet(fgcolor.copyAttributes());
                    StyleConstants.setForeground(mfgcolor, colorChoose);
                    sdocfc.setCharacterAttributes(start, dif, mfgcolor, true);
                }
                  });
                  
                  //background action
                  background.addActionListener(e -> {
                  Color colorChoose = JColorChooser.showDialog(editorpane, "ቀለም ይምረጡ", Color.WHITE);
                StyledDocument sdocbc = (StyledDocument) editorpane.getDocument();
                int start = editorpane.getSelectionStart();
                int end = editorpane.getSelectionEnd();
                int dif = end - start;
                if (start == end) {
                    return;
                } else {
                    Element element = sdocbc.getCharacterElement(start);
                    AttributeSet bgcolor = element.getAttributes();
                    MutableAttributeSet mbgcolor = new SimpleAttributeSet(bgcolor.copyAttributes());
                    StyleConstants.setBackground(mbgcolor, colorChoose);
                    sdocbc.setCharacterAttributes(start, dif, mbgcolor, true);
                }
                  });
                  
                  
                  
                  mainFrame.add(subPanel,BorderLayout.NORTH);
                  mainFrame.add(editorpane,BorderLayout.CENTER);
                  mainFrame.setTitle("ብራና የአማርኛ ፊደል ገበታ");
                  mainFrame.setSize(600,600);
                  mainFrame.setVisible(true);
             
      } 
   
 
    public static void main(String[] args) {
        try {
            // select Look and Feel
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
         new TextEditor();
        } 
       catch (Exception ex) {
            ex.printStackTrace();
        }
        
            }}
    
    
    
        
