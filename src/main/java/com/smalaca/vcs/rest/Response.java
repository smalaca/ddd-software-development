package com.smalaca.vcs.rest;

class Response {
    private static final boolean FAILURE = false;
    private static final boolean SUCCESS = true;

    private final boolean isSuccessful;

    private Response(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    static Response failure() {
        return new Response(FAILURE);
    }

    static Response success() {
        return new Response(SUCCESS);
    }
}
