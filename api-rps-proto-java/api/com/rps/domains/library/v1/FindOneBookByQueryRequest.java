// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rps/domains/library/v1/book_api.proto

package com.rps.domains.library.v1;

/**
 * Protobuf type {@code rps.domains.library.v1.FindOneBookByQueryRequest}
 */
public final class FindOneBookByQueryRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:rps.domains.library.v1.FindOneBookByQueryRequest)
    FindOneBookByQueryRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FindOneBookByQueryRequest.newBuilder() to construct.
  private FindOneBookByQueryRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FindOneBookByQueryRequest() {
    query_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FindOneBookByQueryRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FindOneBookByQueryRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.rps.types.request.v1.Get.Builder subBuilder = null;
            if (getParams_ != null) {
              subBuilder = getParams_.toBuilder();
            }
            getParams_ = input.readMessage(com.rps.types.request.v1.Get.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(getParams_);
              getParams_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            query_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.rps.domains.library.v1.BookApiProto.internal_static_rps_domains_library_v1_FindOneBookByQueryRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.rps.domains.library.v1.BookApiProto.internal_static_rps_domains_library_v1_FindOneBookByQueryRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.rps.domains.library.v1.FindOneBookByQueryRequest.class, com.rps.domains.library.v1.FindOneBookByQueryRequest.Builder.class);
  }

  public static final int GET_PARAMS_FIELD_NUMBER = 1;
  private com.rps.types.request.v1.Get getParams_;
  /**
   * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
   * @return Whether the getParams field is set.
   */
  @java.lang.Override
  public boolean hasGetParams() {
    return getParams_ != null;
  }
  /**
   * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
   * @return The getParams.
   */
  @java.lang.Override
  public com.rps.types.request.v1.Get getGetParams() {
    return getParams_ == null ? com.rps.types.request.v1.Get.getDefaultInstance() : getParams_;
  }
  /**
   * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
   */
  @java.lang.Override
  public com.rps.types.request.v1.GetOrBuilder getGetParamsOrBuilder() {
    return getGetParams();
  }

  public static final int QUERY_FIELD_NUMBER = 2;
  private volatile java.lang.Object query_;
  /**
   * <code>string query = 2 [json_name = "query"];</code>
   * @return The query.
   */
  @java.lang.Override
  public java.lang.String getQuery() {
    java.lang.Object ref = query_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      query_ = s;
      return s;
    }
  }
  /**
   * <code>string query = 2 [json_name = "query"];</code>
   * @return The bytes for query.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getQueryBytes() {
    java.lang.Object ref = query_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      query_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (getParams_ != null) {
      output.writeMessage(1, getGetParams());
    }
    if (!getQueryBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, query_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (getParams_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getGetParams());
    }
    if (!getQueryBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, query_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.rps.domains.library.v1.FindOneBookByQueryRequest)) {
      return super.equals(obj);
    }
    com.rps.domains.library.v1.FindOneBookByQueryRequest other = (com.rps.domains.library.v1.FindOneBookByQueryRequest) obj;

    if (hasGetParams() != other.hasGetParams()) return false;
    if (hasGetParams()) {
      if (!getGetParams()
          .equals(other.getGetParams())) return false;
    }
    if (!getQuery()
        .equals(other.getQuery())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasGetParams()) {
      hash = (37 * hash) + GET_PARAMS_FIELD_NUMBER;
      hash = (53 * hash) + getGetParams().hashCode();
    }
    hash = (37 * hash) + QUERY_FIELD_NUMBER;
    hash = (53 * hash) + getQuery().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.rps.domains.library.v1.FindOneBookByQueryRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.rps.domains.library.v1.FindOneBookByQueryRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code rps.domains.library.v1.FindOneBookByQueryRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:rps.domains.library.v1.FindOneBookByQueryRequest)
      com.rps.domains.library.v1.FindOneBookByQueryRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.rps.domains.library.v1.BookApiProto.internal_static_rps_domains_library_v1_FindOneBookByQueryRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.rps.domains.library.v1.BookApiProto.internal_static_rps_domains_library_v1_FindOneBookByQueryRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.rps.domains.library.v1.FindOneBookByQueryRequest.class, com.rps.domains.library.v1.FindOneBookByQueryRequest.Builder.class);
    }

    // Construct using com.rps.domains.library.v1.FindOneBookByQueryRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (getParamsBuilder_ == null) {
        getParams_ = null;
      } else {
        getParams_ = null;
        getParamsBuilder_ = null;
      }
      query_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.rps.domains.library.v1.BookApiProto.internal_static_rps_domains_library_v1_FindOneBookByQueryRequest_descriptor;
    }

    @java.lang.Override
    public com.rps.domains.library.v1.FindOneBookByQueryRequest getDefaultInstanceForType() {
      return com.rps.domains.library.v1.FindOneBookByQueryRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.rps.domains.library.v1.FindOneBookByQueryRequest build() {
      com.rps.domains.library.v1.FindOneBookByQueryRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.rps.domains.library.v1.FindOneBookByQueryRequest buildPartial() {
      com.rps.domains.library.v1.FindOneBookByQueryRequest result = new com.rps.domains.library.v1.FindOneBookByQueryRequest(this);
      if (getParamsBuilder_ == null) {
        result.getParams_ = getParams_;
      } else {
        result.getParams_ = getParamsBuilder_.build();
      }
      result.query_ = query_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.rps.domains.library.v1.FindOneBookByQueryRequest) {
        return mergeFrom((com.rps.domains.library.v1.FindOneBookByQueryRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.rps.domains.library.v1.FindOneBookByQueryRequest other) {
      if (other == com.rps.domains.library.v1.FindOneBookByQueryRequest.getDefaultInstance()) return this;
      if (other.hasGetParams()) {
        mergeGetParams(other.getGetParams());
      }
      if (!other.getQuery().isEmpty()) {
        query_ = other.query_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.rps.domains.library.v1.FindOneBookByQueryRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.rps.domains.library.v1.FindOneBookByQueryRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.rps.types.request.v1.Get getParams_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rps.types.request.v1.Get, com.rps.types.request.v1.Get.Builder, com.rps.types.request.v1.GetOrBuilder> getParamsBuilder_;
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     * @return Whether the getParams field is set.
     */
    public boolean hasGetParams() {
      return getParamsBuilder_ != null || getParams_ != null;
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     * @return The getParams.
     */
    public com.rps.types.request.v1.Get getGetParams() {
      if (getParamsBuilder_ == null) {
        return getParams_ == null ? com.rps.types.request.v1.Get.getDefaultInstance() : getParams_;
      } else {
        return getParamsBuilder_.getMessage();
      }
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public Builder setGetParams(com.rps.types.request.v1.Get value) {
      if (getParamsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        getParams_ = value;
        onChanged();
      } else {
        getParamsBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public Builder setGetParams(
        com.rps.types.request.v1.Get.Builder builderForValue) {
      if (getParamsBuilder_ == null) {
        getParams_ = builderForValue.build();
        onChanged();
      } else {
        getParamsBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public Builder mergeGetParams(com.rps.types.request.v1.Get value) {
      if (getParamsBuilder_ == null) {
        if (getParams_ != null) {
          getParams_ =
            com.rps.types.request.v1.Get.newBuilder(getParams_).mergeFrom(value).buildPartial();
        } else {
          getParams_ = value;
        }
        onChanged();
      } else {
        getParamsBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public Builder clearGetParams() {
      if (getParamsBuilder_ == null) {
        getParams_ = null;
        onChanged();
      } else {
        getParams_ = null;
        getParamsBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public com.rps.types.request.v1.Get.Builder getGetParamsBuilder() {
      
      onChanged();
      return getGetParamsFieldBuilder().getBuilder();
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    public com.rps.types.request.v1.GetOrBuilder getGetParamsOrBuilder() {
      if (getParamsBuilder_ != null) {
        return getParamsBuilder_.getMessageOrBuilder();
      } else {
        return getParams_ == null ?
            com.rps.types.request.v1.Get.getDefaultInstance() : getParams_;
      }
    }
    /**
     * <code>.rps.types.request.v1.Get get_params = 1 [json_name = "getParams"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.rps.types.request.v1.Get, com.rps.types.request.v1.Get.Builder, com.rps.types.request.v1.GetOrBuilder> 
        getGetParamsFieldBuilder() {
      if (getParamsBuilder_ == null) {
        getParamsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.rps.types.request.v1.Get, com.rps.types.request.v1.Get.Builder, com.rps.types.request.v1.GetOrBuilder>(
                getGetParams(),
                getParentForChildren(),
                isClean());
        getParams_ = null;
      }
      return getParamsBuilder_;
    }

    private java.lang.Object query_ = "";
    /**
     * <code>string query = 2 [json_name = "query"];</code>
     * @return The query.
     */
    public java.lang.String getQuery() {
      java.lang.Object ref = query_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        query_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string query = 2 [json_name = "query"];</code>
     * @return The bytes for query.
     */
    public com.google.protobuf.ByteString
        getQueryBytes() {
      java.lang.Object ref = query_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        query_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string query = 2 [json_name = "query"];</code>
     * @param value The query to set.
     * @return This builder for chaining.
     */
    public Builder setQuery(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      query_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string query = 2 [json_name = "query"];</code>
     * @return This builder for chaining.
     */
    public Builder clearQuery() {
      
      query_ = getDefaultInstance().getQuery();
      onChanged();
      return this;
    }
    /**
     * <code>string query = 2 [json_name = "query"];</code>
     * @param value The bytes for query to set.
     * @return This builder for chaining.
     */
    public Builder setQueryBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      query_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rps.domains.library.v1.FindOneBookByQueryRequest)
  }

  // @@protoc_insertion_point(class_scope:rps.domains.library.v1.FindOneBookByQueryRequest)
  private static final com.rps.domains.library.v1.FindOneBookByQueryRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.rps.domains.library.v1.FindOneBookByQueryRequest();
  }

  public static com.rps.domains.library.v1.FindOneBookByQueryRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FindOneBookByQueryRequest>
      PARSER = new com.google.protobuf.AbstractParser<FindOneBookByQueryRequest>() {
    @java.lang.Override
    public FindOneBookByQueryRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FindOneBookByQueryRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FindOneBookByQueryRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FindOneBookByQueryRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.rps.domains.library.v1.FindOneBookByQueryRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
