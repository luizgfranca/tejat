import getLineArray from "./lib/getLineArray";
import { GridProps } from "./types";
import './style.css';

const Grid: React.FC<GridProps> = (props) => {
  if (props.headers.length === 0) {
    return null;
  }

  return (
    <div className={'grid'}>
      <div className={'gridHeader'}>
        {props.headers.map((column, index) => (
          <div className={'gridHeaderColumn'} key={index}>
            {column.description}
          </div>
        ))}
      </div>

      <div className={'gridBody'}>
        {props.items.map((item, index) => (
          <div className={'gridBodyLine'} key={index}>
            {getLineArray(item, props.headers).map((columnValue, index) => (
              <div className={'gridBodyColumn'} key={index}>
                {columnValue}
              </div>
            ))}
          </div>
        ))}
      </div>
    </div>
  );
};

export default Grid;
