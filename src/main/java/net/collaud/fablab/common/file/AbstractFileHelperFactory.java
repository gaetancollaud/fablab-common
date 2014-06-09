package net.collaud.fablab.common.file;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gaetan
 */
abstract public class AbstractFileHelperFactory {

	public static final int HELPER_MAX_AGE = 5 * 60 * 1000;

	private final Map<Integer, FileHelper> cache;

	public AbstractFileHelperFactory() {
		cache = new HashMap<>();
	}

	/**
	 * Get the helper associated to its id. Will create a new one if this is the first time and put
	 * it in cache. The next time the helper will be accessed by the cache.
	 * If the helper exceed the max age, it will be recreted.
	 *
	 * @param id
	 * @return
	 * @see HELPER_MAX_AGE
	 * @throws FileHelperException If the helper cannot be created.
	 */
	protected FileHelper get(Integer id) throws FileHelperException {
		FileHelper helper = cache.get(id);
		if (helper == null || helper.getAge() > HELPER_MAX_AGE) {
			//helper never existed or is too old
			helper = create(id);
			cache.put(id, helper);
		}
		return helper;
	}

	/**
	 * This method has to create the FileHelper asscociated with this id
	 *
	 * @param id
	 * @return
	 */
	abstract protected FileHelper create(Integer id);

	protected FileHelper createPropertiesFileHelper(String file) throws FileHelperException {
		try {
			File f = new File(file);
			return new PropertiesFileHelper(f);
		} catch (IOException ex) {
			throw new FileHelperException("Unable to open file " + file, ex);
		}
	}

	/**
	 * Create and returne a simple unknown helper exception
	 *
	 * @param id
	 * @return
	 */
	protected FileHelperException getUnknowFileHelperException(int id) {
		return new FileHelperException("Unknown helper with id " + id);
	}
}
