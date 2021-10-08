// package: rps.types.request.v1
// file: rps/types/request/v1/delete.proto

import * as jspb from "google-protobuf";

export class Delete extends jspb.Message {
  getSoft(): boolean;
  setSoft(value: boolean): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Delete.AsObject;
  static toObject(includeInstance: boolean, msg: Delete): Delete.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Delete, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Delete;
  static deserializeBinaryFromReader(message: Delete, reader: jspb.BinaryReader): Delete;
}

export namespace Delete {
  export type AsObject = {
    soft: boolean,
  }
}

