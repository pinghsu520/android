package com.example.collagecreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final String IMAGE_ID = "com.benjdd.collagemaker.IMG";
    Uri currentPhotoUri = null;
    String currentPhotoPath = null;
    ImageView currentImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dispatchTakePictureIntent(View v) {
        Intent takePictureIntent = new
                Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(
                takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

//    protected void onActivityResult(int requestCode,
//                                    int resultCode,
//                                    Intent data) {
//
//        if (requestCode == REQUEST_IMAGE_CAPTURE &&
//                resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            ImageView imageView = findViewById(R.id.profile_image);
//            imageView.setImageBitmap(imageBitmap);
//        }
//
//    }




}
