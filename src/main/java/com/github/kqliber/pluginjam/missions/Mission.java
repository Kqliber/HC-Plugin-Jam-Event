package com.github.kqliber.pluginjam.missions;

public interface Mission {

    int getProgress();

    int setProgress(int progress);

    int getCompletionAmount();

    int setCompletionAmount(int completion);

    void onComplete();
}
