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
/*
 *  slim ouertani
 *  
 */
package net.dikka.charika.blueprint
package reflect

trait  ABuilder {
  val defaultActivation:Activation=Eager
  val defaultTimeout:Int=300000
  val defaultAvailability:Availability = Mandatory
}


