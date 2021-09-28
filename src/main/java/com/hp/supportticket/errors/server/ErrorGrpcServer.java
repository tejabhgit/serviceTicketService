/*package com.hp.supportticket.errors.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerInterceptors;

import java.io.IOException;
import java.util.Arrays;

public class ErrorGrpcServer {
  static public void main(String[] args) throws IOException, InterruptedException {
    UnknownStatusDescriptionInterceptor unknownStatusDescriptionInterceptor = new UnknownStatusDescriptionInterceptor(Arrays.asList(
        IllegalArgumentException.class
    ));
    Server server = ServerBuilder.forPort(9090)
        .addService(ServerInterceptors.intercept(new ErrorServiceImpl(), unknownStatusDescriptionInterceptor))
        .build();

    System.out.println("Starting server...");
    server.start();
    System.out.println("Server started!");
    server.awaitTermination();
  }
}
*/