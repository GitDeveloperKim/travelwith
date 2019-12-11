package com.chicken.toyproject.travelwith.model


data class Schedule (var createdAt: String, var endDate: String, var id: Integer, var lat: Float, var lon: Float,
                     var name: String, var placeExplain: String, var placeName: String, var scheduleExplain: String,
                     var scheduleMembers: ArrayList<ScheduleMember>, var startDate: String, var travel: ArrayList<Travel>, var updatedAt: String)