package com.example.collagecreator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity<btnshare> extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final String IMAGE_ID = "com.example.collagemaker.IMG";
    Uri currentPhotoUri = null;
    String currentPhotoPath = null;
    ImageView currentImageView = null;
    private String sharePath="no";
    private ImageView iv;
    private Button buttonShare;
    private Button btnSS, btnshare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnshare = findViewById(R.id.share);
        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("GOT TO BUTTON!");
//                takeScreenshot();
//                if (!sharePath.equals("no")) {
//                    System.out.print("REACHED HERE");

                    share(sharePath);
//                }
            }
        });
        View iv = findViewById(R.id.top);

    }


        private void takeScreenshot() {
        Date now = new Date();
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {

            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpeg";

            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            String filePath = imageFile.getPath();
            System.out.println("THE FILE PATH IS: "+filePath);
            Bitmap ssbitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            iv.setImageBitmap(ssbitmap);
            sharePath = filePath;

        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }

    private void share(String sharePath){
        File file = new File(sharePath);
        Uri uri = currentPhotoUri;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent .setType("image/*");
        intent .putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent );

    }



    private File createImageFile() throws Exception {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
    public void dispatchTakePictureIntent(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            File photoFile = createImageFile();
            currentImageView = (ImageView) v;
            currentPhotoUri = FileProvider.getUriForFile(this, "com.example.collagecreator.fileprovider", photoFile);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, currentPhotoUri);
        }
        catch(Exception e){}

        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
            currentImageView.setImageBitmap(bitmap);
        }
    }
//    }




}
