package com.evernote.client.android.tasks;

/**
 * @author rwondratschek
 */
public abstract class TaskNoCallback extends Task<Void> {

    @Override
    protected final Void execute() {
        executeTask();
        return null;
    }

    protected abstract void executeTask();
}