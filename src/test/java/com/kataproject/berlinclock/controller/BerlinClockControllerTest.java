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
	public void makeAValidCallToFullClock() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.hasSecondActive(true)
													.withHourBlocks(0)
													.withRemainingHours(0)
													.withMinuteBlocks(0)
													.withRemainingMinutes(0)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/full-clock/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("YOOOOOOOOOOOOOOOOOOOOOOO")));
	}

	@Test
	public void makeAValidCallToHourBlocks() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withHourBlocks(3)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/hour-blocks/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("RRRO")));
	}

	@Test
	public void makeAValidCallToRemainingHours() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingHours(3)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/remaining-hours/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("RRRO")));
	}

	@Test
	public void makeAValidCallToMinuteBlocks() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withMinuteBlocks(10)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/minute-blocks/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("YYRYYRYYRYO")));
	}

	@Test
	public void makeAValidCallToRemainingMinutes() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.withRemainingMinutes(3)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/remaining-minutes/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("YYYO")));
	}

	@Test
	public void makeAValidCallToSeconds() throws Exception {
		BerlinClock berlinClock = BerlinClockBuilder.aBerlinClock()
													.hasSecondActive(true)
													.build();

		Mockito	.doReturn(berlinClock)
				.when(berlinClockService)
				.convertTimeToBerlinClock(any());

		mockMvc	.perform(get("/berlin-clock/seconds/aTime"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$",
									is("Y")));
	}
}
