import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;


public class game {
	
	public static void main (String[] args) {
		Terminal terminal = TerminalFacade.createTerminal();
        terminal.enterPrivateMode();
        //TerminalSize terminalSize = terminal.getTerminalSize();
        int x = 5;
        int y = 5;
        terminal.setCursorVisible(false);
        terminal.moveCursor(x,y);
		terminal.putCharacter('@');
        while(true) {
        	Key key = terminal.readInput();
        	if (key != null) {
        		if (key.getKind() == Key.Kind.ArrowUp) {
        			y = y - 1;
        		}
        		if (key.getKind() == Key.Kind.ArrowDown) {
        			y = y + 1;
        		}
        		if (key.getKind() == Key.Kind.ArrowLeft) {
        			x = x - 1;
        		}
        		if (key.getKind() == Key.Kind.ArrowRight) {
        			x = x + 1;
        		}
        		if (key.getKind() == Key.Kind.Escape) {
        			System.exit(0);
        		}
        		terminal.clearScreen();
        		terminal.moveCursor(x,y);
        		terminal.putCharacter('@');
        	}
		}
    }
}