package com.wansmd.king.mutao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wansmd.king.mutao.LoginActivity;
import com.wansmd.king.mutao.MyApplication;
import com.wansmd.king.mutao.R;
import com.wansmd.king.mutao.myview.CircleImageView;

/**
 * Created by King on 2018/3/15.
 */

public class MeFragment extends Fragment{
    protected Button button;
//    protected LoginButton loginButton;
    private TextView userName_fragment_me;
    private CircleImageView circleImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
        initListener();


    }

    private void initView() {
        userName_fragment_me = getView().findViewById(R.id.userName_fragment_me);
        circleImageView = getView().findViewById(R.id.head_fragment_me);
        button = getView().findViewById(R.id.login_but);
    }

    private void initListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        MyApplication application = (MyApplication) getActivity().getApplication();
        if (!application.getUserName().equals("")) {
            userName_fragment_me.setText(application.getUserName());
            button.setVisibility(View.INVISIBLE);
            circleImageView.setVisibility(View.VISIBLE);
        }else {
            circleImageView.setVisibility(View.INVISIBLE);
            button.setVisibility(View.VISIBLE);
        }
    }
}
