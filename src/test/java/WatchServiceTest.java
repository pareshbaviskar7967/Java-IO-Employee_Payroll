import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class WatchServiceTest {
    @Test
    public void givenDirectoryWhenWatchedListsAllTheActivites() throws IOException {
        Path path = Paths.get("C:/Users/iamat/eclipse-workspace/Employee-Payroll/lib");
        Files.list(path).filter(Files::isRegularFile).forEach(System.out::println);
        new WatchServiceExample(path);
    }
}