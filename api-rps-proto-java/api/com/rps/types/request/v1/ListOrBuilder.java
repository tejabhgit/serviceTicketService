// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rps/types/request/v1/list.proto

package com.rps.types.request.v1;

public interface ListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rps.types.request.v1.List)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A document that defines the sort order of the result set.
   * Items are by default retuned in the stored order,
   * but it is not guaranteed to be that they are in the inserted order.
   * They are not sorted by the _id field. Sometimes it can be look like it is
   * sorted by the insertion order but it can change in another request. It is not reliable.
   * </pre>
   *
   * <code>string order = 1 [json_name = "order"];</code>
   * @return The order.
   */
  java.lang.String getOrder();
  /**
   * <pre>
   * A document that defines the sort order of the result set.
   * Items are by default retuned in the stored order,
   * but it is not guaranteed to be that they are in the inserted order.
   * They are not sorted by the _id field. Sometimes it can be look like it is
   * sorted by the insertion order but it can change in another request. It is not reliable.
   * </pre>
   *
   * <code>string order = 1 [json_name = "order"];</code>
   * @return The bytes for order.
   */
  com.google.protobuf.ByteString
      getOrderBytes();

  /**
   * <pre>
   * Maximum number of items to return.
   * Defaults to 50, Maximum allowed is 50
   * </pre>
   *
   * <code>int64 item_limit = 2 [json_name = "itemLimit"];</code>
   * @return The itemLimit.
   */
  long getItemLimit();

  /**
   * <pre>
   * Page offset.
   * Defaults to 0
   * </pre>
   *
   * <code>int64 page_offset = 3 [json_name = "pageOffset"];</code>
   * @return The pageOffset.
   */
  long getPageOffset();

  /**
   * <pre>
   * List of fields to populate from the resource in the result.
   * If empty all fields will be populated.
   * ID is always populated
   * </pre>
   *
   * <code>repeated string field_mask = 4 [json_name = "fieldMask"];</code>
   * @return A list containing the fieldMask.
   */
  java.util.List<java.lang.String>
      getFieldMaskList();
  /**
   * <pre>
   * List of fields to populate from the resource in the result.
   * If empty all fields will be populated.
   * ID is always populated
   * </pre>
   *
   * <code>repeated string field_mask = 4 [json_name = "fieldMask"];</code>
   * @return The count of fieldMask.
   */
  int getFieldMaskCount();
  /**
   * <pre>
   * List of fields to populate from the resource in the result.
   * If empty all fields will be populated.
   * ID is always populated
   * </pre>
   *
   * <code>repeated string field_mask = 4 [json_name = "fieldMask"];</code>
   * @param index The index of the element to return.
   * @return The fieldMask at the given index.
   */
  java.lang.String getFieldMask(int index);
  /**
   * <pre>
   * List of fields to populate from the resource in the result.
   * If empty all fields will be populated.
   * ID is always populated
   * </pre>
   *
   * <code>repeated string field_mask = 4 [json_name = "fieldMask"];</code>
   * @param index The index of the value to return.
   * @return The bytes of the fieldMask at the given index.
   */
  com.google.protobuf.ByteString
      getFieldMaskBytes(int index);
}