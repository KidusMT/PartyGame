package com.kmt.party.ui.team.dialog;

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
import com.kmt.party.di.component.ActivityComponent;
import com.kmt.party.ui.base.BaseDialog;
import com.kmt.party.ui.team.TeamCommunicator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddPlayerDialog extends BaseDialog implements AddPlayerMvpView {


    public static final String TAG = AddPlayerDialog.class.getSimpleName();
    @Inject
    AddPlayerMvpPresenter<AddPlayerMvpView> mPresenter;

    @BindView(R.id.et_player_name)
    TextView etPlayerName;
    TeamCommunicator communicator;
    public static AddPlayerDialog newInstance() {
        AddPlayerDialog fragment = new AddPlayerDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_repeat, container, false);

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
        communicator = (TeamCommunicator) context;
    }

    @Override
    protected void setUp(View view) {

//        if (crew != null) {
//            etRepeatDate.setText(DateUtils.formatDateTime(getBaseActivity(), DateTime.now(), DateUtils.FORMAT_SHOW_DATE));
//        }
    }

    @OnClick(R.id.btn_dialog_repeat_add)
    void onAddClicked() {
        String name = etPlayerName.getText().toString().trim();
        if (TextUtils.isEmpty(name)){
            showMessage("Please enter non-empty name.");
            return;
        }
        Player player = new Player();
        player.setName(name);
        communicator.onAddClick(player);
        dismissDialog();
    }

    @OnClick(R.id.btn_dialog_repeat_cancel)
    void onOkClicked() {
        mPresenter.onCancelClick();
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