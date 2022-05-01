package memory.memento;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Handle the memento (DTO file)
 * when save is called all the history updated is provided
 */
public class ResultOriginator {

    private List<ScreenMementoDTO> mementos = new ArrayList<>();

    /**
     * Keep the memory ready to be saved
     */
    public void keepStatusUpdated(List<ScreenMementoDTO> result) { mementos = result; }

    /**
     * Save a file from mementos using PrintWriter
     * @param fileToMemorize
     * @throws FileNotFoundException
     */
    public void save(File fileToMemorize) throws FileNotFoundException {
        if (fileToMemorize != null) {
            PrintWriter writer = new PrintWriter(fileToMemorize);
            for (ScreenMementoDTO s : mementos)
                writer.println(s.toString());

            writer.close();
        }
    }

    /**
     * Load the memento content
     * @return StringBuffer
     */
    public StringBuffer getMementoContent() {
        StringBuffer res = new StringBuffer();
        for (ScreenMementoDTO m : mementos) {
            res.append(m.toString());
            res.append("\n");
        }
        return res;
    }

    public List<ScreenMementoDTO> getMementos() {
        return mementos;
    }

    public void cleanMemento() {
        mementos.clear();
    }
}
