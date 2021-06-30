import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileOperations {
    public static void main(String[] args) {
        File file = new File("myfile.txt");
        if (file.exists())
            System.out.println("file exists.");
        else
            System.out.println("file does not exists.");

        File myfile = new File("myfile.txt");
        System.out.println("New file has been created with name " + myfile);

        try {
            myfile.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create file.");
            e.printStackTrace();
        }

        File file1 = new File("myfile.txt");
        if (file1.delete()) {
            System.out.println("File deleted." + file1.getName());
        } else {
            System.out.println("Error occured.");
        }

        try {
            Path path = Paths.get("C:/Users/pares/eclipse-workspace/Employee-Payroll/lib/files");
            Files.createDirectory(path);
            System.out.println("Directory created.");
        } catch (IOException e) {
            System.out.println("Failed to create directory at location, " + e.getMessage());
        }

        System.out.println();

        String pathName = "C:/Users/pares/eclipse-workspace/Employee-Payroll/lib";
        try {
            List<File> files = Files.list(Paths.get(pathName))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            files.forEach(System.out::println);
        } catch (IOException e) {
        }
    }
}