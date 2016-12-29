package javaapplication1;
import java.sql.*;

public class JavaApplication1 {
    public static void main(String[] args) {
        Connection con = null;
        try{
            String _driver = "com.mysql.jdbc.Driver"; //"sun.jdbc.odbc.JdbcOdbcDriver"
            String _url = "jdbc:mysql://localhost/test?user=sa&password=!password123";//"jdbc:odbc:score"
            Class.forName(_driver);
            System.out.println("MySQLToJava:OK");
            con = DriverManager.getConnection(_url);
            System.out.println("connect to DB:"+_url);
            
            Statement st = con.createStatement();
            st.execute("SELECT * FROM test1 WHERE id = 100000000");
            ResultSet rs = st.getResultSet();
            
            while(rs.next())
            {
                System.out.println(rs.getString("id")+" "+rs.getString("amount")+" "+rs.getString("price"));
            }
            rs.close();
            st.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            if(con!=null){
                System.out.println("Connection is closed...");
                try{
                    con.close();
                }
                catch(Exception e2){
                }
            }
        }
    }
}
