package javaapplication2;
import java.sql.*;

public class JavaApplication2 {

    public static void main(String[] args) {
        Connection con =null;
        try{
            String _driver = "com.mysql.jdbc.Driver";
            String _url = "jdbc:mysql://localhost/test?user=sa&password=!password123";
            Class.forName(_driver);
            System.out.println("jdbc to mysql");
            con = DriverManager.getConnection(_url);
            System.out.println("Connect to "+_url);
            Statement st = con.createStatement();
            String sql = "insert into test1 (id,amount,price) values(100000000,100000000,100000000)";
            int result = st.executeUpdate(sql);
            System.out.println("result = "+result);
            st.close();
            
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
        finally{
            if(con !=null){
                System.out.println("Close DB...");
                try{
                    con.close();
                }
                catch(Exception e2){
                }
            }
        }
    }
    
}
