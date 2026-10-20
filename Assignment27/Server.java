import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Client: " + msg);
            if (msg.equalsIgnoreCase("exit")) break;
            System.out.print("Server: ");
            out.println(keyboard.readLine());
        }

        s.close();
        ss.close();
    }
}