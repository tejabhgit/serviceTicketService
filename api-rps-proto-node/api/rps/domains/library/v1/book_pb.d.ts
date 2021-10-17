// package: rps.domains.library.v1
// file: rps/domains/library/v1/book.proto

import * as jspb from "google-protobuf";

import * as rps_types_meta_v1_meta_pb from "../../../../rps/types/meta/v1/meta_pb";

export class Book extends jspb.Message {
  getId(): string;
  setId(value: string): void;

  getIsbn(): string;
  setIsbn(value: string): void;

  getTitle(): string;
  setTitle(value: string): void;

  getAuthor(): string;
  setAuthor(value: string): void;

  hasMeta(): boolean;
  clearMeta(): void;
  getMeta(): rps_types_meta_v1_meta_pb.Meta | undefined;
  setMeta(value?: rps_types_meta_v1_meta_pb.Meta): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Book.AsObject;
  static toObject(includeInstance: boolean, msg: Book): Book.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Book, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Book;
  static deserializeBinaryFromReader(message: Book, reader: jspb.BinaryReader): Book;
}

export namespace Book {
  export type AsObject = {
    id: string,
    isbn: string,
    title: string,
    author: string,
    meta?: rps_types_meta_v1_meta_pb.Meta.AsObject,
  }
}

