package dev.jgabriel.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import dev.jgabriel.navigation.ui.theme.ComposeNavigationTheme

class PreviewScreenshots2 {
    @Preview(showBackground = true)
    @Composable
    fun TestingPreviewScreenshot() {
        ComposeNavigationTheme {
            Text(
                text = "Testing  2Preview",
                color = Color.White,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(color = Color.Black),
            )
        }
    }
}
