package pl.oskarpolak.springsec;

import static  org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.oskarpolak.springsec.controllers.MainController;
import pl.oskarpolak.springsec.models.DistanceModel;
import pl.oskarpolak.springsec.models.services.DistanceService;

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
@AutoConfigureWebMvc
public class SpringsecApplicationTests {

	@MockBean
	DistanceService distanceService;

	@Autowired
	MockMvc mockMvc;

//	@Test
//	public void contextLoads() {
//		assertThat(mainController).isNotNull();
//	}
//
//	@Test
//	public void loadHttp() {
//		assertThat(distanceService.getDistance("Kraków", "Warszawa")).isNotNull();
//	}

	@Test
	@WithMockUser(username = "oskarpolak", password = "oski", roles = "ADMIN")
	public void checkController() throws Exception {
		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("poszło")));
	}


}
