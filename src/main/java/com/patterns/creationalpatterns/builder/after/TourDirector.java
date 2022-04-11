package com.patterns.creationalpatterns.builder.after;

import java.time.LocalDate;

import com.patterns.creationalpatterns.builder.before.TourPlan;

public class TourDirector {

	private TourPlanBuilder toruPlanBuilder;

	public TourDirector(TourPlanBuilder toruPlanBuilder) {
		this.toruPlanBuilder = toruPlanBuilder;
	}
	
	public TourPlan cancunTrip() {
		return toruPlanBuilder.title("칸쿤 여행")
				   .nightsAndDays(2, 3)
				   .startDate(LocalDate.of(2022, 5, 9))
				   .whereToStay("리조트")
				   .addPlan(0, "체크인하고 짐 풀기")
				   .addPlan(0, "저녁 식사")
				   .getPlan();
	}
	
	public TourPlan longBeachTrip() {
		return toruPlanBuilder.title("롱비치")
				.startDate(LocalDate.of(2022, 11, 1))
				.getPlan();
	}
	
}
