package practica2_MarcelinoGil;

/**
 * @description This class contains the attributes of Technology object and the basic predefined methods
 * @author Marcelino Gil Nombela
 * @version 1.0
 * @since 09/04/2023
 */
public class Technology {

	private String techName;
	private String techType;
	private String purpose;
	private int releaseYear;
	private String license;

	public Technology(String techName, String techType, String purpose, int releaseYear, String license) {
		super();
		this.techName = techName;
		this.techType = techType;
		this.purpose = purpose;
		this.releaseYear = releaseYear;
		this.license = license;
	}

	public String getTechName() {
		return techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public String getTechType() {
		return techType;
	}

	public void setTechType(String techType) {
		this.techType = techType;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Technology [techName=" + techName + ", techType=" + techType + ", purpose=" + purpose + ", releaseYear="
				+ releaseYear + ", license=" + license + "]";
	}

}
