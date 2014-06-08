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
	
	public static final int HELPER_MAX_AGE = 5*60*1000;

	private final Map<Integer, FileHelper> cache;

	public AbstractFileHelperFactory() {
		cache = new HashMap<>();
	}

	/**
	 * Get the helper associated to its id. Will create a new one if this is the first time and put it in cache. The next time the helper will be accessed by the cache.
	 * @param id
	 * @return
	 * @throws FileHelperException If the helper cannot be created.
	 */
	protected FileHelper get(Integer id) throws FileHelperException{
		FileHelper helper = cache.get(id);
		if (helper == null || helper.getAge() > HELPER_MAX_AGE) {
			//helper never existed or is too old
			helper = create(id);
			cache.put(id, helper);
		}
		return helper;
	}

	abstract protected FileHelper create(Integer key);

	protected FileHelper createPropertiesFileHelper(String file) throws FileHelperException {
		try {
			File f = new File(file);
			return new PropertiesFileHelper(f);
		} catch (IOException ex) {
			throw new FileHelperException("Unable to open file " + file, ex);
		}
	}

	protected FileHelperException getUnknowFileHelperException(int id) {
		return new FileHelperException("Unknown helper with id " + id);
	}
}
