package utng.model;

public class Experiment {
	private String id;
	private String title;
	private String description;
	private String creationDate;
	private String modificationDate;
	
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param creationDate
	 * @param modificationDate
	 */
	public Experiment(String id, String title, String description, String creationDate, String modificationDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
	}

	/**
	 * 
	 */
	public Experiment() {
		this("","","","","");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the modificationDate
	 */
	public String getModificationDate() {
		return modificationDate;
	}

	/**
	 * @param modificationDate the modificationDate to set
	 */
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	
		
	
}
