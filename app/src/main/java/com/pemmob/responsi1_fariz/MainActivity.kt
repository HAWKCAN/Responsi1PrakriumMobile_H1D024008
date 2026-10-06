package com.pemmob.responsi1_fariz

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.pemmob.responsi1_fariz.data.repository.PokemonRepository
import com.pemmob.responsi1_fariz.navigation.AppNavGraph
import com.pemmob.responsi1_fariz.ui.theme.Responsi1_FarizTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?  ) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Responsi1_FarizTheme {
                    AppNavGraph()
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

