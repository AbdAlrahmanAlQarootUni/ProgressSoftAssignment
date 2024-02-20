//package org.example.controllers;
//
//import org.example.models.FxDeal;
//import org.example.services.FxDealService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import ps.assignment.controllers.FxDealController;
//
//import java.util.Arrays;
//import java.util.Date;
//import ps.assignment.services.FxDealService;
//import ps.assignment.models.FxDeal;
//
//import static org.hamcrest.Matchers.*;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(FxDealController.class)
//class FxDealControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private FxDealService fxDealService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testDealForm() throws Exception {
//        mockMvc.perform(get("/dealForm"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("home"))
//                .andExpect(model().attributeExists("fxDeal"));
//    }
//
//    @Test
//    void testViewDeals() throws Exception {
//        when(fxDealService.findAllDeals()).thenReturn(Arrays.asList(new FxDeal(), new FxDeal()));
//
//        mockMvc.perform(get("/deals"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("deals"))
//                .andExpect(model().attributeExists("deals"))
//                .andExpect(model().attribute("deals", hasSize(2)));
//    }
//
//    @Test
//    void testSubmitDealValid() throws Exception {
//        mockMvc.perform(post("/submitDeal")
//                        .param("dealUniqueId", "123")
//                        .param("fromCurrencyIsoCode", "USD")
//                        .param("toCurrencyIsoCode", "EUR")
//                        // Assuming the dealTimestamp is formatted properly
//                        .param("dealTimestamp", "2020-01-01T00:00")
//                        .param("dealAmount", "1000"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/success"));
//
//        verify(fxDealService, times(1)).saveDeal(any(FxDeal.class));
//    }
//
//    @Test
//    void testSubmitDealInvalid() throws Exception {
//        mockMvc.perform(post("/submitDeal"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("dealForm"))
//                .andExpect(model().attributeExists("fxDeal"))
//                .andExpect(model().hasErrors());
//
//        verify(fxDealService, never()).saveDeal(any(FxDeal.class));
//    }
//}
