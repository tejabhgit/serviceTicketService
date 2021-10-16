// GENERATED CODE -- DO NOT EDIT!

// package: rps.domains.library.v1
// file: rps/domains/library/v1/book_api.proto

import * as rps_domains_library_v1_book_api_pb from "../../../../rps/domains/library/v1/book_api_pb";
import * as grpc from "@grpc/grpc-js";

interface IBookAPIService extends grpc.ServiceDefinition<grpc.UntypedServiceImplementation> {
  createOneBook: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.CreateOneBookRequest, rps_domains_library_v1_book_api_pb.CreateOneBookResponse>;
  findOneBookByID: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest, rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse>;
  findManyBooksByID: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse>;
  findManyBooksByIDStream: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse>;
  findOneBookByQuery: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest, rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse>;
  findManyBooksByQuery: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse>;
  findManyBooksByQueryStream: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse>;
  updateOneBookByID: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest, rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse>;
  deleteOneBookByID: grpc.MethodDefinition<rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest, rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse>;
}

export const BookAPIService: IBookAPIService;

export interface IBookAPIServer extends grpc.UntypedServiceImplementation {
  createOneBook: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.CreateOneBookRequest, rps_domains_library_v1_book_api_pb.CreateOneBookResponse>;
  findOneBookByID: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest, rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse>;
  findManyBooksByID: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse>;
  findManyBooksByIDStream: grpc.handleServerStreamingCall<rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse>;
  findOneBookByQuery: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest, rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse>;
  findManyBooksByQuery: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse>;
  findManyBooksByQueryStream: grpc.handleServerStreamingCall<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest, rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse>;
  updateOneBookByID: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest, rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse>;
  deleteOneBookByID: grpc.handleUnaryCall<rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest, rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse>;
}

export class BookAPIClient extends grpc.Client {
  constructor(address: string, credentials: grpc.ChannelCredentials, options?: object);
  createOneBook(argument: rps_domains_library_v1_book_api_pb.CreateOneBookRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.CreateOneBookResponse>): grpc.ClientUnaryCall;
  createOneBook(argument: rps_domains_library_v1_book_api_pb.CreateOneBookRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.CreateOneBookResponse>): grpc.ClientUnaryCall;
  createOneBook(argument: rps_domains_library_v1_book_api_pb.CreateOneBookRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.CreateOneBookResponse>): grpc.ClientUnaryCall;
  findOneBookByID(argument: rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse>): grpc.ClientUnaryCall;
  findOneBookByID(argument: rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse>): grpc.ClientUnaryCall;
  findOneBookByID(argument: rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse>): grpc.ClientUnaryCall;
  findManyBooksByID(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse>): grpc.ClientUnaryCall;
  findManyBooksByID(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse>): grpc.ClientUnaryCall;
  findManyBooksByID(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse>): grpc.ClientUnaryCall;
  findManyBooksByIDStream(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest, metadataOrOptions?: grpc.Metadata | grpc.CallOptions | null): grpc.ClientReadableStream<rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse>;
  findManyBooksByIDStream(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest, metadata?: grpc.Metadata | null, options?: grpc.CallOptions | null): grpc.ClientReadableStream<rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse>;
  findOneBookByQuery(argument: rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse>): grpc.ClientUnaryCall;
  findOneBookByQuery(argument: rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse>): grpc.ClientUnaryCall;
  findOneBookByQuery(argument: rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse>): grpc.ClientUnaryCall;
  findManyBooksByQuery(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse>): grpc.ClientUnaryCall;
  findManyBooksByQuery(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse>): grpc.ClientUnaryCall;
  findManyBooksByQuery(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse>): grpc.ClientUnaryCall;
  findManyBooksByQueryStream(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest, metadataOrOptions?: grpc.Metadata | grpc.CallOptions | null): grpc.ClientReadableStream<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse>;
  findManyBooksByQueryStream(argument: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest, metadata?: grpc.Metadata | null, options?: grpc.CallOptions | null): grpc.ClientReadableStream<rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse>;
  updateOneBookByID(argument: rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse>): grpc.ClientUnaryCall;
  updateOneBookByID(argument: rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse>): grpc.ClientUnaryCall;
  updateOneBookByID(argument: rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse>): grpc.ClientUnaryCall;
  deleteOneBookByID(argument: rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse>): grpc.ClientUnaryCall;
  deleteOneBookByID(argument: rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest, metadataOrOptions: grpc.Metadata | grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse>): grpc.ClientUnaryCall;
  deleteOneBookByID(argument: rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest, metadata: grpc.Metadata | null, options: grpc.CallOptions | null, callback: grpc.requestCallback<rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse>): grpc.ClientUnaryCall;
}
