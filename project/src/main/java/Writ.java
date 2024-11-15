import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;

public class Writ

public class CreateFile
{
    public String determineSaveLocation()
     {
        String workingDir;
        String OS = (System.getProperty("os.name")).toUpperCase();

        if (OS.contains("WIN"))
        {
            workingDir = System.getenv("AppData");
        }
        else
        {
            workingDir = System.getProperty("user.home");
            workingDir += "/Library/Application Support";
        }
        return workingDir;
     }

    public void create ()
    {
        String destination = determineSaveLocation();
        File file = new File(destination + "/com.tcs.Untitled-command-line-game/save.txt"); // Specify the path within the /res directory

        if (!file.exists()) {
            try {
                // Ensure the directories in the path are created if they don't exist
                boolean mkdirWorks = file.getParentFile().mkdirs();
                System.out.println("mkdirs: " + mkdirWorks);
                
                file.createNewFile();
                System.out.println("File created: " + file.getPath());
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists. No action taken.");

        }

    }
    
}