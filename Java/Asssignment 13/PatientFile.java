import java.io.*;

public class PatientFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("patient.txt");

            fw.write("Patient ID: P101\n");
            fw.write("Name: John\n");
            fw.write("Age: 35\n");
            fw.write("Diagnosis: Fever\n");

            fw.close();

            System.out.println("Patient details written to file.\n");

            FileReader fr = new FileReader("patient.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;

            System.out.println("Patient Details from File:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}