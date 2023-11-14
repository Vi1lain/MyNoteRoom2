package vi1ain.my.mynoteroom2.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vi1ain.my.mynoteroom2.MyApp

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDB:RoomDatabase() {
    abstract val noteDao:NoteDao
companion object{
    fun createDataBase(app:MyApp):NoteDB = Room.databaseBuilder(
        app,
        NoteDB::class.java, "room_note2.db"
    ).build()
}

}