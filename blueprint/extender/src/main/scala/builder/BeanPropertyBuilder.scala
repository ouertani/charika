package net.dikka.charika.blueprint
package builder

import reflect.TMetadata
import reflect.impl.BeanProperty
import reflect._
import reflect.impl._
class BeanPropertyBuilder  {
  private [this] var _name:String=_
  private [this] var _value : TMetadata=_



  def withName( name:String)={
    this._name=name
    this
  }
  def withValue(value : TMetadata)={
    this._value=value
    this
  }

def apply()={
    new BeanProperty(_name,
                    _value )
  }
}
