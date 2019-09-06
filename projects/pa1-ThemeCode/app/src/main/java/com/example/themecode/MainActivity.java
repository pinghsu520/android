package com.example.themecode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.app.ActionBar;
import android.app.Activity;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Context context=getApplicationContext();
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));



        TextView space = new TextView(context);
        space.setText("\n");
        space.setGravity(Gravity.CENTER);
        space.setTextSize(25);



        // Title: GSW
        TextView title = new TextView(context);
        title.setTypeface(null,Typeface.BOLD_ITALIC);
        title.setText("Golden State Warriors");
        title.setTextColor(Color.parseColor("#000000"));
        title.setGravity(Gravity.CENTER);
        title.setTextSize(35);




        TextView textView = new TextView(context);
        LinearLayout.LayoutParams textView_LayoutParams = new
                LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView_LayoutParams.gravity = Gravity.CENTER;
        textView.setGravity(Gravity.CENTER);
        textView.setText("The Golden State Warriors are an American professional basketball team\n" +
                "        based in San Francisco. The Warriors compete in the National Basketball Association (NBA),\n" +
                "        as a member of the Western Conference Pacific Division. Founded in 1946 in\n" +
                "        Philadelphia, the Warriors relocated to the San Francisco Bay Area in 1962 and took the\n" +
                "        name of the city.");
        textView.setTextColor(Color.parseColor("#0E0E75"));
        final float scale = context.getResources().getDisplayMetrics().density;
        textView.setTextSize(25);

//
        textView_LayoutParams.setMargins((int) (50 * scale + 0.5f), (int) (50 * scale + 0.5f),
                (int) (50 * scale + 0.5f), (int) (50 * scale + 0.5f));
        textView.setLayoutParams(textView_LayoutParams);




        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setBackgroundColor(Color.parseColor("#39ff14"));
//        linearLayout.setBackgroundColor(Color.parseColor("0E0E75"));




        ImageView gsw_logo = new ImageView(this);
        gsw_logo.setLayoutParams(textView_LayoutParams);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(400, 400);
        gsw_logo.setLayoutParams(lp);
        gsw_logo.setImageResource(R.drawable.gswlogo);


        ImageView gsw_champs = new ImageView(this);
        gsw_champs.setLayoutParams(textView_LayoutParams);

        ViewGroup.LayoutParams lp1 = new ViewGroup.LayoutParams(1000, 1500);
        gsw_champs.setLayoutParams(lp1);
        gsw_champs.setImageResource(R.drawable.gswchamps);



        TextView textView1 = new TextView(context);
        LinearLayout.LayoutParams textView_LayoutParams1 = new
                LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView_LayoutParams1.gravity = Gravity.CENTER;
        textView1.setGravity(Gravity.CENTER);
        textView1.setText("The 2018 Finals pitted the Warriors against the Cavaliers for the fourth consecutive season;\n" +
                "    this marked the first time in NBA history that the same two teams had met in the Finals for\n" +
                "    four consecutive years. The Warriors swept the Cavaliers to win their second straight NBA\n" +
                "    championship; previously, there had not been an NBA Finals sweep since 2007.\n" +
                "    Following the 2018 NBA Finals, writers for Sports Illustrated,\n" +
                "    USA Today described the Warriors as a dynasty.");
        textView1.setTextColor(Color.parseColor("#ff0000"));
        final float scale1 = context.getResources().getDisplayMetrics().density;
        textView1.setTextSize(25);
        textView_LayoutParams1.setMargins((int) (50 * scale1 + 0.5f), (int) (50 * scale1 + 0.5f),
                (int) (50 * scale1 + 0.5f), (int) (50 * scale1 + 0.5f));
        textView1.setLayoutParams(textView_LayoutParams1);






        ImageView steph = new ImageView(this);
        steph.setLayoutParams(textView_LayoutParams);

        ViewGroup.LayoutParams lp2 = new ViewGroup.LayoutParams(1000, 1500);
        steph.setLayoutParams(lp2);
        steph.setImageResource(R.drawable.steph1);




        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams textView_LayoutParams2 = new
                LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
