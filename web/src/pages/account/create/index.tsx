import React, { useState } from "react";
import { ErrorMessage, Field, Form, Formik } from "formik";
import { submitAccountCreation, ValidationSchema } from "./action";
import ErrorBox from "../../../ui/creationErrorBox";
import './style.css';

const CreateAccountPage: React.FC = () => {
    const [hasCreationError, setHasCreationError] = useState(false);

    return (
        <div className="create-account-page">
            <h1>Create a new account</h1>

            <ErrorBox 
                show={hasCreationError}
                message={'There was an error in the creation of the new account'}
            />

            <Formik
                initialValues={{name: ''}}
                onSubmit={submitAccountCreation(setHasCreationError)}
                validationSchema={ValidationSchema}
            >
                {({errors, touched}) => (
                    <Form>
                        <label htmlFor="name">Name:</label>
                        <Field name="name"/>
                        <ErrorMessage name="name" />
                        
                        <div className="form-footer">
                            <button type="submit">Create</button>
                        </div>
                        
                    </Form>
                )}
            </Formik>
        </div>
    )
}

export default CreateAccountPage;