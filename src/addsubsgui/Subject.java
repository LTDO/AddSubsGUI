

/**
 *Subject.java
 * This is a model class
 * @author Lunga Tshila
 * Date: 23 September 2020
 */
package addsubsgui;

import java.sql.*;
import javax.swing.JOptionPane;


public class Subject {
    
    static final String DATABASE_URL = "jdbc:derby://localhost:1527/Sunshine3";
    static final String username = "Administrator";
    static final String password = "Password";
    
    private String subjectCode;
    private String subjecDescription;

    public Subject() {
    }

    public Subject(String subjectCode, String subjecDescription) {
        this.subjectCode = subjectCode;
        this.subjecDescription = subjecDescription;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjecDescription() {
        return subjecDescription;
    }

    public void setSubjecDescription(String subjecDescription) {
        this.subjecDescription = subjecDescription;
    }

    @Override
    public String toString() {
        return "Subject{" + "subjectCode=" + subjectCode + ", subjecDescription=" + subjecDescription + '}';
    }
    
    //Intially defined as a stub...to come back and add functionality.
   public void save(){
       Connection connection = null;
       PreparedStatement statement = null;
       int ok;
       String sql = "INSERT INTO Subject VALUES(?, ?)";
       
       try{
           connection = DriverManager.getConnection(DATABASE_URL, username, password);
           
           statement = connection.prepareStatement(sql);
           statement.setString(1, subjectCode);
           statement.setString(2, subjecDescription);
           
           ok = statement.executeUpdate();
           if(ok > 0){
               JOptionPane.showMessageDialog(null, "Success Subject added.");
               System.exit(0);
           }else{
               JOptionPane.showMessageDialog(null, "Error: Could not add subject.");
               
           }

           
       }catch(SQLException sqlException){
           JOptionPane.showMessageDialog(null, "Error: " + sqlException.getMessage());
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
       }finally{
            try {
                        if (statement != null) {
                            statement.close();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);

                    }

                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);

                    }
       }
   }
}
