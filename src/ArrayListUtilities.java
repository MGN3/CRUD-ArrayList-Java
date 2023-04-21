package practica2_MarcelinoGil;

import java.util.ArrayList;

public class ArrayListUtilities {

	/**
	 * This method shows the first attribute(name) of each Technology
	 * 
	 * @param ArrayList The ArrayList of Technology objects
	 */
	public static void showNames(ArrayList<Technology> ArrayList) {
		try {
			int arraySize = ArrayList.size();

			for (int i = 0; i < arraySize; i++) {
				System.out.println("Tech number " + (i + 1) + ": " + ArrayList.get(i).getTechName());

			}
		} catch (NullPointerException e) {
			// In this catch I show different messages.
			System.out.println("NullPointerException caught: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
