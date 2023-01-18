package tacos;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

// Web test for HomeController
@WebMvcTest(HomeController.class)
class HomeControllerTest {

	// injects MockMvc
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testHomePage() throws Exception {
		// performs GET
		mockMvc.perform(get("/"))
			// expects HTTP 200
			.andExpect(status().isOk())
			// expects home view
			.andExpect(view().name("home"))
			// expects Welcome to...
			.andExpect(content().string(containsString("Welcome to...")));
	}
}
