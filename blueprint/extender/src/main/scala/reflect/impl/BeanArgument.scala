package net.dikka.charika.blueprint
package reflect.impl

import reflect._

class BeanArgument (val value : TMetadata, val valueType : Option[String],val index : Option[Int])
extends TBeanArgument {
  override def getValue()=value
  override def getValueType()=valueType
  override def getIndex()=index getOrElse (-1)
}
