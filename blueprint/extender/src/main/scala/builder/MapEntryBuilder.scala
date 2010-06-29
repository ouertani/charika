package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class MapEntryBuilder  {
  private [this] var  _key:TNonNullMetadata=_
  private [this] var  _value:TMetadata=_


  def withTNonNullMetadata(key:TNonNullMetadata)={
    this._key=key
    this
  }
  def withTMetadata(value:TMetadata)={
    this._value=value
    this
  }
def build()={
    new MapEntry( _key,
                _value)
  }
}
