package com.example.collagemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.myfirstapptest.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;




public class MainActivity extends AppCompatActivity {

    Uri currentPhotoUri = null;
    String currentPhotoPath = null;
    ImageView currentImageView = null;

    static final int REQUEST_IMAGE_CAPTURE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



//    public void dispatchTakePictureIntent(View v) {
//        Intent takePictureIntent = new
//                Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(
//                takePictureIntent, REQUEST_IMAGE_CAPTURE);
//    }
//    @Override
//// Just a small icon, how to save file, full size?
//    protected void onActivityResult(int requestCode,
//                                    int resultCode,
//                                    Intent data) {
//
//        if (requestCode == REQUEST_IMAGE_CAPTURE &&
//                resultCode == RESULT_OK) {
//            Bundle extras = data.getExtras();
//            Bitmap imageBitmap = (Bitmap) extras.get("data");
//            ImageView imageView = findViewById(R.id.steph);
//            imageView.setImageBitmap(imageBitmap);
//        }
//
//    }
//
//    private File createImageFile() throws Exception {
//        String timeStamp = new
//                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        String imageFileName = "JPEG_" + timeStamp + "_";
//        File storageDir =
//                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName, ".jpg", storageDir);
//        currentPhotoPath = image.getAbsolutePath();
//        return image;
//    }
}