/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.kaaproject.kaa.server.common.thrift.gen.control;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileData implements org.apache.thrift.TBase<FileData, FileData._Fields>, java.io.Serializable, Cloneable, Comparable<FileData> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FileData");

  private static final org.apache.thrift.protocol.TField FILE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("fileName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("data", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new FileDataStandardSchemeFactory());
    schemes.put(TupleScheme.class, new FileDataTupleSchemeFactory());
  }

  public String fileName; // required
  public ByteBuffer data; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FILE_NAME((short)1, "fileName"),
    DATA((short)2, "data");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FILE_NAME
          return FILE_NAME;
        case 2: // DATA
          return DATA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FILE_NAME, new org.apache.thrift.meta_data.FieldMetaData("fileName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DATA, new org.apache.thrift.meta_data.FieldMetaData("data", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FileData.class, metaDataMap);
  }

  public FileData() {
  }

  public FileData(
    String fileName,
    ByteBuffer data)
  {
    this();
    this.fileName = fileName;
    this.data = data;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FileData(FileData other) {
    if (other.isSetFileName()) {
      this.fileName = other.fileName;
    }
    if (other.isSetData()) {
      this.data = org.apache.thrift.TBaseHelper.copyBinary(other.data);
;
    }
  }

  public FileData deepCopy() {
    return new FileData(this);
  }

  @Override
  public void clear() {
    this.fileName = null;
    this.data = null;
  }

  public String getFileName() {
    return this.fileName;
  }

  public FileData setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public void unsetFileName() {
    this.fileName = null;
  }

  /** Returns true if field fileName is set (has been assigned a value) and false otherwise */
  public boolean isSetFileName() {
    return this.fileName != null;
  }

  public void setFileNameIsSet(boolean value) {
    if (!value) {
      this.fileName = null;
    }
  }

  public byte[] getData() {
    setData(org.apache.thrift.TBaseHelper.rightSize(data));
    return data == null ? null : data.array();
  }

  public ByteBuffer bufferForData() {
    return data;
  }

  public FileData setData(byte[] data) {
    setData(data == null ? (ByteBuffer)null : ByteBuffer.wrap(data));
    return this;
  }

  public FileData setData(ByteBuffer data) {
    this.data = data;
    return this;
  }

  public void unsetData() {
    this.data = null;
  }

  /** Returns true if field data is set (has been assigned a value) and false otherwise */
  public boolean isSetData() {
    return this.data != null;
  }

  public void setDataIsSet(boolean value) {
    if (!value) {
      this.data = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FILE_NAME:
      if (value == null) {
        unsetFileName();
      } else {
        setFileName((String)value);
      }
      break;

    case DATA:
      if (value == null) {
        unsetData();
      } else {
        setData((ByteBuffer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FILE_NAME:
      return getFileName();

    case DATA:
      return getData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FILE_NAME:
      return isSetFileName();
    case DATA:
      return isSetData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof FileData)
      return this.equals((FileData)that);
    return false;
  }

  public boolean equals(FileData that) {
    if (that == null)
      return false;

    boolean this_present_fileName = true && this.isSetFileName();
    boolean that_present_fileName = true && that.isSetFileName();
    if (this_present_fileName || that_present_fileName) {
      if (!(this_present_fileName && that_present_fileName))
        return false;
      if (!this.fileName.equals(that.fileName))
        return false;
    }

    boolean this_present_data = true && this.isSetData();
    boolean that_present_data = true && that.isSetData();
    if (this_present_data || that_present_data) {
      if (!(this_present_data && that_present_data))
        return false;
      if (!this.data.equals(that.data))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_fileName = true && (isSetFileName());
    builder.append(present_fileName);
    if (present_fileName)
      builder.append(fileName);

    boolean present_data = true && (isSetData());
    builder.append(present_data);
    if (present_data)
      builder.append(data);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(FileData other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetFileName()).compareTo(other.isSetFileName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFileName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fileName, other.fileName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData()).compareTo(other.isSetData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data, other.data);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("FileData(");
    boolean first = true;

    sb.append("fileName:");
    if (this.fileName == null) {
      sb.append("null");
    } else {
      sb.append(this.fileName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("data:");
    if (this.data == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.data, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FileDataStandardSchemeFactory implements SchemeFactory {
    public FileDataStandardScheme getScheme() {
      return new FileDataStandardScheme();
    }
  }

  private static class FileDataStandardScheme extends StandardScheme<FileData> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FileData struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FILE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fileName = iprot.readString();
              struct.setFileNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.data = iprot.readBinary();
              struct.setDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, FileData struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fileName != null) {
        oprot.writeFieldBegin(FILE_NAME_FIELD_DESC);
        oprot.writeString(struct.fileName);
        oprot.writeFieldEnd();
      }
      if (struct.data != null) {
        oprot.writeFieldBegin(DATA_FIELD_DESC);
        oprot.writeBinary(struct.data);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FileDataTupleSchemeFactory implements SchemeFactory {
    public FileDataTupleScheme getScheme() {
      return new FileDataTupleScheme();
    }
  }

  private static class FileDataTupleScheme extends TupleScheme<FileData> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FileData struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetFileName()) {
        optionals.set(0);
      }
      if (struct.isSetData()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetFileName()) {
        oprot.writeString(struct.fileName);
      }
      if (struct.isSetData()) {
        oprot.writeBinary(struct.data);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FileData struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.fileName = iprot.readString();
        struct.setFileNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.data = iprot.readBinary();
        struct.setDataIsSet(true);
      }
    }
  }

}

