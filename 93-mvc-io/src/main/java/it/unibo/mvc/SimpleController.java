package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is an implementation of Controller.
 *
 */
public final class SimpleController implements Controller {

    private String str;
    private List<String> history;

    /**
     * Create a new SimpleController: sets the current string as null and create the history List<String>.
     */
    public SimpleController() {
        this.str = null;
        this.history = new LinkedList<>();
    }

    @Override
    public void setString(String str) throws IllegalArgumentException{
        this.str = str;
    }

    @Override
    public String getNextString() {
        return this.str;
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void printCurrentString() throws IllegalStateException {
        System.out.println(this.str);
    }

}
