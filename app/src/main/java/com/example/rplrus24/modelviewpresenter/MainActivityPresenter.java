package com.example.rplrus24.modelviewpresenter;

import android.view.View;

public class MainActivityPresenter {
    private user user;
    private View view;

    public MainActivityPresenter (View view){
        this.user = new user();
        this.view = view;
    }

    public void name(String name){
        user.setName(name);
        view.updateUserInfoTextView(user.toString());
    }

    public void email(String email){
        user.setEmail(email);
        view.updateUserInfoTextView(user.toString());
    }

    public interface View{
        void updateUserInfoTextView(String info);
        void showProgressbar();
        void hideProgressbar();
    }

}
