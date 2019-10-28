package com.benjdd.videogamecharacters;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    /** TODO:
     * * You can create a variable here, that can be used to keep track of
     * * which view (the good list or bad list) should be being displayed.
     */
    private boolean current = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** TODO:
         * * Check if the screen is big or small,
         * * If it is big, call setupFragmentsForBigScreen
         * * Else, call setupFragmentsForSmallScreen
         */
        if(!isBigScreen()) {
            setContentView(R.layout.activity_main_small);
            setupFragmentsForSmallScreen();
        }
        else {
            setContentView(R.layout.activity_main_big);
            setupFragmentsForBigScreen();
        }

    }

    /**
     * @return true if the screen is larger than 5 by 5 inches, fale otherwise
     */
    private boolean isBigScreen() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float xInches = (((float)metrics.widthPixels) / metrics.xdpi);
        float yInches = (((float)metrics.widthPixels) / metrics.xdpi);
        return xInches > 5.0 && yInches > 5.0;
    }

    public void toggleGoodBad(View v) {
        /** TODO:
         * * Toggle between showing the list of good characters and list of bad characters
         * * Use fragment(s) and a fragment transaction(s)
         * * You can replace the innter contents of the LinearLayout with the id of good_or_bad_layout
         * * This function should also get called when the toggle button is pressed
         */

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(current){
            BadCharactersFragment Frag = new BadCharactersFragment();
            Frag.setContainerActivity(this);
            transaction.replace(R.id.good_or_bad_layout, Frag);
        }
        else{
            GoodCharactersFragment Frag = new GoodCharactersFragment();
            Frag.setContainerActivity(this);
            transaction.replace(R.id.good_or_bad_layout, Frag);
        }
        current = !current;
        transaction.addToBackStack(null);
        transaction.commit();


    }

    private void setupFragmentsForSmallScreen() {
        /** TODO:
         * * Set the content view to be based on the activity_main_small.xml file
         * * Then, call the function to toggle between the good and bad characters
         */
        GoodCharactersFragment gFrag = new GoodCharactersFragment();
        gFrag.setContainerActivity(this);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.good_or_bad_layout, gFrag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void setupFragmentsForBigScreen() {
        /** TODO:
         * * Set the content view to be based on the activity_main_big.xml file
         * * Then, use fragments and fragment transactions to display both lists.
         */
        GoodCharactersFragment gFrag = new GoodCharactersFragment();
        gFrag.setContainerActivity(this);
        BadCharactersFragment bFrag = new BadCharactersFragment();
        bFrag.setContainerActivity(this);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.good_layout, gFrag);
        transaction.add(R.id.bad_layout, bFrag);
        transaction.commit();
    }
}

