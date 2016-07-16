package webcrawler.utils;

import java.net.URL;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class URLUtilsTest {

	@Test
	public void testGetDomainName() throws Exception {
		assertEquals("bbc.co.uk", URLUtils.getDomainName(new URL("http://www.bbc.co.uk/news")));
	}

	@Test
	public void testNormaliseNameToLower() throws Exception {
		assertEquals(new URL("http://www.bbc.co.uk/news"), URLUtils.normalise("HTTP://www.bbC.co.uk/newS"));
	}


	@Test
	public void testNormaliseMissingProtocol() throws Exception {
		assertEquals(new URL("http://www.bbc.co.uk/news"), URLUtils.normalise("www.bbC.co.uk/newS"));
	}
}
