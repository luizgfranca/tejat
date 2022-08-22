import { getTransactionsByOriginAccount, createTransaction } from "../api/transaction";
import Transaction from "../model/transaction";
import env from '../env.json';
import TransactionDto from "../api/dto/transaction";

export interface ListTransactionsOptions {
    formatTime: boolean;
}

export default class TransactionService {
    static async getByOriginAccount(originAccountId: string, options?: ListTransactionsOptions): Promise<Transaction[] | null> {
        try {
            const { data } = await getTransactionsByOriginAccount(originAccountId);
            
            if(!options || !data?.length)
                return data.map(t => new Transaction(t));

            return data.map((t): Transaction => {
                const transaction = new Transaction(t);
                transaction.formatDate(env.timeFormat);
                return transaction;
            });
        } catch (e) {
            console.error(e);
            return null;
        }
    }

    static async create(transaction: Transaction): Promise<Transaction | null> {
        try {
            const response = await createTransaction({
                origin: transaction.origin.id,
                destination: transaction.destination.id,
                description: transaction.description,
                value: transaction.value
            });

            return new Transaction(response.data);
        } catch (e) {
            console.error(e);
            return null;
        }
    }
}