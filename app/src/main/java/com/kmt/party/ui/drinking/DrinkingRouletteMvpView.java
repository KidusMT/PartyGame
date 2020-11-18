package com.kmt.party.ui.drinking;

import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.MvpView;

import java.util.ArrayList;
import java.util.Queue;

public interface DrinkingRouletteMvpView extends MvpView {
    void populateCard(ArrayList<Question> questions);
}
