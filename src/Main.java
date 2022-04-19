import javax.swing.*;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = " ";
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        String wordArray[];

        ArrayList<String> lines = new ArrayList<>();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.OPEN_DIALOG);
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready())
                {
                   rec = reader.readLine();
                   lineCount++;
                   wordArray = rec.split(" ");
                   charCount += rec.length();
                   wordCount += wordArray.length;
                }
                System.out.println("The current working directory is: " + selectedFile);
                System.out.println("There are " + lineCount + " lines.");
                System.out.println("There are " + wordCount + " words.");
                System.out.println("There are " + charCount + " characters.");
                reader.close();
                System.out.println("\n\nData file read!");
            }
            
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
