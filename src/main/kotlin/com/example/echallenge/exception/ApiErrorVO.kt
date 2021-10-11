package com.example.echallenge.exception

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ApiErrorVO(var errorCode: String, var message: String)