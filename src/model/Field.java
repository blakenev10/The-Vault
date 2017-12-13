package model;
/**
 * <b>Project:</b>	The Vault
 * <b>Package:</b>	model
 * <b>File:</b>		Field.java
 * 
 * @author Blake Neville
 */

/**
 * <b>Description:</b> A Field is the unit of data that holds the information that the user
 * wishes to relate together
 *
 * @author Blake Neville
 */
public class Field {

	private String		name;
	private String[] 	info;
	private String[]	tags;
	private final boolean		isConfidential;
	
	/**
	 * Constructs a new Field
	 * 
	 * @param	name
	 * 			The name that the user will associate with this field
	 * @param	info
	 * 			The info that that the user wishes to save with the field
	 * @param	tags
	 * 			Strings that the user associates with the field that can be used later in
	 * 			searches to find the field
	 * @param	isConfidential
	 * 			This is true if the field should not be accessed by a traditional search
	 * 			and should require a special password to be able to access
	 */
	public Field(String name, String[] info, String[] tags, boolean isConfidential) {
		
		this.name 			= name;
		this.info			= info;
		this.tags			= tags;
		this.isConfidential	= isConfidential;
	}

	/**
	 * <b>Description:</b> This method should be called to append an info String to the field
	 * 
	 * @param	i
	 * 			The info String to add
	 */
	public void addInfo(String i) {
		
		String[] temp = new String[info.length + 1];
		for(int x = 0; x < info.length; x++)
			temp[x] = info[x];
		
		temp[info.length] = i;
		
		info = temp;
	}
	
	/**
	 * <b>Description:</b> This method should be called to append an tag String to the field
	 * 
	 * @param	t
	 * 			The tag String to add
	 */
	public void addTag(String t) {
		
		String[] temp = new String[tags.length + 1];
		for(int x = 0; x < tags.length; x++)
			temp[x] = tags[x];
		
		temp[info.length] = t;
		
		tags = temp;
	}
	
	/**
	 * <b>Description:</b> This search method should be called when classified information
	 * should not be revealed
	 * 
	 * @param	search
	 * 			The string that this field should be searched for
	 * @return	Returns true if the string is found within the name or tags of this Field
	 * 			and the Field is not labeled as classified
	 */
	public boolean searchForStringInField(String search) {
		
		if( !isConfidential )
			return searchForString(search);
		
		return false;
	}
	
	/**
	 * <b>Description:</b> This search method should be called if classified information
	 * can be found.
	 * 
	 * @param	search
	 * 			The string that this field should be searched for
	 * @return	Returns true if the string is found within the name or tags of this Field
	 * 			regardless of confidentiality
	 */
	public boolean clearanceSearch(String search) {
		
		return searchForString(search);
	}
	
	private boolean searchForString(String search) {
		
		for(String t : tags)
			if( t.contains(search) )
				return true;
		
		if( name.contains(search) )
			return true;
		
		return false;
	}
}





