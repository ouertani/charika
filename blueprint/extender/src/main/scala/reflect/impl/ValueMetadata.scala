package net.dikka.charika.blueprint
package reflect.impl
import reflect._
 class ValueMetadata( stringValue:String,
                            tipe:String) extends TValueMetadata {
  override def  getStringValue()=stringValue
  override def getType()=tipe
}
