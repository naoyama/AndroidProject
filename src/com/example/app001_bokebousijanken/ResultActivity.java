package com.example.app001_bokebousijanken;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	public static final String EXTRA_NAME = "extra_janken";
	public static final int EXTRA_GUU = 0;
	public static final int EXTRA_CHOKI = 1;
	public static final int EXTRA_PAR = 2;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int konkai = getIntent().getIntExtra(EXTRA_NAME, 999);
        if( konkai == 999 ){
        	finish();
        	return;
        }

        TextView first_view = (TextView)findViewById(R.id.firstView);
        View result_view = findViewById(R.id.resultView);

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        int zenkai = pref.getInt(EXTRA_NAME, 999);
        if( zenkai == 999 ){
        	first_view.setVisibility(View.VISIBLE);
        	result_view.setVisibility(View.INVISIBLE);
        }else{
        	first_view.setVisibility(View.INVISIBLE);
        	result_view.setVisibility(View.VISIBLE);

        	TextView textResult = (TextView)findViewById(R.id.textResult);
        	if( zenkai == konkai ){
        		textResult.setText(R.string.result_aiko);
        	}else{
        		switch( zenkai ){
	        		case EXTRA_GUU:
	        			if( konkai == EXTRA_PAR ){
	        				textResult.setText(R.string.result_win);
	                	}else{
	        				textResult.setText(R.string.result_loose);
	        			}
	        			break;
	        		case EXTRA_CHOKI:
	        			if( konkai == EXTRA_GUU ){
	        				textResult.setText(R.string.result_win);
	                	}else{
	        				textResult.setText(R.string.result_loose);
	        			}
	        			break;
	        		case EXTRA_PAR:
	        			if( konkai == EXTRA_CHOKI ){
	        				textResult.setText(R.string.result_win);
	                	}else{
	        				textResult.setText(R.string.result_loose);
	        			}
	        			break;
        		}
        	}
        }

        // 今回のを記憶する
        Editor editor = pref.edit();
        editor.putInt(EXTRA_NAME, konkai);
        editor.commit();

        // 閉じるボタン
        Button btnEnd = (Button)findViewById(R.id.buttonEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ResultActivity.this.finish();
			}
		});


	}
}
