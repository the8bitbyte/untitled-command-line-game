import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile
{
    public void save(String saveData, String dest)
    {
        File file = new File(dest);
        String content = saveData;

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}