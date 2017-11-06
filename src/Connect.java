import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

@WebServlet(name = "Connect", urlPatterns = { "/connect" })
public class Connect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Driver d = new SQLServerDriver();
        String connectionUrl = "jdbc:sqlserver://localhost:1401;databaseName=Test;user=sa;password=<YourStrong!Passw0rd>";

        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = d.connect(connectionUrl, new Properties())) {
                System.out.println("Done.");
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}
