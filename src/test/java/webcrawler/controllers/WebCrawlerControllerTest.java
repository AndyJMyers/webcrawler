package webcrawler.controllers;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import webcrawler.engines.WebCrawlerEngine;

@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerControllerTest {

		@Mock
		WebCrawlerEngine webCrawlerEngine;
		
		@InjectMocks 
		private WebCrawlerController webCrawlerController = new WebCrawlerController();

		
		@Test
		public void testWebCrawler() throws Exception {
			final URL testURL = new URL("http://www.somesite.com");
			
			when(webCrawlerEngine.processPage(testURL)).thenReturn(null);			
			
			webCrawlerController.webcrawler(testURL);
			
			verify(webCrawlerEngine).processPage(testURL);
		}
	}
