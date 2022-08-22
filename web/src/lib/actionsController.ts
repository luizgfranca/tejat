import React, { SetStateAction } from "react";

export default class ActionsController<T> {
    protected state: T;
    protected setStateAction: React.Dispatch<SetStateAction<T>>;

    public setHooks(state: T, setStateAction: React.Dispatch<SetStateAction<T>>) {
        this.state = state;
        this.setStateAction = setStateAction;
    }
}