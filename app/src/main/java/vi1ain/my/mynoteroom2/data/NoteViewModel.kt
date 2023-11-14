package vi1ain.my.mynoteroom2.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import vi1ain.my.mynoteroom2.MyApp

class NoteViewModel(val database: NoteDB) : ViewModel() {
    val noteList = database.noteDao.getAllNotes()
    var checkNoteEntity: NoteEntity? = null
    var titleState by mutableStateOf("")

    fun insertNote() = viewModelScope.launch {
        val noteItem = checkNoteEntity?.copy(title = titleState) ?: NoteEntity(
            title = titleState,
            isCheked = false
        )
        database.noteDao.insertNote(noteItem)
        checkNoteEntity = null
        titleState = ""
    }

    fun deleteNote(noteEntity: NoteEntity) = viewModelScope.launch {
        database.noteDao.deleteNote(noteEntity = noteEntity)
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as MyApp).database
                return NoteViewModel(database = database) as T
            }
        }
    }
}