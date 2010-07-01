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

  
class PropsMetadataBuilder extends Function0[TPropsMetadata] {
  
  final protected [this] var _entries:List[TMapEntry]=_

 def withEntries(entries:List[TMapEntry])={
    this._entries=entries
    this
  }

  def withEntry(entry:TMapEntry)={
    this._entries::=entry
    this
  }

 def apply()={
    new PropsMetadata( _entries)
  }
}

