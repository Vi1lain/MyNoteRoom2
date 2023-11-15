package vi1ain.my.mynoteroom2.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import vi1ain.my.mynoteroom2.R
import vi1ain.my.mynoteroom2.data.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun NoteList(
    noteViewModel: NoteViewModel = viewModel(factory = NoteViewModel.factory)
) {

    val noteList = noteViewModel.noteList.collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(onClick = {
                noteViewModel.insertNote()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "add"
                )
                Text(text = "Add note")
            }
        }
    ) {
        Column(
            Modifier
                .fillMaxSize()
        ) {
            TextField(colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
                label = { Text(text = "title") },
                modifier = Modifier.fillMaxWidth(),
                value = noteViewModel.titleState,
                onValueChange = { text -> noteViewModel.titleState = text })

            LazyColumn(modifier = Modifier
                .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp),
                 ){
                items(noteList.value) { note ->
                    NoteCard(note,
                        {
                            noteViewModel.checkNoteEntity = it
                            noteViewModel.titleState = it.title
                        },
                        {
                            noteViewModel.deleteNote(note)
                        },{check ->
                            noteViewModel.isChekedNote(note.copy(isCheked = check))
                        })
                }
            }
        }
    }
}