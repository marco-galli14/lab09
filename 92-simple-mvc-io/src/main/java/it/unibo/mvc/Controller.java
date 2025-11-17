package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT = System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt";
    
    private File file;

    /**
     * The constructor sets the file as default "output.txt"
     */
    public Controller() {
        this.file = new File(DEFAULT);
    }

    /**
     * Sets the current file of the Controller as "corrente"
     * 
     * @param corrente the new current File of the Controller
     */
    public void setFile(final File corrente) {
        this.file = corrente;
    }

    public File getFile() {
        return this.file;
    }

    public Path getPath() {
        return this.file.toPath();
    }

    public void writeString(final String parola) {
        try (PrintStream o = new PrintStream(this.file, StandardCharsets.UTF_8)) {
            o.print(parola);
        } catch (IOException e) {
            System.err.println(e); // NOPMD
        }
    }
    
}
