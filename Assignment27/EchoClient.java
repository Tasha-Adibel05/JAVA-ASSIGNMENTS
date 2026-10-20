import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5001);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        System.out.print("Enter message: ");
        String msg = keyboard.readLine();

        out.println(msg);
        System.out.println("Echo from server: " + in.readLine());

        s.close();
    }
}