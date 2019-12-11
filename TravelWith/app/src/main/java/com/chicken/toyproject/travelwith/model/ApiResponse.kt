package com.chicken.toyproject.travelwith.model

 class ApiResponse <T> (var data: Array<T>, var error: ApiResponseError, var httpStatus: String, var message: String)