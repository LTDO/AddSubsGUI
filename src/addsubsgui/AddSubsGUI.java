
/**
 * AddSubjs.java
 * This is a  GUI Program made simple
 * @author Lunga Tshila (216282934)
 * Date: 22 September 2020
 */
package addsubsgui;

//Working Class

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javafx.stage.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddSubsGUI implements ActionListener{
    
        private JFrame mainframe;
        private JPanel panelWest, panelEast, panelSouth;
        private JLabel lblSubjectCode;
        private JLabel lblSubjectDescription;
        private JTextField txtSubjectCode;
        private JTextField txtSubjectDescription;
        private JButton btnSave;
        private JButton btnCancel;
        
        public AddSubsGUI(){
            mainframe = new JFrame("Add a subject");
            panelWest = new JPanel();
            panelEast = new JPanel();
            panelSouth = new JPanel();
            lblSubjectCode = new JLabel("Subject Code:");
            lblSubjectDescription = new JLabel("Subject Description");
            txtSubjectCode = new JTextField();
            txtSubjectDescription = new JTextField();
            btnSave = new JButton("Save");
            btnCancel = new JButton("Cancel");
            
        }
        
        public void setGUI(){
            
            //set layout of panels
            panelWest.setLayout(new GridLayout(2, 1));
            panelEast.setLayout(new GridLayout(2, 1));
            panelSouth.setLayout(new GridLayout(1, 2));
            
            //set dimensions of panels
            panelEast.setPreferredSize(new Dimension(250, 90));
            panelSouth.setPreferredSize(new Dimension(200, 30));
            
            
            //labels and buttons to the panels
            panelWest.add(lblSubjectCode);
            panelWest.add(lblSubjectDescription);
            
            panelEast.add(txtSubjectCode);
            panelEast.add(txtSubjectDescription);
            
            panelSouth.add(btnSave);
            panelSouth.add(btnCancel);
            
            
            //add the panels to the main frame
            mainframe.add(panelWest, BorderLayout.WEST);
            mainframe.add(panelEast, BorderLayout.EAST);
            mainframe.add(panelSouth, BorderLayout.SOUTH);
            
            //min max and close buttons...click on close and it closes..
            mainframe.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }
            });
            
            //add event listeners to save and cancel btns
            btnSave.addActionListener(this);
            btnCancel.addActionListener(this);
            
            //deprecated methods that are available in the old compiler can be added here...
            mainframe.setSize(400,  120);
            mainframe.setVisible(true);
            mainframe.pack();
        }
    
    public static void main(String[] args) {
        new AddSubsGUI().setGUI();
    }   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSave){
            String subjectCode = txtSubjectCode.getText();
            String subjectDecription = txtSubjectDescription.getText();
            
            Subject s = new Subject(subjectCode, subjectDecription);
            s.save();
            
            
        }else if(e.getSource() == btnCancel){
            System.exit(0);
        }
    }
}
