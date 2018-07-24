package aditya.com.activitytransections;

import android.app.ActivityOptions;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupWindowAnimations();
    }


    private void setupWindowAnimations() {

        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(400);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }

    public void slideTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
        i.putExtra(Constants.KEY_TITLE, "Slide By Java Code");
        startActivity(i, options.toBundle());
    }

    public void slideTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        i.putExtra(Constants.KEY_TITLE, "Slide By XML");
        startActivity(i, options.toBundle());
    }



    public void explodeTransitionByCode(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.ExplodeJava);
        i.putExtra(Constants.KEY_TITLE, "Explode By Java");
        startActivity(i, options.toBundle());

    }

    public void exolpdeTransitionByXML(View view) {

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideXML);
        i.putExtra(Constants.KEY_TITLE, "Slide By XML");
        startActivity(i, options.toBundle());
    }
}
