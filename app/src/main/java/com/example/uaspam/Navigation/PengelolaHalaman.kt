import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.uaspam.LoginPage
import com.example.uaspam.Navigation.Screen
import com.example.uaspam.ui.AnimatedSplashScreen
import com.example.uaspam.ui.DataPelanggan.DataPel
import com.example.uaspam.ui.DataPelanggan.DestinasiDataPel
import com.example.uaspam.ui.Detail.DetailDestinationScreen
import com.example.uaspam.ui.Detail.DetailScreen
import com.example.uaspam.ui.Edit.EditMakanan
import com.example.uaspam.ui.Edit.EditMakananScreen
import com.example.uaspam.ui.MenuViewModel.DetailPaymentScreen
import com.example.uaspam.ui.MenuViewModel.MenuScreen
import com.example.uaspam.ui.MenuViewModel.PaymentScreen
import com.example.uaspam.ui.MenuViewModel.TampilScreenMenu
import com.example.uaspam.ui.add.AddScreen
import com.example.uaspam.ui.add.DestinasiEntry

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route,
        modifier = Modifier
    ) {
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable("LoginPage") {
            LoginPage(navController)
        }
        composable(route = Screen.Home.route) {
            Box(modifier = Modifier.fillMaxSize())
        }
        composable(DestinasiEntry.route) {
            AddScreen(navigateBack = {navController.popBackStack()},
                OnNextClick = {navController.navigate(Screen.Home.route)})
        }
        composable(route = DetailDestinationScreen.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationScreen.MakananId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val makananId = backStackEntry.arguments?.getString(DetailDestinationScreen.MakananId)
            makananId?.let {
                DetailScreen(
                    navigateBack = { navController.popBackStack() },
                    navigateToEditItem = {
                        navController.navigate("${EditMakananScreen.route}/$makananId")
                        println("makananId: $makananId")
                    }
                )
            }
        }
        composable(DestinasiDataPel.route){
            DataPel(
                navigateBack = {navController.navigate("LoginPage")},
                navigateNext = {navController.navigate((TampilScreenMenu.route))}
            )
        }
        composable(
            route = EditMakananScreen.routeWithArgs,
            arguments = listOf(navArgument(EditMakananScreen.makananId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val makananId = backStackEntry.arguments?.getString(EditMakananScreen.makananId)
            makananId?.let {
                EditMakanan(
                    navigateBack = { navController.popBackStack()},
                    onNavigateUp = {navController.navigateUp() })
            }
        }
        composable(
            TampilScreenMenu.route
        ) {
            MenuScreen(navigateToItemEntry = {
                navController.navigate(DestinasiEntry.route)
            },
                onDetailClick = { itemId ->
                    navController.navigate("${DetailDestinationScreen.route}/$itemId")
                    println("itemId: $itemId")
                },
                onPaymentClick = {
                        itemId -> navController.navigate("${DetailPaymentScreen.route}/$itemId")
                }
            )
        }
        composable(route = DetailPaymentScreen.routeWithArgs,
            arguments = listOf(navArgument(DetailPaymentScreen.MakananId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val makananId = backStackEntry.arguments?.getString(DetailPaymentScreen.MakananId)
            makananId?.let {
                PaymentScreen(
                    navigateBack = { navController.popBackStack() },
                )
            }
        }
    }
}