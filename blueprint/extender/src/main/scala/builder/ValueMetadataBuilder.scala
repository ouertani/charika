package net.dikka.charika.blueprint
package builder
import reflect._
import reflect.impl._
class ValueMetadataBuilder  {
  private [this] var stringValue:String=_
  private [this] var tipe:String=_


  def withStringValue(stringValue:String)={
    this.stringValue=stringValue
    this
  }
  def withType(tipe:String)={
    this.tipe=tipe
    this
  }



  def build()={
    new ValueMetadata( stringValue,
                            tipe)
  }

}