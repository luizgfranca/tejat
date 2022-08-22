import React, { Dispatch, SetStateAction } from "react";
import ActionsController from "../../../lib/actionsController";
import Account from "../../../model/account";
import Transaction from "../../../model/transaction";
import AccountService from "../../../service/account";
import TransactionService from "../../../service/transaction";
import { SelectorOption } from "../../../ui/field/selector";

export type TransactionCreationState = {
  origin: Account[] | null;
  destination: Account[] | null;
  selectedOrigin?: string;
  selectedDestination?: string;
  hasCreationError: boolean;
};

export default class CreateTransactionActions extends ActionsController<TransactionCreationState> {
  public tryLoadingAccounts() {
    if (this.state.origin && this.state.destination) return;

    AccountService.list().then((response) => {
      this.setStateAction({
        ...this.state,
        origin: response,
        destination: response,
      });
    });
  }


  public submitTransactionCreation(values: any) {
    const t = new Transaction();

    const origin = new Account();
    origin.id = values.origin.toString();
    t.origin = origin;

    const destination = new Account();
    destination.id = values.destination.toString();
    t.destination = destination;

    t.description = values.description;
    t.value = values.value;

    TransactionService.create(t)
      .then((result) => {
        if (!result) this.setCreationError();
      })
      .catch((e) => {
        this.setCreationError();
      });
  }

  private setCreationError() {
    this.setStateAction({
      ...this.state,
      hasCreationError: true,
    });
  }

  private getAccountSelectorOptions(
    accounts?: Account[] | null,
    alreadySelected?: string
  ): SelectorOption[] {
    if (!accounts) return [];

    return accounts
      .filter((account) => account.id !== alreadySelected)
      .map((account) => {
        return {
          key: account.id,
          description: account.name,
        };
      });
  }

  public getOriginSelectorOptions(): SelectorOption[] {
    return this.getAccountSelectorOptions(
      this.state.origin,
      this.state.selectedDestination
    );
  }

  public getDestinationSelectorOptions(): SelectorOption[] {
    return this.getAccountSelectorOptions(
      this.state.destination,
      this.state.selectedOrigin
    );
  }

  public selectOrigin(id: string) {
    this.setStateAction({
      ...this.state,
      selectedOrigin: id,
    });
  }

  public selectDestination(id: string) {
    this.setStateAction({
      ...this.state,
      selectedDestination: id,
    });
  }
}
