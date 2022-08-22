import { ErrorMessage, Field, Form, Formik } from "formik";
import { useState } from "react";
import Account from "../../../model/account";
import ErrorBox from "../../../ui/creationErrorBox";
import NumberField from "../../../ui/field/number";
import SelectorField from "../../../ui/field/selector";
import CreateTransactionActions, { TransactionCreationState } from "./action";
import './style.css'

const actions = new CreateTransactionActions();

const CreateTransactionPage: React.FC = () => {
    const [state, setStateAction] = useState<TransactionCreationState>({
        origin: null,
        destination: null,
        hasCreationError: false
    });

    actions.setHooks(state, setStateAction);
    actions.tryLoadingAccounts();

    return (
        <div className="create-transaction-page">
            <h1>New Transaction</h1>

            <ErrorBox 
                show={state.hasCreationError}
                message={'There was an error in the creation of the transaction.'}
            />

            <Formik
                onSubmit={actions.submitTransactionCreation.bind(actions)}
                initialValues={{
                    origin: '',
                    destination: '',
                    description: '',
                    value: '0'
                }}

            >
                {({setFieldValue}) => (
                    <Form>
                        <div className="row">
                            <div className="fieldBox">
                                <SelectorField 
                                    name="origin"
                                    label="Origin"
                                    options={actions.getOriginSelectorOptions()}
                                    onSelect={(key) => {
                                        setFieldValue('origin', key)
                                        actions.selectOrigin(key)
                                    }}
                                />
                                <ErrorMessage name="origin" />                                
                            </div>
                            
                            <div className="fieldBox">
                                <SelectorField 
                                    name="destination"
                                    label="Destination"
                                    options={actions.getDestinationSelectorOptions()}
                                    onSelect={(key) => {
                                        setFieldValue('destination', key)
                                        actions.selectDestination(key)
                                    }}
                                />
                                <ErrorMessage name="destination" />    
                            </div>
                            
                        </div>
                        
                        <div className="row">
                            <div className="fieldBox">
                                <label htmlFor="description">Description:</label>
                                <Field name="description" size="70"/>
                                <ErrorMessage name="description" />    
                            </div>
                            
                            <div className="fieldBox">
                                <NumberField 
                                    name="value"
                                    label="value"
                                />
                                <ErrorMessage name="value" />
                            </div>        
                        </div>
                        

                        <div className="form-footer">
                            <button type="submit">Create</button>
                        </div>
                    </Form>
                )}
            </Formik>
        </div>
    )
}

export default CreateTransactionPage;