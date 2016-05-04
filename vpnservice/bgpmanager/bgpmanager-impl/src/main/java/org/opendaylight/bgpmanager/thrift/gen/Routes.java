/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package org.opendaylight.bgpmanager.thrift.gen;

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

public class Routes implements org.apache.thrift.TBase<Routes, Routes._Fields>, java.io.Serializable, Cloneable, Comparable<Routes> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Routes");

  private static final org.apache.thrift.protocol.TField ERRCODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errcode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField UPDATES_FIELD_DESC = new org.apache.thrift.protocol.TField("updates", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField MORE_FIELD_DESC = new org.apache.thrift.protocol.TField("more", org.apache.thrift.protocol.TType.I32, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new RoutesStandardSchemeFactory());
    schemes.put(TupleScheme.class, new RoutesTupleSchemeFactory());
  }

  public int errcode; // required
  public List<Update> updates; // optional
  public int more; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERRCODE((short)1, "errcode"),
    UPDATES((short)2, "updates"),
    MORE((short)4, "more");

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
        case 1: // ERRCODE
          return ERRCODE;
        case 2: // UPDATES
          return UPDATES;
        case 4: // MORE
          return MORE;
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
  private static final int __ERRCODE_ISSET_ID = 0;
  private static final int __MORE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.UPDATES,_Fields.MORE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERRCODE, new org.apache.thrift.meta_data.FieldMetaData("errcode", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UPDATES, new org.apache.thrift.meta_data.FieldMetaData("updates", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Update.class))));
    tmpMap.put(_Fields.MORE, new org.apache.thrift.meta_data.FieldMetaData("more", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Routes.class, metaDataMap);
  }

  public Routes() {
  }

  public Routes(
    int errcode)
  {
    this();
    this.errcode = errcode;
    setErrcodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Routes(Routes other) {
    __isset_bitfield = other.__isset_bitfield;
    this.errcode = other.errcode;
    if (other.isSetUpdates()) {
      List<Update> __this__updates = new ArrayList<Update>(other.updates.size());
      for (Update other_element : other.updates) {
        __this__updates.add(new Update(other_element));
      }
      this.updates = __this__updates;
    }
    this.more = other.more;
  }

  public Routes deepCopy() {
    return new Routes(this);
  }

  @Override
  public void clear() {
    setErrcodeIsSet(false);
    this.errcode = 0;
    this.updates = null;
    setMoreIsSet(false);
    this.more = 0;
  }

  public int getErrcode() {
    return this.errcode;
  }

  public Routes setErrcode(int errcode) {
    this.errcode = errcode;
    setErrcodeIsSet(true);
    return this;
  }

  public void unsetErrcode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ERRCODE_ISSET_ID);
  }

  /** Returns true if field errcode is set (has been assigned a value) and false otherwise */
  public boolean isSetErrcode() {
    return EncodingUtils.testBit(__isset_bitfield, __ERRCODE_ISSET_ID);
  }

  public void setErrcodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ERRCODE_ISSET_ID, value);
  }

  public int getUpdatesSize() {
    return (this.updates == null) ? 0 : this.updates.size();
  }

  public java.util.Iterator<Update> getUpdatesIterator() {
    return (this.updates == null) ? null : this.updates.iterator();
  }

  public void addToUpdates(Update elem) {
    if (this.updates == null) {
      this.updates = new ArrayList<Update>();
    }
    this.updates.add(elem);
  }

  public List<Update> getUpdates() {
    return this.updates;
  }

  public Routes setUpdates(List<Update> updates) {
    this.updates = updates;
    return this;
  }

  public void unsetUpdates() {
    this.updates = null;
  }

  /** Returns true if field updates is set (has been assigned a value) and false otherwise */
  public boolean isSetUpdates() {
    return this.updates != null;
  }

  public void setUpdatesIsSet(boolean value) {
    if (!value) {
      this.updates = null;
    }
  }

  public int getMore() {
    return this.more;
  }

  public Routes setMore(int more) {
    this.more = more;
    setMoreIsSet(true);
    return this;
  }

  public void unsetMore() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MORE_ISSET_ID);
  }

  /** Returns true if field more is set (has been assigned a value) and false otherwise */
  public boolean isSetMore() {
    return EncodingUtils.testBit(__isset_bitfield, __MORE_ISSET_ID);
  }

  public void setMoreIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MORE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ERRCODE:
      if (value == null) {
        unsetErrcode();
      } else {
        setErrcode((Integer)value);
      }
      break;

    case UPDATES:
      if (value == null) {
        unsetUpdates();
      } else {
        setUpdates((List<Update>)value);
      }
      break;

    case MORE:
      if (value == null) {
        unsetMore();
      } else {
        setMore((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERRCODE:
      return Integer.valueOf(getErrcode());

    case UPDATES:
      return getUpdates();

    case MORE:
      return Integer.valueOf(getMore());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ERRCODE:
      return isSetErrcode();
    case UPDATES:
      return isSetUpdates();
    case MORE:
      return isSetMore();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Routes)
      return this.equals((Routes)that);
    return false;
  }

  public boolean equals(Routes that) {
    if (that == null)
      return false;

    boolean this_present_errcode = true;
    boolean that_present_errcode = true;
    if (this_present_errcode || that_present_errcode) {
      if (!(this_present_errcode && that_present_errcode))
        return false;
      if (this.errcode != that.errcode)
        return false;
    }

    boolean this_present_updates = true && this.isSetUpdates();
    boolean that_present_updates = true && that.isSetUpdates();
    if (this_present_updates || that_present_updates) {
      if (!(this_present_updates && that_present_updates))
        return false;
      if (!this.updates.equals(that.updates))
        return false;
    }

    boolean this_present_more = true && this.isSetMore();
    boolean that_present_more = true && that.isSetMore();
    if (this_present_more || that_present_more) {
      if (!(this_present_more && that_present_more))
        return false;
      if (this.more != that.more)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Routes other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetErrcode()).compareTo(other.isSetErrcode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrcode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errcode, other.errcode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpdates()).compareTo(other.isSetUpdates());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpdates()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.updates, other.updates);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMore()).compareTo(other.isSetMore());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMore()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.more, other.more);
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
    StringBuilder sb = new StringBuilder("Routes(");
    boolean first = true;

    sb.append("errcode:");
    sb.append(this.errcode);
    first = false;
    if (isSetUpdates()) {
      if (!first) sb.append(", ");
      sb.append("updates:");
      if (this.updates == null) {
        sb.append("null");
      } else {
        sb.append(this.updates);
      }
      first = false;
    }
    if (isSetMore()) {
      if (!first) sb.append(", ");
      sb.append("more:");
      sb.append(this.more);
      first = false;
    }
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RoutesStandardSchemeFactory implements SchemeFactory {
    public RoutesStandardScheme getScheme() {
      return new RoutesStandardScheme();
    }
  }

  private static class RoutesStandardScheme extends StandardScheme<Routes> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Routes struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERRCODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errcode = iprot.readI32();
              struct.setErrcodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // UPDATES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.updates = new ArrayList<Update>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  Update _elem2;
                  _elem2 = new Update();
                  _elem2.read(iprot);
                  struct.updates.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setUpdatesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MORE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.more = iprot.readI32();
              struct.setMoreIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Routes struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERRCODE_FIELD_DESC);
      oprot.writeI32(struct.errcode);
      oprot.writeFieldEnd();
      if (struct.updates != null) {
        if (struct.isSetUpdates()) {
          oprot.writeFieldBegin(UPDATES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.updates.size()));
            for (Update _iter3 : struct.updates)
            {
              _iter3.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetMore()) {
        oprot.writeFieldBegin(MORE_FIELD_DESC);
        oprot.writeI32(struct.more);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RoutesTupleSchemeFactory implements SchemeFactory {
    public RoutesTupleScheme getScheme() {
      return new RoutesTupleScheme();
    }
  }

  private static class RoutesTupleScheme extends TupleScheme<Routes> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Routes struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetErrcode()) {
        optionals.set(0);
      }
      if (struct.isSetUpdates()) {
        optionals.set(1);
      }
      if (struct.isSetMore()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetErrcode()) {
        oprot.writeI32(struct.errcode);
      }
      if (struct.isSetUpdates()) {
        {
          oprot.writeI32(struct.updates.size());
          for (Update _iter4 : struct.updates)
          {
            _iter4.write(oprot);
          }
        }
      }
      if (struct.isSetMore()) {
        oprot.writeI32(struct.more);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Routes struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.errcode = iprot.readI32();
        struct.setErrcodeIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.updates = new ArrayList<Update>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            Update _elem7;
            _elem7 = new Update();
            _elem7.read(iprot);
            struct.updates.add(_elem7);
          }
        }
        struct.setUpdatesIsSet(true);
      }
      if (incoming.get(2)) {
        struct.more = iprot.readI32();
        struct.setMoreIsSet(true);
      }
    }
  }

}

