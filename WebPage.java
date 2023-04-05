package practica2_MarcelinoGil;

import java.util.ArrayList;
import java.util.Date;

public class WebPage {

	private String webName;
	private String url;
	private int budget;
	private ArrayList<Technology> techStack = new ArrayList<Technology>();

	/**
	 * This constructor receives every attribute except the ArrayList of
	 * technologies. If we want to add a new add a Technology into the WebPage's
	 * ArrayList, we have to create a method for that purpose.
	 */
	public WebPage(String webName, String url, int budget) {
		super();
		this.webName = webName;
		this.url = url;
		this.budget = budget;
	}

	/**
	 * Constructor overloading, in this case we include the ArrayList.
	 */
	public WebPage(String webName, String url, int budget, ArrayList<Technology> techStack) {
		super();
		this.webName = webName;
		this.url = url;
		this.budget = budget;
		this.techStack = techStack;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public ArrayList<Technology> getTechStack() {
		return techStack;
	}

	public void setTechStack(ArrayList<Technology> techStack) {
		this.techStack = techStack;
	}

	@Override
	public String toString() {
		return "WebPage [webName=" + webName + ", url=" + url + ", budget=" + budget + ", techStack=" + techStack + "]";
	}

	/**
	 * <ul>
	 * <li>One of the ways to include a Technology into the atribbute ArrayList of
	 * the object WebPage The object Technology is supossed to be already
	 * created/availeable to be added.
	 * </ul>
	 *
	 * @param tech The Technology object to be added to the ArrayList
	 */
	public void addTechnology(Technology tech) {
		techStack.add(tech);
	}

	/**
	 * <ul>
	 * <li>Overloading the method addTechnology. This time, the attributes of the
	 * Technology object must be specified oen by one to create it and then add it
	 * into the ArrayList
	 * </ul>
	 *
	 * @param techName
	 * @param techType
	 * @param purpose
	 * @param releaseYear
	 * @param license
	 */
	public void addTechnology(String techName, String techType, String purpose, int releaseYear, String license) {
		techStack.add(new Technology(techName, techType, purpose, releaseYear, license));
	}

	/**
	 * <ul>
	 * <li>Overloading the method addTechnology.
	 * <li>In this case, the new Technology will be created with the user imput.
	 * </ul>
	 * 
	 */
	public void addTechnology() {
		String techName = "";
		String techType = "";
		String purpose = "";
		int releaseYear = 0;
		String license = "";

		techStack.add(new Technology(techName = Utilities.getString("Set Technology name: "),
				techType = Utilities.getString("Set Technology type: "),
				purpose = Utilities.getString("Set Technology purpose: "),
				releaseYear = Utilities.getIntBetween(1900, 2050, "Introduce the Technology release year: "),
				license = Utilities.getString("Set Technology license: ")));
	}

	// continuar aqui//NO FUNCIONA, parece un bucle infinito.
	public Technology searchTechByName(String dataRequested) {
		Technology returnTech = null;
		boolean dataFound = false;

		for (Technology tech : techStack) {
			if (dataRequested.equals(tech.getTechName())) {
				returnTech = tech;
				dataFound = true;
			}

		}

		return returnTech;
	}

	/**
	 * <ul>
	 * <li>This method shows the content of each Technology where the data have been
	 * found.
	 * <li>The Object/Technology data is converted to lower case, as well as the
	 * dataRequest String, as an attempt to increase the chances of finding the
	 * data.
	 * </ul>
	 *
	 * @param dataRequest The String that wants to be found.
	 * 
	 */
	public void findAllMatches(String dataRequest) {

		boolean dataFound = false;
		int arrayListSize = techStack.size();

		// First, we make sure that the ArrayList is not empty.
		if (arrayListSize == 0) {
			System.out.println("The list of Technologies for the WebPage '" + webName + "' is empty.");

		} else {
			for (Technology tech : techStack) {
				/*
				 * The object is set as a lower case String to find if it includes the
				 * datarequested(also in lower case) Instead of ".toString()", ".contains()"
				 * could have been an option.
				 */
				if (tech.toString().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
					System.out.println(tech.toString());
					dataFound = true;
				}
			}
			if (!dataFound) {
				System.out.println("No matches found");
			}

		}
	}

	/**
	 * <ul>
	 * <li>This method shows only the first object where the data was found,
	 *
	 * <li>The Object/Technology data is converted to lower case, as well as the
	 * dataRequest String, as an attempt to increase the chances of finding the
	 * data.
	 * </ul>
	 *
	 * @param dataRequest The String that wants to be found.
	 * 
	 */
	public int findFirstMatch(String dataRequest) {

		boolean dataFound = false;
		int arrayListSize = techStack.size();
		int count = 0;// ---------------------------------------

		if (techStack.size() == 0) {
			System.out.println("The list of Technologies for the WebPage '" + webName + "' is empty.");

		} else {

			while (!dataFound && count < arrayListSize) {

				/*
				 * The object is set as a lower case String to find if it includes the
				 * datarequested(also in lower case) Instead of ".toString()", ".contains()"
				 * could have been an option.
				 */
				if (techStack.get(count).toString().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
					System.out.println("Match found: " + techStack.get(count));
					dataFound = true;
				}
				if (!dataFound) {
					count++;
				}
			}

		}
		// Two returns possible: -1 if dataRequest is not found, or the index of the
		// ArrayList position where data was found.
		if (!dataFound) {
			System.out.println("No matches found");
			count = -1;
		}
		return count;
	}

	public int findFirstMatch(String dataRequest, int attribute) {

		boolean dataFound = false;
		int arrayListSize = techStack.size();
		int count = 0;

		// Checking if ArrayList is empty.
		if (techStack.size() == 0) {
			System.out.println("The list of Technologies for the WebPage '" + webName + "' is empty.");

		} else {

			// Loop that keeps iterating through each ArrayList position checking a specific
			// attribute.
			while (!dataFound && count < arrayListSize) {

				switch (attribute) {

				case 1:
					// Both the attribute and dataRequest are converted to lower case and then
					// indexOf will check if dataRequest subString exists inside the Attribute.
					if (techStack.get(count).getTechName().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
						System.out.println("First match for '" + dataRequest + "' is: "
								+ techStack.get(count).getTechName() + ", which is part of: \n" + techStack.get(count));
						dataFound = true;
					}
					break;

				case 2:
					if (techStack.get(count).getTechType().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
						System.out.println("First match for '" + dataRequest + "' is: "
								+ techStack.get(count).getTechType() + ", which is part of: \n" + techStack.get(count));
						dataFound = true;
					}
					break;

				case 3:
					if (techStack.get(count).getPurpose().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
						System.out.println("First match for '" + dataRequest + "' is: "
								+ techStack.get(count).getPurpose() + ", which is part of: \n" + techStack.get(count));
						dataFound = true;
					}
					break;

				case 4:
					// Convert the int attribute into a String and use .contains() against
					// dataRequest.
					if (String.valueOf(techStack.get(count).getReleaseYear()).contains(dataRequest)) {
						System.out.println(
								"First match for '" + dataRequest + "' is: " + techStack.get(count).getReleaseYear()
										+ ", which is part of: \n" + techStack.get(count));
						dataFound = true;
					}
					break;

				case 5:
					if (techStack.get(count).getLicense().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
						System.out.println("First match for '" + dataRequest + "' is: "
								+ techStack.get(count).getLicense() + ", which is part of: \n" + techStack.get(count));
						dataFound = true;
					}
					break;

				default:
					System.out.println("Invalid imput");
					break;
				}
				// IMPORTANT: this is the variable returned and its increased in each loop if
				// dataRequest is not found.
				if (!dataFound) {
					count++;
				}

			}
		}
		// Two returns possible: -1 if dataRequest is not found, or the index of the
		// ArrayList position where data was found.
		if (!dataFound) {
			System.out.println("No matches found");
			count = -1;
		}
		return count;
	}

	public void removeArrayList() {

		if (techStack.size() > 0) {
			techStack.removeAll(techStack);
		} else {
			System.out.println("There are no Technologies to be removed.");
		}
	}

	///////////// SEGUIR AQUI
	public Technology search(WebPage web) {
		/*
		 * private String techName; private String techType; private String purpose;
		 * private int releaseYear; private String license;
		 */
		Technology tech = new Technology(null, null, null, 0, null);

		// tech=web.findFirstMatch(Utilities.getString("What do you want to find"));

		return tech;
	}

	/**
	 * <ul>
	 * <li>This method shows only the first object where the data was found,
	 *
	 * <li>The Object/Technology data is converted to lower case, as well as the
	 * dataRequest String, as an attempt to increase the chances of finding the
	 * data.
	 * </ul>
	 *
	 * @deprecated
	 * 
	 */
	public void showAllArrayList() {

		int arrayListSize = techStack.size();

		if (techStack.size() == 0) {
			System.out.println("The list of Technologies for the WebPage '" + webName + "' is empty.");
		} else {

			for (int i = 0; i < arrayListSize; i++) {
				System.out.println(techStack.get(i));
			}
		}
	}

	public Technology search(int whichAttribute, String findThis) {
		/*
		 * private String techName; private String techType; private String purpose;
		 * private int releaseYear; private String license;
		 */
		for (Technology tech : techStack) {

		}

		return techStack.get(0);
	}

	/*
	 * public static ArrayList<WebPage> webPageArray(int amountWebs, int
	 * amountTechs) { ArrayList<WebPage> webPageArray = new ArrayList<WebPage>(); //
	 * este arraylist absorve cada add, aunque provenga del bucle correspondiente a
	 * // otra web, por lo que la segunda web tiene todas las anteriores techs
	 * ArrayList<Technology> techStack = new ArrayList<Technology>();
	 * 
	 * System.out.println("Introduce data for the web main atributes: "); for (int i
	 * = 0; i < amountWebs; i++) { System.out.println("Add web number: '" + (i + 1)
	 * + "'"); webPageArray.add(new
	 * WebPage(Utilities.getString("Introduce the name of the webpage"),
	 * Utilities.getString("Introduce the URL name"), Utilities.getIntBetween(1,
	 * 9999999, "Introduce the budget: "), techStack)); for (int j = 0; j <
	 * amountTechs; j++) { System.out.println("Add Technology number: '" + (j + 1) +
	 * "'"); techStack.add(new
	 * Technology(Utilities.getString("Set Technology name"),
	 * Utilities.getString("Set Technology type: "),
	 * Utilities.getString("Set Technology purpose"))); } }
	 * 
	 * return webPageArray;
	 * 
	 * }
	 */
	/*
	 * public void createMultipleWebPages(int numberOfWebPages) { for (int i = 0; i
	 * < numberOfWebPages; i++) { String webname = "Web Page " + i; String url =
	 * "http://www.webpage" + i + ".com"; int budget = 1000 * i;
	 * ArrayList<Technology> technologies = new ArrayList<Technology>();
	 * technologies.add(new Technology("Technology 1", "Type 1", "Purpose 1"));
	 * technologies.add(new Technology("Technology 2", "Type 2", "Purpose 2"));
	 * WebPage newWebPage = new WebPage(webname, url, budget, new
	 * ArrayList<Technology>(technologies)); // Aquí iría el código para guardar la
	 * nueva página web en la base de datos } }
	 */
	/*
	 * public static void createTechnologies(int numberOfWebPages) { String webName;
	 * String url; int budget; for (int i = 0; i < numberOfWebPages; i++) {
	 * ArrayList<Technology> techStack = new ArrayList<Technology>();
	 * techStack.add(new Technology(Utilities.getString("Set techName: "),
	 * Utilities.getString("Set techType: "),
	 * Utilities.getString("Set purpose: "))); techStack.add(new
	 * Technology("Technology 2", "Type 2", "Purpose 2")); WebPage newWebPage = new
	 * WebPage(webName = Utilities.getString("Set web Name: "), url =
	 * Utilities.getString("Set web URL: "), budget = Utilities.getIntBetween(1,
	 * 99999999, "Set butget amout: "), new ArrayList<Technology>(techStack)); //
	 * Aquí iría el código para guardar la nueva página web en la base de datos } }
	 */

	// ---------------PRUEBA METODO ESTATICO VS NO ESTATICO-----------------
	// El metodo static no puede usar atributos de una clase, suele ser util para
	// clases de tipo utilidad, funciones auxiliares.
	public static ArrayList<WebPage> webArrayList(int websNumber) {
		ArrayList<WebPage> webs = new ArrayList<WebPage>();
		ArrayList<Technology> techStack = new ArrayList<Technology>();

		for (int i = 0; i < websNumber; i++) {
			System.out.println("WebPage number " + (i + 1));
			System.out.print("Ingrese el nombre del objeto: ");
			webs.add(new WebPage(Utilities.getString("Introduce the name of the web: "),
					Utilities.getString("Introduce the URL: "),
					Utilities.getIntBetween(1, 10000000, "Introduce the budget of the project: "), techStack));
		}

		return webs;
	}
}