//        textView_LayoutParams2.gravity = Gravity.CENTER;
        textView2.setGravity(Gravity.CENTER);
        textView2.setText("The leader of the GSW, Wardell Stephen \"Steph\" Curry II (born March 14, 1988) is an American\n" +
                "    professional basketball player for the Golden State Warriors of the National Basketball\n" +
                "    Association (NBA). A six-time NBA All-Star, he has been named the NBA Most Valuable Player\n" +
                "    (MVP) twice and won three NBA championships with the Warriors. Many players and analysts\n" +
                "    have called him the greatest shooter in NBA history.");
        textView2.setTextColor(Color.parseColor("#000000"));
        final float scale2 = context.getResources().getDisplayMetrics().density;
        textView2.setTextSize(25);
        textView_LayoutParams2.setMargins((int) (50 * scale2 + 0.5f), (int) (50 * scale2 + 0.5f),
                (int) (50 * scale2 + 0.5f), (int) (50 * scale2 + 0.5f));
        textView2.setLayoutParams(textView_LayoutParams2);



        linearLayout.addView(space);
        linearLayout.addView(gsw_logo);
        linearLayout.addView(title);



        linearLayout.addView(textView);
        linearLayout.addView(gsw_champs);
        linearLayout.addView(textView1);
        linearLayout.addView(steph);
        linearLayout.addView(textView2);

        scrollView.addView(linearLayout);





        setContentView(scrollView);

//second way



//
//
////        ScrollView scrollView = new ScrollView(this);
////        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
////                ViewGroup.LayoutParams.MATCH_PARENT));
////
//
//        TextView textView = new TextView(this);
//        textView.setTextColor(Color.parseColor("#0000ff"));
//        textView.setText("This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n" +
//                "This TextView is dynamically created\n");
//
//
////        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
//        this.addContentView(linearLayout, layoutParams);
//        linearLayout.addView(textView);
//
//
//
//        ImageView imageView1 = new ImageView(this);
//            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(0, 100, 0, 30);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView1);
//
//            ImageView imageView2 = new ImageView(this);
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(20, 10, 20, 10);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView2);
//
//        Button button = new Button(this);
//        button.setText("This Button is dynamically created");
//
//        // stuff that is added
//
//
//        linearLayout.addView(button);
//
////        this.addContentView(scrollView, layoutParams);
////        scrollView.addView(linearLayout);
//
//




        // THIRD WAY?
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            ScrollView scrollView = new ScrollView(this);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            scrollView.setLayoutParams(layoutParams);
//
//            LinearLayout linearLayout = new LinearLayout(this);
//            LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            linearLayout.setOrientation(LinearLayout.VERTICAL);
//            linearLayout.setLayoutParams(linearParams);
//
//            scrollView.addView(linearLayout);

//            ImageView imageView1 = new ImageView(this);
//            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params1.setMargins(0, 30, 0, 30);
//            params1.gravity = Gravity.CENTER;
//            imageView1.setLayoutParams(params1);
//            imageView1.setImageResource(R.drawable.gsw1);
//            linearLayout.addView(imageView1);
//
//            ImageView imageView2 = new ImageView(this);
//            LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params2.setMargins(0, 0, 0, 30);
//            params2.gravity = Gravity.CENTER;
//            imageView2.setLayoutParams(params2);
//            imageView2.setImageResource(R.drawable.gsw2);
//            linearLayout.addView(imageView2);
//
//            ImageView imageView3 = new ImageView(this);
//            LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params3.setMargins(0, 0, 0, 30);
//            params3.gravity = Gravity.CENTER;
//            imageView3.setLayoutParams(params3);
//            imageView3.setImageResource(R.drawable.gsw3);
//            linearLayout.addView(imageView3);
//
//            ImageView imageView4 = new ImageView(this);
//            LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            params4.setMargins(0, 0, 0, 30);
//            params4.gravity = Gravity.CENTER;
//            imageView4.setLayoutParams(params4);
//            imageView4.setImageResource(R.drawable.gsw4);
//            linearLayout.addView(imageView4);


//            LinearLayout linearLayout1 = findViewById(R.id.rootContainer);
//            if (linearLayout1 != null) {
//                linearLayout1.addView(scrollView);
//            }
//        }



    }
}