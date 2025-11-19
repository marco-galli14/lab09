package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is an implementation of Controller.
 *
 */
public final class SimpleController implements Controller {

    private String str;
    private final List<String> history;

    /**
     * Create a new SimpleController: sets the current string as null and create the history List<String>.
     */
    public SimpleController() {
        this.str = "";
        this.history = new LinkedList<>();
    }

    @Override
    public void setString(final String stringa) {
        if (!"".equals(stringa)) {
            this.str = stringa;
            this.history.add(str);
        } else {
            throw new IllegalStateException("stringa cannot be null");
        }

    }

    @Override
    public String getNextString() {
        return this.str;
    }

    @Override
    public List<String> getHistory() {
        final List<String> ris = new LinkedList<>();
        ris.addAll(this.history);
        return ris;
    }

    @Override
    public void printCurrentString() {
        if (!"".equals(this.str)) {
            System.out.println(this.str); // NOPMD
        } else {
            throw new IllegalStateException("there's no current string");
        }
    }

}
