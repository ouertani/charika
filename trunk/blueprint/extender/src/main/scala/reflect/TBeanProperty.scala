package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.BeanProperty

trait TBeanProperty extends BeanProperty


case class BeanPropertyImpl(name:String ,
                            value : TMetadata ) extends TBeanProperty