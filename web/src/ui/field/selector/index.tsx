export type SelectorOption = {
  key: string;
  description: String;
};

export type SelectorFieldProps = {
  label?: string;
  name?: string;
  options: SelectorOption[];
  onSelect: (key: string) => void;
};

const SelectorField: React.FC<SelectorFieldProps> = (props) => {
  const fieldIdentification = props.name ? props.name : "selectorField";

  return (
    <div className="selectorField">
      {props.label ? <label htmlFor={fieldIdentification}></label> : null}

      <select name={fieldIdentification} id={fieldIdentification}>
        {!props.options
          ? null
          : props.options.map((option) => (
              <option value={option.key} onClick={() => props.onSelect(option.key)}>{option.description}</option>
            ))}
      </select>
    </div>
  );
};

export default SelectorField;
