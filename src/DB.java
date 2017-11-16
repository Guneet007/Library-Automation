import java.sql.*;
public class DB {
    Connection con;
    ResultSet rs;
    Statement stmt;

    public DB()throws Exception
    {
      Class.forName("com.mysql.jdbc.Driver");
      String url="jdbc:mysql://localhost/library";
      con=DriverManager.getConnection(url,"root","admin");
      stmt=con.createStatement();
    }
    
    public void update(String qry)throws Exception
    {
      stmt.executeUpdate(qry);
    }
    
    public ResultSet execute(String qry)throws Exception
    {
     rs=stmt.executeQuery(qry);
     return rs;
    }
    public int getBookCatId()throws Exception
    {
    String qry="select ifnull(max(bookcatid),0)max from bookcat";
    rs=stmt.executeQuery(qry);
    rs.next();
    
    int n=rs.getInt("max");
    n++;
    return n;
    }
    
    public int getBookId()throws Exception
    {
    String qry="select ifnull(max(bookid),0)max from book";
    rs=stmt.executeQuery(qry);
    rs.next();
    
    int n=rs.getInt("max");
    n++;
    return n;
    
    }
    public int getStudentId()throws Exception
    {
        String qry="select ifnull(max(stuid),0)max from student";
    rs=stmt.executeQuery(qry);
    rs.next();
    
    int n=rs.getInt("max");
    n++;
    return n;
    }
    public int getIssueId()throws Exception
    {
        String qry="select ifnull(max(issueid),0)max from issue";
    rs=stmt.executeQuery(qry);
    rs.next();
    
    int n=rs.getInt("max");
    n++;
    return n;
    }
     public int getFineId()throws Exception
    {
        String qry="select ifnull(max(fineid),0)max from fine";
    rs=stmt.executeQuery(qry);
    rs.next();
    
    int n=rs.getInt("max");
    n++;
    return n;
    }
}
