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

class BeanMetadata(
  id :String ,
  activation:Activation,
  dependsOns:List[String],
  className:Option[String],
  initMethod:Option[String] ,
  destroyMethod:Option[String],
  beanArguments:List[TBeanArgument],
  beanProperties:List[TBeanProperty],
  factoryMethod:Option[String],
  factoryComponent:TTarget,
  scope:Scope) extends ComponentMetadata(id , activation , dependsOns) with TBeanMetadata {

  override def  getClassName()=className
  override def  getInitMethod()=initMethod
  override def  getDestroyMethod()=destroyMethod
  override def  getArguments()=beanArguments
  override def  getProperties()=beanProperties
  override def  getFactoryMethod()=factoryMethod
  override def  getFactoryComponent()=factoryComponent
  override def  getScope()=scope.stringValue


}
