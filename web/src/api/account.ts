import { AxiosResponse } from "axios";
import Account from "../model/account";
import { api } from "./instance";

const RESOURCE = "/account";

async function getAccounts(): Promise<AxiosResponse<Account[]>> {
  return api.get(RESOURCE);
}

async function getAccount(id: string): Promise<AxiosResponse<Account>> {
  return await api.get(`${RESOURCE}/${id}`);
}

async function createAccount(
  name: string
): Promise<AxiosResponse<Account>> {
  return await api.post(RESOURCE, { name });
}

async function updateAccount(
  id: string,
  newName: string
): Promise<AxiosResponse<Account>> {
  return await api.put(RESOURCE, { id, name: newName });
}

async function deleteAccount(id: string) {
  await api.delete(`${RESOURCE}/${id}`);
}

export {
  getAccounts,
  getAccount,
  createAccount,
  updateAccount,
  deleteAccount
}