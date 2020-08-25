package ch.sbb.spc.demo;

/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2017.
 */

import android.app.Application;

import ch.sbb.spc.Environment;
import ch.sbb.spc.Settings;
import ch.sbb.spc.SwissPassLoginClient;
import ch.sbb.spc.SwissPassMobileClient;

public class DemoApplication extends Application {

    String clientId = "oauth_tester_inte";
    String redirectAppUrl = "sidapp://oauth/callback";
    String provider = "oauth_t";

    @Override
    public void onCreate() {
        super.onCreate();

        // Init singleton whit application specific settings
        Settings settings = new Settings(clientId, provider, redirectAppUrl, Environment.INTEGRATION);
        SwissPassLoginClient loginClient = SwissPassLoginClient.initialize(getApplicationContext(), settings);
        SwissPassMobileClient.initialize(getApplicationContext(), loginClient);
    }
}
