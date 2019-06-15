package servlet;

public class ChecPopulation {
	public static boolean checkMath(String population){
		try {
			Integer.parseInt(population);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
