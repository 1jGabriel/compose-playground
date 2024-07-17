package dev.jgabriel.navigation.routes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import dev.jgabriel.navigation.home.HomeScreen
import dev.jgabriel.navigation.profile.ProfileScreen
import dev.jgabriel.navigation.stringlist.StringListScreen

fun NavGraphBuilder.stringListScreen(navController: NavHostController) {
    composable<StringList> { backStackEntry ->
        val list = backStackEntry.toRoute<StringList>()
        StringListScreen(
            list = list,
            navigateToHome = { navController.popBackStack(Home, false) },
        )
    }
}

fun NavGraphBuilder.profileScreen(navController: NavHostController) {
    composable<Profile> { backStackEntry ->
        val profile = backStackEntry.toRoute<Profile>()
        ProfileScreen(
            profile = profile,
            openTelaComLista = {
                navController.navigate(
                    StringList(
                        listOf(
                            "a",
                            "b",
                            "c",
                        ),
                    ),
                )
            },
        )
    }
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable<Home> {
        HomeScreen(
            onClickOpenProfile = {
                navController.navigate(
                    Profile(
                        "Abrir perfil",
                        blah = "teste",
                    ),
                )
            },
            onClickOpenModal = { },
        )
    }
}

fun NavHostController.openModal() = navigate(Modal)

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.modal(navController: NavHostController) {
    composable<Modal> {
        ModalBottomSheet(onDismissRequest = { navController.navigateUp() }) {
            Column(
                modifier = Modifier.size(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(text = "Meu modal")
            }
        }
    }
}
