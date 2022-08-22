import './style.css'

export interface SelectorPropItem {
  description: string;
  action: Function;
}

export interface SelectorProps {
  options: SelectorPropItem[];
}

// TODO: action should receive a parameter identifying a supported action
// TODO: there should be a default message when no option
const Selector: React.FC<SelectorProps> = ({ options }) => {
  return (
    <div className={'selector'}>
      {options.length > 0 ? (
        options.map((option, index) => {
          return (
            <div
              className={'selectorOption'}
              onClick={() => {
                option.action();
              }}
              key={index}
            >
              {option.description}
            </div>
          );
        })
      ) : (
        <></>
      )}
    </div>
  );
};

export default Selector;
