package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.BeanArgument

trait TBeanArgument extends BeanArgument 


class BeanArgument_ (value : TMetadata, valueType : String, index : Int) extends TBeanArgument {
  override def getValue()=value
  override def 	getValueType()=valueType
  override def	getIndex()=index
}