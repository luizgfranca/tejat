import { get } from 'lodash';
import { GridHeaderColumn } from '../types';

export default function getLineArray(
  item: object,
  columns: GridHeaderColumn[]
): string[] {
  return columns.map((column): string => {
    const content = get(item, column.propertyName, "");

    if (typeof content === "string") return content;
    else if (typeof content === "number") return content.toString();
    else return "";
  });
}
