package com.chicken.toyproject.travelwith.model

data class Travel (var createdAt: String, var endDate: String, var id:Int,
                   var name: String, var schedules: Array<Schedule>, var startDate: String,
                   var travelExplain: String, var travelMembers: Array<TravelMember>,
                   var updatedAt: String)