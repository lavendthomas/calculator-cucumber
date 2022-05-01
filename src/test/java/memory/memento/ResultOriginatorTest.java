package memory.memento;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import static java.nio.file.Path.of;
import static org.junit.jupiter.api.Assertions.*;

class ResultOriginatorTest {

    private final ResultOriginator originator = new ResultOriginator();

    @Test
    void save_path_not_found() {
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> {
            originator.save(new File("/"));
        });

        assertNotNull(thrown.getMessage());
    }

    @Test
    void save_file() throws IOException {
        String PATH_TO_SAVE = "src/test/resources/saved_file.txt";
        File file_to_save = new File(PATH_TO_SAVE);
        originator.save(file_to_save);
        assertTrue(Files.exists(of(PATH_TO_SAVE)));
        Files.delete(of(PATH_TO_SAVE));
        assertFalse(Files.exists(of(PATH_TO_SAVE)));
    }

}
