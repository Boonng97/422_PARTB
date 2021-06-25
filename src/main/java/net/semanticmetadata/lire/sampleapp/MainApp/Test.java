import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test extends JFrame {
    public JPanel Cards;
    public JPanel TabMenu;
    public JPanel ButtonMenu;
    public JPanel IndexCards;
    public JPanel SearchCards;
    public JPanel BrowseCards;
    public JPanel ResultsCards;
    public JPanel BrowseImagePanel;
    public ImagePanel BrowseImage;
    public JPanel ResultPanel;
    public JScrollPane ResultImageScroll;
    
    public JButton Indexbtn;
    public JButton IndexStrbtn;
    public JButton OpenDirbtn;
    public JButton Searchbtn;
    public JButton OpenImgbtn;
    public JButton SearchStrbtn;
    public JButton Browsebtn;
    public JButton BrowseStrbtn;
    public JButton Resultbtn;

    public JLabel IndexLabel;
    public JLabel SearchLabel;
    public JLabel BrowseLabel;
    public JLabel BrowseLabel2;
    public JLabel BrowseTotal;
    public JLabel ResultLabel;
    
    public JTextField IndexTF;
    public JTextField SearchTF;
    
    
    public JSpinner BrowseJS;

    public JProgressBar IndexJP;
    public JProgressBar SearchJP;

    final static String INDEXPANEL = "Card with Indexing";
    final static String SEARCHPANEL = "Card with Searching";
    final static String RESULTPANEL = "Card with Result";
    final static String BROWSEPANEL = "Card with Browsing";

    public Test(Container pane)
    {
        pane.setLayout(new BorderLayout());
        pane.setPreferredSize(new Dimension(800,500));
        Cards=new JPanel(new CardLayout());
        TabMenu=new JPanel(new BorderLayout());
        TabMenu.setBackground(Color.lightGray);
        ButtonMenu=new JPanel();
        IndexCards=new JPanel();
        SearchCards=new JPanel();
        BrowseCards=new JPanel();
        BrowseImagePanel=new JPanel();
        BrowseImage=new ImagePanel();
        ResultsCards=new JPanel();
        ResultPanel=new JPanel();
        ResultImageScroll=new JScrollPane();
        
        Indexbtn=new JButton();
        Indexbtn.setText("Index");
        Indexbtn.setBackground(Color.lightGray);
        Indexbtn.setBorderPainted(false);
        Indexbtn.setFocusPainted(false);
        Indexbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStateChanged(INDEXPANEL);
            }
        });

        Searchbtn=new JButton();
        Searchbtn.setText("Search");
        Searchbtn.setBackground(Color.lightGray);
        Searchbtn.setBorderPainted(false);
        Searchbtn.setFocusPainted(false);
        Searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStateChanged(SEARCHPANEL);
            }
        });

        Browsebtn=new JButton();
        Browsebtn.setText("Browse");
        Browsebtn.setBackground(Color.lightGray);
        Browsebtn.setBorderPainted(false);
        Browsebtn.setFocusPainted(false);
        Browsebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStateChanged(BROWSEPANEL);
            }
        });

        IndexStrbtn=new JButton();
        IndexStrbtn.setText("Start");
//        IndexStrbtn.setBorderPainted(false);
//        IndexStrbtn.setFocusPainted(false);
        IndexStrbtn.setBackground(Color.white);

        OpenDirbtn=new JButton();
        OpenDirbtn.setText("Open dir");
        OpenDirbtn.setBackground(Color.white);
//        OpenDirbtn.setBorderPainted(false);
//        OpenDirbtn.setFocusPainted(false);
        OpenDirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenDirActionPerformed(evt);
            }
        });

        SearchStrbtn=new JButton();
        SearchStrbtn.setText("Start");
//        SearchStrbtn.setBorderPainted(false);
//        SearchStrbtn.setFocusPainted(false);
        SearchStrbtn.setBackground(Color.white);

        OpenImgbtn=new JButton();
        OpenImgbtn.setText("Open Image");
        OpenImgbtn.setBackground(Color.white);
