package com.smalaca.vcs.rest.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
