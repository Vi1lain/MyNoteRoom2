package vi1ain.my.mynoteroom2.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import vi1ain.my.mynoteroom2.MyApp

class NoteViewModel(val database:NoteDB) : ViewModel() {
val noteList = database.noteDao.getAllNotes()

    var titleState by mutableStateOf("")

    fun deleteNote(noteEntity: NoteEntity) {

    }






companion object{
    val factory:ViewModelProvider.Factory = object :ViewModelProvider.Factory{
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
            extras: CreationExtras): T {
            val  database = (checkNotNull(extras[APPLICATION_KEY]) as MyApp).database
            return NoteViewModel(database = database) as T
        }
    }
}
}