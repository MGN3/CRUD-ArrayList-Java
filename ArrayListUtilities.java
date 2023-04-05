package practica2_MarcelinoGil;

import java.util.ArrayList;

public class ArrayListUtilities {

	/** This method shows the first attribute(name) of each Technology */
	public static void showNames(ArrayList<Technology> ArrayList) {
		int arraySize = ArrayList.size();

		for (int i = 0; i < arraySize; i++) {
			System.out.println("Tech number " + (i + 1) + ": " + ArrayList.get(i).getTechName());

		}
	}

}
