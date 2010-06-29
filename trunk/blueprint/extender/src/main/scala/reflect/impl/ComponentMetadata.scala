package net.dikka.charika.blueprint
package reflect.impl

import reflect._
import scala.collection.JavaConversions._

class ComponentMetadata(val id :String ,val activation:Activation ,val dependsOns:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOns
}
