package vi1ain.my.mynoteroom2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vi1ain.my.mynoteroom2.data.NoteEntity


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NoteCard(note:NoteEntity) {
    Scaffold() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 3.dp, top = 3.dp, end = 3.dp
            )
            .clickable {
                /*TODO*/
            }) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Checkbox(checked = true, onCheckedChange = {})
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp, start = 10.dp)
                        .weight(1f),
                    text = note.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Delete, contentDescription = "delete",tint = Color.Red)

                }
            }
        }
    }
}