//        OpenImgbtn.setBorderPainted(false);
//        OpenImgbtn.setFocusPainted(false);
        OpenImgbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenImageActionPerformed(evt);
            }
        });

        BrowseStrbtn=new JButton();
        BrowseStrbtn.setText("Browse");
        BrowseStrbtn.setBackground(Color.white);

        Resultbtn=new JButton();
        Resultbtn.setText("Result");
        Resultbtn.setBackground(Color.lightGray);
        Resultbtn.setBorderPainted(false);
        Resultbtn.setFocusPainted(false);
        Resultbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemStateChanged(RESULTPANEL);
            }
        });

        IndexLabel=new JLabel(" Indexing");
        IndexLabel.setFont(new Font(IndexLabel.getName(),Font.BOLD,20));
        SearchLabel=new JLabel(" Searching");
        SearchLabel.setFont(new Font(SearchLabel.getName(),Font.BOLD,20));
        BrowseLabel=new JLabel(" Browse");
        BrowseLabel.setFont(new Font(BrowseLabel.getName(),Font.BOLD,20));
        BrowseLabel2=new JLabel(" Current document");
        BrowseTotal=new JLabel(" (Total: 100)");
        ResultLabel=new JLabel(" Result");
        ResultLabel.setFont(new Font(ResultLabel.getName(),Font.BOLD,20));
        
        IndexTF=new JTextField();
        IndexTF.setEditable(false);
        SearchTF=new JTextField();
        SearchTF.setEditable(false);
       

        IndexJP=new JProgressBar();
        IndexJP.setString("Indexing State...");
        IndexJP.setStringPainted(true);

        SearchJP=new JProgressBar();
        SearchJP.setString("Searching...");
        SearchJP.setStringPainted(true);

        BrowseJS=new JSpinner();
        BrowseJS.setValue(1);
        BrowseJS.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                BrowseJSValuechange(evt);
            }
        });

        ButtonMenu.add(Indexbtn);
        ButtonMenu.add(Searchbtn);
        ButtonMenu.add(Browsebtn);
        ButtonMenu.add(Resultbtn);

        GroupLayout indexlayout=new GroupLayout(IndexCards);
        IndexCards.setLayout(indexlayout);
        indexlayout.setHorizontalGroup(
                indexlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(IndexLabel)
                    .addGroup(indexlayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(indexlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(IndexJP,GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                                    .addGroup(indexlayout.createSequentialGroup()
                                        .addComponent(IndexTF,GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(OpenDirbtn,GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    )
                                    .addGroup(GroupLayout.Alignment.TRAILING, indexlayout.createSequentialGroup()
                                            .addContainerGap(670,Short.MAX_VALUE)
                                            .addComponent(IndexStrbtn,GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    )

                            )
                            .addContainerGap()
                    )
        );
        indexlayout.setVerticalGroup(
                indexlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(indexlayout.createSequentialGroup()
                            .addComponent(IndexLabel)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(indexlayout.createParallelGroup()
                                .addComponent(IndexTF,GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                .addComponent(OpenDirbtn)
                            )
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IndexJP,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(IndexStrbtn)

                    )
        );


        GroupLayout searchlayout=new GroupLayout(SearchCards);
        SearchCards.setLayout(searchlayout);
        searchlayout.setHorizontalGroup(
                searchlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(SearchLabel)
                        .addGroup(searchlayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(searchlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(SearchJP,GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                                        .addGroup(searchlayout.createSequentialGroup()
                                                .addComponent(SearchTF,GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(OpenImgbtn,GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        )
                                        .addGroup(GroupLayout.Alignment.TRAILING, searchlayout.createSequentialGroup()
                                                .addContainerGap(655,Short.MAX_VALUE)
                                                .addComponent(SearchStrbtn,GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        )

                                )
                                .addContainerGap()
                        )
        );
        searchlayout.setVerticalGroup(
                searchlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(searchlayout.createSequentialGroup()
                                .addComponent(SearchLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(searchlayout.createParallelGroup()
                                        .addComponent(SearchTF,GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(OpenImgbtn)
                                )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchJP,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchStrbtn)

                        )
        );

        BrowseImagePanel.setLayout(new BorderLayout());
//        BrowseImagePanel.add(BrowseImage,BorderLayout.CENTER);

        GroupLayout browselayout=new GroupLayout(BrowseCards);
        BrowseCards.setLayout(browselayout);
        browselayout.setHorizontalGroup(
                browselayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(browselayout.createSequentialGroup()
                                .addGroup(browselayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(BrowseLabel)
                                        .addGroup(browselayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(BrowseLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BrowseTotal)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BrowseJS, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(BrowseStrbtn)))
                                .addGap(354, 354, 354))
                        .addComponent(BrowseImagePanel,GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        browselayout.setVerticalGroup(
                browselayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(browselayout.createSequentialGroup()
                                .addComponent(BrowseLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(browselayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(BrowseLabel2)
                                        .addComponent(BrowseTotal)
                                        .addComponent(BrowseJS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BrowseStrbtn)
                                        )
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BrowseImagePanel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        );
        
        ResultPanel.add(ResultImageScroll);
        GroupLayout resultlayout=new GroupLayout(ResultsCards);
        ResultsCards.setLayout(resultlayout);
        resultlayout.setHorizontalGroup(
                resultlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(ResultLabel)
                .addComponent(ResultPanel,GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE,700, GroupLayout.PREFERRED_SIZE)
        );
        
        resultlayout.setVerticalGroup(
                resultlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resultlayout.createSequentialGroup()
                                .addComponent(ResultLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ResultPanel, GroupLayout.PREFERRED_SIZE,400, GroupLayout.PREFERRED_SIZE)
                        )
                
        );
        
        Cards.add(IndexCards,INDEXPANEL);
        Cards.add(SearchCards,SEARCHPANEL);
        Cards.add(BrowseCards,BROWSEPANEL);
        Cards.add(ResultsCards,RESULTPANEL);
        TabMenu.add(ButtonMenu,BorderLayout.WEST);
        pane.add(TabMenu,BorderLayout.NORTH);
        pane.add(Cards,BorderLayout.CENTER);
    }
    public void itemStateChanged(String item) {
        CardLayout cl = (CardLayout)(Cards.getLayout());
        cl.show(Cards, item);
    }

    //function call for select directory
    private void buttonOpenDirActionPerformed(ActionEvent evt) {
        JFileChooser jfc = new JFileChooser(".");
        jfc.setDialogTitle("Select directory to index ...");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                IndexTF.setText(jfc.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            }
        }
    }

    //function call for open image
    private void buttonOpenImageActionPerformed(ActionEvent evt) {
        JFileChooser jfc = new JFileChooser(".");
        jfc.setDialogTitle("Select image to search for ...");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, PNG & GIF Images", "jpg", "gif", "png");
        jfc.setFileFilter(filter);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                SearchTF.setText(jfc.getSelectedFile().getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger("global").log(Level.SEVERE, null, ex);
            }
        }
    }

    //spinner value changes
    private void BrowseJSValuechange(ChangeEvent evt) {
        int docID = (Integer) BrowseJS.getValue() - 1;
//        if (docID >= 0 && docID < browseReader.maxDoc()) {
//            setDocumentImageIcon(docID);
//        } else {
            if (docID < 0) {
                BrowseJS.setValue(1);
            } else {
                BrowseJS.setValue(100);
            }
//        }
    }
}
