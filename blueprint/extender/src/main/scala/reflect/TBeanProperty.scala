package net.dikka.charika.blueprint
package reflect

import org.osgi.service.blueprint.reflect.BeanProperty

trait TBeanProperty extends BeanProperty


class BeanProperty_(name:String ,
                         value : TMetadata ) extends TBeanProperty {

  override def getName()=name
  override def getValue()=value
}