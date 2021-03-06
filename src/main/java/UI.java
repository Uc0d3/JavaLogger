import logger.io.LogsReader;
import logger.model.Log;
import logger.model.LogType;

import java.io.IOException;
import java.util.*;

import static logger.model.LogType.SEVER;

public class UI {

    static Scanner scanner = new Scanner(System.in);
    LogsReader logsReader;

    public UI(String filename) throws IOException {
        this.logsReader = new LogsReader(filename);
        logsReader.readLogs();
    }


    public static void printMenu() {
        System.out.println("1 -  Anzeige die Logs bei Typ");
        System.out.println("2 -  Anzeige der am häufigsten Log Meldungen für Type = SEVERE");
        System.out.println("3 -  Anzeige die Logs, die in den letzten 10 Tagen geschrieben wurden;\n");
    }

    public void start() {
        printMenu();

        while (true) {
            System.out.println("Optiune:");
            int opt = scanner.nextInt();

            if (opt == 1) {
                System.out.println("Bitte den Typ der Error wahlen :");
                System.out.println("INFO, ERROR, DEBUG, SEVER, WARN, CONFIG, FINE, FINER, FATAL");
                String logType = scanner.next();
                List<String> logs  = logsReader.getByType(LogType.valueOf(logType));
                System.out.println(String.join("\n",logs));

            }
            else if (opt == 2) {
                List<String> logs  = logsReader.getByType(LogType.SEVER);
                System.out.println(String.join("\n",logs));

            }
            else if (opt == 3) {
                Date date = new Date();
                Map<LogType, List<Log>> map = logsReader.getLogMap();
                map.entrySet().stream().filter(log -> log.getValue().);



            }
        }

    }
