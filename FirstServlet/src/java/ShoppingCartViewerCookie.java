import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartViewerCookie extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        String sessionid =null;
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("sessionid")){
                    sessionid=cookies[i].getValue();
                    break;
                }
            }
        }
        
        if(sessionid == null){
            sessionid =generateSessionId();
            Cookie c =new Cookie("sessionid",sessionid);
            res.addCookie(c);
        }
        out.println("<HEAD><TITLE>Current Shopping Cart Items</TITLE></HEAD>");
        out.println("<BODY>");
        
        String[]items =getItemsFromCart(sessionid);
        
        out.println("You currently have the following items in your card :<BR>");
        if(items ==null){
            out.println("<B>None</B>");
        }
        else{
            out.println("<UL>");
            for(int i=0;i<items.length;i++){
                out.println("<LI>"+items[i]);
            }
            out.println("</UL>");
        }
        
        out.println("<FORM ACTION = \"/servlet/ShoppingCart\" METHOD=POST>");
        out.println("Would you like to <BR>");
        out.println("<INPUT TYPE =submit VALUE= \" Add More Items \">");
        out.println("<INPUT TYPE =submit VALUE= \"CHECK Out \">");
        out.println("</FROM>");
        
        out.println("For help,click <A HREF = \"/servlet/Help?topic=ShoppingCartViewerCookie\">here</A>");
        out.println("</BODY></HTML>");
    }

    private String generateSessionId() {
        String uid = new java.rmi.server.UID().toString();
        return java.net.URLEncoder.encode(uid);
    }
    private static String [] getItemsFromCart(String sessionid){
        return null;
    }
}
