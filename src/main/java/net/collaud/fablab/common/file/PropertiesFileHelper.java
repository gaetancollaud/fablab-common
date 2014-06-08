package net.collaud.fablab.common.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author gaetan
 * @param <T>
 */
public class PropertiesFileHelper<T extends KeyEnum> extends FileHelper<T> {

	private static final Logger LOG = Logger.getLogger(PropertiesFileHelper.class);

	private final Properties prop;

	public PropertiesFileHelper(File file) throws IOException {
		super();
		prop = new Properties();
		prop.load(new FileReader(file));
	}

	@Override
	public String get(T key, String def) {
		return prop.getProperty(key.getKey(), def);
	}

	@Override
	public String get(T key) {
		return get(key, null);
	}

	@Override
	public int getAsInt(T key, int def) {
		String v = get(key);
		if (v == null) {
			return def;
		}
		try {
			return Integer.parseInt(v);
		} catch (NumberFormatException ex) {
			LOG.error("Cannot parse key=" + key.getKey() + " value=" + v + " to int", ex);
			return def;
		}
	}

	@Override
	public int getAsInt(T key) {
		return getAsInt(key, 0);
	}
}
