package com.chicken.toyproject.travelwith.model

data class Member (var black: Boolean, var coupons: ArrayList<Coupon>, var createdAt: String,
                   var dormant: Boolean, var id: Int, var memberActivity: MemberActivity,
                   var memberId: String, var memberType: Int, var name : String,
                   var nickname: String, var scheduleMembers: ArrayList<ScheduleMember>,
                   var snsType : Int, var travelMembers: ArrayList<TravelMember>,
                   var updatedAt: String)