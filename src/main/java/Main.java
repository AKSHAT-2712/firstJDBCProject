import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        //1. Load and register the driver
        //name of mysql driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.Establish the connection with the database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","Akshat@2712");

        //3.Create the statement object - CAR
        Statement st = con.createStatement();

        boolean flag = true;
        while(flag)
        {
            System.out.println("Enter the choice");
            System.out.println("1.View the record");
            System.out.println("2.Insert the record");
            System.out.println("3.Update the record");
            System.out.println("4.Delete the record");
            System.out.println("5.Exit");

            int choice = sc.nextInt();

            switch(choice)
            {
                case 1 :
                    String sql = "select * from scoretable;";
                    ResultSet rs = st.executeQuery(sql);
                    System.out.println("ID\t| NAME\t| RUNS\t| BALLS\t");
                    while(rs.next())
                    {
                        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t");
                    }
                    break;
                case 2 :
                    //INSERT into scoretable VALUES(1,"KOHLI",100,50);
                    System.out.println("Enter the id");
                    int id = sc.nextInt();
                    System.out.println("Enter the name of the player");
                    String name = sc.next();
                    System.out.println("Enter the runs scored");
                    int runs = sc.nextInt();
                    System.out.println("Enter the balls taken");
                    int balls = sc.nextInt();

                    String str = "INSERT into scoretable VALUES("+id+",'"+name+"',"+runs+","+balls+");";
                    int rows = st.executeUpdate(str);
                    System.out.println(rows+"ROWS INSERTED");

                    break;
                case 3 :
                    //UPDATE scoretable set runs = 140 , balls = 70 WHERE id = 1
                    System.out.println("Enter the id of the player");
                    id = sc.nextInt();
                    System.out.println("Enter the runs to be edited");
                    runs = sc.nextInt();
                    System.out.println("Enter the balls played now");
                     balls = sc.nextInt();

                    String updateQuery = "UPDATE scoretable set runs = "+runs+", balls = "+balls+" WHERE id = "+id+" ; ";

                    rows = st.executeUpdate(updateQuery);
                    System.out.println(rows+"ROWS AFFECTED");
                    break;
                case 4 :
                    //DELETE scoretable WHERE id=1
                    System.out.println("Enter the id of the player");
                    id = sc.nextInt();

                    String deleteQuery = "DELETE from scoretable WHERE id="+id+";";

                    rows = st.executeUpdate(deleteQuery);
                    System.out.println(rows+"ROWS AFFECTED");
                    break;
                case 5 : break;
                default: flag = false; break;
            }

        }
    }
}
