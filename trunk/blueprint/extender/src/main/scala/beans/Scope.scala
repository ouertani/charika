
package net.dikka.charika.blueprint.extender.impl
package beans


sealed trait Scope
case object Singleton extends Scope
case object Prototype extends Scope
