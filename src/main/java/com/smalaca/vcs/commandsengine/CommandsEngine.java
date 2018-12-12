package com.smalaca.vcs.commandsengine;

import com.smalaca.vcs.application.commands.CherryPickCommand;

public interface CommandsEngine {
    void register(CherryPickCommand cherryPickCommand);
}
