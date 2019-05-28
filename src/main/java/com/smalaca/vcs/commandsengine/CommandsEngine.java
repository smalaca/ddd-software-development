package com.smalaca.vcs.commandsengine;

import com.smalaca.vcs.application.commit.cherrypick.CherryPickCommand;

public interface CommandsEngine {
    void register(CherryPickCommand cherryPickCommand);
}
