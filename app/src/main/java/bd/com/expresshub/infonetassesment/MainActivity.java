package bd.com.expresshub.infonetassesment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import bd.com.expresshub.infonetassesment.room.UserRoomDatabase;

public class MainActivity extends AppCompatActivity {

    TextInputLayout nameTil, countryTil, cityTil, dobTil;
    TextInputEditText nameET, dobET;
    AutoCompleteTextView act_country, act_city;
    View submitBtn, showBtn;

    public Calendar myCalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameTil = findViewById(R.id.nameTIL);
        countryTil = findViewById(R.id.countryTIL);
        cityTil = findViewById(R.id.cityTIL);
        dobTil = findViewById(R.id.dobTil);
        nameET = findViewById(R.id.nameId);
        dobET = findViewById(R.id.birthDateId);
        act_country = findViewById(R.id.countryId);
        act_city = findViewById(R.id.cityId);
        submitBtn = findViewById(R.id.saveLayoutId);
        showBtn = findViewById(R.id.showLayoutId);


        //set from Date from calender
        myCalender = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener fDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateLabel();
            }
        };

        dobET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, fDate, myCalender
                        .get(Calendar.YEAR), myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName() | !validateDob()) {
                    return;
                }
//                Toast.makeText(MainActivity.this, "valid", Toast.LENGTH_SHORT).show();
                saveData();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InfoListActivity.class);
                startActivity(intent);
            }
        });



    }

    private void dateLabel() {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dobET.setText(sdf.format(myCalender.getTime()));
    }

    private void saveData() {

        String name_txt = nameET.getText().toString().trim();
        String country_txt = act_country.getText().toString().trim();
        String city_txt = act_city.getText().toString().trim();
        String dob_txt = dobET.getText().toString().trim();

        UserModel model = new UserModel();
        model.setUserName(name_txt);
        model.setCountryName(country_txt);
        model.setCityName(city_txt);
        model.setDob(dob_txt);

        UserRoomDatabase.getDatabase(getApplicationContext()).userDao().insertAll(model);

        nameET.setText("");
        act_country.setText("");
        act_city.setText("");
        dobET.setText("");
        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }


    private boolean validateName() {
        String nameInput = nameET.getText().toString().trim();

        if (nameInput.isEmpty()) {
            nameTil.setError("Field can't be empty");
            return false;
        } else {
            nameTil.setError(null);
            return true;
        }
    }

    private boolean validateCountry() {
        String countryInput = act_country.getText().toString().trim();

        if (countryInput.isEmpty()) {
            countryTil.setError("Field can't be empty");
            return false;
        } else {
            countryTil.setError(null);
            return true;
        }
    }

    private boolean validateCity() {
        String cityInput = act_city.getText().toString().trim();

        if (cityInput.isEmpty()) {
            cityTil.setError("Field can't be empty");
            return false;
        } else {
            cityTil.setError(null);
            return true;
        }
    }

    private boolean validateDob() {
        String dobInput = dobET.getText().toString().trim();

        if (dobInput.isEmpty()) {
            dobTil.setError("Field can't be empty");
            return false;
        } else {
            dobTil.setError(null);
            return true;
        }
    }

//    private boolean validateThana() {
//        String thanaInput = addressThanaET.getText().toString().trim();
//
//        if (thanaInput.isEmpty()) {
//            addressThanaTil.setError("Field can't be empty");
//            return false;
//        } else {
//            addressThanaTil.setError(null);
//            return true;
//        }
//    }

}