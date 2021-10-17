// package: rps.types.meta.v1
// file: rps/types/meta/v1/meta.proto

import * as jspb from "google-protobuf";

import * as google_protobuf_timestamp_pb from "google-protobuf/google/protobuf/timestamp_pb";

export class Meta extends jspb.Message {
  hasCreatedTime(): boolean;
  clearCreatedTime(): void;
  getCreatedTime(): google_protobuf_timestamp_pb.Timestamp | undefined;
  setCreatedTime(value?: google_protobuf_timestamp_pb.Timestamp): void;

  hasUpdatedTime(): boolean;
  clearUpdatedTime(): void;
  getUpdatedTime(): google_protobuf_timestamp_pb.Timestamp | undefined;
  setUpdatedTime(value?: google_protobuf_timestamp_pb.Timestamp): void;

  hasDeletedTime(): boolean;
  clearDeletedTime(): void;
  getDeletedTime(): google_protobuf_timestamp_pb.Timestamp | undefined;
  setDeletedTime(value?: google_protobuf_timestamp_pb.Timestamp): void;

  getVersion(): number;
  setVersion(value: number): void;

  getRequestId(): string;
  setRequestId(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Meta.AsObject;
  static toObject(includeInstance: boolean, msg: Meta): Meta.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Meta, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Meta;
  static deserializeBinaryFromReader(message: Meta, reader: jspb.BinaryReader): Meta;
}

export namespace Meta {
  export type AsObject = {
    createdTime?: google_protobuf_timestamp_pb.Timestamp.AsObject,
    updatedTime?: google_protobuf_timestamp_pb.Timestamp.AsObject,
    deletedTime?: google_protobuf_timestamp_pb.Timestamp.AsObject,
    version: number,
    requestId: string,
  }
}

