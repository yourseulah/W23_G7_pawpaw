package com.example.petgrooming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdatePetInfoActivity extends AppCompatActivity {

    EditText pet_name_input, pet_animal_type_input, pet_breed_input, pet_size_input, pet_age_input, pet_condition_input, pet_firebase_photoid;
    Button update_button,delete_button;
    String id, breed, name, type, size, age, condition, firebasePhotoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pet_info);

        pet_name_input = findViewById(R.id.pet_name_update);
        pet_animal_type_input = findViewById(R.id.pet_animal_type_update);
        pet_breed_input = findViewById(R.id.pet_breed_update);
        pet_size_input = findViewById(R.id.pet_size_update);
        pet_age_input = findViewById(R.id.pet_age_update);
        pet_condition_input = findViewById(R.id.pet_condition_update);
        update_button = findViewById(R.id.add_button_update);
        delete_button = findViewById(R.id.delete_button_update);
        pet_firebase_photoid = findViewById(R.id.editTextFireBaseIdinUpdate);
        getAndSetIntentData();
        update_button.setOnClickListener((View v) -> {
            MyPetInfoDatabaseHelper myDB = new MyPetInfoDatabaseHelper(UpdatePetInfoActivity.this);
            name = pet_name_input.getText().toString();
            type = pet_animal_type_input.getText().toString();
            breed = pet_breed_input.getText().toString();
            size = pet_size_input.getText().toString();
            age = pet_age_input.getText().toString();
            condition = pet_condition_input.getText().toString();
            firebasePhotoId = pet_condition_input.getText().toString();
            myDB.updateData(id, name, type, breed, age, size, condition,firebasePhotoId);
            Intent intent = new Intent(UpdatePetInfoActivity.this,
                    HomeScreenMainActivity.class);
            startActivity(intent);

        });
        delete_button.setOnClickListener((View v) -> {
            MyPetInfoDatabaseHelper myDB = new MyPetInfoDatabaseHelper(UpdatePetInfoActivity.this);
            myDB.deleteOneRow(id);

        });




    }
    void getAndSetIntentData()
    {
        id = getIntent().getStringExtra("pet_id_update");
        name = getIntent().getStringExtra("pet_name_update");
        type = getIntent().getStringExtra("pet_animal_type_update");
        size = getIntent().getStringExtra("pet_size_update");
        age = getIntent().getStringExtra("pet_age_update");
        breed = getIntent().getStringExtra("pet_breed_update");
        condition = getIntent().getStringExtra("pet_condition_update_new");
        pet_name_input.setText(name);
        pet_animal_type_input.setText(type);
        pet_age_input.setText(age);
        pet_size_input.setText(size);
        pet_breed_input.setText(breed);
        pet_condition_input.setText(condition);

    }

}