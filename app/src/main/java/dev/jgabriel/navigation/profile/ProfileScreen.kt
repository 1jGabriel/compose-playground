package dev.jgabriel.navigation.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.jgabriel.navigation.routes.Profile

@Composable
fun ProfileScreen(
    profile: Profile,
    openTelaComLista: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("profile ${profile.id}", modifier = Modifier.clickable {
            openTelaComLista()
        })
    }
}