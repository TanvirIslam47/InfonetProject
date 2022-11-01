package bd.com.expresshub.infonetassesment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userTable")
public class UserModel {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int uid;

    @NonNull
    @ColumnInfo(name = "name")
    public String userName;

    @ColumnInfo(name = "countryName")
    public String countryName;

    @ColumnInfo(name = "cityName")
    public String cityName;

    @ColumnInfo(name = "languageName")
    public String languageName;

    @ColumnInfo(name = "dob")
    public String dob;

    public int getUid() {
        return uid;
    }

    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
