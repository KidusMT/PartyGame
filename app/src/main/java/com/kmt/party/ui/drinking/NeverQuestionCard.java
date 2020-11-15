package com.kmt.party.ui.drinking;

import android.widget.TextView;

import com.kmt.party.R;
import com.kmt.party.data.model.Question;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.card_layout)
public class NeverQuestionCard {

    private static final String TAG = "QuestionCard";

    @View(R.id.tv_question_txt)
    private TextView mQuestionTextView;

    private Question mQuestion;

    public NeverQuestionCard(Question question) {
        mQuestion = question;
    }

    @Resolve
    private void onResolved() {

        mQuestionTextView.setText(mQuestion.getQuestionText());
    }

}
