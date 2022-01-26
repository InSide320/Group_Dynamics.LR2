import logger_file.FileLogger;
import medicine.Medicine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        FileLogger fileLogger = new FileLogger();
        List<Medicine> list = new ArrayList<>();

        list.add(new Medicine("No-spa", 20.01, true));
        list.add(new Medicine("Amizon", 50.1, false));
        list.add(new Medicine("Ugol", 10.1, false));
        list.add(new Medicine("tovar", 15.25, false));
        fileLogger.bufferedWriteInFile(list);
        fileLogger.bufferedReadFile();
    }
}
