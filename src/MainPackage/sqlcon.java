/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector
 */
public class sqlcon {

    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=elmsn3;username=sa;password=111;";
    Statement st;
    Connection conn;

    public sqlcon() {
        try {
            conn = DriverManager.getConnection(url);
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean inData(String tableName, String colName, String values) {
        String qu = "insert into " + tableName + " (" + colName + ") values (" + values + ")";
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(String tableName, String editData, String condition) {
        String qu = "update " + tableName + " set " + editData + " WHERE " + condition;
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(String tableName, String editData) {
        String qu = "update " + tableName + " set " + editData;
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delData(String tableName, String condition) {
        String qu = "DELETE FROM " + tableName + " WHERE " + condition;
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ResultSet dataRead(String colName, String tableName, String condition) {
        String qu = "select " + colName + " from " + tableName + " where " + condition;
        ResultSet rs = null;
        try {
            rs = st.executeQuery(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet dataRead(String colName, String tableName) {
        String qu = "select " + colName + " from " + tableName;
        ResultSet rs = null;
        try {
            rs = st.executeQuery(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean backup(String FileNameWithPath){
        String qu = "BACKUP DATABASE [elmsn3] TO  DISK = N'"+FileNameWithPath+"' WITH NOFORMAT, NOINIT";
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean restore(String FileNameWithPath){
        String qu = "RESTORE DATABASE [elmsn3] FROM  DISK = N'"+FileNameWithPath+"'";
        try {
            return st.execute(qu);
        } catch (SQLException ex) {
            Logger.getLogger(sqlcon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
