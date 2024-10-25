import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile
{
    public void save(String saveData)
    {
        File file = new File("save" + File.separator + "output.txt");
        String content = saveData;

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}