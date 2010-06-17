
package net.dikka.charika.blueprint.extender.impl
package beans


sealed trait Activation { val   activation:Int  }
case object Lazy extends Activation {val activation=2 }
case object Eager extends Activation{ val activation=1}
