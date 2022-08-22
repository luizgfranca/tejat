import React, { SetStateAction } from "react";

export function onNumberFieldChange(event: React.FormEvent<HTMLInputElement>) {
  //@ts-ignore
  const value: string = event.nativeEvent.data;

  if (isNaN(Number(value))) {
    //@ts-ignore
    event.target.value = event.target.value.substring(
      0,
      //@ts-ignore
      event.target.value.length - 1
    );
  }
}
