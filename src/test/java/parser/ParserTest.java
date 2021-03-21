package parser;

import command.Command;
import command.DisplayMenusCommand;
import command.DisplayStoresCommand;
import command.ExitCommand;
import command.ReadReviewsCommand;
import exceptions.DukeExceptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ParserTest {

    private int maxStores = 1;

    @Test
    public void parse_list_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("list","1", maxStores);
        assertTrue(c instanceof DisplayStoresCommand);
    }

    @Test
    public void parse_menu_success() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("menu 1","1", maxStores);
        assertTrue(c instanceof DisplayMenusCommand);
    }

    @Test
    public void parse_menuExceedStoreIndex_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parse("menu 5","1", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'menu' command.", e.getMessage());
        }
    }

    @Test
    public void parse_menuNoNumbers_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parse("menu abc","1", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'menu' command.", e.getMessage());
        }
    }

    @Test
    public void parse_exit_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("exit","1", maxStores);
        assertTrue(c instanceof ExitCommand);
    }

    @Test
    public void parse_faultyCommand_throwException() {
        Parser parser = new Parser();
        assertThrows(DukeExceptions.class, () -> {
            Command c = parser.parse("RandomInput","1", maxStores);
        });
    }

    @Test
    public void parse_read_displayCommand() throws DukeExceptions {
        Parser parser = new Parser();
        Command c = parser.parse("read 1","1", maxStores);
        assertTrue(c instanceof ReadReviewsCommand);
    }

    @Test
    public void parse_readIndexExceedReviewNo_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parse("read 5","1", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'read' command.", e.getMessage());
        }
    }

    @Test
    public void parse_readIndexNoNumbers_exceptionThrown() {
        Parser parser = new Parser();
        try {
            Command c = parser.parse("read hi","1", maxStores);
        } catch (Exception e) {
            assertEquals("Invalid index! Please enter a valid index for your 'read' command.", e.getMessage());
        }
    }


}