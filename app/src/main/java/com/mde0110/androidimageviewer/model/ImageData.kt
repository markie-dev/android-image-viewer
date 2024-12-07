package com.mde0110.androidimageviewer.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ImageData(
    val id: Int,
    val resourceId: Int,
    val name: String,
    val color: Color,
    val icon: ImageVector
)