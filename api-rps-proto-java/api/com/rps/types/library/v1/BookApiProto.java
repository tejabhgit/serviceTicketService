// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rps/types/meta/v1/meta.proto

package com.rps.types.library.v1;

public final class BookApiProto {
  private BookApiProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rps_types_meta_v1_Meta_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rps_types_meta_v1_Meta_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034rps/types/meta/v1/meta.proto\022\021rps.type" +
      "s.meta.v1\032\024gogoproto/gogo.proto\032\037google/" +
      "protobuf/timestamp.proto\"\235\002\n\004Meta\022C\n\014cre" +
      "ated_time\030\001 \001(\0132\032.google.protobuf.Timest" +
      "ampB\004\220\337\037\001R\013createdTime\022C\n\014updated_time\030\002" +
      " \001(\0132\032.google.protobuf.TimestampB\004\220\337\037\001R\013" +
      "updatedTime\022C\n\014deleted_time\030\003 \001(\0132\032.goog" +
      "le.protobuf.TimestampB\004\220\337\037\001R\013deletedTime" +
      "\022\030\n\007version\030\004 \001(\003R\007version\022,\n\nrequest_id" +
      "\030\005 \001(\tB\r\342\336\037\tRequestIDR\trequestIdB\244\001\n\030com" +
      ".rps.types.library.v1B\014BookApiProtoP\001ZJg" +
      "ithub.azc.ext.hp.com/hp-rps/api-rps-prot" +
      "o-go/api/rps/types/meta/v1;metav1\242\002\003RDL\252" +
      "\002\021Rps.Types.Meta.V1\312\002\021Rps\\Types\\Meta\\V1b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.GoGoProtos.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_rps_types_meta_v1_Meta_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_rps_types_meta_v1_Meta_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rps_types_meta_v1_Meta_descriptor,
        new java.lang.String[] { "CreatedTime", "UpdatedTime", "DeletedTime", "Version", "RequestId", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf.GoGoProtos.customname);
    registry.add(com.google.protobuf.GoGoProtos.stdtime);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf.GoGoProtos.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}