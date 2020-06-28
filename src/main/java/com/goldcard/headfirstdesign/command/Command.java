package com.goldcard.headfirstdesign.command;

public interface Command {
    void execute();
    void undo();
}