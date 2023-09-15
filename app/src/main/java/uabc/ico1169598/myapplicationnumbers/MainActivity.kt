package uabc.ico1169598.myapplicationnumbers

import android.content.Intent
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uabc.ico1169598.myapplicationnumbers.ui.theme.MyApplicationNumbersTheme
import uabc.ico1169598.myapplicationnumbers.ui.theme.SecondActivity

class MainActivity : ComponentActivity() {

    private val numberOne = mutableStateOf(0)
    private val numberTwo = mutableStateOf(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationNumbersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent(
                        numberOne = numberOne,
                        numberTwo = numberTwo,
                        onClick = {
                            sendDataToSecondActivity()
                        }
                    )
                }
            }
        }
    }

    private fun sendDataToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("numberOne", numberOne.value)
            putExtra("numberTwo", numberTwo.value)
        }
        startActivity(intent)
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
    MyApplicationNumbersTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextField(label: String, number: Int, onNumberChange: (Int) -> Unit = {}) {
    OutlinedTextField(
        value = if (number == 0) "" else number.toString(),
        onValueChange = {
            if (it.isNotEmpty()) {
                onNumberChange(it.toInt())
            }
            else {
                onNumberChange(0)
            }
        },
        label = {Text(text = label)},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun MainContent(
    numberOne: MutableState<Int> = mutableStateOf(0),
    numberTwo: MutableState<Int> = mutableStateOf(0),
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rnds = (0..10).random()
        /*NumberTextField(label="NumberOne", number=numberOne.value, onNumberChange={numberOne.value=it})
        Spacer(modifier = Modifier.height(16.dp))
        NumberTextField(label="NumberTwo", number=numberTwo.value, onNumberChange={numberTwo.value=it})
        Spacer(modifier=Modifier.height(16.dp))
        Button(onClick = onClick) {
            Text(text = "Send data")
        }*/
    }

}