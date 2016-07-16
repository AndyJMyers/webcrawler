package webcrawler.model;

import java.util.Set;
import java.util.TreeSet;

public class WebCrawlerResults {
	
	// Note: using Strings rather than URLs as Strings are Comparable.
	private Set<String> pagesInDomain = new TreeSet<String>();

	public Set<String> getPagesInDomain() {
		return pagesInDomain;
	}

	public void addPage(String page) {
		pagesInDomain.add(page);
	}

	public boolean alreadySeenPage(String url) {
		return pagesInDomain.contains(url);
	}

}
