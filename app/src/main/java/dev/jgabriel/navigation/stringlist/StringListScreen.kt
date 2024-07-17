package dev.jgabriel.navigation.stringlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import dev.jgabriel.navigation.routes.StringList

@Composable
fun StringListScreen(
    list: StringList,
    navigateToHome: () -> Unit,
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(list.items) {
            Text(
                textAlign = TextAlign.Center,
                text = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToHome()
                    })
        }
    }
}

@Preview
@Composable
private fun StringListPreview() {
    StringListScreen(
        StringList(listOf("a", "b")),
        navigateToHome = {}
    )
    
}