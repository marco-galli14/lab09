package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * Sets the next string to print.
     * @param str the next string to print.
     * @throws IllegalArgumentException if str is null.
     */
    void setString(String str) throws IllegalArgumentException;

    /**
     * @return the next string to print.
     */
    String getNextString();

    /**
     * @return the history of the printed strings (in form of a `List` of `Strings`).
     */
    List<String> getHistory();

    /**
     * Prints the current string.
     * @throws IllegalStateException if the current string is unset.
     */
    void printCurrentString() throws IllegalStateException;
}
