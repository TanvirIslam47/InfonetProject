package bd.com.expresshub.infonetassesment.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import bd.com.expresshub.infonetassesment.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    //private static volatile UserRoomDatabase userRoomInstance;
    private static UserRoomDatabase userRoomInstance;

    public static UserRoomDatabase getDatabase(final Context context) {
        if(userRoomInstance == null) {
            synchronized (UserRoomDatabase.class) {
//                if (userRoomInstance == null) {
                userRoomInstance = Room.databaseBuilder(context.getApplicationContext(),
                        UserRoomDatabase.class, "user_db").allowMainThreadQueries().build();
//                }
            }
        }
        return userRoomInstance;
    }
}
