package com.chicken.toyproject.travelwith.model

data class Coupon (var couponUuid: String, var createdAt: String,
                   var id: Int, var member: Member, var retire : Boolean,
                   var updatedAt:String, var use: Boolean )