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

class BlueprintMetadataBuilder extends Function0[TBlueprintMetadata] {
    
    private [this] var _default:TDefault=_
    private [this] var _metadatas:List[TMetadata]=_


    def withDefault(default:TDefault)={
      _default=default
      this
    }
    def withMetaDatas( metaDatas:List[TMetadata]) ={
      _metadatas=metaDatas
      this
    }
    def withMetaData(metaData:TMetadata)={
      _metadatas::=metaData
      this
    }
    
    def apply()={
      BlueprintMetadata(_default,_metadatas)
    }
  }

