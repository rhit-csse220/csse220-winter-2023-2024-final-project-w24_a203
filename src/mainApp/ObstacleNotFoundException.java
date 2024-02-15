package mainApp;

/*
 * Class: ObstacleNotFoundException
 * Purpose: This is our custom exception handling. If a file
 * being loaded isn't up to "spec" as is required for game, this
 * error gets thrown.
 */
public class ObstacleNotFoundException extends Exception {

	char letter;

	public ObstacleNotFoundException(char letter) {
		this.letter = letter;
	}

	@Override
	public String getMessage() {
		return "\nObstacleNotFoundException: " + this.letter + " is not a valid game component.";
	}
}
