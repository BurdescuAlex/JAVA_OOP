package Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AuditService {
    private static AuditService instance =new AuditService();
    private static Path logPath = Paths.get("src/Data/Log.txt");
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");


    private AuditService(){

    }

    public static AuditService getInstance()
    {
        return instance;
    }

    public void writeLog(String function)  {
        try {
            var outputLog = Files.newBufferedWriter(logPath,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Date currentDate =  formatter.parse(formatter.format(new Date() ));

            outputLog.write(function + "\t" + currentDate + "\n");

            outputLog.flush();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void writeSession()  {
        try {
            var outputLog = Files.newBufferedWriter(logPath,StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Date currentDate =  formatter.parse(formatter.format(new Date() ));

            outputLog.write("\n\n\n\t\tNEW SESSION" + "\t" + currentDate + "\n");

            outputLog.flush();
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
