import { Dispatch, SetStateAction } from "react";
import Account from "../../model/account";
import Transaction from "../../model/transaction";
import AccountService from "../../service/account";
import TransactionService from "../../service/transaction";
import { GridHeaderColumn } from "../../ui/grid/types";
import { SelectorPropItem } from "../../ui/selector";

export async function loadAccounts(
  setAccounts: Dispatch<SetStateAction<Account[] | null>>
) {
  const accounts = await AccountService.list();
  if (accounts) setAccounts(accounts);
  else setAccounts([]);
}

export async function loadTransactions(
  setTransactions: Dispatch<SetStateAction<Transaction[] | null>>,
  accountId: string
) {
  const transactions = await TransactionService.getByOriginAccount(accountId, {formatTime: true});
  if (transactions) setTransactions(transactions);
  else setTransactions([]);
}

export function buidAccountsSelectorOptions(
  accounts: Account[] | null,
  setTransactions: Dispatch<SetStateAction<Transaction[] | null>>
): SelectorPropItem[] {
  if (!accounts) return [];
  return accounts.map((account) => {
    return {
      description: account.name,
      action: () => loadTransactions(setTransactions, account.id)
    };
  });
}

export function getTransactionListHeaders(): GridHeaderColumn[] {
  return [
    {
      propertyName: "createdAtFormattedStr",
      description: "Time of execution",
    },
    {
      propertyName: "id",
      description: "Id",
    },
    {
      propertyName: "description",
      description: "Description",
    },
    {
      propertyName: "value",
      description: "Amount",
    },
  ];
}
