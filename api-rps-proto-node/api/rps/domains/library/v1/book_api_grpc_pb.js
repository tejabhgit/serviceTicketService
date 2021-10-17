// GENERATED CODE -- DO NOT EDIT!

'use strict';
var grpc = require('@grpc/grpc-js');
var rps_domains_library_v1_book_api_pb = require('../../../../rps/domains/library/v1/book_api_pb.js');

var rps_domains_library_v1_book_pb = require('../../../../rps/domains/library/v1/book_pb.js');
var rps_options_method_pb = require('../../../../rps/options/method_pb.js');
var rps_types_request_v1_create_pb = require('../../../../rps/types/request/v1/create_pb.js');
var rps_types_request_v1_delete_pb = require('../../../../rps/types/request/v1/delete_pb.js');
var rps_types_request_v1_get_pb = require('../../../../rps/types/request/v1/get_pb.js');
var rps_types_request_v1_list_pb = require('../../../../rps/types/request/v1/list_pb.js');
var rps_types_request_v1_update_pb = require('../../../../rps/types/request/v1/update_pb.js');

function serialize_rps_domains_library_v1_CreateOneBookRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.CreateOneBookRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.CreateOneBookRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_CreateOneBookRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.CreateOneBookRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_CreateOneBookResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.CreateOneBookResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.CreateOneBookResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_CreateOneBookResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.CreateOneBookResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_DeleteOneBookByIDRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.DeleteOneBookByIDRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_DeleteOneBookByIDRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_DeleteOneBookByIDResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.DeleteOneBookByIDResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_DeleteOneBookByIDResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByIDRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByIDRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByIDRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByIDResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByIDResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByIDResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByIDStreamRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByIDStreamRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByIDStreamRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByIDStreamResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByIDStreamResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByIDStreamResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByQueryRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByQueryRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByQueryRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByQueryResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByQueryResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByQueryResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByQueryStreamRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByQueryStreamRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByQueryStreamRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindManyBooksByQueryStreamResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindManyBooksByQueryStreamResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindManyBooksByQueryStreamResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindOneBookByIDRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindOneBookByIDRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindOneBookByIDRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindOneBookByIDResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindOneBookByIDResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindOneBookByIDResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindOneBookByQueryRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindOneBookByQueryRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindOneBookByQueryRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_FindOneBookByQueryResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.FindOneBookByQueryResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_FindOneBookByQueryResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_UpdateOneBookByIDRequest(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest)) {
    throw new Error('Expected argument of type rps.domains.library.v1.UpdateOneBookByIDRequest');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_UpdateOneBookByIDRequest(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest.deserializeBinary(new Uint8Array(buffer_arg));
}

function serialize_rps_domains_library_v1_UpdateOneBookByIDResponse(arg) {
  if (!(arg instanceof rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse)) {
    throw new Error('Expected argument of type rps.domains.library.v1.UpdateOneBookByIDResponse');
  }
  return Buffer.from(arg.serializeBinary());
}

function deserialize_rps_domains_library_v1_UpdateOneBookByIDResponse(buffer_arg) {
  return rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse.deserializeBinary(new Uint8Array(buffer_arg));
}


// ##############################################################################
// Service Definition
// ##############################################################################
//
// BookAPI manages books from the library
var BookAPIService = exports.BookAPIService = {
  // ############################################################################
// Create Methods
// ############################################################################
//
// CreateOneBook creates a single resource (unary-unary).
createOneBook: {
    path: '/rps.domains.library.v1.BookAPI/CreateOneBook',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.CreateOneBookRequest,
    responseType: rps_domains_library_v1_book_api_pb.CreateOneBookResponse,
    requestSerialize: serialize_rps_domains_library_v1_CreateOneBookRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_CreateOneBookRequest,
    responseSerialize: serialize_rps_domains_library_v1_CreateOneBookResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_CreateOneBookResponse,
  },
  // ############################################################################
// Find Methods
// ############################################################################
//
// FindOneBookByID retuns a single resource matching id (unary-unary).
// Recommended for fetching a single resource.
findOneBookByID: {
    path: '/rps.domains.library.v1.BookAPI/FindOneBookByID',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.FindOneBookByIDRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindOneBookByIDResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindOneBookByIDRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindOneBookByIDRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindOneBookByIDResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindOneBookByIDResponse,
  },
  // FindManyBooksByID retuns a list of resources matching ids (unary-unary).
// Recommended for fetching a small amount of resources (upper limit of 50 resources per call).
findManyBooksByID: {
    path: '/rps.domains.library.v1.BookAPI/FindManyBooksByID',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.FindManyBooksByIDRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindManyBooksByIDResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindManyBooksByIDRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByIDRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindManyBooksByIDResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByIDResponse,
  },
  // FindManyBooksByIDStream retuns a streaming list of resources matching ids  (unary-stream).
// Recommended for fetching multiple resources (no upper limit).
findManyBooksByIDStream: {
    path: '/rps.domains.library.v1.BookAPI/FindManyBooksByIDStream',
    requestStream: false,
    responseStream: true,
    requestType: rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindManyBooksByIDStreamResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindManyBooksByIDStreamRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByIDStreamRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindManyBooksByIDStreamResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByIDStreamResponse,
  },
  // FindOneBookByQuery retuns a single resource matching query (unary-unary).
// Recommended for fetching a single resource.
findOneBookByQuery: {
    path: '/rps.domains.library.v1.BookAPI/FindOneBookByQuery',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.FindOneBookByQueryRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindOneBookByQueryResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindOneBookByQueryRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindOneBookByQueryRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindOneBookByQueryResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindOneBookByQueryResponse,
  },
  // FindManyBooksByQuery retuns a list of resources matching query (unary-unary).
// Recommended for fetching a small amount of resources (upper limit of 50 resources per call).
findManyBooksByQuery: {
    path: '/rps.domains.library.v1.BookAPI/FindManyBooksByQuery',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindManyBooksByQueryRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByQueryRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindManyBooksByQueryResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByQueryResponse,
  },
  // FindManyBooksByQueryStream retuns a streaming list of resources matching query (unary-stream).
// Recommended for fetching multiple resources (no upper limit).
findManyBooksByQueryStream: {
    path: '/rps.domains.library.v1.BookAPI/FindManyBooksByQueryStream',
    requestStream: false,
    responseStream: true,
    requestType: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamRequest,
    responseType: rps_domains_library_v1_book_api_pb.FindManyBooksByQueryStreamResponse,
    requestSerialize: serialize_rps_domains_library_v1_FindManyBooksByQueryStreamRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByQueryStreamRequest,
    responseSerialize: serialize_rps_domains_library_v1_FindManyBooksByQueryStreamResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_FindManyBooksByQueryStreamResponse,
  },
  // ############################################################################
// Update Methods
// ############################################################################
//
// UpdateOneBookByID updates a single resource (unary-unary).
updateOneBookByID: {
    path: '/rps.domains.library.v1.BookAPI/UpdateOneBookByID',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.UpdateOneBookByIDRequest,
    responseType: rps_domains_library_v1_book_api_pb.UpdateOneBookByIDResponse,
    requestSerialize: serialize_rps_domains_library_v1_UpdateOneBookByIDRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_UpdateOneBookByIDRequest,
    responseSerialize: serialize_rps_domains_library_v1_UpdateOneBookByIDResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_UpdateOneBookByIDResponse,
  },
  // ############################################################################
// Delete Methods
// ############################################################################
//
// DeleteOneBookByID deletes a single resource (unary-unary).
deleteOneBookByID: {
    path: '/rps.domains.library.v1.BookAPI/DeleteOneBookByID',
    requestStream: false,
    responseStream: false,
    requestType: rps_domains_library_v1_book_api_pb.DeleteOneBookByIDRequest,
    responseType: rps_domains_library_v1_book_api_pb.DeleteOneBookByIDResponse,
    requestSerialize: serialize_rps_domains_library_v1_DeleteOneBookByIDRequest,
    requestDeserialize: deserialize_rps_domains_library_v1_DeleteOneBookByIDRequest,
    responseSerialize: serialize_rps_domains_library_v1_DeleteOneBookByIDResponse,
    responseDeserialize: deserialize_rps_domains_library_v1_DeleteOneBookByIDResponse,
  },
};

exports.BookAPIClient = grpc.makeGenericClientConstructor(BookAPIService);
