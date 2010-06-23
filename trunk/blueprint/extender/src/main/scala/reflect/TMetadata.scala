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



import net.dikka.charika.blueprint.extender.impl.beans._
import org.osgi.service.blueprint.reflect._
import scala.collection.JavaConversions._


sealed trait TMetadata extends Metadata
trait TNullMetadata extends NullMetadata with TMetadata
trait TNonNullMetadata extends NonNullMetadata with TMetadata


trait TIdRefMetadata extends IdRefMetadata with TNonNullMetadata{
  val ref:Option[String]
  override def getComponentId:String=ref.getOrElse(null)
}

trait TCollectionMetadata extends CollectionMetadata with TNonNullMetadata {
  val values:List[_ <:Metadata]
  override  def getValues()=values
}
trait TPropsMetadata extends PropsMetadata with TNonNullMetadata
trait TMapMetadata extends MapMetadata with TNonNullMetadata
trait TTarget extends Target with TNonNullMetadata




trait TReferenceListMetadata extends ReferenceListMetadata with TServiceReferenceMetadata

trait TMapEntry extends MapEntry {
  val key:TNonNullMetadata
  val value:TMetadata

  override def  getKey:NonNullMetadata=key
  override def  getValue():Metadata=value
}

trait TBeanProperty extends BeanProperty {
  val value:TMetadata
  override def  getValue():Metadata=value
}

trait TRegistrationListener extends RegistrationListener{
  val target:TTarget
  override def  getListenerComponent():Target=target
}

