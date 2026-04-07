import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class KopiranjeByteFilea {
    public static void main(String[] args) {
        File ulazniFile = new File("dokument.pdf");   // može biti bilo koja binarna datoteka
        File zapis = new File("kopija.pdf");

        try (FileInputStream ulaz = new FileInputStream(ulazniFile);
             FileOutputStream izlaz = new FileOutputStream(zapis)) {

            byte[] buffer = new byte[1024];  // čitamo po 1 KB blokova
            int bytesRead;
            while ((bytesRead = ulaz.read(buffer)) != -1) {
                izlaz.write(buffer, 0, bytesRead);
            }

            System.out.println("Datoteka je uspješno kopirana!");

        } catch (IOException e) {
            System.err.println("Greška pri kopiranju datoteke: " + e.getMessage());
        }
    }
}
