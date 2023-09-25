package uabc.ico1169598.myapplicationnumbers.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uabc.ico1169598.myapplicationnumbers.ui.theme.ui.theme.MyApplicationNumbersTheme

class SecondActivity : ComponentActivity() {

    private var numberOne by mutableStateOf(0)
    private var numberTwo by mutableStateOf(0)
    private var numberThree by mutableStateOf(0)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationNumbersTheme {
                val result by remember {
                    mutableStateOf(addNumbers())
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Result")
                    Text(text = "$numberOne × $numberTwo = $result")
                    Text(text = "\nYour answer: $numberThree")

                }
            }
        }

    }

    private fun addNumbers(): Int {
        numberOne = intent.getIntExtra("numberOne",0)
        numberTwo = intent.getIntExtra("numberTwo",0)
        numberThree = intent.getIntExtra("numberThree",0)
        return numberOne*numberTwo
    }

}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationNumbersTheme {
        Greeting2("Android")
    }
}