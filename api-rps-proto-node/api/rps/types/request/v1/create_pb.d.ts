// package: rps.types.request.v1
// file: rps/types/request/v1/create.proto

import * as jspb from "google-protobuf";


export class Create extends jspb.Message {
  getValidateOnly(): boolean;
  setValidateOnly(value: boolean): void;

  getRequestId(): string;
  setRequestId(value: string): void;

  getSkipResult(): boolean;
  setSkipResult(value: boolean): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Create.AsObject;
  static toObject(includeInstance: boolean, msg: Create): Create.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Create, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Create;
  static deserializeBinaryFromReader(message: Create, reader: jspb.BinaryReader): Create;
}

export namespace Create {
  export type AsObject = {
    validateOnly: boolean,
    requestId: string,
    skipResult: boolean,
  }
}

