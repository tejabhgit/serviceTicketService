// package: rps.types.request.v1
// file: rps/types/request/v1/list.proto

import * as jspb from "google-protobuf";

export class List extends jspb.Message {
  getOrder(): string;
  setOrder(value: string): void;

  getItemLimit(): number;
  setItemLimit(value: number): void;

  getPageOffset(): number;
  setPageOffset(value: number): void;

  clearFieldMaskList(): void;
  getFieldMaskList(): Array<string>;
  setFieldMaskList(value: Array<string>): void;
  addFieldMask(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): List.AsObject;
  static toObject(includeInstance: boolean, msg: List): List.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: List, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): List;
  static deserializeBinaryFromReader(message: List, reader: jspb.BinaryReader): List;
}

export namespace List {
  export type AsObject = {
    order: string,
    itemLimit: number,
    pageOffset: number,
    fieldMaskList: Array<string>,
  }
}

