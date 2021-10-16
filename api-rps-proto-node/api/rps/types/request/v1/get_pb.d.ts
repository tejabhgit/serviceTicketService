// package: rps.types.request.v1
// file: rps/types/request/v1/get.proto

import * as jspb from "google-protobuf";

export class Get extends jspb.Message {
  clearFieldMaskList(): void;
  getFieldMaskList(): Array<string>;
  setFieldMaskList(value: Array<string>): void;
  addFieldMask(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Get.AsObject;
  static toObject(includeInstance: boolean, msg: Get): Get.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Get, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Get;
  static deserializeBinaryFromReader(message: Get, reader: jspb.BinaryReader): Get;
}

export namespace Get {
  export type AsObject = {
    fieldMaskList: Array<string>,
  }
}

