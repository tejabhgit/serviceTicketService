// package: rps.types.request.v1
// file: rps/types/request/v1/update.proto

import * as jspb from "google-protobuf";


export class Update extends jspb.Message {
  clearUpdateMaskList(): void;
  getUpdateMaskList(): Array<string>;
  setUpdateMaskList(value: Array<string>): void;
  addUpdateMask(value: string, index?: number): string;

  getValidateOnly(): boolean;
  setValidateOnly(value: boolean): void;

  getRequestId(): string;
  setRequestId(value: string): void;

  getSkipResult(): boolean;
  setSkipResult(value: boolean): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Update.AsObject;
  static toObject(includeInstance: boolean, msg: Update): Update.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Update, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Update;
  static deserializeBinaryFromReader(message: Update, reader: jspb.BinaryReader): Update;
}

export namespace Update {
  export type AsObject = {
    updateMaskList: Array<string>,
    validateOnly: boolean,
    requestId: string,
    skipResult: boolean,
  }
}

