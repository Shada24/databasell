package com.example.database

import android.os.Bundle
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.items
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.database.ui.theme.DatabaseTheme
import io.ktor.websocket.Frame
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DatabaseTheme {
                ScreenOneContent()

                }
            }
        }
    }

@Composable
fun ScreenOneContent(modifier: Modifier = Modifier) {
    val ArtViewModel: ArtViewModel = viewModel()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            if (ArtViewModel.artList.isEmpty()) {
                CircularProgressIndicator()
            }
        }
        items(ArtViewModel.artList) { art ->
            PostItem(
                modifier = Modifier.fillMaxWidth(),
                clientType = art.clientType,
                dest = art.dest,
                destSize = art.destSize,
                expires = art.expires,
                generator = art.generator,
                output =art.output,
                percent =art.percent,
                src =art.src,
                srcSize=art.srcSize,
            )
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier, clientType: String, dest: String, destSize: Int, expires: String,generator: String,output: String,percent: Int,src: String,srcSize: Int) {
    Card(modifier = Modifier) {
        Column(modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
//            AsyncImage(model = picture, contentDescription = "", modifier = Modifier.size(150.dp))
            Text(clientType.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(dest, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(destSize.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(expires.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(generator.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(output.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(percent.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(src.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(srcSize.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)

        }
    }
}
