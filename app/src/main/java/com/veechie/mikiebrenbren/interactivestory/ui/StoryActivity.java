package com.veechie.mikiebrenbren.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.veechie.mikiebrenbren.interactivestory.R;
import com.veechie.mikiebrenbren.interactivestory.model.Page;
import com.veechie.mikiebrenbren.interactivestory.model.Story;


public class StoryActivity extends ActionBarActivity {

    private Page[] mPages;
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;
    private String mName;


    public static final String TAG = StoryActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
         mName = intent.getStringExtra(getString(R.string.key_name));

        if("name" == null)
            mName ="freind";

        Log.d(TAG, mName);

        mImageView = (ImageView)findViewById(R.id.storyImageView);
        mTextView = (TextView)findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.choiceButton1);
        mButton2 = (Button) findViewById(R.id.choiceButton2);


    }

    private void loadPage(){

        Page page  = mStory.getPage(0);

        Drawable drawable = getResources().getDrawable(page.getImageId());
        mImageView.setImageDrawable(drawable);

        String pageText = page.getText();
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);

        mButton1.setText(page.getChoice1().getText());
        mButton2.setText(page.getChoice2().getText());

    }

}
