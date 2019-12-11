package com.chicken.toyproject.travelwith.model

data class ScheduleMember (var createdAt: String, var id: Int, var member: Array<Member>,
                           var schedule: Array<Schedule>, var updatedAt: String)