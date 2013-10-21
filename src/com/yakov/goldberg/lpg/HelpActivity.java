package com.yakov.goldberg.lpg;

import com.yakov.goldberg.lpg.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);

		TextView tw = (TextView) findViewById(R.id.helptextView);
		String en_str = getResources().getString(R.string.help_content);
		String ver_str = getResources().getString(R.string.version_string);
		String changes = "Changes:\n  - added price update date;\n"
				+ "  - added LPG garages;\n" + "  - bug fixes.";
		tw.setText(en_str + "\n\n\n" + ver_str + "\n\n" + changes);

		final Button mybutton = (Button) findViewById(R.id.button_rate);
		mybutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String str = "https://play.google.com/store/apps/details?id=com.yakov.goldberg.lpg";
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help, menu);
		return true;
	}

	public void help_send_mail_clicked(View view) {
		Intent i = (new Helper()).send_mail_to_developer("Subject",
				"I'm email body.");
		startActivity(Intent.createChooser(i, "Send Email"));
	}
}
