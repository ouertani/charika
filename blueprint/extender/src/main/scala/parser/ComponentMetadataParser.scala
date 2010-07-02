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
package parser

import builder._
import reflect._
import scala.xml.Node

  
  class ComponentMetadataParser  extends  Function2[Node,TDefault,TComponentMetadata] {
 
    override def  apply(node:Node,
                        default:TDefault) :TComponentMetadata = new ComponentMetadataBuilder(default)
    .withId(node <<< ID_ATTRIBUTE )
    .withActivation(node <<< ACTIVATION_ATTRIBUTE )
    .withDependsOns(node <<< DEPENDS_ON_ATTRIBUTE ) ()
  }
