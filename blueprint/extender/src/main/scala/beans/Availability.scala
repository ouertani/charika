package net.dikka.charika.blueprint.extender.impl
package beans

sealed trait Availability
case object Mandatory extends Availability
case object Optional extends Availability
