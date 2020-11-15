package com.kmt.party.ui.never;

import com.kmt.party.data.DataManager;
import com.kmt.party.data.model.Question;
import com.kmt.party.ui.base.BasePresenter;
import com.kmt.party.utils.rx.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class NeverPresenter<V extends NeverMvpView> extends BasePresenter<V> implements NeverMvpPresenter<V> {

    @SuppressWarnings({"unused", "RedundantSuppression"})
    private static final String TAG = NeverPresenter.class.getSimpleName();
    private List<Question> questionList = new ArrayList<>();
    @Inject
    public NeverPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressWarnings({"unused", "RedundantSuppression"})
    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    public void setFunny(){
        // funny
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("quit drinking more than twice."));
        questions.add(new Question("peed in a pool."));
        questions.add(new Question("said I was going to go somewhere with no absolutely no intention of actually going."));
        questions.add(new Question("challenged an animal to a fight."));
        questions.add(new Question("been kicked out of a bar."));
        questions.add(new Question("used the bathroom in complete darkness."));
        questions.add(new Question("been chased by a dog."));
        questions.add(new Question("worn Crocs."));
        questions.add(new Question("gotten a tattoo I regret."));
        questions.add(new Question("called in sick but wasn’t."));
        questions.add(new Question("kissed an animal."));
        questions.add(new Question("farted in an elevator and pretended it was not me."));
        questions.add(new Question("eaten my own bugger."));
        questions.add(new Question("re-gifted."));
        questions.add(new Question("worn a Broken Watch for style."));
        questions.add(new Question("spent more than $50 on underwear."));
        questions.add(new Question("pulled a push door."));
        questions.add(new Question("used the bathroom in complete darkness."));
        questions.add(new Question("spilled pen ink in my pocket."));
        questions.add(new Question("given someone a black eye."));
        questions.add(new Question("done something I thought I would never do."));
        questions.add(new Question("been invited to a threesome."));
        questions.add(new Question("swam naked in someone else's pool."));
        questions.add(new Question("gotten drunk playing games like this."));
        questions.add(new Question("kicked a masseuse during a massage by mistake."));
        questions.add(new Question("woken up someone with my snoring."));
        questions.add(new Question("farted while squatting in the gym."));
        questions.add(new Question("pranked my parents."));
        questions.add(new Question("tried weed."));
        questions.add(new Question("driven a car naked."));
        questions.add(new Question("been trapped in an elevator."));
        questions.add(new Question("sang at karaoke."));
        questions.add(new Question("used the 5 second rule for food that fell."));
        questions.add(new Question("dropped my phone in the toilet."));
        questions.add(new Question("woken up with bruises and not know how they got there."));
        questions.add(new Question("kissed a stranger."));
        questions.add(new Question("not cleaned my teeth for over 48 hrs."));
        questions.add(new Question("dyed my hair the wrong color!"));
        questions.add(new Question("sang out loud in a friends shower."));
        questions.add(new Question("been locked in a room."));
        questions.add(new Question("dropped a phone on my face."));
        questions.add(new Question("been chased by a cat."));

        questionList = questions;
    }

    public void setDirty(){
        // Dirty
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("taken a sexy selfie."));
        questions.add(new Question("rainbow kissed."));
        questions.add(new Question("sent a dirty text to the wrong person."));
        questions.add(new Question("had a one night stand."));
        questions.add(new Question("done it in the sea."));
        questions.add(new Question("shaved my partner’s pubic hair."));
        questions.add(new Question("kissed a celebrity."));
        questions.add(new Question("put a thumb in it."));
        questions.add(new Question("abandoned my baby mama."));
        questions.add(new Question("tasted myself."));
        questions.add(new Question("watched a friend (do it)."));
        questions.add(new Question("cheated."));
        questions.add(new Question("done it while a family member was in the same room."));
        questions.add(new Question("touched myself to a Youtube video."));
        questions.add(new Question("had to use lubrication."));
        questions.add(new Question("had to fake it."));
        questions.add(new Question("tossed the salad."));
        questions.add(new Question("Squirted."));
        questions.add(new Question("flashed a bartender for a free drink."));
        questions.add(new Question("done it in a public place."));
        questions.add(new Question("been in handcuffs, for any reason."));
        questions.add(new Question("done it on my period."));
        questions.add(new Question("licked food off someone."));
        questions.add(new Question("done it on a kitchen counter."));
        questions.add(new Question("been with someone 10 inches or longer."));
        questions.add(new Question("showered with the same sex."));
        questions.add(new Question("slept with twins."));
        questions.add(new Question("caught my parents doing it."));
        questions.add(new Question("been choked."));
        questions.add(new Question("stalked an ex online."));
        questions.add(new Question("sucked my partners toes."));
        questions.add(new Question("screwed around in an elevator."));
        questions.add(new Question("slept with someone within an hour of meeting them."));
        questions.add(new Question("had an STD."));
        questions.add(new Question("given/received a lap dance."));
        questions.add(new Question("required medical attention due to a foreign object stuck inside my body."));
        questions.add(new Question("been upset with a partner for not performing well."));
        questions.add(new Question("used a friends pleasure toys."));
        questions.add(new Question("sent someone a picture of my stuff."));

        questionList = questions;
    }

    public void setParty(){
        // Party
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("been kicked out of a bar"));
        questions.add(new Question("thrown up and swallow it"));
        questions.add(new Question("Skinny Dipped"));
        questions.add(new Question("taken the morning after pill"));
        questions.add(new Question("driven through red lights"));
        questions.add(new Question("stalked my Ex"));
        questions.add(new Question("checked through my phone media to remember the night before"));
        questions.add(new Question("farted in an elevator and pretended it was not me"));
        questions.add(new Question("put a thumb in it"));
        questions.add(new Question("had a sugar daddy"));
        questions.add(new Question("went to work without bathing"));
        questions.add(new Question("created an Instagram just to stalk people"));
        questions.add(new Question("accepted a drop from total strangers"));
        questions.add(new Question("eaten raw fish"));
        questions.add(new Question("tasted myself"));
        questions.add(new Question("watched a friend (do it)"));
        questions.add(new Question("done it with a family member in the same building."));

        questionList = questions;
    }
    @Override
    public void onViewInitialized() {
        setFunny();
        getMvpView().refreshQuestionnaire(questionList);

    }

    @Override
    public void onCardExhausted() {
        getMvpView().reloadQuestionnaire(questionList);
    }

    @Override
    public void onFunnyClicked() {
        setFunny();
        onCardExhausted();
    }

    @Override
    public void onDirtyClicked() {
        setDirty();
        onCardExhausted();
    }

    @Override
    public void onPartyClicked() {
        setParty();
        onCardExhausted();
    }
}
