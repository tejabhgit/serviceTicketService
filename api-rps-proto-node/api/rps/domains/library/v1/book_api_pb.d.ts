// package: rps.domains.library.v1
// file: rps/domains/library/v1/book_api.proto

import * as jspb from "google-protobuf";

import * as rps_domains_library_v1_book_pb from "../../../../rps/domains/library/v1/book_pb";
import * as rps_options_method_pb from "../../../../rps/options/method_pb";
import * as rps_types_request_v1_create_pb from "../../../../rps/types/request/v1/create_pb";
import * as rps_types_request_v1_delete_pb from "../../../../rps/types/request/v1/delete_pb";
import * as rps_types_request_v1_get_pb from "../../../../rps/types/request/v1/get_pb";
import * as rps_types_request_v1_list_pb from "../../../../rps/types/request/v1/list_pb";
import * as rps_types_request_v1_update_pb from "../../../../rps/types/request/v1/update_pb";

export class CreateOneBookRequest extends jspb.Message {
  hasCreateParams(): boolean;
  clearCreateParams(): void;
  getCreateParams(): rps_types_request_v1_create_pb.Create | undefined;
  setCreateParams(value?: rps_types_request_v1_create_pb.Create): void;

  hasNewBook(): boolean;
  clearNewBook(): void;
  getNewBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setNewBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CreateOneBookRequest.AsObject;
  static toObject(includeInstance: boolean, msg: CreateOneBookRequest): CreateOneBookRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: CreateOneBookRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CreateOneBookRequest;
  static deserializeBinaryFromReader(message: CreateOneBookRequest, reader: jspb.BinaryReader): CreateOneBookRequest;
}

