package com.kataproject.berlinclock.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kataproject.berlinclock.BerlinClockApplication;
import com.kataproject.berlinclock.dto.BerlinClock;
import com.kataproject.berlinclock.dto.BerlinClockBuilder;
import com.kataproject.berlinclock.service.BerlinClockService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BerlinClockApplication.class)
@WebAppConfiguration
public class BerlinClockControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	BerlinClockController berlinClockController;

	@Mock
	BerlinClockService berlinClockService;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders	.standaloneSetup(berlinClockController)
										.build();
	}

	@Test
	public void makeAValidCallToBerlinClockApi() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(11)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlinclock/minutes-blocks/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("YYRYYRYYRYY")));
	}
}
