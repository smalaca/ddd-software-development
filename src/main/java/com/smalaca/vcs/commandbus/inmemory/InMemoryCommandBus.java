package com.smalaca.vcs.commandbus.inmemory;

import com.smalaca.vcs.application.commit.cherrypick.CherryPickCommand;
import com.smalaca.vcs.rest.command.CommandBus;
import com.smalaca.vcs.rest.command.CommandHandler;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCommandBus implements CommandBus {
    private final Map<Class, CommandHandler> commandHandlers = new HashMap<>();

    @Override
    public void register(Class commandType, CommandHandler commandHandler) {
        commandHandlers.put(commandType, commandHandler);
    }

    @Override
    public void handle(CherryPickCommand cherryPickCommand) {
        commandHandlers
                .get(cherryPickCommand.getClass())
                .handle(cherryPickCommand);
    }
}
