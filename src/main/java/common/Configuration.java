package common;

/**
 * Project Configuration file that contains useful constants.
 */
public class Configuration {

    // GUI
    public static final String TITLE_MAIN = "Calculator";
    public static final String CONFIGURATION_TITLE = "Configuration";

    public static final int DEFAULT_MEM_SIZE = 50;
    public static final int MIN_MEM_SIZE = 3;
    public static final int MAX_MEM_SIZE = 100;
    public static final String MEMORY_SIZE_DIALOG_TEXT = "Memory size value : ";
    public static final String MEMORY_SIZE_DIALOG_BUTTON = "OK";

    public static final String PRINTER_DIALOG_BUTTON = "OK";
    public static final String PRINT_TITLE = "Memory printing ..";
    public static final String PRINTER_WITH_THIS = "Following printer was selected to print the memory : ";
    public static final String PRINTER_INITIATE_TASK = "Initiate print task";
    public static final String PRINTER_FAILED = "Print task failed.";

    // MEMORY MEDIATOR (backend's persistence)
    public static final String DEFAULT_DIRECTORY = "user.home";
    public static final String FILE_TYPE = "*.txt";
    public static final String FILE_TYPE_DESCRIPTION = "text file";
    public static final String EXPRESSION_SEPARATOR = " = ";
    public static final String EXPRESSION_TYPE_SEPARATOR = " : ";

    // MEMENTO DTO (cross packages)
    public static String ERROR_MSG_RESULT_STRUCTURE = "invalid String structure to marshall to screen memento";

}
