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


trait TValueMetadataBuilder {
  val builder:ValueMetadataBuilder
  class ValueMetadataBuilder  {
    final protected [this] var stringValue:String=_
    final protected [this] var tipe:String=_


    def withStringValue(stringValue:String)={
      this.stringValue=stringValue
      this
    }
    def withType(tipe:String)={
      this.tipe=tipe
      this
    }



    def build()={
      new ValueMetadata( stringValue,
                        tipe)
    }

  }
}