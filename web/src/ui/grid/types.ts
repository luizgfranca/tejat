export interface GridHeaderColumn {
  propertyName: string;
  description: string;
}

export interface GridProps {
  headers: GridHeaderColumn[];
  items: object[];
}
