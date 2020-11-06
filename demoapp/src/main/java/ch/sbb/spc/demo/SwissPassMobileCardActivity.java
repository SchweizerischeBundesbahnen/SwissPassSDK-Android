package ch.sbb.spc.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import ch.sbb.spc.SwissPassMobileListener;

public class SwissPassMobileCardActivity extends FragmentActivity implements SwissPassMobileListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swisspassmobile_card);
    }

    @Override
    public void onSwisspassCardviewClick() {
        startActivity(new Intent(this, SwissPassMobileActivity.class));
    }

    @Override
    public void onSwisspassInvalid() {

    }
}
