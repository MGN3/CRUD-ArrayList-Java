package practica2_MarcelinoGil;

import java.util.ArrayList;

/**
 * @description This class contains the attributes of WebPage and the basic
 *              predefined methods. The class also contains the methods to
 *              implement the CRUD functionalities. The method findFirstMach()
 *              is one of the most important of them all, because it is reused
 *              in other methods a functionalities.
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 09/04/2023
 */
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
		try {
			techStack.add(tech);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("The index is out of valid range: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("The object to be added is null: " + e.getMessage());
		}
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
		try {
			techStack.add(new Technology(techName, techType, purpose, releaseYear, license));
		} catch (Exception e) {
			System.out.println("An error has occurred while adding the technology: " + e.getMessage());
		}
	}

	/**
	 * <ul>
	 * <li>Overloading the method addTechnology.
	 * <li>In this case, the new Technology will be created with the user input.
	 * </ul>
	 * 
	 */
	public void addTechnology() {
		try {
			techStack.add(new Technology(Utilities.getString("Set Technology name: "),
					Utilities.getString("Set Technology type: "), Utilities.getString("Set Technology purpose: "),
					Utilities.getIntBetween(1900, 2050, "Introduce the Technology release year: "),
					Utilities.getString("Set Technology license: ")));
		} catch (Exception e) {
			System.out.println("An error has occurred while adding the technology: " + e.getMessage());
		}

	}

	/**
	 * <ul>
	 * <li>This method recieves an ArrayList of Technologies and each of them will
	 * be enumerated and shown and they can be added by entering the corresponding
	 * number.
	 * </ul>
	 *
	 * @param premadeTechs An ArrayList of premade Technology objects
	 */
	public void addPremadeTech(ArrayList<Technology> premadeTechs) {
		try {
			boolean containsTechnology;
			int arrayListIndex;
			char doSomethingElse;

			do {
				ArrayListUtilities.showNames(premadeTechs);

				containsTechnology = techStack.contains(premadeTechs.get(arrayListIndex = Utilities.getIntBetween(1,
						(techStack.size() + 1), "Enter the number of the tech you want to add?") - 1));

				if (!containsTechnology) {
					System.out.println("The following Technology have been added: '"
							+ premadeTechs.get(arrayListIndex).getTechName() + "'.");
					techStack.add(premadeTechs.get(arrayListIndex));
				} else {
					System.out.println("This Technology has already been added.");
				}

				doSomethingElse = Utilities.getCharMenu('y', 'n', "Do you want to add another Technology?");

			} while (doSomethingElse != 'n');
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error al agregar una tecnología premade: " + e.getMessage());
		}
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
		try {
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
		} catch (Exception e) {
			System.out.println("An error has occurred while searching for matches: " + e.getMessage());
		}
	}

	/**
	 * <ul>
	 * <li>This method shows only the first object where the data was found.
	 *
	 * <li>The Object/Technology data is converted to lower case, as well as the
	 * dataRequest String, to increase the chances of finding the. data.
	 * </ul>
	 *
	 * @param dataRequest The String that wants to be found.
	 * @return count The position in the ArrayList where the first match has been
	 *         found.
	 */
	public int findFirstMatch(String dataRequest) {
		boolean dataFound = false;
		int arrayListSize = techStack.size();
		int count = 0;// ---------------------------------------

		try {
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

			if (!dataFound) {
				System.out.println("No matches found");
				count = -1;
			}
			return count;
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}

	/**
	 * <ul>
	 * <li>This method shows only the first object where the data was found.
	 *
	 * <li>The Object/Technology data is converted to lower case, as well as the
	 * dataRequest String, to increase the chances of finding the data.
	 * </ul>
	 *
	 * @param dataRequest The String that wants to be found.
	 * @param attribute   Indicates in which attribute dataRequest is going to be
	 *                    searched.
	 * 
	 * @return count The position in the ArrayList where the first match has been
	 *         found.
	 */
	public int findFirstMatch(String dataRequest, int attribute) {

		boolean dataFound = false;
		int arrayListSize = techStack.size();
		int count = 0;

		try {
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
							System.out.println(
									"First match for '" + dataRequest + "' is: " + techStack.get(count).getTechName()
											+ ", which is part of: \n" + techStack.get(count));
							dataFound = true;
						}
						break;

					case 2:
						if (techStack.get(count).getTechType().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
							System.out.println(
									"First match for '" + dataRequest + "' is: " + techStack.get(count).getTechType()
											+ ", which is part of: \n" + techStack.get(count));
							dataFound = true;
						}
						break;

					case 3:
						if (techStack.get(count).getPurpose().toLowerCase().indexOf(dataRequest.toLowerCase()) >= 0) {
							System.out.println(
									"First match for '" + dataRequest + "' is: " + techStack.get(count).getPurpose()
											+ ", which is part of: \n" + techStack.get(count));
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
							System.out.println(
									"First match for '" + dataRequest + "' is: " + techStack.get(count).getLicense()
											+ ", which is part of: \n" + techStack.get(count));
							dataFound = true;
						}
						break;

					default:
						System.out.println("Invalid input");
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

		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			return -1;
		} finally {
			System.out.println("Action finished");
		}
	}

	/**
	 * <ul>
	 * <li>The Technology where the first match occurs will be overwritten with new
	 * attributes.
	 *
	 * <li>The index of the specific ArrayList position is collected with the
	 * findFirstMatch() method, which is why the WebPage object will have to call
	 * the funcion and also be the parameter: "object1.updateTech(object1);" because
	 * the object is needed to reuse findFirstMatch.
	 * </ul>
	 *
	 * @param web The WebPage object that contains the ArrayList of Technology
	 *            objects.
	 */
	public void updateTech(WebPage web) {
		try {
			int arrayListIndex;

			arrayListIndex = web.findFirstMatch(Utilities.getString("What do you want to find and update?"));

			// If the value of arrayListIndex is -1, no matches were found.
			if (arrayListIndex > -1) {
				// The Technology will be overwritten with new data.
				web.getTechStack().set(arrayListIndex,
						new Technology(Utilities.getString("Set new name:"), Utilities.getString("Set new tech type:"),
								Utilities.getString("Set new purpose:"),
								Utilities.getIntBetween(1900, 2050, "Set new release year:"),
								Utilities.getString("Set new license:")));
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * <ul>
	 * <li>The Technology's attribute where the first match occur will be
	 * overwritten
	 *
	 * <li>The index of the specific ArrayList position is collected with the
	 * findFirstMatch() method, which is why the WebPage object will have to call
	 * the funcion and also be the parameter: "object1.updateTech(object1);" because
	 * the object is needed to reuse findFirstMatch.
	 * </ul>
	 *
	 * @param web The WebPage object that contains the ArrayList of Technology
	 *            objects.
	 */
	public void updateTechAttribute(WebPage web) {
		int arrayListIndex;
		int attributeSelector;

		try {
			arrayListIndex = web.findFirstMatch(Utilities.getString("What do you want to find: "),
					attributeSelector = Utilities.getIntBetween(1, 5,
							"Enter 1, 2, 3, 4 or 5 to search by: 1-Name, 2-Tech type, 3-Purpose, 4-Release year or 5-License"));

			// If the value of arrayListIndex is -1, no matches were found.
			if (arrayListIndex > -1) {

				switch (attributeSelector) {

				case 1:
					web.getTechStack().get(arrayListIndex).setTechName(Utilities.getString("Set new name:"));
					break;
				case 2:
					web.getTechStack().get(arrayListIndex).setTechType(Utilities.getString("Set new tech type:"));
					break;
				case 3:
					web.getTechStack().get(arrayListIndex).setPurpose(Utilities.getString("Set new purpose:"));
					break;
				case 4:
					web.getTechStack().get(arrayListIndex)
							.setReleaseYear(Utilities.getIntBetween(1900, 2050, "Set new release year:"));
					break;
				case 5:
					web.getTechStack().get(arrayListIndex).setLicense(Utilities.getString("Set new license:"));
					break;
				default:
					System.out.println("Invalid option");
					break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid index. " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred. " + e.getMessage());
		}
	}
	
	

	/**
	 * <ul>
	 * <li>The Technology where the first match occurs will be removed from the
	 * ArrayList of Technology objects.
	 * </ul>
	 *
	 * @param web The WebPage object that contains the ArrayList of Technology
	 *            objects.
	 */
	public void remove(WebPage web) {
		try {
			int arrayListIndex;
			char confirm;

			// ".findFirstMatch()" to collect the position of the first match.
			arrayListIndex = web
					.findFirstMatch(Utilities.getString("Which Technology do you want to find and remove?"));

			if (arrayListIndex > -1) {
				confirm = Utilities.getCharMenu('y', 'n', "Do you want to remove the previous Technology?");
				if (confirm == 'y') {
					web.getTechStack().remove(arrayListIndex);
					System.out.println("The Technology has been removed");
				} else {
					System.out.println("Not removed");
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Index out of bounds error: " + e.getMessage());
		} catch (NullPointerException e) {
			System.err.println("Null pointer error: " + e.getMessage());
		}
	}

	/**
	 * <ul>
	 * <li>Removes every Technology from the ArrayList.
	 * </ul>
	 */
	public void remove() {
		char confirm;
		try {
			// If the ArrayList is empty, no removal actions will be performed.
			if (techStack.size() > 0) {
				// We collect y or n to confirm the removal
				confirm = Utilities.getCharMenu('y', 'n',
						"Are you sure? This will remove every Technology from the list");
				if (confirm == 'y') {
					techStack.removeAll(techStack);
				}
			} else {
				System.out.println("There are no Technologies to be removed.");
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
