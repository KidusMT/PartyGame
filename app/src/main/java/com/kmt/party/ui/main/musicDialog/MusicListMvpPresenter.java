package com.kmt.party.ui.main.musicDialog;
import com.kmt.party.ui.base.MvpPresenter;

public interface MusicListMvpPresenter<V extends MusicListMvpView> extends MvpPresenter<V> {

    void onCancelClick();

}
