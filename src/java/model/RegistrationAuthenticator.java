package model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationAuthenticator 
{
        public boolean isRegister(UserDTO user)
        {
            String eid = user.getEid();
            String username = user.getUsername();
            String password = user.getPassword();
            String salary = user.getSalary();
            String city = user.getCity();
            int i=0;
            try
            {
                Statement st = DBConnector.getStatement ();
                String query = "INSERT INTO emp(empid,empname,emppassword,empsalary,empcity) VALUES('"+eid+"','"+username+"','"+password+"','"+salary+"','"+city+"')";
                System.out.println("Query = "+query);
                
                i = st.executeUpdate(query);
                
                
            } 
            catch(Exception e)
            {
                System.out.println(e);
            }
            
                if(i>0)
                {
                    System.out.println(i+" Query inserted!");
                    return true;
                }
                else
                {
                    System.out.println("Query Insertion failed!");
                    return false;
                }
        }
}
