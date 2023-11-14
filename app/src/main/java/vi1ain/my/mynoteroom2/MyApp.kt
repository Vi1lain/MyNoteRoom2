package vi1ain.my.mynoteroom2

import android.app.Application
import vi1ain.my.mynoteroom2.data.NoteDB

class MyApp:Application() {
    val database by lazy { NoteDB.createDataBase(this) }
}