// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: person.proto
package com.squareup.wire.protos3.kotlin.person

import com.squareup.wire.EnumAdapter
import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.WireEnum
import com.squareup.wire.WireField
import com.squareup.wire.internal.countNonNull
import com.squareup.wire.internal.redactElements
import com.squareup.wire.internal.sanitize
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.hashCode
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import okio.ByteString

/**
 * Message representing a person, includes their name, unique ID number, email and phone number.
 */
class Person(
  /**
   * The customer's full name.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val name: String = "",
  /**
   * The customer's ID number.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  val id: Int = 0,
  /**
   * Email address for the customer.
   */
  @field:WireField(
    tag = 3,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val email: String = "",
  /**
   * A list of the customer's phone numbers.
   */
  @field:WireField(
    tag = 4,
    adapter = "com.squareup.wire.protos3.kotlin.person.Person${'$'}PhoneNumber#ADAPTER",
    label = WireField.Label.REPEATED
  )
  val phones: List<PhoneNumber> = emptyList(),
  @field:WireField(
    tag = 5,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED
  )
  val aliases: List<String> = emptyList(),
  @field:WireField(
    tag = 6,
    adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  val foo: Int? = null,
  @field:WireField(
    tag = 7,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  val bar: String? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Person, Nothing>(ADAPTER, unknownFields) {
  init {
    require(countNonNull(foo, bar) <= 1) {
      "At most one of foo, bar may be non-null"
    }
  }

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  override fun newBuilder(): Nothing = throw AssertionError()

  override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Person) return false
    return unknownFields == other.unknownFields
        && name == other.name
        && id == other.id
        && email == other.email
        && phones == other.phones
        && aliases == other.aliases
        && foo == other.foo
        && bar == other.bar
  }

  override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + name.hashCode()
      result = result * 37 + id.hashCode()
      result = result * 37 + email.hashCode()
      result = result * 37 + phones.hashCode()
      result = result * 37 + aliases.hashCode()
      result = result * 37 + foo.hashCode()
      result = result * 37 + bar.hashCode()
      super.hashCode = result
    }
    return result
  }

  override fun toString(): String {
    val result = mutableListOf<String>()
    result += """name=${sanitize(name)}"""
    result += """id=$id"""
    result += """email=${sanitize(email)}"""
    if (phones.isNotEmpty()) result += """phones=$phones"""
    if (aliases.isNotEmpty()) result += """aliases=${sanitize(aliases)}"""
    if (foo != null) result += """foo=$foo"""
    if (bar != null) result += """bar=${sanitize(bar)}"""
    return result.joinToString(prefix = "Person{", separator = ", ", postfix = "}")
  }

  fun copy(
    name: String = this.name,
    id: Int = this.id,
    email: String = this.email,
    phones: List<PhoneNumber> = this.phones,
    aliases: List<String> = this.aliases,
    foo: Int? = this.foo,
    bar: String? = this.bar,
    unknownFields: ByteString = this.unknownFields
  ): Person = Person(name, id, email, phones, aliases, foo, bar, unknownFields)

  companion object {
    @JvmField
    val ADAPTER: ProtoAdapter<Person> = object : ProtoAdapter<Person>(
      FieldEncoding.LENGTH_DELIMITED, 
      Person::class, 
      "type.googleapis.com/squareup.protos3.kotlin.person.Person"
    ) {
      override fun encodedSize(value: Person): Int = 
        ProtoAdapter.STRING.encodedSizeWithTag(1, value.name) +
        ProtoAdapter.INT32.encodedSizeWithTag(2, value.id) +
        ProtoAdapter.STRING.encodedSizeWithTag(3, value.email) +
        PhoneNumber.ADAPTER.asRepeated().encodedSizeWithTag(4, value.phones) +
        ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, value.aliases) +
        ProtoAdapter.INT32.encodedSizeWithTag(6, value.foo) +
        ProtoAdapter.STRING.encodedSizeWithTag(7, value.bar) +
        value.unknownFields.size

      override fun encode(writer: ProtoWriter, value: Person) {
        if (value.name != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        if (value.id != 0) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.id)
        if (value.email != "") ProtoAdapter.STRING.encodeWithTag(writer, 3, value.email)
        PhoneNumber.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.phones)
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 5, value.aliases)
        if (value.foo != null) ProtoAdapter.INT32.encodeWithTag(writer, 6, value.foo)
        if (value.bar != null) ProtoAdapter.STRING.encodeWithTag(writer, 7, value.bar)
        writer.writeBytes(value.unknownFields)
      }

      override fun decode(reader: ProtoReader): Person {
        var name: String = ""
        var id: Int = 0
        var email: String = ""
        val phones = mutableListOf<PhoneNumber>()
        val aliases = mutableListOf<String>()
        var foo: Int? = null
        var bar: String? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> id = ProtoAdapter.INT32.decode(reader)
            3 -> email = ProtoAdapter.STRING.decode(reader)
            4 -> phones.add(PhoneNumber.ADAPTER.decode(reader))
            5 -> aliases.add(ProtoAdapter.STRING.decode(reader))
            6 -> foo = ProtoAdapter.INT32.decode(reader)
            7 -> bar = ProtoAdapter.STRING.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Person(
          name = name,
          id = id,
          email = email,
          phones = phones,
          aliases = aliases,
          foo = foo,
          bar = bar,
          unknownFields = unknownFields
        )
      }

      override fun redact(value: Person): Person = value.copy(
        phones = value.phones.redactElements(PhoneNumber.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }
  }

  /**
   * Represents the type of the phone number: mobile, home or work.
   */
  enum class PhoneType(
    override val value: Int
  ) : WireEnum {
    MOBILE(0),

    HOME(1),

    /**
     * Could be phone or fax.
     */
    WORK(2);

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<PhoneType> = object : EnumAdapter<PhoneType>(
        PhoneType::class
      ) {
        override fun fromValue(value: Int): PhoneType? = PhoneType.fromValue(value)
      }

      @JvmStatic
      fun fromValue(value: Int): PhoneType? = when (value) {
        0 -> MOBILE
        1 -> HOME
        2 -> WORK
        else -> null
      }
    }
  }

  class PhoneNumber(
    /**
     * The customer's phone number.
     */
    @field:WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
    )
    val number: String = "",
    /**
     * The type of phone stored here.
     */
    @field:WireField(
      tag = 2,
      adapter = "com.squareup.wire.protos3.kotlin.person.Person${'$'}PhoneType#ADAPTER"
    )
    val type: PhoneType = PhoneType.MOBILE,
    unknownFields: ByteString = ByteString.EMPTY
  ) : Message<PhoneNumber, Nothing>(ADAPTER, unknownFields) {
    @Deprecated(
      message = "Shouldn't be used in Kotlin",
      level = DeprecationLevel.HIDDEN
    )
    override fun newBuilder(): Nothing = throw AssertionError()

    override fun equals(other: Any?): Boolean {
      if (other === this) return true
      if (other !is PhoneNumber) return false
      return unknownFields == other.unknownFields
          && number == other.number
          && type == other.type
    }

    override fun hashCode(): Int {
      var result = super.hashCode
      if (result == 0) {
        result = unknownFields.hashCode()
        result = result * 37 + number.hashCode()
        result = result * 37 + type.hashCode()
        super.hashCode = result
      }
      return result
    }

    override fun toString(): String {
      val result = mutableListOf<String>()
      result += """number=${sanitize(number)}"""
      result += """type=$type"""
      return result.joinToString(prefix = "PhoneNumber{", separator = ", ", postfix = "}")
    }

    fun copy(
      number: String = this.number,
      type: PhoneType = this.type,
      unknownFields: ByteString = this.unknownFields
    ): PhoneNumber = PhoneNumber(number, type, unknownFields)

    companion object {
      @JvmField
      val ADAPTER: ProtoAdapter<PhoneNumber> = object : ProtoAdapter<PhoneNumber>(
        FieldEncoding.LENGTH_DELIMITED, 
        PhoneNumber::class, 
        "type.googleapis.com/squareup.protos3.kotlin.person.Person.PhoneNumber"
      ) {
        override fun encodedSize(value: PhoneNumber): Int = 
          ProtoAdapter.STRING.encodedSizeWithTag(1, value.number) +
          PhoneType.ADAPTER.encodedSizeWithTag(2, value.type) +
          value.unknownFields.size

        override fun encode(writer: ProtoWriter, value: PhoneNumber) {
          if (value.number != "") ProtoAdapter.STRING.encodeWithTag(writer, 1, value.number)
          if (value.type != PhoneType.MOBILE) PhoneType.ADAPTER.encodeWithTag(writer, 2, value.type)
          writer.writeBytes(value.unknownFields)
        }

        override fun decode(reader: ProtoReader): PhoneNumber {
          var number: String = ""
          var type: PhoneType = PhoneType.MOBILE
          val unknownFields = reader.forEachTag { tag ->
            when (tag) {
              1 -> number = ProtoAdapter.STRING.decode(reader)
              2 -> try {
                type = PhoneType.ADAPTER.decode(reader)
              } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
                reader.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
              }
              else -> reader.readUnknownField(tag)
            }
          }
          return PhoneNumber(
            number = number,
            type = type,
            unknownFields = unknownFields
          )
        }

        override fun redact(value: PhoneNumber): PhoneNumber = value.copy(
          unknownFields = ByteString.EMPTY
        )
      }
    }
  }
}
