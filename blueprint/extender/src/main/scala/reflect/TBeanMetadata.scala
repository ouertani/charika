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
package reflect

import org.osgi.service.blueprint.reflect.BeanMetadata



trait TBeanMetadata extends BeanMetadata with TTarget with TComponentMetadata {

  val className:Option[String]
  val initMethod:Option[String]
  val destroyMethod:Option[String]
  val beanArguments:Seq[TBeanArgument]
  val beanProperties:Seq[TBeanProperty]
  val factoryMethod:Option[String]
  val factoryComponent:Option[TTarget]
  val scope:Scope
}










  

