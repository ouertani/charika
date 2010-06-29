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

class ComponentMetadata(val id :String ,val activation:Activation ,val dependsOns:List[String]) extends TComponentMetadata {
  override def getId()=id
  override def getActivation()=activation.intValue
  override def getDependsOn()=dependsOns
}
