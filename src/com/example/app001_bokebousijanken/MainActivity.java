package com.example.app001_bokebousijanken;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener{



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getPreferences(MODE_PRIVATE);

        // ボタンのリスナー設定
        ImageButton btn;
        btn = (ImageButton)findViewById(R.id.buttonGuu);
        btn.setOnClickListener(this);
        btn = (ImageButton)findViewById(R.id.buttonChoki);
        btn.setOnClickListener(this);
        btn = (ImageButton)findViewById(R.id.buttonPar);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	public void onClick(View v) {
		Intent intent = new Intent(this, ResultActivity.class);
		switch(v.getId() ){
			case R.id.buttonGuu:
				intent.putExtra(ResultActivity.EXTRA_NAME, ResultActivity.EXTRA_GUU);
				break;
			case R.id.buttonChoki:
				intent.putExtra(ResultActivity.EXTRA_NAME, ResultActivity.EXTRA_CHOKI);
				break;
			case R.id.buttonPar:
				intent.putExtra(ResultActivity.EXTRA_NAME, ResultActivity.EXTRA_PAR);
				break;
			default:
				return;
		}
		startActivity(intent);
		finish();
	}


}
