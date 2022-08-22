import { DateTime } from "luxon";
import AccountDto from "./account";

export default interface TransactionDto {
    id: string;
    description: string;
    value: number;
    createdAt: string;
    origin: AccountDto;
    destination: AccountDto;
}