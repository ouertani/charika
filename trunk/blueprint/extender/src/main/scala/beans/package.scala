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
package net.dikka.charika.blueprint.extender.impl


package object beans {
  
  def xor(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x || z) && !(y || z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)

 
}
