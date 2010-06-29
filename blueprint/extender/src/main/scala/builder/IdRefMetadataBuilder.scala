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
package builder
import reflect._
import reflect.impl._
class IdRefMetadataBuilder   {
  private [this] var _componentId:String=_

  def withComponentId(componentId:String)={
    this._componentId=componentId
    this
  }

 def build()={
    new IdRefMetadata(_componentId)
  }
}