// package: rps.options
// file: rps/options/method.proto

import * as jspb from "google-protobuf";
import * as google_protobuf_descriptor_pb from "google-protobuf/google/protobuf/descriptor_pb";

export class MethodRule extends jspb.Message {
  clearScopesList(): void;
  getScopesList(): Array<string>;
  setScopesList(value: Array<string>): void;
  addScopes(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): MethodRule.AsObject;
  static toObject(includeInstance: boolean, msg: MethodRule): MethodRule.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: MethodRule, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): MethodRule;
  static deserializeBinaryFromReader(message: MethodRule, reader: jspb.BinaryReader): MethodRule;
}

export namespace MethodRule {
  export type AsObject = {
    scopesList: Array<string>,
  }
}

  export const method: jspb.ExtensionFieldInfo<MethodRule>;

