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
package net.dikka.charika.blueprint
package reflect.impl

import reflect._
import scala.collection.JavaConversions._

case class BeanMetadata(
 override val id :String ,
 override val activation:Activation,
 override val dependsOns:List[String],
  className:Option[String],
  initMethod:Option[String] ,
  destroyMethod:Option[String],
  beanArguments:Seq[TBeanArgument],
  beanProperties:Seq[TBeanProperty],
  factoryMethod:Option[String],
  factoryComponent:Option[TTarget],
  scope:Scope) extends ComponentMetadata(id , activation , dependsOns) with TBeanMetadata {

  override def  getClassName()=className
  override def  getInitMethod()=initMethod
  override def  getDestroyMethod()=destroyMethod
  override def  getArguments()=beanArguments
  override def  getProperties()=beanProperties
  override def  getFactoryMethod()=factoryMethod
  override def  getFactoryComponent()=factoryComponent getOrElse null
  override def  getScope()=scope.stringValue


}
