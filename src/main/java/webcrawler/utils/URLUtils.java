package webcrawler.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class URLUtils {
	static final Logger logger = Logger.getLogger(URLUtils.class);
	
	public static String getDomainName(URL url) {
	    String domain = url.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	
	/**
	 * Returns a canonical url, to lower case and adds http if not present. 
	 */
	public static URL normalise(String url) {
		String lowerCaseUrl = url.toLowerCase();
		
		URL normalised = null;
		try {
			normalised = new URL(lowerCaseUrl);
		} catch (MalformedURLException mue) {
			// may be missing the protocol 
			try {
				normalised = new URL("http://" + lowerCaseUrl);
			} catch (MalformedURLException e) {
				logger.error("Unable to generate legal URL from " + url);
			}
		}
		
		return normalised;
	}
}
