/*
 *  slim ouertani
 *  
 */
package net.dikka.charika.blueprint
package reflect

case class ABuilder (
  val defaultActivation:Activation=Eager,
  val defaultTimeout:Int=300000,
  val defaultAvailability:Availability = Mandatory
)

