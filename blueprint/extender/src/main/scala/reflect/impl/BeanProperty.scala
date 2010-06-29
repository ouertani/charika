package net.dikka.charika.blueprint
package reflect.impl

import reflect._

class BeanProperty(name:String ,
                    value : TMetadata ) extends TBeanProperty {

  override def getName()=name
  override def getValue()=value
}
