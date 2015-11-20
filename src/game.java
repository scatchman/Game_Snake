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
		int direction = 4; //1 - up. 2 - left. 3 - down. 4 - right.
        while(true) {
        	Key key = terminal.readInput();
        	if (key != null) {
        		if (key.getKind() == Key.Kind.ArrowUp) {
        			if (direction != 3)
        			direction = 1;
        		}
        		if (key.getKind() == Key.Kind.ArrowDown) {
        			if (direction != 1)
        			direction = 3;
        		}
        		if (key.getKind() == Key.Kind.ArrowLeft) {
        			if (direction != 4)
        			direction = 2;
        		}
        		if (key.getKind() == Key.Kind.ArrowRight) {
        			if (direction != 2)
        			direction = 4;
        		}
        		if (key.getKind() == Key.Kind.Escape) {
        			System.exit(0);
        		}
        		
        	}
        	
        	terminal.clearScreen();
    		if (direction == 1)
    			y = y - 1;
    		if (direction == 3)
    			y = y + 1;
    		if (direction == 2)
    			x = x - 1;
    		if (direction == 4)
    			x = x + 1;
    		terminal.moveCursor(x,y);
    		terminal.putCharacter('@');
    		try {
        	    Thread.sleep(500);                 //0,5 sec
        	} catch(InterruptedException ex) {
        	    Thread.currentThread().interrupt();
        	}
		}
    }
}