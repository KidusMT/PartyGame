package com.kmt.party.ui.drinking.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.kmt.party.R;
import com.kmt.party.data.model.Player;
import com.kmt.party.data.model.Question;
import com.kmt.party.di.component.ActivityComponent;
import com.kmt.party.ui.base.BaseDialog;
import com.kmt.party.ui.team.TeamCommunicator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrinkingQuestionsDialog extends BaseDialog implements DrinkingQuestionsMvpView {


    public static final String TAG = DrinkingQuestionsDialog.class.getSimpleName();
    @Inject
    DrinkingQuestionsMvpPresenter<DrinkingQuestionsMvpView> mPresenter;

    @BindView(R.id.drinking_card_item)
    TextView tvQuestionItem;
    @BindView(R.id.drinking_player_name)
    TextView tvPlayerName;
    public static Question question;
    public static Player player;
    public static DrinkingQuestionsDialog newInstance(Question ques, Player pal) {
        question = ques;
        player = pal;
        DrinkingQuestionsDialog fragment = new DrinkingQuestionsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_drinking_question, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }


        setUp(view);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected void setUp(View view) {
        if (player!=null && !TextUtils.isEmpty(player.getName())){
            tvPlayerName.setText(player.getName());
        }

        if (question!=null && !TextUtils.isEmpty(question.getQuestionText())){
            tvQuestionItem.setText(question.getQuestionText());
        }
    }

    @OnClick(R.id.btn_dialog_drinking_ok)
    void onOkClicked() {
        dismissDialog();
    }

    @Override
    public void dismissDialog() {
        super.dismissDialog(TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}