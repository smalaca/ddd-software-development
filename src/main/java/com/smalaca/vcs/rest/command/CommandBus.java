package com.smalaca.vcs.rest.command;

import com.smalaca.vcs.application.commit.cherrypick.CherryPickCommand;

public interface CommandBus {
    void register(Class commandType, CommandHandler commandHandler);

    void handle(CherryPickCommand cherryPickCommand);
}