export namespace CreateOneBookRequest {
  export type AsObject = {
    createParams?: rps_types_request_v1_create_pb.Create.AsObject,
    newBook?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class CreateOneBookResponse extends jspb.Message {
  hasCreatedBook(): boolean;
  clearCreatedBook(): void;
  getCreatedBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setCreatedBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CreateOneBookResponse.AsObject;
  static toObject(includeInstance: boolean, msg: CreateOneBookResponse): CreateOneBookResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: CreateOneBookResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CreateOneBookResponse;
  static deserializeBinaryFromReader(message: CreateOneBookResponse, reader: jspb.BinaryReader): CreateOneBookResponse;
}

export namespace CreateOneBookResponse {
  export type AsObject = {
    createdBook?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class FindOneBookByIDRequest extends jspb.Message {
  hasGetParams(): boolean;
  clearGetParams(): void;
  getGetParams(): rps_types_request_v1_get_pb.Get | undefined;
  setGetParams(value?: rps_types_request_v1_get_pb.Get): void;

  getId(): string;
  setId(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindOneBookByIDRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindOneBookByIDRequest): FindOneBookByIDRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindOneBookByIDRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindOneBookByIDRequest;
  static deserializeBinaryFromReader(message: FindOneBookByIDRequest, reader: jspb.BinaryReader): FindOneBookByIDRequest;
}

export namespace FindOneBookByIDRequest {
  export type AsObject = {
    getParams?: rps_types_request_v1_get_pb.Get.AsObject,
    id: string,
  }
}

export class FindOneBookByIDResponse extends jspb.Message {
  hasBook(): boolean;
  clearBook(): void;
  getBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindOneBookByIDResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindOneBookByIDResponse): FindOneBookByIDResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindOneBookByIDResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindOneBookByIDResponse;
  static deserializeBinaryFromReader(message: FindOneBookByIDResponse, reader: jspb.BinaryReader): FindOneBookByIDResponse;
}

export namespace FindOneBookByIDResponse {
  export type AsObject = {
    book?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class FindManyBooksByIDRequest extends jspb.Message {
  hasListParams(): boolean;
  clearListParams(): void;
  getListParams(): rps_types_request_v1_list_pb.List | undefined;
  setListParams(value?: rps_types_request_v1_list_pb.List): void;

  clearIdsList(): void;
  getIdsList(): Array<string>;
  setIdsList(value: Array<string>): void;
  addIds(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByIDRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByIDRequest): FindManyBooksByIDRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByIDRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByIDRequest;
  static deserializeBinaryFromReader(message: FindManyBooksByIDRequest, reader: jspb.BinaryReader): FindManyBooksByIDRequest;
}

export namespace FindManyBooksByIDRequest {
  export type AsObject = {
    listParams?: rps_types_request_v1_list_pb.List.AsObject,
    idsList: Array<string>,
  }
}

export class FindManyBooksByIDResponse extends jspb.Message {
  clearBooksList(): void;
  getBooksList(): Array<rps_domains_library_v1_book_pb.Book>;
  setBooksList(value: Array<rps_domains_library_v1_book_pb.Book>): void;
  addBooks(value?: rps_domains_library_v1_book_pb.Book, index?: number): rps_domains_library_v1_book_pb.Book;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByIDResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByIDResponse): FindManyBooksByIDResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByIDResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByIDResponse;
  static deserializeBinaryFromReader(message: FindManyBooksByIDResponse, reader: jspb.BinaryReader): FindManyBooksByIDResponse;
}

export namespace FindManyBooksByIDResponse {
  export type AsObject = {
    booksList: Array<rps_domains_library_v1_book_pb.Book.AsObject>,
  }
}

export class FindManyBooksByIDStreamRequest extends jspb.Message {
  hasListParams(): boolean;
  clearListParams(): void;
  getListParams(): rps_types_request_v1_list_pb.List | undefined;
  setListParams(value?: rps_types_request_v1_list_pb.List): void;

  clearIdsList(): void;
  getIdsList(): Array<string>;
  setIdsList(value: Array<string>): void;
  addIds(value: string, index?: number): string;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByIDStreamRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByIDStreamRequest): FindManyBooksByIDStreamRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByIDStreamRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByIDStreamRequest;
  static deserializeBinaryFromReader(message: FindManyBooksByIDStreamRequest, reader: jspb.BinaryReader): FindManyBooksByIDStreamRequest;
}

export namespace FindManyBooksByIDStreamRequest {
  export type AsObject = {
    listParams?: rps_types_request_v1_list_pb.List.AsObject,
    idsList: Array<string>,
  }
}

export class FindManyBooksByIDStreamResponse extends jspb.Message {
  hasBook(): boolean;
  clearBook(): void;
  getBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByIDStreamResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByIDStreamResponse): FindManyBooksByIDStreamResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByIDStreamResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByIDStreamResponse;
  static deserializeBinaryFromReader(message: FindManyBooksByIDStreamResponse, reader: jspb.BinaryReader): FindManyBooksByIDStreamResponse;
}

export namespace FindManyBooksByIDStreamResponse {
  export type AsObject = {
    book?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class FindOneBookByQueryRequest extends jspb.Message {
  hasGetParams(): boolean;
  clearGetParams(): void;
  getGetParams(): rps_types_request_v1_get_pb.Get | undefined;
  setGetParams(value?: rps_types_request_v1_get_pb.Get): void;

  getQuery(): string;
  setQuery(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindOneBookByQueryRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindOneBookByQueryRequest): FindOneBookByQueryRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindOneBookByQueryRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindOneBookByQueryRequest;
  static deserializeBinaryFromReader(message: FindOneBookByQueryRequest, reader: jspb.BinaryReader): FindOneBookByQueryRequest;
}

export namespace FindOneBookByQueryRequest {
  export type AsObject = {
    getParams?: rps_types_request_v1_get_pb.Get.AsObject,
    query: string,
  }
}

export class FindOneBookByQueryResponse extends jspb.Message {
  hasBook(): boolean;
  clearBook(): void;
  getBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindOneBookByQueryResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindOneBookByQueryResponse): FindOneBookByQueryResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindOneBookByQueryResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindOneBookByQueryResponse;
  static deserializeBinaryFromReader(message: FindOneBookByQueryResponse, reader: jspb.BinaryReader): FindOneBookByQueryResponse;
}

export namespace FindOneBookByQueryResponse {
  export type AsObject = {
    book?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class FindManyBooksByQueryRequest extends jspb.Message {
  hasListParams(): boolean;
  clearListParams(): void;
  getListParams(): rps_types_request_v1_list_pb.List | undefined;
  setListParams(value?: rps_types_request_v1_list_pb.List): void;

  getQuery(): string;
  setQuery(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByQueryRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByQueryRequest): FindManyBooksByQueryRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByQueryRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByQueryRequest;
  static deserializeBinaryFromReader(message: FindManyBooksByQueryRequest, reader: jspb.BinaryReader): FindManyBooksByQueryRequest;
}

export namespace FindManyBooksByQueryRequest {
  export type AsObject = {
    listParams?: rps_types_request_v1_list_pb.List.AsObject,
    query: string,
  }
}

export class FindManyBooksByQueryResponse extends jspb.Message {
  clearBooksList(): void;
  getBooksList(): Array<rps_domains_library_v1_book_pb.Book>;
  setBooksList(value: Array<rps_domains_library_v1_book_pb.Book>): void;
  addBooks(value?: rps_domains_library_v1_book_pb.Book, index?: number): rps_domains_library_v1_book_pb.Book;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByQueryResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByQueryResponse): FindManyBooksByQueryResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByQueryResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByQueryResponse;
  static deserializeBinaryFromReader(message: FindManyBooksByQueryResponse, reader: jspb.BinaryReader): FindManyBooksByQueryResponse;
}

export namespace FindManyBooksByQueryResponse {
  export type AsObject = {
    booksList: Array<rps_domains_library_v1_book_pb.Book.AsObject>,
  }
}

export class FindManyBooksByQueryStreamRequest extends jspb.Message {
  hasListParams(): boolean;
  clearListParams(): void;
  getListParams(): rps_types_request_v1_list_pb.List | undefined;
  setListParams(value?: rps_types_request_v1_list_pb.List): void;

  getQuery(): string;
  setQuery(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByQueryStreamRequest.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByQueryStreamRequest): FindManyBooksByQueryStreamRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByQueryStreamRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByQueryStreamRequest;
  static deserializeBinaryFromReader(message: FindManyBooksByQueryStreamRequest, reader: jspb.BinaryReader): FindManyBooksByQueryStreamRequest;
}

export namespace FindManyBooksByQueryStreamRequest {
  export type AsObject = {
    listParams?: rps_types_request_v1_list_pb.List.AsObject,
    query: string,
  }
}

export class FindManyBooksByQueryStreamResponse extends jspb.Message {
  hasBook(): boolean;
  clearBook(): void;
  getBook(): rps_domains_library_v1_book_pb.Book | undefined;
  setBook(value?: rps_domains_library_v1_book_pb.Book): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): FindManyBooksByQueryStreamResponse.AsObject;
  static toObject(includeInstance: boolean, msg: FindManyBooksByQueryStreamResponse): FindManyBooksByQueryStreamResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: FindManyBooksByQueryStreamResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): FindManyBooksByQueryStreamResponse;
  static deserializeBinaryFromReader(message: FindManyBooksByQueryStreamResponse, reader: jspb.BinaryReader): FindManyBooksByQueryStreamResponse;
}

export namespace FindManyBooksByQueryStreamResponse {
  export type AsObject = {
    book?: rps_domains_library_v1_book_pb.Book.AsObject,
  }
}

export class UpdateOneBookByIDRequest extends jspb.Message {
  hasUpdateParams(): boolean;
  clearUpdateParams(): void;
  getUpdateParams(): rps_types_request_v1_update_pb.Update | undefined;
  setUpdateParams(value?: rps_types_request_v1_update_pb.Update): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): UpdateOneBookByIDRequest.AsObject;
  static toObject(includeInstance: boolean, msg: UpdateOneBookByIDRequest): UpdateOneBookByIDRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: UpdateOneBookByIDRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): UpdateOneBookByIDRequest;
  static deserializeBinaryFromReader(message: UpdateOneBookByIDRequest, reader: jspb.BinaryReader): UpdateOneBookByIDRequest;
}

