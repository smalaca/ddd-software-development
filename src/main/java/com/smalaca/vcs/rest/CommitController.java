package com.smalaca.vcs.rest;

import com.smalaca.vcs.application.commit.CommitService;
import com.smalaca.vcs.application.commit.cherrypick.CherryPickCommand;
import com.smalaca.vcs.rest.command.CommandBus;

public class CommitController {
    private final CommandBus commandBus;
    private final CommitService commitService;

    public CommitController(CommandBus commandBus, CommitService commitService) {
        this.commandBus = commandBus;
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
            commandBus.handle(cherryPickCommand);

            return Response.success();
        }

        return Response.failure();
    }

    private boolean areValid(String hashCode, String targetId) {
        return false;
    }
}
