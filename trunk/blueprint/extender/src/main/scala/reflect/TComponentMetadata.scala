package net.dikka.charika.blueprint
package reflect


import net.dikka.charika.blueprint.extender.impl.beans._
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._


trait TComponentMetadata extends ComponentMetadata with NonNullMetadata 


abstract class Component (id:String, activation :Activation=Eager, dependsOn:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOn
}
