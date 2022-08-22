import { AxiosResponse } from "axios";
import TransactionDto from "./dto/transaction";
import { api } from "./instance";

const RESOURCE = "/transaction";

interface CreateTransactionPayload {
  description: string;
  value: number;
  origin: string;
  destination: string;
}

export async function getTransactions(): Promise<AxiosResponse<TransactionDto[]>> {
  return api.get(RESOURCE);
}

export async function getTransaction(
  id: string
): Promise<AxiosResponse<TransactionDto>> {
  return await api.get(`${RESOURCE}/${id}`);
}

export async function createTransaction(
  payload: CreateTransactionPayload
): Promise<AxiosResponse<TransactionDto>> {
  return await api.post(RESOURCE, { ...payload });
}

export async function getTransactionsByOriginAccount(
  originAccountId: string
): Promise<AxiosResponse<TransactionDto[]>> {
  return await api.get(`${RESOURCE}/origin/${originAccountId}`);
}

export async function getTransactionsByDestinationAccount(
  destinationAccountId: string
): Promise<AxiosResponse<TransactionDto[]>> {
  return await api.get(`${RESOURCE}/destination/${destinationAccountId}`);
}
