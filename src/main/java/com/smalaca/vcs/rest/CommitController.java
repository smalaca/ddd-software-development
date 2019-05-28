package com.smalaca.vcs.rest;

import com.smalaca.vcs.application.commands.CherryPickCommand;
import com.smalaca.vcs.application.services.CommitService;
import com.smalaca.vcs.commandsengine.CommandsEngine;

public class CommitController {
    private final CommandsEngine commandsEngine;
    private final CommitService commitService;

    public CommitController(CommandsEngine commandsEngine, CommitService commitService) {
        this.commandsEngine = commandsEngine;
        this.commitService = commitService;
    }

    public Response cherryPickViaApplicationService(String hashCode, String targetId) {
        if (areValid(hashCode, targetId)) {
            commitService.cherryPick(hashCode, targetId);

            return Response.success();
        }

        return Response.failure();
    }

    public Response cherryPickViaCommand(String hashCode, String targetId) {
        if (areValid(hashCode, targetId)) {
            CherryPickCommand cherryPickCommand = new CherryPickCommand(hashCode, targetId);
            commandsEngine.register(cherryPickCommand);

            return Response.success();
        }

        return Response.failure();
    }

    private boolean areValid(String hashCode, String targetId) {
        return false;
    }
}
