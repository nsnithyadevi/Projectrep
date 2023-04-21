package com.example.MyProject;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.*;

public class ConDBRSToHTML {
    public static void main(String args[])  {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:port:xe", "usern", "pass");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from emp");
            String htmlTable = resultSetToHtmlTable(rs);
            System.out.println(htmlTable);

            //ResultsetToHTML rs = stm.executeQuery("Select * from emp");
            //while (rs.next()){
            //    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            // }

            rs.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }


    //Converts a ResultSet object to an HTML table
    private static String resultSetToHtmlTable(ResultSet rs) throws SQLException{
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.println("<html>");
        pw.println("<Head>");
        pw.println("<Title> Result Set to HTML Table </title>");
        pw.println("</Head>");
        pw.println("<body>");
        pw.println("<table>");

// Get the metadata of the result set
        ResultSetMetaData metadata = rs.getMetaData();
        int columnCount = metadata.getColumnCount();

        // Print the table headers
        pw.println("<tr>");
        for (int i=0;i<=columnCount; i++) {
            pw.println("<th>" + metadata.getColumnName(i) + "</th>" );
        }
        pw.println("</tr>");

        // Print the table rows
        while (rs.next()) {
            pw.println("<tr>");
            for (int i = 0; i <= columnCount; i++) {
                pw.println("<td>" +rs.getString(i)+ "</td>");
            }
            pw.println("</tr>");
        }
        pw.println("</body>");
        pw.println("</table>");
        pw.println("</html>");

        return sw.toString();
    }
}
