package net.dikka.charika.blueprint
package reflect.impl
import org.osgi.service.blueprint.reflect.BeanProperty

trait TBeanProperty extends BeanProperty


case class BeanPropertyImpl(name:String ,
                            value : TMetadata ) extends TBeanProperty