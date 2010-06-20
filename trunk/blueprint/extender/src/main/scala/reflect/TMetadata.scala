/*
 *  slim ouertani
 *  
 */
package net.dikka.charika.blueprint
package reflect


import net.dikka.charika.blueprint.extender.impl.beans.Activation
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._

trait TMetadata extends Metadata
trait TNullMetadata extends NullMetadata with TMetadata
trait TNonNullMetadata extends NonNullMetadata with TMetadata

trait TValueMetadata extends ValueMetadata with TNonNullMetadata
trait TIdRefMetadata extends IdRefMetadata with TNonNullMetadata
trait TComponentMetadata extends ComponentMetadata with NonNullMetadata {
  val activation:Activation
  val dependsOn:List[String]
  override def  getActivation()=activation.activation
  override  def getDependsOn()=dependsOn
}
trait TCollectionMetadata extends CollectionMetadata with TNonNullMetadata {
  val values:List[_ <:Metadata]
  override  def getValues()=values
}
trait TPropsMetadata extends PropsMetadata with TNonNullMetadata
trait TMapMetadata extends MapMetadata with TNonNullMetadata
trait TTarget extends Target with TNonNullMetadata
trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata
trait TRefMetadata extends RefMetadata with TTarget with TNonNullMetadata

trait TServiceReferenceMetadata extends ServiceReferenceMetadata with TComponentMetadata
trait TReferenceListMetadata extends ReferenceListMetadata with TServiceReferenceMetadata
trait TReferenceMetadata extends ReferenceMetadata with TTarget with TServiceReferenceMetadata
trait TMapEntry extends MapEntry {
  val key:TNonNullMetadata
  val value:TMetadata

  override def  getKey:NonNullMetadata=key
  override def  getValue():Metadata=value
}
trait TReferenceListener extends  ReferenceListener {
  val target:TTarget
  override def getListenerComponent():Target=target
}
trait TBeanProperty extends BeanProperty {
  val value:TMetadata
  override def  getValue():Metadata=value
}
trait TBeanArgument extends BeanArgument {
  val metadata:TMetadata
  val index:Int
  override def getValue():Metadata=metadata
  override def getIndex()=index.intValue
}
trait TRegistrationListener extends RegistrationListener{
  val target:TTarget
  override def  getListenerComponent():Target=target
}
