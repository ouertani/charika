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

import org.osgi.service.blueprint.reflect.RefMetadata

trait TRefMetadata extends RefMetadata with TTarget with TNonNullMetadata

sealed class RefMetadata_(componentId:String) extends TRefMetadata {
  override def getComponentId()=componentId
}

class RefMetadataBuilder  {
  private [this] var _componentId:String=_
  def withcomponentId(componentId:String){
    this._componentId=componentId
    this
  }



  def build()={
    new RefMetadata_(_componentId)
  }
}
