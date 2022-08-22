import { Field } from "formik";
import { useState } from "react";
import { onNumberFieldChange } from "./action";

export interface NumberFieldProps {
  name: string;
  label?: string;
}

const NumberField: React.FC<NumberFieldProps> = (props: NumberFieldProps) => {
  const [fieldContent, setFIeldCOntent] = useState("");

  return (
    <div className="numberField">
      {props.label ? <label htmlFor={props.name}>{props.label}</label> : null}
      <input
        type="text"
        name={props.name}
        onInput={(e) => { onNumberFieldChange(e); }}
      />
    </div>
  );
};

export default NumberField;
