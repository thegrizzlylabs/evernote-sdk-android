package com.evernote.client.android;

import android.content.Intent;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;

public class EvernoteOAuthCustomTabsActivity extends FragmentActivity {

    @Override
    protected void onResume() {
        super.onResume();

        // If this is the first run of the activity, start the authorization activity
        String url = getIntent().getStringExtra(EvernoteUtil.EXTRA_AUTHORIZATION_URL);
        if (url != null) {
            new CustomTabsIntent.Builder()
                    .build()
                    .launchUrl(this, Uri.parse(url));
            return;
        }

        // Otherwise we're returning from the authorization activity, so finish the activity with the right result
        Uri redirectUri = getIntent().getData();
        Intent data = new Intent();
        if (redirectUri != null) {
            data.putExtra(EvernoteUtil.EXTRA_OAUTH_CALLBACK_URL, redirectUri.toString());
        }
        setResult(redirectUri == null ? RESULT_CANCELED : RESULT_OK, data);
        finish();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
