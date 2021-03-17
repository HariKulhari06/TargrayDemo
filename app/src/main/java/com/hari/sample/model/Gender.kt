package com.hari.sample.model

enum class Gender(val id: String) {
    MALE("Male"),
    FEMALE("Female");

    companion object {
        fun getGender(id: String) = values().first { it.id == id }
    }
}