package logger_file;

import medicine.Medicine;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogger {
    private static final String NAME_FILE = "src\\main\\java\\logger_file\\loggerFile.txt";
    Logger logger = Logger.getGlobal();

    public void bufferedWriteInFile(List<Medicine> medicine) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(NAME_FILE, false))) {
            for (int i = 0; i < medicine.size(); i++) {
                medicine.sort(Comparator.comparingDouble(Medicine::getPrice));
                if (!medicine.get(i).isAvailability()) {
                    bufferedWriter.write(medicine.get(i) + "\n");
                }
            }

            bufferedWriter.newLine();
            bufferedWriter.newLine();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }
    }

    public void bufferedReadFile() {
        String value;
        List<Medicine> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(NAME_FILE))) {
            while ((value = bufferedReader.readLine()) != null) {
                System.out.println(value);
            }
        } catch (IOException | RuntimeException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }

        System.err.println("Logs uploaded to the app!");
    }
}
