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

trait TRefMetadataBuilder{
  
  val refMetadataBuilder:RefMetadataBuilder = new RefMetadataBuilder()

  class RefMetadataBuilder extends Function0[TRefMetadata] {
    
    final protected [this] var _componentId:Option[String]=None

    def withcomponentId(componentId:String)={
      this._componentId=componentId
      this
    }

    def apply()={
      new RefMetadata(_componentId)
    }
  }
}