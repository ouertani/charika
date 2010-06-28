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



import org.osgi.service.blueprint.reflect.PropsMetadata
import scala.collection.JavaConversions._

trait TPropsMetadata extends PropsMetadata with TNonNullMetadata

sealed class PropsMetadata_( entries:List[TMapEntry]) extends TPropsMetadata {
  override def getEntries()= entries
}

class PropsMetadataBuilder  extends     TBuilder[TPropsMetadata]{
  private [this] var entries:List[TMapEntry]=_

 def withEntries(entries:List[TMapEntry])={
    this.entries=entries
    this
  }

  def withEntry(entry:TMapEntry)={
    this.entries=this.entries :+entry
    this
  }

  override def validate (){}


  override def apply()={
    new PropsMetadata_( entries)
  }
}

