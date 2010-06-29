package net.dikka.charika.blueprint
package builder


import reflect.TMetadata
import reflect.impl.BeanArgument



class BeanArgumentBuilder   {
  private [this] var _value : TMetadata=_
  private [this] var _valueType : Option[String]=None
  private [this] var _index : Option[Int]=None


  def withValue(value : TMetadata)={
    this._value=value
    this
  }
  def withValueType(valueType : String)={
    this._valueType=valueType
    this
  }
  def withIndex(index : Int)={
    this._index=index
    this
  }


  def apply()={
    new BeanArgument (_value, _valueType , _index )
  }
}
