package com.kmt.party.ui.main;

import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.MvpView;

import java.util.List;

public interface MainMvpView extends MvpView {
    void refreshQuestionnaire(List<Question> questionList);

    void reloadQuestionnaire(List<Question> questionList);
}
