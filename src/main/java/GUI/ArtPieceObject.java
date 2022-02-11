package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ArtPieceObject extends JPanel {
    
    javax.swing.JLabel Title = new javax.swing.JLabel();
    javax.swing.JLabel Panel = new javax.swing.JLabel();
    javax.swing.JLabel Image = new javax.swing.JLabel();
    String title,ImgURL;
    String Info;
    public ArtPieceObject(String TitleString,String ImageURL,String Details)
    {
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setAlignmentX(1.0F);
        this.setAlignmentY(1.0F);
        this.setMaximumSize(new java.awt.Dimension(310, 310));
        this.setMinimumSize(new java.awt.Dimension(310, 310));
        this.setOpaque(false);
        this.setPreferredSize(new java.awt.Dimension(310, 310));
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
       
        Title.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(TitleString);
        this.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 160, 40));

        Panel.setBackground(new java.awt.Color(0, 0, 0));
        Panel.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Panel.setForeground(new java.awt.Color(0, 0, 0));
        Panel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/folder/HalfutRectangle.png"))); // NOI18N
        this.add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 310, 85));

        Image.setBackground(new java.awt.Color(255, 255, 255));
        Image.setForeground(new java.awt.Color(255, 255, 255));
        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImageURL))); // NOI18N
        Image.setToolTipText(Details);
        Image.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        this.add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 310, 240));
        
        Image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt);
            }
        });
        
        title = TitleString;
        ImgURL = ImageURL;
        Info = Details;
    }
     private void MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomButton1MouseClicked
        //Open Details Page and populate it with the Event detials and icon
         System.out.println("GUI.ArtPieceObject.MouseClicked()");
        Backend.ArtPiecePage.Instance().backButtom((JFrame) SwingUtilities.windowForComponent(this), new Details(title,ImgURL,Info));
    }

}
