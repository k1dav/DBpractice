package Random_test;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class IdHelper {
    Session session = null;
    public IdHelper(){
        this.session=HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public List getAmount(int startId,int endId){
        List<Test1> testList =null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("FROM test1 as test1 WHERE test1 between '"+startId+"'and'"+endId+"'");
            testList=(List<Test1>)q.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return testList;
    }
    public List getPricebyID(int startId,int endId){
        List<Test1> testList =null;
        try{
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("FROM test1 as test1 WHERE test1 between '"+startId+"'and'"+endId+"'");
            testList=(List<Test1>)q.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return testList;
    }
}
