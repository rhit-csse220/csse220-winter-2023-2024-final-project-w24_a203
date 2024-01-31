package mainApp;

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
