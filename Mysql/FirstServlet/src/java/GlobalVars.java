
import javax.servlet.ServletContext;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class GlobalVars {
    private static GlobalVars gv =null;
    public BasicDataSource dataSource=null;
    private String _path = "";
    public static synchronized GlobalVars getGlobalVars(ServletContext context) throws Exception{
        if(gv!=null)
            return gv;
        gv=new GlobalVars();
        String cdriver = context.getInitParameter("driver");
        String csource = context.getInitParameter("source");
        String cuser = context.getInitParameter("username");
        String pass = context.getInitParameter("password");
        
        gv.dataSource=new BasicDataSource();
        gv.dataSource.setDriverClassName(cdriver);
        gv.dataSource.setUrl(csource+"?useUnicode=true&characterEncoding=UTF-8");
        gv.dataSource.setUsername(cuser);
        gv.dataSource.setPassword(pass);
        gv._path=context.getInitParameter("path");
        return gv;
    }
    private GlobalVars(){
    }
}

