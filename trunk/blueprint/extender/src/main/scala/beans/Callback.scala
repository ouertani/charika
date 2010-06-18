package net.dikka.charika.blueprint.extender.impl
package beans


case class Callback(initMethod:Option[String], destroyMethod:Option[String]){
  require(initMethod != null, "InitMethod must not be null!")
  require(destroyMethod != null, "DestroyMethod must not be null!")
}
