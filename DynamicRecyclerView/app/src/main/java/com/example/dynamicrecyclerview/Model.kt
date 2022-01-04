package com.example.dynamicrecyclerview

data class SectionModel(
    val category: String,
    val friendList: List<Friend>
)

data class Friend(
    val name: String,
    val age: Int,
    val phone: String
)