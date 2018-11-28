package com.example.rplrus24.modelviewpresenter;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.xml.transform.Templates;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View{
    private MainActivityPresenter presenter;
    private TextView textView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);
        textView = findViewById(R.id.textview_email);
        EditText editText_email = findViewById(R.id.edittext_email);
        EditText editText_name = findViewById(R.id.edittext_name);
        initProgress();
        editText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.email(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideProgressbar();
            }
        });
        editText_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.name(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideProgressbar();
            }
        });
    }

    private void initProgress() {
        progressBar = new ProgressBar(this,null,android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar,params);
        showProgressbar();
    }

    @Override
    public void updateUserInfoTextView(String info) {
        textView.setText(info);
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
