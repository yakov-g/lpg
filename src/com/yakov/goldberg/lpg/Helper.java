package com.yakov.goldberg.lpg;

import android.content.Intent;

public class Helper {

	public Intent send_mail_to_developer(String subject, String body) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yakov.goldberg@gmail.com"});
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, body);
		return intent;
	}

}
