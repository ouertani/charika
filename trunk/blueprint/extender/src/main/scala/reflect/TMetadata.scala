/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License, v. 2.0
 * which accompanies this distribution, and is available at
 * http://www.apache.org/licenses/
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
/*
 *  slim ouertani
 *  
 */
package net.dikka.charika.blueprint
package reflect


import net.dikka.charika.blueprint.extender.impl.beans.Activation
import net.dikka.charika.blueprint.extender.impl.beans.Scope
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._

sealed trait TMetadata extends Metadata
trait TNullMetadata extends NullMetadata with TMetadata
sealed trait TNonNullMetadata extends NonNullMetadata with TMetadata

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
trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata {

  val factoryComponent:TTarget
  val scope:Scope
  override def   getFactoryComponent():Target=factoryComponent

  override def getScope()=scope.scope

}
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

