package upeu.edu.pe.navigationjpc2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import upeu.edu.pe.navigationjpc2.ui.presentation.component.MyAppDrawer
import upeu.edu.pe.navigationjpc2.ui.theme.NavigationJPC2Theme
import upeu.edu.pe.navigationjpc2.ui.theme.ThemeType
import upeu.edu.pe.navigationjpc2.ui.theme.darkGreenScheme
import upeu.edu.pe.navigationjpc2.ui.theme.darkRedScheme
import upeu.edu.pe.navigationjpc2.ui.theme.lightGreenScheme
import upeu.edu.pe.navigationjpc2.ui.theme.lightRedScheme
import upeu.edu.pe.navigationjpc2.utils.conttexto
import upeu.edu.pe.navigationjpc2.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeType= remember{ mutableStateOf(ThemeType.RED) }
            val darkThemex= isNight()
            val darkTheme = remember { mutableStateOf(darkThemex)
            }
            val colorScheme=when(themeType.value){
                ThemeType.RED->{if (darkTheme.value) darkRedScheme else
                    lightRedScheme}
                ThemeType.GREEN->{if (darkTheme.value) darkGreenScheme else
                    lightGreenScheme}
                else->{lightGreenScheme}
            }
            conttexto.CONTEXTO_APPX=this
            NavigationJPC2Theme(colorScheme = colorScheme) {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    
                }*/

                MyAppDrawer(darkMode = darkTheme, themeType = themeType)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationJPC2Theme(colorScheme = lightGreenScheme) {
        Greeting("Android")
    }
}