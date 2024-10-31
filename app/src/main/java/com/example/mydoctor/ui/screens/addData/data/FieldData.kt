package com.example.mydoctor.ui.screens.addData.data

data class FieldData(
    val label: String? = null,
    val title: String? = null,
    val fieldType: FieldType,
    val value: String,
    val hint: String,
    val onValueChange: (String) -> Unit
)

enum class FieldType {
    Text, Date, Time
}