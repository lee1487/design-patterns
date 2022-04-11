package com.patterns.creationalpatterns.builder.after;

import java.time.LocalDate;

import com.patterns.creationalpatterns.builder.before.TourPlan;

public class App {

	public static void main(String[] args) {
//		TourPlanBuilder builder = new DefaultTourBuilder();
//		TourPlan plan = builder.title("칸쿤 여행")
//			   .nightsAndDays(2, 3)
//			   .startDate(LocalDate.of(2022, 5, 9))
//			   .whereToStay("리조트")
//			   .addPlan(0, "체크인하고 짐 풀기")
//			   .addPlan(0, "저녁 식사")
//			   .getPlan();
//		
//		TourPlan longBeachTrip = builder.title("롱비치")
//				.startDate(LocalDate.of(2022, 11, 1))
//				.getPlan();
		
		TourDirector director = new TourDirector(new DefaultTourBuilder());
		TourPlan cancunTrip = director.cancunTrip();
		TourPlan longBeachTrip = director.longBeachTrip();
	}
}
