package com.smalaca.vcs.rest;

import com.smalaca.vcs.application.commands.CherryPickCommand;
import com.smalaca.vcs.application.commands.CherryPickCommandFactory;
import com.smalaca.vcs.application.services.CommitService;
import com.smalaca.vcs.commandsengine.CommandsEngine;

public class CommitController {
    private final CommandsEngine commandsEngine;
    private final CommitService commitService;
    private final CherryPickCommandFactory cherryPickCommandFactory;

    public CommitController(CommandsEngine commandsEngine, CommitService commitService, CherryPickCommandFactory cherryPickCommandFactory) {
        this.commandsEngine = commandsEngine;
        this.commitService = commitService;
        this.cherryPickCommandFactory = cherryPickCommandFactory;
    }

    public Response cherryPickViaApplicatioService(String hashCode, String targetId) {
        if (areValid(hashCode, targetId)) {
            commitService.cherryPick(hashCode, targetId);

            return Response.success();
        }

        return Response.failure();
    }

    public Response cherryPickViaCommand(String hashCode, String targetId) {
        if (areValid(hashCode, targetId)) {
            CherryPickCommand cherryPickCommand = cherryPickCommandFactory.createFor(hashCode, targetId);
            commandsEngine.register(cherryPickCommand);

            return Response.success();
        }

        return Response.failure();
    }

    private boolean areValid(String hashCode, String targetId) {
        return false;
    }
}
