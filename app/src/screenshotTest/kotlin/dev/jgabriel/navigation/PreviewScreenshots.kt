package dev.jgabriel.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.jgabriel.navigation.ui.theme.ComposeNavigationTheme

class PreviewScreenshots {
    @Preview(showBackground = true)
    @Composable
    fun TestingPreviewScreenshot() {
        ComposeNavigationTheme {
            Text("Testing  2Preview")
        }
    }
}
