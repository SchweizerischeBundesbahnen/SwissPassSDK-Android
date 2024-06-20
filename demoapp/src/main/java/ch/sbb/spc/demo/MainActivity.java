package ch.sbb.spc.demo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ch.sbb.spc.AccountStatus;
import ch.sbb.spc.Page;
import ch.sbb.spc.ReauthenticationMethod;
import ch.sbb.spc.RequestListener;
import ch.sbb.spc.Response;
import ch.sbb.spc.Scope;
import ch.sbb.spc.SwissPassLoginClient;
import ch.sbb.spc.SwissPassMobileClient;

/**
 * The demo app shows how to initialize Swisspass OAuthClient and use API calls.
 * This app is kept as simple as possible just to show the basic interaction between an application
 * and the authentication library. In a real application it is not recommended to keep API
 * request listeners in an activity, because activities may die during an asynchronous request call,
 * for e.g. due to orientation change or the system kills the activity.
 * <p>
 * Please read through readme, release notes and javadoc.
 * <p>
 * If you use Proguard then you have to copy proguard rules from this project.
 */
public class MainActivity extends AppCompatActivity {

    TextView accessTokenTextView;
    TextView userInfoTextView;
    TextView responseCodeTextView;
    TextView developerMessageTextView;
    TextView userMessageTextView;
    TextView isLoggedInTextView;
    TextView swisspassStatus;
    RadioButton fingerprintSelector;

    private SwissPassLoginClient loginClient;
    private SwissPassMobileClient mobileClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        accessTokenTextView = findViewById(R.id.accessTokenTextView);
        userInfoTextView = findViewById(R.id.idUserInfoTextView);
        responseCodeTextView = findViewById(R.id.responseCode);
        developerMessageTextView = findViewById(R.id.developerMessage);
        userMessageTextView = findViewById(R.id.userMessage);
        fingerprintSelector = findViewById(R.id.fingerprintSelector);
        isLoggedInTextView = findViewById(R.id.isLoggedInTextView);
        swisspassStatus = findViewById(R.id.swisspassStatus);
        fingerprintSelector.setChecked(true);

