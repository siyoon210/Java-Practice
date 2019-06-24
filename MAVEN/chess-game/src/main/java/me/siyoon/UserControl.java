package me.siyoon;

public interface UserControl {
    enum Action {
        Move;
    }

    Action getAction();
}
