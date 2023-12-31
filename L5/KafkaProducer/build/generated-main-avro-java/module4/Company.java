/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package module4;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Company extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3517753265675065104L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Company\",\"namespace\":\"module4\",\"fields\":[{\"name\":\"tradeNumber\",\"type\":\"int\"},{\"name\":\"registeredName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Company> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Company> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Company> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Company> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Company> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Company to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Company from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Company instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Company fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int tradeNumber;
  private java.lang.String registeredName;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Company() {}

  /**
   * All-args constructor.
   * @param tradeNumber The new value for tradeNumber
   * @param registeredName The new value for registeredName
   */
  public Company(java.lang.Integer tradeNumber, java.lang.String registeredName) {
    this.tradeNumber = tradeNumber;
    this.registeredName = registeredName;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return tradeNumber;
    case 1: return registeredName;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: tradeNumber = (java.lang.Integer)value$; break;
    case 1: registeredName = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'tradeNumber' field.
   * @return The value of the 'tradeNumber' field.
   */
  public int getTradeNumber() {
    return tradeNumber;
  }


  /**
   * Sets the value of the 'tradeNumber' field.
   * @param value the value to set.
   */
  public void setTradeNumber(int value) {
    this.tradeNumber = value;
  }

  /**
   * Gets the value of the 'registeredName' field.
   * @return The value of the 'registeredName' field.
   */
  public java.lang.String getRegisteredName() {
    return registeredName;
  }


  /**
   * Sets the value of the 'registeredName' field.
   * @param value the value to set.
   */
  public void setRegisteredName(java.lang.String value) {
    this.registeredName = value;
  }

  /**
   * Creates a new Company RecordBuilder.
   * @return A new Company RecordBuilder
   */
  public static module4.Company.Builder newBuilder() {
    return new module4.Company.Builder();
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Company RecordBuilder
   */
  public static module4.Company.Builder newBuilder(module4.Company.Builder other) {
    if (other == null) {
      return new module4.Company.Builder();
    } else {
      return new module4.Company.Builder(other);
    }
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Company instance.
   * @param other The existing instance to copy.
   * @return A new Company RecordBuilder
   */
  public static module4.Company.Builder newBuilder(module4.Company other) {
    if (other == null) {
      return new module4.Company.Builder();
    } else {
      return new module4.Company.Builder(other);
    }
  }

  /**
   * RecordBuilder for Company instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Company>
    implements org.apache.avro.data.RecordBuilder<Company> {

    private int tradeNumber;
    private java.lang.String registeredName;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(module4.Company.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.tradeNumber)) {
        this.tradeNumber = data().deepCopy(fields()[0].schema(), other.tradeNumber);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.registeredName)) {
        this.registeredName = data().deepCopy(fields()[1].schema(), other.registeredName);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Company instance
     * @param other The existing instance to copy.
     */
    private Builder(module4.Company other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.tradeNumber)) {
        this.tradeNumber = data().deepCopy(fields()[0].schema(), other.tradeNumber);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.registeredName)) {
        this.registeredName = data().deepCopy(fields()[1].schema(), other.registeredName);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'tradeNumber' field.
      * @return The value.
      */
    public int getTradeNumber() {
      return tradeNumber;
    }


    /**
      * Sets the value of the 'tradeNumber' field.
      * @param value The value of 'tradeNumber'.
      * @return This builder.
      */
    public module4.Company.Builder setTradeNumber(int value) {
      validate(fields()[0], value);
      this.tradeNumber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'tradeNumber' field has been set.
      * @return True if the 'tradeNumber' field has been set, false otherwise.
      */
    public boolean hasTradeNumber() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'tradeNumber' field.
      * @return This builder.
      */
    public module4.Company.Builder clearTradeNumber() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'registeredName' field.
      * @return The value.
      */
    public java.lang.String getRegisteredName() {
      return registeredName;
    }


    /**
      * Sets the value of the 'registeredName' field.
      * @param value The value of 'registeredName'.
      * @return This builder.
      */
    public module4.Company.Builder setRegisteredName(java.lang.String value) {
      validate(fields()[1], value);
      this.registeredName = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'registeredName' field has been set.
      * @return True if the 'registeredName' field has been set, false otherwise.
      */
    public boolean hasRegisteredName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'registeredName' field.
      * @return This builder.
      */
    public module4.Company.Builder clearRegisteredName() {
      registeredName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Company build() {
      try {
        Company record = new Company();
        record.tradeNumber = fieldSetFlags()[0] ? this.tradeNumber : (java.lang.Integer) defaultValue(fields()[0]);
        record.registeredName = fieldSetFlags()[1] ? this.registeredName : (java.lang.String) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Company>
    WRITER$ = (org.apache.avro.io.DatumWriter<Company>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Company>
    READER$ = (org.apache.avro.io.DatumReader<Company>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.tradeNumber);

    out.writeString(this.registeredName);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.tradeNumber = in.readInt();

      this.registeredName = in.readString();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.tradeNumber = in.readInt();
          break;

        case 1:
          this.registeredName = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