export namespace UpdateOneBookByIDRequest {
  export type AsObject = {
    updateParams?: rps_types_request_v1_update_pb.Update.AsObject,
  }
}

export class UpdateOneBookByIDResponse extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): UpdateOneBookByIDResponse.AsObject;
  static toObject(includeInstance: boolean, msg: UpdateOneBookByIDResponse): UpdateOneBookByIDResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: UpdateOneBookByIDResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): UpdateOneBookByIDResponse;
  static deserializeBinaryFromReader(message: UpdateOneBookByIDResponse, reader: jspb.BinaryReader): UpdateOneBookByIDResponse;
}

export namespace UpdateOneBookByIDResponse {
  export type AsObject = {
  }
}

export class DeleteOneBookByIDRequest extends jspb.Message {
  hasDeleteParams(): boolean;
  clearDeleteParams(): void;
  getDeleteParams(): rps_types_request_v1_delete_pb.Delete | undefined;
  setDeleteParams(value?: rps_types_request_v1_delete_pb.Delete): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DeleteOneBookByIDRequest.AsObject;
  static toObject(includeInstance: boolean, msg: DeleteOneBookByIDRequest): DeleteOneBookByIDRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: DeleteOneBookByIDRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DeleteOneBookByIDRequest;
  static deserializeBinaryFromReader(message: DeleteOneBookByIDRequest, reader: jspb.BinaryReader): DeleteOneBookByIDRequest;
}

export namespace DeleteOneBookByIDRequest {
  export type AsObject = {
    deleteParams?: rps_types_request_v1_delete_pb.Delete.AsObject,
  }
}

export class DeleteOneBookByIDResponse extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DeleteOneBookByIDResponse.AsObject;
  static toObject(includeInstance: boolean, msg: DeleteOneBookByIDResponse): DeleteOneBookByIDResponse.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: DeleteOneBookByIDResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DeleteOneBookByIDResponse;
  static deserializeBinaryFromReader(message: DeleteOneBookByIDResponse, reader: jspb.BinaryReader): DeleteOneBookByIDResponse;
}

export namespace DeleteOneBookByIDResponse {
  export type AsObject = {
  }
}

