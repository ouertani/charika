package net.dikka.charika.blueprint.extender.impl
package beans




case class Construction (clazz:Option[String], factoryMethod: Option[String], factoryRef:Option[String]){
  require(clazz != null, "Class must not be null!")
  require(factoryMethod != null, "FactoryMethod must not be null!")
  require(factoryRef != null, "FactoryRef must not be null!")

  /*
   The destroyMethod must not be set when the scope is prototype.
   The activation must not be set to eager if the bean also has prototype scope.
   The following combinations of arguments are valid, all other combinations are invalid:
   • className
   • className, factory-method
   • factory-ref, factory-method
   */
  if(clazz isDefined) {
    require((factoryRef  isEmpty), "Invalid combination" )
  }

  if(factoryMethod isDefined) {
    require(xor( factoryRef isDefined ,  clazz isDefined ) , "Invalid combination" )
  }
  require ((clazz isDefined ) || (factoryMethod isDefined) || (factoryRef isDefined ),"Invalid combination" )
}
