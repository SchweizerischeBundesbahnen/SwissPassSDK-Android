package ch.sbb.spc.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import ch.sbb.spc.AccountStatusResponse;
import ch.sbb.spc.Page;
import ch.sbb.spc.ReauthenticationMethod;
import ch.sbb.spc.RequestListener;
import ch.sbb.spc.Response;
import ch.sbb.spc.Scope;
import ch.sbb.spc.SwissPassLoginClient;
import ch.sbb.spc.SwissPassMobileClient;
import ch.sbb.spc.TokenResponse;
import ch.sbb.spc.UserInfoResponse;

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
public class MainActivity extends Activity {

    TextView accessTokenTextView;
    TextView userInfoTextView;
    TextView responseCodeTextView;
    TextView developerMessageTextView;
    TextView userMessageTextView;
    TextView isLoggedInTextView;
    TextView swisspassStatus;
    RadioButton fingerprintSelector;

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
    }

    public void onLogin(View view) {
        SwissPassLoginClient.getInstance().requestLogin(new Scope(), new RequestListener<TokenResponse>() {
            @Override
            public void onResult(final TokenResponse result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        MainActivity.this.accessTokenTextView.setText(result.getAccessToken());
                    }
                });
            }
        });
    }

    public void onRegister(View view) {
        SwissPassLoginClient.getInstance().requestRegistration(new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onRefreshToken(View view) {
        SwissPassLoginClient.getInstance().requestToken(true, new RequestListener<TokenResponse>() {
            @Override
            public void onResult(final TokenResponse result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        MainActivity.this.accessTokenTextView.setText(result.getAccessToken());
                    }
                });

            }
        });
    }

    public void onToken(View view) {
        SwissPassLoginClient.getInstance().requestToken(false, new RequestListener<TokenResponse>() {
            @Override
            public void onResult(final TokenResponse result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        MainActivity.this.accessTokenTextView.setText(result.getAccessToken());
                    }
                });
            }
        });
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
        SwissPassLoginClient.getInstance().requestLogout(new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        MainActivity.this.accessTokenTextView.setText("");
                        MainActivity.this.userInfoTextView.setText("");
                    }
                });
            }
        });
    }

    public void onUserInfo(View view) {
        SwissPassLoginClient.getInstance().requestUserInfo(new RequestListener<UserInfoResponse>() {
            @Override
            public void onResult(final UserInfoResponse result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        if (result.getUserInfo() != null) {
                            MainActivity.this.userInfoTextView.setText(result.getUserInfo().getFirstName() + " " + result.getUserInfo().getLastName());
                        } else {
                            MainActivity.this.userInfoTextView.setText("");
                        }
                    }
                });
            }
        });
    }

    public void onTokenManagement(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.TOKEN_MANAGEMENT, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onAccountManagement(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.ACCOUNT_MANAGEMENT, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onLoginDataManagement(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.LOGIN_DATA_MANAGEMENT, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onLinkCard(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.LINK_CARD_MANAGEMENT, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onInfoAbo(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.INFO_ABOS, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onInfoSwissPass(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.INFO_SWISSPASS, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onContact(View view) {
        SwissPassLoginClient.getInstance().openSwissPass(Page.CONTACT_FORM, new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onReauthenticate(View view) {
        ReauthenticationMethod reauthenticationMethod = ReauthenticationMethod.DEVICE_SCREENLOCK;
        if (fingerprintSelector.isChecked()) {
            reauthenticationMethod = ReauthenticationMethod.FINGERPRINT_ONLY;
        }

        SwissPassLoginClient.getInstance().requestAuthentication(reauthenticationMethod, "Fingerprint custom infotext", new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void onSwissPassMobileStatus(View view) {
        swisspassStatus.setText("");
        SwissPassMobileClient.getInstance().requestSwissPassMobileAccountStatus(new RequestListener<AccountStatusResponse>() {
            @Override
            public void onResult(final AccountStatusResponse result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        if(SPC_ERROR_NO_ERROR == result.getErrorCode()) {
                            swisspassStatus.setText(result.getSwissPassMobileAccountStatus().toString());
                        } else {
                            swisspassStatus.setText("Account Status unavailable, see error");
                        }
                    }
                });
            }
        });
    }

    public void onSwissPassMobileActivate(View view) {
        SwissPassMobileClient.getInstance().requestSwissPassMobileActivation(new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                        if (result.getErrorCode() == RequestListener.SPC_ERROR_NO_ERROR) {
                            startActivity(new Intent(MainActivity.this, SwissPassMobileActivity.class));
                        }
                    }
                });
            }
        });
    }

    public void onSwissPassMobileShow(View view) {
        startActivity(new Intent(MainActivity.this, SwissPassMobileActivity.class));
    }

    public void onSwissPassMobileShowCard(View view) {
        startActivity(new Intent(MainActivity.this, SwissPassMobileCardActivity.class));
    }

    public void onSwissPassMobileDeactivate(View view) {
        SwissPassMobileClient.getInstance().requestSwissPassMobileDeactivation(new RequestListener<Response>() {
            @Override
            public void onResult(final Response result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showError(result);
                    }
                });
            }
        });
    }

    public void showError(final Response response) {
        responseCodeTextView.setText("");
        developerMessageTextView.setText("");
        userMessageTextView.setText("");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainActivity.this.responseCodeTextView.setText(responseCodeToString(response));
                MainActivity.this.developerMessageTextView.setText(response.getDeveloperErrorMessage());
                if (response.getUserErrorMessage() != null && response.getUserErrorMessage().length() > 0) {
                    MainActivity.this.userMessageTextView.setText(response.getUserErrorMessage());
                }
            }
        });
    }

    private String responseCodeToString(Response response) {
        switch (response.getErrorCode()) {
            case RequestListener.SPC_ERROR_ACCESS_DENIED:
                return "SPC_ERROR_ACCESS_DENIED";
            case RequestListener.SPC_ERROR_CANCELLED:
                return "SPC_ERROR_CANCELLED";
            case RequestListener.SPC_ERROR_OAUTH_INVALID_TOKEN:
                return "SPC_ERROR_INVALID_TOKEN";
            case RequestListener.SPC_ERROR_IO:
                return "SPC_ERROR_IO";
            case RequestListener.SPC_ERROR_NO_ERROR:
                return "SPC_ERROR_NO_ERROR";
            case RequestListener.SPC_ERROR_NO_WEB_BROWSER_FOUND:
                return "SPC_ERROR_NO_WEB_BROWSER_FOUND";
            case RequestListener.SPC_ERROR_TERMS_NOT_ACCEPTED:
                return "SPC_ERROR_TERMS_NOT_ACCEPTED";
            case RequestListener.SPC_ERROR_USER_LOGGED_IN:
                return "SPC_ERROR_USER_LOGGED_IN";
        }
        return "";
    }
}
