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
        this.str = null;
        this.history = new LinkedList<>();
    }

    @Override
    public void setString(final String stringa) {
        try {
            this.str = stringa;
        } catch (final IllegalArgumentException e) {
            System.err.println(e); // NOPMD
        }
        this.history.add(str);
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
        try {
            System.out.println(this.str); // NOPMD
        } catch (final IllegalStateException e) {
            System.err.println(e); // NOPMD
        }
    }

}
