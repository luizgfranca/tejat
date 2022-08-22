import { Dispatch, SetStateAction } from 'react';
import * as Yup from 'yup'
import AccountService from '../../../service/account'

export const ValidationSchema = Yup.object().shape({
    name: Yup.string().required('Required')
})

export function submitAccountCreation(setHasCreationError: Dispatch<SetStateAction<boolean>>) {
    return (values: any) => {
        const { name } = values;
        const account = AccountService.create(name)

        if(!account)
            setHasCreationError(true);
    }
}