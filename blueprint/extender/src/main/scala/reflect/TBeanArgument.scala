package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.BeanArgument

trait TBeanArgument extends BeanArgument 


case class ArgumentImpl (value : TMetadata, valueType : String, index : Int) extends TBeanArgument 