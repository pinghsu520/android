package com.benjdd.tasks;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String TASKS_THEME = "com.benjdd.TASKS_THEME";
    private final String THEME_LIGHT = "light";
    private final String THEME_DARK = "dark";

    // The name of the tasks file
    private String tasksFileName = "tasks_file.txt";

    // The task data, ListView and the adapter that will be associated with it
    private ListView tasksListView = null;
    ArrayAdapter<String> taskArrayAdapter = null;
    private ArrayList<String> tasks = new ArrayList<String>();

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final String IMAGE_ID = "com.benjdd.collagemaker.IMG";
    Uri currentPhotoUri = null;
    String currentPhotoPath = null;
    ImageView currentImageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTasksTheme(null);
        setContentView(R.layout.activity_main);

        createTasksFileIfNotExists();
        populateTasks();
        setupTasksList();
    }

    public void setAlarmForTask(View v) {
        // Implement
    }

    private File createImageFile() throws Exception {
        String timeStamp = new
                SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir =
                getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName, ".jpg", storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public void dispatchTakePictureIntent(View v) {

        Intent takePictureIntent =
                new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File photoFile = createImageFile();
        currentImageView = (ImageView) v;
        currentPhotoUri = FileProvider.getUriForFile(
                this, "com.benjdd.tasks.fileprovider", photoFile);
        takePictureIntent.putExtra(
                MediaStore.EXTRA_OUTPUT, currentPhotoUri);
        startActivityForResult(
                takePictureIntent, REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE &&
                resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = findViewById(R.id.steph);
            imageView.setImageBitmap(imageBitmap);
        }

    }

    /**
     * Set the theme of the application.
     */
    public void setTasksTheme(View v) {
        SharedPreferences sharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
        String theme  = sharedPrefs.getString(TASKS_THEME, THEME_LIGHT);

        if (theme.equals(THEME_LIGHT)) {
            setTheme(R.style.AppThemeLight);
        } else {
            setTheme(R.style.AppThemeDark);
        }
    }

    /**
     * Set the theme of the application.
     */
    public void toggleTheme(View v) {
        SharedPreferences sharedPrefs = this.getPreferences(Context.MODE_PRIVATE);
        String theme  = sharedPrefs.getString(TASKS_THEME, THEME_LIGHT);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        if (theme.equals(THEME_LIGHT)) {
            editor.putString(TASKS_THEME, THEME_DARK);
        } else {
            editor.putString(TASKS_THEME, THEME_LIGHT);
        }

        editor.commit();
        recreate();
    }

    /**
     * This function is called whenever a user pressed the button to add a task to the list.
     * @param v the button that was clicked on.
     */
    public void addTaskButtonClicked(View v) {
        EditText editText = this.findViewById(R.id.type_task);
        String taskText = editText.getText().toString();
        tasks.add(taskText);
        taskArrayAdapter.notifyDataSetChanged();
    }

    /**
     * This function is called whenever a task in the task list is clicked on.
     * @param v the view that was clicked on.
     */
    public void taskClicked(View v) {
        String taskText = ((TextView) v).getText().toString();
        tasks.remove(taskText);
        taskArrayAdapter.notifyDataSetChanged();
    }

    /**
     * Create the data <-> adapter <-> ListView association
     */
    private void setupTasksList() {
        tasksListView =
                (ListView)findViewById(R.id.tasks_list_view);
        taskArrayAdapter = new
                ArrayAdapter<String>(this, R.layout.task_row,
                R.id.task_item, tasks);
        tasksListView.setAdapter(taskArrayAdapter);
    }

    /**
     * Read the tasks from the task file.
     */
    private void populateTasks() {
        Context context = getApplicationContext();
        try {
            FileInputStream fileInputStream = context.openFileInput(tasksFileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String taskLine = bufferedReader.readLine();
            while (taskLine != null) {
                tasks.add(taskLine);
                taskLine = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Oh Sheisse-Schnitzel, das error ja.");
        }
    }

    /**
     * Create the task file, only if it doesn't already exist.
     */
    private void createTasksFileIfNotExists() {
        File file = this.getFileStreamPath(tasksFileName);
        if (!file.exists()) {
            String fileContents = "Wake up\nAttend 317\nAdd tasks\nDo the tasks!\n";
            FileOutputStream outputStream;
            try {
                outputStream = openFileOutput(tasksFileName, this.MODE_PRIVATE);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Save task list to non-volatile memory
     */
    private void saveTasksFile() {
        File file = this.getFileStreamPath(tasksFileName);
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(tasksFileName, this.MODE_PRIVATE);
            for (String taskString : tasks) {
                outputStream.write((taskString + "\n").getBytes());
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Share a task from the task list
     * @param v
     */
    public void shareTask(View v) {
        LinearLayout ll = (LinearLayout) v.getParent();
        TextView tv = ll.findViewById(R.id.task_item);
        String shareBody = tv.getText().toString();

        Intent sharingIntent = new
                Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(
                android.content.Intent.EXTRA_SUBJECT, "A task");
        sharingIntent.putExtra(
                android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(sharingIntent);
    }

}
