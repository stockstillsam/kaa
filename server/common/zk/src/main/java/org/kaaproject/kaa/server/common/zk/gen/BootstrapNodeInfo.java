/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package org.kaaproject.kaa.server.common.zk.gen;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class BootstrapNodeInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"BootstrapNodeInfo\",\"namespace\":\"org.kaaproject.kaa.server.common.zk.gen\",\"fields\":[{\"name\":\"connectionInfo\",\"type\":{\"type\":\"record\",\"name\":\"ConnectionInfo\",\"fields\":[{\"name\":\"thriftHost\",\"type\":\"string\"},{\"name\":\"thriftPort\",\"type\":\"int\"},{\"name\":\"publicKey\",\"type\":[\"bytes\",\"null\"]}]}},{\"name\":\"transports\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"TransportMetaData\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"minSupportedVersion\",\"type\":\"int\"},{\"name\":\"maxSupportedVersion\",\"type\":\"int\"},{\"name\":\"connectionInfo\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"VersionConnectionInfoPair\",\"fields\":[{\"name\":\"version\",\"type\":\"int\"},{\"name\":\"conenctionInfo\",\"type\":\"bytes\"}]}}}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo connectionInfo;
   private java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> transports;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public BootstrapNodeInfo() {}

  /**
   * All-args constructor.
   */
  public BootstrapNodeInfo(org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo connectionInfo, java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> transports) {
    this.connectionInfo = connectionInfo;
    this.transports = transports;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return connectionInfo;
    case 1: return transports;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: connectionInfo = (org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo)value$; break;
    case 1: transports = (java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'connectionInfo' field.
   */
  public org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo getConnectionInfo() {
    return connectionInfo;
  }

  /**
   * Sets the value of the 'connectionInfo' field.
   * @param value the value to set.
   */
  public void setConnectionInfo(org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo value) {
    this.connectionInfo = value;
  }

  /**
   * Gets the value of the 'transports' field.
   */
  public java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> getTransports() {
    return transports;
  }

  /**
   * Sets the value of the 'transports' field.
   * @param value the value to set.
   */
  public void setTransports(java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> value) {
    this.transports = value;
  }

  /** Creates a new BootstrapNodeInfo RecordBuilder */
  public static org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder newBuilder() {
    return new org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder();
  }
  
  /** Creates a new BootstrapNodeInfo RecordBuilder by copying an existing Builder */
  public static org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder newBuilder(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder other) {
    return new org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder(other);
  }
  
  /** Creates a new BootstrapNodeInfo RecordBuilder by copying an existing BootstrapNodeInfo instance */
  public static org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder newBuilder(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo other) {
    return new org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder(other);
  }
  
  /**
   * RecordBuilder for BootstrapNodeInfo instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<BootstrapNodeInfo>
    implements org.apache.avro.data.RecordBuilder<BootstrapNodeInfo> {

    private org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo connectionInfo;
    private java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> transports;

    /** Creates a new Builder */
    private Builder() {
      super(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.connectionInfo)) {
        this.connectionInfo = data().deepCopy(fields()[0].schema(), other.connectionInfo);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.transports)) {
        this.transports = data().deepCopy(fields()[1].schema(), other.transports);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing BootstrapNodeInfo instance */
    private Builder(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo other) {
            super(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.SCHEMA$);
      if (isValidValue(fields()[0], other.connectionInfo)) {
        this.connectionInfo = data().deepCopy(fields()[0].schema(), other.connectionInfo);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.transports)) {
        this.transports = data().deepCopy(fields()[1].schema(), other.transports);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'connectionInfo' field */
    public org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo getConnectionInfo() {
      return connectionInfo;
    }
    
    /** Sets the value of the 'connectionInfo' field */
    public org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder setConnectionInfo(org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo value) {
      validate(fields()[0], value);
      this.connectionInfo = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'connectionInfo' field has been set */
    public boolean hasConnectionInfo() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'connectionInfo' field */
    public org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder clearConnectionInfo() {
      connectionInfo = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'transports' field */
    public java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> getTransports() {
      return transports;
    }
    
    /** Sets the value of the 'transports' field */
    public org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder setTransports(java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData> value) {
      validate(fields()[1], value);
      this.transports = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'transports' field has been set */
    public boolean hasTransports() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'transports' field */
    public org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo.Builder clearTransports() {
      transports = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public BootstrapNodeInfo build() {
      try {
        BootstrapNodeInfo record = new BootstrapNodeInfo();
        record.connectionInfo = fieldSetFlags()[0] ? this.connectionInfo : (org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo) defaultValue(fields()[0]);
        record.transports = fieldSetFlags()[1] ? this.transports : (java.util.List<org.kaaproject.kaa.server.common.zk.gen.TransportMetaData>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
