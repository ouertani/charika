package net.dikka.charika.blueprint.extender.impl
package beans

case class ConstructionParam( dependsOn:List[String], arguments :List[Argument],  propertys : List[Property]) {
  require(dependsOn != null, "DependsOn must not be null!")
  require(arguments != null, "arguments must not be null!")
  require(propertys != null, "propertys must not be null!")

  val t =arguments.map(_.index).partition(_.isDefined)

  if( t._1.size !=0) {
    /*
     * Either all arguments have a specified index or none have a specified index.
     *
     */
    require (t._2.size==0,"Either all arguments have a specified index or none have a specified index.")


    /*
     * If indexes are specified, they must be unique and run from 0..(n-1), where n is the number of arguments.
     */
    val l= arguments.map(_.index.get)
    require(l.filter(0>).isEmpty,"index must be >= 0")

    l.sortWith  (_ < _).foldLeft(-1) ((x,y)=> { require(y==x+1,"index run from 0..(n-1), where n is the number of arguments");y})

  }

}
