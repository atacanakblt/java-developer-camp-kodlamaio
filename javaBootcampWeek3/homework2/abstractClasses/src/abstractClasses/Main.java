package abstractClasses;

public class Main {

	public static void main(String[] args) {
		
		WomanGameCalculator womenGameCalculator = new WomanGameCalculator();
		womenGameCalculator.hesapla();
		womenGameCalculator.gameOver();
		
		GameCalculator gameCalculator = new WomanGameCalculator();
		
		
	}

}
