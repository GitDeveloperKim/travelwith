package com.chicken.toyproject.travelwith.model

data class ScheduleDTO (var createdAt: String, var endDate: String, var id: Int, var lat: Float, var lon: Float, var name: String,
            var placeExplain: String, var placeName: String, var scheduleExplain: String, var startDate: String, var travel: Travel, var updatedAt: String)