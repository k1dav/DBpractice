package javaapplication3;
import java.sql.*;
public class JavaApplication3 {

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
            String sql = "select * from test1 limit 10";
            System.out.println("execute:"+sql);
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            int coln = meta.getColumnCount();
            for(int i=1;i<=coln;i++){
                System.out.println(meta.getColumnClassName(i)+":"+meta.getColumnTypeName((i))+":"+meta.getColumnLabel(i));
            }
            rs.close();
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
