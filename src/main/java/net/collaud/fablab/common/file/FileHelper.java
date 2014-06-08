package net.collaud.fablab.common.file;

/**
 *
 * @author gaetan
 * @param <T>
 */
abstract public class FileHelper<T extends KeyEnum>{
	
	private final long creation;
	
	public FileHelper() {
		creation = System.currentTimeMillis();
	}
	
	long getAge(){
		return System.currentTimeMillis()-creation;
	}

	/**
	 *
	 * @param key key of the property
	 * @param def default value
	 * @return the value of the property or the default value if the key is not found
	 */
	abstract public String get(T key, String def);

	/**
	 *
	 * @param key key of the property
	 * @return the value of the property or null if the key is not found
	 */
	abstract public String get(T key);

	/**
	 * @param key key of the property
	 * @param def default value
	 * @return the value as integer. Will return the default value, if the key is not found, or if a
	 * convertion error appear.
	 */
	abstract public int getAsInt(T key, int def);

	/**
	 * @param key key of the property
	 * @return the value as integer. Will return 0 if the key is not found, or if a convertion error
	 * appear.
	 */
	abstract public int getAsInt(T key);
}
