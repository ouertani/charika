/**
 * Copyright (c) 2010 DIKKA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Slim Ouertani   - initial API and implementation
 *
 */
package net.dikka.charika.blueprint.extender.impl


package object beans {

 // abstract class Component (id:String, activation :Activation=Eager, dependsOn:List[String])




  def xor3(x: Boolean, y: Boolean, z : Boolean): Boolean = (x || y || z ) && !(x && y) && !(x || z) && !(y || z) && ! (x && y && z)


  def xor(x: Boolean, y: Boolean): Boolean = (x || y) && !(x && y)

 
}
