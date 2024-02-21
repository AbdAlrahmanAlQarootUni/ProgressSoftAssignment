package ps.assignment;

import ps.assignment.models.FxDeal;
import ps.assignment.services.FxDealService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ps.assignment.controllers.FxDealController;

import java.util.Arrays;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FxDealController.class)
class FxDealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FxDealService fxDealService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDealForm() throws Exception {
        mockMvc.perform(get("/dealForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("fxDeal"));

    }

    @Test
    void testViewDeals() throws Exception {
        when(fxDealService.findAllDeals()).thenReturn(Arrays.asList(new FxDeal(), new FxDeal()));

        mockMvc.perform(get("/deals"))
                .andExpect(status().isOk())
                .andExpect(view().name("deals"))
                .andExpect(model().attributeExists("deals"))
                .andExpect(model().attribute("deals", hasSize(2)));
    }

}
