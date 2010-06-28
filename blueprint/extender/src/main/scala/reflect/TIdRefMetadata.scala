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

import org.osgi.service.blueprint.reflect.IdRefMetadata

trait TIdRefMetadata extends IdRefMetadata with TNonNullMetadata


sealed class IdRefMetadata_(componentId:String) extends TIdRefMetadata {
  override def  getComponentId()=componentId
}


class IdRefMetadataBuilder   {
  private [this] var _componentId:String=_

  def withComponentId(componentId:String)={
    this._componentId=componentId
    this
  }

 def build()={
    new IdRefMetadata_(_componentId)
  }
}