        DemoApplication.getClientFactory().initializeActivityResult(this);
        loginClient = SwissPassLoginClient.getInstance();
        mobileClient = SwissPassMobileClient.getInstance();
    }

    public void onLogin(View view) {
        loginClient.requestLogin(new Scope(), new DefaultContinuation<>((result) -> {
            showError(result);
            runOnUiThread(() -> accessTokenTextView.setText(result.getAccessToken()));
        }));
    }

    public void onRegister(View view) {
        loginClient.requestRegistration(new DefaultContinuation<>(this::showError));
    }

    public void onToken(View view) {
        loginClient.requestToken(new DefaultContinuation<>(result -> {
            showError(result);
            runOnUiThread(() -> accessTokenTextView.setText(result.getAccessToken()));
        }));
    }

    public void onIsKeyStoreAvailable(View view) {
        String text;
        if (SwissPassLoginClient.getInstance().isKeyStoreAvailable()) {
            text = "YES";
        } else {
            text = "NO";
        }
        isLoggedInTextView.setText(text);
    }

    public void onLogout(View view) {
        loginClient.requestLogout(new DefaultContinuation<>(result -> {
            showError(result);
            runOnUiThread(() -> {
                accessTokenTextView.setText("");
                userInfoTextView.setText("");
            });
        }));
    }

    public void onUserInfo(View view) {
        loginClient.requestUserInfo(new DefaultContinuation<>(result -> {
            showError(result);
            if (result.getUserInfo() != null) {
                final String text = String.format("%s %s", result.getUserInfo().getFirstName(), result.getUserInfo().getLastName());
                runOnUiThread(() -> userInfoTextView.setText(text));
            } else {
                runOnUiThread(() -> userInfoTextView.setText(""));
            }
        }));
    }

    public void onAccountManagement(View view) {
        loginClient.openSwissPass(Page.ACCOUNT_MANAGEMENT, null, new DefaultContinuation<>(this::showError));
    }

    public void onLoginDataManagement(View view) {
        loginClient.openSwissPass(Page.LOGIN_DATA_MANAGEMENT, null, new DefaultContinuation<>(this::showError));
    }

    public void onLinkCard(View view) {
        loginClient.openSwissPass(Page.LINK_CARD_MANAGEMENT, null, new DefaultContinuation<>(this::showError));
    }

    public void onInfoAbo(View view) {
        loginClient.openSwissPass(Page.INFO_ABOS, "null", new DefaultContinuation<>(this::showError));
    }

    public void onInfoSwissPass(View view) {
        loginClient.openSwissPass(Page.INFO_SWISSPASS, null, new DefaultContinuation<>(this::showError));
    }

    public void onContact(View view) {
        loginClient.openSwissPass(Page.CONTACT_FORM, null, new DefaultContinuation<>(this::showError));
    }

    public void onReauthenticate(View view) {
        ReauthenticationMethod reauthenticationMethod = ReauthenticationMethod.DEVICE_SCREENLOCK;
        if (fingerprintSelector.isChecked()) {
            reauthenticationMethod = ReauthenticationMethod.FINGERPRINT_ONLY;
        }
        loginClient.requestAuthentication(reauthenticationMethod, "Fingerprint custom infotext", new DefaultContinuation<>(this::showError));
    }

    @SuppressLint("SetTextI18n")
    public void onSwissPassMobileStatus(View view) {
        swisspassStatus.setText("");
        mobileClient.requestSwissPassMobileAccountStatus(new DefaultContinuation<>((result) -> {
            showError(result);
            if (RequestListener.SPC_ERROR_NO_ERROR == result.getErrorCode()) {
                final AccountStatus status = result.getSwissPassMobileAccountStatus();
                if (status != null) {
                    runOnUiThread(() -> swisspassStatus.setText(status.toString()));
                }
            } else {
                runOnUiThread(() -> swisspassStatus.setText("Account Status unavailable, see error"));
            }
        }));
    }

    public void onSwissPassMobileActivate(View view) {
        mobileClient.requestSwissPassMobileActivation(new DefaultContinuation<>(this::showError));
    }

    public void onSwissPassMobileShow(View view) {
        startActivity(new Intent(MainActivity.this, SwissPassMobileActivity.class));
    }

    public void onSwissPassMobileShowCard(View view) {
        startActivity(new Intent(MainActivity.this, SwissPassMobileCardActivity.class));
    }

    public void onSwissPassMobileDeactivate(View view) {
        mobileClient.requestSwissPassMobileDeactivation(new DefaultContinuation<>(this::showError));
    }

    public void showError(final Response response) {
        runOnUiThread(() -> {
            responseCodeTextView.setText("");
            developerMessageTextView.setText("");
            userMessageTextView.setText("");
            responseCodeTextView.setText(responseCodeToString(response));
            developerMessageTextView.setText(response.getDeveloperErrorMessage());
            if (!response.getUserErrorMessage().isEmpty()) {
                userMessageTextView.setText(response.getUserErrorMessage());
            }
        });
    }

    private String responseCodeToString(Response response) {
        return switch (response.getErrorCode()) {
            case RequestListener.SPC_ERROR_ACCESS_DENIED -> "SPC_ERROR_ACCESS_DENIED";
            case RequestListener.SPC_ERROR_CANCELLED -> "SPC_ERROR_CANCELLED";
            case RequestListener.SPC_ERROR_OAUTH_INVALID_TOKEN -> "SPC_ERROR_INVALID_TOKEN";
            case RequestListener.SPC_ERROR_IO -> "SPC_ERROR_IO";
            case RequestListener.SPC_ERROR_NO_ERROR -> "SPC_ERROR_NO_ERROR";
            case RequestListener.SPC_ERROR_NO_WEB_BROWSER_FOUND -> "SPC_ERROR_NO_WEB_BROWSER_FOUND";
            case RequestListener.SPC_ERROR_TERMS_NOT_ACCEPTED -> "SPC_ERROR_TERMS_NOT_ACCEPTED";
            case RequestListener.SPC_ERROR_USER_LOGGED_IN -> "SPC_ERROR_USER_LOGGED_IN";
            default -> "";
        };
    }
}
