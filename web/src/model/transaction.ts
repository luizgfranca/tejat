import { DateTime } from "luxon";
import TransactionDto from "../api/dto/transaction";
import Account from "./account";

export default class Transaction {
    id: string;
    description: string;
    value: number;
    createdAt: string;
    origin: Account;
    destination: Account;

    createdAtFormattedStr?: string;

    constructor(dto?: TransactionDto) {
        if(dto) {
            this.id = dto.id;
            this.description = dto.description;
            this.value = dto.value;
            this.createdAt = dto.createdAt;
            this.origin = dto.origin;
            this.destination = dto.destination;
        }
    }

    public formatDate(formatString: string) {
        this.createdAtFormattedStr = DateTime.fromISO(this.createdAt).toFormat(formatString);
    }
}