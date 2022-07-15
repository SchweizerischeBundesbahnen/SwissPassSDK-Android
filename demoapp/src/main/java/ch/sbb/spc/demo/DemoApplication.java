package ch.sbb.spc.demo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import ch.sbb.spc.ClientFactory;
import ch.sbb.spc.Environment;
import ch.sbb.spc.Settings;
import ch.sbb.spc.SwissPassLoginClient;

public class DemoApplication extends Application implements LifecycleOwner, ViewModelStoreOwner {

    private static ClientFactory<DemoApplication> clientFactory;
    public static ClientFactory<DemoApplication> getClientFactory() {
        return clientFactory;
    }

    String clientId = "oauth_tester_inte";
    String redirectAppUrl = "sidapp://oauth/callback";
    String provider = "oauth_t";

    @Override
    public void onCreate() {
        super.onCreate();

        clientFactory = new ClientFactory<>(this);

        Settings settings = new Settings(clientId, provider, redirectAppUrl, Environment.INTEGRATION);
        SwissPassLoginClient loginClient = clientFactory.createLoginClient(settings);
        clientFactory.createMobileClient(loginClient);
    }

    private final ViewModelStore viewModelStore = new ViewModelStore();

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return ProcessLifecycleOwner.get().getLifecycle();
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }
}
