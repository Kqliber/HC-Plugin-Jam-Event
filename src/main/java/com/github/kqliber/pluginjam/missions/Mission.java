package com.github.kqliber.pluginjam.missions;

import com.github.kqliber.pluginjam.user.User;

public interface Mission {

    int getProgress();

    void setProgress(int progress);

    int getCompletionAmount();

    void onComplete(User user);
}
