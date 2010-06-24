package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.ValueMetadata

trait TValueMetadata  extends ValueMetadata with TNonNullMetadata

class ValueMetadata_( stringValue:String,
                         tipe:String) extends TValueMetadata {
  override def  getStringValue()=stringValue
  override def getType()=tipe
}