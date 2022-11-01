package bd.com.expresshub.infonetassesment.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import bd.com.expresshub.infonetassesment.UserModel;

@Dao
public interface UserDao {
    @Query("SELECT * FROM userTable")
    List<UserModel> getAll();

    @Query("SELECT * FROM userTable WHERE uid IN (:userIds)")
    List<UserModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM userTable WHERE name LIKE :name AND " +
            "countryName LIKE :country LIMIT 1")
    UserModel findByName(String name, String country);

    @Insert
    void insertAll(UserModel users);

    @Delete
    void delete(UserModel user);
}
