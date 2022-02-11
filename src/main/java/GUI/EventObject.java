package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class EventObject extends JPanel{
    javax.swing.JLabel Title = new javax.swing.JLabel();
    javax.swing.JLabel Panel = new javax.swing.JLabel();
    javax.swing.JLabel Image = new javax.swing.JLabel();
    private int ID;
    public EventObject(String TitleString,String ImageURL,int Index)
    {
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setForeground(new java.awt.Color(255, 255, 255));
        this.setAlignmentX(1.0F);
        this.setAlignmentY(1.0F);
        this.setMaximumSize(new java.awt.Dimension(310, 310));
        this.setMinimumSize(new java.awt.Dimension(310, 310));
        this.setOpaque(false);
        this.setPreferredSize(new java.awt.Dimension(310, 310));
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MouseClicked(evt);
            }
        });
        this.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(TitleString);
        this.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 730, 40));

        Panel.setBackground(new java.awt.Color(0, 0, 0));
        Panel.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        Panel.setForeground(new java.awt.Color(0, 0, 0));
        Panel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Events/Rectangle 3Big.png"))); // NOI18N
        this.add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 750, 85));

        Image.setBackground(new java.awt.Color(255, 255, 255));
        Image.setForeground(new java.awt.Color(255, 255, 255));
        Image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Image.setIcon(new javax.swing.ImageIcon(getClass().getResource(ImageURL))); // NOI18N
        Image.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        this.add(Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 750, 240));
        this.ID = Index;
    }

    private void MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomButton1MouseClicked
        //Open Details Page and populate it with the Event detials and icon
        Backend.EventDetailsPage.Instance().setEventID(ID);
        System.out.println("Event ID " + Backend.EventDetailsPage.Instance().getEventID());
        Backend.LoginPage.Instance().signUpButton((JFrame) SwingUtilities.windowForComponent(this) , new EventDetails());
    }
}
